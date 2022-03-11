package e.x.a.f;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Pair;
import e.v.h;
import e.x.a.b;
import e.x.a.c;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class c implements e.x.a.c {
    public final Context b;
    public final String c;

    /* renamed from: d */
    public final c.a f2109d;

    /* renamed from: e */
    public final boolean f2110e;

    /* renamed from: f */
    public final Object f2111f = new Object();

    /* renamed from: g */
    public a f2112g;

    /* renamed from: h */
    public boolean f2113h;

    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {
        public final a[] b;
        public final c.a c;

        /* renamed from: d */
        public boolean f2114d;

        /* renamed from: e.x.a.f.c$a$a */
        /* loaded from: classes.dex */
        public class C0066a implements DatabaseErrorHandler {
            public final /* synthetic */ c.a a;
            public final /* synthetic */ a[] b;

            public C0066a(c.a aVar, a[] aVarArr) {
                this.a = aVar;
                this.b = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                c.a aVar = this.a;
                a d2 = a.d(this.b, sQLiteDatabase);
                Objects.requireNonNull(aVar);
                d2.c();
                if (d2.b.isOpen()) {
                    List<Pair<String, String>> list = null;
                    try {
                        try {
                            list = d2.b.getAttachedDbs();
                        } catch (SQLiteException unused) {
                        }
                        try {
                            d2.b.close();
                        } catch (IOException unused2) {
                        }
                    } finally {
                        if (list != null) {
                            for (Pair<String, String> next : list) {
                                aVar.a((String) next.second);
                            }
                        } else {
                            aVar.a(d2.c());
                        }
                    }
                }
            }
        }

        public a(Context context, String str, a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.a, new C0066a(aVar, aVarArr));
            this.c = aVar;
            this.b = aVarArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
            if ((r1.b == r3) == false) goto L_0x000e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
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

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.b[0] = null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            c.a aVar = this.c;
            d(this.b, sQLiteDatabase);
            Objects.requireNonNull((h) aVar);
        }

        /* JADX WARN: Finally extract failed */
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            c.a aVar = this.c;
            a d2 = d(this.b, sQLiteDatabase);
            h hVar = (h) aVar;
            Objects.requireNonNull(hVar);
            Cursor d3 = d2.d(new e.x.a.a("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"));
            try {
                boolean z = false;
                if (d3.moveToFirst()) {
                    if (d3.getInt(0) == 0) {
                        z = true;
                    }
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

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f2114d = true;
            ((h) this.c).b(d(this.b, sQLiteDatabase), i2, i3);
        }

        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
        @Override // android.database.sqlite.SQLiteOpenHelper
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            boolean z;
            if (!this.f2114d) {
                c.a aVar = this.c;
                a d2 = d(this.b, sQLiteDatabase);
                h hVar = (h) aVar;
                Objects.requireNonNull(hVar);
                Cursor d3 = d2.d(new e.x.a.a("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"));
                try {
                    if (d3.moveToFirst()) {
                        if (d3.getInt(0) != 0) {
                            z = true;
                            d3.close();
                            if (!z) {
                                Cursor d4 = d2.d(new e.x.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                                try {
                                    String string = d4.moveToFirst() ? d4.getString(0) : null;
                                    d4.close();
                                    if (!hVar.f2079d.equals(string) && !hVar.f2080e.equals(string)) {
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
                        }
                    }
                    z = false;
                    d3.close();
                    if (!z) {
                    }
                    hVar.c.d(d2);
                    hVar.b = null;
                } catch (Throwable th2) {
                    d3.close();
                    throw th2;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f2114d = true;
            this.c.b(d(this.b, sQLiteDatabase), i2, i3);
        }

        public synchronized b t() {
            this.f2114d = false;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (this.f2114d) {
                close();
                return t();
            }
            return c(writableDatabase);
        }
    }

    public c(Context context, String str, c.a aVar, boolean z) {
        this.b = context;
        this.c = str;
        this.f2109d = aVar;
        this.f2110e = z;
    }

    @Override // e.x.a.c
    public b E() {
        return c().t();
    }

    public final a c() {
        a aVar;
        synchronized (this.f2111f) {
            if (this.f2112g == null) {
                a[] aVarArr = new a[1];
                if (Build.VERSION.SDK_INT < 23 || this.c == null || !this.f2110e) {
                    this.f2112g = new a(this.b, this.c, aVarArr, this.f2109d);
                } else {
                    this.f2112g = new a(this.b, new File(this.b.getNoBackupFilesDir(), this.c).getAbsolutePath(), aVarArr, this.f2109d);
                }
                this.f2112g.setWriteAheadLoggingEnabled(this.f2113h);
            }
            aVar = this.f2112g;
        }
        return aVar;
    }

    @Override // e.x.a.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c().close();
    }

    @Override // e.x.a.c
    public String getDatabaseName() {
        return this.c;
    }

    @Override // e.x.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.f2111f) {
            a aVar = this.f2112g;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z);
            }
            this.f2113h = z;
        }
    }
}
