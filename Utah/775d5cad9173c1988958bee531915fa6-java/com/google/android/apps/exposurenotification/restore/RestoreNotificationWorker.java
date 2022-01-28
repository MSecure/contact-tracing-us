package com.google.android.apps.exposurenotification.restore;

import android.app.ActivityManager;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import e.b0.h;
import e.b0.p;
import e.b0.w;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.s.v;
import f.b.a.c.b.o.b;
import f.b.b.f.a.u;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import l.b.a.d;

public class RestoreNotificationWorker extends ListenableWorker {

    /* renamed from: j  reason: collision with root package name */
    public static final d f427j = d.h(24);

    /* renamed from: g  reason: collision with root package name */
    public final Context f428g;

    /* renamed from: h  reason: collision with root package name */
    public final v f429h;

    /* renamed from: i  reason: collision with root package name */
    public final v0 f430i;

    static {
        d.l(30);
    }

    public RestoreNotificationWorker(Context context, WorkerParameters workerParameters, v vVar, v0 v0Var) {
        super(context, workerParameters);
        this.f428g = context;
        this.f429h = vVar;
        this.f430i = v0Var;
    }

    public static void g(w wVar) {
        d dVar = f427j;
        h hVar = h.KEEP;
        Objects.requireNonNull(wVar);
        wVar.f("RestoreNotificationWork", hVar, Collections.singletonList((p) ((p.a) new p.a(RestoreNotificationWorker.class).e(dVar.t(), TimeUnit.MILLISECONDS)).a()));
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        v0.h hVar;
        Context context = this.f428g;
        v0 v0Var = this.f430i;
        v vVar = this.f429h;
        v0.h hVar2 = v0.h.UNKNOWN;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i2 = runningAppProcessInfo.importance;
        boolean z = i2 == 100 || i2 == 200;
        int i3 = v0Var.a.getInt("ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY", 0);
        if (i3 != 1) {
            hVar = i3 != 2 ? hVar2 : v0.h.SKIPPED;
        } else {
            hVar = v0.h.ONBOARDED;
        }
        if (hVar == hVar2 && !z) {
            vVar.d(context, R.string.reactivate_exposure_notification_app_subject, R.string.reactivate_exposure_notification_app_body);
        }
        return b.Q0(new ListenableWorker.a.c());
    }
}
