package b.u.a.g;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import b.u.a.b;
import b.u.a.e;

public class a implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f1741c = new String[0];

    /* renamed from: b  reason: collision with root package name */
    public final SQLiteDatabase f1742b;

    /* renamed from: b.u.a.g.a$a  reason: collision with other inner class name */
    public class C0043a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f1743a;

        public C0043a(a aVar, e eVar) {
            this.f1743a = eVar;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f1743a.b(new e(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f1742b = sQLiteDatabase;
    }

    public String a() {
        return this.f1742b.getPath();
    }

    public boolean b() {
        return this.f1742b.inTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1742b.close();
    }

    public Cursor d(e eVar) {
        return this.f1742b.rawQueryWithFactory(new C0043a(this, eVar), eVar.a(), f1741c, null);
    }

    public Cursor e(String str) {
        return d(new b.u.a.a(str));
    }
}
