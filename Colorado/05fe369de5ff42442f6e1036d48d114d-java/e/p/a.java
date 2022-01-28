package e.p;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import e.n.a.b;
import e.p.f0;
import e.u.c;

public abstract class a extends f0.c {
    public final e.u.a a;
    public final h b;
    public final Bundle c;

    public a(c cVar, Bundle bundle) {
        this.a = cVar.d();
        this.b = cVar.a();
        this.c = bundle;
    }

    @Override // e.p.f0.b, e.p.f0.c
    public final <T extends e0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // e.p.f0.e
    public void b(e0 e0Var) {
        SavedStateHandleController.h(e0Var, this.a, this.b);
    }

    @Override // e.p.f0.c
    public final <T extends e0> T c(String str, Class<T> cls) {
        T t;
        SavedStateHandleController j2 = SavedStateHandleController.j(this.a, this.b, str, this.c);
        y yVar = j2.c;
        e.n.a.a aVar = (e.n.a.a) this;
        i.a.a<b<? extends e0>> aVar2 = aVar.f1528e.get(cls.getName());
        if (aVar2 == null) {
            z zVar = aVar.f1527d;
            t = (T) zVar.c("androidx.hilt.lifecycle.HiltViewModelFactory:" + str, cls);
        } else {
            t = (T) aVar2.get().a(yVar);
        }
        t.b("androidx.lifecycle.savedstate.vm.tag", j2);
        return t;
    }
}
