package b.b0.y.p.f;

import android.content.Context;
import b.b0.m;
import b.b0.y.s.s.b;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class d<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final String f1181f = m.e("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    public final b.b0.y.s.s.a f1182a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1183b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f1184c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Set<b.b0.y.p.a<T>> f1185d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    public T f1186e;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f1187b;

        public a(List list) {
            this.f1187b = list;
        }

        public void run() {
            for (b.b0.y.p.a aVar : this.f1187b) {
                aVar.a(d.this.f1186e);
            }
        }
    }

    public d(Context context, b.b0.y.s.s.a aVar) {
        this.f1183b = context.getApplicationContext();
        this.f1182a = aVar;
    }

    public abstract T a();

    public void b(b.b0.y.p.a<T> aVar) {
        synchronized (this.f1184c) {
            if (this.f1185d.remove(aVar) && this.f1185d.isEmpty()) {
                e();
            }
        }
    }

    public void c(T t) {
        synchronized (this.f1184c) {
            if (this.f1186e != t) {
                if (this.f1186e == null || !this.f1186e.equals(t)) {
                    this.f1186e = t;
                    ((b) this.f1182a).f1336c.execute(new a(new ArrayList(this.f1185d)));
                }
            }
        }
    }

    public abstract void d();

    public abstract void e();
}
