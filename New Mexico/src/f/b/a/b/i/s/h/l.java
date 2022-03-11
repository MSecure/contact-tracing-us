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
/* loaded from: classes.dex */
public class l {
    public final Context a;
    public final e b;
    public final c c;

    /* renamed from: d */
    public final r f2647d;

    /* renamed from: e */
    public final Executor f2648e;

    /* renamed from: f */
    public final b f2649f;

    /* renamed from: g */
    public final a f2650g;

    public l(Context context, e eVar, c cVar, r rVar, Executor executor, b bVar, a aVar) {
        this.a = context;
        this.b = eVar;
        this.c = cVar;
        this.f2647d = rVar;
        this.f2648e = executor;
        this.f2649f = bVar;
        this.f2650g = aVar;
    }

    public void a(i iVar, int i2) {
        g b;
        m a = this.b.a(iVar.b());
        Iterable<h> iterable = (Iterable) this.f2649f.c(new b.a(this, iVar) { // from class: f.b.a.b.i.s.h.h
            public final l a;
            public final i b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // f.b.a.b.i.t.b.a
            public Object a() {
                l lVar = this.a;
                return lVar.c.w(this.b);
            }
        });
        if (iterable.iterator().hasNext()) {
            if (a == null) {
                m.e.S("Uploader", "Unknown backend for %s, deleting event batch for it...", iVar);
                b = g.a();
            } else {
                ArrayList arrayList = new ArrayList();
                for (h hVar : iterable) {
                    arrayList.add(hVar.a());
                }
                byte[] c = iVar.c();
                if (1 != 0) {
                    b = a.b(new f.b.a.b.i.p.a(arrayList, c, null));
                } else {
                    throw new IllegalStateException(f.a.a.a.a.x("Missing required properties:", ""));
                }
            }
            this.f2649f.c(new b.a(this, b, iterable, iVar, i2) { // from class: f.b.a.b.i.s.h.i
                public final l a;
                public final g b;
                public final Iterable c;

                /* renamed from: d  reason: collision with root package name */
                public final f.b.a.b.i.i f2645d;

                /* renamed from: e  reason: collision with root package name */
                public final int f2646e;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                    this.f2645d = r4;
                    this.f2646e = r5;
                }

                @Override // f.b.a.b.i.t.b.a
                public Object a() {
                    l lVar = this.a;
                    g gVar = this.b;
                    Iterable<h> iterable2 = this.c;
                    f.b.a.b.i.i iVar2 = this.f2645d;
                    int i3 = this.f2646e;
                    if (gVar.c() == g.a.TRANSIENT_ERROR) {
                        lVar.c.y(iterable2);
                        lVar.f2647d.a(iVar2, i3 + 1);
                        return null;
                    }
                    lVar.c.j(iterable2);
                    if (gVar.c() == g.a.OK) {
                        lVar.c.D(iVar2, gVar.b() + lVar.f2650g.a());
                    }
                    if (!lVar.c.r(iVar2)) {
                        return null;
                    }
                    lVar.f2647d.a(iVar2, 1);
                    return null;
                }
            });
        }
    }
}
