package b.z.y.o.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import b.z.m;
import b.z.y.o.b.e;
import b.z.y.r.p;
import b.z.y.r.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b implements b.z.y.b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1999e = m.e("CommandHandler");

    /* renamed from: b  reason: collision with root package name */
    public final Context f2000b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b.z.y.b> f2001c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Object f2002d = new Object();

    public b(Context context) {
        this.f2000b = context;
    }

    public static Intent b(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent c(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    public static Intent e(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @Override // b.z.y.b
    public void a(String str, boolean z) {
        synchronized (this.f2002d) {
            b.z.y.b remove = this.f2001c.remove(str);
            if (remove != null) {
                remove.a(str, z);
            }
        }
    }

    public void f(Intent intent, int i, e eVar) {
        boolean z;
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            m.c().a(f1999e, String.format("Handling constraints changed %s", intent), new Throwable[0]);
            c cVar = new c(this.f2000b, i, eVar);
            List<p> f = ((r) cVar.f2006c.f.f1971c.h()).f();
            ConstraintProxy.a(cVar.f2004a, f);
            cVar.f2007d.b(f);
            ArrayList arrayList = (ArrayList) f;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                String str = pVar.f2091a;
                if (currentTimeMillis >= pVar.a() && (!pVar.b() || cVar.f2007d.a(str))) {
                    arrayList2.add(pVar);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String str2 = ((p) it2.next()).f2091a;
                Intent c2 = c(cVar.f2004a, str2);
                m.c().a(c.f2003e, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
                e eVar2 = cVar.f2006c;
                eVar2.h.post(new e.b(eVar2, c2, cVar.f2005b));
            }
            cVar.f2007d.c();
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            m.c().a(f1999e, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
            eVar.f.d();
        } else {
            Bundle extras = intent.getExtras();
            String[] strArr = {"KEY_WORKSPEC_ID"};
            if (extras != null && !extras.isEmpty()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= 1) {
                        z = true;
                        break;
                    } else if (extras.get(strArr[i2]) == null) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            z = false;
            if (!z) {
                m.c().b(f1999e, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
            } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
                String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
                m.c().a(f1999e, String.format("Handling schedule work for %s", string), new Throwable[0]);
                WorkDatabase workDatabase = eVar.f.f1971c;
                workDatabase.beginTransaction();
                try {
                    p i3 = ((r) workDatabase.h()).i(string);
                    if (i3 == null) {
                        m.c().f(f1999e, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                    } else if (i3.f2092b.b()) {
                        m.c().f(f1999e, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                    } else {
                        long a2 = i3.a();
                        if (!i3.b()) {
                            m.c().a(f1999e, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(a2)), new Throwable[0]);
                            a.c(this.f2000b, eVar.f, string, a2);
                        } else {
                            m.c().a(f1999e, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(a2)), new Throwable[0]);
                            a.c(this.f2000b, eVar.f, string, a2);
                            eVar.h.post(new e.b(eVar, b(this.f2000b), i));
                        }
                        workDatabase.setTransactionSuccessful();
                    }
                } finally {
                    workDatabase.endTransaction();
                }
            } else if ("ACTION_DELAY_MET".equals(action)) {
                Bundle extras2 = intent.getExtras();
                synchronized (this.f2002d) {
                    String string2 = extras2.getString("KEY_WORKSPEC_ID");
                    m.c().a(f1999e, String.format("Handing delay met for %s", string2), new Throwable[0]);
                    if (!this.f2001c.containsKey(string2)) {
                        d dVar = new d(this.f2000b, i, string2, eVar);
                        this.f2001c.put(string2, dVar);
                        dVar.f();
                    } else {
                        m.c().a(f1999e, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string2), new Throwable[0]);
                    }
                }
            } else if ("ACTION_STOP_WORK".equals(action)) {
                String string3 = intent.getExtras().getString("KEY_WORKSPEC_ID");
                m.c().a(f1999e, String.format("Handing stopWork work for %s", string3), new Throwable[0]);
                eVar.f.e(string3);
                a.a(this.f2000b, eVar.f, string3);
                eVar.a(string3, false);
            } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
                Bundle extras3 = intent.getExtras();
                String string4 = extras3.getString("KEY_WORKSPEC_ID");
                boolean z2 = extras3.getBoolean("KEY_NEEDS_RESCHEDULE");
                m.c().a(f1999e, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
                a(string4, z2);
            } else {
                m.c().f(f1999e, String.format("Ignoring intent %s", intent), new Throwable[0]);
            }
        }
    }
}
