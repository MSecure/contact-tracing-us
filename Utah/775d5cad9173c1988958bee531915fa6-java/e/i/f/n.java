package e.i.f;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class n implements ThreadFactory {
    public String b;
    public int c;

    public static class a extends Thread {
        public final int b;

        public a(Runnable runnable, String str, int i2) {
            super(runnable, str);
            this.b = i2;
        }

        public void run() {
            Process.setThreadPriority(this.b);
            super.run();
        }
    }

    public n(String str, int i2) {
        this.b = str;
        this.c = i2;
    }

    public Thread newThread(Runnable runnable) {
        return new a(runnable, this.b, this.c);
    }
}
