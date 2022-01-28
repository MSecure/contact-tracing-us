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
    public final PriorityBlockingQueue<n<?>> f2151d = new PriorityBlockingQueue<>();

    /* renamed from: e  reason: collision with root package name */
    public final b f2152e;

    /* renamed from: f  reason: collision with root package name */
    public final h f2153f;

    /* renamed from: g  reason: collision with root package name */
    public final q f2154g;

    /* renamed from: h  reason: collision with root package name */
    public final i[] f2155h;

    /* renamed from: i  reason: collision with root package name */
    public c f2156i;

    /* renamed from: j  reason: collision with root package name */
    public final List<a> f2157j = new ArrayList();

    public interface a<T> {
        void a(n<T> nVar);
    }

    public o(b bVar, h hVar) {
        f fVar = new f(new Handler(Looper.getMainLooper()));
        this.f2152e = bVar;
        this.f2153f = hVar;
        this.f2155h = new i[4];
        this.f2154g = fVar;
    }

    public <T> n<T> a(n<T> nVar) {
        nVar.f2143i = this;
        synchronized (this.b) {
            this.b.add(nVar);
        }
        nVar.f2142h = Integer.valueOf(this.a.incrementAndGet());
        nVar.a("add-to-queue");
        (!nVar.f2144j ? this.f2151d : this.c).add(nVar);
        return nVar;
    }

    public void b() {
        c cVar = this.f2156i;
        if (cVar != null) {
            cVar.f2130f = true;
            cVar.interrupt();
        }
        i[] iVarArr = this.f2155h;
        for (i iVar : iVarArr) {
            if (iVar != null) {
                iVar.f2135f = true;
                iVar.interrupt();
            }
        }
        c cVar2 = new c(this.c, this.f2151d, this.f2152e, this.f2154g);
        this.f2156i = cVar2;
        cVar2.start();
        for (int i2 = 0; i2 < this.f2155h.length; i2++) {
            i iVar2 = new i(this.f2151d, this.f2153f, this.f2152e, this.f2154g);
            this.f2155h[i2] = iVar2;
            iVar2.start();
        }
    }
}
