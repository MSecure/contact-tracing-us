package g.b.a.c.c;

import android.os.Looper;
import androidx.activity.ComponentActivity;
import e.p.e0;
import e.p.f0;
import f.b.a.a.a.b;
import g.b.a.a;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class b implements g.b.b.b<g.b.a.b.a> {
    public final f0 b;
    public volatile g.b.a.b.a c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3747d = new Object();

    public class a implements f0.b {
        public final /* synthetic */ ComponentActivity a;

        public a(b bVar, ComponentActivity componentActivity) {
            this.a = componentActivity;
        }

        @Override // e.p.f0.b
        public <T extends e0> T a(Class<T> cls) {
            return new c(new b.c(null));
        }
    }

    /* renamed from: g.b.a.c.c.b$b  reason: collision with other inner class name */
    public interface AbstractC0139b {
        g.b.a.c.a.b f();
    }

    public static final class c extends e0 {
        public final g.b.a.b.a c;

        public c(g.b.a.b.a aVar) {
            this.c = aVar;
        }

        @Override // e.p.e0
        public void a() {
            e eVar = (e) ((d) f.b.a.c.b.o.b.t0(this.c, d.class)).b();
            Objects.requireNonNull(eVar);
            if (f.b.a.c.b.o.b.f2666f == null) {
                f.b.a.c.b.o.b.f2666f = Looper.getMainLooper().getThread();
            }
            if (Thread.currentThread() == f.b.a.c.b.o.b.f2666f) {
                for (a.AbstractC0137a aVar : eVar.a) {
                    aVar.a();
                }
                return;
            }
            throw new IllegalStateException("Must be called on the Main thread.");
        }
    }

    public interface d {
        g.b.a.a b();
    }

    public static final class e implements g.b.a.a {
        public final Set<a.AbstractC0137a> a = new HashSet();
    }

    public b(ComponentActivity componentActivity) {
        this.b = new f0(componentActivity.i(), new a(this, componentActivity));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // g.b.b.b
    public g.b.a.b.a e() {
        if (this.c == null) {
            synchronized (this.f3747d) {
                if (this.c == null) {
                    this.c = ((c) this.b.a(c.class)).c;
                }
            }
        }
        return this.c;
    }
}
