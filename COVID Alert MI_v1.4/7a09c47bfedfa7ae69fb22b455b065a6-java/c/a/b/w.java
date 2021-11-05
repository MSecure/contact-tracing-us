package c.a.b;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2852a = Log.isLoggable("Volley", 2);

    /* renamed from: b  reason: collision with root package name */
    public static final String f2853b = w.class.getName();

    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final boolean f2854c = w.f2852a;

        /* renamed from: a  reason: collision with root package name */
        public final List<C0060a> f2855a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f2856b = false;

        /* renamed from: c.a.b.w$a$a  reason: collision with other inner class name */
        public static class C0060a {

            /* renamed from: a  reason: collision with root package name */
            public final String f2857a;

            /* renamed from: b  reason: collision with root package name */
            public final long f2858b;

            /* renamed from: c  reason: collision with root package name */
            public final long f2859c;

            public C0060a(String str, long j, long j2) {
                this.f2857a = str;
                this.f2858b = j;
                this.f2859c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (!this.f2856b) {
                this.f2855a.add(new C0060a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void b(String str) {
            long j;
            this.f2856b = true;
            if (this.f2855a.size() == 0) {
                j = 0;
            } else {
                long j2 = this.f2855a.get(0).f2859c;
                List<C0060a> list = this.f2855a;
                j = list.get(list.size() - 1).f2859c - j2;
            }
            if (j > 0) {
                long j3 = this.f2855a.get(0).f2859c;
                w.a("(%-4d ms) %s", Long.valueOf(j), str);
                for (C0060a aVar : this.f2855a) {
                    long j4 = aVar.f2859c;
                    w.a("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(aVar.f2858b), aVar.f2857a);
                    j3 = j4;
                }
            }
        }

        public void finalize() {
            if (!this.f2856b) {
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
            } else if (!stackTrace[i].getClassName().equals(f2853b)) {
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
        if (f2852a) {
            a(str, objArr);
        }
    }
}
