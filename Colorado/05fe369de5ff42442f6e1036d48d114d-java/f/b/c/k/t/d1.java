package f.b.c.k.t;

import f.a.a.a.a;
import f.b.c.k.s.c0;
import f.b.c.k.u.m;
import f.b.g.j;
import java.util.Objects;

public final class d1 {
    public final c0 a;
    public final int b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final h0 f3277d;

    /* renamed from: e  reason: collision with root package name */
    public final m f3278e;

    /* renamed from: f  reason: collision with root package name */
    public final m f3279f;

    /* renamed from: g  reason: collision with root package name */
    public final j f3280g;

    public d1(c0 c0Var, int i2, long j2, h0 h0Var, m mVar, m mVar2, j jVar) {
        Objects.requireNonNull(c0Var);
        this.a = c0Var;
        this.b = i2;
        this.c = j2;
        this.f3279f = mVar2;
        this.f3277d = h0Var;
        Objects.requireNonNull(mVar);
        this.f3278e = mVar;
        Objects.requireNonNull(jVar);
        this.f3280g = jVar;
    }

    public d1 a(j jVar, m mVar) {
        return new d1(this.a, this.b, this.c, this.f3277d, mVar, this.f3279f, jVar);
    }

    public d1 b(long j2) {
        return new d1(this.a, this.b, j2, this.f3277d, this.f3278e, this.f3279f, this.f3280g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d1.class != obj.getClass()) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return this.a.equals(d1Var.a) && this.b == d1Var.b && this.c == d1Var.c && this.f3277d.equals(d1Var.f3277d) && this.f3278e.equals(d1Var.f3278e) && this.f3279f.equals(d1Var.f3279f) && this.f3280g.equals(d1Var.f3280g);
    }

    public int hashCode() {
        int hashCode = this.f3277d.hashCode();
        int hashCode2 = this.f3278e.hashCode();
        int hashCode3 = this.f3279f.hashCode();
        return this.f3280g.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (((((this.a.hashCode() * 31) + this.b) * 31) + ((int) this.c)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder i2 = a.i("TargetData{target=");
        i2.append(this.a);
        i2.append(", targetId=");
        i2.append(this.b);
        i2.append(", sequenceNumber=");
        i2.append(this.c);
        i2.append(", purpose=");
        i2.append(this.f3277d);
        i2.append(", snapshotVersion=");
        i2.append(this.f3278e);
        i2.append(", lastLimboFreeSnapshotVersion=");
        i2.append(this.f3279f);
        i2.append(", resumeToken=");
        i2.append(this.f3280g);
        i2.append('}');
        return i2.toString();
    }
}
