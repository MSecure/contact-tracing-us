package e.c0.x.t;

import androidx.work.impl.WorkDatabase;
import e.c0.o;
import e.c0.s;
import e.c0.x.d;
import e.c0.x.e;
import e.c0.x.l;
import e.c0.x.o;
import e.c0.x.s.b;
import e.c0.x.s.p;
import e.c0.x.s.q;
import java.util.LinkedList;

public abstract class c implements Runnable {
    public final e.c0.x.c b = new e.c0.x.c();

    public void a(l lVar, String str) {
        boolean z;
        WorkDatabase workDatabase = lVar.c;
        p r = workDatabase.r();
        b m = workDatabase.m();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (true) {
            z = true;
            if (linkedList.isEmpty()) {
                break;
            }
            String str2 = (String) linkedList.remove();
            q qVar = (q) r;
            s g2 = qVar.g(str2);
            if (!(g2 == s.SUCCEEDED || g2 == s.FAILED)) {
                qVar.p(s.CANCELLED, str2);
            }
            linkedList.addAll(((e.c0.x.s.c) m).a(str2));
        }
        d dVar = lVar.f1050f;
        synchronized (dVar.f1034k) {
            e.c0.l.c().a(d.f1026l, String.format("Processor cancelling %s", str), new Throwable[0]);
            dVar.f1032i.add(str);
            o remove = dVar.f1029f.remove(str);
            if (remove == null) {
                z = false;
            }
            if (remove == null) {
                remove = dVar.f1030g.remove(str);
            }
            d.c(str, remove);
            if (z) {
                dVar.g();
            }
        }
        for (e eVar : lVar.f1049e) {
            eVar.b(str);
        }
    }

    public abstract void b();

    public void run() {
        try {
            b();
            this.b.a(e.c0.o.a);
        } catch (Throwable th) {
            this.b.a(new o.b.a(th));
        }
    }
}
