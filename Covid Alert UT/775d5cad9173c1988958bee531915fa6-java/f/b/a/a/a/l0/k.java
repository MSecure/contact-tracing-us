package f.b.a.a.a.l0;

import f.b.a.a.a.l0.h0;
import java.util.Objects;
import l.b.a.f;

public final class k extends h0 {
    public final long a;
    public final long b;
    public final h0.c c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2292d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2293e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2294f;

    /* renamed from: g  reason: collision with root package name */
    public final h0.d f2295g;

    /* renamed from: h  reason: collision with root package name */
    public final f f2296h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2297i;

    /* renamed from: j  reason: collision with root package name */
    public final h0.b f2298j;

    /* renamed from: k  reason: collision with root package name */
    public final String f2299k;

    /* renamed from: l  reason: collision with root package name */
    public final h0.e f2300l;
    public final boolean m;
    public final long n;
    public final boolean o;

    public static final class b extends h0.a {
        public Long a;
        public Long b;
        public h0.c c;

        /* renamed from: d  reason: collision with root package name */
        public String f2301d;

        /* renamed from: e  reason: collision with root package name */
        public String f2302e;

        /* renamed from: f  reason: collision with root package name */
        public String f2303f;

        /* renamed from: g  reason: collision with root package name */
        public h0.d f2304g;

        /* renamed from: h  reason: collision with root package name */
        public f f2305h;

        /* renamed from: i  reason: collision with root package name */
        public Boolean f2306i;

        /* renamed from: j  reason: collision with root package name */
        public h0.b f2307j;

        /* renamed from: k  reason: collision with root package name */
        public String f2308k;

        /* renamed from: l  reason: collision with root package name */
        public h0.e f2309l;
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
            this.f2301d = kVar.f2292d;
            this.f2302e = kVar.f2293e;
            this.f2303f = kVar.f2294f;
            this.f2304g = kVar.f2295g;
            this.f2305h = kVar.f2296h;
            this.f2306i = Boolean.valueOf(kVar.f2297i);
            this.f2307j = kVar.f2298j;
            this.f2308k = kVar.f2299k;
            this.f2309l = kVar.f2300l;
            this.m = Boolean.valueOf(kVar.m);
            this.n = Long.valueOf(kVar.n);
            this.o = Boolean.valueOf(kVar.o);
        }

        @Override // f.b.a.a.a.l0.h0.a
        public h0 a() {
            String str = this.a == null ? " id" : "";
            if (this.b == null) {
                str = f.a.a.a.a.w(str, " createdTimestampMs");
            }
            if (this.f2306i == null) {
                str = f.a.a.a.a.w(str, " isServerOnsetDate");
            }
            if (this.f2307j == null) {
                str = f.a.a.a.a.w(str, " hasSymptoms");
            }
            if (this.m == null) {
                str = f.a.a.a.a.w(str, " isCodeFromLink");
            }
            if (this.n == null) {
                str = f.a.a.a.a.w(str, " lastUpdatedTimestampMs");
            }
            if (this.o == null) {
                str = f.a.a.a.a.w(str, " isPreAuth");
            }
            if (str.isEmpty()) {
                return new k(this.a.longValue(), this.b.longValue(), this.c, this.f2301d, this.f2302e, this.f2303f, this.f2304g, this.f2305h, this.f2306i.booleanValue(), this.f2307j, this.f2308k, this.f2309l, this.m.booleanValue(), this.n.longValue(), this.o.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.w("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.l0.h0.a
        public h0.a b(long j2) {
            this.b = Long.valueOf(j2);
            return this;
        }

        @Override // f.b.a.a.a.l0.h0.a
        public h0.a c(h0.b bVar) {
            Objects.requireNonNull(bVar, "Null hasSymptoms");
            this.f2307j = bVar;
            return this;
        }

        @Override // f.b.a.a.a.l0.h0.a
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
            this.f2306i = Boolean.valueOf(z);
            return this;
        }
    }

    public k(long j2, long j3, h0.c cVar, String str, String str2, String str3, h0.d dVar, f fVar, boolean z, h0.b bVar, String str4, h0.e eVar, boolean z2, long j4, boolean z3, a aVar) {
        this.a = j2;
        this.b = j3;
        this.c = cVar;
        this.f2292d = str;
        this.f2293e = str2;
        this.f2294f = str3;
        this.f2295g = dVar;
        this.f2296h = fVar;
        this.f2297i = z;
        this.f2298j = bVar;
        this.f2299k = str4;
        this.f2300l = eVar;
        this.m = z2;
        this.n = j4;
        this.o = z3;
    }

    @Override // f.b.a.a.a.l0.h0
    public String b() {
        return this.f2294f;
    }

    @Override // f.b.a.a.a.l0.h0
    public long c() {
        return this.b;
    }

    @Override // f.b.a.a.a.l0.h0
    public h0.b d() {
        return this.f2298j;
    }

    @Override // f.b.a.a.a.l0.h0
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
        return this.a == h0Var.e() && this.b == h0Var.c() && ((cVar = this.c) != null ? cVar.equals(h0Var.m()) : h0Var.m() == null) && ((str = this.f2292d) != null ? str.equals(h0Var.p()) : h0Var.p() == null) && ((str2 = this.f2293e) != null ? str2.equals(h0Var.j()) : h0Var.j() == null) && ((str3 = this.f2294f) != null ? str3.equals(h0Var.b()) : h0Var.b() == null) && ((dVar = this.f2295g) != null ? dVar.equals(h0Var.n()) : h0Var.n() == null) && ((fVar = this.f2296h) != null ? fVar.equals(h0Var.k()) : h0Var.k() == null) && this.f2297i == h0Var.h() && this.f2298j.equals(h0Var.d()) && ((str4 = this.f2299k) != null ? str4.equals(h0Var.l()) : h0Var.l() == null) && ((eVar = this.f2300l) != null ? eVar.equals(h0Var.o()) : h0Var.o() == null) && this.m == h0Var.f() && this.n == h0Var.i() && this.o == h0Var.g();
    }

    @Override // f.b.a.a.a.l0.h0
    public boolean f() {
        return this.m;
    }

    @Override // f.b.a.a.a.l0.h0
    public boolean g() {
        return this.o;
    }

    @Override // f.b.a.a.a.l0.h0
    public boolean h() {
        return this.f2297i;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        h0.c cVar = this.c;
        int i3 = 0;
        int hashCode = (i2 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        String str = this.f2292d;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f2293e;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2294f;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        h0.d dVar = this.f2295g;
        int hashCode5 = (hashCode4 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        f fVar = this.f2296h;
        int i4 = 1231;
        int hashCode6 = (((((hashCode5 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003) ^ (this.f2297i ? 1231 : 1237)) * 1000003) ^ this.f2298j.hashCode()) * 1000003;
        String str4 = this.f2299k;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        h0.e eVar = this.f2300l;
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

    @Override // f.b.a.a.a.l0.h0
    public long i() {
        return this.n;
    }

    @Override // f.b.a.a.a.l0.h0
    public String j() {
        return this.f2293e;
    }

    @Override // f.b.a.a.a.l0.h0
    public f k() {
        return this.f2296h;
    }

    @Override // f.b.a.a.a.l0.h0
    public String l() {
        return this.f2299k;
    }

    @Override // f.b.a.a.a.l0.h0
    public h0.c m() {
        return this.c;
    }

    @Override // f.b.a.a.a.l0.h0
    public h0.d n() {
        return this.f2295g;
    }

    @Override // f.b.a.a.a.l0.h0
    public h0.e o() {
        return this.f2300l;
    }

    @Override // f.b.a.a.a.l0.h0
    public String p() {
        return this.f2292d;
    }

    @Override // f.b.a.a.a.l0.h0
    public h0.a r() {
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
        h2.append(this.f2292d);
        h2.append(", longTermToken=");
        h2.append(this.f2293e);
        h2.append(", certificate=");
        h2.append(this.f2294f);
        h2.append(", testResult=");
        h2.append(this.f2295g);
        h2.append(", onsetDate=");
        h2.append(this.f2296h);
        h2.append(", isServerOnsetDate=");
        h2.append(this.f2297i);
        h2.append(", hasSymptoms=");
        h2.append(this.f2298j);
        h2.append(", revisionToken=");
        h2.append(this.f2299k);
        h2.append(", travelStatus=");
        h2.append(this.f2300l);
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
