package e.b0.a0.q.f;

import android.content.Context;
import e.b0.a0.t.t.b;
import e.b0.n;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class d<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final String f1091f = n.e("ConstraintTracker");
    public final e.b0.a0.t.t.a a;
    public final Context b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Set<e.b0.a0.q.a<T>> f1092d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    public T f1093e;

    public class a implements Runnable {
        public final /* synthetic */ List b;

        public a(List list) {
            this.b = list;
        }

        public void run() {
            for (e.b0.a0.q.a aVar : this.b) {
                aVar.a(d.this.f1093e);
            }
        }
    }

    public d(Context context, e.b0.a0.t.t.a aVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
    }

    public abstract T a();

    public void b(e.b0.a0.q.a<T> aVar) {
        synchronized (this.c) {
            if (this.f1092d.remove(aVar) && this.f1092d.isEmpty()) {
                e();
            }
        }
    }

    public void c(T t) {
        synchronized (this.c) {
            T t2 = this.f1093e;
            if (t2 != t) {
                if (t2 == null || !t2.equals(t)) {
                    this.f1093e = t;
                    ((b) this.a).c.execute(new a(new ArrayList(this.f1092d)));
                }
            }
        }
    }

    public abstract void d();

    public abstract void e();
}
