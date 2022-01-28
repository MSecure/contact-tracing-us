package androidx.lifecycle;

import b.o.a0;
import b.o.f;
import b.o.g;
import b.o.i;
import b.o.j;
import b.o.t;
import b.o.x;
import b.o.z;
import b.t.b;
import b.t.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class SavedStateHandleController implements g {

    /* renamed from: a  reason: collision with root package name */
    public final String f248a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f249b = false;

    /* renamed from: c  reason: collision with root package name */
    public final t f250c;

    public static final class a implements b.a {
        @Override // b.t.b.a
        public void a(d dVar) {
            if (dVar instanceof a0) {
                z viewModelStore = ((a0) dVar).getViewModelStore();
                b savedStateRegistry = dVar.getSavedStateRegistry();
                if (viewModelStore != null) {
                    Iterator it = new HashSet(viewModelStore.f2263a.keySet()).iterator();
                    while (it.hasNext()) {
                        HashMap<String, x> hashMap = viewModelStore.f2263a;
                        f lifecycle = dVar.getLifecycle();
                        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) hashMap.get((String) it.next()).getTag("androidx.lifecycle.savedstate.vm.tag");
                        if (savedStateHandleController != null && !savedStateHandleController.f249b) {
                            savedStateHandleController.h(savedStateRegistry, lifecycle);
                            SavedStateHandleController.i(savedStateRegistry, lifecycle);
                        }
                    }
                    if (!new HashSet(viewModelStore.f2263a.keySet()).isEmpty()) {
                        savedStateRegistry.c(a.class);
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
        this.f248a = str;
        this.f250c = tVar;
    }

    public static void i(final b bVar, final f fVar) {
        f.b bVar2 = ((j) fVar).f2221b;
        if (bVar2 != f.b.INITIALIZED) {
            if (!(bVar2.compareTo(f.b.STARTED) >= 0)) {
                fVar.a(new g() {
                    /* class androidx.lifecycle.SavedStateHandleController.AnonymousClass1 */

                    @Override // b.o.g
                    public void d(i iVar, f.a aVar) {
                        if (aVar == f.a.ON_START) {
                            j jVar = (j) f.this;
                            jVar.d("removeObserver");
                            jVar.f2220a.h(this);
                            bVar.c(a.class);
                        }
                    }
                });
                return;
            }
        }
        bVar.c(a.class);
    }

    @Override // b.o.g
    public void d(i iVar, f.a aVar) {
        if (aVar == f.a.ON_DESTROY) {
            this.f249b = false;
            j jVar = (j) iVar.getLifecycle();
            jVar.d("removeObserver");
            jVar.f2220a.h(this);
        }
    }

    public void h(b bVar, f fVar) {
        if (!this.f249b) {
            this.f249b = true;
            fVar.a(this);
            bVar.b(this.f248a, this.f250c.f2241d);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }
}
