package c.b.a.a.g.e;

import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.o;
import c.b.a.a.j.j;
import com.google.android.gms.nearby.connection.ConnectionOptions;

public final /* synthetic */ class w4 implements o {

    /* renamed from: a  reason: collision with root package name */
    public final u4 f3793a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3794b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3795c;

    /* renamed from: d  reason: collision with root package name */
    public final k f3796d;

    /* renamed from: e  reason: collision with root package name */
    public final ConnectionOptions f3797e;

    public w4(u4 u4Var, byte[] bArr, String str, k kVar, ConnectionOptions connectionOptions) {
        this.f3793a = u4Var;
        this.f3794b = bArr;
        this.f3795c = str;
        this.f3796d = kVar;
        this.f3797e = connectionOptions;
    }

    @Override // c.b.a.a.d.k.o.o
    public final void a(Object obj, Object obj2) {
        byte[] bArr = this.f3794b;
        String str = this.f3795c;
        k kVar = this.f3796d;
        ConnectionOptions connectionOptions = this.f3797e;
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
            a9Var.j = connectionOptions;
            ((j7) v3Var.getService()).M(a9Var);
            return;
        }
        throw null;
    }
}
