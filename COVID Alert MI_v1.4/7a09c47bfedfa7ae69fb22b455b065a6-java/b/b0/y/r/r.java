package b.b0.y.r;

import android.database.Cursor;
import b.b.k.i;
import b.b0.d;
import b.b0.n;
import b.b0.u;
import b.b0.y.r.p;
import b.s.j;
import b.s.m;
import b.x.t;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class r implements q {

    /* renamed from: a  reason: collision with root package name */
    public final b.s.h f1243a;

    /* renamed from: b  reason: collision with root package name */
    public final b.s.b<p> f1244b;

    /* renamed from: c  reason: collision with root package name */
    public final m f1245c;

    /* renamed from: d  reason: collision with root package name */
    public final m f1246d;

    /* renamed from: e  reason: collision with root package name */
    public final m f1247e;

    /* renamed from: f  reason: collision with root package name */
    public final m f1248f;

    /* renamed from: g  reason: collision with root package name */
    public final m f1249g;
    public final m h;
    public final m i;

    public class a extends b.s.b<p> {
        public a(r rVar, b.s.h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.w.a.f, java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x01bb  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01d4  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x01e0 A[SYNTHETIC, Splitter:B:74:0x01e0] */
        @Override // b.s.b
        public void bind(b.w.a.f fVar, p pVar) {
            int i;
            Throwable th;
            IOException e2;
            p pVar2 = pVar;
            String str = pVar2.f1234a;
            int i2 = 1;
            if (str == null) {
                ((b.w.a.g.e) fVar).f2630b.bindNull(1);
            } else {
                ((b.w.a.g.e) fVar).f2630b.bindString(1, str);
            }
            b.w.a.g.e eVar = (b.w.a.g.e) fVar;
            eVar.f2630b.bindLong(2, (long) t.P2(pVar2.f1235b));
            String str2 = pVar2.f1236c;
            if (str2 == null) {
                eVar.f2630b.bindNull(3);
            } else {
                eVar.f2630b.bindString(3, str2);
            }
            String str3 = pVar2.f1237d;
            int i3 = 4;
            if (str3 == null) {
                eVar.f2630b.bindNull(4);
            } else {
                eVar.f2630b.bindString(4, str3);
            }
            byte[] h = b.b0.e.h(pVar2.f1238e);
            if (h == null) {
                eVar.f2630b.bindNull(5);
            } else {
                eVar.f2630b.bindBlob(5, h);
            }
            byte[] h2 = b.b0.e.h(pVar2.f1239f);
            if (h2 == null) {
                eVar.f2630b.bindNull(6);
            } else {
                eVar.f2630b.bindBlob(6, h2);
            }
            eVar.f2630b.bindLong(7, pVar2.f1240g);
            eVar.f2630b.bindLong(8, pVar2.h);
            eVar.f2630b.bindLong(9, pVar2.i);
            eVar.f2630b.bindLong(10, (long) pVar2.k);
            b.b0.a aVar = pVar2.l;
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                i = 0;
            } else if (ordinal == 1) {
                i = 1;
            } else {
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
            }
            eVar.f2630b.bindLong(11, (long) i);
            eVar.f2630b.bindLong(12, pVar2.m);
            eVar.f2630b.bindLong(13, pVar2.n);
            eVar.f2630b.bindLong(14, pVar2.o);
            eVar.f2630b.bindLong(15, pVar2.p);
            eVar.f2630b.bindLong(16, pVar2.q ? 1 : 0);
            b.b0.c cVar = pVar2.j;
            if (cVar != null) {
                n nVar = cVar.f1009a;
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
                eVar.f2630b.bindLong(17, (long) i3);
                eVar.f2630b.bindLong(18, cVar.f1010b ? 1 : 0);
                eVar.f2630b.bindLong(19, cVar.f1011c ? 1 : 0);
                eVar.f2630b.bindLong(20, cVar.f1012d ? 1 : 0);
                eVar.f2630b.bindLong(21, cVar.f1013e ? 1 : 0);
                eVar.f2630b.bindLong(22, cVar.f1014f);
                eVar.f2630b.bindLong(23, cVar.f1015g);
                b.b0.d dVar = cVar.h;
                byte[] bArr = null;
                ObjectOutputStream objectOutputStream = null;
                if (dVar.a() != 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream2.writeInt(dVar.a());
                            for (d.a aVar2 : dVar.f1023a) {
                                objectOutputStream2.writeUTF(aVar2.f1024a.toString());
                                objectOutputStream2.writeBoolean(aVar2.f1025b);
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
                                eVar.f2630b.bindNull(24);
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
                        eVar.f2630b.bindNull(24);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                }
                if (bArr != null) {
                    eVar.f2630b.bindBlob(24, bArr);
                    return;
                }
            } else {
                eVar.f2630b.bindNull(17);
                eVar.f2630b.bindNull(18);
                eVar.f2630b.bindNull(19);
                eVar.f2630b.bindNull(20);
                eVar.f2630b.bindNull(21);
                eVar.f2630b.bindNull(22);
                eVar.f2630b.bindNull(23);
            }
            eVar.f2630b.bindNull(24);
        }

        @Override // b.s.m
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends m {
        public b(r rVar, b.s.h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class c extends m {
        public c(r rVar, b.s.h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class d extends m {
        public d(r rVar, b.s.h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    public class e extends m {
        public e(r rVar, b.s.h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class f extends m {
        public f(r rVar, b.s.h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public class g extends m {
        public g(r rVar, b.s.h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class h extends m {
        public h(r rVar, b.s.h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public class i extends m {
        public i(r rVar, b.s.h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public r(b.s.h hVar) {
        this.f1243a = hVar;
        this.f1244b = new a(this, hVar);
        this.f1245c = new b(this, hVar);
        this.f1246d = new c(this, hVar);
        this.f1247e = new d(this, hVar);
        this.f1248f = new e(this, hVar);
        this.f1249g = new f(this, hVar);
        this.h = new g(this, hVar);
        this.i = new h(this, hVar);
        new i(this, hVar);
    }

    public void a(String str) {
        this.f1243a.assertNotSuspendingTransaction();
        b.w.a.g.f acquire = this.f1245c.acquire();
        if (str == null) {
            ((b.w.a.g.e) acquire).f2630b.bindNull(1);
        } else {
            ((b.w.a.g.e) acquire).f2630b.bindString(1, str);
        }
        this.f1243a.beginTransaction();
        acquire = (b.w.a.g.f) acquire;
        try {
            acquire.b();
            this.f1243a.setTransactionSuccessful();
        } finally {
            this.f1243a.endTransaction();
            this.f1245c.release(acquire);
        }
    }

    public List<p> b(int i2) {
        j jVar;
        Throwable th;
        j c2 = j.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        c2.d(1, (long) i2);
        this.f1243a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1243a, c2, false, null);
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
                    b.b0.c cVar = new b.b0.c();
                    cVar.f1009a = t.P1(b2.getInt(y));
                    cVar.f1010b = b2.getInt(y2) != 0;
                    cVar.f1011c = b2.getInt(y3) != 0;
                    cVar.f1012d = b2.getInt(y4) != 0;
                    cVar.f1013e = b2.getInt(y5) != 0;
                    cVar.f1014f = b2.getLong(y6);
                    cVar.f1015g = b2.getLong(y7);
                    cVar.h = t.n(b2.getBlob(y8));
                    p pVar = new p(string, string2);
                    pVar.f1235b = t.Q1(b2.getInt(y10));
                    pVar.f1237d = b2.getString(y12);
                    pVar.f1238e = b.b0.e.g(b2.getBlob(y13));
                    pVar.f1239f = b.b0.e.g(b2.getBlob(i3));
                    i3 = i3;
                    pVar.f1240g = b2.getLong(y15);
                    pVar.h = b2.getLong(y16);
                    pVar.i = b2.getLong(y17);
                    pVar.k = b2.getInt(y18);
                    pVar.l = t.O1(b2.getInt(y19));
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
                    y2 = y2;
                    y12 = y12;
                    y15 = y15;
                    y16 = y16;
                    y18 = y18;
                    y9 = y9;
                    y11 = y11;
                    y = y;
                    y22 = y22;
                    y3 = y3;
                    y20 = y20;
                    y4 = y4;
                    y19 = y19;
                }
                b2.close();
                jVar.g();
                return arrayList;
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
    }

    public List<String> c() {
        j c2 = j.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f1243a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1243a, c2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            c2.g();
        }
    }

    public List<p> d(int i2) {
        j jVar;
        Throwable th;
        j c2 = j.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        c2.d(1, (long) i2);
        this.f1243a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1243a, c2, false, null);
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
                    b.b0.c cVar = new b.b0.c();
                    cVar.f1009a = t.P1(b2.getInt(y));
                    cVar.f1010b = b2.getInt(y2) != 0;
                    cVar.f1011c = b2.getInt(y3) != 0;
                    cVar.f1012d = b2.getInt(y4) != 0;
                    cVar.f1013e = b2.getInt(y5) != 0;
                    cVar.f1014f = b2.getLong(y6);
                    cVar.f1015g = b2.getLong(y7);
                    cVar.h = t.n(b2.getBlob(y8));
                    p pVar = new p(string, string2);
                    pVar.f1235b = t.Q1(b2.getInt(y10));
                    pVar.f1237d = b2.getString(y12);
                    pVar.f1238e = b.b0.e.g(b2.getBlob(y13));
                    pVar.f1239f = b.b0.e.g(b2.getBlob(i3));
                    i3 = i3;
                    pVar.f1240g = b2.getLong(y15);
                    pVar.h = b2.getLong(y16);
                    pVar.i = b2.getLong(y17);
                    pVar.k = b2.getInt(y18);
                    pVar.l = t.O1(b2.getInt(y19));
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
                    y2 = y2;
                    y12 = y12;
                    y15 = y15;
                    y16 = y16;
                    y18 = y18;
                    y9 = y9;
                    y11 = y11;
                    y = y;
                    y22 = y22;
                    y3 = y3;
                    y20 = y20;
                    y4 = y4;
                    y19 = y19;
                }
                b2.close();
                jVar.g();
                return arrayList;
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
    }

    public List<p> e() {
        j jVar;
        Throwable th;
        j c2 = j.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.f1243a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1243a, c2, false, null);
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
                int i2 = y14;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(y9);
                    String string2 = b2.getString(y11);
                    b.b0.c cVar = new b.b0.c();
                    cVar.f1009a = t.P1(b2.getInt(y));
                    cVar.f1010b = b2.getInt(y2) != 0;
                    cVar.f1011c = b2.getInt(y3) != 0;
                    cVar.f1012d = b2.getInt(y4) != 0;
                    cVar.f1013e = b2.getInt(y5) != 0;
                    cVar.f1014f = b2.getLong(y6);
                    cVar.f1015g = b2.getLong(y7);
                    cVar.h = t.n(b2.getBlob(y8));
                    p pVar = new p(string, string2);
                    pVar.f1235b = t.Q1(b2.getInt(y10));
                    pVar.f1237d = b2.getString(y12);
                    pVar.f1238e = b.b0.e.g(b2.getBlob(y13));
                    pVar.f1239f = b.b0.e.g(b2.getBlob(i2));
                    i2 = i2;
                    pVar.f1240g = b2.getLong(y15);
                    pVar.h = b2.getLong(y16);
                    pVar.i = b2.getLong(y17);
                    pVar.k = b2.getInt(y18);
                    pVar.l = t.O1(b2.getInt(y19));
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
                    y2 = y2;
                    y13 = y13;
                    y15 = y15;
                    y16 = y16;
                    y18 = y18;
                    y9 = y9;
                    y11 = y11;
                    y = y;
                    y22 = y22;
                    y3 = y3;
                    y20 = y20;
                    y4 = y4;
                    y19 = y19;
                }
                b2.close();
                jVar.g();
                return arrayList;
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
    }

    public List<p> f() {
        j jVar;
        Throwable th;
        j c2 = j.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f1243a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1243a, c2, false, null);
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
                int i2 = y14;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(y9);
                    String string2 = b2.getString(y11);
                    b.b0.c cVar = new b.b0.c();
                    cVar.f1009a = t.P1(b2.getInt(y));
                    cVar.f1010b = b2.getInt(y2) != 0;
                    cVar.f1011c = b2.getInt(y3) != 0;
                    cVar.f1012d = b2.getInt(y4) != 0;
                    cVar.f1013e = b2.getInt(y5) != 0;
                    cVar.f1014f = b2.getLong(y6);
                    cVar.f1015g = b2.getLong(y7);
                    cVar.h = t.n(b2.getBlob(y8));
                    p pVar = new p(string, string2);
                    pVar.f1235b = t.Q1(b2.getInt(y10));
                    pVar.f1237d = b2.getString(y12);
                    pVar.f1238e = b.b0.e.g(b2.getBlob(y13));
                    pVar.f1239f = b.b0.e.g(b2.getBlob(i2));
                    i2 = i2;
                    pVar.f1240g = b2.getLong(y15);
                    pVar.h = b2.getLong(y16);
                    pVar.i = b2.getLong(y17);
                    pVar.k = b2.getInt(y18);
                    pVar.l = t.O1(b2.getInt(y19));
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
                    y2 = y2;
                    y13 = y13;
                    y15 = y15;
                    y16 = y16;
                    y18 = y18;
                    y9 = y9;
                    y11 = y11;
                    y = y;
                    y22 = y22;
                    y3 = y3;
                    y20 = y20;
                    y4 = y4;
                    y19 = y19;
                }
                b2.close();
                jVar.g();
                return arrayList;
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
    }

    public u g(String str) {
        j c2 = j.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            c2.e(1);
        } else {
            c2.f(1, str);
        }
        this.f1243a.assertNotSuspendingTransaction();
        u uVar = null;
        Cursor b2 = b.s.q.b.b(this.f1243a, c2, false, null);
        try {
            if (b2.moveToFirst()) {
                uVar = t.Q1(b2.getInt(0));
            }
            return uVar;
        } finally {
            b2.close();
            c2.g();
        }
    }

    public List<String> h(String str) {
        j c2 = j.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c2.e(1);
        } else {
            c2.f(1, str);
        }
        this.f1243a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1243a, c2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            c2.g();
        }
    }

    public p i(String str) {
        j jVar;
        Throwable th;
        p pVar;
        j c2 = j.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str == null) {
            c2.e(1);
        } else {
            c2.f(1, str);
        }
        this.f1243a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1243a, c2, false, null);
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
                if (b2.moveToFirst()) {
                    String string = b2.getString(y9);
                    String string2 = b2.getString(y11);
                    b.b0.c cVar = new b.b0.c();
                    cVar.f1009a = t.P1(b2.getInt(y));
                    cVar.f1010b = b2.getInt(y2) != 0;
                    cVar.f1011c = b2.getInt(y3) != 0;
                    cVar.f1012d = b2.getInt(y4) != 0;
                    cVar.f1013e = b2.getInt(y5) != 0;
                    cVar.f1014f = b2.getLong(y6);
                    cVar.f1015g = b2.getLong(y7);
                    cVar.h = t.n(b2.getBlob(y8));
                    p pVar2 = new p(string, string2);
                    pVar2.f1235b = t.Q1(b2.getInt(y10));
                    pVar2.f1237d = b2.getString(y12);
                    pVar2.f1238e = b.b0.e.g(b2.getBlob(y13));
                    pVar2.f1239f = b.b0.e.g(b2.getBlob(y14));
                    pVar2.f1240g = b2.getLong(y15);
                    pVar2.h = b2.getLong(y16);
                    pVar2.i = b2.getLong(y17);
                    pVar2.k = b2.getInt(y18);
                    pVar2.l = t.O1(b2.getInt(y19));
                    pVar2.m = b2.getLong(y20);
                    pVar2.n = b2.getLong(y21);
                    pVar2.o = b2.getLong(y22);
                    pVar2.p = b2.getLong(y23);
                    pVar2.q = b2.getInt(y24) != 0;
                    pVar2.j = cVar;
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                b2.close();
                jVar.g();
                return pVar;
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
    }

    public List<p.a> j(String str) {
        j c2 = j.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c2.e(1);
        } else {
            c2.f(1, str);
        }
        this.f1243a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1243a, c2, false, null);
        try {
            int y = i.j.y(b2, "id");
            int y2 = i.j.y(b2, "state");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                p.a aVar = new p.a();
                aVar.f1241a = b2.getString(y);
                aVar.f1242b = t.Q1(b2.getInt(y2));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            b2.close();
            c2.g();
        }
    }

    public int k(String str) {
        this.f1243a.assertNotSuspendingTransaction();
        b.w.a.g.f acquire = this.f1248f.acquire();
        if (str == null) {
            ((b.w.a.g.e) acquire).f2630b.bindNull(1);
        } else {
            ((b.w.a.g.e) acquire).f2630b.bindString(1, str);
        }
        this.f1243a.beginTransaction();
        acquire = (b.w.a.g.f) acquire;
        try {
            int b2 = acquire.b();
            this.f1243a.setTransactionSuccessful();
            return b2;
        } finally {
            this.f1243a.endTransaction();
            this.f1248f.release(acquire);
        }
    }

    public int l(String str, long j) {
        this.f1243a.assertNotSuspendingTransaction();
        b.w.a.f acquire = this.h.acquire();
        ((b.w.a.g.e) acquire).f2630b.bindLong(1, j);
        if (str == null) {
            ((b.w.a.g.e) acquire).f2630b.bindNull(2);
        } else {
            ((b.w.a.g.e) acquire).f2630b.bindString(2, str);
        }
        this.f1243a.beginTransaction();
        try {
            int b2 = ((b.w.a.g.f) acquire).b();
            this.f1243a.setTransactionSuccessful();
            return b2;
        } finally {
            this.f1243a.endTransaction();
            this.h.release(acquire);
        }
    }

    public int m(String str) {
        this.f1243a.assertNotSuspendingTransaction();
        b.w.a.g.f acquire = this.f1249g.acquire();
        if (str == null) {
            ((b.w.a.g.e) acquire).f2630b.bindNull(1);
        } else {
            ((b.w.a.g.e) acquire).f2630b.bindString(1, str);
        }
        this.f1243a.beginTransaction();
        acquire = (b.w.a.g.f) acquire;
        try {
            int b2 = acquire.b();
            this.f1243a.setTransactionSuccessful();
            return b2;
        } finally {
            this.f1243a.endTransaction();
            this.f1249g.release(acquire);
        }
    }

    public void n(String str, b.b0.e eVar) {
        this.f1243a.assertNotSuspendingTransaction();
        b.w.a.g.f acquire = this.f1246d.acquire();
        byte[] h2 = b.b0.e.h(eVar);
        if (h2 == null) {
            ((b.w.a.g.e) acquire).f2630b.bindNull(1);
        } else {
            ((b.w.a.g.e) acquire).f2630b.bindBlob(1, h2);
        }
        if (str == null) {
            ((b.w.a.g.e) acquire).f2630b.bindNull(2);
        } else {
            ((b.w.a.g.e) acquire).f2630b.bindString(2, str);
        }
        this.f1243a.beginTransaction();
        acquire = (b.w.a.g.f) acquire;
        try {
            acquire.b();
            this.f1243a.setTransactionSuccessful();
        } finally {
            this.f1243a.endTransaction();
            this.f1246d.release(acquire);
        }
    }

    public void o(String str, long j) {
        this.f1243a.assertNotSuspendingTransaction();
        b.w.a.f acquire = this.f1247e.acquire();
        ((b.w.a.g.e) acquire).f2630b.bindLong(1, j);
        if (str == null) {
            ((b.w.a.g.e) acquire).f2630b.bindNull(2);
        } else {
            ((b.w.a.g.e) acquire).f2630b.bindString(2, str);
        }
        this.f1243a.beginTransaction();
        try {
            ((b.w.a.g.f) acquire).b();
            this.f1243a.setTransactionSuccessful();
        } finally {
            this.f1243a.endTransaction();
            this.f1247e.release(acquire);
        }
    }

    public int p(u uVar, String... strArr) {
        this.f1243a.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE workspec SET state=");
        sb.append("?");
        sb.append(" WHERE id IN (");
        b.s.q.c.a(sb, strArr.length);
        sb.append(")");
        b.w.a.f compileStatement = this.f1243a.compileStatement(sb.toString());
        long P2 = (long) t.P2(uVar);
        b.w.a.g.e eVar = (b.w.a.g.e) compileStatement;
        eVar.f2630b.bindLong(1, P2);
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                eVar.f2630b.bindNull(i2);
            } else {
                eVar.f2630b.bindString(i2, str);
            }
            i2++;
        }
        this.f1243a.beginTransaction();
        try {
            int b2 = ((b.w.a.g.f) compileStatement).b();
            this.f1243a.setTransactionSuccessful();
            return b2;
        } finally {
            this.f1243a.endTransaction();
        }
    }
}
