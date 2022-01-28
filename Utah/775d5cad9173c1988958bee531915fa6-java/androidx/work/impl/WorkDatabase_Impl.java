package androidx.work.impl;

import android.content.Context;
import e.b0.a0.s.b;
import e.b0.a0.s.e;
import e.b0.a0.s.h;
import e.b0.a0.s.i;
import e.b0.a0.s.k;
import e.b0.a0.s.l;
import e.b0.a0.s.m;
import e.b0.a0.s.n;
import e.b0.a0.s.p;
import e.b0.a0.s.q;
import e.b0.a0.s.s;
import e.b0.a0.s.t;
import e.u.f;
import e.u.g;
import e.u.h;
import e.u.p.d;
import e.w.a.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public final class WorkDatabase_Impl extends WorkDatabase {
    public static final /* synthetic */ int t = 0;
    public volatile p m;
    public volatile b n;
    public volatile s o;
    public volatile h p;
    public volatile k q;
    public volatile m r;
    public volatile e s;

    public class a extends h.a {
        public a(int i2) {
            super(i2);
        }

        @Override // e.u.h.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            e.w.a.f.a aVar = (e.w.a.f.a) bVar;
            aVar.b.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            aVar.b.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            aVar.b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            aVar.b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            aVar.b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            aVar.b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            aVar.b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        @Override // e.u.h.a
        public void b(e.w.a.b bVar) {
            e.w.a.f.a aVar = (e.w.a.f.a) bVar;
            aVar.b.execSQL("DROP TABLE IF EXISTS `Dependency`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `WorkTag`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `WorkName`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `Preference`");
            WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
            int i2 = WorkDatabase_Impl.t;
            List<g.b> list = workDatabase_Impl.f1980h;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Objects.requireNonNull(WorkDatabase_Impl.this.f1980h.get(i3));
                }
            }
        }

        @Override // e.u.h.a
        public void c(e.w.a.b bVar) {
            WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
            int i2 = WorkDatabase_Impl.t;
            List<g.b> list = workDatabase_Impl.f1980h;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Objects.requireNonNull(WorkDatabase_Impl.this.f1980h.get(i3));
                }
            }
        }

        @Override // e.u.h.a
        public void d(e.w.a.b bVar) {
            WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
            int i2 = WorkDatabase_Impl.t;
            workDatabase_Impl.a = bVar;
            ((e.w.a.f.a) bVar).b.execSQL("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.i(bVar);
            List<g.b> list = WorkDatabase_Impl.this.f1980h;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    WorkDatabase_Impl.this.f1980h.get(i3).a(bVar);
                }
            }
        }

        @Override // e.u.h.a
        public void e(e.w.a.b bVar) {
        }

        @Override // e.u.h.a
        public void f(e.w.a.b bVar) {
            e.u.p.b.a(bVar);
        }

        @Override // e.u.h.a
        public h.b g(e.w.a.b bVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap.put("prerequisite_id", new d.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new d.C0058d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet2.add(new d.C0058d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            d dVar = new d("Dependency", hashMap, hashSet, hashSet2);
            d a = d.a(bVar, "Dependency");
            if (!dVar.equals(a)) {
                return new h.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + dVar + "\n Found:\n" + a);
            }
            HashMap hashMap2 = new HashMap(25);
            hashMap2.put("id", new d.a("id", "TEXT", true, 1, null, 1));
            hashMap2.put("state", new d.a("state", "INTEGER", true, 0, null, 1));
            hashMap2.put("worker_class_name", new d.a("worker_class_name", "TEXT", true, 0, null, 1));
            hashMap2.put("input_merger_class_name", new d.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            hashMap2.put("input", new d.a("input", "BLOB", true, 0, null, 1));
            hashMap2.put("output", new d.a("output", "BLOB", true, 0, null, 1));
            hashMap2.put("initial_delay", new d.a("initial_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("interval_duration", new d.a("interval_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("flex_duration", new d.a("flex_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_attempt_count", new d.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_policy", new d.a("backoff_policy", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_delay_duration", new d.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("period_start_time", new d.a("period_start_time", "INTEGER", true, 0, null, 1));
            hashMap2.put("minimum_retention_duration", new d.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("schedule_requested_at", new d.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_in_foreground", new d.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            hashMap2.put("out_of_quota_policy", new d.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            hashMap2.put("required_network_type", new d.a("required_network_type", "INTEGER", false, 0, null, 1));
            hashMap2.put("requires_charging", new d.a("requires_charging", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_device_idle", new d.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_battery_not_low", new d.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_storage_not_low", new d.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_content_update_delay", new d.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_max_content_delay", new d.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("content_uri_triggers", new d.a("content_uri_triggers", "BLOB", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new d.C0058d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            hashSet4.add(new d.C0058d("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
            d dVar2 = new d("WorkSpec", hashMap2, hashSet3, hashSet4);
            d a2 = d.a(bVar, "WorkSpec");
            if (!dVar2.equals(a2)) {
                return new h.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + dVar2 + "\n Found:\n" + a2);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new d.a("tag", "TEXT", true, 1, null, 1));
            hashMap3.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new d.C0058d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            d dVar3 = new d("WorkTag", hashMap3, hashSet5, hashSet6);
            d a3 = d.a(bVar, "WorkTag");
            if (!dVar3.equals(a3)) {
                return new h.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + dVar3 + "\n Found:\n" + a3);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap4.put("system_id", new d.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            d dVar4 = new d("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
            d a4 = d.a(bVar, "SystemIdInfo");
            if (!dVar4.equals(a4)) {
                return new h.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + dVar4 + "\n Found:\n" + a4);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("name", new d.a("name", "TEXT", true, 1, null, 1));
            hashMap5.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new d.C0058d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            d dVar5 = new d("WorkName", hashMap5, hashSet8, hashSet9);
            d a5 = d.a(bVar, "WorkName");
            if (!dVar5.equals(a5)) {
                return new h.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + dVar5 + "\n Found:\n" + a5);
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap6.put("progress", new d.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            d dVar6 = new d("WorkProgress", hashMap6, hashSet10, new HashSet(0));
            d a6 = d.a(bVar, "WorkProgress");
            if (!dVar6.equals(a6)) {
                return new h.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + dVar6 + "\n Found:\n" + a6);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put("key", new d.a("key", "TEXT", true, 1, null, 1));
            hashMap7.put("long_value", new d.a("long_value", "INTEGER", false, 0, null, 1));
            d dVar7 = new d("Preference", hashMap7, new HashSet(0), new HashSet(0));
            d a7 = d.a(bVar, "Preference");
            if (dVar7.equals(a7)) {
                return new h.b(true, null);
            }
            return new h.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + dVar7 + "\n Found:\n" + a7);
        }
    }

    @Override // e.u.g
    public f e() {
        return new f(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // e.u.g
    public c f(e.u.a aVar) {
        e.u.h hVar = new e.u.h(aVar, new a(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6");
        Context context = aVar.b;
        String str = aVar.c;
        if (context != null) {
            return aVar.a.a(new c.b(context, str, hVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }

    @Override // androidx.work.impl.WorkDatabase
    public b m() {
        b bVar;
        if (this.n != null) {
            return this.n;
        }
        synchronized (this) {
            if (this.n == null) {
                this.n = new e.b0.a0.s.c(this);
            }
            bVar = this.n;
        }
        return bVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public e n() {
        e eVar;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            if (this.s == null) {
                this.s = new e.b0.a0.s.f(this);
            }
            eVar = this.s;
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public e.b0.a0.s.h o() {
        e.b0.a0.s.h hVar;
        if (this.p != null) {
            return this.p;
        }
        synchronized (this) {
            if (this.p == null) {
                this.p = new i(this);
            }
            hVar = this.p;
        }
        return hVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public k p() {
        k kVar;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            if (this.q == null) {
                this.q = new l(this);
            }
            kVar = this.q;
        }
        return kVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public m q() {
        m mVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            if (this.r == null) {
                this.r = new n(this);
            }
            mVar = this.r;
        }
        return mVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public p r() {
        p pVar;
        if (this.m != null) {
            return this.m;
        }
        synchronized (this) {
            if (this.m == null) {
                this.m = new q(this);
            }
            pVar = this.m;
        }
        return pVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public s s() {
        s sVar;
        if (this.o != null) {
            return this.o;
        }
        synchronized (this) {
            if (this.o == null) {
                this.o = new t(this);
            }
            sVar = this.o;
        }
        return sVar;
    }
}
