package e.b0.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class j {
    public static e.t.o.a a = new a(1, 2);
    public static e.t.o.a b = new b(3, 4);
    public static e.t.o.a c = new c(4, 5);

    /* renamed from: d  reason: collision with root package name */
    public static e.t.o.a f1023d = new d(6, 7);

    /* renamed from: e  reason: collision with root package name */
    public static e.t.o.a f1024e = new e(7, 8);

    /* renamed from: f  reason: collision with root package name */
    public static e.t.o.a f1025f = new f(8, 9);

    public class a extends e.t.o.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            e.v.a.f.a aVar = (e.v.a.f.a) bVar;
            aVar.b.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            aVar.b.execSQL("DROP TABLE IF EXISTS alarmInfo");
            aVar.b.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    public class b extends e.t.o.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                ((e.v.a.f.a) bVar).b.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    public class c extends e.t.o.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            ((e.v.a.f.a) bVar).b.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    public class d extends e.t.o.a {
        public d(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    public class e extends e.t.o.a {
        public e(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    public class f extends e.t.o.a {
        public f(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static class g extends e.t.o.a {
        public final Context c;

        public g(Context context, int i2, int i3) {
            super(i2, i3);
            this.c = context;
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            if (this.b >= 10) {
                ((e.v.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    public static class h extends e.t.o.a {
        public final Context c;

        public h(Context context) {
            super(9, 10);
            this.c = context;
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            SharedPreferences sharedPreferences = this.c.getSharedPreferences("androidx.work.util.preferences", 0);
            if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                long j2 = 0;
                long j3 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
                if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                    j2 = 1;
                }
                e.v.a.f.a aVar = (e.v.a.f.a) bVar;
                aVar.b.beginTransaction();
                try {
                    ((e.v.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j3)});
                    ((e.v.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j2)});
                    sharedPreferences.edit().clear().apply();
                    ((e.v.a.f.a) bVar).b.setTransactionSuccessful();
                } finally {
                    aVar.b.endTransaction();
                }
            }
            SharedPreferences sharedPreferences2 = this.c.getSharedPreferences("androidx.work.util.id", 0);
            if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                int i2 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                int i3 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                e.v.a.f.a aVar2 = (e.v.a.f.a) bVar;
                aVar2.b.beginTransaction();
                try {
                    ((e.v.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i2)});
                    ((e.v.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i3)});
                    sharedPreferences2.edit().clear().apply();
                    ((e.v.a.f.a) bVar).b.setTransactionSuccessful();
                } finally {
                    aVar2.b.endTransaction();
                }
            }
        }
    }
}
