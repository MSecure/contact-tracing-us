package androidx.lifecycle;

import e.p.g;
import e.p.h;
import e.p.j;
import e.p.k;
import e.p.r;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: k  reason: collision with root package name */
    public static final Object f161k = new Object();
    public final Object a;
    public e.c.a.b.b<r<? super T>, LiveData<T>.c> b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f162d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f163e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Object f164f;

    /* renamed from: g  reason: collision with root package name */
    public int f165g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f166h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f167i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f168j;

    public class LifecycleBoundObserver extends LiveData<T>.c implements h {

        /* renamed from: e  reason: collision with root package name */
        public final j f169e;

        public LifecycleBoundObserver(j jVar, r<? super T> rVar) {
            super(rVar);
            this.f169e = jVar;
        }

        @Override // e.p.h
        public void d(j jVar, g.a aVar) {
            g.b bVar = ((k) this.f169e.a()).b;
            if (bVar == g.b.DESTROYED) {
                LiveData.this.k(this.a);
                return;
            }
            g.b bVar2 = null;
            while (bVar2 != bVar) {
                h(k());
                bVar2 = bVar;
                bVar = ((k) this.f169e.a()).b;
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        public void i() {
            k kVar = (k) this.f169e.a();
            kVar.d("removeObserver");
            kVar.a.l(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean j(j jVar) {
            return this.f169e == jVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return ((k) this.f169e.a()).b.compareTo(g.b.STARTED) >= 0;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.LiveData */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            Object obj;
            synchronized (LiveData.this.a) {
                obj = LiveData.this.f164f;
                LiveData.this.f164f = LiveData.f161k;
            }
            LiveData.this.l(obj);
        }
    }

    public class b extends LiveData<T>.c {
        public b(LiveData liveData, r<? super T> rVar) {
            super(rVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return true;
        }
    }

    public abstract class c {
        public final r<? super T> a;
        public boolean b;
        public int c = -1;

        public c(r<? super T> rVar) {
            this.a = rVar;
        }

        public void h(boolean z) {
            if (z != this.b) {
                this.b = z;
                LiveData liveData = LiveData.this;
                int i2 = z ? 1 : -1;
                int i3 = liveData.c;
                liveData.c = i2 + i3;
                if (!liveData.f162d) {
                    liveData.f162d = true;
                    while (true) {
                        try {
                            int i4 = liveData.c;
                            if (i3 == i4) {
                                break;
                            }
                            boolean z2 = i3 == 0 && i4 > 0;
                            boolean z3 = i3 > 0 && i4 == 0;
                            if (z2) {
                                liveData.h();
                            } else if (z3) {
                                liveData.i();
                            }
                            i3 = i4;
                        } finally {
                            liveData.f162d = false;
                        }
                    }
                }
                if (this.b) {
                    LiveData.this.c(this);
                }
            }
        }

        public void i() {
        }

        public boolean j(j jVar) {
            return false;
        }

        public abstract boolean k();
    }

    public LiveData() {
        this.a = new Object();
        this.b = new e.c.a.b.b<>();
        this.c = 0;
        Object obj = f161k;
        this.f164f = obj;
        this.f168j = new a();
        this.f163e = obj;
        this.f165g = -1;
    }

    public LiveData(T t) {
        this.a = new Object();
        this.b = new e.c.a.b.b<>();
        this.c = 0;
        this.f164f = f161k;
        this.f168j = new a();
        this.f163e = t;
        this.f165g = 0;
    }

    public static void a(String str) {
        if (!e.c.a.a.a.d().b()) {
            throw new IllegalStateException(f.a.a.a.a.c("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(LiveData<T>.c cVar) {
        if (cVar.b) {
            if (!cVar.k()) {
                cVar.h(false);
                return;
            }
            int i2 = cVar.c;
            int i3 = this.f165g;
            if (i2 < i3) {
                cVar.c = i3;
                cVar.a.a((Object) this.f163e);
            }
        }
    }

    public void c(LiveData<T>.c cVar) {
        if (this.f166h) {
            this.f167i = true;
            return;
        }
        this.f166h = true;
        do {
            this.f167i = false;
            if (cVar == null) {
                e.c.a.b.b<K, V>.d i2 = this.b.i();
                while (i2.hasNext()) {
                    b((c) ((Map.Entry) i2.next()).getValue());
                    if (this.f167i) {
                        break;
                    }
                }
            } else {
                b(cVar);
                cVar = null;
            }
        } while (this.f167i);
        this.f166h = false;
    }

    public T d() {
        T t = (T) this.f163e;
        if (t != f161k) {
            return t;
        }
        return null;
    }

    public boolean e() {
        return this.c > 0;
    }

    public void f(j jVar, r<? super T> rVar) {
        a("observe");
        if (((k) jVar.a()).b != g.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(jVar, rVar);
            LiveData<T>.c k2 = this.b.k(rVar, lifecycleBoundObserver);
            if (k2 != null && !k2.j(jVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (k2 == null) {
                jVar.a().a(lifecycleBoundObserver);
            }
        }
    }

    public void g(r<? super T> rVar) {
        a("observeForever");
        b bVar = new b(this, rVar);
        LiveData<T>.c k2 = this.b.k(rVar, bVar);
        if (k2 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (k2 == null) {
            bVar.h(true);
        }
    }

    public void h() {
    }

    public void i() {
    }

    public void j(T t) {
        boolean z;
        synchronized (this.a) {
            z = this.f164f == f161k;
            this.f164f = t;
        }
        if (z) {
            e.c.a.a.a.d().a.c(this.f168j);
        }
    }

    public void k(r<? super T> rVar) {
        a("removeObserver");
        LiveData<T>.c l2 = this.b.l(rVar);
        if (l2 != null) {
            l2.i();
            l2.h(false);
        }
    }

    public void l(T t) {
        a("setValue");
        this.f165g++;
        this.f163e = t;
        c(null);
    }
}
