package e.v.a.f;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import e.v.a.b;
import e.v.a.e;

public class a implements b {
    public static final String[] c = new String[0];
    public final SQLiteDatabase b;

    /* renamed from: e.v.a.f.a$a  reason: collision with other inner class name */
    public class C0060a implements SQLiteDatabase.CursorFactory {
        public final /* synthetic */ e a;

        public C0060a(a aVar, e eVar) {
            this.a = eVar;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.d(new e(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this.b = sQLiteDatabase;
    }

    public String c() {
        return this.b.getPath();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }

    public Cursor d(e eVar) {
        return this.b.rawQueryWithFactory(new C0060a(this, eVar), eVar.c(), c, null);
    }

    public Cursor v(String str) {
        return d(new e.v.a.a(str));
    }
}
