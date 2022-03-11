package e.c0.x.q;

import android.content.Context;
import e.c0.c;
import e.c0.l;
import e.c0.x.q.e.b;
import e.c0.x.q.e.c;
import e.c0.x.q.e.e;
import e.c0.x.q.e.f;
import e.c0.x.q.e.g;
import e.c0.x.q.e.h;
import e.c0.x.s.o;
import e.c0.x.t.q.a;

public class d implements c.a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f1104d = l.e("WorkConstraintsTracker");
    public final c a;
    public final c<?>[] b;
    public final Object c = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = cVar;
        this.b = new c[]{new e.c0.x.q.e.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new e.c0.x.q.e.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    public boolean a(String str) {
        synchronized (this.c) {
            c<?>[] cVarArr = this.b;
            for (c<?> cVar : cVarArr) {
                c.a aVar = (T) cVar.b;
                if (aVar != null && cVar.c(aVar) && cVar.a.contains(str)) {
                    l.c().a(f1104d, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void b(Iterable<o> iterable) {
        synchronized (this.c) {
            e.c0.x.q.e.c<?>[] cVarArr = this.b;
            for (e.c0.x.q.e.c<?> cVar : cVarArr) {
                if (cVar.f1105d != null) {
                    cVar.f1105d = null;
                    cVar.e(null, (T) cVar.b);
                }
            }
            for (e.c0.x.q.e.c<?> cVar2 : this.b) {
                cVar2.d(iterable);
            }
            e.c0.x.q.e.c<?>[] cVarArr2 = this.b;
            for (e.c0.x.q.e.c<?> cVar3 : cVarArr2) {
                if (cVar3.f1105d != this) {
                    cVar3.f1105d = this;
                    cVar3.e(this, (T) cVar3.b);
                }
            }
        }
    }

    public void c() {
        synchronized (this.c) {
            e.c0.x.q.e.c<?>[] cVarArr = this.b;
            for (e.c0.x.q.e.c<?> cVar : cVarArr) {
                if (!cVar.a.isEmpty()) {
                    cVar.a.clear();
                    cVar.c.b(cVar);
                }
            }
        }
    }
}
