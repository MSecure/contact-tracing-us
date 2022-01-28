package c.b.a.a.e.c;

import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.o;
import c.b.a.a.g.i;

public final /* synthetic */ class e5 implements o {

    /* renamed from: a  reason: collision with root package name */
    public final u4 f2561a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f2562b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2563c;

    /* renamed from: d  reason: collision with root package name */
    public final k f2564d;

    public e5(u4 u4Var, byte[] bArr, String str, k kVar) {
        this.f2561a = u4Var;
        this.f2562b = bArr;
        this.f2563c = str;
        this.f2564d = kVar;
    }

    @Override // c.b.a.a.c.k.o.o
    public final void a(Object obj, Object obj2) {
        byte[] bArr = this.f2562b;
        String str = this.f2563c;
        k kVar = this.f2564d;
        v3 v3Var = (v3) obj;
        a6 a6Var = new a6((i) obj2);
        if (v3Var != null) {
            x3 x3Var = new x3(kVar);
            v3Var.f2771e.add(x3Var);
            a9 a9Var = new a9(null);
            a9Var.f2520b = new p4(a6Var);
            a9Var.i = bArr;
            a9Var.f = str;
            a9Var.h = x3Var;
            ((j7) v3Var.getService()).P(a9Var);
            return;
        }
        throw null;
    }
}
