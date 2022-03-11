package com.google.android.apps.exposurenotification;

import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.c0.b;
import e.c0.c;
import e.c0.f;
import e.c0.m;
import e.c0.o;
import e.c0.p;
import e.c0.t;
import e.n.b.a;
import f.b.a.a.a.g;
import f.b.a.a.a.t.v;
import f.b.a.a.a.z.i;
import f.b.a.a.a.z.j;
import f.b.a.a.a.z.k;
import f.b.a.a.a.z.l;
import f.b.b.f.a.q;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import l.b.a.x.h;

public final class ExposureNotificationApplication extends g implements b.AbstractC0023b {
    public a c;

    /* renamed from: d  reason: collision with root package name */
    public l f337d;
    @Keep
    public f.b.c.a firebaseApp;
    @Keep
    public t workManager;

    @Override // e.c0.b.AbstractC0023b
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
        l lVar = this.f337d;
        Objects.requireNonNull(lVar);
        Log.i("WorkScheduler", "Scheduling post-enable periodic WorkManager jobs...");
        t tVar = lVar.a;
        TimeUnit timeUnit = UploadCoverTrafficWorker.f354k;
        Log.i("UploadCoverTrafficWrk", "Scheduling periodic WorkManager job...");
        p.a aVar = new p.a(UploadCoverTrafficWorker.class, 4, UploadCoverTrafficWorker.f354k);
        c.a aVar2 = new c.a();
        m mVar = m.CONNECTED;
        aVar2.a = mVar;
        aVar.c.f1139j = new c(aVar2);
        f fVar = f.KEEP;
        e.c0.x.t.p.c<o.b.c> cVar = ((e.c0.x.c) tVar.c("UploadCoverTrafficWorker", fVar, (p) aVar.a())).f1025d;
        f.b.a.a.a.z.g gVar = new f.b.a.a.a.z.g(lVar);
        cVar.a(new q(cVar, gVar), lVar.b);
        t tVar2 = lVar.a;
        long max = Math.max(ProvideDiagnosisKeysWorker.m.q(), lVar.c.q());
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        p.a aVar3 = new p.a(ProvideDiagnosisKeysWorker.class, max, timeUnit2);
        c.a aVar4 = new c.a();
        aVar4.b = true;
        aVar4.a = mVar;
        aVar3.c.f1139j = new c(aVar4);
        e.c0.a aVar5 = e.c0.a.EXPONENTIAL;
        TimeUnit timeUnit3 = TimeUnit.MILLISECONDS;
        e.c0.x.t.p.c<o.b.c> cVar2 = ((e.c0.x.c) tVar2.c("ProvideDiagnosisKeysWorker", fVar, (p) ((p.a) aVar3.d(aVar5, 30000, timeUnit3)).a())).f1025d;
        f.b.a.a.a.z.h hVar = new f.b.a.a.a.z.h(lVar);
        cVar2.a(new q(cVar2, hVar), lVar.b);
        e.c0.x.t.p.c<o.b.c> cVar3 = ((e.c0.x.c) lVar.a.c("CountryCheckingWorker", fVar, (p) new p.a(CountryCheckingWorker.class, 6, timeUnit2).a())).f1025d;
        i iVar = new i(lVar);
        cVar3.a(new q(cVar3, iVar), lVar.b);
        e.c0.x.t.p.c<o.b.c> cVar4 = ((e.c0.x.c) lVar.a.c("FirelogAnalyticsUploadWorker", fVar, (p) new p.a(FirelogAnalyticsWorker.class, FirelogAnalyticsWorker.f361h.b / 60, TimeUnit.MINUTES).a())).f1025d;
        j jVar = new j(lVar);
        cVar4.a(new q(cVar4, jVar), lVar.b);
        if (v.b()) {
            t tVar3 = lVar.a;
            l.b.a.c cVar5 = SubmitPrivateAnalyticsWorker.f402k;
            cVar5.q();
            p.a aVar6 = new p.a(SubmitPrivateAnalyticsWorker.class, cVar5.q(), timeUnit2);
            c.a aVar7 = new c.a();
            aVar7.b = true;
            aVar7.a = mVar;
            aVar6.c.f1139j = new c(aVar7);
            e.c0.x.t.p.c<o.b.c> cVar6 = ((e.c0.x.c) tVar3.c("SubmitPrivateAnalyticsWorker", fVar, (p) ((p.a) aVar6.d(aVar5, 30000, timeUnit3)).a())).f1025d;
            k kVar = new k(lVar);
            cVar6.a(new q(cVar6, kVar), lVar.b);
            return;
        }
        String.format("Private Analytics not scheduled. isFeatureSupported=%s, isDeviceAttestationAvailable=%s", Boolean.TRUE, Boolean.valueOf(v.b()));
    }
}
