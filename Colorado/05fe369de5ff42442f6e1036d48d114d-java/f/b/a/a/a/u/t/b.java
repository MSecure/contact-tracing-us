package f.b.a.a.a.u.t;

import android.content.Context;
import android.text.TextUtils;
import f.b.a.a.a.u.l;
import f.b.a.d.a.w;
import f.b.b.a.g;
import gov.co.cdphe.exposurenotifications.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public final /* synthetic */ class b implements g {
    public final /* synthetic */ m a;
    public final /* synthetic */ p b;
    public final /* synthetic */ g c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f2430d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f2431e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ i f2432f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f2433g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f2434h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ j f2435i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ e f2436j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ k f2437k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ h f2438l;
    public final /* synthetic */ n m;

    public /* synthetic */ b(m mVar, p pVar, g gVar, o oVar, d dVar, i iVar, f fVar, Context context, j jVar, e eVar, k kVar, h hVar, n nVar) {
        this.a = mVar;
        this.b = pVar;
        this.c = gVar;
        this.f2430d = oVar;
        this.f2431e = dVar;
        this.f2432f = iVar;
        this.f2433g = fVar;
        this.f2434h = context;
        this.f2435i = jVar;
        this.f2436j = eVar;
        this.f2437k = kVar;
        this.f2438l = hVar;
        this.m = nVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        m mVar = this.a;
        p pVar = this.b;
        g gVar = this.c;
        o oVar = this.f2430d;
        d dVar = this.f2431e;
        i iVar = this.f2432f;
        f fVar = this.f2433g;
        Context context = this.f2434h;
        j jVar = this.f2435i;
        e eVar = this.f2436j;
        k kVar = this.f2437k;
        h hVar = this.f2438l;
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
