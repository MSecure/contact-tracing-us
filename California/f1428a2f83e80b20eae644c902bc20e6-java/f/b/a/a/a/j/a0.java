package f.b.a.a.a.j;

import android.location.LocationManager;
import android.os.StatFs;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.m.p;
import f.b.a.a.a.n.f0;
import f.b.a.a.a.n.i0;
import f.b.a.a.a.w.n0;
import i.a.a;

public final class a0 implements b<ExposureNotificationViewModel> {
    public final a<n0> a;
    public final a<f0> b;
    public final a<LocationManager> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<StatFs> f2077d;

    /* renamed from: e  reason: collision with root package name */
    public final a<p> f2078e;

    /* renamed from: f  reason: collision with root package name */
    public final a<i0> f2079f;

    /* renamed from: g  reason: collision with root package name */
    public final a<f.b.a.a.a.h.s.a> f2080g;

    public a0(a<n0> aVar, a<f0> aVar2, a<LocationManager> aVar3, a<StatFs> aVar4, a<p> aVar5, a<i0> aVar6, a<f.b.a.a.a.h.s.a> aVar7) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2077d = aVar4;
        this.f2078e = aVar5;
        this.f2079f = aVar6;
        this.f2080g = aVar7;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public ExposureNotificationViewModel a(u uVar) {
        return new ExposureNotificationViewModel(this.a.get(), this.b.get(), this.c.get(), this.f2077d.get(), this.f2078e.get(), this.f2079f.get(), this.f2080g.get());
    }
}
