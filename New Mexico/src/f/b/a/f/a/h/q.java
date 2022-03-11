package f.b.a.f.a.h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class q implements Executor {
    public final Handler b = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.b.post(runnable);
    }
}
