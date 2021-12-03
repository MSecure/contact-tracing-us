package f.b.a.b.h.b;

import f.a.a.a.a;
import java.util.List;

public final class l extends r {
    public final long a;
    public final long b;
    public final p c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f2484d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2485e;

    /* renamed from: f  reason: collision with root package name */
    public final List<q> f2486f;

    /* renamed from: g  reason: collision with root package name */
    public final u f2487g;

    public /* synthetic */ l(long j2, long j3, p pVar, Integer num, String str, List list, u uVar) {
        this.a = j2;
        this.b = j3;
        this.c = pVar;
        this.f2484d = num;
        this.f2485e = str;
        this.f2486f = list;
        this.f2487g = uVar;
    }

    @Override // f.b.a.b.h.b.r
    public p a() {
        return this.c;
    }

    @Override // f.b.a.b.h.b.r
    public List<q> b() {
        return this.f2486f;
    }

    @Override // f.b.a.b.h.b.r
    public Integer c() {
        return this.f2484d;
    }

    @Override // f.b.a.b.h.b.r
    public String d() {
        return this.f2485e;
    }

    @Override // f.b.a.b.h.b.r
    public u e() {
        return this.f2487g;
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
        if (this.a == rVar.f() && this.b == rVar.g() && ((pVar = this.c) != null ? pVar.equals(((l) rVar).c) : ((l) rVar).c == null) && ((num = this.f2484d) != null ? num.equals(((l) rVar).f2484d) : ((l) rVar).f2484d == null) && ((str = this.f2485e) != null ? str.equals(((l) rVar).f2485e) : ((l) rVar).f2485e == null) && ((list = this.f2486f) != null ? list.equals(((l) rVar).f2486f) : ((l) rVar).f2486f == null)) {
            u uVar = this.f2487g;
            u uVar2 = ((l) rVar).f2487g;
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
        Integer num = this.f2484d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f2485e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<q> list = this.f2486f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        u uVar = this.f2487g;
        if (uVar != null) {
            i3 = uVar.hashCode();
        }
        return hashCode4 ^ i3;
    }

    public String toString() {
        StringBuilder i2 = a.i("LogRequest{requestTimeMs=");
        i2.append(this.a);
        i2.append(", requestUptimeMs=");
        i2.append(this.b);
        i2.append(", clientInfo=");
        i2.append(this.c);
        i2.append(", logSource=");
        i2.append(this.f2484d);
        i2.append(", logSourceName=");
        i2.append(this.f2485e);
        i2.append(", logEvents=");
        i2.append(this.f2486f);
        i2.append(", qosTier=");
        i2.append(this.f2487g);
        i2.append("}");
        return i2.toString();
    }
}
