package e.z.x.t;

import androidx.work.impl.WorkDatabase;
import e.z.o;
import e.z.s;
import e.z.x.d;
import e.z.x.e;
import e.z.x.l;
import e.z.x.o;
import e.z.x.s.b;
import e.z.x.s.p;
import e.z.x.s.q;
import java.util.LinkedList;

public abstract class c implements Runnable {
    public final e.z.x.c b = new e.z.x.c();

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
            linkedList.addAll(((e.z.x.s.c) m).a(str2));
        }
        d dVar = lVar.f1905f;
        synchronized (dVar.f1889k) {
            e.z.l.c().a(d.f1881l, String.format("Processor cancelling %s", str), new Throwable[0]);
            dVar.f1887i.add(str);
            o remove = dVar.f1884f.remove(str);
            if (remove == null) {
                z = false;
            }
            if (remove == null) {
                remove = dVar.f1885g.remove(str);
            }
            d.c(str, remove);
            if (z) {
                dVar.g();
            }
        }
        for (e eVar : lVar.f1904e) {
            eVar.b(str);
        }
    }

    public abstract void b();

    public void run() {
        try {
            b();
            this.b.a(e.z.o.a);
        } catch (Throwable th) {
            this.b.a(new o.b.a(th));
        }
    }
}
