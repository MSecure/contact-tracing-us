package c.b.d;

import c.b.d.f1;
import c.b.d.n1;
import c.b.d.s;
import c.b.d.x;
import c.b.d.x2;

public class m1 implements n1 {

    /* renamed from: a  reason: collision with root package name */
    public final f0<s.g> f5436a;

    public m1(f0<s.g> f0Var) {
        this.f5436a = f0Var;
    }

    @Override // c.b.d.n1
    public n1.a a() {
        return n1.a.EXTENSION_SET;
    }

    @Override // c.b.d.n1
    public n1 addRepeatedField(s.g gVar, Object obj) {
        this.f5436a.a(gVar, obj);
        return this;
    }

    @Override // c.b.d.n1
    public Object b(k kVar, z zVar, s.g gVar, f1 f1Var) {
        f1 f1Var2;
        f1.a newBuilderForType = f1Var.newBuilderForType();
        if (!gVar.e() && (f1Var2 = (f1) this.f5436a.k(gVar)) != null) {
            newBuilderForType.mergeFrom(f1Var2);
        }
        kVar.x(newBuilderForType, zVar);
        return newBuilderForType.buildPartial();
    }

    @Override // c.b.d.n1
    public Object c(j jVar, z zVar, s.g gVar, f1 f1Var) {
        f1 f1Var2;
        f1.a newBuilderForType = f1Var.newBuilderForType();
        if (!gVar.e() && (f1Var2 = (f1) this.f5436a.k(gVar)) != null) {
            newBuilderForType.mergeFrom(f1Var2);
        }
        newBuilderForType.mergeFrom(jVar, zVar);
        return newBuilderForType.buildPartial();
    }

    @Override // c.b.d.n1
    public Object d(k kVar, z zVar, s.g gVar, f1 f1Var) {
        f1 f1Var2;
        f1.a newBuilderForType = f1Var.newBuilderForType();
        if (!gVar.e() && (f1Var2 = (f1) this.f5436a.k(gVar)) != null) {
            newBuilderForType.mergeFrom(f1Var2);
        }
        kVar.t(gVar.f5819c.f5594d, newBuilderForType, zVar);
        return newBuilderForType.buildPartial();
    }

    @Override // c.b.d.n1
    public x.b e(x xVar, s.b bVar, int i) {
        return xVar.f5907d.get(new x.a(bVar, i));
    }

    @Override // c.b.d.n1
    public x2.d f(s.g gVar) {
        return gVar.A() ? x2.d.STRICT : x2.d.LOOSE;
    }

    @Override // c.b.d.n1
    public boolean hasField(s.g gVar) {
        return this.f5436a.r(gVar);
    }

    @Override // c.b.d.n1
    public n1 setField(s.g gVar, Object obj) {
        this.f5436a.B(gVar, obj);
        return this;
    }
}
