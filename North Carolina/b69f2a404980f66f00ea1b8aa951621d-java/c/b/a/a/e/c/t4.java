package c.b.a.a.e.c;

import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.o;
import c.b.a.a.g.i;
import com.google.android.gms.nearby.connection.ConnectionOptions;

public final /* synthetic */ class t4 implements o {

    /* renamed from: a  reason: collision with root package name */
    public final u4 f2729a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2730b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2731c;

    /* renamed from: d  reason: collision with root package name */
    public final k f2732d;

    /* renamed from: e  reason: collision with root package name */
    public final ConnectionOptions f2733e;

    public t4(u4 u4Var, String str, String str2, k kVar, ConnectionOptions connectionOptions) {
        this.f2729a = u4Var;
        this.f2730b = str;
        this.f2731c = str2;
        this.f2732d = kVar;
        this.f2733e = connectionOptions;
    }

    @Override // c.b.a.a.c.k.o.o
    public final void a(Object obj, Object obj2) {
        String str = this.f2730b;
        String str2 = this.f2731c;
        k kVar = this.f2732d;
        ConnectionOptions connectionOptions = this.f2733e;
        v3 v3Var = (v3) obj;
        a6 a6Var = new a6((i) obj2);
        if (v3Var != null) {
            x3 x3Var = new x3(kVar);
            v3Var.f2771e.add(x3Var);
            a9 a9Var = new a9(null);
            a9Var.f2520b = new p4(a6Var);
            a9Var.f2523e = str;
            a9Var.f = str2;
            a9Var.h = x3Var;
            a9Var.j = connectionOptions;
            ((j7) v3Var.getService()).P(a9Var);
            return;
        }
        throw null;
    }
}
