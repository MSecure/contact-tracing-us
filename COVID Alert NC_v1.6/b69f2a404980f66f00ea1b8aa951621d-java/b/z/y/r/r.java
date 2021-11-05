package b.z.y.r;

import android.database.Cursor;
import b.b.k.i;
import b.r.j;
import b.r.m;
import b.z.d;
import b.z.n;
import b.z.u;
import b.z.y.r.p;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class r implements q {

    /* renamed from: a  reason: collision with root package name */
    public final b.r.h f2098a;

    /* renamed from: b  reason: collision with root package name */
    public final b.r.b<p> f2099b;

    /* renamed from: c  reason: collision with root package name */
    public final m f2100c;

    /* renamed from: d  reason: collision with root package name */
    public final m f2101d;

    /* renamed from: e  reason: collision with root package name */
    public final m f2102e;
    public final m f;
    public final m g;
    public final m h;
    public final m i;

    public class a extends b.r.b<p> {
        public a(r rVar, b.r.h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.u.a.f, java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x01bb  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01d4  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x01e0 A[SYNTHETIC, Splitter:B:74:0x01e0] */
        @Override // b.r.b
        public void bind(b.u.a.f fVar, p pVar) {
            int i;
            Throwable th;
            IOException e2;
            p pVar2 = pVar;
            String str = pVar2.f2091a;
            int i2 = 1;
            if (str == null) {
                ((b.u.a.g.e) fVar).f1754b.bindNull(1);
            } else {
                ((b.u.a.g.e) fVar).f1754b.bindString(1, str);
            }
            b.u.a.g.e eVar = (b.u.a.g.e) fVar;
            eVar.f1754b.bindLong(2, (long) i.j.h1(pVar2.f2092b));
            String str2 = pVar2.f2093c;
            if (str2 == null) {
                eVar.f1754b.bindNull(3);
            } else {
                eVar.f1754b.bindString(3, str2);
            }
            String str3 = pVar2.f2094d;
            int i3 = 4;
            if (str3 == null) {
                eVar.f1754b.bindNull(4);
            } else {
                eVar.f1754b.bindString(4, str3);
            }
            byte[] h = b.z.e.h(pVar2.f2095e);
            if (h == null) {
                eVar.f1754b.bindNull(5);
            } else {
                eVar.f1754b.bindBlob(5, h);
            }
            byte[] h2 = b.z.e.h(pVar2.f);
            if (h2 == null) {
                eVar.f1754b.bindNull(6);
            } else {
                eVar.f1754b.bindBlob(6, h2);
            }
            eVar.f1754b.bindLong(7, pVar2.g);
            eVar.f1754b.bindLong(8, pVar2.h);
            eVar.f1754b.bindLong(9, pVar2.i);
            eVar.f1754b.bindLong(10, (long) pVar2.k);
            b.z.a aVar = pVar2.l;
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                i = 0;
            } else if (ordinal == 1) {
                i = 1;
            } else {
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
            }
            eVar.f1754b.bindLong(11, (long) i);
            eVar.f1754b.bindLong(12, pVar2.m);
            eVar.f1754b.bindLong(13, pVar2.n);
            eVar.f1754b.bindLong(14, pVar2.o);
            eVar.f1754b.bindLong(15, pVar2.p);
            eVar.f1754b.bindLong(16, pVar2.q ? 1 : 0);
            b.z.c cVar = pVar2.j;
            if (cVar != null) {
                n nVar = cVar.f1898a;
                int ordinal2 = nVar.ordinal();
                if (ordinal2 != 0) {
                    if (ordinal2 != 1) {
                        if (ordinal2 == 2) {
                            i2 = 2;
                        } else if (ordinal2 == 3) {
                            i2 = 3;
                        } else if (ordinal2 != 4) {
                            throw new IllegalArgumentException("Could not convert " + nVar + " to int");
                        }
                    }
                    i3 = i2;
                } else {
                    i3 = 0;
                }
                eVar.f1754b.bindLong(17, (long) i3);
                eVar.f1754b.bindLong(18, cVar.f1899b ? 1 : 0);
                eVar.f1754b.bindLong(19, cVar.f1900c ? 1 : 0);
                eVar.f1754b.bindLong(20, cVar.f1901d ? 1 : 0);
                eVar.f1754b.bindLong(21, cVar.f1902e ? 1 : 0);
                eVar.f1754b.bindLong(22, cVar.f);
                eVar.f1754b.bindLong(23, cVar.g);
                b.z.d dVar = cVar.h;
                byte[] bArr = null;
                ObjectOutputStream objectOutputStream = null;
                if (dVar.a() != 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream2.writeInt(dVar.a());
                            for (d.a aVar2 : dVar.f1908a) {
                                objectOutputStream2.writeUTF(aVar2.f1909a.toString());
                                objectOutputStream2.writeBoolean(aVar2.f1910b);
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
                                if (bArr != null) {
                                }
                                eVar.f1754b.bindNull(24);
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
                        if (bArr != null) {
                        }
                        eVar.f1754b.bindNull(24);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                }
                if (bArr != null) {
                    eVar.f1754b.bindBlob(24, bArr);
                    return;
                }
            } else {
                eVar.f1754b.bindNull(17);
                eVar.f1754b.bindNull(18);
                eVar.f1754b.bindNull(19);
                eVar.f1754b.bindNull(20);
                eVar.f1754b.bindNull(21);
                eVar.f1754b.bindNull(22);
                eVar.f1754b.bindNull(23);
            }
            eVar.f1754b.bindNull(24);
        }

        @Override // b.r.m
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends m {
        public b(r rVar, b.r.h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class c extends m {
        public c(r rVar, b.r.h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class d extends m {
        public d(r rVar, b.r.h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    public class e extends m {
        public e(r rVar, b.r.h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class f extends m {
        public f(r rVar, b.r.h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public class g extends m {
        public g(r rVar, b.r.h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class h extends m {
        public h(r rVar, b.r.h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public class i extends m {
        public i(r rVar, b.r.h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public r(b.r.h hVar) {
        this.f2098a = hVar;
        this.f2099b = new a(this, hVar);
        this.f2100c = new b(this, hVar);
        this.f2101d = new c(this, hVar);
        this.f2102e = new d(this, hVar);
        this.f = new e(this, hVar);
        this.g = new f(this, hVar);
        this.h = new g(this, hVar);
        this.i = new h(this, hVar);
        new i(this, hVar);
    }

    public void a(String str) {
        this.f2098a.assertNotSuspendingTransaction();
        b.u.a.g.f acquire = this.f2100c.acquire();
        if (str == null) {
            ((b.u.a.g.e) acquire).f1754b.bindNull(1);
        } else {
            ((b.u.a.g.e) acquire).f1754b.bindString(1, str);
        }
        this.f2098a.beginTransaction();
        acquire = (b.u.a.g.f) acquire;
        try {
            acquire.b();
            this.f2098a.setTransactionSuccessful();
        } finally {
            this.f2098a.endTransaction();
            this.f2100c.release(acquire);
        }
    }

    public List<p> b(int i2) {
        j jVar;
        Throwable th;
        j d2 = j.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        d2.e(1, (long) i2);
        this.f2098a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2098a, d2, false, null);
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
                    b.z.c cVar = new b.z.c();
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
                    pVar.f2095e = b.z.e.g(b2.getBlob(a013));
                    pVar.f = b.z.e.g(b2.getBlob(i3));
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
                    a02 = a02;
                    a012 = a012;
                    a015 = a015;
                    a016 = a016;
                    a018 = a018;
                    a09 = a09;
                    a011 = a011;
                    a0 = a0;
                    a022 = a022;
                    a03 = a03;
                    a020 = a020;
                    a04 = a04;
                    a019 = a019;
                }
                b2.close();
                jVar.h();
                return arrayList;
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
    }

    public List<String> c() {
        j d2 = j.d("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f2098a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2098a, d2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public List<p> d(int i2) {
        j jVar;
        Throwable th;
        j d2 = j.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        d2.e(1, (long) i2);
        this.f2098a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2098a, d2, false, null);
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
                    b.z.c cVar = new b.z.c();
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
                    pVar.f2095e = b.z.e.g(b2.getBlob(a013));
                    pVar.f = b.z.e.g(b2.getBlob(i3));
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
                    a02 = a02;
                    a012 = a012;
                    a015 = a015;
                    a016 = a016;
                    a018 = a018;
                    a09 = a09;
                    a011 = a011;
                    a0 = a0;
                    a022 = a022;
                    a03 = a03;
                    a020 = a020;
                    a04 = a04;
                    a019 = a019;
                }
                b2.close();
                jVar.h();
                return arrayList;
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
    }

    public List<p> e() {
        j jVar;
        Throwable th;
        j d2 = j.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.f2098a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2098a, d2, false, null);
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
                int i2 = a014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(a09);
                    String string2 = b2.getString(a011);
                    b.z.c cVar = new b.z.c();
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
                    pVar.f2095e = b.z.e.g(b2.getBlob(a013));
                    pVar.f = b.z.e.g(b2.getBlob(i2));
                    i2 = i2;
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
                    a02 = a02;
                    a013 = a013;
                    a015 = a015;
                    a016 = a016;
                    a018 = a018;
                    a09 = a09;
                    a011 = a011;
                    a0 = a0;
                    a022 = a022;
                    a03 = a03;
                    a020 = a020;
                    a04 = a04;
                    a019 = a019;
                }
                b2.close();
                jVar.h();
                return arrayList;
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
    }

    public List<p> f() {
        j jVar;
        Throwable th;
        j d2 = j.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f2098a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2098a, d2, false, null);
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
                int i2 = a014;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(a09);
                    String string2 = b2.getString(a011);
                    b.z.c cVar = new b.z.c();
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
                    pVar.f2095e = b.z.e.g(b2.getBlob(a013));
                    pVar.f = b.z.e.g(b2.getBlob(i2));
                    i2 = i2;
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
                    a02 = a02;
                    a013 = a013;
                    a015 = a015;
                    a016 = a016;
                    a018 = a018;
                    a09 = a09;
                    a011 = a011;
                    a0 = a0;
                    a022 = a022;
                    a03 = a03;
                    a020 = a020;
                    a04 = a04;
                    a019 = a019;
                }
                b2.close();
                jVar.h();
                return arrayList;
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
    }

    public u g(String str) {
        j d2 = j.d("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            d2.f(1);
        } else {
            d2.g(1, str);
        }
        this.f2098a.assertNotSuspendingTransaction();
        u uVar = null;
        Cursor b2 = b.r.q.b.b(this.f2098a, d2, false, null);
        try {
            if (b2.moveToFirst()) {
                uVar = i.j.t0(b2.getInt(0));
            }
            return uVar;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public List<String> h(String str) {
        j d2 = j.d("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            d2.f(1);
        } else {
            d2.g(1, str);
        }
        this.f2098a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2098a, d2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public p i(String str) {
        j jVar;
        Throwable th;
        p pVar;
        j d2 = j.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str == null) {
            d2.f(1);
        } else {
            d2.g(1, str);
        }
        this.f2098a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2098a, d2, false, null);
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
                if (b2.moveToFirst()) {
                    String string = b2.getString(a09);
                    String string2 = b2.getString(a011);
                    b.z.c cVar = new b.z.c();
                    cVar.f1898a = i.j.s0(b2.getInt(a0));
                    cVar.f1899b = b2.getInt(a02) != 0;
                    cVar.f1900c = b2.getInt(a03) != 0;
                    cVar.f1901d = b2.getInt(a04) != 0;
                    cVar.f1902e = b2.getInt(a05) != 0;
                    cVar.f = b2.getLong(a06);
                    cVar.g = b2.getLong(a07);
                    cVar.h = i.j.g(b2.getBlob(a08));
                    p pVar2 = new p(string, string2);
                    pVar2.f2092b = i.j.t0(b2.getInt(a010));
                    pVar2.f2094d = b2.getString(a012);
                    pVar2.f2095e = b.z.e.g(b2.getBlob(a013));
                    pVar2.f = b.z.e.g(b2.getBlob(a014));
                    pVar2.g = b2.getLong(a015);
                    pVar2.h = b2.getLong(a016);
                    pVar2.i = b2.getLong(a017);
                    pVar2.k = b2.getInt(a018);
                    pVar2.l = i.j.r0(b2.getInt(a019));
                    pVar2.m = b2.getLong(a020);
                    pVar2.n = b2.getLong(a021);
                    pVar2.o = b2.getLong(a022);
                    pVar2.p = b2.getLong(a023);
                    pVar2.q = b2.getInt(a024) != 0;
                    pVar2.j = cVar;
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                b2.close();
                jVar.h();
                return pVar;
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
    }

    public List<p.a> j(String str) {
        j d2 = j.d("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            d2.f(1);
        } else {
            d2.g(1, str);
        }
        this.f2098a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2098a, d2, false, null);
        try {
            int a0 = i.j.a0(b2, "id");
            int a02 = i.j.a0(b2, "state");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                p.a aVar = new p.a();
                aVar.f2096a = b2.getString(a0);
                aVar.f2097b = i.j.t0(b2.getInt(a02));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public int k(String str) {
        this.f2098a.assertNotSuspendingTransaction();
        b.u.a.g.f acquire = this.f.acquire();
        if (str == null) {
            ((b.u.a.g.e) acquire).f1754b.bindNull(1);
        } else {
            ((b.u.a.g.e) acquire).f1754b.bindString(1, str);
        }
        this.f2098a.beginTransaction();
        acquire = (b.u.a.g.f) acquire;
        try {
            int b2 = acquire.b();
            this.f2098a.setTransactionSuccessful();
            return b2;
        } finally {
            this.f2098a.endTransaction();
            this.f.release(acquire);
        }
    }

    public int l(String str, long j) {
        this.f2098a.assertNotSuspendingTransaction();
        b.u.a.f acquire = this.h.acquire();
        ((b.u.a.g.e) acquire).f1754b.bindLong(1, j);
        if (str == null) {
            ((b.u.a.g.e) acquire).f1754b.bindNull(2);
        } else {
            ((b.u.a.g.e) acquire).f1754b.bindString(2, str);
        }
        this.f2098a.beginTransaction();
        try {
            int b2 = ((b.u.a.g.f) acquire).b();
            this.f2098a.setTransactionSuccessful();
            return b2;
        } finally {
            this.f2098a.endTransaction();
            this.h.release(acquire);
        }
    }

    public int m(String str) {
        this.f2098a.assertNotSuspendingTransaction();
        b.u.a.g.f acquire = this.g.acquire();
        if (str == null) {
            ((b.u.a.g.e) acquire).f1754b.bindNull(1);
        } else {
            ((b.u.a.g.e) acquire).f1754b.bindString(1, str);
        }
        this.f2098a.beginTransaction();
        acquire = (b.u.a.g.f) acquire;
        try {
            int b2 = acquire.b();
            this.f2098a.setTransactionSuccessful();
            return b2;
        } finally {
            this.f2098a.endTransaction();
            this.g.release(acquire);
        }
    }

    public void n(String str, b.z.e eVar) {
        this.f2098a.assertNotSuspendingTransaction();
        b.u.a.g.f acquire = this.f2101d.acquire();
        byte[] h2 = b.z.e.h(eVar);
        if (h2 == null) {
            ((b.u.a.g.e) acquire).f1754b.bindNull(1);
        } else {
            ((b.u.a.g.e) acquire).f1754b.bindBlob(1, h2);
        }
        if (str == null) {
            ((b.u.a.g.e) acquire).f1754b.bindNull(2);
        } else {
            ((b.u.a.g.e) acquire).f1754b.bindString(2, str);
        }
        this.f2098a.beginTransaction();
        acquire = (b.u.a.g.f) acquire;
        try {
            acquire.b();
            this.f2098a.setTransactionSuccessful();
        } finally {
            this.f2098a.endTransaction();
            this.f2101d.release(acquire);
        }
    }

    public void o(String str, long j) {
        this.f2098a.assertNotSuspendingTransaction();
        b.u.a.f acquire = this.f2102e.acquire();
        ((b.u.a.g.e) acquire).f1754b.bindLong(1, j);
        if (str == null) {
            ((b.u.a.g.e) acquire).f1754b.bindNull(2);
        } else {
            ((b.u.a.g.e) acquire).f1754b.bindString(2, str);
        }
        this.f2098a.beginTransaction();
        try {
            ((b.u.a.g.f) acquire).b();
            this.f2098a.setTransactionSuccessful();
        } finally {
            this.f2098a.endTransaction();
            this.f2102e.release(acquire);
        }
    }

    public int p(u uVar, String... strArr) {
        this.f2098a.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE workspec SET state=");
        sb.append("?");
        sb.append(" WHERE id IN (");
        b.r.q.c.a(sb, strArr.length);
        sb.append(")");
        b.u.a.f compileStatement = this.f2098a.compileStatement(sb.toString());
        long h1 = (long) i.j.h1(uVar);
        b.u.a.g.e eVar = (b.u.a.g.e) compileStatement;
        eVar.f1754b.bindLong(1, h1);
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                eVar.f1754b.bindNull(i2);
            } else {
                eVar.f1754b.bindString(i2, str);
            }
            i2++;
        }
        this.f2098a.beginTransaction();
        try {
            int b2 = ((b.u.a.g.f) compileStatement).b();
            this.f2098a.setTransactionSuccessful();
            return b2;
        } finally {
            this.f2098a.endTransaction();
        }
    }
}
