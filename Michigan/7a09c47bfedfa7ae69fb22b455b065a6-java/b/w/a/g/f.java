package b.w.a.g;

import android.database.sqlite.SQLiteStatement;

public class f extends e implements b.w.a.f {

    /* renamed from: c  reason: collision with root package name */
    public final SQLiteStatement f2631c;

    public f(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f2631c = sQLiteStatement;
    }

    public long a() {
        return this.f2631c.executeInsert();
    }

    public int b() {
        return this.f2631c.executeUpdateDelete();
    }
}
