package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class DiskCacheReadProducer implements Producer<EncodedImage> {
    public final CacheKeyFactory mCacheKeyFactory;
    public final BufferedDiskCache mDefaultBufferedDiskCache;
    public final Producer<EncodedImage> mInputProducer;
    public final BufferedDiskCache mSmallImageBufferedDiskCache;

    public DiskCacheReadProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public static Map<String, String> getExtraMap(RequestListener requestListener, String str, boolean z, int i) {
        if (!requestListener.requiresExtraMap(str)) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z));
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer<EncodedImage> consumer, final ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        boolean z = true;
        if (imageRequest.mIsDiskCacheEnabled) {
            producerContext.getListener().onProducerStart(producerContext.getId(), "DiskCacheProducer");
            CacheKey encodedCacheKey = ((DefaultCacheKeyFactory) this.mCacheKeyFactory).getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
            if (imageRequest.mCacheChoice != ImageRequest.CacheChoice.SMALL) {
                z = false;
            }
            BufferedDiskCache bufferedDiskCache = z ? this.mSmallImageBufferedDiskCache : this.mDefaultBufferedDiskCache;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Task<EncodedImage> task = bufferedDiskCache.get(encodedCacheKey, atomicBoolean);
            final String id = producerContext.getId();
            final RequestListener listener = producerContext.getListener();
            task.continueWith(new Continuation<EncodedImage, Void>() {
                /* class com.facebook.imagepipeline.producers.DiskCacheReadProducer.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
                @Override // bolts.Continuation
                public Void then(Task<EncodedImage> task) throws Exception {
                    boolean z;
                    TResult tresult;
                    synchronized (task.lock) {
                        z = task.cancelled;
                    }
                    if (z || (task.isFaulted() && (task.getError() instanceof CancellationException))) {
                        listener.onProducerFinishWithCancellation(id, "DiskCacheProducer", null);
                        consumer.onCancellation();
                    } else if (task.isFaulted()) {
                        listener.onProducerFinishWithFailure(id, "DiskCacheProducer", task.getError(), null);
                        DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                    } else {
                        synchronized (task.lock) {
                            tresult = task.result;
                        }
                        TResult tresult2 = tresult;
                        if (tresult2 != null) {
                            RequestListener requestListener = listener;
                            String str = id;
                            requestListener.onProducerFinishWithSuccess(str, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(requestListener, str, true, tresult2.getSize()));
                            listener.onUltimateProducerReached(id, "DiskCacheProducer", true);
                            consumer.onProgressUpdate(1.0f);
                            consumer.onNewResult(tresult2, 1);
                            CloseableReference.closeSafely(tresult2.mPooledByteBufferRef);
                        } else {
                            RequestListener requestListener2 = listener;
                            String str2 = id;
                            requestListener2.onProducerFinishWithSuccess(str2, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(requestListener2, str2, false, 0));
                            DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                        }
                    }
                    return null;
                }
            });
            producerContext.addCallbacks(new BaseProducerContextCallbacks(this) {
                /* class com.facebook.imagepipeline.producers.DiskCacheReadProducer.AnonymousClass2 */

                @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    atomicBoolean.set(true);
                }
            });
        } else if (producerContext.getLowestPermittedRequestLevel().mValue >= ImageRequest.RequestLevel.DISK_CACHE.mValue) {
            consumer.onNewResult(null, 1);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }
}
