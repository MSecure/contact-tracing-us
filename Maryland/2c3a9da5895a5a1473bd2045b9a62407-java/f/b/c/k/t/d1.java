package f.b.c.k.t;

import f.a.a.a.a;
import f.b.c.k.s.c0;
import f.b.c.k.u.m;
import f.b.f.j;
import java.util.Objects;

public final class d1 {
    public final c0 a;
    public final int b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final h0 f3182d;

    /* renamed from: e  reason: collision with root package name */
    public final m f3183e;

    /* renamed from: f  reason: collision with root package name */
    public final m f3184f;

    /* renamed from: g  reason: collision with root package name */
    public final j f3185g;

    public d1(c0 c0Var, int i2, long j2, h0 h0Var, m mVar, m mVar2, j jVar) {
        Objects.requireNonNull(c0Var);
        this.a = c0Var;
        this.b = i2;
        this.c = j2;
        this.f3184f = mVar2;
        this.f3182d = h0Var;
        Objects.requireNonNull(mVar);
        this.f3183e = mVar;
        Objects.requireNonNull(jVar);
        this.f3185g = jVar;
    }

    public d1 a(j jVar, m mVar) {
        return new d1(this.a, this.b, this.c, this.f3182d, mVar, this.f3184f, jVar);
    }

    public d1 b(long j2) {
        return new d1(this.a, this.b, j2, this.f3182d, this.f3183e, this.f3184f, this.f3185g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d1.class != obj.getClass()) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return this.a.equals(d1Var.a) && this.b == d1Var.b && this.c == d1Var.c && this.f3182d.equals(d1Var.f3182d) && this.f3183e.equals(d1Var.f3183e) && this.f3184f.equals(d1Var.f3184f) && this.f3185g.equals(d1Var.f3185g);
    }

    public int hashCode() {
        int hashCode = this.f3182d.hashCode();
        int hashCode2 = this.f3183e.hashCode();
        int hashCode3 = this.f3184f.hashCode();
        return this.f3185g.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (((((this.a.hashCode() * 31) + this.b) * 31) + ((int) this.c)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder h2 = a.h("TargetData{target=");
        h2.append(this.a);
        h2.append(", targetId=");
        h2.append(this.b);
        h2.append(", sequenceNumber=");
        h2.append(this.c);
        h2.append(", purpose=");
        h2.append(this.f3182d);
        h2.append(", snapshotVersion=");
        h2.append(this.f3183e);
        h2.append(", lastLimboFreeSnapshotVersion=");
        h2.append(this.f3184f);
        h2.append(", resumeToken=");
        h2.append(this.f3185g);
        h2.append('}');
        return h2.toString();
    }
}
