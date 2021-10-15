package b.b0.y.p;

import android.content.Context;
import android.content.ReceiverCallNotAllowedException;
import b.b0.m;
import b.b0.y.p.e.b;
import b.b0.y.p.e.c;
import b.b0.y.p.e.e;
import b.b0.y.p.e.f;
import b.b0.y.p.e.g;
import b.b0.y.p.e.h;
import b.b0.y.r.p;
import b.b0.y.s.s.a;

public class d implements c.a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f1169d = m.e("WorkConstraintsTracker");

    /* renamed from: a  reason: collision with root package name */
    public final c f1170a;

    /* renamed from: b  reason: collision with root package name */
    public final c<?>[] f1171b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f1172c = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f1170a = cVar;
        this.f1171b = new c[]{new b.b0.y.p.e.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new b.b0.y.p.e.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    public boolean a(String str) {
        synchronized (this.f1172c) {
            c<?>[] cVarArr = this.f1171b;
            for (c<?> cVar : cVarArr) {
                ReceiverCallNotAllowedException receiverCallNotAllowedException = (T) cVar.f1174b;
                if (receiverCallNotAllowedException != null && cVar.c(receiverCallNotAllowedException) && cVar.f1173a.contains(str)) {
                    m.c().a(f1169d, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void b(Iterable<p> iterable) {
        synchronized (this.f1172c) {
            c<?>[] cVarArr = this.f1171b;
            for (c<?> cVar : cVarArr) {
                if (cVar.f1176d != null) {
                    cVar.f1176d = null;
                    cVar.e(null, (T) cVar.f1174b);
                }
            }
            for (c<?> cVar2 : this.f1171b) {
                cVar2.d(iterable);
            }
            c<?>[] cVarArr2 = this.f1171b;
            for (c<?> cVar3 : cVarArr2) {
                if (cVar3.f1176d != this) {
                    cVar3.f1176d = this;
                    cVar3.e(this, (T) cVar3.f1174b);
                }
            }
        }
    }

    public void c() {
        synchronized (this.f1172c) {
            c<?>[] cVarArr = this.f1171b;
            for (c<?> cVar : cVarArr) {
                if (!cVar.f1173a.isEmpty()) {
                    cVar.f1173a.clear();
                    cVar.f1175c.b(cVar);
                }
            }
        }
    }
}
