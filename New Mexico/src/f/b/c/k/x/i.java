package f.b.c.k.x;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Executor {
    public static final i b = new i();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
