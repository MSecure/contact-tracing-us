package b.z.y.s.s;

import android.os.Handler;
import android.os.Looper;
import b.z.y.s.i;
import java.util.concurrent.Executor;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final i f2183a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f2184b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Executor f2185c = new a();

    public class a implements Executor {
        public a() {
        }

        public void execute(Runnable runnable) {
            b.this.f2184b.post(runnable);
        }
    }

    public b(Executor executor) {
        this.f2183a = new i(executor);
    }
}
