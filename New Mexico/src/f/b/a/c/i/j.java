package f.b.a.c.i;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class j {
    public static final Executor a = new a();
    public static final Executor b = new b0();

    /* loaded from: classes.dex */
    public static final class a implements Executor {
        public final Handler b = new f.b.a.c.e.d.a(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.b.post(runnable);
        }
    }
}
