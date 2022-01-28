package e.b0;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class c {
    public final Executor a = a(false);
    public final Executor b = a(true);
    public final z c;

    /* renamed from: d  reason: collision with root package name */
    public final m f1156d;

    /* renamed from: e  reason: collision with root package name */
    public final e.b0.a0.a f1157e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1158f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1159g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1160h;

    public static final class a {
        public z a;
    }

    public interface b {
        c a();
    }

    public c(a aVar) {
        z zVar = aVar.a;
        if (zVar == null) {
            String str = z.a;
            zVar = new y();
        }
        this.c = zVar;
        this.f1156d = new l();
        this.f1157e = new e.b0.a0.a();
        this.f1158f = 4;
        this.f1159g = Integer.MAX_VALUE;
        this.f1160h = 20;
    }

    public final Executor a(boolean z) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new b(this, z));
    }
}
