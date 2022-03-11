package f.b.a.a.a.w;

import f.b.a.a.a.w.b0;
import java.util.Objects;
import l.b.a.e;

public final class j extends b0 {
    public final long a;
    public final long b;
    public final b0.c c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2261d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2262e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2263f;

    /* renamed from: g  reason: collision with root package name */
    public final b0.d f2264g;

    /* renamed from: h  reason: collision with root package name */
    public final e f2265h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2266i;

    /* renamed from: j  reason: collision with root package name */
    public final b0.b f2267j;

    /* renamed from: k  reason: collision with root package name */
    public final String f2268k;

    /* renamed from: l  reason: collision with root package name */
    public final b0.e f2269l;
    public final boolean m;

    public static final class b extends b0.a {
        public Long a;
        public Long b;
        public b0.c c;

        /* renamed from: d  reason: collision with root package name */
        public String f2270d;

        /* renamed from: e  reason: collision with root package name */
        public String f2271e;

        /* renamed from: f  reason: collision with root package name */
        public String f2272f;

        /* renamed from: g  reason: collision with root package name */
        public b0.d f2273g;

        /* renamed from: h  reason: collision with root package name */
        public e f2274h;

        /* renamed from: i  reason: collision with root package name */
        public Boolean f2275i;

        /* renamed from: j  reason: collision with root package name */
        public b0.b f2276j;

        /* renamed from: k  reason: collision with root package name */
        public String f2277k;

        /* renamed from: l  reason: collision with root package name */
        public b0.e f2278l;
        public Boolean m;

        public b() {
        }

        public b(b0 b0Var, a aVar) {
            j jVar = (j) b0Var;
            this.a = Long.valueOf(jVar.a);
            this.b = Long.valueOf(jVar.b);
            this.c = jVar.c;
            this.f2270d = jVar.f2261d;
            this.f2271e = jVar.f2262e;
            this.f2272f = jVar.f2263f;
            this.f2273g = jVar.f2264g;
            this.f2274h = jVar.f2265h;
            this.f2275i = Boolean.valueOf(jVar.f2266i);
            this.f2276j = jVar.f2267j;
            this.f2277k = jVar.f2268k;
            this.f2278l = jVar.f2269l;
            this.m = Boolean.valueOf(jVar.m);
        }

        @Override // f.b.a.a.a.w.b0.a
        public b0 a() {
            String str = this.a == null ? " id" : "";
            if (this.b == null) {
                str = f.a.a.a.a.t(str, " createdTimestampMs");
            }
            if (this.f2275i == null) {
                str = f.a.a.a.a.t(str, " isServerOnsetDate");
            }
            if (this.f2276j == null) {
                str = f.a.a.a.a.t(str, " hasSymptoms");
            }
            if (this.m == null) {
                str = f.a.a.a.a.t(str, " isCodeFromLink");
            }
            if (str.isEmpty()) {
                return new j(this.a.longValue(), this.b.longValue(), this.c, this.f2270d, this.f2271e, this.f2272f, this.f2273g, this.f2274h, this.f2275i.booleanValue(), this.f2276j, this.f2277k, this.f2278l, this.m.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.w.b0.a
        public b0.a b(long j2) {
            this.b = Long.valueOf(j2);
            return this;
        }

        @Override // f.b.a.a.a.w.b0.a
        public b0.a c(b0.b bVar) {
            Objects.requireNonNull(bVar, "Null hasSymptoms");
            this.f2276j = bVar;
            return this;
        }

        public b0.a d(boolean z) {
            this.m = Boolean.valueOf(z);
            return this;
        }

        public b0.a e(boolean z) {
            this.f2275i = Boolean.valueOf(z);
            return this;
        }
    }

    public j(long j2, long j3, b0.c cVar, String str, String str2, String str3, b0.d dVar, e eVar, boolean z, b0.b bVar, String str4, b0.e eVar2, boolean z2, a aVar) {
        this.a = j2;
        this.b = j3;
        this.c = cVar;
        this.f2261d = str;
        this.f2262e = str2;
        this.f2263f = str3;
        this.f2264g = dVar;
        this.f2265h = eVar;
        this.f2266i = z;
        this.f2267j = bVar;
        this.f2268k = str4;
        this.f2269l = eVar2;
        this.m = z2;
    }

    @Override // f.b.a.a.a.w.b0
    public String b() {
        return this.f2263f;
    }

    @Override // f.b.a.a.a.w.b0
    public long c() {
        return this.b;
    }

    @Override // f.b.a.a.a.w.b0
    public b0.b d() {
        return this.f2267j;
    }

    @Override // f.b.a.a.a.w.b0
    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        b0.c cVar;
        String str;
        String str2;
        String str3;
        b0.d dVar;
        e eVar;
        String str4;
        b0.e eVar2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.a == b0Var.e() && this.b == b0Var.c() && ((cVar = this.c) != null ? cVar.equals(b0Var.k()) : b0Var.k() == null) && ((str = this.f2261d) != null ? str.equals(b0Var.n()) : b0Var.n() == null) && ((str2 = this.f2262e) != null ? str2.equals(b0Var.h()) : b0Var.h() == null) && ((str3 = this.f2263f) != null ? str3.equals(b0Var.b()) : b0Var.b() == null) && ((dVar = this.f2264g) != null ? dVar.equals(b0Var.l()) : b0Var.l() == null) && ((eVar = this.f2265h) != null ? eVar.equals(b0Var.i()) : b0Var.i() == null) && this.f2266i == b0Var.g() && this.f2267j.equals(b0Var.d()) && ((str4 = this.f2268k) != null ? str4.equals(b0Var.j()) : b0Var.j() == null) && ((eVar2 = this.f2269l) != null ? eVar2.equals(b0Var.m()) : b0Var.m() == null) && this.m == b0Var.f();
    }

    @Override // f.b.a.a.a.w.b0
    public boolean f() {
        return this.m;
    }

    @Override // f.b.a.a.a.w.b0
    public boolean g() {
        return this.f2266i;
    }

    @Override // f.b.a.a.a.w.b0
    public String h() {
        return this.f2262e;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        b0.c cVar = this.c;
        int i3 = 0;
        int hashCode = (i2 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        String str = this.f2261d;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f2262e;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2263f;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        b0.d dVar = this.f2264g;
        int hashCode5 = (hashCode4 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        e eVar = this.f2265h;
        int i4 = 1231;
        int hashCode6 = (((((hashCode5 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003) ^ (this.f2266i ? 1231 : 1237)) * 1000003) ^ this.f2267j.hashCode()) * 1000003;
        String str4 = this.f2268k;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        b0.e eVar2 = this.f2269l;
        if (eVar2 != null) {
            i3 = eVar2.hashCode();
        }
        int i5 = (hashCode7 ^ i3) * 1000003;
        if (!this.m) {
            i4 = 1237;
        }
        return i5 ^ i4;
    }

    @Override // f.b.a.a.a.w.b0
    public e i() {
        return this.f2265h;
    }

    @Override // f.b.a.a.a.w.b0
    public String j() {
        return this.f2268k;
    }

    @Override // f.b.a.a.a.w.b0
    public b0.c k() {
        return this.c;
    }

    @Override // f.b.a.a.a.w.b0
    public b0.d l() {
        return this.f2264g;
    }

    @Override // f.b.a.a.a.w.b0
    public b0.e m() {
        return this.f2269l;
    }

    @Override // f.b.a.a.a.w.b0
    public String n() {
        return this.f2261d;
    }

    @Override // f.b.a.a.a.w.b0
    public b0.a p() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("DiagnosisEntity{id=");
        h2.append(this.a);
        h2.append(", createdTimestampMs=");
        h2.append(this.b);
        h2.append(", sharedStatus=");
        h2.append(this.c);
        h2.append(", verificationCode=");
        h2.append(this.f2261d);
        h2.append(", longTermToken=");
        h2.append(this.f2262e);
        h2.append(", certificate=");
        h2.append(this.f2263f);
        h2.append(", testResult=");
        h2.append(this.f2264g);
        h2.append(", onsetDate=");
        h2.append(this.f2265h);
        h2.append(", isServerOnsetDate=");
        h2.append(this.f2266i);
        h2.append(", hasSymptoms=");
        h2.append(this.f2267j);
        h2.append(", revisionToken=");
        h2.append(this.f2268k);
        h2.append(", travelStatus=");
        h2.append(this.f2269l);
        h2.append(", isCodeFromLink=");
        h2.append(this.m);
        h2.append("}");
        return h2.toString();
    }
}
