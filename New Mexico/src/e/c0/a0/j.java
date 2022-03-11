package e.c0.a0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes.dex */
public class j {
    public static e.v.o.a a = new a(1, 2);
    public static e.v.o.a b = new b(3, 4);
    public static e.v.o.a c = new c(4, 5);

    /* renamed from: d  reason: collision with root package name */
    public static e.v.o.a f1099d = new d(6, 7);

    /* renamed from: e  reason: collision with root package name */
    public static e.v.o.a f1100e = new e(7, 8);

    /* renamed from: f  reason: collision with root package name */
    public static e.v.o.a f1101f = new f(8, 9);

    /* renamed from: g  reason: collision with root package name */
    public static e.v.o.a f1102g = new g(11, 12);

    /* loaded from: classes.dex */
    public class a extends e.v.o.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            e.x.a.f.a aVar = (e.x.a.f.a) bVar;
            aVar.b.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            aVar.b.execSQL("DROP TABLE IF EXISTS alarmInfo");
            aVar.b.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    /* loaded from: classes.dex */
    public class b extends e.v.o.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                ((e.x.a.f.a) bVar).b.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends e.v.o.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            ((e.x.a.f.a) bVar).b.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    /* loaded from: classes.dex */
    public class d extends e.v.o.a {
        public d(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    /* loaded from: classes.dex */
    public class e extends e.v.o.a {
        public e(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    /* loaded from: classes.dex */
    public class f extends e.v.o.a {
        public f(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes.dex */
    public class g extends e.v.o.a {
        public g(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes.dex */
    public static class h extends e.v.o.a {
        public final Context c;

        public h(Context context, int i2, int i3) {
            super(i2, i3);
            this.c = context;
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            if (this.b >= 10) {
                ((e.x.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
            } else {
                this.c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i extends e.v.o.a {
        public final Context c;

        public i(Context context) {
            super(9, 10);
            this.c = context;
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            e.x.a.f.a aVar;
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            SharedPreferences sharedPreferences = this.c.getSharedPreferences("androidx.work.util.preferences", 0);
            if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                long j2 = 0;
                long j3 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
                if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                    j2 = 1;
                }
                aVar = (e.x.a.f.a) bVar;
                aVar.b.beginTransaction();
                try {
                    ((e.x.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j3)});
                    ((e.x.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j2)});
                    sharedPreferences.edit().clear().apply();
                    ((e.x.a.f.a) bVar).b.setTransactionSuccessful();
                } finally {
                }
            }
            SharedPreferences sharedPreferences2 = this.c.getSharedPreferences("androidx.work.util.id", 0);
            if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                int i2 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                int i3 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                aVar = (e.x.a.f.a) bVar;
                aVar.b.beginTransaction();
                try {
                    ((e.x.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i2)});
                    ((e.x.a.f.a) bVar).b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i3)});
                    sharedPreferences2.edit().clear().apply();
                    ((e.x.a.f.a) bVar).b.setTransactionSuccessful();
                } finally {
                }
            }
        }
    }
}
