package b.b0;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f997a = a();

    /* renamed from: b  reason: collision with root package name */
    public final Executor f998b = a();

    /* renamed from: c  reason: collision with root package name */
    public final x f999c;

    /* renamed from: d  reason: collision with root package name */
    public final l f1000d;

    /* renamed from: e  reason: collision with root package name */
    public final b.b0.y.a f1001e;

    /* renamed from: f  reason: collision with root package name */
    public final i f1002f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1003g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public x f1004a;

        /* renamed from: b  reason: collision with root package name */
        public int f1005b = 4;

        /* renamed from: c  reason: collision with root package name */
        public int f1006c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f1007d = Integer.MAX_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public int f1008e = 20;
    }

    /* renamed from: b.b0.b$b  reason: collision with other inner class name */
    public interface AbstractC0016b {
        b getWorkManagerConfiguration();
    }

    public b(a aVar) {
        x xVar = aVar.f1004a;
        this.f999c = xVar == null ? x.c() : xVar;
        this.f1000d = new k();
        this.f1001e = new b.b0.y.a();
        this.h = aVar.f1005b;
        this.i = aVar.f1006c;
        this.j = aVar.f1007d;
        this.k = aVar.f1008e;
        this.f1002f = null;
        this.f1003g = null;
    }

    public final Executor a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
