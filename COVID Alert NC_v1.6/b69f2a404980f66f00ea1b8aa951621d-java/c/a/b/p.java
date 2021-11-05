package c.a.b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f2229a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public final Set<o<?>> f2230b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final PriorityBlockingQueue<o<?>> f2231c = new PriorityBlockingQueue<>();

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<o<?>> f2232d = new PriorityBlockingQueue<>();

    /* renamed from: e  reason: collision with root package name */
    public final b f2233e;
    public final i f;
    public final r g;
    public final j[] h;
    public d i;
    public final List<a> j = new ArrayList();

    public interface a<T> {
        void a(o<T> oVar);
    }

    public p(b bVar, i iVar) {
        g gVar = new g(new Handler(Looper.getMainLooper()));
        this.f2233e = bVar;
        this.f = iVar;
        this.h = new j[4];
        this.g = gVar;
    }

    public <T> o<T> a(o<T> oVar) {
        oVar.setRequestQueue(this);
        synchronized (this.f2230b) {
            this.f2230b.add(oVar);
        }
        oVar.setSequence(this.f2229a.incrementAndGet());
        oVar.addMarker("add-to-queue");
        (!oVar.shouldCache() ? this.f2232d : this.f2231c).add(oVar);
        return oVar;
    }

    public void b() {
        d dVar = this.i;
        if (dVar != null) {
            dVar.f = true;
            dVar.interrupt();
        }
        j[] jVarArr = this.h;
        for (j jVar : jVarArr) {
            if (jVar != null) {
                jVar.f = true;
                jVar.interrupt();
            }
        }
        d dVar2 = new d(this.f2231c, this.f2232d, this.f2233e, this.g);
        this.i = dVar2;
        dVar2.start();
        for (int i2 = 0; i2 < this.h.length; i2++) {
            j jVar2 = new j(this.f2232d, this.f, this.f2233e, this.g);
            this.h[i2] = jVar2;
            jVar2.start();
        }
    }
}
