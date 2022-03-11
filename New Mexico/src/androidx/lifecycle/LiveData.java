package androidx.lifecycle;

import e.r.h;
import e.r.j;
import e.r.l;
import e.r.m;
import e.r.t;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k */
    public static final Object f173k = new Object();
    public final Object a;
    public e.c.a.b.b<t<? super T>, LiveData<T>.c> b;
    public int c;

    /* renamed from: d */
    public boolean f174d;

    /* renamed from: e */
    public volatile Object f175e;

    /* renamed from: f */
    public volatile Object f176f;

    /* renamed from: g */
    public int f177g;

    /* renamed from: h */
    public boolean f178h;

    /* renamed from: i */
    public boolean f179i;

    /* renamed from: j */
    public final Runnable f180j;

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.c implements j {

        /* renamed from: e */
        public final l f181e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LifecycleBoundObserver(l lVar, t<? super T> tVar) {
            super(tVar);
            LiveData.this = r1;
            this.f181e = lVar;
        }

        @Override // e.r.j
        public void d(l lVar, h.a aVar) {
            h.b bVar = ((m) this.f181e.a()).b;
            if (bVar == h.b.DESTROYED) {
                LiveData.this.k(this.a);
                return;
            }
            for (h.b bVar2 = null; bVar2 != bVar; bVar2 = bVar) {
                h(k());
                bVar = ((m) this.f181e.a()).b;
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        public void i() {
            m mVar = (m) this.f181e.a();
            mVar.d("removeObserver");
            mVar.a.l(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean j(l lVar) {
            return this.f181e == lVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return ((m) this.f181e.a()).b.compareTo(h.b.STARTED) >= 0;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            LiveData.this = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.a) {
                obj = LiveData.this.f176f;
                LiveData.this.f176f = LiveData.f173k;
            }
            LiveData.this.l(obj);
        }
    }

    /* loaded from: classes.dex */
    public class b extends LiveData<T>.c {
        public b(LiveData liveData, t<? super T> tVar) {
            super(tVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public abstract class c {
        public final t<? super T> a;
        public boolean b;
        public int c = -1;

        public c(t<? super T> tVar) {
            LiveData.this = r1;
            this.a = tVar;
        }

        public void h(boolean z) {
            if (z != this.b) {
                this.b = z;
                LiveData liveData = LiveData.this;
                int i2 = z ? 1 : -1;
                int i3 = liveData.c;
                liveData.c = i2 + i3;
                if (!liveData.f174d) {
                    liveData.f174d = true;
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
                            liveData.f174d = false;
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

        public boolean j(l lVar) {
            return false;
        }

        public abstract boolean k();
    }

    public LiveData() {
        this.a = new Object();
        this.b = new e.c.a.b.b<>();
        this.c = 0;
        Object obj = f173k;
        this.f176f = obj;
        this.f180j = new a();
        this.f175e = obj;
        this.f177g = -1;
    }

    public LiveData(T t) {
        this.a = new Object();
        this.b = new e.c.a.b.b<>();
        this.c = 0;
        this.f176f = f173k;
        this.f180j = new a();
        this.f175e = t;
        this.f177g = 0;
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
            int i3 = this.f177g;
            if (i2 < i3) {
                cVar.c = i3;
                cVar.a.a((Object) this.f175e);
            }
        }
    }

    public void c(LiveData<T>.c cVar) {
        if (this.f178h) {
            this.f179i = true;
            return;
        }
        this.f178h = true;
        do {
            this.f179i = false;
            if (cVar == null) {
                e.c.a.b.b<t<? super T>, LiveData<T>.c>.d i2 = this.b.i();
                while (i2.hasNext()) {
                    b((c) ((Map.Entry) i2.next()).getValue());
                    if (this.f179i) {
                        break;
                    }
                }
            } else {
                b(cVar);
                cVar = null;
            }
        } while (this.f179i);
        this.f178h = false;
    }

    public T d() {
        T t = (T) this.f175e;
        if (t != f173k) {
            return t;
        }
        return null;
    }

    public boolean e() {
        return this.c > 0;
    }

    public void f(l lVar, t<? super T> tVar) {
        a("observe");
        if (((m) lVar.a()).b != h.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lVar, tVar);
            LiveData<T>.c k2 = this.b.k(tVar, lifecycleBoundObserver);
            if (k2 != null && !k2.j(lVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (k2 == null) {
                lVar.a().a(lifecycleBoundObserver);
            }
        }
    }

    public void g(t<? super T> tVar) {
        a("observeForever");
        b bVar = new b(this, tVar);
        LiveData<T>.c k2 = this.b.k(tVar, bVar);
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
            z = this.f176f == f173k;
            this.f176f = t;
        }
        if (z) {
            e.c.a.a.a.d().a.c(this.f180j);
        }
    }

    public void k(t<? super T> tVar) {
        a("removeObserver");
        LiveData<T>.c l2 = this.b.l(tVar);
        if (l2 != null) {
            l2.i();
            l2.h(false);
        }
    }

    public void l(T t) {
        a("setValue");
        this.f177g++;
        this.f175e = t;
        c(null);
    }
}
