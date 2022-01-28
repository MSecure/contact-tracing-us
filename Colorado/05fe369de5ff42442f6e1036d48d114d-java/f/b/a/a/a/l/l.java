package f.b.a.a.a.l;

import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.n.a.b;
import e.p.y;
import e.z.t;
import f.b.a.a.a.b0.r0;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.w;
import i.a.a;

public final class l implements b<ExposureHomeViewModel> {
    public final a<v0> a;
    public final a<r0> b;
    public final a<w> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<f.b.a.a.a.i.f0.a> f2249d;

    /* renamed from: e  reason: collision with root package name */
    public final a<t> f2250e;

    public l(a<v0> aVar, a<r0> aVar2, a<w> aVar3, a<f.b.a.a.a.i.f0.a> aVar4, a<t> aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2249d = aVar4;
        this.f2250e = aVar5;
    }

    /* Return type fixed from 'e.p.e0' to match base method */
    @Override // e.n.a.b
    public ExposureHomeViewModel a(y yVar) {
        return new ExposureHomeViewModel(this.a.get(), this.b.get(), this.c.get(), this.f2249d.get(), this.f2250e.get());
    }
}
