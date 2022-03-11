package g.b.a.c.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import e.o.a.m;
import f.b.a.a.a.k;
import g.b.a.c.a.c;
import g.b.b.b;
import java.util.Objects;
/* loaded from: classes.dex */
public class g implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d */
    public final m f4069d;

    /* loaded from: classes.dex */
    public interface a {
        c b();
    }

    public g(m mVar) {
        this.f4069d = mVar;
    }

    public static final Context b(Context context) {
        while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    public final Object a() {
        Objects.requireNonNull(this.f4069d.s(), "Hilt Fragments must be attached before creating the component.");
        d.b(this.f4069d.s() instanceof b, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", this.f4069d.s().getClass());
        c b = ((a) f.b.a.c.b.o.b.u0(this.f4069d.s(), a.class)).b();
        m mVar = this.f4069d;
        k.e eVar = (k.e) b;
        Objects.requireNonNull(eVar);
        Objects.requireNonNull(mVar);
        eVar.f2301d = mVar;
        d.a(mVar, m.class);
        return new k.f(eVar.a, eVar.b, eVar.c, eVar.f2301d);
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
