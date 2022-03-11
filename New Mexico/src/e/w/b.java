package e.w;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import e.r.h;
import e.r.j;
import e.r.l;
import e.r.m;
import e.w.a;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public final class b {
    public final c a;
    public final a b = new a();

    public b(c cVar) {
        this.a = cVar;
    }

    public void a(Bundle bundle) {
        h a = this.a.a();
        if (((m) a).b == h.b.INITIALIZED) {
            a.a(new Recreator(this.a));
            a aVar = this.b;
            if (!aVar.c) {
                if (bundle != null) {
                    aVar.b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                a.a(new j() { // from class: androidx.savedstate.SavedStateRegistry$1
                    @Override // e.r.j
                    public void d(l lVar, h.a aVar2) {
                        a aVar3;
                        boolean z;
                        if (aVar2 == h.a.ON_START) {
                            aVar3 = a.this;
                            z = true;
                        } else if (aVar2 == h.a.ON_STOP) {
                            aVar3 = a.this;
                            z = false;
                        } else {
                            return;
                        }
                        aVar3.f2107e = z;
                    }
                });
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
        e.c.a.b.b<String, a.b>.d i2 = aVar.a.i();
        while (i2.hasNext()) {
            Map.Entry entry = (Map.Entry) i2.next();
            bundle2.putBundle((String) entry.getKey(), ((a.b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
