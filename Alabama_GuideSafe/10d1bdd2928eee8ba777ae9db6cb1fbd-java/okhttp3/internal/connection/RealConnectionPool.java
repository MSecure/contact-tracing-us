package okhttp3.internal.connection;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Address;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.platform.Platform;

public final class RealConnectionPool {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    public final Runnable cleanupRunnable = new Runnable() {
        /* class okhttp3.internal.connection.$$Lambda$RealConnectionPool$Cy61BJKpsrwSB_hQmB_R9MngVNU */

        public final void run() {
            RealConnectionPool.this.lambda$new$0$RealConnectionPool();
        }
    };
    public boolean cleanupRunning;
    public final Deque<RealConnection> connections = new ArrayDeque();
    public final long keepAliveDurationNs;
    public final int maxIdleConnections;
    public final RouteDatabase routeDatabase = new RouteDatabase();

    public RealConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("keepAliveDuration <= 0: ", j));
        }
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        List<Reference<Transmitter>> list = realConnection.transmitters;
        int i = 0;
        while (i < list.size()) {
            Reference<Transmitter> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("A connection to ");
                outline17.append(realConnection.route().address().url());
                outline17.append(" was leaked. Did you forget to close a response body?");
                Platform.get().logCloseableLeak(outline17.toString(), ((Transmitter.TransmitterReference) reference).callStackTrace);
                list.remove(i);
                realConnection.noNewExchanges = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public long cleanup(long j) {
        synchronized (this) {
            RealConnection realConnection = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (RealConnection realConnection2 : this.connections) {
                if (pruneAndGetAllocationCount(realConnection2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - realConnection2.idleAtNanos;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.keepAliveDurationNs) {
                if (i <= this.maxIdleConnections) {
                    if (i > 0) {
                        return this.keepAliveDurationNs - j2;
                    } else if (i2 > 0) {
                        return this.keepAliveDurationNs;
                    } else {
                        this.cleanupRunning = false;
                        return -1;
                    }
                }
            }
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            return 0;
        }
    }

    public void connectFailed(Route route, IOException iOException) {
        if (route.proxy().type() != Proxy.Type.DIRECT) {
            Address address = route.address();
            address.proxySelector().connectFailed(address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }

    public boolean connectionBecameIdle(RealConnection realConnection) {
        if (realConnection.noNewExchanges || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    public void evictAll() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealConnection> it = this.connections.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next.transmitters.isEmpty()) {
                    next.noNewExchanges = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Util.closeQuietly(((RealConnection) it2.next()).socket());
        }
    }

    public synchronized int idleConnectionCount() {
        int i;
        i = 0;
        for (RealConnection realConnection : this.connections) {
            if (realConnection.transmitters.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
    public /* synthetic */ void lambda$new$0$RealConnectionPool() {
        while (true) {
            long cleanup = cleanup(System.nanoTime());
            if (cleanup != -1) {
                if (cleanup > 0) {
                    long j = cleanup / 1000000;
                    long j2 = cleanup - (1000000 * j);
                    synchronized (this) {
                        wait(j, (int) j2);
                    }
                }
            } else {
                return;
            }
        }
    }

    public void put(RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }

    public boolean transmitterAcquirePooledConnection(Address address, Transmitter transmitter, List<Route> list, boolean z) {
        for (RealConnection realConnection : this.connections) {
            if ((!z || realConnection.isMultiplexed()) && realConnection.isEligible(address, list)) {
                transmitter.acquireConnectionNoEvents(realConnection);
                return true;
            }
        }
        return false;
    }
}
