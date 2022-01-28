package b.w.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import java.io.File;

public interface c extends Closeable {

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f2610a;

        public a(int i) {
            this.f2610a = i;
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
        public final Context f2611a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2612b;

        /* renamed from: c  reason: collision with root package name */
        public final a f2613c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f2614d;

        public b(Context context, String str, a aVar, boolean z) {
            this.f2611a = context;
            this.f2612b = str;
            this.f2613c = aVar;
            this.f2614d = z;
        }
    }

    /* renamed from: b.w.a.c$c  reason: collision with other inner class name */
    public interface AbstractC0052c {
        c a(b bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    b p();

    void setWriteAheadLoggingEnabled(boolean z);
}
