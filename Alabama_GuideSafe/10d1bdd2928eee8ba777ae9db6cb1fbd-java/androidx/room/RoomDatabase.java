package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class RoomDatabase {
    public boolean mAllowMainThreadQueries;
    @Deprecated
    public List<Callback> mCallbacks;
    public final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    @Deprecated
    public volatile SupportSQLiteDatabase mDatabase;
    public final InvalidationTracker mInvalidationTracker;
    public SupportSQLiteOpenHelper mOpenHelper;
    public Executor mQueryExecutor;
    public final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    public boolean mWriteAheadLoggingEnabled;

    public static class Builder<T extends RoomDatabase> {
        public boolean mAllowDestructiveMigrationOnDowngrade;
        public boolean mAllowMainThreadQueries;
        public ArrayList<Callback> mCallbacks;
        public final Context mContext;
        public final Class<T> mDatabaseClass;
        public SupportSQLiteOpenHelper.Factory mFactory;
        public JournalMode mJournalMode = JournalMode.AUTOMATIC;
        public final MigrationContainer mMigrationContainer = new MigrationContainer();
        public Set<Integer> mMigrationStartAndEndVersions;
        public final String mName;
        public Executor mQueryExecutor;
        public boolean mRequireMigration = true;
        public Executor mTransactionExecutor;

        public Builder(Context context, Class<T> cls, String str) {
            this.mContext = context;
            this.mDatabaseClass = cls;
            this.mName = str;
        }

        public Builder<T> addMigrations(Migration... migrationArr) {
            if (this.mMigrationStartAndEndVersions == null) {
                this.mMigrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            MigrationContainer migrationContainer = this.mMigrationContainer;
            if (migrationContainer != null) {
                for (Migration migration2 : migrationArr) {
                    int i = migration2.startVersion;
                    int i2 = migration2.endVersion;
                    TreeMap<Integer, Migration> treeMap = migrationContainer.mMigrations.get(Integer.valueOf(i));
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                        migrationContainer.mMigrations.put(Integer.valueOf(i), treeMap);
                    }
                    Migration migration3 = treeMap.get(Integer.valueOf(i2));
                    if (migration3 != null) {
                        Log.w("ROOM", "Overriding migration " + migration3 + " with " + migration2);
                    }
                    treeMap.put(Integer.valueOf(i2), migration2);
                }
                return this;
            }
            throw null;
        }
    }

    public static abstract class Callback {
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING
    }

    public static class MigrationContainer {
        public HashMap<Integer, TreeMap<Integer, Migration>> mMigrations = new HashMap<>();
    }

    public RoomDatabase() {
        new ConcurrentHashMap();
        this.mInvalidationTracker = new InvalidationTracker((WorkDatabase_Impl) this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
            }
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(writableDatabase);
        ((FrameworkSQLiteDatabase) writableDatabase).mDelegate.beginTransaction();
    }

    public FrameworkSQLiteStatement compileStatement(String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return new FrameworkSQLiteStatement(((FrameworkSQLiteDatabase) this.mOpenHelper.getWritableDatabase()).mDelegate.compileStatement(str));
    }

    @Deprecated
    public void endTransaction() {
        ((FrameworkSQLiteDatabase) this.mOpenHelper.getWritableDatabase()).mDelegate.endTransaction();
        if (!inTransaction()) {
            InvalidationTracker invalidationTracker = this.mInvalidationTracker;
            if (invalidationTracker.mPendingRefresh.compareAndSet(false, true)) {
                invalidationTracker.mDatabase.mQueryExecutor.execute(invalidationTracker.mRefreshRunnable);
            }
        }
    }

    public boolean inTransaction() {
        return ((FrameworkSQLiteDatabase) this.mOpenHelper.getWritableDatabase()).mDelegate.inTransaction();
    }

    public boolean isOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        return supportSQLiteDatabase != null && ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.isOpen();
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal == null) {
            return ((FrameworkSQLiteDatabase) this.mOpenHelper.getWritableDatabase()).query(supportSQLiteQuery);
        }
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) this.mOpenHelper.getWritableDatabase();
        return frameworkSQLiteDatabase.mDelegate.rawQueryWithFactory(new SQLiteDatabase.CursorFactory(frameworkSQLiteDatabase, supportSQLiteQuery) {
            /* class androidx.sqlite.db.framework.FrameworkSQLiteDatabase.AnonymousClass2 */
            public final /* synthetic */ SupportSQLiteQuery val$supportQuery;

            {
                this.val$supportQuery = r2;
            }

            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                this.val$supportQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.getSql(), FrameworkSQLiteDatabase.EMPTY_STRING_ARRAY, null, cancellationSignal);
    }

    @Deprecated
    public void setTransactionSuccessful() {
        ((FrameworkSQLiteDatabase) this.mOpenHelper.getWritableDatabase()).mDelegate.setTransactionSuccessful();
    }
}
