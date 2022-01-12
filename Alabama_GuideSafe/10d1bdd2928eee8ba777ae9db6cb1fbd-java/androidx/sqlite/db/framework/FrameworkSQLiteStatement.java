package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;

public class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteStatement mDelegate;

    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.mDelegate = sQLiteStatement;
    }

    public int executeUpdateDelete() {
        return this.mDelegate.executeUpdateDelete();
    }
}
