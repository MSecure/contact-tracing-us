package e.b0.a0.s;

import android.database.Cursor;
import android.os.Build;
import e.b.a.m;
import e.b0.a0.s.o;
import e.b0.e;
import e.b0.o;
import e.b0.r;
import e.b0.v;
import e.u.i;
import e.u.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class q implements p {
    public final e.u.g a;
    public final e.u.b<o> b;
    public final l c;

    /* renamed from: d  reason: collision with root package name */
    public final l f1121d;

    /* renamed from: e  reason: collision with root package name */
    public final l f1122e;

    /* renamed from: f  reason: collision with root package name */
    public final l f1123f;

    /* renamed from: g  reason: collision with root package name */
    public final l f1124g;

    /* renamed from: h  reason: collision with root package name */
    public final l f1125h;

    /* renamed from: i  reason: collision with root package name */
    public final l f1126i;

    public class a extends e.u.b<o> {
        public a(q qVar, e.u.g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x01ea  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x020a  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0216 A[SYNTHETIC, Splitter:B:87:0x0216] */
        @Override // e.u.b
        public void d(e.w.a.f.f fVar, o oVar) {
            int i2;
            int i3;
            Throwable th;
            IOException e2;
            o oVar2 = oVar;
            String str = oVar2.a;
            int i4 = 1;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            fVar.b.bindLong(2, (long) m.e.D1(oVar2.b));
            String str2 = oVar2.c;
            if (str2 == null) {
                fVar.b.bindNull(3);
            } else {
                fVar.b.bindString(3, str2);
            }
            String str3 = oVar2.f1112d;
            if (str3 == null) {
                fVar.b.bindNull(4);
            } else {
                fVar.b.bindString(4, str3);
            }
            byte[] c = e.b0.f.c(oVar2.f1113e);
            if (c == null) {
                fVar.b.bindNull(5);
            } else {
                fVar.b.bindBlob(5, c);
            }
            byte[] c2 = e.b0.f.c(oVar2.f1114f);
            if (c2 == null) {
                fVar.b.bindNull(6);
            } else {
                fVar.b.bindBlob(6, c2);
            }
            fVar.b.bindLong(7, oVar2.f1115g);
            fVar.b.bindLong(8, oVar2.f1116h);
            fVar.b.bindLong(9, oVar2.f1117i);
            fVar.b.bindLong(10, (long) oVar2.f1119k);
            e.b0.a aVar = oVar2.f1120l;
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                i2 = 0;
            } else if (ordinal == 1) {
                i2 = 1;
            } else {
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
            }
            fVar.b.bindLong(11, (long) i2);
            fVar.b.bindLong(12, oVar2.m);
            fVar.b.bindLong(13, oVar2.n);
            fVar.b.bindLong(14, oVar2.o);
            fVar.b.bindLong(15, oVar2.p);
            fVar.b.bindLong(16, oVar2.q ? 1 : 0);
            r rVar = oVar2.r;
            int ordinal2 = rVar.ordinal();
            if (ordinal2 == 0) {
                i3 = 0;
            } else if (ordinal2 == 1) {
                i3 = 1;
            } else {
                throw new IllegalArgumentException("Could not convert " + rVar + " to int");
            }
            fVar.b.bindLong(17, (long) i3);
            e.b0.d dVar = oVar2.f1118j;
            if (dVar != null) {
                o oVar3 = dVar.a;
                int ordinal3 = oVar3.ordinal();
                if (ordinal3 == 0) {
                    i4 = 0;
                } else if (ordinal3 != 1) {
                    if (ordinal3 == 2) {
                        i4 = 2;
                    } else if (ordinal3 == 3) {
                        i4 = 3;
                    } else if (ordinal3 == 4) {
                        i4 = 4;
                    } else if (Build.VERSION.SDK_INT < 30 || oVar3 != o.TEMPORARILY_UNMETERED) {
                        throw new IllegalArgumentException("Could not convert " + oVar3 + " to int");
                    } else {
                        i4 = 5;
                    }
                }
                fVar.b.bindLong(18, (long) i4);
                fVar.b.bindLong(19, dVar.b ? 1 : 0);
                fVar.b.bindLong(20, dVar.c ? 1 : 0);
                fVar.b.bindLong(21, dVar.f1162d ? 1 : 0);
                fVar.b.bindLong(22, dVar.f1163e ? 1 : 0);
                fVar.b.bindLong(23, dVar.f1164f);
                fVar.b.bindLong(24, dVar.f1165g);
                e.b0.e eVar = dVar.f1166h;
                byte[] bArr = null;
                ObjectOutputStream objectOutputStream = null;
                if (eVar.a() != 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream2.writeInt(eVar.a());
                            for (e.a aVar2 : eVar.a) {
                                objectOutputStream2.writeUTF(aVar2.a.toString());
                                objectOutputStream2.writeBoolean(aVar2.b);
                            }
                            try {
                                objectOutputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        } catch (IOException e4) {
                            e2 = e4;
                            objectOutputStream = objectOutputStream2;
                            try {
                                e2.printStackTrace();
                                if (objectOutputStream != null) {
                                }
                                byteArrayOutputStream.close();
                                bArr = byteArrayOutputStream.toByteArray();
                                if (bArr == null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (objectOutputStream2 != null) {
                            }
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } catch (IOException e7) {
                        e2 = e7;
                        e2.printStackTrace();
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        byteArrayOutputStream.close();
                        bArr = byteArrayOutputStream.toByteArray();
                        if (bArr == null) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                }
                if (bArr == null) {
                    fVar.b.bindNull(25);
                } else {
                    fVar.b.bindBlob(25, bArr);
                }
            } else {
                fVar.b.bindNull(18);
                fVar.b.bindNull(19);
                fVar.b.bindNull(20);
                fVar.b.bindNull(21);
                fVar.b.bindNull(22);
                fVar.b.bindNull(23);
                fVar.b.bindNull(24);
                fVar.b.bindNull(25);
            }
        }
    }

    public class b extends l {
        public b(q qVar, e.u.g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class c extends l {
        public c(q qVar, e.u.g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class d extends l {
        public d(q qVar, e.u.g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    public class e extends l {
        public e(q qVar, e.u.g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class f extends l {
        public f(q qVar, e.u.g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public class g extends l {
        public g(q qVar, e.u.g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class h extends l {
        public h(q qVar, e.u.g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public q(e.u.g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f1121d = new c(this, gVar);
        this.f1122e = new d(this, gVar);
        this.f1123f = new e(this, gVar);
        this.f1124g = new f(this, gVar);
        this.f1125h = new g(this, gVar);
        this.f1126i = new h(this, gVar);
        new AtomicBoolean(false);
    }

    public void a(String str) {
        this.a.b();
        e.w.a.f.f a2 = this.c.a();
        if (str == null) {
            a2.b.bindNull(1);
        } else {
            a2.b.bindString(1, str);
        }
        this.a.c();
        try {
            a2.d();
            this.a.l();
            this.a.g();
            l lVar = this.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        } catch (Throwable th) {
            this.a.g();
            this.c.c(a2);
            throw th;
        }
    }

    public List<o> b(int i2) {
        i iVar;
        Throwable th;
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        t.x(1, (long) i2);
        this.a.b();
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            int g0 = m.e.g0(b2, "required_network_type");
            int g02 = m.e.g0(b2, "requires_charging");
            int g03 = m.e.g0(b2, "requires_device_idle");
            int g04 = m.e.g0(b2, "requires_battery_not_low");
            int g05 = m.e.g0(b2, "requires_storage_not_low");
            int g06 = m.e.g0(b2, "trigger_content_update_delay");
            int g07 = m.e.g0(b2, "trigger_max_content_delay");
            int g08 = m.e.g0(b2, "content_uri_triggers");
            int g09 = m.e.g0(b2, "id");
            int g010 = m.e.g0(b2, "state");
            int g011 = m.e.g0(b2, "worker_class_name");
            int g012 = m.e.g0(b2, "input_merger_class_name");
            int g013 = m.e.g0(b2, "input");
            int g014 = m.e.g0(b2, "output");
            iVar = t;
            try {
                int g015 = m.e.g0(b2, "initial_delay");
                int g016 = m.e.g0(b2, "interval_duration");
                int g017 = m.e.g0(b2, "flex_duration");
                int g018 = m.e.g0(b2, "run_attempt_count");
                int g019 = m.e.g0(b2, "backoff_policy");
                int g020 = m.e.g0(b2, "backoff_delay_duration");
                int g021 = m.e.g0(b2, "period_start_time");
                int g022 = m.e.g0(b2, "minimum_retention_duration");
                int g023 = m.e.g0(b2, "schedule_requested_at");
                int g024 = m.e.g0(b2, "run_in_foreground");
                int g025 = m.e.g0(b2, "out_of_quota_policy");
                int i3 = g014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(g09);
                    String string2 = b2.getString(g011);
                    e.b0.d dVar = new e.b0.d();
                    dVar.a = m.e.F0(b2.getInt(g0));
                    dVar.b = b2.getInt(g02) != 0;
                    dVar.c = b2.getInt(g03) != 0;
                    dVar.f1162d = b2.getInt(g04) != 0;
                    dVar.f1163e = b2.getInt(g05) != 0;
                    dVar.f1164f = b2.getLong(g06);
                    dVar.f1165g = b2.getLong(g07);
                    dVar.f1166h = m.e.f(b2.getBlob(g08));
                    o oVar = new o(string, string2);
                    oVar.b = m.e.H0(b2.getInt(g010));
                    oVar.f1112d = b2.getString(g012);
                    oVar.f1113e = e.b0.f.b(b2.getBlob(g013));
                    oVar.f1114f = e.b0.f.b(b2.getBlob(i3));
                    i3 = i3;
                    oVar.f1115g = b2.getLong(g015);
                    oVar.f1116h = b2.getLong(g016);
                    oVar.f1117i = b2.getLong(g017);
                    oVar.f1119k = b2.getInt(g018);
                    oVar.f1120l = m.e.E0(b2.getInt(g019));
                    g017 = g017;
                    oVar.m = b2.getLong(g020);
                    oVar.n = b2.getLong(g021);
                    g021 = g021;
                    oVar.o = b2.getLong(g022);
                    oVar.p = b2.getLong(g023);
                    oVar.q = b2.getInt(g024) != 0;
                    oVar.r = m.e.G0(b2.getInt(g025));
                    oVar.f1118j = dVar;
                    arrayList.add(oVar);
                    g025 = g025;
                    g02 = g02;
                    g012 = g012;
                    g015 = g015;
                    g016 = g016;
                    g018 = g018;
                    g023 = g023;
                    g09 = g09;
                    g011 = g011;
                    g0 = g0;
                    g024 = g024;
                    g022 = g022;
                    g03 = g03;
                    g020 = g020;
                    g04 = g04;
                    g019 = g019;
                }
                b2.close();
                iVar.Q();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.Q();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = t;
            b2.close();
            iVar.Q();
            throw th;
        }
    }

    public List<String> c() {
        i t = i.t("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.a.b();
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            t.Q();
        }
    }

    public List<o> d(int i2) {
        i iVar;
        Throwable th;
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        t.x(1, (long) i2);
        this.a.b();
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            int g0 = m.e.g0(b2, "required_network_type");
            int g02 = m.e.g0(b2, "requires_charging");
            int g03 = m.e.g0(b2, "requires_device_idle");
            int g04 = m.e.g0(b2, "requires_battery_not_low");
            int g05 = m.e.g0(b2, "requires_storage_not_low");
            int g06 = m.e.g0(b2, "trigger_content_update_delay");
            int g07 = m.e.g0(b2, "trigger_max_content_delay");
            int g08 = m.e.g0(b2, "content_uri_triggers");
            int g09 = m.e.g0(b2, "id");
            int g010 = m.e.g0(b2, "state");
            int g011 = m.e.g0(b2, "worker_class_name");
            int g012 = m.e.g0(b2, "input_merger_class_name");
            int g013 = m.e.g0(b2, "input");
            int g014 = m.e.g0(b2, "output");
            iVar = t;
            try {
                int g015 = m.e.g0(b2, "initial_delay");
                int g016 = m.e.g0(b2, "interval_duration");
                int g017 = m.e.g0(b2, "flex_duration");
                int g018 = m.e.g0(b2, "run_attempt_count");
                int g019 = m.e.g0(b2, "backoff_policy");
                int g020 = m.e.g0(b2, "backoff_delay_duration");
                int g021 = m.e.g0(b2, "period_start_time");
                int g022 = m.e.g0(b2, "minimum_retention_duration");
                int g023 = m.e.g0(b2, "schedule_requested_at");
                int g024 = m.e.g0(b2, "run_in_foreground");
                int g025 = m.e.g0(b2, "out_of_quota_policy");
                int i3 = g014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(g09);
                    String string2 = b2.getString(g011);
                    e.b0.d dVar = new e.b0.d();
                    dVar.a = m.e.F0(b2.getInt(g0));
                    dVar.b = b2.getInt(g02) != 0;
                    dVar.c = b2.getInt(g03) != 0;
                    dVar.f1162d = b2.getInt(g04) != 0;
                    dVar.f1163e = b2.getInt(g05) != 0;
                    dVar.f1164f = b2.getLong(g06);
                    dVar.f1165g = b2.getLong(g07);
                    dVar.f1166h = m.e.f(b2.getBlob(g08));
                    o oVar = new o(string, string2);
                    oVar.b = m.e.H0(b2.getInt(g010));
                    oVar.f1112d = b2.getString(g012);
                    oVar.f1113e = e.b0.f.b(b2.getBlob(g013));
                    oVar.f1114f = e.b0.f.b(b2.getBlob(i3));
                    i3 = i3;
                    oVar.f1115g = b2.getLong(g015);
                    oVar.f1116h = b2.getLong(g016);
                    oVar.f1117i = b2.getLong(g017);
                    oVar.f1119k = b2.getInt(g018);
                    oVar.f1120l = m.e.E0(b2.getInt(g019));
                    g017 = g017;
                    oVar.m = b2.getLong(g020);
                    oVar.n = b2.getLong(g021);
                    g021 = g021;
                    oVar.o = b2.getLong(g022);
                    oVar.p = b2.getLong(g023);
                    oVar.q = b2.getInt(g024) != 0;
                    oVar.r = m.e.G0(b2.getInt(g025));
                    oVar.f1118j = dVar;
                    arrayList.add(oVar);
                    g025 = g025;
                    g02 = g02;
                    g012 = g012;
                    g015 = g015;
                    g016 = g016;
                    g018 = g018;
                    g023 = g023;
                    g09 = g09;
                    g011 = g011;
                    g0 = g0;
                    g024 = g024;
                    g022 = g022;
                    g03 = g03;
                    g020 = g020;
                    g04 = g04;
                    g019 = g019;
                }
                b2.close();
                iVar.Q();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.Q();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = t;
            b2.close();
            iVar.Q();
            throw th;
        }
    }

    public List<o> e() {
        i iVar;
        Throwable th;
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.a.b();
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            int g0 = m.e.g0(b2, "required_network_type");
            int g02 = m.e.g0(b2, "requires_charging");
            int g03 = m.e.g0(b2, "requires_device_idle");
            int g04 = m.e.g0(b2, "requires_battery_not_low");
            int g05 = m.e.g0(b2, "requires_storage_not_low");
            int g06 = m.e.g0(b2, "trigger_content_update_delay");
            int g07 = m.e.g0(b2, "trigger_max_content_delay");
            int g08 = m.e.g0(b2, "content_uri_triggers");
            int g09 = m.e.g0(b2, "id");
            int g010 = m.e.g0(b2, "state");
            int g011 = m.e.g0(b2, "worker_class_name");
            int g012 = m.e.g0(b2, "input_merger_class_name");
            int g013 = m.e.g0(b2, "input");
            int g014 = m.e.g0(b2, "output");
            iVar = t;
            try {
                int g015 = m.e.g0(b2, "initial_delay");
                int g016 = m.e.g0(b2, "interval_duration");
                int g017 = m.e.g0(b2, "flex_duration");
                int g018 = m.e.g0(b2, "run_attempt_count");
                int g019 = m.e.g0(b2, "backoff_policy");
                int g020 = m.e.g0(b2, "backoff_delay_duration");
                int g021 = m.e.g0(b2, "period_start_time");
                int g022 = m.e.g0(b2, "minimum_retention_duration");
                int g023 = m.e.g0(b2, "schedule_requested_at");
                int g024 = m.e.g0(b2, "run_in_foreground");
                int g025 = m.e.g0(b2, "out_of_quota_policy");
                int i2 = g014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(g09);
                    String string2 = b2.getString(g011);
                    e.b0.d dVar = new e.b0.d();
                    dVar.a = m.e.F0(b2.getInt(g0));
                    dVar.b = b2.getInt(g02) != 0;
                    dVar.c = b2.getInt(g03) != 0;
                    dVar.f1162d = b2.getInt(g04) != 0;
                    dVar.f1163e = b2.getInt(g05) != 0;
                    dVar.f1164f = b2.getLong(g06);
                    dVar.f1165g = b2.getLong(g07);
                    dVar.f1166h = m.e.f(b2.getBlob(g08));
                    o oVar = new o(string, string2);
                    oVar.b = m.e.H0(b2.getInt(g010));
                    oVar.f1112d = b2.getString(g012);
                    oVar.f1113e = e.b0.f.b(b2.getBlob(g013));
                    oVar.f1114f = e.b0.f.b(b2.getBlob(i2));
                    i2 = i2;
                    oVar.f1115g = b2.getLong(g015);
                    oVar.f1116h = b2.getLong(g016);
                    oVar.f1117i = b2.getLong(g017);
                    oVar.f1119k = b2.getInt(g018);
                    oVar.f1120l = m.e.E0(b2.getInt(g019));
                    g017 = g017;
                    oVar.m = b2.getLong(g020);
                    oVar.n = b2.getLong(g021);
                    g021 = g021;
                    oVar.o = b2.getLong(g022);
                    oVar.p = b2.getLong(g023);
                    oVar.q = b2.getInt(g024) != 0;
                    oVar.r = m.e.G0(b2.getInt(g025));
                    oVar.f1118j = dVar;
                    arrayList.add(oVar);
                    g025 = g025;
                    g02 = g02;
                    g013 = g013;
                    g015 = g015;
                    g016 = g016;
                    g018 = g018;
                    g023 = g023;
                    g09 = g09;
                    g011 = g011;
                    g0 = g0;
                    g024 = g024;
                    g022 = g022;
                    g03 = g03;
                    g020 = g020;
                    g04 = g04;
                    g019 = g019;
                }
                b2.close();
                iVar.Q();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.Q();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = t;
            b2.close();
            iVar.Q();
            throw th;
        }
    }

    public List<o> f() {
        i iVar;
        Throwable th;
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.b();
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            int g0 = m.e.g0(b2, "required_network_type");
            int g02 = m.e.g0(b2, "requires_charging");
            int g03 = m.e.g0(b2, "requires_device_idle");
            int g04 = m.e.g0(b2, "requires_battery_not_low");
            int g05 = m.e.g0(b2, "requires_storage_not_low");
            int g06 = m.e.g0(b2, "trigger_content_update_delay");
            int g07 = m.e.g0(b2, "trigger_max_content_delay");
            int g08 = m.e.g0(b2, "content_uri_triggers");
            int g09 = m.e.g0(b2, "id");
            int g010 = m.e.g0(b2, "state");
            int g011 = m.e.g0(b2, "worker_class_name");
            int g012 = m.e.g0(b2, "input_merger_class_name");
            int g013 = m.e.g0(b2, "input");
            int g014 = m.e.g0(b2, "output");
            iVar = t;
            try {
                int g015 = m.e.g0(b2, "initial_delay");
                int g016 = m.e.g0(b2, "interval_duration");
                int g017 = m.e.g0(b2, "flex_duration");
                int g018 = m.e.g0(b2, "run_attempt_count");
                int g019 = m.e.g0(b2, "backoff_policy");
                int g020 = m.e.g0(b2, "backoff_delay_duration");
                int g021 = m.e.g0(b2, "period_start_time");
                int g022 = m.e.g0(b2, "minimum_retention_duration");
                int g023 = m.e.g0(b2, "schedule_requested_at");
                int g024 = m.e.g0(b2, "run_in_foreground");
                int g025 = m.e.g0(b2, "out_of_quota_policy");
                int i2 = g014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(g09);
                    String string2 = b2.getString(g011);
                    e.b0.d dVar = new e.b0.d();
                    dVar.a = m.e.F0(b2.getInt(g0));
                    dVar.b = b2.getInt(g02) != 0;
                    dVar.c = b2.getInt(g03) != 0;
                    dVar.f1162d = b2.getInt(g04) != 0;
                    dVar.f1163e = b2.getInt(g05) != 0;
                    dVar.f1164f = b2.getLong(g06);
                    dVar.f1165g = b2.getLong(g07);
                    dVar.f1166h = m.e.f(b2.getBlob(g08));
                    o oVar = new o(string, string2);
                    oVar.b = m.e.H0(b2.getInt(g010));
                    oVar.f1112d = b2.getString(g012);
                    oVar.f1113e = e.b0.f.b(b2.getBlob(g013));
                    oVar.f1114f = e.b0.f.b(b2.getBlob(i2));
                    i2 = i2;
                    oVar.f1115g = b2.getLong(g015);
                    oVar.f1116h = b2.getLong(g016);
                    oVar.f1117i = b2.getLong(g017);
                    oVar.f1119k = b2.getInt(g018);
                    oVar.f1120l = m.e.E0(b2.getInt(g019));
                    g017 = g017;
                    oVar.m = b2.getLong(g020);
                    oVar.n = b2.getLong(g021);
                    g021 = g021;
                    oVar.o = b2.getLong(g022);
                    oVar.p = b2.getLong(g023);
                    oVar.q = b2.getInt(g024) != 0;
                    oVar.r = m.e.G0(b2.getInt(g025));
                    oVar.f1118j = dVar;
                    arrayList.add(oVar);
                    g025 = g025;
                    g02 = g02;
                    g013 = g013;
                    g015 = g015;
                    g016 = g016;
                    g018 = g018;
                    g023 = g023;
                    g09 = g09;
                    g011 = g011;
                    g0 = g0;
                    g024 = g024;
                    g022 = g022;
                    g03 = g03;
                    g020 = g020;
                    g04 = g04;
                    g019 = g019;
                }
                b2.close();
                iVar.Q();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.Q();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = t;
            b2.close();
            iVar.Q();
            throw th;
        }
    }

    public v g(String str) {
        i t = i.t("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        v vVar = null;
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            if (b2.moveToFirst()) {
                vVar = m.e.H0(b2.getInt(0));
            }
            return vVar;
        } finally {
            b2.close();
            t.Q();
        }
    }

    public List<String> h(String str) {
        i t = i.t("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            t.Q();
        }
    }

    public o i(String str) {
        i iVar;
        Throwable th;
        o oVar;
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            int g0 = m.e.g0(b2, "required_network_type");
            int g02 = m.e.g0(b2, "requires_charging");
            int g03 = m.e.g0(b2, "requires_device_idle");
            int g04 = m.e.g0(b2, "requires_battery_not_low");
            int g05 = m.e.g0(b2, "requires_storage_not_low");
            int g06 = m.e.g0(b2, "trigger_content_update_delay");
            int g07 = m.e.g0(b2, "trigger_max_content_delay");
            int g08 = m.e.g0(b2, "content_uri_triggers");
            int g09 = m.e.g0(b2, "id");
            int g010 = m.e.g0(b2, "state");
            int g011 = m.e.g0(b2, "worker_class_name");
            int g012 = m.e.g0(b2, "input_merger_class_name");
            int g013 = m.e.g0(b2, "input");
            int g014 = m.e.g0(b2, "output");
            iVar = t;
            try {
                int g015 = m.e.g0(b2, "initial_delay");
                int g016 = m.e.g0(b2, "interval_duration");
                int g017 = m.e.g0(b2, "flex_duration");
                int g018 = m.e.g0(b2, "run_attempt_count");
                int g019 = m.e.g0(b2, "backoff_policy");
                int g020 = m.e.g0(b2, "backoff_delay_duration");
                int g021 = m.e.g0(b2, "period_start_time");
                int g022 = m.e.g0(b2, "minimum_retention_duration");
                int g023 = m.e.g0(b2, "schedule_requested_at");
                int g024 = m.e.g0(b2, "run_in_foreground");
                int g025 = m.e.g0(b2, "out_of_quota_policy");
                if (b2.moveToFirst()) {
                    String string = b2.getString(g09);
                    String string2 = b2.getString(g011);
                    e.b0.d dVar = new e.b0.d();
                    dVar.a = m.e.F0(b2.getInt(g0));
                    dVar.b = b2.getInt(g02) != 0;
                    dVar.c = b2.getInt(g03) != 0;
                    dVar.f1162d = b2.getInt(g04) != 0;
                    dVar.f1163e = b2.getInt(g05) != 0;
                    dVar.f1164f = b2.getLong(g06);
                    dVar.f1165g = b2.getLong(g07);
                    dVar.f1166h = m.e.f(b2.getBlob(g08));
                    o oVar2 = new o(string, string2);
                    oVar2.b = m.e.H0(b2.getInt(g010));
                    oVar2.f1112d = b2.getString(g012);
                    oVar2.f1113e = e.b0.f.b(b2.getBlob(g013));
                    oVar2.f1114f = e.b0.f.b(b2.getBlob(g014));
                    oVar2.f1115g = b2.getLong(g015);
                    oVar2.f1116h = b2.getLong(g016);
                    oVar2.f1117i = b2.getLong(g017);
                    oVar2.f1119k = b2.getInt(g018);
                    oVar2.f1120l = m.e.E0(b2.getInt(g019));
                    oVar2.m = b2.getLong(g020);
                    oVar2.n = b2.getLong(g021);
                    oVar2.o = b2.getLong(g022);
                    oVar2.p = b2.getLong(g023);
                    oVar2.q = b2.getInt(g024) != 0;
                    oVar2.r = m.e.G0(b2.getInt(g025));
                    oVar2.f1118j = dVar;
                    oVar = oVar2;
                } else {
                    oVar = null;
                }
                b2.close();
                iVar.Q();
                return oVar;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.Q();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = t;
            b2.close();
            iVar.Q();
            throw th;
        }
    }

    public List<o.a> j(String str) {
        i t = i.t("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            int g0 = m.e.g0(b2, "id");
            int g02 = m.e.g0(b2, "state");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                o.a aVar = new o.a();
                aVar.a = b2.getString(g0);
                aVar.b = m.e.H0(b2.getInt(g02));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            b2.close();
            t.Q();
        }
    }

    public int k(String str) {
        this.a.b();
        e.w.a.f.f a2 = this.f1123f.a();
        if (str == null) {
            a2.b.bindNull(1);
        } else {
            a2.b.bindString(1, str);
        }
        this.a.c();
        try {
            int d2 = a2.d();
            this.a.l();
            this.a.g();
            l lVar = this.f1123f;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            return d2;
        } catch (Throwable th) {
            this.a.g();
            this.f1123f.c(a2);
            throw th;
        }
    }

    public int l(String str, long j2) {
        this.a.b();
        e.w.a.f.f a2 = this.f1125h.a();
        a2.b.bindLong(1, j2);
        if (str == null) {
            a2.b.bindNull(2);
        } else {
            a2.b.bindString(2, str);
        }
        this.a.c();
        try {
            int d2 = a2.d();
            this.a.l();
            return d2;
        } finally {
            this.a.g();
            l lVar = this.f1125h;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }

    public int m(String str) {
        this.a.b();
        e.w.a.f.f a2 = this.f1124g.a();
        if (str == null) {
            a2.b.bindNull(1);
        } else {
            a2.b.bindString(1, str);
        }
        this.a.c();
        try {
            int d2 = a2.d();
            this.a.l();
            this.a.g();
            l lVar = this.f1124g;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            return d2;
        } catch (Throwable th) {
            this.a.g();
            this.f1124g.c(a2);
            throw th;
        }
    }

    public void n(String str, e.b0.f fVar) {
        this.a.b();
        e.w.a.f.f a2 = this.f1121d.a();
        byte[] c2 = e.b0.f.c(fVar);
        if (c2 == null) {
            a2.b.bindNull(1);
        } else {
            a2.b.bindBlob(1, c2);
        }
        if (str == null) {
            a2.b.bindNull(2);
        } else {
            a2.b.bindString(2, str);
        }
        this.a.c();
        try {
            a2.d();
            this.a.l();
            this.a.g();
            l lVar = this.f1121d;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        } catch (Throwable th) {
            this.a.g();
            this.f1121d.c(a2);
            throw th;
        }
    }

    public void o(String str, long j2) {
        this.a.b();
        e.w.a.f.f a2 = this.f1122e.a();
        a2.b.bindLong(1, j2);
        if (str == null) {
            a2.b.bindNull(2);
        } else {
            a2.b.bindString(2, str);
        }
        this.a.c();
        try {
            a2.d();
            this.a.l();
        } finally {
            this.a.g();
            l lVar = this.f1122e;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }

    public int p(v vVar, String... strArr) {
        this.a.b();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE workspec SET state=");
        sb.append("?");
        sb.append(" WHERE id IN (");
        e.u.p.c.a(sb, strArr.length);
        sb.append(")");
        e.w.a.f.f d2 = this.a.d(sb.toString());
        d2.b.bindLong(1, (long) m.e.D1(vVar));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                d2.b.bindNull(i2);
            } else {
                d2.b.bindString(i2, str);
            }
            i2++;
        }
        this.a.c();
        try {
            int d3 = d2.d();
            this.a.l();
            return d3;
        } finally {
            this.a.g();
        }
    }
}
