package b.s;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry$1;
import b.n.f;
import b.n.j;
import b.s.a;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final c f1712a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1713b = new a();

    public b(c cVar) {
        this.f1712a = cVar;
    }

    public void a(Bundle bundle) {
        f lifecycle = this.f1712a.getLifecycle();
        if (((j) lifecycle).f1392b == f.b.INITIALIZED) {
            lifecycle.a(new Recreator(this.f1712a));
            a aVar = this.f1713b;
            if (!aVar.f1709c) {
                if (bundle != null) {
                    aVar.f1708b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                lifecycle.a(new SavedStateRegistry$1(aVar));
                aVar.f1709c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        a aVar = this.f1713b;
        if (aVar != null) {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = aVar.f1708b;
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
            b.c.a.b.b<K, V>.d c2 = aVar.f1707a.c();
            while (c2.hasNext()) {
                Map.Entry entry = (Map.Entry) c2.next();
                bundle2.putBundle((String) entry.getKey(), ((a.b) entry.getValue()).a());
            }
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
            return;
        }
        throw null;
    }
}
