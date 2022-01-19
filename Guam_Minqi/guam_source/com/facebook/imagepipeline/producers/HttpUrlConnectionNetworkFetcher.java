package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<HttpUrlConnectionNetworkFetchState> {
    public final ExecutorService mExecutorService = Executors.newFixedThreadPool(3);
    public int mHttpConnectionTimeout;
    public final MonotonicClock mMonotonicClock;

    public static class HttpUrlConnectionNetworkFetchState extends FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        public HttpUrlConnectionNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        RealtimeSinceBootClock realtimeSinceBootClock = RealtimeSinceBootClock.get();
        this.mMonotonicClock = realtimeSinceBootClock;
        this.mHttpConnectionTimeout = i;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public FetchState createFetchState(Consumer consumer, ProducerContext producerContext) {
        return new HttpUrlConnectionNetworkFetchState(consumer, producerContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090  */
    public final HttpURLConnection downloadFrom(Uri uri, int i) throws IOException {
        boolean z;
        Uri uri2;
        String str;
        HttpURLConnection httpURLConnection = (HttpURLConnection) UriUtil.uriToUrl(uri).openConnection();
        httpURLConnection.setConnectTimeout(this.mHttpConnectionTimeout);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return httpURLConnection;
        }
        if (!(responseCode == 307 || responseCode == 308)) {
            switch (responseCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                String headerField = httpURLConnection.getHeaderField("Location");
                httpURLConnection.disconnect();
                if (headerField == null) {
                    uri2 = null;
                } else {
                    uri2 = Uri.parse(headerField);
                }
                String scheme = uri.getScheme();
                if (i > 0 && uri2 != null && !uri2.getScheme().equals(scheme)) {
                    return downloadFrom(uri2, i - 1);
                }
                if (i == 0) {
                    str = String.format(Locale.getDefault(), "URL %s follows too many redirects", uri.toString());
                } else {
                    str = String.format(Locale.getDefault(), "URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode));
                }
                throw new IOException(str);
            }
            httpURLConnection.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        z = true;
        if (!z) {
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(FetchState fetchState, final NetworkFetcher.Callback callback) {
        final HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState = (HttpUrlConnectionNetworkFetchState) fetchState;
        httpUrlConnectionNetworkFetchState.submitTime = this.mMonotonicClock.now();
        final Future<?> submit = this.mExecutorService.submit(new Runnable() {
            /* class com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:24:0x003f A[SYNTHETIC, Splitter:B:24:0x003f] */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x004a A[SYNTHETIC, Splitter:B:30:0x004a] */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x004f  */
            /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
            public void run() {
                HttpURLConnection httpURLConnection;
                Throwable th;
                IOException e;
                HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher = HttpUrlConnectionNetworkFetcher.this;
                HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState = httpUrlConnectionNetworkFetchState;
                NetworkFetcher.Callback callback = callback;
                InputStream inputStream = null;
                if (httpUrlConnectionNetworkFetcher != null) {
                    try {
                        httpURLConnection = httpUrlConnectionNetworkFetcher.downloadFrom(httpUrlConnectionNetworkFetchState.getUri(), 5);
                        try {
                            httpUrlConnectionNetworkFetchState.responseTime = httpUrlConnectionNetworkFetcher.mMonotonicClock.now();
                            if (httpURLConnection != null) {
                                inputStream = httpURLConnection.getInputStream();
                                ((NetworkFetchProducer.AnonymousClass1) callback).onResponse(inputStream, -1);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (httpURLConnection == null) {
                                return;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            try {
                                ((NetworkFetchProducer.AnonymousClass1) callback).onFailure(e);
                                if (0 != 0) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (httpURLConnection == null) {
                                    return;
                                }
                                httpURLConnection.disconnect();
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                if (0 != 0) {
                                }
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        httpURLConnection = null;
                        ((NetworkFetchProducer.AnonymousClass1) callback).onFailure(e);
                        if (0 != 0) {
                        }
                        if (httpURLConnection == null) {
                        }
                        httpURLConnection.disconnect();
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = null;
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    return;
                }
                throw null;
            }
        });
        httpUrlConnectionNetworkFetchState.mContext.addCallbacks(new BaseProducerContextCallbacks(this) {
            /* class com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.AnonymousClass2 */

            @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (submit.cancel(false)) {
                    ((NetworkFetchProducer.AnonymousClass1) callback).onCancellation();
                }
            }
        });
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public Map getExtraMap(FetchState fetchState, int i) {
        HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState = (HttpUrlConnectionNetworkFetchState) fetchState;
        HashMap hashMap = new HashMap(4);
        hashMap.put("queue_time", Long.toString(httpUrlConnectionNetworkFetchState.responseTime - httpUrlConnectionNetworkFetchState.submitTime));
        hashMap.put("fetch_time", Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.responseTime));
        hashMap.put("total_time", Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.submitTime));
        hashMap.put("image_size", Integer.toString(i));
        return hashMap;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void onFetchCompletion(FetchState fetchState, int i) {
        ((HttpUrlConnectionNetworkFetchState) fetchState).fetchCompleteTime = this.mMonotonicClock.now();
    }
}
