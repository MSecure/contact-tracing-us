package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import e.b.a.m;
import e.b0.a0.k;
import e.b0.a0.l;
import e.b0.a0.p.c.b;
import e.b0.a0.s.d;
import e.b0.a0.s.f;
import e.b0.a0.s.i;
import e.b0.a0.s.o;
import e.b0.a0.s.p;
import e.b0.a0.s.q;
import e.b0.a0.t.h;
import e.b0.c;
import e.b0.n;
import e.b0.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f317e = n.e("ForceStopRunnable");

    /* renamed from: f  reason: collision with root package name */
    public static final long f318f = TimeUnit.DAYS.toMillis(3650);
    public final Context b;
    public final l c;

    /* renamed from: d  reason: collision with root package name */
    public int f319d = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String a = n.e("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                int i2 = ((n.a) n.c()).b;
                ForceStopRunnable.d(context);
            }
        }
    }

    public ForceStopRunnable(Context context, l lVar) {
        this.b = context.getApplicationContext();
        this.c = lVar;
    }

    public static PendingIntent b(Context context, int i2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return PendingIntent.getBroadcast(context, -1, intent, i2);
    }

    public static void d(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent b2 = b(context, m.e.I0() ? 167772160 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f318f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, b2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x020c  */
    public void a() {
        boolean z;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.b;
            l lVar = this.c;
            String str = b.f1079f;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            List<JobInfo> e2 = b.e(context, jobScheduler);
            i iVar = (i) lVar.c.o();
            Objects.requireNonNull(iVar);
            e.u.i t = e.u.i.t("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
            iVar.a.b();
            Cursor b2 = e.u.p.b.b(iVar.a, t, false, null);
            try {
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    arrayList.add(b2.getString(0));
                }
                HashSet hashSet = new HashSet(e2 != null ? e2.size() : 0);
                if (e2 != null && !e2.isEmpty()) {
                    for (JobInfo jobInfo : e2) {
                        String g2 = b.g(jobInfo);
                        if (!TextUtils.isEmpty(g2)) {
                            hashSet.add(g2);
                        } else {
                            b.a(jobScheduler, jobInfo.getId());
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!hashSet.contains((String) it.next())) {
                            n.c().a(b.f1079f, "Reconciling jobs", new Throwable[0]);
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    WorkDatabase workDatabase = lVar.c;
                    workDatabase.c();
                    try {
                        p r = workDatabase.r();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((q) r).l((String) it2.next(), -1);
                        }
                        workDatabase.l();
                    } finally {
                        workDatabase.g();
                    }
                }
            } finally {
                b2.close();
                t.Q();
            }
        } else {
            z = false;
        }
        WorkDatabase workDatabase2 = this.c.c;
        p r2 = workDatabase2.r();
        e.b0.a0.s.m q = workDatabase2.q();
        workDatabase2.c();
        try {
            q qVar = (q) r2;
            List<o> e3 = qVar.e();
            boolean z3 = !((ArrayList) e3).isEmpty();
            if (z3) {
                Iterator it3 = ((ArrayList) e3).iterator();
                while (it3.hasNext()) {
                    o oVar = (o) it3.next();
                    qVar.p(v.ENQUEUED, oVar.a);
                    qVar.l(oVar.a, -1);
                }
            }
            ((e.b0.a0.s.n) q).b();
            workDatabase2.l();
            boolean z4 = z3 || z;
            Long a = ((f) this.c.f1030g.a.n()).a("reschedule_needed");
            if (a != null && a.longValue() == 1) {
                n.c().a(f317e, "Rescheduling Workers.", new Throwable[0]);
                this.c.j();
                h hVar = this.c.f1030g;
                Objects.requireNonNull(hVar);
                ((f) hVar.a.n()).b(new d("reschedule_needed", false));
                return;
            }
            int i2 = 536870912;
            try {
                if (m.e.I0()) {
                    i2 = 570425344;
                }
                PendingIntent b3 = b(this.b, i2);
                if (Build.VERSION.SDK_INT >= 30) {
                    if (b3 != null) {
                        b3.cancel();
                    }
                    List historicalProcessExitReasons = ((ActivityManager) this.b.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                    if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= historicalProcessExitReasons.size()) {
                                break;
                            } else if (((ApplicationExitInfo) historicalProcessExitReasons.get(i3)).getReason() == 10) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                } else if (b3 == null) {
                    d(this.b);
                    if (!z2) {
                        n.c().a(f317e, "Application was force-stopped, rescheduling.", new Throwable[0]);
                        this.c.j();
                        return;
                    } else if (z4) {
                        n.c().a(f317e, "Found unfinished work, scheduling it.", new Throwable[0]);
                        l lVar2 = this.c;
                        e.b0.a0.f.a(lVar2.b, lVar2.c, lVar2.f1028e);
                        return;
                    } else {
                        return;
                    }
                }
                z2 = false;
            } catch (IllegalArgumentException | SecurityException e4) {
                n.c().f(f317e, "Ignoring exception", e4);
            }
            if (!z2) {
            }
        } finally {
            workDatabase2.g();
        }
    }

    public boolean c() {
        c cVar = this.c.b;
        Objects.requireNonNull(cVar);
        if (TextUtils.isEmpty(null)) {
            n.c().a(f317e, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean a = e.b0.a0.t.i.a(this.b, cVar);
        n.c().a(f317e, String.format("Is default app process = %s", Boolean.valueOf(a)), new Throwable[0]);
        return a;
    }

    public void run() {
        try {
            if (c()) {
                while (true) {
                    k.a(this.b);
                    n.c().a(f317e, "Performing cleanup operations.", new Throwable[0]);
                    try {
                        a();
                        this.c.i();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                        int i2 = this.f319d + 1;
                        this.f319d = i2;
                        if (i2 >= 3) {
                            n.c().b(f317e, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                            IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                            Objects.requireNonNull(this.c.b);
                            throw illegalStateException;
                        }
                        n.c().a(f317e, String.format("Retrying after %s", Long.valueOf(((long) i2) * 300)), e2);
                        try {
                            Thread.sleep(((long) this.f319d) * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        } finally {
            this.c.i();
        }
    }
}
