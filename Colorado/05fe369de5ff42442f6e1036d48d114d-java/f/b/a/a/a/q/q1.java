package f.b.a.a.a.q;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker;
import e.n.b.b;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.d0.m;
import f.b.a.a.a.i.w;
import f.b.a.a.a.o.f0;
import f.b.b.f.a.x;
import i.a.a;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public final class q1 implements b<SmsVerificationWorker> {
    public final a<i1> a;
    public final a<v0> b;
    public final a<i0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<f0> f2348d;

    /* renamed from: e  reason: collision with root package name */
    public final a<w> f2349e;

    /* renamed from: f  reason: collision with root package name */
    public final a<ExecutorService> f2350f;

    /* renamed from: g  reason: collision with root package name */
    public final a<ExecutorService> f2351g;

    /* renamed from: h  reason: collision with root package name */
    public final a<x> f2352h;

    /* renamed from: i  reason: collision with root package name */
    public final a<SecureRandom> f2353i;

    /* renamed from: j  reason: collision with root package name */
    public final a<m> f2354j;

    /* renamed from: k  reason: collision with root package name */
    public final a<f.b.a.a.a.i.f0.a> f2355k;

    public q1(a<i1> aVar, a<v0> aVar2, a<i0> aVar3, a<f0> aVar4, a<w> aVar5, a<ExecutorService> aVar6, a<ExecutorService> aVar7, a<x> aVar8, a<SecureRandom> aVar9, a<m> aVar10, a<f.b.a.a.a.i.f0.a> aVar11) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2348d = aVar4;
        this.f2349e = aVar5;
        this.f2350f = aVar6;
        this.f2351g = aVar7;
        this.f2352h = aVar8;
        this.f2353i = aVar9;
        this.f2354j = aVar10;
        this.f2355k = aVar11;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public SmsVerificationWorker a(Context context, WorkerParameters workerParameters) {
        return new SmsVerificationWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2348d.get(), this.f2349e.get(), this.f2350f.get(), this.f2351g.get(), this.f2352h.get(), this.f2353i.get(), this.f2354j.get(), this.f2355k.get());
    }
}
