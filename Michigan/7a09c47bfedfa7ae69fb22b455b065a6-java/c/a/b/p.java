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
    public final AtomicInteger f2840a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public final Set<o<?>> f2841b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final PriorityBlockingQueue<o<?>> f2842c = new PriorityBlockingQueue<>();

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<o<?>> f2843d = new PriorityBlockingQueue<>();

    /* renamed from: e  reason: collision with root package name */
    public final b f2844e;

    /* renamed from: f  reason: collision with root package name */
    public final i f2845f;

    /* renamed from: g  reason: collision with root package name */
    public final r f2846g;
    public final j[] h;
    public d i;
    public final List<a> j = new ArrayList();

    public interface a<T> {
        void a(o<T> oVar);
    }

    public p(b bVar, i iVar) {
        g gVar = new g(new Handler(Looper.getMainLooper()));
        this.f2844e = bVar;
        this.f2845f = iVar;
        this.h = new j[4];
        this.f2846g = gVar;
    }

    public <T> o<T> a(o<T> oVar) {
        oVar.setRequestQueue(this);
        synchronized (this.f2841b) {
            this.f2841b.add(oVar);
        }
        oVar.setSequence(this.f2840a.incrementAndGet());
        oVar.addMarker("add-to-queue");
        (!oVar.shouldCache() ? this.f2843d : this.f2842c).add(oVar);
        return oVar;
    }

    public void b() {
        d dVar = this.i;
        if (dVar != null) {
            dVar.f2807f = true;
            dVar.interrupt();
        }
        j[] jVarArr = this.h;
        for (j jVar : jVarArr) {
            if (jVar != null) {
                jVar.f2826f = true;
                jVar.interrupt();
            }
        }
        d dVar2 = new d(this.f2842c, this.f2843d, this.f2844e, this.f2846g);
        this.i = dVar2;
        dVar2.start();
        for (int i2 = 0; i2 < this.h.length; i2++) {
            j jVar2 = new j(this.f2843d, this.f2845f, this.f2844e, this.f2846g);
            this.h[i2] = jVar2;
            jVar2.start();
        }
    }
}
