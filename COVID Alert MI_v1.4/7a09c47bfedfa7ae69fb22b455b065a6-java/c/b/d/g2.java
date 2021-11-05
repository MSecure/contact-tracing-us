package c.b.d;

import c.b.d.a;
import c.b.d.a.AbstractC0106a;
import c.b.d.k1;

public class g2<MType extends a, BType extends a.AbstractC0106a, IType extends k1> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public a.b f5288a;

    /* renamed from: b  reason: collision with root package name */
    public BType f5289b;

    /* renamed from: c  reason: collision with root package name */
    public MType f5290c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5291d;

    public g2(MType mtype, a.b bVar, boolean z) {
        n0.a(mtype);
        this.f5290c = mtype;
        this.f5288a = bVar;
        this.f5291d = z;
    }

    @Override // c.b.d.a.b
    public void a() {
        g();
    }

    public MType b() {
        this.f5291d = true;
        return e();
    }

    public g2<MType, BType, IType> c() {
        k1 k1Var = this.f5290c;
        if (k1Var == null) {
            k1Var = this.f5289b;
        }
        this.f5290c = (MType) ((a) k1Var.getDefaultInstanceForType());
        BType btype = this.f5289b;
        if (btype != null) {
            btype.dispose();
            this.f5289b = null;
        }
        g();
        return this;
    }

    public BType d() {
        if (this.f5289b == null) {
            BType btype = (BType) ((a.AbstractC0106a) this.f5290c.newBuilderForType(this));
            this.f5289b = btype;
            btype.mergeFrom(this.f5290c);
            this.f5289b.markClean();
        }
        return this.f5289b;
    }

    public MType e() {
        if (this.f5290c == null) {
            this.f5290c = (MType) ((a) this.f5289b.buildPartial());
        }
        return this.f5290c;
    }

    public g2<MType, BType, IType> f(MType mtype) {
        if (this.f5289b == null) {
            f1 f1Var = this.f5290c;
            if (f1Var == f1Var.getDefaultInstanceForType()) {
                this.f5290c = mtype;
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
        if (this.f5289b != null) {
            this.f5290c = null;
        }
        if (this.f5291d && (bVar = this.f5288a) != null) {
            bVar.a();
            this.f5291d = false;
        }
    }
}
