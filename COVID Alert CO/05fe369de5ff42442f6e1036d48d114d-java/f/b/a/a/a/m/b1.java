package f.b.a.a.a.m;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.n.a.b;
import e.p.y;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.p.r;
import f.b.a.a.a.q.i1;
import f.b.a.a.a.q.m1;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class b1 implements b<ExposureNotificationViewModel> {
    public final a<v0> a;
    public final a<i1> b;
    public final a<i0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<r> f2251d;

    /* renamed from: e  reason: collision with root package name */
    public final a<m1> f2252e;

    /* renamed from: f  reason: collision with root package name */
    public final a<f.b.a.a.a.i.f0.a> f2253f;

    /* renamed from: g  reason: collision with root package name */
    public final a<ExecutorService> f2254g;

    public b1(a<v0> aVar, a<i1> aVar2, a<i0> aVar3, a<r> aVar4, a<m1> aVar5, a<f.b.a.a.a.i.f0.a> aVar6, a<ExecutorService> aVar7) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2251d = aVar4;
        this.f2252e = aVar5;
        this.f2253f = aVar6;
        this.f2254g = aVar7;
    }

    /* Return type fixed from 'e.p.e0' to match base method */
    @Override // e.n.a.b
    public ExposureNotificationViewModel a(y yVar) {
        return new ExposureNotificationViewModel(this.a.get(), this.b.get(), this.c.get(), this.f2251d.get(), this.f2252e.get(), this.f2253f.get(), this.f2254g.get());
    }
}
