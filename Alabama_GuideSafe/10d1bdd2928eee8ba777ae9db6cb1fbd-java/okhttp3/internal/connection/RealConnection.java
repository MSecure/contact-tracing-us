package okhttp3.internal.connection;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_TUNNEL_ATTEMPTS = 21;
    public static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public int allocationLimit = 1;
    public final RealConnectionPool connectionPool;
    public Handshake handshake;
    public Http2Connection http2Connection;
    public long idleAtNanos = RecyclerView.FOREVER_NS;
    public boolean noNewExchanges;
    public Protocol protocol;
    public Socket rawSocket;
    public int refusedStreamCount;
    public final Route route;
    public int routeFailureCount;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;
    public final List<Reference<Transmitter>> transmitters = new ArrayList();

    public RealConnection(RealConnectionPool realConnectionPool, Route route2) {
        this.connectionPool = realConnectionPool;
        this.route = route2;
    }

    private void connectSocket(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket socket2;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
            socket2 = address.socketFactory().createSocket();
        } else {
            socket2 = new Socket(proxy);
        }
        this.rawSocket = socket2;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
            try {
                this.source = new RealBufferedSource(Okio.source(this.rawSocket));
                this.sink = new RealBufferedSink(Okio.sink(this.rawSocket));
            } catch (NullPointerException e) {
                if (NPE_THROW_WITH_NULL.equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Failed to connect to ");
            outline17.append(this.route.socketAddress());
            ConnectException connectException = new ConnectException(outline17.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0137 A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013d A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0140  */
    private void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Throwable th;
        AssertionError e;
        Protocol protocol2;
        Address address = this.route.address();
        SSLSocket sSLSocket = null;
        String str = null;
        try {
            SSLSocket sSLSocket2 = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.get().configureTlsExtensions(sSLSocket2, address.url().host(), address.protocols());
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                Handshake handshake2 = Handshake.get(session);
                if (!address.hostnameVerifier().verify(address.url().host(), session)) {
                    List<Certificate> peerCertificates = handshake2.peerCertificates();
                    if (!peerCertificates.isEmpty()) {
                        X509Certificate x509Certificate = (X509Certificate) peerCertificates.get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                    }
                    throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
                }
                address.certificatePinner().check(address.url().host(), handshake2.peerCertificates());
                if (configureSecureSocket.supportsTlsExtensions()) {
                    str = Platform.get().getSelectedProtocol(sSLSocket2);
                }
                this.socket = sSLSocket2;
                this.source = new RealBufferedSource(Okio.source(sSLSocket2));
                this.sink = new RealBufferedSink(Okio.sink(this.socket));
                this.handshake = handshake2;
                if (str != null) {
                    protocol2 = Protocol.get(str);
                } else {
                    protocol2 = Protocol.HTTP_1_1;
                }
                this.protocol = protocol2;
                Platform.get().afterHandshake(sSLSocket2);
            } catch (AssertionError e2) {
                e = e2;
                sSLSocket = sSLSocket2;
                try {
                    if (!Util.isAndroidGetsocknameError(e)) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sSLSocket != null) {
                    }
                    Util.closeQuietly((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform.get().afterHandshake(sSLSocket);
                }
                Util.closeQuietly((Socket) sSLSocket);
                throw th;
            }
        } catch (AssertionError e3) {
            e = e3;
            if (!Util.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    private void connectTunnel(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        for (int i4 = 0; i4 < 21; i4++) {
            connectSocket(i, i2, call, eventListener);
            createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Util.closeQuietly(this.rawSocket);
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
            } else {
                return;
            }
        }
    }

    private Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("CONNECT ");
        outline17.append(Util.hostHeader(httpUrl, true));
        outline17.append(" HTTP/1.1");
        String sb = outline17.toString();
        while (true) {
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, null, this.source, this.sink);
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1ExchangeCodec.writeRequest(request.headers(), sb);
            http1ExchangeCodec.finishRequest();
            Response build = http1ExchangeCodec.readResponseHeaders(false).request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(build.header("Connection"))) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    StringBuilder outline172 = GeneratedOutlineSupport.outline17("Unexpected response code for CONNECT: ");
                    outline172.append(build.code());
                    throw new IOException(outline172.toString());
                }
            } else if (this.source.getBuffer().exhausted() && this.sink.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate != null ? authenticate : build;
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                startHttp2(i);
            }
        } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            startHttp2(i);
        } else {
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        }
    }

    private boolean routeMatchesAny(List<Route> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Route route2 = list.get(i);
            if (route2.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && this.route.socketAddress().equals(route2.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private void startHttp2(int i) throws IOException {
        this.socket.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i).build();
        this.http2Connection = build;
        build.start();
    }

    public static RealConnection testConnection(RealConnectionPool realConnectionPool, Route route2, Socket socket2, long j) {
        RealConnection realConnection = new RealConnection(realConnectionPool, route2);
        realConnection.socket = socket2;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0082 A[Catch:{ IOException -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public void connect(int i, int i2, int i3, int i4, boolean z, Call call, EventListener eventListener) {
        IOException e;
        if (this.protocol == null) {
            List<ConnectionSpec> connectionSpecs = this.route.address().connectionSpecs();
            ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(connectionSpecs);
            if (this.route.address().sslSocketFactory() == null) {
                if (connectionSpecs.contains(ConnectionSpec.CLEARTEXT)) {
                    String host = this.route.address().url().host();
                    if (!Platform.get().isCleartextTrafficPermitted(host)) {
                        throw new RouteException(new UnknownServiceException(GeneratedOutlineSupport.outline11("CLEARTEXT communication to ", host, " not permitted by network security policy")));
                    }
                } else {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
            RouteException routeException = null;
            do {
                try {
                    if (!this.route.requiresTunnel()) {
                        connectTunnel(i, i2, i3, call, eventListener);
                        if (this.rawSocket == null) {
                            if (!this.route.requiresTunnel() && this.rawSocket == null) {
                                throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                            } else if (this.http2Connection != null) {
                                synchronized (this.connectionPool) {
                                    this.allocationLimit = this.http2Connection.maxConcurrentStreams();
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    } else {
                        try {
                            connectSocket(i, i2, call, eventListener);
                        } catch (IOException e2) {
                            e = e2;
                            Util.closeQuietly(this.socket);
                            Util.closeQuietly(this.rawSocket);
                            this.socket = null;
                            this.rawSocket = null;
                            this.source = null;
                            this.sink = null;
                            this.handshake = null;
                            this.protocol = null;
                            this.http2Connection = null;
                            eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                            if (routeException != null) {
                                routeException = new RouteException(e);
                            } else {
                                routeException.addConnectException(e);
                            }
                            if (!z || connectionSpecSelector.connectionFailed(e)) {
                                throw routeException;
                            }
                            do {
                                if (!this.route.requiresTunnel()) {
                                }
                                establishProtocol(connectionSpecSelector, i4, call, eventListener);
                                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                                if (!this.route.requiresTunnel()) {
                                }
                                if (this.http2Connection != null) {
                                }
                            } while (connectionSpecSelector.connectionFailed(e));
                            throw routeException;
                        }
                    }
                    try {
                        establishProtocol(connectionSpecSelector, i4, call, eventListener);
                        eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                        if (!this.route.requiresTunnel()) {
                        }
                        if (this.http2Connection != null) {
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } catch (IOException e4) {
                    e = e4;
                    Util.closeQuietly(this.socket);
                    Util.closeQuietly(this.rawSocket);
                    this.socket = null;
                    this.rawSocket = null;
                    this.source = null;
                    this.sink = null;
                    this.handshake = null;
                    this.protocol = null;
                    this.http2Connection = null;
                    eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                    if (routeException != null) {
                    }
                    throw routeException;
                }
            } while (connectionSpecSelector.connectionFailed(e));
            throw routeException;
        }
        throw new IllegalStateException("already connected");
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isEligible(Address address, List<Route> list) {
        if (this.transmitters.size() >= this.allocationLimit || this.noNewExchanges || !Internal.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean isHealthy(boolean z) {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return http2Connection2.isHealthy(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.socket.getSoTimeout();
                try {
                    this.socket.setSoTimeout(1);
                    if (this.source.exhausted()) {
                        this.socket.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.socket.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.socket.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public ExchangeCodec newCodec(OkHttpClient okHttpClient, Interceptor.Chain chain) throws SocketException {
        if (this.http2Connection != null) {
            return new Http2ExchangeCodec(okHttpClient, this, chain, this.http2Connection);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        this.source.timeout().timeout((long) chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout((long) chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1ExchangeCodec(okHttpClient, this, this.source, this.sink);
    }

    public RealWebSocket.Streams newWebSocketStreams(final Exchange exchange) throws SocketException {
        this.socket.setSoTimeout(0);
        noNewExchanges();
        return new RealWebSocket.Streams(true, this.source, this.sink) {
            /* class okhttp3.internal.connection.RealConnection.AnonymousClass1 */

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                exchange.bodyComplete(-1, true, true, null);
            }
        };
    }

    public void noNewExchanges() {
        synchronized (this.connectionPool) {
            this.noNewExchanges = true;
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection http2Connection2) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection2.maxConcurrentStreams();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.protocol;
    }

    @Override // okhttp3.Connection
    public Route route() {
        return this.route;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.socket;
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.route.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.route.address().url().host())) {
            return true;
        }
        if (this.handshake == null || !OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.handshake.peerCertificates().get(0))) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Connection{");
        outline17.append(this.route.address().url().host());
        outline17.append(ColorPropConverter.PACKAGE_DELIMITER);
        outline17.append(this.route.address().url().port());
        outline17.append(", proxy=");
        outline17.append(this.route.proxy());
        outline17.append(" hostAddress=");
        outline17.append(this.route.socketAddress());
        outline17.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        outline17.append(handshake2 != null ? handshake2.cipherSuite() : "none");
        outline17.append(" protocol=");
        outline17.append(this.protocol);
        outline17.append('}');
        return outline17.toString();
    }

    public void trackFailure(IOException iOException) {
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i;
                    if (i > 1) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (errorCode != ErrorCode.CANCEL) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!isMultiplexed() || (iOException instanceof ConnectionShutdownException)) {
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (iOException != null) {
                        this.connectionPool.connectFailed(this.route, iOException);
                    }
                    this.routeFailureCount++;
                }
            }
        }
    }
}
