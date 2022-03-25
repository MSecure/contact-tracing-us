package f.b.a.a.a.y;

import f.b.a.a.a.y.c0;
import java.util.Objects;
import l.b.a.e;

public final class j extends c0 {
    public final long a;
    public final long b;
    public final c0.c c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2338d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2339e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2340f;

    /* renamed from: g  reason: collision with root package name */
    public final c0.d f2341g;

    /* renamed from: h  reason: collision with root package name */
    public final e f2342h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2343i;

    /* renamed from: j  reason: collision with root package name */
    public final c0.b f2344j;

    /* renamed from: k  reason: collision with root package name */
    public final String f2345k;

    /* renamed from: l  reason: collision with root package name */
    public final c0.e f2346l;
    public final boolean m;

    public static final class b extends c0.a {
        public Long a;
        public Long b;
        public c0.c c;

        /* renamed from: d  reason: collision with root package name */
        public String f2347d;

        /* renamed from: e  reason: collision with root package name */
        public String f2348e;

        /* renamed from: f  reason: collision with root package name */
        public String f2349f;

        /* renamed from: g  reason: collision with root package name */
        public c0.d f2350g;

        /* renamed from: h  reason: collision with root package name */
        public e f2351h;

        /* renamed from: i  reason: collision with root package name */
        public Boolean f2352i;

        /* renamed from: j  reason: collision with root package name */
        public c0.b f2353j;

        /* renamed from: k  reason: collision with root package name */
        public String f2354k;

        /* renamed from: l  reason: collision with root package name */
        public c0.e f2355l;
        public Boolean m;

        public b() {
        }

        public b(c0 c0Var, a aVar) {
            j jVar = (j) c0Var;
            this.a = Long.valueOf(jVar.a);
            this.b = Long.valueOf(jVar.b);
            this.c = jVar.c;
            this.f2347d = jVar.f2338d;
            this.f2348e = jVar.f2339e;
            this.f2349f = jVar.f2340f;
            this.f2350g = jVar.f2341g;
            this.f2351h = jVar.f2342h;
            this.f2352i = Boolean.valueOf(jVar.f2343i);
            this.f2353j = jVar.f2344j;
            this.f2354k = jVar.f2345k;
            this.f2355l = jVar.f2346l;
            this.m = Boolean.valueOf(jVar.m);
        }

        @Override // f.b.a.a.a.y.c0.a
        public c0 a() {
            String str = this.a == null ? " id" : "";
            if (this.b == null) {
                str = f.a.a.a.a.t(str, " createdTimestampMs");
            }
            if (this.f2352i == null) {
                str = f.a.a.a.a.t(str, " isServerOnsetDate");
            }
            if (this.f2353j == null) {
                str = f.a.a.a.a.t(str, " hasSymptoms");
            }
            if (this.m == null) {
                str = f.a.a.a.a.t(str, " isCodeFromLink");
            }
            if (str.isEmpty()) {
                return new j(this.a.longValue(), this.b.longValue(), this.c, this.f2347d, this.f2348e, this.f2349f, this.f2350g, this.f2351h, this.f2352i.booleanValue(), this.f2353j, this.f2354k, this.f2355l, this.m.booleanValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.y.c0.a
        public c0.a b(long j2) {
            this.b = Long.valueOf(j2);
            return this;
        }

        @Override // f.b.a.a.a.y.c0.a
        public c0.a c(c0.b bVar) {
            Objects.requireNonNull(bVar, "Null hasSymptoms");
            this.f2353j = bVar;
            return this;
        }

        public c0.a d(boolean z) {
            this.m = Boolean.valueOf(z);
            return this;
        }

        public c0.a e(boolean z) {
            this.f2352i = Boolean.valueOf(z);
            return this;
        }
    }

    public j(long j2, long j3, c0.c cVar, String str, String str2, String str3, c0.d dVar, e eVar, boolean z, c0.b bVar, String str4, c0.e eVar2, boolean z2, a aVar) {
        this.a = j2;
        this.b = j3;
        this.c = cVar;
        this.f2338d = str;
        this.f2339e = str2;
        this.f2340f = str3;
        this.f2341g = dVar;
        this.f2342h = eVar;
        this.f2343i = z;
        this.f2344j = bVar;
        this.f2345k = str4;
        this.f2346l = eVar2;
        this.m = z2;
    }

    @Override // f.b.a.a.a.y.c0
    public String b() {
        return this.f2340f;
    }

    @Override // f.b.a.a.a.y.c0
    public long c() {
        return this.b;
    }

    @Override // f.b.a.a.a.y.c0
    public c0.b d() {
        return this.f2344j;
    }

    @Override // f.b.a.a.a.y.c0
    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        c0.c cVar;
        String str;
        String str2;
        String str3;
        c0.d dVar;
        e eVar;
        String str4;
        c0.e eVar2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.a == c0Var.e() && this.b == c0Var.c() && ((cVar = this.c) != null ? cVar.equals(c0Var.k()) : c0Var.k() == null) && ((str = this.f2338d) != null ? str.equals(c0Var.n()) : c0Var.n() == null) && ((str2 = this.f2339e) != null ? str2.equals(c0Var.h()) : c0Var.h() == null) && ((str3 = this.f2340f) != null ? str3.equals(c0Var.b()) : c0Var.b() == null) && ((dVar = this.f2341g) != null ? dVar.equals(c0Var.l()) : c0Var.l() == null) && ((eVar = this.f2342h) != null ? eVar.equals(c0Var.i()) : c0Var.i() == null) && this.f2343i == c0Var.g() && this.f2344j.equals(c0Var.d()) && ((str4 = this.f2345k) != null ? str4.equals(c0Var.j()) : c0Var.j() == null) && ((eVar2 = this.f2346l) != null ? eVar2.equals(c0Var.m()) : c0Var.m() == null) && this.m == c0Var.f();
    }

    @Override // f.b.a.a.a.y.c0
    public boolean f() {
        return this.m;
    }

    @Override // f.b.a.a.a.y.c0
    public boolean g() {
        return this.f2343i;
    }

    @Override // f.b.a.a.a.y.c0
    public String h() {
        return this.f2339e;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        c0.c cVar = this.c;
        int i3 = 0;
        int hashCode = (i2 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        String str = this.f2338d;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f2339e;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2340f;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        c0.d dVar = this.f2341g;
        int hashCode5 = (hashCode4 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        e eVar = this.f2342h;
        int i4 = 1231;
        int hashCode6 = (((((hashCode5 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003) ^ (this.f2343i ? 1231 : 1237)) * 1000003) ^ this.f2344j.hashCode()) * 1000003;
        String str4 = this.f2345k;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        c0.e eVar2 = this.f2346l;
        if (eVar2 != null) {
            i3 = eVar2.hashCode();
        }
        int i5 = (hashCode7 ^ i3) * 1000003;
        if (!this.m) {
            i4 = 1237;
        }
        return i5 ^ i4;
    }

    @Override // f.b.a.a.a.y.c0
    public e i() {
        return this.f2342h;
    }

    @Override // f.b.a.a.a.y.c0
    public String j() {
        return this.f2345k;
    }

    @Override // f.b.a.a.a.y.c0
    public c0.c k() {
        return this.c;
    }

    @Override // f.b.a.a.a.y.c0
    public c0.d l() {
        return this.f2341g;
    }

    @Override // f.b.a.a.a.y.c0
    public c0.e m() {
        return this.f2346l;
    }

    @Override // f.b.a.a.a.y.c0
    public String n() {
        return this.f2338d;
    }

    @Override // f.b.a.a.a.y.c0
    public c0.a p() {
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
        h2.append(this.f2338d);
        h2.append(", longTermToken=");
        h2.append(this.f2339e);
        h2.append(", certificate=");
        h2.append(this.f2340f);
        h2.append(", testResult=");
        h2.append(this.f2341g);
        h2.append(", onsetDate=");
        h2.append(this.f2342h);
        h2.append(", isServerOnsetDate=");
        h2.append(this.f2343i);
        h2.append(", hasSymptoms=");
        h2.append(this.f2344j);
        h2.append(", revisionToken=");
        h2.append(this.f2345k);
        h2.append(", travelStatus=");
        h2.append(this.f2346l);
        h2.append(", isCodeFromLink=");
        h2.append(this.m);
        h2.append("}");
        return h2.toString();
    }
}
