package g.b.a.c.c;

import android.os.Looper;
import androidx.activity.ComponentActivity;
import e.q.e0;
import e.q.f0;
import g.b.a.a;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class c implements g.b.b.b<g.b.a.b.a> {
    public final f0 b;
    public volatile g.b.a.b.a c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3812d = new Object();

    public interface a {
        g.b.a.c.a.b f();
    }

    public static final class b extends e0 {
        public final g.b.a.b.a c;

        public b(g.b.a.b.a aVar) {
            this.c = aVar;
        }

        @Override // e.q.e0
        public void a() {
            d dVar = (d) ((AbstractC0139c) f.b.a.c.b.o.b.t0(this.c, AbstractC0139c.class)).b();
            Objects.requireNonNull(dVar);
            if (f.b.a.c.b.o.b.f2720f == null) {
                f.b.a.c.b.o.b.f2720f = Looper.getMainLooper().getThread();
            }
            if (Thread.currentThread() == f.b.a.c.b.o.b.f2720f) {
                for (a.AbstractC0137a aVar : dVar.a) {
                    aVar.a();
                }
                return;
            }
            throw new IllegalStateException("Must be called on the Main thread.");
        }
    }

    /* renamed from: g.b.a.c.c.c$c  reason: collision with other inner class name */
    public interface AbstractC0139c {
        g.b.a.a b();
    }

    public static final class d implements g.b.a.a {
        public final Set<a.AbstractC0137a> a = new HashSet();
    }

    public c(ComponentActivity componentActivity) {
        this.b = new f0(componentActivity.i(), new b(this, componentActivity));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // g.b.b.b
    public g.b.a.b.a e() {
        if (this.c == null) {
            synchronized (this.f3812d) {
                if (this.c == null) {
                    this.c = ((b) this.b.a(b.class)).c;
                }
            }
        }
        return this.c;
    }
}
