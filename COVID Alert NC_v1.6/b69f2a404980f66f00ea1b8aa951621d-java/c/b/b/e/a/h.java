package c.b.b.e.a;

import c.b.b.e.a.b;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class h<OutputT> extends b.j<OutputT> {
    public static final b k;
    public static final Logger l = Logger.getLogger(h.class.getName());
    public volatile Set<Throwable> i = null;
    public volatile int j;

    public static abstract class b {
        public b(a aVar) {
        }

        public abstract void a(h hVar, Set<Throwable> set, Set<Throwable> set2);

        public abstract int b(h hVar);
    }

    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Set<Throwable>> f3403a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicIntegerFieldUpdater<h> f3404b;

        public c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super(null);
            this.f3403a = atomicReferenceFieldUpdater;
            this.f3404b = atomicIntegerFieldUpdater;
        }

        @Override // c.b.b.e.a.h.b
        public void a(h hVar, Set<Throwable> set, Set<Throwable> set2) {
            this.f3403a.compareAndSet(hVar, null, set2);
        }

        @Override // c.b.b.e.a.h.b
        public int b(h hVar) {
            return this.f3404b.decrementAndGet(hVar);
        }
    }

    public static final class d extends b {
        public d(a aVar) {
            super(null);
        }

        @Override // c.b.b.e.a.h.b
        public void a(h hVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (hVar) {
                if (hVar.i == null) {
                    hVar.i = set2;
                }
            }
        }

        @Override // c.b.b.e.a.h.b
        public int b(h hVar) {
            int i;
            synchronized (hVar) {
                i = hVar.j - 1;
                hVar.j = i;
            }
            return i;
        }
    }

    static {
        b bVar;
        Throwable th = null;
        try {
            bVar = new c(AtomicReferenceFieldUpdater.newUpdater(h.class, Set.class, "i"), AtomicIntegerFieldUpdater.newUpdater(h.class, "j"));
        } catch (Throwable th2) {
            th = th2;
            bVar = new d(null);
        }
        k = bVar;
        if (th != null) {
            l.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public h(int i2) {
        this.j = i2;
    }
}
