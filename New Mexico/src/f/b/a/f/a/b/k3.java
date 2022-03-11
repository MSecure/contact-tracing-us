package f.b.a.f.a.b;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
public final /* synthetic */ class k3 implements ThreadFactory {
    public static final /* synthetic */ k3 b = new k3();

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
