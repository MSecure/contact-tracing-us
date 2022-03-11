package e.c0;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {
    public final Executor a = a();
    public final Executor b = a();
    public final w c;

    /* renamed from: d  reason: collision with root package name */
    public final k f1000d;

    /* renamed from: e  reason: collision with root package name */
    public final e.c0.x.a f1001e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1002f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1003g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1004h;

    public static final class a {
        public w a;
    }

    /* renamed from: e.c0.b$b  reason: collision with other inner class name */
    public interface AbstractC0023b {
        b a();
    }

    public b(a aVar) {
        w wVar = aVar.a;
        if (wVar == null) {
            String str = w.a;
            wVar = new v();
        }
        this.c = wVar;
        this.f1000d = new j();
        this.f1001e = new e.c0.x.a();
        this.f1002f = 4;
        this.f1003g = Integer.MAX_VALUE;
        this.f1004h = 20;
    }

    public final Executor a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
