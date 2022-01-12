package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    public final ByteArrayPool mByteArrayPool;
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public final boolean mDecodeCancellationEnabled;
    public final boolean mDownsampleEnabled;
    public final boolean mDownsampleEnabledForNetwork;
    public final Executor mExecutor;
    public final ImageDecoder mImageDecoder;
    public final Producer<EncodedImage> mInputProducer;
    public final int mMaxBitmapSize;
    public final ProgressiveJpegConfig mProgressiveJpegConfig;

    public class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        public LocalImagesProgressiveDecoder(DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i) {
            super(consumer, producerContext, z, i);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return encodedImage.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public QualityInfo getQualityInfo() {
            return new ImmutableQualityInfo(0, false, false);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            if (BaseConsumer.isNotLast(i)) {
                return false;
            }
            return this.mJobScheduler.updateJob(encodedImage, i);
        }
    }

    public class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {
        public int mLastScheduledScanNumber;
        public final ProgressiveJpegConfig mProgressiveJpegConfig;
        public final ProgressiveJpegParser mProgressiveJpegParser;

        public NetworkImagesProgressiveDecoder(DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z, int i) {
            super(consumer, producerContext, z, i);
            this.mProgressiveJpegParser = progressiveJpegParser;
            if (progressiveJpegConfig != null) {
                this.mProgressiveJpegConfig = progressiveJpegConfig;
                this.mLastScheduledScanNumber = 0;
                return;
            }
            throw null;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return this.mProgressiveJpegParser.mBestScanEndOffset;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public QualityInfo getQualityInfo() {
            return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.mBestScanNumber);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            boolean updateJob = this.mJobScheduler.updateJob(encodedImage, i);
            if ((BaseConsumer.isNotLast(i) || BaseConsumer.statusHasFlag(i, 8)) && !BaseConsumer.statusHasFlag(i, 4) && EncodedImage.isValid(encodedImage)) {
                encodedImage.parseMetaDataIfNeeded();
                if (encodedImage.mImageFormat == DefaultImageFormats.JPEG) {
                    if (!this.mProgressiveJpegParser.parseMoreData(encodedImage)) {
                        return false;
                    }
                    int i2 = this.mProgressiveJpegParser.mBestScanNumber;
                    if (i2 <= this.mLastScheduledScanNumber) {
                        return false;
                    }
                    if (i2 < this.mProgressiveJpegConfig.getNextScanNumberToDecode(this.mLastScheduledScanNumber) && !this.mProgressiveJpegParser.mEndMarkerRead) {
                        return false;
                    }
                    this.mLastScheduledScanNumber = i2;
                }
            }
            return updateJob;
        }
    }

    public abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        public final ImageDecodeOptions mImageDecodeOptions;
        public boolean mIsFinished = false;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;
        public final RequestListener mProducerListener;

        public ProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mProducerListener = producerContext.getListener();
            this.mImageDecodeOptions = producerContext.getImageRequest().mImageDecodeOptions;
            this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, new JobScheduler.JobRunnable(DecodeProducer.this, producerContext, i) {
                /* class com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.AnonymousClass1 */
                public final /* synthetic */ int val$maxBitmapSize;
                public final /* synthetic */ ProducerContext val$producerContext;

                {
                    this.val$producerContext = r3;
                    this.val$maxBitmapSize = r4;
                }

                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, int i) {
                    boolean z;
                    String str;
                    long j;
                    int i2;
                    QualityInfo qualityInfo;
                    CloseableImage closeableImage;
                    Exception e;
                    int i3 = i;
                    if (encodedImage != null) {
                        if (DecodeProducer.this.mDownsampleEnabled || !BaseConsumer.statusHasFlag(i3, 16)) {
                            ImageRequest imageRequest = this.val$producerContext.getImageRequest();
                            if (DecodeProducer.this.mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(imageRequest.mSourceUri)) {
                                encodedImage.mSampleSize = AppCompatDelegateImpl.ConfigurationImplApi17.determineSampleSize(imageRequest.mRotationOptions, imageRequest.mResizeOptions, encodedImage, this.val$maxBitmapSize);
                            }
                        }
                        ProgressiveDecoder progressiveDecoder = ProgressiveDecoder.this;
                        if (progressiveDecoder != null) {
                            encodedImage.parseMetaDataIfNeeded();
                            if (encodedImage.mImageFormat == DefaultImageFormats.JPEG || !BaseConsumer.isNotLast(i)) {
                                synchronized (progressiveDecoder) {
                                    z = progressiveDecoder.mIsFinished;
                                }
                                if (!z && EncodedImage.isValid(encodedImage)) {
                                    encodedImage.parseMetaDataIfNeeded();
                                    ImageFormat imageFormat = encodedImage.mImageFormat;
                                    String str2 = imageFormat != null ? imageFormat.mName : "unknown";
                                    StringBuilder sb = new StringBuilder();
                                    encodedImage.parseMetaDataIfNeeded();
                                    sb.append(encodedImage.mWidth);
                                    sb.append("x");
                                    encodedImage.parseMetaDataIfNeeded();
                                    sb.append(encodedImage.mHeight);
                                    String sb2 = sb.toString();
                                    String valueOf = String.valueOf(encodedImage.mSampleSize);
                                    boolean isLast = BaseConsumer.isLast(i);
                                    boolean z2 = isLast && !BaseConsumer.statusHasFlag(i3, 8);
                                    boolean statusHasFlag = BaseConsumer.statusHasFlag(i3, 4);
                                    ResizeOptions resizeOptions = progressiveDecoder.mProducerContext.getImageRequest().mResizeOptions;
                                    if (resizeOptions != null) {
                                        str = resizeOptions.width + "x" + resizeOptions.height;
                                    } else {
                                        str = "unknown";
                                    }
                                    try {
                                        JobScheduler jobScheduler = progressiveDecoder.mJobScheduler;
                                        synchronized (jobScheduler) {
                                            j = jobScheduler.mJobStartTime - jobScheduler.mJobSubmitTime;
                                        }
                                        String valueOf2 = String.valueOf(progressiveDecoder.mProducerContext.getImageRequest().mSourceUri);
                                        if (z2 || statusHasFlag) {
                                            i2 = encodedImage.getSize();
                                        } else {
                                            i2 = progressiveDecoder.getIntermediateImageEndOffset(encodedImage);
                                        }
                                        if (z2 || statusHasFlag) {
                                            qualityInfo = ImmutableQualityInfo.FULL_QUALITY;
                                        } else {
                                            qualityInfo = progressiveDecoder.getQualityInfo();
                                        }
                                        progressiveDecoder.mProducerListener.onProducerStart(progressiveDecoder.mProducerContext.getId(), "DecodeProducer");
                                        try {
                                            CloseableImage decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, i2, qualityInfo, progressiveDecoder.mImageDecodeOptions);
                                            try {
                                                if (encodedImage.mSampleSize != 1) {
                                                    i3 |= 16;
                                                }
                                                progressiveDecoder.mProducerListener.onProducerFinishWithSuccess(progressiveDecoder.mProducerContext.getId(), "DecodeProducer", progressiveDecoder.getExtraMap(decode, j, qualityInfo, isLast, str2, sb2, str, valueOf));
                                                CloseableReference of = CloseableReference.of(decode, DecodeProducer.this.mCloseableReferenceFactory.mLeakHandler);
                                                try {
                                                    progressiveDecoder.maybeFinish(BaseConsumer.isLast(i3));
                                                    progressiveDecoder.mConsumer.onNewResult(of, i3);
                                                } finally {
                                                    if (of != null) {
                                                        of.close();
                                                    }
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                closeableImage = decode;
                                                progressiveDecoder.mProducerListener.onProducerFinishWithFailure(progressiveDecoder.mProducerContext.getId(), "DecodeProducer", e, progressiveDecoder.getExtraMap(closeableImage, j, qualityInfo, isLast, str2, sb2, str, valueOf));
                                                progressiveDecoder.maybeFinish(true);
                                                progressiveDecoder.mConsumer.onFailure(e);
                                            }
                                        } catch (DecodeException e3) {
                                            EncodedImage encodedImage2 = e3.mEncodedImage;
                                            FLog.w("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e3.getMessage(), valueOf2, encodedImage2.getFirstBytesAsHexString(10), Integer.valueOf(encodedImage2.getSize()));
                                            throw e3;
                                        } catch (Exception e4) {
                                            e = e4;
                                            closeableImage = null;
                                            progressiveDecoder.mProducerListener.onProducerFinishWithFailure(progressiveDecoder.mProducerContext.getId(), "DecodeProducer", e, progressiveDecoder.getExtraMap(closeableImage, j, qualityInfo, isLast, str2, sb2, str, valueOf));
                                            progressiveDecoder.maybeFinish(true);
                                            progressiveDecoder.mConsumer.onFailure(e);
                                        }
                                    } finally {
                                        EncodedImage.closeSafely(encodedImage);
                                    }
                                }
                            }
                        } else {
                            throw null;
                        }
                    }
                }
            }, this.mImageDecodeOptions.minDecodeIntervalMs);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(DecodeProducer.this, z) {
                /* class com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.AnonymousClass2 */
                public final /* synthetic */ boolean val$decodeCancellationEnabled;

                {
                    this.val$decodeCancellationEnabled = r3;
                }

                @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (this.val$decodeCancellationEnabled) {
                        ProgressiveDecoder progressiveDecoder = ProgressiveDecoder.this;
                        progressiveDecoder.maybeFinish(true);
                        progressiveDecoder.mConsumer.onCancellation();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
                        ProgressiveDecoder.this.mJobScheduler.scheduleJob();
                    }
                }
            });
        }

        public final Map<String, String> getExtraMap(CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z, String str, String str2, String str3, String str4) {
            if (!this.mProducerListener.requiresExtraMap(this.mProducerContext.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(((ImmutableQualityInfo) qualityInfo).mIsOfGoodEnoughQuality);
            String valueOf3 = String.valueOf(z);
            if (closeableImage instanceof CloseableStaticBitmap) {
                Bitmap bitmap = ((CloseableStaticBitmap) closeableImage).mBitmap;
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", bitmap.getWidth() + "x" + bitmap.getHeight());
                hashMap.put("queueTime", valueOf);
                hashMap.put("hasGoodQuality", valueOf2);
                hashMap.put("isFinal", valueOf3);
                hashMap.put("encodedImageSize", str2);
                hashMap.put("imageFormat", str);
                hashMap.put("requestedImageSize", str3);
                hashMap.put("sampleSize", str4);
                return new ImmutableMap(hashMap);
            }
            HashMap hashMap2 = new HashMap(7);
            hashMap2.put("queueTime", valueOf);
            hashMap2.put("hasGoodQuality", valueOf2);
            hashMap2.put("isFinal", valueOf3);
            hashMap2.put("encodedImageSize", str2);
            hashMap2.put("imageFormat", str);
            hashMap2.put("requestedImageSize", str3);
            hashMap2.put("sampleSize", str4);
            return new ImmutableMap(hashMap2);
        }

        public abstract int getIntermediateImageEndOffset(EncodedImage encodedImage);

        public abstract QualityInfo getQualityInfo();

        public final void handleCancellation() {
            maybeFinish(true);
            this.mConsumer.onCancellation();
        }

        public final void maybeFinish(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.mIsFinished) {
                        this.mConsumer.onProgressUpdate(1.0f);
                        this.mIsFinished = true;
                        this.mJobScheduler.clearJob();
                    }
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.DelegatingConsumer
        public void onCancellationImpl() {
            handleCancellation();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.DelegatingConsumer
        public void onFailureImpl(Throwable th) {
            maybeFinish(true);
            this.mConsumer.onFailure(th);
        }

        /* JADX INFO: finally extract failed */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            try {
                FrescoSystrace.isTracing();
                boolean isLast = BaseConsumer.isLast(i);
                if (isLast && !EncodedImage.isValid(encodedImage)) {
                    ExceptionWithNoStacktrace exceptionWithNoStacktrace = new ExceptionWithNoStacktrace("Encoded image is not valid.");
                    maybeFinish(true);
                    this.mConsumer.onFailure(exceptionWithNoStacktrace);
                } else if (updateDecodeJob(encodedImage, i)) {
                    boolean statusHasFlag = BaseConsumer.statusHasFlag(i, 4);
                    if (isLast || statusHasFlag || this.mProducerContext.isIntermediateResultExpected()) {
                        this.mJobScheduler.scheduleJob();
                    }
                }
                FrescoSystrace.isTracing();
            } catch (Throwable th) {
                FrescoSystrace.isTracing();
                throw th;
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.DelegatingConsumer
        public void onProgressUpdateImpl(float f) {
            this.mConsumer.onProgressUpdate(f * 0.99f);
        }

        public abstract boolean updateDecodeJob(EncodedImage encodedImage, int i);
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, Producer<EncodedImage> producer, int i, CloseableReferenceFactory closeableReferenceFactory) {
        if (byteArrayPool != null) {
            this.mByteArrayPool = byteArrayPool;
            if (executor != null) {
                this.mExecutor = executor;
                if (imageDecoder != null) {
                    this.mImageDecoder = imageDecoder;
                    if (progressiveJpegConfig != null) {
                        this.mProgressiveJpegConfig = progressiveJpegConfig;
                        this.mDownsampleEnabled = z;
                        this.mDownsampleEnabledForNetwork = z2;
                        if (producer != null) {
                            this.mInputProducer = producer;
                            this.mDecodeCancellationEnabled = z3;
                            this.mMaxBitmapSize = i;
                            this.mCloseableReferenceFactory = closeableReferenceFactory;
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
        throw null;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<EncodedImage> consumer2;
        try {
            FrescoSystrace.isTracing();
            if (!UriUtil.isNetworkUri(producerContext.getImageRequest().mSourceUri)) {
                consumer2 = new LocalImagesProgressiveDecoder(this, consumer, producerContext, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
            } else {
                consumer2 = new NetworkImagesProgressiveDecoder(this, consumer, producerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
            }
            this.mInputProducer.produceResults(consumer2, producerContext);
            FrescoSystrace.isTracing();
        } catch (Throwable th) {
            FrescoSystrace.isTracing();
            throw th;
        }
    }
}
