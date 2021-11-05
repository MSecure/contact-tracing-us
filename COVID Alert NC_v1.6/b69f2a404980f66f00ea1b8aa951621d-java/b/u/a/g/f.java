package b.u.a.g;

import android.database.sqlite.SQLiteStatement;

public class f extends e implements b.u.a.f {

    /* renamed from: c  reason: collision with root package name */
    public final SQLiteStatement f1755c;

    public f(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f1755c = sQLiteStatement;
    }

    public long a() {
        return this.f1755c.executeInsert();
    }

    public int b() {
        return this.f1755c.executeUpdateDelete();
    }
}
