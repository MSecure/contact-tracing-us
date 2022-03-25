package f.b.a.a.a.r;

import android.content.Context;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.n.v;
import f.b.a.a.a.p.f0;
import f.b.a.a.a.y.d0;
import f.b.a.a.a.y.q0;
import i.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class m4 implements b<ShareDiagnosisViewModel> {
    public final a<Context> a;
    public final a<v> b;
    public final a<d0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<f0> f2253d;

    /* renamed from: e  reason: collision with root package name */
    public final a<q0> f2254e;

    /* renamed from: f  reason: collision with root package name */
    public final a<f.b.a.a.a.h.s.a> f2255f;

    /* renamed from: g  reason: collision with root package name */
    public final a<f.b.a.a.a.q.b> f2256g;

    /* renamed from: h  reason: collision with root package name */
    public final a<ExecutorService> f2257h;

    /* renamed from: i  reason: collision with root package name */
    public final a<ExecutorService> f2258i;

    /* renamed from: j  reason: collision with root package name */
    public final a<ScheduledExecutorService> f2259j;

    public m4(a<Context> aVar, a<v> aVar2, a<d0> aVar3, a<f0> aVar4, a<q0> aVar5, a<f.b.a.a.a.h.s.a> aVar6, a<f.b.a.a.a.q.b> aVar7, a<ExecutorService> aVar8, a<ExecutorService> aVar9, a<ScheduledExecutorService> aVar10) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2253d = aVar4;
        this.f2254e = aVar5;
        this.f2255f = aVar6;
        this.f2256g = aVar7;
        this.f2257h = aVar8;
        this.f2258i = aVar9;
        this.f2259j = aVar10;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public ShareDiagnosisViewModel a(u uVar) {
        return new ShareDiagnosisViewModel(this.a.get(), this.b.get(), this.c.get(), this.f2253d.get(), this.f2254e.get(), this.f2255f.get(), this.f2256g.get(), this.f2257h.get(), this.f2258i.get(), this.f2259j.get());
    }
}
