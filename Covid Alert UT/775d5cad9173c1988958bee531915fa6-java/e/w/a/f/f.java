package e.w.a.f;

import android.database.sqlite.SQLiteStatement;
import e.w.a.d;

public class f extends e implements d {
    public final SQLiteStatement c;

    public f(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.c = sQLiteStatement;
    }

    public long c() {
        return this.c.executeInsert();
    }

    public int d() {
        return this.c.executeUpdateDelete();
    }
}
