package c.b.a.a.g.b;

import java.util.Collections;
import java.util.Map;

public final /* synthetic */ class f implements m {

    /* renamed from: a  reason: collision with root package name */
    public final e f3265a;

    /* renamed from: b  reason: collision with root package name */
    public final b f3266b;

    public f(e eVar, b bVar) {
        this.f3265a = eVar;
        this.f3266b = bVar;
    }

    @Override // c.b.a.a.g.b.m
    public final Object a() {
        e eVar = this.f3265a;
        b bVar = this.f3266b;
        if (bVar != null) {
            Map<String, String> a2 = e.d("gms:phenotype:phenotype_flag:debug_disable_caching") ? bVar.a() : bVar.f3226e;
            if (a2 == null) {
                synchronized (bVar.f3225d) {
                    a2 = bVar.f3226e;
                    if (a2 == null) {
                        a2 = bVar.a();
                        bVar.f3226e = a2;
                    }
                }
            }
            if (a2 == null) {
                a2 = Collections.emptyMap();
            }
            return a2.get(eVar.f3251b);
        }
        throw null;
    }
}
