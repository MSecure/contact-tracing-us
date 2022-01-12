package androidx.room;

import androidx.sqlite.db.framework.FrameworkSQLiteStatement;

public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, T t);

    public final void insert(T t) {
        FrameworkSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            acquire.mDelegate.executeInsert();
            if (acquire == this.mStmt) {
                this.mLock.set(false);
            }
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }
}
