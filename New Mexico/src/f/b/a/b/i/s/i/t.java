package f.b.a.b.i.s.i;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import e.b.a.m;
import f.b.a.b.b;
import f.b.a.b.i.f;
import f.b.a.b.i.i;
import f.b.a.b.i.t.b;
import f.b.a.b.i.v.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class t implements c, f.b.a.b.i.t.b {

    /* renamed from: f */
    public static final f.b.a.b.b f2660f = new f.b.a.b.b("proto");
    public final z b;
    public final f.b.a.b.i.u.a c;

    /* renamed from: d */
    public final f.b.a.b.i.u.a f2661d;

    /* renamed from: e */
    public final d f2662e;

    /* loaded from: classes.dex */
    public interface b<T, U> {
        U a(T t);
    }

    /* loaded from: classes.dex */
    public static class c {
        public final String a;
        public final String b;

        public c(String str, String str2, a aVar) {
            this.a = str;
            this.b = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        T a();
    }

    public t(f.b.a.b.i.u.a aVar, f.b.a.b.i.u.a aVar2, d dVar, z zVar) {
        this.b = zVar;
        this.c = aVar;
        this.f2661d = aVar2;
        this.f2662e = dVar;
    }

    public static String L(Iterable<h> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<h> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> T Q(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.a(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // f.b.a.b.i.s.i.c
    public void D(i iVar, long j2) {
        x(new b(j2, iVar) { // from class: f.b.a.b.i.s.i.i
            public final long a;
            public final f.b.a.b.i.i b;

            {
                this.a = r1;
                this.b = r3;
            }

            @Override // f.b.a.b.i.s.i.t.b
            public Object a(Object obj) {
                long j3 = this.a;
                f.b.a.b.i.i iVar2 = this.b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                b bVar = t.f2660f;
                ContentValues contentValues = new ContentValues();
                contentValues.put("next_request_ms", Long.valueOf(j3));
                if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{iVar2.b(), String.valueOf(a.a(iVar2.d()))}) < 1) {
                    contentValues.put("backend_name", iVar2.b());
                    contentValues.put("priority", Integer.valueOf(a.a(iVar2.d())));
                    sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                return null;
            }
        });
    }

    public final <T> T J(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.f2661d.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f2661d.a() >= ((long) this.f2662e.a()) + a2) {
                    return bVar.a(e2);
                }
                SystemClock.sleep(50);
            }
        }
    }

    @Override // f.b.a.b.i.s.i.c
    public h N(i iVar, f fVar) {
        Object[] objArr = {iVar.d(), fVar.g(), iVar.b()};
        m.e.C0("SQLiteEventStore");
        String.format("Storing event with priority=%s, name=%s for destination %s", objArr);
        long longValue = ((Long) x(new b(this, iVar, fVar) { // from class: f.b.a.b.i.s.i.s
            public final t a;
            public final i b;
            public final f c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // f.b.a.b.i.s.i.t.b
            public Object a(Object obj) {
                long j2;
                t tVar = this.a;
                i iVar2 = this.b;
                f fVar2 = this.c;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                b bVar = t.f2660f;
                if (tVar.d().compileStatement("PRAGMA page_size").simpleQueryForLong() * tVar.d().compileStatement("PRAGMA page_count").simpleQueryForLong() >= tVar.f2662e.e()) {
                    return -1L;
                }
                Long t = tVar.t(sQLiteDatabase, iVar2);
                if (t != null) {
                    j2 = t.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", iVar2.b());
                    contentValues.put("priority", Integer.valueOf(a.a(iVar2.d())));
                    contentValues.put("next_request_ms", (Integer) 0);
                    if (iVar2.c() != null) {
                        contentValues.put("extras", Base64.encodeToString(iVar2.c(), 0));
                    }
                    j2 = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int d2 = tVar.f2662e.d();
                byte[] bArr = fVar2.d().b;
                boolean z = bArr.length <= d2;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(j2));
                contentValues2.put("transport_name", fVar2.g());
                contentValues2.put("timestamp_ms", Long.valueOf(fVar2.e()));
                contentValues2.put("uptime_ms", Long.valueOf(fVar2.h()));
                contentValues2.put("payload_encoding", fVar2.d().a.a);
                contentValues2.put("code", fVar2.c());
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
                for (Map.Entry entry : Collections.unmodifiableMap(fVar2.b()).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(insert));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(insert);
            }
        })).longValue();
        if (longValue < 1) {
            return null;
        }
        return new b(longValue, iVar, fVar);
    }

    @Override // f.b.a.b.i.s.i.c
    public Iterable<i> P() {
        SQLiteDatabase d2 = d();
        d2.beginTransaction();
        try {
            List list = (List) Q(d2.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), p.a);
            d2.setTransactionSuccessful();
            return list;
        } finally {
            d2.endTransaction();
        }
    }

    @Override // f.b.a.b.i.t.b
    public <T> T c(b.a<T> aVar) {
        SQLiteDatabase d2 = d();
        J(new d(d2) { // from class: f.b.a.b.i.s.i.m
            public final SQLiteDatabase a;

            {
                this.a = r1;
            }

            @Override // f.b.a.b.i.s.i.t.d
            public Object a() {
                SQLiteDatabase sQLiteDatabase = this.a;
                f.b.a.b.b bVar = t.f2660f;
                sQLiteDatabase.beginTransaction();
                return null;
            }
        }, n.a);
        try {
            T a2 = aVar.a();
            d2.setTransactionSuccessful();
            return a2;
        } finally {
            d2.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }

    public SQLiteDatabase d() {
        z zVar = this.b;
        zVar.getClass();
        return (SQLiteDatabase) J(new d(zVar) { // from class: f.b.a.b.i.s.i.o
            public final z a;

            {
                this.a = r1;
            }

            @Override // f.b.a.b.i.s.i.t.d
            public Object a() {
                return this.a.getWritableDatabase();
            }
        }, r.a);
    }

    /* JADX WARN: Finally extract failed */
    @Override // f.b.a.b.i.s.i.c
    public int g() {
        long a2 = this.c.a() - this.f2662e.b();
        SQLiteDatabase d2 = d();
        d2.beginTransaction();
        try {
            Integer valueOf = Integer.valueOf(d2.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(a2)}));
            d2.setTransactionSuccessful();
            d2.endTransaction();
            return valueOf.intValue();
        } catch (Throwable th) {
            d2.endTransaction();
            throw th;
        }
    }

    @Override // f.b.a.b.i.s.i.c
    public void j(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder h2 = f.a.a.a.a.h("DELETE FROM events WHERE _id in ");
            h2.append(L(iterable));
            d().compileStatement(h2.toString()).execute();
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // f.b.a.b.i.s.i.c
    public long k(i iVar) {
        Cursor rawQuery = d().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{iVar.b(), String.valueOf(f.b.a.b.i.v.a.a(iVar.d()))});
        try {
            Long valueOf = Long.valueOf(rawQuery.moveToNext() ? rawQuery.getLong(0) : 0);
            rawQuery.close();
            return valueOf.longValue();
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // f.b.a.b.i.s.i.c
    public boolean r(i iVar) {
        SQLiteDatabase d2 = d();
        d2.beginTransaction();
        try {
            Long t = t(d2, iVar);
            Boolean bool = t == null ? Boolean.FALSE : (Boolean) Q(d().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{t.toString()}), q.a);
            d2.setTransactionSuccessful();
            d2.endTransaction();
            return bool.booleanValue();
        } catch (Throwable th) {
            d2.endTransaction();
            throw th;
        }
    }

    public final Long t(SQLiteDatabase sQLiteDatabase, i iVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(iVar.b(), String.valueOf(f.b.a.b.i.v.a.a(iVar.d()))));
        if (iVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(iVar.c(), 0));
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !query.moveToNext() ? null : Long.valueOf(query.getLong(0));
        } finally {
            query.close();
        }
    }

    @Override // f.b.a.b.i.s.i.c
    public Iterable<h> w(i iVar) {
        return (Iterable) x(new b(this, iVar) { // from class: f.b.a.b.i.s.i.j
            public final t a;
            public final i b;

            {
                this.a = r1;
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: INVOKE  
                  (wrap: android.database.Cursor : 0x0047: INVOKE  (r2v20 android.database.Cursor A[REMOVE]) = 
                  (r15v1 'sQLiteDatabase' android.database.sqlite.SQLiteDatabase)
                  ("events")
                  (wrap: java.lang.String[] : 0x0029: FILLED_NEW_ARRAY  (r4v9 java.lang.String[] A[REMOVE]) = ("_id"), ("transport_name"), ("timestamp_ms"), ("uptime_ms"), ("payload_encoding"), ("payload"), ("code"), ("inline") elemType: java.lang.String)
                  ("context_id = ?")
                  (wrap: java.lang.String[] : ?: FILLED_NEW_ARRAY  (r6v2 java.lang.String[] A[REMOVE]) = 
                  (wrap: java.lang.String : 0x002f: INVOKE  (r2v1 't' java.lang.Long) type: VIRTUAL call: java.lang.Long.toString():java.lang.String)
                 elemType: java.lang.String)
                  (null java.lang.String)
                  (null java.lang.String)
                  (null java.lang.String)
                  (wrap: java.lang.String : 0x003e: INVOKE  (r10v1 java.lang.String A[REMOVE]) = 
                  (wrap: int : 0x003a: INVOKE  (r2v18 int A[REMOVE]) = 
                  (wrap: f.b.a.b.i.s.i.d : 0x0038: IGET  (r2v17 f.b.a.b.i.s.i.d A[REMOVE]) = (r0v0 'tVar' f.b.a.b.i.s.i.t) f.b.a.b.i.s.i.t.e f.b.a.b.i.s.i.d)
                 type: VIRTUAL call: f.b.a.b.i.s.i.d.c():int)
                 type: STATIC call: java.lang.String.valueOf(int):java.lang.String)
                 type: VIRTUAL call: android.database.sqlite.SQLiteDatabase.query(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.database.Cursor)
                  (wrap: f.b.a.b.i.s.i.k : 0x004d: CONSTRUCTOR  (r3v22 f.b.a.b.i.s.i.k A[REMOVE]) = (r0v0 'tVar' f.b.a.b.i.s.i.t), (r11v0 'arrayList' java.util.ArrayList), (r1v0 'iVar2' f.b.a.b.i.i) call: f.b.a.b.i.s.i.k.<init>(f.b.a.b.i.s.i.t, java.util.List, f.b.a.b.i.i):void type: CONSTRUCTOR)
                 type: STATIC call: f.b.a.b.i.s.i.t.Q(android.database.Cursor, f.b.a.b.i.s.i.t$b):java.lang.Object in method: f.b.a.b.i.s.i.j.a(java.lang.Object):java.lang.Object, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.b.i.s.i.k, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 16 more
                */
            @Override // f.b.a.b.i.s.i.t.b
            public java.lang.Object a(java.lang.Object r15) {
                /*
                // Method dump skipped, instructions count: 320
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.b.i.s.i.j.a(java.lang.Object):java.lang.Object");
            }
        });
    }

    public final <T> T x(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase d2 = d();
        d2.beginTransaction();
        try {
            T a2 = bVar.a(d2);
            d2.setTransactionSuccessful();
            return a2;
        } finally {
            d2.endTransaction();
        }
    }

    @Override // f.b.a.b.i.s.i.c
    public void y(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder h2 = f.a.a.a.a.h("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            h2.append(L(iterable));
            String sb = h2.toString();
            SQLiteDatabase d2 = d();
            d2.beginTransaction();
            try {
                d2.compileStatement(sb).execute();
                d2.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                d2.setTransactionSuccessful();
            } finally {
                d2.endTransaction();
            }
        }
    }
}
