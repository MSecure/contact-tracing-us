package f.b.a.b.i.s.i;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import f.b.a.b.b;
import f.b.a.b.i.f;
import f.b.a.b.i.i;
import f.b.a.b.i.s.i.t;
import f.b.a.b.i.v.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public final /* synthetic */ class s implements t.b {
    public final t a;
    public final i b;
    public final f c;

    public s(t tVar, i iVar, f fVar) {
        this.a = tVar;
        this.b = iVar;
        this.c = fVar;
    }

    @Override // f.b.a.b.i.s.i.t.b
    public Object a(Object obj) {
        long j2;
        t tVar = this.a;
        i iVar = this.b;
        f fVar = this.c;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        b bVar = t.f2396f;
        if (tVar.d().compileStatement("PRAGMA page_size").simpleQueryForLong() * tVar.d().compileStatement("PRAGMA page_count").simpleQueryForLong() >= tVar.f2398e.e()) {
            return -1L;
        }
        Long v = tVar.v(sQLiteDatabase, iVar);
        if (v != null) {
            j2 = v.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("backend_name", iVar.b());
            contentValues.put("priority", Integer.valueOf(a.a(iVar.d())));
            contentValues.put("next_request_ms", (Integer) 0);
            if (iVar.c() != null) {
                contentValues.put("extras", Base64.encodeToString(iVar.c(), 0));
            }
            j2 = sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        int d2 = tVar.f2398e.d();
        byte[] bArr = fVar.d().b;
        boolean z = bArr.length <= d2;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(j2));
        contentValues2.put("transport_name", fVar.g());
        contentValues2.put("timestamp_ms", Long.valueOf(fVar.e()));
        contentValues2.put("uptime_ms", Long.valueOf(fVar.h()));
        contentValues2.put("payload_encoding", fVar.d().a.a);
        contentValues2.put("code", fVar.c());
        contentValues2.put("num_attempts", (Integer) 0);
        contentValues2.put("inline", Boolean.valueOf(z));
        contentValues2.put("payload", z ? bArr : new byte[0]);
        long insert = sQLiteDatabase.insert("events", null, contentValues2);
        if (!z) {
            int ceil = (int) Math.ceil(((double) bArr.length) / ((double) d2));
            for (int i2 = 1; i2 <= ceil; i2++) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (i2 - 1) * d2, Math.min(i2 * d2, bArr.length));
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("event_id", Long.valueOf(insert));
                contentValues3.put("sequence_num", Integer.valueOf(i2));
                contentValues3.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues3);
            }
        }
        for (Map.Entry entry : Collections.unmodifiableMap(fVar.b()).entrySet()) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("event_id", Long.valueOf(insert));
            contentValues4.put("name", (String) entry.getKey());
            contentValues4.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues4);
        }
        return Long.valueOf(insert);
    }
}
