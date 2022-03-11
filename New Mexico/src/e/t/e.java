package e.t;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import e.r.f0;
import e.r.g;
import e.r.g0;
import e.r.h;
import e.r.h0;
import e.r.l;
import e.r.m;
import e.r.z;
import e.w.a;
import e.w.b;
import e.w.c;
import java.util.UUID;
/* loaded from: classes.dex */
public final class e implements l, h0, g, c {
    public final Context b;
    public final j c;

    /* renamed from: d */
    public Bundle f1918d;

    /* renamed from: e */
    public final m f1919e;

    /* renamed from: f */
    public final b f1920f;

    /* renamed from: g */
    public final UUID f1921g;

    /* renamed from: h */
    public h.b f1922h;

    /* renamed from: i */
    public h.b f1923i;

    /* renamed from: j */
    public g f1924j;

    /* renamed from: k */
    public f0.b f1925k;

    public e(Context context, j jVar, Bundle bundle, l lVar, g gVar) {
        this(context, jVar, bundle, lVar, gVar, UUID.randomUUID(), null);
    }

    public e(Context context, j jVar, Bundle bundle, l lVar, g gVar, UUID uuid, Bundle bundle2) {
        this.f1919e = new m(this);
        b bVar = new b(this);
        this.f1920f = bVar;
        this.f1922h = h.b.CREATED;
        this.f1923i = h.b.RESUMED;
        this.b = context;
        this.f1921g = uuid;
        this.c = jVar;
        this.f1918d = bundle;
        this.f1924j = gVar;
        bVar.a(bundle2);
        if (lVar != null) {
            this.f1922h = ((m) lVar.a()).b;
        }
    }

    @Override // e.r.l
    public h a() {
        return this.f1919e;
    }

    public void b() {
        h.b bVar;
        m mVar;
        if (this.f1922h.ordinal() < this.f1923i.ordinal()) {
            mVar = this.f1919e;
            bVar = this.f1922h;
        } else {
            mVar = this.f1919e;
            bVar = this.f1923i;
        }
        mVar.i(bVar);
    }

    @Override // e.w.c
    public a d() {
        return this.f1920f.b;
    }

    @Override // e.r.h0
    public g0 i() {
        g gVar = this.f1924j;
        if (gVar != null) {
            UUID uuid = this.f1921g;
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

    @Override // e.r.g
    public f0.b l() {
        if (this.f1925k == null) {
            this.f1925k = new z((Application) this.b.getApplicationContext(), this, this.f1918d);
        }
        return this.f1925k;
    }
}
