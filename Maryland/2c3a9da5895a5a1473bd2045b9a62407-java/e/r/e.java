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
    public Bundle f1742d;

    /* renamed from: e  reason: collision with root package name */
    public final k f1743e;

    /* renamed from: f  reason: collision with root package name */
    public final b f1744f;

    /* renamed from: g  reason: collision with root package name */
    public final UUID f1745g;

    /* renamed from: h  reason: collision with root package name */
    public g.b f1746h;

    /* renamed from: i  reason: collision with root package name */
    public g.b f1747i;

    /* renamed from: j  reason: collision with root package name */
    public g f1748j;

    /* renamed from: k  reason: collision with root package name */
    public b0.b f1749k;

    public e(Context context, j jVar, Bundle bundle, j jVar2, g gVar) {
        this(context, jVar, bundle, jVar2, gVar, UUID.randomUUID(), null);
    }

    public e(Context context, j jVar, Bundle bundle, j jVar2, g gVar, UUID uuid, Bundle bundle2) {
        this.f1743e = new k(this);
        b bVar = new b(this);
        this.f1744f = bVar;
        this.f1746h = g.b.CREATED;
        this.f1747i = g.b.RESUMED;
        this.b = context;
        this.f1745g = uuid;
        this.c = jVar;
        this.f1742d = bundle;
        this.f1748j = gVar;
        bVar.a(bundle2);
        if (jVar2 != null) {
            this.f1746h = ((k) jVar2.a()).b;
        }
    }

    @Override // e.p.j
    public g a() {
        return this.f1743e;
    }

    public void b() {
        g.b bVar;
        k kVar;
        if (this.f1746h.ordinal() < this.f1747i.ordinal()) {
            kVar = this.f1743e;
            bVar = this.f1746h;
        } else {
            kVar = this.f1743e;
            bVar = this.f1747i;
        }
        kVar.i(bVar);
    }

    @Override // e.u.c
    public a d() {
        return this.f1744f.b;
    }

    @Override // e.p.d0
    public c0 i() {
        g gVar = this.f1748j;
        if (gVar != null) {
            UUID uuid = this.f1745g;
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
    public b0.b l() {
        if (this.f1749k == null) {
            this.f1749k = new v((Application) this.b.getApplicationContext(), this, this.f1742d);
        }
        return this.f1749k;
    }
}
