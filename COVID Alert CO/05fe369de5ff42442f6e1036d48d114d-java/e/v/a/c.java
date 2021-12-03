package e.v.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import java.io.File;

public interface c extends Closeable {

    public static abstract class a {
        public final int a;

        public a(int i2) {
            this.a = i2;
        }

        public final void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                try {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } catch (Exception unused) {
                }
            }
        }

        public abstract void b(b bVar, int i2, int i3);
    }

    public static class b {
        public final Context a;
        public final String b;
        public final a c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1748d;

        public b(Context context, String str, a aVar, boolean z) {
            this.a = context;
            this.b = str;
            this.c = aVar;
            this.f1748d = z;
        }
    }

    /* renamed from: e.v.a.c$c  reason: collision with other inner class name */
    public interface AbstractC0054c {
        c a(b bVar);
    }

    b E();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z);
}
