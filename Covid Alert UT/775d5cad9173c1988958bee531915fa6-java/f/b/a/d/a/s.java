package f.b.a.d.a;

import android.net.Uri;
import e.b.a.m;
import f.a.b.o;
import f.a.b.p;
import f.a.b.w.b;
import f.a.b.w.h;
import f.b.a.d.a.d0;
import f.b.a.d.a.j0.c;
import f.b.a.d.a.j0.e;
import f.b.b.a.l;
import f.b.b.f.a.a;
import f.b.b.f.a.u;
import f.b.b.f.a.w;
import l.b.a.d;
import org.json.JSONObject;

public class s implements f0 {

    /* renamed from: f  reason: collision with root package name */
    public static final d f2825f = d.n(10);

    /* renamed from: g  reason: collision with root package name */
    public static final h0 f2826g = h0.f().a();
    public f.b.a.d.a.j0.d a;
    public final Uri b;
    public final w c = t.f2829d;

    /* renamed from: d  reason: collision with root package name */
    public final l<b0> f2827d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f2828e;

    public static class a extends e {
        public a(Uri uri, p.b<JSONObject> bVar, p.a aVar) {
            super(0, uri.toString(), null, bVar, aVar);
            this.m = new f.a.b.e((int) s.f2825f.t(), 3, 1.0f);
        }
    }

    public s(Uri uri, l<b0> lVar, d0.a aVar) {
        this.b = uri;
        this.f2827d = lVar;
        this.f2828e = aVar.a("PAPrioRemoteConfig");
        o oVar = new o(new h(), new b(new f.a.b.w.e()));
        oVar.b();
        this.a = new c(oVar);
    }

    @Override // f.b.a.d.a.f0
    public u<h0> a() {
        f.b.b.f.a.l y = f.b.b.f.a.l.x(m.e.l0(new c(this))).y(new a(this), this.c);
        e eVar = new e(this);
        w wVar = this.c;
        a.b bVar = new a.b(y, Exception.class, eVar);
        y.a(bVar, f.b.a.c.b.o.b.j1(wVar, bVar));
        return bVar;
    }
}
