package e.z.x.p.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import e.z.l;
import e.z.s;
import e.z.x.b;
import e.z.x.e;
import e.z.x.q.d;
import e.z.x.s.o;
import e.z.x.t.h;
import e.z.x.t.j;
import e.z.x.t.q.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c implements e, e.z.x.q.c, b {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1926j = l.e("GreedyScheduler");
    public final Context b;
    public final e.z.x.l c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1927d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<o> f1928e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public b f1929f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1930g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f1931h;

    /* renamed from: i  reason: collision with root package name */
    public Boolean f1932i;

    public c(Context context, e.z.b bVar, a aVar, e.z.x.l lVar) {
        this.b = context;
        this.c = lVar;
        this.f1927d = new d(context, aVar, this);
        this.f1929f = new b(this, bVar.f1856e);
        this.f1931h = new Object();
    }

    @Override // e.z.x.b
    public void a(String str, boolean z) {
        synchronized (this.f1931h) {
            Iterator<o> it = this.f1928e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next.a.equals(str)) {
                    l.c().a(f1926j, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f1928e.remove(next);
                    this.f1927d.b(this.f1928e);
                    break;
                }
            }
        }
    }

    @Override // e.z.x.e
    public void b(String str) {
        Runnable remove;
        if (this.f1932i == null) {
            this.f1932i = Boolean.valueOf(h.a(this.b, this.c.b));
        }
        if (!this.f1932i.booleanValue()) {
            l.c().d(f1926j, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.f1930g) {
            this.c.f1905f.b(this);
            this.f1930g = true;
        }
        l.c().a(f1926j, String.format("Cancelling work ID %s", str), new Throwable[0]);
        b bVar = this.f1929f;
        if (!(bVar == null || (remove = bVar.c.remove(str)) == null)) {
            bVar.b.a.removeCallbacks(remove);
        }
        this.c.i(str);
    }

    @Override // e.z.x.q.c
    public void c(List<String> list) {
        for (String str : list) {
            l.c().a(f1926j, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            e.z.x.l lVar = this.c;
            a aVar = lVar.f1903d;
            ((e.z.x.t.q.b) aVar).a.execute(new j(lVar, str, null));
        }
    }

    @Override // e.z.x.e
    public void d(o... oVarArr) {
        if (this.f1932i == null) {
            this.f1932i = Boolean.valueOf(h.a(this.b, this.c.b));
        }
        if (!this.f1932i.booleanValue()) {
            l.c().d(f1926j, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.f1930g) {
            this.c.f1905f.b(this);
            this.f1930g = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (o oVar : oVarArr) {
            long a = oVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (oVar.b == s.ENQUEUED) {
                if (currentTimeMillis < a) {
                    b bVar = this.f1929f;
                    if (bVar != null) {
                        Runnable remove = bVar.c.remove(oVar.a);
                        if (remove != null) {
                            bVar.b.a.removeCallbacks(remove);
                        }
                        a aVar = new a(bVar, oVar);
                        bVar.c.put(oVar.a, aVar);
                        bVar.b.a.postDelayed(aVar, oVar.a() - System.currentTimeMillis());
                    }
                } else if (oVar.b()) {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 < 23 || !oVar.f1994j.c) {
                        if (i2 >= 24) {
                            if (oVar.f1994j.f1865h.a() > 0) {
                                l.c().a(f1926j, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", oVar), new Throwable[0]);
                            }
                        }
                        hashSet.add(oVar);
                        hashSet2.add(oVar.a);
                    } else {
                        l.c().a(f1926j, String.format("Ignoring WorkSpec %s, Requires device idle.", oVar), new Throwable[0]);
                    }
                } else {
                    l.c().a(f1926j, String.format("Starting work for %s", oVar.a), new Throwable[0]);
                    e.z.x.l lVar = this.c;
                    ((e.z.x.t.q.b) lVar.f1903d).a.execute(new j(lVar, oVar.a, null));
                }
            }
        }
        synchronized (this.f1931h) {
            if (!hashSet.isEmpty()) {
                l.c().a(f1926j, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f1928e.addAll(hashSet);
                this.f1927d.b(this.f1928e);
            }
        }
    }

    @Override // e.z.x.q.c
    public void e(List<String> list) {
        for (String str : list) {
            l.c().a(f1926j, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.c.i(str);
        }
    }

    @Override // e.z.x.e
    public boolean f() {
        return false;
    }
}
