package com.facebook.imagepipeline.producers;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    public final Executor mExecutor;
    public final ImageTranscoderFactory mImageTranscoderFactory;
    public final Producer<EncodedImage> mInputProducer;
    public final boolean mIsResizingEnabled;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ImageTranscoderFactory mImageTranscoderFactory;
        public boolean mIsCancelled = false;
        public final boolean mIsResizingEnabled;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;

        public TransformingConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer);
            this.mProducerContext = producerContext;
            Boolean bool = producerContext.getImageRequest().mResizingAllowedOverride;
            this.mIsResizingEnabled = bool != null ? bool.booleanValue() : z;
            this.mImageTranscoderFactory = imageTranscoderFactory;
            this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, new JobScheduler.JobRunnable(ResizeAndRotateProducer.this) {
                /* class com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.AnonymousClass1 */

                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, int i) {
                    TransformingConsumer transformingConsumer = TransformingConsumer.this;
                    ImageTranscoderFactory imageTranscoderFactory = transformingConsumer.mImageTranscoderFactory;
                    encodedImage.parseMetaDataIfNeeded();
                    ImageTranscoder createImageTranscoder = imageTranscoderFactory.createImageTranscoder(encodedImage.mImageFormat, TransformingConsumer.this.mIsResizingEnabled);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(createImageTranscoder);
                    ImageTranscoder imageTranscoder = createImageTranscoder;
                    transformingConsumer.mProducerContext.getListener().onProducerStart(transformingConsumer.mProducerContext.getId(), "ResizeAndRotateProducer");
                    ImageRequest imageRequest = transformingConsumer.mProducerContext.getImageRequest();
                    PooledByteBufferOutputStream newOutputStream = ResizeAndRotateProducer.this.mPooledByteBufferFactory.newOutputStream();
                    try {
                        ImageTranscodeResult transcode = imageTranscoder.transcode(encodedImage, newOutputStream, imageRequest.mRotationOptions, imageRequest.mResizeOptions, null, 85);
                        if (transcode.mTranscodeStatus != 2) {
                            Map<String, String> extraMap = transformingConsumer.getExtraMap(encodedImage, imageRequest.mResizeOptions, transcode, imageTranscoder.getIdentifier());
                            CloseableReference of = CloseableReference.of(((MemoryPooledByteBufferOutputStream) newOutputStream).toByteBuffer());
                            try {
                                EncodedImage encodedImage2 = new EncodedImage(of);
                                encodedImage2.mImageFormat = DefaultImageFormats.JPEG;
                                try {
                                    encodedImage2.parseMetaData();
                                    transformingConsumer.mProducerContext.getListener().onProducerFinishWithSuccess(transformingConsumer.mProducerContext.getId(), "ResizeAndRotateProducer", extraMap);
                                    if (transcode.mTranscodeStatus != 1) {
                                        i |= 16;
                                    }
                                    transformingConsumer.mConsumer.onNewResult(encodedImage2, i);
                                    newOutputStream.close();
                                } finally {
                                    EncodedImage.closeSafely(encodedImage2);
                                }
                            } finally {
                                if (of != null) {
                                    of.close();
                                }
                            }
                        } else {
                            throw new RuntimeException("Error while transcoding the image");
                        }
                    } catch (Exception e) {
                        transformingConsumer.mProducerContext.getListener().onProducerFinishWithFailure(transformingConsumer.mProducerContext.getId(), "ResizeAndRotateProducer", e, null);
                        if (BaseConsumer.isLast(i)) {
                            transformingConsumer.mConsumer.onFailure(e);
                        }
                    } catch (Throwable th) {
                        newOutputStream.close();
                        throw th;
                    }
                }
            }, 100);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(ResizeAndRotateProducer.this, consumer) {
                /* class com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.AnonymousClass2 */
                public final /* synthetic */ Consumer val$consumer;

                {
                    this.val$consumer = r3;
                }

                @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    TransformingConsumer.this.mJobScheduler.clearJob();
                    TransformingConsumer.this.mIsCancelled = true;
                    this.val$consumer.onCancellation();
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }
            });
        }

        public final Map<String, String> getExtraMap(EncodedImage encodedImage, ResizeOptions resizeOptions, ImageTranscodeResult imageTranscodeResult, String str) {
            String str2;
            long j;
            if (!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            encodedImage.parseMetaDataIfNeeded();
            sb.append(encodedImage.mWidth);
            sb.append("x");
            encodedImage.parseMetaDataIfNeeded();
            sb.append(encodedImage.mHeight);
            String sb2 = sb.toString();
            if (resizeOptions != null) {
                str2 = resizeOptions.width + "x" + resizeOptions.height;
            } else {
                str2 = "Unspecified";
            }
            HashMap hashMap = new HashMap();
            encodedImage.parseMetaDataIfNeeded();
            hashMap.put("Image format", String.valueOf(encodedImage.mImageFormat));
            hashMap.put("Original size", sb2);
            hashMap.put("Requested size", str2);
            JobScheduler jobScheduler = this.mJobScheduler;
            synchronized (jobScheduler) {
                j = jobScheduler.mJobStartTime - jobScheduler.mJobSubmitTime;
            }
            hashMap.put("queueTime", String.valueOf(j));
            hashMap.put("Transcoder id", str);
            hashMap.put("Transcoding result", String.valueOf(imageTranscodeResult));
            return new ImmutableMap(hashMap);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0077, code lost:
            if (r8 != false) goto L_0x0079;
         */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            boolean z;
            boolean z2;
            EncodedImage encodedImage = (EncodedImage) obj;
            TriState triState = TriState.YES;
            TriState triState2 = TriState.UNSET;
            if (!this.mIsCancelled) {
                boolean isLast = BaseConsumer.isLast(i);
                boolean z3 = true;
                if (encodedImage != null) {
                    encodedImage.parseMetaDataIfNeeded();
                    ImageFormat imageFormat = encodedImage.mImageFormat;
                    ImageRequest imageRequest = this.mProducerContext.getImageRequest();
                    ImageTranscoder createImageTranscoder = this.mImageTranscoderFactory.createImageTranscoder(imageFormat, this.mIsResizingEnabled);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(createImageTranscoder);
                    TriState triState3 = TriState.NO;
                    encodedImage.parseMetaDataIfNeeded();
                    if (encodedImage.mImageFormat == ImageFormat.UNKNOWN) {
                        triState3 = triState2;
                    } else {
                        encodedImage.parseMetaDataIfNeeded();
                        if (createImageTranscoder.canTranscode(encodedImage.mImageFormat)) {
                            RotationOptions rotationOptions = imageRequest.mRotationOptions;
                            if (!rotationOptions.mDeferUntilRendered) {
                                if (JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage) == 0) {
                                    if (!rotationOptions.rotationEnabled() || rotationOptions.mDeferUntilRendered) {
                                        encodedImage.mExifOrientation = 0;
                                        z2 = false;
                                    } else {
                                        ImmutableList<Integer> immutableList = JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS;
                                        encodedImage.parseMetaDataIfNeeded();
                                        z2 = immutableList.contains(Integer.valueOf(encodedImage.mExifOrientation));
                                    }
                                }
                                z = true;
                                if (!z && !createImageTranscoder.canResize(encodedImage, imageRequest.mRotationOptions, imageRequest.mResizeOptions)) {
                                    z3 = false;
                                }
                                if (z3) {
                                    triState3 = triState;
                                }
                            }
                            z = false;
                            z3 = false;
                            if (z3) {
                            }
                        }
                    }
                    if (!isLast && triState3 == triState2) {
                        return;
                    }
                    if (triState3 != triState) {
                        if (imageFormat != DefaultImageFormats.JPEG && imageFormat != DefaultImageFormats.HEIF) {
                            RotationOptions rotationOptions2 = this.mProducerContext.getImageRequest().mRotationOptions;
                            if (!rotationOptions2.useImageMetadata() && rotationOptions2.rotationEnabled()) {
                                int forcedAngle = rotationOptions2.getForcedAngle();
                                EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
                                CloseableReference.closeSafely(encodedImage.mPooledByteBufferRef);
                                if (cloneOrNull != null) {
                                    cloneOrNull.mRotationAngle = forcedAngle;
                                }
                                encodedImage = cloneOrNull;
                            }
                        } else if (!(this.mProducerContext.getImageRequest().mRotationOptions.mDeferUntilRendered || encodedImage.getRotationAngle() == 0 || encodedImage.getRotationAngle() == -1)) {
                            EncodedImage cloneOrNull2 = EncodedImage.cloneOrNull(encodedImage);
                            CloseableReference.closeSafely(encodedImage.mPooledByteBufferRef);
                            if (cloneOrNull2 != null) {
                                cloneOrNull2.mRotationAngle = 0;
                            }
                            encodedImage = cloneOrNull2;
                        }
                        this.mConsumer.onNewResult(encodedImage, i);
                    } else if (this.mJobScheduler.updateJob(encodedImage, i)) {
                        if (isLast || this.mProducerContext.isIntermediateResultExpected()) {
                            this.mJobScheduler.scheduleJob();
                        }
                    }
                } else if (isLast) {
                    this.mConsumer.onNewResult(null, 1);
                }
            }
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
        if (executor != null) {
            this.mExecutor = executor;
            if (pooledByteBufferFactory != null) {
                this.mPooledByteBufferFactory = pooledByteBufferFactory;
                if (producer != null) {
                    this.mInputProducer = producer;
                    if (imageTranscoderFactory != null) {
                        this.mImageTranscoderFactory = imageTranscoderFactory;
                        this.mIsResizingEnabled = z;
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new TransformingConsumer(consumer, producerContext, this.mIsResizingEnabled, this.mImageTranscoderFactory), producerContext);
    }
}
