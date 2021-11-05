package c.b.a.a.e.c;

import c.b.a.a.c.c;
import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.m;
import c.b.a.a.g.i;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

public final class s5 extends m<v3, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f2715a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2716b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f2717c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AdvertisingOptions f2718d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u4 f2719e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s5(u4 u4Var, k kVar, c[] cVarArr, byte[] bArr, String str, k kVar2, AdvertisingOptions advertisingOptions) {
        super(kVar, cVarArr, false);
        this.f2719e = u4Var;
        this.f2715a = bArr;
        this.f2716b = str;
        this.f2717c = kVar2;
        this.f2718d = advertisingOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.c.k.a$b, c.b.a.a.g.i] */
    @Override // c.b.a.a.c.k.o.m
    public final void registerListener(v3 v3Var, i iVar) {
        v3 v3Var2 = v3Var;
        a6 a6Var = new a6(iVar);
        byte[] bArr = this.f2715a;
        String str = this.f2716b;
        k kVar = this.f2717c;
        AdvertisingOptions advertisingOptions = this.f2718d;
        if (v3Var2 != null) {
            x3 x3Var = new x3(kVar);
            v3Var2.f2771e.add(x3Var);
            h9 h9Var = new h9(null);
            h9Var.f2608b = new r4(a6Var);
            h9Var.i = bArr;
            h9Var.f2611e = str;
            h9Var.g = advertisingOptions;
            h9Var.h = x3Var;
            ((j7) v3Var2.getService()).H(h9Var);
            return;
        }
        throw null;
    }
}
