package g.b.a.c.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import e.m.a.m;
import f.b.a.a.a.b;
import g.b.a.c.a.c;
import g.b.b.b;
import java.util.Objects;

public class f implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final m f3749d;

    public interface a {
        c b();
    }

    public f(m mVar) {
        this.f3749d = mVar;
    }

    public static final Context b(Context context) {
        while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    public final Object a() {
        Objects.requireNonNull(this.f3749d.p(), "Hilt Fragments must be attached before creating the component.");
        c.b(this.f3749d.p() instanceof b, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", this.f3749d.p().getClass());
        c b2 = ((a) f.b.a.c.b.o.b.t0(this.f3749d.p(), a.class)).b();
        m mVar = this.f3749d;
        b.c.C0068b.a aVar = (b.c.C0068b.a) b2;
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(mVar);
        aVar.a = mVar;
        c.a(mVar, m.class);
        return new b.c.C0068b.C0069b(aVar.a, null);
    }

    @Override // g.b.b.b
    public Object e() {
        if (this.b == null) {
            synchronized (this.c) {
                if (this.b == null) {
                    this.b = a();
                }
            }
        }
        return this.b;
    }
}
