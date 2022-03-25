package f.b.a.a.a.t;

import f.b.a.a.a.t.b0;

public final class r extends b0 {
    public final boolean a;
    public final long b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final double f2292d;

    /* renamed from: e  reason: collision with root package name */
    public final double f2293e;

    /* renamed from: f  reason: collision with root package name */
    public final double f2294f;

    /* renamed from: g  reason: collision with root package name */
    public final double f2295g;

    /* renamed from: h  reason: collision with root package name */
    public final double f2296h;

    /* renamed from: i  reason: collision with root package name */
    public final double f2297i;

    /* renamed from: j  reason: collision with root package name */
    public final double f2298j;

    /* renamed from: k  reason: collision with root package name */
    public final double f2299k;

    /* renamed from: l  reason: collision with root package name */
    public final double f2300l;
    public final double m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;

    public static final class b extends b0.a {
        public Boolean a;
        public Long b;
        public Boolean c;

        /* renamed from: d  reason: collision with root package name */
        public Double f2301d;

        /* renamed from: e  reason: collision with root package name */
        public Double f2302e;

        /* renamed from: f  reason: collision with root package name */
        public Double f2303f;

        /* renamed from: g  reason: collision with root package name */
        public Double f2304g;

        /* renamed from: h  reason: collision with root package name */
        public Double f2305h;

        /* renamed from: i  reason: collision with root package name */
        public Double f2306i;

        /* renamed from: j  reason: collision with root package name */
        public Double f2307j;

        /* renamed from: k  reason: collision with root package name */
        public Double f2308k;

        /* renamed from: l  reason: collision with root package name */
        public Double f2309l;
        public Double m;
        public String n;
        public String o;
        public String p;
        public String q;

        @Override // f.b.a.a.a.t.b0.a
        public b0 a() {
            String str = this.a == null ? " enabled" : "";
            if (this.b == null) {
                str = f.a.a.a.a.t(str, " collectionFrequencyHours");
            }
            if (this.c == null) {
                str = f.a.a.a.a.t(str, " deviceAttestationRequired");
            }
            if (this.f2301d == null) {
                str = f.a.a.a.a.t(str, " interactionCountPrioEpsilon");
            }
            if (this.f2302e == null) {
                str = f.a.a.a.a.t(str, " interactionCountPrioSamplingRate");
            }
            if (this.f2303f == null) {
                str = f.a.a.a.a.t(str, " notificationCountPrioEpsilon");
            }
            if (this.f2304g == null) {
                str = f.a.a.a.a.t(str, " notificationCountPrioSamplingRate");
            }
            if (this.f2305h == null) {
                str = f.a.a.a.a.t(str, " riskScorePrioEpsilon");
            }
            if (this.f2306i == null) {
                str = f.a.a.a.a.t(str, " riskScorePrioSamplingRate");
            }
            if (this.f2307j == null) {
                str = f.a.a.a.a.t(str, " codeVerifiedPrioEpsilon");
            }
            if (this.f2308k == null) {
                str = f.a.a.a.a.t(str, " codeVerifiedPrioSamplingRate");
            }
            if (this.f2309l == null) {
                str = f.a.a.a.a.t(str, " keysUploadedPrioEpsilon");
            }
            if (this.m == null) {
                str = f.a.a.a.a.t(str, " keysUploadedPrioSamplingRate");
            }
            if (this.n == null) {
                str = f.a.a.a.a.t(str, " phaCertificate");
            }
            if (this.o == null) {
                str = f.a.a.a.a.t(str, " facilitatorCertificate");
            }
            if (this.p == null) {
                str = f.a.a.a.a.t(str, " phaEncryptionKeyId");
            }
            if (this.q == null) {
                str = f.a.a.a.a.t(str, " facilitatorEncryptionKeyId");
            }
            if (str.isEmpty()) {
                return new r(this.a.booleanValue(), this.b.longValue(), this.c.booleanValue(), this.f2301d.doubleValue(), this.f2302e.doubleValue(), this.f2303f.doubleValue(), this.f2304g.doubleValue(), this.f2305h.doubleValue(), this.f2306i.doubleValue(), this.f2307j.doubleValue(), this.f2308k.doubleValue(), this.f2309l.doubleValue(), this.m.doubleValue(), this.n, this.o, this.p, this.q, null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }
    }

    public r(boolean z, long j2, boolean z2, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, String str, String str2, String str3, String str4, a aVar) {
        this.a = z;
        this.b = j2;
        this.c = z2;
        this.f2292d = d2;
        this.f2293e = d3;
        this.f2294f = d4;
        this.f2295g = d5;
        this.f2296h = d6;
        this.f2297i = d7;
        this.f2298j = d8;
        this.f2299k = d9;
        this.f2300l = d10;
        this.m = d11;
        this.n = str;
        this.o = str2;
        this.p = str3;
        this.q = str4;
    }

    @Override // f.b.a.a.a.t.b0
    public double a() {
        return this.f2298j;
    }

    @Override // f.b.a.a.a.t.b0
    public double b() {
        return this.f2299k;
    }

    @Override // f.b.a.a.a.t.b0
    public long c() {
        return this.b;
    }

    @Override // f.b.a.a.a.t.b0
    public boolean d() {
        return this.c;
    }

    @Override // f.b.a.a.a.t.b0
    public boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.a == b0Var.e() && this.b == b0Var.c() && this.c == b0Var.d() && Double.doubleToLongBits(this.f2292d) == Double.doubleToLongBits(b0Var.h()) && Double.doubleToLongBits(this.f2293e) == Double.doubleToLongBits(b0Var.i()) && Double.doubleToLongBits(this.f2294f) == Double.doubleToLongBits(b0Var.m()) && Double.doubleToLongBits(this.f2295g) == Double.doubleToLongBits(b0Var.n()) && Double.doubleToLongBits(this.f2296h) == Double.doubleToLongBits(b0Var.q()) && Double.doubleToLongBits(this.f2297i) == Double.doubleToLongBits(b0Var.r()) && Double.doubleToLongBits(this.f2298j) == Double.doubleToLongBits(b0Var.a()) && Double.doubleToLongBits(this.f2299k) == Double.doubleToLongBits(b0Var.b()) && Double.doubleToLongBits(this.f2300l) == Double.doubleToLongBits(b0Var.j()) && Double.doubleToLongBits(this.m) == Double.doubleToLongBits(b0Var.k()) && this.n.equals(b0Var.o()) && this.o.equals(b0Var.f()) && this.p.equals(b0Var.p()) && this.q.equals(b0Var.g());
    }

    @Override // f.b.a.a.a.t.b0
    public String f() {
        return this.o;
    }

    @Override // f.b.a.a.a.t.b0
    public String g() {
        return this.q;
    }

    @Override // f.b.a.a.a.t.b0
    public double h() {
        return this.f2292d;
    }

    public int hashCode() {
        int i2 = 1231;
        int i3 = this.a ? 1231 : 1237;
        long j2 = this.b;
        int i4 = (((i3 ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        if (!this.c) {
            i2 = 1237;
        }
        return ((((((((((((((((((((((((((((i4 ^ i2) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2292d) >>> 32) ^ Double.doubleToLongBits(this.f2292d)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2293e) >>> 32) ^ Double.doubleToLongBits(this.f2293e)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2294f) >>> 32) ^ Double.doubleToLongBits(this.f2294f)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2295g) >>> 32) ^ Double.doubleToLongBits(this.f2295g)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2296h) >>> 32) ^ Double.doubleToLongBits(this.f2296h)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2297i) >>> 32) ^ Double.doubleToLongBits(this.f2297i)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2298j) >>> 32) ^ Double.doubleToLongBits(this.f2298j)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2299k) >>> 32) ^ Double.doubleToLongBits(this.f2299k)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2300l) >>> 32) ^ Double.doubleToLongBits(this.f2300l)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.m) >>> 32) ^ Double.doubleToLongBits(this.m)))) * 1000003) ^ this.n.hashCode()) * 1000003) ^ this.o.hashCode()) * 1000003) ^ this.p.hashCode()) * 1000003) ^ this.q.hashCode();
    }

    @Override // f.b.a.a.a.t.b0
    public double i() {
        return this.f2293e;
    }

    @Override // f.b.a.a.a.t.b0
    public double j() {
        return this.f2300l;
    }

    @Override // f.b.a.a.a.t.b0
    public double k() {
        return this.m;
    }

    @Override // f.b.a.a.a.t.b0
    public double m() {
        return this.f2294f;
    }

    @Override // f.b.a.a.a.t.b0
    public double n() {
        return this.f2295g;
    }

    @Override // f.b.a.a.a.t.b0
    public String o() {
        return this.n;
    }

    @Override // f.b.a.a.a.t.b0
    public String p() {
        return this.p;
    }

    @Override // f.b.a.a.a.t.b0
    public double q() {
        return this.f2296h;
    }

    @Override // f.b.a.a.a.t.b0
    public double r() {
        return this.f2297i;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("RemoteConfigs{enabled=");
        h2.append(this.a);
        h2.append(", collectionFrequencyHours=");
        h2.append(this.b);
        h2.append(", deviceAttestationRequired=");
        h2.append(this.c);
        h2.append(", interactionCountPrioEpsilon=");
        h2.append(this.f2292d);
        h2.append(", interactionCountPrioSamplingRate=");
        h2.append(this.f2293e);
        h2.append(", notificationCountPrioEpsilon=");
        h2.append(this.f2294f);
        h2.append(", notificationCountPrioSamplingRate=");
        h2.append(this.f2295g);
        h2.append(", riskScorePrioEpsilon=");
        h2.append(this.f2296h);
        h2.append(", riskScorePrioSamplingRate=");
        h2.append(this.f2297i);
        h2.append(", codeVerifiedPrioEpsilon=");
        h2.append(this.f2298j);
        h2.append(", codeVerifiedPrioSamplingRate=");
        h2.append(this.f2299k);
        h2.append(", keysUploadedPrioEpsilon=");
        h2.append(this.f2300l);
        h2.append(", keysUploadedPrioSamplingRate=");
        h2.append(this.m);
        h2.append(", phaCertificate=");
        h2.append(this.n);
        h2.append(", facilitatorCertificate=");
        h2.append(this.o);
        h2.append(", phaEncryptionKeyId=");
        h2.append(this.p);
        h2.append(", facilitatorEncryptionKeyId=");
        return f.a.a.a.a.e(h2, this.q, "}");
    }
}
