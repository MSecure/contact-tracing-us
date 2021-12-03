package com.google.android.apps.exposurenotification;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.Keep;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import com.google.android.apps.exposurenotification.logging.ApplicationObserver;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.b0.c;
import e.b0.d;
import e.b0.g;
import e.b0.o;
import e.b0.q;
import e.b0.s;
import e.b0.w;
import e.q.v;
import f.b.a.a.a.a0.e;
import f.b.a.a.a.a0.f;
import f.b.a.a.a.n0.h;
import f.b.a.a.a.n0.i;
import f.b.a.a.a.n0.j;
import f.b.a.a.a.n0.k;
import f.b.a.a.a.n0.l;
import f.b.a.a.a.r;
import f.b.a.e.k.a;
import f.b.b.f.a.a;
import f.b.b.f.a.p;
import f.b.b.f.a.u;
import f.c.a.b;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class ExposureNotificationApplication extends r implements c.b {
    public e.o.a.a c;

    /* renamed from: d  reason: collision with root package name */
    public l f329d;

    /* renamed from: e  reason: collision with root package name */
    public ApplicationObserver f330e;

    /* renamed from: f  reason: collision with root package name */
    public f.b.b.a.l<f.b.a.a.a.k0.a> f331f;
    @Keep
    public f.b.c.a firebaseApp;

    /* renamed from: g  reason: collision with root package name */
    public ExecutorService f332g;

    /* renamed from: h  reason: collision with root package name */
    public f f333h;
    @Keep
    public w workManager;

    public class a implements p<Object> {
        public a() {
        }

        @Override // f.b.b.f.a.p
        public void a(Throwable th) {
            throw new e.b(th);
        }

        @Override // f.b.b.f.a.p
        public void b(Object obj) {
            l lVar = ExposureNotificationApplication.this.f329d;
            Objects.requireNonNull(lVar);
            f.b.a.a.a.s.d0.a aVar = l.f2332f;
            aVar.f("Scheduling post-enable periodic WorkManager jobs...");
            w wVar = lVar.a;
            UploadCoverTrafficWorker.n.f("Scheduling periodic WorkManager job...");
            s.a aVar2 = new s.a(UploadCoverTrafficWorker.class, 4, UploadCoverTrafficWorker.o);
            d.a aVar3 = new d.a();
            o oVar = o.CONNECTED;
            aVar3.a = oVar;
            aVar2.c.f1118j = new d(aVar3);
            g gVar = g.KEEP;
            e.b0.a0.t.s.c<q.b.c> cVar = ((e.b0.a0.c) wVar.e("UploadCoverTrafficWorker", gVar, (s) aVar2.a())).f1002d;
            f.b.a.a.a.n0.g gVar2 = new f.b.a.a.a.n0.g(lVar);
            cVar.a(new f.b.b.f.a.q(cVar, gVar2), lVar.b);
            w wVar2 = lVar.a;
            long max = Math.max(ProvideDiagnosisKeysWorker.o.s(), lVar.c.s());
            TimeUnit timeUnit = TimeUnit.HOURS;
            s.a aVar4 = new s.a(ProvideDiagnosisKeysWorker.class, max, timeUnit);
            d.a aVar5 = new d.a();
            aVar5.b = true;
            aVar5.a = oVar;
            aVar4.c.f1118j = new d(aVar5);
            e.b0.a aVar6 = e.b0.a.EXPONENTIAL;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            e.b0.a0.t.s.c<q.b.c> cVar2 = ((e.b0.a0.c) wVar2.e("ProvideDiagnosisKeysWorker", gVar, (s) ((s.a) aVar4.d(aVar6, 30000, timeUnit2)).a())).f1002d;
            h hVar = new h(lVar);
            cVar2.a(new f.b.b.f.a.q(cVar2, hVar), lVar.b);
            w wVar3 = lVar.a;
            CountryCheckingWorker.f431k.a("Scheduling country code checker");
            e.b0.a0.t.s.c<q.b.c> cVar3 = ((e.b0.a0.c) wVar3.e("CountryCheckingWorker", gVar, (s) new s.a(CountryCheckingWorker.class, 6, timeUnit).a())).f1002d;
            i iVar = new i(lVar);
            cVar3.a(new f.b.b.f.a.q(cVar3, iVar), lVar.b);
            e.b0.a0.t.s.c<q.b.c> cVar4 = ((e.b0.a0.c) lVar.a.e("FirelogAnalyticsUploadWorker", gVar, (s) new s.a(FirelogAnalyticsWorker.class, FirelogAnalyticsWorker.f364j.b / 60, TimeUnit.MINUTES).a())).f1002d;
            j jVar = new j(lVar);
            cVar4.a(new f.b.b.f.a.q(cVar4, jVar), lVar.b);
            if (!lVar.f2333d.a() || !f.b.a.d.a.r.c()) {
                aVar.a(String.format("Private Analytics not scheduled. isFeatureSupported=%s, isDeviceAttestationAvailable=%s", Boolean.valueOf(lVar.f2333d.a()), Boolean.valueOf(f.b.a.d.a.r.c())));
                return;
            }
            w wVar4 = lVar.a;
            f.b.a.a.a.s.d0.a aVar7 = SubmitPrivateAnalyticsWorker.n;
            StringBuilder h2 = f.a.a.a.a.h("Scheduling periodic work request. repeatInterval=");
            l.b.a.d dVar = SubmitPrivateAnalyticsWorker.o;
            h2.append(dVar.s());
            aVar7.a(h2.toString());
            s.a aVar8 = new s.a(SubmitPrivateAnalyticsWorker.class, dVar.s(), timeUnit);
            d.a aVar9 = new d.a();
            aVar9.b = true;
            aVar9.a = oVar;
            aVar8.c.f1118j = new d(aVar9);
            e.b0.a0.t.s.c<q.b.c> cVar5 = ((e.b0.a0.c) wVar4.e("SubmitPrivateAnalyticsWorker", gVar, (s) ((s.a) aVar8.d(aVar6, 30000, timeUnit2)).a())).f1002d;
            k kVar = new k(lVar);
            cVar5.a(new f.b.b.f.a.q(cVar5, kVar), lVar.b);
        }
    }

    @Override // e.b0.c.b
    public c a() {
        c.a aVar = new c.a();
        aVar.a = this.c;
        return new c(aVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0094, code lost:
        if (r3 != false) goto L_0x0097;
     */
    @Override // f.b.a.a.a.r
    public void onCreate() {
        u<?> uVar;
        boolean z;
        super.onCreate();
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 31) {
            registerActivityLifecycleCallbacks(new a.b(0, f.b.a.e.k.a.b));
        }
        if (this.f331f.b()) {
            this.f332g.execute(new f.b.a.a.a.a(this));
        }
        if (!f.c.a.a.a.getAndSet(true)) {
            b bVar = new b(this, "org/threeten/bp/TZDB.dat");
            if (l.b.a.y.h.a.get()) {
                throw new IllegalStateException("Already initialized");
            } else if (!l.b.a.y.h.b.compareAndSet(null, bVar)) {
                throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
            }
        }
        f fVar = this.f333h;
        Objects.requireNonNull(fVar);
        if (getResources().getBoolean(R.bool.enx_enableV1toENXMigration) && !fVar.a.b.a.getBoolean("ExposureNotificationSharedPreferences.MIGRATION_RUN_OR_NOT_NEEDED", false)) {
            try {
                PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                    z = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            z = false;
        }
        z2 = false;
        if (!z2) {
            fVar.a.b();
            uVar = f.b.b.f.a.s.c;
        } else {
            e eVar = fVar.a;
            f.b.b.f.a.l y = f.b.b.f.a.l.x(f.b.b.f.a.l.x(((e.b0.a0.c) eVar.c.a()).f1002d).z(new f.b.a.a.a.a0.b(eVar, this), eVar.a).z(f.b.a.a.a.a0.a.a, eVar.a)).y(new f.b.a.a.a.a0.d(fVar), fVar.b);
            f.b.a.a.a.a0.c cVar = new f.b.a.a.a.a0.c(fVar);
            ExecutorService executorService = fVar.b;
            a.C0108a aVar = new a.C0108a(y, Exception.class, cVar);
            y.a(aVar, f.b.a.c.b.o.b.j1(executorService, aVar));
            uVar = aVar;
        }
        uVar.a(new f.b.b.f.a.q(uVar, new a()), this.f332g);
        ApplicationObserver applicationObserver = this.f330e;
        v vVar = v.f1815j;
        Objects.requireNonNull(applicationObserver);
        vVar.f1819g.a(applicationObserver);
    }
}
