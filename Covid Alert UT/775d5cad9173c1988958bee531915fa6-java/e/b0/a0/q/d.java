package e.b0.a0.q;

import android.content.Context;
import e.b0.a0.q.e.b;
import e.b0.a0.q.e.c;
import e.b0.a0.q.e.e;
import e.b0.a0.q.e.f;
import e.b0.a0.q.e.g;
import e.b0.a0.q.e.h;
import e.b0.a0.s.o;
import e.b0.a0.t.t.a;
import e.b0.n;
import h.a.j1.z0;

public class d implements c.a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f1083d = n.e("WorkConstraintsTracker");
    public final c a;
    public final c<?>[] b;
    public final Object c = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = cVar;
        this.b = new c[]{new e.b0.a0.q.e.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new e.b0.a0.q.e.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    public boolean a(String str) {
        synchronized (this.c) {
            c<?>[] cVarArr = this.b;
            for (c<?> cVar : cVarArr) {
                z0.c cVar2 = (T) cVar.b;
                if (cVar2 != null && cVar.c(cVar2) && cVar.a.contains(str)) {
                    n.c().a(f1083d, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void b(Iterable<o> iterable) {
        synchronized (this.c) {
            c<?>[] cVarArr = this.b;
            for (c<?> cVar : cVarArr) {
                if (cVar.f1084d != null) {
                    cVar.f1084d = null;
                    cVar.e(null, (T) cVar.b);
                }
            }
            for (c<?> cVar2 : this.b) {
                cVar2.d(iterable);
            }
            c<?>[] cVarArr2 = this.b;
            for (c<?> cVar3 : cVarArr2) {
                if (cVar3.f1084d != this) {
                    cVar3.f1084d = this;
                    cVar3.e(this, (T) cVar3.b);
                }
            }
        }
    }

    public void c() {
        synchronized (this.c) {
            c<?>[] cVarArr = this.b;
            for (c<?> cVar : cVarArr) {
                if (!cVar.a.isEmpty()) {
                    cVar.a.clear();
                    cVar.c.b(cVar);
                }
            }
        }
    }
}
