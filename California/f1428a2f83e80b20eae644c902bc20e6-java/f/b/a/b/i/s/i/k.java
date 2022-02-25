package f.b.a.b.i.s.i;

import android.database.Cursor;
import f.b.a.b.b;
import f.b.a.b.i.a;
import f.b.a.b.i.e;
import f.b.a.b.i.i;
import f.b.a.b.i.s.i.t;
import java.util.HashMap;
import java.util.List;

public final /* synthetic */ class k implements t.b {
    public final t a;
    public final List b;
    public final i c;

    public k(t tVar, List list, i iVar) {
        this.a = tVar;
        this.b = list;
        this.c = iVar;
    }

    @Override // f.b.a.b.i.s.i.t.b
    public Object a(Object obj) {
        b bVar;
        b bVar2;
        t tVar = this.a;
        List list = this.b;
        i iVar = this.c;
        Cursor cursor = (Cursor) obj;
        b bVar3 = t.f2388f;
        while (cursor.moveToNext()) {
            long j2 = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            a.b bVar4 = new a.b();
            bVar4.f2342f = new HashMap();
            bVar4.f(cursor.getString(1));
            bVar4.e(cursor.getLong(2));
            bVar4.g(cursor.getLong(3));
            if (z) {
                String string = cursor.getString(4);
                if (string == null) {
                    bVar2 = t.f2388f;
                } else {
                    bVar2 = new b(string);
                }
                bVar4.d(new e(bVar2, cursor.getBlob(5)));
            } else {
                String string2 = cursor.getString(4);
                if (string2 == null) {
                    bVar = t.f2388f;
                } else {
                    bVar = new b(string2);
                }
                bVar4.d(new e(bVar, (byte[]) t.V(tVar.d().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num"), l.a)));
            }
            if (!cursor.isNull(6)) {
                bVar4.b = Integer.valueOf(cursor.getInt(6));
            }
            list.add(new b(j2, iVar, bVar4.b()));
        }
        return null;
    }
}
