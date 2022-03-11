package f.b.a.b.i.s.i;

import android.database.sqlite.SQLiteDatabase;
import f.b.a.b.i.s.i.z;
import java.util.List;
/* loaded from: classes.dex */
public final /* synthetic */ class y implements z.a {
    public static final y a = new y();

    @Override // f.b.a.b.i.s.i.z.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        List<z.a> list = z.f2664d;
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }
}
