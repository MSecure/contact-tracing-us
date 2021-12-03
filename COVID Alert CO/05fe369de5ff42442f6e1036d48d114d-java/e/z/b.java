package e.z;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {
    public final Executor a = a();
    public final Executor b = a();
    public final w c;

    /* renamed from: d  reason: collision with root package name */
    public final k f1855d;

    /* renamed from: e  reason: collision with root package name */
    public final e.z.x.a f1856e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1857f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1858g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1859h;

    public static final class a {
        public w a;
    }

    /* renamed from: e.z.b$b  reason: collision with other inner class name */
    public interface AbstractC0062b {
        b a();
    }

    public b(a aVar) {
        w wVar = aVar.a;
        if (wVar == null) {
            String str = w.a;
            wVar = new v();
        }
        this.c = wVar;
        this.f1855d = new j();
        this.f1856e = new e.z.x.a();
        this.f1857f = 4;
        this.f1858g = Integer.MAX_VALUE;
        this.f1859h = 20;
    }

    public final Executor a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
