package androidx.work.impl.model;

import android.database.Cursor;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;

public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<SystemIdInfo> __insertionAdapterOfSystemIdInfo;
    public final SharedSQLiteStatement __preparedStmtOfRemoveSystemIdInfo;

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSystemIdInfo = new EntityInsertionAdapter<SystemIdInfo>(this, roomDatabase) {
            /* class androidx.work.impl.model.SystemIdInfoDao_Impl.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.framework.FrameworkSQLiteStatement, java.lang.Object] */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, SystemIdInfo systemIdInfo) {
                SystemIdInfo systemIdInfo2 = systemIdInfo;
                String str = systemIdInfo2.workSpecId;
                if (str == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(1);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindString(1, str);
                }
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(2, (long) systemIdInfo2.systemId);
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            }
        };
        this.__preparedStmtOfRemoveSystemIdInfo = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.SystemIdInfoDao_Impl.AnonymousClass2 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    public SystemIdInfo getSystemIdInfo(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        SystemIdInfo systemIdInfo = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "work_spec_id");
            int columnIndexOrThrow2 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "system_id");
            if (query.moveToFirst()) {
                systemIdInfo = new SystemIdInfo(query.getString(columnIndexOrThrow), query.getInt(columnIndexOrThrow2));
            }
            return systemIdInfo;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insertSystemIdInfo(SystemIdInfo systemIdInfo) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSystemIdInfo.insert(systemIdInfo);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void removeSystemIdInfo(String str) {
        this.__db.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement acquire = this.__preparedStmtOfRemoveSystemIdInfo.acquire();
        if (str == null) {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindNull(1);
        } else {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            SharedSQLiteStatement sharedSQLiteStatement = this.__preparedStmtOfRemoveSystemIdInfo;
            if (acquire == sharedSQLiteStatement.mStmt) {
                sharedSQLiteStatement.mLock.set(false);
            }
        } catch (Throwable th) {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveSystemIdInfo.release(acquire);
            throw th;
        }
    }
}
