package g.b.a.c.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import e.n.a.m;
import f.b.a.a.a.k;
import g.b.a.c.a.c;
import g.b.b.b;
import java.util.Objects;

public class g implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final m f3814d;

    public interface a {
        c b();
    }

    public g(m mVar) {
        this.f3814d = mVar;
    }

    public static final Context b(Context context) {
        while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    public final Object a() {
        Objects.requireNonNull(this.f3814d.r(), "Hilt Fragments must be attached before creating the component.");
        d.b(this.f3814d.r() instanceof b, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", this.f3814d.r().getClass());
        c b2 = ((a) f.b.a.c.b.o.b.t0(this.f3814d.r(), a.class)).b();
        m mVar = this.f3814d;
        k.e eVar = (k.e) b2;
        Objects.requireNonNull(eVar);
        Objects.requireNonNull(mVar);
        eVar.f2265d = mVar;
        d.a(mVar, m.class);
        return new k.f(eVar.a, eVar.b, eVar.c, eVar.f2265d);
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
