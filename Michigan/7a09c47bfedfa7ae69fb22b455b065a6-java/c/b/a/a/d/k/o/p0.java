package c.b.a.a.d.k.o;

import android.os.Looper;
import b.x.t;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.f;
import c.b.a.a.d.k.g;
import c.b.a.a.d.k.i;
import c.b.a.a.d.k.j;
import c.b.a.a.d.k.k;
import c.b.a.a.d.k.l;
import c.b.a.a.d.k.m;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

public final class p0<R extends i> extends m<R> implements j<R> {

    /* renamed from: a  reason: collision with root package name */
    public l<? super R, ? extends i> f3035a = null;

    /* renamed from: b  reason: collision with root package name */
    public p0<? extends i> f3036b = null;

    /* renamed from: c  reason: collision with root package name */
    public volatile k<? super R> f3037c = null;

    /* renamed from: d  reason: collision with root package name */
    public f<R> f3038d = null;

    /* renamed from: e  reason: collision with root package name */
    public final Object f3039e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public Status f3040f = null;

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<e> f3041g;
    public final q0 h;
    public boolean i = false;

    public p0(WeakReference<e> weakReference) {
        t.D(weakReference, "GoogleApiClient reference must not be null");
        this.f3041g = weakReference;
        e eVar = weakReference.get();
        this.h = new q0(this, eVar != null ? eVar.b() : Looper.getMainLooper());
    }

    public static void d(i iVar) {
        if (iVar instanceof g) {
            try {
                ((g) iVar).a();
            } catch (RuntimeException unused) {
                String.valueOf(iVar).length();
            }
        }
    }

    @Override // c.b.a.a.d.k.j
    public final void a(R r) {
        synchronized (this.f3039e) {
            if (!r.getStatus().t()) {
                c(r.getStatus());
                if (r instanceof g) {
                    try {
                        ((g) r).a();
                    } catch (RuntimeException unused) {
                        String.valueOf(r).length();
                    }
                }
            } else if (this.f3035a != null) {
                h0.f3001a.submit(new o0(this, r));
            } else if (g()) {
                k<? super R> kVar = this.f3037c;
                t.C(kVar);
                kVar.c(r);
            }
        }
    }

    public final <S extends i> m<S> b(l<? super R, ? extends S> lVar) {
        p0<? extends i> p0Var;
        synchronized (this.f3039e) {
            boolean z = true;
            t.I(this.f3035a == null, "Cannot call then() twice.");
            if (this.f3037c != null) {
                z = false;
            }
            t.I(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f3035a = lVar;
            p0Var = new p0<>(this.f3041g);
            this.f3036b = p0Var;
            e();
        }
        return p0Var;
    }

    public final void c(Status status) {
        synchronized (this.f3039e) {
            this.f3040f = status;
            f(status);
        }
    }

    public final void e() {
        if (this.f3035a != null || this.f3037c != null) {
            e eVar = this.f3041g.get();
            if (!(this.i || this.f3035a == null || eVar == null)) {
                eVar.c(this);
                this.i = true;
            }
            Status status = this.f3040f;
            if (status != null) {
                f(status);
                return;
            }
            f<R> fVar = this.f3038d;
            if (fVar != null) {
                fVar.setResultCallback(this);
            }
        }
    }

    public final void f(Status status) {
        synchronized (this.f3039e) {
            if (this.f3035a != null) {
                if (this.f3035a != null) {
                    t.D(status, "onFailure must not return null");
                    p0<? extends i> p0Var = this.f3036b;
                    t.C(p0Var);
                    p0Var.c(status);
                } else {
                    throw null;
                }
            } else if (g()) {
                k<? super R> kVar = this.f3037c;
                t.C(kVar);
                kVar.b(status);
            }
        }
    }

    public final boolean g() {
        return (this.f3037c == null || this.f3041g.get() == null) ? false : true;
    }
}
