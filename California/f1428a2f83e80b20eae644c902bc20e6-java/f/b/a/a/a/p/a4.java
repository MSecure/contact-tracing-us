package f.b.a.a.a.p;

import android.content.Context;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.n.a.b;
import f.b.a.a.a.l.u;
import f.b.a.a.a.n.f0;
import f.b.a.a.a.w.c0;
import i.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class a4 implements b<ShareDiagnosisViewModel> {
    public final a<Context> a;
    public final a<u> b;
    public final a<c0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<f0> f2169d;

    /* renamed from: e  reason: collision with root package name */
    public final a<f.b.a.a.a.o.b> f2170e;

    /* renamed from: f  reason: collision with root package name */
    public final a<ExecutorService> f2171f;

    /* renamed from: g  reason: collision with root package name */
    public final a<ExecutorService> f2172g;

    /* renamed from: h  reason: collision with root package name */
    public final a<ScheduledExecutorService> f2173h;

    public a4(a<Context> aVar, a<u> aVar2, a<c0> aVar3, a<f0> aVar4, a<f.b.a.a.a.o.b> aVar5, a<ExecutorService> aVar6, a<ExecutorService> aVar7, a<ScheduledExecutorService> aVar8) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2169d = aVar4;
        this.f2170e = aVar5;
        this.f2171f = aVar6;
        this.f2172g = aVar7;
        this.f2173h = aVar8;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public ShareDiagnosisViewModel a(e.p.u uVar) {
        return new ShareDiagnosisViewModel(this.a.get(), this.b.get(), this.c.get(), this.f2169d.get(), this.f2170e.get(), this.f2171f.get(), this.f2172g.get(), this.f2173h.get());
    }
}
