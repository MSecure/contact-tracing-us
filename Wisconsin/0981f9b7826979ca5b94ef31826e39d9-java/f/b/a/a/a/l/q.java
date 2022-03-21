package f.b.a.a.a.l;

import f.b.a.a.a.l.t;
import f.b.a.a.a.o.d;
import f.b.b.b.c;
import java.util.Collection;
import l.b.a.e;

public final class q extends t {
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final c<d> f2095d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2096e;

    /* renamed from: f  reason: collision with root package name */
    public final c<String> f2097f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2098g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2099h;

    /* renamed from: i  reason: collision with root package name */
    public final String f2100i;

    /* renamed from: j  reason: collision with root package name */
    public final String f2101j;

    /* renamed from: k  reason: collision with root package name */
    public final e f2102k;

    /* renamed from: l  reason: collision with root package name */
    public final e f2103l;
    public final String m;
    public final boolean n;
    public final int o;
    public final boolean p;

    public static final class b extends t.a {
        public String a;
        public c<d> b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public c<String> f2104d;

        /* renamed from: e  reason: collision with root package name */
        public String f2105e;

        /* renamed from: f  reason: collision with root package name */
        public String f2106f;

        /* renamed from: g  reason: collision with root package name */
        public String f2107g;

        /* renamed from: h  reason: collision with root package name */
        public String f2108h;

        /* renamed from: i  reason: collision with root package name */
        public e f2109i;

        /* renamed from: j  reason: collision with root package name */
        public e f2110j;

        /* renamed from: k  reason: collision with root package name */
        public String f2111k;

        /* renamed from: l  reason: collision with root package name */
        public Boolean f2112l;
        public Integer m;
        public Boolean n;

        public b() {
        }

        public b(t tVar, a aVar) {
            q qVar = (q) tVar;
            this.a = qVar.c;
            this.b = qVar.f2095d;
            this.c = qVar.f2096e;
            this.f2104d = qVar.f2097f;
            this.f2105e = qVar.f2098g;
            this.f2106f = qVar.f2099h;
            this.f2107g = qVar.f2100i;
            this.f2108h = qVar.f2101j;
            this.f2109i = qVar.f2102k;
            this.f2110j = qVar.f2103l;
            this.f2111k = qVar.m;
            this.f2112l = Boolean.valueOf(qVar.n);
            this.m = Integer.valueOf(qVar.o);
            this.n = Boolean.valueOf(qVar.p);
        }

        @Override // f.b.a.a.a.l.t.a
        public t a() {
            String str = this.a == null ? " verificationCode" : "";
            if (this.f2112l == null) {
                str = f.a.a.a.a.t(str, " hasTraveled");
            }
            if (this.m == null) {
                str = f.a.a.a.a.t(str, " numKeysAffected");
            }
            if (this.n == null) {
                str = f.a.a.a.a.t(str, " isCoverTraffic");
            }
            if (str.isEmpty()) {
                return new q(this.a, this.b, this.c, this.f2104d, this.f2105e, this.f2106f, this.f2107g, this.f2108h, this.f2109i, this.f2110j, this.f2111k, this.f2112l.booleanValue(), this.m.intValue(), this.n.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.l.t.a
        public t.a b(boolean z) {
            this.n = Boolean.valueOf(z);
            return this;
        }

        @Override // f.b.a.a.a.l.t.a
        public t.a c(Collection<d> collection) {
            this.b = collection == null ? null : c.s(collection);
            return this;
        }
    }

    public q(String str, c cVar, String str2, c cVar2, String str3, String str4, String str5, String str6, e eVar, e eVar2, String str7, boolean z, int i2, boolean z2, a aVar) {
        this.c = str;
        this.f2095d = cVar;
        this.f2096e = str2;
        this.f2097f = cVar2;
        this.f2098g = str3;
        this.f2099h = str4;
        this.f2100i = str5;
        this.f2101j = str6;
        this.f2102k = eVar;
        this.f2103l = eVar2;
        this.m = str7;
        this.n = z;
        this.o = i2;
        this.p = z2;
    }

    @Override // f.b.a.a.a.l.t
    public String a() {
        return this.f2101j;
    }

    @Override // f.b.a.a.a.l.t
    public e b() {
        return this.f2103l;
    }

    @Override // f.b.a.a.a.l.t
    public boolean c() {
        return this.n;
    }

    @Override // f.b.a.a.a.l.t
    public String d() {
        return this.f2100i;
    }

    @Override // f.b.a.a.a.l.t
    public String e() {
        return this.f2096e;
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
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.c.equals(tVar.q()) && ((cVar = this.f2095d) != null ? cVar.equals(tVar.g()) : tVar.g() == null) && ((str = this.f2096e) != null ? str.equals(tVar.e()) : tVar.e() == null) && ((cVar2 = this.f2097f) != null ? cVar2.equals(tVar.l()) : tVar.l() == null) && ((str2 = this.f2098g) != null ? str2.equals(tVar.h()) : tVar.h() == null) && ((str3 = this.f2099h) != null ? str3.equals(tVar.o()) : tVar.o() == null) && ((str4 = this.f2100i) != null ? str4.equals(tVar.d()) : tVar.d() == null) && ((str5 = this.f2101j) != null ? str5.equals(tVar.a()) : tVar.a() == null) && ((eVar = this.f2102k) != null ? eVar.equals(tVar.n()) : tVar.n() == null) && ((eVar2 = this.f2103l) != null ? eVar2.equals(tVar.b()) : tVar.b() == null) && ((str6 = this.m) != null ? str6.equals(tVar.m()) : tVar.m() == null) && this.n == tVar.c() && this.o == tVar.k() && this.p == tVar.f();
    }

    @Override // f.b.a.a.a.l.t
    public boolean f() {
        return this.p;
    }

    @Override // f.b.a.a.a.l.t
    public c<d> g() {
        return this.f2095d;
    }

    @Override // f.b.a.a.a.l.t
    public String h() {
        return this.f2098g;
    }

    public int hashCode() {
        int hashCode = (this.c.hashCode() ^ 1000003) * 1000003;
        c<d> cVar = this.f2095d;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        String str = this.f2096e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        c<String> cVar2 = this.f2097f;
        int hashCode4 = (hashCode3 ^ (cVar2 == null ? 0 : cVar2.hashCode())) * 1000003;
        String str2 = this.f2098g;
        int hashCode5 = (hashCode4 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2099h;
        int hashCode6 = (hashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f2100i;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f2101j;
        int hashCode8 = (hashCode7 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        e eVar = this.f2102k;
        int hashCode9 = (hashCode8 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        e eVar2 = this.f2103l;
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

    @Override // f.b.a.a.a.l.t
    public int k() {
        return this.o;
    }

    @Override // f.b.a.a.a.l.t
    public c<String> l() {
        return this.f2097f;
    }

    @Override // f.b.a.a.a.l.t
    public String m() {
        return this.m;
    }

    @Override // f.b.a.a.a.l.t
    public e n() {
        return this.f2102k;
    }

    @Override // f.b.a.a.a.l.t
    public String o() {
        return this.f2099h;
    }

    @Override // f.b.a.a.a.l.t
    public t.a p() {
        return new b(this, null);
    }

    @Override // f.b.a.a.a.l.t
    public String q() {
        return this.c;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Upload{verificationCode=");
        h2.append(this.c);
        h2.append(", keys=");
        h2.append(this.f2095d);
        h2.append(", homeRegion=");
        h2.append(this.f2096e);
        h2.append(", regions=");
        h2.append(this.f2097f);
        h2.append(", longTermToken=");
        h2.append(this.f2098g);
        h2.append(", testType=");
        h2.append(this.f2099h);
        h2.append(", hmacKeyBase64=");
        h2.append(this.f2100i);
        h2.append(", certificate=");
        h2.append(this.f2101j);
        h2.append(", symptomOnset=");
        h2.append(this.f2102k);
        h2.append(", diagnosisDate=");
        h2.append(this.f2103l);
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
