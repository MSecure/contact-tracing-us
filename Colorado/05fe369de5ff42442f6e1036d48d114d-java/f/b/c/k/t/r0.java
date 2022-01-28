package f.b.c.k.t;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteTransactionListener;
import f.b.c.d;
import f.b.c.k.r.f;
import f.b.c.k.s.s;
import f.b.c.k.t.v;
import f.b.c.k.x.g;
import f.b.c.k.x.m;
import f.b.c.k.x.n;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class r0 extends f0 {
    public final SQLiteOpenHelper b;
    public final h c;

    /* renamed from: d  reason: collision with root package name */
    public final b1 f3296d;

    /* renamed from: e  reason: collision with root package name */
    public final l0 f3297e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f3298f;

    /* renamed from: g  reason: collision with root package name */
    public final n0 f3299g;

    /* renamed from: h  reason: collision with root package name */
    public final SQLiteTransactionListener f3300h;

    /* renamed from: i  reason: collision with root package name */
    public SQLiteDatabase f3301i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3302j;

    public class a implements SQLiteTransactionListener {
        public a() {
        }

        public void onBegin() {
            r0.this.f3299g.g();
        }

        public void onCommit() {
            r0.this.f3299g.e();
        }

        public void onRollback() {
        }
    }

    public static class b extends SQLiteOpenHelper {
        public final h b;
        public boolean c;

        public b(Context context, h hVar, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 11);
            this.b = hVar;
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.c = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (!this.c) {
                onConfigure(sQLiteDatabase);
            }
            new a1(sQLiteDatabase, this.b).c(0);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (!this.c) {
                onConfigure(sQLiteDatabase);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.c) {
                onConfigure(sQLiteDatabase);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (!this.c) {
                onConfigure(sQLiteDatabase);
            }
            new a1(sQLiteDatabase, this.b).c(i2);
        }
    }

    public static class c {
        public final SQLiteDatabase a;
        public final String b;
        public SQLiteDatabase.CursorFactory c;

        public c(SQLiteDatabase sQLiteDatabase, String str) {
            this.a = sQLiteDatabase;
            this.b = str;
        }

        public c a(Object... objArr) {
            this.c = new s0(objArr);
            return this;
        }

        public int b(g<Cursor> gVar) {
            Cursor c2 = c();
            int i2 = 0;
            while (c2.moveToNext()) {
                try {
                    i2++;
                    gVar.a(c2);
                } catch (Throwable unused) {
                }
            }
            c2.close();
            return i2;
            throw th;
        }

        public final Cursor c() {
            SQLiteDatabase.CursorFactory cursorFactory = this.c;
            return cursorFactory != null ? this.a.rawQueryWithFactory(cursorFactory, this.b, null, null) : this.a.rawQuery(this.b, null);
        }
    }

    public r0(Context context, String str, f.b.c.k.u.b bVar, h hVar, v.a aVar) {
        try {
            b bVar2 = new b(context, hVar, "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(bVar.b, "utf-8") + "." + URLEncoder.encode(bVar.c, "utf-8"));
            this.f3300h = new a();
            this.b = bVar2;
            this.c = hVar;
            this.f3296d = new b1(this, hVar);
            this.f3297e = new l0(this);
            this.f3298f = new u0(this, hVar);
            this.f3299g = new n0(this, aVar);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static void j(SQLiteProgram sQLiteProgram, Object[] objArr) {
        int i2;
        long longValue;
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (obj == null) {
                sQLiteProgram.bindNull(i3 + 1);
            } else if (obj instanceof String) {
                sQLiteProgram.bindString(i3 + 1, (String) obj);
            } else {
                if (obj instanceof Integer) {
                    i2 = i3 + 1;
                    longValue = (long) ((Integer) obj).intValue();
                } else if (obj instanceof Long) {
                    i2 = i3 + 1;
                    longValue = ((Long) obj).longValue();
                } else if (obj instanceof Double) {
                    sQLiteProgram.bindDouble(i3 + 1, ((Double) obj).doubleValue());
                } else if (obj instanceof byte[]) {
                    sQLiteProgram.bindBlob(i3 + 1, (byte[]) obj);
                } else {
                    f.b.a.c.b.o.b.q0("Unknown argument %s of type %s", obj, obj.getClass());
                    throw null;
                }
                sQLiteProgram.bindLong(i2, longValue);
            }
        }
    }

    @Override // f.b.c.k.t.f0
    public f a() {
        return this.f3297e;
    }

    @Override // f.b.c.k.t.f0
    public e0 b(f fVar) {
        return new q0(this, this.c, fVar);
    }

    @Override // f.b.c.k.t.f0
    public i0 c() {
        return this.f3299g;
    }

    @Override // f.b.c.k.t.f0
    public k0 d() {
        return this.f3298f;
    }

    @Override // f.b.c.k.t.f0
    public c1 e() {
        return this.f3296d;
    }

    @Override // f.b.c.k.t.f0
    public boolean f() {
        return this.f3302j;
    }

    @Override // f.b.c.k.t.f0
    public <T> T g(String str, n<T> nVar) {
        m.a(m.a.DEBUG, f0.a, "Starting transaction: %s", str);
        this.f3301i.beginTransactionWithListener(this.f3300h);
        try {
            T t = nVar.get();
            this.f3301i.setTransactionSuccessful();
            return t;
        } finally {
            this.f3301i.endTransaction();
        }
    }

    @Override // f.b.c.k.t.f0
    public void h(String str, Runnable runnable) {
        m.a(m.a.DEBUG, f0.a, "Starting transaction: %s", str);
        this.f3301i.beginTransactionWithListener(this.f3300h);
        try {
            runnable.run();
            this.f3301i.setTransactionSuccessful();
        } finally {
            this.f3301i.endTransaction();
        }
    }

    @Override // f.b.c.k.t.f0
    public void i() {
        boolean z;
        boolean z2 = true;
        f.b.a.c.b.o.b.M0(!this.f3302j, "SQLitePersistence double-started!", new Object[0]);
        this.f3302j = true;
        try {
            this.f3301i = this.b.getWritableDatabase();
            b1 b1Var = this.f3296d;
            Cursor cursor = null;
            try {
                Cursor rawQuery = b1Var.a.f3301i.rawQuery("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1", null);
                if (rawQuery.moveToFirst()) {
                    b1Var.c = rawQuery.getInt(0);
                    b1Var.f3271d = (long) rawQuery.getInt(1);
                    b1Var.f3272e = new f.b.c.k.u.m(new d(rawQuery.getLong(2), rawQuery.getInt(3)));
                    b1Var.f3273f = rawQuery.getLong(4);
                    rawQuery.close();
                    z = true;
                } else {
                    rawQuery.close();
                    z = false;
                }
                if (!z) {
                    z2 = false;
                }
                f.b.a.c.b.o.b.M0(z2, "Missing target_globals entry", new Object[0]);
                this.f3299g.b = new s(this.f3296d.f3271d);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteDatabaseLockedException e2) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e2);
        }
    }

    public c k(String str) {
        return new c(this.f3301i, str);
    }
}
