package b.b0.y;

import android.content.Context;
import android.content.SharedPreferences;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static b.s.p.a f1084a = new a(1, 2);

    /* renamed from: b  reason: collision with root package name */
    public static b.s.p.a f1085b = new b(3, 4);

    /* renamed from: c  reason: collision with root package name */
    public static b.s.p.a f1086c = new c(4, 5);

    /* renamed from: d  reason: collision with root package name */
    public static b.s.p.a f1087d = new d(6, 7);

    /* renamed from: e  reason: collision with root package name */
    public static b.s.p.a f1088e = new e(7, 8);

    /* renamed from: f  reason: collision with root package name */
    public static b.s.p.a f1089f = new f(8, 9);

    public class a extends b.s.p.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // b.s.p.a
        public void a(b.w.a.b bVar) {
            ((b.w.a.g.a) bVar).f2616b.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            b.w.a.g.a aVar = (b.w.a.g.a) bVar;
            aVar.f2616b.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            aVar.f2616b.execSQL("DROP TABLE IF EXISTS alarmInfo");
            aVar.f2616b.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    public class b extends b.s.p.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // b.s.p.a
        public void a(b.w.a.b bVar) {
            ((b.w.a.g.a) bVar).f2616b.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
        }
    }

    public class c extends b.s.p.a {
        public c(int i, int i2) {
            super(i, i2);
        }

        @Override // b.s.p.a
        public void a(b.w.a.b bVar) {
            ((b.w.a.g.a) bVar).f2616b.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            ((b.w.a.g.a) bVar).f2616b.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    public class d extends b.s.p.a {
        public d(int i, int i2) {
            super(i, i2);
        }

        @Override // b.s.p.a
        public void a(b.w.a.b bVar) {
            ((b.w.a.g.a) bVar).f2616b.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    public class e extends b.s.p.a {
        public e(int i, int i2) {
            super(i, i2);
        }

        @Override // b.s.p.a
        public void a(b.w.a.b bVar) {
            ((b.w.a.g.a) bVar).f2616b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    public class f extends b.s.p.a {
        public f(int i, int i2) {
            super(i, i2);
        }

        @Override // b.s.p.a
        public void a(b.w.a.b bVar) {
            ((b.w.a.g.a) bVar).f2616b.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static class g extends b.s.p.a {

        /* renamed from: c  reason: collision with root package name */
        public final Context f1090c;

        public g(Context context, int i, int i2) {
            super(i, i2);
            this.f1090c = context;
        }

        @Override // b.s.p.a
        public void a(b.w.a.b bVar) {
            if (this.f2550b >= 10) {
                ((b.w.a.g.a) bVar).f2616b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.f1090c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    public static class h extends b.s.p.a {

        /* renamed from: c  reason: collision with root package name */
        public final Context f1091c;

        public h(Context context) {
            super(9, 10);
            this.f1091c = context;
        }

        @Override // b.s.p.a
        public void a(b.w.a.b bVar) {
            ((b.w.a.g.a) bVar).f2616b.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            SharedPreferences sharedPreferences = this.f1091c.getSharedPreferences("androidx.work.util.preferences", 0);
            if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                long j = 0;
                long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
                if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                    j = 1;
                }
                b.w.a.g.a aVar = (b.w.a.g.a) bVar;
                aVar.f2616b.beginTransaction();
                try {
                    ((b.w.a.g.a) bVar).f2616b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                    ((b.w.a.g.a) bVar).f2616b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j)});
                    sharedPreferences.edit().clear().apply();
                    ((b.w.a.g.a) bVar).f2616b.setTransactionSuccessful();
                } finally {
                    aVar.f2616b.endTransaction();
                }
            }
            SharedPreferences sharedPreferences2 = this.f1091c.getSharedPreferences("androidx.work.util.id", 0);
            if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                int i = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                int i2 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                b.w.a.g.a aVar2 = (b.w.a.g.a) bVar;
                aVar2.f2616b.beginTransaction();
                try {
                    ((b.w.a.g.a) bVar).f2616b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                    ((b.w.a.g.a) bVar).f2616b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                    sharedPreferences2.edit().clear().apply();
                    ((b.w.a.g.a) bVar).f2616b.setTransactionSuccessful();
                } finally {
                    aVar2.f2616b.endTransaction();
                }
            }
        }
    }
}
