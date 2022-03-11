package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import e.b0.l;
import e.b0.s;
import e.b0.x.k;
import e.b0.x.p.c.b;
import e.b0.x.s.d;
import e.b0.x.s.f;
import e.b0.x.s.i;
import e.b0.x.s.m;
import e.b0.x.s.n;
import e.b0.x.s.o;
import e.b0.x.s.p;
import e.b0.x.s.q;
import e.b0.x.t.g;
import e.b0.x.t.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f317e = l.e("ForceStopRunnable");

    /* renamed from: f  reason: collision with root package name */
    public static final long f318f = TimeUnit.DAYS.toMillis(3650);
    public final Context b;
    public final e.b0.x.l c;

    /* renamed from: d  reason: collision with root package name */
    public int f319d = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String a = l.e("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                int i2 = ((l.a) l.c()).b;
                ForceStopRunnable.c(context);
            }
        }
    }

    public ForceStopRunnable(Context context, e.b0.x.l lVar) {
        this.b = context.getApplicationContext();
        this.c = lVar;
    }

    public static PendingIntent b(Context context, int i2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return PendingIntent.getBroadcast(context, -1, intent, i2);
    }

    public static void c(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent b2 = b(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f318f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, b2);
        }
    }

    public void a() {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.b;
            e.b0.x.l lVar = this.c;
            String str = b.f1080f;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            List<JobInfo> e2 = b.e(context, jobScheduler);
            i iVar = (i) lVar.c.o();
            Objects.requireNonNull(iVar);
            e.t.i v = e.t.i.v("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
            iVar.a.b();
            Cursor b2 = e.t.p.b.b(iVar.a, v, false, null);
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
                            l.c().a(b.f1080f, "Reconciling jobs", new Throwable[0]);
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
                    } finally {
                        workDatabase.g();
                    }
                }
            } finally {
                b2.close();
                v.V();
            }
        } else {
            z = false;
        }
        WorkDatabase workDatabase2 = this.c.c;
        p r2 = workDatabase2.r();
        m q = workDatabase2.q();
        workDatabase2.c();
        q qVar = (q) r2;
        try {
            ArrayList arrayList2 = (ArrayList) qVar.e();
            boolean z3 = !arrayList2.isEmpty();
            if (z3) {
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    o oVar = (o) it3.next();
                    qVar.p(s.ENQUEUED, oVar.a);
                    qVar.l(oVar.a, -1);
                }
            }
            ((n) q).b();
            workDatabase2.l();
            boolean z4 = z3 || z;
            Long a = ((f) this.c.f1031g.a.n()).a("reschedule_needed");
            if (a != null && a.longValue() == 1) {
                l.c().a(f317e, "Rescheduling Workers.", new Throwable[0]);
                this.c.f();
                g gVar = this.c.f1031g;
                Objects.requireNonNull(gVar);
                ((f) gVar.a.n()).b(new d("reschedule_needed", false));
            } else {
                if (b(this.b, 536870912) == null) {
                    c(this.b);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    l.c().a(f317e, "Application was force-stopped, rescheduling.", new Throwable[0]);
                    this.c.f();
                } else if (z4) {
                    l.c().a(f317e, "Found unfinished work, scheduling it.", new Throwable[0]);
                    e.b0.x.l lVar2 = this.c;
                    e.b0.x.f.a(lVar2.b, lVar2.c, lVar2.f1029e);
                }
            }
            e.b0.x.l lVar3 = this.c;
            Objects.requireNonNull(lVar3);
            synchronized (e.b0.x.l.n) {
                lVar3.f1032h = true;
                BroadcastReceiver.PendingResult pendingResult = lVar3.f1033i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    lVar3.f1033i = null;
                }
            }
        } finally {
            workDatabase2.g();
        }
    }

    public void run() {
        boolean z;
        File file;
        e.b0.x.l lVar = this.c;
        if (lVar.f1034j == null) {
            synchronized (e.b0.x.l.n) {
                if (lVar.f1034j == null) {
                    lVar.h();
                    if (lVar.f1034j == null) {
                        Objects.requireNonNull(lVar.b);
                        if (!TextUtils.isEmpty(null)) {
                            throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                        }
                    }
                }
            }
        }
        if (lVar.f1034j == null) {
            z = true;
        } else {
            l c2 = l.c();
            String str = f317e;
            c2.a(str, "Found a remote implementation for WorkManager", new Throwable[0]);
            z = h.a(this.b, this.c.b);
            l.c().a(str, String.format("Is default app process = %s", Boolean.valueOf(z)), new Throwable[0]);
        }
        if (z) {
            while (true) {
                Context context = this.b;
                String str2 = k.a;
                File databasePath = context.getDatabasePath("androidx.work.workdb");
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23 && databasePath.exists()) {
                    l.c().a(k.a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
                    HashMap hashMap = new HashMap();
                    if (i2 >= 23) {
                        File databasePath2 = context.getDatabasePath("androidx.work.workdb");
                        if (i2 < 23) {
                            file = context.getDatabasePath("androidx.work.workdb");
                        } else {
                            file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
                        }
                        hashMap.put(databasePath2, file);
                        String[] strArr = k.b;
                        for (String str3 : strArr) {
                            hashMap.put(new File(databasePath2.getPath() + str3), new File(file.getPath() + str3));
                        }
                    }
                    for (File file2 : hashMap.keySet()) {
                        File file3 = (File) hashMap.get(file2);
                        if (file2.exists() && file3 != null) {
                            if (file3.exists()) {
                                l.c().f(k.a, String.format("Over-writing contents of %s", file3), new Throwable[0]);
                            }
                            l.c().a(k.a, file2.renameTo(file3) ? String.format("Migrated %s to %s", file2, file3) : String.format("Renaming %s to %s failed", file2, file3), new Throwable[0]);
                        }
                    }
                }
                l.c().a(f317e, "Performing cleanup operations.", new Throwable[0]);
                try {
                    a();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                    int i3 = this.f319d + 1;
                    this.f319d = i3;
                    if (i3 >= 3) {
                        l.c().b(f317e, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        Objects.requireNonNull(this.c.b);
                        throw illegalStateException;
                    }
                    l.c().a(f317e, String.format("Retrying after %s", Long.valueOf(((long) i3) * 300)), e2);
                    try {
                        Thread.sleep(((long) this.f319d) * 300);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }
}
