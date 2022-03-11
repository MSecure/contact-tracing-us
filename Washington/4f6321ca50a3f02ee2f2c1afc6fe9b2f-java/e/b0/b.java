package e.b0;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {
    public final Executor a = a();
    public final Executor b = a();
    public final w c;

    /* renamed from: d  reason: collision with root package name */
    public final k f980d;

    /* renamed from: e  reason: collision with root package name */
    public final e.b0.x.a f981e;

    /* renamed from: f  reason: collision with root package name */
    public final int f982f;

    /* renamed from: g  reason: collision with root package name */
    public final int f983g;

    /* renamed from: h  reason: collision with root package name */
    public final int f984h;

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
        this.f980d = new j();
        this.f981e = new e.b0.x.a();
        this.f982f = 4;
        this.f983g = Integer.MAX_VALUE;
        this.f984h = 20;
    }

    public final Executor a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
