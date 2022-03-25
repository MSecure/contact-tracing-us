package f.b.a.b.i.s.i;

import android.database.Cursor;
import android.util.Base64;
import f.b.a.b.b;
import f.b.a.b.i.b;
import f.b.a.b.i.i;
import f.b.a.b.i.s.i.t;
import f.b.a.b.i.v.a;
import java.util.ArrayList;

public final /* synthetic */ class p implements t.b {
    public static final p a = new p();

    @Override // f.b.a.b.i.s.i.t.b
    public Object a(Object obj) {
        byte[] bArr;
        Cursor cursor = (Cursor) obj;
        b bVar = t.f2476f;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            i.a a2 = i.a();
            a2.b(cursor.getString(1));
            a2.c(a.b(cursor.getInt(2)));
            String string = cursor.getString(3);
            if (string == null) {
                bArr = null;
            } else {
                bArr = Base64.decode(string, 0);
            }
            b.C0079b bVar2 = (b.C0079b) a2;
            bVar2.b = bArr;
            arrayList.add(bVar2.a());
        }
        return arrayList;
    }
}
