package g.a.a.c.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import e.m.a.l;
import f.b.a.a.a.a;
import g.a.a.c.a.c;
import g.a.b.b;
import java.util.Objects;

public class e implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final l f3595d;

    public interface a {
        c h();
    }

    public e(l lVar) {
        this.f3595d = lVar;
    }

    public static final Context b(Context context) {
        while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    public final Object a() {
        Objects.requireNonNull(this.f3595d.q(), "Hilt Fragments must be attached before creating the component.");
        f.b.a.c.b.o.b.I(this.f3595d.q() instanceof b, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", this.f3595d.q().getClass());
        c h2 = ((a) f.b.a.c.b.o.b.H0(this.f3595d.q(), a.class)).h();
        l lVar = this.f3595d;
        a.c.b.C0070a aVar = (a.c.b.C0070a) h2;
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(lVar);
        aVar.a = lVar;
        f.b.a.c.b.o.b.v(lVar, l.class);
        return new a.c.b.C0071b(aVar.a, null);
    }

    @Override // g.a.b.b
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
