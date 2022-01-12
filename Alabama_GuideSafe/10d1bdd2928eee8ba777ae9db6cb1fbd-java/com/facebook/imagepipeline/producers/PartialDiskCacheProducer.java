package com.facebook.imagepipeline.producers;

import android.net.Uri;
import androidx.appcompat.app.AppCompatDelegateImpl;
import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class PartialDiskCacheProducer implements Producer<EncodedImage> {
    public final ByteArrayPool mByteArrayPool;
    public final CacheKeyFactory mCacheKeyFactory;
    public final BufferedDiskCache mDefaultBufferedDiskCache;
    public final Producer<EncodedImage> mInputProducer;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public static class PartialDiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ByteArrayPool mByteArrayPool;
        public final BufferedDiskCache mDefaultBufferedDiskCache;
        public final EncodedImage mPartialEncodedImageFromCache;
        public final CacheKey mPartialImageCacheKey;
        public final PooledByteBufferFactory mPooledByteBufferFactory;

        public PartialDiskCacheConsumer(Consumer consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, EncodedImage encodedImage, AnonymousClass1 r7) {
            super(consumer);
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mPartialImageCacheKey = cacheKey;
            this.mPooledByteBufferFactory = pooledByteBufferFactory;
            this.mByteArrayPool = byteArrayPool;
            this.mPartialEncodedImageFromCache = encodedImage;
        }

        public final void copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = (byte[]) this.mByteArrayPool.get(16384);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(16384, i2));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i2 -= read;
                    }
                } catch (Throwable th) {
                    this.mByteArrayPool.release(bArr);
                    throw th;
                }
            }
            this.mByteArrayPool.release(bArr);
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        public final PooledByteBufferOutputStream merge(EncodedImage encodedImage, EncodedImage encodedImage2) throws IOException {
            PooledByteBufferOutputStream newOutputStream = this.mPooledByteBufferFactory.newOutputStream(encodedImage2.getSize() + encodedImage2.mBytesRange.from);
            copy(encodedImage.getInputStream(), newOutputStream, encodedImage2.mBytesRange.from);
            copy(encodedImage2.getInputStream(), newOutputStream, encodedImage2.getSize());
            return newOutputStream;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (!BaseConsumer.isNotLast(i)) {
                EncodedImage encodedImage2 = this.mPartialEncodedImageFromCache;
                if (encodedImage2 == null || encodedImage.mBytesRange == null) {
                    if (BaseConsumer.statusHasFlag(i, 8) && BaseConsumer.isLast(i)) {
                        encodedImage.parseMetaDataIfNeeded();
                        if (encodedImage.mImageFormat != ImageFormat.UNKNOWN) {
                            this.mDefaultBufferedDiskCache.put(this.mPartialImageCacheKey, encodedImage);
                            this.mConsumer.onNewResult(encodedImage, i);
                            return;
                        }
                    }
                    this.mConsumer.onNewResult(encodedImage, i);
                    return;
                }
                try {
                    sendFinalResultToConsumer(merge(encodedImage2, encodedImage));
                } catch (IOException e) {
                    FLog.e("PartialDiskCacheProducer", "Error while merging image data", e);
                    this.mConsumer.onFailure(e);
                } catch (Throwable th) {
                    CloseableReference.closeSafely(encodedImage.mPooledByteBufferRef);
                    CloseableReference.closeSafely(this.mPartialEncodedImageFromCache.mPooledByteBufferRef);
                    throw th;
                }
                CloseableReference.closeSafely(encodedImage.mPooledByteBufferRef);
                CloseableReference.closeSafely(this.mPartialEncodedImageFromCache.mPooledByteBufferRef);
                BufferedDiskCache bufferedDiskCache = this.mDefaultBufferedDiskCache;
                CacheKey cacheKey = this.mPartialImageCacheKey;
                if (cacheKey != null) {
                    bufferedDiskCache.mStagingArea.remove(cacheKey);
                    try {
                        Task.call(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0048: INVOKE  
                              (wrap: com.facebook.imagepipeline.cache.BufferedDiskCache$4 : 0x0043: CONSTRUCTOR  (r0v13 com.facebook.imagepipeline.cache.BufferedDiskCache$4) = 
                              (r4v8 'bufferedDiskCache' com.facebook.imagepipeline.cache.BufferedDiskCache)
                              (r5v3 'cacheKey' com.facebook.cache.common.CacheKey)
                             call: com.facebook.imagepipeline.cache.BufferedDiskCache.4.<init>(com.facebook.imagepipeline.cache.BufferedDiskCache, com.facebook.cache.common.CacheKey):void type: CONSTRUCTOR)
                              (wrap: java.util.concurrent.Executor : 0x0046: IGET  (r4v11 java.util.concurrent.Executor) = (r4v8 'bufferedDiskCache' com.facebook.imagepipeline.cache.BufferedDiskCache) com.facebook.imagepipeline.cache.BufferedDiskCache.mWriteExecutor java.util.concurrent.Executor)
                             type: STATIC call: bolts.Task.call(java.util.concurrent.Callable, java.util.concurrent.Executor):bolts.Task in method: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PartialDiskCacheConsumer.onNewResultImpl(java.lang.Object, int):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0043: CONSTRUCTOR  (r0v13 com.facebook.imagepipeline.cache.BufferedDiskCache$4) = 
                              (r4v8 'bufferedDiskCache' com.facebook.imagepipeline.cache.BufferedDiskCache)
                              (r5v3 'cacheKey' com.facebook.cache.common.CacheKey)
                             call: com.facebook.imagepipeline.cache.BufferedDiskCache.4.<init>(com.facebook.imagepipeline.cache.BufferedDiskCache, com.facebook.cache.common.CacheKey):void type: CONSTRUCTOR in method: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PartialDiskCacheConsumer.onNewResultImpl(java.lang.Object, int):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 33 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.imagepipeline.cache.BufferedDiskCache, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 39 more
                            */
                        /*
                        // Method dump skipped, instructions count: 155
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PartialDiskCacheConsumer.onNewResultImpl(java.lang.Object, int):void");
                    }

                    public final void sendFinalResultToConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream) {
                        EncodedImage encodedImage;
                        Throwable th;
                        CloseableReference of = CloseableReference.of(((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).toByteBuffer());
                        try {
                            encodedImage = new EncodedImage(of);
                            try {
                                encodedImage.parseMetaData();
                                this.mConsumer.onNewResult(encodedImage, 1);
                                EncodedImage.closeSafely(encodedImage);
                                CloseableReference.closeSafely(of);
                            } catch (Throwable th2) {
                                th = th2;
                                EncodedImage.closeSafely(encodedImage);
                                CloseableReference.closeSafely(of);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            encodedImage = null;
                            th = th3;
                            EncodedImage.closeSafely(encodedImage);
                            CloseableReference.closeSafely(of);
                            throw th;
                        }
                    }
                }

                public PartialDiskCacheProducer(BufferedDiskCache bufferedDiskCache, CacheKeyFactory cacheKeyFactory, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, Producer<EncodedImage> producer) {
                    this.mDefaultBufferedDiskCache = bufferedDiskCache;
                    this.mCacheKeyFactory = cacheKeyFactory;
                    this.mPooledByteBufferFactory = pooledByteBufferFactory;
                    this.mByteArrayPool = byteArrayPool;
                    this.mInputProducer = producer;
                }

                public static void access$100(PartialDiskCacheProducer partialDiskCacheProducer, Consumer consumer, ProducerContext producerContext, CacheKey cacheKey, EncodedImage encodedImage) {
                    partialDiskCacheProducer.mInputProducer.produceResults(new PartialDiskCacheConsumer(consumer, partialDiskCacheProducer.mDefaultBufferedDiskCache, cacheKey, partialDiskCacheProducer.mPooledByteBufferFactory, partialDiskCacheProducer.mByteArrayPool, encodedImage, null), producerContext);
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
                    if (!imageRequest.mIsDiskCacheEnabled) {
                        this.mInputProducer.produceResults(consumer, producerContext);
                        return;
                    }
                    producerContext.getListener().onProducerStart(producerContext.getId(), "PartialDiskCacheProducer");
                    Uri build = imageRequest.mSourceUri.buildUpon().appendQueryParameter("fresco_partial", "true").build();
                    CacheKeyFactory cacheKeyFactory = this.mCacheKeyFactory;
                    producerContext.getCallerContext();
                    if (((DefaultCacheKeyFactory) cacheKeyFactory) != null) {
                        final SimpleCacheKey simpleCacheKey = new SimpleCacheKey(build.toString());
                        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        Task<EncodedImage> task = this.mDefaultBufferedDiskCache.get(simpleCacheKey, atomicBoolean);
                        final String id = producerContext.getId();
                        final RequestListener listener = producerContext.getListener();
                        task.continueWith(new Continuation<EncodedImage, Void>() {
                            /* class com.facebook.imagepipeline.producers.PartialDiskCacheProducer.AnonymousClass1 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
                            @Override // bolts.Continuation
                            public Void then(Task<EncodedImage> task) throws Exception {
                                boolean z;
                                TResult tresult;
                                synchronized (task.lock) {
                                    z = task.cancelled;
                                }
                                boolean z2 = false;
                                if (z || (task.isFaulted() && (task.getError() instanceof CancellationException))) {
                                    listener.onProducerFinishWithCancellation(id, "PartialDiskCacheProducer", null);
                                    consumer.onCancellation();
                                } else if (task.isFaulted()) {
                                    listener.onProducerFinishWithFailure(id, "PartialDiskCacheProducer", task.getError(), null);
                                    PartialDiskCacheProducer.access$100(PartialDiskCacheProducer.this, consumer, producerContext, simpleCacheKey, null);
                                } else {
                                    synchronized (task.lock) {
                                        tresult = task.result;
                                    }
                                    TResult tresult2 = tresult;
                                    if (tresult2 != null) {
                                        RequestListener requestListener = listener;
                                        String str = id;
                                        requestListener.onProducerFinishWithSuccess(str, "PartialDiskCacheProducer", PartialDiskCacheProducer.getExtraMap(requestListener, str, true, tresult2.getSize()));
                                        int size = tresult2.getSize() - 1;
                                        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(size > 0);
                                        BytesRange bytesRange = new BytesRange(0, size);
                                        tresult2.mBytesRange = bytesRange;
                                        int size2 = tresult2.getSize();
                                        ImageRequest imageRequest = producerContext.getImageRequest();
                                        BytesRange bytesRange2 = imageRequest.mBytesRange;
                                        if (bytesRange2 != null && bytesRange.from <= bytesRange2.from && bytesRange.to >= bytesRange2.to) {
                                            listener.onUltimateProducerReached(id, "PartialDiskCacheProducer", true);
                                            consumer.onNewResult(tresult2, 9);
                                        } else {
                                            consumer.onNewResult(tresult2, 8);
                                            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(imageRequest.mSourceUri);
                                            newBuilderWithSource.mImageDecodeOptions = imageRequest.mImageDecodeOptions;
                                            newBuilderWithSource.mBytesRange = imageRequest.mBytesRange;
                                            newBuilderWithSource.mCacheChoice = imageRequest.mCacheChoice;
                                            newBuilderWithSource.mLocalThumbnailPreviewsEnabled = imageRequest.mLocalThumbnailPreviewsEnabled;
                                            newBuilderWithSource.mLowestPermittedRequestLevel = imageRequest.mLowestPermittedRequestLevel;
                                            newBuilderWithSource.mPostprocessor = imageRequest.mPostprocessor;
                                            newBuilderWithSource.mProgressiveRenderingEnabled = imageRequest.mProgressiveRenderingEnabled;
                                            newBuilderWithSource.mRequestPriority = imageRequest.mRequestPriority;
                                            newBuilderWithSource.mResizeOptions = imageRequest.mResizeOptions;
                                            newBuilderWithSource.mRequestListener = imageRequest.mRequestListener;
                                            newBuilderWithSource.mRotationOptions = imageRequest.mRotationOptions;
                                            newBuilderWithSource.mDecodePrefetches = imageRequest.mDecodePrefetches;
                                            int i = size2 - 1;
                                            if (i >= 0) {
                                                z2 = true;
                                            }
                                            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(z2);
                                            newBuilderWithSource.mBytesRange = new BytesRange(i, Integer.MAX_VALUE);
                                            PartialDiskCacheProducer.access$100(PartialDiskCacheProducer.this, consumer, new SettableProducerContext(newBuilderWithSource.build(), producerContext), simpleCacheKey, tresult2);
                                        }
                                    } else {
                                        RequestListener requestListener2 = listener;
                                        String str2 = id;
                                        requestListener2.onProducerFinishWithSuccess(str2, "PartialDiskCacheProducer", PartialDiskCacheProducer.getExtraMap(requestListener2, str2, false, 0));
                                        PartialDiskCacheProducer.access$100(PartialDiskCacheProducer.this, consumer, producerContext, simpleCacheKey, tresult2);
                                    }
                                }
                                return null;
                            }
                        });
                        producerContext.addCallbacks(new BaseProducerContextCallbacks(this) {
                            /* class com.facebook.imagepipeline.producers.PartialDiskCacheProducer.AnonymousClass2 */

                            @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
                            public void onCancellationRequested() {
                                atomicBoolean.set(true);
                            }
                        });
                        return;
                    }
                    throw null;
                }
            }
