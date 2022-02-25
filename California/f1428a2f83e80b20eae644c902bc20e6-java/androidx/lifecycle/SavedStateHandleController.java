package androidx.lifecycle;

import android.os.Bundle;
import e.p.a0;
import e.p.c0;
import e.p.d0;
import e.p.g;
import e.p.h;
import e.p.j;
import e.p.k;
import e.p.u;
import e.u.a;
import e.u.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class SavedStateHandleController implements h {
    public final String a;
    public boolean b = false;
    public final u c;

    public static final class a implements a.AbstractC0054a {
        @Override // e.u.a.AbstractC0054a
        public void a(c cVar) {
            if (cVar instanceof d0) {
                c0 h2 = ((d0) cVar).h();
                e.u.a c = cVar.c();
                Objects.requireNonNull(h2);
                Iterator it = new HashSet(h2.a.keySet()).iterator();
                while (it.hasNext()) {
                    SavedStateHandleController.h(h2.a.get((String) it.next()), c, cVar.a());
                }
                if (!new HashSet(h2.a.keySet()).isEmpty()) {
                    c.c(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    public SavedStateHandleController(String str, u uVar) {
        this.a = str;
        this.c = uVar;
    }

    public static void h(a0 a0Var, e.u.a aVar, g gVar) {
        Object obj;
        Map<String, Object> map = a0Var.a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = a0Var.a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController != null && !savedStateHandleController.b) {
            savedStateHandleController.i(aVar, gVar);
            k(aVar, gVar);
        }
    }

    public static SavedStateHandleController j(e.u.a aVar, g gVar, String str, Bundle bundle) {
        u uVar;
        Bundle a2 = aVar.a(str);
        Class[] clsArr = u.f1717e;
        if (a2 == null && bundle == null) {
            uVar = new u();
        } else {
            HashMap hashMap = new HashMap();
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    hashMap.put(str2, bundle.get(str2));
                }
            }
            if (a2 == null) {
                uVar = new u(hashMap);
            } else {
                ArrayList parcelableArrayList = a2.getParcelableArrayList("keys");
                ArrayList parcelableArrayList2 = a2.getParcelableArrayList("values");
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    throw new IllegalStateException("Invalid bundle passed as restored state");
                }
                for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                    hashMap.put((String) parcelableArrayList.get(i2), parcelableArrayList2.get(i2));
                }
                uVar = new u(hashMap);
            }
        }
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, uVar);
        savedStateHandleController.i(aVar, gVar);
        k(aVar, gVar);
        return savedStateHandleController;
    }

    public static void k(final e.u.a aVar, final g gVar) {
        g.b bVar = ((k) gVar).b;
        if (bVar != g.b.INITIALIZED) {
            if (!(bVar.compareTo(g.b.STARTED) >= 0)) {
                gVar.a(new h() {
                    /* class androidx.lifecycle.SavedStateHandleController.AnonymousClass1 */

                    @Override // e.p.h
                    public void d(j jVar, g.a aVar) {
                        if (aVar == g.a.ON_START) {
                            k kVar = (k) g.this;
                            kVar.d("removeObserver");
                            kVar.a.l(this);
                            aVar.c(a.class);
                        }
                    }
                });
                return;
            }
        }
        aVar.c(a.class);
    }

    @Override // e.p.h
    public void d(j jVar, g.a aVar) {
        if (aVar == g.a.ON_DESTROY) {
            this.b = false;
            k kVar = (k) jVar.a();
            kVar.d("removeObserver");
            kVar.a.l(this);
        }
    }

    public void i(e.u.a aVar, g gVar) {
        if (!this.b) {
            this.b = true;
            gVar.a(this);
            aVar.b(this.a, this.c.f1718d);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }
}
