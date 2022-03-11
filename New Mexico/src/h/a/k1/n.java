package h.a.k1;

import f.b.a.c.b.o.b;
import h.a.k1.f;
import h.a.k1.p.m.c;
import java.io.IOException;
import k.e;
/* loaded from: classes.dex */
public class n {
    public final g a;
    public final c b;
    public int c = 65535;

    /* renamed from: d  reason: collision with root package name */
    public final a f4433d = new a(0, 65535);

    /* loaded from: classes.dex */
    public final class a {
        public final int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f4434d;

        /* renamed from: e  reason: collision with root package name */
        public f f4435e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4436f = false;
        public final e a = new e();

        public a(int i2, int i3) {
            this.b = i2;
            this.c = i3;
        }

        public a(n nVar, f fVar, int i2) {
            int i3 = fVar.f4405l;
            n.this = nVar;
            this.b = i3;
            this.c = i2;
            this.f4435e = fVar;
        }

        public int a(int i2) {
            if (i2 <= 0 || Integer.MAX_VALUE - i2 >= this.c) {
                int i3 = this.c + i2;
                this.c = i3;
                return i3;
            }
            StringBuilder h2 = f.a.a.a.a.h("Window size overflow for stream: ");
            h2.append(this.b);
            throw new IllegalArgumentException(h2.toString());
        }

        public int b() {
            return Math.max(0, Math.min(this.c, (int) this.a.c)) - this.f4434d;
        }

        public int c() {
            return Math.min(this.c, n.this.f4433d.c);
        }

        public void d(e eVar, int i2, boolean z) {
            do {
                int min = Math.min(i2, n.this.b.A());
                int i3 = -min;
                n.this.f4433d.a(i3);
                a(i3);
                try {
                    boolean z2 = false;
                    n.this.b.i(eVar.c == ((long) min) && z, this.b, eVar, min);
                    f.b bVar = this.f4435e.m;
                    synchronized (bVar.c) {
                        b.G(bVar.f4160f, "onStreamAllocated was not called, but it seems the stream is active");
                        int i4 = bVar.f4159e;
                        boolean z3 = i4 < 32768;
                        int i5 = i4 - min;
                        bVar.f4159e = i5;
                        boolean z4 = i5 < 32768;
                        if (!z3 && z4) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        bVar.d();
                    }
                    i2 -= min;
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } while (i2 > 0);
        }
    }

    public n(g gVar, c cVar) {
        b.A(gVar, "transport");
        this.a = gVar;
        b.A(cVar, "frameWriter");
        this.b = cVar;
    }

    public void a(boolean z, int i2, e eVar, boolean z2) {
        b.A(eVar, "source");
        f p = this.a.p(i2);
        if (p != null) {
            a d2 = d(p);
            int c = d2.c();
            boolean z3 = d2.a.c > 0;
            int i3 = (int) eVar.c;
            if (z3 || c < i3) {
                if (!z3 && c > 0) {
                    d2.d(eVar, c, false);
                }
                d2.a.h(eVar, (long) ((int) eVar.c));
                d2.f4436f = z | d2.f4436f;
            } else {
                d2.d(eVar, i3, z);
            }
            if (z2) {
                b();
            }
        }
    }

    public void b() {
        try {
            this.b.flush();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean c(int i2) {
        if (i2 >= 0) {
            int i3 = i2 - this.c;
            this.c = i2;
            f[] l2 = this.a.l();
            for (f fVar : l2) {
                a aVar = (a) fVar.f4404k;
                if (aVar == null) {
                    fVar.f4404k = new a(this, fVar, this.c);
                } else {
                    aVar.a(i3);
                }
            }
            if (i3 > 0) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException(f.a.a.a.a.u("Invalid initial window size: ", i2));
    }

    public final a d(f fVar) {
        a aVar = (a) fVar.f4404k;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(this, fVar, this.c);
        fVar.f4404k = aVar2;
        return aVar2;
    }

    public int e(f fVar, int i2) {
        if (fVar == null) {
            int a2 = this.f4433d.a(i2);
            f();
            return a2;
        }
        a d2 = d(fVar);
        int a3 = d2.a(i2);
        int c = d2.c();
        int min = Math.min(c, d2.c());
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            e eVar = d2.a;
            long j2 = eVar.c;
            if (!(j2 > 0) || min <= 0) {
                break;
            }
            if (((long) min) >= j2) {
                int i5 = (int) j2;
                i4 += i5;
                d2.d(eVar, i5, d2.f4436f);
            } else {
                i4 += min;
                d2.d(eVar, min, false);
            }
            i3++;
            min = Math.min(c - i4, d2.c());
        }
        if (i3 > 0) {
            z = true;
        }
        if (z) {
            b();
        }
        return a3;
    }

    public void f() {
        int i2;
        f[] l2 = this.a.l();
        int i3 = this.f4433d.c;
        int length = l2.length;
        while (true) {
            i2 = 0;
            if (length <= 0 || i3 <= 0) {
                break;
            }
            int ceil = (int) Math.ceil((double) (((float) i3) / ((float) length)));
            for (int i4 = 0; i4 < length && i3 > 0; i4++) {
                f fVar = l2[i4];
                a d2 = d(fVar);
                int min = Math.min(i3, Math.min(d2.b(), ceil));
                if (min > 0) {
                    d2.f4434d += min;
                    i3 -= min;
                }
                if (d2.b() > 0) {
                    i2++;
                    l2[i2] = fVar;
                }
            }
            length = i2;
        }
        int i5 = 0;
        for (f fVar2 : this.a.l()) {
            a d3 = d(fVar2);
            int i6 = d3.f4434d;
            int min2 = Math.min(i6, d3.c());
            int i7 = 0;
            while (true) {
                e eVar = d3.a;
                long j2 = eVar.c;
                if ((j2 > 0) && min2 > 0) {
                    if (((long) min2) >= j2) {
                        int i8 = (int) j2;
                        i7 += i8;
                        d3.d(eVar, i8, d3.f4436f);
                    } else {
                        i7 += min2;
                        d3.d(eVar, min2, false);
                    }
                    i5++;
                    min2 = Math.min(i6 - i7, d3.c());
                }
            }
            d3.f4434d = 0;
        }
        if (i5 > 0) {
            i2 = 1;
        }
        if (i2 != 0) {
            b();
        }
    }
}
