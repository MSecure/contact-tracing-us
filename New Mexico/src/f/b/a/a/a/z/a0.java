package f.b.a.a.a.z;

import f.b.a.a.a.d0.d;
import f.b.a.a.a.z.e0;
import f.b.b.b.c;
import java.util.Collection;
import l.b.a.f;
/* loaded from: classes.dex */
public final class a0 extends e0 {
    public final String a;
    public final c<d> b;
    public final String c;

    /* renamed from: d */
    public final c<String> f2509d;

    /* renamed from: e */
    public final String f2510e;

    /* renamed from: f */
    public final String f2511f;

    /* renamed from: g */
    public final String f2512g;

    /* renamed from: h */
    public final String f2513h;

    /* renamed from: i */
    public final f f2514i;

    /* renamed from: j */
    public final f f2515j;

    /* renamed from: k */
    public final String f2516k;

    /* renamed from: l */
    public final String f2517l;
    public final boolean m;
    public final int n;
    public final boolean o;

    /* loaded from: classes.dex */
    public static final class b extends e0.a {
        public String a;
        public c<d> b;
        public String c;

        /* renamed from: d */
        public c<String> f2518d;

        /* renamed from: e */
        public String f2519e;

        /* renamed from: f */
        public String f2520f;

        /* renamed from: g */
        public String f2521g;

        /* renamed from: h */
        public String f2522h;

        /* renamed from: i */
        public f f2523i;

        /* renamed from: j */
        public f f2524j;

        /* renamed from: k */
        public String f2525k;

        /* renamed from: l */
        public String f2526l;
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
            this.f2518d = a0Var.f2509d;
            this.f2519e = a0Var.f2510e;
            this.f2520f = a0Var.f2511f;
            this.f2521g = a0Var.f2512g;
            this.f2522h = a0Var.f2513h;
            this.f2523i = a0Var.f2514i;
            this.f2524j = a0Var.f2515j;
            this.f2525k = a0Var.f2516k;
            this.f2526l = a0Var.f2517l;
            this.m = Boolean.valueOf(a0Var.m);
            this.n = Integer.valueOf(a0Var.n);
            this.o = Boolean.valueOf(a0Var.o);
        }

        @Override // f.b.a.a.a.z.e0.a
        public e0 a() {
            String str = this.a == null ? " verificationCode" : "";
            if (this.m == null) {
                str = f.a.a.a.a.x(str, " hasTraveled");
            }
            if (this.n == null) {
                str = f.a.a.a.a.x(str, " numKeysAffected");
            }
            if (this.o == null) {
                str = f.a.a.a.a.x(str, " isCoverTraffic");
            }
            if (str.isEmpty()) {
                return new a0(this.a, this.b, this.c, this.f2518d, this.f2519e, this.f2520f, this.f2521g, this.f2522h, this.f2523i, this.f2524j, this.f2525k, this.f2526l, this.m.booleanValue(), this.n.intValue(), this.o.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.x("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.z.e0.a
        public e0.a b(boolean z) {
            this.o = Boolean.valueOf(z);
            return this;
        }

        @Override // f.b.a.a.a.z.e0.a
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
        this.f2509d = cVar2;
        this.f2510e = str3;
        this.f2511f = str4;
        this.f2512g = str5;
        this.f2513h = str6;
        this.f2514i = fVar;
        this.f2515j = fVar2;
        this.f2516k = str7;
        this.f2517l = str8;
        this.m = z;
        this.n = i2;
        this.o = z2;
    }

    @Override // f.b.a.a.a.z.e0
    public String a() {
        return this.f2513h;
    }

    @Override // f.b.a.a.a.z.e0
    public f b() {
        return this.f2515j;
    }

    @Override // f.b.a.a.a.z.e0
    public boolean c() {
        return this.m;
    }

    @Override // f.b.a.a.a.z.e0
    public String d() {
        return this.f2512g;
    }

    @Override // f.b.a.a.a.z.e0
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
        return this.a.equals(e0Var.r()) && ((cVar = this.b) != null ? cVar.equals(e0Var.g()) : e0Var.g() == null) && ((str = this.c) != null ? str.equals(e0Var.e()) : e0Var.e() == null) && ((cVar2 = this.f2509d) != null ? cVar2.equals(e0Var.m()) : e0Var.m() == null) && ((str2 = this.f2510e) != null ? str2.equals(e0Var.h()) : e0Var.h() == null) && ((str3 = this.f2511f) != null ? str3.equals(e0Var.p()) : e0Var.p() == null) && ((str4 = this.f2512g) != null ? str4.equals(e0Var.d()) : e0Var.d() == null) && ((str5 = this.f2513h) != null ? str5.equals(e0Var.a()) : e0Var.a() == null) && ((fVar = this.f2514i) != null ? fVar.equals(e0Var.o()) : e0Var.o() == null) && ((fVar2 = this.f2515j) != null ? fVar2.equals(e0Var.b()) : e0Var.b() == null) && ((str6 = this.f2516k) != null ? str6.equals(e0Var.n()) : e0Var.n() == null) && ((str7 = this.f2517l) != null ? str7.equals(e0Var.k()) : e0Var.k() == null) && this.m == e0Var.c() && this.n == e0Var.l() && this.o == e0Var.f();
    }

    @Override // f.b.a.a.a.z.e0
    public boolean f() {
        return this.o;
    }

    @Override // f.b.a.a.a.z.e0
    public c<d> g() {
        return this.b;
    }

    @Override // f.b.a.a.a.z.e0
    public String h() {
        return this.f2510e;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        c<d> cVar = this.b;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        String str = this.c;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        c<String> cVar2 = this.f2509d;
        int hashCode4 = (hashCode3 ^ (cVar2 == null ? 0 : cVar2.hashCode())) * 1000003;
        String str2 = this.f2510e;
        int hashCode5 = (hashCode4 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2511f;
        int hashCode6 = (hashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f2512g;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f2513h;
        int hashCode8 = (hashCode7 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        f fVar = this.f2514i;
        int hashCode9 = (hashCode8 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        f fVar2 = this.f2515j;
        int hashCode10 = (hashCode9 ^ (fVar2 == null ? 0 : fVar2.hashCode())) * 1000003;
        String str6 = this.f2516k;
        int hashCode11 = (hashCode10 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f2517l;
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

    @Override // f.b.a.a.a.z.e0
    public String k() {
        return this.f2517l;
    }

    @Override // f.b.a.a.a.z.e0
    public int l() {
        return this.n;
    }

    @Override // f.b.a.a.a.z.e0
    public c<String> m() {
        return this.f2509d;
    }

    @Override // f.b.a.a.a.z.e0
    public String n() {
        return this.f2516k;
    }

    @Override // f.b.a.a.a.z.e0
    public f o() {
        return this.f2514i;
    }

    @Override // f.b.a.a.a.z.e0
    public String p() {
        return this.f2511f;
    }

    @Override // f.b.a.a.a.z.e0
    public e0.a q() {
        return new b(this, null);
    }

    @Override // f.b.a.a.a.z.e0
    public String r() {
        return this.a;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Upload{verificationCode=");
        h2.append(this.a);
        h2.append(", keys=");
        h2.append(this.b);
        h2.append(", homeRegion=");
        h2.append(this.c);
        h2.append(", regions=");
        h2.append(this.f2509d);
        h2.append(", longTermToken=");
        h2.append(this.f2510e);
        h2.append(", testType=");
        h2.append(this.f2511f);
        h2.append(", hmacKeyBase64=");
        h2.append(this.f2512g);
        h2.append(", certificate=");
        h2.append(this.f2513h);
        h2.append(", symptomOnset=");
        h2.append(this.f2514i);
        h2.append(", diagnosisDate=");
        h2.append(this.f2515j);
        h2.append(", revisionToken=");
        h2.append(this.f2516k);
        h2.append(", nonceBase64=");
        h2.append(this.f2517l);
        h2.append(", hasTraveled=");
        h2.append(this.m);
        h2.append(", numKeysAffected=");
        h2.append(this.n);
        h2.append(", isCoverTraffic=");
        h2.append(this.o);
        h2.append("}");
        return h2.toString();
    }
}
