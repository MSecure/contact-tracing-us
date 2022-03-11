package e.x.a.f;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import e.x.a.e;
/* loaded from: classes.dex */
public class b implements SQLiteDatabase.CursorFactory {
    public final /* synthetic */ e a;

    public b(a aVar, e eVar) {
        this.a = eVar;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.a.d(new e(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }
}
