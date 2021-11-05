package b.z.y;

import android.content.Context;
import android.content.SharedPreferences;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static b.r.p.a f1960a = new a(1, 2);

    /* renamed from: b  reason: collision with root package name */
    public static b.r.p.a f1961b = new b(3, 4);

    /* renamed from: c  reason: collision with root package name */
    public static b.r.p.a f1962c = new c(4, 5);

    /* renamed from: d  reason: collision with root package name */
    public static b.r.p.a f1963d = new d(6, 7);

    /* renamed from: e  reason: collision with root package name */
    public static b.r.p.a f1964e = new e(7, 8);
    public static b.r.p.a f = new f(8, 9);

    public class a extends b.r.p.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // b.r.p.a
        public void a(b.u.a.b bVar) {
            ((b.u.a.g.a) bVar).f1742b.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            b.u.a.g.a aVar = (b.u.a.g.a) bVar;
            aVar.f1742b.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            aVar.f1742b.execSQL("DROP TABLE IF EXISTS alarmInfo");
            aVar.f1742b.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    public class b extends b.r.p.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // b.r.p.a
        public void a(b.u.a.b bVar) {
            ((b.u.a.g.a) bVar).f1742b.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
        }
    }

    public class c extends b.r.p.a {
        public c(int i, int i2) {
            super(i, i2);
        }

        @Override // b.r.p.a
        public void a(b.u.a.b bVar) {
            ((b.u.a.g.a) bVar).f1742b.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            ((b.u.a.g.a) bVar).f1742b.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    public class d extends b.r.p.a {
        public d(int i, int i2) {
            super(i, i2);
        }

        @Override // b.r.p.a
        public void a(b.u.a.b bVar) {
            ((b.u.a.g.a) bVar).f1742b.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    public class e extends b.r.p.a {
        public e(int i, int i2) {
            super(i, i2);
        }

        @Override // b.r.p.a
        public void a(b.u.a.b bVar) {
            ((b.u.a.g.a) bVar).f1742b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    public class f extends b.r.p.a {
        public f(int i, int i2) {
            super(i, i2);
        }

        @Override // b.r.p.a
        public void a(b.u.a.b bVar) {
            ((b.u.a.g.a) bVar).f1742b.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static class g extends b.r.p.a {

        /* renamed from: c  reason: collision with root package name */
        public final Context f1965c;

        public g(Context context, int i, int i2) {
            super(i, i2);
            this.f1965c = context;
        }

        @Override // b.r.p.a
        public void a(b.u.a.b bVar) {
            if (this.f1680b >= 10) {
                ((b.u.a.g.a) bVar).f1742b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.f1965c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    public static class h extends b.r.p.a {

        /* renamed from: c  reason: collision with root package name */
        public final Context f1966c;

        public h(Context context) {
            super(9, 10);
            this.f1966c = context;
        }

        @Override // b.r.p.a
        public void a(b.u.a.b bVar) {
            ((b.u.a.g.a) bVar).f1742b.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            SharedPreferences sharedPreferences = this.f1966c.getSharedPreferences("androidx.work.util.preferences", 0);
            if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                long j = 0;
                long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
                if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                    j = 1;
                }
                b.u.a.g.a aVar = (b.u.a.g.a) bVar;
                aVar.f1742b.beginTransaction();
                try {
                    ((b.u.a.g.a) bVar).f1742b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                    ((b.u.a.g.a) bVar).f1742b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j)});
                    sharedPreferences.edit().clear().apply();
                    ((b.u.a.g.a) bVar).f1742b.setTransactionSuccessful();
                } finally {
                    aVar.f1742b.endTransaction();
                }
            }
            SharedPreferences sharedPreferences2 = this.f1966c.getSharedPreferences("androidx.work.util.id", 0);
            if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                int i = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                int i2 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                b.u.a.g.a aVar2 = (b.u.a.g.a) bVar;
                aVar2.f1742b.beginTransaction();
                try {
                    ((b.u.a.g.a) bVar).f1742b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                    ((b.u.a.g.a) bVar).f1742b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                    sharedPreferences2.edit().clear().apply();
                    ((b.u.a.g.a) bVar).f1742b.setTransactionSuccessful();
                } finally {
                    aVar2.f1742b.endTransaction();
                }
            }
        }
    }
}
