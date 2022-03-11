package e.b0.x.p.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import e.b0.l;
import e.b0.s;
import e.b0.x.b;
import e.b0.x.e;
import e.b0.x.q.d;
import e.b0.x.s.o;
import e.b0.x.t.h;
import e.b0.x.t.j;
import e.b0.x.t.q.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c implements e, e.b0.x.q.c, b {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1051j = l.e("GreedyScheduler");
    public final Context b;
    public final e.b0.x.l c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1052d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<o> f1053e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public b f1054f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1055g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f1056h;

    /* renamed from: i  reason: collision with root package name */
    public Boolean f1057i;

    public c(Context context, e.b0.b bVar, a aVar, e.b0.x.l lVar) {
        this.b = context;
        this.c = lVar;
        this.f1052d = new d(context, aVar, this);
        this.f1054f = new b(this, bVar.f981e);
        this.f1056h = new Object();
    }

    @Override // e.b0.x.b
    public void a(String str, boolean z) {
        synchronized (this.f1056h) {
            Iterator<o> it = this.f1053e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next.a.equals(str)) {
                    l.c().a(f1051j, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f1053e.remove(next);
                    this.f1052d.b(this.f1053e);
                    break;
                }
            }
        }
    }

    @Override // e.b0.x.e
    public void b(String str) {
        Runnable remove;
        if (this.f1057i == null) {
            this.f1057i = Boolean.valueOf(h.a(this.b, this.c.b));
        }
        if (!this.f1057i.booleanValue()) {
            l.c().d(f1051j, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.f1055g) {
            this.c.f1030f.b(this);
            this.f1055g = true;
        }
        l.c().a(f1051j, String.format("Cancelling work ID %s", str), new Throwable[0]);
        b bVar = this.f1054f;
        if (!(bVar == null || (remove = bVar.c.remove(str)) == null)) {
            bVar.b.a.removeCallbacks(remove);
        }
        this.c.g(str);
    }

    @Override // e.b0.x.q.c
    public void c(List<String> list) {
        for (String str : list) {
            l.c().a(f1051j, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            e.b0.x.l lVar = this.c;
            a aVar = lVar.f1028d;
            ((e.b0.x.t.q.b) aVar).a.execute(new j(lVar, str, null));
        }
    }

    @Override // e.b0.x.e
    public void d(o... oVarArr) {
        if (this.f1057i == null) {
            this.f1057i = Boolean.valueOf(h.a(this.b, this.c.b));
        }
        if (!this.f1057i.booleanValue()) {
            l.c().d(f1051j, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.f1055g) {
            this.c.f1030f.b(this);
            this.f1055g = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (o oVar : oVarArr) {
            long a = oVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (oVar.b == s.ENQUEUED) {
                if (currentTimeMillis < a) {
                    b bVar = this.f1054f;
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
                    if (i2 < 23 || !oVar.f1119j.c) {
                        if (i2 >= 24) {
                            if (oVar.f1119j.f990h.a() > 0) {
                                l.c().a(f1051j, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", oVar), new Throwable[0]);
                            }
                        }
                        hashSet.add(oVar);
                        hashSet2.add(oVar.a);
                    } else {
                        l.c().a(f1051j, String.format("Ignoring WorkSpec %s, Requires device idle.", oVar), new Throwable[0]);
                    }
                } else {
                    l.c().a(f1051j, String.format("Starting work for %s", oVar.a), new Throwable[0]);
                    e.b0.x.l lVar = this.c;
                    ((e.b0.x.t.q.b) lVar.f1028d).a.execute(new j(lVar, oVar.a, null));
                }
            }
        }
        synchronized (this.f1056h) {
            if (!hashSet.isEmpty()) {
                l.c().a(f1051j, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f1053e.addAll(hashSet);
                this.f1052d.b(this.f1053e);
            }
        }
    }

    @Override // e.b0.x.q.c
    public void e(List<String> list) {
        for (String str : list) {
            l.c().a(f1051j, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.c.g(str);
        }
    }

    @Override // e.b0.x.e
    public boolean f() {
        return false;
    }
}
