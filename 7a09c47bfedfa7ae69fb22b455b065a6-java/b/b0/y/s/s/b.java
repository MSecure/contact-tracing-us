package b.b0.y.s.s;

import android.os.Handler;
import android.os.Looper;
import b.b0.y.s.i;
import java.util.concurrent.Executor;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final i f1334a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f1335b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Executor f1336c = new a();

    public class a implements Executor {
        public a() {
        }

        public void execute(Runnable runnable) {
            b.this.f1335b.post(runnable);
        }
    }

    public b(Executor executor) {
        this.f1334a = new i(executor);
    }
}
