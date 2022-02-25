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
    public static a.AbstractC0080a<? extends f, f.b.a.c.h.a> f2428h = c.c;
    public final Context a;
    public final Handler b;
    public final a.AbstractC0080a<? extends f, f.b.a.c.h.a> c;

    /* renamed from: d  reason: collision with root package name */
    public Set<Scope> f2429d;

    /* renamed from: e  reason: collision with root package name */
    public f.b.a.c.b.m.c f2430e;

    /* renamed from: f  reason: collision with root package name */
    public f f2431f;

    /* renamed from: g  reason: collision with root package name */
    public a0 f2432g;

    public x(Context context, Handler handler, f.b.a.c.b.m.c cVar) {
        a.AbstractC0080a<? extends f, f.b.a.c.h.a> aVar = f2428h;
        this.a = context;
        this.b = handler;
        m.h.p(cVar, "ClientSettings must not be null");
        this.f2430e = cVar;
        this.f2429d = cVar.b;
        this.c = aVar;
    }

    @Override // f.b.a.c.b.l.l.d
    public final void C(Bundle bundle) {
        this.f2431f.m(this);
    }

    @Override // f.b.a.c.b.l.l.j
    public final void l(f.b.a.c.b.a aVar) {
        ((e.c) this.f2432g).b(aVar);
    }

    @Override // f.b.a.c.b.l.l.d
    public final void n(int i2) {
        this.f2431f.j();
    }
}
