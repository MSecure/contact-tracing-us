package f.b.a.a.a.r;

import f.b.a.a.a.r.c0;

public final class r extends c0 {
    public final boolean a;
    public final long b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final double f2215d;

    /* renamed from: e  reason: collision with root package name */
    public final double f2216e;

    /* renamed from: f  reason: collision with root package name */
    public final double f2217f;

    /* renamed from: g  reason: collision with root package name */
    public final double f2218g;

    /* renamed from: h  reason: collision with root package name */
    public final double f2219h;

    /* renamed from: i  reason: collision with root package name */
    public final double f2220i;

    /* renamed from: j  reason: collision with root package name */
    public final String f2221j;

    /* renamed from: k  reason: collision with root package name */
    public final String f2222k;

    /* renamed from: l  reason: collision with root package name */
    public final String f2223l;
    public final String m;

    public static final class b extends c0.a {
        public Boolean a;
        public Long b;
        public Boolean c;

        /* renamed from: d  reason: collision with root package name */
        public Double f2224d;

        /* renamed from: e  reason: collision with root package name */
        public Double f2225e;

        /* renamed from: f  reason: collision with root package name */
        public Double f2226f;

        /* renamed from: g  reason: collision with root package name */
        public Double f2227g;

        /* renamed from: h  reason: collision with root package name */
        public Double f2228h;

        /* renamed from: i  reason: collision with root package name */
        public Double f2229i;

        /* renamed from: j  reason: collision with root package name */
        public String f2230j;

        /* renamed from: k  reason: collision with root package name */
        public String f2231k;

        /* renamed from: l  reason: collision with root package name */
        public String f2232l;
        public String m;

        @Override // f.b.a.a.a.r.c0.a
        public c0 a() {
            String str = this.a == null ? " enabled" : "";
            if (this.b == null) {
                str = f.a.a.a.a.t(str, " collectionFrequencyHours");
            }
            if (this.c == null) {
                str = f.a.a.a.a.t(str, " deviceAttestationRequired");
            }
            if (this.f2224d == null) {
                str = f.a.a.a.a.t(str, " interactionCountPrioEpsilon");
            }
            if (this.f2225e == null) {
                str = f.a.a.a.a.t(str, " interactionCountPrioSamplingRate");
            }
            if (this.f2226f == null) {
                str = f.a.a.a.a.t(str, " notificationCountPrioEpsilon");
            }
            if (this.f2227g == null) {
                str = f.a.a.a.a.t(str, " notificationCountPrioSamplingRate");
            }
            if (this.f2228h == null) {
                str = f.a.a.a.a.t(str, " riskScorePrioEpsilon");
            }
            if (this.f2229i == null) {
                str = f.a.a.a.a.t(str, " riskScorePrioSamplingRate");
            }
            if (this.f2230j == null) {
                str = f.a.a.a.a.t(str, " phaCertificate");
            }
            if (this.f2231k == null) {
                str = f.a.a.a.a.t(str, " facilitatorCertificate");
            }
            if (this.f2232l == null) {
                str = f.a.a.a.a.t(str, " phaEncryptionKeyId");
            }
            if (this.m == null) {
                str = f.a.a.a.a.t(str, " facilitatorEncryptionKeyId");
            }
            if (str.isEmpty()) {
                return new r(this.a.booleanValue(), this.b.longValue(), this.c.booleanValue(), this.f2224d.doubleValue(), this.f2225e.doubleValue(), this.f2226f.doubleValue(), this.f2227g.doubleValue(), this.f2228h.doubleValue(), this.f2229i.doubleValue(), this.f2230j, this.f2231k, this.f2232l, this.m, null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }
    }

    public r(boolean z, long j2, boolean z2, double d2, double d3, double d4, double d5, double d6, double d7, String str, String str2, String str3, String str4, a aVar) {
        this.a = z;
        this.b = j2;
        this.c = z2;
        this.f2215d = d2;
        this.f2216e = d3;
        this.f2217f = d4;
        this.f2218g = d5;
        this.f2219h = d6;
        this.f2220i = d7;
        this.f2221j = str;
        this.f2222k = str2;
        this.f2223l = str3;
        this.m = str4;
    }

    @Override // f.b.a.a.a.r.c0
    public long a() {
        return this.b;
    }

    @Override // f.b.a.a.a.r.c0
    public boolean b() {
        return this.c;
    }

    @Override // f.b.a.a.a.r.c0
    public boolean c() {
        return this.a;
    }

    @Override // f.b.a.a.a.r.c0
    public String d() {
        return this.f2222k;
    }

    @Override // f.b.a.a.a.r.c0
    public String e() {
        return this.m;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.a == c0Var.c() && this.b == c0Var.a() && this.c == c0Var.b() && Double.doubleToLongBits(this.f2215d) == Double.doubleToLongBits(c0Var.f()) && Double.doubleToLongBits(this.f2216e) == Double.doubleToLongBits(c0Var.g()) && Double.doubleToLongBits(this.f2217f) == Double.doubleToLongBits(c0Var.i()) && Double.doubleToLongBits(this.f2218g) == Double.doubleToLongBits(c0Var.j()) && Double.doubleToLongBits(this.f2219h) == Double.doubleToLongBits(c0Var.m()) && Double.doubleToLongBits(this.f2220i) == Double.doubleToLongBits(c0Var.n()) && this.f2221j.equals(c0Var.k()) && this.f2222k.equals(c0Var.d()) && this.f2223l.equals(c0Var.l()) && this.m.equals(c0Var.e());
    }

    @Override // f.b.a.a.a.r.c0
    public double f() {
        return this.f2215d;
    }

    @Override // f.b.a.a.a.r.c0
    public double g() {
        return this.f2216e;
    }

    public int hashCode() {
        int i2 = 1231;
        int i3 = this.a ? 1231 : 1237;
        long j2 = this.b;
        int i4 = (((i3 ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        if (!this.c) {
            i2 = 1237;
        }
        return ((((((((((((((((((((i4 ^ i2) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2215d) >>> 32) ^ Double.doubleToLongBits(this.f2215d)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2216e) >>> 32) ^ Double.doubleToLongBits(this.f2216e)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2217f) >>> 32) ^ Double.doubleToLongBits(this.f2217f)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2218g) >>> 32) ^ Double.doubleToLongBits(this.f2218g)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2219h) >>> 32) ^ Double.doubleToLongBits(this.f2219h)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2220i) >>> 32) ^ Double.doubleToLongBits(this.f2220i)))) * 1000003) ^ this.f2221j.hashCode()) * 1000003) ^ this.f2222k.hashCode()) * 1000003) ^ this.f2223l.hashCode()) * 1000003) ^ this.m.hashCode();
    }

    @Override // f.b.a.a.a.r.c0
    public double i() {
        return this.f2217f;
    }

    @Override // f.b.a.a.a.r.c0
    public double j() {
        return this.f2218g;
    }

    @Override // f.b.a.a.a.r.c0
    public String k() {
        return this.f2221j;
    }

    @Override // f.b.a.a.a.r.c0
    public String l() {
        return this.f2223l;
    }

    @Override // f.b.a.a.a.r.c0
    public double m() {
        return this.f2219h;
    }

    @Override // f.b.a.a.a.r.c0
    public double n() {
        return this.f2220i;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("RemoteConfigs{enabled=");
        h2.append(this.a);
        h2.append(", collectionFrequencyHours=");
        h2.append(this.b);
        h2.append(", deviceAttestationRequired=");
        h2.append(this.c);
        h2.append(", interactionCountPrioEpsilon=");
        h2.append(this.f2215d);
        h2.append(", interactionCountPrioSamplingRate=");
        h2.append(this.f2216e);
        h2.append(", notificationCountPrioEpsilon=");
        h2.append(this.f2217f);
        h2.append(", notificationCountPrioSamplingRate=");
        h2.append(this.f2218g);
        h2.append(", riskScorePrioEpsilon=");
        h2.append(this.f2219h);
        h2.append(", riskScorePrioSamplingRate=");
        h2.append(this.f2220i);
        h2.append(", phaCertificate=");
        h2.append(this.f2221j);
        h2.append(", facilitatorCertificate=");
        h2.append(this.f2222k);
        h2.append(", phaEncryptionKeyId=");
        h2.append(this.f2223l);
        h2.append(", facilitatorEncryptionKeyId=");
        return f.a.a.a.a.e(h2, this.m, "}");
    }
}
