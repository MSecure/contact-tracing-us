package e.c0.x.p.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import e.c0.l;
import e.c0.s;
import e.c0.x.b;
import e.c0.x.e;
import e.c0.x.q.d;
import e.c0.x.s.o;
import e.c0.x.t.h;
import e.c0.x.t.j;
import e.c0.x.t.q.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c implements e, e.c0.x.q.c, b {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1071j = l.e("GreedyScheduler");
    public final Context b;
    public final e.c0.x.l c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1072d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<o> f1073e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public b f1074f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1075g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f1076h;

    /* renamed from: i  reason: collision with root package name */
    public Boolean f1077i;

    public c(Context context, e.c0.b bVar, a aVar, e.c0.x.l lVar) {
        this.b = context;
        this.c = lVar;
        this.f1072d = new d(context, aVar, this);
        this.f1074f = new b(this, bVar.f1001e);
        this.f1076h = new Object();
    }

    @Override // e.c0.x.b
    public void a(String str, boolean z) {
        synchronized (this.f1076h) {
            Iterator<o> it = this.f1073e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next.a.equals(str)) {
                    l.c().a(f1071j, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f1073e.remove(next);
                    this.f1072d.b(this.f1073e);
                    break;
                }
            }
        }
    }

    @Override // e.c0.x.e
    public void b(String str) {
        Runnable remove;
        if (this.f1077i == null) {
            this.f1077i = Boolean.valueOf(h.a(this.b, this.c.b));
        }
        if (!this.f1077i.booleanValue()) {
            l.c().d(f1071j, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.f1075g) {
            this.c.f1050f.b(this);
            this.f1075g = true;
        }
        l.c().a(f1071j, String.format("Cancelling work ID %s", str), new Throwable[0]);
        b bVar = this.f1074f;
        if (!(bVar == null || (remove = bVar.c.remove(str)) == null)) {
            bVar.b.a.removeCallbacks(remove);
        }
        this.c.g(str);
    }

    @Override // e.c0.x.q.c
    public void c(List<String> list) {
        for (String str : list) {
            l.c().a(f1071j, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            e.c0.x.l lVar = this.c;
            a aVar = lVar.f1048d;
            ((e.c0.x.t.q.b) aVar).a.execute(new j(lVar, str, null));
        }
    }

    @Override // e.c0.x.e
    public void d(o... oVarArr) {
        if (this.f1077i == null) {
            this.f1077i = Boolean.valueOf(h.a(this.b, this.c.b));
        }
        if (!this.f1077i.booleanValue()) {
            l.c().d(f1071j, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.f1075g) {
            this.c.f1050f.b(this);
            this.f1075g = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (o oVar : oVarArr) {
            long a = oVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (oVar.b == s.ENQUEUED) {
                if (currentTimeMillis < a) {
                    b bVar = this.f1074f;
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
                    if (i2 < 23 || !oVar.f1139j.c) {
                        if (i2 >= 24) {
                            if (oVar.f1139j.f1010h.a() > 0) {
                                l.c().a(f1071j, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", oVar), new Throwable[0]);
                            }
                        }
                        hashSet.add(oVar);
                        hashSet2.add(oVar.a);
                    } else {
                        l.c().a(f1071j, String.format("Ignoring WorkSpec %s, Requires device idle.", oVar), new Throwable[0]);
                    }
                } else {
                    l.c().a(f1071j, String.format("Starting work for %s", oVar.a), new Throwable[0]);
                    e.c0.x.l lVar = this.c;
                    ((e.c0.x.t.q.b) lVar.f1048d).a.execute(new j(lVar, oVar.a, null));
                }
            }
        }
        synchronized (this.f1076h) {
            if (!hashSet.isEmpty()) {
                l.c().a(f1071j, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f1073e.addAll(hashSet);
                this.f1072d.b(this.f1073e);
            }
        }
    }

    @Override // e.c0.x.q.c
    public void e(List<String> list) {
        for (String str : list) {
            l.c().a(f1071j, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.c.g(str);
        }
    }

    @Override // e.c0.x.e
    public boolean f() {
        return false;
    }
}
