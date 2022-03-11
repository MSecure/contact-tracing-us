package f.a.b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class o {

    /* renamed from: e */
    public final b f2179e;

    /* renamed from: f */
    public final h f2180f;

    /* renamed from: g */
    public final q f2181g;

    /* renamed from: i */
    public c f2183i;
    public final AtomicInteger a = new AtomicInteger();
    public final Set<n<?>> b = new HashSet();
    public final PriorityBlockingQueue<n<?>> c = new PriorityBlockingQueue<>();

    /* renamed from: d */
    public final PriorityBlockingQueue<n<?>> f2178d = new PriorityBlockingQueue<>();

    /* renamed from: j */
    public final List<a> f2184j = new ArrayList();

    /* renamed from: h */
    public final i[] f2182h = new i[4];

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(n<T> nVar);
    }

    public o(b bVar, h hVar) {
        f fVar = new f(new Handler(Looper.getMainLooper()));
        this.f2179e = bVar;
        this.f2180f = hVar;
        this.f2181g = fVar;
    }

    public <T> n<T> a(n<T> nVar) {
        nVar.f2170i = this;
        synchronized (this.b) {
            this.b.add(nVar);
        }
        nVar.f2169h = Integer.valueOf(this.a.incrementAndGet());
        nVar.a("add-to-queue");
        (!nVar.f2171j ? this.f2178d : this.c).add(nVar);
        return nVar;
    }

    public void b() {
        c cVar = this.f2183i;
        if (cVar != null) {
            cVar.f2157f = true;
            cVar.interrupt();
        }
        i[] iVarArr = this.f2182h;
        for (i iVar : iVarArr) {
            if (iVar != null) {
                iVar.f2162f = true;
                iVar.interrupt();
            }
        }
        c cVar2 = new c(this.c, this.f2178d, this.f2179e, this.f2181g);
        this.f2183i = cVar2;
        cVar2.start();
        for (int i2 = 0; i2 < this.f2182h.length; i2++) {
            i iVar2 = new i(this.f2178d, this.f2180f, this.f2179e, this.f2181g);
            this.f2182h[i2] = iVar2;
            iVar2.start();
        }
    }
}
