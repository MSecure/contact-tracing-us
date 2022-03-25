package f.b.a.b.i.s.i;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import e.b.a.m;
import f.b.a.b.i.f;
import f.b.a.b.i.i;
import f.b.a.b.i.t.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class t implements c, f.b.a.b.i.t.b {

    /* renamed from: f  reason: collision with root package name */
    public static final f.b.a.b.b f2476f = new f.b.a.b.b("proto");
    public final z b;
    public final f.b.a.b.i.u.a c;

    /* renamed from: d  reason: collision with root package name */
    public final f.b.a.b.i.u.a f2477d;

    /* renamed from: e  reason: collision with root package name */
    public final d f2478e;

    public interface b<T, U> {
        U a(T t);
    }

    public static class c {
        public final String a;
        public final String b;

        public c(String str, String str2, a aVar) {
            this.a = str;
            this.b = str2;
        }
    }

    public interface d<T> {
        T a();
    }

    public t(f.b.a.b.i.u.a aVar, f.b.a.b.i.u.a aVar2, d dVar, z zVar) {
        this.b = zVar;
        this.c = aVar;
        this.f2477d = aVar2;
        this.f2478e = dVar;
    }

    public static String P(Iterable<h> iterable) {
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

    public static <T> T V(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.a(cursor);
        } finally {
            cursor.close();
        }
    }

    public final <T> T A(b<SQLiteDatabase, T> bVar) {
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
    public void B(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder h2 = f.a.a.a.a.h("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            h2.append(P(iterable));
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

    @Override // f.b.a.b.i.s.i.c
    public void H(i iVar, long j2) {
        A(new i(j2, iVar));
    }

    public final <T> T N(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.f2477d.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f2477d.a() >= ((long) this.f2478e.a()) + a2) {
                    return bVar.a(e2);
                }
                SystemClock.sleep(50);
            }
        }
    }

    @Override // f.b.a.b.i.s.i.c
    public h S(i iVar, f fVar) {
        Object[] objArr = {iVar.d(), fVar.g(), iVar.b()};
        m.h.o0("SQLiteEventStore");
        String.format("Storing event with priority=%s, name=%s for destination %s", objArr);
        long longValue = ((Long) A(new s(this, iVar, fVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return new b(longValue, iVar, fVar);
    }

    @Override // f.b.a.b.i.s.i.c
    public Iterable<i> U() {
        SQLiteDatabase d2 = d();
        d2.beginTransaction();
        try {
            List list = (List) V(d2.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), p.a);
            d2.setTransactionSuccessful();
            return list;
        } finally {
            d2.endTransaction();
        }
    }

    @Override // f.b.a.b.i.t.b
    public <T> T c(b.a<T> aVar) {
        SQLiteDatabase d2 = d();
        N(new m(d2), n.a);
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
        return (SQLiteDatabase) N(new o(zVar), r.a);
    }

    /* JADX INFO: finally extract failed */
    @Override // f.b.a.b.i.s.i.c
    public int g() {
        long a2 = this.c.a() - this.f2478e.b();
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
            h2.append(P(iterable));
            d().compileStatement(h2.toString()).execute();
        }
    }

    /* JADX INFO: finally extract failed */
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

    /* JADX INFO: finally extract failed */
    @Override // f.b.a.b.i.s.i.c
    public boolean t(i iVar) {
        Boolean bool;
        SQLiteDatabase d2 = d();
        d2.beginTransaction();
        try {
            Long v = v(d2, iVar);
            if (v == null) {
                bool = Boolean.FALSE;
            } else {
                bool = (Boolean) V(d().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{v.toString()}), q.a);
            }
            d2.setTransactionSuccessful();
            d2.endTransaction();
            return bool.booleanValue();
        } catch (Throwable th) {
            d2.endTransaction();
            throw th;
        }
    }

    public final Long v(SQLiteDatabase sQLiteDatabase, i iVar) {
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
    public Iterable<h> z(i iVar) {
        return (Iterable) A(new j(this, iVar));
    }
}
