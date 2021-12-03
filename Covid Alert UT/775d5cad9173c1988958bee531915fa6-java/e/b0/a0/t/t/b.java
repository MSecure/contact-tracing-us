package e.b0.a0.t.t;

import android.os.Handler;
import android.os.Looper;
import e.b0.a0.t.j;
import java.util.concurrent.Executor;

public class b implements a {
    public final j a;
    public final Handler b = new Handler(Looper.getMainLooper());
    public final Executor c = new a();

    public class a implements Executor {
        public a() {
        }

        public void execute(Runnable runnable) {
            b.this.b.post(runnable);
        }
    }

    public b(Executor executor) {
        this.a = new j(executor);
    }
}
