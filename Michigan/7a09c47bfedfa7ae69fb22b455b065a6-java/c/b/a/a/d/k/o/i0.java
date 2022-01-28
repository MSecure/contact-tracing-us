package c.b.a.a.d.k.o;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.o.g;
import c.b.a.a.i.b.e;
import c.b.a.a.i.c;
import c.b.a.a.i.f;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class i0 extends e implements e.a, e.b {
    public static a.AbstractC0062a<? extends f, c.b.a.a.i.a> h = c.f4099c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3002a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f3003b;

    /* renamed from: c  reason: collision with root package name */
    public final a.AbstractC0062a<? extends f, c.b.a.a.i.a> f3004c;

    /* renamed from: d  reason: collision with root package name */
    public Set<Scope> f3005d;

    /* renamed from: e  reason: collision with root package name */
    public c.b.a.a.d.m.c f3006e;

    /* renamed from: f  reason: collision with root package name */
    public f f3007f;

    /* renamed from: g  reason: collision with root package name */
    public l0 f3008g;

    public i0(Context context, Handler handler, c.b.a.a.d.m.c cVar) {
        a.AbstractC0062a<? extends f, c.b.a.a.i.a> aVar = h;
        this.f3002a = context;
        this.f3003b = handler;
        t.D(cVar, "ClientSettings must not be null");
        this.f3006e = cVar;
        this.f3005d = cVar.f3087b;
        this.f3004c = aVar;
    }

    @Override // c.b.a.a.d.k.o.f
    public final void onConnected(Bundle bundle) {
        this.f3007f.a(this);
    }

    @Override // c.b.a.a.d.k.o.l
    public final void onConnectionFailed(c.b.a.a.d.a aVar) {
        ((g.c) this.f3008g).b(aVar);
    }

    @Override // c.b.a.a.d.k.o.f
    public final void onConnectionSuspended(int i) {
        this.f3007f.disconnect();
    }
}
