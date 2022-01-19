package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import java.util.Map;
import org.pathcheck.covidsafepaths.BuildConfig;

public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public final CacheKeyFactory mCacheKeyFactory;
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;
    public final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final CacheKey mCacheKey;
        public final boolean mIsMemoryCachedEnabled;
        public final boolean mIsRepeatedProcessor;
        public final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z2) {
            super(consumer);
            this.mCacheKey = cacheKey;
            this.mIsRepeatedProcessor = z;
            this.mMemoryCache = memoryCache;
            this.mIsMemoryCachedEnabled = z2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            CloseableReference closeableReference2 = null;
            if (closeableReference == null) {
                if (BaseConsumer.isLast(i)) {
                    this.mConsumer.onNewResult(closeableReference2, i);
                }
            } else if (!BaseConsumer.isNotLast(i) || this.mIsRepeatedProcessor) {
                if (this.mIsMemoryCachedEnabled) {
                    closeableReference2 = this.mMemoryCache.cache(this.mCacheKey, closeableReference);
                }
                try {
                    this.mConsumer.onProgressUpdate(1.0f);
                    Consumer<O> consumer = this.mConsumer;
                    if (closeableReference2 != null) {
                        closeableReference = closeableReference2;
                    }
                    consumer.onNewResult(closeableReference, i);
                } finally {
                    CloseableReference.closeSafely(closeableReference2);
                }
            }
        }
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        RequestListener listener = producerContext.getListener();
        String id = producerContext.getId();
        ImageRequest imageRequest = producerContext.getImageRequest();
        Object callerContext = producerContext.getCallerContext();
        Postprocessor postprocessor = imageRequest.mPostprocessor;
        if (postprocessor == null || postprocessor.getPostprocessorCacheKey() == null) {
            this.mInputProducer.produceResults(consumer, producerContext);
            return;
        }
        listener.onProducerStart(id, "PostprocessedBitmapMemoryCacheProducer");
        CacheKey postprocessedBitmapCacheKey = ((DefaultCacheKeyFactory) this.mCacheKeyFactory).getPostprocessedBitmapCacheKey(imageRequest, callerContext);
        CloseableReference<CloseableImage> closeableReference = this.mMemoryCache.get(postprocessedBitmapCacheKey);
        Map<String, String> map = null;
        if (closeableReference != null) {
            if (listener.requiresExtraMap(id)) {
                map = ImmutableMap.of("cached_value_found", BuildConfig.DISPLAY_CALL_EMERGENCY_SERVICES);
            }
            listener.onProducerFinishWithSuccess(id, "PostprocessedBitmapMemoryCacheProducer", map);
            listener.onUltimateProducerReached(id, "PostprocessedBitmapMemoryCacheProducer", true);
            consumer.onProgressUpdate(1.0f);
            consumer.onNewResult(closeableReference, 1);
            closeableReference.close();
            return;
        }
        CachedPostprocessorConsumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(consumer, postprocessedBitmapCacheKey, postprocessor instanceof RepeatedPostprocessor, this.mMemoryCache, producerContext.getImageRequest().mIsMemoryCacheEnabled);
        if (listener.requiresExtraMap(id)) {
            map = ImmutableMap.of("cached_value_found", "false");
        }
        listener.onProducerFinishWithSuccess(id, "PostprocessedBitmapMemoryCacheProducer", map);
        this.mInputProducer.produceResults(cachedPostprocessorConsumer, producerContext);
    }
}
