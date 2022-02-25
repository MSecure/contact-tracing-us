package f.b.a.a.a.r;

import f.b.a.a.a.r.a0;

public final class q extends a0 {
    public final boolean a;
    public final long b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final double f2208d;

    /* renamed from: e  reason: collision with root package name */
    public final double f2209e;

    /* renamed from: f  reason: collision with root package name */
    public final double f2210f;

    /* renamed from: g  reason: collision with root package name */
    public final double f2211g;

    /* renamed from: h  reason: collision with root package name */
    public final double f2212h;

    /* renamed from: i  reason: collision with root package name */
    public final double f2213i;

    /* renamed from: j  reason: collision with root package name */
    public final String f2214j;

    /* renamed from: k  reason: collision with root package name */
    public final String f2215k;

    /* renamed from: l  reason: collision with root package name */
    public final String f2216l;
    public final String m;

    public static final class b extends a0.a {
        public Boolean a;
        public Long b;
        public Boolean c;

        /* renamed from: d  reason: collision with root package name */
        public Double f2217d;

        /* renamed from: e  reason: collision with root package name */
        public Double f2218e;

        /* renamed from: f  reason: collision with root package name */
        public Double f2219f;

        /* renamed from: g  reason: collision with root package name */
        public Double f2220g;

        /* renamed from: h  reason: collision with root package name */
        public Double f2221h;

        /* renamed from: i  reason: collision with root package name */
        public Double f2222i;

        /* renamed from: j  reason: collision with root package name */
        public String f2223j;

        /* renamed from: k  reason: collision with root package name */
        public String f2224k;

        /* renamed from: l  reason: collision with root package name */
        public String f2225l;
        public String m;

        @Override // f.b.a.a.a.r.a0.a
        public a0 a() {
            String str = this.a == null ? " enabled" : "";
            if (this.b == null) {
                str = f.a.a.a.a.t(str, " collectionFrequencyHours");
            }
            if (this.c == null) {
                str = f.a.a.a.a.t(str, " deviceAttestationRequired");
            }
            if (this.f2217d == null) {
                str = f.a.a.a.a.t(str, " interactionCountPrioEpsilon");
            }
            if (this.f2218e == null) {
                str = f.a.a.a.a.t(str, " interactionCountPrioSamplingRate");
            }
            if (this.f2219f == null) {
                str = f.a.a.a.a.t(str, " notificationCountPrioEpsilon");
            }
            if (this.f2220g == null) {
                str = f.a.a.a.a.t(str, " notificationCountPrioSamplingRate");
            }
            if (this.f2221h == null) {
                str = f.a.a.a.a.t(str, " riskScorePrioEpsilon");
            }
            if (this.f2222i == null) {
                str = f.a.a.a.a.t(str, " riskScorePrioSamplingRate");
            }
            if (this.f2223j == null) {
                str = f.a.a.a.a.t(str, " phaCertificate");
            }
            if (this.f2224k == null) {
                str = f.a.a.a.a.t(str, " facilitatorCertificate");
            }
            if (this.f2225l == null) {
                str = f.a.a.a.a.t(str, " phaEncryptionKeyId");
            }
            if (this.m == null) {
                str = f.a.a.a.a.t(str, " facilitatorEncryptionKeyId");
            }
            if (str.isEmpty()) {
                return new q(this.a.booleanValue(), this.b.longValue(), this.c.booleanValue(), this.f2217d.doubleValue(), this.f2218e.doubleValue(), this.f2219f.doubleValue(), this.f2220g.doubleValue(), this.f2221h.doubleValue(), this.f2222i.doubleValue(), this.f2223j, this.f2224k, this.f2225l, this.m, null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }
    }

    public q(boolean z, long j2, boolean z2, double d2, double d3, double d4, double d5, double d6, double d7, String str, String str2, String str3, String str4, a aVar) {
        this.a = z;
        this.b = j2;
        this.c = z2;
        this.f2208d = d2;
        this.f2209e = d3;
        this.f2210f = d4;
        this.f2211g = d5;
        this.f2212h = d6;
        this.f2213i = d7;
        this.f2214j = str;
        this.f2215k = str2;
        this.f2216l = str3;
        this.m = str4;
    }

    @Override // f.b.a.a.a.r.a0
    public long a() {
        return this.b;
    }

    @Override // f.b.a.a.a.r.a0
    public boolean b() {
        return this.c;
    }

    @Override // f.b.a.a.a.r.a0
    public boolean c() {
        return this.a;
    }

    @Override // f.b.a.a.a.r.a0
    public String d() {
        return this.f2215k;
    }

    @Override // f.b.a.a.a.r.a0
    public String e() {
        return this.m;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.a == a0Var.c() && this.b == a0Var.a() && this.c == a0Var.b() && Double.doubleToLongBits(this.f2208d) == Double.doubleToLongBits(a0Var.f()) && Double.doubleToLongBits(this.f2209e) == Double.doubleToLongBits(a0Var.g()) && Double.doubleToLongBits(this.f2210f) == Double.doubleToLongBits(a0Var.i()) && Double.doubleToLongBits(this.f2211g) == Double.doubleToLongBits(a0Var.j()) && Double.doubleToLongBits(this.f2212h) == Double.doubleToLongBits(a0Var.m()) && Double.doubleToLongBits(this.f2213i) == Double.doubleToLongBits(a0Var.n()) && this.f2214j.equals(a0Var.k()) && this.f2215k.equals(a0Var.d()) && this.f2216l.equals(a0Var.l()) && this.m.equals(a0Var.e());
    }

    @Override // f.b.a.a.a.r.a0
    public double f() {
        return this.f2208d;
    }

    @Override // f.b.a.a.a.r.a0
    public double g() {
        return this.f2209e;
    }

    public int hashCode() {
        int i2 = 1231;
        int i3 = this.a ? 1231 : 1237;
        long j2 = this.b;
        int i4 = (((i3 ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        if (!this.c) {
            i2 = 1237;
        }
        return ((((((((((((((((((((i4 ^ i2) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2208d) >>> 32) ^ Double.doubleToLongBits(this.f2208d)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2209e) >>> 32) ^ Double.doubleToLongBits(this.f2209e)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2210f) >>> 32) ^ Double.doubleToLongBits(this.f2210f)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2211g) >>> 32) ^ Double.doubleToLongBits(this.f2211g)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2212h) >>> 32) ^ Double.doubleToLongBits(this.f2212h)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2213i) >>> 32) ^ Double.doubleToLongBits(this.f2213i)))) * 1000003) ^ this.f2214j.hashCode()) * 1000003) ^ this.f2215k.hashCode()) * 1000003) ^ this.f2216l.hashCode()) * 1000003) ^ this.m.hashCode();
    }

    @Override // f.b.a.a.a.r.a0
    public double i() {
        return this.f2210f;
    }

    @Override // f.b.a.a.a.r.a0
    public double j() {
        return this.f2211g;
    }

    @Override // f.b.a.a.a.r.a0
    public String k() {
        return this.f2214j;
    }

    @Override // f.b.a.a.a.r.a0
    public String l() {
        return this.f2216l;
    }

    @Override // f.b.a.a.a.r.a0
    public double m() {
        return this.f2212h;
    }

    @Override // f.b.a.a.a.r.a0
    public double n() {
        return this.f2213i;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("RemoteConfigs{enabled=");
        h2.append(this.a);
        h2.append(", collectionFrequencyHours=");
        h2.append(this.b);
        h2.append(", deviceAttestationRequired=");
        h2.append(this.c);
        h2.append(", interactionCountPrioEpsilon=");
        h2.append(this.f2208d);
        h2.append(", interactionCountPrioSamplingRate=");
        h2.append(this.f2209e);
        h2.append(", notificationCountPrioEpsilon=");
        h2.append(this.f2210f);
        h2.append(", notificationCountPrioSamplingRate=");
        h2.append(this.f2211g);
        h2.append(", riskScorePrioEpsilon=");
        h2.append(this.f2212h);
        h2.append(", riskScorePrioSamplingRate=");
        h2.append(this.f2213i);
        h2.append(", phaCertificate=");
        h2.append(this.f2214j);
        h2.append(", facilitatorCertificate=");
        h2.append(this.f2215k);
        h2.append(", phaEncryptionKeyId=");
        h2.append(this.f2216l);
        h2.append(", facilitatorEncryptionKeyId=");
        return f.a.a.a.a.e(h2, this.m, "}");
    }
}
