package g.b.a.c.b;

import android.app.Application;
import android.os.Bundle;
import e.r.f0;
import e.r.z;
import g.b.a.c.a.d;
import java.util.Set;
/* loaded from: classes.dex */
public final class c {
    public final Application a;
    public final Set<String> b;
    public final d c;

    public c(Application application, Set<String> set, d dVar) {
        this.a = application;
        this.b = set;
        this.c = dVar;
    }

    public final f0.b a(e.w.c cVar, Bundle bundle, f0.b bVar) {
        if (bVar == null) {
            bVar = new z(this.a, cVar, bundle);
        }
        return new d(cVar, bundle, this.b, bVar, this.c);
    }
}
