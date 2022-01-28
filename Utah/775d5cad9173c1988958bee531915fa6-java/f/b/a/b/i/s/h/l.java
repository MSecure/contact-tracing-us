package f.b.a.b.i.s.h;

import android.content.Context;
import e.b.a.m;
import f.b.a.b.i.i;
import f.b.a.b.i.p.e;
import f.b.a.b.i.p.g;
import f.b.a.b.i.p.m;
import f.b.a.b.i.s.i.c;
import f.b.a.b.i.s.i.h;
import f.b.a.b.i.t.b;
import f.b.a.b.i.u.a;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class l {
    public final Context a;
    public final e b;
    public final c c;

    /* renamed from: d  reason: collision with root package name */
    public final r f2606d;

    /* renamed from: e  reason: collision with root package name */
    public final Executor f2607e;

    /* renamed from: f  reason: collision with root package name */
    public final b f2608f;

    /* renamed from: g  reason: collision with root package name */
    public final a f2609g;

    public l(Context context, e eVar, c cVar, r rVar, Executor executor, b bVar, a aVar) {
        this.a = context;
        this.b = eVar;
        this.c = cVar;
        this.f2606d = rVar;
        this.f2607e = executor;
        this.f2608f = bVar;
        this.f2609g = aVar;
    }

    public void a(i iVar, int i2) {
        g b2;
        m a2 = this.b.a(iVar.b());
        Iterable<h> iterable = (Iterable) this.f2608f.c(new h(this, iVar));
        if (iterable.iterator().hasNext()) {
            if (a2 == null) {
                m.e.R("Uploader", "Unknown backend for %s, deleting event batch for it...", iVar);
                b2 = g.a();
            } else {
                ArrayList arrayList = new ArrayList();
                for (h hVar : iterable) {
                    arrayList.add(hVar.a());
                }
                byte[] c2 = iVar.c();
                if (1 != 0) {
                    b2 = a2.b(new f.b.a.b.i.p.a(arrayList, c2, null));
                } else {
                    throw new IllegalStateException(f.a.a.a.a.w("Missing required properties:", ""));
                }
            }
            this.f2608f.c(new i(this, b2, iterable, iVar, i2));
        }
    }
}
