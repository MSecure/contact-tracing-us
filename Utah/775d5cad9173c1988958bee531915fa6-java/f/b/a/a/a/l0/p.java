package f.b.a.a.a.l0;

import l.b.a.e;

public final class p extends e1 {
    public final long a;
    public final e b;
    public final e c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2310d;

    public p(long j2, e eVar, e eVar2, String str, a aVar) {
        this.a = j2;
        this.b = eVar;
        this.c = eVar2;
        this.f2310d = str;
    }

    @Override // f.b.a.a.a.l0.e1
    public e b() {
        return this.c;
    }

    @Override // f.b.a.a.a.l0.e1
    public long c() {
        return this.a;
    }

    @Override // f.b.a.a.a.l0.e1
    public String d() {
        return this.f2310d;
    }

    @Override // f.b.a.a.a.l0.e1
    public e e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        e eVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return this.a == e1Var.c() && this.b.equals(e1Var.e()) && ((eVar = this.c) != null ? eVar.equals(e1Var.b()) : e1Var.b() == null) && this.f2310d.equals(e1Var.d());
    }

    public int hashCode() {
        long j2 = this.a;
        int hashCode = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        e eVar = this.c;
        return this.f2310d.hashCode() ^ ((hashCode ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("VerificationCodeRequestEntity{id=");
        h2.append(this.a);
        h2.append(", requestTime=");
        h2.append(this.b);
        h2.append(", expiresAtTime=");
        h2.append(this.c);
        h2.append(", nonce=");
        return f.a.a.a.a.e(h2, this.f2310d, "}");
    }
}
