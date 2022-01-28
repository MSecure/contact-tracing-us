package b.z.y.r;

import b.z.c;
import b.z.e;
import b.z.m;
import b.z.u;

public final class p {
    public static final String r = m.e("WorkSpec");

    /* renamed from: a  reason: collision with root package name */
    public String f2091a;

    /* renamed from: b  reason: collision with root package name */
    public u f2092b = u.ENQUEUED;

    /* renamed from: c  reason: collision with root package name */
    public String f2093c;

    /* renamed from: d  reason: collision with root package name */
    public String f2094d;

    /* renamed from: e  reason: collision with root package name */
    public e f2095e;
    public e f;
    public long g;
    public long h;
    public long i;
    public c j;
    public int k;
    public b.z.a l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2096a;

        /* renamed from: b  reason: collision with root package name */
        public u f2097b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f2097b != aVar.f2097b) {
                return false;
            }
            return this.f2096a.equals(aVar.f2096a);
        }

        public int hashCode() {
            return this.f2097b.hashCode() + (this.f2096a.hashCode() * 31);
        }
    }

    public p(p pVar) {
        e eVar = e.f1912c;
        this.f2095e = eVar;
        this.f = eVar;
        this.j = c.i;
        this.l = b.z.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.f2091a = pVar.f2091a;
        this.f2093c = pVar.f2093c;
        this.f2092b = pVar.f2092b;
        this.f2094d = pVar.f2094d;
        this.f2095e = new e(pVar.f2095e);
        this.f = new e(pVar.f);
        this.g = pVar.g;
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
        e eVar = e.f1912c;
        this.f2095e = eVar;
        this.f = eVar;
        this.j = c.i;
        this.l = b.z.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.f2091a = str;
        this.f2093c = str2;
    }

    public long a() {
        long j2;
        long j3;
        boolean z = false;
        if (this.f2092b == u.ENQUEUED && this.k > 0) {
            if (this.l == b.z.a.LINEAR) {
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
                    j6 = this.g + currentTimeMillis;
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
            j2 = this.g;
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
        if (this.g != pVar.g || this.h != pVar.h || this.i != pVar.i || this.k != pVar.k || this.m != pVar.m || this.n != pVar.n || this.o != pVar.o || this.p != pVar.p || this.q != pVar.q || !this.f2091a.equals(pVar.f2091a) || this.f2092b != pVar.f2092b || !this.f2093c.equals(pVar.f2093c)) {
            return false;
        }
        String str = this.f2094d;
        if (str == null ? pVar.f2094d != null : !str.equals(pVar.f2094d)) {
            return false;
        }
        if (this.f2095e.equals(pVar.f2095e) && this.f.equals(pVar.f) && this.j.equals(pVar.j)) {
            return this.l == pVar.l;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f2093c.hashCode() + ((this.f2092b.hashCode() + (this.f2091a.hashCode() * 31)) * 31)) * 31;
        String str = this.f2094d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = this.f2095e.hashCode();
        int hashCode4 = this.f.hashCode();
        long j2 = this.g;
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
        StringBuilder g2 = c.a.a.a.a.g("{WorkSpec: ");
        g2.append(this.f2091a);
        g2.append("}");
        return g2.toString();
    }
}
