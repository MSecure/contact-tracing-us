package f.b.a.a.a.z;

import f.b.a.a.a.z.i0;
import l.b.a.f;
/* loaded from: classes.dex */
public final class b0 extends i0 {
    public final f a;
    public final String b;
    public final String c;

    /* renamed from: d */
    public final String f2528d;

    /* renamed from: e */
    public final long f2529e;

    /* renamed from: f */
    public final long f2530f;

    /* renamed from: g */
    public final boolean f2531g;

    /* loaded from: classes.dex */
    public static final class b extends i0.a {
        public f a;
        public String b;
        public String c;

        /* renamed from: d */
        public String f2532d;

        /* renamed from: e */
        public Long f2533e;

        /* renamed from: f */
        public Long f2534f;

        /* renamed from: g */
        public Boolean f2535g;

        public b() {
        }

        public b(i0 i0Var, a aVar) {
            b0 b0Var = (b0) i0Var;
            this.a = b0Var.a;
            this.b = b0Var.b;
            this.c = b0Var.c;
            this.f2532d = b0Var.f2528d;
            this.f2533e = Long.valueOf(b0Var.f2529e);
            this.f2534f = Long.valueOf(b0Var.f2530f);
            this.f2535g = Boolean.valueOf(b0Var.f2531g);
        }

        @Override // f.b.a.a.a.z.i0.a
        public i0 a() {
            String str = this.f2533e == null ? " tzOffsetMin" : "";
            if (this.f2534f == null) {
                str = f.a.a.a.a.x(str, " expiresAtTimestampSec");
            }
            if (this.f2535g == null) {
                str = f.a.a.a.a.x(str, " isCoverTraffic");
            }
            if (str.isEmpty()) {
                return new b0(this.a, this.b, this.c, this.f2532d, this.f2533e.longValue(), this.f2534f.longValue(), this.f2535g.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.x("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.z.i0.a
        public i0.a b(long j2) {
            this.f2534f = Long.valueOf(j2);
            return this;
        }
    }

    public b0(f fVar, String str, String str2, String str3, long j2, long j3, boolean z, a aVar) {
        this.a = fVar;
        this.b = str;
        this.c = str2;
        this.f2528d = str3;
        this.f2529e = j2;
        this.f2530f = j3;
        this.f2531g = z;
    }

    @Override // f.b.a.a.a.z.i0
    public String a() {
        return this.f2528d;
    }

    @Override // f.b.a.a.a.z.i0
    public long b() {
        return this.f2530f;
    }

    @Override // f.b.a.a.a.z.i0
    public boolean c() {
        return this.f2531g;
    }

    @Override // f.b.a.a.a.z.i0
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
                    String str3 = this.f2528d;
                    if (str3 != null ? str3.equals(i0Var.a()) : i0Var.a() == null) {
                        if (this.f2529e == i0Var.i() && this.f2530f == i0Var.b() && this.f2531g == i0Var.c()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // f.b.a.a.a.z.i0
    public String f() {
        return this.b;
    }

    @Override // f.b.a.a.a.z.i0
    public f g() {
        return this.a;
    }

    @Override // f.b.a.a.a.z.i0
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
        String str3 = this.f2528d;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        long j2 = this.f2529e;
        long j3 = this.f2530f;
        return ((((((hashCode3 ^ i2) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f2531g ? 1231 : 1237);
    }

    @Override // f.b.a.a.a.z.i0
    public long i() {
        return this.f2529e;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("UserReportUpload{testDate=");
        h2.append(this.a);
        h2.append(", phoneNumber=");
        h2.append(this.b);
        h2.append(", nonceBase64=");
        h2.append(this.c);
        h2.append(", expiresAt=");
        h2.append(this.f2528d);
        h2.append(", tzOffsetMin=");
        h2.append(this.f2529e);
        h2.append(", expiresAtTimestampSec=");
        h2.append(this.f2530f);
        h2.append(", isCoverTraffic=");
        h2.append(this.f2531g);
        h2.append("}");
        return h2.toString();
    }
}
