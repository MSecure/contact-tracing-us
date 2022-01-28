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
    public final PriorityBlockingQueue<n<?>> f2052d = new PriorityBlockingQueue<>();

    /* renamed from: e  reason: collision with root package name */
    public final b f2053e;

    /* renamed from: f  reason: collision with root package name */
    public final h f2054f;

    /* renamed from: g  reason: collision with root package name */
    public final q f2055g;

    /* renamed from: h  reason: collision with root package name */
    public final i[] f2056h;

    /* renamed from: i  reason: collision with root package name */
    public c f2057i;

    /* renamed from: j  reason: collision with root package name */
    public final List<a> f2058j = new ArrayList();

    public interface a<T> {
        void a(n<T> nVar);
    }

    public o(b bVar, h hVar) {
        f fVar = new f(new Handler(Looper.getMainLooper()));
        this.f2053e = bVar;
        this.f2054f = hVar;
        this.f2056h = new i[4];
        this.f2055g = fVar;
    }

    public <T> n<T> a(n<T> nVar) {
        nVar.f2044i = this;
        synchronized (this.b) {
            this.b.add(nVar);
        }
        nVar.f2043h = Integer.valueOf(this.a.incrementAndGet());
        nVar.a("add-to-queue");
        (!nVar.f2045j ? this.f2052d : this.c).add(nVar);
        return nVar;
    }

    public void b() {
        c cVar = this.f2057i;
        if (cVar != null) {
            cVar.f2031f = true;
            cVar.interrupt();
        }
        i[] iVarArr = this.f2056h;
        for (i iVar : iVarArr) {
            if (iVar != null) {
                iVar.f2036f = true;
                iVar.interrupt();
            }
        }
        c cVar2 = new c(this.c, this.f2052d, this.f2053e, this.f2055g);
        this.f2057i = cVar2;
        cVar2.start();
        for (int i2 = 0; i2 < this.f2056h.length; i2++) {
            i iVar2 = new i(this.f2052d, this.f2054f, this.f2053e, this.f2055g);
            this.f2056h[i2] = iVar2;
            iVar2.start();
        }
    }
}
