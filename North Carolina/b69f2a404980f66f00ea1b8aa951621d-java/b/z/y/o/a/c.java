package b.z.y.o.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import b.z.m;
import b.z.u;
import b.z.y.b;
import b.z.y.e;
import b.z.y.k;
import b.z.y.p.d;
import b.z.y.r.p;
import b.z.y.s.h;
import b.z.y.s.j;
import b.z.y.s.s.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c implements e, b.z.y.p.c, b {
    public static final String j = m.e("GreedyScheduler");

    /* renamed from: b  reason: collision with root package name */
    public final Context f1994b;

    /* renamed from: c  reason: collision with root package name */
    public final k f1995c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1996d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<p> f1997e = new HashSet();
    public b f;
    public boolean g;
    public final Object h;
    public Boolean i;

    public c(Context context, b.z.b bVar, a aVar, k kVar) {
        this.f1994b = context;
        this.f1995c = kVar;
        this.f1996d = new d(context, aVar, this);
        this.f = new b(this, bVar.f1893e);
        this.h = new Object();
    }

    @Override // b.z.y.b
    public void a(String str, boolean z) {
        synchronized (this.h) {
            Iterator<p> it = this.f1997e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                if (next.f2091a.equals(str)) {
                    m.c().a(j, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f1997e.remove(next);
                    this.f1996d.b(this.f1997e);
                    break;
                }
            }
        }
    }

    @Override // b.z.y.e
    public void b(String str) {
        Runnable remove;
        if (this.i == null) {
            this.i = Boolean.valueOf(h.a(this.f1994b, this.f1995c.f1970b));
        }
        if (!this.i.booleanValue()) {
            m.c().d(j, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.g) {
            this.f1995c.f.b(this);
            this.g = true;
        }
        m.c().a(j, String.format("Cancelling work ID %s", str), new Throwable[0]);
        b bVar = this.f;
        if (!(bVar == null || (remove = bVar.f1993c.remove(str)) == null)) {
            bVar.f1992b.f1944a.removeCallbacks(remove);
        }
        this.f1995c.e(str);
    }

    @Override // b.z.y.p.c
    public void c(List<String> list) {
        for (String str : list) {
            m.c().a(j, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            k kVar = this.f1995c;
            a aVar = kVar.f1972d;
            ((b.z.y.s.s.b) aVar).f2183a.execute(new j(kVar, str, null));
        }
    }

    @Override // b.z.y.e
    public void d(p... pVarArr) {
        if (this.i == null) {
            this.i = Boolean.valueOf(h.a(this.f1994b, this.f1995c.f1970b));
        }
        if (!this.i.booleanValue()) {
            m.c().d(j, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.g) {
            this.f1995c.f.b(this);
            this.g = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long a2 = pVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (pVar.f2092b == u.ENQUEUED) {
                if (currentTimeMillis < a2) {
                    b bVar = this.f;
                    if (bVar != null) {
                        Runnable remove = bVar.f1993c.remove(pVar.f2091a);
                        if (remove != null) {
                            bVar.f1992b.f1944a.removeCallbacks(remove);
                        }
                        a aVar = new a(bVar, pVar);
                        bVar.f1993c.put(pVar.f2091a, aVar);
                        bVar.f1992b.f1944a.postDelayed(aVar, pVar.a() - System.currentTimeMillis());
                    }
                } else if (pVar.b()) {
                    int i2 = Build.VERSION.SDK_INT;
                    b.z.c cVar = pVar.j;
                    if (cVar.f1900c) {
                        m.c().a(j, String.format("Ignoring WorkSpec %s, Requires device idle.", pVar), new Throwable[0]);
                    } else {
                        if (i2 >= 24) {
                            if (cVar.h.a() > 0) {
                                m.c().a(j, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", pVar), new Throwable[0]);
                            }
                        }
                        hashSet.add(pVar);
                        hashSet2.add(pVar.f2091a);
                    }
                } else {
                    m.c().a(j, String.format("Starting work for %s", pVar.f2091a), new Throwable[0]);
                    k kVar = this.f1995c;
                    ((b.z.y.s.s.b) kVar.f1972d).f2183a.execute(new j(kVar, pVar.f2091a, null));
                }
            }
        }
        synchronized (this.h) {
            if (!hashSet.isEmpty()) {
                m.c().a(j, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f1997e.addAll(hashSet);
                this.f1996d.b(this.f1997e);
            }
        }
    }

    @Override // b.z.y.p.c
    public void e(List<String> list) {
        for (String str : list) {
            m.c().a(j, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f1995c.e(str);
        }
    }

    @Override // b.z.y.e
    public boolean f() {
        return false;
    }
}
