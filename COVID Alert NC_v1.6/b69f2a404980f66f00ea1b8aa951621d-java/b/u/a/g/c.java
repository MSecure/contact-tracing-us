package b.u.a.g;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import b.r.i;
import b.u.a.b;
import b.u.a.c;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class c implements b.u.a.c {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1745b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1746c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a f1747d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1748e;
    public final Object f = new Object();
    public a g;
    public boolean h;

    public static class a extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        public final a[] f1749b;

        /* renamed from: c  reason: collision with root package name */
        public final c.a f1750c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1751d;

        /* renamed from: b.u.a.g.c$a$a  reason: collision with other inner class name */
        public class C0044a implements DatabaseErrorHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.a f1752a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a[] f1753b;

            public C0044a(c.a aVar, a[] aVarArr) {
                this.f1752a = aVar;
                this.f1753b = aVarArr;
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
                c.a aVar = this.f1752a;
                a b2 = a.b(this.f1753b, sQLiteDatabase);
                List<Pair<String, String>> list = null;
                if (aVar != null) {
                    b2.a();
                    if (b2.f1742b.isOpen()) {
                        try {
                            list = b2.f1742b.getAttachedDbs();
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
            super(context, str, null, aVar.f1736a, new C0044a(aVar, aVarArr));
            this.f1750c = aVar;
            this.f1749b = aVarArr;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
            if ((r1.f1742b == r3) == false) goto L_0x000e;
         */
        public static a b(a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            a aVar = aVarArr[0];
            if (aVar != null) {
            }
            aVarArr[0] = new a(sQLiteDatabase);
            return aVarArr[0];
        }

        public a a(SQLiteDatabase sQLiteDatabase) {
            return b(this.f1749b, sQLiteDatabase);
        }

        @Override // java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f1749b[0] = null;
        }

        public synchronized b d() {
            this.f1751d = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f1751d) {
                close();
                return d();
            }
            return a(writableDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            c.a aVar = this.f1750c;
            b(this.f1749b, sQLiteDatabase);
            if (((i) aVar) == null) {
                throw null;
            }
        }

        /* JADX INFO: finally extract failed */
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            c.a aVar = this.f1750c;
            a b2 = b(this.f1749b, sQLiteDatabase);
            i iVar = (i) aVar;
            if (iVar != null) {
                Cursor d2 = b2.d(new b.u.a.a("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"));
                try {
                    boolean z = false;
                    if (d2.moveToFirst() && d2.getInt(0) == 0) {
                        z = true;
                    }
                    d2.close();
                    iVar.f1647c.createAllTables(b2);
                    if (!z) {
                        i.b onValidateSchema = iVar.f1647c.onValidateSchema(b2);
                        if (!onValidateSchema.f1650a) {
                            StringBuilder g = c.a.a.a.a.g("Pre-packaged database has an invalid schema: ");
                            g.append(onValidateSchema.f1651b);
                            throw new IllegalStateException(g.toString());
                        }
                    }
                    iVar.c(b2);
                    iVar.f1647c.onCreate(b2);
                } catch (Throwable th) {
                    d2.close();
                    throw th;
                }
            } else {
                throw null;
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f1751d = true;
            ((i) this.f1750c).b(b(this.f1749b, sQLiteDatabase), i, i2);
        }

        /* JADX INFO: finally extract failed */
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f1751d) {
                c.a aVar = this.f1750c;
                a b2 = b(this.f1749b, sQLiteDatabase);
                i iVar = (i) aVar;
                if (iVar != null) {
                    Cursor d2 = b2.d(new b.u.a.a("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"));
                    try {
                        if (d2.moveToFirst() && d2.getInt(0) != 0) {
                            Cursor d3 = b2.d(new b.u.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                            try {
                                String string = d3.moveToFirst() ? d3.getString(0) : null;
                                d3.close();
                                if (!iVar.f1648d.equals(string) && !iVar.f1649e.equals(string)) {
                                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                                }
                            } catch (Throwable th) {
                                d3.close();
                                throw th;
                            }
                        } else {
                            i.b onValidateSchema = iVar.f1647c.onValidateSchema(b2);
                            if (onValidateSchema.f1650a) {
                                iVar.f1647c.onPostMigrate(b2);
                                iVar.c(b2);
                            } else {
                                StringBuilder g = c.a.a.a.a.g("Pre-packaged database has an invalid schema: ");
                                g.append(onValidateSchema.f1651b);
                                throw new IllegalStateException(g.toString());
                            }
                        }
                        iVar.f1647c.onOpen(b2);
                        iVar.f1646b = null;
                    } finally {
                        d2.close();
                    }
                } else {
                    throw null;
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f1751d = true;
            this.f1750c.b(b(this.f1749b, sQLiteDatabase), i, i2);
        }
    }

    public c(Context context, String str, c.a aVar, boolean z) {
        this.f1745b = context;
        this.f1746c = str;
        this.f1747d = aVar;
        this.f1748e = z;
    }

    public final a a() {
        a aVar;
        synchronized (this.f) {
            if (this.g == null) {
                a[] aVarArr = new a[1];
                if (this.f1746c == null || !this.f1748e) {
                    this.g = new a(this.f1745b, this.f1746c, aVarArr, this.f1747d);
                } else {
                    this.g = new a(this.f1745b, new File(this.f1745b.getNoBackupFilesDir(), this.f1746c).getAbsolutePath(), aVarArr, this.f1747d);
                }
                this.g.setWriteAheadLoggingEnabled(this.h);
            }
            aVar = this.g;
        }
        return aVar;
    }

    @Override // b.u.a.c
    public b c() {
        return a().d();
    }

    @Override // java.io.Closeable, b.u.a.c, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // b.u.a.c
    public String getDatabaseName() {
        return this.f1746c;
    }

    @Override // b.u.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.f) {
            if (this.g != null) {
                this.g.setWriteAheadLoggingEnabled(z);
            }
            this.h = z;
        }
    }
}
