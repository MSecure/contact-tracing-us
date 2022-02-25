package f.b.a.b.i.s.i;

import android.database.sqlite.SQLiteDatabase;
import f.b.a.b.i.s.i.z;
import java.util.List;

public final /* synthetic */ class x implements z.a {
    public static final x a = new x();

    @Override // f.b.a.b.i.s.i.z.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        List<z.a> list = z.f2392d;
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
