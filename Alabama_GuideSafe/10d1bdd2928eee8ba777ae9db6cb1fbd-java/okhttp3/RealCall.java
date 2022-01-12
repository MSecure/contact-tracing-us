package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.Timeout;

public final class RealCall implements Call {
    public final OkHttpClient client;
    public boolean executed;
    public final boolean forWebSocket;
    public final Request originalRequest;
    public Transmitter transmitter;

    public final class AsyncCall extends NamedRunnable {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        public final Callback responseCallback;

        public AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        public AtomicInteger callsPerHost() {
            return this.callsPerHost;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0033 A[Catch:{ IOException -> 0x0056, all -> 0x0028, all -> 0x0054 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[Catch:{ IOException -> 0x0056, all -> 0x0028, all -> 0x0054 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007c A[Catch:{ IOException -> 0x0056, all -> 0x0028, all -> 0x0054 }] */
        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            boolean z;
            IOException e;
            Throwable th;
            RealCall.this.transmitter.timeoutEnter();
            try {
                z = true;
                try {
                    this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain());
                } catch (IOException e2) {
                    e = e2;
                    if (!z) {
                    }
                    RealCall.this.client.dispatcher().finished(this);
                } catch (Throwable th2) {
                    th = th2;
                    RealCall.this.cancel();
                    if (!z) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                z = false;
                e = e3;
                if (!z) {
                    Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                } else {
                    this.responseCallback.onFailure(RealCall.this, e);
                }
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th3) {
                RealCall.this.client.dispatcher().finished(this);
                throw th3;
            }
            RealCall.this.client.dispatcher().finished(this);
        }

        public void executeOn(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                RealCall.this.transmitter.noMoreExchanges(interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        public RealCall get() {
            return RealCall.this;
        }

        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        public Request request() {
            return RealCall.this.originalRequest;
        }

        public void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            this.callsPerHost = asyncCall.callsPerHost;
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
    }

    public static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.transmitter = new Transmitter(okHttpClient, realCall);
        return realCall;
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.transmitter.cancel();
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.transmitter.callStart();
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // okhttp3.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.transmitter.timeoutEnter();
        this.transmitter.callStart();
        try {
            this.client.dispatcher().executed(this);
            return getResponseWithInterceptorChain();
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a6  */
    public Response getResponseWithInterceptorChain() throws IOException {
        Throwable th;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(new RetryAndFollowUpInterceptor(this.client));
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        boolean z = false;
        try {
            Response proceed = new RealInterceptorChain(arrayList, this.transmitter, null, 0, this.originalRequest, this, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
            if (!this.transmitter.isCanceled()) {
                this.transmitter.noMoreExchanges(null);
                return proceed;
            }
            Util.closeQuietly(proceed);
            throw new IOException("Canceled");
        } catch (IOException e) {
            throw this.transmitter.noMoreExchanges(e);
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (!z) {
            }
            throw th;
        }
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.transmitter.isCanceled();
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        return this.transmitter.timeout();
    }

    public String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    @Override // okhttp3.Call, java.lang.Object
    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
