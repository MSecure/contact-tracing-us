package f.b.a.d.a;

import f.b.a.d.a.h0;

public final class q extends h0 {
    public final boolean a;
    public final long b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2815d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2816e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2817f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2818g;

    public static final class b extends h0.a {
        public Boolean a;
        public Long b;
        public Boolean c;

        /* renamed from: d  reason: collision with root package name */
        public String f2819d;

        /* renamed from: e  reason: collision with root package name */
        public String f2820e;

        /* renamed from: f  reason: collision with root package name */
        public String f2821f;

        /* renamed from: g  reason: collision with root package name */
        public String f2822g;

        @Override // f.b.a.d.a.h0.a
        public h0 a() {
            String str = this.a == null ? " enabled" : "";
            if (this.b == null) {
                str = f.a.a.a.a.w(str, " collectionFrequencyHours");
            }
            if (this.c == null) {
                str = f.a.a.a.a.w(str, " deviceAttestationRequired");
            }
            if (this.f2819d == null) {
                str = f.a.a.a.a.w(str, " phaCertificate");
            }
            if (this.f2820e == null) {
                str = f.a.a.a.a.w(str, " facilitatorCertificate");
            }
            if (this.f2821f == null) {
                str = f.a.a.a.a.w(str, " phaEncryptionKeyId");
            }
            if (this.f2822g == null) {
                str = f.a.a.a.a.w(str, " facilitatorEncryptionKeyId");
            }
            if (str.isEmpty()) {
                return new q(this.a.booleanValue(), this.b.longValue(), this.c.booleanValue(), this.f2819d, this.f2820e, this.f2821f, this.f2822g, null);
            }
            throw new IllegalStateException(f.a.a.a.a.w("Missing required properties:", str));
        }
    }

    public q(boolean z, long j2, boolean z2, String str, String str2, String str3, String str4, a aVar) {
        this.a = z;
        this.b = j2;
        this.c = z2;
        this.f2815d = str;
        this.f2816e = str2;
        this.f2817f = str3;
        this.f2818g = str4;
    }

    @Override // f.b.a.d.a.h0
    public long a() {
        return this.b;
    }

    @Override // f.b.a.d.a.h0
    public boolean b() {
        return this.c;
    }

    @Override // f.b.a.d.a.h0
    public boolean c() {
        return this.a;
    }

    @Override // f.b.a.d.a.h0
    public String d() {
        return this.f2816e;
    }

    @Override // f.b.a.d.a.h0
    public String e() {
        return this.f2818g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.a == h0Var.c() && this.b == h0Var.a() && this.c == h0Var.b() && this.f2815d.equals(h0Var.g()) && this.f2816e.equals(h0Var.d()) && this.f2817f.equals(h0Var.h()) && this.f2818g.equals(h0Var.e());
    }

    @Override // f.b.a.d.a.h0
    public String g() {
        return this.f2815d;
    }

    @Override // f.b.a.d.a.h0
    public String h() {
        return this.f2817f;
    }

    public int hashCode() {
        int i2 = 1231;
        int i3 = this.a ? 1231 : 1237;
        long j2 = this.b;
        int i4 = (((i3 ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        if (!this.c) {
            i2 = 1237;
        }
        return ((((((((i4 ^ i2) * 1000003) ^ this.f2815d.hashCode()) * 1000003) ^ this.f2816e.hashCode()) * 1000003) ^ this.f2817f.hashCode()) * 1000003) ^ this.f2818g.hashCode();
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("RemoteConfigs{enabled=");
        h2.append(this.a);
        h2.append(", collectionFrequencyHours=");
        h2.append(this.b);
        h2.append(", deviceAttestationRequired=");
        h2.append(this.c);
        h2.append(", phaCertificate=");
        h2.append(this.f2815d);
        h2.append(", facilitatorCertificate=");
        h2.append(this.f2816e);
        h2.append(", phaEncryptionKeyId=");
        h2.append(this.f2817f);
        h2.append(", facilitatorEncryptionKeyId=");
        return f.a.a.a.a.e(h2, this.f2818g, "}");
    }
}
