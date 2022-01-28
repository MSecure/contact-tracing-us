package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import b.b0.i;
import b.b0.m;
import b.b0.u;
import b.b0.y.j;
import b.b0.y.k;
import b.b0.y.o.c.b;
import b.b0.y.r.d;
import b.b0.y.r.f;
import b.b0.y.r.n;
import b.b0.y.r.o;
import b.b0.y.r.p;
import b.b0.y.r.q;
import b.b0.y.r.r;
import b.b0.y.s.g;
import b.b0.y.s.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f482e = m.e("ForceStopRunnable");

    /* renamed from: f  reason: collision with root package name */
    public static final long f483f = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: b  reason: collision with root package name */
    public final Context f484b;

    /* renamed from: c  reason: collision with root package name */
    public final k f485c;

    /* renamed from: d  reason: collision with root package name */
    public int f486d = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public static final String f487a = m.e("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                int i = ((m.a) m.c()).f1040b;
                ForceStopRunnable.c(context);
            }
        }
    }

    public ForceStopRunnable(Context context, k kVar) {
        this.f484b = context.getApplicationContext();
        this.f485c = kVar;
    }

    public static PendingIntent b(Context context, int i) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return PendingIntent.getBroadcast(context, -1, intent, i);
    }

    public static void c(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent b2 = b(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f483f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, b2);
        }
    }

    public void a() {
        boolean z;
        boolean i = b.i(this.f484b, this.f485c);
        WorkDatabase workDatabase = this.f485c.f1096c;
        q h = workDatabase.h();
        n g2 = workDatabase.g();
        workDatabase.beginTransaction();
        r rVar = (r) h;
        try {
            ArrayList arrayList = (ArrayList) rVar.e();
            boolean z2 = !arrayList.isEmpty();
            if (z2) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    p pVar = (p) it.next();
                    rVar.p(u.ENQUEUED, pVar.f1234a);
                    rVar.l(pVar.f1234a, -1);
                }
            }
            ((o) g2).b();
            workDatabase.setTransactionSuccessful();
            boolean z3 = z2 || i;
            Long a2 = ((f) this.f485c.f1100g.f1265a.d()).a("reschedule_needed");
            if (a2 != null && a2.longValue() == 1) {
                m.c().a(f482e, "Rescheduling Workers.", new Throwable[0]);
                this.f485c.d();
                g gVar = this.f485c.f1100g;
                if (gVar != null) {
                    ((f) gVar.f1265a.d()).b(new d("reschedule_needed", false));
                } else {
                    throw null;
                }
            } else {
                if (b(this.f484b, 536870912) == null) {
                    c(this.f484b);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    m.c().a(f482e, "Application was force-stopped, rescheduling.", new Throwable[0]);
                    this.f485c.d();
                } else if (z3) {
                    m.c().a(f482e, "Found unfinished work, scheduling it.", new Throwable[0]);
                    k kVar = this.f485c;
                    b.b0.y.f.b(kVar.f1095b, kVar.f1096c, kVar.f1098e);
                }
            }
            k kVar2 = this.f485c;
            if (kVar2 != null) {
                synchronized (k.n) {
                    kVar2.h = true;
                    if (kVar2.i != null) {
                        kVar2.i.finish();
                        kVar2.i = null;
                    }
                }
                return;
            }
            throw null;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public void run() {
        boolean z;
        k kVar = this.f485c;
        if (kVar.j == null) {
            synchronized (k.n) {
                if (kVar.j == null) {
                    kVar.f();
                    if (kVar.j == null) {
                        if (!TextUtils.isEmpty(kVar.f1095b.f1003g)) {
                            throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                        }
                    }
                }
            }
        }
        if (kVar.j == null) {
            z = true;
        } else {
            m.c().a(f482e, "Found a remote implementation for WorkManager", new Throwable[0]);
            z = h.a(this.f484b, this.f485c.f1095b);
            m.c().a(f482e, String.format("Is default app process = %s", Boolean.valueOf(z)), new Throwable[0]);
        }
        if (z) {
            while (true) {
                j.b(this.f484b);
                m.c().a(f482e, "Performing cleanup operations.", new Throwable[0]);
                try {
                    a();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                    int i = this.f486d + 1;
                    this.f486d = i;
                    if (i >= 3) {
                        m.c().b(f482e, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        i iVar = this.f485c.f1095b.f1002f;
                        if (iVar != null) {
                            m.c().a(f482e, "Routing exception to the specified exception handler", illegalStateException);
                            iVar.a(illegalStateException);
                            return;
                        }
                        throw illegalStateException;
                    }
                    m.c().a(f482e, String.format("Retrying after %s", Long.valueOf(((long) i) * 300)), e2);
                    try {
                        Thread.sleep(((long) this.f486d) * 300);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }
}
