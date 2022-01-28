package c.b.a.a.g.e;

import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.m;
import c.b.a.a.j.j;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

public final class t5 extends m<v3, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3730a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3731b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f3732c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AdvertisingOptions f3733d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u4 f3734e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t5(u4 u4Var, k kVar, String str, String str2, k kVar2, AdvertisingOptions advertisingOptions) {
        super(kVar);
        this.f3734e = u4Var;
        this.f3730a = str;
        this.f3731b = str2;
        this.f3732c = kVar2;
        this.f3733d = advertisingOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b, c.b.a.a.j.j] */
    @Override // c.b.a.a.d.k.o.m
    public final /* synthetic */ void registerListener(v3 v3Var, j jVar) {
        v3Var.j(new a6(jVar), this.f3730a, this.f3731b, this.f3732c, this.f3733d);
    }
}
