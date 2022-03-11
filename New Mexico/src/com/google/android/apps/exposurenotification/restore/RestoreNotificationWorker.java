package com.google.android.apps.exposurenotification.restore;

import android.app.ActivityManager;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker;
import e.b.a.m;
import e.c0.h;
import e.c0.p;
import e.c0.w;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.i0.b;
import f.b.a.a.a.i0.c;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.t.h0;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import l.b.a.d;
/* loaded from: classes.dex */
public class RestoreNotificationWorker extends ListenableWorker {
    public static final d m = d.h(24);

    /* renamed from: g */
    public final Context f435g;

    /* renamed from: h */
    public final h0 f436h;

    /* renamed from: i */
    public final a1 f437i;

    /* renamed from: j */
    public final q1 f438j;

    /* renamed from: k */
    public final ExecutorService f439k;

    /* renamed from: l */
    public final ScheduledExecutorService f440l;

    static {
        d.l(30);
    }

    public RestoreNotificationWorker(Context context, WorkerParameters workerParameters, h0 h0Var, a1 a1Var, q1 q1Var, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        super(context, workerParameters);
        this.f435g = context;
        this.f436h = h0Var;
        this.f437i = a1Var;
        this.f438j = q1Var;
        this.f439k = executorService;
        this.f440l = scheduledExecutorService;
    }

    public static void g(w wVar) {
        d dVar = m;
        p.a aVar = new p.a(RestoreNotificationWorker.class);
        aVar.f1261d.add("RESTORE_NOTIFICATION_WORKER_TAG");
        wVar.f("RestoreNotificationWork", h.KEEP, aVar.e(dVar.u(), TimeUnit.MILLISECONDS).a());
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l y = l.x(m.e.o0(this.f438j.b(), q1.f2205d, this.f440l)).z(new i() { // from class: f.b.a.a.a.i0.a
            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                RestoreNotificationWorker restoreNotificationWorker = RestoreNotificationWorker.this;
                Set set = (Set) obj;
                Objects.requireNonNull(restoreNotificationWorker);
                if (!set.contains(f.b.a.c.f.b.d.EN_NOT_SUPPORT) && !set.contains(f.b.a.c.f.b.d.NOT_IN_ALLOWLIST)) {
                    Context context = restoreNotificationWorker.f435g;
                    a1 a1Var = restoreNotificationWorker.f437i;
                    h0 h0Var = restoreNotificationWorker.f436h;
                    a1.h hVar = a1.h.UNKNOWN;
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    int i2 = runningAppProcessInfo.importance;
                    boolean z = i2 == 100 || i2 == 200;
                    int i3 = a1Var.a.getInt("ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY", 0);
                    if ((i3 != 1 ? i3 != 2 ? hVar : a1.h.SKIPPED : a1.h.ONBOARDED) == hVar && !z) {
                        h0Var.d(context, R.string.reactivate_exposure_notification_app_subject, R.string.reactivate_exposure_notification_app_body);
                    }
                }
                return s.c;
            }
        }, this.f439k).y(b.a, this.f439k);
        c cVar = c.a;
        ExecutorService executorService = this.f439k;
        a.b bVar = new a.b(y, Exception.class, cVar);
        y.a(bVar, f.b.a.c.b.o.b.k1(executorService, bVar));
        return bVar;
    }
}
