package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

public final class Transmitter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Call call;
    public Object callStackTrace;
    public boolean canceled;
    public final OkHttpClient client;
    public RealConnection connection;
    public final RealConnectionPool connectionPool;
    public final EventListener eventListener;
    public Exchange exchange;
    public ExchangeFinder exchangeFinder;
    public boolean exchangeRequestDone;
    public boolean exchangeResponseDone;
    public boolean noMoreExchanges;
    public Request request;
    public final AsyncTimeout timeout = new AsyncTimeout() {
        /* class okhttp3.internal.connection.Transmitter.AnonymousClass1 */

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Transmitter.this.cancel();
        }
    };
    public boolean timeoutEarlyExit;

    public static final class TransmitterReference extends WeakReference<Transmitter> {
        public final Object callStackTrace;

        public TransmitterReference(Transmitter transmitter, Object obj) {
            super(transmitter);
            this.callStackTrace = obj;
        }
    }

    public Transmitter(OkHttpClient okHttpClient, Call call2) {
        this.client = okHttpClient;
        this.connectionPool = Internal.instance.realConnectionPool(okHttpClient.connectionPool());
        this.call = call2;
        this.eventListener = okHttpClient.eventListenerFactory().create(call2);
        this.timeout.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private IOException maybeReleaseConnection(IOException iOException, boolean z) {
        RealConnection realConnection;
        Socket releaseConnectionNoEvents;
        boolean z2;
        boolean z3;
        synchronized (this.connectionPool) {
            if (z) {
                if (this.exchange != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            realConnection = this.connection;
            releaseConnectionNoEvents = (this.connection == null || this.exchange != null || (!z && !this.noMoreExchanges)) ? null : releaseConnectionNoEvents();
            if (this.connection != null) {
                realConnection = null;
            }
            z2 = true;
            z3 = this.noMoreExchanges && this.exchange == null;
        }
        Util.closeQuietly(releaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z3) {
            if (iOException == null) {
                z2 = false;
            }
            iOException = timeoutExit(iOException);
            if (z2) {
                this.eventListener.callFailed(this.call, iOException);
            } else {
                this.eventListener.callEnd(this.call);
            }
        }
        return iOException;
    }

    private IOException timeoutExit(IOException iOException) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void acquireConnectionNoEvents(RealConnection realConnection) {
        if (this.connection == null) {
            this.connection = realConnection;
            realConnection.transmitters.add(new TransmitterReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    public void callStart() {
        this.callStackTrace = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this.call);
    }

    public boolean canRetry() {
        return this.exchangeFinder.hasStreamFailure() && this.exchangeFinder.hasRouteToTry();
    }

    public void cancel() {
        Exchange exchange2;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            exchange2 = this.exchange;
            if (this.exchangeFinder == null || this.exchangeFinder.connectingConnection() == null) {
                realConnection = this.connection;
            } else {
                realConnection = this.exchangeFinder.connectingConnection();
            }
        }
        if (exchange2 != null) {
            exchange2.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public void exchangeDoneDueToException() {
        synchronized (this.connectionPool) {
            if (!this.noMoreExchanges) {
                this.exchange = null;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return maybeReleaseConnection(r6, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r6;
     */
    public IOException exchangeMessageDone(Exchange exchange2, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        synchronized (this.connectionPool) {
            if (exchange2 != this.exchange) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.exchangeRequestDone;
                this.exchangeRequestDone = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.exchangeResponseDone) {
                    z3 = true;
                }
                this.exchangeResponseDone = true;
            }
            if (!this.exchangeRequestDone || !this.exchangeResponseDone || !z3) {
                z4 = false;
            } else {
                this.exchange.connection().successCount++;
                this.exchange = null;
            }
        }
    }

    public boolean hasExchange() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.exchange != null;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    public Exchange newExchange(Interceptor.Chain chain, boolean z) {
        synchronized (this.connectionPool) {
            if (this.noMoreExchanges) {
                throw new IllegalStateException("released");
            } else if (this.exchange != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        Exchange exchange2 = new Exchange(this, this.call, this.eventListener, this.exchangeFinder, this.exchangeFinder.find(this.client, chain, z));
        synchronized (this.connectionPool) {
            this.exchange = exchange2;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return exchange2;
    }

    public IOException noMoreExchanges(IOException iOException) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    public void prepareToConnect(Request request2) {
        Request request3 = this.request;
        if (request3 != null) {
            if (Util.sameConnection(request3.url(), request2.url()) && this.exchangeFinder.hasRouteToTry()) {
                return;
            }
            if (this.exchange != null) {
                throw new IllegalStateException();
            } else if (this.exchangeFinder != null) {
                maybeReleaseConnection(null, true);
                this.exchangeFinder = null;
            }
        }
        this.request = request2;
        this.exchangeFinder = new ExchangeFinder(this, this.connectionPool, createAddress(request2.url()), this.call, this.eventListener);
    }

    public Socket releaseConnectionNoEvents() {
        int i = 0;
        int size = this.connection.transmitters.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (this.connection.transmitters.get(i).get() == this) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            RealConnection realConnection = this.connection;
            realConnection.transmitters.remove(i);
            this.connection = null;
            if (!realConnection.transmitters.isEmpty()) {
                return null;
            }
            realConnection.idleAtNanos = System.nanoTime();
            if (this.connectionPool.connectionBecameIdle(realConnection)) {
                return realConnection.socket();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            this.timeout.exit();
            return;
        }
        throw new IllegalStateException();
    }

    public void timeoutEnter() {
        this.timeout.enter();
    }
}
