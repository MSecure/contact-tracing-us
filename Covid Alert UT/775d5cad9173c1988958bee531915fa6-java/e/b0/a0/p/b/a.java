package e.b0.a0.p.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import e.b0.a0.l;
import e.b0.a0.s.d;
import e.b0.a0.s.g;
import e.b0.a0.s.i;
import e.b0.a0.t.f;
import e.b0.n;

public class a {
    public static final String a = n.e("Alarms");

    public static void a(Context context, String str, int i2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i2, b.c(context, str), Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service != null && alarmManager != null) {
            n.c().a(a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i2)), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void b(Context context, l lVar, String str, long j2) {
        int intValue;
        WorkDatabase workDatabase = lVar.c;
        i iVar = (i) workDatabase.o();
        g a2 = iVar.a(str);
        if (a2 != null) {
            a(context, str, a2.b);
            c(context, str, a2.b, j2);
            return;
        }
        synchronized (f.class) {
            workDatabase.c();
            try {
                Long a3 = ((e.b0.a0.s.f) workDatabase.n()).a("next_alarm_manager_id");
                int i2 = 0;
                intValue = a3 != null ? a3.intValue() : 0;
                if (intValue != Integer.MAX_VALUE) {
                    i2 = intValue + 1;
                }
                ((e.b0.a0.s.f) workDatabase.n()).b(new d("next_alarm_manager_id", (long) i2));
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
        PendingIntent service = PendingIntent.getService(context, i2, b.c(context, str), Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
        if (alarmManager != null) {
            alarmManager.setExact(0, j2, service);
        }
    }
}
