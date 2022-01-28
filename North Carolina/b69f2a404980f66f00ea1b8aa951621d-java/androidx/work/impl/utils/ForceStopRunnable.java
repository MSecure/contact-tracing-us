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
import b.z.i;
import b.z.m;
import b.z.u;
import b.z.y.j;
import b.z.y.k;
import b.z.y.o.c.b;
import b.z.y.r.d;
import b.z.y.r.f;
import b.z.y.r.n;
import b.z.y.r.o;
import b.z.y.r.p;
import b.z.y.r.q;
import b.z.y.r.r;
import b.z.y.s.g;
import b.z.y.s.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f346e = m.e("ForceStopRunnable");
    public static final long f = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: b  reason: collision with root package name */
    public final Context f347b;

    /* renamed from: c  reason: collision with root package name */
    public final k f348c;

    /* renamed from: d  reason: collision with root package name */
    public int f349d = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public static final String f350a = m.e("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                int i = ((m.a) m.c()).f1924b;
                ForceStopRunnable.c(context);
            }
        }
    }

    public ForceStopRunnable(Context context, k kVar) {
        this.f347b = context.getApplicationContext();
        this.f348c = kVar;
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
        long currentTimeMillis = System.currentTimeMillis() + f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, b2);
        }
    }

    public void a() {
        boolean z;
        boolean i = b.i(this.f347b, this.f348c);
        WorkDatabase workDatabase = this.f348c.f1971c;
        q h = workDatabase.h();
        n g = workDatabase.g();
        workDatabase.beginTransaction();
        r rVar = (r) h;
        try {
            ArrayList arrayList = (ArrayList) rVar.e();
            boolean z2 = !arrayList.isEmpty();
            if (z2) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    p pVar = (p) it.next();
                    rVar.p(u.ENQUEUED, pVar.f2091a);
                    rVar.l(pVar.f2091a, -1);
                }
            }
            ((o) g).b();
            workDatabase.setTransactionSuccessful();
            boolean z3 = z2 || i;
            Long a2 = ((f) this.f348c.g.f2118a.d()).a("reschedule_needed");
            if (a2 != null && a2.longValue() == 1) {
                m.c().a(f346e, "Rescheduling Workers.", new Throwable[0]);
                this.f348c.d();
                g gVar = this.f348c.g;
                if (gVar != null) {
                    ((f) gVar.f2118a.d()).b(new d("reschedule_needed", false));
                } else {
                    throw null;
                }
            } else {
                if (b(this.f347b, 536870912) == null) {
                    c(this.f347b);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    m.c().a(f346e, "Application was force-stopped, rescheduling.", new Throwable[0]);
                    this.f348c.d();
                } else if (z3) {
                    m.c().a(f346e, "Found unfinished work, scheduling it.", new Throwable[0]);
                    k kVar = this.f348c;
                    b.z.y.f.b(kVar.f1970b, kVar.f1971c, kVar.f1973e);
                }
            }
            k kVar2 = this.f348c;
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
        k kVar = this.f348c;
        if (kVar.j == null) {
            synchronized (k.n) {
                if (kVar.j == null) {
                    kVar.f();
                    if (kVar.j == null) {
                        if (!TextUtils.isEmpty(kVar.f1970b.g)) {
                            throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                        }
                    }
                }
            }
        }
        if (kVar.j == null) {
            z = true;
        } else {
            m.c().a(f346e, "Found a remote implementation for WorkManager", new Throwable[0]);
            z = h.a(this.f347b, this.f348c.f1970b);
            m.c().a(f346e, String.format("Is default app process = %s", Boolean.valueOf(z)), new Throwable[0]);
        }
        if (z) {
            while (true) {
                j.b(this.f347b);
                m.c().a(f346e, "Performing cleanup operations.", new Throwable[0]);
                try {
                    a();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                    int i = this.f349d + 1;
                    this.f349d = i;
                    if (i >= 3) {
                        m.c().b(f346e, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        i iVar = this.f348c.f1970b.f;
                        if (iVar != null) {
                            m.c().a(f346e, "Routing exception to the specified exception handler", illegalStateException);
                            iVar.a(illegalStateException);
                            return;
                        }
                        throw illegalStateException;
                    }
                    m.c().a(f346e, String.format("Retrying after %s", Long.valueOf(((long) i) * 300)), e2);
                    try {
                        Thread.sleep(((long) this.f349d) * 300);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }
}
