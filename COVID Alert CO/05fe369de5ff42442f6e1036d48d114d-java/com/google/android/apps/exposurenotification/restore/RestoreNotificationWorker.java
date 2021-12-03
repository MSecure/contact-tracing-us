package com.google.android.apps.exposurenotification.restore;

import android.app.ActivityManager;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import e.z.g;
import e.z.n;
import e.z.t;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.w;
import f.b.a.c.b.o.b;
import f.b.b.f.a.u;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import l.b.a.d;

public class RestoreNotificationWorker extends ListenableWorker {

    /* renamed from: h  reason: collision with root package name */
    public static final d f431h = d.h(24);

    /* renamed from: e  reason: collision with root package name */
    public final Context f432e;

    /* renamed from: f  reason: collision with root package name */
    public final w f433f;

    /* renamed from: g  reason: collision with root package name */
    public final v0 f434g;

    static {
        d.l(30);
    }

    public RestoreNotificationWorker(Context context, WorkerParameters workerParameters, w wVar, v0 v0Var) {
        super(context, workerParameters);
        this.f432e = context;
        this.f433f = wVar;
        this.f434g = v0Var;
    }

    public static void g(t tVar) {
        d dVar = f431h;
        g gVar = g.KEEP;
        Objects.requireNonNull(tVar);
        tVar.e("RestoreNotificationWork", gVar, Collections.singletonList((n) ((n.a) new n.a(RestoreNotificationWorker.class).e(dVar.t(), TimeUnit.MILLISECONDS)).a()));
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        v0.h hVar;
        Context context = this.f432e;
        v0 v0Var = this.f434g;
        w wVar = this.f433f;
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
            wVar.d(context, R.string.reactivate_exposure_notification_app_subject, R.string.reactivate_exposure_notification_app_body);
        }
        return b.O0(new ListenableWorker.a.c());
    }
}
