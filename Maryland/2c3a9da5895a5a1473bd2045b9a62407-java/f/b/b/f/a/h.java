package f.b.b.f.a;

import f.b.b.f.a.b;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class h<OutputT> extends b.j<OutputT> {

    /* renamed from: k  reason: collision with root package name */
    public static final b f3040k;

    /* renamed from: l  reason: collision with root package name */
    public static final Logger f3041l = Logger.getLogger(h.class.getName());

    /* renamed from: i  reason: collision with root package name */
    private volatile Set<Throwable> f3042i = null;

    /* renamed from: j  reason: collision with root package name */
    private volatile int f3043j;

    public static abstract class b {
        public b(a aVar) {
        }

        public abstract void a(h hVar, Set<Throwable> set, Set<Throwable> set2);

        public abstract int b(h hVar);
    }

    public static final class c extends b {
        public final AtomicReferenceFieldUpdater<h, Set<Throwable>> a;
        public final AtomicIntegerFieldUpdater<h> b;

        public c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        @Override // f.b.b.f.a.h.b
        public void a(h hVar, Set<Throwable> set, Set<Throwable> set2) {
            this.a.compareAndSet(hVar, null, set2);
        }

        @Override // f.b.b.f.a.h.b
        public int b(h hVar) {
            return this.b.decrementAndGet(hVar);
        }
    }

    public static final class d extends b {
        public d(a aVar) {
            super(null);
        }

        @Override // f.b.b.f.a.h.b
        public void a(h hVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (hVar) {
                if (hVar.f3042i == null) {
                    hVar.f3042i = set2;
                }
            }
        }

        @Override // f.b.b.f.a.h.b
        public int b(h hVar) {
            int z;
            synchronized (hVar) {
                z = h.z(hVar);
            }
            return z;
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
        f3040k = bVar;
        if (th != null) {
            f3041l.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public h(int i2) {
        this.f3043j = i2;
    }

    public static /* synthetic */ int z(h hVar) {
        int i2 = hVar.f3043j - 1;
        hVar.f3043j = i2;
        return i2;
    }

    public abstract void A(Set<Throwable> set);

    public final void B() {
        this.f3042i = null;
    }

    public final Set<Throwable> C() {
        Set<Throwable> set = this.f3042i;
        if (set != null) {
            return set;
        }
        Set<Throwable> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        A(newSetFromMap);
        f3040k.a(this, null, newSetFromMap);
        return this.f3042i;
    }
}
