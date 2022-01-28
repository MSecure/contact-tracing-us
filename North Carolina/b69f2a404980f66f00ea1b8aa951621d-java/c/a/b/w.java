package c.a.b;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2239a = Log.isLoggable("Volley", 2);

    /* renamed from: b  reason: collision with root package name */
    public static final String f2240b = w.class.getName();

    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final boolean f2241c = w.f2239a;

        /* renamed from: a  reason: collision with root package name */
        public final List<C0054a> f2242a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f2243b = false;

        /* renamed from: c.a.b.w$a$a  reason: collision with other inner class name */
        public static class C0054a {

            /* renamed from: a  reason: collision with root package name */
            public final String f2244a;

            /* renamed from: b  reason: collision with root package name */
            public final long f2245b;

            /* renamed from: c  reason: collision with root package name */
            public final long f2246c;

            public C0054a(String str, long j, long j2) {
                this.f2244a = str;
                this.f2245b = j;
                this.f2246c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (!this.f2243b) {
                this.f2242a.add(new C0054a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void b(String str) {
            long j;
            this.f2243b = true;
            if (this.f2242a.size() == 0) {
                j = 0;
            } else {
                long j2 = this.f2242a.get(0).f2246c;
                List<C0054a> list = this.f2242a;
                j = list.get(list.size() - 1).f2246c - j2;
            }
            if (j > 0) {
                long j3 = this.f2242a.get(0).f2246c;
                w.a("(%-4d ms) %s", Long.valueOf(j), str);
                for (C0054a aVar : this.f2242a) {
                    long j4 = aVar.f2246c;
                    w.a("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(aVar.f2245b), aVar.f2244a);
                    j3 = j4;
                }
            }
        }

        public void finalize() {
            if (!this.f2243b) {
                b("Request on the loose");
                w.a("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(f2240b)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        if (f2239a) {
            a(str, objArr);
        }
    }
}
