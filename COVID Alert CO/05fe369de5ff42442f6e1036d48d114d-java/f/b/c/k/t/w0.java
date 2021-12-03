package f.b.c.k.t;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import f.b.a.c.b.o.b;
import f.b.c.k.x.g;

public final /* synthetic */ class w0 implements g {
    public final a1 a;

    public w0(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // f.b.c.k.x.g
    public void a(Object obj) {
        a1 a1Var = this.a;
        Cursor cursor = (Cursor) obj;
        String string = cursor.getString(0);
        Cursor rawQueryWithFactory = a1Var.a.rawQueryWithFactory(new s0(new Object[]{string, Long.valueOf(cursor.getLong(1))}), "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?", null, null);
        while (rawQueryWithFactory.moveToNext()) {
            try {
                int i2 = rawQueryWithFactory.getInt(0);
                SQLiteStatement compileStatement = a1Var.a.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
                compileStatement.bindString(1, string);
                compileStatement.bindLong(2, (long) i2);
                b.M0(compileStatement.executeUpdateDelete() != 0, "Mutatiohn batch (%s, %d) did not exist", string, Integer.valueOf(i2));
                a1Var.a.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[]{string, Integer.valueOf(i2)});
            } catch (Throwable unused) {
            }
        }
        rawQueryWithFactory.close();
        return;
        throw th;
    }
}
