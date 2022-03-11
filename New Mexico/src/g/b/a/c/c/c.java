package g.b.a.c.c;

import android.os.Looper;
import androidx.activity.ComponentActivity;
import e.r.e0;
import e.r.f0;
import g.b.a.a;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public final class c implements g.b.b.b<g.b.a.b.a> {
    public final f0 b;
    public volatile g.b.a.b.a c;

    /* renamed from: d */
    public final Object f4067d = new Object();

    /* loaded from: classes.dex */
    public interface a {
        g.b.a.c.a.b f();
    }

    /* loaded from: classes.dex */
    public static final class b extends e0 {
        public final g.b.a.b.a c;

        public b(g.b.a.b.a aVar) {
            this.c = aVar;
        }

        @Override // e.r.e0
        public void a() {
            d dVar = (d) ((AbstractC0141c) f.b.a.c.b.o.b.u0(this.c, AbstractC0141c.class)).b();
            Objects.requireNonNull(dVar);
            if (f.b.a.c.b.o.b.f2762g == null) {
                f.b.a.c.b.o.b.f2762g = Looper.getMainLooper().getThread();
            }
            if (Thread.currentThread() == f.b.a.c.b.o.b.f2762g) {
                for (a.AbstractC0139a aVar : dVar.a) {
                    aVar.a();
                }
                return;
            }
            throw new IllegalStateException("Must be called on the Main thread.");
        }
    }

    /* renamed from: g.b.a.c.c.c$c */
    /* loaded from: classes.dex */
    public interface AbstractC0141c {
        g.b.a.a b();
    }

    /* loaded from: classes.dex */
    public static final class d implements g.b.a.a {
        public final Set<a.AbstractC0139a> a = new HashSet();
    }

    public c(ComponentActivity componentActivity) {
        this.b = new f0(componentActivity.i(), new b(this, componentActivity));
    }

    @Override // g.b.b.b
    public g.b.a.b.a e() {
        if (this.c == null) {
            synchronized (this.f4067d) {
                if (this.c == null) {
                    this.c = ((b) this.b.a(b.class)).c;
                }
            }
        }
        return this.c;
    }
}
