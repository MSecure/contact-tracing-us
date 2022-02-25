package com.google.android.apps.exposurenotification;

import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.b0.b;
import e.b0.c;
import e.b0.f;
import e.b0.m;
import e.b0.o;
import e.b0.p;
import e.b0.t;
import e.n.b.a;
import f.b.a.a.a.g;
import f.b.a.a.a.r.w;
import f.b.a.a.a.x.i;
import f.b.a.a.a.x.j;
import f.b.a.a.a.x.k;
import f.b.b.f.a.q;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import l.b.a.x.h;

public final class ExposureNotificationApplication extends g implements b.AbstractC0018b {
    public a c;

    /* renamed from: d  reason: collision with root package name */
    public k f329d;
    @Keep
    public f.b.c.a firebaseApp;
    @Keep
    public t workManager;

    @Override // e.b0.b.AbstractC0018b
    public b a() {
        b.a aVar = new b.a();
        aVar.a = this.c;
        return new b(aVar);
    }

    @Override // f.b.a.a.a.g
    public void onCreate() {
        super.onCreate();
        if (!f.c.a.a.a.getAndSet(true)) {
            f.c.a.b bVar = new f.c.a.b(this, "org/threeten/bp/TZDB.dat");
            if (h.a.get()) {
                throw new IllegalStateException("Already initialized");
            } else if (!h.b.compareAndSet(null, bVar)) {
                throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
            }
        }
        k kVar = this.f329d;
        Objects.requireNonNull(kVar);
        Log.i("WorkScheduler", "Scheduling post-enable periodic WorkManager jobs...");
        t tVar = kVar.a;
        TimeUnit timeUnit = UploadCoverTrafficWorker.f345j;
        Log.i("UploadCoverTrafficWrk", "Scheduling periodic WorkManager job...");
        p.a aVar = new p.a(UploadCoverTrafficWorker.class, 4, UploadCoverTrafficWorker.f345j);
        c.a aVar2 = new c.a();
        m mVar = m.CONNECTED;
        aVar2.a = mVar;
        aVar.c.f1119j = new c(aVar2);
        f fVar = f.KEEP;
        e.b0.x.t.p.c<o.b.c> cVar = ((e.b0.x.c) tVar.c("UploadCoverTrafficWorker", fVar, (p) aVar.a())).f1005d;
        f.b.a.a.a.x.f fVar2 = new f.b.a.a.a.x.f(kVar);
        cVar.a(new q(cVar, fVar2), kVar.b);
        t tVar2 = kVar.a;
        long max = Math.max(ProvideDiagnosisKeysWorker.m.o(), kVar.c.o());
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        p.a aVar3 = new p.a(ProvideDiagnosisKeysWorker.class, max, timeUnit2);
        c.a aVar4 = new c.a();
        aVar4.b = true;
        aVar4.a = mVar;
        aVar3.c.f1119j = new c(aVar4);
        e.b0.a aVar5 = e.b0.a.EXPONENTIAL;
        TimeUnit timeUnit3 = TimeUnit.MILLISECONDS;
        e.b0.x.t.p.c<o.b.c> cVar2 = ((e.b0.x.c) tVar2.c("ProvideDiagnosisKeysWorker", fVar, (p) ((p.a) aVar3.d(aVar5, 30000, timeUnit3)).a())).f1005d;
        f.b.a.a.a.x.g gVar = new f.b.a.a.a.x.g(kVar);
        cVar2.a(new q(cVar2, gVar), kVar.b);
        e.b0.x.t.p.c<o.b.c> cVar3 = ((e.b0.x.c) kVar.a.c("CountryCheckingWorker", fVar, (p) new p.a(CountryCheckingWorker.class, 6, timeUnit2).a())).f1005d;
        f.b.a.a.a.x.h hVar = new f.b.a.a.a.x.h(kVar);
        cVar3.a(new q(cVar3, hVar), kVar.b);
        e.b0.x.t.p.c<o.b.c> cVar4 = ((e.b0.x.c) kVar.a.c("FirelogAnalyticsUploadWorker", fVar, (p) new p.a(FirelogAnalyticsWorker.class, FirelogAnalyticsWorker.f351h.b / 60, TimeUnit.MINUTES).a())).f1005d;
        i iVar = new i(kVar);
        cVar4.a(new q(cVar4, iVar), kVar.b);
        if (w.b()) {
            t tVar3 = kVar.a;
            l.b.a.c cVar5 = SubmitPrivateAnalyticsWorker.f388i;
            cVar5.o();
            p.a aVar6 = new p.a(SubmitPrivateAnalyticsWorker.class, cVar5.o(), timeUnit2);
            c.a aVar7 = new c.a();
            aVar7.b = true;
            aVar7.a = mVar;
            aVar6.c.f1119j = new c(aVar7);
            e.b0.x.t.p.c<o.b.c> cVar6 = ((e.b0.x.c) tVar3.c("SubmitPrivateAnalyticsWorker", fVar, (p) ((p.a) aVar6.d(aVar5, 30000, timeUnit3)).a())).f1005d;
            j jVar = new j(kVar);
            cVar6.a(new q(cVar6, jVar), kVar.b);
            return;
        }
        String.format("Private Analytics not scheduled. isFeatureSupported=%s, isDeviceAttestationAvailable=%s", Boolean.TRUE, Boolean.valueOf(w.b()));
    }
}
