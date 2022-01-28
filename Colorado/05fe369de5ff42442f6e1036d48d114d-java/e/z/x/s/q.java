package e.z.x.s;

import android.database.Cursor;
import e.b.a.m;
import e.t.i;
import e.t.l;
import e.z.d;
import e.z.s;
import e.z.x.s.o;
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
    public final l f1997d;

    /* renamed from: e  reason: collision with root package name */
    public final l f1998e;

    /* renamed from: f  reason: collision with root package name */
    public final l f1999f;

    /* renamed from: g  reason: collision with root package name */
    public final l f2000g;

    /* renamed from: h  reason: collision with root package name */
    public final l f2001h;

    /* renamed from: i  reason: collision with root package name */
    public final l f2002i;

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
            fVar.b.bindLong(2, (long) m.h.r1(oVar2.b));
            String str2 = oVar2.c;
            if (str2 == null) {
                fVar.b.bindNull(3);
            } else {
                fVar.b.bindString(3, str2);
            }
            String str3 = oVar2.f1988d;
            int i4 = 4;
            if (str3 == null) {
                fVar.b.bindNull(4);
            } else {
                fVar.b.bindString(4, str3);
            }
            byte[] c = e.z.e.c(oVar2.f1989e);
            if (c == null) {
                fVar.b.bindNull(5);
            } else {
                fVar.b.bindBlob(5, c);
            }
            byte[] c2 = e.z.e.c(oVar2.f1990f);
            if (c2 == null) {
                fVar.b.bindNull(6);
            } else {
                fVar.b.bindBlob(6, c2);
            }
            fVar.b.bindLong(7, oVar2.f1991g);
            fVar.b.bindLong(8, oVar2.f1992h);
            fVar.b.bindLong(9, oVar2.f1993i);
            fVar.b.bindLong(10, (long) oVar2.f1995k);
            e.z.a aVar = oVar2.f1996l;
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
            e.z.c cVar = oVar2.f1994j;
            if (cVar != null) {
                e.z.m mVar = cVar.a;
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
                fVar.b.bindLong(20, cVar.f1861d ? 1 : 0);
                fVar.b.bindLong(21, cVar.f1862e ? 1 : 0);
                fVar.b.bindLong(22, cVar.f1863f);
                fVar.b.bindLong(23, cVar.f1864g);
                e.z.d dVar = cVar.f1865h;
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
        this.f1997d = new c(this, gVar);
        this.f1998e = new d(this, gVar);
        this.f1999f = new e(this, gVar);
        this.f2000g = new f(this, gVar);
        this.f2001h = new g(this, gVar);
        this.f2002i = new h(this, gVar);
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
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        t.x(1, (long) i2);
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, t, false, null);
        try {
            int d0 = m.h.d0(b2, "required_network_type");
            int d02 = m.h.d0(b2, "requires_charging");
            int d03 = m.h.d0(b2, "requires_device_idle");
            int d04 = m.h.d0(b2, "requires_battery_not_low");
            int d05 = m.h.d0(b2, "requires_storage_not_low");
            int d06 = m.h.d0(b2, "trigger_content_update_delay");
            int d07 = m.h.d0(b2, "trigger_max_content_delay");
            int d08 = m.h.d0(b2, "content_uri_triggers");
            int d09 = m.h.d0(b2, "id");
            int d010 = m.h.d0(b2, "state");
            int d011 = m.h.d0(b2, "worker_class_name");
            int d012 = m.h.d0(b2, "input_merger_class_name");
            int d013 = m.h.d0(b2, "input");
            int d014 = m.h.d0(b2, "output");
            iVar = t;
            try {
                int d015 = m.h.d0(b2, "initial_delay");
                int d016 = m.h.d0(b2, "interval_duration");
                int d017 = m.h.d0(b2, "flex_duration");
                int d018 = m.h.d0(b2, "run_attempt_count");
                int d019 = m.h.d0(b2, "backoff_policy");
                int d020 = m.h.d0(b2, "backoff_delay_duration");
                int d021 = m.h.d0(b2, "period_start_time");
                int d022 = m.h.d0(b2, "minimum_retention_duration");
                int d023 = m.h.d0(b2, "schedule_requested_at");
                int d024 = m.h.d0(b2, "run_in_foreground");
                int i3 = d014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(d09);
                    String string2 = b2.getString(d011);
                    e.z.c cVar = new e.z.c();
                    cVar.a = m.h.w0(b2.getInt(d0));
                    cVar.b = b2.getInt(d02) != 0;
                    cVar.c = b2.getInt(d03) != 0;
                    cVar.f1861d = b2.getInt(d04) != 0;
                    cVar.f1862e = b2.getInt(d05) != 0;
                    cVar.f1863f = b2.getLong(d06);
                    cVar.f1864g = b2.getLong(d07);
                    cVar.f1865h = m.h.f(b2.getBlob(d08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.x0(b2.getInt(d010));
                    oVar.f1988d = b2.getString(d012);
                    oVar.f1989e = e.z.e.b(b2.getBlob(d013));
                    oVar.f1990f = e.z.e.b(b2.getBlob(i3));
                    i3 = i3;
                    oVar.f1991g = b2.getLong(d015);
                    oVar.f1992h = b2.getLong(d016);
                    oVar.f1993i = b2.getLong(d017);
                    oVar.f1995k = b2.getInt(d018);
                    oVar.f1996l = m.h.v0(b2.getInt(d019));
                    d017 = d017;
                    oVar.m = b2.getLong(d020);
                    oVar.n = b2.getLong(d021);
                    d021 = d021;
                    oVar.o = b2.getLong(d022);
                    oVar.p = b2.getLong(d023);
                    oVar.q = b2.getInt(d024) != 0;
                    oVar.f1994j = cVar;
                    arrayList.add(oVar);
                    d023 = d023;
                    d024 = d024;
                    d02 = d02;
                    d012 = d012;
                    d015 = d015;
                    d016 = d016;
                    d018 = d018;
                    d09 = d09;
                    d011 = d011;
                    d0 = d0;
                    d022 = d022;
                    d03 = d03;
                    d020 = d020;
                    d04 = d04;
                    d019 = d019;
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
        Cursor b2 = e.t.p.b.b(this.a, t, false, null);
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
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        t.x(1, (long) i2);
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, t, false, null);
        try {
            int d0 = m.h.d0(b2, "required_network_type");
            int d02 = m.h.d0(b2, "requires_charging");
            int d03 = m.h.d0(b2, "requires_device_idle");
            int d04 = m.h.d0(b2, "requires_battery_not_low");
            int d05 = m.h.d0(b2, "requires_storage_not_low");
            int d06 = m.h.d0(b2, "trigger_content_update_delay");
            int d07 = m.h.d0(b2, "trigger_max_content_delay");
            int d08 = m.h.d0(b2, "content_uri_triggers");
            int d09 = m.h.d0(b2, "id");
            int d010 = m.h.d0(b2, "state");
            int d011 = m.h.d0(b2, "worker_class_name");
            int d012 = m.h.d0(b2, "input_merger_class_name");
            int d013 = m.h.d0(b2, "input");
            int d014 = m.h.d0(b2, "output");
            iVar = t;
            try {
                int d015 = m.h.d0(b2, "initial_delay");
                int d016 = m.h.d0(b2, "interval_duration");
                int d017 = m.h.d0(b2, "flex_duration");
                int d018 = m.h.d0(b2, "run_attempt_count");
                int d019 = m.h.d0(b2, "backoff_policy");
                int d020 = m.h.d0(b2, "backoff_delay_duration");
                int d021 = m.h.d0(b2, "period_start_time");
                int d022 = m.h.d0(b2, "minimum_retention_duration");
                int d023 = m.h.d0(b2, "schedule_requested_at");
                int d024 = m.h.d0(b2, "run_in_foreground");
                int i3 = d014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(d09);
                    String string2 = b2.getString(d011);
                    e.z.c cVar = new e.z.c();
                    cVar.a = m.h.w0(b2.getInt(d0));
                    cVar.b = b2.getInt(d02) != 0;
                    cVar.c = b2.getInt(d03) != 0;
                    cVar.f1861d = b2.getInt(d04) != 0;
                    cVar.f1862e = b2.getInt(d05) != 0;
                    cVar.f1863f = b2.getLong(d06);
                    cVar.f1864g = b2.getLong(d07);
                    cVar.f1865h = m.h.f(b2.getBlob(d08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.x0(b2.getInt(d010));
                    oVar.f1988d = b2.getString(d012);
                    oVar.f1989e = e.z.e.b(b2.getBlob(d013));
                    oVar.f1990f = e.z.e.b(b2.getBlob(i3));
                    i3 = i3;
                    oVar.f1991g = b2.getLong(d015);
                    oVar.f1992h = b2.getLong(d016);
                    oVar.f1993i = b2.getLong(d017);
                    oVar.f1995k = b2.getInt(d018);
                    oVar.f1996l = m.h.v0(b2.getInt(d019));
                    d017 = d017;
                    oVar.m = b2.getLong(d020);
                    oVar.n = b2.getLong(d021);
                    d021 = d021;
                    oVar.o = b2.getLong(d022);
                    oVar.p = b2.getLong(d023);
                    oVar.q = b2.getInt(d024) != 0;
                    oVar.f1994j = cVar;
                    arrayList.add(oVar);
                    d023 = d023;
                    d024 = d024;
                    d02 = d02;
                    d012 = d012;
                    d015 = d015;
                    d016 = d016;
                    d018 = d018;
                    d09 = d09;
                    d011 = d011;
                    d0 = d0;
                    d022 = d022;
                    d03 = d03;
                    d020 = d020;
                    d04 = d04;
                    d019 = d019;
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
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, t, false, null);
        try {
            int d0 = m.h.d0(b2, "required_network_type");
            int d02 = m.h.d0(b2, "requires_charging");
            int d03 = m.h.d0(b2, "requires_device_idle");
            int d04 = m.h.d0(b2, "requires_battery_not_low");
            int d05 = m.h.d0(b2, "requires_storage_not_low");
            int d06 = m.h.d0(b2, "trigger_content_update_delay");
            int d07 = m.h.d0(b2, "trigger_max_content_delay");
            int d08 = m.h.d0(b2, "content_uri_triggers");
            int d09 = m.h.d0(b2, "id");
            int d010 = m.h.d0(b2, "state");
            int d011 = m.h.d0(b2, "worker_class_name");
            int d012 = m.h.d0(b2, "input_merger_class_name");
            int d013 = m.h.d0(b2, "input");
            int d014 = m.h.d0(b2, "output");
            iVar = t;
            try {
                int d015 = m.h.d0(b2, "initial_delay");
                int d016 = m.h.d0(b2, "interval_duration");
                int d017 = m.h.d0(b2, "flex_duration");
                int d018 = m.h.d0(b2, "run_attempt_count");
                int d019 = m.h.d0(b2, "backoff_policy");
                int d020 = m.h.d0(b2, "backoff_delay_duration");
                int d021 = m.h.d0(b2, "period_start_time");
                int d022 = m.h.d0(b2, "minimum_retention_duration");
                int d023 = m.h.d0(b2, "schedule_requested_at");
                int d024 = m.h.d0(b2, "run_in_foreground");
                int i2 = d014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(d09);
                    String string2 = b2.getString(d011);
                    e.z.c cVar = new e.z.c();
                    cVar.a = m.h.w0(b2.getInt(d0));
                    cVar.b = b2.getInt(d02) != 0;
                    cVar.c = b2.getInt(d03) != 0;
                    cVar.f1861d = b2.getInt(d04) != 0;
                    cVar.f1862e = b2.getInt(d05) != 0;
                    cVar.f1863f = b2.getLong(d06);
                    cVar.f1864g = b2.getLong(d07);
                    cVar.f1865h = m.h.f(b2.getBlob(d08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.x0(b2.getInt(d010));
                    oVar.f1988d = b2.getString(d012);
                    oVar.f1989e = e.z.e.b(b2.getBlob(d013));
                    oVar.f1990f = e.z.e.b(b2.getBlob(i2));
                    i2 = i2;
                    oVar.f1991g = b2.getLong(d015);
                    oVar.f1992h = b2.getLong(d016);
                    oVar.f1993i = b2.getLong(d017);
                    oVar.f1995k = b2.getInt(d018);
                    oVar.f1996l = m.h.v0(b2.getInt(d019));
                    d017 = d017;
                    oVar.m = b2.getLong(d020);
                    oVar.n = b2.getLong(d021);
                    d021 = d021;
                    oVar.o = b2.getLong(d022);
                    oVar.p = b2.getLong(d023);
                    oVar.q = b2.getInt(d024) != 0;
                    oVar.f1994j = cVar;
                    arrayList.add(oVar);
                    d023 = d023;
                    d024 = d024;
                    d02 = d02;
                    d013 = d013;
                    d015 = d015;
                    d016 = d016;
                    d018 = d018;
                    d09 = d09;
                    d011 = d011;
                    d0 = d0;
                    d022 = d022;
                    d03 = d03;
                    d020 = d020;
                    d04 = d04;
                    d019 = d019;
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
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, t, false, null);
        try {
            int d0 = m.h.d0(b2, "required_network_type");
            int d02 = m.h.d0(b2, "requires_charging");
            int d03 = m.h.d0(b2, "requires_device_idle");
            int d04 = m.h.d0(b2, "requires_battery_not_low");
            int d05 = m.h.d0(b2, "requires_storage_not_low");
            int d06 = m.h.d0(b2, "trigger_content_update_delay");
            int d07 = m.h.d0(b2, "trigger_max_content_delay");
            int d08 = m.h.d0(b2, "content_uri_triggers");
            int d09 = m.h.d0(b2, "id");
            int d010 = m.h.d0(b2, "state");
            int d011 = m.h.d0(b2, "worker_class_name");
            int d012 = m.h.d0(b2, "input_merger_class_name");
            int d013 = m.h.d0(b2, "input");
            int d014 = m.h.d0(b2, "output");
            iVar = t;
            try {
                int d015 = m.h.d0(b2, "initial_delay");
                int d016 = m.h.d0(b2, "interval_duration");
                int d017 = m.h.d0(b2, "flex_duration");
                int d018 = m.h.d0(b2, "run_attempt_count");
                int d019 = m.h.d0(b2, "backoff_policy");
                int d020 = m.h.d0(b2, "backoff_delay_duration");
                int d021 = m.h.d0(b2, "period_start_time");
                int d022 = m.h.d0(b2, "minimum_retention_duration");
                int d023 = m.h.d0(b2, "schedule_requested_at");
                int d024 = m.h.d0(b2, "run_in_foreground");
                int i2 = d014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(d09);
                    String string2 = b2.getString(d011);
                    e.z.c cVar = new e.z.c();
                    cVar.a = m.h.w0(b2.getInt(d0));
                    cVar.b = b2.getInt(d02) != 0;
                    cVar.c = b2.getInt(d03) != 0;
                    cVar.f1861d = b2.getInt(d04) != 0;
                    cVar.f1862e = b2.getInt(d05) != 0;
                    cVar.f1863f = b2.getLong(d06);
                    cVar.f1864g = b2.getLong(d07);
                    cVar.f1865h = m.h.f(b2.getBlob(d08));
                    o oVar = new o(string, string2);
                    oVar.b = m.h.x0(b2.getInt(d010));
                    oVar.f1988d = b2.getString(d012);
                    oVar.f1989e = e.z.e.b(b2.getBlob(d013));
                    oVar.f1990f = e.z.e.b(b2.getBlob(i2));
                    i2 = i2;
                    oVar.f1991g = b2.getLong(d015);
                    oVar.f1992h = b2.getLong(d016);
                    oVar.f1993i = b2.getLong(d017);
                    oVar.f1995k = b2.getInt(d018);
                    oVar.f1996l = m.h.v0(b2.getInt(d019));
                    d017 = d017;
                    oVar.m = b2.getLong(d020);
                    oVar.n = b2.getLong(d021);
                    d021 = d021;
                    oVar.o = b2.getLong(d022);
                    oVar.p = b2.getLong(d023);
                    oVar.q = b2.getInt(d024) != 0;
                    oVar.f1994j = cVar;
                    arrayList.add(oVar);
                    d023 = d023;
                    d024 = d024;
                    d02 = d02;
                    d013 = d013;
                    d015 = d015;
                    d016 = d016;
                    d018 = d018;
                    d09 = d09;
                    d011 = d011;
                    d0 = d0;
                    d022 = d022;
                    d03 = d03;
                    d020 = d020;
                    d04 = d04;
                    d019 = d019;
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

    public s g(String str) {
        i t = i.t("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        s sVar = null;
        Cursor b2 = e.t.p.b.b(this.a, t, false, null);
        try {
            if (b2.moveToFirst()) {
                sVar = m.h.x0(b2.getInt(0));
            }
            return sVar;
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
        Cursor b2 = e.t.p.b.b(this.a, t, false, null);
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
        i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, t, false, null);
        try {
            int d0 = m.h.d0(b2, "required_network_type");
            int d02 = m.h.d0(b2, "requires_charging");
            int d03 = m.h.d0(b2, "requires_device_idle");
            int d04 = m.h.d0(b2, "requires_battery_not_low");
            int d05 = m.h.d0(b2, "requires_storage_not_low");
            int d06 = m.h.d0(b2, "trigger_content_update_delay");
            int d07 = m.h.d0(b2, "trigger_max_content_delay");
            int d08 = m.h.d0(b2, "content_uri_triggers");
            int d09 = m.h.d0(b2, "id");
            int d010 = m.h.d0(b2, "state");
            int d011 = m.h.d0(b2, "worker_class_name");
            int d012 = m.h.d0(b2, "input_merger_class_name");
            int d013 = m.h.d0(b2, "input");
            int d014 = m.h.d0(b2, "output");
            iVar = t;
            try {
                int d015 = m.h.d0(b2, "initial_delay");
                int d016 = m.h.d0(b2, "interval_duration");
                int d017 = m.h.d0(b2, "flex_duration");
                int d018 = m.h.d0(b2, "run_attempt_count");
                int d019 = m.h.d0(b2, "backoff_policy");
                int d020 = m.h.d0(b2, "backoff_delay_duration");
                int d021 = m.h.d0(b2, "period_start_time");
                int d022 = m.h.d0(b2, "minimum_retention_duration");
                int d023 = m.h.d0(b2, "schedule_requested_at");
                int d024 = m.h.d0(b2, "run_in_foreground");
                if (b2.moveToFirst()) {
                    String string = b2.getString(d09);
                    String string2 = b2.getString(d011);
                    e.z.c cVar = new e.z.c();
                    cVar.a = m.h.w0(b2.getInt(d0));
                    cVar.b = b2.getInt(d02) != 0;
                    cVar.c = b2.getInt(d03) != 0;
                    cVar.f1861d = b2.getInt(d04) != 0;
                    cVar.f1862e = b2.getInt(d05) != 0;
                    cVar.f1863f = b2.getLong(d06);
                    cVar.f1864g = b2.getLong(d07);
                    cVar.f1865h = m.h.f(b2.getBlob(d08));
                    o oVar2 = new o(string, string2);
                    oVar2.b = m.h.x0(b2.getInt(d010));
                    oVar2.f1988d = b2.getString(d012);
                    oVar2.f1989e = e.z.e.b(b2.getBlob(d013));
                    oVar2.f1990f = e.z.e.b(b2.getBlob(d014));
                    oVar2.f1991g = b2.getLong(d015);
                    oVar2.f1992h = b2.getLong(d016);
                    oVar2.f1993i = b2.getLong(d017);
                    oVar2.f1995k = b2.getInt(d018);
                    oVar2.f1996l = m.h.v0(b2.getInt(d019));
                    oVar2.m = b2.getLong(d020);
                    oVar2.n = b2.getLong(d021);
                    oVar2.o = b2.getLong(d022);
                    oVar2.p = b2.getLong(d023);
                    oVar2.q = b2.getInt(d024) != 0;
                    oVar2.f1994j = cVar;
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
        Cursor b2 = e.t.p.b.b(this.a, t, false, null);
        try {
            int d0 = m.h.d0(b2, "id");
            int d02 = m.h.d0(b2, "state");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                o.a aVar = new o.a();
                aVar.a = b2.getString(d0);
                aVar.b = m.h.x0(b2.getInt(d02));
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
        e.v.a.f.f a2 = this.f1999f.a();
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
            l lVar = this.f1999f;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            return d2;
        } catch (Throwable th) {
            this.a.g();
            this.f1999f.c(a2);
            throw th;
        }
    }

    public int l(String str, long j2) {
        this.a.b();
        e.v.a.f.f a2 = this.f2001h.a();
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
            l lVar = this.f2001h;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }

    public int m(String str) {
        this.a.b();
        e.v.a.f.f a2 = this.f2000g.a();
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
            l lVar = this.f2000g;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            return d2;
        } catch (Throwable th) {
            this.a.g();
            this.f2000g.c(a2);
            throw th;
        }
    }

    public void n(String str, e.z.e eVar) {
        this.a.b();
        e.v.a.f.f a2 = this.f1997d.a();
        byte[] c2 = e.z.e.c(eVar);
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
            l lVar = this.f1997d;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        } catch (Throwable th) {
            this.a.g();
            this.f1997d.c(a2);
            throw th;
        }
    }

    public void o(String str, long j2) {
        this.a.b();
        e.v.a.f.f a2 = this.f1998e.a();
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
            l lVar = this.f1998e;
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
        e.t.p.c.a(sb, strArr.length);
        sb.append(")");
        e.v.a.f.f d2 = this.a.d(sb.toString());
        d2.b.bindLong(1, (long) m.h.r1(sVar));
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
