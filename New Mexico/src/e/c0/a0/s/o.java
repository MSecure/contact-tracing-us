package e.c0.a0.s;

import e.c0.d;
import e.c0.f;
import e.c0.n;
import e.c0.r;
import e.c0.v;
/* loaded from: classes.dex */
public final class o {
    public static final String s = n.e("WorkSpec");
    public String a;
    public v b;
    public String c;

    /* renamed from: d */
    public String f1191d;

    /* renamed from: e */
    public f f1192e;

    /* renamed from: f */
    public f f1193f;

    /* renamed from: g */
    public long f1194g;

    /* renamed from: h */
    public long f1195h;

    /* renamed from: i */
    public long f1196i;

    /* renamed from: j */
    public d f1197j;

    /* renamed from: k */
    public int f1198k;

    /* renamed from: l */
    public e.c0.a f1199l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;
    public r r;

    /* loaded from: classes.dex */
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
        this.b = v.ENQUEUED;
        f fVar = f.c;
        this.f1192e = fVar;
        this.f1193f = fVar;
        this.f1197j = d.f1240i;
        this.f1199l = e.c0.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.r = r.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = oVar.a;
        this.c = oVar.c;
        this.b = oVar.b;
        this.f1191d = oVar.f1191d;
        this.f1192e = new f(oVar.f1192e);
        this.f1193f = new f(oVar.f1193f);
        this.f1194g = oVar.f1194g;
        this.f1195h = oVar.f1195h;
        this.f1196i = oVar.f1196i;
        this.f1197j = new d(oVar.f1197j);
        this.f1198k = oVar.f1198k;
        this.f1199l = oVar.f1199l;
        this.m = oVar.m;
        this.n = oVar.n;
        this.o = oVar.o;
        this.p = oVar.p;
        this.q = oVar.q;
        this.r = oVar.r;
    }

    public o(String str, String str2) {
        this.b = v.ENQUEUED;
        f fVar = f.c;
        this.f1192e = fVar;
        this.f1193f = fVar;
        this.f1197j = d.f1240i;
        this.f1199l = e.c0.a.EXPONENTIAL;
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
        if (this.b == v.ENQUEUED && this.f1198k > 0) {
            if (this.f1199l == e.c0.a.LINEAR) {
                z = true;
            }
            long j4 = this.m;
            long scalb = z ? j4 * ((long) this.f1198k) : (long) Math.scalb((float) j4, this.f1198k - 1);
            j3 = this.n;
            j2 = Math.min(18000000L, scalb);
        } else {
            long j5 = 0;
            if (c()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j6 = this.n;
                int i2 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
                if (i2 == 0) {
                    j6 = this.f1194g + currentTimeMillis;
                }
                long j7 = this.f1196i;
                long j8 = this.f1195h;
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
            j3 = this.f1194g;
        }
        return j2 + j3;
    }

    public boolean b() {
        return !d.f1240i.equals(this.f1197j);
    }

    public boolean c() {
        return this.f1195h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f1194g != oVar.f1194g || this.f1195h != oVar.f1195h || this.f1196i != oVar.f1196i || this.f1198k != oVar.f1198k || this.m != oVar.m || this.n != oVar.n || this.o != oVar.o || this.p != oVar.p || this.q != oVar.q || !this.a.equals(oVar.a) || this.b != oVar.b || !this.c.equals(oVar.c)) {
            return false;
        }
        String str = this.f1191d;
        if (str == null ? oVar.f1191d == null : str.equals(oVar.f1191d)) {
            return this.f1192e.equals(oVar.f1192e) && this.f1193f.equals(oVar.f1193f) && this.f1197j.equals(oVar.f1197j) && this.f1199l == oVar.f1199l && this.r == oVar.r;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        String str = this.f1191d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = this.f1192e.hashCode();
        int hashCode4 = this.f1193f.hashCode();
        long j2 = this.f1194g;
        long j3 = this.f1195h;
        long j4 = this.f1196i;
        int hashCode5 = this.f1197j.hashCode();
        int hashCode6 = this.f1199l.hashCode();
        long j5 = this.m;
        long j6 = this.n;
        long j7 = this.o;
        long j8 = this.p;
        return this.r.hashCode() + ((((((((((((hashCode6 + ((((hashCode5 + ((((((((hashCode4 + ((hashCode3 + ((hashCode + hashCode2) * 31)) * 31)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31)) * 31) + this.f1198k) * 31)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.q ? 1 : 0)) * 31);
    }

    public String toString() {
        return f.a.a.a.a.e(f.a.a.a.a.h("{WorkSpec: "), this.a, "}");
    }
}
