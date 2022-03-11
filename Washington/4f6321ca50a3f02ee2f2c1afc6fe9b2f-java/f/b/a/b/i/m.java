package f.b.a.b.i;

import android.content.Context;
import f.b.a.b.b;
import f.b.a.b.g;
import f.b.a.b.i.b;
import f.b.a.b.i.i;
import f.b.a.b.i.s.e;
import f.b.a.b.i.s.h.l;
import f.b.a.b.i.s.h.n;
import f.b.a.b.i.s.h.p;
import f.b.a.b.i.u.a;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class m implements l {

    /* renamed from: e  reason: collision with root package name */
    public static volatile n f2362e;
    public final a a;
    public final a b;
    public final e c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2363d;

    public m(a aVar, a aVar2, e eVar, l lVar, p pVar) {
        this.a = aVar;
        this.b = aVar2;
        this.c = eVar;
        this.f2363d = lVar;
        pVar.a.execute(new n(pVar));
    }

    public static m a() {
        n nVar = f2362e;
        if (nVar != null) {
            return ((c) nVar).m.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f2362e == null) {
            synchronized (m.class) {
                if (f2362e == null) {
                    Objects.requireNonNull(context);
                    f2362e = new c(context, null);
                }
            }
        }
    }

    public g c(d dVar) {
        Set set;
        if (dVar instanceof d) {
            Objects.requireNonNull((f.b.a.b.h.a) dVar);
            set = Collections.unmodifiableSet(f.b.a.b.h.a.f2300f);
        } else {
            set = Collections.singleton(new b("proto"));
        }
        i.a a2 = i.a();
        Objects.requireNonNull(dVar);
        a2.b("cct");
        b.C0076b bVar = (b.C0076b) a2;
        bVar.b = ((f.b.a.b.h.a) dVar).b();
        return new j(set, bVar.a(), this);
    }
}
