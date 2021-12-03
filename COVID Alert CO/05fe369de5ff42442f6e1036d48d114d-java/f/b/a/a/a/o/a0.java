package f.b.a.a.a.o;

import f.b.a.a.a.o.e0;
import f.b.a.a.a.r.d;
import f.b.b.b.c;
import java.util.Collection;
import l.b.a.f;

public final class a0 extends e0 {
    public final String a;
    public final c<d> b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final c<String> f2269d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2270e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2271f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2272g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2273h;

    /* renamed from: i  reason: collision with root package name */
    public final f f2274i;

    /* renamed from: j  reason: collision with root package name */
    public final f f2275j;

    /* renamed from: k  reason: collision with root package name */
    public final String f2276k;

    /* renamed from: l  reason: collision with root package name */
    public final String f2277l;
    public final boolean m;
    public final int n;
    public final boolean o;

    public static final class b extends e0.a {
        public String a;
        public c<d> b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public c<String> f2278d;

        /* renamed from: e  reason: collision with root package name */
        public String f2279e;

        /* renamed from: f  reason: collision with root package name */
        public String f2280f;

        /* renamed from: g  reason: collision with root package name */
        public String f2281g;

        /* renamed from: h  reason: collision with root package name */
        public String f2282h;

        /* renamed from: i  reason: collision with root package name */
        public f f2283i;

        /* renamed from: j  reason: collision with root package name */
        public f f2284j;

        /* renamed from: k  reason: collision with root package name */
        public String f2285k;

        /* renamed from: l  reason: collision with root package name */
        public String f2286l;
        public Boolean m;
        public Integer n;
        public Boolean o;

        public b() {
        }

        public b(e0 e0Var, a aVar) {
            a0 a0Var = (a0) e0Var;
            this.a = a0Var.a;
            this.b = a0Var.b;
            this.c = a0Var.c;
            this.f2278d = a0Var.f2269d;
            this.f2279e = a0Var.f2270e;
            this.f2280f = a0Var.f2271f;
            this.f2281g = a0Var.f2272g;
            this.f2282h = a0Var.f2273h;
            this.f2283i = a0Var.f2274i;
            this.f2284j = a0Var.f2275j;
            this.f2285k = a0Var.f2276k;
            this.f2286l = a0Var.f2277l;
            this.m = Boolean.valueOf(a0Var.m);
            this.n = Integer.valueOf(a0Var.n);
            this.o = Boolean.valueOf(a0Var.o);
        }

        @Override // f.b.a.a.a.o.e0.a
        public e0 a() {
            String str = this.a == null ? " verificationCode" : "";
            if (this.m == null) {
                str = f.a.a.a.a.c(str, " hasTraveled");
            }
            if (this.n == null) {
                str = f.a.a.a.a.c(str, " numKeysAffected");
            }
            if (this.o == null) {
                str = f.a.a.a.a.c(str, " isCoverTraffic");
            }
            if (str.isEmpty()) {
                return new a0(this.a, this.b, this.c, this.f2278d, this.f2279e, this.f2280f, this.f2281g, this.f2282h, this.f2283i, this.f2284j, this.f2285k, this.f2286l, this.m.booleanValue(), this.n.intValue(), this.o.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.c("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.o.e0.a
        public e0.a b(boolean z) {
            this.o = Boolean.valueOf(z);
            return this;
        }

        @Override // f.b.a.a.a.o.e0.a
        public e0.a c(Collection<d> collection) {
            this.b = collection == null ? null : c.s(collection);
            return this;
        }

        public e0.a d(boolean z) {
            this.m = Boolean.valueOf(z);
            return this;
        }
    }

    public a0(String str, c cVar, String str2, c cVar2, String str3, String str4, String str5, String str6, f fVar, f fVar2, String str7, String str8, boolean z, int i2, boolean z2, a aVar) {
        this.a = str;
        this.b = cVar;
        this.c = str2;
        this.f2269d = cVar2;
        this.f2270e = str3;
        this.f2271f = str4;
        this.f2272g = str5;
        this.f2273h = str6;
        this.f2274i = fVar;
        this.f2275j = fVar2;
        this.f2276k = str7;
        this.f2277l = str8;
        this.m = z;
        this.n = i2;
        this.o = z2;
    }

    @Override // f.b.a.a.a.o.e0
    public String a() {
        return this.f2273h;
    }

    @Override // f.b.a.a.a.o.e0
    public f b() {
        return this.f2275j;
    }

    @Override // f.b.a.a.a.o.e0
    public boolean c() {
        return this.m;
    }

    @Override // f.b.a.a.a.o.e0
    public String d() {
        return this.f2272g;
    }

    @Override // f.b.a.a.a.o.e0
    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        c<d> cVar;
        String str;
        c<String> cVar2;
        String str2;
        String str3;
        String str4;
        String str5;
        f fVar;
        f fVar2;
        String str6;
        String str7;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return this.a.equals(e0Var.r()) && ((cVar = this.b) != null ? cVar.equals(e0Var.g()) : e0Var.g() == null) && ((str = this.c) != null ? str.equals(e0Var.e()) : e0Var.e() == null) && ((cVar2 = this.f2269d) != null ? cVar2.equals(e0Var.m()) : e0Var.m() == null) && ((str2 = this.f2270e) != null ? str2.equals(e0Var.h()) : e0Var.h() == null) && ((str3 = this.f2271f) != null ? str3.equals(e0Var.p()) : e0Var.p() == null) && ((str4 = this.f2272g) != null ? str4.equals(e0Var.d()) : e0Var.d() == null) && ((str5 = this.f2273h) != null ? str5.equals(e0Var.a()) : e0Var.a() == null) && ((fVar = this.f2274i) != null ? fVar.equals(e0Var.o()) : e0Var.o() == null) && ((fVar2 = this.f2275j) != null ? fVar2.equals(e0Var.b()) : e0Var.b() == null) && ((str6 = this.f2276k) != null ? str6.equals(e0Var.n()) : e0Var.n() == null) && ((str7 = this.f2277l) != null ? str7.equals(e0Var.k()) : e0Var.k() == null) && this.m == e0Var.c() && this.n == e0Var.l() && this.o == e0Var.f();
    }

    @Override // f.b.a.a.a.o.e0
    public boolean f() {
        return this.o;
    }

    @Override // f.b.a.a.a.o.e0
    public c<d> g() {
        return this.b;
    }

    @Override // f.b.a.a.a.o.e0
    public String h() {
        return this.f2270e;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        c<d> cVar = this.b;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        String str = this.c;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        c<String> cVar2 = this.f2269d;
        int hashCode4 = (hashCode3 ^ (cVar2 == null ? 0 : cVar2.hashCode())) * 1000003;
        String str2 = this.f2270e;
        int hashCode5 = (hashCode4 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2271f;
        int hashCode6 = (hashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f2272g;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f2273h;
        int hashCode8 = (hashCode7 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        f fVar = this.f2274i;
        int hashCode9 = (hashCode8 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        f fVar2 = this.f2275j;
        int hashCode10 = (hashCode9 ^ (fVar2 == null ? 0 : fVar2.hashCode())) * 1000003;
        String str6 = this.f2276k;
        int hashCode11 = (hashCode10 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f2277l;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i3 = (hashCode11 ^ i2) * 1000003;
        int i4 = 1231;
        int i5 = (((i3 ^ (this.m ? 1231 : 1237)) * 1000003) ^ this.n) * 1000003;
        if (!this.o) {
            i4 = 1237;
        }
        return i5 ^ i4;
    }

    @Override // f.b.a.a.a.o.e0
    public String k() {
        return this.f2277l;
    }

    @Override // f.b.a.a.a.o.e0
    public int l() {
        return this.n;
    }

    @Override // f.b.a.a.a.o.e0
    public c<String> m() {
        return this.f2269d;
    }

    @Override // f.b.a.a.a.o.e0
    public String n() {
        return this.f2276k;
    }

    @Override // f.b.a.a.a.o.e0
    public f o() {
        return this.f2274i;
    }

    @Override // f.b.a.a.a.o.e0
    public String p() {
        return this.f2271f;
    }

    @Override // f.b.a.a.a.o.e0
    public e0.a q() {
        return new b(this, null);
    }

    @Override // f.b.a.a.a.o.e0
    public String r() {
        return this.a;
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("Upload{verificationCode=");
        i2.append(this.a);
        i2.append(", keys=");
        i2.append(this.b);
        i2.append(", homeRegion=");
        i2.append(this.c);
        i2.append(", regions=");
        i2.append(this.f2269d);
        i2.append(", longTermToken=");
        i2.append(this.f2270e);
        i2.append(", testType=");
        i2.append(this.f2271f);
        i2.append(", hmacKeyBase64=");
        i2.append(this.f2272g);
        i2.append(", certificate=");
        i2.append(this.f2273h);
        i2.append(", symptomOnset=");
        i2.append(this.f2274i);
        i2.append(", diagnosisDate=");
        i2.append(this.f2275j);
        i2.append(", revisionToken=");
        i2.append(this.f2276k);
        i2.append(", nonceBase64=");
        i2.append(this.f2277l);
        i2.append(", hasTraveled=");
        i2.append(this.m);
        i2.append(", numKeysAffected=");
        i2.append(this.n);
        i2.append(", isCoverTraffic=");
        i2.append(this.o);
        i2.append("}");
        return i2.toString();
    }
}
