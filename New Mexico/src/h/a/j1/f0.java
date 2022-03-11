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
/* loaded from: classes.dex */
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
    public final AtomicReference<e> f4185d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final String f4186e;

    /* renamed from: f  reason: collision with root package name */
    public final String f4187f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4188g;

    /* renamed from: h  reason: collision with root package name */
    public final t2.c<Executor> f4189h;

    /* renamed from: i  reason: collision with root package name */
    public final long f4190i;

    /* renamed from: j  reason: collision with root package name */
    public final g1 f4191j;

    /* renamed from: k  reason: collision with root package name */
    public final s f4192k;

    /* renamed from: l  reason: collision with root package name */
    public c f4193l;
    public boolean m;
    public Executor n;
    public final boolean o;
    public final boolean p;
    public final q0.g q;
    public boolean r;
    public q0.e s;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public enum b implements a {
        INSTANCE
    }

    /* loaded from: classes.dex */
    public static final class c {
        public final List<? extends InetAddress> a;
        public final List<String> b;
        public final List<v> c;

        public c(List<? extends InetAddress> list, List<String> list2, List<v> list3) {
            f.b.a.c.b.o.b.A(list, "addresses");
            this.a = Collections.unmodifiableList(list);
            f.b.a.c.b.o.b.A(list2, "txtRecords");
            this.b = Collections.unmodifiableList(list2);
            f.b.a.c.b.o.b.A(list3, "balancerAddresses");
            this.c = Collections.unmodifiableList(list3);
        }

        public String toString() {
            k u1 = f.b.a.c.b.o.b.u1(this);
            u1.d("addresses", this.a);
            u1.d("txtRecords", this.b);
            u1.d("balancerAddresses", this.c);
            return u1.toString();
        }
    }

    /* loaded from: classes.dex */
    public final class d implements Runnable {
        public final q0.e b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f0.this.r = false;
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public final /* synthetic */ c b;

            public b(c cVar) {
                this.b = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f0 f0Var = f0.this;
                f0Var.f4193l = this.b;
                if (f0Var.f4190i > 0) {
                    s sVar = f0Var.f4192k;
                    sVar.b();
                    sVar.c();
                }
            }
        }

        public d(q0.e eVar) {
            f.b.a.c.b.o.b.A(eVar, "savedListener");
            this.b = eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0094 A[Catch: Exception -> 0x01f4, TryCatch #5 {Exception -> 0x01f4, blocks: (B:11:0x0052, B:14:0x005f, B:17:0x0068, B:21:0x0074, B:23:0x007a, B:31:0x008d, B:32:0x008e, B:33:0x0091, B:35:0x0094, B:37:0x00a0, B:39:0x00a4, B:41:0x00aa, B:43:0x00da), top: B:95:0x0052 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[Catch: Exception -> 0x01f4, TRY_LEAVE, TryCatch #5 {Exception -> 0x01f4, blocks: (B:11:0x0052, B:14:0x005f, B:17:0x0068, B:21:0x0074, B:23:0x007a, B:31:0x008d, B:32:0x008e, B:33:0x0091, B:35:0x0094, B:37:0x00a0, B:39:0x00a4, B:41:0x00aa, B:43:0x00da), top: B:95:0x0052 }] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x010b A[LOOP:1: B:45:0x0105->B:47:0x010b, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01d4  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void a() {
            e eVar;
            c h2;
            Logger logger;
            q0.b bVar;
            f fVar;
            f0 f0Var = f0.this;
            try {
                x0 a2 = f0.this.a.a(InetSocketAddress.createUnresolved(f0Var.f4187f, f0Var.f4188g));
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
                    String str = f0.this.f4187f;
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
                            eVar = f0.this.f4185d.get();
                            if (eVar == null && (fVar = f0.B) != null) {
                                eVar = fVar.a();
                            }
                        } else {
                            eVar = null;
                        }
                        a aVar2 = f0.this.c;
                        f0 f0Var2 = f0.this;
                        h2 = f0.h(aVar2, eVar, f0Var2.p, f0.A, f0Var2.f4187f);
                        g1 g1Var = f0.this.f4191j;
                        b bVar3 = new b(h2);
                        Queue<Runnable> queue = g1Var.c;
                        f.b.a.c.b.o.b.A(bVar3, "runnable is null");
                        queue.add(bVar3);
                        g1Var.a();
                        logger = f0.t;
                        if (logger.isLoggable(Level.FINER)) {
                            logger.finer("Found DNS results " + h2 + " for " + f0.this.f4187f);
                        }
                        ArrayList arrayList = new ArrayList();
                        for (InetAddress inetAddress : h2.a) {
                            arrayList.add(new v(Collections.singletonList(new InetSocketAddress(inetAddress, f0.this.f4188g)), h.a.a.b));
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
                                        bVar = new q0.b(c1.f4089h.g("failed to pick service config choice").f(e3));
                                    }
                                }
                                bVar = map == null ? null : new q0.b(map);
                            } catch (IOException | RuntimeException e4) {
                                bVar = new q0.b(c1.f4089h.g("failed to parse TXT records").f(e4));
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
                            f0.t.log(Level.FINE, "No TXT records found for {0}", new Object[]{f0.this.f4187f});
                        }
                        this.b.b(new q0.f(arrayList, a3.a(), bVar2));
                    }
                    z2 = false;
                    if (!z2) {
                    }
                    a aVar22 = f0.this.c;
                    f0 f0Var22 = f0.this;
                    h2 = f0.h(aVar22, eVar, f0Var22.p, f0.A, f0Var22.f4187f);
                    g1 g1Var2 = f0.this.f4191j;
                    b bVar32 = new b(h2);
                    Queue<Runnable> queue2 = g1Var2.c;
                    f.b.a.c.b.o.b.A(bVar32, "runnable is null");
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
                    StringBuilder h3 = f.a.a.a.a.h("Unable to resolve host ");
                    h3.append(f0.this.f4187f);
                    eVar2.a(c1Var2.g(h3.toString()).f(e5));
                }
            } catch (IOException e6) {
                q0.e eVar3 = this.b;
                c1 c1Var3 = c1.n;
                StringBuilder h4 = f.a.a.a.a.h("Unable to resolve host ");
                h4.append(f0.this.f4187f);
                eVar3.a(c1Var3.g(h4.toString()).f(e6));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger logger = f0.t;
            if (logger.isLoggable(Level.FINER)) {
                StringBuilder h2 = f.a.a.a.a.h("Attempting DNS resolution of ");
                h2.append(f0.this.f4187f);
                logger.finer(h2.toString());
            }
            try {
                a();
            } finally {
                g1 g1Var = f0.this.f4191j;
                a aVar = new a();
                Queue<Runnable> queue = g1Var.c;
                f.b.a.c.b.o.b.A(aVar, "runnable is null");
                queue.add(aVar);
                g1Var.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        List<v> a(a aVar, String str);

        List<String> b(String str);
    }

    /* loaded from: classes.dex */
    public interface f {
        e a();

        Throwable b();
    }

    static {
        String str;
        Level level;
        Throwable e2;
        f fVar;
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
        f fVar2 = null;
        try {
            try {
                try {
                    fVar = (f) Class.forName("h.a.j1.g1", true, f0.class.getClassLoader()).asSubclass(f.class).getConstructor(new Class[0]).newInstance(new Object[0]);
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
        } catch (ClassCastException e5) {
            e2 = e5;
            logger = t;
            level = Level.FINE;
            str = "Unable to cast JndiResourceResolverFactory, skipping.";
        } catch (ClassNotFoundException e6) {
            e2 = e6;
            logger = t;
            level = Level.FINE;
            str = "Unable to find JndiResourceResolverFactory, skipping.";
        }
        if (fVar.b() != null) {
            level = Level.FINE;
            e2 = fVar.b();
            str = "JndiResourceResolverFactory not available, skipping.";
            logger.log(level, str, e2);
            B = fVar2;
        }
        fVar2 = fVar;
        B = fVar2;
    }

    /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;Ljava/lang/String;Lh/a/q0$a;Lh/a/j1/t2$c<Ljava/util/concurrent/Executor;>;Lf/b/b/a/s;ZZ)V */
    public f0(String str, q0.a aVar, t2.c cVar, s sVar, boolean z2, boolean z3) {
        int i2;
        f.b.a.c.b.o.b.A(aVar, "args");
        this.f4189h = cVar;
        StringBuilder sb = new StringBuilder();
        sb.append("//");
        f.b.a.c.b.o.b.A(str, "name");
        sb.append(str);
        URI create = URI.create(sb.toString());
        boolean z4 = true;
        f.b.a.c.b.o.b.t(create.getHost() != null, "Invalid DNS name: %s", str);
        String authority = create.getAuthority();
        f.b.a.c.b.o.b.B(authority, "nameUri (%s) doesn't have an authority", create);
        this.f4186e = authority;
        this.f4187f = create.getHost();
        if (create.getPort() == -1) {
            i2 = aVar.a;
        } else {
            i2 = create.getPort();
        }
        this.f4188g = i2;
        y0 y0Var = aVar.b;
        f.b.a.c.b.o.b.A(y0Var, "proxyDetector");
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
        this.f4190i = j2;
        f.b.a.c.b.o.b.A(sVar, "stopwatch");
        this.f4192k = sVar;
        g1 g1Var = aVar.c;
        f.b.a.c.b.o.b.A(g1Var, "syncContext");
        this.f4191j = g1Var;
        Executor executor = aVar.f4549g;
        this.n = executor;
        this.o = executor != null ? false : z4;
        this.p = z3;
        q0.g gVar = aVar.f4546d;
        f.b.a.c.b.o.b.A(gVar, "serviceConfigParser");
        this.q = gVar;
    }

    public static Map<String, ?> e(Map<String, ?> map, Random random, String str) {
        boolean z2;
        boolean z3;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            f.b.a.c.b.o.b.x1(u.contains(entry.getKey()), "Bad key: %s", entry);
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
            f.b.a.c.b.o.b.x1(intValue >= 0 && intValue <= 100, "Bad percentage: %s", d2);
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
        List emptyList = Collections.emptyList();
        List<v> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        Exception e3 = null;
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
                    e = e5;
                }
            }
            e = null;
            if (z3) {
                boolean z4 = true;
                boolean z5 = !z2 || e != null;
                if (e2 == null || !z5) {
                    z4 = false;
                }
                if (!z4) {
                    try {
                        emptyList3 = eVar.b("_grpc_config." + str);
                    } catch (Exception e6) {
                        e3 = e6;
                    }
                }
            }
            e3 = e;
            exc = e3;
        } else {
            exc = null;
        }
        if (e2 != null) {
            if (e3 == null) {
                try {
                    if (!emptyList2.isEmpty()) {
                    }
                } catch (Throwable th) {
                    Logger logger = t;
                    Level level = Level.FINE;
                    logger.log(level, "Address resolution failure", (Throwable) e2);
                    if (e3 != null) {
                        logger.log(level, "Balancer resolution failure", (Throwable) e3);
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
        if (e3 != null) {
            t.log(Level.FINE, "Balancer resolution failure", (Throwable) e3);
        }
        if (exc != null) {
            t.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) exc);
        }
        return new c(emptyList, emptyList3, emptyList2);
    }

    @Override // h.a.q0
    public String a() {
        return this.f4186e;
    }

    @Override // h.a.q0
    public void b() {
        f.b.a.c.b.o.b.G(this.s != null, "not started");
        g();
    }

    @Override // h.a.q0
    public void c() {
        if (!this.m) {
            this.m = true;
            Executor executor = this.n;
            if (executor != null && this.o) {
                t2.b(this.f4189h, executor);
                this.n = null;
            }
        }
    }

    @Override // h.a.q0
    public void d(q0.e eVar) {
        f.b.a.c.b.o.b.G(this.s == null, "already started");
        if (this.o) {
            this.n = (Executor) t2.a(this.f4189h);
        }
        f.b.a.c.b.o.b.A(eVar, "listener");
        this.s = eVar;
        g();
    }

    public final void g() {
        int i2;
        if (!this.r && !this.m) {
            if (this.f4193l == null || this.f4190i == 0 || (i2 > 0 && this.f4192k.a(TimeUnit.NANOSECONDS) > this.f4190i)) {
                this.r = true;
                this.n.execute(new d(this.s));
            }
        }
    }
}
