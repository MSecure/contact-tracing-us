package com.bugfender.sdk.a.a.h;

import com.bugfender.sdk.LogLevel;
import java.util.Date;

public class g {
    private int a;
    private int b;
    private long c;
    private Date d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    /* access modifiers changed from: package-private */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[LogLevel.values().length];
            a = iArr;
            iArr[LogLevel.Debug.ordinal()] = 1;
            a[LogLevel.Warning.ordinal()] = 2;
            a[LogLevel.Error.ordinal()] = 3;
            a[LogLevel.Trace.ordinal()] = 4;
            a[LogLevel.Info.ordinal()] = 5;
            try {
                a[LogLevel.Fatal.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class b {
        private int a;
        private int b;
        private long c;
        private Date d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;

        public b a(int i2) {
            this.b = i2;
            return this;
        }

        public b b(int i2) {
            this.a = i2;
            return this;
        }

        public b c(String str) {
            this.e = str;
            return this;
        }

        public b d(String str) {
            this.h = str;
            return this;
        }

        public b e(String str) {
            this.j = str;
            return this;
        }

        public b f(String str) {
            this.i = str;
            return this;
        }

        public b a(long j2) {
            this.c = j2;
            return this;
        }

        public b b(String str) {
            this.f = str;
            return this;
        }

        public b a(Date date) {
            this.d = date;
            return this;
        }

        public b a(String str) {
            this.g = str;
            return this;
        }

        public g a() {
            return new g(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }
    }

    public enum c {
        D(0),
        c(1),
        d(2),
        e(3),
        I(4),
        F(5);
        
        private final int a;

        private c(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }

        public static c a(LogLevel logLevel) {
            switch (a.a[logLevel.ordinal()]) {
                case 1:
                    return D;
                case 2:
                    return c;
                case 3:
                    return d;
                case 4:
                    return e;
                case 5:
                    return I;
                case 6:
                    return F;
                default:
                    return D;
            }
        }
    }

    /* synthetic */ g(int i2, int i3, long j2, Date date, String str, String str2, String str3, String str4, String str5, String str6, a aVar) {
        this(i2, i3, j2, date, str, str2, str3, str4, str5, str6);
    }

    public long a() {
        return this.c;
    }

    public Date b() {
        return this.d;
    }

    public String c() {
        return this.g;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.a;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.e;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.j;
    }

    public String j() {
        return this.i;
    }

    private g(int i2, int i3, long j2, Date date, String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = i2;
        this.b = i3;
        this.c = j2;
        this.d = date;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = str6;
    }
}
