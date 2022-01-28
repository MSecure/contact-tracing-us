package e.z.x.s;

import e.z.c;
import e.z.e;
import e.z.l;
import e.z.s;

public final class o {
    public static final String r = l.e("WorkSpec");
    public String a;
    public s b = s.ENQUEUED;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f1988d;

    /* renamed from: e  reason: collision with root package name */
    public e f1989e;

    /* renamed from: f  reason: collision with root package name */
    public e f1990f;

    /* renamed from: g  reason: collision with root package name */
    public long f1991g;

    /* renamed from: h  reason: collision with root package name */
    public long f1992h;

    /* renamed from: i  reason: collision with root package name */
    public long f1993i;

    /* renamed from: j  reason: collision with root package name */
    public c f1994j;

    /* renamed from: k  reason: collision with root package name */
    public int f1995k;

    /* renamed from: l  reason: collision with root package name */
    public e.z.a f1996l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;

    public static class a {
        public String a;
        public s b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b) {
                return false;
            }
            return this.a.equals(aVar.a);
        }

        public int hashCode() {
            return this.b.hashCode() + (this.a.hashCode() * 31);
        }
    }

    public o(o oVar) {
        e eVar = e.c;
        this.f1989e = eVar;
        this.f1990f = eVar;
        this.f1994j = c.f1860i;
        this.f1996l = e.z.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.a = oVar.a;
        this.c = oVar.c;
        this.b = oVar.b;
        this.f1988d = oVar.f1988d;
        this.f1989e = new e(oVar.f1989e);
        this.f1990f = new e(oVar.f1990f);
        this.f1991g = oVar.f1991g;
        this.f1992h = oVar.f1992h;
        this.f1993i = oVar.f1993i;
        this.f1994j = new c(oVar.f1994j);
        this.f1995k = oVar.f1995k;
        this.f1996l = oVar.f1996l;
        this.m = oVar.m;
        this.n = oVar.n;
        this.o = oVar.o;
        this.p = oVar.p;
        this.q = oVar.q;
    }

    public o(String str, String str2) {
        e eVar = e.c;
        this.f1989e = eVar;
        this.f1990f = eVar;
        this.f1994j = c.f1860i;
        this.f1996l = e.z.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.a = str;
        this.c = str2;
    }

    public long a() {
        long j2;
        long j3;
        boolean z = false;
        if (this.b == s.ENQUEUED && this.f1995k > 0) {
            if (this.f1996l == e.z.a.LINEAR) {
                z = true;
            }
            long j4 = this.m;
            long scalb = z ? j4 * ((long) this.f1995k) : (long) Math.scalb((float) j4, this.f1995k - 1);
            j3 = this.n;
            j2 = Math.min(18000000L, scalb);
        } else {
            long j5 = 0;
            if (c()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j6 = this.n;
                int i2 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
                if (i2 == 0) {
                    j6 = this.f1991g + currentTimeMillis;
                }
                long j7 = this.f1993i;
                long j8 = this.f1992h;
                if (j7 != j8) {
                    z = true;
                }
                if (z) {
                    if (i2 == 0) {
                        j5 = j7 * -1;
                    }
                    return j6 + j8 + j5;
                }
                if (i2 != 0) {
                    j5 = j8;
                }
                return j6 + j5;
            }
            j2 = this.n;
            if (j2 == 0) {
                j2 = System.currentTimeMillis();
            }
            j3 = this.f1991g;
        }
        return j2 + j3;
    }

    public boolean b() {
        return !c.f1860i.equals(this.f1994j);
    }

    public boolean c() {
        return this.f1992h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f1991g != oVar.f1991g || this.f1992h != oVar.f1992h || this.f1993i != oVar.f1993i || this.f1995k != oVar.f1995k || this.m != oVar.m || this.n != oVar.n || this.o != oVar.o || this.p != oVar.p || this.q != oVar.q || !this.a.equals(oVar.a) || this.b != oVar.b || !this.c.equals(oVar.c)) {
            return false;
        }
        String str = this.f1988d;
        if (str == null ? oVar.f1988d == null : str.equals(oVar.f1988d)) {
            return this.f1989e.equals(oVar.f1989e) && this.f1990f.equals(oVar.f1990f) && this.f1994j.equals(oVar.f1994j) && this.f1996l == oVar.f1996l;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        String str = this.f1988d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = this.f1989e.hashCode();
        int hashCode4 = this.f1990f.hashCode();
        long j2 = this.f1991g;
        long j3 = this.f1992h;
        long j4 = this.f1993i;
        int hashCode5 = this.f1994j.hashCode();
        int hashCode6 = this.f1996l.hashCode();
        long j5 = this.m;
        long j6 = this.n;
        long j7 = this.o;
        long j8 = this.p;
        return ((((((((((hashCode6 + ((((hashCode5 + ((((((((hashCode4 + ((hashCode3 + ((hashCode + hashCode2) * 31)) * 31)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31)) * 31) + this.f1995k) * 31)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.q ? 1 : 0);
    }

    public String toString() {
        return f.a.a.a.a.f(f.a.a.a.a.i("{WorkSpec: "), this.a, "}");
    }
}
