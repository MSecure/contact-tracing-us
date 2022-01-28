package b.b0.y.s;

import androidx.work.impl.WorkDatabase;
import b.b0.m;
import b.b0.p;
import b.b0.u;
import b.b0.y.d;
import b.b0.y.e;
import b.b0.y.k;
import b.b0.y.n;
import b.b0.y.r.b;
import b.b0.y.r.q;
import b.b0.y.r.r;
import java.util.LinkedList;

public abstract class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final b.b0.y.c f1259b = new b.b0.y.c();

    public void a(k kVar, String str) {
        boolean z;
        WorkDatabase workDatabase = kVar.f1096c;
        q h = workDatabase.h();
        b b2 = workDatabase.b();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (true) {
            z = false;
            if (linkedList.isEmpty()) {
                break;
            }
            String str2 = (String) linkedList.remove();
            r rVar = (r) h;
            u g2 = rVar.g(str2);
            if (!(g2 == u.SUCCEEDED || g2 == u.FAILED)) {
                rVar.p(u.CANCELLED, str2);
            }
            linkedList.addAll(((b.b0.y.r.c) b2).a(str2));
        }
        d dVar = kVar.f1099f;
        synchronized (dVar.l) {
            m.c().a(d.m, String.format("Processor cancelling %s", str), new Throwable[0]);
            dVar.j.add(str);
            n remove = dVar.f1072g.remove(str);
            if (remove != null) {
                z = true;
            }
            if (remove == null) {
                remove = dVar.h.remove(str);
            }
            d.c(str, remove);
            if (z) {
                dVar.h();
            }
        }
        for (e eVar : kVar.f1098e) {
            eVar.b(str);
        }
    }

    public abstract void b();

    public void run() {
        try {
            b();
            this.f1259b.a(p.f1047a);
        } catch (Throwable th) {
            this.f1259b.a(new p.b.a(th));
        }
    }
}
