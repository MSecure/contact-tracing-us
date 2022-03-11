package e.d;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import e.b.a.m;
import e.d.c;
import e.r.e0;
import e.r.s;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class u extends e0 {
    public Executor c;

    /* renamed from: d */
    public q f1265d;

    /* renamed from: e */
    public t f1266e;

    /* renamed from: f */
    public s f1267f;

    /* renamed from: g */
    public c f1268g;

    /* renamed from: h */
    public v f1269h;

    /* renamed from: i */
    public DialogInterface.OnClickListener f1270i;

    /* renamed from: j */
    public CharSequence f1271j;

    /* renamed from: l */
    public boolean f1273l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public s<r> q;
    public s<d> r;
    public s<CharSequence> s;
    public s<Boolean> t;
    public s<Boolean> u;
    public s<Boolean> w;
    public s<Integer> y;
    public s<CharSequence> z;

    /* renamed from: k */
    public int f1272k = 0;
    public boolean v = true;
    public int x = 0;

    /* loaded from: classes.dex */
    public class a extends q {
        public a(u uVar) {
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends c.a {
        public final WeakReference<u> a;

        public b(u uVar) {
            this.a = new WeakReference<>(uVar);
        }

        @Override // e.d.c.a
        public void a(int i2, CharSequence charSequence) {
            if (this.a.get() != null && !this.a.get().n && this.a.get().m) {
                this.a.get().k(new d(i2, charSequence));
            }
        }

        @Override // e.d.c.a
        public void b() {
            if (this.a.get() != null && this.a.get().m) {
                u uVar = this.a.get();
                if (uVar.t == null) {
                    uVar.t = new s<>();
                }
                u.o(uVar.t, Boolean.TRUE);
            }
        }

        @Override // e.d.c.a
        public void c(r rVar) {
            if (this.a.get() != null && this.a.get().m) {
                int i2 = -1;
                if (rVar.b == -1) {
                    s sVar = rVar.a;
                    int c = this.a.get().c();
                    if (((c & 32767) != 0) && !m.e.N0(c)) {
                        i2 = 2;
                    }
                    rVar = new r(sVar, i2);
                }
                u uVar = this.a.get();
                if (uVar.q == null) {
                    uVar.q = new s<>();
                }
                u.o(uVar.q, rVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Executor {
        public final Handler b = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.b.post(runnable);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements DialogInterface.OnClickListener {
        public final WeakReference<u> b;

        public d(u uVar) {
            this.b = new WeakReference<>(uVar);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.b.get() != null) {
                this.b.get().n(true);
            }
        }
    }

    public static <T> void o(s<T> sVar, T t) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            sVar.l(t);
        } else {
            sVar.j(t);
        }
    }

    public int c() {
        t tVar = this.f1266e;
        if (tVar == null) {
            return 0;
        }
        s sVar = this.f1267f;
        int i2 = tVar.b;
        if (i2 != 0) {
            return i2;
        }
        return sVar != null ? 15 : 255;
    }

    public v d() {
        if (this.f1269h == null) {
            this.f1269h = new v();
        }
        return this.f1269h;
    }

    public q e() {
        if (this.f1265d == null) {
            this.f1265d = new a(this);
        }
        return this.f1265d;
    }

    public Executor f() {
        Executor executor = this.c;
        return executor != null ? executor : new c();
    }

    public CharSequence g() {
        t tVar = this.f1266e;
        if (tVar == null) {
            return null;
        }
        Objects.requireNonNull(tVar);
        return null;
    }

    public CharSequence h() {
        CharSequence charSequence = this.f1271j;
        if (charSequence != null) {
            return charSequence;
        }
        t tVar = this.f1266e;
        if (tVar == null) {
            return null;
        }
        Objects.requireNonNull(tVar);
        return "";
    }

    public CharSequence i() {
        t tVar = this.f1266e;
        if (tVar == null) {
            return null;
        }
        Objects.requireNonNull(tVar);
        return null;
    }

    public CharSequence j() {
        t tVar = this.f1266e;
        if (tVar != null) {
            return tVar.a;
        }
        return null;
    }

    public void k(d dVar) {
        if (this.r == null) {
            this.r = new s<>();
        }
        o(this.r, dVar);
    }

    public void l(CharSequence charSequence) {
        if (this.z == null) {
            this.z = new s<>();
        }
        o(this.z, charSequence);
    }

    public void m(int i2) {
        if (this.y == null) {
            this.y = new s<>();
        }
        o(this.y, Integer.valueOf(i2));
    }

    public void n(boolean z) {
        if (this.u == null) {
            this.u = new s<>();
        }
        o(this.u, Boolean.valueOf(z));
    }
}
