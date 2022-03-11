package f.a.b;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class v {
    public static boolean a = Log.isLoggable("Volley", 2);
    public static final String b = v.class.getName();

    public static class a {
        public static final boolean c = v.a;
        public final List<C0064a> a = new ArrayList();
        public boolean b = false;

        /* renamed from: f.a.b.v$a$a  reason: collision with other inner class name */
        public static class C0064a {
            public final String a;
            public final long b;
            public final long c;

            public C0064a(String str, long j2, long j3) {
                this.a = str;
                this.b = j2;
                this.c = j3;
            }
        }

        public synchronized void a(String str, long j2) {
            if (!this.b) {
                this.a.add(new C0064a(str, j2, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void b(String str) {
            long j2;
            this.b = true;
            if (this.a.size() == 0) {
                j2 = 0;
            } else {
                long j3 = this.a.get(0).c;
                List<C0064a> list = this.a;
                j2 = list.get(list.size() - 1).c - j3;
            }
            if (j2 > 0) {
                long j4 = this.a.get(0).c;
                v.a("(%-4d ms) %s", Long.valueOf(j2), str);
                for (C0064a aVar : this.a) {
                    long j5 = aVar.c;
                    v.a("(+%-4d) [%2d] %s", Long.valueOf(j5 - j4), Long.valueOf(aVar.b), aVar.a);
                    j4 = j5;
                }
            }
        }

        public void finalize() {
            if (!this.b) {
                b("Request on the loose");
                v.b("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i2].getClassName().equals(b)) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                StringBuilder i3 = f.a.a.a.a.i(substring.substring(substring.lastIndexOf(36) + 1), ".");
                i3.append(stackTrace[i2].getMethodName());
                str2 = i3.toString();
                break;
            } else {
                i2++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        Log.e("Volley", a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        if (a) {
            a(str, objArr);
        }
    }
}
