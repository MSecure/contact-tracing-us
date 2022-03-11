package f.b.c.k.t;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
/* loaded from: classes.dex */
public final /* synthetic */ class s0 implements SQLiteDatabase.CursorFactory {
    public final Object[] a;

    public s0(Object[] objArr) {
        this.a = objArr;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        r0.j(sQLiteQuery, this.a);
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }
}
