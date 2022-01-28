package androidx.work.impl;

import android.content.Context;
import b.b0.y.r.b;
import b.b0.y.r.c;
import b.b0.y.r.e;
import b.b0.y.r.h;
import b.b0.y.r.k;
import b.b0.y.r.l;
import b.b0.y.r.n;
import b.b0.y.r.o;
import b.b0.y.r.q;
import b.b0.y.r.r;
import b.b0.y.r.t;
import b.b0.y.r.u;
import b.s.f;
import b.s.h;
import b.s.i;
import b.s.q.d;
import b.w.a.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: b  reason: collision with root package name */
    public volatile q f453b;

    /* renamed from: c  reason: collision with root package name */
    public volatile b f454c;

    /* renamed from: d  reason: collision with root package name */
    public volatile t f455d;

    /* renamed from: e  reason: collision with root package name */
    public volatile h f456e;

    /* renamed from: f  reason: collision with root package name */
    public volatile k f457f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f458g;
    public volatile e h;

    public class a extends i.a {
        public a(int i) {
            super(i);
        }

        @Override // b.s.i.a
        public void createAllTables(b.w.a.b bVar) {
            ((b.w.a.g.a) bVar).f2616b.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            b.w.a.g.a aVar = (b.w.a.g.a) bVar;
            aVar.f2616b.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            aVar.f2616b.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            aVar.f2616b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            aVar.f2616b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            aVar.f2616b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            aVar.f2616b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            aVar.f2616b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cf029002fffdcadf079e8d0a1c9a70ac')");
        }

        @Override // b.s.i.a
        public void dropAllTables(b.w.a.b bVar) {
            b.w.a.g.a aVar = (b.w.a.g.a) bVar;
            aVar.f2616b.execSQL("DROP TABLE IF EXISTS `Dependency`");
            aVar.f2616b.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
            aVar.f2616b.execSQL("DROP TABLE IF EXISTS `WorkTag`");
            aVar.f2616b.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
            aVar.f2616b.execSQL("DROP TABLE IF EXISTS `WorkName`");
            aVar.f2616b.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
            aVar.f2616b.execSQL("DROP TABLE IF EXISTS `Preference`");
            if (WorkDatabase_Impl.this.mCallbacks != null) {
                int size = WorkDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    if (WorkDatabase_Impl.this.mCallbacks.get(i) == null) {
                        throw null;
                    }
                }
            }
        }

        @Override // b.s.i.a
        public void onCreate(b.w.a.b bVar) {
            if (WorkDatabase_Impl.this.mCallbacks != null) {
                int size = WorkDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    if (WorkDatabase_Impl.this.mCallbacks.get(i) == null) {
                        throw null;
                    }
                }
            }
        }

        @Override // b.s.i.a
        public void onOpen(b.w.a.b bVar) {
            WorkDatabase_Impl.this.mDatabase = bVar;
            ((b.w.a.g.a) bVar).f2616b.execSQL("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.internalInitInvalidationTracker(bVar);
            List<h.b> list = WorkDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    WorkDatabase_Impl.this.mCallbacks.get(i).a(bVar);
                }
            }
        }

        @Override // b.s.i.a
        public void onPostMigrate(b.w.a.b bVar) {
        }

        @Override // b.s.i.a
        public void onPreMigrate(b.w.a.b bVar) {
            b.s.q.b.a(bVar);
        }

        @Override // b.s.i.a
        public i.b onValidateSchema(b.w.a.b bVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap.put("prerequisite_id", new d.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new d.C0049d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet2.add(new d.C0049d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            d dVar = new d("Dependency", hashMap, hashSet, hashSet2);
            d a2 = d.a(bVar, "Dependency");
            if (!dVar.equals(a2)) {
                return new i.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + dVar + "\n Found:\n" + a2);
            }
            HashMap hashMap2 = new HashMap(24);
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
            hashSet4.add(new d.C0049d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            hashSet4.add(new d.C0049d("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
            d dVar2 = new d("WorkSpec", hashMap2, hashSet3, hashSet4);
            d a3 = d.a(bVar, "WorkSpec");
            if (!dVar2.equals(a3)) {
                return new i.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + dVar2 + "\n Found:\n" + a3);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new d.a("tag", "TEXT", true, 1, null, 1));
            hashMap3.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new d.C0049d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            d dVar3 = new d("WorkTag", hashMap3, hashSet5, hashSet6);
            d a4 = d.a(bVar, "WorkTag");
            if (!dVar3.equals(a4)) {
                return new i.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + dVar3 + "\n Found:\n" + a4);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap4.put("system_id", new d.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            d dVar4 = new d("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
            d a5 = d.a(bVar, "SystemIdInfo");
            if (!dVar4.equals(a5)) {
                return new i.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + dVar4 + "\n Found:\n" + a5);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("name", new d.a("name", "TEXT", true, 1, null, 1));
            hashMap5.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new d.C0049d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            d dVar5 = new d("WorkName", hashMap5, hashSet8, hashSet9);
            d a6 = d.a(bVar, "WorkName");
            if (!dVar5.equals(a6)) {
                return new i.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + dVar5 + "\n Found:\n" + a6);
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap6.put("progress", new d.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            d dVar6 = new d("WorkProgress", hashMap6, hashSet10, new HashSet(0));
            d a7 = d.a(bVar, "WorkProgress");
            if (!dVar6.equals(a7)) {
                return new i.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + dVar6 + "\n Found:\n" + a7);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put("key", new d.a("key", "TEXT", true, 1, null, 1));
            hashMap7.put("long_value", new d.a("long_value", "INTEGER", false, 0, null, 1));
            d dVar7 = new d("Preference", hashMap7, new HashSet(0), new HashSet(0));
            d a8 = d.a(bVar, "Preference");
            if (dVar7.equals(a8)) {
                return new i.b(true, null);
            }
            return new i.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + dVar7 + "\n Found:\n" + a8);
        }
    }

    @Override // androidx.work.impl.WorkDatabase
    public b b() {
        b bVar;
        if (this.f454c != null) {
            return this.f454c;
        }
        synchronized (this) {
            if (this.f454c == null) {
                this.f454c = new c(this);
            }
            bVar = this.f454c;
        }
        return bVar;
    }

    @Override // b.s.h
    public void clearAllTables() {
        super.assertNotMainThread();
        b.w.a.b p = super.getOpenHelper().p();
        if (1 == 0) {
            try {
                ((b.w.a.g.a) p).f2616b.execSQL("PRAGMA foreign_keys = FALSE");
            } catch (Throwable th) {
                super.endTransaction();
                if (1 == 0) {
                    ((b.w.a.g.a) p).f2616b.execSQL("PRAGMA foreign_keys = TRUE");
                }
                ((b.w.a.g.a) p).c(new b.w.a.a("PRAGMA wal_checkpoint(FULL)")).close();
                b.w.a.g.a aVar = (b.w.a.g.a) p;
                if (!aVar.b()) {
                    aVar.f2616b.execSQL("VACUUM");
                }
                throw th;
            }
        }
        super.beginTransaction();
        if (1 != 0) {
            ((b.w.a.g.a) p).f2616b.execSQL("PRAGMA defer_foreign_keys = TRUE");
        }
        ((b.w.a.g.a) p).f2616b.execSQL("DELETE FROM `Dependency`");
        ((b.w.a.g.a) p).f2616b.execSQL("DELETE FROM `WorkSpec`");
        ((b.w.a.g.a) p).f2616b.execSQL("DELETE FROM `WorkTag`");
        ((b.w.a.g.a) p).f2616b.execSQL("DELETE FROM `SystemIdInfo`");
        ((b.w.a.g.a) p).f2616b.execSQL("DELETE FROM `WorkName`");
        ((b.w.a.g.a) p).f2616b.execSQL("DELETE FROM `WorkProgress`");
        ((b.w.a.g.a) p).f2616b.execSQL("DELETE FROM `Preference`");
        super.setTransactionSuccessful();
        super.endTransaction();
        if (1 == 0) {
            ((b.w.a.g.a) p).f2616b.execSQL("PRAGMA foreign_keys = TRUE");
        }
        b.w.a.g.a aVar2 = (b.w.a.g.a) p;
        aVar2.c(new b.w.a.a("PRAGMA wal_checkpoint(FULL)")).close();
        if (!aVar2.b()) {
            aVar2.f2616b.execSQL("VACUUM");
        }
    }

    @Override // b.s.h
    public f createInvalidationTracker() {
        return new f(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // b.s.h
    public b.w.a.c createOpenHelper(b.s.a aVar) {
        i iVar = new i(aVar, new a(11), "cf029002fffdcadf079e8d0a1c9a70ac", "8aff2efc47fafe870c738f727dfcfc6e");
        Context context = aVar.f2453b;
        String str = aVar.f2454c;
        if (context != null) {
            return aVar.f2452a.a(new c.b(context, str, iVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }

    @Override // androidx.work.impl.WorkDatabase
    public e d() {
        e eVar;
        if (this.h != null) {
            return this.h;
        }
        synchronized (this) {
            if (this.h == null) {
                this.h = new b.b0.y.r.f(this);
            }
            eVar = this.h;
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public b.b0.y.r.h e() {
        b.b0.y.r.h hVar;
        if (this.f456e != null) {
            return this.f456e;
        }
        synchronized (this) {
            if (this.f456e == null) {
                this.f456e = new b.b0.y.r.i(this);
            }
            hVar = this.f456e;
        }
        return hVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public k f() {
        k kVar;
        if (this.f457f != null) {
            return this.f457f;
        }
        synchronized (this) {
            if (this.f457f == null) {
                this.f457f = new l(this);
            }
            kVar = this.f457f;
        }
        return kVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public n g() {
        n nVar;
        if (this.f458g != null) {
            return this.f458g;
        }
        synchronized (this) {
            if (this.f458g == null) {
                this.f458g = new o(this);
            }
            nVar = this.f458g;
        }
        return nVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public q h() {
        q qVar;
        if (this.f453b != null) {
            return this.f453b;
        }
        synchronized (this) {
            if (this.f453b == null) {
                this.f453b = new r(this);
            }
            qVar = this.f453b;
        }
        return qVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public t i() {
        t tVar;
        if (this.f455d != null) {
            return this.f455d;
        }
        synchronized (this) {
            if (this.f455d == null) {
                this.f455d = new u(this);
            }
            tVar = this.f455d;
        }
        return tVar;
    }
}
