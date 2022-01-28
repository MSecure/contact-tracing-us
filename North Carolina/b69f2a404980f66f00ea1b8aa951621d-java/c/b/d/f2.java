package c.b.d;

import c.b.d.a;
import c.b.d.a.AbstractC0097a;
import c.b.d.j1;

public class f2<MType extends a, BType extends a.AbstractC0097a, IType extends j1> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public a.b f3866a;

    /* renamed from: b  reason: collision with root package name */
    public BType f3867b;

    /* renamed from: c  reason: collision with root package name */
    public MType f3868c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3869d;

    public f2(MType mtype, a.b bVar, boolean z) {
        m0.a(mtype);
        this.f3868c = mtype;
        this.f3866a = bVar;
        this.f3869d = z;
    }

    @Override // c.b.d.a.b
    public void a() {
        g();
    }

    public MType b() {
        this.f3869d = true;
        return e();
    }

    public f2<MType, BType, IType> c() {
        j1 j1Var = this.f3868c;
        if (j1Var == null) {
            j1Var = this.f3867b;
        }
        this.f3868c = (MType) ((a) j1Var.getDefaultInstanceForType());
        BType btype = this.f3867b;
        if (btype != null) {
            btype.dispose();
            this.f3867b = null;
        }
        g();
        return this;
    }

    public BType d() {
        if (this.f3867b == null) {
            BType btype = (BType) ((a.AbstractC0097a) this.f3868c.newBuilderForType(this));
            this.f3867b = btype;
            btype.mergeFrom(this.f3868c);
            this.f3867b.markClean();
        }
        return this.f3867b;
    }

    public MType e() {
        if (this.f3868c == null) {
            this.f3868c = (MType) ((a) this.f3867b.buildPartial());
        }
        return this.f3868c;
    }

    public f2<MType, BType, IType> f(MType mtype) {
        if (this.f3867b == null) {
            e1 e1Var = this.f3868c;
            if (e1Var == e1Var.getDefaultInstanceForType()) {
                this.f3868c = mtype;
                g();
                return this;
            }
        }
        d().mergeFrom(mtype);
        g();
        return this;
    }

    public final void g() {
        a.b bVar;
        if (this.f3867b != null) {
            this.f3868c = null;
        }
        if (this.f3869d && (bVar = this.f3866a) != null) {
            bVar.a();
            this.f3869d = false;
        }
    }
}
