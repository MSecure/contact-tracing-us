package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class NetworkFetchProducer implements Producer<EncodedImage> {
    public final ByteArrayPool mByteArrayPool;
    public final NetworkFetcher mNetworkFetcher;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mNetworkFetcher = networkFetcher;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
    public static void notifyConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i, BytesRange bytesRange, Consumer<EncodedImage> consumer) {
        Throwable th;
        EncodedImage encodedImage;
        CloseableReference of = CloseableReference.of(((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).toByteBuffer());
        try {
            encodedImage = new EncodedImage(of);
            try {
                encodedImage.mBytesRange = bytesRange;
                encodedImage.parseMetaData();
                consumer.onNewResult(encodedImage, i);
                EncodedImage.closeSafely(encodedImage);
                if (of != null) {
                    of.close();
                }
            } catch (Throwable th2) {
                th = th2;
                EncodedImage.closeSafely(encodedImage);
                if (of != null) {
                    of.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            encodedImage = null;
            EncodedImage.closeSafely(encodedImage);
            if (of != null) {
            }
            throw th;
        }
    }

    public void handleFinalResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Map<String, String> map;
        int i = ((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).mCount;
        if (!fetchState.getListener().requiresExtraMap(fetchState.getId())) {
            map = null;
        } else {
            map = this.mNetworkFetcher.getExtraMap(fetchState, i);
        }
        RequestListener listener = fetchState.getListener();
        listener.onProducerFinishWithSuccess(fetchState.getId(), "NetworkFetchProducer", map);
        listener.onUltimateProducerReached(fetchState.getId(), "NetworkFetchProducer", true);
        notifyConsumer(pooledByteBufferOutputStream, fetchState.mOnNewResultStatusFlags | 1, fetchState.mResponseBytesRange, fetchState.mConsumer);
    }

    public void maybeHandleIntermediateResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!fetchState.mContext.isIntermediateResultExpected()) {
            z = false;
        } else if (((BaseNetworkFetcher) this.mNetworkFetcher) != null) {
            z = true;
        } else {
            throw null;
        }
        if (z && uptimeMillis - fetchState.mLastIntermediateResultTimeMs >= 100) {
            fetchState.mLastIntermediateResultTimeMs = uptimeMillis;
            fetchState.getListener().onProducerEvent(fetchState.getId(), "NetworkFetchProducer", "intermediate_result");
            notifyConsumer(pooledByteBufferOutputStream, fetchState.mOnNewResultStatusFlags, fetchState.mResponseBytesRange, fetchState.mConsumer);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        producerContext.getListener().onProducerStart(producerContext.getId(), "NetworkFetchProducer");
        final FetchState createFetchState = this.mNetworkFetcher.createFetchState(consumer, producerContext);
        this.mNetworkFetcher.fetch(createFetchState, new NetworkFetcher.Callback() {
            /* class com.facebook.imagepipeline.producers.NetworkFetchProducer.AnonymousClass1 */

            public void onCancellation() {
                NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
                FetchState fetchState = createFetchState;
                if (networkFetchProducer != null) {
                    fetchState.getListener().onProducerFinishWithCancellation(fetchState.getId(), "NetworkFetchProducer", null);
                    fetchState.mConsumer.onCancellation();
                    return;
                }
                throw null;
            }

            public void onFailure(Throwable th) {
                NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
                FetchState fetchState = createFetchState;
                if (networkFetchProducer != null) {
                    fetchState.getListener().onProducerFinishWithFailure(fetchState.getId(), "NetworkFetchProducer", th, null);
                    fetchState.getListener().onUltimateProducerReached(fetchState.getId(), "NetworkFetchProducer", false);
                    fetchState.mConsumer.onFailure(th);
                    return;
                }
                throw null;
            }

            /* JADX INFO: finally extract failed */
            public void onResponse(InputStream inputStream, int i) throws IOException {
                PooledByteBufferOutputStream pooledByteBufferOutputStream;
                float f;
                FrescoSystrace.isTracing();
                NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
                FetchState fetchState = createFetchState;
                if (i > 0) {
                    pooledByteBufferOutputStream = networkFetchProducer.mPooledByteBufferFactory.newOutputStream(i);
                } else {
                    pooledByteBufferOutputStream = networkFetchProducer.mPooledByteBufferFactory.newOutputStream();
                }
                byte[] bArr = (byte[]) networkFetchProducer.mByteArrayPool.get(16384);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read < 0) {
                            networkFetchProducer.mNetworkFetcher.onFetchCompletion(fetchState, ((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).mCount);
                            networkFetchProducer.handleFinalResult(pooledByteBufferOutputStream, fetchState);
                            networkFetchProducer.mByteArrayPool.release(bArr);
                            pooledByteBufferOutputStream.close();
                            FrescoSystrace.isTracing();
                            return;
                        } else if (read > 0) {
                            pooledByteBufferOutputStream.write(bArr, 0, read);
                            networkFetchProducer.maybeHandleIntermediateResult(pooledByteBufferOutputStream, fetchState);
                            int i2 = ((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).mCount;
                            if (i > 0) {
                                f = ((float) i2) / ((float) i);
                            } else {
                                f = 1.0f - ((float) Math.exp(((double) (-i2)) / 50000.0d));
                            }
                            fetchState.mConsumer.onProgressUpdate(f);
                        }
                    } catch (Throwable th) {
                        networkFetchProducer.mByteArrayPool.release(bArr);
                        pooledByteBufferOutputStream.close();
                        throw th;
                    }
                }
            }
        });
    }
}
