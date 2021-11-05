package androidx.lifecycle;

import b.n.a0;
import b.n.f;
import b.n.g;
import b.n.i;
import b.n.j;
import b.n.t;
import b.n.x;
import b.n.z;
import b.s.a;
import b.s.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class SavedStateHandleController implements g {

    /* renamed from: a  reason: collision with root package name */
    public final String f168a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f169b = false;

    /* renamed from: c  reason: collision with root package name */
    public final t f170c;

    public static final class a implements a.AbstractC0040a {
        @Override // b.s.a.AbstractC0040a
        public void a(c cVar) {
            if (cVar instanceof a0) {
                z viewModelStore = ((a0) cVar).getViewModelStore();
                b.s.a savedStateRegistry = cVar.getSavedStateRegistry();
                if (viewModelStore != null) {
                    Iterator it = new HashSet(viewModelStore.f1427a.keySet()).iterator();
                    while (it.hasNext()) {
                        HashMap<String, x> hashMap = viewModelStore.f1427a;
                        f lifecycle = cVar.getLifecycle();
                        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) hashMap.get((String) it.next()).getTag("androidx.lifecycle.savedstate.vm.tag");
                        if (savedStateHandleController != null && !savedStateHandleController.f169b) {
                            savedStateHandleController.h(savedStateRegistry, lifecycle);
                            SavedStateHandleController.i(savedStateRegistry, lifecycle);
                        }
                    }
                    if (!new HashSet(viewModelStore.f1427a.keySet()).isEmpty()) {
                        savedStateRegistry.b(a.class);
                        return;
                    }
                    return;
                }
                throw null;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    public SavedStateHandleController(String str, t tVar) {
        this.f168a = str;
        this.f170c = tVar;
    }

    public static void i(final b.s.a aVar, final f fVar) {
        f.b bVar = ((j) fVar).f1392b;
        if (bVar != f.b.INITIALIZED) {
            if (!(bVar.compareTo(f.b.STARTED) >= 0)) {
                fVar.a(new g() {
                    /* class androidx.lifecycle.SavedStateHandleController.AnonymousClass1 */

                    @Override // b.n.g
                    public void d(i iVar, f.a aVar) {
                        if (aVar == f.a.ON_START) {
                            ((j) fVar).f1391a.j(this);
                            aVar.b(a.class);
                        }
                    }
                });
                return;
            }
        }
        aVar.b(a.class);
    }

    @Override // b.n.g
    public void d(i iVar, f.a aVar) {
        if (aVar == f.a.ON_DESTROY) {
            this.f169b = false;
            ((j) iVar.getLifecycle()).f1391a.j(this);
        }
    }

    public void h(b.s.a aVar, f fVar) {
        if (!this.f169b) {
            this.f169b = true;
            fVar.a(this);
            if (aVar.f1707a.h(this.f168a, this.f170c.f1407b) != null) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }
}
