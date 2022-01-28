package e.r;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import e.p.f0;
import e.p.g;
import e.p.g0;
import e.p.h;
import e.p.h0;
import e.p.l;
import e.p.m;
import e.p.z;
import e.u.a;
import e.u.b;
import e.u.c;
import java.util.UUID;

public final class e implements l, h0, g, c {
    public final Context b;
    public final j c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f1558d;

    /* renamed from: e  reason: collision with root package name */
    public final m f1559e;

    /* renamed from: f  reason: collision with root package name */
    public final b f1560f;

    /* renamed from: g  reason: collision with root package name */
    public final UUID f1561g;

    /* renamed from: h  reason: collision with root package name */
    public h.b f1562h;

    /* renamed from: i  reason: collision with root package name */
    public h.b f1563i;

    /* renamed from: j  reason: collision with root package name */
    public g f1564j;

    /* renamed from: k  reason: collision with root package name */
    public f0.b f1565k;

    public e(Context context, j jVar, Bundle bundle, l lVar, g gVar) {
        this(context, jVar, bundle, lVar, gVar, UUID.randomUUID(), null);
    }

    public e(Context context, j jVar, Bundle bundle, l lVar, g gVar, UUID uuid, Bundle bundle2) {
        this.f1559e = new m(this);
        b bVar = new b(this);
        this.f1560f = bVar;
        this.f1562h = h.b.CREATED;
        this.f1563i = h.b.RESUMED;
        this.b = context;
        this.f1561g = uuid;
        this.c = jVar;
        this.f1558d = bundle;
        this.f1564j = gVar;
        bVar.a(bundle2);
        if (lVar != null) {
            this.f1562h = ((m) lVar.a()).b;
        }
    }

    @Override // e.p.l
    public h a() {
        return this.f1559e;
    }

    public void b() {
        h.b bVar;
        m mVar;
        if (this.f1562h.ordinal() < this.f1563i.ordinal()) {
            mVar = this.f1559e;
            bVar = this.f1562h;
        } else {
            mVar = this.f1559e;
            bVar = this.f1563i;
        }
        mVar.i(bVar);
    }

    @Override // e.u.c
    public a d() {
        return this.f1560f.b;
    }

    @Override // e.p.h0
    public g0 i() {
        g gVar = this.f1564j;
        if (gVar != null) {
            UUID uuid = this.f1561g;
            g0 g0Var = gVar.c.get(uuid);
            if (g0Var != null) {
                return g0Var;
            }
            g0 g0Var2 = new g0();
            gVar.c.put(uuid, g0Var2);
            return g0Var2;
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    @Override // e.p.g
    public f0.b l() {
        if (this.f1565k == null) {
            this.f1565k = new z((Application) this.b.getApplicationContext(), this, this.f1558d);
        }
        return this.f1565k;
    }
}
