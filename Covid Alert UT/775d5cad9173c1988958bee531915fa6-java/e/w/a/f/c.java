package e.w.a.f;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Pair;
import e.u.h;
import e.w.a.b;
import e.w.a.c;
import java.io.File;
import java.util.List;
import java.util.Objects;

public class c implements e.w.a.c {
    public final Context b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a f2024d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2025e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f2026f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public a f2027g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2028h;

    public static class a extends SQLiteOpenHelper {
        public final a[] b;
        public final c.a c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2029d;

        /* renamed from: e.w.a.f.c$a$a  reason: collision with other inner class name */
        public class C0062a implements DatabaseErrorHandler {
            public final /* synthetic */ c.a a;
            public final /* synthetic */ a[] b;

            public C0062a(c.a aVar, a[] aVarArr) {
                this.a = aVar;
                this.b = aVarArr;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
                if (r4.hasNext() != false) goto L_0x0033;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
                r0.a((java.lang.String) r4.next().second);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
                r0.a(r4.c());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
                throw r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
                if (r1 != null) goto L_0x0029;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
                r4 = r1.iterator();
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0021 */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
            /* JADX WARNING: Removed duplicated region for block: B:5:0x001f A[ExcHandler: all (r2v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
              PHI: (r1v10 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:3:0x0018, B:6:0x0021, B:7:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x0018] */
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                a d2;
                List<Pair<String, String>> list;
                c.a aVar = this.a;
                d2 = a.d(this.b, sQLiteDatabase);
                Objects.requireNonNull(aVar);
                d2.c();
                if (d2.b.isOpen()) {
                    list = null;
                    try {
                        list = d2.b.getAttachedDbs();
                    } catch (SQLiteException unknown) {
                        d2.b.close();
                        if (list != null) {
                        }
                    } catch (Throwable th) {
                    }
                    d2.b.close();
                    if (list != null) {
                        for (Pair<String, String> pair : list) {
                            aVar.a((String) pair.second);
                        }
                        return;
                    }
                }
                aVar.a(d2.c());
            }
        }

        public a(Context context, String str, a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.a, new C0062a(aVar, aVarArr));
            this.c = aVar;
            this.b = aVarArr;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
            if ((r1.b == r3) == false) goto L_0x000e;
         */
        public static a d(a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            a aVar = aVarArr[0];
            if (aVar != null) {
            }
            aVarArr[0] = new a(sQLiteDatabase);
            return aVarArr[0];
        }

        public a c(SQLiteDatabase sQLiteDatabase) {
            return d(this.b, sQLiteDatabase);
        }

        @Override // java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.b[0] = null;
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            c.a aVar = this.c;
            d(this.b, sQLiteDatabase);
            Objects.requireNonNull((h) aVar);
        }

        /* JADX INFO: finally extract failed */
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            c.a aVar = this.c;
            a d2 = d(this.b, sQLiteDatabase);
            h hVar = (h) aVar;
            Objects.requireNonNull(hVar);
            Cursor d3 = d2.d(new e.w.a.a("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"));
            try {
                boolean z = false;
                if (d3.moveToFirst() && d3.getInt(0) == 0) {
                    z = true;
                }
                d3.close();
                hVar.c.a(d2);
                if (!z) {
                    h.b g2 = hVar.c.g(d2);
                    if (!g2.a) {
                        StringBuilder h2 = f.a.a.a.a.h("Pre-packaged database has an invalid schema: ");
                        h2.append(g2.b);
                        throw new IllegalStateException(h2.toString());
                    }
                }
                hVar.c(d2);
                hVar.c.c(d2);
            } catch (Throwable th) {
                d3.close();
                throw th;
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f2029d = true;
            ((h) this.c).b(d(this.b, sQLiteDatabase), i2, i3);
        }

        /* JADX INFO: finally extract failed */
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f2029d) {
                c.a aVar = this.c;
                a d2 = d(this.b, sQLiteDatabase);
                h hVar = (h) aVar;
                Objects.requireNonNull(hVar);
                Cursor d3 = d2.d(new e.w.a.a("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"));
                try {
                    boolean z = d3.moveToFirst() && d3.getInt(0) != 0;
                    d3.close();
                    if (z) {
                        Cursor d4 = d2.d(new e.w.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                        try {
                            String string = d4.moveToFirst() ? d4.getString(0) : null;
                            d4.close();
                            if (!hVar.f1994d.equals(string) && !hVar.f1995e.equals(string)) {
                                throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                            }
                        } catch (Throwable th) {
                            d4.close();
                            throw th;
                        }
                    } else {
                        h.b g2 = hVar.c.g(d2);
                        if (g2.a) {
                            hVar.c.e(d2);
                            hVar.c(d2);
                        } else {
                            StringBuilder h2 = f.a.a.a.a.h("Pre-packaged database has an invalid schema: ");
                            h2.append(g2.b);
                            throw new IllegalStateException(h2.toString());
                        }
                    }
                    hVar.c.d(d2);
                    hVar.b = null;
                } catch (Throwable th2) {
                    d3.close();
                    throw th2;
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f2029d = true;
            this.c.b(d(this.b, sQLiteDatabase), i2, i3);
        }

        public synchronized b t() {
            this.f2029d = false;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (this.f2029d) {
                close();
                return t();
            }
            return c(writableDatabase);
        }
    }

    public c(Context context, String str, c.a aVar, boolean z) {
        this.b = context;
        this.c = str;
        this.f2024d = aVar;
        this.f2025e = z;
    }

    @Override // e.w.a.c
    public b E() {
        return c().t();
    }

    public final a c() {
        a aVar;
        synchronized (this.f2026f) {
            if (this.f2027g == null) {
                a[] aVarArr = new a[1];
                if (Build.VERSION.SDK_INT < 23 || this.c == null || !this.f2025e) {
                    this.f2027g = new a(this.b, this.c, aVarArr, this.f2024d);
                } else {
                    this.f2027g = new a(this.b, new File(this.b.getNoBackupFilesDir(), this.c).getAbsolutePath(), aVarArr, this.f2024d);
                }
                this.f2027g.setWriteAheadLoggingEnabled(this.f2028h);
            }
            aVar = this.f2027g;
        }
        return aVar;
    }

    @Override // e.w.a.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c().close();
    }

    @Override // e.w.a.c
    public String getDatabaseName() {
        return this.c;
    }

    @Override // e.w.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.f2026f) {
            a aVar = this.f2027g;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z);
            }
            this.f2028h = z;
        }
    }
}
