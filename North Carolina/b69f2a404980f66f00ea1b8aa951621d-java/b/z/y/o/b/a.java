package b.z.y.o.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import b.z.m;
import b.z.y.k;
import b.z.y.r.d;
import b.z.y.r.f;
import b.z.y.r.g;
import b.z.y.r.i;
import b.z.y.s.e;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1998a = m.e("Alarms");

    public static void a(Context context, k kVar, String str) {
        i iVar = (i) kVar.f1971c.e();
        g a2 = iVar.a(str);
        if (a2 != null) {
            b(context, str, a2.f2077b);
            m.c().a(f1998a, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            iVar.c(str);
        }
    }

    public static void b(Context context, String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, b.c(context, str), 536870912);
        if (service != null && alarmManager != null) {
            m.c().a(f1998a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i)), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void c(Context context, k kVar, String str, long j) {
        int intValue;
        WorkDatabase workDatabase = kVar.f1971c;
        i iVar = (i) workDatabase.e();
        g a2 = iVar.a(str);
        if (a2 != null) {
            b(context, str, a2.f2077b);
            d(context, str, a2.f2077b, j);
            return;
        }
        synchronized (e.class) {
            workDatabase.beginTransaction();
            try {
                Long a3 = ((f) workDatabase.d()).a("next_alarm_manager_id");
                int i = 0;
                intValue = a3 != null ? a3.intValue() : 0;
                if (intValue != Integer.MAX_VALUE) {
                    i = intValue + 1;
                }
                ((f) workDatabase.d()).b(new d("next_alarm_manager_id", (long) i));
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
        iVar.b(new g(str, intValue));
        d(context, str, intValue, j);
    }

    public static void d(Context context, String str, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, b.c(context, str), 134217728);
        if (alarmManager != null) {
            alarmManager.setExact(0, j, service);
        }
    }
}
