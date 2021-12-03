package com.google.android.apps.exposurenotification;

import androidx.annotation.Keep;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import com.google.android.apps.exposurenotification.logging.ApplicationObserver;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.n.b.a;
import e.p.v;
import e.z.b;
import e.z.c;
import e.z.f;
import e.z.m;
import e.z.o;
import e.z.p;
import e.z.t;
import f.b.a.a.a.d0.g;
import f.b.a.a.a.d0.i;
import f.b.a.a.a.d0.j;
import f.b.a.a.a.d0.k;
import f.b.a.a.a.d0.l;
import f.b.a.a.a.h;
import f.b.a.d.a.r;
import f.b.b.f.a.q;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import l.b.a.d;

public final class ExposureNotificationApplication extends h implements b.AbstractC0062b {
    public a c;

    /* renamed from: d  reason: collision with root package name */
    public l f325d;

    /* renamed from: e  reason: collision with root package name */
    public ApplicationObserver f326e;

    /* renamed from: f  reason: collision with root package name */
    public f.b.b.a.l<f.b.a.a.a.a0.a> f327f;
    @Keep
    public f.b.c.a firebaseApp;

    /* renamed from: g  reason: collision with root package name */
    public ExecutorService f328g;
    @Keep
    public t workManager;

    @Override // e.z.b.AbstractC0062b
    public b a() {
        b.a aVar = new b.a();
        aVar.a = this.c;
        return new b(aVar);
    }

    @Override // f.b.a.a.a.h
    public void onCreate() {
        super.onCreate();
        if (this.f327f.b()) {
            this.f328g.execute(new f.b.a.a.a.a(this));
        }
        if (!f.c.a.a.a.getAndSet(true)) {
            f.c.a.b bVar = new f.c.a.b(this, "org/threeten/bp/TZDB.dat");
            if (l.b.a.y.h.a.get()) {
                throw new IllegalStateException("Already initialized");
            } else if (!l.b.a.y.h.b.compareAndSet(null, bVar)) {
                throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
            }
        }
        l lVar = this.f325d;
        Objects.requireNonNull(lVar);
        f.b.a.a.a.i.e0.a aVar = l.f2135f;
        aVar.f("Scheduling post-enable periodic WorkManager jobs...");
        t tVar = lVar.a;
        UploadCoverTrafficWorker.f353l.f("Scheduling periodic WorkManager job...");
        p.a aVar2 = new p.a(UploadCoverTrafficWorker.class, 4, UploadCoverTrafficWorker.m);
        c.a aVar3 = new c.a();
        m mVar = m.CONNECTED;
        aVar3.a = mVar;
        aVar2.c.f1994j = new c(aVar3);
        f fVar = f.KEEP;
        e.z.x.t.p.c<o.b.c> cVar = ((e.z.x.c) tVar.d("UploadCoverTrafficWorker", fVar, (p) aVar2.a())).f1880d;
        g gVar = new g(lVar);
        cVar.a(new q(cVar, gVar), lVar.b);
        t tVar2 = lVar.a;
        long max = Math.max(ProvideDiagnosisKeysWorker.m.s(), lVar.c.s());
        TimeUnit timeUnit = TimeUnit.HOURS;
        p.a aVar4 = new p.a(ProvideDiagnosisKeysWorker.class, max, timeUnit);
        c.a aVar5 = new c.a();
        aVar5.b = true;
        aVar5.a = mVar;
        aVar4.c.f1994j = new c(aVar5);
        e.z.a aVar6 = e.z.a.EXPONENTIAL;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        e.z.x.t.p.c<o.b.c> cVar2 = ((e.z.x.c) tVar2.d("ProvideDiagnosisKeysWorker", fVar, (p) ((p.a) aVar4.d(aVar6, 30000, timeUnit2)).a())).f1880d;
        f.b.a.a.a.d0.h hVar = new f.b.a.a.a.d0.h(lVar);
        cVar2.a(new q(cVar2, hVar), lVar.b);
        t tVar3 = lVar.a;
        CountryCheckingWorker.f435i.a("Scheduling country code checker");
        e.z.x.t.p.c<o.b.c> cVar3 = ((e.z.x.c) tVar3.d("CountryCheckingWorker", fVar, (p) new p.a(CountryCheckingWorker.class, 6, timeUnit).a())).f1880d;
        i iVar = new i(lVar);
        cVar3.a(new q(cVar3, iVar), lVar.b);
        e.z.x.t.p.c<o.b.c> cVar4 = ((e.z.x.c) lVar.a.d("FirelogAnalyticsUploadWorker", fVar, (p) new p.a(FirelogAnalyticsWorker.class, FirelogAnalyticsWorker.f361h.b / 60, TimeUnit.MINUTES).a())).f1880d;
        j jVar = new j(lVar);
        cVar4.a(new q(cVar4, jVar), lVar.b);
        if (!lVar.f2136d.a() || !r.c()) {
            aVar.a(String.format("Private Analytics not scheduled. isFeatureSupported=%s, isDeviceAttestationAvailable=%s", Boolean.valueOf(lVar.f2136d.a()), Boolean.valueOf(r.c())));
        } else {
            t tVar4 = lVar.a;
            f.b.a.a.a.i.e0.a aVar7 = SubmitPrivateAnalyticsWorker.f423l;
            StringBuilder i2 = f.a.a.a.a.i("Scheduling periodic work request. repeatInterval=");
            d dVar = SubmitPrivateAnalyticsWorker.m;
            i2.append(dVar.s());
            aVar7.a(i2.toString());
            p.a aVar8 = new p.a(SubmitPrivateAnalyticsWorker.class, dVar.s(), timeUnit);
            c.a aVar9 = new c.a();
            aVar9.b = true;
            aVar9.a = mVar;
            aVar8.c.f1994j = new c(aVar9);
            e.z.x.t.p.c<o.b.c> cVar5 = ((e.z.x.c) tVar4.d("SubmitPrivateAnalyticsWorker", fVar, (p) ((p.a) aVar8.d(aVar6, 30000, timeUnit2)).a())).f1880d;
            k kVar = new k(lVar);
            cVar5.a(new q(cVar5, kVar), lVar.b);
        }
        ApplicationObserver applicationObserver = this.f326e;
        v vVar = v.f1540j;
        Objects.requireNonNull(applicationObserver);
        vVar.a().a(applicationObserver);
    }
}
