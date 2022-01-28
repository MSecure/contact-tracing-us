package c.b.a.a.g.e;

import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.m;
import c.b.a.a.j.j;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

public final class v5 extends m<v3, EndpointDiscoveryCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3778a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f3779b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DiscoveryOptions f3780c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u4 f3781d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v5(u4 u4Var, k kVar, String str, k kVar2, DiscoveryOptions discoveryOptions) {
        super(kVar);
        this.f3781d = u4Var;
        this.f3778a = str;
        this.f3779b = kVar2;
        this.f3780c = discoveryOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b, c.b.a.a.j.j] */
    @Override // c.b.a.a.d.k.o.m
    public final /* synthetic */ void registerListener(v3 v3Var, j jVar) {
        v3Var.h(new a6(jVar), this.f3778a, this.f3779b, this.f3780c);
    }
}
