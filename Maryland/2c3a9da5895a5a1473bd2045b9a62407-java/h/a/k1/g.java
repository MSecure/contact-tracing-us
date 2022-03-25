package h.a.k1;

import f.b.b.a.k;
import f.b.b.a.s;
import f.b.b.a.t;
import f.b.b.a.u;
import f.e.a.b;
import f.e.a.d;
import h.a.a;
import h.a.a0;
import h.a.c1;
import h.a.d0;
import h.a.d1;
import h.a.f1;
import h.a.j;
import h.a.j1.c3;
import h.a.j1.j1;
import h.a.j1.p0;
import h.a.j1.q0;
import h.a.j1.q2;
import h.a.j1.t2;
import h.a.j1.v;
import h.a.j1.v0;
import h.a.j1.w;
import h.a.j1.w0;
import h.a.j1.w2;
import h.a.j1.x0;
import h.a.j1.y1;
import h.a.j1.z;
import h.a.k1.b;
import h.a.k1.f;
import h.a.k1.h;
import h.a.k1.p.m.b;
import h.a.k1.p.m.f;
import h.a.k1.p.m.i;
import h.a.n0;
import h.a.o0;
import h.a.y;
import h.a.z0;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k.h;
import k.l;
import k.m;
import k.n;
import k.o;

public class g implements z, b.a {
    public static final Map<h.a.k1.p.m.a, c1> Q;
    public static final Logger R = Logger.getLogger(g.class.getName());
    public static final f[] S = new f[0];
    public HostnameVerifier A;
    public int B;
    public final LinkedList<f> C;
    public final h.a.k1.p.b D;
    public ScheduledExecutorService E;
    public j1 F;
    public boolean G;
    public long H;
    public long I;
    public boolean J;
    public final Runnable K;
    public final int L;
    public final boolean M;
    public final c3 N;
    public final x0<f> O;
    public final h.a.z P;
    public final InetSocketAddress a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final Random f3932d = new Random();

    /* renamed from: e  reason: collision with root package name */
    public final u<s> f3933e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3934f;

    /* renamed from: g  reason: collision with root package name */
    public y1.a f3935g;

    /* renamed from: h  reason: collision with root package name */
    public b f3936h;

    /* renamed from: i  reason: collision with root package name */
    public n f3937i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f3938j;

    /* renamed from: k  reason: collision with root package name */
    public final d0 f3939k;

    /* renamed from: l  reason: collision with root package name */
    public int f3940l;
    public final Map<Integer, f> m;
    public final Executor n;
    public final q2 o;
    public final int p;
    public int q;
    public e r;
    public h.a.a s;
    public c1 t;
    public boolean u;
    public w0 v;
    public boolean w;
    public boolean x;
    public final SocketFactory y;
    public SSLSocketFactory z;

    public class a extends x0<f> {
        public a() {
        }

        @Override // h.a.j1.x0
        public void a() {
            g.this.f3935g.c(true);
        }

        @Override // h.a.j1.x0
        public void b() {
            g.this.f3935g.c(false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Objects.requireNonNull(g.this);
            g gVar = g.this;
            Objects.requireNonNull(gVar);
            Objects.requireNonNull(g.this);
            gVar.r = new e(null, null);
            g gVar2 = g.this;
            gVar2.n.execute(gVar2.r);
            synchronized (g.this.f3938j) {
                g gVar3 = g.this;
                gVar3.B = Integer.MAX_VALUE;
                gVar3.w();
            }
            Objects.requireNonNull(g.this);
            throw null;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ CountDownLatch b;
        public final /* synthetic */ a c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f3941d;

        public class a implements k.s {
            public a(c cVar) {
            }

            @Override // k.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // k.s
            public long m(k.e eVar, long j2) {
                return -1;
            }
        }

        public c(CountDownLatch countDownLatch, a aVar, i iVar) {
            this.b = countDownLatch;
            this.c = aVar;
            this.f3941d = iVar;
        }

        public void run() {
            Throwable th;
            d1 e2;
            g gVar;
            e eVar;
            Exception e3;
            Socket h2;
            try {
                this.b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            a aVar = new a(this);
            Logger logger = l.a;
            n nVar = new n(aVar);
            SSLSession sSLSession = null;
            try {
                g gVar2 = g.this;
                h.a.z zVar = gVar2.P;
                if (zVar == null) {
                    h2 = gVar2.y.createSocket(gVar2.a.getAddress(), g.this.a.getPort());
                } else {
                    SocketAddress socketAddress = zVar.b;
                    if (socketAddress instanceof InetSocketAddress) {
                        h2 = g.h(gVar2, zVar.c, (InetSocketAddress) socketAddress, zVar.f4088d, zVar.f4089e);
                    } else {
                        c1 c1Var = c1.m;
                        throw new d1(c1Var.g("Unsupported SocketAddress implementation " + g.this.P.b.getClass()));
                    }
                }
                Socket socket = h2;
                g gVar3 = g.this;
                SSLSocketFactory sSLSocketFactory = gVar3.z;
                SSLSocket sSLSocket = socket;
                if (sSLSocketFactory != null) {
                    SSLSocket a2 = k.a(sSLSocketFactory, gVar3.A, socket, gVar3.m(), g.this.n(), g.this.D);
                    sSLSession = a2.getSession();
                    sSLSocket = a2;
                }
                sSLSocket.setTcpNoDelay(true);
                n nVar2 = new n(l.c(sSLSocket));
                try {
                    this.c.c(l.b(sSLSocket), sSLSocket);
                    g gVar4 = g.this;
                    a.b b2 = gVar4.s.b();
                    b2.b(y.a, sSLSocket.getRemoteSocketAddress());
                    b2.b(y.b, sSLSocket.getLocalSocketAddress());
                    b2.b(y.c, sSLSession);
                    b2.b(p0.f3808d, sSLSession == null ? z0.NONE : z0.PRIVACY_AND_INTEGRITY);
                    gVar4.s = b2.a();
                    g gVar5 = g.this;
                    gVar5.r = new e(gVar5, ((f) this.f3941d).e(nVar2, true));
                    synchronized (g.this.f3938j) {
                        g gVar6 = g.this;
                        f.b.a.c.b.o.b.A(sSLSocket, "socket");
                        Objects.requireNonNull(gVar6);
                        if (sSLSession != null) {
                            g gVar7 = g.this;
                            new a0.b(sSLSession);
                            Objects.requireNonNull(gVar7);
                        }
                    }
                } catch (d1 e4) {
                    e2 = e4;
                    nVar = nVar2;
                    g.this.v(0, h.a.k1.p.m.a.INTERNAL_ERROR, e2.b);
                    gVar = g.this;
                    eVar = new e(gVar, ((f) this.f3941d).e(nVar, true));
                    gVar.r = eVar;
                } catch (Exception e5) {
                    e3 = e5;
                    nVar = nVar2;
                    try {
                        g.this.b(e3);
                        gVar = g.this;
                        eVar = new e(gVar, ((f) this.f3941d).e(nVar, true));
                        gVar.r = eVar;
                    } catch (Throwable th2) {
                        th = th2;
                        nVar2 = nVar;
                        g gVar8 = g.this;
                        gVar8.r = new e(gVar8, ((f) this.f3941d).e(nVar2, true));
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    g gVar82 = g.this;
                    gVar82.r = new e(gVar82, ((f) this.f3941d).e(nVar2, true));
                    throw th;
                }
            } catch (d1 e6) {
                e2 = e6;
                g.this.v(0, h.a.k1.p.m.a.INTERNAL_ERROR, e2.b);
                gVar = g.this;
                eVar = new e(gVar, ((f) this.f3941d).e(nVar, true));
                gVar.r = eVar;
            } catch (Exception e7) {
                e3 = e7;
                g.this.b(e3);
                gVar = g.this;
                eVar = new e(gVar, ((f) this.f3941d).e(nVar, true));
                gVar.r = eVar;
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            g gVar = g.this;
            gVar.n.execute(gVar.r);
            synchronized (g.this.f3938j) {
                g gVar2 = g.this;
                gVar2.B = Integer.MAX_VALUE;
                gVar2.w();
            }
        }
    }

    public class e implements b.a, Runnable {
        public final h b;
        public h.a.k1.p.m.b c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3943d;

        public e(g gVar, h.a.k1.p.m.b bVar) {
            h hVar = new h(Level.FINE, g.class);
            g.this = gVar;
            this.f3943d = true;
            this.c = bVar;
            this.b = hVar;
        }

        public e(h.a.k1.p.m.b bVar, h hVar) {
            this.f3943d = true;
            this.c = null;
            this.b = null;
        }

        public void run() {
            IOException e2;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (((f.c) this.c).c(this)) {
                try {
                    j1 j1Var = g.this.F;
                    if (j1Var != null) {
                        j1Var.a();
                    }
                } catch (Throwable th) {
                    try {
                        ((f.c) this.c).b.close();
                    } catch (IOException e3) {
                        g.R.log(Level.INFO, "Exception closing frame reader", (Throwable) e3);
                    }
                    g.this.f3935g.a();
                    Thread.currentThread().setName(name);
                    throw th;
                }
            }
            g gVar = g.this;
            h.a.k1.p.m.a aVar = h.a.k1.p.m.a.INTERNAL_ERROR;
            c1 g2 = c1.n.g("End of stream or IOException");
            Map<h.a.k1.p.m.a, c1> map = g.Q;
            gVar.v(0, aVar, g2);
            try {
                ((f.c) this.c).b.close();
            } catch (IOException e4) {
                e2 = e4;
            }
            g.this.f3935g.a();
            Thread.currentThread().setName(name);
            g.R.log(Level.INFO, "Exception closing frame reader", (Throwable) e2);
            g.this.f3935g.a();
            Thread.currentThread().setName(name);
        }
    }

    static {
        EnumMap enumMap = new EnumMap(h.a.k1.p.m.a.class);
        h.a.k1.p.m.a aVar = h.a.k1.p.m.a.NO_ERROR;
        c1 c1Var = c1.m;
        enumMap.put((Object) aVar, (Object) c1Var.g("No error: A GRPC status of OK should have been sent"));
        enumMap.put((Object) h.a.k1.p.m.a.PROTOCOL_ERROR, (Object) c1Var.g("Protocol error"));
        enumMap.put((Object) h.a.k1.p.m.a.INTERNAL_ERROR, (Object) c1Var.g("Internal error"));
        enumMap.put((Object) h.a.k1.p.m.a.FLOW_CONTROL_ERROR, (Object) c1Var.g("Flow control error"));
        enumMap.put((Object) h.a.k1.p.m.a.STREAM_CLOSED, (Object) c1Var.g("Stream closed"));
        enumMap.put((Object) h.a.k1.p.m.a.FRAME_TOO_LARGE, (Object) c1Var.g("Frame too large"));
        enumMap.put((Object) h.a.k1.p.m.a.REFUSED_STREAM, (Object) c1.n.g("Refused stream"));
        enumMap.put((Object) h.a.k1.p.m.a.CANCEL, (Object) c1.f3614g.g("Cancelled"));
        enumMap.put((Object) h.a.k1.p.m.a.COMPRESSION_ERROR, (Object) c1Var.g("Compression error"));
        enumMap.put((Object) h.a.k1.p.m.a.CONNECT_ERROR, (Object) c1Var.g("Connect error"));
        enumMap.put((Object) h.a.k1.p.m.a.ENHANCE_YOUR_CALM, (Object) c1.f3619l.g("Enhance your calm"));
        enumMap.put((Object) h.a.k1.p.m.a.INADEQUATE_SECURITY, (Object) c1.f3617j.g("Inadequate security"));
        Q = Collections.unmodifiableMap(enumMap);
    }

    public g(InetSocketAddress inetSocketAddress, String str, String str2, h.a.a aVar, Executor executor, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, h.a.k1.p.b bVar, int i2, int i3, h.a.z zVar, Runnable runnable, int i4, c3 c3Var, boolean z2) {
        Object obj = new Object();
        this.f3938j = obj;
        this.m = new HashMap();
        this.B = 0;
        this.C = new LinkedList<>();
        this.O = new a();
        f.b.a.c.b.o.b.A(inetSocketAddress, "address");
        this.a = inetSocketAddress;
        this.b = str;
        this.p = i2;
        this.f3934f = i3;
        f.b.a.c.b.o.b.A(executor, "executor");
        this.n = executor;
        this.o = new q2(executor);
        this.f3940l = 3;
        this.y = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.z = sSLSocketFactory;
        this.A = hostnameVerifier;
        f.b.a.c.b.o.b.A(bVar, "connectionSpec");
        this.D = bVar;
        this.f3933e = q0.o;
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        sb.append("grpc-java-");
        sb.append("okhttp");
        sb.append('/');
        sb.append("1.28.0");
        this.c = sb.toString();
        this.P = zVar;
        f.b.a.c.b.o.b.A(runnable, "tooManyPingsRunnable");
        this.K = runnable;
        this.L = i4;
        this.N = c3Var;
        this.f3939k = d0.a(g.class, inetSocketAddress.toString());
        a.b a2 = h.a.a.a();
        a2.b(p0.f3809e, aVar);
        this.s = a2.a();
        this.M = z2;
        synchronized (obj) {
        }
    }

    public static Socket h(g gVar, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) {
        String str3;
        Objects.requireNonNull(gVar);
        try {
            Socket createSocket = inetSocketAddress2.getAddress() != null ? gVar.y.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : gVar.y.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            createSocket.setTcpNoDelay(true);
            k.s c2 = l.c(createSocket);
            m mVar = new m(l.b(createSocket));
            f.e.a.d j2 = gVar.j(inetSocketAddress, str, str2);
            f.e.a.b bVar = j2.a;
            mVar.d(String.format("CONNECT %s:%d HTTP/1.1", bVar.a, Integer.valueOf(bVar.b)));
            mVar.d("\r\n");
            int length = j2.b.a.length / 2;
            for (int i2 = 0; i2 < length; i2++) {
                f.e.a.a aVar = j2.b;
                Objects.requireNonNull(aVar);
                int i3 = i2 * 2;
                if (i3 >= 0) {
                    String[] strArr = aVar.a;
                    if (i3 < strArr.length) {
                        str3 = strArr[i3];
                        mVar.d(str3);
                        mVar.d(": ");
                        mVar.d(j2.b.a(i2));
                        mVar.d("\r\n");
                    }
                }
                str3 = null;
                mVar.d(str3);
                mVar.d(": ");
                mVar.d(j2.b.a(i2));
                mVar.d("\r\n");
            }
            mVar.d("\r\n");
            mVar.flush();
            f.e.a.e.a.a a2 = f.e.a.e.a.a.a(s(c2));
            while (!s(c2).equals("")) {
            }
            int i4 = a2.b;
            if (i4 >= 200 && i4 < 300) {
                return createSocket;
            }
            k.e eVar = new k.e();
            try {
                createSocket.shutdownOutput();
                ((k.b) c2).m(eVar, 1024);
            } catch (IOException e2) {
                eVar.e0("Unable to read body: " + e2.toString());
            }
            try {
                createSocket.close();
            } catch (IOException unused) {
            }
            throw new d1(c1.n.g(String.format("Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(a2.b), a2.c, eVar.V())));
        } catch (IOException e3) {
            throw new d1(c1.n.g("Failed trying to connect with proxy").f(e3));
        }
    }

    public static void i(g gVar, h.a.k1.p.m.a aVar, String str) {
        Objects.requireNonNull(gVar);
        gVar.v(0, aVar, z(aVar).a(str));
    }

    public static String s(k.s sVar) {
        long j2;
        o oVar;
        k.e eVar = new k.e();
        while (((k.b) sVar).m(eVar, 1) != -1) {
            if (eVar.v(eVar.c - 1) == 10) {
                long j3 = eVar.c;
                long j4 = Long.MAX_VALUE;
                if (Long.MAX_VALUE > j3) {
                    j4 = j3;
                }
                long j5 = 0;
                if (0 != j4 && (oVar = eVar.b) != null) {
                    if (j3 - 0 >= 0) {
                        j3 = 0;
                        while (true) {
                            long j6 = ((long) (oVar.c - oVar.b)) + j3;
                            if (j6 >= 0) {
                                break;
                            }
                            oVar = oVar.f4117f;
                            j3 = j6;
                        }
                    } else {
                        while (j3 > 0) {
                            oVar = oVar.f4118g;
                            j3 -= (long) (oVar.c - oVar.b);
                        }
                    }
                    loop3:
                    while (true) {
                        if (j3 >= j4) {
                            break;
                        }
                        byte[] bArr = oVar.a;
                        int min = (int) Math.min((long) oVar.c, (((long) oVar.b) + j4) - j3);
                        for (int i2 = (int) ((((long) oVar.b) + j5) - j3); i2 < min; i2++) {
                            if (bArr[i2] == 10) {
                                j2 = ((long) (i2 - oVar.b)) + j3;
                                break loop3;
                            }
                        }
                        j5 = ((long) (oVar.c - oVar.b)) + j3;
                        oVar = oVar.f4117f;
                        j3 = j5;
                    }
                }
                j2 = -1;
                if (j2 == -1) {
                    if (Long.MAX_VALUE < eVar.c && eVar.v(9223372036854775806L) == 13 && eVar.v(Long.MAX_VALUE) == 10) {
                        j2 = Long.MAX_VALUE;
                    } else {
                        k.e eVar2 = new k.e();
                        long j7 = 0;
                        long min2 = Math.min(32L, eVar.c);
                        k.u.b(eVar.c, 0, min2);
                        if (min2 != 0) {
                            eVar2.c += min2;
                            o oVar2 = eVar.b;
                            while (true) {
                                long j8 = (long) (oVar2.c - oVar2.b);
                                if (j7 < j8) {
                                    break;
                                }
                                j7 -= j8;
                                oVar2 = oVar2.f4117f;
                            }
                            while (min2 > 0) {
                                o oVar3 = new o(oVar2);
                                int i3 = (int) (((long) oVar3.b) + j7);
                                oVar3.b = i3;
                                oVar3.c = Math.min(i3 + ((int) min2), oVar3.c);
                                o oVar4 = eVar2.b;
                                if (oVar4 == null) {
                                    oVar3.f4118g = oVar3;
                                    oVar3.f4117f = oVar3;
                                    eVar2.b = oVar3;
                                } else {
                                    oVar4.f4118g.b(oVar3);
                                }
                                min2 -= (long) (oVar3.c - oVar3.b);
                                oVar2 = oVar2.f4117f;
                                j7 = 0;
                            }
                        }
                        StringBuilder h2 = f.a.a.a.a.h("\\n not found: limit=");
                        h2.append(Math.min(eVar.c, Long.MAX_VALUE));
                        h2.append(" content=");
                        h2.append(eVar2.N().e());
                        h2.append((char) 8230);
                        throw new EOFException(h2.toString());
                    }
                }
                return eVar.W(j2);
            }
        }
        StringBuilder h3 = f.a.a.a.a.h("\\n not found: ");
        h3.append(eVar.N().e());
        throw new EOFException(h3.toString());
    }

    public static c1 z(h.a.k1.p.m.a aVar) {
        c1 c1Var = Q.get(aVar);
        if (c1Var != null) {
            return c1Var;
        }
        c1 c1Var2 = c1.f3615h;
        StringBuilder h2 = f.a.a.a.a.h("Unknown http2 error code: ");
        h2.append(aVar.b);
        return c1Var2.g(h2.toString());
    }

    @Override // h.a.j1.y1
    public void a(c1 c1Var) {
        v.a aVar = v.a.PROCESSED;
        d(c1Var);
        synchronized (this.f3938j) {
            Iterator<Map.Entry<Integer, f>> it = this.m.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, f> next = it.next();
                it.remove();
                next.getValue().m.i(c1Var, aVar, false, new n0());
                r(next.getValue());
            }
            Iterator<f> it2 = this.C.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                next2.m.i(c1Var, aVar, true, new n0());
                r(next2);
            }
            this.C.clear();
            y();
        }
    }

    @Override // h.a.k1.b.a
    public void b(Throwable th) {
        f.b.a.c.b.o.b.A(th, "failureCause");
        v(0, h.a.k1.p.m.a.INTERNAL_ERROR, c1.n.f(th));
    }

    @Override // h.a.c0
    public d0 c() {
        return this.f3939k;
    }

    @Override // h.a.j1.y1
    public void d(c1 c1Var) {
        synchronized (this.f3938j) {
            if (this.t == null) {
                this.t = c1Var;
                this.f3935g.d(c1Var);
                y();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // h.a.j1.y1
    public Runnable e(y1.a aVar) {
        q2 q2Var;
        Runnable dVar;
        f.b.a.c.b.o.b.A(aVar, "listener");
        this.f3935g = aVar;
        if (this.G) {
            this.E = (ScheduledExecutorService) t2.a(q0.n);
            j1 j1Var = new j1(new j1.c(this), this.E, this.H, this.I, this.J);
            this.F = j1Var;
            synchronized (j1Var) {
                if (j1Var.f3730d) {
                    j1Var.b();
                }
            }
        }
        if (this.a == null) {
            synchronized (this.f3938j) {
                b bVar = new b(this, null, null);
                this.f3936h = bVar;
                this.f3937i = new n(this, bVar);
            }
            q2Var = this.o;
            dVar = new b();
        } else {
            a aVar2 = new a(this.o, this);
            f fVar = new f();
            Logger logger = l.a;
            f.d dVar2 = new f.d(new m(aVar2), true);
            synchronized (this.f3938j) {
                b bVar2 = new b(this, dVar2, new h(Level.FINE, g.class));
                this.f3936h = bVar2;
                this.f3937i = new n(this, bVar2);
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            q2 q2Var2 = this.o;
            c cVar = new c(countDownLatch, aVar2, fVar);
            Queue<Runnable> queue = q2Var2.c;
            f.b.a.c.b.o.b.A(cVar, "'r' must not be null.");
            queue.add(cVar);
            q2Var2.c(cVar);
            try {
                t();
                countDownLatch.countDown();
                q2Var = this.o;
                dVar = new d();
            } catch (Throwable th) {
                countDownLatch.countDown();
                throw th;
            }
        }
        Queue<Runnable> queue2 = q2Var.c;
        f.b.a.c.b.o.b.A(dVar, "'r' must not be null.");
        queue2.add(dVar);
        q2Var.c(dVar);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        if (r1.f3864d != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r1.c.put(r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0065, code lost:
        r0 = r1.f3865e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        if (r0 == null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        r2 = new h.a.j1.v0(r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        r2 = new h.a.j1.u0(r12, r1.f3866f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0078, code lost:
        h.a.j1.w0.a(r13, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    @Override // h.a.j1.w
    public void f(w.a aVar, Executor executor) {
        long j2;
        synchronized (this.f3938j) {
            boolean z2 = true;
            f.b.a.c.b.o.b.F(this.f3936h != null);
            if (this.w) {
                w0.a(executor, new v0(aVar, o()));
                return;
            }
            w0 w0Var = this.v;
            if (w0Var != null) {
                j2 = 0;
                z2 = false;
            } else {
                j2 = this.f3932d.nextLong();
                s sVar = this.f3933e.get();
                sVar.c();
                w0 w0Var2 = new w0(j2, sVar);
                this.v = w0Var2;
                this.N.f3681e++;
                w0Var = w0Var2;
            }
            if (z2) {
                this.f3936h.C(false, (int) (j2 >>> 32), (int) j2);
            }
        }
    }

    @Override // h.a.j1.w
    public h.a.j1.u g(o0 o0Var, n0 n0Var, h.a.c cVar) {
        w2 w2Var;
        Object obj;
        Throwable th;
        f.b.a.c.b.o.b.A(o0Var, "method");
        f.b.a.c.b.o.b.A(n0Var, "headers");
        h.a.a aVar = this.s;
        w2 w2Var2 = w2.c;
        List<j.a> list = cVar.f3607g;
        if (list.isEmpty()) {
            w2Var = w2.c;
        } else {
            h.a.a aVar2 = h.a.a.b;
            h.a.c cVar2 = h.a.c.f3603k;
            f.b.a.c.b.o.b.A(aVar, "transportAttrs cannot be null");
            f.b.a.c.b.o.b.A(cVar, "callOptions cannot be null");
            j.b bVar = new j.b(aVar, cVar);
            int size = list.size();
            f1[] f1VarArr = new f1[size];
            for (int i2 = 0; i2 < size; i2++) {
                f1VarArr[i2] = list.get(i2).a(bVar, n0Var);
            }
            w2Var = new w2(f1VarArr);
        }
        Object obj2 = this.f3938j;
        synchronized (obj2) {
            try {
                obj = obj2;
                try {
                    f fVar = new f(o0Var, n0Var, this.f3936h, this, this.f3937i, this.f3938j, this.p, this.f3934f, this.b, this.c, w2Var, this.N, cVar, this.M);
                    return fVar;
                } catch (Throwable th2) {
                    th = th2;
                    while (true) {
                        try {
                            break;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
                while (true) {
                    break;
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0250, code lost:
        if (r5 != false) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
        r17 = r3;
        r16 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        r17 = r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014e  */
    public final f.e.a.d j(InetSocketAddress inetSocketAddress, String str, String str2) {
        String str3;
        String str4;
        boolean z2;
        InetAddress inetAddress;
        int i2;
        int i3;
        int i4;
        byte[] bArr;
        int i5;
        int i6;
        int i7;
        boolean z3;
        b.C0136b bVar = new b.C0136b();
        bVar.a = "https";
        String hostName = inetSocketAddress.getHostName();
        if (hostName != null) {
            int i8 = 0;
            String c2 = f.e.a.b.c(hostName, 0, hostName.length(), false);
            if (!c2.startsWith("[") || !c2.endsWith("]")) {
                str3 = hostName;
                try {
                    str4 = IDN.toASCII(c2).toLowerCase(Locale.US);
                    if (!str4.isEmpty()) {
                        int i9 = 0;
                        while (true) {
                            if (i9 >= str4.length()) {
                                z2 = false;
                                break;
                            }
                            char charAt = str4.charAt(i9);
                            if (charAt <= 31) {
                                break;
                            } else if (charAt >= 127) {
                                break;
                            } else if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                                break;
                            } else {
                                i9++;
                            }
                        }
                        z2 = true;
                    }
                } catch (IllegalArgumentException unused) {
                }
            } else {
                int length = c2.length() - 1;
                int i10 = 16;
                byte[] bArr2 = new byte[16];
                int i11 = 0;
                int i12 = 1;
                int i13 = -1;
                int i14 = -1;
                while (true) {
                    if (i12 < length) {
                        if (i11 == i10) {
                            break;
                        }
                        int i15 = i12 + 2;
                        if (i15 <= length) {
                            i6 = i14;
                            if (c2.regionMatches(i12, "::", i8, 2)) {
                                if (i13 == -1) {
                                    i11 += 2;
                                    str3 = hostName;
                                    if (i15 != length) {
                                        i14 = i15;
                                        i13 = i11;
                                        i5 = 0;
                                        i12 = i14;
                                        while (i12 < length) {
                                            int a2 = f.e.a.b.a(c2.charAt(i12));
                                            if (a2 == -1) {
                                                break;
                                            }
                                            i5 = (i5 << 4) + a2;
                                            i12++;
                                        }
                                        int i16 = i12 - i14;
                                        if (i16 == 0 || i16 > 4) {
                                            break;
                                        }
                                        int i17 = i11 + 1;
                                        bArr2[i11] = (byte) ((i5 >>> 8) & 255);
                                        i11 = i17 + 1;
                                        bArr2[i17] = (byte) (i5 & 255);
                                        i8 = 0;
                                        i10 = 16;
                                        hostName = str3;
                                    } else {
                                        i13 = i11;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else {
                            i6 = i14;
                        }
                        if (i11 != 0) {
                            if (c2.regionMatches(i12, ":", i8, 1)) {
                                i12++;
                            } else if (c2.regionMatches(i12, ".", i8, 1)) {
                                int i18 = i11 - 2;
                                int i19 = i18;
                                int i20 = i6;
                                loop1:
                                while (true) {
                                    if (i20 < length) {
                                        if (i19 == 16) {
                                            break;
                                        }
                                        if (i19 != i18) {
                                            if (c2.charAt(i20) != '.') {
                                                break;
                                            }
                                            i20++;
                                        }
                                        int i21 = 0;
                                        int i22 = i20;
                                        while (true) {
                                            if (i22 >= length) {
                                                str3 = hostName;
                                                i7 = i13;
                                                break;
                                            }
                                            i7 = i13;
                                            char charAt2 = c2.charAt(i22);
                                            str3 = hostName;
                                            if (charAt2 >= '0' && charAt2 <= '9') {
                                                if ((i21 == 0 && i20 != i22) || ((i21 * 10) + charAt2) - 48 > 255) {
                                                    break loop1;
                                                }
                                                i22++;
                                                i13 = i7;
                                                hostName = str3;
                                            } else {
                                                break;
                                            }
                                        }
                                        if (i22 - i20 == 0) {
                                            break;
                                        }
                                        bArr2[i19] = (byte) i21;
                                        i19++;
                                        i20 = i22;
                                        i13 = i7;
                                        hostName = str3;
                                    } else {
                                        str3 = hostName;
                                        i7 = i13;
                                        if (i19 == i18 + 4) {
                                            z3 = true;
                                        }
                                    }
                                }
                                z3 = false;
                                if (z3) {
                                    i11 += 2;
                                    i13 = i7;
                                }
                            }
                        }
                        str3 = hostName;
                        i14 = i12;
                        i13 = i13;
                        i5 = 0;
                        i12 = i14;
                        while (i12 < length) {
                        }
                        int i162 = i12 - i14;
                        int i172 = i11 + 1;
                        bArr2[i11] = (byte) ((i5 >>> 8) & 255);
                        i11 = i172 + 1;
                        bArr2[i172] = (byte) (i5 & 255);
                        i8 = 0;
                        i10 = 16;
                        hostName = str3;
                    } else {
                        str3 = hostName;
                        break;
                    }
                }
                if (i11 != 16) {
                    if (i13 != -1) {
                        int i23 = i11 - i13;
                        System.arraycopy(bArr2, i13, bArr2, 16 - i23, i23);
                        Arrays.fill(bArr2, i13, (16 - i11) + i13, (byte) 0);
                    }
                    i2 = 0;
                    inetAddress = null;
                    if (inetAddress != null) {
                        byte[] address = inetAddress.getAddress();
                        int i24 = 16;
                        if (address.length == 16) {
                            int i25 = 0;
                            int i26 = 0;
                            int i27 = -1;
                            while (i25 < address.length) {
                                int i28 = i25;
                                while (i28 < i24 && address[i28] == 0 && address[i28 + 1] == 0) {
                                    i28 += 2;
                                    i24 = 16;
                                }
                                int i29 = i28 - i25;
                                if (i29 > i26) {
                                    i27 = i25;
                                    i26 = i29;
                                }
                                i25 = i28 + 2;
                                i24 = 16;
                            }
                            k.e eVar = new k.e();
                            while (i2 < address.length) {
                                if (i2 == i27) {
                                    eVar.b0(58);
                                    i2 += i26;
                                    if (i2 == 16) {
                                        eVar.b0(58);
                                    }
                                } else {
                                    if (i2 > 0) {
                                        eVar.b0(58);
                                    }
                                    long j2 = (long) (((address[i2] & 255) << 8) | (address[i2 + 1] & 255));
                                    if (j2 == 0) {
                                        eVar.b0(48);
                                        bArr = address;
                                        i4 = i26;
                                        i3 = i27;
                                    } else {
                                        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
                                        o Y = eVar.Y(numberOfTrailingZeros);
                                        byte[] bArr3 = Y.a;
                                        int i30 = Y.c;
                                        bArr = address;
                                        int i31 = (i30 + numberOfTrailingZeros) - 1;
                                        while (i31 >= i30) {
                                            bArr3[i31] = k.e.f4109d[(int) (j2 & 15)];
                                            j2 >>>= 4;
                                            i31--;
                                            i26 = i26;
                                            i27 = i27;
                                        }
                                        i4 = i26;
                                        i3 = i27;
                                        Y.c += numberOfTrailingZeros;
                                        eVar.c += (long) numberOfTrailingZeros;
                                    }
                                    i2 += 2;
                                    address = bArr;
                                    i26 = i4;
                                    i27 = i3;
                                }
                            }
                            str4 = eVar.V();
                            if (str4 == null) {
                                bVar.b = str4;
                                int port = inetSocketAddress.getPort();
                                if (port <= 0 || port > 65535) {
                                    throw new IllegalArgumentException(f.a.a.a.a.q("unexpected port: ", port));
                                }
                                bVar.c = port;
                                if (bVar.a == null) {
                                    throw new IllegalStateException("scheme == null");
                                } else if (bVar.b != null) {
                                    f.e.a.b bVar2 = new f.e.a.b(bVar, null);
                                    d.b bVar3 = new d.b();
                                    bVar3.a = bVar2;
                                    bVar3.a("Host", bVar2.a + ":" + bVar2.b);
                                    bVar3.a("User-Agent", this.c);
                                    if (!(str == null || str2 == null)) {
                                        try {
                                            bVar3.a("Proxy-Authorization", "Basic " + h.f((str + ":" + str2).getBytes("ISO-8859-1")).a());
                                        } catch (UnsupportedEncodingException unused2) {
                                            throw new AssertionError();
                                        }
                                    }
                                    if (bVar3.a != null) {
                                        return new f.e.a.d(bVar3, null);
                                    }
                                    throw new IllegalStateException("url == null");
                                } else {
                                    throw new IllegalStateException("host == null");
                                }
                            } else {
                                throw new IllegalArgumentException(f.a.a.a.a.t("unexpected host: ", str3));
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
                i2 = 0;
                try {
                    inetAddress = InetAddress.getByAddress(bArr2);
                    if (inetAddress != null) {
                    }
                } catch (UnknownHostException unused3) {
                    throw new AssertionError();
                }
            }
            str4 = null;
            if (str4 == null) {
            }
        } else {
            throw new IllegalArgumentException("host == null");
        }
    }

    public void k(int i2, c1 c1Var, v.a aVar, boolean z2, h.a.k1.p.m.a aVar2, n0 n0Var) {
        synchronized (this.f3938j) {
            f remove = this.m.remove(Integer.valueOf(i2));
            if (remove != null) {
                if (c1Var != null) {
                    remove.m.i(c1Var, aVar, z2, new n0());
                }
                if (!w()) {
                    y();
                    r(remove);
                }
            }
        }
    }

    public f[] l() {
        f[] fVarArr;
        synchronized (this.f3938j) {
            fVarArr = (f[]) this.m.values().toArray(S);
        }
        return fVarArr;
    }

    public String m() {
        URI a2 = q0.a(this.b);
        return a2.getHost() != null ? a2.getHost() : this.b;
    }

    public int n() {
        URI a2 = q0.a(this.b);
        return a2.getPort() != -1 ? a2.getPort() : this.a.getPort();
    }

    public final Throwable o() {
        synchronized (this.f3938j) {
            c1 c1Var = this.t;
            if (c1Var != null) {
                Objects.requireNonNull(c1Var);
                return new d1(c1Var);
            }
            return new d1(c1.n.g("Connection closed"));
        }
    }

    public f p(int i2) {
        f fVar;
        synchronized (this.f3938j) {
            fVar = this.m.get(Integer.valueOf(i2));
        }
        return fVar;
    }

    public boolean q(int i2) {
        boolean z2;
        synchronized (this.f3938j) {
            z2 = true;
            if (i2 >= this.f3940l || (i2 & 1) != 1) {
                z2 = false;
            }
        }
        return z2;
    }

    public final void r(f fVar) {
        if (this.x && this.C.isEmpty() && this.m.isEmpty()) {
            this.x = false;
            j1 j1Var = this.F;
            if (j1Var != null) {
                synchronized (j1Var) {
                    if (!j1Var.f3730d) {
                        j1.e eVar = j1Var.f3731e;
                        if (eVar == j1.e.PING_SCHEDULED || eVar == j1.e.PING_DELAYED) {
                            j1Var.f3731e = j1.e.IDLE;
                        }
                        if (j1Var.f3731e == j1.e.PING_SENT) {
                            j1Var.f3731e = j1.e.IDLE_AND_PING_SENT;
                        }
                    }
                }
            }
        }
        if (fVar.c) {
            this.O.c(fVar, false);
        }
    }

    public void t() {
        synchronized (this.f3938j) {
            b bVar = this.f3936h;
            Objects.requireNonNull(bVar);
            try {
                bVar.c.L();
            } catch (IOException e2) {
                bVar.b.b(e2);
            }
            h.a.k1.p.m.h hVar = new h.a.k1.p.m.h();
            hVar.b(7, 0, this.f3934f);
            b bVar2 = this.f3936h;
            bVar2.f3912d.f(h.a.OUTBOUND, hVar);
            try {
                bVar2.c.o(hVar);
            } catch (IOException e3) {
                bVar2.b.b(e3);
            }
            int i2 = this.f3934f;
            if (i2 > 65535) {
                this.f3936h.u(0, (long) (i2 - 65535));
            }
        }
    }

    public String toString() {
        k T1 = f.b.a.c.b.o.b.T1(this);
        T1.b("logId", this.f3939k.c);
        T1.d("address", this.a);
        return T1.toString();
    }

    public final void u(f fVar) {
        if (!this.x) {
            this.x = true;
            j1 j1Var = this.F;
            if (j1Var != null) {
                j1Var.b();
            }
        }
        if (fVar.c) {
            this.O.c(fVar, true);
        }
    }

    public final void v(int i2, h.a.k1.p.m.a aVar, c1 c1Var) {
        v.a aVar2 = v.a.REFUSED;
        synchronized (this.f3938j) {
            if (this.t == null) {
                this.t = c1Var;
                this.f3935g.d(c1Var);
            }
            if (aVar != null && !this.u) {
                this.u = true;
                this.f3936h.R(0, aVar, new byte[0]);
            }
            Iterator<Map.Entry<Integer, f>> it = this.m.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, f> next = it.next();
                if (next.getKey().intValue() > i2) {
                    it.remove();
                    next.getValue().m.i(c1Var, aVar2, false, new n0());
                    r(next.getValue());
                }
            }
            Iterator<f> it2 = this.C.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                next2.m.i(c1Var, aVar2, true, new n0());
                r(next2);
            }
            this.C.clear();
            y();
        }
    }

    public final boolean w() {
        boolean z2 = false;
        while (!this.C.isEmpty() && this.m.size() < this.B) {
            x(this.C.poll());
            z2 = true;
        }
        return z2;
    }

    public final void x(f fVar) {
        f.b.a.c.b.o.b.G(fVar.f3931l == -1, "StreamId already assigned");
        this.m.put(Integer.valueOf(this.f3940l), fVar);
        u(fVar);
        f.b bVar = fVar.m;
        int i2 = this.f3940l;
        if (f.this.f3931l == -1) {
            f.this.f3931l = i2;
            f.b bVar2 = f.this.m;
            f.b.a.c.b.o.b.F(bVar2.f3649j != null);
            synchronized (bVar2.c) {
                f.b.a.c.b.o.b.G(!bVar2.f3686f, "Already allocated");
                bVar2.f3686f = true;
            }
            bVar2.d();
            c3 c3Var = bVar2.f3684d;
            c3Var.b++;
            c3Var.a.a();
            if (bVar.J) {
                b bVar3 = bVar.G;
                f fVar2 = f.this;
                bVar3.F(fVar2.p, false, fVar2.f3931l, 0, bVar.z);
                for (f1 f1Var : f.this.f3928i.a) {
                    Objects.requireNonNull((j) f1Var);
                }
                bVar.z = null;
                if (bVar.A.c > 0) {
                    bVar.H.a(bVar.B, f.this.f3931l, bVar.A, bVar.C);
                }
                bVar.J = false;
            }
            o0.c cVar = fVar.f3926g.a;
            if (!(cVar == o0.c.UNARY || cVar == o0.c.SERVER_STREAMING) || fVar.p) {
                this.f3936h.flush();
            }
            int i3 = this.f3940l;
            if (i3 >= 2147483645) {
                this.f3940l = Integer.MAX_VALUE;
                v(Integer.MAX_VALUE, h.a.k1.p.m.a.NO_ERROR, c1.n.g("Stream ids exhausted"));
                return;
            }
            this.f3940l = i3 + 2;
            return;
        }
        throw new IllegalStateException(t.b("the stream has been started with id %s", Integer.valueOf(i2)));
    }

    public final void y() {
        if (this.t != null && this.m.isEmpty() && this.C.isEmpty() && !this.w) {
            this.w = true;
            j1 j1Var = this.F;
            if (j1Var != null) {
                synchronized (j1Var) {
                    j1.e eVar = j1Var.f3731e;
                    j1.e eVar2 = j1.e.DISCONNECTED;
                    if (eVar != eVar2) {
                        j1Var.f3731e = eVar2;
                        ScheduledFuture<?> scheduledFuture = j1Var.f3732f;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        ScheduledFuture<?> scheduledFuture2 = j1Var.f3733g;
                        if (scheduledFuture2 != null) {
                            scheduledFuture2.cancel(false);
                            j1Var.f3733g = null;
                        }
                    }
                }
                t2.b(q0.n, this.E);
                this.E = null;
            }
            w0 w0Var = this.v;
            if (w0Var != null) {
                Throwable o2 = o();
                synchronized (w0Var) {
                    if (!w0Var.f3864d) {
                        w0Var.f3864d = true;
                        w0Var.f3865e = o2;
                        Map<w.a, Executor> map = w0Var.c;
                        w0Var.c = null;
                        for (Map.Entry<w.a, Executor> entry : map.entrySet()) {
                            w0.a(entry.getValue(), new v0(entry.getKey(), o2));
                        }
                    }
                }
                this.v = null;
            }
            if (!this.u) {
                this.u = true;
                this.f3936h.R(0, h.a.k1.p.m.a.NO_ERROR, new byte[0]);
            }
            this.f3936h.close();
        }
    }
}
