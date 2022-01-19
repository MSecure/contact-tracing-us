package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public abstract class LocalFetchProducer implements Producer<EncodedImage> {
    public final Executor mExecutor;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public EncodedImage getByteBufferBackedEncodedImage(InputStream inputStream, int i) throws IOException {
        CloseableReference closeableReference;
        if (i <= 0) {
            try {
                closeableReference = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream));
            } catch (Throwable th) {
                Closeables.closeQuietly(inputStream);
                CloseableReference.closeSafely(null);
                throw th;
            }
        } else {
            closeableReference = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream, i));
        }
        EncodedImage encodedImage = new EncodedImage(closeableReference);
        Closeables.closeQuietly(inputStream);
        if (closeableReference != null) {
            closeableReference.close();
        }
        return encodedImage;
    }

    public abstract EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException;

    public abstract String getProducerName();

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        final RequestListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final AnonymousClass1 r9 = new StatefulProducerRunnable<EncodedImage>(consumer, getProducerName(), listener, id) {
            /* class com.facebook.imagepipeline.producers.LocalFetchProducer.AnonymousClass1 */

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public void disposeResult(Object obj) {
                EncodedImage.closeSafely((EncodedImage) obj);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Object getResult() throws Exception {
                EncodedImage encodedImage = LocalFetchProducer.this.getEncodedImage(imageRequest);
                if (encodedImage == null) {
                    listener.onUltimateProducerReached(id, LocalFetchProducer.this.getProducerName(), false);
                    return null;
                }
                encodedImage.parseMetaData();
                listener.onUltimateProducerReached(id, LocalFetchProducer.this.getProducerName(), true);
                return encodedImage;
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks(this) {
            /* class com.facebook.imagepipeline.producers.LocalFetchProducer.AnonymousClass2 */

            @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                r9.cancel();
            }
        });
        this.mExecutor.execute(r9);
    }
}
