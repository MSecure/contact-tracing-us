package c.b.a.a.e.c;

import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.o;
import c.b.a.a.g.i;
import com.google.android.gms.nearby.connection.ConnectionOptions;

public final /* synthetic */ class w4 implements o {

    /* renamed from: a  reason: collision with root package name */
    public final u4 f2788a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f2789b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2790c;

    /* renamed from: d  reason: collision with root package name */
    public final k f2791d;

    /* renamed from: e  reason: collision with root package name */
    public final ConnectionOptions f2792e;

    public w4(u4 u4Var, byte[] bArr, String str, k kVar, ConnectionOptions connectionOptions) {
        this.f2788a = u4Var;
        this.f2789b = bArr;
        this.f2790c = str;
        this.f2791d = kVar;
        this.f2792e = connectionOptions;
    }

    @Override // c.b.a.a.c.k.o.o
    public final void a(Object obj, Object obj2) {
        byte[] bArr = this.f2789b;
        String str = this.f2790c;
        k kVar = this.f2791d;
        ConnectionOptions connectionOptions = this.f2792e;
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
            a9Var.j = connectionOptions;
            ((j7) v3Var.getService()).P(a9Var);
            return;
        }
        throw null;
    }
}
