package f.b.a.b.h.b;

import f.b.a.b.h.b.q;
import java.util.Arrays;

public final class k extends q {
    public final long a;
    public final Integer b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f2530d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2531e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2532f;

    /* renamed from: g  reason: collision with root package name */
    public final t f2533g;

    public static final class a extends q.a {
        public Long a;
        public Integer b;
        public Long c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f2534d;

        /* renamed from: e  reason: collision with root package name */
        public String f2535e;

        /* renamed from: f  reason: collision with root package name */
        public Long f2536f;

        /* renamed from: g  reason: collision with root package name */
        public t f2537g;
    }

    public /* synthetic */ k(long j2, Integer num, long j3, byte[] bArr, String str, long j4, t tVar) {
        this.a = j2;
        this.b = num;
        this.c = j3;
        this.f2530d = bArr;
        this.f2531e = str;
        this.f2532f = j4;
        this.f2533g = tVar;
    }

    @Override // f.b.a.b.h.b.q
    public Integer a() {
        return this.b;
    }

    @Override // f.b.a.b.h.b.q
    public long b() {
        return this.a;
    }

    @Override // f.b.a.b.h.b.q
    public long c() {
        return this.c;
    }

    @Override // f.b.a.b.h.b.q
    public t d() {
        return this.f2533g;
    }

    @Override // f.b.a.b.h.b.q
    public byte[] e() {
        return this.f2530d;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.a == qVar.b() && ((num = this.b) != null ? num.equals(((k) qVar).b) : ((k) qVar).b == null) && this.c == qVar.c()) {
            if (Arrays.equals(this.f2530d, qVar instanceof k ? ((k) qVar).f2530d : qVar.e()) && ((str = this.f2531e) != null ? str.equals(((k) qVar).f2531e) : ((k) qVar).f2531e == null) && this.f2532f == qVar.g()) {
                t tVar = this.f2533g;
                t tVar2 = ((k) qVar).f2533g;
                if (tVar == null) {
                    if (tVar2 == null) {
                        return true;
                    }
                } else if (tVar.equals(tVar2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // f.b.a.b.h.b.q
    public String f() {
        return this.f2531e;
    }

    @Override // f.b.a.b.h.b.q
    public long g() {
        return this.f2532f;
    }

    public int hashCode() {
        long j2 = this.a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.b;
        int i3 = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        long j3 = this.c;
        int hashCode2 = (((((i2 ^ hashCode) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f2530d)) * 1000003;
        String str = this.f2531e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j4 = this.f2532f;
        int i4 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        t tVar = this.f2533g;
        if (tVar != null) {
            i3 = tVar.hashCode();
        }
        return i4 ^ i3;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("LogEvent{eventTimeMs=");
        h2.append(this.a);
        h2.append(", eventCode=");
        h2.append(this.b);
        h2.append(", eventUptimeMs=");
        h2.append(this.c);
        h2.append(", sourceExtension=");
        h2.append(Arrays.toString(this.f2530d));
        h2.append(", sourceExtensionJsonProto3=");
        h2.append(this.f2531e);
        h2.append(", timezoneOffsetSeconds=");
        h2.append(this.f2532f);
        h2.append(", networkConnectionInfo=");
        h2.append(this.f2533g);
        h2.append("}");
        return h2.toString();
    }
}
