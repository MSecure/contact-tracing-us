package b.b0;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public static m f1039a;

    public static class a extends m {

        /* renamed from: b  reason: collision with root package name */
        public int f1040b;

        public a(int i) {
            this.f1040b = i;
        }

        @Override // b.b0.m
        public void a(String str, String str2, Throwable... thArr) {
            if (this.f1040b <= 3 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // b.b0.m
        public void b(String str, String str2, Throwable... thArr) {
            if (this.f1040b <= 6 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // b.b0.m
        public void d(String str, String str2, Throwable... thArr) {
            if (this.f1040b <= 4 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // b.b0.m
        public void f(String str, String str2, Throwable... thArr) {
            if (this.f1040b <= 5 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }
    }

    public static synchronized m c() {
        m mVar;
        synchronized (m.class) {
            if (f1039a == null) {
                f1039a = new a(3);
            }
            mVar = f1039a;
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
