package b.b0.y.o.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import b.b0.m;
import b.b0.u;
import b.b0.y.b;
import b.b0.y.e;
import b.b0.y.k;
import b.b0.y.p.d;
import b.b0.y.r.p;
import b.b0.y.s.h;
import b.b0.y.s.j;
import b.b0.y.s.s.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c implements e, b.b0.y.p.c, b {
    public static final String j = m.e("GreedyScheduler");

    /* renamed from: b  reason: collision with root package name */
    public final Context f1125b;

    /* renamed from: c  reason: collision with root package name */
    public final k f1126c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1127d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<p> f1128e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public b f1129f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1130g;
    public final Object h;
    public Boolean i;

    public c(Context context, b.b0.b bVar, a aVar, k kVar) {
        this.f1125b = context;
        this.f1126c = kVar;
        this.f1127d = new d(context, aVar, this);
        this.f1129f = new b(this, bVar.f1001e);
        this.h = new Object();
    }

    @Override // b.b0.y.b
    public void a(String str, boolean z) {
        synchronized (this.h) {
            Iterator<p> it = this.f1128e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                if (next.f1234a.equals(str)) {
                    m.c().a(j, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f1128e.remove(next);
                    this.f1127d.b(this.f1128e);
                    break;
                }
            }
        }
    }

    @Override // b.b0.y.e
    public void b(String str) {
        Runnable remove;
        if (this.i == null) {
            this.i = Boolean.valueOf(h.a(this.f1125b, this.f1126c.f1095b));
        }
        if (!this.i.booleanValue()) {
            m.c().d(j, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.f1130g) {
            this.f1126c.f1099f.b(this);
            this.f1130g = true;
        }
        m.c().a(j, String.format("Cancelling work ID %s", str), new Throwable[0]);
        b bVar = this.f1129f;
        if (!(bVar == null || (remove = bVar.f1124c.remove(str)) == null)) {
            bVar.f1123b.f1064a.removeCallbacks(remove);
        }
        this.f1126c.e(str);
    }

    @Override // b.b0.y.p.c
    public void c(List<String> list) {
        for (String str : list) {
            m.c().a(j, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            k kVar = this.f1126c;
            a aVar = kVar.f1097d;
            ((b.b0.y.s.s.b) aVar).f1334a.execute(new j(kVar, str, null));
        }
    }

    @Override // b.b0.y.e
    public void d(p... pVarArr) {
        if (this.i == null) {
            this.i = Boolean.valueOf(h.a(this.f1125b, this.f1126c.f1095b));
        }
        if (!this.i.booleanValue()) {
            m.c().d(j, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.f1130g) {
            this.f1126c.f1099f.b(this);
            this.f1130g = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long a2 = pVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (pVar.f1235b == u.ENQUEUED) {
                if (currentTimeMillis < a2) {
                    b bVar = this.f1129f;
                    if (bVar != null) {
                        Runnable remove = bVar.f1124c.remove(pVar.f1234a);
                        if (remove != null) {
                            bVar.f1123b.f1064a.removeCallbacks(remove);
                        }
                        a aVar = new a(bVar, pVar);
                        bVar.f1124c.put(pVar.f1234a, aVar);
                        bVar.f1123b.f1064a.postDelayed(aVar, pVar.a() - System.currentTimeMillis());
                    }
                } else if (pVar.b()) {
                    int i2 = Build.VERSION.SDK_INT;
                    b.b0.c cVar = pVar.j;
                    if (cVar.f1011c) {
                        m.c().a(j, String.format("Ignoring WorkSpec %s, Requires device idle.", pVar), new Throwable[0]);
                    } else {
                        if (i2 >= 24) {
                            if (cVar.h.a() > 0) {
                                m.c().a(j, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", pVar), new Throwable[0]);
                            }
                        }
                        hashSet.add(pVar);
                        hashSet2.add(pVar.f1234a);
                    }
                } else {
                    m.c().a(j, String.format("Starting work for %s", pVar.f1234a), new Throwable[0]);
                    k kVar = this.f1126c;
                    ((b.b0.y.s.s.b) kVar.f1097d).f1334a.execute(new j(kVar, pVar.f1234a, null));
                }
            }
        }
        synchronized (this.h) {
            if (!hashSet.isEmpty()) {
                m.c().a(j, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f1128e.addAll(hashSet);
                this.f1127d.b(this.f1128e);
            }
        }
    }

    @Override // b.b0.y.p.c
    public void e(List<String> list) {
        for (String str : list) {
            m.c().a(j, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f1126c.e(str);
        }
    }

    @Override // b.b0.y.e
    public boolean f() {
        return false;
    }
}
