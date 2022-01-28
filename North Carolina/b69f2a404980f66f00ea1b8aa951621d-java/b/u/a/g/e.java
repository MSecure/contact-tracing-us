package b.u.a.g;

import android.database.sqlite.SQLiteProgram;
import b.u.a.d;

public class e implements d {

    /* renamed from: b  reason: collision with root package name */
    public final SQLiteProgram f1754b;

    public e(SQLiteProgram sQLiteProgram) {
        this.f1754b = sQLiteProgram;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1754b.close();
    }
}
