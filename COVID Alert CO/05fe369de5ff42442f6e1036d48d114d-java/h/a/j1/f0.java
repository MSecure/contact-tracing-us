package h.a.j1;

import f.b.b.a.k;
import f.b.b.a.s;
import f.b.b.a.w;
import h.a.a;
import h.a.c1;
import h.a.g1;
import h.a.j1.t2;
import h.a.q0;
import h.a.v;
import h.a.x0;
import h.a.y0;
import java.io.IOException;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class f0 extends q0 {
    public static boolean A;
    public static final f B;
    public static String C;
    public static final Logger t;
    public static final Set<String> u = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));
    public static final String v;
    public static final String w;
    public static final String x;
    public static boolean y;
    public static boolean z;
    public final y0 a;
    public final Random b = new Random();
    public volatile a c = b.INSTANCE;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<e> f3865d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final String f3866e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3867f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3868g;

    /* renamed from: h  reason: collision with root package name */
    public final t2.c<Executor> f3869h;

    /* renamed from: i  reason: collision with root package name */
    public final long f3870i;

    /* renamed from: j  reason: collision with root package name */
    public final g1 f3871j;

    /* renamed from: k  reason: collision with root package name */
    public final s f3872k;

    /* renamed from: l  reason: collision with root package name */
    public c f3873l;
    public boolean m;
    public Executor n;
    public final boolean o;
    public final boolean p;
    public final q0.g q;
    public boolean r;
    public q0.e s;

    public interface a {
    }

    public enum b implements a {
        INSTANCE
    }

    public static final class c {
        public final List<? extends InetAddress> a;
        public final List<String> b;
        public final List<v> c;

        public c(List<? extends InetAddress> list, List<String> list2, List<v> list3) {
            f.b.a.c.b.o.b.z(list, "addresses");
            this.a = Collections.unmodifiableList(list);
            f.b.a.c.b.o.b.z(list2, "txtRecords");
            this.b = Collections.unmodifiableList(list2);
            f.b.a.c.b.o.b.z(list3, "balancerAddresses");
            this.c = Collections.unmodifiableList(list3);
        }

        public String toString() {
            k q1 = f.b.a.c.b.o.b.q1(this);
            q1.d("addresses", this.a);
            q1.d("txtRecords", this.b);
            q1.d("balancerAddresses", this.c);
            return q1.toString();
        }
    }

    public final class d implements Runnable {
        public final q0.e b;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                f0.this.r = false;
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ c b;

            public b(c cVar) {
                this.b = cVar;
            }

            public void run() {
                f0 f0Var = f0.this;
                f0Var.f3873l = this.b;
                if (f0Var.f3870i > 0) {
                    s sVar = f0Var.f3872k;
                    sVar.b();
                    sVar.c();
                }
            }
        }

        public d(q0.e eVar) {
            f.b.a.c.b.o.b.z(eVar, "savedListener");
            this.b = eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x0094 A[Catch:{ Exception -> 0x01f4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00a9 A[Catch:{ Exception -> 0x01f4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00da A[Catch:{ Exception -> 0x01f4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x010b A[LOOP:1: B:45:0x0105->B:47:0x010b, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x013a  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0149  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01d4  */
        public void a() {
            e eVar;
            c h2;
            Logger logger;
            q0.b bVar;
            f fVar;
            f0 f0Var = f0.this;
            try {
                x0 a2 = f0.this.a.a(InetSocketAddress.createUnresolved(f0Var.f3867f, f0Var.f3868g));
                q0.b bVar2 = null;
                if (a2 != null) {
                    Logger logger2 = f0.t;
                    if (logger2.isLoggable(Level.FINER)) {
                        logger2.finer("Using proxy address " + a2);
                    }
                    h.a.a aVar = h.a.a.b;
                    v vVar = new v(Collections.singletonList(a2), aVar);
                    Collections.emptyList();
                    this.b.b(new q0.f(Collections.singletonList(vVar), aVar, null));
                    return;
                }
                try {
                    boolean z = f0.y;
                    boolean z2 = f0.z;
                    String str = f0.this.f3867f;
                    if (z) {
                        if (!"localhost".equalsIgnoreCase(str)) {
                            if (!str.contains(":")) {
                                boolean z3 = true;
                                for (int i2 = 0; i2 < str.length(); i2++) {
                                    char charAt = str.charAt(i2);
                                    if (charAt != '.') {
                                        z3 &= charAt >= '0' && charAt <= '9';
                                    }
                                }
                                z2 = !z3;
                            }
                        }
                        if (!z2) {
                            eVar = f0.this.f3865d.get();
                            if (eVar == null && (fVar = f0.B) != null) {
                                eVar = fVar.a();
                            }
                        } else {
                            eVar = null;
                        }
                        a aVar2 = f0.this.c;
                        f0 f0Var2 = f0.this;
                        h2 = f0.h(aVar2, eVar, f0Var2.p, f0.A, f0Var2.f3867f);
                        g1 g1Var = f0.this.f3871j;
                        b bVar3 = new b(h2);
                        Queue<Runnable> queue = g1Var.c;
                        f.b.a.c.b.o.b.z(bVar3, "runnable is null");
                        queue.add(bVar3);
                        g1Var.a();
                        logger = f0.t;
                        if (logger.isLoggable(Level.FINER)) {
                            logger.finer("Found DNS results " + h2 + " for " + f0.this.f3867f);
                        }
                        ArrayList arrayList = new ArrayList();
                        for (InetAddress inetAddress : h2.a) {
                            arrayList.add(new v(Collections.singletonList(new InetSocketAddress(inetAddress, f0.this.f3868g)), h.a.a.b));
                        }
                        Collections.emptyList();
                        h.a.a aVar3 = h.a.a.b;
                        a.b a3 = h.a.a.a();
                        if (!h2.c.isEmpty()) {
                            a3.b(p0.b, h2.c);
                        }
                        if (h2.b.isEmpty()) {
                            List<String> list = h2.b;
                            Random random = f0.this.b;
                            if (f0.C == null) {
                                try {
                                    f0.C = InetAddress.getLocalHost().getHostName();
                                } catch (UnknownHostException e2) {
                                    throw new RuntimeException(e2);
                                }
                            }
                            String str2 = f0.C;
                            try {
                                Iterator it = ((ArrayList) f0.f(list)).iterator();
                                Map<String, ?> map = null;
                                while (it.hasNext()) {
                                    try {
                                        map = f0.e((Map) it.next(), random, str2);
                                        if (map != null) {
                                            break;
                                        }
                                    } catch (RuntimeException e3) {
                                        bVar = new q0.b(c1.f3769h.g("failed to pick service config choice").f(e3));
                                    }
                                }
                                bVar = map == null ? null : new q0.b(map);
                            } catch (IOException | RuntimeException e4) {
                                bVar = new q0.b(c1.f3769h.g("failed to parse TXT records").f(e4));
                            }
                            if (bVar != null) {
                                c1 c1Var = bVar.a;
                                if (c1Var != null) {
                                    this.b.a(c1Var);
                                    return;
                                }
                                Map<String, ?> map2 = (Map) bVar.b;
                                bVar2 = f0.this.q.a(map2);
                                a3.b(p0.a, map2);
                            }
                        } else {
                            f0.t.log(Level.FINE, "No TXT records found for {0}", new Object[]{f0.this.f3867f});
                        }
                        this.b.b(new q0.f(arrayList, a3.a(), bVar2));
                    }
                    z2 = false;
                    if (!z2) {
                    }
                    a aVar22 = f0.this.c;
                    f0 f0Var22 = f0.this;
                    h2 = f0.h(aVar22, eVar, f0Var22.p, f0.A, f0Var22.f3867f);
                    g1 g1Var2 = f0.this.f3871j;
                    b bVar32 = new b(h2);
                    Queue<Runnable> queue2 = g1Var2.c;
                    f.b.a.c.b.o.b.z(bVar32, "runnable is null");
                    queue2.add(bVar32);
                    g1Var2.a();
                    logger = f0.t;
                    if (logger.isLoggable(Level.FINER)) {
                    }
                    ArrayList arrayList2 = new ArrayList();
                    while (r3.hasNext()) {
                    }
                    Collections.emptyList();
                    h.a.a aVar32 = h.a.a.b;
                    a.b a32 = h.a.a.a();
                    if (!h2.c.isEmpty()) {
                    }
                    if (h2.b.isEmpty()) {
                    }
                    this.b.b(new q0.f(arrayList2, a32.a(), bVar2));
                } catch (Exception e5) {
                    q0.e eVar2 = this.b;
                    c1 c1Var2 = c1.n;
                    StringBuilder i3 = f.a.a.a.a.i("Unable to resolve host ");
                    i3.append(f0.this.f3867f);
                    eVar2.a(c1Var2.g(i3.toString()).f(e5));
                }
            } catch (IOException e6) {
                q0.e eVar3 = this.b;
                c1 c1Var3 = c1.n;
                StringBuilder i4 = f.a.a.a.a.i("Unable to resolve host ");
                i4.append(f0.this.f3867f);
                eVar3.a(c1Var3.g(i4.toString()).f(e6));
            }
        }

        public void run() {
            Logger logger = f0.t;
            if (logger.isLoggable(Level.FINER)) {
                StringBuilder i2 = f.a.a.a.a.i("Attempting DNS resolution of ");
                i2.append(f0.this.f3867f);
                logger.finer(i2.toString());
            }
            try {
                a();
            } finally {
                g1 g1Var = f0.this.f3871j;
                a aVar = new a();
                Queue<Runnable> queue = g1Var.c;
                f.b.a.c.b.o.b.z(aVar, "runnable is null");
                queue.add(aVar);
                g1Var.a();
            }
        }
    }

    public interface e {
        List<v> a(a aVar, String str);

        List<String> b(String str);
    }

    public interface f {
        e a();

        Throwable b();
    }

    static {
        String str;
        Level level;
        Throwable e2;
        Logger logger = Logger.getLogger(f0.class.getName());
        t = logger;
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        v = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        w = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        x = property3;
        y = Boolean.parseBoolean(property);
        z = Boolean.parseBoolean(property2);
        A = Boolean.parseBoolean(property3);
        f fVar = null;
        try {
            try {
                try {
                    f fVar2 = (f) Class.forName("h.a.j1.g1", true, f0.class.getClassLoader()).asSubclass(f.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (fVar2.b() != null) {
                        level = Level.FINE;
                        e2 = fVar2.b();
                        str = "JndiResourceResolverFactory not available, skipping.";
                        logger.log(level, str, e2);
                        B = fVar;
                    }
                    fVar = fVar2;
                    B = fVar;
                } catch (Exception e3) {
                    e2 = e3;
                    logger = t;
                    level = Level.FINE;
                    str = "Can't construct JndiResourceResolverFactory, skipping.";
                }
            } catch (Exception e4) {
                e2 = e4;
                logger = t;
                level = Level.FINE;
                str = "Can't find JndiResourceResolverFactory ctor, skipping.";
            }
        } catch (ClassNotFoundException e5) {
            e2 = e5;
            logger = t;
            level = Level.FINE;
            str = "Unable to find JndiResourceResolverFactory, skipping.";
        } catch (ClassCastException e6) {
            e2 = e6;
            logger = t;
            level = Level.FINE;
            str = "Unable to cast JndiResourceResolverFactory, skipping.";
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;Ljava/lang/String;Lh/a/q0$a;Lh/a/j1/t2$c<Ljava/util/concurrent/Executor;>;Lf/b/b/a/s;ZZ)V */
    public f0(String str, q0.a aVar, t2.c cVar, s sVar, boolean z2, boolean z3) {
        int i2;
        f.b.a.c.b.o.b.z(aVar, "args");
        this.f3869h = cVar;
        StringBuilder sb = new StringBuilder();
        sb.append("//");
        f.b.a.c.b.o.b.z(str, "name");
        sb.append(str);
        URI create = URI.create(sb.toString());
        boolean z4 = true;
        f.b.a.c.b.o.b.s(create.getHost() != null, "Invalid DNS name: %s", str);
        String authority = create.getAuthority();
        f.b.a.c.b.o.b.A(authority, "nameUri (%s) doesn't have an authority", create);
        this.f3866e = authority;
        this.f3867f = create.getHost();
        if (create.getPort() == -1) {
            i2 = aVar.a;
        } else {
            i2 = create.getPort();
        }
        this.f3868g = i2;
        y0 y0Var = aVar.b;
        f.b.a.c.b.o.b.z(y0Var, "proxyDetector");
        this.a = y0Var;
        long j2 = 0;
        if (!z2) {
            String property = System.getProperty("networkaddress.cache.ttl");
            long j3 = 30;
            if (property != null) {
                try {
                    j3 = Long.parseLong(property);
                } catch (NumberFormatException unused) {
                    t.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
                }
            }
            j2 = j3 > 0 ? TimeUnit.SECONDS.toNanos(j3) : j3;
        }
        this.f3870i = j2;
        f.b.a.c.b.o.b.z(sVar, "stopwatch");
        this.f3872k = sVar;
        g1 g1Var = aVar.c;
        f.b.a.c.b.o.b.z(g1Var, "syncContext");
        this.f3871j = g1Var;
        Executor executor = aVar.f4229g;
        this.n = executor;
        this.o = executor != null ? false : z4;
        this.p = z3;
        q0.g gVar = aVar.f4226d;
        f.b.a.c.b.o.b.z(gVar, "serviceConfigParser");
        this.q = gVar;
    }

    public static Map<String, ?> e(Map<String, ?> map, Random random, String str) {
        boolean z2;
        boolean z3;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            f.b.a.c.b.o.b.t1(u.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> c2 = i1.c(map, "clientLanguage");
        if (c2 != null && !c2.isEmpty()) {
            Iterator<String> it = c2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if ("java".equalsIgnoreCase(it.next())) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            if (!z3) {
                return null;
            }
        }
        Double d2 = i1.d(map, "percentage");
        if (d2 != null) {
            int intValue = d2.intValue();
            f.b.a.c.b.o.b.t1(intValue >= 0 && intValue <= 100, "Bad percentage: %s", d2);
            if (random.nextInt(100) >= intValue) {
                return null;
            }
        }
        List<String> c3 = i1.c(map, "clientHostname");
        if (c3 != null && !c3.isEmpty()) {
            Iterator<String> it2 = c3.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().equals(str)) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                return null;
            }
        }
        Map<String, ?> f2 = i1.f(map, "serviceConfig");
        if (f2 != null) {
            return f2;
        }
        throw new w(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
    }

    public static List<Map<String, ?>> f(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.startsWith("grpc_config=")) {
                t.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            } else {
                String substring = str.substring(12);
                Logger logger = h1.a;
                f.b.e.a.a aVar = new f.b.e.a.a(new StringReader(substring));
                try {
                    Object a2 = h1.a(aVar);
                    if (a2 instanceof List) {
                        List list2 = (List) a2;
                        i1.a(list2);
                        arrayList.addAll(list2);
                    } else {
                        throw new ClassCastException("wrong type " + a2);
                    }
                } finally {
                    try {
                        aVar.close();
                    } catch (IOException e2) {
                        h1.a.log(Level.WARNING, "Failed to close", (Throwable) e2);
                    }
                }
            }
        }
        return arrayList;
    }

    public static c h(a aVar, e eVar, boolean z2, boolean z3, String str) {
        Exception e2;
        Exception exc;
        Exception e3;
        List emptyList = Collections.emptyList();
        List<v> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        Exception exc2 = null;
        try {
            Objects.requireNonNull((b) aVar);
            emptyList = Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
            e2 = null;
        } catch (Exception e4) {
            e2 = e4;
        }
        if (eVar != null) {
            if (z2) {
                try {
                    emptyList2 = eVar.a(aVar, "_grpclb._tcp." + str);
                } catch (Exception e5) {
                    e3 = e5;
                }
            }
            e3 = null;
            if (z3) {
                boolean z4 = true;
                boolean z5 = !z2 || e3 != null;
                if (e2 == null || !z5) {
                    z4 = false;
                }
                if (!z4) {
                    try {
                        emptyList3 = eVar.b("_grpc_config." + str);
                    } catch (Exception e6) {
                        exc2 = e6;
                    }
                }
            }
            exc2 = e3;
            exc = exc2;
        } else {
            exc = null;
        }
        if (e2 != null) {
            if (exc2 == null) {
                try {
                    if (!emptyList2.isEmpty()) {
                    }
                } catch (Throwable th) {
                    Logger logger = t;
                    Level level = Level.FINE;
                    logger.log(level, "Address resolution failure", (Throwable) e2);
                    if (exc2 != null) {
                        logger.log(level, "Balancer resolution failure", (Throwable) exc2);
                    }
                    if (exc != null) {
                        logger.log(level, "ServiceConfig resolution failure", (Throwable) exc);
                    }
                    throw th;
                }
            }
            f.b.b.a.v.c(e2);
            throw new RuntimeException(e2);
        }
        if (e2 != null) {
            t.log(Level.FINE, "Address resolution failure", (Throwable) e2);
        }
        if (exc2 != null) {
            t.log(Level.FINE, "Balancer resolution failure", (Throwable) exc2);
        }
        if (exc != null) {
            t.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) exc);
        }
        return new c(emptyList, emptyList3, emptyList2);
    }

    @Override // h.a.q0
    public String a() {
        return this.f3866e;
    }

    @Override // h.a.q0
    public void b() {
        f.b.a.c.b.o.b.F(this.s != null, "not started");
        g();
    }

    @Override // h.a.q0
    public void c() {
        if (!this.m) {
            this.m = true;
            Executor executor = this.n;
            if (executor != null && this.o) {
                t2.b(this.f3869h, executor);
                this.n = null;
            }
        }
    }

    @Override // h.a.q0
    public void d(q0.e eVar) {
        f.b.a.c.b.o.b.F(this.s == null, "already started");
        if (this.o) {
            this.n = (Executor) t2.a(this.f3869h);
        }
        f.b.a.c.b.o.b.z(eVar, "listener");
        this.s = eVar;
        g();
    }

    public final void g() {
        int i2;
        if (!this.r && !this.m) {
            if (this.f3873l == null || this.f3870i == 0 || (i2 > 0 && this.f3872k.a(TimeUnit.NANOSECONDS) > this.f3870i)) {
                this.r = true;
                this.n.execute(new d(this.s));
            }
        }
    }
}
