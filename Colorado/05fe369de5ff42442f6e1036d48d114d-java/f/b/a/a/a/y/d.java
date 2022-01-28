package f.b.a.a.a.y;

import f.b.a.a.a.b0.j;
import f.b.a.a.a.b0.r;
import f.b.a.a.a.b0.s;
import f.b.a.a.a.b0.u;
import f.b.a.a.a.i.f0.a;
import f.b.b.a.t;
import java.util.Objects;

public class d {
    public final f a;
    public final u b;
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2464d;

    public d(f fVar, u uVar, a aVar, String str) {
        this.a = fVar;
        this.b = uVar;
        this.c = aVar;
        this.f2464d = str;
    }

    public void a() {
        String networkCountryIso = this.a.a.getNetworkCountryIso();
        if (t.a(networkCountryIso)) {
            networkCountryIso = null;
        }
        if (networkCountryIso != null) {
            u uVar = this.b;
            r rVar = uVar.a;
            long a2 = uVar.b.a();
            Objects.requireNonNull(rVar);
            j jVar = new j(networkCountryIso, a2);
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
