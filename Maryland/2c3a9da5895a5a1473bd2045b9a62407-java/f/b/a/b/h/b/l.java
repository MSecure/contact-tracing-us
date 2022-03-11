package f.b.a.b.h.b;

import f.a.a.a.a;
import java.util.List;

public final class l extends r {
    public final long a;
    public final long b;
    public final p c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f2395d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2396e;

    /* renamed from: f  reason: collision with root package name */
    public final List<q> f2397f;

    /* renamed from: g  reason: collision with root package name */
    public final u f2398g;

    public /* synthetic */ l(long j2, long j3, p pVar, Integer num, String str, List list, u uVar) {
        this.a = j2;
        this.b = j3;
        this.c = pVar;
        this.f2395d = num;
        this.f2396e = str;
        this.f2397f = list;
        this.f2398g = uVar;
    }

    @Override // f.b.a.b.h.b.r
    public p a() {
        return this.c;
    }

    @Override // f.b.a.b.h.b.r
    public List<q> b() {
        return this.f2397f;
    }

    @Override // f.b.a.b.h.b.r
    public Integer c() {
        return this.f2395d;
    }

    @Override // f.b.a.b.h.b.r
    public String d() {
        return this.f2396e;
    }

    @Override // f.b.a.b.h.b.r
    public u e() {
        return this.f2398g;
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
        if (this.a == rVar.f() && this.b == rVar.g() && ((pVar = this.c) != null ? pVar.equals(((l) rVar).c) : ((l) rVar).c == null) && ((num = this.f2395d) != null ? num.equals(((l) rVar).f2395d) : ((l) rVar).f2395d == null) && ((str = this.f2396e) != null ? str.equals(((l) rVar).f2396e) : ((l) rVar).f2396e == null) && ((list = this.f2397f) != null ? list.equals(((l) rVar).f2397f) : ((l) rVar).f2397f == null)) {
            u uVar = this.f2398g;
            u uVar2 = ((l) rVar).f2398g;
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
        Integer num = this.f2395d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f2396e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<q> list = this.f2397f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        u uVar = this.f2398g;
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
        h2.append(this.f2395d);
        h2.append(", logSourceName=");
        h2.append(this.f2396e);
        h2.append(", logEvents=");
        h2.append(this.f2397f);
        h2.append(", qosTier=");
        h2.append(this.f2398g);
        h2.append("}");
        return h2.toString();
    }
}
