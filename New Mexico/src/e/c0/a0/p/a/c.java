package e.c0.a0.p.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import e.c0.a0.b;
import e.c0.a0.e;
import e.c0.a0.l;
import e.c0.a0.q.d;
import e.c0.a0.s.o;
import e.c0.a0.t.i;
import e.c0.a0.t.k;
import e.c0.a0.t.t.a;
import e.c0.n;
import e.c0.v;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class c implements e, e.c0.a0.q.c, b {

    /* renamed from: j */
    public static final String f1129j = n.e("GreedyScheduler");
    public final Context b;
    public final l c;

    /* renamed from: d */
    public final d f1130d;

    /* renamed from: f */
    public b f1132f;

    /* renamed from: g */
    public boolean f1133g;

    /* renamed from: i */
    public Boolean f1135i;

    /* renamed from: e */
    public final Set<o> f1131e = new HashSet();

    /* renamed from: h */
    public final Object f1134h = new Object();

    public c(Context context, e.c0.c cVar, a aVar, l lVar) {
        this.b = context;
        this.c = lVar;
        this.f1130d = new d(context, aVar, this);
        this.f1132f = new b(this, cVar.f1236e);
    }

    @Override // e.c0.a0.b
    public void a(String str, boolean z) {
        synchronized (this.f1134h) {
            Iterator<o> it = this.f1131e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next.a.equals(str)) {
                    n.c().a(f1129j, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f1131e.remove(next);
                    this.f1130d.b(this.f1131e);
                    break;
                }
            }
        }
    }

    @Override // e.c0.a0.e
    public void b(String str) {
        Runnable remove;
        if (this.f1135i == null) {
            this.f1135i = Boolean.valueOf(i.a(this.b, this.c.b));
        }
        if (!this.f1135i.booleanValue()) {
            n.c().d(f1129j, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.f1133g) {
            this.c.f1108f.b(this);
            this.f1133g = true;
        }
        n.c().a(f1129j, String.format("Cancelling work ID %s", str), new Throwable[0]);
        b bVar = this.f1132f;
        if (!(bVar == null || (remove = bVar.c.remove(str)) == null)) {
            bVar.b.a.removeCallbacks(remove);
        }
        this.c.l(str);
    }

    @Override // e.c0.a0.q.c
    public void c(List<String> list) {
        for (String str : list) {
            n.c().a(f1129j, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            l lVar = this.c;
            ((e.c0.a0.t.t.b) lVar.f1106d).a.execute(new k(lVar, str, null));
        }
    }

    @Override // e.c0.a0.e
    public void d(o... oVarArr) {
        if (this.f1135i == null) {
            this.f1135i = Boolean.valueOf(i.a(this.b, this.c.b));
        }
        if (!this.f1135i.booleanValue()) {
            n.c().d(f1129j, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.f1133g) {
            this.c.f1108f.b(this);
            this.f1133g = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (o oVar : oVarArr) {
            long a = oVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (oVar.b == v.ENQUEUED) {
                if (currentTimeMillis < a) {
                    b bVar = this.f1132f;
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
                    if (i2 >= 23 && oVar.f1197j.c) {
                        n.c().a(f1129j, String.format("Ignoring WorkSpec %s, Requires device idle.", oVar), new Throwable[0]);
                    } else if (i2 < 24 || !oVar.f1197j.a()) {
                        hashSet.add(oVar);
                        hashSet2.add(oVar.a);
                    } else {
                        n.c().a(f1129j, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", oVar), new Throwable[0]);
                    }
                } else {
                    n.c().a(f1129j, String.format("Starting work for %s", oVar.a), new Throwable[0]);
                    l lVar = this.c;
                    ((e.c0.a0.t.t.b) lVar.f1106d).a.execute(new k(lVar, oVar.a, null));
                }
            }
        }
        synchronized (this.f1134h) {
            if (!hashSet.isEmpty()) {
                n.c().a(f1129j, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f1131e.addAll(hashSet);
                this.f1130d.b(this.f1131e);
            }
        }
    }

    @Override // e.c0.a0.q.c
    public void e(List<String> list) {
        for (String str : list) {
            n.c().a(f1129j, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.c.l(str);
        }
    }

    @Override // e.c0.a0.e
    public boolean f() {
        return false;
    }
}
