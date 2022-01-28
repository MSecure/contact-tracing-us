package f.b.a.b.i.s.i;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import f.b.a.b.b;
import f.b.a.b.i.s.i.t;
import f.b.a.b.i.v.a;

public final /* synthetic */ class i implements t.b {
    public final long a;
    public final f.b.a.b.i.i b;

    public i(long j2, f.b.a.b.i.i iVar) {
        this.a = j2;
        this.b = iVar;
    }

    @Override // f.b.a.b.i.s.i.t.b
    public Object a(Object obj) {
        long j2 = this.a;
        f.b.a.b.i.i iVar = this.b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        b bVar = t.f2565f;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j2));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{iVar.b(), String.valueOf(a.a(iVar.d()))}) < 1) {
            contentValues.put("backend_name", iVar.b());
            contentValues.put("priority", Integer.valueOf(a.a(iVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
