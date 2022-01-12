package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;

public final class ExchangeFinder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    public RealConnection connectingConnection;
    public final RealConnectionPool connectionPool;
    public final EventListener eventListener;
    public boolean hasStreamFailure;
    public Route nextRouteToTry;
    public RouteSelector.Selection routeSelection;
    public final RouteSelector routeSelector;
    public final Transmitter transmitter;

    public ExchangeFinder(Transmitter transmitter2, RealConnectionPool realConnectionPool, Address address2, Call call2, EventListener eventListener2) {
        this.transmitter = transmitter2;
        this.connectionPool = realConnectionPool;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.routeSelector = new RouteSelector(address2, realConnectionPool.routeDatabase, call2, eventListener2);
    }

    private RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket socket;
        Socket releaseConnectionNoEvents;
        RealConnection realConnection;
        RealConnection realConnection2;
        boolean z2;
        Route route;
        boolean z3;
        List<Route> list;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            if (!this.transmitter.isCanceled()) {
                this.hasStreamFailure = false;
                RealConnection realConnection3 = this.transmitter.connection;
                socket = null;
                releaseConnectionNoEvents = (this.transmitter.connection == null || !this.transmitter.connection.noNewExchanges) ? null : this.transmitter.releaseConnectionNoEvents();
                if (this.transmitter.connection != null) {
                    realConnection2 = this.transmitter.connection;
                    realConnection = null;
                } else {
                    realConnection = realConnection3;
                    realConnection2 = null;
                }
                if (realConnection2 == null) {
                    if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, null, false)) {
                        realConnection2 = this.transmitter.connection;
                        route = null;
                        z2 = true;
                    } else {
                        if (this.nextRouteToTry != null) {
                            route = this.nextRouteToTry;
                            this.nextRouteToTry = null;
                        } else if (retryCurrentRoute()) {
                            route = this.transmitter.connection.route();
                        }
                        z2 = false;
                    }
                }
                z2 = false;
                route = null;
            } else {
                throw new IOException("Canceled");
            }
        }
        Util.closeQuietly(releaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (route != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            if (!this.transmitter.isCanceled()) {
                if (z3) {
                    list = this.routeSelection.getAll();
                    if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, list, false)) {
                        realConnection2 = this.transmitter.connection;
                        z2 = true;
                    }
                } else {
                    list = null;
                }
                if (!z2) {
                    if (route == null) {
                        route = this.routeSelection.next();
                    }
                    realConnection2 = new RealConnection(this.connectionPool, route);
                    this.connectingConnection = realConnection2;
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        this.connectionPool.routeDatabase.connected(realConnection2.route());
        synchronized (this.connectionPool) {
            this.connectingConnection = null;
            if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, list, true)) {
                realConnection2.noNewExchanges = true;
                socket = realConnection2.socket();
                realConnection2 = this.transmitter.connection;
                this.nextRouteToTry = route;
            } else {
                this.connectionPool.put(realConnection2);
                this.transmitter.acquireConnectionNoEvents(realConnection2);
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection2);
        return realConnection2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return r0;
     */
    private RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, i4, z);
            synchronized (this.connectionPool) {
                if (findConnection.successCount == 0 && !findConnection.isMultiplexed()) {
                    return findConnection;
                }
            }
            findConnection.noNewExchanges();
        }
    }

    private boolean retryCurrentRoute() {
        RealConnection realConnection = this.transmitter.connection;
        return realConnection != null && realConnection.routeFailureCount == 0 && Util.sameConnection(realConnection.route().address().url(), this.address.url());
    }

    public RealConnection connectingConnection() {
        return this.connectingConnection;
    }

    public ExchangeCodec find(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            return findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain);
        } catch (RouteException e) {
            trackFailure();
            throw e;
        } catch (IOException e2) {
            trackFailure();
            throw new RouteException(e2);
        }
    }

    public boolean hasRouteToTry() {
        synchronized (this.connectionPool) {
            boolean z = true;
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                this.nextRouteToTry = this.transmitter.connection.route();
                return true;
            }
            if (this.routeSelection == null || !this.routeSelection.hasNext()) {
                if (!this.routeSelector.hasNext()) {
                    z = false;
                }
            }
            return z;
        }
    }

    public boolean hasStreamFailure() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.hasStreamFailure;
        }
        return z;
    }

    public void trackFailure() {
        synchronized (this.connectionPool) {
            this.hasStreamFailure = true;
        }
    }
}
