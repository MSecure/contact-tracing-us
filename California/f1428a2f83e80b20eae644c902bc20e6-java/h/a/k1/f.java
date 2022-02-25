package h.a.k1;

import h.a.c1;
import h.a.e0;
import h.a.f0;
import h.a.f1;
import h.a.j;
import h.a.j1.a;
import h.a.j1.a3;
import h.a.j1.c3;
import h.a.j1.d;
import h.a.j1.k2;
import h.a.j1.q0;
import h.a.j1.t0;
import h.a.j1.v;
import h.a.j1.w2;
import h.a.n0;
import h.a.o0;
import h.b.c;
import h.b.d;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.e;
import k.h;

public class f extends h.a.j1.a {
    public static final e q = new e();

    /* renamed from: g  reason: collision with root package name */
    public final o0<?, ?> f3822g;

    /* renamed from: h  reason: collision with root package name */
    public final String f3823h;

    /* renamed from: i  reason: collision with root package name */
    public final w2 f3824i;

    /* renamed from: j  reason: collision with root package name */
    public String f3825j;

    /* renamed from: k  reason: collision with root package name */
    public Object f3826k;

    /* renamed from: l  reason: collision with root package name */
    public volatile int f3827l;
    public final b m;
    public final a n;
    public final h.a.a o;
    public boolean p;

    public class a implements a.b {
        public a() {
        }

        public void a(n0 n0Var, byte[] bArr) {
            h.b.a aVar = c.a;
            Objects.requireNonNull(aVar);
            String str = "/" + f.this.f3822g.b;
            if (bArr != null) {
                f.this.p = true;
                StringBuilder i2 = f.a.a.a.a.i(str, "?");
                i2.append(f.b.b.c.a.a.c(bArr));
                str = i2.toString();
            }
            try {
                synchronized (f.this.m.y) {
                    b.l(f.this.m, n0Var, str);
                }
                Objects.requireNonNull(aVar);
            } catch (Throwable th) {
                Objects.requireNonNull(c.a);
                throw th;
            }
        }
    }

    public class b extends t0 {
        public e A = new e();
        public boolean B = false;
        public boolean C = false;
        public boolean D = false;
        public int E;
        public int F;
        public final b G;
        public final n H;
        public final g I;
        public boolean J = true;
        public final d K;
        public final int x;
        public final Object y;
        public List<h.a.k1.p.m.d> z;

        public b(int i2, w2 w2Var, Object obj, b bVar, n nVar, g gVar, int i3, String str) {
            super(i2, w2Var, f.this.a);
            f.b.a.c.b.o.b.A(obj, "lock");
            this.y = obj;
            this.G = bVar;
            this.H = nVar;
            this.I = gVar;
            this.E = i3;
            this.F = i3;
            this.x = i3;
            Objects.requireNonNull(c.a);
            this.K = h.b.a.a;
        }

        public static void l(b bVar, n0 n0Var, String str) {
            boolean z2;
            f fVar = f.this;
            String str2 = fVar.f3825j;
            String str3 = fVar.f3823h;
            boolean z3 = fVar.p;
            boolean z4 = bVar.I.z == null;
            h.a.k1.p.m.d dVar = c.a;
            f.b.a.c.b.o.b.A(n0Var, "headers");
            f.b.a.c.b.o.b.A(str, "defaultPath");
            f.b.a.c.b.o.b.A(str2, "authority");
            n0Var.b(q0.f3712g);
            n0Var.b(q0.f3713h);
            n0.f<String> fVar2 = q0.f3714i;
            n0Var.b(fVar2);
            ArrayList arrayList = new ArrayList(n0Var.b + 7);
            arrayList.add(z4 ? c.b : c.a);
            arrayList.add(z3 ? c.f3809d : c.c);
            arrayList.add(new h.a.k1.p.m.d(h.a.k1.p.m.d.f3913h, str2));
            arrayList.add(new h.a.k1.p.m.d(h.a.k1.p.m.d.f3911f, str));
            arrayList.add(new h.a.k1.p.m.d(fVar2.b, str3));
            arrayList.add(c.f3810e);
            arrayList.add(c.f3811f);
            Logger logger = a3.a;
            Charset charset = e0.a;
            int i2 = n0Var.b * 2;
            byte[][] bArr = new byte[i2][];
            Object[] objArr = n0Var.a;
            if (objArr instanceof byte[][]) {
                System.arraycopy(objArr, 0, bArr, 0, i2);
            } else {
                for (int i3 = 0; i3 < n0Var.b; i3++) {
                    int i4 = i3 * 2;
                    bArr[i4] = n0Var.g(i3);
                    bArr[i4 + 1] = n0Var.k(i3);
                }
            }
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6 += 2) {
                byte[] bArr2 = bArr[i6];
                byte[] bArr3 = bArr[i6 + 1];
                if (a3.a(bArr2, a3.b)) {
                    bArr[i5] = bArr2;
                    bArr[i5 + 1] = e0.b.c(bArr3).getBytes(f.b.b.a.d.a);
                } else {
                    int length = bArr3.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length) {
                            z2 = true;
                            break;
                        }
                        byte b = bArr3[i7];
                        if (b < 32 || b > 126) {
                            z2 = false;
                        } else {
                            i7++;
                        }
                    }
                    if (z2) {
                        bArr[i5] = bArr2;
                        bArr[i5 + 1] = bArr3;
                    } else {
                        String str4 = new String(bArr2, f.b.b.a.d.a);
                        Logger logger2 = a3.a;
                        StringBuilder j2 = f.a.a.a.a.j("Metadata key=", str4, ", value=");
                        j2.append(Arrays.toString(bArr3));
                        j2.append(" contains invalid ASCII characters");
                        logger2.warning(j2.toString());
                    }
                }
                i5 += 2;
            }
            if (i5 != i2) {
                bArr = (byte[][]) Arrays.copyOfRange(bArr, 0, i5);
            }
            for (int i8 = 0; i8 < bArr.length; i8 += 2) {
                h f2 = h.f(bArr[i8]);
                String q = f2.q();
                if (!q.startsWith(":") && !q0.f3712g.b.equalsIgnoreCase(q) && !q0.f3714i.b.equalsIgnoreCase(q)) {
                    arrayList.add(new h.a.k1.p.m.d(f2, h.f(bArr[i8 + 1])));
                }
            }
            bVar.z = arrayList;
            g gVar = bVar.I;
            f fVar3 = f.this;
            c1 c1Var = gVar.t;
            if (c1Var != null) {
                fVar3.m.i(c1Var, v.a.REFUSED, true, new n0());
            } else if (gVar.m.size() >= gVar.B) {
                gVar.C.add(fVar3);
                gVar.u(fVar3);
            } else {
                gVar.x(fVar3);
            }
        }

        public static void m(b bVar, e eVar, boolean z2, boolean z3) {
            if (!bVar.D) {
                if (bVar.J) {
                    bVar.A.h(eVar, (long) ((int) eVar.c));
                    bVar.B |= z2;
                    bVar.C |= z3;
                    return;
                }
                f.b.a.c.b.o.b.G(f.this.f3827l != -1, "streamId should be set");
                bVar.H.a(z2, f.this.f3827l, eVar, z3);
            }
        }

        @Override // h.a.j1.z1.b
        public void b(Throwable th) {
            n(c1.d(th), true, new n0());
        }

        @Override // h.a.j1.f.i
        public void c(Runnable runnable) {
            synchronized (this.y) {
                runnable.run();
            }
        }

        @Override // h.a.j1.a.c, h.a.j1.z1.b
        public void e(boolean z2) {
            v.a aVar = v.a.PROCESSED;
            if (!this.o) {
                g gVar = this.I;
                int i2 = f.this.f3827l;
                synchronized (gVar.f3834j) {
                    f remove = gVar.m.remove(Integer.valueOf(i2));
                    if (remove != null) {
                        gVar.f3832h.T(i2, h.a.k1.p.m.a.CANCEL);
                        if (!gVar.w()) {
                            gVar.y();
                            gVar.r(remove);
                        }
                    }
                }
            } else {
                this.I.k(f.this.f3827l, null, aVar, false, null, null);
            }
            f.b.a.c.b.o.b.G(this.p, "status should have been reported on deframer closed");
            this.m = true;
            if (this.q && z2) {
                i(c1.m.g("Encountered end-of-stream mid-frame"), aVar, true, new n0());
            }
            Runnable runnable = this.n;
            if (runnable != null) {
                runnable.run();
                this.n = null;
            }
        }

        @Override // h.a.j1.z1.b
        public void f(int i2) {
            int i3 = this.F - i2;
            this.F = i3;
            int i4 = this.x;
            if (((float) i3) <= ((float) i4) * 0.5f) {
                int i5 = i4 - i3;
                this.E += i5;
                this.F = i3 + i5;
                this.G.u(f.this.f3827l, (long) i5);
            }
        }

        public final void n(c1 c1Var, boolean z2, n0 n0Var) {
            v.a aVar = v.a.PROCESSED;
            if (!this.D) {
                this.D = true;
                if (this.J) {
                    g gVar = this.I;
                    f fVar = f.this;
                    gVar.C.remove(fVar);
                    gVar.r(fVar);
                    this.z = null;
                    this.A.c();
                    this.J = false;
                    if (n0Var == null) {
                        n0Var = new n0();
                    }
                    i(c1Var, aVar, true, n0Var);
                    return;
                }
                g gVar2 = this.I;
                int i2 = f.this.f3827l;
                synchronized (gVar2.f3834j) {
                    f remove = gVar2.m.remove(Integer.valueOf(i2));
                    if (remove != null) {
                        gVar2.f3832h.T(i2, h.a.k1.p.m.a.CANCEL);
                        if (c1Var != null) {
                            b bVar = remove.m;
                            if (n0Var == null) {
                                n0Var = new n0();
                            }
                            bVar.i(c1Var, aVar, z2, n0Var);
                        }
                        if (!gVar2.w()) {
                            gVar2.y();
                            gVar2.r(remove);
                        }
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
        public void o(e eVar, boolean z2) {
            n0 n0Var;
            c1 c1Var;
            Throwable th;
            v.a aVar = v.a.PROCESSED;
            int i2 = this.E - ((int) eVar.c);
            this.E = i2;
            if (i2 < 0) {
                this.G.T(f.this.f3827l, h.a.k1.p.m.a.FLOW_CONTROL_ERROR);
                this.I.k(f.this.f3827l, c1.m.g("Received data size exceeded our receiving window size"), aVar, false, null, null);
                return;
            }
            j jVar = new j(eVar);
            c1 c1Var2 = this.r;
            boolean z3 = false;
            if (c1Var2 != null) {
                StringBuilder h2 = f.a.a.a.a.h("DATA-----------------------------\n");
                Charset charset = this.t;
                int i3 = k2.a;
                f.b.a.c.b.o.b.A(charset, "charset");
                f.b.a.c.b.o.b.A(jVar, "buffer");
                int b = jVar.b();
                byte[] bArr = new byte[b];
                jVar.O(bArr, 0, b);
                h2.append(new String(bArr, charset));
                this.r = c1Var2.a(h2.toString());
                jVar.b.c();
                if (this.r.b.length() > 1000 || z2) {
                    c1Var = this.r;
                    n0Var = this.s;
                } else {
                    return;
                }
            } else if (!this.u) {
                c1Var = c1.m.g("headers not received before payload");
                n0Var = new n0();
            } else {
                f.b.a.c.b.o.b.A(jVar, "frame");
                try {
                    if (this.p) {
                        h.a.j1.a.f3538f.log(Level.INFO, "Received data on closed stream");
                        jVar.b.c();
                    } else {
                        try {
                            this.b.P(jVar);
                        } catch (Throwable th2) {
                            th = th2;
                            if (z3) {
                                jVar.b.c();
                            }
                            throw th;
                        }
                    }
                    if (z2) {
                        this.r = c1.m.g("Received unexpected EOS on DATA frame from server.");
                        n0 n0Var2 = new n0();
                        this.s = n0Var2;
                        i(this.r, aVar, false, n0Var2);
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    z3 = true;
                    if (z3) {
                    }
                    throw th;
                }
            }
            n(c1Var, false, n0Var);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
        public void p(List<h.a.k1.p.m.d> list, boolean z2) {
            c1 c1Var;
            StringBuilder sb;
            c1 a;
            c1 c1Var2;
            String str;
            if (z2) {
                byte[][] a2 = o.a(list);
                Charset charset = e0.a;
                n0 n0Var = new n0(a2);
                f.b.a.c.b.o.b.A(n0Var, "trailers");
                if (this.r == null && !this.u) {
                    c1 k2 = k(n0Var);
                    this.r = k2;
                    if (k2 != null) {
                        this.s = n0Var;
                    }
                }
                c1 c1Var3 = this.r;
                if (c1Var3 != null) {
                    c1 a3 = c1Var3.a("trailers: " + n0Var);
                    this.r = a3;
                    n(a3, false, this.s);
                    return;
                }
                n0.f<c1> fVar = f0.b;
                c1 c1Var4 = (c1) n0Var.d(fVar);
                if (c1Var4 != null) {
                    str = (String) n0Var.d(f0.a);
                } else if (this.u) {
                    c1Var4 = c1.f3511h;
                    str = "missing GRPC status in response";
                } else {
                    Integer num = (Integer) n0Var.d(t0.w);
                    c1Var2 = (num != null ? q0.f(num.intValue()) : c1.m.g("missing HTTP status code")).a("missing GRPC status, inferred error from HTTP status code");
                    n0Var.b(t0.w);
                    n0Var.b(fVar);
                    n0Var.b(f0.a);
                    f.b.a.c.b.o.b.A(c1Var2, "status");
                    f.b.a.c.b.o.b.A(n0Var, "trailers");
                    if (!this.p) {
                        h.a.j1.a.f3538f.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{c1Var2, n0Var});
                        return;
                    }
                    for (f1 f1Var : this.f3543h.a) {
                        Objects.requireNonNull((j) f1Var);
                    }
                    i(c1Var2, v.a.PROCESSED, false, n0Var);
                    return;
                }
                c1Var2 = c1Var4.g(str);
                n0Var.b(t0.w);
                n0Var.b(fVar);
                n0Var.b(f0.a);
                f.b.a.c.b.o.b.A(c1Var2, "status");
                f.b.a.c.b.o.b.A(n0Var, "trailers");
                if (!this.p) {
                }
            } else {
                byte[][] a4 = o.a(list);
                Charset charset2 = e0.a;
                n0 n0Var2 = new n0(a4);
                f.b.a.c.b.o.b.A(n0Var2, "headers");
                c1 c1Var5 = this.r;
                if (c1Var5 != null) {
                    this.r = c1Var5.a("headers: " + n0Var2);
                    return;
                }
                try {
                    if (this.u) {
                        c1Var = c1.m.g("Received headers twice");
                        this.r = c1Var;
                        sb = new StringBuilder();
                    } else {
                        n0.f<Integer> fVar2 = t0.w;
                        Integer num2 = (Integer) n0Var2.d(fVar2);
                        if (num2 == null || num2.intValue() < 100 || num2.intValue() >= 200) {
                            this.u = true;
                            c1 k3 = k(n0Var2);
                            this.r = k3;
                            if (k3 != null) {
                                a = k3.a("headers: " + n0Var2);
                                this.r = a;
                                this.s = n0Var2;
                                this.t = t0.j(n0Var2);
                            }
                            n0Var2.b(fVar2);
                            n0Var2.b(f0.b);
                            n0Var2.b(f0.a);
                            h(n0Var2);
                            c1Var = this.r;
                            if (c1Var != null) {
                                sb = new StringBuilder();
                            } else {
                                return;
                            }
                        } else {
                            c1Var = this.r;
                            if (c1Var != null) {
                                sb = new StringBuilder();
                            } else {
                                return;
                            }
                        }
                    }
                    sb.append("headers: ");
                    sb.append(n0Var2);
                    a = c1Var.a(sb.toString());
                    this.r = a;
                    this.s = n0Var2;
                    this.t = t0.j(n0Var2);
                } catch (Throwable th) {
                    c1 c1Var6 = this.r;
                    if (c1Var6 != null) {
                        this.r = c1Var6.a("headers: " + n0Var2);
                        this.s = n0Var2;
                        this.t = t0.j(n0Var2);
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(o0<?, ?> o0Var, n0 n0Var, b bVar, g gVar, n nVar, Object obj, int i2, int i3, String str, String str2, w2 w2Var, c3 c3Var, h.a.c cVar, boolean z) {
        super(new m(), w2Var, c3Var, n0Var, cVar, z && o0Var.f3954h);
        this.f3827l = -1;
        this.n = new a();
        this.p = false;
        f.b.a.c.b.o.b.A(w2Var, "statsTraceCtx");
        this.f3824i = w2Var;
        this.f3822g = o0Var;
        this.f3825j = str;
        this.f3823h = str2;
        this.o = gVar.s;
        this.m = new b(i2, w2Var, obj, bVar, nVar, gVar, i3, o0Var.b);
    }

    @Override // h.a.j1.u
    public void j(String str) {
        f.b.a.c.b.o.b.A(str, "authority");
        this.f3825j = str;
    }

    @Override // h.a.j1.a
    public a.b o() {
        return this.n;
    }

    @Override // h.a.j1.a
    public a.c p() {
        return this.m;
    }

    public d.a q() {
        return this.m;
    }
}
