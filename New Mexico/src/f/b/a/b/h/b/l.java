package f.b.a.b.h.b;

import f.a.a.a.a;
import java.util.List;
/* loaded from: classes.dex */
public final class l extends r {
    public final long a;
    public final long b;
    public final p c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f2579d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2580e;

    /* renamed from: f  reason: collision with root package name */
    public final List<q> f2581f;

    /* renamed from: g  reason: collision with root package name */
    public final u f2582g;

    public /* synthetic */ l(long j2, long j3, p pVar, Integer num, String str, List list, u uVar) {
        this.a = j2;
        this.b = j3;
        this.c = pVar;
        this.f2579d = num;
        this.f2580e = str;
        this.f2581f = list;
        this.f2582g = uVar;
    }

    @Override // f.b.a.b.h.b.r
    public p a() {
        return this.c;
    }

    @Override // f.b.a.b.h.b.r
    public List<q> b() {
        return this.f2581f;
    }

    @Override // f.b.a.b.h.b.r
    public Integer c() {
        return this.f2579d;
    }

    @Override // f.b.a.b.h.b.r
    public String d() {
        return this.f2580e;
    }

    @Override // f.b.a.b.h.b.r
    public u e() {
        return this.f2582g;
    }

    public boolean equals(Object obj) {
        p pVar;
        Integer num;
        String str;
        List<q> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (this.a == rVar.f() && this.b == rVar.g() && ((pVar = this.c) != null ? pVar.equals(((l) rVar).c) : ((l) rVar).c == null) && ((num = this.f2579d) != null ? num.equals(((l) rVar).f2579d) : ((l) rVar).f2579d == null) && ((str = this.f2580e) != null ? str.equals(((l) rVar).f2580e) : ((l) rVar).f2580e == null) && ((list = this.f2581f) != null ? list.equals(((l) rVar).f2581f) : ((l) rVar).f2581f == null)) {
            u uVar = this.f2582g;
            u uVar2 = ((l) rVar).f2582g;
            if (uVar == null) {
                if (uVar2 == null) {
                    return true;
                }
            } else if (uVar.equals(uVar2)) {
                return true;
            }
        }
        return false;
    }

    @Override // f.b.a.b.h.b.r
    public long f() {
        return this.a;
    }

    @Override // f.b.a.b.h.b.r
    public long g() {
        return this.b;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        p pVar = this.c;
        int i3 = 0;
        int hashCode = (i2 ^ (pVar == null ? 0 : pVar.hashCode())) * 1000003;
        Integer num = this.f2579d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f2580e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<q> list = this.f2581f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        u uVar = this.f2582g;
        if (uVar != null) {
            i3 = uVar.hashCode();
        }
        return hashCode4 ^ i3;
    }

    public String toString() {
        StringBuilder h2 = a.h("LogRequest{requestTimeMs=");
        h2.append(this.a);
        h2.append(", requestUptimeMs=");
        h2.append(this.b);
        h2.append(", clientInfo=");
        h2.append(this.c);
        h2.append(", logSource=");
        h2.append(this.f2579d);
        h2.append(", logSourceName=");
        h2.append(this.f2580e);
        h2.append(", logEvents=");
        h2.append(this.f2581f);
        h2.append(", qosTier=");
        h2.append(this.f2582g);
        h2.append("}");
        return h2.toString();
    }
}
