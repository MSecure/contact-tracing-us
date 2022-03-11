package e.x.a.f;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import e.x.a.b;
import e.x.a.e;
/* loaded from: classes.dex */
public class a implements b {
    public static final String[] c = new String[0];
    public final SQLiteDatabase b;

    /* renamed from: e.x.a.f.a$a */
    /* loaded from: classes.dex */
    public class C0065a implements SQLiteDatabase.CursorFactory {
        public final /* synthetic */ e a;

        public C0065a(a aVar, e eVar) {
            this.a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
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
        return this.b.rawQueryWithFactory(new C0065a(this, eVar), eVar.c(), c, null);
    }

    public Cursor t(String str) {
        return d(new e.x.a.a(str));
    }
}
