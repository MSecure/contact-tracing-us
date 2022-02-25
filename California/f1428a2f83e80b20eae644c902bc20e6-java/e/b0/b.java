package e.b0;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {
    public final Executor a = a();
    public final Executor b = a();
    public final w c;

    /* renamed from: d  reason: collision with root package name */
    public final k f981d;

    /* renamed from: e  reason: collision with root package name */
    public final e.b0.x.a f982e;

    /* renamed from: f  reason: collision with root package name */
    public final int f983f;

    /* renamed from: g  reason: collision with root package name */
    public final int f984g;

    /* renamed from: h  reason: collision with root package name */
    public final int f985h;

    public static final class a {
        public w a;
    }

    /* renamed from: e.b0.b$b  reason: collision with other inner class name */
    public interface AbstractC0018b {
        b a();
    }

    public b(a aVar) {
        w wVar = aVar.a;
        if (wVar == null) {
            String str = w.a;
            wVar = new v();
        }
        this.c = wVar;
        this.f981d = new j();
        this.f982e = new e.b0.x.a();
        this.f983f = 4;
        this.f984g = Integer.MAX_VALUE;
        this.f985h = 20;
    }

    public final Executor a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
