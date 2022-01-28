package b.u.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import java.io.File;

public interface c extends Closeable {

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f1736a;

        public a(int i) {
            this.f1736a = i;
        }

        public final void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                try {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } catch (Exception unused) {
                }
            }
        }

        public abstract void b(b bVar, int i, int i2);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1737a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1738b;

        /* renamed from: c  reason: collision with root package name */
        public final a f1739c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1740d;

        public b(Context context, String str, a aVar, boolean z) {
            this.f1737a = context;
            this.f1738b = str;
            this.f1739c = aVar;
            this.f1740d = z;
        }
    }

    /* renamed from: b.u.a.c$c  reason: collision with other inner class name */
    public interface AbstractC0042c {
        c a(b bVar);
    }

    b c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z);
}
