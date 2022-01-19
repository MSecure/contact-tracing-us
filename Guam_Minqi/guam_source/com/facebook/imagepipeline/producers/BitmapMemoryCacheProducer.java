package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import org.pathcheck.covidsafepaths.BuildConfig;

public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public final CacheKeyFactory mCacheKeyFactory;
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;
    public final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public String getProducerName() {
        return "BitmapMemoryCacheProducer";
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        try {
            FrescoSystrace.isTracing();
            RequestListener listener = producerContext.getListener();
            String id = producerContext.getId();
            listener.onProducerStart(id, getProducerName());
            CacheKey bitmapCacheKey = ((DefaultCacheKeyFactory) this.mCacheKeyFactory).getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            CloseableReference<CloseableImage> closeableReference = this.mMemoryCache.get(bitmapCacheKey);
            Map<String, String> map = null;
            if (closeableReference != null) {
                boolean z = ((ImmutableQualityInfo) ((CloseableStaticBitmap) closeableReference.get()).mQualityInfo).mIsOfFullQuality;
                if (z) {
                    listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", BuildConfig.DISPLAY_CALL_EMERGENCY_SERVICES) : null);
                    listener.onUltimateProducerReached(id, getProducerName(), true);
                    consumer.onProgressUpdate(1.0f);
                }
                consumer.onNewResult(closeableReference, z ? 1 : 0);
                closeableReference.close();
                if (z) {
                    FrescoSystrace.isTracing();
                    return;
                }
            }
            if (producerContext.getLowestPermittedRequestLevel().mValue >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.mValue) {
                listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                listener.onUltimateProducerReached(id, getProducerName(), false);
                consumer.onNewResult(null, 1);
                FrescoSystrace.isTracing();
                return;
            }
            Consumer<CloseableReference<CloseableImage>> wrapConsumer = wrapConsumer(consumer, bitmapCacheKey, producerContext.getImageRequest().mIsMemoryCacheEnabled);
            String producerName = getProducerName();
            if (listener.requiresExtraMap(id)) {
                map = ImmutableMap.of("cached_value_found", "false");
            }
            listener.onProducerFinishWithSuccess(id, producerName, map);
            FrescoSystrace.isTracing();
            this.mInputProducer.produceResults(wrapConsumer, producerContext);
            FrescoSystrace.isTracing();
            FrescoSystrace.isTracing();
        } catch (Throwable th) {
            FrescoSystrace.isTracing();
            throw th;
        }
    }

    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, final CacheKey cacheKey, final boolean z) {
        return new DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>(consumer) {
            /* class com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.AnonymousClass1 */

            /* JADX INFO: finally extract failed */
            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(Object obj, int i) {
                CloseableReference<CloseableImage> closeableReference;
                CloseableReference closeableReference2 = (CloseableReference) obj;
                try {
                    FrescoSystrace.isTracing();
                    boolean isLast = BaseConsumer.isLast(i);
                    CloseableReference closeableReference3 = null;
                    if (closeableReference2 == null) {
                        if (isLast) {
                            this.mConsumer.onNewResult(null, i);
                        }
                    } else if (((CloseableImage) closeableReference2.get()) == null) {
                        throw null;
                    } else if (BaseConsumer.statusHasFlag(i, 8)) {
                        this.mConsumer.onNewResult(closeableReference2, i);
                    } else {
                        if (!isLast && (closeableReference = BitmapMemoryCacheProducer.this.mMemoryCache.get(cacheKey)) != null) {
                            try {
                                QualityInfo qualityInfo = ((CloseableStaticBitmap) ((CloseableImage) closeableReference2.get())).mQualityInfo;
                                QualityInfo qualityInfo2 = ((CloseableStaticBitmap) closeableReference.get()).mQualityInfo;
                                if (((ImmutableQualityInfo) qualityInfo2).mIsOfFullQuality || ((ImmutableQualityInfo) qualityInfo2).mQuality >= ((ImmutableQualityInfo) qualityInfo).mQuality) {
                                    this.mConsumer.onNewResult(closeableReference, i);
                                    CloseableReference.closeSafely(closeableReference);
                                }
                            } finally {
                                CloseableReference.closeSafely(closeableReference);
                            }
                        }
                        if (z) {
                            closeableReference3 = BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference2);
                        }
                        if (isLast) {
                            try {
                                this.mConsumer.onProgressUpdate(1.0f);
                            } catch (Throwable th) {
                                CloseableReference.closeSafely(closeableReference3);
                                throw th;
                            }
                        }
                        Consumer<O> consumer = this.mConsumer;
                        if (closeableReference3 != null) {
                            closeableReference2 = closeableReference3;
                        }
                        consumer.onNewResult(closeableReference2, i);
                        CloseableReference.closeSafely(closeableReference3);
                    }
                    FrescoSystrace.isTracing();
                } catch (Throwable th2) {
                    FrescoSystrace.isTracing();
                    throw th2;
                }
            }
        };
    }
}
