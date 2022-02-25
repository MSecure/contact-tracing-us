package e.r;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import e.p.b0;
import e.p.c0;
import e.p.d0;
import e.p.f;
import e.p.g;
import e.p.j;
import e.p.k;
import e.p.v;
import e.u.a;
import e.u.b;
import e.u.c;
import java.util.UUID;

public final class e implements j, d0, f, c {
    public final Context b;
    public final j c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f1727d;

    /* renamed from: e  reason: collision with root package name */
    public final k f1728e;

    /* renamed from: f  reason: collision with root package name */
    public final b f1729f;

    /* renamed from: g  reason: collision with root package name */
    public final UUID f1730g;

    /* renamed from: h  reason: collision with root package name */
    public g.b f1731h;

    /* renamed from: i  reason: collision with root package name */
    public g.b f1732i;

    /* renamed from: j  reason: collision with root package name */
    public g f1733j;

    /* renamed from: k  reason: collision with root package name */
    public b0.b f1734k;

    public e(Context context, j jVar, Bundle bundle, j jVar2, g gVar) {
        this(context, jVar, bundle, jVar2, gVar, UUID.randomUUID(), null);
    }

    public e(Context context, j jVar, Bundle bundle, j jVar2, g gVar, UUID uuid, Bundle bundle2) {
        this.f1728e = new k(this);
        b bVar = new b(this);
        this.f1729f = bVar;
        this.f1731h = g.b.CREATED;
        this.f1732i = g.b.RESUMED;
        this.b = context;
        this.f1730g = uuid;
        this.c = jVar;
        this.f1727d = bundle;
        this.f1733j = gVar;
        bVar.a(bundle2);
        if (jVar2 != null) {
            this.f1731h = ((k) jVar2.a()).b;
        }
    }

    @Override // e.p.j
    public g a() {
        return this.f1728e;
    }

    @Override // e.u.c
    public a c() {
        return this.f1729f.b;
    }

    public void d() {
        g.b bVar;
        k kVar;
        if (this.f1731h.ordinal() < this.f1732i.ordinal()) {
            kVar = this.f1728e;
            bVar = this.f1731h;
        } else {
            kVar = this.f1728e;
            bVar = this.f1732i;
        }
        kVar.i(bVar);
    }

    @Override // e.p.d0
    public c0 h() {
        g gVar = this.f1733j;
        if (gVar != null) {
            UUID uuid = this.f1730g;
            c0 c0Var = gVar.c.get(uuid);
            if (c0Var != null) {
                return c0Var;
            }
            c0 c0Var2 = new c0();
            gVar.c.put(uuid, c0Var2);
            return c0Var2;
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    @Override // e.p.f
    public b0.b k() {
        if (this.f1734k == null) {
            this.f1734k = new v((Application) this.b.getApplicationContext(), this, this.f1727d);
        }
        return this.f1734k;
    }
}
