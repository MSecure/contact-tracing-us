package f.b.a.b.h.b;

import f.a.a.a.a;

public final class h extends a {
    public final Integer a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2382d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2383e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2384f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2385g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2386h;

    public /* synthetic */ h(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = num;
        this.b = str;
        this.c = str2;
        this.f2382d = str3;
        this.f2383e = str4;
        this.f2384f = str5;
        this.f2385g = str6;
        this.f2386h = str7;
    }

    @Override // f.b.a.b.h.b.a
    public String a() {
        return this.f2382d;
    }

    @Override // f.b.a.b.h.b.a
    public String b() {
        return this.f2386h;
    }

    @Override // f.b.a.b.h.b.a
    public String c() {
        return this.c;
    }

    @Override // f.b.a.b.h.b.a
    public String d() {
        return this.f2385g;
    }

    @Override // f.b.a.b.h.b.a
    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        Integer num = this.a;
        if (num != null ? num.equals(((h) obj).a) : ((h) obj).a == null) {
            String str = this.b;
            if (str != null ? str.equals(((h) obj).b) : ((h) obj).b == null) {
                String str2 = this.c;
                if (str2 != null ? str2.equals(((h) obj).c) : ((h) obj).c == null) {
                    String str3 = this.f2382d;
                    if (str3 != null ? str3.equals(((h) obj).f2382d) : ((h) obj).f2382d == null) {
                        String str4 = this.f2383e;
                        if (str4 != null ? str4.equals(((h) obj).f2383e) : ((h) obj).f2383e == null) {
                            String str5 = this.f2384f;
                            if (str5 != null ? str5.equals(((h) obj).f2384f) : ((h) obj).f2384f == null) {
                                String str6 = this.f2385g;
                                if (str6 != null ? str6.equals(((h) obj).f2385g) : ((h) obj).f2385g == null) {
                                    String str7 = this.f2386h;
                                    String str8 = ((h) obj).f2386h;
                                    if (str7 == null) {
                                        if (str8 == null) {
                                            return true;
                                        }
                                    } else if (str7.equals(str8)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // f.b.a.b.h.b.a
    public String f() {
        return this.f2384f;
    }

    @Override // f.b.a.b.h.b.a
    public String g() {
        return this.f2383e;
    }

    @Override // f.b.a.b.h.b.a
    public Integer h() {
        return this.a;
    }

    public int hashCode() {
        Integer num = this.a;
        int i2 = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2382d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f2383e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f2384f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f2385g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f2386h;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode7 ^ i2;
    }

    public String toString() {
        StringBuilder h2 = a.h("AndroidClientInfo{sdkVersion=");
        h2.append(this.a);
        h2.append(", model=");
        h2.append(this.b);
        h2.append(", hardware=");
        h2.append(this.c);
        h2.append(", device=");
        h2.append(this.f2382d);
        h2.append(", product=");
        h2.append(this.f2383e);
        h2.append(", osBuild=");
        h2.append(this.f2384f);
        h2.append(", manufacturer=");
        h2.append(this.f2385g);
        h2.append(", fingerprint=");
        return a.e(h2, this.f2386h, "}");
    }
}
