package c.b.d;

import c.b.d.f1;
import c.b.d.n1;
import c.b.d.s;
import c.b.d.x;
import c.b.d.x2;

public class l1 implements n1 {

    /* renamed from: a  reason: collision with root package name */
    public final f1.a f5421a;

    public l1(f1.a aVar) {
        this.f5421a = aVar;
    }

    @Override // c.b.d.n1
    public n1.a a() {
        return n1.a.MESSAGE;
    }

    @Override // c.b.d.n1
    public n1 addRepeatedField(s.g gVar, Object obj) {
        this.f5421a.addRepeatedField(gVar, obj);
        return this;
    }

    @Override // c.b.d.n1
    public Object b(k kVar, z zVar, s.g gVar, f1 f1Var) {
        f1 f1Var2;
        f1.a newBuilderForType = f1Var != null ? f1Var.newBuilderForType() : this.f5421a.newBuilderForField(gVar);
        if (!gVar.e() && (f1Var2 = (f1) this.f5421a.getField(gVar)) != null) {
            newBuilderForType.mergeFrom(f1Var2);
        }
        kVar.x(newBuilderForType, zVar);
        return newBuilderForType.buildPartial();
    }

    @Override // c.b.d.n1
    public Object c(j jVar, z zVar, s.g gVar, f1 f1Var) {
        f1 f1Var2;
        f1.a newBuilderForType = f1Var != null ? f1Var.newBuilderForType() : this.f5421a.newBuilderForField(gVar);
        if (!gVar.e() && (f1Var2 = (f1) this.f5421a.getField(gVar)) != null) {
            newBuilderForType.mergeFrom(f1Var2);
        }
        newBuilderForType.mergeFrom(jVar, zVar);
        return newBuilderForType.buildPartial();
    }

    @Override // c.b.d.n1
    public Object d(k kVar, z zVar, s.g gVar, f1 f1Var) {
        f1 f1Var2;
        f1.a newBuilderForType = f1Var != null ? f1Var.newBuilderForType() : this.f5421a.newBuilderForField(gVar);
        if (!gVar.e() && (f1Var2 = (f1) this.f5421a.getField(gVar)) != null) {
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
        if (gVar.A()) {
            return x2.d.STRICT;
        }
        gVar.e();
        return x2.d.LOOSE;
    }

    @Override // c.b.d.n1
    public boolean hasField(s.g gVar) {
        return this.f5421a.hasField(gVar);
    }

    @Override // c.b.d.n1
    public n1 setField(s.g gVar, Object obj) {
        this.f5421a.setField(gVar, obj);
        return this;
    }
}
