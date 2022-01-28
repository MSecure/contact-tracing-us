package e.b0;

public abstract class n {
    public static n a;

    public static class a extends n {
        public int b;

        public a(int i2) {
            this.b = i2;
        }

        @Override // e.b0.n
        public void a(String str, String str2, Throwable... thArr) {
            if (this.b <= 3 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // e.b0.n
        public void b(String str, String str2, Throwable... thArr) {
            if (this.b <= 6 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // e.b0.n
        public void d(String str, String str2, Throwable... thArr) {
            if (this.b <= 4 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // e.b0.n
        public void f(String str, String str2, Throwable... thArr) {
            if (this.b <= 5 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }
    }

    public static synchronized n c() {
        n nVar;
        synchronized (n.class) {
            if (a == null) {
                a = new a(3);
            }
            nVar = a;
        }
        return nVar;
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
