package c.b.a.a.c.k.o;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import b.b.k.i;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.o.g;
import c.b.a.a.f.b.e;
import c.b.a.a.f.c;
import c.b.a.a.f.f;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class l0 extends e implements e.a, e.b {
    public static a.AbstractC0055a<? extends f, c.b.a.a.f.a> h = c.f2847c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2381a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f2382b;

    /* renamed from: c  reason: collision with root package name */
    public final a.AbstractC0055a<? extends f, c.b.a.a.f.a> f2383c;

    /* renamed from: d  reason: collision with root package name */
    public Set<Scope> f2384d;

    /* renamed from: e  reason: collision with root package name */
    public c.b.a.a.c.l.c f2385e;
    public f f;
    public o0 g;

    public l0(Context context, Handler handler, c.b.a.a.c.l.c cVar) {
        a.AbstractC0055a<? extends f, c.b.a.a.f.a> aVar = h;
        this.f2381a = context;
        this.f2382b = handler;
        i.j.t(cVar, "ClientSettings must not be null");
        this.f2385e = cVar;
        this.f2384d = cVar.f2432b;
        this.f2383c = aVar;
    }

    @Override // c.b.a.a.c.k.o.l
    public final void c(c.b.a.a.c.a aVar) {
        ((g.c) this.g).b(aVar);
    }

    @Override // c.b.a.a.c.k.o.f
    public final void d(int i) {
        this.f.disconnect();
    }

    @Override // c.b.a.a.c.k.o.f
    public final void e(Bundle bundle) {
        this.f.b(this);
    }
}
