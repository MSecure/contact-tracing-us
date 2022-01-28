package b.w.a.g;

import android.database.sqlite.SQLiteProgram;
import b.w.a.d;

public class e implements d {

    /* renamed from: b  reason: collision with root package name */
    public final SQLiteProgram f2630b;

    public e(SQLiteProgram sQLiteProgram) {
        this.f2630b = sQLiteProgram;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2630b.close();
    }
}
