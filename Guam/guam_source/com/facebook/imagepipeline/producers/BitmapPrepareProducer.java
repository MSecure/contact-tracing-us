package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public class BitmapPrepareProducer implements Producer<CloseableReference<CloseableImage>> {
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;
    public final int mMaxBitmapSizeBytes;
    public final int mMinBitmapSizeBytes;
    public final boolean mPreparePrefetch;

    public static class BitmapPrepareConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final int mMaxBitmapSizeBytes;
        public final int mMinBitmapSizeBytes;

        public BitmapPrepareConsumer(Consumer<CloseableReference<CloseableImage>> consumer, int i, int i2) {
            super(consumer);
            this.mMinBitmapSizeBytes = i;
            this.mMaxBitmapSizeBytes = i2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            CloseableImage closeableImage;
            Bitmap bitmap;
            int height;
            CloseableReference closeableReference = (CloseableReference) obj;
            if (closeableReference != null && closeableReference.isValid() && (closeableImage = (CloseableImage) closeableReference.get()) != null && !closeableImage.isClosed() && (closeableImage instanceof CloseableStaticBitmap) && (bitmap = ((CloseableStaticBitmap) closeableImage).mBitmap) != null && (height = bitmap.getHeight() * bitmap.getRowBytes()) >= this.mMinBitmapSizeBytes && height <= this.mMaxBitmapSizeBytes) {
                bitmap.prepareToDraw();
            }
            this.mConsumer.onNewResult(closeableReference, i);
        }
    }

    public BitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> producer, int i, int i2, boolean z) {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i <= i2);
        if (producer != null) {
            this.mInputProducer = producer;
            this.mMinBitmapSizeBytes = i;
            this.mMaxBitmapSizeBytes = i2;
            this.mPreparePrefetch = z;
            return;
        }
        throw null;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        if (!producerContext.isPrefetch() || this.mPreparePrefetch) {
            this.mInputProducer.produceResults(new BitmapPrepareConsumer(consumer, this.mMinBitmapSizeBytes, this.mMaxBitmapSizeBytes), producerContext);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }
}
