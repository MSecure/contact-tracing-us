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
import e.z.l;
import e.z.s;
import e.z.x.k;
import e.z.x.p.c.b;
import e.z.x.s.d;
import e.z.x.s.f;
import e.z.x.s.i;
import e.z.x.s.m;
import e.z.x.s.n;
import e.z.x.s.o;
import e.z.x.s.p;
import e.z.x.s.q;
import e.z.x.t.g;
import e.z.x.t.h;
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
    public static final String f313e = l.e("ForceStopRunnable");

    /* renamed from: f  reason: collision with root package name */
    public static final long f314f = TimeUnit.DAYS.toMillis(3650);
    public final Context b;
    public final e.z.x.l c;

    /* renamed from: d  reason: collision with root package name */
    public int f315d = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String a = l.e("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                int i2 = ((l.a) l.c()).b;
                ForceStopRunnable.c(context);
            }
        }
    }

    public ForceStopRunnable(Context context, e.z.x.l lVar) {
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
        long currentTimeMillis = System.currentTimeMillis() + f314f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, b2);
        }
    }

    public void a() {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.b;
            e.z.x.l lVar = this.c;
            String str = b.f1955f;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            List<JobInfo> e2 = b.e(context, jobScheduler);
            i iVar = (i) lVar.c.o();
            Objects.requireNonNull(iVar);
            e.t.i t = e.t.i.t("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
            iVar.a.b();
            Cursor b2 = e.t.p.b.b(iVar.a, t, false, null);
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
                            l.c().a(b.f1955f, "Reconciling jobs", new Throwable[0]);
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
                t.Q();
            }
        } else {
            z = false;
        }
        WorkDatabase workDatabase2 = this.c.c;
        p r2 = workDatabase2.r();
        m q = workDatabase2.q();
        workDatabase2.c();
        try {
            q qVar = (q) r2;
            List<o> e3 = qVar.e();
            boolean z3 = !((ArrayList) e3).isEmpty();
            if (z3) {
                Iterator it3 = ((ArrayList) e3).iterator();
                while (it3.hasNext()) {
                    o oVar = (o) it3.next();
                    qVar.p(s.ENQUEUED, oVar.a);
                    qVar.l(oVar.a, -1);
                }
            }
            ((n) q).b();
            workDatabase2.l();
            boolean z4 = z3 || z;
            Long a = ((f) this.c.f1906g.a.n()).a("reschedule_needed");
            if (a != null && a.longValue() == 1) {
                l.c().a(f313e, "Rescheduling Workers.", new Throwable[0]);
                this.c.h();
                g gVar = this.c.f1906g;
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
                    l.c().a(f313e, "Application was force-stopped, rescheduling.", new Throwable[0]);
                    this.c.h();
                } else if (z4) {
                    l.c().a(f313e, "Found unfinished work, scheduling it.", new Throwable[0]);
                    e.z.x.l lVar2 = this.c;
                    e.z.x.f.a(lVar2.b, lVar2.c, lVar2.f1904e);
                }
            }
            e.z.x.l lVar3 = this.c;
            Objects.requireNonNull(lVar3);
            synchronized (e.z.x.l.n) {
                lVar3.f1907h = true;
                BroadcastReceiver.PendingResult pendingResult = lVar3.f1908i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    lVar3.f1908i = null;
                }
            }
        } finally {
            workDatabase2.g();
        }
    }

    public void run() {
        boolean z;
        File file;
        e.z.x.l lVar = this.c;
        if (lVar.f1909j == null) {
            synchronized (e.z.x.l.n) {
                if (lVar.f1909j == null) {
                    lVar.j();
                    if (lVar.f1909j == null) {
                        Objects.requireNonNull(lVar.b);
                        if (!TextUtils.isEmpty(null)) {
                            throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                        }
                    }
                }
            }
        }
        if (lVar.f1909j == null) {
            z = true;
        } else {
            l c2 = l.c();
            String str = f313e;
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
                l.c().a(f313e, "Performing cleanup operations.", new Throwable[0]);
                try {
                    a();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                    int i3 = this.f315d + 1;
                    this.f315d = i3;
                    if (i3 >= 3) {
                        l.c().b(f313e, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        Objects.requireNonNull(this.c.b);
                        throw illegalStateException;
                    }
                    l.c().a(f313e, String.format("Retrying after %s", Long.valueOf(((long) i3) * 300)), e2);
                    try {
                        Thread.sleep(((long) this.f315d) * 300);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }
}
