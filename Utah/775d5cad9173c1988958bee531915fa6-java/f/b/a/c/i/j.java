package f.b.a.c.i;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class j {
    public static final Executor a = new a();
    public static final Executor b = new b0();

    public static final class a implements Executor {
        public final Handler b = new f.b.a.c.e.d.a(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.b.post(runnable);
        }
    }
}
