package c.b.a.a.g.e;

import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.o;
import c.b.a.a.j.j;

public final /* synthetic */ class e5 implements o {

    /* renamed from: a  reason: collision with root package name */
    public final u4 f3546a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3547b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3548c;

    /* renamed from: d  reason: collision with root package name */
    public final k f3549d;

    public e5(u4 u4Var, byte[] bArr, String str, k kVar) {
        this.f3546a = u4Var;
        this.f3547b = bArr;
        this.f3548c = str;
        this.f3549d = kVar;
    }

    @Override // c.b.a.a.d.k.o.o
    public final void a(Object obj, Object obj2) {
        byte[] bArr = this.f3547b;
        String str = this.f3548c;
        k kVar = this.f3549d;
        v3 v3Var = (v3) obj;
        a6 a6Var = new a6((j) obj2);
        if (v3Var != null) {
            x3 x3Var = new x3(kVar);
            v3Var.f3773e.add(x3Var);
            a9 a9Var = new a9(null);
            a9Var.f3503b = new p4(a6Var);
            a9Var.i = bArr;
            a9Var.f3507f = str;
            a9Var.h = x3Var;
            ((j7) v3Var.getService()).M(a9Var);
            return;
        }
        throw null;
    }
}
