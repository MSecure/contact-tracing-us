package com.bugfender.sdk.a.c.i;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    private AbstractC0019a a;

    /* renamed from: com.bugfender.sdk.a.c.i.a$a  reason: collision with other inner class name */
    public interface AbstractC0019a {
        long a();

        long b();

        long c();
    }

    public static abstract class b implements AbstractC0019a {
        protected final ActivityManager a;
        protected long b;
        protected long c;
        protected Context d;

        public b(Context context) {
            this.a = (ActivityManager) context.getSystemService("activity");
            this.d = context;
        }

        @Override // com.bugfender.sdk.a.c.i.a.AbstractC0019a
        public long a() {
            return this.b;
        }

        @Override // com.bugfender.sdk.a.c.i.a.AbstractC0019a
        public long b() {
            return this.c;
        }

        /* access modifiers changed from: protected */
        public Double d() {
            new DecimalFormat("#.##");
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                Matcher matcher = Pattern.compile("(\\d+)").matcher(randomAccessFile.readLine());
                String str = "";
                while (matcher.find()) {
                    str = matcher.group(1);
                }
                randomAccessFile.close();
                return Double.valueOf(Double.parseDouble(str));
            } catch (Exception unused) {
                return Double.valueOf(-1.0d);
            }
        }
    }

    public static class c extends b {
        public c(Context context) {
            super(context);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) this.d.getSystemService("activity")).getMemoryInfo(memoryInfo);
            this.c = memoryInfo.availMem;
            this.b = memoryInfo.totalMem;
        }

        @Override // com.bugfender.sdk.a.c.i.a.AbstractC0019a, com.bugfender.sdk.a.c.i.a.b
        public long a() {
            return this.b - this.c;
        }

        @Override // com.bugfender.sdk.a.c.i.a.AbstractC0019a
        public long c() {
            return this.b;
        }
    }

    public static class d extends b {
        public d(Context context) {
            super(context);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.a.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses == null ? Collections.emptyList() : runningAppProcesses) {
                if (runningAppProcessInfo.uid > 1000) {
                    this.b += (long) this.a.getProcessMemoryInfo(new int[]{runningAppProcessInfo.pid})[0].getTotalPss();
                }
            }
        }

        @Override // com.bugfender.sdk.a.c.i.a.AbstractC0019a, com.bugfender.sdk.a.c.i.a.b
        public long a() {
            return this.b;
        }

        @Override // com.bugfender.sdk.a.c.i.a.AbstractC0019a
        public long c() {
            return Math.round(d().doubleValue());
        }
    }

    public a(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.a = new c(context);
        } else {
            this.a = new d(context);
        }
    }

    public long a() {
        return this.a.b();
    }

    public long b() {
        return this.a.c();
    }

    public long c() {
        return this.a.a();
    }
}
