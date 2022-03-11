package e.x.a.f;

import android.database.sqlite.SQLiteStatement;
import e.x.a.d;
/* loaded from: classes.dex */
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
