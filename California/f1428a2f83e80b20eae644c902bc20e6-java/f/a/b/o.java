package f.a.b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class o {
    public final AtomicInteger a = new AtomicInteger();
    public final Set<n<?>> b = new HashSet();
    public final PriorityBlockingQueue<n<?>> c = new PriorityBlockingQueue<>();

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<n<?>> f2046d = new PriorityBlockingQueue<>();

    /* renamed from: e  reason: collision with root package name */
    public final b f2047e;

    /* renamed from: f  reason: collision with root package name */
    public final h f2048f;

    /* renamed from: g  reason: collision with root package name */
    public final q f2049g;

    /* renamed from: h  reason: collision with root package name */
    public final i[] f2050h;

    /* renamed from: i  reason: collision with root package name */
    public c f2051i;

    /* renamed from: j  reason: collision with root package name */
    public final List<a> f2052j = new ArrayList();

    public interface a<T> {
        void a(n<T> nVar);
    }

    public o(b bVar, h hVar) {
        f fVar = new f(new Handler(Looper.getMainLooper()));
        this.f2047e = bVar;
        this.f2048f = hVar;
        this.f2050h = new i[4];
        this.f2049g = fVar;
    }
}
