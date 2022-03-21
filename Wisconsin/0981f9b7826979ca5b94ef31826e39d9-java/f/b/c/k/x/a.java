package f.b.c.k.x;

import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {
    public final Runnable a;

    public a(Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        this.a.run();
        return null;
    }
}
