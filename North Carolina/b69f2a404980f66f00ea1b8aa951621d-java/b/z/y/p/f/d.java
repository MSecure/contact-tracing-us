package b.z.y.p.f;

import android.content.Context;
import b.z.m;
import b.z.y.s.s.b;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class d<T> {
    public static final String f = m.e("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    public final b.z.y.s.s.a f2042a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f2043b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f2044c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Set<b.z.y.p.a<T>> f2045d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    public T f2046e;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f2047b;

        public a(List list) {
            this.f2047b = list;
        }

        public void run() {
            for (b.z.y.p.a aVar : this.f2047b) {
                aVar.a(d.this.f2046e);
            }
        }
    }

    public d(Context context, b.z.y.s.s.a aVar) {
        this.f2043b = context.getApplicationContext();
        this.f2042a = aVar;
    }

    public abstract T a();

    public void b(b.z.y.p.a<T> aVar) {
        synchronized (this.f2044c) {
            if (this.f2045d.remove(aVar) && this.f2045d.isEmpty()) {
                e();
            }
        }
    }

    public void c(T t) {
        synchronized (this.f2044c) {
            if (this.f2046e != t) {
                if (this.f2046e == null || !this.f2046e.equals(t)) {
                    this.f2046e = t;
                    ((b) this.f2042a).f2185c.execute(new a(new ArrayList(this.f2045d)));
                }
            }
        }
    }

    public abstract void d();

    public abstract void e();
}
