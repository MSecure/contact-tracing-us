package b.z;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1889a = a();

    /* renamed from: b  reason: collision with root package name */
    public final Executor f1890b = a();

    /* renamed from: c  reason: collision with root package name */
    public final x f1891c = x.b();

    /* renamed from: d  reason: collision with root package name */
    public final l f1892d = new k();

    /* renamed from: e  reason: collision with root package name */
    public final b.z.y.a f1893e = new b.z.y.a();
    public final i f;
    public final String g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1894a = 4;

        /* renamed from: b  reason: collision with root package name */
        public int f1895b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f1896c = Integer.MAX_VALUE;

        /* renamed from: d  reason: collision with root package name */
        public int f1897d = 20;
    }

    /* renamed from: b.z.b$b  reason: collision with other inner class name */
    public interface AbstractC0050b {
        b a();
    }

    public b(a aVar) {
        this.h = aVar.f1894a;
        this.i = aVar.f1895b;
        this.j = aVar.f1896c;
        this.k = aVar.f1897d;
        this.f = null;
        this.g = null;
    }

    public final Executor a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
