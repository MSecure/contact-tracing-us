package b.b0.y.r;

import b.b0.c;
import b.b0.e;
import b.b0.m;
import b.b0.u;

public final class p {
    public static final String r = m.e("WorkSpec");

    /* renamed from: a  reason: collision with root package name */
    public String f1234a;

    /* renamed from: b  reason: collision with root package name */
    public u f1235b = u.ENQUEUED;

    /* renamed from: c  reason: collision with root package name */
    public String f1236c;

    /* renamed from: d  reason: collision with root package name */
    public String f1237d;

    /* renamed from: e  reason: collision with root package name */
    public e f1238e;

    /* renamed from: f  reason: collision with root package name */
    public e f1239f;

    /* renamed from: g  reason: collision with root package name */
    public long f1240g;
    public long h;
    public long i;
    public c j;
    public int k;
    public b.b0.a l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f1241a;

        /* renamed from: b  reason: collision with root package name */
        public u f1242b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f1242b != aVar.f1242b) {
                return false;
            }
            return this.f1241a.equals(aVar.f1241a);
        }

        public int hashCode() {
            return this.f1242b.hashCode() + (this.f1241a.hashCode() * 31);
        }
    }

    public p(p pVar) {
        e eVar = e.f1027c;
        this.f1238e = eVar;
        this.f1239f = eVar;
        this.j = c.i;
        this.l = b.b0.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.f1234a = pVar.f1234a;
        this.f1236c = pVar.f1236c;
        this.f1235b = pVar.f1235b;
        this.f1237d = pVar.f1237d;
        this.f1238e = new e(pVar.f1238e);
        this.f1239f = new e(pVar.f1239f);
        this.f1240g = pVar.f1240g;
        this.h = pVar.h;
        this.i = pVar.i;
        this.j = new c(pVar.j);
        this.k = pVar.k;
        this.l = pVar.l;
        this.m = pVar.m;
        this.n = pVar.n;
        this.o = pVar.o;
        this.p = pVar.p;
        this.q = pVar.q;
    }

    public p(String str, String str2) {
        e eVar = e.f1027c;
        this.f1238e = eVar;
        this.f1239f = eVar;
        this.j = c.i;
        this.l = b.b0.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.f1234a = str;
        this.f1236c = str2;
    }

    public long a() {
        long j2;
        long j3;
        boolean z = false;
        if (this.f1235b == u.ENQUEUED && this.k > 0) {
            if (this.l == b.b0.a.LINEAR) {
                z = true;
            }
            long j4 = this.m;
            long scalb = z ? j4 * ((long) this.k) : (long) Math.scalb((float) j4, this.k - 1);
            j2 = this.n;
            j3 = Math.min(18000000L, scalb);
        } else {
            long j5 = 0;
            if (c()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j6 = this.n;
                if (j6 == 0) {
                    j6 = this.f1240g + currentTimeMillis;
                }
                if (this.i != this.h) {
                    z = true;
                }
                int i2 = (this.n > 0 ? 1 : (this.n == 0 ? 0 : -1));
                if (z) {
                    if (i2 == 0) {
                        j5 = this.i * -1;
                    }
                    return j6 + this.h + j5;
                }
                if (i2 != 0) {
                    j5 = this.h;
                }
                return j6 + j5;
            }
            j3 = this.n;
            if (j3 == 0) {
                j3 = System.currentTimeMillis();
            }
            j2 = this.f1240g;
        }
        return j3 + j2;
    }

    public boolean b() {
        return !c.i.equals(this.j);
    }

    public boolean c() {
        return this.h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f1240g != pVar.f1240g || this.h != pVar.h || this.i != pVar.i || this.k != pVar.k || this.m != pVar.m || this.n != pVar.n || this.o != pVar.o || this.p != pVar.p || this.q != pVar.q || !this.f1234a.equals(pVar.f1234a) || this.f1235b != pVar.f1235b || !this.f1236c.equals(pVar.f1236c)) {
            return false;
        }
        String str = this.f1237d;
        if (str == null ? pVar.f1237d != null : !str.equals(pVar.f1237d)) {
            return false;
        }
        if (this.f1238e.equals(pVar.f1238e) && this.f1239f.equals(pVar.f1239f) && this.j.equals(pVar.j)) {
            return this.l == pVar.l;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f1236c.hashCode() + ((this.f1235b.hashCode() + (this.f1234a.hashCode() * 31)) * 31)) * 31;
        String str = this.f1237d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = this.f1238e.hashCode();
        int hashCode4 = this.f1239f.hashCode();
        long j2 = this.f1240g;
        long j3 = this.h;
        long j4 = this.i;
        int hashCode5 = this.j.hashCode();
        int hashCode6 = this.l.hashCode();
        long j5 = this.m;
        long j6 = this.n;
        long j7 = this.o;
        long j8 = this.p;
        return ((((((((((hashCode6 + ((((hashCode5 + ((((((((hashCode4 + ((hashCode3 + ((hashCode + hashCode2) * 31)) * 31)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31)) * 31) + this.k) * 31)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.q ? 1 : 0);
    }

    public String toString() {
        StringBuilder h2 = c.a.a.a.a.h("{WorkSpec: ");
        h2.append(this.f1234a);
        h2.append("}");
        return h2.toString();
    }
}
