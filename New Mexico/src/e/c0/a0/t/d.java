package e.c0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.c0.a0.c;
import e.c0.a0.e;
import e.c0.a0.l;
import e.c0.a0.o;
import e.c0.a0.s.b;
import e.c0.a0.s.p;
import e.c0.a0.s.q;
import e.c0.n;
import e.c0.q;
import e.c0.v;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class d implements Runnable {
    public final c b = new c();

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
            v g2 = qVar.g(str2);
            if (!(g2 == v.SUCCEEDED || g2 == v.FAILED)) {
                qVar.p(v.CANCELLED, str2);
            }
            linkedList.addAll(((e.c0.a0.s.c) m).a(str2));
        }
        e.c0.a0.d dVar = lVar.f1108f;
        synchronized (dVar.f1090l) {
            n.c().a(e.c0.a0.d.m, String.format("Processor cancelling %s", str), new Throwable[0]);
            dVar.f1088j.add(str);
            o remove = dVar.f1085g.remove(str);
            if (remove == null) {
                z = false;
            }
            if (remove == null) {
                remove = dVar.f1086h.remove(str);
            }
            e.c0.a0.d.c(str, remove);
            if (z) {
                dVar.h();
            }
        }
        for (e eVar : lVar.f1107e) {
            eVar.b(str);
        }
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public void run() {
        try {
            b();
            this.b.a(e.c0.q.a);
        } catch (Throwable th) {
            this.b.a(new q.b.a(th));
        }
    }
}
