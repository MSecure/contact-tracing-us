package f.b.a.b.i.s.i;

import android.database.sqlite.SQLiteDatabase;
import f.b.a.b.i.s.i.z;
import java.util.List;

public final /* synthetic */ class w implements z.a {
    public static final w a = new w();

    @Override // f.b.a.b.i.s.i.z.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        List<z.a> list = z.f2623d;
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }
}
