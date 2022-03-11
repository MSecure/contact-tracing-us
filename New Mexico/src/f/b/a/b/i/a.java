package f.b.a.b.i;

import f.b.a.b.i.f;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public final class a extends f {
    public final String a;
    public final Integer b;
    public final e c;

    /* renamed from: d */
    public final long f2609d;

    /* renamed from: e */
    public final long f2610e;

    /* renamed from: f */
    public final Map<String, String> f2611f;

    /* loaded from: classes.dex */
    public static final class b extends f.a {
        public String a;
        public Integer b;
        public e c;

        /* renamed from: d */
        public Long f2612d;

        /* renamed from: e */
        public Long f2613e;

        /* renamed from: f */
        public Map<String, String> f2614f;

        @Override // f.b.a.b.i.f.a
        public f b() {
            String str = this.a == null ? " transportName" : "";
            if (this.c == null) {
                str = f.a.a.a.a.x(str, " encodedPayload");
            }
            if (this.f2612d == null) {
                str = f.a.a.a.a.x(str, " eventMillis");
            }
            if (this.f2613e == null) {
                str = f.a.a.a.a.x(str, " uptimeMillis");
            }
            if (this.f2614f == null) {
                str = f.a.a.a.a.x(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.f2612d.longValue(), this.f2613e.longValue(), this.f2614f, null);
            }
            throw new IllegalStateException(f.a.a.a.a.x("Missing required properties:", str));
        }

        @Override // f.b.a.b.i.f.a
        public Map<String, String> c() {
            Map<String, String> map = this.f2614f;
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
            this.f2612d = Long.valueOf(j2);
            return this;
        }

        public f.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        public f.a g(long j2) {
            this.f2613e = Long.valueOf(j2);
            return this;
        }
    }

    public a(String str, Integer num, e eVar, long j2, long j3, Map map, C0077a aVar) {
        this.a = str;
        this.b = num;
        this.c = eVar;
        this.f2609d = j2;
        this.f2610e = j3;
        this.f2611f = map;
    }

    @Override // f.b.a.b.i.f
    public Map<String, String> b() {
        return this.f2611f;
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
        return this.f2609d;
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
        return this.a.equals(fVar.g()) && ((num = this.b) != null ? num.equals(fVar.c()) : fVar.c() == null) && this.c.equals(fVar.d()) && this.f2609d == fVar.e() && this.f2610e == fVar.h() && this.f2611f.equals(fVar.b());
    }

    @Override // f.b.a.b.i.f
    public String g() {
        return this.a;
    }

    @Override // f.b.a.b.i.f
    public long h() {
        return this.f2610e;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j2 = this.f2609d;
        long j3 = this.f2610e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.c.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f2611f.hashCode();
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("EventInternal{transportName=");
        h2.append(this.a);
        h2.append(", code=");
        h2.append(this.b);
        h2.append(", encodedPayload=");
        h2.append(this.c);
        h2.append(", eventMillis=");
        h2.append(this.f2609d);
        h2.append(", uptimeMillis=");
        h2.append(this.f2610e);
        h2.append(", autoMetadata=");
        h2.append(this.f2611f);
        h2.append("}");
        return h2.toString();
    }
}
