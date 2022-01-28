package b.z.y.s;

import androidx.work.impl.WorkDatabase;
import b.z.m;
import b.z.p;
import b.z.u;
import b.z.y.d;
import b.z.y.e;
import b.z.y.k;
import b.z.y.n;
import b.z.y.r.b;
import b.z.y.r.q;
import b.z.y.r.r;
import java.util.LinkedList;

public abstract class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final b.z.y.c f2112b = new b.z.y.c();

    public void a(k kVar, String str) {
        boolean z;
        WorkDatabase workDatabase = kVar.f1971c;
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
            u g = rVar.g(str2);
            if (!(g == u.SUCCEEDED || g == u.FAILED)) {
                rVar.p(u.CANCELLED, str2);
            }
            linkedList.addAll(((b.z.y.r.c) b2).a(str2));
        }
        d dVar = kVar.f;
        synchronized (dVar.l) {
            m.c().a(d.m, String.format("Processor cancelling %s", str), new Throwable[0]);
            dVar.j.add(str);
            n remove = dVar.g.remove(str);
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
        for (e eVar : kVar.f1973e) {
            eVar.b(str);
        }
    }

    public abstract void b();

    public void run() {
        try {
            b();
            this.f2112b.a(p.f1929a);
        } catch (Throwable th) {
            this.f2112b.a(new p.b.a(th));
        }
    }
}
