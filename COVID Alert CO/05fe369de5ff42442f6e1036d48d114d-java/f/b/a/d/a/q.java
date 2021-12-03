package f.b.a.d.a;

import f.b.a.d.a.h0;

public final class q extends h0 {
    public final boolean a;
    public final long b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2761d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2762e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2763f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2764g;

    public static final class b extends h0.a {
        public Boolean a;
        public Long b;
        public Boolean c;

        /* renamed from: d  reason: collision with root package name */
        public String f2765d;

        /* renamed from: e  reason: collision with root package name */
        public String f2766e;

        /* renamed from: f  reason: collision with root package name */
        public String f2767f;

        /* renamed from: g  reason: collision with root package name */
        public String f2768g;

        @Override // f.b.a.d.a.h0.a
        public h0 a() {
            String str = this.a == null ? " enabled" : "";
            if (this.b == null) {
                str = f.a.a.a.a.c(str, " collectionFrequencyHours");
            }
            if (this.c == null) {
                str = f.a.a.a.a.c(str, " deviceAttestationRequired");
            }
            if (this.f2765d == null) {
                str = f.a.a.a.a.c(str, " phaCertificate");
            }
            if (this.f2766e == null) {
                str = f.a.a.a.a.c(str, " facilitatorCertificate");
            }
            if (this.f2767f == null) {
                str = f.a.a.a.a.c(str, " phaEncryptionKeyId");
            }
            if (this.f2768g == null) {
                str = f.a.a.a.a.c(str, " facilitatorEncryptionKeyId");
            }
            if (str.isEmpty()) {
                return new q(this.a.booleanValue(), this.b.longValue(), this.c.booleanValue(), this.f2765d, this.f2766e, this.f2767f, this.f2768g, null);
            }
            throw new IllegalStateException(f.a.a.a.a.c("Missing required properties:", str));
        }
    }

    public q(boolean z, long j2, boolean z2, String str, String str2, String str3, String str4, a aVar) {
        this.a = z;
        this.b = j2;
        this.c = z2;
        this.f2761d = str;
        this.f2762e = str2;
        this.f2763f = str3;
        this.f2764g = str4;
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
        return this.f2762e;
    }

    @Override // f.b.a.d.a.h0
    public String e() {
        return this.f2764g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.a == h0Var.c() && this.b == h0Var.a() && this.c == h0Var.b() && this.f2761d.equals(h0Var.g()) && this.f2762e.equals(h0Var.d()) && this.f2763f.equals(h0Var.h()) && this.f2764g.equals(h0Var.e());
    }

    @Override // f.b.a.d.a.h0
    public String g() {
        return this.f2761d;
    }

    @Override // f.b.a.d.a.h0
    public String h() {
        return this.f2763f;
    }

    public int hashCode() {
        int i2 = 1231;
        int i3 = this.a ? 1231 : 1237;
        long j2 = this.b;
        int i4 = (((i3 ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        if (!this.c) {
            i2 = 1237;
        }
        return ((((((((i4 ^ i2) * 1000003) ^ this.f2761d.hashCode()) * 1000003) ^ this.f2762e.hashCode()) * 1000003) ^ this.f2763f.hashCode()) * 1000003) ^ this.f2764g.hashCode();
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("RemoteConfigs{enabled=");
        i2.append(this.a);
        i2.append(", collectionFrequencyHours=");
        i2.append(this.b);
        i2.append(", deviceAttestationRequired=");
        i2.append(this.c);
        i2.append(", phaCertificate=");
        i2.append(this.f2761d);
        i2.append(", facilitatorCertificate=");
        i2.append(this.f2762e);
        i2.append(", phaEncryptionKeyId=");
        i2.append(this.f2763f);
        i2.append(", facilitatorEncryptionKeyId=");
        return f.a.a.a.a.f(i2, this.f2764g, "}");
    }
}
