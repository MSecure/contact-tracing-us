package e.b0.x.p.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.b0.c;
import e.b0.l;
import e.b0.m;
import e.b0.x.p.b.e;
import e.b0.x.s.g;
import e.b0.x.s.i;
import e.b0.x.s.o;
import e.b0.x.s.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b implements e.b0.x.b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1058e = l.e("CommandHandler");
    public final Context b;
    public final Map<String, e.b0.x.b> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Object f1059d = new Object();

    public b(Context context) {
        this.b = context;
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

    public static Intent d(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @Override // e.b0.x.b
    public void a(String str, boolean z) {
        synchronized (this.f1059d) {
            e.b0.x.b remove = this.c.remove(str);
            if (remove != null) {
                remove.a(str, z);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x018b  */
    public void e(Intent intent, int i2, e eVar) {
        boolean z;
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            l.c().a(f1058e, String.format("Handling constraints changed %s", intent), new Throwable[0]);
            c cVar = new c(this.b, i2, eVar);
            List<o> f2 = ((q) eVar.f1073f.c.r()).f();
            Context context = cVar.a;
            String str = ConstraintProxy.a;
            ArrayList arrayList = (ArrayList) f2;
            Iterator it = arrayList.iterator();
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            while (it.hasNext()) {
                c cVar2 = ((o) it.next()).f1119j;
                z2 |= cVar2.f986d;
                z3 |= cVar2.b;
                z4 |= cVar2.f987e;
                z5 |= cVar2.a != m.NOT_REQUIRED;
                if (z2 && z3 && z4 && z5) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            intent2.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z2).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z3).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z4).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z5);
            context.sendBroadcast(intent2);
            cVar.f1061d.b(f2);
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                o oVar = (o) it2.next();
                String str3 = oVar.a;
                if (currentTimeMillis >= oVar.a() && (!oVar.b() || cVar.f1061d.a(str3))) {
                    arrayList2.add(oVar);
                }
            }
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                String str4 = ((o) it3.next()).a;
                Intent c2 = c(cVar.a, str4);
                l.c().a(c.f1060e, String.format("Creating a delay_met command for workSpec with id (%s)", str4), new Throwable[0]);
                e eVar2 = cVar.c;
                eVar2.f1075h.post(new e.b(eVar2, c2, cVar.b));
            }
            cVar.f1061d.c();
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            l.c().a(f1058e, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i2)), new Throwable[0]);
            eVar.f1073f.f();
        } else {
            Bundle extras = intent.getExtras();
            String[] strArr = {"KEY_WORKSPEC_ID"};
            if (extras != null && !extras.isEmpty()) {
                int i3 = 0;
                while (true) {
                    if (i3 >= 1) {
                        z = true;
                        break;
                    } else if (extras.get(strArr[i3]) == null) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    l.c().b(f1058e, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
                    return;
                } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
                    String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
                    l c3 = l.c();
                    String str5 = f1058e;
                    c3.a(str5, String.format("Handling schedule work for %s", string), new Throwable[0]);
                    WorkDatabase workDatabase = eVar.f1073f.c;
                    workDatabase.c();
                    try {
                        o i4 = ((q) workDatabase.r()).i(string);
                        if (i4 == null) {
                            l c4 = l.c();
                            c4.f(str5, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                        } else if (i4.b.a()) {
                            l c5 = l.c();
                            c5.f(str5, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                        } else {
                            long a = i4.a();
                            if (!i4.b()) {
                                l.c().a(str5, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(a)), new Throwable[0]);
                                a.b(this.b, eVar.f1073f, string, a);
                            } else {
                                l.c().a(str5, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(a)), new Throwable[0]);
                                a.b(this.b, eVar.f1073f, string, a);
                                eVar.f1075h.post(new e.b(eVar, b(this.b), i2));
                            }
                            workDatabase.l();
                        }
                        return;
                    } finally {
                        workDatabase.g();
                    }
                } else if ("ACTION_DELAY_MET".equals(action)) {
                    Bundle extras2 = intent.getExtras();
                    synchronized (this.f1059d) {
                        String string2 = extras2.getString("KEY_WORKSPEC_ID");
                        l c6 = l.c();
                        String str6 = f1058e;
                        c6.a(str6, String.format("Handing delay met for %s", string2), new Throwable[0]);
                        if (!this.c.containsKey(string2)) {
                            d dVar = new d(this.b, i2, string2, eVar);
                            this.c.put(string2, dVar);
                            dVar.f();
                        } else {
                            l.c().a(str6, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string2), new Throwable[0]);
                        }
                    }
                    return;
                } else if ("ACTION_STOP_WORK".equals(action)) {
                    String string3 = intent.getExtras().getString("KEY_WORKSPEC_ID");
                    l.c().a(f1058e, String.format("Handing stopWork work for %s", string3), new Throwable[0]);
                    eVar.f1073f.g(string3);
                    Context context2 = this.b;
                    e.b0.x.l lVar = eVar.f1073f;
                    String str7 = a.a;
                    i iVar = (i) lVar.c.o();
                    g a2 = iVar.a(string3);
                    if (a2 != null) {
                        a.a(context2, string3, a2.b);
                        l.c().a(a.a, String.format("Removing SystemIdInfo for workSpecId (%s)", string3), new Throwable[0]);
                        iVar.c(string3);
                    }
                    eVar.a(string3, false);
                    return;
                } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
                    Bundle extras3 = intent.getExtras();
                    String string4 = extras3.getString("KEY_WORKSPEC_ID");
                    boolean z6 = extras3.getBoolean("KEY_NEEDS_RESCHEDULE");
                    l.c().a(f1058e, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i2)), new Throwable[0]);
                    a(string4, z6);
                    return;
                } else {
                    l.c().f(f1058e, String.format("Ignoring intent %s", intent), new Throwable[0]);
                    return;
                }
            }
            z = false;
            if (z) {
            }
        }
    }
}
