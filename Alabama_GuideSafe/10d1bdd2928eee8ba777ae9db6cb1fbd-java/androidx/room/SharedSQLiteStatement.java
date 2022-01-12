package androidx.room;

import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class SharedSQLiteStatement {
    public final RoomDatabase mDatabase;
    public final AtomicBoolean mLock = new AtomicBoolean(false);
    public volatile FrameworkSQLiteStatement mStmt;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    public FrameworkSQLiteStatement acquire() {
        this.mDatabase.assertNotMainThread();
        if (this.mLock.compareAndSet(false, true)) {
            if (this.mStmt == null) {
                this.mStmt = this.mDatabase.compileStatement(createQuery());
            }
            return this.mStmt;
        }
        return this.mDatabase.compileStatement(createQuery());
    }

    public abstract String createQuery();

    public void release(FrameworkSQLiteStatement frameworkSQLiteStatement) {
        if (frameworkSQLiteStatement == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
