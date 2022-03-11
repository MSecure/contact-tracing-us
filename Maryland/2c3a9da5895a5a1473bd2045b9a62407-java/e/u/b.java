package e.u;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry$1;
import e.p.g;
import e.p.k;
import e.u.a;
import java.util.Map;
import java.util.Objects;

public final class b {
    public final c a;
    public final a b = new a();

    public b(c cVar) {
        this.a = cVar;
    }

    public void a(Bundle bundle) {
        g a2 = this.a.a();
        if (((k) a2).b == g.b.INITIALIZED) {
            a2.a(new Recreator(this.a));
            a aVar = this.b;
            if (!aVar.c) {
                if (bundle != null) {
                    aVar.b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                a2.a(new SavedStateRegistry$1(aVar));
                aVar.c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        a aVar = this.b;
        Objects.requireNonNull(aVar);
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = aVar.b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        e.c.a.b.b<K, V>.d i2 = aVar.a.i();
        while (i2.hasNext()) {
            Map.Entry entry = (Map.Entry) i2.next();
            bundle2.putBundle((String) entry.getKey(), ((a.b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
