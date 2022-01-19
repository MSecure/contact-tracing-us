package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import org.pathcheck.covidsafepaths.BuildConfig;

public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    public final CacheKeyFactory mCacheKeyFactory;
    public final Producer<EncodedImage> mInputProducer;
    public final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

    public static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final boolean mIsMemoryCacheEnabled;
        public final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
        public final CacheKey mRequestedCacheKey;

        public EncodedMemoryCacheConsumer(Consumer<EncodedImage> consumer, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z) {
            super(consumer);
            this.mMemoryCache = memoryCache;
            this.mRequestedCacheKey = cacheKey;
            this.mIsMemoryCacheEnabled = z;
        }

        /* JADX INFO: finally extract failed */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            try {
                FrescoSystrace.isTracing();
                if (!BaseConsumer.isNotLast(i) && encodedImage != null) {
                    if (!((i & 10) != 0)) {
                        encodedImage.parseMetaDataIfNeeded();
                        if (encodedImage.mImageFormat != ImageFormat.UNKNOWN) {
                            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
                            if (byteBufferRef != null) {
                                CloseableReference<PooledByteBuffer> closeableReference = null;
                                try {
                                    if (this.mIsMemoryCacheEnabled) {
                                        closeableReference = this.mMemoryCache.cache(this.mRequestedCacheKey, byteBufferRef);
                                    }
                                    if (closeableReference != null) {
                                        try {
                                            EncodedImage encodedImage2 = new EncodedImage(closeableReference);
                                            encodedImage2.copyMetaDataFrom(encodedImage);
                                            try {
                                                this.mConsumer.onProgressUpdate(1.0f);
                                                this.mConsumer.onNewResult(encodedImage2, i);
                                                FrescoSystrace.isTracing();
                                            } finally {
                                                EncodedImage.closeSafely(encodedImage2);
                                            }
                                        } finally {
                                            CloseableReference.closeSafely(closeableReference);
                                        }
                                    }
                                } finally {
                                    CloseableReference.closeSafely(byteBufferRef);
                                }
                            }
                            this.mConsumer.onNewResult(encodedImage, i);
                            FrescoSystrace.isTracing();
                        }
                    }
                }
                this.mConsumer.onNewResult(encodedImage, i);
                FrescoSystrace.isTracing();
            } catch (Throwable th) {
                FrescoSystrace.isTracing();
                throw th;
            }
        }
    }

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        try {
            FrescoSystrace.isTracing();
            String id = producerContext.getId();
            RequestListener listener = producerContext.getListener();
            listener.onProducerStart(id, "EncodedMemoryCacheProducer");
            CacheKey encodedCacheKey = ((DefaultCacheKeyFactory) this.mCacheKeyFactory).getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            CloseableReference<PooledByteBuffer> closeableReference = this.mMemoryCache.get(encodedCacheKey);
            Map<String, String> map = null;
            if (closeableReference != null) {
                try {
                    EncodedImage encodedImage = new EncodedImage(closeableReference);
                    try {
                        if (listener.requiresExtraMap(id)) {
                            map = ImmutableMap.of("cached_value_found", BuildConfig.DISPLAY_CALL_EMERGENCY_SERVICES);
                        }
                        listener.onProducerFinishWithSuccess(id, "EncodedMemoryCacheProducer", map);
                        listener.onUltimateProducerReached(id, "EncodedMemoryCacheProducer", true);
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(encodedImage, 1);
                        EncodedImage.closeSafely(encodedImage);
                        CloseableReference.closeSafely(closeableReference);
                        FrescoSystrace.isTracing();
                    } catch (Throwable th) {
                        EncodedImage.closeSafely(encodedImage);
                        throw th;
                    }
                } catch (Throwable th2) {
                    CloseableReference.closeSafely(closeableReference);
                    throw th2;
                }
            } else if (producerContext.getLowestPermittedRequestLevel().mValue >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.mValue) {
                listener.onProducerFinishWithSuccess(id, "EncodedMemoryCacheProducer", listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                listener.onUltimateProducerReached(id, "EncodedMemoryCacheProducer", false);
                consumer.onNewResult(null, 1);
                CloseableReference.closeSafely(closeableReference);
                FrescoSystrace.isTracing();
            } else {
                EncodedMemoryCacheConsumer encodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(consumer, this.mMemoryCache, encodedCacheKey, producerContext.getImageRequest().mIsMemoryCacheEnabled);
                if (listener.requiresExtraMap(id)) {
                    map = ImmutableMap.of("cached_value_found", "false");
                }
                listener.onProducerFinishWithSuccess(id, "EncodedMemoryCacheProducer", map);
                this.mInputProducer.produceResults(encodedMemoryCacheConsumer, producerContext);
                CloseableReference.closeSafely(closeableReference);
                FrescoSystrace.isTracing();
            }
        } catch (Throwable th3) {
            FrescoSystrace.isTracing();
            throw th3;
        }
    }
}
