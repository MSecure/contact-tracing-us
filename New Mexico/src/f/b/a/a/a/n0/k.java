package f.b.a.a.a.n0;

import f.b.a.a.a.n0.j0;
import java.util.Objects;
import l.b.a.f;
/* loaded from: classes.dex */
public final class k extends j0 {
    public final long a;
    public final long b;
    public final j0.c c;

    /* renamed from: d */
    public final String f2349d;

    /* renamed from: e */
    public final String f2350e;

    /* renamed from: f */
    public final String f2351f;

    /* renamed from: g */
    public final j0.d f2352g;

    /* renamed from: h */
    public final f f2353h;

    /* renamed from: i */
    public final boolean f2354i;

    /* renamed from: j */
    public final j0.b f2355j;

    /* renamed from: k */
    public final String f2356k;

    /* renamed from: l */
    public final j0.e f2357l;
    public final boolean m;
    public final long n;
    public final boolean o;

    /* loaded from: classes.dex */
    public static final class b extends j0.a {
        public Long a;
        public Long b;
        public j0.c c;

        /* renamed from: d */
        public String f2358d;

        /* renamed from: e */
        public String f2359e;

        /* renamed from: f */
        public String f2360f;

        /* renamed from: g */
        public j0.d f2361g;

        /* renamed from: h */
        public f f2362h;

        /* renamed from: i */
        public Boolean f2363i;

        /* renamed from: j */
        public j0.b f2364j;

        /* renamed from: k */
        public String f2365k;

        /* renamed from: l */
        public j0.e f2366l;
        public Boolean m;
        public Long n;
        public Boolean o;

        public b() {
        }

        public b(j0 j0Var, a aVar) {
            k kVar = (k) j0Var;
            this.a = Long.valueOf(kVar.a);
            this.b = Long.valueOf(kVar.b);
            this.c = kVar.c;
            this.f2358d = kVar.f2349d;
            this.f2359e = kVar.f2350e;
            this.f2360f = kVar.f2351f;
            this.f2361g = kVar.f2352g;
            this.f2362h = kVar.f2353h;
            this.f2363i = Boolean.valueOf(kVar.f2354i);
            this.f2364j = kVar.f2355j;
            this.f2365k = kVar.f2356k;
            this.f2366l = kVar.f2357l;
            this.m = Boolean.valueOf(kVar.m);
            this.n = Long.valueOf(kVar.n);
            this.o = Boolean.valueOf(kVar.o);
        }

        @Override // f.b.a.a.a.n0.j0.a
        public j0 a() {
            String str = this.a == null ? " id" : "";
            if (this.b == null) {
                str = f.a.a.a.a.x(str, " createdTimestampMs");
            }
            if (this.f2363i == null) {
                str = f.a.a.a.a.x(str, " isServerOnsetDate");
            }
            if (this.f2364j == null) {
                str = f.a.a.a.a.x(str, " hasSymptoms");
            }
            if (this.m == null) {
                str = f.a.a.a.a.x(str, " isCodeFromLink");
            }
            if (this.n == null) {
                str = f.a.a.a.a.x(str, " lastUpdatedTimestampMs");
            }
            if (this.o == null) {
                str = f.a.a.a.a.x(str, " isPreAuth");
            }
            if (str.isEmpty()) {
                return new k(this.a.longValue(), this.b.longValue(), this.c, this.f2358d, this.f2359e, this.f2360f, this.f2361g, this.f2362h, this.f2363i.booleanValue(), this.f2364j, this.f2365k, this.f2366l, this.m.booleanValue(), this.n.longValue(), this.o.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.x("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.n0.j0.a
        public j0.a b(long j2) {
            this.b = Long.valueOf(j2);
            return this;
        }

        @Override // f.b.a.a.a.n0.j0.a
        public j0.a c(j0.b bVar) {
            Objects.requireNonNull(bVar, "Null hasSymptoms");
            this.f2364j = bVar;
            return this;
        }

        @Override // f.b.a.a.a.n0.j0.a
        public j0.a d(long j2) {
            this.n = Long.valueOf(j2);
            return this;
        }

        public j0.a e(boolean z) {
            this.m = Boolean.valueOf(z);
            return this;
        }

        public j0.a f(boolean z) {
            this.o = Boolean.valueOf(z);
            return this;
        }

        public j0.a g(boolean z) {
            this.f2363i = Boolean.valueOf(z);
            return this;
        }
    }

    public k(long j2, long j3, j0.c cVar, String str, String str2, String str3, j0.d dVar, f fVar, boolean z, j0.b bVar, String str4, j0.e eVar, boolean z2, long j4, boolean z3, a aVar) {
        this.a = j2;
        this.b = j3;
        this.c = cVar;
        this.f2349d = str;
        this.f2350e = str2;
        this.f2351f = str3;
        this.f2352g = dVar;
        this.f2353h = fVar;
        this.f2354i = z;
        this.f2355j = bVar;
        this.f2356k = str4;
        this.f2357l = eVar;
        this.m = z2;
        this.n = j4;
        this.o = z3;
    }

    @Override // f.b.a.a.a.n0.j0
    public String b() {
        return this.f2351f;
    }

    @Override // f.b.a.a.a.n0.j0
    public long c() {
        return this.b;
    }

    @Override // f.b.a.a.a.n0.j0
    public j0.b d() {
        return this.f2355j;
    }

    @Override // f.b.a.a.a.n0.j0
    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        j0.c cVar;
        String str;
        String str2;
        String str3;
        j0.d dVar;
        f fVar;
        String str4;
        j0.e eVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return this.a == j0Var.e() && this.b == j0Var.c() && ((cVar = this.c) != null ? cVar.equals(j0Var.m()) : j0Var.m() == null) && ((str = this.f2349d) != null ? str.equals(j0Var.p()) : j0Var.p() == null) && ((str2 = this.f2350e) != null ? str2.equals(j0Var.j()) : j0Var.j() == null) && ((str3 = this.f2351f) != null ? str3.equals(j0Var.b()) : j0Var.b() == null) && ((dVar = this.f2352g) != null ? dVar.equals(j0Var.n()) : j0Var.n() == null) && ((fVar = this.f2353h) != null ? fVar.equals(j0Var.k()) : j0Var.k() == null) && this.f2354i == j0Var.h() && this.f2355j.equals(j0Var.d()) && ((str4 = this.f2356k) != null ? str4.equals(j0Var.l()) : j0Var.l() == null) && ((eVar = this.f2357l) != null ? eVar.equals(j0Var.o()) : j0Var.o() == null) && this.m == j0Var.f() && this.n == j0Var.i() && this.o == j0Var.g();
    }

    @Override // f.b.a.a.a.n0.j0
    public boolean f() {
        return this.m;
    }

    @Override // f.b.a.a.a.n0.j0
    public boolean g() {
        return this.o;
    }

    @Override // f.b.a.a.a.n0.j0
    public boolean h() {
        return this.f2354i;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        j0.c cVar = this.c;
        int i3 = 0;
        int hashCode = (i2 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        String str = this.f2349d;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f2350e;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2351f;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        j0.d dVar = this.f2352g;
        int hashCode5 = (hashCode4 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        f fVar = this.f2353h;
        int i4 = 1231;
        int hashCode6 = (((((hashCode5 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003) ^ (this.f2354i ? 1231 : 1237)) * 1000003) ^ this.f2355j.hashCode()) * 1000003;
        String str4 = this.f2356k;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        j0.e eVar = this.f2357l;
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

    @Override // f.b.a.a.a.n0.j0
    public long i() {
        return this.n;
    }

    @Override // f.b.a.a.a.n0.j0
    public String j() {
        return this.f2350e;
    }

    @Override // f.b.a.a.a.n0.j0
    public f k() {
        return this.f2353h;
    }

    @Override // f.b.a.a.a.n0.j0
    public String l() {
        return this.f2356k;
    }

    @Override // f.b.a.a.a.n0.j0
    public j0.c m() {
        return this.c;
    }

    @Override // f.b.a.a.a.n0.j0
    public j0.d n() {
        return this.f2352g;
    }

    @Override // f.b.a.a.a.n0.j0
    public j0.e o() {
        return this.f2357l;
    }

    @Override // f.b.a.a.a.n0.j0
    public String p() {
        return this.f2349d;
    }

    @Override // f.b.a.a.a.n0.j0
    public j0.a r() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("DiagnosisEntity{id=");
        h2.append(this.a);
        h2.append(", createdTimestampMs=");
        h2.append(this.b);
        h2.append(", sharedStatus=");
        h2.append(this.c);
        h2.append(", verificationCode=");
        h2.append(this.f2349d);
        h2.append(", longTermToken=");
        h2.append(this.f2350e);
        h2.append(", certificate=");
        h2.append(this.f2351f);
        h2.append(", testResult=");
        h2.append(this.f2352g);
        h2.append(", onsetDate=");
        h2.append(this.f2353h);
        h2.append(", isServerOnsetDate=");
        h2.append(this.f2354i);
        h2.append(", hasSymptoms=");
        h2.append(this.f2355j);
        h2.append(", revisionToken=");
        h2.append(this.f2356k);
        h2.append(", travelStatus=");
        h2.append(this.f2357l);
        h2.append(", isCodeFromLink=");
        h2.append(this.m);
        h2.append(", lastUpdatedTimestampMs=");
        h2.append(this.n);
        h2.append(", isPreAuth=");
        h2.append(this.o);
        h2.append("}");
        return h2.toString();
    }
}
