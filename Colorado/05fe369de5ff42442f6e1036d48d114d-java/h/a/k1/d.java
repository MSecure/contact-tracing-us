package h.a.k1;

import h.a.e;
import h.a.j1.c3;
import h.a.j1.g;
import h.a.j1.j1;
import h.a.j1.q0;
import h.a.j1.t2;
import h.a.j1.x;
import h.a.j1.z;
import h.a.k1.p.b;
import h.a.k1.p.i;
import h.a.k1.p.k;
import h.a.l0;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class d extends h.a.j1.b<d> {
    public static final h.a.k1.p.b M;
    public static final long N = TimeUnit.DAYS.toNanos(1000);
    public static final t2.c<Executor> O = new a();
    public Executor D;
    public ScheduledExecutorService E;
    public SSLSocketFactory F;
    public h.a.k1.p.b G = M;
    public b H = b.TLS;
    public long I = Long.MAX_VALUE;
    public long J = q0.f3973j;
    public int K = 65535;
    public int L = Integer.MAX_VALUE;

    public class a implements t2.c<Executor> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.a.j1.t2.c
        public Executor a() {
            return Executors.newCachedThreadPool(q0.d("grpc-okhttp-%d", true));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.j1.t2.c
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }
    }

    public enum b {
        TLS,
        PLAINTEXT
    }

    public static final class c implements x {
        public final Executor b;
        public final boolean c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f4071d;

        /* renamed from: e  reason: collision with root package name */
        public final c3.b f4072e;

        /* renamed from: f  reason: collision with root package name */
        public final SocketFactory f4073f;

        /* renamed from: g  reason: collision with root package name */
        public final SSLSocketFactory f4074g;

        /* renamed from: h  reason: collision with root package name */
        public final HostnameVerifier f4075h;

        /* renamed from: i  reason: collision with root package name */
        public final h.a.k1.p.b f4076i;

        /* renamed from: j  reason: collision with root package name */
        public final int f4077j;

        /* renamed from: k  reason: collision with root package name */
        public final boolean f4078k;

        /* renamed from: l  reason: collision with root package name */
        public final g f4079l;
        public final long m;
        public final int n;
        public final boolean o;
        public final int p;
        public final ScheduledExecutorService q;
        public final boolean r;
        public boolean s;

        public class a implements Runnable {
            public final /* synthetic */ g.b b;

            public a(c cVar, g.b bVar) {
                this.b = bVar;
            }

            public void run() {
                g.b bVar = this.b;
                long j2 = bVar.a;
                long max = Math.max(2 * j2, j2);
                if (g.this.b.compareAndSet(bVar.a, max)) {
                    g.c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{g.this.a, Long.valueOf(max)});
                }
            }
        }

        public c(Executor executor, ScheduledExecutorService scheduledExecutorService, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, h.a.k1.p.b bVar, int i2, boolean z, long j2, long j3, int i3, boolean z2, int i4, c3.b bVar2, boolean z3, a aVar) {
            boolean z4 = true;
            boolean z5 = scheduledExecutorService == null;
            this.f4071d = z5;
            this.q = z5 ? (ScheduledExecutorService) t2.a(q0.n) : scheduledExecutorService;
            this.f4073f = null;
            this.f4074g = sSLSocketFactory;
            this.f4075h = null;
            this.f4076i = bVar;
            this.f4077j = i2;
            this.f4078k = z;
            this.f4079l = new g("keepalive time nanos", j2);
            this.m = j3;
            this.n = i3;
            this.o = z2;
            this.p = i4;
            this.r = z3;
            z4 = executor != null ? false : z4;
            this.c = z4;
            f.b.a.c.b.o.b.z(bVar2, "transportTracerFactory");
            this.f4072e = bVar2;
            this.b = z4 ? (Executor) t2.a(d.O) : executor;
        }

        @Override // java.io.Closeable, h.a.j1.x, java.lang.AutoCloseable
        public void close() {
            if (!this.s) {
                this.s = true;
                if (this.f4071d) {
                    t2.b(q0.n, this.q);
                }
                if (this.c) {
                    t2.b(d.O, this.b);
                }
            }
        }

        @Override // h.a.j1.x
        public z f(SocketAddress socketAddress, x.a aVar, e eVar) {
            if (!this.s) {
                g gVar = this.f4079l;
                g.b bVar = new g.b(gVar.b.get(), null);
                a aVar2 = new a(this, bVar);
                String str = aVar.a;
                String str2 = aVar.c;
                h.a.a aVar3 = aVar.b;
                Executor executor = this.b;
                SocketFactory socketFactory = this.f4073f;
                SSLSocketFactory sSLSocketFactory = this.f4074g;
                HostnameVerifier hostnameVerifier = this.f4075h;
                h.a.k1.p.b bVar2 = this.f4076i;
                int i2 = this.f4077j;
                int i3 = this.n;
                h.a.z zVar = aVar.f4027d;
                int i4 = this.p;
                c3.b bVar3 = this.f4072e;
                Objects.requireNonNull(bVar3);
                g gVar2 = new g((InetSocketAddress) socketAddress, str, str2, aVar3, executor, socketFactory, sSLSocketFactory, hostnameVerifier, bVar2, i2, i3, zVar, aVar2, i4, new c3(bVar3.a, null), this.r);
                if (this.f4078k) {
                    long j2 = bVar.a;
                    long j3 = this.m;
                    boolean z = this.o;
                    gVar2.G = true;
                    gVar2.H = j2;
                    gVar2.I = j3;
                    gVar2.J = z;
                }
                return gVar2;
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        @Override // h.a.j1.x
        public ScheduledExecutorService p() {
            return this.q;
        }
    }

    static {
        b.C0150b bVar = new b.C0150b(h.a.k1.p.b.f4128f);
        bVar.b(h.a.k1.p.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, h.a.k1.p.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, h.a.k1.p.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, h.a.k1.p.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, h.a.k1.p.a.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, h.a.k1.p.a.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, h.a.k1.p.a.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, h.a.k1.p.a.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384);
        bVar.d(k.TLS_1_2);
        bVar.c(true);
        M = bVar.a();
    }

    public d(String str) {
        super(str);
    }

    public static d forTarget(String str) {
        return new d(str);
    }

    @Override // h.a.l0
    public l0 b(long j2, TimeUnit timeUnit) {
        f.b.a.c.b.o.b.o(j2 > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(j2);
        this.I = nanos;
        long max = Math.max(nanos, j1.f3883l);
        this.I = max;
        if (max >= N) {
            this.I = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // h.a.l0
    public l0 c() {
        this.H = b.PLAINTEXT;
        return this;
    }

    @Override // h.a.j1.b
    public final x d() {
        SSLSocketFactory sSLSocketFactory;
        boolean z = this.I != Long.MAX_VALUE;
        Executor executor = this.D;
        ScheduledExecutorService scheduledExecutorService = this.E;
        int ordinal = this.H.ordinal();
        if (ordinal == 0) {
            try {
                if (this.F == null) {
                    this.F = SSLContext.getInstance("Default", i.f4135d.a).getSocketFactory();
                }
                sSLSocketFactory = this.F;
            } catch (GeneralSecurityException e2) {
                throw new RuntimeException("TLS Provider failure", e2);
            }
        } else if (ordinal == 1) {
            sSLSocketFactory = null;
        } else {
            StringBuilder i2 = f.a.a.a.a.i("Unknown negotiation type: ");
            i2.append(this.H);
            throw new RuntimeException(i2.toString());
        }
        return new c(executor, scheduledExecutorService, null, sSLSocketFactory, null, this.G, this.s, z, this.I, this.J, this.K, false, this.L, this.r, false, null);
    }

    @Override // h.a.j1.b
    public int e() {
        int ordinal = this.H.ordinal();
        if (ordinal == 0) {
            return 443;
        }
        if (ordinal == 1) {
            return 80;
        }
        throw new AssertionError(this.H + " not handled");
    }

    public final d scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        f.b.a.c.b.o.b.z(scheduledExecutorService, "scheduledExecutorService");
        this.E = scheduledExecutorService;
        return this;
    }

    public final d sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.F = sSLSocketFactory;
        this.H = b.TLS;
        return this;
    }

    public final d transportExecutor(Executor executor) {
        this.D = executor;
        return this;
    }
}
