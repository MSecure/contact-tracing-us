package b.t;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry$1;
import b.c.a.b.b;
import b.o.f;
import b.o.j;
import b.t.b;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final d f2584a;

    /* renamed from: b  reason: collision with root package name */
    public final b f2585b = new b();

    public c(d dVar) {
        this.f2584a = dVar;
    }

    public void a(Bundle bundle) {
        f lifecycle = this.f2584a.getLifecycle();
        if (((j) lifecycle).f2221b == f.b.INITIALIZED) {
            lifecycle.a(new Recreator(this.f2584a));
            b bVar = this.f2585b;
            if (!bVar.f2581c) {
                if (bundle != null) {
                    bVar.f2580b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                lifecycle.a(new SavedStateRegistry$1(bVar));
                bVar.f2581c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        b bVar = this.f2585b;
        if (bVar != null) {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = bVar.f2580b;
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
            b<K, V>.d c2 = bVar.f2579a.c();
            while (c2.hasNext()) {
                Map.Entry entry = (Map.Entry) c2.next();
                bundle2.putBundle((String) entry.getKey(), ((b.AbstractC0050b) entry.getValue()).a());
            }
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
            return;
        }
        throw null;
    }
}
