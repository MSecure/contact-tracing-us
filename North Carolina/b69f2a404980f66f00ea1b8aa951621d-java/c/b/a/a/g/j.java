package c.b.a.a.g;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f2857a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f2858b = new z();

    public static final class a implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f2859b = new c.b.a.a.e.d.a(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f2859b.post(runnable);
        }
    }
}
