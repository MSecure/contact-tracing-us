package f.b.a.b.i.s.i;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import f.b.a.b.b;
import f.b.a.b.i.f;
import f.b.a.b.i.i;
import f.b.a.b.i.s.i.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;

public final /* synthetic */ class j implements t.b {
    public final t a;
    public final i b;

    public j(t tVar, i iVar) {
        this.a = tVar;
        this.b = iVar;
    }

    /* JADX INFO: finally extract failed */
    @Override // f.b.a.b.i.s.i.t.b
    public Object a(Object obj) {
        t tVar = this.a;
        i iVar = this.b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        b bVar = t.f2565f;
        Objects.requireNonNull(tVar);
        ArrayList arrayList = new ArrayList();
        Long t = tVar.t(sQLiteDatabase, iVar);
        if (t != null) {
            t.Q(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{t.toString()}, null, null, null, String.valueOf(tVar.f2567e.c())), new k(tVar, arrayList, iVar));
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append(((h) arrayList.get(i2)).b());
            if (i2 < arrayList.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor query = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null);
        while (query.moveToNext()) {
            try {
                long j2 = query.getLong(0);
                Set set = (Set) hashMap.get(Long.valueOf(j2));
                if (set == null) {
                    set = new HashSet();
                    hashMap.put(Long.valueOf(j2), set);
                }
                set.add(new t.c(query.getString(1), query.getString(2), null));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            h hVar = (h) listIterator.next();
            if (hashMap.containsKey(Long.valueOf(hVar.b()))) {
                f.a i3 = hVar.a().i();
                for (t.c cVar : (Set) hashMap.get(Long.valueOf(hVar.b()))) {
                    i3.a(cVar.a, cVar.b);
                }
                listIterator.set(new b(hVar.b(), hVar.c(), i3.b()));
            }
        }
        return arrayList;
    }
}
