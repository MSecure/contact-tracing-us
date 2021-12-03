package f.b.a.a.a.o;

import f.b.a.a.a.o.j0;
import l.b.a.f;

public final class b0 extends j0 {
    public final f a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2288d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2289e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2290f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2291g;

    public static final class b extends j0.a {
        public f a;
        public String b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public String f2292d;

        /* renamed from: e  reason: collision with root package name */
        public Long f2293e;

        /* renamed from: f  reason: collision with root package name */
        public Long f2294f;

        /* renamed from: g  reason: collision with root package name */
        public Boolean f2295g;

        public b() {
        }

        public b(j0 j0Var, a aVar) {
            b0 b0Var = (b0) j0Var;
            this.a = b0Var.a;
            this.b = b0Var.b;
            this.c = b0Var.c;
            this.f2292d = b0Var.f2288d;
            this.f2293e = Long.valueOf(b0Var.f2289e);
            this.f2294f = Long.valueOf(b0Var.f2290f);
            this.f2295g = Boolean.valueOf(b0Var.f2291g);
        }

        @Override // f.b.a.a.a.o.j0.a
        public j0 a() {
            String str = this.f2293e == null ? " tzOffsetMin" : "";
            if (this.f2294f == null) {
                str = f.a.a.a.a.c(str, " expiresAtTimestampSec");
            }
            if (this.f2295g == null) {
                str = f.a.a.a.a.c(str, " isCoverTraffic");
            }
            if (str.isEmpty()) {
                return new b0(this.a, this.b, this.c, this.f2292d, this.f2293e.longValue(), this.f2294f.longValue(), this.f2295g.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.c("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.o.j0.a
        public j0.a b(long j2) {
            this.f2294f = Long.valueOf(j2);
            return this;
        }
    }

    public b0(f fVar, String str, String str2, String str3, long j2, long j3, boolean z, a aVar) {
        this.a = fVar;
        this.b = str;
        this.c = str2;
        this.f2288d = str3;
        this.f2289e = j2;
        this.f2290f = j3;
        this.f2291g = z;
    }

    @Override // f.b.a.a.a.o.j0
    public String a() {
        return this.f2288d;
    }

    @Override // f.b.a.a.a.o.j0
    public long b() {
        return this.f2290f;
    }

    @Override // f.b.a.a.a.o.j0
    public boolean c() {
        return this.f2291g;
    }

    @Override // f.b.a.a.a.o.j0
    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        f fVar = this.a;
        if (fVar != null ? fVar.equals(j0Var.g()) : j0Var.g() == null) {
            String str = this.b;
            if (str != null ? str.equals(j0Var.f()) : j0Var.f() == null) {
                String str2 = this.c;
                if (str2 != null ? str2.equals(j0Var.e()) : j0Var.e() == null) {
                    String str3 = this.f2288d;
                    if (str3 != null ? str3.equals(j0Var.a()) : j0Var.a() == null) {
                        return this.f2289e == j0Var.i() && this.f2290f == j0Var.b() && this.f2291g == j0Var.c();
                    }
                }
            }
        }
    }

    @Override // f.b.a.a.a.o.j0
    public String f() {
        return this.b;
    }

    @Override // f.b.a.a.a.o.j0
    public f g() {
        return this.a;
    }

    @Override // f.b.a.a.a.o.j0
    public j0.a h() {
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
        String str3 = this.f2288d;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        long j2 = this.f2289e;
        long j3 = this.f2290f;
        return ((((((hashCode3 ^ i2) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f2291g ? 1231 : 1237);
    }

    @Override // f.b.a.a.a.o.j0
    public long i() {
        return this.f2289e;
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("UserReportUpload{testDate=");
        i2.append(this.a);
        i2.append(", phoneNumber=");
        i2.append(this.b);
        i2.append(", nonceBase64=");
        i2.append(this.c);
        i2.append(", expiresAt=");
        i2.append(this.f2288d);
        i2.append(", tzOffsetMin=");
        i2.append(this.f2289e);
        i2.append(", expiresAtTimestampSec=");
        i2.append(this.f2290f);
        i2.append(", isCoverTraffic=");
        i2.append(this.f2291g);
        i2.append("}");
        return i2.toString();
    }
}
