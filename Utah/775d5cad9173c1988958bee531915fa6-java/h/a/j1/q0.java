package h.a.j1;

import f.b.b.a.c;
import f.b.b.a.s;
import f.b.b.a.u;
import f.b.b.f.a.b0;
import h.a.c;
import h.a.c1;
import h.a.d0;
import h.a.e0;
import h.a.h0;
import h.a.j;
import h.a.j1.t2;
import h.a.j1.v;
import h.a.n0;
import h.a.o0;
import h.a.y0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class q0 {
    public static final Logger a = Logger.getLogger(q0.class.getName());
    public static final n0.f<Long> b = n0.f.a("grpc-timeout", new h());
    public static final n0.f<String> c;

    /* renamed from: d  reason: collision with root package name */
    public static final n0.f<byte[]> f4032d = e0.a("grpc-accept-encoding", new f(null));

    /* renamed from: e  reason: collision with root package name */
    public static final n0.f<String> f4033e;

    /* renamed from: f  reason: collision with root package name */
    public static final n0.f<byte[]> f4034f = e0.a("accept-encoding", new f(null));

    /* renamed from: g  reason: collision with root package name */
    public static final n0.f<String> f4035g;

    /* renamed from: h  reason: collision with root package name */
    public static final n0.f<String> f4036h;

    /* renamed from: i  reason: collision with root package name */
    public static final n0.f<String> f4037i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f4038j;

    /* renamed from: k  reason: collision with root package name */
    public static final y0 f4039k = new i2();

    /* renamed from: l  reason: collision with root package name */
    public static final c.a<Boolean> f4040l = c.a.a("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
    public static final t2.c<Executor> m = new b();
    public static final t2.c<ScheduledExecutorService> n = new c();
    public static final u<s> o = new d();

    public class a implements y0 {
    }

    public class b implements t2.c<Executor> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.a.j1.t2.c
        public Executor a() {
            return Executors.newCachedThreadPool(q0.d("grpc-default-executor-%d", true));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.j1.t2.c
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    public class c implements t2.c<ScheduledExecutorService> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.a.j1.t2.c
        public ScheduledExecutorService a() {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, q0.d("grpc-timer-%d", true));
            try {
                newScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(newScheduledThreadPool, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
            return Executors.unconfigurableScheduledExecutorService(newScheduledThreadPool);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.j1.t2.c
        public void b(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }
    }

    public class d implements u<s> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // f.b.b.a.u
        public s get() {
            return new s();
        }
    }

    public class e implements w {
        public final /* synthetic */ w a;
        public final /* synthetic */ j.a b;

        public e(w wVar, j.a aVar) {
            this.a = wVar;
            this.b = aVar;
        }

        @Override // h.a.c0
        public d0 c() {
            return this.a.c();
        }

        @Override // h.a.j1.w
        public u g(o0<?, ?> o0Var, n0 n0Var, h.a.c cVar) {
            return this.a.g(o0Var, n0Var, cVar.f(this.b));
        }
    }

    public static final class f implements e0.a<byte[]> {
        public f(a aVar) {
        }

        @Override // h.a.n0.i
        public byte[] a(Object obj) {
            return (byte[]) obj;
        }

        @Override // h.a.n0.i
        public Object b(byte[] bArr) {
            return bArr;
        }
    }

    /* JADX WARN: Init of enum d can be incorrect */
    /* JADX WARN: Init of enum e can be incorrect */
    /* JADX WARN: Init of enum f can be incorrect */
    /* JADX WARN: Init of enum g can be incorrect */
    /* JADX WARN: Init of enum h can be incorrect */
    /* JADX WARN: Init of enum i can be incorrect */
    /* JADX WARN: Init of enum j can be incorrect */
    /* JADX WARN: Init of enum k can be incorrect */
    /* JADX WARN: Init of enum m can be incorrect */
    /* JADX WARN: Init of enum n can be incorrect */
    public enum g {
        NO_ERROR(0, r1),
        PROTOCOL_ERROR(1, r4),
        INTERNAL_ERROR(2, r4),
        FLOW_CONTROL_ERROR(3, r4),
        SETTINGS_TIMEOUT(4, r4),
        STREAM_CLOSED(5, r4),
        FRAME_SIZE_ERROR(6, r4),
        REFUSED_STREAM(7, r1),
        CANCEL(8, c1.f3833g),
        COMPRESSION_ERROR(9, r4),
        CONNECT_ERROR(10, r4),
        ENHANCE_YOUR_CALM(11, c1.f3838l.g("Bandwidth exhausted")),
        INADEQUATE_SECURITY(12, c1.f3836j.g("Permission denied as protocol is not secure enough to call")),
        HTTP_1_1_REQUIRED(13, c1.f3834h);
        
        public static final g[] r;
        public final int b;
        public final c1 c;

        /* access modifiers changed from: public */
        static {
            c1 c1Var = c1.n;
            c1 c1Var2 = c1.m;
            g[] values = values();
            g[] gVarArr = new g[(((int) ((long) values[13].b)) + 1)];
            for (g gVar : values) {
                gVarArr[(int) ((long) gVar.b)] = gVar;
            }
            r = gVarArr;
        }

        /* access modifiers changed from: public */
        g(int i2, c1 c1Var) {
            this.b = i2;
            StringBuilder h2 = f.a.a.a.a.h("HTTP/2 error code: ");
            h2.append(name());
            this.c = c1Var.a(h2.toString());
        }
    }

    public static class h implements n0.d<Long> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.n0.d
        public String a(Long l2) {
            StringBuilder sb;
            String str;
            Long l3 = l2;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l3.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            } else if (l3.longValue() < 100000000) {
                return l3 + "n";
            } else {
                if (l3.longValue() < 100000000000L) {
                    sb = new StringBuilder();
                    sb.append(timeUnit.toMicros(l3.longValue()));
                    str = "u";
                } else if (l3.longValue() < 100000000000000L) {
                    sb = new StringBuilder();
                    sb.append(timeUnit.toMillis(l3.longValue()));
                    str = "m";
                } else if (l3.longValue() < 100000000000000000L) {
                    sb = new StringBuilder();
                    sb.append(timeUnit.toSeconds(l3.longValue()));
                    str = "S";
                } else {
                    int i2 = (l3.longValue() > 6000000000000000000L ? 1 : (l3.longValue() == 6000000000000000000L ? 0 : -1));
                    sb = new StringBuilder();
                    long longValue = l3.longValue();
                    if (i2 < 0) {
                        sb.append(timeUnit.toMinutes(longValue));
                        str = "M";
                    } else {
                        sb.append(timeUnit.toHours(longValue));
                        str = "H";
                    }
                }
                sb.append(str);
                return sb.toString();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.a.n0.d
        public Long b(String str) {
            TimeUnit timeUnit;
            f.b.a.c.b.o.b.o(str.length() > 0, "empty timeout");
            f.b.a.c.b.o.b.o(str.length() <= 9, "bad timeout format");
            long parseLong = Long.parseLong(str.substring(0, str.length() - 1));
            char charAt = str.charAt(str.length() - 1);
            if (charAt == 'H') {
                timeUnit = TimeUnit.HOURS;
            } else if (charAt == 'M') {
                timeUnit = TimeUnit.MINUTES;
            } else if (charAt == 'S') {
                timeUnit = TimeUnit.SECONDS;
            } else if (charAt == 'u') {
                timeUnit = TimeUnit.MICROSECONDS;
            } else if (charAt == 'm') {
                timeUnit = TimeUnit.MILLISECONDS;
            } else if (charAt == 'n') {
                return Long.valueOf(parseLong);
            } else {
                throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(charAt)));
            }
            return Long.valueOf(timeUnit.toNanos(parseLong));
        }
    }

    static {
        Charset.forName("US-ASCII");
        n0.d<String> dVar = n0.c;
        c = n0.f.a("grpc-encoding", dVar);
        f4033e = n0.f.a("content-encoding", dVar);
        f4035g = n0.f.a("content-type", dVar);
        f4036h = n0.f.a("te", dVar);
        f4037i = n0.f.a("user-agent", dVar);
        c.C0102c cVar = c.C0102c.b;
        Objects.requireNonNull(c.d.c);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f4038j = timeUnit.toNanos(20);
        TimeUnit.HOURS.toNanos(2);
        timeUnit.toNanos(20);
    }

    public static URI a(String str) {
        f.b.a.c.b.o.b.z(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException(f.a.a.a.a.w("Invalid authority: ", str), e2);
        }
    }

    public static void b(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e2) {
            a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e2);
        }
    }

    public static String c(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(inetSocketAddress, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory d(String str, boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        String.format(Locale.ROOT, str, 0);
        return new b0(Executors.defaultThreadFactory(), str, new AtomicLong(0), valueOf, null, null);
    }

    public static w e(h0.e eVar, boolean z) {
        h0.h hVar = eVar.a;
        w b2 = hVar != null ? ((b3) hVar.c()).b() : null;
        if (b2 != null) {
            j.a aVar = eVar.b;
            if (aVar == null) {
                return b2;
            }
            return new e(b2, aVar);
        }
        if (!eVar.c.e()) {
            if (eVar.f3856d) {
                return new j0(eVar.c, v.a.DROPPED);
            }
            if (!z) {
                return new j0(eVar.c, v.a.PROCESSED);
            }
        }
        return null;
    }

    public static c1 f(int i2) {
        c1.b bVar;
        if ((i2 < 100 || i2 >= 200) && i2 != 400) {
            if (i2 == 401) {
                bVar = c1.b.UNAUTHENTICATED;
            } else if (i2 == 403) {
                bVar = c1.b.PERMISSION_DENIED;
            } else if (i2 != 404) {
                if (i2 != 429) {
                    if (i2 != 431) {
                        switch (i2) {
                            case 502:
                            case 503:
                            case 504:
                                break;
                            default:
                                bVar = c1.b.UNKNOWN;
                                break;
                        }
                    }
                }
                bVar = c1.b.UNAVAILABLE;
            } else {
                bVar = c1.b.UNIMPLEMENTED;
            }
            c1 a2 = bVar.a();
            return a2.g("HTTP status code " + i2);
        }
        bVar = c1.b.INTERNAL;
        c1 a22 = bVar.a();
        return a22.g("HTTP status code " + i2);
    }
}
