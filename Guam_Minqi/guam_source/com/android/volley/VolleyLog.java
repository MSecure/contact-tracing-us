package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VolleyLog {
    public static final String CLASS_NAME = VolleyLog.class.getName();
    public static boolean DEBUG = Log.isLoggable("Volley", 2);

    public static class MarkerLog {
        public static final boolean ENABLED = VolleyLog.DEBUG;
        public boolean mFinished = false;
        public final List<Marker> mMarkers = new ArrayList();

        public static class Marker {
            public final String name;
            public final long thread;
            public final long time;

            public Marker(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        public synchronized void add(String str, long j) {
            if (!this.mFinished) {
                this.mMarkers.add(new Marker(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() throws Throwable {
            if (!this.mFinished) {
                finish("Request on the loose");
                VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public synchronized void finish(String str) {
            long j;
            this.mFinished = true;
            if (this.mMarkers.size() == 0) {
                j = 0;
            } else {
                long j2 = this.mMarkers.get(0).time;
                List<Marker> list = this.mMarkers;
                j = list.get(list.size() - 1).time - j2;
            }
            if (j > 0) {
                long j3 = this.mMarkers.get(0).time;
                VolleyLog.buildMessage("(%-4d ms) %s", Long.valueOf(j), str);
                for (Marker marker : this.mMarkers) {
                    long j4 = marker.time;
                    VolleyLog.buildMessage("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(marker.thread), marker.name);
                    j3 = j4;
                }
            }
        }
    }

    public static String buildMessage(String str, Object... objArr) {
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
            } else if (!stackTrace[i].getClassName().equals(CLASS_NAME)) {
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

    public static void e(String str, Object... objArr) {
        Log.e("Volley", buildMessage(str, objArr));
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            buildMessage(str, objArr);
        }
    }
}
