package f.b.a.b.i.s.i;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class z extends SQLiteOpenHelper {

    /* renamed from: d */
    public static final List<a> f2664d = Arrays.asList(v.a, w.a, x.a, y.a);
    public final int b;
    public boolean c = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    public z(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.b = i2;
    }

    public final void c(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        List<a> list = f2664d;
        if (i3 <= list.size()) {
            while (i2 < i3) {
                f2664d.get(i2).a(sQLiteDatabase);
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i2 + " to " + i3 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.c = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i2 = this.b;
        if (!this.c) {
            onConfigure(sQLiteDatabase);
        }
        c(sQLiteDatabase, 0, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        if (!this.c) {
            onConfigure(sQLiteDatabase);
        }
        c(sQLiteDatabase, 0, i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!this.c) {
            onConfigure(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (!this.c) {
            onConfigure(sQLiteDatabase);
        }
        c(sQLiteDatabase, i2, i3);
    }
}
