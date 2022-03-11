package f.b.a.a.a.k0;

import f.b.a.a.a.n0.j;
import f.b.a.a.a.n0.r;
import f.b.a.a.a.n0.s;
import f.b.a.a.a.n0.v;
import f.b.a.a.a.t.q0.a;
import f.b.b.a.t;
import java.util.Objects;
/* loaded from: classes.dex */
public class c {
    public final e a;
    public final v b;
    public final a c;

    /* renamed from: d */
    public final String f2311d;

    public c(e eVar, v vVar, a aVar, String str) {
        this.a = eVar;
        this.b = vVar;
        this.c = aVar;
        this.f2311d = str;
    }

    public void a() {
        String networkCountryIso = this.a.a.getNetworkCountryIso();
        if (t.a(networkCountryIso)) {
            networkCountryIso = null;
        }
        if (networkCountryIso != null) {
            v vVar = this.b;
            r rVar = vVar.a;
            long a = vVar.b.a();
            Objects.requireNonNull(rVar);
            j jVar = new j(networkCountryIso, a);
            s sVar = (s) rVar;
            sVar.a.b();
            sVar.a.c();
            try {
                sVar.b.f(jVar);
                sVar.a.l();
            } finally {
                sVar.a.g();
            }
        }
    }
}
