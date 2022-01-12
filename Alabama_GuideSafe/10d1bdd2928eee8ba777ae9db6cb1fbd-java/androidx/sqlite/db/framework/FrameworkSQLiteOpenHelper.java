package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public final SupportSQLiteOpenHelper.Callback mCallback;
    public final Context mContext;
    public OpenHelper mDelegate;
    public final Object mLock = new Object();
    public final String mName;
    public final boolean mUseNoBackupDirectory;
    public boolean mWriteAheadLoggingEnabled;

    public static class OpenHelper extends SQLiteOpenHelper {
        public final SupportSQLiteOpenHelper.Callback mCallback;
        public final FrameworkSQLiteDatabase[] mDbRef;
        public boolean mMigrated;

        public OpenHelper(Context context, String str, final FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, final SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, null, callback.version, new DatabaseErrorHandler() {
                /* class androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.AnonymousClass1 */

                /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
                    if (r1 != null) goto L_0x0040;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
                    r5 = r1.iterator();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
                    if (r5.hasNext() != false) goto L_0x004a;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
                    r0.deleteDatabaseFile((java.lang.String) r5.next().second);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
                    r0.deleteDatabaseFile(r5.getPath());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
                    throw r2;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
                    r2 = move-exception;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x003a */
                /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
                /* JADX WARNING: Removed duplicated region for block: B:7:0x0038 A[ExcHandler: all (r2v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
                  PHI: (r1v8 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v1 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v2 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v2 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x0031, B:8:0x003a, B:9:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0031] */
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    SupportSQLiteOpenHelper.Callback callback = SupportSQLiteOpenHelper.Callback.this;
                    FrameworkSQLiteDatabase wrappedDb = OpenHelper.getWrappedDb(frameworkSQLiteDatabaseArr, sQLiteDatabase);
                    List<Pair<String, String>> list = null;
                    if (callback != null) {
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Corruption reported by sqlite on database: ");
                        outline17.append(wrappedDb.getPath());
                        Log.e("SupportSQLite", outline17.toString());
                        if (!wrappedDb.mDelegate.isOpen()) {
                            callback.deleteDatabaseFile(wrappedDb.getPath());
                            return;
                        }
                        try {
                            list = wrappedDb.mDelegate.getAttachedDbs();
                            wrappedDb.close();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                        }
                        if (list == null) {
                            for (Pair<String, String> pair : list) {
                                callback.deleteDatabaseFile((String) pair.second);
                            }
                            return;
                        }
                        callback.deleteDatabaseFile(wrappedDb.getPath());
                        return;
                    }
                    throw null;
                }
            });
            this.mCallback = callback;
            this.mDbRef = frameworkSQLiteDatabaseArr;
        }

        @Override // java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.mDbRef[0] = null;
        }

        public FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            return getWrappedDb(this.mDbRef, sQLiteDatabase);
        }

        public synchronized SupportSQLiteDatabase getWritableSupportDatabase() {
            this.mMigrated = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.mMigrated) {
                close();
                return getWritableSupportDatabase();
            }
            return getWrappedDb(writableDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            SupportSQLiteOpenHelper.Callback callback = this.mCallback;
            getWrappedDb(this.mDbRef, sQLiteDatabase);
            if (((RoomOpenHelper) callback) == null) {
                throw null;
            }
        }

        /* JADX INFO: finally extract failed */
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            SupportSQLiteOpenHelper.Callback callback = this.mCallback;
            FrameworkSQLiteDatabase wrappedDb = getWrappedDb(this.mDbRef, sQLiteDatabase);
            RoomOpenHelper roomOpenHelper = (RoomOpenHelper) callback;
            if (roomOpenHelper != null) {
                Cursor query = wrappedDb.query(new SimpleSQLiteQuery("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"));
                try {
                    boolean z = query.moveToFirst() && query.getInt(0) == 0;
                    query.close();
                    roomOpenHelper.mDelegate.createAllTables(wrappedDb);
                    if (!z) {
                        RoomOpenHelper.ValidationResult onValidateSchema = roomOpenHelper.mDelegate.onValidateSchema(wrappedDb);
                        if (!onValidateSchema.isValid) {
                            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Pre-packaged database has an invalid schema: ");
                            outline17.append(onValidateSchema.expectedFoundMsg);
                            throw new IllegalStateException(outline17.toString());
                        }
                    }
                    roomOpenHelper.updateIdentity(wrappedDb);
                    WorkDatabase_Impl.AnonymousClass1 r6 = (WorkDatabase_Impl.AnonymousClass1) roomOpenHelper.mDelegate;
                    if (WorkDatabase_Impl.this.mCallbacks != null) {
                        int size = WorkDatabase_Impl.this.mCallbacks.size();
                        for (int i = 0; i < size; i++) {
                            if (WorkDatabase_Impl.this.mCallbacks.get(i) == null) {
                                throw null;
                            }
                        }
                    }
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            } else {
                throw null;
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            ((RoomOpenHelper) this.mCallback).onUpgrade(getWrappedDb(this.mDbRef, sQLiteDatabase), i, i2);
        }

        /* JADX INFO: finally extract failed */
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.mMigrated) {
                SupportSQLiteOpenHelper.Callback callback = this.mCallback;
                FrameworkSQLiteDatabase wrappedDb = getWrappedDb(this.mDbRef, sQLiteDatabase);
                RoomOpenHelper roomOpenHelper = (RoomOpenHelper) callback;
                if (roomOpenHelper != null) {
                    Cursor query = wrappedDb.query(new SimpleSQLiteQuery("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"));
                    try {
                        if (query.moveToFirst() && query.getInt(0) != 0) {
                            Cursor query2 = wrappedDb.query(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                            try {
                                String string = query2.moveToFirst() ? query2.getString(0) : null;
                                query2.close();
                                if (!roomOpenHelper.mIdentityHash.equals(string) && !roomOpenHelper.mLegacyHash.equals(string)) {
                                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                                }
                            } catch (Throwable th) {
                                query2.close();
                                throw th;
                            }
                        } else {
                            RoomOpenHelper.ValidationResult onValidateSchema = roomOpenHelper.mDelegate.onValidateSchema(wrappedDb);
                            if (!onValidateSchema.isValid) {
                                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Pre-packaged database has an invalid schema: ");
                                outline17.append(onValidateSchema.expectedFoundMsg);
                                throw new IllegalStateException(outline17.toString());
                            } else if (((WorkDatabase_Impl.AnonymousClass1) roomOpenHelper.mDelegate) != null) {
                                roomOpenHelper.updateIdentity(wrappedDb);
                            } else {
                                throw null;
                            }
                        }
                        WorkDatabase_Impl.AnonymousClass1 r2 = (WorkDatabase_Impl.AnonymousClass1) roomOpenHelper.mDelegate;
                        WorkDatabase_Impl.this.mDatabase = wrappedDb;
                        wrappedDb.mDelegate.execSQL("PRAGMA foreign_keys = ON");
                        InvalidationTracker invalidationTracker = WorkDatabase_Impl.this.mInvalidationTracker;
                        synchronized (invalidationTracker) {
                            if (invalidationTracker.mInitialized) {
                                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                            } else {
                                wrappedDb.mDelegate.execSQL("PRAGMA temp_store = MEMORY;");
                                wrappedDb.mDelegate.execSQL("PRAGMA recursive_triggers='ON';");
                                wrappedDb.mDelegate.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                                invalidationTracker.syncTriggers(wrappedDb);
                                invalidationTracker.mCleanupStatement = new FrameworkSQLiteStatement(wrappedDb.mDelegate.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 "));
                                invalidationTracker.mInitialized = true;
                            }
                        }
                        List<RoomDatabase.Callback> list = WorkDatabase_Impl.this.mCallbacks;
                        if (list != null) {
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                if (((WorkDatabase.AnonymousClass2) WorkDatabase_Impl.this.mCallbacks.get(i)) != null) {
                                    wrappedDb.mDelegate.beginTransaction();
                                    try {
                                        wrappedDb.mDelegate.execSQL(WorkDatabase.getPruneSQL());
                                        wrappedDb.mDelegate.setTransactionSuccessful();
                                        wrappedDb.mDelegate.endTransaction();
                                    } catch (Throwable th2) {
                                        wrappedDb.mDelegate.endTransaction();
                                        throw th2;
                                    }
                                } else {
                                    throw null;
                                }
                            }
                        }
                        roomOpenHelper.mConfiguration = null;
                    } finally {
                        query.close();
                    }
                } else {
                    throw null;
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(this.mDbRef, sQLiteDatabase), i, i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
            if ((r1.mDelegate == r3) == false) goto L_0x000e;
         */
        public static FrameworkSQLiteDatabase getWrappedDb(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
            if (frameworkSQLiteDatabase != null) {
            }
            frameworkSQLiteDatabaseArr[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            return frameworkSQLiteDatabaseArr[0];
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z) {
        this.mContext = context;
        this.mName = str;
        this.mCallback = callback;
        this.mUseNoBackupDirectory = z;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        getDelegate().close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mName;
    }

    public final OpenHelper getDelegate() {
        OpenHelper openHelper;
        synchronized (this.mLock) {
            if (this.mDelegate == null) {
                FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr = new FrameworkSQLiteDatabase[1];
                if (this.mName == null || !this.mUseNoBackupDirectory) {
                    this.mDelegate = new OpenHelper(this.mContext, this.mName, frameworkSQLiteDatabaseArr, this.mCallback);
                } else {
                    this.mDelegate = new OpenHelper(this.mContext, new File(this.mContext.getNoBackupFilesDir(), this.mName).getAbsolutePath(), frameworkSQLiteDatabaseArr, this.mCallback);
                }
                this.mDelegate.setWriteAheadLoggingEnabled(this.mWriteAheadLoggingEnabled);
            }
            openHelper = this.mDelegate;
        }
        return openHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getWritableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.mLock) {
            if (this.mDelegate != null) {
                this.mDelegate.setWriteAheadLoggingEnabled(z);
            }
            this.mWriteAheadLoggingEnabled = z;
        }
    }
}
