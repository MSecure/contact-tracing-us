package c.b.a.a.j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f4110a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f4111b = new a0();

    public static final class a implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f4112b = new c.b.a.a.g.g.a(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f4112b.post(runnable);
        }
    }
}
