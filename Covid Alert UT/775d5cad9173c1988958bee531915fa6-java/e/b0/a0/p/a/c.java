package e.b0.a0.p.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import e.b0.a0.b;
import e.b0.a0.e;
import e.b0.a0.l;
import e.b0.a0.q.d;
import e.b0.a0.s.o;
import e.b0.a0.t.i;
import e.b0.a0.t.k;
import e.b0.a0.t.t.a;
import e.b0.n;
import e.b0.v;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c implements e, e.b0.a0.q.c, b {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1050j = n.e("GreedyScheduler");
    public final Context b;
    public final l c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1051d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<o> f1052e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public b f1053f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1054g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f1055h;

    /* renamed from: i  reason: collision with root package name */
    public Boolean f1056i;

    public c(Context context, e.b0.c cVar, a aVar, l lVar) {
        this.b = context;
        this.c = lVar;
        this.f1051d = new d(context, aVar, this);
        this.f1053f = new b(this, cVar.f1157e);
        this.f1055h = new Object();
    }

    @Override // e.b0.a0.b
    public void a(String str, boolean z) {
        synchronized (this.f1055h) {
            Iterator<o> it = this.f1052e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next.a.equals(str)) {
                    n.c().a(f1050j, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f1052e.remove(next);
                    this.f1051d.b(this.f1052e);
                    break;
                }
            }
        }
    }

    @Override // e.b0.a0.e
    public void b(String str) {
        Runnable remove;
        if (this.f1056i == null) {
            this.f1056i = Boolean.valueOf(i.a(this.b, this.c.b));
        }
        if (!this.f1056i.booleanValue()) {
            n.c().d(f1050j, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.f1054g) {
            this.c.f1029f.b(this);
            this.f1054g = true;
        }
        n.c().a(f1050j, String.format("Cancelling work ID %s", str), new Throwable[0]);
        b bVar = this.f1053f;
        if (!(bVar == null || (remove = bVar.c.remove(str)) == null)) {
            bVar.b.a.removeCallbacks(remove);
        }
        this.c.k(str);
    }

    @Override // e.b0.a0.q.c
    public void c(List<String> list) {
        for (String str : list) {
            n.c().a(f1050j, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            l lVar = this.c;
            a aVar = lVar.f1027d;
            ((e.b0.a0.t.t.b) aVar).a.execute(new k(lVar, str, null));
        }
    }

    @Override // e.b0.a0.e
    public void d(o... oVarArr) {
        if (this.f1056i == null) {
            this.f1056i = Boolean.valueOf(i.a(this.b, this.c.b));
        }
        if (!this.f1056i.booleanValue()) {
            n.c().d(f1050j, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.f1054g) {
            this.c.f1029f.b(this);
            this.f1054g = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (o oVar : oVarArr) {
            long a = oVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (oVar.b == v.ENQUEUED) {
                if (currentTimeMillis < a) {
                    b bVar = this.f1053f;
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
                    if (i2 >= 23 && oVar.f1118j.c) {
                        n.c().a(f1050j, String.format("Ignoring WorkSpec %s, Requires device idle.", oVar), new Throwable[0]);
                    } else if (i2 < 24 || !oVar.f1118j.a()) {
                        hashSet.add(oVar);
                        hashSet2.add(oVar.a);
                    } else {
                        n.c().a(f1050j, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", oVar), new Throwable[0]);
                    }
                } else {
                    n.c().a(f1050j, String.format("Starting work for %s", oVar.a), new Throwable[0]);
                    l lVar = this.c;
                    String str = oVar.a;
                    ((e.b0.a0.t.t.b) lVar.f1027d).a.execute(new k(lVar, str, null));
                }
            }
        }
        synchronized (this.f1055h) {
            if (!hashSet.isEmpty()) {
                n.c().a(f1050j, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f1052e.addAll(hashSet);
                this.f1051d.b(this.f1052e);
            }
        }
    }

    @Override // e.b0.a0.q.c
    public void e(List<String> list) {
        for (String str : list) {
            n.c().a(f1050j, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.c.k(str);
        }
    }

    @Override // e.b0.a0.e
    public boolean f() {
        return false;
    }
}
