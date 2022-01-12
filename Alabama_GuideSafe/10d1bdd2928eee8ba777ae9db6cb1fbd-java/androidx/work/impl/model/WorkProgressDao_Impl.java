package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

public final class WorkProgressDao_Impl implements WorkProgressDao {
    public final RoomDatabase __db;
    public final SharedSQLiteStatement __preparedStmtOfDelete;
    public final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        new AtomicBoolean(false);
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkProgressDao_Impl.AnonymousClass2 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkProgressDao_Impl.AnonymousClass3 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
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
            SharedSQLiteStatement sharedSQLiteStatement = this.__preparedStmtOfDelete;
            if (acquire == sharedSQLiteStatement.mStmt) {
                sharedSQLiteStatement.mLock.set(false);
            }
        } catch (Throwable th) {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(acquire);
            throw th;
        }
    }

    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            SharedSQLiteStatement sharedSQLiteStatement = this.__preparedStmtOfDeleteAll;
            if (acquire == sharedSQLiteStatement.mStmt) {
                sharedSQLiteStatement.mLock.set(false);
            }
        } catch (Throwable th) {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
            throw th;
        }
    }
}
