package e.z;

public abstract class l {
    public static l a;

    public static class a extends l {
        public int b;

        public a(int i2) {
            this.b = i2;
        }

        @Override // e.z.l
        public void a(String str, String str2, Throwable... thArr) {
            if (this.b <= 3 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // e.z.l
        public void b(String str, String str2, Throwable... thArr) {
            if (this.b <= 6 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // e.z.l
        public void d(String str, String str2, Throwable... thArr) {
            if (this.b <= 4 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // e.z.l
        public void f(String str, String str2, Throwable... thArr) {
            if (this.b <= 5 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }
    }

    public static synchronized l c() {
        l lVar;
        synchronized (l.class) {
            if (a == null) {
                a = new a(3);
            }
            lVar = a;
        }
        return lVar;
    }

    public static String e(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            str = str.substring(0, 20);
        }
        sb.append(str);
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void f(String str, String str2, Throwable... thArr);
}
