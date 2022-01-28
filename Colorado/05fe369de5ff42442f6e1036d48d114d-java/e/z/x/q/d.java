package e.z.x.q;

import android.content.Context;
import androidx.slice.SliceItemParcelizer;
import e.z.l;
import e.z.x.q.e.b;
import e.z.x.q.e.c;
import e.z.x.q.e.e;
import e.z.x.q.e.f;
import e.z.x.q.e.g;
import e.z.x.q.e.h;
import e.z.x.s.o;
import e.z.x.t.q.a;

public class d implements c.a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f1959d = l.e("WorkConstraintsTracker");
    public final c a;
    public final c<?>[] b;
    public final Object c = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = cVar;
        this.b = new c[]{new e.z.x.q.e.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new e.z.x.q.e.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    public boolean a(String str) {
        synchronized (this.c) {
            c<?>[] cVarArr = this.b;
            for (c<?> cVar : cVarArr) {
                SliceItemParcelizer sliceItemParcelizer = (T) cVar.b;
                if (sliceItemParcelizer != null && cVar.c(sliceItemParcelizer) && cVar.a.contains(str)) {
                    l.c().a(f1959d, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
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
                if (cVar.f1960d != null) {
                    cVar.f1960d = null;
                    cVar.e(null, (T) cVar.b);
                }
            }
            for (c<?> cVar2 : this.b) {
                cVar2.d(iterable);
            }
            c<?>[] cVarArr2 = this.b;
            for (c<?> cVar3 : cVarArr2) {
                if (cVar3.f1960d != this) {
                    cVar3.f1960d = this;
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
