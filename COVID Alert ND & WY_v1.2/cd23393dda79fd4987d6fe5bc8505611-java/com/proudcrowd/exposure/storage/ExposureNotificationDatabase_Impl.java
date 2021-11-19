package com.proudcrowd.exposure.storage;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class ExposureNotificationDatabase_Impl extends ExposureNotificationDatabase {
    private volatile ExposureDao _exposureDao;
    private volatile KeyScanDao _keyScanDao;
    private volatile PartyDao _partyDao;
    private volatile WatermarkUrlDao _watermarkUrlDao;

    /* access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(2) {
            /* class com.proudcrowd.exposure.storage.ExposureNotificationDatabase_Impl.AnonymousClass1 */

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ExposureEntity` (`date_timestamp_ms` INTEGER NOT NULL, `has_viewed` INTEGER NOT NULL, `created_timestamp_ms` INTEGER NOT NULL, PRIMARY KEY(`date_timestamp_ms`))");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_ExposureEntity_date_timestamp_ms` ON `ExposureEntity` (`date_timestamp_ms`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `KeyScanEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `created_timestamp_ms` INTEGER NOT NULL, `is_success` INTEGER NOT NULL, `error_message` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WatermarkUrlEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url_fragment` TEXT, `created_timestamp_ms` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PartyEntity` (`id` INTEGER NOT NULL, `name` TEXT, `image_url` TEXT, `constituent_name` TEXT, `instructions` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd09a813cb6ded27e671c422061a82729')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ExposureEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `KeyScanEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WatermarkUrlEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `PartyEntity`");
                if (ExposureNotificationDatabase_Impl.this.mCallbacks != null) {
                    int size = ExposureNotificationDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ExposureNotificationDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (ExposureNotificationDatabase_Impl.this.mCallbacks != null) {
                    int size = ExposureNotificationDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ExposureNotificationDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ExposureNotificationDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                ExposureNotificationDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (ExposureNotificationDatabase_Impl.this.mCallbacks != null) {
                    int size = ExposureNotificationDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ExposureNotificationDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("date_timestamp_ms", new TableInfo.Column("date_timestamp_ms", "INTEGER", true, 1, null, 1));
                hashMap.put("has_viewed", new TableInfo.Column("has_viewed", "INTEGER", true, 0, null, 1));
                hashMap.put("created_timestamp_ms", new TableInfo.Column("created_timestamp_ms", "INTEGER", true, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.Index("index_ExposureEntity_date_timestamp_ms", false, Arrays.asList("date_timestamp_ms")));
                TableInfo tableInfo = new TableInfo("ExposureEntity", hashMap, hashSet, hashSet2);
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "ExposureEntity");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExposureEntity(com.proudcrowd.exposure.storage.ExposureEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap2.put("created_timestamp_ms", new TableInfo.Column("created_timestamp_ms", "INTEGER", true, 0, null, 1));
                hashMap2.put("is_success", new TableInfo.Column("is_success", "INTEGER", true, 0, null, 1));
                hashMap2.put("error_message", new TableInfo.Column("error_message", "TEXT", false, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("KeyScanEntity", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "KeyScanEntity");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "KeyScanEntity(com.proudcrowd.exposure.storage.KeyScanEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(3);
                hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap3.put("url_fragment", new TableInfo.Column("url_fragment", "TEXT", false, 0, null, 1));
                hashMap3.put("created_timestamp_ms", new TableInfo.Column("created_timestamp_ms", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("WatermarkUrlEntity", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "WatermarkUrlEntity");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "WatermarkUrlEntity(com.proudcrowd.exposure.storage.WatermarkUrlEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(5);
                hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap4.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", false, 0, null, 1));
                hashMap4.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, 1));
                hashMap4.put("constituent_name", new TableInfo.Column("constituent_name", "TEXT", false, 0, null, 1));
                hashMap4.put("instructions", new TableInfo.Column("instructions", "TEXT", false, 0, null, 1));
                TableInfo tableInfo4 = new TableInfo("PartyEntity", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "PartyEntity");
                if (tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(true, null);
                }
                return new RoomOpenHelper.ValidationResult(false, "PartyEntity(com.proudcrowd.exposure.storage.PartyEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
        }, "d09a813cb6ded27e671c422061a82729", "70d2c21fbb76565569962281e785514a")).build());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "ExposureEntity", "KeyScanEntity", "WatermarkUrlEntity", "PartyEntity");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `ExposureEntity`");
            writableDatabase.execSQL("DELETE FROM `KeyScanEntity`");
            writableDatabase.execSQL("DELETE FROM `WatermarkUrlEntity`");
            writableDatabase.execSQL("DELETE FROM `PartyEntity`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureNotificationDatabase
    public ExposureDao exposureDao() {
        ExposureDao exposureDao;
        if (this._exposureDao != null) {
            return this._exposureDao;
        }
        synchronized (this) {
            if (this._exposureDao == null) {
                this._exposureDao = new ExposureDao_Impl(this);
            }
            exposureDao = this._exposureDao;
        }
        return exposureDao;
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureNotificationDatabase
    public KeyScanDao keyScanDao() {
        KeyScanDao keyScanDao;
        if (this._keyScanDao != null) {
            return this._keyScanDao;
        }
        synchronized (this) {
            if (this._keyScanDao == null) {
                this._keyScanDao = new KeyScanDao_Impl(this);
            }
            keyScanDao = this._keyScanDao;
        }
        return keyScanDao;
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureNotificationDatabase
    public WatermarkUrlDao keyUrlDao() {
        WatermarkUrlDao watermarkUrlDao;
        if (this._watermarkUrlDao != null) {
            return this._watermarkUrlDao;
        }
        synchronized (this) {
            if (this._watermarkUrlDao == null) {
                this._watermarkUrlDao = new WatermarkUrlDao_Impl(this);
            }
            watermarkUrlDao = this._watermarkUrlDao;
        }
        return watermarkUrlDao;
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureNotificationDatabase
    public PartyDao partyDao() {
        PartyDao partyDao;
        if (this._partyDao != null) {
            return this._partyDao;
        }
        synchronized (this) {
            if (this._partyDao == null) {
                this._partyDao = new PartyDao_Impl(this);
            }
            partyDao = this._partyDao;
        }
        return partyDao;
    }
}
