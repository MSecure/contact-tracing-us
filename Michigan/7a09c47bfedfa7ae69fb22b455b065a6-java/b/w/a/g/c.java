package b.w.a.g;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import b.s.i;
import b.w.a.b;
import b.w.a.c;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class c implements b.w.a.c {

    /* renamed from: b  reason: collision with root package name */
    public final Context f2619b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2620c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a f2621d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2622e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f2623f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public a f2624g;
    public boolean h;

    public static class a extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        public final a[] f2625b;

        /* renamed from: c  reason: collision with root package name */
        public final c.a f2626c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2627d;

        /* renamed from: b.w.a.g.c$a$a  reason: collision with other inner class name */
        public class C0054a implements DatabaseErrorHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.a f2628a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a[] f2629b;

            public C0054a(c.a aVar, a[] aVarArr) {
                this.f2628a = aVar;
                this.f2629b = aVarArr;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
                r4 = r1.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
                if (r4.hasNext() != false) goto L_0x0030;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
                r0.a((java.lang.String) r4.next().second);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
                r0.a(r4.a());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
                throw r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
                if (r1 != null) goto L_0x0026;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0020 */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
            /* JADX WARNING: Removed duplicated region for block: B:6:0x001e A[ExcHandler: all (r2v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
              PHI: (r1v8 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v1 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v2 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v2 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:4:0x0017, B:7:0x0020, B:8:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:4:0x0017] */
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                c.a aVar = this.f2628a;
                a b2 = a.b(this.f2629b, sQLiteDatabase);
                List<Pair<String, String>> list = null;
                if (aVar != null) {
                    b2.a();
                    if (b2.f2616b.isOpen()) {
                        try {
                            list = b2.f2616b.getAttachedDbs();
                            b2.close();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                        }
                        if (list != null) {
                            for (Pair<String, String> pair : list) {
                                aVar.a((String) pair.second);
                            }
                            return;
                        }
                    }
                    aVar.a(b2.a());
                    return;
                }
                throw null;
            }
        }

        public a(Context context, String str, a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.f2610a, new C0054a(aVar, aVarArr));
            this.f2626c = aVar;
            this.f2625b = aVarArr;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
            if ((r1.f2616b == r3) == false) goto L_0x000e;
         */
        public static a b(a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            a aVar = aVarArr[0];
            if (aVar != null) {
            }
            aVarArr[0] = new a(sQLiteDatabase);
            return aVarArr[0];
        }

        public a a(SQLiteDatabase sQLiteDatabase) {
            return b(this.f2625b, sQLiteDatabase);
        }

        public synchronized b c() {
            this.f2627d = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f2627d) {
                close();
                return c();
            }
            return a(writableDatabase);
        }

        @Override // java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f2625b[0] = null;
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            c.a aVar = this.f2626c;
            b(this.f2625b, sQLiteDatabase);
            if (((i) aVar) == null) {
                throw null;
            }
        }

        /* JADX INFO: finally extract failed */
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            c.a aVar = this.f2626c;
            a b2 = b(this.f2625b, sQLiteDatabase);
            i iVar = (i) aVar;
            if (iVar != null) {
                Cursor c2 = b2.c(new b.w.a.a("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"));
                try {
                    boolean z = false;
                    if (c2.moveToFirst() && c2.getInt(0) == 0) {
                        z = true;
                    }
                    c2.close();
                    iVar.f2511c.createAllTables(b2);
                    if (!z) {
                        i.b onValidateSchema = iVar.f2511c.onValidateSchema(b2);
                        if (!onValidateSchema.f2514a) {
                            StringBuilder h = c.a.a.a.a.h("Pre-packaged database has an invalid schema: ");
                            h.append(onValidateSchema.f2515b);
                            throw new IllegalStateException(h.toString());
                        }
                    }
                    iVar.c(b2);
                    iVar.f2511c.onCreate(b2);
                } catch (Throwable th) {
                    c2.close();
                    throw th;
                }
            } else {
                throw null;
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f2627d = true;
            ((i) this.f2626c).b(b(this.f2625b, sQLiteDatabase), i, i2);
        }

        /* JADX INFO: finally extract failed */
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f2627d) {
                c.a aVar = this.f2626c;
                a b2 = b(this.f2625b, sQLiteDatabase);
                i iVar = (i) aVar;
                if (iVar != null) {
                    Cursor c2 = b2.c(new b.w.a.a("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"));
                    try {
                        if (c2.moveToFirst() && c2.getInt(0) != 0) {
                            Cursor c3 = b2.c(new b.w.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                            try {
                                String string = c3.moveToFirst() ? c3.getString(0) : null;
                                c3.close();
                                if (!iVar.f2512d.equals(string) && !iVar.f2513e.equals(string)) {
                                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                                }
                            } catch (Throwable th) {
                                c3.close();
                                throw th;
                            }
                        } else {
                            i.b onValidateSchema = iVar.f2511c.onValidateSchema(b2);
                            if (onValidateSchema.f2514a) {
                                iVar.f2511c.onPostMigrate(b2);
                                iVar.c(b2);
                            } else {
                                StringBuilder h = c.a.a.a.a.h("Pre-packaged database has an invalid schema: ");
                                h.append(onValidateSchema.f2515b);
                                throw new IllegalStateException(h.toString());
                            }
                        }
                        iVar.f2511c.onOpen(b2);
                        iVar.f2510b = null;
                    } finally {
                        c2.close();
                    }
                } else {
                    throw null;
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f2627d = true;
            this.f2626c.b(b(this.f2625b, sQLiteDatabase), i, i2);
        }
    }

    public c(Context context, String str, c.a aVar, boolean z) {
        this.f2619b = context;
        this.f2620c = str;
        this.f2621d = aVar;
        this.f2622e = z;
    }

    public final a a() {
        a aVar;
        synchronized (this.f2623f) {
            if (this.f2624g == null) {
                a[] aVarArr = new a[1];
                if (this.f2620c == null || !this.f2622e) {
                    this.f2624g = new a(this.f2619b, this.f2620c, aVarArr, this.f2621d);
                } else {
                    this.f2624g = new a(this.f2619b, new File(this.f2619b.getNoBackupFilesDir(), this.f2620c).getAbsolutePath(), aVarArr, this.f2621d);
                }
                this.f2624g.setWriteAheadLoggingEnabled(this.h);
            }
            aVar = this.f2624g;
        }
        return aVar;
    }

    @Override // b.w.a.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // b.w.a.c
    public String getDatabaseName() {
        return this.f2620c;
    }

    @Override // b.w.a.c
    public b p() {
        return a().c();
    }

    @Override // b.w.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.f2623f) {
            if (this.f2624g != null) {
                this.f2624g.setWriteAheadLoggingEnabled(z);
            }
            this.h = z;
        }
    }
}
