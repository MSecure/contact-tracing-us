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
import e.c0.c;
import e.c0.e;
import e.c0.l;
import e.c0.x.s.g;
import e.c0.x.s.h;
import e.c0.x.s.i;
import e.c0.x.s.k;
import e.c0.x.s.o;
import e.c0.x.s.p;
import e.c0.x.s.q;
import e.c0.x.s.s;
import e.c0.x.s.t;
import e.t.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {

    /* renamed from: f  reason: collision with root package name */
    public static final String f334f = l.e("DiagnosticsWrkr");

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
            e.c0.x.s.l lVar = (e.c0.x.s.l) kVar;
            Objects.requireNonNull(lVar);
            e.t.i v = e.t.i.v("SELECT name FROM workname WHERE work_spec_id=?", 1);
            if (str == null) {
                v.N(1);
            } else {
                v.P(1, str);
            }
            lVar.a.b();
            Cursor b = b.b(lVar.a, v, false, null);
            try {
                ArrayList arrayList = new ArrayList(b.getCount());
                while (b.moveToNext()) {
                    arrayList.add(b.getString(0));
                }
                b.close();
                v.V();
                sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", oVar.a, oVar.c, valueOf, oVar.b.name(), TextUtils.join(",", arrayList), TextUtils.join(",", ((t) sVar).a(oVar.a))));
            } catch (Throwable th) {
                b.close();
                v.V();
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
        WorkDatabase workDatabase = e.c0.x.l.d(this.b).c;
        p r = workDatabase.r();
        k p = workDatabase.p();
        s s = workDatabase.s();
        h o = workDatabase.o();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);
        q qVar = (q) r;
        Objects.requireNonNull(qVar);
        e.t.i v = e.t.i.v("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        v.A(1, currentTimeMillis);
        qVar.a.b();
        Cursor b = b.b(qVar.a, v, false, null);
        try {
            int b0 = m.h.b0(b, "required_network_type");
            int b02 = m.h.b0(b, "requires_charging");
            int b03 = m.h.b0(b, "requires_device_idle");
            int b04 = m.h.b0(b, "requires_battery_not_low");
            int b05 = m.h.b0(b, "requires_storage_not_low");
            int b06 = m.h.b0(b, "trigger_content_update_delay");
            int b07 = m.h.b0(b, "trigger_max_content_delay");
            int b08 = m.h.b0(b, "content_uri_triggers");
            int b09 = m.h.b0(b, "id");
            int b010 = m.h.b0(b, "state");
            int b011 = m.h.b0(b, "worker_class_name");
            int b012 = m.h.b0(b, "input_merger_class_name");
            int b013 = m.h.b0(b, "input");
            int b014 = m.h.b0(b, "output");
            iVar = v;
            try {
                int b015 = m.h.b0(b, "initial_delay");
                int b016 = m.h.b0(b, "interval_duration");
                int b017 = m.h.b0(b, "flex_duration");
                int b018 = m.h.b0(b, "run_attempt_count");
                int b019 = m.h.b0(b, "backoff_policy");
                int b020 = m.h.b0(b, "backoff_delay_duration");
                int b021 = m.h.b0(b, "period_start_time");
                int b022 = m.h.b0(b, "minimum_retention_duration");
                int b023 = m.h.b0(b, "schedule_requested_at");
                int b024 = m.h.b0(b, "run_in_foreground");
                int i3 = b014;
                ArrayList arrayList = new ArrayList(b.getCount());
                while (b.moveToNext()) {
                    String string = b.getString(b09);
                    String string2 = b.getString(b011);
                    c cVar = new c();
                    cVar.a = m.h.u0(b.getInt(b0));
                    cVar.b = b.getInt(b02) != 0;
                    cVar.c = b.getInt(b03) != 0;
                    cVar.f1006d = b.getInt(b04) != 0;
                    cVar.f1007e = b.getInt(b05) != 0;
                    cVar.f1008f = b.getLong(b06);
                    cVar.f1009g = b.getLong(b07);
                    cVar.f1010h = m.h.f(b.getBlob(b08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.v0(b.getInt(b010));
                    oVar.f1133d = b.getString(b012);
                    oVar.f1134e = e.a(b.getBlob(b013));
                    oVar.f1135f = e.a(b.getBlob(i3));
                    i3 = i3;
                    oVar.f1136g = b.getLong(b015);
                    oVar.f1137h = b.getLong(b016);
                    oVar.f1138i = b.getLong(b017);
                    oVar.f1140k = b.getInt(b018);
                    oVar.f1141l = m.h.t0(b.getInt(b019));
                    b017 = b017;
                    oVar.m = b.getLong(b020);
                    oVar.n = b.getLong(b021);
                    b021 = b021;
                    oVar.o = b.getLong(b022);
                    b022 = b022;
                    oVar.p = b.getLong(b023);
                    oVar.q = b.getInt(b024) != 0;
                    oVar.f1139j = cVar;
                    arrayList.add(oVar);
                    b023 = b023;
                    b024 = b024;
                    b02 = b02;
                    b010 = b010;
                    b012 = b012;
                    b011 = b011;
                    b03 = b03;
                    b0 = b0;
                    b015 = b015;
                    b09 = b09;
                    b020 = b020;
                    b013 = b013;
                    b016 = b016;
                    b018 = b018;
                    b019 = b019;
                }
                b.close();
                iVar.V();
                q qVar2 = (q) r;
                List<o> e2 = qVar2.e();
                List<o> b2 = qVar2.b(200);
                if (!arrayList.isEmpty()) {
                    l c = l.c();
                    String str = f334f;
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
                    String str2 = f334f;
                    c2.d(str2, "Running work:\n\n", new Throwable[i2]);
                    l.c().d(str2, h(kVar, sVar, hVar, e2), new Throwable[i2]);
                }
                if (!((ArrayList) b2).isEmpty()) {
                    l c3 = l.c();
                    String str3 = f334f;
                    c3.d(str3, "Enqueued work:\n\n", new Throwable[i2]);
                    l.c().d(str3, h(kVar, sVar, hVar, b2), new Throwable[i2]);
                }
                return new ListenableWorker.a.c();
            } catch (Throwable th2) {
                th = th2;
                b.close();
                iVar.V();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = v;
            b.close();
            iVar.V();
            throw th;
        }
    }
}
