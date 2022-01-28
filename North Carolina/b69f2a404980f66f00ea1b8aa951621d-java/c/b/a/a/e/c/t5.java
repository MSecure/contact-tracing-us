package c.b.a.a.e.c;

import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.m;
import c.b.a.a.g.i;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

public final class t5 extends m<v3, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2734a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2735b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f2736c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AdvertisingOptions f2737d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u4 f2738e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t5(u4 u4Var, k kVar, String str, String str2, k kVar2, AdvertisingOptions advertisingOptions) {
        super(kVar);
        this.f2738e = u4Var;
        this.f2734a = str;
        this.f2735b = str2;
        this.f2736c = kVar2;
        this.f2737d = advertisingOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.c.k.a$b, c.b.a.a.g.i] */
    @Override // c.b.a.a.c.k.o.m
    public final /* synthetic */ void registerListener(v3 v3Var, i iVar) {
        v3Var.j(new a6(iVar), this.f2734a, this.f2735b, this.f2736c, this.f2737d);
    }
}
