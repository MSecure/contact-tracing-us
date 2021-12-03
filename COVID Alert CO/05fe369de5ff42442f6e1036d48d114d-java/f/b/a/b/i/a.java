package f.b.a.b.i;

import f.b.a.b.i.f;
import java.util.Map;
import java.util.Objects;

public final class a extends f {
    public final String a;
    public final Integer b;
    public final e c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2514d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2515e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, String> f2516f;

    public static final class b extends f.a {
        public String a;
        public Integer b;
        public e c;

        /* renamed from: d  reason: collision with root package name */
        public Long f2517d;

        /* renamed from: e  reason: collision with root package name */
        public Long f2518e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f2519f;

        @Override // f.b.a.b.i.f.a
        public f b() {
            String str = this.a == null ? " transportName" : "";
            if (this.c == null) {
                str = f.a.a.a.a.c(str, " encodedPayload");
            }
            if (this.f2517d == null) {
                str = f.a.a.a.a.c(str, " eventMillis");
            }
            if (this.f2518e == null) {
                str = f.a.a.a.a.c(str, " uptimeMillis");
            }
            if (this.f2519f == null) {
                str = f.a.a.a.a.c(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.f2517d.longValue(), this.f2518e.longValue(), this.f2519f, null);
            }
            throw new IllegalStateException(f.a.a.a.a.c("Missing required properties:", str));
        }

        @Override // f.b.a.b.i.f.a
        public Map<String, String> c() {
            Map<String, String> map = this.f2519f;
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
            this.f2517d = Long.valueOf(j2);
            return this;
        }

        public f.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        public f.a g(long j2) {
            this.f2518e = Long.valueOf(j2);
            return this;
        }
    }

    public a(String str, Integer num, e eVar, long j2, long j3, Map map, C0077a aVar) {
        this.a = str;
        this.b = num;
        this.c = eVar;
        this.f2514d = j2;
        this.f2515e = j3;
        this.f2516f = map;
    }

    @Override // f.b.a.b.i.f
    public Map<String, String> b() {
        return this.f2516f;
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
        return this.f2514d;
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
        return this.a.equals(fVar.g()) && ((num = this.b) != null ? num.equals(fVar.c()) : fVar.c() == null) && this.c.equals(fVar.d()) && this.f2514d == fVar.e() && this.f2515e == fVar.h() && this.f2516f.equals(fVar.b());
    }

    @Override // f.b.a.b.i.f
    public String g() {
        return this.a;
    }

    @Override // f.b.a.b.i.f
    public long h() {
        return this.f2515e;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j2 = this.f2514d;
        long j3 = this.f2515e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.c.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f2516f.hashCode();
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("EventInternal{transportName=");
        i2.append(this.a);
        i2.append(", code=");
        i2.append(this.b);
        i2.append(", encodedPayload=");
        i2.append(this.c);
        i2.append(", eventMillis=");
        i2.append(this.f2514d);
        i2.append(", uptimeMillis=");
        i2.append(this.f2515e);
        i2.append(", autoMetadata=");
        i2.append(this.f2516f);
        i2.append("}");
        return i2.toString();
    }
}
