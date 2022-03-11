package e.b0.x.s;

import android.database.Cursor;
import e.b.a.m;
import e.b0.d;
import e.b0.s;
import e.b0.x.s.o;
import e.t.i;
import e.t.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class q implements p {
    public final e.t.g a;
    public final e.t.b<o> b;
    public final l c;

    /* renamed from: d  reason: collision with root package name */
    public final l f1122d;

    /* renamed from: e  reason: collision with root package name */
    public final l f1123e;

    /* renamed from: f  reason: collision with root package name */
    public final l f1124f;

    /* renamed from: g  reason: collision with root package name */
    public final l f1125g;

    /* renamed from: h  reason: collision with root package name */
    public final l f1126h;

    /* renamed from: i  reason: collision with root package name */
    public final l f1127i;

    public class a extends e.t.b<o> {
        public a(q qVar, e.t.g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x01b1  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01c9  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x01d1  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01dd A[SYNTHETIC, Splitter:B:75:0x01dd] */
        @Override // e.t.b
        public void d(e.v.a.f.f fVar, o oVar) {
            int i2;
            Throwable th;
            IOException e2;
            o oVar2 = oVar;
            String str = oVar2.a;
            int i3 = 1;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            fVar.b.bindLong(2, (long) m.h.l1(oVar2.b));
            String str2 = oVar2.c;
            if (str2 == null) {
                fVar.b.bindNull(3);
            } else {
                fVar.b.bindString(3, str2);
            }
            String str3 = oVar2.f1113d;
            int i4 = 4;
            if (str3 == null) {
                fVar.b.bindNull(4);
            } else {
                fVar.b.bindString(4, str3);
            }
            byte[] b = e.b0.e.b(oVar2.f1114e);
            if (b == null) {
                fVar.b.bindNull(5);
            } else {
                fVar.b.bindBlob(5, b);
            }
            byte[] b2 = e.b0.e.b(oVar2.f1115f);
            if (b2 == null) {
                fVar.b.bindNull(6);
            } else {
                fVar.b.bindBlob(6, b2);
            }
            fVar.b.bindLong(7, oVar2.f1116g);
            fVar.b.bindLong(8, oVar2.f1117h);
            fVar.b.bindLong(9, oVar2.f1118i);
            fVar.b.bindLong(10, (long) oVar2.f1120k);
            e.b0.a aVar = oVar2.f1121l;
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
            e.b0.c cVar = oVar2.f1119j;
            if (cVar != null) {
                e.b0.m mVar = cVar.a;
                int ordinal2 = mVar.ordinal();
                if (ordinal2 != 0) {
                    if (ordinal2 != 1) {
                        if (ordinal2 == 2) {
                            i3 = 2;
                        } else if (ordinal2 == 3) {
                            i3 = 3;
                        } else if (ordinal2 != 4) {
                            throw new IllegalArgumentException("Could not convert " + mVar + " to int");
                        }
                    }
                    i4 = i3;
                } else {
                    i4 = 0;
                }
                fVar.b.bindLong(17, (long) i4);
                fVar.b.bindLong(18, cVar.b ? 1 : 0);
                fVar.b.bindLong(19, cVar.c ? 1 : 0);
                fVar.b.bindLong(20, cVar.f986d ? 1 : 0);
                fVar.b.bindLong(21, cVar.f987e ? 1 : 0);
                fVar.b.bindLong(22, cVar.f988f);
                fVar.b.bindLong(23, cVar.f989g);
                e.b0.d dVar = cVar.f990h;
                byte[] bArr = null;
                ObjectOutputStream objectOutputStream = null;
                if (dVar.a() != 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream2.writeInt(dVar.a());
                            for (d.a aVar2 : dVar.a) {
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
                    fVar.b.bindNull(24);
                } else {
                    fVar.b.bindBlob(24, bArr);
                }
            } else {
                fVar.b.bindNull(17);
                fVar.b.bindNull(18);
                fVar.b.bindNull(19);
                fVar.b.bindNull(20);
                fVar.b.bindNull(21);
                fVar.b.bindNull(22);
                fVar.b.bindNull(23);
                fVar.b.bindNull(24);
            }
        }
    }

    public class b extends l {
        public b(q qVar, e.t.g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class c extends l {
        public c(q qVar, e.t.g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class d extends l {
        public d(q qVar, e.t.g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    public class e extends l {
        public e(q qVar, e.t.g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class f extends l {
        public f(q qVar, e.t.g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public class g extends l {
        public g(q qVar, e.t.g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class h extends l {
        public h(q qVar, e.t.g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public q(e.t.g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f1122d = new c(this, gVar);
        this.f1123e = new d(this, gVar);
        this.f1124f = new e(this, gVar);
        this.f1125g = new f(this, gVar);
        this.f1126h = new g(this, gVar);
        this.f1127i = new h(this, gVar);
        new AtomicBoolean(false);
    }

    public void a(String str) {
        this.a.b();
        e.v.a.f.f a2 = this.c.a();
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
        i v = i.v("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        v.A(1, (long) i2);
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            int b0 = m.h.b0(b2, "required_network_type");
            int b02 = m.h.b0(b2, "requires_charging");
            int b03 = m.h.b0(b2, "requires_device_idle");
            int b04 = m.h.b0(b2, "requires_battery_not_low");
            int b05 = m.h.b0(b2, "requires_storage_not_low");
            int b06 = m.h.b0(b2, "trigger_content_update_delay");
            int b07 = m.h.b0(b2, "trigger_max_content_delay");
            int b08 = m.h.b0(b2, "content_uri_triggers");
            int b09 = m.h.b0(b2, "id");
            int b010 = m.h.b0(b2, "state");
            int b011 = m.h.b0(b2, "worker_class_name");
            int b012 = m.h.b0(b2, "input_merger_class_name");
            int b013 = m.h.b0(b2, "input");
            int b014 = m.h.b0(b2, "output");
            iVar = v;
            try {
                int b015 = m.h.b0(b2, "initial_delay");
                int b016 = m.h.b0(b2, "interval_duration");
                int b017 = m.h.b0(b2, "flex_duration");
                int b018 = m.h.b0(b2, "run_attempt_count");
                int b019 = m.h.b0(b2, "backoff_policy");
                int b020 = m.h.b0(b2, "backoff_delay_duration");
                int b021 = m.h.b0(b2, "period_start_time");
                int b022 = m.h.b0(b2, "minimum_retention_duration");
                int b023 = m.h.b0(b2, "schedule_requested_at");
                int b024 = m.h.b0(b2, "run_in_foreground");
                int i3 = b014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b09);
                    String string2 = b2.getString(b011);
                    e.b0.c cVar = new e.b0.c();
                    cVar.a = m.h.u0(b2.getInt(b0));
                    cVar.b = b2.getInt(b02) != 0;
                    cVar.c = b2.getInt(b03) != 0;
                    cVar.f986d = b2.getInt(b04) != 0;
                    cVar.f987e = b2.getInt(b05) != 0;
                    cVar.f988f = b2.getLong(b06);
                    cVar.f989g = b2.getLong(b07);
                    cVar.f990h = m.h.f(b2.getBlob(b08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.v0(b2.getInt(b010));
                    oVar.f1113d = b2.getString(b012);
                    oVar.f1114e = e.b0.e.a(b2.getBlob(b013));
                    oVar.f1115f = e.b0.e.a(b2.getBlob(i3));
                    i3 = i3;
                    oVar.f1116g = b2.getLong(b015);
                    oVar.f1117h = b2.getLong(b016);
                    oVar.f1118i = b2.getLong(b017);
                    oVar.f1120k = b2.getInt(b018);
                    oVar.f1121l = m.h.t0(b2.getInt(b019));
                    b017 = b017;
                    oVar.m = b2.getLong(b020);
                    oVar.n = b2.getLong(b021);
                    b021 = b021;
                    oVar.o = b2.getLong(b022);
                    oVar.p = b2.getLong(b023);
                    oVar.q = b2.getInt(b024) != 0;
                    oVar.f1119j = cVar;
                    arrayList.add(oVar);
                    b023 = b023;
                    b024 = b024;
                    b02 = b02;
                    b012 = b012;
                    b015 = b015;
                    b016 = b016;
                    b018 = b018;
                    b09 = b09;
                    b011 = b011;
                    b0 = b0;
                    b022 = b022;
                    b03 = b03;
                    b020 = b020;
                    b04 = b04;
                    b019 = b019;
                }
                b2.close();
                iVar.V();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.V();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = v;
            b2.close();
            iVar.V();
            throw th;
        }
    }

    public List<String> c() {
        i v = i.v("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            v.V();
        }
    }

    public List<o> d(int i2) {
        i iVar;
        Throwable th;
        i v = i.v("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        v.A(1, (long) i2);
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            int b0 = m.h.b0(b2, "required_network_type");
            int b02 = m.h.b0(b2, "requires_charging");
            int b03 = m.h.b0(b2, "requires_device_idle");
            int b04 = m.h.b0(b2, "requires_battery_not_low");
            int b05 = m.h.b0(b2, "requires_storage_not_low");
            int b06 = m.h.b0(b2, "trigger_content_update_delay");
            int b07 = m.h.b0(b2, "trigger_max_content_delay");
            int b08 = m.h.b0(b2, "content_uri_triggers");
            int b09 = m.h.b0(b2, "id");
            int b010 = m.h.b0(b2, "state");
            int b011 = m.h.b0(b2, "worker_class_name");
            int b012 = m.h.b0(b2, "input_merger_class_name");
            int b013 = m.h.b0(b2, "input");
            int b014 = m.h.b0(b2, "output");
            iVar = v;
            try {
                int b015 = m.h.b0(b2, "initial_delay");
                int b016 = m.h.b0(b2, "interval_duration");
                int b017 = m.h.b0(b2, "flex_duration");
                int b018 = m.h.b0(b2, "run_attempt_count");
                int b019 = m.h.b0(b2, "backoff_policy");
                int b020 = m.h.b0(b2, "backoff_delay_duration");
                int b021 = m.h.b0(b2, "period_start_time");
                int b022 = m.h.b0(b2, "minimum_retention_duration");
                int b023 = m.h.b0(b2, "schedule_requested_at");
                int b024 = m.h.b0(b2, "run_in_foreground");
                int i3 = b014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b09);
                    String string2 = b2.getString(b011);
                    e.b0.c cVar = new e.b0.c();
                    cVar.a = m.h.u0(b2.getInt(b0));
                    cVar.b = b2.getInt(b02) != 0;
                    cVar.c = b2.getInt(b03) != 0;
                    cVar.f986d = b2.getInt(b04) != 0;
                    cVar.f987e = b2.getInt(b05) != 0;
                    cVar.f988f = b2.getLong(b06);
                    cVar.f989g = b2.getLong(b07);
                    cVar.f990h = m.h.f(b2.getBlob(b08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.v0(b2.getInt(b010));
                    oVar.f1113d = b2.getString(b012);
                    oVar.f1114e = e.b0.e.a(b2.getBlob(b013));
                    oVar.f1115f = e.b0.e.a(b2.getBlob(i3));
                    i3 = i3;
                    oVar.f1116g = b2.getLong(b015);
                    oVar.f1117h = b2.getLong(b016);
                    oVar.f1118i = b2.getLong(b017);
                    oVar.f1120k = b2.getInt(b018);
                    oVar.f1121l = m.h.t0(b2.getInt(b019));
                    b017 = b017;
                    oVar.m = b2.getLong(b020);
                    oVar.n = b2.getLong(b021);
                    b021 = b021;
                    oVar.o = b2.getLong(b022);
                    oVar.p = b2.getLong(b023);
                    oVar.q = b2.getInt(b024) != 0;
                    oVar.f1119j = cVar;
                    arrayList.add(oVar);
                    b023 = b023;
                    b024 = b024;
                    b02 = b02;
                    b012 = b012;
                    b015 = b015;
                    b016 = b016;
                    b018 = b018;
                    b09 = b09;
                    b011 = b011;
                    b0 = b0;
                    b022 = b022;
                    b03 = b03;
                    b020 = b020;
                    b04 = b04;
                    b019 = b019;
                }
                b2.close();
                iVar.V();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.V();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = v;
            b2.close();
            iVar.V();
            throw th;
        }
    }

    public List<o> e() {
        i iVar;
        Throwable th;
        i v = i.v("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            int b0 = m.h.b0(b2, "required_network_type");
            int b02 = m.h.b0(b2, "requires_charging");
            int b03 = m.h.b0(b2, "requires_device_idle");
            int b04 = m.h.b0(b2, "requires_battery_not_low");
            int b05 = m.h.b0(b2, "requires_storage_not_low");
            int b06 = m.h.b0(b2, "trigger_content_update_delay");
            int b07 = m.h.b0(b2, "trigger_max_content_delay");
            int b08 = m.h.b0(b2, "content_uri_triggers");
            int b09 = m.h.b0(b2, "id");
            int b010 = m.h.b0(b2, "state");
            int b011 = m.h.b0(b2, "worker_class_name");
            int b012 = m.h.b0(b2, "input_merger_class_name");
            int b013 = m.h.b0(b2, "input");
            int b014 = m.h.b0(b2, "output");
            iVar = v;
            try {
                int b015 = m.h.b0(b2, "initial_delay");
                int b016 = m.h.b0(b2, "interval_duration");
                int b017 = m.h.b0(b2, "flex_duration");
                int b018 = m.h.b0(b2, "run_attempt_count");
                int b019 = m.h.b0(b2, "backoff_policy");
                int b020 = m.h.b0(b2, "backoff_delay_duration");
                int b021 = m.h.b0(b2, "period_start_time");
                int b022 = m.h.b0(b2, "minimum_retention_duration");
                int b023 = m.h.b0(b2, "schedule_requested_at");
                int b024 = m.h.b0(b2, "run_in_foreground");
                int i2 = b014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b09);
                    String string2 = b2.getString(b011);
                    e.b0.c cVar = new e.b0.c();
                    cVar.a = m.h.u0(b2.getInt(b0));
                    cVar.b = b2.getInt(b02) != 0;
                    cVar.c = b2.getInt(b03) != 0;
                    cVar.f986d = b2.getInt(b04) != 0;
                    cVar.f987e = b2.getInt(b05) != 0;
                    cVar.f988f = b2.getLong(b06);
                    cVar.f989g = b2.getLong(b07);
                    cVar.f990h = m.h.f(b2.getBlob(b08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.v0(b2.getInt(b010));
                    oVar.f1113d = b2.getString(b012);
                    oVar.f1114e = e.b0.e.a(b2.getBlob(b013));
                    oVar.f1115f = e.b0.e.a(b2.getBlob(i2));
                    i2 = i2;
                    oVar.f1116g = b2.getLong(b015);
                    oVar.f1117h = b2.getLong(b016);
                    oVar.f1118i = b2.getLong(b017);
                    oVar.f1120k = b2.getInt(b018);
                    oVar.f1121l = m.h.t0(b2.getInt(b019));
                    b017 = b017;
                    oVar.m = b2.getLong(b020);
                    oVar.n = b2.getLong(b021);
                    b021 = b021;
                    oVar.o = b2.getLong(b022);
                    oVar.p = b2.getLong(b023);
                    oVar.q = b2.getInt(b024) != 0;
                    oVar.f1119j = cVar;
                    arrayList.add(oVar);
                    b023 = b023;
                    b024 = b024;
                    b02 = b02;
                    b013 = b013;
                    b015 = b015;
                    b016 = b016;
                    b018 = b018;
                    b09 = b09;
                    b011 = b011;
                    b0 = b0;
                    b022 = b022;
                    b03 = b03;
                    b020 = b020;
                    b04 = b04;
                    b019 = b019;
                }
                b2.close();
                iVar.V();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.V();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = v;
            b2.close();
            iVar.V();
            throw th;
        }
    }

    public List<o> f() {
        i iVar;
        Throwable th;
        i v = i.v("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            int b0 = m.h.b0(b2, "required_network_type");
            int b02 = m.h.b0(b2, "requires_charging");
            int b03 = m.h.b0(b2, "requires_device_idle");
            int b04 = m.h.b0(b2, "requires_battery_not_low");
            int b05 = m.h.b0(b2, "requires_storage_not_low");
            int b06 = m.h.b0(b2, "trigger_content_update_delay");
            int b07 = m.h.b0(b2, "trigger_max_content_delay");
            int b08 = m.h.b0(b2, "content_uri_triggers");
            int b09 = m.h.b0(b2, "id");
            int b010 = m.h.b0(b2, "state");
            int b011 = m.h.b0(b2, "worker_class_name");
            int b012 = m.h.b0(b2, "input_merger_class_name");
            int b013 = m.h.b0(b2, "input");
            int b014 = m.h.b0(b2, "output");
            iVar = v;
            try {
                int b015 = m.h.b0(b2, "initial_delay");
                int b016 = m.h.b0(b2, "interval_duration");
                int b017 = m.h.b0(b2, "flex_duration");
                int b018 = m.h.b0(b2, "run_attempt_count");
                int b019 = m.h.b0(b2, "backoff_policy");
                int b020 = m.h.b0(b2, "backoff_delay_duration");
                int b021 = m.h.b0(b2, "period_start_time");
                int b022 = m.h.b0(b2, "minimum_retention_duration");
                int b023 = m.h.b0(b2, "schedule_requested_at");
                int b024 = m.h.b0(b2, "run_in_foreground");
                int i2 = b014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b09);
                    String string2 = b2.getString(b011);
                    e.b0.c cVar = new e.b0.c();
                    cVar.a = m.h.u0(b2.getInt(b0));
                    cVar.b = b2.getInt(b02) != 0;
                    cVar.c = b2.getInt(b03) != 0;
                    cVar.f986d = b2.getInt(b04) != 0;
                    cVar.f987e = b2.getInt(b05) != 0;
                    cVar.f988f = b2.getLong(b06);
                    cVar.f989g = b2.getLong(b07);
                    cVar.f990h = m.h.f(b2.getBlob(b08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.v0(b2.getInt(b010));
                    oVar.f1113d = b2.getString(b012);
                    oVar.f1114e = e.b0.e.a(b2.getBlob(b013));
                    oVar.f1115f = e.b0.e.a(b2.getBlob(i2));
                    i2 = i2;
                    oVar.f1116g = b2.getLong(b015);
                    oVar.f1117h = b2.getLong(b016);
                    oVar.f1118i = b2.getLong(b017);
                    oVar.f1120k = b2.getInt(b018);
                    oVar.f1121l = m.h.t0(b2.getInt(b019));
                    b017 = b017;
                    oVar.m = b2.getLong(b020);
                    oVar.n = b2.getLong(b021);
                    b021 = b021;
                    oVar.o = b2.getLong(b022);
                    oVar.p = b2.getLong(b023);
                    oVar.q = b2.getInt(b024) != 0;
                    oVar.f1119j = cVar;
                    arrayList.add(oVar);
                    b023 = b023;
                    b024 = b024;
                    b02 = b02;
                    b013 = b013;
                    b015 = b015;
                    b016 = b016;
                    b018 = b018;
                    b09 = b09;
                    b011 = b011;
                    b0 = b0;
                    b022 = b022;
                    b03 = b03;
                    b020 = b020;
                    b04 = b04;
                    b019 = b019;
                }
                b2.close();
                iVar.V();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.V();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = v;
            b2.close();
            iVar.V();
            throw th;
        }
    }

    public s g(String str) {
        i v = i.v("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            v.N(1);
        } else {
            v.P(1, str);
        }
        this.a.b();
        s sVar = null;
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            if (b2.moveToFirst()) {
                sVar = m.h.v0(b2.getInt(0));
            }
            return sVar;
        } finally {
            b2.close();
            v.V();
        }
    }

    public List<String> h(String str) {
        i v = i.v("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            v.N(1);
        } else {
            v.P(1, str);
        }
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            v.V();
        }
    }

    public o i(String str) {
        i iVar;
        Throwable th;
        o oVar;
        i v = i.v("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str == null) {
            v.N(1);
        } else {
            v.P(1, str);
        }
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            int b0 = m.h.b0(b2, "required_network_type");
            int b02 = m.h.b0(b2, "requires_charging");
            int b03 = m.h.b0(b2, "requires_device_idle");
            int b04 = m.h.b0(b2, "requires_battery_not_low");
            int b05 = m.h.b0(b2, "requires_storage_not_low");
            int b06 = m.h.b0(b2, "trigger_content_update_delay");
            int b07 = m.h.b0(b2, "trigger_max_content_delay");
            int b08 = m.h.b0(b2, "content_uri_triggers");
            int b09 = m.h.b0(b2, "id");
            int b010 = m.h.b0(b2, "state");
            int b011 = m.h.b0(b2, "worker_class_name");
            int b012 = m.h.b0(b2, "input_merger_class_name");
            int b013 = m.h.b0(b2, "input");
            int b014 = m.h.b0(b2, "output");
            iVar = v;
            try {
                int b015 = m.h.b0(b2, "initial_delay");
                int b016 = m.h.b0(b2, "interval_duration");
                int b017 = m.h.b0(b2, "flex_duration");
                int b018 = m.h.b0(b2, "run_attempt_count");
                int b019 = m.h.b0(b2, "backoff_policy");
                int b020 = m.h.b0(b2, "backoff_delay_duration");
                int b021 = m.h.b0(b2, "period_start_time");
                int b022 = m.h.b0(b2, "minimum_retention_duration");
                int b023 = m.h.b0(b2, "schedule_requested_at");
                int b024 = m.h.b0(b2, "run_in_foreground");
                if (b2.moveToFirst()) {
                    String string = b2.getString(b09);
                    String string2 = b2.getString(b011);
                    e.b0.c cVar = new e.b0.c();
                    cVar.a = m.h.u0(b2.getInt(b0));
                    cVar.b = b2.getInt(b02) != 0;
                    cVar.c = b2.getInt(b03) != 0;
                    cVar.f986d = b2.getInt(b04) != 0;
                    cVar.f987e = b2.getInt(b05) != 0;
                    cVar.f988f = b2.getLong(b06);
                    cVar.f989g = b2.getLong(b07);
                    cVar.f990h = m.h.f(b2.getBlob(b08));
                    o oVar2 = new o(string, string2);
                    oVar2.b = m.h.v0(b2.getInt(b010));
                    oVar2.f1113d = b2.getString(b012);
                    oVar2.f1114e = e.b0.e.a(b2.getBlob(b013));
                    oVar2.f1115f = e.b0.e.a(b2.getBlob(b014));
                    oVar2.f1116g = b2.getLong(b015);
                    oVar2.f1117h = b2.getLong(b016);
                    oVar2.f1118i = b2.getLong(b017);
                    oVar2.f1120k = b2.getInt(b018);
                    oVar2.f1121l = m.h.t0(b2.getInt(b019));
                    oVar2.m = b2.getLong(b020);
                    oVar2.n = b2.getLong(b021);
                    oVar2.o = b2.getLong(b022);
                    oVar2.p = b2.getLong(b023);
                    oVar2.q = b2.getInt(b024) != 0;
                    oVar2.f1119j = cVar;
                    oVar = oVar2;
                } else {
                    oVar = null;
                }
                b2.close();
                iVar.V();
                return oVar;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.V();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = v;
            b2.close();
            iVar.V();
            throw th;
        }
    }

    public List<o.a> j(String str) {
        i v = i.v("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            v.N(1);
        } else {
            v.P(1, str);
        }
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            int b0 = m.h.b0(b2, "id");
            int b02 = m.h.b0(b2, "state");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                o.a aVar = new o.a();
                aVar.a = b2.getString(b0);
                aVar.b = m.h.v0(b2.getInt(b02));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            b2.close();
            v.V();
        }
    }

    public int k(String str) {
        this.a.b();
        e.v.a.f.f a2 = this.f1124f.a();
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
            l lVar = this.f1124f;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            return d2;
        } catch (Throwable th) {
            this.a.g();
            this.f1124f.c(a2);
            throw th;
        }
    }

    public int l(String str, long j2) {
        this.a.b();
        e.v.a.f.f a2 = this.f1126h.a();
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
            l lVar = this.f1126h;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }

    public int m(String str) {
        this.a.b();
        e.v.a.f.f a2 = this.f1125g.a();
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
            l lVar = this.f1125g;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            return d2;
        } catch (Throwable th) {
            this.a.g();
            this.f1125g.c(a2);
            throw th;
        }
    }

    public void n(String str, e.b0.e eVar) {
        this.a.b();
        e.v.a.f.f a2 = this.f1122d.a();
        byte[] b2 = e.b0.e.b(eVar);
        if (b2 == null) {
            a2.b.bindNull(1);
        } else {
            a2.b.bindBlob(1, b2);
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
            l lVar = this.f1122d;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        } catch (Throwable th) {
            this.a.g();
            this.f1122d.c(a2);
            throw th;
        }
    }

    public void o(String str, long j2) {
        this.a.b();
        e.v.a.f.f a2 = this.f1123e.a();
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
            l lVar = this.f1123e;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }

    public int p(s sVar, String... strArr) {
        this.a.b();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE workspec SET state=");
        sb.append("?");
        sb.append(" WHERE id IN (");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("?");
            if (i2 < length - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        e.v.a.f.f d2 = this.a.d(sb.toString());
        d2.b.bindLong(1, (long) m.h.l1(sVar));
        int i3 = 2;
        for (String str : strArr) {
            if (str == null) {
                d2.b.bindNull(i3);
            } else {
                d2.b.bindString(i3, str);
            }
            i3++;
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
