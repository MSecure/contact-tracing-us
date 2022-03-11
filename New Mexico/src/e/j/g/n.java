package e.j.g;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
public class n implements ThreadFactory {
    public String b;
    public int c;

    /* loaded from: classes.dex */
    public static class a extends Thread {
        public final int b;

        public a(Runnable runnable, String str, int i2) {
            super(runnable, str);
            this.b = i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(this.b);
            super.run();
        }
    }

    public n(String str, int i2) {
        this.b = str;
        this.c = i2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new a(runnable, this.b, this.c);
    }
}
