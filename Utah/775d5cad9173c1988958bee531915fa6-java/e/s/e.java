package e.s;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import e.q.f0;
import e.q.g;
import e.q.g0;
import e.q.h;
import e.q.h0;
import e.q.l;
import e.q.m;
import e.q.z;
import e.v.a;
import e.v.b;
import e.v.c;
import java.util.UUID;

public final class e implements l, h0, g, c {
    public final Context b;
    public final j c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f1833d;

    /* renamed from: e  reason: collision with root package name */
    public final m f1834e;

    /* renamed from: f  reason: collision with root package name */
    public final b f1835f;

    /* renamed from: g  reason: collision with root package name */
    public final UUID f1836g;

    /* renamed from: h  reason: collision with root package name */
    public h.b f1837h;

    /* renamed from: i  reason: collision with root package name */
    public h.b f1838i;

    /* renamed from: j  reason: collision with root package name */
    public g f1839j;

    /* renamed from: k  reason: collision with root package name */
    public f0.b f1840k;

    public e(Context context, j jVar, Bundle bundle, l lVar, g gVar) {
        this(context, jVar, bundle, lVar, gVar, UUID.randomUUID(), null);
    }

    public e(Context context, j jVar, Bundle bundle, l lVar, g gVar, UUID uuid, Bundle bundle2) {
        this.f1834e = new m(this);
        b bVar = new b(this);
        this.f1835f = bVar;
        this.f1837h = h.b.CREATED;
        this.f1838i = h.b.RESUMED;
        this.b = context;
        this.f1836g = uuid;
        this.c = jVar;
        this.f1833d = bundle;
        this.f1839j = gVar;
        bVar.a(bundle2);
        if (lVar != null) {
            this.f1837h = ((m) lVar.a()).b;
        }
    }

    @Override // e.q.l
    public h a() {
        return this.f1834e;
    }

    public void b() {
        h.b bVar;
        m mVar;
        if (this.f1837h.ordinal() < this.f1838i.ordinal()) {
            mVar = this.f1834e;
            bVar = this.f1837h;
        } else {
            mVar = this.f1834e;
            bVar = this.f1838i;
        }
        mVar.i(bVar);
    }

    @Override // e.v.c
    public a d() {
        return this.f1835f.b;
    }

    @Override // e.q.h0
    public g0 i() {
        g gVar = this.f1839j;
        if (gVar != null) {
            UUID uuid = this.f1836g;
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

    @Override // e.q.g
    public f0.b l() {
        if (this.f1840k == null) {
            this.f1840k = new z((Application) this.b.getApplicationContext(), this, this.f1833d);
        }
        return this.f1840k;
    }
}
