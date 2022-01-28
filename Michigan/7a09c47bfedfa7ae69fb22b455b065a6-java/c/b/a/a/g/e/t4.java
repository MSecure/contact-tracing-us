package c.b.a.a.g.e;

import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.o;
import c.b.a.a.j.j;
import com.google.android.gms.nearby.connection.ConnectionOptions;

public final /* synthetic */ class t4 implements o {

    /* renamed from: a  reason: collision with root package name */
    public final u4 f3725a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3726b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3727c;

    /* renamed from: d  reason: collision with root package name */
    public final k f3728d;

    /* renamed from: e  reason: collision with root package name */
    public final ConnectionOptions f3729e;

    public t4(u4 u4Var, String str, String str2, k kVar, ConnectionOptions connectionOptions) {
        this.f3725a = u4Var;
        this.f3726b = str;
        this.f3727c = str2;
        this.f3728d = kVar;
        this.f3729e = connectionOptions;
    }

    @Override // c.b.a.a.d.k.o.o
    public final void a(Object obj, Object obj2) {
        String str = this.f3726b;
        String str2 = this.f3727c;
        k kVar = this.f3728d;
        ConnectionOptions connectionOptions = this.f3729e;
        v3 v3Var = (v3) obj;
        a6 a6Var = new a6((j) obj2);
        if (v3Var != null) {
            x3 x3Var = new x3(kVar);
            v3Var.f3773e.add(x3Var);
            a9 a9Var = new a9(null);
            a9Var.f3503b = new p4(a6Var);
            a9Var.f3506e = str;
            a9Var.f3507f = str2;
            a9Var.h = x3Var;
            a9Var.j = connectionOptions;
            ((j7) v3Var.getService()).M(a9Var);
            return;
        }
        throw null;
    }
}
