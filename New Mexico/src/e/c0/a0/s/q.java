package e.c0.a0.s;

import android.database.Cursor;
import android.os.Build;
import e.b.a.m;
import e.c0.a0.s.o;
import e.c0.o;
import e.c0.r;
import e.c0.v;
import e.v.i;
import e.v.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class q implements p {
    public final e.v.g a;
    public final e.v.b<o> b;
    public final l c;

    /* renamed from: d */
    public final l f1200d;

    /* renamed from: e */
    public final l f1201e;

    /* renamed from: f */
    public final l f1202f;

    /* renamed from: g */
    public final l f1203g;

    /* renamed from: h */
    public final l f1204h;

    /* renamed from: i */
    public final l f1205i;

    /* loaded from: classes.dex */
    public class a extends e.v.b<o> {
        public a(q qVar, e.v.g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX WARN: Can't wrap try/catch for region: R(5:(4:97|57|100|58)|(4:102|59|(2:60|(1:62)(1:104))|63)|95|75|78) */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01f7, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01f8, code lost:
            r0.printStackTrace();
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x020a  */
        /* JADX WARN: Type inference failed for: r2v29, types: [int] */
        /* JADX WARN: Type inference failed for: r2v30, types: [java.io.ByteArrayOutputStream] */
        /* JADX WARN: Type inference failed for: r2v33 */
        /* JADX WARN: Type inference failed for: r2v34 */
        /* JADX WARN: Type inference failed for: r2v49 */
        /* JADX WARN: Type inference failed for: r2v50 */
        /* JADX WARN: Type inference failed for: r2v51 */
        /* JADX WARN: Type inference failed for: r2v52 */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // e.v.b
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void d(e.x.a.f.f fVar, Object obj) {
            int i2;
            int i3;
            ObjectOutputStream objectOutputStream;
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream2;
            IOException e2;
            boolean hasNext;
            o oVar = (o) obj;
            String str = oVar.a;
            int i4 = 1;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            fVar.b.bindLong(2, (long) m.e.L1(oVar.b));
            String str2 = oVar.c;
            if (str2 == null) {
                fVar.b.bindNull(3);
            } else {
                fVar.b.bindString(3, str2);
            }
            String str3 = oVar.f1191d;
            if (str3 == null) {
                fVar.b.bindNull(4);
            } else {
                fVar.b.bindString(4, str3);
            }
            byte[] c = e.c0.f.c(oVar.f1192e);
            if (c == null) {
                fVar.b.bindNull(5);
            } else {
                fVar.b.bindBlob(5, c);
            }
            byte[] c2 = e.c0.f.c(oVar.f1193f);
            if (c2 == null) {
                fVar.b.bindNull(6);
            } else {
                fVar.b.bindBlob(6, c2);
            }
            fVar.b.bindLong(7, oVar.f1194g);
            fVar.b.bindLong(8, oVar.f1195h);
            fVar.b.bindLong(9, oVar.f1196i);
            fVar.b.bindLong(10, (long) oVar.f1198k);
            e.c0.a aVar = oVar.f1199l;
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                i2 = 0;
            } else if (ordinal == 1) {
                i2 = 1;
            } else {
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
            }
            fVar.b.bindLong(11, (long) i2);
            fVar.b.bindLong(12, oVar.m);
            fVar.b.bindLong(13, oVar.n);
            fVar.b.bindLong(14, oVar.o);
            fVar.b.bindLong(15, oVar.p);
            fVar.b.bindLong(16, oVar.q ? 1 : 0);
            r rVar = oVar.r;
            int ordinal2 = rVar.ordinal();
            if (ordinal2 == 0) {
                i3 = 0;
            } else if (ordinal2 == 1) {
                i3 = 1;
            } else {
                throw new IllegalArgumentException("Could not convert " + rVar + " to int");
            }
            fVar.b.bindLong(17, (long) i3);
            e.c0.d dVar = oVar.f1197j;
            if (dVar != null) {
                o oVar2 = dVar.a;
                int ordinal3 = oVar2.ordinal();
                if (ordinal3 == 0) {
                    i4 = 0;
                } else if (ordinal3 != 1) {
                    if (ordinal3 == 2) {
                        i4 = 2;
                    } else if (ordinal3 == 3) {
                        i4 = 3;
                    } else if (ordinal3 == 4) {
                        i4 = 4;
                    } else if (Build.VERSION.SDK_INT < 30 || oVar2 != o.TEMPORARILY_UNMETERED) {
                        throw new IllegalArgumentException("Could not convert " + oVar2 + " to int");
                    } else {
                        i4 = 5;
                    }
                }
                fVar.b.bindLong(18, (long) i4);
                fVar.b.bindLong(19, dVar.b ? 1 : 0);
                fVar.b.bindLong(20, dVar.c ? 1 : 0);
                fVar.b.bindLong(21, dVar.f1241d ? 1 : 0);
                fVar.b.bindLong(22, dVar.f1242e ? 1 : 0);
                fVar.b.bindLong(23, dVar.f1243f);
                fVar.b.bindLong(24, dVar.f1244g);
                e.c0.e eVar = dVar.f1245h;
                ?? a = eVar.a();
                byte[] bArr = null;
                ObjectOutputStream objectOutputStream2 = null;
                ObjectOutputStream objectOutputStream3 = null;
                if (a != 0) {
                    try {
                        try {
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream2);
                            } catch (IOException e3) {
                                e2 = e3;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream = objectOutputStream3;
                            byteArrayOutputStream = a;
                        }
                    } catch (IOException 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v15 ??
                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:228)
                        	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:349)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:312)
                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        */
                    /*
                    // Method dump skipped, instructions count: 598
                    */
                    throw new UnsupportedOperationException("Method not decompiled: e.c0.a0.s.q.a.d(e.x.a.f.f, java.lang.Object):void");
                }
            }

            /* loaded from: classes.dex */
            public class b extends l {
                public b(q qVar, e.v.g gVar) {
                    super(gVar);
                }

                @Override // e.v.l
                public String b() {
                    return "DELETE FROM workspec WHERE id=?";
                }
            }

            /* loaded from: classes.dex */
            public class c extends l {
                public c(q qVar, e.v.g gVar) {
                    super(gVar);
                }

                @Override // e.v.l
                public String b() {
                    return "UPDATE workspec SET output=? WHERE id=?";
                }
            }

            /* loaded from: classes.dex */
            public class d extends l {
                public d(q qVar, e.v.g gVar) {
                    super(gVar);
                }

                @Override // e.v.l
                public String b() {
                    return "UPDATE workspec SET period_start_time=? WHERE id=?";
                }
            }

            /* loaded from: classes.dex */
            public class e extends l {
                public e(q qVar, e.v.g gVar) {
                    super(gVar);
                }

                @Override // e.v.l
                public String b() {
                    return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
                }
            }

            /* loaded from: classes.dex */
            public class f extends l {
                public f(q qVar, e.v.g gVar) {
                    super(gVar);
                }

                @Override // e.v.l
                public String b() {
                    return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
                }
            }

            /* loaded from: classes.dex */
            public class g extends l {
                public g(q qVar, e.v.g gVar) {
                    super(gVar);
                }

                @Override // e.v.l
                public String b() {
                    return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
                }
            }

            /* loaded from: classes.dex */
            public class h extends l {
                public h(q qVar, e.v.g gVar) {
                    super(gVar);
                }

                @Override // e.v.l
                public String b() {
                    return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
                }
            }

            public q(e.v.g gVar) {
                this.a = gVar;
                this.b = new a(this, gVar);
                this.c = new b(this, gVar);
                this.f1200d = new c(this, gVar);
                this.f1201e = new d(this, gVar);
                this.f1202f = new e(this, gVar);
                this.f1203g = new f(this, gVar);
                this.f1204h = new g(this, gVar);
                this.f1205i = new h(this, gVar);
                new AtomicBoolean(false);
            }

            public void a(String str) {
                this.a.b();
                e.x.a.f.f a2 = this.c.a();
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
                Cursor b2 = e.v.p.b.b(this.a, t, false, null);
                try {
                    int h0 = m.e.h0(b2, "required_network_type");
                    int h02 = m.e.h0(b2, "requires_charging");
                    int h03 = m.e.h0(b2, "requires_device_idle");
                    int h04 = m.e.h0(b2, "requires_battery_not_low");
                    int h05 = m.e.h0(b2, "requires_storage_not_low");
                    int h06 = m.e.h0(b2, "trigger_content_update_delay");
                    int h07 = m.e.h0(b2, "trigger_max_content_delay");
                    int h08 = m.e.h0(b2, "content_uri_triggers");
                    int h09 = m.e.h0(b2, "id");
                    int h010 = m.e.h0(b2, "state");
                    int h011 = m.e.h0(b2, "worker_class_name");
                    int h012 = m.e.h0(b2, "input_merger_class_name");
                    int h013 = m.e.h0(b2, "input");
                    int h014 = m.e.h0(b2, "output");
                    iVar = t;
                    try {
                        int h015 = m.e.h0(b2, "initial_delay");
                        int h016 = m.e.h0(b2, "interval_duration");
                        int h017 = m.e.h0(b2, "flex_duration");
                        int h018 = m.e.h0(b2, "run_attempt_count");
                        int h019 = m.e.h0(b2, "backoff_policy");
                        int h020 = m.e.h0(b2, "backoff_delay_duration");
                        int h021 = m.e.h0(b2, "period_start_time");
                        int h022 = m.e.h0(b2, "minimum_retention_duration");
                        int h023 = m.e.h0(b2, "schedule_requested_at");
                        int h024 = m.e.h0(b2, "run_in_foreground");
                        int h025 = m.e.h0(b2, "out_of_quota_policy");
                        ArrayList arrayList = new ArrayList(b2.getCount());
                        while (b2.moveToNext()) {
                            String string = b2.getString(h09);
                            String string2 = b2.getString(h011);
                            e.c0.d dVar = new e.c0.d();
                            dVar.a = m.e.H0(b2.getInt(h0));
                            dVar.b = b2.getInt(h02) != 0;
                            dVar.c = b2.getInt(h03) != 0;
                            dVar.f1241d = b2.getInt(h04) != 0;
                            dVar.f1242e = b2.getInt(h05) != 0;
                            dVar.f1243f = b2.getLong(h06);
                            dVar.f1244g = b2.getLong(h07);
                            dVar.f1245h = m.e.f(b2.getBlob(h08));
                            o oVar = new o(string, string2);
                            oVar.b = m.e.J0(b2.getInt(h010));
                            oVar.f1191d = b2.getString(h012);
                            oVar.f1192e = e.c0.f.b(b2.getBlob(h013));
                            oVar.f1193f = e.c0.f.b(b2.getBlob(h014));
                            h014 = h014;
                            oVar.f1194g = b2.getLong(h015);
                            oVar.f1195h = b2.getLong(h016);
                            oVar.f1196i = b2.getLong(h017);
                            oVar.f1198k = b2.getInt(h018);
                            oVar.f1199l = m.e.G0(b2.getInt(h019));
                            h017 = h017;
                            oVar.m = b2.getLong(h020);
                            oVar.n = b2.getLong(h021);
                            h021 = h021;
                            oVar.o = b2.getLong(h022);
                            oVar.p = b2.getLong(h023);
                            oVar.q = b2.getInt(h024) != 0;
                            oVar.r = m.e.I0(b2.getInt(h025));
                            oVar.f1197j = dVar;
                            arrayList.add(oVar);
                            h025 = h025;
                            h02 = h02;
                            h012 = h012;
                            h015 = h015;
                            h016 = h016;
                            h018 = h018;
                            h023 = h023;
                            h09 = h09;
                            h011 = h011;
                            h0 = h0;
                            h024 = h024;
                            h022 = h022;
                            h03 = h03;
                            h020 = h020;
                            h04 = h04;
                            h019 = h019;
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
                }
            }

            public List<String> c() {
                i t = i.t("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
                this.a.b();
                Cursor b2 = e.v.p.b.b(this.a, t, false, null);
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
                Cursor b2 = e.v.p.b.b(this.a, t, false, null);
                try {
                    int h0 = m.e.h0(b2, "required_network_type");
                    int h02 = m.e.h0(b2, "requires_charging");
                    int h03 = m.e.h0(b2, "requires_device_idle");
                    int h04 = m.e.h0(b2, "requires_battery_not_low");
                    int h05 = m.e.h0(b2, "requires_storage_not_low");
                    int h06 = m.e.h0(b2, "trigger_content_update_delay");
                    int h07 = m.e.h0(b2, "trigger_max_content_delay");
                    int h08 = m.e.h0(b2, "content_uri_triggers");
                    int h09 = m.e.h0(b2, "id");
                    int h010 = m.e.h0(b2, "state");
                    int h011 = m.e.h0(b2, "worker_class_name");
                    int h012 = m.e.h0(b2, "input_merger_class_name");
                    int h013 = m.e.h0(b2, "input");
                    int h014 = m.e.h0(b2, "output");
                    iVar = t;
                    try {
                        int h015 = m.e.h0(b2, "initial_delay");
                        int h016 = m.e.h0(b2, "interval_duration");
                        int h017 = m.e.h0(b2, "flex_duration");
                        int h018 = m.e.h0(b2, "run_attempt_count");
                        int h019 = m.e.h0(b2, "backoff_policy");
                        int h020 = m.e.h0(b2, "backoff_delay_duration");
                        int h021 = m.e.h0(b2, "period_start_time");
                        int h022 = m.e.h0(b2, "minimum_retention_duration");
                        int h023 = m.e.h0(b2, "schedule_requested_at");
                        int h024 = m.e.h0(b2, "run_in_foreground");
                        int h025 = m.e.h0(b2, "out_of_quota_policy");
                        ArrayList arrayList = new ArrayList(b2.getCount());
                        while (b2.moveToNext()) {
                            String string = b2.getString(h09);
                            String string2 = b2.getString(h011);
                            e.c0.d dVar = new e.c0.d();
                            dVar.a = m.e.H0(b2.getInt(h0));
                            dVar.b = b2.getInt(h02) != 0;
                            dVar.c = b2.getInt(h03) != 0;
                            dVar.f1241d = b2.getInt(h04) != 0;
                            dVar.f1242e = b2.getInt(h05) != 0;
                            dVar.f1243f = b2.getLong(h06);
                            dVar.f1244g = b2.getLong(h07);
                            dVar.f1245h = m.e.f(b2.getBlob(h08));
                            o oVar = new o(string, string2);
                            oVar.b = m.e.J0(b2.getInt(h010));
                            oVar.f1191d = b2.getString(h012);
                            oVar.f1192e = e.c0.f.b(b2.getBlob(h013));
                            oVar.f1193f = e.c0.f.b(b2.getBlob(h014));
                            h014 = h014;
                            oVar.f1194g = b2.getLong(h015);
                            oVar.f1195h = b2.getLong(h016);
                            oVar.f1196i = b2.getLong(h017);
                            oVar.f1198k = b2.getInt(h018);
                            oVar.f1199l = m.e.G0(b2.getInt(h019));
                            h017 = h017;
                            oVar.m = b2.getLong(h020);
                            oVar.n = b2.getLong(h021);
                            h021 = h021;
                            oVar.o = b2.getLong(h022);
                            oVar.p = b2.getLong(h023);
                            oVar.q = b2.getInt(h024) != 0;
                            oVar.r = m.e.I0(b2.getInt(h025));
                            oVar.f1197j = dVar;
                            arrayList.add(oVar);
                            h025 = h025;
                            h02 = h02;
                            h012 = h012;
                            h015 = h015;
                            h016 = h016;
                            h018 = h018;
                            h023 = h023;
                            h09 = h09;
                            h011 = h011;
                            h0 = h0;
                            h024 = h024;
                            h022 = h022;
                            h03 = h03;
                            h020 = h020;
                            h04 = h04;
                            h019 = h019;
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
                }
            }

            public List<o> e() {
                i iVar;
                Throwable th;
                int h0;
                int h02;
                int h03;
                int h04;
                int h05;
                int h06;
                int h07;
                int h08;
                int h09;
                int h010;
                int h011;
                int h012;
                int h013;
                int h014;
                i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
                this.a.b();
                Cursor b2 = e.v.p.b.b(this.a, t, false, null);
                try {
                    h0 = m.e.h0(b2, "required_network_type");
                    h02 = m.e.h0(b2, "requires_charging");
                    h03 = m.e.h0(b2, "requires_device_idle");
                    h04 = m.e.h0(b2, "requires_battery_not_low");
                    h05 = m.e.h0(b2, "requires_storage_not_low");
                    h06 = m.e.h0(b2, "trigger_content_update_delay");
                    h07 = m.e.h0(b2, "trigger_max_content_delay");
                    h08 = m.e.h0(b2, "content_uri_triggers");
                    h09 = m.e.h0(b2, "id");
                    h010 = m.e.h0(b2, "state");
                    h011 = m.e.h0(b2, "worker_class_name");
                    h012 = m.e.h0(b2, "input_merger_class_name");
                    h013 = m.e.h0(b2, "input");
                    h014 = m.e.h0(b2, "output");
                    iVar = t;
                } catch (Throwable th2) {
                    th = th2;
                    iVar = t;
                }
                try {
                    int h015 = m.e.h0(b2, "initial_delay");
                    int h016 = m.e.h0(b2, "interval_duration");
                    int h017 = m.e.h0(b2, "flex_duration");
                    int h018 = m.e.h0(b2, "run_attempt_count");
                    int h019 = m.e.h0(b2, "backoff_policy");
                    int h020 = m.e.h0(b2, "backoff_delay_duration");
                    int h021 = m.e.h0(b2, "period_start_time");
                    int h022 = m.e.h0(b2, "minimum_retention_duration");
                    int h023 = m.e.h0(b2, "schedule_requested_at");
                    int h024 = m.e.h0(b2, "run_in_foreground");
                    int h025 = m.e.h0(b2, "out_of_quota_policy");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        String string = b2.getString(h09);
                        String string2 = b2.getString(h011);
                        e.c0.d dVar = new e.c0.d();
                        dVar.a = m.e.H0(b2.getInt(h0));
                        dVar.b = b2.getInt(h02) != 0;
                        dVar.c = b2.getInt(h03) != 0;
                        dVar.f1241d = b2.getInt(h04) != 0;
                        dVar.f1242e = b2.getInt(h05) != 0;
                        dVar.f1243f = b2.getLong(h06);
                        dVar.f1244g = b2.getLong(h07);
                        dVar.f1245h = m.e.f(b2.getBlob(h08));
                        o oVar = new o(string, string2);
                        oVar.b = m.e.J0(b2.getInt(h010));
                        oVar.f1191d = b2.getString(h012);
                        oVar.f1192e = e.c0.f.b(b2.getBlob(h013));
                        oVar.f1193f = e.c0.f.b(b2.getBlob(h014));
                        h014 = h014;
                        oVar.f1194g = b2.getLong(h015);
                        oVar.f1195h = b2.getLong(h016);
                        oVar.f1196i = b2.getLong(h017);
                        oVar.f1198k = b2.getInt(h018);
                        oVar.f1199l = m.e.G0(b2.getInt(h019));
                        h017 = h017;
                        oVar.m = b2.getLong(h020);
                        oVar.n = b2.getLong(h021);
                        h021 = h021;
                        oVar.o = b2.getLong(h022);
                        oVar.p = b2.getLong(h023);
                        oVar.q = b2.getInt(h024) != 0;
                        oVar.r = m.e.I0(b2.getInt(h025));
                        oVar.f1197j = dVar;
                        arrayList.add(oVar);
                        h025 = h025;
                        h02 = h02;
                        h013 = h013;
                        h015 = h015;
                        h016 = h016;
                        h018 = h018;
                        h023 = h023;
                        h09 = h09;
                        h011 = h011;
                        h0 = h0;
                        h024 = h024;
                        h022 = h022;
                        h03 = h03;
                        h020 = h020;
                        h04 = h04;
                        h019 = h019;
                    }
                    b2.close();
                    iVar.Q();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    b2.close();
                    iVar.Q();
                    throw th;
                }
            }

            public List<o> f() {
                i iVar;
                Throwable th;
                int h0;
                int h02;
                int h03;
                int h04;
                int h05;
                int h06;
                int h07;
                int h08;
                int h09;
                int h010;
                int h011;
                int h012;
                int h013;
                int h014;
                i t = i.t("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
                this.a.b();
                Cursor b2 = e.v.p.b.b(this.a, t, false, null);
                try {
                    h0 = m.e.h0(b2, "required_network_type");
                    h02 = m.e.h0(b2, "requires_charging");
                    h03 = m.e.h0(b2, "requires_device_idle");
                    h04 = m.e.h0(b2, "requires_battery_not_low");
                    h05 = m.e.h0(b2, "requires_storage_not_low");
                    h06 = m.e.h0(b2, "trigger_content_update_delay");
                    h07 = m.e.h0(b2, "trigger_max_content_delay");
                    h08 = m.e.h0(b2, "content_uri_triggers");
                    h09 = m.e.h0(b2, "id");
                    h010 = m.e.h0(b2, "state");
                    h011 = m.e.h0(b2, "worker_class_name");
                    h012 = m.e.h0(b2, "input_merger_class_name");
                    h013 = m.e.h0(b2, "input");
                    h014 = m.e.h0(b2, "output");
                    iVar = t;
                } catch (Throwable th2) {
                    th = th2;
                    iVar = t;
                }
                try {
                    int h015 = m.e.h0(b2, "initial_delay");
                    int h016 = m.e.h0(b2, "interval_duration");
                    int h017 = m.e.h0(b2, "flex_duration");
                    int h018 = m.e.h0(b2, "run_attempt_count");
                    int h019 = m.e.h0(b2, "backoff_policy");
                    int h020 = m.e.h0(b2, "backoff_delay_duration");
                    int h021 = m.e.h0(b2, "period_start_time");
                    int h022 = m.e.h0(b2, "minimum_retention_duration");
                    int h023 = m.e.h0(b2, "schedule_requested_at");
                    int h024 = m.e.h0(b2, "run_in_foreground");
                    int h025 = m.e.h0(b2, "out_of_quota_policy");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        String string = b2.getString(h09);
                        String string2 = b2.getString(h011);
                        e.c0.d dVar = new e.c0.d();
                        dVar.a = m.e.H0(b2.getInt(h0));
                        dVar.b = b2.getInt(h02) != 0;
                        dVar.c = b2.getInt(h03) != 0;
                        dVar.f1241d = b2.getInt(h04) != 0;
                        dVar.f1242e = b2.getInt(h05) != 0;
                        dVar.f1243f = b2.getLong(h06);
                        dVar.f1244g = b2.getLong(h07);
                        dVar.f1245h = m.e.f(b2.getBlob(h08));
                        o oVar = new o(string, string2);
                        oVar.b = m.e.J0(b2.getInt(h010));
                        oVar.f1191d = b2.getString(h012);
                        oVar.f1192e = e.c0.f.b(b2.getBlob(h013));
                        oVar.f1193f = e.c0.f.b(b2.getBlob(h014));
                        h014 = h014;
                        oVar.f1194g = b2.getLong(h015);
                        oVar.f1195h = b2.getLong(h016);
                        oVar.f1196i = b2.getLong(h017);
                        oVar.f1198k = b2.getInt(h018);
                        oVar.f1199l = m.e.G0(b2.getInt(h019));
                        h017 = h017;
                        oVar.m = b2.getLong(h020);
                        oVar.n = b2.getLong(h021);
                        h021 = h021;
                        oVar.o = b2.getLong(h022);
                        oVar.p = b2.getLong(h023);
                        oVar.q = b2.getInt(h024) != 0;
                        oVar.r = m.e.I0(b2.getInt(h025));
                        oVar.f1197j = dVar;
                        arrayList.add(oVar);
                        h025 = h025;
                        h02 = h02;
                        h013 = h013;
                        h015 = h015;
                        h016 = h016;
                        h018 = h018;
                        h023 = h023;
                        h09 = h09;
                        h011 = h011;
                        h0 = h0;
                        h024 = h024;
                        h022 = h022;
                        h03 = h03;
                        h020 = h020;
                        h04 = h04;
                        h019 = h019;
                    }
                    b2.close();
                    iVar.Q();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
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
                Cursor b2 = e.v.p.b.b(this.a, t, false, null);
                try {
                    if (b2.moveToFirst()) {
                        vVar = m.e.J0(b2.getInt(0));
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
                Cursor b2 = e.v.p.b.b(this.a, t, false, null);
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
                Cursor b2 = e.v.p.b.b(this.a, t, false, null);
                try {
                    int h0 = m.e.h0(b2, "required_network_type");
                    int h02 = m.e.h0(b2, "requires_charging");
                    int h03 = m.e.h0(b2, "requires_device_idle");
                    int h04 = m.e.h0(b2, "requires_battery_not_low");
                    int h05 = m.e.h0(b2, "requires_storage_not_low");
                    int h06 = m.e.h0(b2, "trigger_content_update_delay");
                    int h07 = m.e.h0(b2, "trigger_max_content_delay");
                    int h08 = m.e.h0(b2, "content_uri_triggers");
                    int h09 = m.e.h0(b2, "id");
                    int h010 = m.e.h0(b2, "state");
                    int h011 = m.e.h0(b2, "worker_class_name");
                    int h012 = m.e.h0(b2, "input_merger_class_name");
                    int h013 = m.e.h0(b2, "input");
                    int h014 = m.e.h0(b2, "output");
                    iVar = t;
                    try {
                        int h015 = m.e.h0(b2, "initial_delay");
                        int h016 = m.e.h0(b2, "interval_duration");
                        int h017 = m.e.h0(b2, "flex_duration");
                        int h018 = m.e.h0(b2, "run_attempt_count");
                        int h019 = m.e.h0(b2, "backoff_policy");
                        int h020 = m.e.h0(b2, "backoff_delay_duration");
                        int h021 = m.e.h0(b2, "period_start_time");
                        int h022 = m.e.h0(b2, "minimum_retention_duration");
                        int h023 = m.e.h0(b2, "schedule_requested_at");
                        int h024 = m.e.h0(b2, "run_in_foreground");
                        int h025 = m.e.h0(b2, "out_of_quota_policy");
                        if (b2.moveToFirst()) {
                            String string = b2.getString(h09);
                            String string2 = b2.getString(h011);
                            e.c0.d dVar = new e.c0.d();
                            dVar.a = m.e.H0(b2.getInt(h0));
                            dVar.b = b2.getInt(h02) != 0;
                            dVar.c = b2.getInt(h03) != 0;
                            dVar.f1241d = b2.getInt(h04) != 0;
                            dVar.f1242e = b2.getInt(h05) != 0;
                            dVar.f1243f = b2.getLong(h06);
                            dVar.f1244g = b2.getLong(h07);
                            dVar.f1245h = m.e.f(b2.getBlob(h08));
                            o oVar2 = new o(string, string2);
                            oVar2.b = m.e.J0(b2.getInt(h010));
                            oVar2.f1191d = b2.getString(h012);
                            oVar2.f1192e = e.c0.f.b(b2.getBlob(h013));
                            oVar2.f1193f = e.c0.f.b(b2.getBlob(h014));
                            oVar2.f1194g = b2.getLong(h015);
                            oVar2.f1195h = b2.getLong(h016);
                            oVar2.f1196i = b2.getLong(h017);
                            oVar2.f1198k = b2.getInt(h018);
                            oVar2.f1199l = m.e.G0(b2.getInt(h019));
                            oVar2.m = b2.getLong(h020);
                            oVar2.n = b2.getLong(h021);
                            oVar2.o = b2.getLong(h022);
                            oVar2.p = b2.getLong(h023);
                            oVar2.q = b2.getInt(h024) != 0;
                            oVar2.r = m.e.I0(b2.getInt(h025));
                            oVar2.f1197j = dVar;
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
                Cursor b2 = e.v.p.b.b(this.a, t, false, null);
                try {
                    int h0 = m.e.h0(b2, "id");
                    int h02 = m.e.h0(b2, "state");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        o.a aVar = new o.a();
                        aVar.a = b2.getString(h0);
                        aVar.b = m.e.J0(b2.getInt(h02));
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
                e.x.a.f.f a2 = this.f1202f.a();
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
                    l lVar = this.f1202f;
                    if (a2 == lVar.c) {
                        lVar.a.set(false);
                    }
                    return d2;
                } catch (Throwable th) {
                    this.a.g();
                    this.f1202f.c(a2);
                    throw th;
                }
            }

            public int l(String str, long j2) {
                this.a.b();
                e.x.a.f.f a2 = this.f1204h.a();
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
                    l lVar = this.f1204h;
                    if (a2 == lVar.c) {
                        lVar.a.set(false);
                    }
                }
            }

            public int m(String str) {
                this.a.b();
                e.x.a.f.f a2 = this.f1203g.a();
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
                    l lVar = this.f1203g;
                    if (a2 == lVar.c) {
                        lVar.a.set(false);
                    }
                    return d2;
                } catch (Throwable th) {
                    this.a.g();
                    this.f1203g.c(a2);
                    throw th;
                }
            }

            public void n(String str, e.c0.f fVar) {
                this.a.b();
                e.x.a.f.f a2 = this.f1200d.a();
                byte[] c2 = e.c0.f.c(fVar);
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
                    l lVar = this.f1200d;
                    if (a2 == lVar.c) {
                        lVar.a.set(false);
                    }
                } catch (Throwable th) {
                    this.a.g();
                    this.f1200d.c(a2);
                    throw th;
                }
            }

            public void o(String str, long j2) {
                this.a.b();
                e.x.a.f.f a2 = this.f1201e.a();
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
                    l lVar = this.f1201e;
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
                e.v.p.c.a(sb, strArr.length);
                sb.append(")");
                e.x.a.f.f d2 = this.a.d(sb.toString());
                d2.b.bindLong(1, (long) m.e.L1(vVar));
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
