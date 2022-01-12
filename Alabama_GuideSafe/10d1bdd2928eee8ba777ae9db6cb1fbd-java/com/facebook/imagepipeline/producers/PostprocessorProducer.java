package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;

public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    public final PlatformBitmapFactory mBitmapFactory;
    public final Executor mExecutor;
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;

    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public boolean mIsClosed;
        public boolean mIsDirty = false;
        public boolean mIsPostProcessingRunning = false;
        public final RequestListener mListener;
        public final Postprocessor mPostprocessor;
        public final String mRequestId;
        public CloseableReference<CloseableImage> mSourceImageRef = null;
        public int mStatus = 0;

        public PostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, RequestListener requestListener, String str, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.mListener = requestListener;
            this.mRequestId = str;
            this.mPostprocessor = postprocessor;
            producerContext.addCallbacks(new BaseProducerContextCallbacks(PostprocessorProducer.this) {
                /* class com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.AnonymousClass1 */

                @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    PostprocessorConsumer postprocessorConsumer = PostprocessorConsumer.this;
                    if (postprocessorConsumer.close()) {
                        postprocessorConsumer.mConsumer.onCancellation();
                    }
                }
            });
        }

        public static void access$600(PostprocessorConsumer postprocessorConsumer, CloseableReference closeableReference, int i) {
            if (postprocessorConsumer != null) {
                AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(CloseableReference.isValid(closeableReference));
                if (!(((CloseableImage) closeableReference.get()) instanceof CloseableStaticBitmap)) {
                    postprocessorConsumer.maybeNotifyOnNewResult(closeableReference, i);
                    return;
                }
                postprocessorConsumer.mListener.onProducerStart(postprocessorConsumer.mRequestId, "PostprocessorProducer");
                try {
                    CloseableReference<CloseableImage> postprocessInternal = postprocessorConsumer.postprocessInternal((CloseableImage) closeableReference.get());
                    try {
                        postprocessorConsumer.mListener.onProducerFinishWithSuccess(postprocessorConsumer.mRequestId, "PostprocessorProducer", postprocessorConsumer.getExtraMap(postprocessorConsumer.mListener, postprocessorConsumer.mRequestId, postprocessorConsumer.mPostprocessor));
                        postprocessorConsumer.maybeNotifyOnNewResult(postprocessInternal, i);
                    } finally {
                        if (postprocessInternal != null) {
                            postprocessInternal.close();
                        }
                    }
                } catch (Exception e) {
                    postprocessorConsumer.mListener.onProducerFinishWithFailure(postprocessorConsumer.mRequestId, "PostprocessorProducer", e, postprocessorConsumer.getExtraMap(postprocessorConsumer.mListener, postprocessorConsumer.mRequestId, postprocessorConsumer.mPostprocessor));
                    if (postprocessorConsumer.close()) {
                        postprocessorConsumer.mConsumer.onFailure(e);
                    }
                }
            } else {
                throw null;
            }
        }

        public final boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }

        public final Map<String, String> getExtraMap(RequestListener requestListener, String str, Postprocessor postprocessor) {
            if (!requestListener.requiresExtraMap(str)) {
                return null;
            }
            return ImmutableMap.of("Postprocessor", postprocessor.getName());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
            if (r1 != false) goto L_0x0010;
         */
        public final void maybeNotifyOnNewResult(CloseableReference<CloseableImage> closeableReference, int i) {
            boolean isLast = BaseConsumer.isLast(i);
            if (!isLast) {
                synchronized (this) {
                    boolean z = this.mIsClosed;
                }
            }
            if (!isLast || !close()) {
                return;
            }
            this.mConsumer.onNewResult(closeableReference, i);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.DelegatingConsumer
        public void onCancellationImpl() {
            if (close()) {
                this.mConsumer.onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.DelegatingConsumer
        public void onFailureImpl(Throwable th) {
            if (close()) {
                this.mConsumer.onFailure(th);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
            com.facebook.common.references.CloseableReference.closeSafely(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            if (r2 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
            r1.this$0.mExecutor.execute(new com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.AnonymousClass2(r1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (CloseableReference.isValid(closeableReference)) {
                synchronized (this) {
                    if (!this.mIsClosed) {
                        CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                        this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                        this.mStatus = i;
                        this.mIsDirty = true;
                        boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                    }
                }
            } else if (BaseConsumer.isLast(i)) {
                maybeNotifyOnNewResult(null, i);
            }
        }

        public final CloseableReference<CloseableImage> postprocessInternal(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> process = this.mPostprocessor.process(closeableStaticBitmap.mBitmap, PostprocessorProducer.this.mBitmapFactory);
            try {
                CloseableReference<CloseableImage> of = CloseableReference.of(new CloseableStaticBitmap(process, ((CloseableStaticBitmap) closeableImage).mQualityInfo, closeableStaticBitmap.mRotationAngle, closeableStaticBitmap.mExifOrientation));
                if (process != null) {
                    process.close();
                }
                return of;
            } catch (Throwable th) {
                CloseableReference.closeSafely(process);
                throw th;
            }
        }

        public final synchronized boolean setRunningIfDirtyAndNotRunning() {
            if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                return false;
            }
            this.mIsPostProcessingRunning = true;
            return true;
        }
    }

    public class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        public boolean mIsClosed = false;
        public CloseableReference<CloseableImage> mSourceImageRef = null;

        public RepeatedPostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext, AnonymousClass1 r5) {
            super(postprocessorConsumer);
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new BaseProducerContextCallbacks(postprocessorProducer) {
                /* class com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.AnonymousClass1 */

                @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (RepeatedPostprocessorConsumer.this.close()) {
                        RepeatedPostprocessorConsumer.this.mConsumer.onCancellation();
                    }
                }
            });
        }

        public final boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.DelegatingConsumer
        public void onCancellationImpl() {
            if (close()) {
                this.mConsumer.onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.DelegatingConsumer
        public void onFailureImpl(Throwable th) {
            if (close()) {
                this.mConsumer.onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!BaseConsumer.isNotLast(i)) {
                synchronized (this) {
                    if (!this.mIsClosed) {
                        CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                        this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                        CloseableReference.closeSafely(closeableReference2);
                    }
                }
                synchronized (this) {
                    if (!this.mIsClosed) {
                        CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mSourceImageRef);
                        try {
                            this.mConsumer.onNewResult(cloneOrNull, 0);
                        } finally {
                            CloseableReference.closeSafely(cloneOrNull);
                        }
                    }
                }
            }
        }
    }

    public class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public SingleUsePostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, AnonymousClass1 r3) {
            super(postprocessorConsumer);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!BaseConsumer.isNotLast(i)) {
                this.mConsumer.onNewResult(closeableReference, i);
            }
        }
    }

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        if (producer != null) {
            this.mInputProducer = producer;
            this.mBitmapFactory = platformBitmapFactory;
            if (executor != null) {
                this.mExecutor = executor;
                return;
            }
            throw null;
        }
        throw null;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<CloseableReference<CloseableImage>> consumer2;
        RequestListener listener = producerContext.getListener();
        Postprocessor postprocessor = producerContext.getImageRequest().mPostprocessor;
        PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(consumer, listener, producerContext.getId(), postprocessor, producerContext);
        if (postprocessor instanceof RepeatedPostprocessor) {
            consumer2 = new RepeatedPostprocessorConsumer(this, postprocessorConsumer, (RepeatedPostprocessor) postprocessor, producerContext, null);
        } else {
            consumer2 = new SingleUsePostprocessorConsumer(this, postprocessorConsumer, null);
        }
        this.mInputProducer.produceResults(consumer2, producerContext);
    }
}
