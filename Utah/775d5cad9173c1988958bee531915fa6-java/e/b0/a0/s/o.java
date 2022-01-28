package e.b0.a0.s;

import e.b0.d;
import e.b0.f;
import e.b0.n;
import e.b0.r;
import e.b0.v;

public final class o {
    public static final String s = n.e("WorkSpec");
    public String a;
    public v b = v.ENQUEUED;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f1112d;

    /* renamed from: e  reason: collision with root package name */
    public f f1113e;

    /* renamed from: f  reason: collision with root package name */
    public f f1114f;

    /* renamed from: g  reason: collision with root package name */
    public long f1115g;

    /* renamed from: h  reason: collision with root package name */
    public long f1116h;

    /* renamed from: i  reason: collision with root package name */
    public long f1117i;

    /* renamed from: j  reason: collision with root package name */
    public d f1118j;

    /* renamed from: k  reason: collision with root package name */
    public int f1119k;

    /* renamed from: l  reason: collision with root package name */
    public e.b0.a f1120l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;
    public r r;

    public static class a {
        public String a;
        public v b;

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
        f fVar = f.c;
        this.f1113e = fVar;
        this.f1114f = fVar;
        this.f1118j = d.f1161i;
        this.f1120l = e.b0.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.r = r.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = oVar.a;
        this.c = oVar.c;
        this.b = oVar.b;
        this.f1112d = oVar.f1112d;
        this.f1113e = new f(oVar.f1113e);
        this.f1114f = new f(oVar.f1114f);
        this.f1115g = oVar.f1115g;
        this.f1116h = oVar.f1116h;
        this.f1117i = oVar.f1117i;
        this.f1118j = new d(oVar.f1118j);
        this.f1119k = oVar.f1119k;
        this.f1120l = oVar.f1120l;
        this.m = oVar.m;
        this.n = oVar.n;
        this.o = oVar.o;
        this.p = oVar.p;
        this.q = oVar.q;
        this.r = oVar.r;
    }

    public o(String str, String str2) {
        f fVar = f.c;
        this.f1113e = fVar;
        this.f1114f = fVar;
        this.f1118j = d.f1161i;
        this.f1120l = e.b0.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.r = r.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = str;
        this.c = str2;
    }

    public long a() {
        long j2;
        long j3;
        boolean z = false;
        if (this.b == v.ENQUEUED && this.f1119k > 0) {
            if (this.f1120l == e.b0.a.LINEAR) {
                z = true;
            }
            long j4 = this.m;
            long scalb = z ? j4 * ((long) this.f1119k) : (long) Math.scalb((float) j4, this.f1119k - 1);
            j3 = this.n;
            j2 = Math.min(18000000L, scalb);
        } else {
            long j5 = 0;
            if (c()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j6 = this.n;
                int i2 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
                if (i2 == 0) {
                    j6 = this.f1115g + currentTimeMillis;
                }
                long j7 = this.f1117i;
                long j8 = this.f1116h;
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
            j3 = this.f1115g;
        }
        return j2 + j3;
    }

    public boolean b() {
        return !d.f1161i.equals(this.f1118j);
    }

    public boolean c() {
        return this.f1116h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f1115g != oVar.f1115g || this.f1116h != oVar.f1116h || this.f1117i != oVar.f1117i || this.f1119k != oVar.f1119k || this.m != oVar.m || this.n != oVar.n || this.o != oVar.o || this.p != oVar.p || this.q != oVar.q || !this.a.equals(oVar.a) || this.b != oVar.b || !this.c.equals(oVar.c)) {
            return false;
        }
        String str = this.f1112d;
        if (str == null ? oVar.f1112d == null : str.equals(oVar.f1112d)) {
            return this.f1113e.equals(oVar.f1113e) && this.f1114f.equals(oVar.f1114f) && this.f1118j.equals(oVar.f1118j) && this.f1120l == oVar.f1120l && this.r == oVar.r;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        String str = this.f1112d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = this.f1113e.hashCode();
        int hashCode4 = this.f1114f.hashCode();
        long j2 = this.f1115g;
        long j3 = this.f1116h;
        long j4 = this.f1117i;
        int hashCode5 = this.f1118j.hashCode();
        int hashCode6 = this.f1120l.hashCode();
        long j5 = this.m;
        long j6 = this.n;
        long j7 = this.o;
        long j8 = this.p;
        return this.r.hashCode() + ((((((((((((hashCode6 + ((((hashCode5 + ((((((((hashCode4 + ((hashCode3 + ((hashCode + hashCode2) * 31)) * 31)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31)) * 31) + this.f1119k) * 31)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.q ? 1 : 0)) * 31);
    }

    public String toString() {
        return f.a.a.a.a.e(f.a.a.a.a.h("{WorkSpec: "), this.a, "}");
    }
}
