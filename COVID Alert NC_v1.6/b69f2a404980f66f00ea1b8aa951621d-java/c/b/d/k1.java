package c.b.d;

import c.b.d.e1;
import c.b.d.m1;
import c.b.d.s;
import c.b.d.w2;
import c.b.d.x;

public class k1 implements m1 {

    /* renamed from: a  reason: collision with root package name */
    public final e1.a f3981a;

    public k1(e1.a aVar) {
        this.f3981a = aVar;
    }

    @Override // c.b.d.m1
    public m1.a a() {
        return m1.a.MESSAGE;
    }

    @Override // c.b.d.m1
    public m1 addRepeatedField(s.g gVar, Object obj) {
        this.f3981a.addRepeatedField(gVar, obj);
        return this;
    }

    @Override // c.b.d.m1
    public Object b(k kVar, z zVar, s.g gVar, e1 e1Var) {
        e1 e1Var2;
        e1.a newBuilderForType = e1Var != null ? e1Var.newBuilderForType() : this.f3981a.newBuilderForField(gVar);
        if (!gVar.c() && (e1Var2 = (e1) this.f3981a.getField(gVar)) != null) {
            newBuilderForType.mergeFrom(e1Var2);
        }
        kVar.x(newBuilderForType, zVar);
        return newBuilderForType.buildPartial();
    }

    @Override // c.b.d.m1
    public Object c(j jVar, z zVar, s.g gVar, e1 e1Var) {
        e1 e1Var2;
        e1.a newBuilderForType = e1Var != null ? e1Var.newBuilderForType() : this.f3981a.newBuilderForField(gVar);
        if (!gVar.c() && (e1Var2 = (e1) this.f3981a.getField(gVar)) != null) {
            newBuilderForType.mergeFrom(e1Var2);
        }
        newBuilderForType.mergeFrom(jVar, zVar);
        return newBuilderForType.buildPartial();
    }

    @Override // c.b.d.m1
    public Object d(k kVar, z zVar, s.g gVar, e1 e1Var) {
        e1 e1Var2;
        e1.a newBuilderForType = e1Var != null ? e1Var.newBuilderForType() : this.f3981a.newBuilderForField(gVar);
        if (!gVar.c() && (e1Var2 = (e1) this.f3981a.getField(gVar)) != null) {
            newBuilderForType.mergeFrom(e1Var2);
        }
        kVar.t(gVar.f4293c.f4132d, newBuilderForType, zVar);
        return newBuilderForType.buildPartial();
    }

    @Override // c.b.d.m1
    public x.b e(x xVar, s.b bVar, int i) {
        return xVar.f4384d.get(new x.a(bVar, i));
    }

    @Override // c.b.d.m1
    public w2.d f(s.g gVar) {
        if (gVar.u()) {
            return w2.d.STRICT;
        }
        gVar.c();
        return w2.d.LOOSE;
    }

    @Override // c.b.d.m1
    public boolean hasField(s.g gVar) {
        return this.f3981a.hasField(gVar);
    }

    @Override // c.b.d.m1
    public m1 setField(s.g gVar, Object obj) {
        this.f3981a.setField(gVar, obj);
        return this;
    }
}
