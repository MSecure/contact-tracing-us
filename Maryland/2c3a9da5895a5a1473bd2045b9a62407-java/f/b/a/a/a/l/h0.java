package f.b.a.a.a.l;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.o.p;
import f.b.a.a.a.p.f0;
import f.b.a.a.a.p.i0;
import f.b.a.a.a.y.q0;
import i.a.a;

public final class h0 implements b<ExposureNotificationViewModel> {
    public final a<q0> a;
    public final a<f0> b;
    public final a<p> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<i0> f2158d;

    /* renamed from: e  reason: collision with root package name */
    public final a<f.b.a.a.a.h.s.a> f2159e;

    public h0(a<q0> aVar, a<f0> aVar2, a<p> aVar3, a<i0> aVar4, a<f.b.a.a.a.h.s.a> aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2158d = aVar4;
        this.f2159e = aVar5;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public ExposureNotificationViewModel a(u uVar) {
        return new ExposureNotificationViewModel(this.a.get(), this.b.get(), this.c.get(), this.f2158d.get(), this.f2159e.get());
    }
}
