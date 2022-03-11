package f.b.a.d.a;

import f.b.a.d.a.h0;
/* loaded from: classes.dex */
public final class q extends h0 {
    public final boolean a;
    public final long b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2857d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2858e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2859f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2860g;

    /* loaded from: classes.dex */
    public static final class b extends h0.a {
        public Boolean a;
        public Long b;
        public Boolean c;

        /* renamed from: d  reason: collision with root package name */
        public String f2861d;

        /* renamed from: e  reason: collision with root package name */
        public String f2862e;

        /* renamed from: f  reason: collision with root package name */
        public String f2863f;

        /* renamed from: g  reason: collision with root package name */
        public String f2864g;

        @Override // f.b.a.d.a.h0.a
        public h0 a() {
            String str = this.a == null ? " enabled" : "";
            if (this.b == null) {
                str = f.a.a.a.a.x(str, " collectionFrequencyHours");
            }
            if (this.c == null) {
                str = f.a.a.a.a.x(str, " deviceAttestationRequired");
            }
            if (this.f2861d == null) {
                str = f.a.a.a.a.x(str, " phaCertificate");
            }
            if (this.f2862e == null) {
                str = f.a.a.a.a.x(str, " facilitatorCertificate");
            }
            if (this.f2863f == null) {
                str = f.a.a.a.a.x(str, " phaEncryptionKeyId");
            }
            if (this.f2864g == null) {
                str = f.a.a.a.a.x(str, " facilitatorEncryptionKeyId");
            }
            if (str.isEmpty()) {
                return new q(this.a.booleanValue(), this.b.longValue(), this.c.booleanValue(), this.f2861d, this.f2862e, this.f2863f, this.f2864g, null);
            }
            throw new IllegalStateException(f.a.a.a.a.x("Missing required properties:", str));
        }
    }

    public q(boolean z, long j2, boolean z2, String str, String str2, String str3, String str4, a aVar) {
        this.a = z;
        this.b = j2;
        this.c = z2;
        this.f2857d = str;
        this.f2858e = str2;
        this.f2859f = str3;
        this.f2860g = str4;
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
        return this.f2858e;
    }

    @Override // f.b.a.d.a.h0
    public String e() {
        return this.f2860g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.a == h0Var.c() && this.b == h0Var.a() && this.c == h0Var.b() && this.f2857d.equals(h0Var.g()) && this.f2858e.equals(h0Var.d()) && this.f2859f.equals(h0Var.h()) && this.f2860g.equals(h0Var.e());
    }

    @Override // f.b.a.d.a.h0
    public String g() {
        return this.f2857d;
    }

    @Override // f.b.a.d.a.h0
    public String h() {
        return this.f2859f;
    }

    public int hashCode() {
        int i2 = 1231;
        int i3 = this.a ? 1231 : 1237;
        long j2 = this.b;
        int i4 = (((i3 ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        if (!this.c) {
            i2 = 1237;
        }
        return ((((((((i4 ^ i2) * 1000003) ^ this.f2857d.hashCode()) * 1000003) ^ this.f2858e.hashCode()) * 1000003) ^ this.f2859f.hashCode()) * 1000003) ^ this.f2860g.hashCode();
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("RemoteConfigs{enabled=");
        h2.append(this.a);
        h2.append(", collectionFrequencyHours=");
        h2.append(this.b);
        h2.append(", deviceAttestationRequired=");
        h2.append(this.c);
        h2.append(", phaCertificate=");
        h2.append(this.f2857d);
        h2.append(", facilitatorCertificate=");
        h2.append(this.f2858e);
        h2.append(", phaEncryptionKeyId=");
        h2.append(this.f2859f);
        h2.append(", facilitatorEncryptionKeyId=");
        return f.a.a.a.a.e(h2, this.f2860g, "}");
    }
}
