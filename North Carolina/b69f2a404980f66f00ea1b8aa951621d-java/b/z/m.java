package b.z;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public static m f1923a;

    public static class a extends m {

        /* renamed from: b  reason: collision with root package name */
        public int f1924b;

        public a(int i) {
            this.f1924b = i;
        }

        @Override // b.z.m
        public void a(String str, String str2, Throwable... thArr) {
            if (this.f1924b <= 3 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // b.z.m
        public void b(String str, String str2, Throwable... thArr) {
            if (this.f1924b <= 6 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // b.z.m
        public void d(String str, String str2, Throwable... thArr) {
            if (this.f1924b <= 4 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // b.z.m
        public void f(String str, String str2, Throwable... thArr) {
            if (this.f1924b <= 5 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }
    }

    public static synchronized m c() {
        m mVar;
        synchronized (m.class) {
            if (f1923a == null) {
                f1923a = new a(3);
            }
            mVar = f1923a;
        }
        return mVar;
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
