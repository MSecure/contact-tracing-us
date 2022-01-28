package androidx.lifecycle;

import android.os.Bundle;
import e.p.e0;
import e.p.g0;
import e.p.h;
import e.p.h0;
import e.p.j;
import e.p.l;
import e.p.m;
import e.p.y;
import e.u.a;
import e.u.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class SavedStateHandleController implements j {
    public final String a;
    public boolean b = false;
    public final y c;

    public static final class a implements a.AbstractC0053a {
        @Override // e.u.a.AbstractC0053a
        public void a(c cVar) {
            if (cVar instanceof h0) {
                g0 i2 = ((h0) cVar).i();
                e.u.a d2 = cVar.d();
                Objects.requireNonNull(i2);
                Iterator it = new HashSet(i2.a.keySet()).iterator();
                while (it.hasNext()) {
                    SavedStateHandleController.h(i2.a.get((String) it.next()), d2, cVar.a());
                }
                if (!new HashSet(i2.a.keySet()).isEmpty()) {
                    d2.c(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    public SavedStateHandleController(String str, y yVar) {
        this.a = str;
        this.c = yVar;
    }

    public static void h(e0 e0Var, e.u.a aVar, h hVar) {
        Object obj;
        Map<String, Object> map = e0Var.a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = e0Var.a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController != null && !savedStateHandleController.b) {
            savedStateHandleController.i(aVar, hVar);
            k(aVar, hVar);
        }
    }

    public static SavedStateHandleController j(e.u.a aVar, h hVar, String str, Bundle bundle) {
        y yVar;
        Bundle a2 = aVar.a(str);
        Class[] clsArr = y.f1547e;
        if (a2 == null && bundle == null) {
            yVar = new y();
        } else {
            HashMap hashMap = new HashMap();
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    hashMap.put(str2, bundle.get(str2));
                }
            }
            if (a2 == null) {
                yVar = new y(hashMap);
            } else {
                ArrayList parcelableArrayList = a2.getParcelableArrayList("keys");
                ArrayList parcelableArrayList2 = a2.getParcelableArrayList("values");
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    throw new IllegalStateException("Invalid bundle passed as restored state");
                }
                for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                    hashMap.put((String) parcelableArrayList.get(i2), parcelableArrayList2.get(i2));
                }
                yVar = new y(hashMap);
            }
        }
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, yVar);
        savedStateHandleController.i(aVar, hVar);
        k(aVar, hVar);
        return savedStateHandleController;
    }

    public static void k(final e.u.a aVar, final h hVar) {
        h.b bVar = ((m) hVar).b;
        if (bVar != h.b.INITIALIZED) {
            if (!(bVar.compareTo(h.b.STARTED) >= 0)) {
                hVar.a(new j() {
                    /* class androidx.lifecycle.SavedStateHandleController.AnonymousClass1 */

                    @Override // e.p.j
                    public void d(l lVar, h.a aVar) {
                        if (aVar == h.a.ON_START) {
                            m mVar = (m) h.this;
                            mVar.d("removeObserver");
                            mVar.a.l(this);
                            aVar.c(a.class);
                        }
                    }
                });
                return;
            }
        }
        aVar.c(a.class);
    }

    @Override // e.p.j
    public void d(l lVar, h.a aVar) {
        if (aVar == h.a.ON_DESTROY) {
            this.b = false;
            m mVar = (m) lVar.a();
            mVar.d("removeObserver");
            mVar.a.l(this);
        }
    }

    public void i(e.u.a aVar, h hVar) {
        if (!this.b) {
            this.b = true;
            hVar.a(this);
            aVar.b(this.a, this.c.f1548d);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }
}
