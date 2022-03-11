package f.b.c.k.t;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.k.u.l;
import f.b.c.k.v.c;
import f.b.f.d0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class a1 {
    public final SQLiteDatabase a;
    public final h b;

    public a1(SQLiteDatabase sQLiteDatabase, h hVar) {
        this.a = sQLiteDatabase;
        this.b = hVar;
    }

    public final void a() {
        Cursor rawQuery = this.a.rawQuery("SELECT target_id, target_proto FROM targets", null);
        while (rawQuery.moveToNext()) {
            try {
                int i2 = rawQuery.getInt(0);
                try {
                    c.b bVar = (c.b) c.t(rawQuery.getBlob(1)).toBuilder();
                    bVar.copyOnWrite();
                    c.f((c) bVar.instance);
                    this.a.execSQL("UPDATE targets SET target_proto = ? WHERE target_id = ?", new Object[]{((c) bVar.build()).toByteArray(), Integer.valueOf(i2)});
                } catch (d0 unused) {
                    b.z0("Failed to decode Query data for target %s", Integer.valueOf(i2));
                    throw null;
                }
            } catch (Throwable unused2) {
            }
        }
        rawQuery.close();
        return;
        throw th;
    }

    public final void b(String[] strArr, Runnable runnable) {
        String str;
        String e2 = a.e(a.h("["), TextUtils.join(", ", strArr), "]");
        boolean z = false;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str2 = strArr[i2];
            boolean e3 = e(str2);
            if (i2 == 0) {
                z = e3;
            } else if (e3 != z) {
                StringBuilder h2 = a.h(a.c("Expected all of ", e2, " to either exist or not, but "));
                if (z) {
                    h2.append(strArr[0]);
                    h2.append(" exists and ");
                    h2.append(str2);
                    str = " does not";
                } else {
                    h2.append(strArr[0]);
                    h2.append(" does not exist and ");
                    h2.append(str2);
                    str = " does";
                }
                h2.append(str);
                throw new IllegalStateException(h2.toString());
            }
        }
        if (!z) {
            runnable.run();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x0188  */
    public void c(int i2) {
        Throwable th;
        Long l2;
        boolean z = true;
        if (i2 < 1) {
            b(new String[]{"mutation_queues", "mutations", "document_mutations"}, new v0(this));
            b(new String[]{"targets", "target_globals", "target_documents"}, new x0(this));
            b(new String[]{"remote_documents"}, new y0(this));
        }
        if (i2 < 3 && i2 != 0) {
            if (e("targets")) {
                this.a.execSQL("DROP TABLE targets");
            }
            if (e("target_globals")) {
                this.a.execSQL("DROP TABLE target_globals");
            }
            if (e("target_documents")) {
                this.a.execSQL("DROP TABLE target_documents");
            }
            b(new String[]{"targets", "target_globals", "target_documents"}, new x0(this));
        }
        Cursor cursor = null;
        if (i2 < 4) {
            if (!(DatabaseUtils.queryNumEntries(this.a, "target_globals") == 1)) {
                this.a.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", new String[]{"0", "0", "0", "0"});
            }
            if (!d("target_globals", "target_count")) {
                this.a.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER");
            }
            long queryNumEntries = DatabaseUtils.queryNumEntries(this.a, "targets");
            ContentValues contentValues = new ContentValues();
            contentValues.put("target_count", Long.valueOf(queryNumEntries));
            this.a.update("target_globals", contentValues, null, null);
        }
        if (i2 < 5 && !d("target_documents", "sequence_number")) {
            this.a.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER");
        }
        if (i2 < 6) {
            SQLiteDatabase sQLiteDatabase = this.a;
            w0 w0Var = new w0(this);
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT uid, last_acknowledged_batch_id FROM mutation_queues", null);
            while (rawQuery.moveToNext()) {
                try {
                    w0Var.a(rawQuery);
                } catch (Throwable unused) {
                }
            }
            rawQuery.close();
        }
        if (i2 < 7) {
            try {
                Cursor rawQuery2 = this.a.rawQuery("SELECT highest_listen_sequence_number FROM target_globals LIMIT 1", null);
                try {
                    if (rawQuery2.moveToFirst()) {
                        l2 = Long.valueOf(rawQuery2.getLong(0));
                        rawQuery2.close();
                    } else {
                        rawQuery2.close();
                        l2 = null;
                    }
                    b.a1(l2 != null, "Missing highest sequence number", new Object[0]);
                    long longValue = l2.longValue();
                    SQLiteStatement compileStatement = this.a.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)");
                    SQLiteDatabase sQLiteDatabase2 = this.a;
                    s0 s0Var = new s0(new Object[]{100});
                    boolean[] zArr = new boolean[1];
                    while (true) {
                        zArr[0] = false;
                        Cursor rawQueryWithFactory = sQLiteDatabase2.rawQueryWithFactory(s0Var, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?", null, null);
                        while (rawQueryWithFactory.moveToNext()) {
                            try {
                                zArr[0] = z;
                                compileStatement.clearBindings();
                                String string = rawQueryWithFactory.getString(0);
                                int i3 = z ? 1 : 0;
                                int i4 = z ? 1 : 0;
                                int i5 = z ? 1 : 0;
                                int i6 = z ? 1 : 0;
                                compileStatement.bindString(i3, string);
                                compileStatement.bindLong(2, longValue);
                                b.a1(compileStatement.executeInsert() != -1, "Failed to insert a sentinel row", new Object[0]);
                                z = true;
                            } catch (Throwable unused2) {
                            }
                        }
                        rawQueryWithFactory.close();
                        if (!zArr[0]) {
                            break;
                        }
                        z = true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                }
                throw th;
            }
        }
        if (i2 < 8) {
            b(new String[]{"collection_parents"}, new z0(this));
            HashMap hashMap = new HashMap();
            SQLiteStatement compileStatement2 = this.a.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)");
            Cursor rawQuery3 = this.a.rawQuery("SELECT path FROM remote_documents", null);
            while (rawQuery3.moveToNext()) {
                try {
                    l lVar = (l) b.h0(rawQuery3.getString(0)).q();
                    b.a1(lVar.n() % 2 == 1, "Expected a collection path.", new Object[0]);
                    String h2 = lVar.h();
                    l lVar2 = (l) lVar.q();
                    HashSet hashSet = (HashSet) hashMap.get(h2);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        hashMap.put(h2, hashSet);
                    }
                    if (hashSet.add(lVar2)) {
                        String h3 = lVar.h();
                        compileStatement2.clearBindings();
                        compileStatement2.bindString(1, h3);
                        compileStatement2.bindString(2, b.s0((l) lVar.q()));
                        compileStatement2.execute();
                    }
                } catch (Throwable unused3) {
                }
            }
            rawQuery3.close();
            Cursor rawQuery4 = this.a.rawQuery("SELECT path FROM document_mutations", null);
            while (rawQuery4.moveToNext()) {
                try {
                    l lVar3 = (l) b.h0(rawQuery4.getString(0)).q();
                    b.a1(lVar3.n() % 2 == 1, "Expected a collection path.", new Object[0]);
                    String h4 = lVar3.h();
                    l lVar4 = (l) lVar3.q();
                    HashSet hashSet2 = (HashSet) hashMap.get(h4);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet();
                        hashMap.put(h4, hashSet2);
                    }
                    if (hashSet2.add(lVar4)) {
                        String h5 = lVar3.h();
                        compileStatement2.clearBindings();
                        compileStatement2.bindString(1, h5);
                        compileStatement2.bindString(2, b.s0((l) lVar3.q()));
                        compileStatement2.execute();
                    }
                } catch (Throwable unused4) {
                }
            }
            rawQuery4.close();
        }
        if (i2 < 9) {
            boolean d2 = d("remote_documents", "read_time_seconds");
            boolean d3 = d("remote_documents", "read_time_nanos");
            b.a1(d2 == d3, "Table contained just one of read_time_seconds or read_time_nanos", new Object[0]);
            if (!(d2 && d3)) {
                this.a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_seconds INTEGER");
                this.a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_nanos INTEGER");
            } else {
                a();
            }
        }
        if (i2 == 9) {
            a();
        }
        if (i2 < 11) {
            Cursor rawQuery5 = this.a.rawQuery("SELECT target_id, target_proto FROM targets", null);
            while (rawQuery5.moveToNext()) {
                try {
                    int i7 = rawQuery5.getInt(0);
                    try {
                        this.a.execSQL("UPDATE targets SET canonical_id  = ? WHERE target_id = ?", new Object[]{this.b.c(c.t(rawQuery5.getBlob(1))).a.a(), Integer.valueOf(i7)});
                    } catch (d0 unused5) {
                        b.z0("Failed to decode Query data for target %s", Integer.valueOf(i7));
                        throw null;
                    }
                } catch (Throwable unused6) {
                }
            }
            rawQuery5.close();
        }
        return;
        throw th;
        throw th;
        throw th;
        throw th;
        throw th;
    }

    public final boolean d(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA table_info(" + str + ")", null);
            int columnIndex = rawQuery.getColumnIndex("name");
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(columnIndex));
            }
            rawQuery.close();
            return arrayList.indexOf(str2) != -1;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean e(String str) {
        Cursor cursor = null;
        try {
            cursor = this.a.rawQueryWithFactory(new s0(new Object[]{str}), "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?", null, null);
            boolean z = !cursor.moveToFirst();
            cursor.close();
            return !z;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
