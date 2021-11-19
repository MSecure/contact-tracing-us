package com.bugfender.sdk.a.a;

import android.util.Log;
import com.bugfender.android.BuildConfig;
import com.bugfender.sdk.a.a.h.c;
import com.bugfender.sdk.a.a.h.d;
import com.bugfender.sdk.a.a.h.f;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.h.h;
import com.bugfender.sdk.a.a.l.a.i;
import com.bugfender.sdk.a.a.l.a.k;
import com.bugfender.sdk.a.a.l.a.l;
import com.bugfender.sdk.a.a.m.a;
import com.bugfender.sdk.a.c.c;
import com.google.android.gms.measurement.AppMeasurement;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class b {
    private static final int A = 1;
    private static final int B = 2;
    public static final String C = "$package_id";
    public static final String D = "$android_id";
    public static final String E = "Bugfender-SDK";
    private static final Runnable F = new d();
    private static final long x = 52428800;
    public static final long y = 5242880;
    private static final int z = 0;
    private final String a;
    private final ScheduledExecutorService b;
    private final com.bugfender.sdk.a.c.c c;
    private final ExecutorService d;
    private final ExecutorService e;
    private final com.bugfender.sdk.a.a.m.a f;
    private final String g;
    private final String h;
    private final com.bugfender.sdk.a.a.j.b i;
    private final com.bugfender.sdk.a.a.g.a<String> j;
    private final com.bugfender.sdk.a.a.e.h.a k;
    private final com.bugfender.sdk.a.a.e.f.a l;
    private final com.bugfender.sdk.a.a.i.a m;
    private final com.bugfender.sdk.a.c.j.a n;
    private com.bugfender.sdk.a.f.b o;
    private volatile com.bugfender.sdk.a.a.h.d p;
    private h q;
    private volatile boolean r = false;
    private volatile boolean s = false;
    private volatile boolean t = false;
    private final List<Callable<?>> u;
    private long v = y;
    private AtomicLong w = new AtomicLong();

    class a implements c.AbstractC0018c {
        a() {
        }

        @Override // com.bugfender.sdk.a.c.c.AbstractC0018c
        public void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
            b bVar = b.this;
            threadPoolExecutor.submit(bVar.a((b) bVar.b(g.c.D, "bf_log_memory_pressure", "Bugfender received a memory warning. New incoming logs will be discarded until the logs pending to be processed are reduced.")));
        }
    }

    /* renamed from: com.bugfender.sdk.a.a.b$b  reason: collision with other inner class name */
    class RunnableC0000b implements Runnable {
        RunnableC0000b() {
        }

        public void run() {
            if (b.this.o == null) {
                com.bugfender.sdk.a.a.j.c<String> e = b.this.i.e();
                b.this.o = com.bugfender.sdk.a.f.b.a(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements a<com.bugfender.sdk.a.a.h.d> {
        c() {
        }

        public void a(com.bugfender.sdk.a.a.h.d dVar) {
            b.this.p = new d.b(dVar).a();
        }

        @Override // com.bugfender.sdk.a.a.a
        public void a(Throwable th) {
            if (th instanceof com.bugfender.sdk.a.a.d.b.a) {
                b.this.s();
            } else if (b.this.p == null) {
                b.this.p = com.bugfender.sdk.a.a.h.d.d;
            }
        }
    }

    static class d implements Runnable {
        d() {
        }

        public void run() {
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements Runnable {
        final /* synthetic */ h a;

        /* renamed from: com.bugfender.sdk.a.a.b$e$b  reason: collision with other inner class name */
        class RunnableC0001b implements Runnable {
            RunnableC0001b() {
            }

            public void run() {
                b.this.m();
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                b.this.g();
            }
        }

        e(h hVar) {
            this.a = hVar;
        }

        public void run() {
            boolean z;
            try {
                b.this.p = (com.bugfender.sdk.a.a.h.d) b.this.l().get(60, TimeUnit.SECONDS);
            } catch (com.bugfender.sdk.a.a.d.b.a | InterruptedException | ExecutionException | TimeoutException e) {
                if (e.getCause() instanceof com.bugfender.sdk.a.a.d.b.a) {
                    b.this.s();
                } else {
                    b.this.p = com.bugfender.sdk.a.a.h.d.d;
                }
            }
            try {
                z = ((Boolean) b.this.b((b) this.a).get()).booleanValue();
            } catch (InterruptedException | ExecutionException e2) {
                e2.printStackTrace();
                z = false;
            }
            if (20200525 < b.this.p.a()) {
                Log.d(b.E, "There's a new Bugfender SDK version. Please check bugfender.com.");
            }
            if (z) {
                try {
                    b.this.h().get();
                    if (b.this.k.a() && b.this.p.c()) {
                        b.this.r().get();
                    }
                } catch (InterruptedException | ExecutionException e3) {
                    e3.printStackTrace();
                }
                b.this.f.a(com.bugfender.sdk.a.a.m.a.b, new a());
                b.this.b.scheduleWithFixedDelay(new RunnableC0001b(), 5, 10, TimeUnit.SECONDS);
                b.this.b.scheduleWithFixedDelay(new c(), 0, 5, TimeUnit.MINUTES);
                b.this.a(new f(b.C, b.this.l.b()));
                b.this.a(new f(b.D, b.this.l.f()));
                b.this.r = true;
                return;
            }
            b.this.r = false;
            Log.e(b.E, "Bugfender SDK initialization has failed.");
        }

        class a extends a.b {
            a() {
            }

            /* access modifiers changed from: protected */
            @Override // com.bugfender.sdk.a.a.m.a.b
            public void a(long j) {
                b.this.f.a();
                b.this.f.a(j, new a.C0013a(this));
            }

            @Override // com.bugfender.sdk.a.a.m.a.b
            public void b() {
                boolean z = b.this.p != null && b.this.p.c();
                boolean a = b.this.k.a();
                if ((a && z) || (a && b.this.s)) {
                    a((l) b.this.q().get());
                    a((l) b.this.r().get());
                }
                if (a) {
                    a((l) b.this.p().get());
                    a((l) b.this.o().get());
                    a((l) b.this.n().get());
                }
            }

            private void a(l<?> lVar) {
                if (lVar.b() instanceof com.bugfender.sdk.a.a.d.b.c) {
                    b.this.p = com.bugfender.sdk.a.a.h.d.d;
                } else if (lVar.b() instanceof com.bugfender.sdk.a.a.d.b.d) {
                    throw new com.bugfender.sdk.a.a.i.c.a.a();
                }
            }
        }
    }

    public b(String str, com.bugfender.sdk.a.a.j.b bVar, com.bugfender.sdk.a.a.i.a aVar, com.bugfender.sdk.a.a.g.a<String> aVar2, com.bugfender.sdk.a.a.e.h.a aVar3, com.bugfender.sdk.a.a.e.f.a aVar4, com.bugfender.sdk.a.c.j.a aVar5, String str2) {
        this.g = str;
        this.i = bVar;
        this.j = aVar2;
        this.k = aVar3;
        this.l = aVar4;
        this.m = aVar;
        this.n = aVar5;
        this.h = str2;
        this.b = Executors.newSingleThreadScheduledExecutor();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        this.d = newFixedThreadPool;
        this.c = new com.bugfender.sdk.a.c.c((ThreadPoolExecutor) newFixedThreadPool, 5000, 20, new a());
        this.e = Executors.newFixedThreadPool(1);
        this.f = new com.bugfender.sdk.a.a.m.a();
        this.u = new CopyOnWriteArrayList();
        this.a = w();
        b(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void s() {
        this.c.a();
        this.e.shutdown();
        this.b.shutdown();
    }

    private void t() {
        this.p = new d.b(this.p).a(true).a();
        if (this.r) {
            i();
            q();
            p();
            o();
        }
    }

    private com.bugfender.sdk.a.a.h.c u() {
        return new c.b().j(this.l.a()).e(this.l.a(this.h)).c(this.l.e()).f(this.l.p()).k(this.l.h()).b(this.l.c()).d(this.l.n()).i(this.l.k()).g(this.l.o()).b(this.l.l()).a(this.l.d()).a(this.g).h(String.valueOf((int) BuildConfig.VERSION_CODE)).a(this.l.g()).a();
    }

    private Map<Integer, String> v() {
        StackTraceElement[] stackTrace;
        StackTraceElement a2;
        HashMap hashMap = new HashMap(3);
        hashMap.put(0, "");
        hashMap.put(1, "");
        hashMap.put(2, String.valueOf(0));
        if (!this.t && ((a2 = a((stackTrace = Thread.currentThread().getStackTrace()))) != null || stackTrace.length >= 6)) {
            if (a2 == null) {
                a2 = stackTrace[6];
            }
            String fileName = a2.getFileName();
            hashMap.put(0, a2.getClassName() + "." + a2.getMethodName());
            hashMap.put(1, fileName);
            hashMap.put(2, String.valueOf(a2.getLineNumber()));
        }
        return hashMap;
    }

    private String w() {
        if (b.class.getPackage() == null) {
            return null;
        }
        String[] split = b.class.getPackage().getName().split(Pattern.quote("."));
        if (split.length <= 1) {
            return split[0];
        }
        return split[0] + "." + split[1];
    }

    private void x() {
        for (Callable<?> callable : this.u) {
            this.c.a(callable);
        }
        this.u.clear();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Future<com.bugfender.sdk.a.a.h.d> l() {
        return this.e.submit(new com.bugfender.sdk.a.a.l.a.c(this.m, u(), this.j));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m() {
        if (this.u.size() > 0) {
            x();
        }
        i();
        h();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Future<l<Boolean>> n() {
        return this.e.submit(new com.bugfender.sdk.a.a.l.a.o.b(this.m, this.j, u()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Future<l<Integer>> o() {
        return this.e.submit(new com.bugfender.sdk.a.a.l.a.m.a(this.i, this.m, this.g, this.l, this.p));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Future<l<Boolean>> p() {
        return this.e.submit(new com.bugfender.sdk.a.a.l.a.n.b(this.i, this.m, this.g));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Future<l<Boolean>> q() {
        return this.e.submit(new com.bugfender.sdk.a.a.l.a.p.b(this.i, this.m));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Future<l<Boolean>> r() {
        return this.e.submit(new com.bugfender.sdk.a.a.l.a.p.c(this.m, this.i, this.g, new com.bugfender.sdk.a.a.l.a.m.a(this.i, this.m, this.g, this.l, this.p)));
    }

    public void b(String str, String str2) {
        a(g.c.d, str, str2);
    }

    public void c(String str, String str2) {
        a(g.c.F, str, str2);
    }

    public void d(String str, String str2) {
        a(g.c.I, str, str2);
    }

    public URL e(String str, String str2) {
        return this.n.b(a(str, str2, AppMeasurement.CRASH_ORIGIN, "bf_issue").toString());
    }

    public UUID f(String str, String str2) {
        return a(str, str2, (String) null, "bf_issue");
    }

    public URL g(String str, String str2) {
        return this.n.b(f(str, str2).toString());
    }

    public UUID h(String str, String str2) {
        return a(str, str2, "user-feedback", "bf_issue");
    }

    public URL i(String str, String str2) {
        return this.n.b(h(str, str2).toString());
    }

    public void j(String str, String str2) {
        a(g.c.e, str, str2);
    }

    public void k(String str, String str2) {
        a(g.c.c, str, str2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g() {
        this.e.submit(new com.bugfender.sdk.a.a.l.a.d(this.m, u(), this.j, new c()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Future<Boolean> h() {
        return this.e.submit(new com.bugfender.sdk.a.a.l.a.b(this.i, this.v, this.w));
    }

    private void i() {
        k();
        j();
    }

    private void j() {
        this.c.a(new com.bugfender.sdk.a.a.l.a.n.a(this.i));
    }

    private void k() {
        this.c.a(new com.bugfender.sdk.a.a.l.a.p.a(this.i));
    }

    public void b(boolean z2) {
        this.s = z2;
        if (z2 && this.k.a()) {
            t();
        }
    }

    public String c() {
        return this.l.a();
    }

    public URL d() {
        return this.n.a(c());
    }

    public String e() {
        h hVar = this.q;
        if (hVar != null) {
            return hVar.l();
        }
        return null;
    }

    public URL f() {
        String e2 = e();
        if (e2 != null) {
            return this.n.c(e2);
        }
        return null;
    }

    public void a(long j2) {
        if (j2 <= 0 || j2 > x) {
            j2 = 52428800;
        }
        this.v = j2;
    }

    public void b() {
        if (this.k.a()) {
            t();
        }
    }

    public void a(String str, String str2) {
        a(g.c.D, str, str2);
    }

    private void a(g.c cVar, String str, String str2) {
        a(a(b(cVar, str, str2)));
    }

    private void b(String str) {
        h a2 = a(str, System.currentTimeMillis());
        this.q = a2;
        a(a2);
    }

    public void a(int i2, String str, String str2, g.c cVar, String str3, String str4) {
        a(a(new g.b().c(str3).d(str4).b(str).a(new Date()).a(this.w.getAndIncrement()).a(str2).a(cVar.a()).b(i2).e(String.valueOf(Thread.currentThread().getId())).f(Thread.currentThread().getName()).a()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Future<Boolean> b(h hVar) {
        return this.c.a(new k(this.i, hVar));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private g b(g.c cVar, String str, String str2) {
        Map<Integer, String> v2 = v();
        Date date = new Date(System.currentTimeMillis());
        String name = Thread.currentThread().getName();
        return new g.b().c(str).d(str2).b(v2.get(0)).a(date).a(this.w.getAndIncrement()).a(v2.get(1)).a(cVar.a()).b(Integer.valueOf(v2.get(2)).intValue()).f(name).e(String.valueOf(Thread.currentThread().getId())).a();
    }

    private UUID a(String str, String str2, String str3, String str4) {
        UUID a2 = com.bugfender.sdk.a.a.e.e.a(c());
        com.bugfender.sdk.a.a.h.e a3 = com.bugfender.sdk.a.a.h.e.h().a(a2).c(str).b(str2).d(str3).a();
        a(new com.bugfender.sdk.a.a.l.a.a(this.i, new com.bugfender.sdk.a.a.l.a.g(this.i), a3, this.m, new com.bugfender.sdk.a.a.l.a.f(), this.w));
        a(g.c.F, str4, a2.toString());
        return a2;
    }

    public <T> void a(f<T> fVar) {
        this.e.submit(new com.bugfender.sdk.a.a.l.a.o.c(this.j, fVar));
        a(a(new g.b().c("bf_key_value").d("Set device data \"" + fVar.a() + "\"=\"" + ((Object) fVar.b()) + "\"").b("").a(new Date()).a(this.w.getAndIncrement()).a("").a(g.c.D.a()).b(0).a()));
    }

    public void a(String str) {
        this.e.submit(new com.bugfender.sdk.a.a.l.a.o.a(this.j, this.m, u(), str));
    }

    public void a() {
        this.b.submit(new RunnableC0000b());
    }

    public void a(boolean z2) {
        this.t = z2;
    }

    private void a(h hVar) {
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        ((ThreadPoolExecutor) this.e).setRejectedExecutionHandler(discardPolicy);
        ((ThreadPoolExecutor) this.d).setRejectedExecutionHandler(discardPolicy);
        this.b.execute(new e(hVar));
    }

    private void a(Callable<?> callable) {
        if (this.r) {
            if (this.u.size() > 0) {
                x();
            }
            this.c.a(callable);
            return;
        }
        this.u.add(callable);
        if (this.u.size() > 500) {
            this.u.clear();
        }
    }

    private h a(String str, long j2) {
        return new h.a().b(j2).a(new com.bugfender.sdk.a.a.h.b(new com.bugfender.sdk.a.a.h.a(str), this.l.h(), this.l.c())).a(this.l.j()).a(u()).a(this.l.i()).a(this.l.n()).a(this.l.s()).b(this.l.p()).c(this.l.m()).c(this.l.o()).e(this.l.r()).e(this.l.k()).a(new Date()).d(com.bugfender.sdk.a.a.e.d.b(UUID.fromString(c())).toString()).a();
    }

    private StackTraceElement a(StackTraceElement[] stackTraceElementArr) {
        if (this.a != null) {
            if (stackTraceElementArr.length > 4) {
                for (int i2 = 4; i2 < stackTraceElementArr.length; i2++) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    if (!stackTraceElement.getClassName().startsWith(this.a)) {
                        return stackTraceElement;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Callable<Boolean> a(g gVar) {
        return new com.bugfender.sdk.a.a.l.a.a(this.i, new com.bugfender.sdk.a.a.l.a.h(this.i), gVar, this.m, new i(), this.w);
    }
}
