package e.w.a.f;

import android.database.sqlite.SQLiteProgram;
import e.w.a.d;

public class e implements d {
    public final SQLiteProgram b;

    public e(SQLiteProgram sQLiteProgram) {
        this.b = sQLiteProgram;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }
}
