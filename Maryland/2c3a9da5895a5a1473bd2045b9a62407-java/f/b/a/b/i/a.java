package f.b.a.b.i;

import f.b.a.b.i.f;
import java.util.Map;
import java.util.Objects;

public final class a extends f {
    public final String a;
    public final Integer b;
    public final e c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2425d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2426e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, String> f2427f;

    public static final class b extends f.a {
        public String a;
        public Integer b;
        public e c;

        /* renamed from: d  reason: collision with root package name */
        public Long f2428d;

        /* renamed from: e  reason: collision with root package name */
        public Long f2429e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f2430f;

        @Override // f.b.a.b.i.f.a
        public f b() {
            String str = this.a == null ? " transportName" : "";
            if (this.c == null) {
                str = f.a.a.a.a.t(str, " encodedPayload");
            }
            if (this.f2428d == null) {
                str = f.a.a.a.a.t(str, " eventMillis");
            }
            if (this.f2429e == null) {
                str = f.a.a.a.a.t(str, " uptimeMillis");
            }
            if (this.f2430f == null) {
                str = f.a.a.a.a.t(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.f2428d.longValue(), this.f2429e.longValue(), this.f2430f, null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }

        @Override // f.b.a.b.i.f.a
        public Map<String, String> c() {
            Map<String, String> map = this.f2430f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public f.a d(e eVar) {
            Objects.requireNonNull(eVar, "Null encodedPayload");
            this.c = eVar;
            return this;
        }

        public f.a e(long j2) {
            this.f2428d = Long.valueOf(j2);
            return this;
        }

        public f.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        public f.a g(long j2) {
            this.f2429e = Long.valueOf(j2);
            return this;
        }
    }

    public a(String str, Integer num, e eVar, long j2, long j3, Map map, C0078a aVar) {
        this.a = str;
        this.b = num;
        this.c = eVar;
        this.f2425d = j2;
        this.f2426e = j3;
        this.f2427f = map;
    }

    @Override // f.b.a.b.i.f
    public Map<String, String> b() {
        return this.f2427f;
    }

    @Override // f.b.a.b.i.f
    public Integer c() {
        return this.b;
    }

    @Override // f.b.a.b.i.f
    public e d() {
        return this.c;
    }

    @Override // f.b.a.b.i.f
    public long e() {
        return this.f2425d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a.equals(fVar.g()) && ((num = this.b) != null ? num.equals(fVar.c()) : fVar.c() == null) && this.c.equals(fVar.d()) && this.f2425d == fVar.e() && this.f2426e == fVar.h() && this.f2427f.equals(fVar.b());
    }

    @Override // f.b.a.b.i.f
    public String g() {
        return this.a;
    }

    @Override // f.b.a.b.i.f
    public long h() {
        return this.f2426e;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j2 = this.f2425d;
        long j3 = this.f2426e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.c.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f2427f.hashCode();
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("EventInternal{transportName=");
        h2.append(this.a);
        h2.append(", code=");
        h2.append(this.b);
        h2.append(", encodedPayload=");
        h2.append(this.c);
        h2.append(", eventMillis=");
        h2.append(this.f2425d);
        h2.append(", uptimeMillis=");
        h2.append(this.f2426e);
        h2.append(", autoMetadata=");
        h2.append(this.f2427f);
        h2.append("}");
        return h2.toString();
    }
}
