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
import e.b0.a0.s.g;
import e.b0.a0.s.h;
import e.b0.a0.s.i;
import e.b0.a0.s.k;
import e.b0.a0.s.l;
import e.b0.a0.s.o;
import e.b0.a0.s.p;
import e.b0.a0.s.q;
import e.b0.a0.s.s;
import e.b0.a0.s.t;
import e.b0.d;
import e.b0.f;
import e.b0.n;
import e.u.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {

    /* renamed from: h  reason: collision with root package name */
    public static final String f326h = n.e("DiagnosticsWrkr");

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
            l lVar = (l) kVar;
            Objects.requireNonNull(lVar);
            e.u.i t = e.u.i.t("SELECT name FROM workname WHERE work_spec_id=?", 1);
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
        e.u.i iVar;
        Throwable th;
        h hVar;
        s sVar;
        k kVar;
        int i2;
        WorkDatabase workDatabase = e.b0.a0.l.g(this.b).c;
        p r = workDatabase.r();
        k p = workDatabase.p();
        s s = workDatabase.s();
        h o = workDatabase.o();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);
        q qVar = (q) r;
        Objects.requireNonNull(qVar);
        e.u.i t = e.u.i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        t.x(1, currentTimeMillis);
        qVar.a.b();
        Cursor b = b.b(qVar.a, t, false, null);
        try {
            int g0 = m.e.g0(b, "required_network_type");
            int g02 = m.e.g0(b, "requires_charging");
            int g03 = m.e.g0(b, "requires_device_idle");
            int g04 = m.e.g0(b, "requires_battery_not_low");
            int g05 = m.e.g0(b, "requires_storage_not_low");
            int g06 = m.e.g0(b, "trigger_content_update_delay");
            int g07 = m.e.g0(b, "trigger_max_content_delay");
            int g08 = m.e.g0(b, "content_uri_triggers");
            int g09 = m.e.g0(b, "id");
            int g010 = m.e.g0(b, "state");
            int g011 = m.e.g0(b, "worker_class_name");
            int g012 = m.e.g0(b, "input_merger_class_name");
            int g013 = m.e.g0(b, "input");
            int g014 = m.e.g0(b, "output");
            iVar = t;
            try {
                int g015 = m.e.g0(b, "initial_delay");
                int g016 = m.e.g0(b, "interval_duration");
                int g017 = m.e.g0(b, "flex_duration");
                int g018 = m.e.g0(b, "run_attempt_count");
                int g019 = m.e.g0(b, "backoff_policy");
                int g020 = m.e.g0(b, "backoff_delay_duration");
                int g021 = m.e.g0(b, "period_start_time");
                int g022 = m.e.g0(b, "minimum_retention_duration");
                int g023 = m.e.g0(b, "schedule_requested_at");
                int g024 = m.e.g0(b, "run_in_foreground");
                int g025 = m.e.g0(b, "out_of_quota_policy");
                int i3 = g014;
                ArrayList arrayList = new ArrayList(b.getCount());
                while (b.moveToNext()) {
                    String string = b.getString(g09);
                    String string2 = b.getString(g011);
                    d dVar = new d();
                    dVar.a = m.e.F0(b.getInt(g0));
                    dVar.b = b.getInt(g02) != 0;
                    dVar.c = b.getInt(g03) != 0;
                    dVar.f1162d = b.getInt(g04) != 0;
                    dVar.f1163e = b.getInt(g05) != 0;
                    dVar.f1164f = b.getLong(g06);
                    dVar.f1165g = b.getLong(g07);
                    dVar.f1166h = m.e.f(b.getBlob(g08));
                    o oVar = new o(string, string2);
                    oVar.b = m.e.H0(b.getInt(g010));
                    oVar.f1112d = b.getString(g012);
                    oVar.f1113e = f.b(b.getBlob(g013));
                    oVar.f1114f = f.b(b.getBlob(i3));
                    i3 = i3;
                    oVar.f1115g = b.getLong(g015);
                    oVar.f1116h = b.getLong(g016);
                    oVar.f1117i = b.getLong(g017);
                    oVar.f1119k = b.getInt(g018);
                    oVar.f1120l = m.e.E0(b.getInt(g019));
                    g017 = g017;
                    oVar.m = b.getLong(g020);
                    oVar.n = b.getLong(g021);
                    g021 = g021;
                    oVar.o = b.getLong(g022);
                    g022 = g022;
                    oVar.p = b.getLong(g023);
                    oVar.q = b.getInt(g024) != 0;
                    oVar.r = m.e.G0(b.getInt(g025));
                    oVar.f1118j = dVar;
                    arrayList.add(oVar);
                    g025 = g025;
                    g02 = g02;
                    g010 = g010;
                    g012 = g012;
                    g023 = g023;
                    g011 = g011;
                    g03 = g03;
                    g0 = g0;
                    g024 = g024;
                    g015 = g015;
                    g09 = g09;
                    g020 = g020;
                    g013 = g013;
                    g016 = g016;
                    g018 = g018;
                    g019 = g019;
                }
                b.close();
                iVar.Q();
                q qVar2 = (q) r;
                List<o> e2 = qVar2.e();
                List<o> b2 = qVar2.b(200);
                if (!arrayList.isEmpty()) {
                    n c = n.c();
                    String str = f326h;
                    i2 = 0;
                    c.d(str, "Recently completed work:\n\n", new Throwable[0]);
                    hVar = o;
                    kVar = p;
                    sVar = s;
                    n.c().d(str, h(kVar, sVar, hVar, arrayList), new Throwable[0]);
                } else {
                    hVar = o;
                    kVar = p;
                    sVar = s;
                    i2 = 0;
                }
                if (!((ArrayList) e2).isEmpty()) {
                    n c2 = n.c();
                    String str2 = f326h;
                    c2.d(str2, "Running work:\n\n", new Throwable[i2]);
                    n.c().d(str2, h(kVar, sVar, hVar, e2), new Throwable[i2]);
                }
                if (!((ArrayList) b2).isEmpty()) {
                    n c3 = n.c();
                    String str3 = f326h;
                    c3.d(str3, "Enqueued work:\n\n", new Throwable[i2]);
                    n.c().d(str3, h(kVar, sVar, hVar, b2), new Throwable[i2]);
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
