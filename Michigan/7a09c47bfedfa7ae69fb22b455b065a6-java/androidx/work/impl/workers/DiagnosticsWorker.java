package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b.b.k.i;
import b.b0.c;
import b.b0.e;
import b.b0.m;
import b.b0.y.r.g;
import b.b0.y.r.h;
import b.b0.y.r.i;
import b.b0.y.r.k;
import b.b0.y.r.l;
import b.b0.y.r.p;
import b.b0.y.r.q;
import b.b0.y.r.r;
import b.b0.y.r.t;
import b.b0.y.r.u;
import b.s.j;
import b.s.q.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final String f495b = m.e("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX INFO: finally extract failed */
    public static String b(k kVar, t tVar, h hVar, List<p> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", "Job Id"));
        for (p pVar : list) {
            g a2 = ((i) hVar).a(pVar.f1234a);
            Integer valueOf = a2 != null ? Integer.valueOf(a2.f1220b) : null;
            String str = pVar.f1234a;
            l lVar = (l) kVar;
            if (lVar != null) {
                j c2 = j.c("SELECT name FROM workname WHERE work_spec_id=?", 1);
                if (str == null) {
                    c2.e(1);
                } else {
                    c2.f(1, str);
                }
                lVar.f1226a.assertNotSuspendingTransaction();
                Cursor b2 = b.b(lVar.f1226a, c2, false, null);
                try {
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        arrayList.add(b2.getString(0));
                    }
                    b2.close();
                    c2.g();
                    sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", pVar.f1234a, pVar.f1236c, valueOf, pVar.f1235b.name(), TextUtils.join(",", arrayList), TextUtils.join(",", ((u) tVar).a(pVar.f1234a))));
                } catch (Throwable th) {
                    b2.close();
                    c2.g();
                    throw th;
                }
            } else {
                throw null;
            }
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a a() {
        j jVar;
        Throwable th;
        h hVar;
        t tVar;
        k kVar;
        int i;
        WorkDatabase workDatabase = b.b0.y.k.b(getApplicationContext()).f1096c;
        q h = workDatabase.h();
        k f2 = workDatabase.f();
        t i2 = workDatabase.i();
        h e2 = workDatabase.e();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);
        r rVar = (r) h;
        if (rVar != null) {
            j c2 = j.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
            c2.d(1, currentTimeMillis);
            rVar.f1243a.assertNotSuspendingTransaction();
            Cursor b2 = b.b(rVar.f1243a, c2, false, null);
            try {
                int y = i.j.y(b2, "required_network_type");
                int y2 = i.j.y(b2, "requires_charging");
                int y3 = i.j.y(b2, "requires_device_idle");
                int y4 = i.j.y(b2, "requires_battery_not_low");
                int y5 = i.j.y(b2, "requires_storage_not_low");
                int y6 = i.j.y(b2, "trigger_content_update_delay");
                int y7 = i.j.y(b2, "trigger_max_content_delay");
                int y8 = i.j.y(b2, "content_uri_triggers");
                int y9 = i.j.y(b2, "id");
                int y10 = i.j.y(b2, "state");
                int y11 = i.j.y(b2, "worker_class_name");
                int y12 = i.j.y(b2, "input_merger_class_name");
                int y13 = i.j.y(b2, "input");
                int y14 = i.j.y(b2, "output");
                jVar = c2;
                try {
                    int y15 = i.j.y(b2, "initial_delay");
                    int y16 = i.j.y(b2, "interval_duration");
                    int y17 = i.j.y(b2, "flex_duration");
                    int y18 = i.j.y(b2, "run_attempt_count");
                    int y19 = i.j.y(b2, "backoff_policy");
                    int y20 = i.j.y(b2, "backoff_delay_duration");
                    int y21 = i.j.y(b2, "period_start_time");
                    int y22 = i.j.y(b2, "minimum_retention_duration");
                    int y23 = i.j.y(b2, "schedule_requested_at");
                    int y24 = i.j.y(b2, "run_in_foreground");
                    int i3 = y14;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        String string = b2.getString(y9);
                        String string2 = b2.getString(y11);
                        c cVar = new c();
                        cVar.f1009a = b.x.t.P1(b2.getInt(y));
                        cVar.f1010b = b2.getInt(y2) != 0;
                        cVar.f1011c = b2.getInt(y3) != 0;
                        cVar.f1012d = b2.getInt(y4) != 0;
                        cVar.f1013e = b2.getInt(y5) != 0;
                        cVar.f1014f = b2.getLong(y6);
                        cVar.f1015g = b2.getLong(y7);
                        cVar.h = b.x.t.n(b2.getBlob(y8));
                        p pVar = new p(string, string2);
                        pVar.f1235b = b.x.t.Q1(b2.getInt(y10));
                        pVar.f1237d = b2.getString(y12);
                        pVar.f1238e = e.g(b2.getBlob(y13));
                        pVar.f1239f = e.g(b2.getBlob(i3));
                        i3 = i3;
                        pVar.f1240g = b2.getLong(y15);
                        pVar.h = b2.getLong(y16);
                        pVar.i = b2.getLong(y17);
                        pVar.k = b2.getInt(y18);
                        pVar.l = b.x.t.O1(b2.getInt(y19));
                        y17 = y17;
                        pVar.m = b2.getLong(y20);
                        pVar.n = b2.getLong(y21);
                        y21 = y21;
                        pVar.o = b2.getLong(y22);
                        pVar.p = b2.getLong(y23);
                        pVar.q = b2.getInt(y24) != 0;
                        pVar.j = cVar;
                        arrayList.add(pVar);
                        y23 = y23;
                        y24 = y24;
                        y13 = y13;
                        y12 = y12;
                        y16 = y16;
                        y18 = y18;
                        y11 = y11;
                        y = y;
                        y15 = y15;
                        y22 = y22;
                        y9 = y9;
                        y2 = y2;
                        y20 = y20;
                        y3 = y3;
                        y19 = y19;
                    }
                    b2.close();
                    jVar.g();
                    r rVar2 = (r) h;
                    List<p> e3 = rVar2.e();
                    List<p> b3 = rVar2.b(200);
                    if (!arrayList.isEmpty()) {
                        i = 0;
                        m.c().d(f495b, "Recently completed work:\n\n", new Throwable[0]);
                        hVar = e2;
                        kVar = f2;
                        tVar = i2;
                        m.c().d(f495b, b(kVar, tVar, hVar, arrayList), new Throwable[0]);
                    } else {
                        hVar = e2;
                        kVar = f2;
                        tVar = i2;
                        i = 0;
                    }
                    if (!((ArrayList) e3).isEmpty()) {
                        m.c().d(f495b, "Running work:\n\n", new Throwable[i]);
                        m.c().d(f495b, b(kVar, tVar, hVar, e3), new Throwable[i]);
                    }
                    if (!((ArrayList) b3).isEmpty()) {
                        m.c().d(f495b, "Enqueued work:\n\n", new Throwable[i]);
                        m.c().d(f495b, b(kVar, tVar, hVar, b3), new Throwable[i]);
                    }
                    return new ListenableWorker.a.c();
                } catch (Throwable th2) {
                    th = th2;
                    b2.close();
                    jVar.g();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                jVar = c2;
                b2.close();
                jVar.g();
                throw th;
            }
        } else {
            throw null;
        }
    }
}
