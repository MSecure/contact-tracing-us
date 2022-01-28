package f.b.a.b.i;

import f.b.a.b.i.f;
import java.util.Map;
import java.util.Objects;

public final class a extends f {
    public final String a;
    public final Integer b;
    public final e c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2568d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2569e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, String> f2570f;

    public static final class b extends f.a {
        public String a;
        public Integer b;
        public e c;

        /* renamed from: d  reason: collision with root package name */
        public Long f2571d;

        /* renamed from: e  reason: collision with root package name */
        public Long f2572e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f2573f;

        @Override // f.b.a.b.i.f.a
        public f b() {
            String str = this.a == null ? " transportName" : "";
            if (this.c == null) {
                str = f.a.a.a.a.w(str, " encodedPayload");
            }
            if (this.f2571d == null) {
                str = f.a.a.a.a.w(str, " eventMillis");
            }
            if (this.f2572e == null) {
                str = f.a.a.a.a.w(str, " uptimeMillis");
            }
            if (this.f2573f == null) {
                str = f.a.a.a.a.w(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.f2571d.longValue(), this.f2572e.longValue(), this.f2573f, null);
            }
            throw new IllegalStateException(f.a.a.a.a.w("Missing required properties:", str));
        }

        @Override // f.b.a.b.i.f.a
        public Map<String, String> c() {
            Map<String, String> map = this.f2573f;
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
            this.f2571d = Long.valueOf(j2);
            return this;
        }

        public f.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        public f.a g(long j2) {
            this.f2572e = Long.valueOf(j2);
            return this;
        }
    }

    public a(String str, Integer num, e eVar, long j2, long j3, Map map, C0075a aVar) {
        this.a = str;
        this.b = num;
        this.c = eVar;
        this.f2568d = j2;
        this.f2569e = j3;
        this.f2570f = map;
    }

    @Override // f.b.a.b.i.f
    public Map<String, String> b() {
        return this.f2570f;
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
        return this.f2568d;
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
        return this.a.equals(fVar.g()) && ((num = this.b) != null ? num.equals(fVar.c()) : fVar.c() == null) && this.c.equals(fVar.d()) && this.f2568d == fVar.e() && this.f2569e == fVar.h() && this.f2570f.equals(fVar.b());
    }

    @Override // f.b.a.b.i.f
    public String g() {
        return this.a;
    }

    @Override // f.b.a.b.i.f
    public long h() {
        return this.f2569e;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j2 = this.f2568d;
        long j3 = this.f2569e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.c.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f2570f.hashCode();
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("EventInternal{transportName=");
        h2.append(this.a);
        h2.append(", code=");
        h2.append(this.b);
        h2.append(", encodedPayload=");
        h2.append(this.c);
        h2.append(", eventMillis=");
        h2.append(this.f2568d);
        h2.append(", uptimeMillis=");
        h2.append(this.f2569e);
        h2.append(", autoMetadata=");
        h2.append(this.f2570f);
        h2.append("}");
        return h2.toString();
    }
}
