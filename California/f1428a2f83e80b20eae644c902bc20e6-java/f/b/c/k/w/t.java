package f.b.c.k.w;

import android.content.Context;
import f.b.c.k.r.a;
import f.b.c.k.s.e;
import f.b.c.k.u.b;
import f.b.c.k.x.c;
import h.a.n0;

public class t {

    /* renamed from: f  reason: collision with root package name */
    public static final n0.f<String> f3163f;

    /* renamed from: g  reason: collision with root package name */
    public static final n0.f<String> f3164g;
    public final c a;
    public final a b;
    public final b0 c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3165d;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f3166e;

    static {
        n0.d<String> dVar = n0.c;
        f3163f = n0.f.a("x-goog-api-client", dVar);
        f3164g = n0.f.a("google-cloud-resource-prefix", dVar);
    }

    public t(c cVar, Context context, a aVar, e eVar, c0 c0Var) {
        this.a = cVar;
        this.f3166e = c0Var;
        this.b = aVar;
        this.c = new b0(cVar, context, eVar, new o(aVar));
        b bVar = eVar.a;
        this.f3165d = String.format("projects/%s/databases/%s", bVar.b, bVar.c);
    }
}
