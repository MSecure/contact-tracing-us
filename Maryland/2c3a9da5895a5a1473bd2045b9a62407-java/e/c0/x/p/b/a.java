package e.c0.x.p.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import e.c0.l;
import e.c0.x.s.d;
import e.c0.x.s.f;
import e.c0.x.s.g;
import e.c0.x.s.i;
import e.c0.x.t.e;

public class a {
    public static final String a = l.e("Alarms");

    public static void a(Context context, String str, int i2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i2, b.c(context, str), 536870912);
        if (service != null && alarmManager != null) {
            l.c().a(a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i2)), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void b(Context context, e.c0.x.l lVar, String str, long j2) {
        int intValue;
        WorkDatabase workDatabase = lVar.c;
        i iVar = (i) workDatabase.o();
        g a2 = iVar.a(str);
        if (a2 != null) {
            a(context, str, a2.b);
            c(context, str, a2.b, j2);
            return;
        }
        synchronized (e.class) {
            workDatabase.c();
            try {
                Long a3 = ((f) workDatabase.n()).a("next_alarm_manager_id");
                int i2 = 0;
                intValue = a3 != null ? a3.intValue() : 0;
                if (intValue != Integer.MAX_VALUE) {
                    i2 = intValue + 1;
                }
                ((f) workDatabase.n()).b(new d("next_alarm_manager_id", (long) i2));
                workDatabase.l();
            } finally {
                workDatabase.g();
            }
        }
        iVar.b(new g(str, intValue));
        c(context, str, intValue, j2);
    }

    public static void c(Context context, String str, int i2, long j2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i2, b.c(context, str), 134217728);
        if (alarmManager != null) {
            alarmManager.setExact(0, j2, service);
        }
    }
}
