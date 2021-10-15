package b.w.a.g;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import b.w.a.b;
import b.w.a.e;

public class a implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f2615c = new String[0];

    /* renamed from: b  reason: collision with root package name */
    public final SQLiteDatabase f2616b;

    /* renamed from: b.w.a.g.a$a  reason: collision with other inner class name */
    public class C0053a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f2617a;

        public C0053a(a aVar, e eVar) {
            this.f2617a = eVar;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f2617a.b(new e(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f2616b = sQLiteDatabase;
    }

    public String a() {
        return this.f2616b.getPath();
    }

    public boolean b() {
        return this.f2616b.inTransaction();
    }

    public Cursor c(e eVar) {
        return this.f2616b.rawQueryWithFactory(new C0053a(this, eVar), eVar.a(), f2615c, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2616b.close();
    }

    public Cursor d(String str) {
        return c(new b.w.a.a(str));
    }
}
