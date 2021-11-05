package b.z.y.p;

import android.content.Context;
import android.util.EventLogTags;
import b.z.m;
import b.z.y.p.e.b;
import b.z.y.p.e.c;
import b.z.y.p.e.e;
import b.z.y.p.e.f;
import b.z.y.p.e.g;
import b.z.y.p.e.h;
import b.z.y.r.p;
import b.z.y.s.s.a;

public class d implements c.a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f2031d = m.e("WorkConstraintsTracker");

    /* renamed from: a  reason: collision with root package name */
    public final c f2032a;

    /* renamed from: b  reason: collision with root package name */
    public final c<?>[] f2033b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f2034c = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2032a = cVar;
        this.f2033b = new c[]{new b.z.y.p.e.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new b.z.y.p.e.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    public boolean a(String str) {
        synchronized (this.f2034c) {
            c<?>[] cVarArr = this.f2033b;
            for (c<?> cVar : cVarArr) {
                EventLogTags eventLogTags = (T) cVar.f2036b;
                if (eventLogTags != null && cVar.c(eventLogTags) && cVar.f2035a.contains(str)) {
                    m.c().a(f2031d, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void b(Iterable<p> iterable) {
        synchronized (this.f2034c) {
            c<?>[] cVarArr = this.f2033b;
            for (c<?> cVar : cVarArr) {
                if (cVar.f2038d != null) {
                    cVar.f2038d = null;
                    cVar.e(null, (T) cVar.f2036b);
                }
            }
            for (c<?> cVar2 : this.f2033b) {
                cVar2.d(iterable);
            }
            c<?>[] cVarArr2 = this.f2033b;
            for (c<?> cVar3 : cVarArr2) {
                if (cVar3.f2038d != this) {
                    cVar3.f2038d = this;
                    cVar3.e(this, (T) cVar3.f2036b);
                }
            }
        }
    }

    public void c() {
        synchronized (this.f2034c) {
            c<?>[] cVarArr = this.f2033b;
            for (c<?> cVar : cVarArr) {
                if (!cVar.f2035a.isEmpty()) {
                    cVar.f2035a.clear();
                    cVar.f2037c.b(cVar);
                }
            }
        }
    }
}
