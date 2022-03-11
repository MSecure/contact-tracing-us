package com.google.android.apps.exposurenotification;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.Keep;
import com.google.android.apps.exposurenotification.ExposureNotificationApplication;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import com.google.android.apps.exposurenotification.logging.ApplicationObserver;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.c0.c;
import e.c0.d;
import e.c0.g;
import e.c0.o;
import e.c0.q;
import e.c0.s;
import e.c0.w;
import e.r.v;
import f.b.a.a.a.b0.e;
import f.b.a.a.a.b0.f;
import f.b.a.a.a.p0.m;
import f.b.a.a.a.p0.n;
import f.b.a.a.a.p0.q;
import f.b.a.a.a.r;
import f.b.a.e.k.a;
import f.b.b.a.l;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.p;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import f.c.a.b;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import l.b.a.y.h;
/* loaded from: classes.dex */
public final class ExposureNotificationApplication extends r implements c.b {
    public e.p.a.a c;

    /* renamed from: d */
    public q f329d;

    /* renamed from: e */
    public ApplicationObserver f330e;

    /* renamed from: f */
    public l<f.b.a.a.a.m0.a> f331f;
    @Keep
    public f.b.c.a firebaseApp;

    /* renamed from: g */
    public ExecutorService f332g;

    /* renamed from: h */
    public f f333h;
    @Keep
    public w workManager;

    /* loaded from: classes.dex */
    public class a implements p<Object> {
        public a() {
            ExposureNotificationApplication.this = r1;
        }

        @Override // f.b.b.f.a.p
        public void a(Object obj) {
            q qVar = ExposureNotificationApplication.this.f329d;
            Objects.requireNonNull(qVar);
            f.b.a.a.a.t.p0.a aVar = q.f2373f;
            aVar.f("Scheduling post-enable periodic WorkManager jobs...");
            w wVar = qVar.a;
            UploadCoverTrafficWorker.n.f("Scheduling periodic WorkManager job...");
            s.a aVar2 = new s.a(UploadCoverTrafficWorker.class, 4, UploadCoverTrafficWorker.o);
            d.a aVar3 = new d.a();
            o oVar = o.CONNECTED;
            aVar3.a = oVar;
            aVar2.c.f1197j = new d(aVar3);
            g gVar = g.KEEP;
            e.c0.a0.t.s.c<q.b.c> cVar = ((e.c0.a0.c) wVar.e("UploadCoverTrafficWorker", gVar, aVar2.a())).f1081d;
            cVar.a(new f.b.b.f.a.q(cVar, new f.b.a.a.a.p0.l(qVar)), qVar.b);
            w wVar2 = qVar.a;
            long max = Math.max(ProvideDiagnosisKeysWorker.o.t(), qVar.c.t());
            TimeUnit timeUnit = TimeUnit.HOURS;
            s.a aVar4 = new s.a(ProvideDiagnosisKeysWorker.class, max, timeUnit);
            d.a aVar5 = new d.a();
            aVar5.b = true;
            aVar5.a = oVar;
            aVar4.c.f1197j = new d(aVar5);
            e.c0.a aVar6 = e.c0.a.EXPONENTIAL;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            e.c0.a0.t.s.c<q.b.c> cVar2 = ((e.c0.a0.c) wVar2.e("ProvideDiagnosisKeysWorker", gVar, aVar4.d(aVar6, 30000, timeUnit2).a())).f1081d;
            cVar2.a(new f.b.b.f.a.q(cVar2, new m(qVar)), qVar.b);
            w wVar3 = qVar.a;
            CountryCheckingWorker.f441k.a("Scheduling country code checker");
            e.c0.a0.t.s.c<q.b.c> cVar3 = ((e.c0.a0.c) wVar3.e("CountryCheckingWorker", gVar, new s.a(CountryCheckingWorker.class, 6, timeUnit).a())).f1081d;
            cVar3.a(new f.b.b.f.a.q(cVar3, new n(qVar)), qVar.b);
            e.c0.a0.t.s.c<q.b.c> cVar4 = ((e.c0.a0.c) qVar.a.e("FirelogAnalyticsUploadWorker", gVar, new s.a(FirelogAnalyticsWorker.class, FirelogAnalyticsWorker.f367j.b / 60, TimeUnit.MINUTES).a())).f1081d;
            cVar4.a(new f.b.b.f.a.q(cVar4, new f.b.a.a.a.p0.o(qVar)), qVar.b);
            if (!qVar.f2374d.a() || !f.b.a.d.a.r.c()) {
                aVar.a(String.format("Private Analytics not scheduled. isFeatureSupported=%s, isDeviceAttestationAvailable=%s", Boolean.valueOf(qVar.f2374d.a()), Boolean.valueOf(f.b.a.d.a.r.c())));
                return;
            }
            w wVar4 = qVar.a;
            f.b.a.a.a.t.p0.a aVar7 = SubmitPrivateAnalyticsWorker.n;
            StringBuilder h2 = f.a.a.a.a.h("Scheduling periodic work request. repeatInterval=");
            l.b.a.d dVar = SubmitPrivateAnalyticsWorker.o;
            h2.append(dVar.t());
            aVar7.a(h2.toString());
            s.a aVar8 = new s.a(SubmitPrivateAnalyticsWorker.class, dVar.t(), timeUnit);
            d.a aVar9 = new d.a();
            aVar9.b = true;
            aVar9.a = oVar;
            aVar8.c.f1197j = new d(aVar9);
            e.c0.a0.t.s.c<q.b.c> cVar5 = ((e.c0.a0.c) wVar4.e("SubmitPrivateAnalyticsWorker", gVar, aVar8.d(aVar6, 30000, timeUnit2).a())).f1081d;
            cVar5.a(new f.b.b.f.a.q(cVar5, new f.b.a.a.a.p0.p(qVar)), qVar.b);
        }

        @Override // f.b.b.f.a.p
        public void b(Throwable th) {
            throw new e.b(th);
        }
    }

    @Override // e.c0.c.b
    public c a() {
        c.a aVar = new c.a();
        aVar.a = this.c;
        return new c(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
        if (r3 != false) goto L_0x0094;
     */
    @Override // f.b.a.a.a.r, android.app.Application
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onCreate() {
        u<?> uVar;
        boolean z;
        super.onCreate();
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 31) {
            registerActivityLifecycleCallbacks(new a.b(0, f.b.a.e.k.a.c));
        }
        if (this.f331f.b()) {
            this.f332g.execute(new Runnable() { // from class: f.b.a.a.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    ExposureNotificationApplication.this.f331f.a().a();
                }
            });
        }
        if (!f.c.a.a.a.getAndSet(true)) {
            b bVar = new b(this, "org/threeten/bp/TZDB.dat");
            if (h.a.get()) {
                throw new IllegalStateException("Already initialized");
            } else if (!h.b.compareAndSet(null, bVar)) {
                throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
            }
        }
        f fVar = this.f333h;
        Objects.requireNonNull(fVar);
        if (f.a(getResources()) && !fVar.a.b.a.getBoolean("ExposureNotificationSharedPreferences.MIGRATION_RUN_OR_NOT_NEEDED", false)) {
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
            f.b.b.f.a.l y = f.b.b.f.a.l.x(f.b.b.f.a.l.x(((e.c0.a0.c) eVar.c.a()).f1081d).z(new i(this) { // from class: f.b.a.a.a.b0.b
                public final /* synthetic */ Context b;

                {
                    this.b = r2;
                }

                @Override // f.b.b.f.a.i
                public final u a(Object obj) {
                    e eVar2 = e.this;
                    Context context = this.b;
                    q.b.c cVar = (q.b.c) obj;
                    Objects.requireNonNull(eVar2);
                    File file = new File(context.getApplicationInfo().dataDir);
                    boolean z3 = true;
                    if (file.exists()) {
                        String[] list = file.list();
                        for (String str : list) {
                            if (!str.equals("no_backup") && !str.equals("lib") && !eVar2.a(new File(file, str))) {
                                z3 = false;
                            }
                        }
                    }
                    return f.b.a.c.b.o.b.R0(Boolean.valueOf(z3));
                }
            }, eVar.a).z(f.b.a.a.a.b0.a.a, eVar.a)).y(new f.b.b.a.g() { // from class: f.b.a.a.a.b0.d
                @Override // f.b.b.a.g
                public final Object a(Object obj) {
                    Void r2 = (Void) obj;
                    f.this.a.b();
                    return null;
                }
            }, fVar.c);
            f.b.a.a.a.b0.c cVar = new i() { // from class: f.b.a.a.a.b0.c
                @Override // f.b.b.f.a.i
                public final u a(Object obj) {
                    Exception exc = (Exception) obj;
                    f.this.a.b();
                    Objects.requireNonNull(exc);
                    return new s.a(exc);
                }
            };
            ExecutorService executorService = fVar.c;
            a.C0110a aVar = new a.C0110a(y, Exception.class, cVar);
            y.a(aVar, f.b.a.c.b.o.b.k1(executorService, aVar));
            uVar = aVar;
        }
        uVar.a(new f.b.b.f.a.q(uVar, new a()), this.f332g);
        ApplicationObserver applicationObserver = this.f330e;
        v vVar = v.f1900j;
        Objects.requireNonNull(applicationObserver);
        vVar.f1904g.a(applicationObserver);
    }
}
