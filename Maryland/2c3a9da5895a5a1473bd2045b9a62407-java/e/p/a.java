package e.p;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import e.n.a.b;
import e.p.b0;
import e.u.c;

public abstract class a extends b0.c {
    public final e.u.a a;
    public final g b;
    public final Bundle c;

    public a(c cVar, Bundle bundle) {
        this.a = cVar.d();
        this.b = cVar.a();
        this.c = bundle;
    }

    @Override // e.p.b0.b, e.p.b0.c
    public final <T extends a0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // e.p.b0.e
    public void b(a0 a0Var) {
        SavedStateHandleController.h(a0Var, this.a, this.b);
    }

    @Override // e.p.b0.c
    public final <T extends a0> T c(String str, Class<T> cls) {
        T t;
        SavedStateHandleController j2 = SavedStateHandleController.j(this.a, this.b, str, this.c);
        u uVar = j2.c;
        e.n.a.a aVar = (e.n.a.a) this;
        i.a.a<b<? extends a0>> aVar2 = aVar.f1720e.get(cls.getName());
        if (aVar2 == null) {
            v vVar = aVar.f1719d;
            t = (T) vVar.c("androidx.hilt.lifecycle.HiltViewModelFactory:" + str, cls);
        } else {
            t = (T) aVar2.get().a(uVar);
        }
        t.b("androidx.lifecycle.savedstate.vm.tag", j2);
        return t;
    }
}
