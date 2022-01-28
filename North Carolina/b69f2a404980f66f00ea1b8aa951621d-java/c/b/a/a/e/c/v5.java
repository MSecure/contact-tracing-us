package c.b.a.a.e.c;

import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.m;
import c.b.a.a.g.i;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

public final class v5 extends m<v3, EndpointDiscoveryCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2775a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f2776b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DiscoveryOptions f2777c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u4 f2778d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v5(u4 u4Var, k kVar, String str, k kVar2, DiscoveryOptions discoveryOptions) {
        super(kVar);
        this.f2778d = u4Var;
        this.f2775a = str;
        this.f2776b = kVar2;
        this.f2777c = discoveryOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.c.k.a$b, c.b.a.a.g.i] */
    @Override // c.b.a.a.c.k.o.m
    public final /* synthetic */ void registerListener(v3 v3Var, i iVar) {
        v3Var.h(new a6(iVar), this.f2775a, this.f2776b, this.f2777c);
    }
}
