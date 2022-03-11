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
import f.b.c.k.x.g;
import f.b.g.d0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
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
                    c.b builder = c.t(rawQuery.getBlob(1)).toBuilder();
                    builder.copyOnWrite();
                    c.f((c) builder.instance);
                    this.a.execSQL("UPDATE targets SET target_proto = ? WHERE target_id = ?", new Object[]{builder.build().toByteArray(), Integer.valueOf(i2)});
                } catch (d0 unused) {
                    b.r0("Failed to decode Query data for target %s", Integer.valueOf(i2));
                    throw null;
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th;
            }
        }
        rawQuery.close();
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

    public void c(int i2) {
        Throwable th;
        Long l2;
        boolean z = true;
        if (i2 < 1) {
            b(new String[]{"mutation_queues", "mutations", "document_mutations"}, new Runnable(this) { // from class: f.b.c.k.t.v0
                public final a1 b;

                {
                    this.b = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a1 a1Var = this.b;
                    a1Var.a.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
                    a1Var.a.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
                    a1Var.a.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
                }
            });
            b(new String[]{"targets", "target_globals", "target_documents"}, new Runnable(this) { // from class: f.b.c.k.t.x0
                public final a1 b;

                {
                    this.b = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a1 a1Var = this.b;
                    a1Var.a.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
                    a1Var.a.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
                    a1Var.a.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
                    a1Var.a.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
                    a1Var.a.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
                }
            });
            b(new String[]{"remote_documents"}, new Runnable(this) { // from class: f.b.c.k.t.y0
                public final a1 b;

                {
                    this.b = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.b.a.execSQL("CREATE TABLE remote_documents (path TEXT PRIMARY KEY, contents BLOB)");
                }
            });
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
            b(new String[]{"targets", "target_globals", "target_documents"}, new Runnable(this) { // from class: f.b.c.k.t.x0
                public final a1 b;

                {
                    this.b = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a1 a1Var = this.b;
                    a1Var.a.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
                    a1Var.a.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
                    a1Var.a.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
                    a1Var.a.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
                    a1Var.a.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
                }
            });
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
            w0 w0Var = new g(this) { // from class: f.b.c.k.t.w0
                public final a1 a;

                {
                    this.a = r1;
                }

                @Override // f.b.c.k.x.g
                public void a(Object obj) {
                    a1 a1Var = this.a;
                    Cursor cursor2 = (Cursor) obj;
                    String string = cursor2.getString(0);
                    Cursor rawQueryWithFactory = a1Var.a.rawQueryWithFactory(new s0(new Object[]{string, Long.valueOf(cursor2.getLong(1))}), "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?", null, null);
                    while (rawQueryWithFactory.moveToNext()) {
                        try {
                            int i3 = rawQueryWithFactory.getInt(0);
                            SQLiteStatement compileStatement = a1Var.a.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
                            compileStatement.bindString(1, string);
                            compileStatement.bindLong(2, (long) i3);
                            b.P0(compileStatement.executeUpdateDelete() != 0, "Mutatiohn batch (%s, %d) did not exist", string, Integer.valueOf(i3));
                            a1Var.a.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[]{string, Integer.valueOf(i3)});
                        } catch (Throwable th2) {
                            if (rawQueryWithFactory != null) {
                                try {
                                    rawQueryWithFactory.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th2;
                        }
                    }
                    rawQueryWithFactory.close();
                }
            };
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT uid, last_acknowledged_batch_id FROM mutation_queues", null);
            while (rawQuery.moveToNext()) {
                try {
                    w0Var.a(rawQuery);
                } finally {
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
                    b.P0(l2 != null, "Missing highest sequence number", new Object[0]);
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
                                b.P0(compileStatement.executeInsert() != -1, "Failed to insert a sentinel row", new Object[0]);
                                z = true;
                            } finally {
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
            }
        }
        if (i2 < 8) {
            b(new String[]{"collection_parents"}, new Runnable(this) { // from class: f.b.c.k.t.z0
                public final a1 b;

                {
                    this.b = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.b.a.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
                }
            });
            HashMap hashMap = new HashMap();
            SQLiteStatement compileStatement2 = this.a.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)");
            Cursor rawQuery3 = this.a.rawQuery("SELECT path FROM remote_documents", null);
            while (rawQuery3.moveToNext()) {
                try {
                    l q = b.c0(rawQuery3.getString(0)).q();
                    b.P0(q.n() % 2 == 1, "Expected a collection path.", new Object[0]);
                    String h2 = q.h();
                    l q2 = q.q();
                    HashSet hashSet = (HashSet) hashMap.get(h2);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        hashMap.put(h2, hashSet);
                    }
                    if (hashSet.add(q2)) {
                        String h3 = q.h();
                        compileStatement2.clearBindings();
                        compileStatement2.bindString(1, h3);
                        compileStatement2.bindString(2, b.m0(q.q()));
                        compileStatement2.execute();
                    }
                } finally {
                    if (rawQuery3 != null) {
                        try {
                            rawQuery3.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            rawQuery3.close();
            Cursor rawQuery4 = this.a.rawQuery("SELECT path FROM document_mutations", null);
            while (rawQuery4.moveToNext()) {
                try {
                    l q3 = b.c0(rawQuery4.getString(0)).q();
                    b.P0(q3.n() % 2 == 1, "Expected a collection path.", new Object[0]);
                    String h4 = q3.h();
                    l q4 = q3.q();
                    HashSet hashSet2 = (HashSet) hashMap.get(h4);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet();
                        hashMap.put(h4, hashSet2);
                    }
                    if (hashSet2.add(q4)) {
                        String h5 = q3.h();
                        compileStatement2.clearBindings();
                        compileStatement2.bindString(1, h5);
                        compileStatement2.bindString(2, b.m0(q3.q()));
                        compileStatement2.execute();
                    }
                } finally {
                    if (rawQuery4 != null) {
                        try {
                            rawQuery4.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            rawQuery4.close();
        }
        if (i2 < 9) {
            boolean d2 = d("remote_documents", "read_time_seconds");
            boolean d3 = d("remote_documents", "read_time_nanos");
            b.P0(d2 == d3, "Table contained just one of read_time_seconds or read_time_nanos", new Object[0]);
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
                    } catch (d0 unused3) {
                        b.r0("Failed to decode Query data for target %s", Integer.valueOf(i7));
                        throw null;
                    }
                } finally {
                    if (rawQuery5 != null) {
                        try {
                            rawQuery5.close();
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
            rawQuery5.close();
        }
    }

    public final boolean d(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            cursor = sQLiteDatabase.rawQuery("PRAGMA table_info(" + str + ")", null);
            int columnIndex = cursor.getColumnIndex("name");
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(columnIndex));
            }
            cursor.close();
            return arrayList.indexOf(str2) != -1;
        } catch (Throwable th) {
            if (cursor != null) {
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
