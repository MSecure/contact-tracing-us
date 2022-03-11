package f.b.c.k.w;

import f.b.c.g.a.f;
import f.b.g.j;
/* loaded from: classes.dex */
public final class o0 {
    public final j a;
    public final boolean b;
    public final f<f.b.c.k.u.f> c;

    /* renamed from: d  reason: collision with root package name */
    public final f<f.b.c.k.u.f> f3668d;

    /* renamed from: e  reason: collision with root package name */
    public final f<f.b.c.k.u.f> f3669e;

    public o0(j jVar, boolean z, f<f.b.c.k.u.f> fVar, f<f.b.c.k.u.f> fVar2, f<f.b.c.k.u.f> fVar3) {
        this.a = jVar;
        this.b = z;
        this.c = fVar;
        this.f3668d = fVar2;
        this.f3669e = fVar3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o0.class != obj.getClass()) {
            return false;
        }
        o0 o0Var = (o0) obj;
        if (this.b == o0Var.b && this.a.equals(o0Var.a) && this.c.equals(o0Var.c) && this.f3668d.equals(o0Var.f3668d)) {
            return this.f3669e.equals(o0Var.f3669e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.c.hashCode();
        int hashCode2 = this.f3668d.hashCode();
        return this.f3669e.hashCode() + ((hashCode2 + ((hashCode + (((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31)) * 31)) * 31);
    }
}
