package g.a.a.c.c;

import android.os.Looper;
import androidx.activity.ComponentActivity;
import e.p.a0;
import e.p.b0;
import f.b.a.a.a.a;
import g.a.a.a;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class b implements g.a.b.b<g.a.a.b.a> {
    public final b0 b;
    public volatile g.a.a.b.a c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3593d = new Object();

    public class a implements b0.b {
        public final /* synthetic */ ComponentActivity a;

        public a(b bVar, ComponentActivity componentActivity) {
            this.a = componentActivity;
        }

        @Override // e.p.b0.b
        public <T extends a0> T a(Class<T> cls) {
            return new c(new a.c(null));
        }
    }

    /* renamed from: g.a.a.c.c.b$b  reason: collision with other inner class name */
    public interface AbstractC0139b {
        g.a.a.c.a.b d();
    }

    public static final class c extends a0 {
        public final g.a.a.b.a c;

        public c(g.a.a.b.a aVar) {
            this.c = aVar;
        }

        @Override // e.p.a0
        public void a() {
            e eVar = (e) ((d) f.b.a.c.b.o.b.H0(this.c, d.class)).b();
            Objects.requireNonNull(eVar);
            if (f.b.a.c.b.o.b.f2577f == null) {
                f.b.a.c.b.o.b.f2577f = Looper.getMainLooper().getThread();
            }
            if (Thread.currentThread() == f.b.a.c.b.o.b.f2577f) {
                for (a.AbstractC0137a aVar : eVar.a) {
                    aVar.a();
                }
                return;
            }
            throw new IllegalStateException("Must be called on the Main thread.");
        }
    }

    public interface d {
        g.a.a.a b();
    }

    public static final class e implements g.a.a.a {
        public final Set<a.AbstractC0137a> a = new HashSet();
    }

    public b(ComponentActivity componentActivity) {
        this.b = new b0(componentActivity.i(), new a(this, componentActivity));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // g.a.b.b
    public g.a.a.b.a e() {
        if (this.c == null) {
            synchronized (this.f3593d) {
                if (this.c == null) {
                    this.c = ((c) this.b.a(c.class)).c;
                }
            }
        }
        return this.c;
    }
}
