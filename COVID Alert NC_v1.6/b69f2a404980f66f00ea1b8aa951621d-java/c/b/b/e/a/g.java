package c.b.b.e.a;

import c.b.b.b.b;
import c.b.b.b.c;
import c.b.b.b.e;
import c.b.b.e.a.b;
import c.b.b.e.a.j;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class g<InputT, OutputT> extends h<OutputT> {
    public static final Logger p = Logger.getLogger(g.class.getName());
    public b<? extends u<? extends InputT>> m;
    public final boolean n;
    public final boolean o;

    public g(b<? extends u<? extends InputT>> bVar, boolean z, boolean z2) {
        super(bVar.size());
        this.m = bVar;
        this.n = z;
        this.o = z2;
    }

    public static void q(g gVar, b bVar) {
        if (gVar != null) {
            int b2 = h.k.b(gVar);
            int i = 0;
            if (!(b2 >= 0)) {
                throw new IllegalStateException("Less than 0 remaining futures");
            } else if (b2 == 0) {
                if (bVar != null) {
                    e u = ((c) bVar).listIterator();
                    while (u.hasNext()) {
                        Future<? extends InputT> future = (Future) u.next();
                        if (!future.isCancelled()) {
                            gVar.s(i, future);
                        }
                        i++;
                    }
                }
                gVar.i = null;
                gVar.t();
                j jVar = (j) gVar;
                jVar.m = null;
                jVar.q = null;
            }
        } else {
            throw null;
        }
    }

    public static boolean r(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // c.b.b.e.a.b
    public final void c() {
        b<? extends u<? extends InputT>> bVar = this.m;
        j jVar = (j) this;
        jVar.m = null;
        jVar.q = null;
        if ((this.f3368b instanceof b.c) && (bVar != null)) {
            boolean p2 = p();
            e u = ((c) bVar).listIterator();
            while (u.hasNext()) {
                ((Future) u.next()).cancel(p2);
            }
        }
    }

    @Override // c.b.b.e.a.b
    public final String k() {
        c.b.b.b.b<? extends u<? extends InputT>> bVar = this.m;
        if (bVar == null) {
            return super.k();
        }
        return "futures=" + bVar;
    }

    public final void s(int i, Future<? extends InputT> future) {
        Throwable th;
        try {
            Object c1 = c.b.a.a.c.n.c.c1(future);
            List<j.b<V>> list = ((j) this).q;
            if (list != null) {
                list.set(i, new j.b<>(c1));
            }
        } catch (ExecutionException e2) {
            th = e2.getCause();
            u(th);
        } catch (Throwable th2) {
            th = th2;
            u(th);
        }
    }

    public abstract void t();

    public final void u(Throwable th) {
        if (th != null) {
            String str = "Input Future failed with Error";
            if (this.n && !n(th)) {
                Set<Throwable> set = this.i;
                if (set == null) {
                    Set<Throwable> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
                    if (newSetFromMap != null) {
                        if (!(this.f3368b instanceof b.c)) {
                            Object obj = this.f3368b;
                            r(newSetFromMap, obj instanceof b.d ? ((b.d) obj).f3376a : null);
                        }
                        h.k.a(this, null, newSetFromMap);
                        set = this.i;
                    } else {
                        throw null;
                    }
                }
                if (r(set, th)) {
                    if (!(th instanceof Error)) {
                        str = "Got more than one input Future failure. Logging failures after the first";
                    }
                    p.log(Level.SEVERE, str, th);
                    return;
                }
            }
            boolean z = th instanceof Error;
            if (z) {
                if (!z) {
                    str = "Got more than one input Future failure. Logging failures after the first";
                }
                p.log(Level.SEVERE, str, th);
                return;
            }
            return;
        }
        throw null;
    }
}
