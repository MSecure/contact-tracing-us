package e.b0.x.q;

import android.content.Context;
import e.b0.l;
import e.b0.x.q.e.b;
import e.b0.x.q.e.c;
import e.b0.x.q.e.e;
import e.b0.x.q.e.f;
import e.b0.x.q.e.g;
import e.b0.x.q.e.h;
import e.b0.x.s.o;
import e.b0.x.t.q.a;
import h.a.j1.z0;

public class d implements c.a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f1085d = l.e("WorkConstraintsTracker");
    public final c a;
    public final c<?>[] b;
    public final Object c = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = cVar;
        this.b = new c[]{new e.b0.x.q.e.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new e.b0.x.q.e.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    public boolean a(String str) {
        synchronized (this.c) {
            c<?>[] cVarArr = this.b;
            for (c<?> cVar : cVarArr) {
                z0.a aVar = (T) cVar.b;
                if (aVar != null && cVar.c(aVar) && cVar.a.contains(str)) {
                    l.c().a(f1085d, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
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
                if (cVar.f1086d != null) {
                    cVar.f1086d = null;
                    cVar.e(null, (T) cVar.b);
                }
            }
            for (c<?> cVar2 : this.b) {
                cVar2.d(iterable);
            }
            c<?>[] cVarArr2 = this.b;
            for (c<?> cVar3 : cVarArr2) {
                if (cVar3.f1086d != this) {
                    cVar3.f1086d = this;
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
