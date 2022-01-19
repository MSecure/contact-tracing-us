package androidx.work.impl;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

public class WorkDatabaseMigrations {
    public static Migration MIGRATION_1_2 = new Migration(1, 2) {
        /* class androidx.work.impl.WorkDatabaseMigrations.AnonymousClass1 */

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) supportSQLiteDatabase;
            frameworkSQLiteDatabase.mDelegate.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            frameworkSQLiteDatabase.mDelegate.execSQL("DROP TABLE IF EXISTS alarmInfo");
            frameworkSQLiteDatabase.mDelegate.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    };
    public static Migration MIGRATION_3_4 = new Migration(3, 4) {
        /* class androidx.work.impl.WorkDatabaseMigrations.AnonymousClass2 */

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
        }
    };
    public static Migration MIGRATION_4_5 = new Migration(4, 5) {
        /* class androidx.work.impl.WorkDatabaseMigrations.AnonymousClass3 */

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    };
    public static Migration MIGRATION_6_7 = new Migration(6, 7) {
        /* class androidx.work.impl.WorkDatabaseMigrations.AnonymousClass4 */

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    };
    public static Migration MIGRATION_7_8 = new Migration(7, 8) {
        /* class androidx.work.impl.WorkDatabaseMigrations.AnonymousClass5 */

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    };
    public static Migration MIGRATION_8_9 = new Migration(8, 9) {
        /* class androidx.work.impl.WorkDatabaseMigrations.AnonymousClass6 */

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    };

    public static class RescheduleMigration extends Migration {
        public final Context mContext;

        public RescheduleMigration(Context context, int i, int i2) {
            super(i, i2);
            this.mContext = context;
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (this.endVersion >= 10) {
                ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.mContext.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    public static class WorkMigration9To10 extends Migration {
        public final Context mContext;

        public WorkMigration9To10(Context context) {
            super(9, 10);
            this.mContext = context;
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("androidx.work.util.preferences", 0);
            if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                long j = 0;
                long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
                if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                    j = 1;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) supportSQLiteDatabase;
                frameworkSQLiteDatabase.mDelegate.beginTransaction();
                try {
                    ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                    ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j)});
                    sharedPreferences.edit().clear().apply();
                    ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.setTransactionSuccessful();
                } finally {
                    frameworkSQLiteDatabase.mDelegate.endTransaction();
                }
            }
            SharedPreferences sharedPreferences2 = this.mContext.getSharedPreferences("androidx.work.util.id", 0);
            if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                int i = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                int i2 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = (FrameworkSQLiteDatabase) supportSQLiteDatabase;
                frameworkSQLiteDatabase2.mDelegate.beginTransaction();
                try {
                    ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                    ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                    sharedPreferences2.edit().clear().apply();
                    ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.setTransactionSuccessful();
                } finally {
                    frameworkSQLiteDatabase2.mDelegate.endTransaction();
                }
            }
        }
    }
}
