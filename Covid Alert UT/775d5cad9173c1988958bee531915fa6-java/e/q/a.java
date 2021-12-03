package e.q;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import e.q.f0;
import e.v.c;
import f.b.a.a.a.k;
import f.b.a.c.b.o.b;
import g.b.a.c.b.d;
import java.util.Objects;

public abstract class a extends f0.c {
    public final e.v.a a;
    public final h b;
    public final Bundle c;

    public a(c cVar, Bundle bundle) {
        this.a = cVar.d();
        this.b = cVar.a();
        this.c = bundle;
    }

    @Override // e.q.f0.b, e.q.f0.c
    public final <T extends e0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // e.q.f0.e
    public void b(e0 e0Var) {
        SavedStateHandleController.h(e0Var, this.a, this.b);
    }

    @Override // e.q.f0.c
    public final <T extends e0> T c(String str, Class<T> cls) {
        SavedStateHandleController j2 = SavedStateHandleController.j(this.a, this.b, str, this.c);
        y yVar = j2.c;
        k.h hVar = (k.h) ((d.a) this).f3809d;
        Objects.requireNonNull(hVar);
        Objects.requireNonNull(yVar);
        hVar.c = yVar;
        g.b.a.c.c.d.a(yVar, y.class);
        i.a.a<e0> aVar = ((d.b) b.t0(new k.i(hVar.a, hVar.b, hVar.c, null), d.b.class)).a().get(cls.getName());
        if (aVar != null) {
            T t = (T) aVar.get();
            t.b("androidx.lifecycle.savedstate.vm.tag", j2);
            return t;
        }
        StringBuilder h2 = f.a.a.a.a.h("Expected the @HiltViewModel-annotated class '");
        h2.append(cls.getName());
        h2.append("' to be available in the multi-binding of @HiltViewModelMap but none was found.");
        throw new IllegalStateException(h2.toString());
    }
}
