package f.b.a.a.a.n;

import f.b.a.a.a.n.u;
import f.b.a.a.a.q.d;
import f.b.b.b.c;
import java.util.Collection;
import l.b.a.e;

public final class r extends u {
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final c<d> f2175d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2176e;

    /* renamed from: f  reason: collision with root package name */
    public final c<String> f2177f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2178g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2179h;

    /* renamed from: i  reason: collision with root package name */
    public final String f2180i;

    /* renamed from: j  reason: collision with root package name */
    public final String f2181j;

    /* renamed from: k  reason: collision with root package name */
    public final e f2182k;

    /* renamed from: l  reason: collision with root package name */
    public final e f2183l;
    public final String m;
    public final boolean n;
    public final int o;
    public final boolean p;

    public static final class b extends u.a {
        public String a;
        public c<d> b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public c<String> f2184d;

        /* renamed from: e  reason: collision with root package name */
        public String f2185e;

        /* renamed from: f  reason: collision with root package name */
        public String f2186f;

        /* renamed from: g  reason: collision with root package name */
        public String f2187g;

        /* renamed from: h  reason: collision with root package name */
        public String f2188h;

        /* renamed from: i  reason: collision with root package name */
        public e f2189i;

        /* renamed from: j  reason: collision with root package name */
        public e f2190j;

        /* renamed from: k  reason: collision with root package name */
        public String f2191k;

        /* renamed from: l  reason: collision with root package name */
        public Boolean f2192l;
        public Integer m;
        public Boolean n;

        public b() {
        }

        public b(u uVar, a aVar) {
            r rVar = (r) uVar;
            this.a = rVar.c;
            this.b = rVar.f2175d;
            this.c = rVar.f2176e;
            this.f2184d = rVar.f2177f;
            this.f2185e = rVar.f2178g;
            this.f2186f = rVar.f2179h;
            this.f2187g = rVar.f2180i;
            this.f2188h = rVar.f2181j;
            this.f2189i = rVar.f2182k;
            this.f2190j = rVar.f2183l;
            this.f2191k = rVar.m;
            this.f2192l = Boolean.valueOf(rVar.n);
            this.m = Integer.valueOf(rVar.o);
            this.n = Boolean.valueOf(rVar.p);
        }

        @Override // f.b.a.a.a.n.u.a
        public u a() {
            String str = this.a == null ? " verificationCode" : "";
            if (this.f2192l == null) {
                str = f.a.a.a.a.t(str, " hasTraveled");
            }
            if (this.m == null) {
                str = f.a.a.a.a.t(str, " numKeysAffected");
            }
            if (this.n == null) {
                str = f.a.a.a.a.t(str, " isCoverTraffic");
            }
            if (str.isEmpty()) {
                return new r(this.a, this.b, this.c, this.f2184d, this.f2185e, this.f2186f, this.f2187g, this.f2188h, this.f2189i, this.f2190j, this.f2191k, this.f2192l.booleanValue(), this.m.intValue(), this.n.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.n.u.a
        public u.a b(boolean z) {
            this.n = Boolean.valueOf(z);
            return this;
        }

        @Override // f.b.a.a.a.n.u.a
        public u.a c(Collection<d> collection) {
            this.b = collection == null ? null : c.s(collection);
            return this;
        }
    }

    public r(String str, c cVar, String str2, c cVar2, String str3, String str4, String str5, String str6, e eVar, e eVar2, String str7, boolean z, int i2, boolean z2, a aVar) {
        this.c = str;
        this.f2175d = cVar;
        this.f2176e = str2;
        this.f2177f = cVar2;
        this.f2178g = str3;
        this.f2179h = str4;
        this.f2180i = str5;
        this.f2181j = str6;
        this.f2182k = eVar;
        this.f2183l = eVar2;
        this.m = str7;
        this.n = z;
        this.o = i2;
        this.p = z2;
    }

    @Override // f.b.a.a.a.n.u
    public String a() {
        return this.f2181j;
    }

    @Override // f.b.a.a.a.n.u
    public e b() {
        return this.f2183l;
    }

    @Override // f.b.a.a.a.n.u
    public boolean c() {
        return this.n;
    }

    @Override // f.b.a.a.a.n.u
    public String d() {
        return this.f2180i;
    }

    @Override // f.b.a.a.a.n.u
    public String e() {
        return this.f2176e;
    }

    public boolean equals(Object obj) {
        c<d> cVar;
        String str;
        c<String> cVar2;
        String str2;
        String str3;
        String str4;
        String str5;
        e eVar;
        e eVar2;
        String str6;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.c.equals(uVar.q()) && ((cVar = this.f2175d) != null ? cVar.equals(uVar.g()) : uVar.g() == null) && ((str = this.f2176e) != null ? str.equals(uVar.e()) : uVar.e() == null) && ((cVar2 = this.f2177f) != null ? cVar2.equals(uVar.l()) : uVar.l() == null) && ((str2 = this.f2178g) != null ? str2.equals(uVar.h()) : uVar.h() == null) && ((str3 = this.f2179h) != null ? str3.equals(uVar.o()) : uVar.o() == null) && ((str4 = this.f2180i) != null ? str4.equals(uVar.d()) : uVar.d() == null) && ((str5 = this.f2181j) != null ? str5.equals(uVar.a()) : uVar.a() == null) && ((eVar = this.f2182k) != null ? eVar.equals(uVar.n()) : uVar.n() == null) && ((eVar2 = this.f2183l) != null ? eVar2.equals(uVar.b()) : uVar.b() == null) && ((str6 = this.m) != null ? str6.equals(uVar.m()) : uVar.m() == null) && this.n == uVar.c() && this.o == uVar.k() && this.p == uVar.f();
    }

    @Override // f.b.a.a.a.n.u
    public boolean f() {
        return this.p;
    }

    @Override // f.b.a.a.a.n.u
    public c<d> g() {
        return this.f2175d;
    }

    @Override // f.b.a.a.a.n.u
    public String h() {
        return this.f2178g;
    }

    public int hashCode() {
        int hashCode = (this.c.hashCode() ^ 1000003) * 1000003;
        c<d> cVar = this.f2175d;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        String str = this.f2176e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        c<String> cVar2 = this.f2177f;
        int hashCode4 = (hashCode3 ^ (cVar2 == null ? 0 : cVar2.hashCode())) * 1000003;
        String str2 = this.f2178g;
        int hashCode5 = (hashCode4 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2179h;
        int hashCode6 = (hashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f2180i;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f2181j;
        int hashCode8 = (hashCode7 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        e eVar = this.f2182k;
        int hashCode9 = (hashCode8 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        e eVar2 = this.f2183l;
        int hashCode10 = (hashCode9 ^ (eVar2 == null ? 0 : eVar2.hashCode())) * 1000003;
        String str6 = this.m;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = (hashCode10 ^ i2) * 1000003;
        int i4 = 1231;
        int i5 = (((i3 ^ (this.n ? 1231 : 1237)) * 1000003) ^ this.o) * 1000003;
        if (!this.p) {
            i4 = 1237;
        }
        return i5 ^ i4;
    }

    @Override // f.b.a.a.a.n.u
    public int k() {
        return this.o;
    }

    @Override // f.b.a.a.a.n.u
    public c<String> l() {
        return this.f2177f;
    }

    @Override // f.b.a.a.a.n.u
    public String m() {
        return this.m;
    }

    @Override // f.b.a.a.a.n.u
    public e n() {
        return this.f2182k;
    }

    @Override // f.b.a.a.a.n.u
    public String o() {
        return this.f2179h;
    }

    @Override // f.b.a.a.a.n.u
    public u.a p() {
        return new b(this, null);
    }

    @Override // f.b.a.a.a.n.u
    public String q() {
        return this.c;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Upload{verificationCode=");
        h2.append(this.c);
        h2.append(", keys=");
        h2.append(this.f2175d);
        h2.append(", homeRegion=");
        h2.append(this.f2176e);
        h2.append(", regions=");
        h2.append(this.f2177f);
        h2.append(", longTermToken=");
        h2.append(this.f2178g);
        h2.append(", testType=");
        h2.append(this.f2179h);
        h2.append(", hmacKeyBase64=");
        h2.append(this.f2180i);
        h2.append(", certificate=");
        h2.append(this.f2181j);
        h2.append(", symptomOnset=");
        h2.append(this.f2182k);
        h2.append(", diagnosisDate=");
        h2.append(this.f2183l);
        h2.append(", revisionToken=");
        h2.append(this.m);
        h2.append(", hasTraveled=");
        h2.append(this.n);
        h2.append(", numKeysAffected=");
        h2.append(this.o);
        h2.append(", isCoverTraffic=");
        h2.append(this.p);
        h2.append("}");
        return h2.toString();
    }
}
