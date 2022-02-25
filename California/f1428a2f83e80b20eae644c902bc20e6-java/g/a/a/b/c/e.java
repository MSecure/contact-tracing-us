package g.a.a.b.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import e.m.a.l;
import f.b.a.a.a.a;
import g.a.a.b.a.c;
import g.a.b.b;
import java.util.Objects;

public class e implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final l f3491d;

    public interface a {
        c h();
    }

    public e(l lVar) {
        this.f3491d = lVar;
    }

    public static final Context b(Context context) {
        while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    public final Object a() {
        Objects.requireNonNull(this.f3491d.q(), "Hilt Fragments must be attached before creating the component.");
        f.b.a.c.b.o.b.I(this.f3491d.q() instanceof b, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", this.f3491d.q().getClass());
        c h2 = ((a) f.b.a.c.b.o.b.H0(this.f3491d.q(), a.class)).h();
        l lVar = this.f3491d;
        a.c.b.C0067a aVar = (a.c.b.C0067a) h2;
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(lVar);
        aVar.a = lVar;
        f.b.a.c.b.o.b.v(lVar, l.class);
        return new a.c.b.C0068b(aVar.a, null);
    }

    @Override // g.a.b.b
    public Object d() {
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
