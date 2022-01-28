package f.b.a.a.a.b0;

import f.b.a.a.a.b0.h0;
import java.util.Objects;
import l.b.a.f;

public final class k extends h0 {
    public final long a;
    public final long b;
    public final h0.c c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2095d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2096e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2097f;

    /* renamed from: g  reason: collision with root package name */
    public final h0.d f2098g;

    /* renamed from: h  reason: collision with root package name */
    public final f f2099h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2100i;

    /* renamed from: j  reason: collision with root package name */
    public final h0.b f2101j;

    /* renamed from: k  reason: collision with root package name */
    public final String f2102k;

    /* renamed from: l  reason: collision with root package name */
    public final h0.e f2103l;
    public final boolean m;
    public final long n;
    public final boolean o;

    public static final class b extends h0.a {
        public Long a;
        public Long b;
        public h0.c c;

        /* renamed from: d  reason: collision with root package name */
        public String f2104d;

        /* renamed from: e  reason: collision with root package name */
        public String f2105e;

        /* renamed from: f  reason: collision with root package name */
        public String f2106f;

        /* renamed from: g  reason: collision with root package name */
        public h0.d f2107g;

        /* renamed from: h  reason: collision with root package name */
        public f f2108h;

        /* renamed from: i  reason: collision with root package name */
        public Boolean f2109i;

        /* renamed from: j  reason: collision with root package name */
        public h0.b f2110j;

        /* renamed from: k  reason: collision with root package name */
        public String f2111k;

        /* renamed from: l  reason: collision with root package name */
        public h0.e f2112l;
        public Boolean m;
        public Long n;
        public Boolean o;

        public b() {
        }

        public b(h0 h0Var, a aVar) {
            k kVar = (k) h0Var;
            this.a = Long.valueOf(kVar.a);
            this.b = Long.valueOf(kVar.b);
            this.c = kVar.c;
            this.f2104d = kVar.f2095d;
            this.f2105e = kVar.f2096e;
            this.f2106f = kVar.f2097f;
            this.f2107g = kVar.f2098g;
            this.f2108h = kVar.f2099h;
            this.f2109i = Boolean.valueOf(kVar.f2100i);
            this.f2110j = kVar.f2101j;
            this.f2111k = kVar.f2102k;
            this.f2112l = kVar.f2103l;
            this.m = Boolean.valueOf(kVar.m);
            this.n = Long.valueOf(kVar.n);
            this.o = Boolean.valueOf(kVar.o);
        }

        @Override // f.b.a.a.a.b0.h0.a
        public h0 a() {
            String str = this.a == null ? " id" : "";
            if (this.b == null) {
                str = f.a.a.a.a.c(str, " createdTimestampMs");
            }
            if (this.f2109i == null) {
                str = f.a.a.a.a.c(str, " isServerOnsetDate");
            }
            if (this.f2110j == null) {
                str = f.a.a.a.a.c(str, " hasSymptoms");
            }
            if (this.m == null) {
                str = f.a.a.a.a.c(str, " isCodeFromLink");
            }
            if (this.n == null) {
                str = f.a.a.a.a.c(str, " lastUpdatedTimestampMs");
            }
            if (this.o == null) {
                str = f.a.a.a.a.c(str, " isPreAuth");
            }
            if (str.isEmpty()) {
                return new k(this.a.longValue(), this.b.longValue(), this.c, this.f2104d, this.f2105e, this.f2106f, this.f2107g, this.f2108h, this.f2109i.booleanValue(), this.f2110j, this.f2111k, this.f2112l, this.m.booleanValue(), this.n.longValue(), this.o.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.c("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.b0.h0.a
        public h0.a b(long j2) {
            this.b = Long.valueOf(j2);
            return this;
        }

        @Override // f.b.a.a.a.b0.h0.a
        public h0.a c(h0.b bVar) {
            Objects.requireNonNull(bVar, "Null hasSymptoms");
            this.f2110j = bVar;
            return this;
        }

        @Override // f.b.a.a.a.b0.h0.a
        public h0.a d(long j2) {
            this.n = Long.valueOf(j2);
            return this;
        }

        public h0.a e(boolean z) {
            this.m = Boolean.valueOf(z);
            return this;
        }

        public h0.a f(boolean z) {
            this.o = Boolean.valueOf(z);
            return this;
        }

        public h0.a g(boolean z) {
            this.f2109i = Boolean.valueOf(z);
            return this;
        }
    }

    public k(long j2, long j3, h0.c cVar, String str, String str2, String str3, h0.d dVar, f fVar, boolean z, h0.b bVar, String str4, h0.e eVar, boolean z2, long j4, boolean z3, a aVar) {
        this.a = j2;
        this.b = j3;
        this.c = cVar;
        this.f2095d = str;
        this.f2096e = str2;
        this.f2097f = str3;
        this.f2098g = dVar;
        this.f2099h = fVar;
        this.f2100i = z;
        this.f2101j = bVar;
        this.f2102k = str4;
        this.f2103l = eVar;
        this.m = z2;
        this.n = j4;
        this.o = z3;
    }

    @Override // f.b.a.a.a.b0.h0
    public String b() {
        return this.f2097f;
    }

    @Override // f.b.a.a.a.b0.h0
    public long c() {
        return this.b;
    }

    @Override // f.b.a.a.a.b0.h0
    public h0.b d() {
        return this.f2101j;
    }

    @Override // f.b.a.a.a.b0.h0
    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        h0.c cVar;
        String str;
        String str2;
        String str3;
        h0.d dVar;
        f fVar;
        String str4;
        h0.e eVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.a == h0Var.e() && this.b == h0Var.c() && ((cVar = this.c) != null ? cVar.equals(h0Var.m()) : h0Var.m() == null) && ((str = this.f2095d) != null ? str.equals(h0Var.p()) : h0Var.p() == null) && ((str2 = this.f2096e) != null ? str2.equals(h0Var.j()) : h0Var.j() == null) && ((str3 = this.f2097f) != null ? str3.equals(h0Var.b()) : h0Var.b() == null) && ((dVar = this.f2098g) != null ? dVar.equals(h0Var.n()) : h0Var.n() == null) && ((fVar = this.f2099h) != null ? fVar.equals(h0Var.k()) : h0Var.k() == null) && this.f2100i == h0Var.h() && this.f2101j.equals(h0Var.d()) && ((str4 = this.f2102k) != null ? str4.equals(h0Var.l()) : h0Var.l() == null) && ((eVar = this.f2103l) != null ? eVar.equals(h0Var.o()) : h0Var.o() == null) && this.m == h0Var.f() && this.n == h0Var.i() && this.o == h0Var.g();
    }

    @Override // f.b.a.a.a.b0.h0
    public boolean f() {
        return this.m;
    }

    @Override // f.b.a.a.a.b0.h0
    public boolean g() {
        return this.o;
    }

    @Override // f.b.a.a.a.b0.h0
    public boolean h() {
        return this.f2100i;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        h0.c cVar = this.c;
        int i3 = 0;
        int hashCode = (i2 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        String str = this.f2095d;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f2096e;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2097f;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        h0.d dVar = this.f2098g;
        int hashCode5 = (hashCode4 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        f fVar = this.f2099h;
        int i4 = 1231;
        int hashCode6 = (((((hashCode5 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003) ^ (this.f2100i ? 1231 : 1237)) * 1000003) ^ this.f2101j.hashCode()) * 1000003;
        String str4 = this.f2102k;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        h0.e eVar = this.f2103l;
        if (eVar != null) {
            i3 = eVar.hashCode();
        }
        int i5 = (hashCode7 ^ i3) * 1000003;
        int i6 = this.m ? 1231 : 1237;
        long j4 = this.n;
        int i7 = (((i5 ^ i6) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        if (!this.o) {
            i4 = 1237;
        }
        return i7 ^ i4;
    }

    @Override // f.b.a.a.a.b0.h0
    public long i() {
        return this.n;
    }

    @Override // f.b.a.a.a.b0.h0
    public String j() {
        return this.f2096e;
    }

    @Override // f.b.a.a.a.b0.h0
    public f k() {
        return this.f2099h;
    }

    @Override // f.b.a.a.a.b0.h0
    public String l() {
        return this.f2102k;
    }

    @Override // f.b.a.a.a.b0.h0
    public h0.c m() {
        return this.c;
    }

    @Override // f.b.a.a.a.b0.h0
    public h0.d n() {
        return this.f2098g;
    }

    @Override // f.b.a.a.a.b0.h0
    public h0.e o() {
        return this.f2103l;
    }

    @Override // f.b.a.a.a.b0.h0
    public String p() {
        return this.f2095d;
    }

    @Override // f.b.a.a.a.b0.h0
    public h0.a r() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("DiagnosisEntity{id=");
        i2.append(this.a);
        i2.append(", createdTimestampMs=");
        i2.append(this.b);
        i2.append(", sharedStatus=");
        i2.append(this.c);
        i2.append(", verificationCode=");
        i2.append(this.f2095d);
        i2.append(", longTermToken=");
        i2.append(this.f2096e);
        i2.append(", certificate=");
        i2.append(this.f2097f);
        i2.append(", testResult=");
        i2.append(this.f2098g);
        i2.append(", onsetDate=");
        i2.append(this.f2099h);
        i2.append(", isServerOnsetDate=");
        i2.append(this.f2100i);
        i2.append(", hasSymptoms=");
        i2.append(this.f2101j);
        i2.append(", revisionToken=");
        i2.append(this.f2102k);
        i2.append(", travelStatus=");
        i2.append(this.f2103l);
        i2.append(", isCodeFromLink=");
        i2.append(this.m);
        i2.append(", lastUpdatedTimestampMs=");
        i2.append(this.n);
        i2.append(", isPreAuth=");
        i2.append(this.o);
        i2.append("}");
        return i2.toString();
    }
}
