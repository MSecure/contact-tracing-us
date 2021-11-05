package c.b.a.a.g.e;

import c.b.a.a.d.c;
import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.m;
import c.b.a.a.j.j;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

public final class s5 extends m<v3, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f3709a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3710b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f3711c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AdvertisingOptions f3712d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u4 f3713e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s5(u4 u4Var, k kVar, c[] cVarArr, byte[] bArr, String str, k kVar2, AdvertisingOptions advertisingOptions) {
        super(kVar, cVarArr, false);
        this.f3713e = u4Var;
        this.f3709a = bArr;
        this.f3710b = str;
        this.f3711c = kVar2;
        this.f3712d = advertisingOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b, c.b.a.a.j.j] */
    @Override // c.b.a.a.d.k.o.m
    public final void registerListener(v3 v3Var, j jVar) {
        v3 v3Var2 = v3Var;
        a6 a6Var = new a6(jVar);
        byte[] bArr = this.f3709a;
        String str = this.f3710b;
        k kVar = this.f3711c;
        AdvertisingOptions advertisingOptions = this.f3712d;
        if (v3Var2 != null) {
            x3 x3Var = new x3(kVar);
            v3Var2.f3773e.add(x3Var);
            h9 h9Var = new h9(null);
            h9Var.f3594b = new r4(a6Var);
            h9Var.i = bArr;
            h9Var.f3597e = str;
            h9Var.f3599g = advertisingOptions;
            h9Var.h = x3Var;
            ((j7) v3Var2.getService()).E(h9Var);
            return;
        }
        throw null;
    }
}
