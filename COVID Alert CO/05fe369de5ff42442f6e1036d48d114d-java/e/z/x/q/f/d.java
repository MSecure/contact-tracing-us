package e.z.x.q.f;

import android.content.Context;
import e.z.l;
import e.z.x.t.q.b;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class d<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final String f1967f = l.e("ConstraintTracker");
    public final e.z.x.t.q.a a;
    public final Context b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Set<e.z.x.q.a<T>> f1968d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    public T f1969e;

    public class a implements Runnable {
        public final /* synthetic */ List b;

        public a(List list) {
            this.b = list;
        }

        public void run() {
            for (e.z.x.q.a aVar : this.b) {
                aVar.a(d.this.f1969e);
            }
        }
    }

    public d(Context context, e.z.x.t.q.a aVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
    }

    public abstract T a();

    public void b(e.z.x.q.a<T> aVar) {
        synchronized (this.c) {
            if (this.f1968d.remove(aVar) && this.f1968d.isEmpty()) {
                e();
            }
        }
    }

    public void c(T t) {
        synchronized (this.c) {
            T t2 = this.f1969e;
            if (t2 != t) {
                if (t2 == null || !t2.equals(t)) {
                    this.f1969e = t;
                    ((b) this.a).c.execute(new a(new ArrayList(this.f1968d)));
                }
            }
        }
    }

    public abstract void d();

    public abstract void e();
}
