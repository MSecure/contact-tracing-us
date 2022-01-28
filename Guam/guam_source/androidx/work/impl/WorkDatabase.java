package androidx.work.impl;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.SQLiteCopyOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class WorkDatabase extends RoomDatabase {
    public static final long PRUNE_THRESHOLD_MILLIS = TimeUnit.DAYS.toMillis(1);

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016d A[Catch:{ ClassNotFoundException -> 0x0227, IllegalAccessException -> 0x0210, InstantiationException -> 0x01f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x016f A[Catch:{ ClassNotFoundException -> 0x0227, IllegalAccessException -> 0x0210, InstantiationException -> 0x01f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f7  */
    public static WorkDatabase create(final Context context, Executor executor, boolean z) {
        RoomDatabase.Builder builder;
        RoomDatabase.JournalMode journalMode;
        String name;
        String str;
        String str2;
        RoomDatabase roomDatabase;
        Executor executor2;
        boolean z2 = true;
        if (z) {
            builder = new RoomDatabase.Builder(context, WorkDatabase.class, null);
            builder.mAllowMainThreadQueries = true;
        } else {
            WorkDatabasePathHelper.getWorkDatabaseName();
            builder = new RoomDatabase.Builder(context, WorkDatabase.class, "androidx.work.workdb");
            builder.mFactory = new SupportSQLiteOpenHelper.Factory() {
                /* class androidx.work.impl.WorkDatabase.AnonymousClass1 */

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
                public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
                    Context context = context;
                    String str = configuration.name;
                    SupportSQLiteOpenHelper.Callback callback = configuration.callback;
                    if (callback == null) {
                        throw new IllegalArgumentException("Must set a callback to create the configuration.");
                    } else if (context == null) {
                        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                    } else if (!TextUtils.isEmpty(str)) {
                        return new FrameworkSQLiteOpenHelper(context, str, callback, true);
                    } else {
                        throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                    }
                }
            };
        }
        builder.mQueryExecutor = executor;
        AnonymousClass2 r1 = new RoomDatabase.Callback() {
            /* class androidx.work.impl.WorkDatabase.AnonymousClass2 */
        };
        if (builder.mCallbacks == null) {
            builder.mCallbacks = new ArrayList<>();
        }
        builder.mCallbacks.add(r1);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_1_2);
        builder.addMigrations(new WorkDatabaseMigrations.RescheduleMigration(context, 2, 3));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_3_4);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_4_5);
        builder.addMigrations(new WorkDatabaseMigrations.RescheduleMigration(context, 5, 6));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_6_7);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_7_8);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_8_9);
        builder.addMigrations(new WorkDatabaseMigrations.WorkMigration9To10(context));
        builder.addMigrations(new WorkDatabaseMigrations.RescheduleMigration(context, 10, 11));
        builder.mRequireMigration = false;
        builder.mAllowDestructiveMigrationOnDowngrade = true;
        RoomDatabase.JournalMode journalMode2 = RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING;
        if (builder.mContext == null) {
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        } else if (builder.mDatabaseClass != null) {
            if (builder.mQueryExecutor == null && builder.mTransactionExecutor == null) {
                Executor executor3 = ArchTaskExecutor.sIOThreadExecutor;
                builder.mTransactionExecutor = executor3;
                builder.mQueryExecutor = executor3;
            } else {
                Executor executor4 = builder.mQueryExecutor;
                if (executor4 != null && builder.mTransactionExecutor == null) {
                    builder.mTransactionExecutor = executor4;
                } else if (builder.mQueryExecutor == null && (executor2 = builder.mTransactionExecutor) != null) {
                    builder.mQueryExecutor = executor2;
                }
            }
            if (builder.mFactory == null) {
                builder.mFactory = new FrameworkSQLiteOpenHelperFactory();
            }
            Context context2 = builder.mContext;
            String str3 = builder.mName;
            SupportSQLiteOpenHelper.Factory factory = builder.mFactory;
            RoomDatabase.MigrationContainer migrationContainer = builder.mMigrationContainer;
            ArrayList<RoomDatabase.Callback> arrayList = builder.mCallbacks;
            boolean z3 = builder.mAllowMainThreadQueries;
            RoomDatabase.JournalMode journalMode3 = builder.mJournalMode;
            if (journalMode3 != null) {
                if (journalMode3 == RoomDatabase.JournalMode.AUTOMATIC) {
                    ActivityManager activityManager = (ActivityManager) context2.getSystemService("activity");
                    if (activityManager == null || activityManager.isLowRamDevice()) {
                        journalMode3 = RoomDatabase.JournalMode.TRUNCATE;
                    } else {
                        journalMode = journalMode2;
                        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context2, str3, factory, migrationContainer, arrayList, z3, journalMode, builder.mQueryExecutor, builder.mTransactionExecutor, false, builder.mRequireMigration, builder.mAllowDestructiveMigrationOnDowngrade, null, null, null);
                        Class<T> cls = builder.mDatabaseClass;
                        name = cls.getPackage().getName();
                        String canonicalName = cls.getCanonicalName();
                        if (!name.isEmpty()) {
                            canonicalName = canonicalName.substring(name.length() + 1);
                        }
                        str = canonicalName.replace('.', '_') + "_Impl";
                        if (!name.isEmpty()) {
                            str2 = str;
                        } else {
                            str2 = name + "." + str;
                        }
                        roomDatabase = (RoomDatabase) Class.forName(str2).newInstance();
                        if (roomDatabase == null) {
                            RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(11) {
                                /* class androidx.work.impl.WorkDatabase_Impl.AnonymousClass1 */

                                @Override // androidx.room.RoomOpenHelper.Delegate
                                public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                                    ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                                    FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) supportSQLiteDatabase;
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                                    frameworkSQLiteDatabase.mDelegate.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cf029002fffdcadf079e8d0a1c9a70ac')");
                                }

                                @Override // androidx.room.RoomOpenHelper.Delegate
                                public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                                    HashMap hashMap = new HashMap(2);
                                    hashMap.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                                    hashMap.put("prerequisite_id", new TableInfo.Column("prerequisite_id", "TEXT", true, 2, null, 1));
                                    HashSet hashSet = new HashSet(2);
                                    hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                                    hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
                                    HashSet hashSet2 = new HashSet(2);
                                    hashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
                                    hashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
                                    TableInfo tableInfo = new TableInfo("Dependency", hashMap, hashSet, hashSet2);
                                    TableInfo read = TableInfo.read(supportSQLiteDatabase, "Dependency");
                                    if (!tableInfo.equals(read)) {
                                        return new RoomOpenHelper.ValidationResult(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                                    }
                                    HashMap hashMap2 = new HashMap(24);
                                    hashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                                    hashMap2.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("worker_class_name", new TableInfo.Column("worker_class_name", "TEXT", true, 0, null, 1));
                                    hashMap2.put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", "TEXT", false, 0, null, 1));
                                    hashMap2.put("input", new TableInfo.Column("input", "BLOB", true, 0, null, 1));
                                    hashMap2.put("output", new TableInfo.Column("output", "BLOB", true, 0, null, 1));
                                    hashMap2.put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("period_start_time", new TableInfo.Column("period_start_time", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("run_in_foreground", new TableInfo.Column("run_in_foreground", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", false, 0, null, 1));
                                    hashMap2.put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
                                    hashMap2.put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", false, 0, null, 1));
                                    HashSet hashSet3 = new HashSet(0);
                                    HashSet hashSet4 = new HashSet(2);
                                    hashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
                                    hashSet4.add(new TableInfo.Index("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
                                    TableInfo tableInfo2 = new TableInfo("WorkSpec", hashMap2, hashSet3, hashSet4);
                                    TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "WorkSpec");
                                    if (!tableInfo2.equals(read2)) {
                                        return new RoomOpenHelper.ValidationResult(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                                    }
                                    HashMap hashMap3 = new HashMap(2);
                                    hashMap3.put("tag", new TableInfo.Column("tag", "TEXT", true, 1, null, 1));
                                    hashMap3.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                                    HashSet hashSet5 = new HashSet(1);
                                    hashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                                    HashSet hashSet6 = new HashSet(1);
                                    hashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
                                    TableInfo tableInfo3 = new TableInfo("WorkTag", hashMap3, hashSet5, hashSet6);
                                    TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "WorkTag");
                                    if (!tableInfo3.equals(read3)) {
                                        return new RoomOpenHelper.ValidationResult(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                                    }
                                    HashMap hashMap4 = new HashMap(2);
                                    hashMap4.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                                    hashMap4.put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0, null, 1));
                                    HashSet hashSet7 = new HashSet(1);
                                    hashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                                    TableInfo tableInfo4 = new TableInfo("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
                                    TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "SystemIdInfo");
                                    if (!tableInfo4.equals(read4)) {
                                        return new RoomOpenHelper.ValidationResult(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                                    }
                                    HashMap hashMap5 = new HashMap(2);
                                    hashMap5.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                                    hashMap5.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                                    HashSet hashSet8 = new HashSet(1);
                                    hashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                                    HashSet hashSet9 = new HashSet(1);
                                    hashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
                                    TableInfo tableInfo5 = new TableInfo("WorkName", hashMap5, hashSet8, hashSet9);
                                    TableInfo read5 = TableInfo.read(supportSQLiteDatabase, "WorkName");
                                    if (!tableInfo5.equals(read5)) {
                                        return new RoomOpenHelper.ValidationResult(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                                    }
                                    HashMap hashMap6 = new HashMap(2);
                                    hashMap6.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                                    hashMap6.put(ReactProgressBarViewManager.PROP_PROGRESS, new TableInfo.Column(ReactProgressBarViewManager.PROP_PROGRESS, "BLOB", true, 0, null, 1));
                                    HashSet hashSet10 = new HashSet(1);
                                    hashSet10.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                                    TableInfo tableInfo6 = new TableInfo("WorkProgress", hashMap6, hashSet10, new HashSet(0));
                                    TableInfo read6 = TableInfo.read(supportSQLiteDatabase, "WorkProgress");
                                    if (!tableInfo6.equals(read6)) {
                                        return new RoomOpenHelper.ValidationResult(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                                    }
                                    HashMap hashMap7 = new HashMap(2);
                                    hashMap7.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, 1));
                                    hashMap7.put("long_value", new TableInfo.Column("long_value", "INTEGER", false, 0, null, 1));
                                    TableInfo tableInfo7 = new TableInfo("Preference", hashMap7, new HashSet(0), new HashSet(0));
                                    TableInfo read7 = TableInfo.read(supportSQLiteDatabase, "Preference");
                                    if (tableInfo7.equals(read7)) {
                                        return new RoomOpenHelper.ValidationResult(true, null);
                                    }
                                    return new RoomOpenHelper.ValidationResult(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                                }
                            }, "cf029002fffdcadf079e8d0a1c9a70ac", "8aff2efc47fafe870c738f727dfcfc6e");
                            Context context3 = databaseConfiguration.context;
                            String str4 = databaseConfiguration.name;
                            if (context3 != null) {
                                SupportSQLiteOpenHelper create = databaseConfiguration.sqliteOpenHelperFactory.create(new SupportSQLiteOpenHelper.Configuration(context3, str4, roomOpenHelper, false));
                                roomDatabase.mOpenHelper = create;
                                if (create instanceof SQLiteCopyOpenHelper) {
                                    ((SQLiteCopyOpenHelper) create).mDatabaseConfiguration = databaseConfiguration;
                                }
                                if (databaseConfiguration.journalMode != journalMode2) {
                                    z2 = false;
                                }
                                roomDatabase.mOpenHelper.setWriteAheadLoggingEnabled(z2);
                                roomDatabase.mCallbacks = databaseConfiguration.callbacks;
                                roomDatabase.mQueryExecutor = databaseConfiguration.queryExecutor;
                                new ArrayDeque();
                                roomDatabase.mAllowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
                                roomDatabase.mWriteAheadLoggingEnabled = z2;
                                if (databaseConfiguration.multiInstanceInvalidation) {
                                    InvalidationTracker invalidationTracker = roomDatabase.mInvalidationTracker;
                                    new MultiInstanceInvalidationClient(databaseConfiguration.context, databaseConfiguration.name, invalidationTracker, invalidationTracker.mDatabase.mQueryExecutor);
                                }
                                return (WorkDatabase) roomDatabase;
                            }
                            throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                        }
                        throw null;
                    }
                }
                journalMode = journalMode3;
                DatabaseConfiguration databaseConfiguration2 = new DatabaseConfiguration(context2, str3, factory, migrationContainer, arrayList, z3, journalMode, builder.mQueryExecutor, builder.mTransactionExecutor, false, builder.mRequireMigration, builder.mAllowDestructiveMigrationOnDowngrade, null, null, null);
                Class<T> cls2 = builder.mDatabaseClass;
                name = cls2.getPackage().getName();
                String canonicalName2 = cls2.getCanonicalName();
                if (!name.isEmpty()) {
                }
                str = canonicalName2.replace('.', '_') + "_Impl";
                try {
                    if (!name.isEmpty()) {
                    }
                    roomDatabase = (RoomDatabase) Class.forName(str2).newInstance();
                    if (roomDatabase == null) {
                    }
                } catch (ClassNotFoundException unused) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("cannot find implementation for ");
                    outline15.append(cls2.getCanonicalName());
                    outline15.append(". ");
                    outline15.append(str);
                    outline15.append(" does not exist");
                    throw new RuntimeException(outline15.toString());
                } catch (IllegalAccessException unused2) {
                    StringBuilder outline152 = GeneratedOutlineSupport.outline15("Cannot access the constructor");
                    outline152.append(cls2.getCanonicalName());
                    throw new RuntimeException(outline152.toString());
                } catch (InstantiationException unused3) {
                    StringBuilder outline153 = GeneratedOutlineSupport.outline15("Failed to create an instance of ");
                    outline153.append(cls2.getCanonicalName());
                    throw new RuntimeException(outline153.toString());
                }
            } else {
                throw null;
            }
        } else {
            throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        }
    }

    public static String getPruneSQL() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ");
        outline15.append(System.currentTimeMillis() - PRUNE_THRESHOLD_MILLIS);
        outline15.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
        return outline15.toString();
    }

    public abstract DependencyDao dependencyDao();

    public abstract PreferenceDao preferenceDao();

    public abstract SystemIdInfoDao systemIdInfoDao();

    public abstract WorkNameDao workNameDao();

    public abstract WorkProgressDao workProgressDao();

    public abstract WorkSpecDao workSpecDao();

    public abstract WorkTagDao workTagDao();
}
