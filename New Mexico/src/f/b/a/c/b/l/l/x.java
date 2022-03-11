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
/* loaded from: classes.dex */
public final class x extends e implements d, f.b.a.c.b.l.e {

    /* renamed from: h */
    public static a.AbstractC0082a<? extends f, f.b.a.c.h.a> f2700h = c.c;
    public final Context a;
    public final Handler b;
    public final a.AbstractC0082a<? extends f, f.b.a.c.h.a> c;

    /* renamed from: d */
    public Set<Scope> f2701d;

    /* renamed from: e */
    public f.b.a.c.b.m.c f2702e;

    /* renamed from: f */
    public f f2703f;

    /* renamed from: g */
    public a0 f2704g;

    public x(Context context, Handler handler, f.b.a.c.b.m.c cVar) {
        a.AbstractC0082a<? extends f, f.b.a.c.h.a> aVar = f2700h;
        this.a = context;
        this.b = handler;
        m.e.r(cVar, "ClientSettings must not be null");
        this.f2702e = cVar;
        this.f2701d = cVar.b;
        this.c = aVar;
    }

    @Override // f.b.a.c.b.l.l.d
    public final void Q(Bundle bundle) {
        this.f2703f.m(this);
    }

    @Override // f.b.a.c.b.l.l.j
    public final void p(f.b.a.c.b.a aVar) {
        ((e.c) this.f2704g).b(aVar);
    }

    @Override // f.b.a.c.b.l.l.d
    public final void z(int i2) {
        this.f2703f.j();
    }
}
