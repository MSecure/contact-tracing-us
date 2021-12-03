package f.b.a.a.a.f0.s;

import android.content.Context;
import android.text.TextUtils;
import f.b.a.a.a.f0.l;
import f.b.a.d.a.w;
import f.b.b.a.g;
import gov.ut.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public final /* synthetic */ class b implements g {
    public final /* synthetic */ m a;
    public final /* synthetic */ p b;
    public final /* synthetic */ g c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f2222d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f2223e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ i f2224f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f2225g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f2226h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ j f2227i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ e f2228j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ k f2229k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ h f2230l;
    public final /* synthetic */ n m;

    public /* synthetic */ b(m mVar, p pVar, g gVar, o oVar, d dVar, i iVar, f fVar, Context context, j jVar, e eVar, k kVar, h hVar, n nVar) {
        this.a = mVar;
        this.b = pVar;
        this.c = gVar;
        this.f2222d = oVar;
        this.f2223e = dVar;
        this.f2224f = iVar;
        this.f2225g = fVar;
        this.f2226h = context;
        this.f2227i = jVar;
        this.f2228j = eVar;
        this.f2229k = kVar;
        this.f2230l = hVar;
        this.m = nVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        m mVar = this.a;
        p pVar = this.b;
        g gVar = this.c;
        o oVar = this.f2222d;
        d dVar = this.f2223e;
        i iVar = this.f2224f;
        f fVar = this.f2225g;
        Context context = this.f2226h;
        j jVar = this.f2227i;
        e eVar = this.f2228j;
        k kVar = this.f2229k;
        h hVar = this.f2230l;
        n nVar = this.m;
        l lVar = (l) obj;
        Objects.requireNonNull(mVar);
        double s = lVar.s();
        double r = lVar.r();
        double w = lVar.w();
        double v = lVar.v();
        double h2 = lVar.h();
        double g2 = lVar.g();
        double b2 = lVar.b();
        double a2 = lVar.a();
        double d2 = lVar.d();
        double c2 = lVar.c();
        double l2 = lVar.l();
        double k2 = lVar.k();
        double p = lVar.p();
        double o = lVar.o();
        double f2 = lVar.f();
        double e2 = lVar.e();
        double n = lVar.n();
        double m2 = lVar.m();
        double j2 = lVar.j();
        double i2 = lVar.i();
        double u = lVar.u();
        double t = lVar.t();
        ArrayList arrayList = new ArrayList(Arrays.asList(new w(pVar, r, s), new w(gVar, v, w), new w(oVar, g2, h2), new w(dVar, a2, b2), new w(iVar, k2, l2), new w(fVar, e2, f2)));
        if (!TextUtils.isEmpty(context.getResources().getString(R.string.share_vaccination_detail))) {
            arrayList.add(new w(jVar, m2, n));
        }
        return new l(mVar, arrayList, Arrays.asList(new w(eVar, c2, d2), new w(kVar, o, p), new w(hVar, i2, j2), new w(nVar, u, t)));
    }
}
