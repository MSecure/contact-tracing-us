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
import e.c0.a0.s.g;
import e.c0.a0.s.h;
import e.c0.a0.s.i;
import e.c0.a0.s.k;
import e.c0.a0.s.l;
import e.c0.a0.s.o;
import e.c0.a0.s.p;
import e.c0.a0.s.q;
import e.c0.a0.s.s;
import e.c0.a0.s.t;
import e.c0.d;
import e.c0.f;
import e.c0.n;
import e.v.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {

    /* renamed from: h  reason: collision with root package name */
    public static final String f326h = n.e("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX WARN: Finally extract failed */
    public static String h(k kVar, s sVar, h hVar, List<o> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        for (o oVar : list) {
            g a = ((i) hVar).a(oVar.a);
            Integer valueOf = a != null ? Integer.valueOf(a.b) : null;
            String str = oVar.a;
            l lVar = (l) kVar;
            Objects.requireNonNull(lVar);
            e.v.i t = e.v.i.t("SELECT name FROM workname WHERE work_spec_id=?", 1);
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
        e.v.i iVar;
        Throwable th;
        h hVar;
        s sVar;
        k kVar;
        int i2;
        WorkDatabase workDatabase = e.c0.a0.l.h(this.b).c;
        p r = workDatabase.r();
        k p = workDatabase.p();
        s s = workDatabase.s();
        h o = workDatabase.o();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);
        q qVar = (q) r;
        Objects.requireNonNull(qVar);
        e.v.i t = e.v.i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        t.x(1, currentTimeMillis);
        qVar.a.b();
        Cursor b = b.b(qVar.a, t, false, null);
        try {
            int h0 = m.e.h0(b, "required_network_type");
            int h02 = m.e.h0(b, "requires_charging");
            int h03 = m.e.h0(b, "requires_device_idle");
            int h04 = m.e.h0(b, "requires_battery_not_low");
            int h05 = m.e.h0(b, "requires_storage_not_low");
            int h06 = m.e.h0(b, "trigger_content_update_delay");
            int h07 = m.e.h0(b, "trigger_max_content_delay");
            int h08 = m.e.h0(b, "content_uri_triggers");
            int h09 = m.e.h0(b, "id");
            int h010 = m.e.h0(b, "state");
            int h011 = m.e.h0(b, "worker_class_name");
            int h012 = m.e.h0(b, "input_merger_class_name");
            int h013 = m.e.h0(b, "input");
            int h014 = m.e.h0(b, "output");
            iVar = t;
            try {
                int h015 = m.e.h0(b, "initial_delay");
                int h016 = m.e.h0(b, "interval_duration");
                int h017 = m.e.h0(b, "flex_duration");
                int h018 = m.e.h0(b, "run_attempt_count");
                int h019 = m.e.h0(b, "backoff_policy");
                int h020 = m.e.h0(b, "backoff_delay_duration");
                int h021 = m.e.h0(b, "period_start_time");
                int h022 = m.e.h0(b, "minimum_retention_duration");
                int h023 = m.e.h0(b, "schedule_requested_at");
                int h024 = m.e.h0(b, "run_in_foreground");
                int h025 = m.e.h0(b, "out_of_quota_policy");
                ArrayList arrayList = new ArrayList(b.getCount());
                while (b.moveToNext()) {
                    String string = b.getString(h09);
                    String string2 = b.getString(h011);
                    d dVar = new d();
                    dVar.a = m.e.H0(b.getInt(h0));
                    dVar.b = b.getInt(h02) != 0;
                    dVar.c = b.getInt(h03) != 0;
                    dVar.f1241d = b.getInt(h04) != 0;
                    dVar.f1242e = b.getInt(h05) != 0;
                    dVar.f1243f = b.getLong(h06);
                    dVar.f1244g = b.getLong(h07);
                    dVar.f1245h = m.e.f(b.getBlob(h08));
                    o oVar = new o(string, string2);
                    oVar.b = m.e.J0(b.getInt(h010));
                    oVar.f1191d = b.getString(h012);
                    oVar.f1192e = f.b(b.getBlob(h013));
                    oVar.f1193f = f.b(b.getBlob(h014));
                    h014 = h014;
                    oVar.f1194g = b.getLong(h015);
                    oVar.f1195h = b.getLong(h016);
                    oVar.f1196i = b.getLong(h017);
                    oVar.f1198k = b.getInt(h018);
                    oVar.f1199l = m.e.G0(b.getInt(h019));
                    h017 = h017;
                    oVar.m = b.getLong(h020);
                    oVar.n = b.getLong(h021);
                    h021 = h021;
                    oVar.o = b.getLong(h022);
                    h022 = h022;
                    oVar.p = b.getLong(h023);
                    oVar.q = b.getInt(h024) != 0;
                    oVar.r = m.e.I0(b.getInt(h025));
                    oVar.f1197j = dVar;
                    arrayList.add(oVar);
                    h025 = h025;
                    h02 = h02;
                    h010 = h010;
                    h012 = h012;
                    h023 = h023;
                    h011 = h011;
                    h03 = h03;
                    h0 = h0;
                    h024 = h024;
                    h015 = h015;
                    h09 = h09;
                    h020 = h020;
                    h013 = h013;
                    h016 = h016;
                    h018 = h018;
                    h019 = h019;
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
        }
    }
}
