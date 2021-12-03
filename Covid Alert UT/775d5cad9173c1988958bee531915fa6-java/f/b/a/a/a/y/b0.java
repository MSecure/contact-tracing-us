package f.b.a.a.a.y;

import f.b.a.a.a.y.i0;
import l.b.a.f;

public final class b0 extends i0 {
    public final f a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2480d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2481e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2482f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2483g;

    public static final class b extends i0.a {
        public f a;
        public String b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public String f2484d;

        /* renamed from: e  reason: collision with root package name */
        public Long f2485e;

        /* renamed from: f  reason: collision with root package name */
        public Long f2486f;

        /* renamed from: g  reason: collision with root package name */
        public Boolean f2487g;

        public b() {
        }

        public b(i0 i0Var, a aVar) {
            b0 b0Var = (b0) i0Var;
            this.a = b0Var.a;
            this.b = b0Var.b;
            this.c = b0Var.c;
            this.f2484d = b0Var.f2480d;
            this.f2485e = Long.valueOf(b0Var.f2481e);
            this.f2486f = Long.valueOf(b0Var.f2482f);
            this.f2487g = Boolean.valueOf(b0Var.f2483g);
        }

        @Override // f.b.a.a.a.y.i0.a
        public i0 a() {
            String str = this.f2485e == null ? " tzOffsetMin" : "";
            if (this.f2486f == null) {
                str = f.a.a.a.a.w(str, " expiresAtTimestampSec");
            }
            if (this.f2487g == null) {
                str = f.a.a.a.a.w(str, " isCoverTraffic");
            }
            if (str.isEmpty()) {
                return new b0(this.a, this.b, this.c, this.f2484d, this.f2485e.longValue(), this.f2486f.longValue(), this.f2487g.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.w("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.y.i0.a
        public i0.a b(long j2) {
            this.f2486f = Long.valueOf(j2);
            return this;
        }
    }

    public b0(f fVar, String str, String str2, String str3, long j2, long j3, boolean z, a aVar) {
        this.a = fVar;
        this.b = str;
        this.c = str2;
        this.f2480d = str3;
        this.f2481e = j2;
        this.f2482f = j3;
        this.f2483g = z;
    }

    @Override // f.b.a.a.a.y.i0
    public String a() {
        return this.f2480d;
    }

    @Override // f.b.a.a.a.y.i0
    public long b() {
        return this.f2482f;
    }

    @Override // f.b.a.a.a.y.i0
    public boolean c() {
        return this.f2483g;
    }

    @Override // f.b.a.a.a.y.i0
    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        f fVar = this.a;
        if (fVar != null ? fVar.equals(i0Var.g()) : i0Var.g() == null) {
            String str = this.b;
            if (str != null ? str.equals(i0Var.f()) : i0Var.f() == null) {
                String str2 = this.c;
                if (str2 != null ? str2.equals(i0Var.e()) : i0Var.e() == null) {
                    String str3 = this.f2480d;
                    if (str3 != null ? str3.equals(i0Var.a()) : i0Var.a() == null) {
                        return this.f2481e == i0Var.i() && this.f2482f == i0Var.b() && this.f2483g == i0Var.c();
                    }
                }
            }
        }
    }

    @Override // f.b.a.a.a.y.i0
    public String f() {
        return this.b;
    }

    @Override // f.b.a.a.a.y.i0
    public f g() {
        return this.a;
    }

    @Override // f.b.a.a.a.y.i0
    public i0.a h() {
        return new b(this, null);
    }

    public int hashCode() {
        f fVar = this.a;
        int i2 = 0;
        int hashCode = ((fVar == null ? 0 : fVar.hashCode()) ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2480d;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        long j2 = this.f2481e;
        long j3 = this.f2482f;
        return ((((((hashCode3 ^ i2) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f2483g ? 1231 : 1237);
    }

    @Override // f.b.a.a.a.y.i0
    public long i() {
        return this.f2481e;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("UserReportUpload{testDate=");
        h2.append(this.a);
        h2.append(", phoneNumber=");
        h2.append(this.b);
        h2.append(", nonceBase64=");
        h2.append(this.c);
        h2.append(", expiresAt=");
        h2.append(this.f2480d);
        h2.append(", tzOffsetMin=");
        h2.append(this.f2481e);
        h2.append(", expiresAtTimestampSec=");
        h2.append(this.f2482f);
        h2.append(", isCoverTraffic=");
        h2.append(this.f2483g);
        h2.append("}");
        return h2.toString();
    }
}
