package e.b0.x.t.q;

import android.os.Handler;
import android.os.Looper;
import e.b0.x.t.i;
import java.util.concurrent.Executor;

public class b implements a {
    public final i a;
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
        this.a = new i(executor);
    }
}
