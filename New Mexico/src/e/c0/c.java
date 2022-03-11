package e.c0;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class c {
    public final Executor a = a(false);
    public final Executor b = a(true);
    public final z c;

    /* renamed from: d */
    public final m f1235d;

    /* renamed from: e */
    public final e.c0.a0.a f1236e;

    /* renamed from: f */
    public final int f1237f;

    /* renamed from: g */
    public final int f1238g;

    /* renamed from: h */
    public final int f1239h;

    /* loaded from: classes.dex */
    public static final class a {
        public z a;
    }

    /* loaded from: classes.dex */
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
        this.f1235d = new l();
        this.f1236e = new e.c0.a0.a();
        this.f1237f = 4;
        this.f1238g = Integer.MAX_VALUE;
        this.f1239h = 20;
    }

    public final Executor a(boolean z) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new b(this, z));
    }
}
