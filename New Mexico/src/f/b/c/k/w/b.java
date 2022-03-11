package f.b.c.k.w;

import f.b.a.c.b.o.b;
import f.b.a.c.i.d;
import f.b.a.c.i.h;
import f.b.c.k.w.n0;
import f.b.c.k.x.c;
import f.b.c.k.x.l;
import f.b.c.k.x.m;
import h.a.c1;
import h.a.f;
import h.a.k0;
import h.a.o0;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
/* loaded from: classes.dex */
public abstract class b<ReqT, RespT, CallbackT extends n0> {

    /* renamed from: l */
    public static final long f3637l;
    public static final long m;
    public static final long n;
    public static final long o;
    public c.b a;
    public final t b;
    public final o0<ReqT, RespT> c;

    /* renamed from: e */
    public final f.b.c.k.x.c f3639e;

    /* renamed from: f */
    public final c.d f3640f;

    /* renamed from: i */
    public f<ReqT, RespT> f3643i;

    /* renamed from: j */
    public final l f3644j;

    /* renamed from: k */
    public final CallbackT f3645k;

    /* renamed from: g */
    public m0 f3641g = m0.Initial;

    /* renamed from: h */
    public long f3642h = 0;

    /* renamed from: d */
    public final b<ReqT, RespT, CallbackT>.RunnableC0121b f3638d = new RunnableC0121b();

    /* loaded from: classes.dex */
    public class a {
        public final long a;

        public a(long j2) {
            b.this = r1;
            this.a = j2;
        }

        public void a(Runnable runnable) {
            b.this.f3639e.d();
            b bVar = b.this;
            if (bVar.f3642h == this.a) {
                runnable.run();
                return;
            }
            m.a(m.a.DEBUG, bVar.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
        }
    }

    /* renamed from: f.b.c.k.w.b$b */
    /* loaded from: classes.dex */
    public class RunnableC0121b implements Runnable {
        public RunnableC0121b() {
            b.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.c()) {
                bVar.a(m0.Initial, c1.f4087f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements d0<RespT> {
        public final b<ReqT, RespT, CallbackT>.a a;

        public c(b<ReqT, RespT, CallbackT>.a aVar) {
            b.this = r1;
            this.a = aVar;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f3637l = timeUnit.toMillis(1);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        m = timeUnit2.toMillis(1);
        n = timeUnit2.toMillis(1);
        o = timeUnit.toMillis(10);
    }

    public b(t tVar, o0<ReqT, RespT> o0Var, f.b.c.k.x.c cVar, c.d dVar, c.d dVar2, CallbackT callbackt) {
        this.b = tVar;
        this.c = o0Var;
        this.f3639e = cVar;
        this.f3640f = dVar2;
        this.f3645k = callbackt;
        this.f3644j = new l(cVar, dVar, f3637l, 1.5d, m);
    }

    public final void a(m0 m0Var, c1 c1Var) {
        m.a aVar = m.a.DEBUG;
        f.b.a.c.b.o.b.P0(d(), "Only started streams should be closed.", new Object[0]);
        m0 m0Var2 = m0.Error;
        f.b.a.c.b.o.b.P0(m0Var == m0Var2 || c1Var.equals(c1.f4087f), "Can't provide an error when not in an error state.", new Object[0]);
        this.f3639e.d();
        Set<String> set = j.f3656d;
        c1.b bVar = c1Var.a;
        Throwable th = c1Var.c;
        if (th instanceof SSLHandshakeException) {
            th.getMessage().contains("no ciphers available");
        }
        c.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.a();
            this.a = null;
        }
        l lVar = this.f3644j;
        c.b bVar3 = lVar.f3703h;
        if (bVar3 != null) {
            bVar3.a();
            lVar.f3703h = null;
        }
        this.f3642h++;
        c1.b bVar4 = c1Var.a;
        if (bVar4 == c1.b.OK) {
            this.f3644j.f3701f = 0;
        } else if (bVar4 == c1.b.RESOURCE_EXHAUSTED) {
            m.a(aVar, getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            l lVar2 = this.f3644j;
            lVar2.f3701f = lVar2.f3700e;
        } else if (bVar4 == c1.b.UNAUTHENTICATED) {
            this.b.b.b();
        } else if (bVar4 == c1.b.UNAVAILABLE) {
            Throwable th2 = c1Var.c;
            if ((th2 instanceof UnknownHostException) || (th2 instanceof ConnectException)) {
                this.f3644j.f3700e = o;
            }
        }
        if (m0Var != m0Var2) {
            m.a(aVar, getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            h();
        }
        if (this.f3643i != null) {
            if (c1Var.e()) {
                m.a(aVar, getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                this.f3643i.a();
            }
            this.f3643i = null;
        }
        this.f3641g = m0Var;
        this.f3645k.e(c1Var);
    }

    public void b() {
        f.b.a.c.b.o.b.P0(!d(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.f3639e.d();
        this.f3641g = m0.Initial;
        this.f3644j.f3701f = 0;
    }

    public boolean c() {
        this.f3639e.d();
        return this.f3641g == m0.Open;
    }

    public boolean d() {
        this.f3639e.d();
        m0 m0Var = this.f3641g;
        return m0Var == m0.Starting || m0Var == m0.Open || m0Var == m0.Backoff;
    }

    public void e() {
        if (c() && this.a == null) {
            this.a = this.f3639e.a(this.f3640f, n, this.f3638d);
        }
    }

    public abstract void f(RespT respt);

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c8, code lost:
        if (r1 > r3) goto L_0x00ca;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void g() {
        this.f3639e.d();
        f.b.a.c.b.o.b.P0(this.f3643i == null, "Last call still set", new Object[0]);
        f.b.a.c.b.o.b.P0(this.a == null, "Idle timer still set", new Object[0]);
        m0 m0Var = this.f3641g;
        m0 m0Var2 = m0.Error;
        if (m0Var == m0Var2) {
            f.b.a.c.b.o.b.P0(m0Var == m0Var2, "Should only perform backoff in an error state", new Object[0]);
            this.f3641g = m0.Backoff;
            l lVar = this.f3644j;
            a aVar = new Runnable(this) { // from class: f.b.c.k.w.a
                public final b b;

                {
                    this.b = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = this.b;
                    m0 m0Var3 = bVar.f3641g;
                    b.P0(m0Var3 == m0.Backoff, "State should still be backoff but was %s", m0Var3);
                    bVar.f3641g = m0.Initial;
                    bVar.g();
                    b.P0(bVar.d(), "Stream should have started", new Object[0]);
                }
            };
            c.b bVar = lVar.f3703h;
            if (bVar != null) {
                bVar.a();
                lVar.f3703h = null;
            }
            long random = lVar.f3701f + ((long) ((Math.random() - 0.5d) * ((double) lVar.f3701f)));
            long max = Math.max(0L, new Date().getTime() - lVar.f3702g);
            long max2 = Math.max(0L, random - max);
            if (lVar.f3701f > 0) {
                m.a(m.a.DEBUG, l.class.getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(max2), Long.valueOf(lVar.f3701f), Long.valueOf(random), Long.valueOf(max));
            }
            lVar.f3703h = lVar.a.a(lVar.b, max2, new Runnable(lVar, aVar) { // from class: f.b.c.k.x.k
                public final l b;
                public final Runnable c;

                {
                    this.b = r1;
                    this.c = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    l lVar2 = this.b;
                    Runnable runnable = this.c;
                    lVar2.f3702g = new Date().getTime();
                    runnable.run();
                }
            });
            long j2 = (long) (((double) lVar.f3701f) * 1.5d);
            lVar.f3701f = j2;
            long j3 = lVar.c;
            if (j2 >= j3) {
                j3 = lVar.f3700e;
            }
            lVar.f3701f = j3;
            lVar.f3700e = lVar.f3699d;
            return;
        }
        f.b.a.c.b.o.b.P0(m0Var == m0.Initial, "Already started", new Object[0]);
        c cVar = new c(new a(this.f3642h));
        t tVar = this.b;
        o0<ReqT, RespT> o0Var = this.c;
        Objects.requireNonNull(tVar);
        f[] fVarArr = {null};
        b0 b0Var = tVar.c;
        h<TContinuationResult> j4 = b0Var.a.j(b0Var.b.a, new f.b.a.c.i.a(b0Var, o0Var) { // from class: f.b.c.k.w.u
            public final b0 a;
            public final o0 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // f.b.a.c.i.a
            public Object a(h hVar) {
                b0 b0Var2 = this.a;
                return b.t0(((k0) hVar.l()).h(this.b, b0Var2.c));
            }
        });
        j4.c(tVar.a.a, new d(tVar, fVarArr, cVar) { // from class: f.b.c.k.w.p
            public final t a;
            public final f[] b;
            public final d0 c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007d: INVOKE  
                  (wrap: f.b.c.k.w.b<ReqT, RespT, CallbackT>$a : 0x0076: IGET  (r9v4 f.b.c.k.w.b<ReqT, RespT, CallbackT>$a A[REMOVE]) = (r2v1 'cVar2' f.b.c.k.w.b$c) f.b.c.k.w.b.c.a f.b.c.k.w.b$a)
                  (wrap: f.b.c.k.w.e : 0x007a: CONSTRUCTOR  (r0v2 f.b.c.k.w.e A[REMOVE]) = (r2v1 'cVar2' f.b.c.k.w.b$c) call: f.b.c.k.w.e.<init>(f.b.c.k.w.b$c):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.c.k.w.b.a.a(java.lang.Runnable):void in method: f.b.c.k.w.p.a(f.b.a.c.i.h):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.c.k.w.e, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 10 more
                */
            @Override // f.b.a.c.i.d
            public void a(f.b.a.c.i.h r9) {
                /*
                    r8 = this;
                    f.b.c.k.w.t r0 = r8.a
                    h.a.f[] r1 = r8.b
                    f.b.c.k.w.d0 r2 = r8.c
                    h.a.n0$f<java.lang.String> r3 = f.b.c.k.w.t.f3680f
                    java.lang.Object r9 = r9.l()
                    h.a.f r9 = (h.a.f) r9
                    r3 = 0
                    r1[r3] = r9
                    r9 = r1[r3]
                    f.b.c.k.w.q r4 = new f.b.c.k.w.q
                    r4.<init>(r0, r2, r1)
                    java.util.Objects.requireNonNull(r0)
                    h.a.n0 r5 = new h.a.n0
                    r5.<init>()
                    h.a.n0$f<java.lang.String> r6 = f.b.c.k.w.t.f3680f
                    java.lang.String r7 = "gl-java/ fire/21.6.0 grpc/"
                    r5.h(r6, r7)
                    h.a.n0$f<java.lang.String> r6 = f.b.c.k.w.t.f3681g
                    java.lang.String r7 = r0.f3682d
                    r5.h(r6, r7)
                    f.b.c.k.w.c0 r0 = r0.f3683e
                    if (r0 == 0) goto L_0x0071
                    f.b.c.k.w.l r0 = (f.b.c.k.w.l) r0
                    f.b.c.m.a<f.b.c.l.c> r6 = r0.a
                    java.lang.Object r6 = r6.get()
                    if (r6 == 0) goto L_0x0071
                    f.b.c.m.a<f.b.c.n.f> r6 = r0.b
                    java.lang.Object r6 = r6.get()
                    if (r6 != 0) goto L_0x0045
                    goto L_0x0071
                L_0x0045:
                    f.b.c.m.a<f.b.c.l.c> r6 = r0.a
                    java.lang.Object r6 = r6.get()
                    f.b.c.l.c r6 = (f.b.c.l.c) r6
                    java.lang.String r7 = "fire-fst"
                    f.b.c.l.c$a r6 = r6.a(r7)
                    int r6 = r6.b
                    if (r6 == 0) goto L_0x0071
                    h.a.n0$f<java.lang.String> r7 = f.b.c.k.w.l.c
                    java.lang.String r6 = java.lang.Integer.toString(r6)
                    r5.h(r7, r6)
                    h.a.n0$f<java.lang.String> r6 = f.b.c.k.w.l.f3657d
                    f.b.c.m.a<f.b.c.n.f> r0 = r0.b
                    java.lang.Object r0 = r0.get()
                    f.b.c.n.f r0 = (f.b.c.n.f) r0
                    java.lang.String r0 = r0.a()
                    r5.h(r6, r0)
                L_0x0071:
                    r9.d(r4, r5)
                    f.b.c.k.w.b$c r2 = (f.b.c.k.w.b.c) r2
                    f.b.c.k.w.b<ReqT, RespT, CallbackT>$a r9 = r2.a
                    f.b.c.k.w.e r0 = new f.b.c.k.w.e
                    r0.<init>(r2)
                    r9.a(r0)
                    r9 = r1[r3]
                    r0 = 1
                    r9.b(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.c.k.w.p.a(f.b.a.c.i.h):void");
            }
        });
        this.f3643i = new s(tVar, fVarArr, j4);
        this.f3641g = m0.Starting;
    }

    public void h() {
    }

    public void i(ReqT reqt) {
        this.f3639e.d();
        m.a(m.a.DEBUG, getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), reqt);
        c.b bVar = this.a;
        if (bVar != null) {
            bVar.a();
            this.a = null;
        }
        this.f3643i.c(reqt);
    }
}
