package f.b.a.a.a.s;

import android.content.Context;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.n.a.b;
import e.p.y;
import f.b.a.a.a.b0.f1;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.c0;
import f.b.a.a.a.o.f0;
import f.b.a.a.a.q.i1;
import f.b.a.d.a.a0;
import i.a.a;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class p6 implements b<ShareDiagnosisViewModel> {
    public final a<Context> a;
    public final a<f0> b;
    public final a<i0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<f1> f2378d;

    /* renamed from: e  reason: collision with root package name */
    public final a<i1> f2379e;

    /* renamed from: f  reason: collision with root package name */
    public final a<v0> f2380f;

    /* renamed from: g  reason: collision with root package name */
    public final a<a0> f2381g;

    /* renamed from: h  reason: collision with root package name */
    public final a<f.b.a.a.a.i.f0.a> f2382h;

    /* renamed from: i  reason: collision with root package name */
    public final a<c0> f2383i;

    /* renamed from: j  reason: collision with root package name */
    public final a<SecureRandom> f2384j;

    /* renamed from: k  reason: collision with root package name */
    public final a<f.b.a.a.a.r.b> f2385k;

    /* renamed from: l  reason: collision with root package name */
    public final a<ExecutorService> f2386l;
    public final a<ExecutorService> m;
    public final a<ScheduledExecutorService> n;

    public p6(a<Context> aVar, a<f0> aVar2, a<i0> aVar3, a<f1> aVar4, a<i1> aVar5, a<v0> aVar6, a<a0> aVar7, a<f.b.a.a.a.i.f0.a> aVar8, a<c0> aVar9, a<SecureRandom> aVar10, a<f.b.a.a.a.r.b> aVar11, a<ExecutorService> aVar12, a<ExecutorService> aVar13, a<ScheduledExecutorService> aVar14) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2378d = aVar4;
        this.f2379e = aVar5;
        this.f2380f = aVar6;
        this.f2381g = aVar7;
        this.f2382h = aVar8;
        this.f2383i = aVar9;
        this.f2384j = aVar10;
        this.f2385k = aVar11;
        this.f2386l = aVar12;
        this.m = aVar13;
        this.n = aVar14;
    }

    /* Return type fixed from 'e.p.e0' to match base method */
    @Override // e.n.a.b
    public ShareDiagnosisViewModel a(y yVar) {
        return new ShareDiagnosisViewModel(this.a.get(), yVar, this.b.get(), this.c.get(), this.f2378d.get(), this.f2379e.get(), this.f2380f.get(), this.f2381g.get(), this.f2382h.get(), this.f2383i.get(), this.f2384j.get(), this.f2385k.get(), this.f2386l.get(), this.m.get(), this.n.get());
    }
}
