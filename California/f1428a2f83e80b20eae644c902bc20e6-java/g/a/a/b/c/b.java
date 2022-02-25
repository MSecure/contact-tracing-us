package g.a.a.b.c;

import androidx.activity.ComponentActivity;
import e.p.a0;
import e.p.b0;
import f.b.a.a.a.a;

public final class b implements g.a.b.b<g.a.a.a.a> {
    public final b0 b;
    public volatile g.a.a.a.a c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3489d = new Object();

    public class a implements b0.b {
        public final /* synthetic */ ComponentActivity a;

        public a(b bVar, ComponentActivity componentActivity) {
            this.a = componentActivity;
        }

        @Override // e.p.b0.b
        public <T extends a0> T a(Class<T> cls) {
            return new C0134b(new a.c(null));
        }
    }

    /* renamed from: g.a.a.b.c.b$b  reason: collision with other inner class name */
    public static final class C0134b extends a0 {
        public final g.a.a.a.a c;

        public C0134b(g.a.a.a.a aVar) {
            this.c = aVar;
        }
    }

    public interface c {
        g.a.a.b.a.b d();
    }

    public b(ComponentActivity componentActivity) {
        this.b = new b0(componentActivity.h(), new a(this, componentActivity));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // g.a.b.b
    public g.a.a.a.a d() {
        if (this.c == null) {
            synchronized (this.f3489d) {
                if (this.c == null) {
                    this.c = ((C0134b) this.b.a(C0134b.class)).c;
                }
            }
        }
        return this.c;
    }
}
