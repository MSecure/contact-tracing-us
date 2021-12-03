package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import e.b.a.m;
import e.t.p.b;
import e.z.c;
import e.z.e;
import e.z.l;
import e.z.x.s.g;
import e.z.x.s.h;
import e.z.x.s.i;
import e.z.x.s.k;
import e.z.x.s.o;
import e.z.x.s.p;
import e.z.x.s.q;
import e.z.x.s.s;
import e.z.x.s.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {

    /* renamed from: f  reason: collision with root package name */
    public static final String f322f = l.e("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX INFO: finally extract failed */
    public static String h(k kVar, s sVar, h hVar, List<o> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        for (o oVar : list) {
            g a = ((i) hVar).a(oVar.a);
            Integer valueOf = a != null ? Integer.valueOf(a.b) : null;
            String str = oVar.a;
            e.z.x.s.l lVar = (e.z.x.s.l) kVar;
            Objects.requireNonNull(lVar);
            e.t.i t = e.t.i.t("SELECT name FROM workname WHERE work_spec_id=?", 1);
            if (str == null) {
                t.J(1);
            } else {
                t.L(1, str);
            }
            lVar.a.b();
            Cursor b = b.b(lVar.a, t, false, null);
            try {
                ArrayList arrayList = new ArrayList(b.getCount());
                while (b.moveToNext()) {
                    arrayList.add(b.getString(0));
                }
                b.close();
                t.Q();
                sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", oVar.a, oVar.c, valueOf, oVar.b.name(), TextUtils.join(",", arrayList), TextUtils.join(",", ((t) sVar).a(oVar.a))));
            } catch (Throwable th) {
                b.close();
                t.Q();
                throw th;
            }
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a g() {
        e.t.i iVar;
        Throwable th;
        h hVar;
        s sVar;
        k kVar;
        int i2;
        WorkDatabase workDatabase = e.z.x.l.f(this.b).c;
        p r = workDatabase.r();
        k p = workDatabase.p();
        s s = workDatabase.s();
        h o = workDatabase.o();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);
        q qVar = (q) r;
        Objects.requireNonNull(qVar);
        e.t.i t = e.t.i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        t.x(1, currentTimeMillis);
        qVar.a.b();
        Cursor b = b.b(qVar.a, t, false, null);
        try {
            int d0 = m.h.d0(b, "required_network_type");
            int d02 = m.h.d0(b, "requires_charging");
            int d03 = m.h.d0(b, "requires_device_idle");
            int d04 = m.h.d0(b, "requires_battery_not_low");
            int d05 = m.h.d0(b, "requires_storage_not_low");
            int d06 = m.h.d0(b, "trigger_content_update_delay");
            int d07 = m.h.d0(b, "trigger_max_content_delay");
            int d08 = m.h.d0(b, "content_uri_triggers");
            int d09 = m.h.d0(b, "id");
            int d010 = m.h.d0(b, "state");
            int d011 = m.h.d0(b, "worker_class_name");
            int d012 = m.h.d0(b, "input_merger_class_name");
            int d013 = m.h.d0(b, "input");
            int d014 = m.h.d0(b, "output");
            iVar = t;
            try {
                int d015 = m.h.d0(b, "initial_delay");
                int d016 = m.h.d0(b, "interval_duration");
                int d017 = m.h.d0(b, "flex_duration");
                int d018 = m.h.d0(b, "run_attempt_count");
                int d019 = m.h.d0(b, "backoff_policy");
                int d020 = m.h.d0(b, "backoff_delay_duration");
                int d021 = m.h.d0(b, "period_start_time");
                int d022 = m.h.d0(b, "minimum_retention_duration");
                int d023 = m.h.d0(b, "schedule_requested_at");
                int d024 = m.h.d0(b, "run_in_foreground");
                int i3 = d014;
                ArrayList arrayList = new ArrayList(b.getCount());
                while (b.moveToNext()) {
                    String string = b.getString(d09);
                    String string2 = b.getString(d011);
                    c cVar = new c();
                    cVar.a = m.h.w0(b.getInt(d0));
                    cVar.b = b.getInt(d02) != 0;
                    cVar.c = b.getInt(d03) != 0;
                    cVar.f1861d = b.getInt(d04) != 0;
                    cVar.f1862e = b.getInt(d05) != 0;
                    cVar.f1863f = b.getLong(d06);
                    cVar.f1864g = b.getLong(d07);
                    cVar.f1865h = m.h.f(b.getBlob(d08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.x0(b.getInt(d010));
                    oVar.f1988d = b.getString(d012);
                    oVar.f1989e = e.b(b.getBlob(d013));
                    oVar.f1990f = e.b(b.getBlob(i3));
                    i3 = i3;
                    oVar.f1991g = b.getLong(d015);
                    oVar.f1992h = b.getLong(d016);
                    oVar.f1993i = b.getLong(d017);
                    oVar.f1995k = b.getInt(d018);
                    oVar.f1996l = m.h.v0(b.getInt(d019));
                    d017 = d017;
                    oVar.m = b.getLong(d020);
                    oVar.n = b.getLong(d021);
                    d021 = d021;
                    oVar.o = b.getLong(d022);
                    d022 = d022;
                    oVar.p = b.getLong(d023);
                    oVar.q = b.getInt(d024) != 0;
                    oVar.f1994j = cVar;
                    arrayList.add(oVar);
                    d023 = d023;
                    d024 = d024;
                    d02 = d02;
                    d010 = d010;
                    d012 = d012;
                    d011 = d011;
                    d03 = d03;
                    d0 = d0;
                    d015 = d015;
                    d09 = d09;
                    d020 = d020;
                    d013 = d013;
                    d016 = d016;
                    d018 = d018;
                    d019 = d019;
                }
                b.close();
                iVar.Q();
                q qVar2 = (q) r;
                List<o> e2 = qVar2.e();
                List<o> b2 = qVar2.b(200);
                if (!arrayList.isEmpty()) {
                    l c = l.c();
                    String str = f322f;
                    i2 = 0;
                    c.d(str, "Recently completed work:\n\n", new Throwable[0]);
                    hVar = o;
                    kVar = p;
                    sVar = s;
                    l.c().d(str, h(kVar, sVar, hVar, arrayList), new Throwable[0]);
                } else {
                    hVar = o;
                    kVar = p;
                    sVar = s;
                    i2 = 0;
                }
                if (!((ArrayList) e2).isEmpty()) {
                    l c2 = l.c();
                    String str2 = f322f;
                    c2.d(str2, "Running work:\n\n", new Throwable[i2]);
                    l.c().d(str2, h(kVar, sVar, hVar, e2), new Throwable[i2]);
                }
                if (!((ArrayList) b2).isEmpty()) {
                    l c3 = l.c();
                    String str3 = f322f;
                    c3.d(str3, "Enqueued work:\n\n", new Throwable[i2]);
                    l.c().d(str3, h(kVar, sVar, hVar, b2), new Throwable[i2]);
                }
                return new ListenableWorker.a.c();
            } catch (Throwable th2) {
                th = th2;
                b.close();
                iVar.Q();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = t;
            b.close();
            iVar.Q();
            throw th;
        }
    }
}
