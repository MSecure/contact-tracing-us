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
/* loaded from: classes.dex */
public final class r0 extends f0 {
    public final SQLiteOpenHelper b;
    public final h c;

    /* renamed from: d */
    public final b1 f3614d;

    /* renamed from: e */
    public final l0 f3615e;

    /* renamed from: f */
    public final u0 f3616f;

    /* renamed from: g */
    public final n0 f3617g;

    /* renamed from: h */
    public final SQLiteTransactionListener f3618h;

    /* renamed from: i */
    public SQLiteDatabase f3619i;

    /* renamed from: j */
    public boolean f3620j;

    /* loaded from: classes.dex */
    public class a implements SQLiteTransactionListener {
        public a() {
            r0.this = r1;
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onBegin() {
            r0.this.f3617g.g();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onCommit() {
            r0.this.f3617g.e();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onRollback() {
        }
    }

    /* loaded from: classes.dex */
    public static class b extends SQLiteOpenHelper {
        public final h b;
        public boolean c;

        public b(Context context, h hVar, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 11);
            this.b = hVar;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.c = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (!this.c) {
                onConfigure(sQLiteDatabase);
            }
            new a1(sQLiteDatabase, this.b).c(0);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (!this.c) {
                onConfigure(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.c) {
                onConfigure(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (!this.c) {
                onConfigure(sQLiteDatabase);
            }
            new a1(sQLiteDatabase, this.b).c(i2);
        }
    }

    /* loaded from: classes.dex */
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
            Cursor c = c();
            int i2 = 0;
            while (c.moveToNext()) {
                try {
                    i2++;
                    gVar.a(c);
                } catch (Throwable th) {
                    if (c != null) {
                        try {
                            c.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            }
            c.close();
            return i2;
        }

        public final Cursor c() {
            SQLiteDatabase.CursorFactory cursorFactory = this.c;
            return cursorFactory != null ? this.a.rawQueryWithFactory(cursorFactory, this.b, null, null) : this.a.rawQuery(this.b, null);
        }
    }

    public r0(Context context, String str, f.b.c.k.u.b bVar, h hVar, v.a aVar) {
        try {
            b bVar2 = new b(context, hVar, "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(bVar.b, "utf-8") + "." + URLEncoder.encode(bVar.c, "utf-8"));
            this.f3618h = new a();
            this.b = bVar2;
            this.c = hVar;
            this.f3614d = new b1(this, hVar);
            this.f3615e = new l0(this);
            this.f3616f = new u0(this, hVar);
            this.f3617g = new n0(this, aVar);
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
                    f.b.a.c.b.o.b.r0("Unknown argument %s of type %s", obj, obj.getClass());
                    throw null;
                }
                sQLiteProgram.bindLong(i2, longValue);
            }
        }
    }

    @Override // f.b.c.k.t.f0
    public f a() {
        return this.f3615e;
    }

    @Override // f.b.c.k.t.f0
    public e0 b(f fVar) {
        return new q0(this, this.c, fVar);
    }

    @Override // f.b.c.k.t.f0
    public i0 c() {
        return this.f3617g;
    }

    @Override // f.b.c.k.t.f0
    public k0 d() {
        return this.f3616f;
    }

    @Override // f.b.c.k.t.f0
    public c1 e() {
        return this.f3614d;
    }

    @Override // f.b.c.k.t.f0
    public boolean f() {
        return this.f3620j;
    }

    @Override // f.b.c.k.t.f0
    public <T> T g(String str, n<T> nVar) {
        m.a(m.a.DEBUG, f0.a, "Starting transaction: %s", str);
        this.f3619i.beginTransactionWithListener(this.f3618h);
        try {
            T t = nVar.get();
            this.f3619i.setTransactionSuccessful();
            return t;
        } finally {
            this.f3619i.endTransaction();
        }
    }

    @Override // f.b.c.k.t.f0
    public void h(String str, Runnable runnable) {
        m.a(m.a.DEBUG, f0.a, "Starting transaction: %s", str);
        this.f3619i.beginTransactionWithListener(this.f3618h);
        try {
            runnable.run();
            this.f3619i.setTransactionSuccessful();
        } finally {
            this.f3619i.endTransaction();
        }
    }

    @Override // f.b.c.k.t.f0
    public void i() {
        boolean z;
        boolean z2 = true;
        f.b.a.c.b.o.b.P0(!this.f3620j, "SQLitePersistence double-started!", new Object[0]);
        this.f3620j = true;
        try {
            this.f3619i = this.b.getWritableDatabase();
            b1 b1Var = this.f3614d;
            Cursor cursor = null;
            try {
                cursor = b1Var.a.f3619i.rawQuery("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1", null);
                if (cursor.moveToFirst()) {
                    b1Var.c = cursor.getInt(0);
                    b1Var.f3589d = (long) cursor.getInt(1);
                    b1Var.f3590e = new f.b.c.k.u.m(new d(cursor.getLong(2), cursor.getInt(3)));
                    b1Var.f3591f = cursor.getLong(4);
                    cursor.close();
                    z = true;
                } else {
                    cursor.close();
                    z = false;
                }
                if (!z) {
                    z2 = false;
                }
                f.b.a.c.b.o.b.P0(z2, "Missing target_globals entry", new Object[0]);
                this.f3617g.b = new s(this.f3614d.f3589d);
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteDatabaseLockedException e2) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e2);
        }
    }

    public c k(String str) {
        return new c(this.f3619i, str);
    }
}
