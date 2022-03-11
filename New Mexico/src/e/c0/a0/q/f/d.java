package e.c0.a0.q.f;

import android.content.Context;
import e.c0.a0.t.t.b;
import e.c0.n;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class d<T> {

    /* renamed from: f */
    public static final String f1170f = n.e("ConstraintTracker");
    public final e.c0.a0.t.t.a a;
    public final Context b;
    public final Object c = new Object();

    /* renamed from: d */
    public final Set<e.c0.a0.q.a<T>> f1171d = new LinkedHashSet();

    /* renamed from: e */
    public T f1172e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ List b;

        public a(List list) {
            d.this = r1;
            this.b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e.c0.a0.q.a aVar : this.b) {
                aVar.a(d.this.f1172e);
            }
        }
    }

    public d(Context context, e.c0.a0.t.t.a aVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
    }

    public abstract T a();

    public void b(e.c0.a0.q.a<T> aVar) {
        synchronized (this.c) {
            if (this.f1171d.remove(aVar) && this.f1171d.isEmpty()) {
                e();
            }
        }
    }

    public void c(T t) {
        synchronized (this.c) {
            T t2 = this.f1172e;
            if (t2 != t && (t2 == null || !t2.equals(t))) {
                this.f1172e = t;
                ((b) this.a).c.execute(new a(new ArrayList(this.f1171d)));
            }
        }
    }

    public abstract void d();

    public abstract void e();
}
