package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b.b.k.i;
import b.r.j;
import b.r.q.b;
import b.z.c;
import b.z.e;
import b.z.m;
import b.z.y.r.g;
import b.z.y.r.h;
import b.z.y.r.i;
import b.z.y.r.k;
import b.z.y.r.l;
import b.z.y.r.p;
import b.z.y.r.q;
import b.z.y.r.r;
import b.z.y.r.t;
import b.z.y.r.u;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final String f356b = m.e("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX INFO: finally extract failed */
    public static String b(k kVar, t tVar, h hVar, List<p> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", "Job Id"));
        for (p pVar : list) {
            g a2 = ((i) hVar).a(pVar.f2091a);
            Integer valueOf = a2 != null ? Integer.valueOf(a2.f2077b) : null;
            String str = pVar.f2091a;
            l lVar = (l) kVar;
            if (lVar != null) {
                j d2 = j.d("SELECT name FROM workname WHERE work_spec_id=?", 1);
                if (str == null) {
                    d2.f(1);
                } else {
                    d2.g(1, str);
                }
                lVar.f2083a.assertNotSuspendingTransaction();
                Cursor b2 = b.b(lVar.f2083a, d2, false, null);
                try {
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        arrayList.add(b2.getString(0));
                    }
                    b2.close();
                    d2.h();
                    sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", pVar.f2091a, pVar.f2093c, valueOf, pVar.f2092b.name(), TextUtils.join(",", arrayList), TextUtils.join(",", ((u) tVar).a(pVar.f2091a))));
                } catch (Throwable th) {
                    b2.close();
                    d2.h();
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
        WorkDatabase workDatabase = b.z.y.k.b(getApplicationContext()).f1971c;
        q h = workDatabase.h();
        k f = workDatabase.f();
        t i2 = workDatabase.i();
        h e2 = workDatabase.e();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);
        r rVar = (r) h;
        if (rVar != null) {
            j d2 = j.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
            d2.e(1, currentTimeMillis);
            rVar.f2098a.assertNotSuspendingTransaction();
            Cursor b2 = b.b(rVar.f2098a, d2, false, null);
            try {
                int a0 = i.j.a0(b2, "required_network_type");
                int a02 = i.j.a0(b2, "requires_charging");
                int a03 = i.j.a0(b2, "requires_device_idle");
                int a04 = i.j.a0(b2, "requires_battery_not_low");
                int a05 = i.j.a0(b2, "requires_storage_not_low");
                int a06 = i.j.a0(b2, "trigger_content_update_delay");
                int a07 = i.j.a0(b2, "trigger_max_content_delay");
                int a08 = i.j.a0(b2, "content_uri_triggers");
                int a09 = i.j.a0(b2, "id");
                int a010 = i.j.a0(b2, "state");
                int a011 = i.j.a0(b2, "worker_class_name");
                int a012 = i.j.a0(b2, "input_merger_class_name");
                int a013 = i.j.a0(b2, "input");
                int a014 = i.j.a0(b2, "output");
                jVar = d2;
                try {
                    int a015 = i.j.a0(b2, "initial_delay");
                    int a016 = i.j.a0(b2, "interval_duration");
                    int a017 = i.j.a0(b2, "flex_duration");
                    int a018 = i.j.a0(b2, "run_attempt_count");
                    int a019 = i.j.a0(b2, "backoff_policy");
                    int a020 = i.j.a0(b2, "backoff_delay_duration");
                    int a021 = i.j.a0(b2, "period_start_time");
                    int a022 = i.j.a0(b2, "minimum_retention_duration");
                    int a023 = i.j.a0(b2, "schedule_requested_at");
                    int a024 = i.j.a0(b2, "run_in_foreground");
                    int i3 = a014;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        String string = b2.getString(a09);
                        String string2 = b2.getString(a011);
                        c cVar = new c();
                        cVar.f1898a = i.j.s0(b2.getInt(a0));
                        cVar.f1899b = b2.getInt(a02) != 0;
                        cVar.f1900c = b2.getInt(a03) != 0;
                        cVar.f1901d = b2.getInt(a04) != 0;
                        cVar.f1902e = b2.getInt(a05) != 0;
                        cVar.f = b2.getLong(a06);
                        cVar.g = b2.getLong(a07);
                        cVar.h = i.j.g(b2.getBlob(a08));
                        p pVar = new p(string, string2);
                        pVar.f2092b = i.j.t0(b2.getInt(a010));
                        pVar.f2094d = b2.getString(a012);
                        pVar.f2095e = e.g(b2.getBlob(a013));
                        pVar.f = e.g(b2.getBlob(i3));
                        i3 = i3;
                        pVar.g = b2.getLong(a015);
                        pVar.h = b2.getLong(a016);
                        pVar.i = b2.getLong(a017);
                        pVar.k = b2.getInt(a018);
                        pVar.l = i.j.r0(b2.getInt(a019));
                        a017 = a017;
                        pVar.m = b2.getLong(a020);
                        pVar.n = b2.getLong(a021);
                        a021 = a021;
                        pVar.o = b2.getLong(a022);
                        pVar.p = b2.getLong(a023);
                        pVar.q = b2.getInt(a024) != 0;
                        pVar.j = cVar;
                        arrayList.add(pVar);
                        a023 = a023;
                        a024 = a024;
                        a013 = a013;
                        a012 = a012;
                        a016 = a016;
                        a018 = a018;
                        a011 = a011;
                        a0 = a0;
                        a015 = a015;
                        a022 = a022;
                        a09 = a09;
                        a02 = a02;
                        a020 = a020;
                        a03 = a03;
                        a019 = a019;
                    }
                    b2.close();
                    jVar.h();
                    r rVar2 = (r) h;
                    List<p> e3 = rVar2.e();
                    List<p> b3 = rVar2.b(200);
                    if (!arrayList.isEmpty()) {
                        i = 0;
                        m.c().d(f356b, "Recently completed work:\n\n", new Throwable[0]);
                        hVar = e2;
                        kVar = f;
                        tVar = i2;
                        m.c().d(f356b, b(kVar, tVar, hVar, arrayList), new Throwable[0]);
                    } else {
                        hVar = e2;
                        kVar = f;
                        tVar = i2;
                        i = 0;
                    }
                    if (!((ArrayList) e3).isEmpty()) {
                        m.c().d(f356b, "Running work:\n\n", new Throwable[i]);
                        m.c().d(f356b, b(kVar, tVar, hVar, e3), new Throwable[i]);
                    }
                    if (!((ArrayList) b3).isEmpty()) {
                        m.c().d(f356b, "Enqueued work:\n\n", new Throwable[i]);
                        m.c().d(f356b, b(kVar, tVar, hVar, b3), new Throwable[i]);
                    }
                    return new ListenableWorker.a.c();
                } catch (Throwable th2) {
                    th = th2;
                    b2.close();
                    jVar.h();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                jVar = d2;
                b2.close();
                jVar.h();
                throw th;
            }
        } else {
            throw null;
        }
    }
}
