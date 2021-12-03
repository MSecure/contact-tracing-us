package f.b.a.c.b.l.l;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.d;
import f.b.a.c.b.l.l.e;
import f.b.a.c.h.b.e;
import f.b.a.c.h.c;
import f.b.a.c.h.f;
import java.util.Set;

public final class x extends e implements d, f.b.a.c.b.l.e {

    /* renamed from: h  reason: collision with root package name */
    public static a.AbstractC0082a<? extends f, f.b.a.c.h.a> f2605h = c.c;
    public final Context a;
    public final Handler b;
    public final a.AbstractC0082a<? extends f, f.b.a.c.h.a> c;

    /* renamed from: d  reason: collision with root package name */
    public Set<Scope> f2606d;

    /* renamed from: e  reason: collision with root package name */
    public f.b.a.c.b.m.c f2607e;

    /* renamed from: f  reason: collision with root package name */
    public f f2608f;

    /* renamed from: g  reason: collision with root package name */
    public a0 f2609g;

    public x(Context context, Handler handler, f.b.a.c.b.m.c cVar) {
        a.AbstractC0082a<? extends f, f.b.a.c.h.a> aVar = f2605h;
        this.a = context;
        this.b = handler;
        m.h.p(cVar, "ClientSettings must not be null");
        this.f2607e = cVar;
        this.f2606d = cVar.b;
        this.c = aVar;
    }

    @Override // f.b.a.c.b.l.l.d
    public final void E(Bundle bundle) {
        this.f2608f.m(this);
    }

    @Override // f.b.a.c.b.l.l.j
    public final void k(f.b.a.c.b.a aVar) {
        ((e.c) this.f2609g).b(aVar);
    }

    @Override // f.b.a.c.b.l.l.d
    public final void q(int i2) {
        this.f2608f.j();
    }
}
