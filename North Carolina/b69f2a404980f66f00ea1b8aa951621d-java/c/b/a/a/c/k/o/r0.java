package c.b.a.a.c.k.o;

import android.os.Looper;
import b.b.k.i;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.f;
import c.b.a.a.c.k.g;
import c.b.a.a.c.k.i;
import c.b.a.a.c.k.j;
import c.b.a.a.c.k.k;
import c.b.a.a.c.k.l;
import c.b.a.a.c.k.m;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

public final class r0<R extends i> extends m<R> implements j<R> {

    /* renamed from: a  reason: collision with root package name */
    public l<? super R, ? extends i> f2393a = null;

    /* renamed from: b  reason: collision with root package name */
    public r0<? extends i> f2394b = null;

    /* renamed from: c  reason: collision with root package name */
    public volatile k<? super R> f2395c = null;

    /* renamed from: d  reason: collision with root package name */
    public f<R> f2396d = null;

    /* renamed from: e  reason: collision with root package name */
    public final Object f2397e = new Object();
    public Status f = null;
    public final WeakReference<e> g;
    public final t0 h;
    public boolean i = false;

    public r0(WeakReference<e> weakReference) {
        i.j.t(weakReference, "GoogleApiClient reference must not be null");
        this.g = weakReference;
        e eVar = weakReference.get();
        this.h = new t0(this, eVar != null ? eVar.b() : Looper.getMainLooper());
    }

    @Override // c.b.a.a.c.k.j
    public final void a(R r) {
        synchronized (this.f2397e) {
            if (r.getStatus().p()) {
                this.g.get();
            } else {
                b(r.getStatus());
                if (r instanceof g) {
                    try {
                        ((g) r).a();
                    } catch (RuntimeException unused) {
                        String.valueOf(r).length();
                    }
                }
            }
        }
    }

    public final void b(Status status) {
        synchronized (this.f2397e) {
            this.f = status;
            c(status);
        }
    }

    public final void c(Status status) {
        synchronized (this.f2397e) {
            this.g.get();
        }
    }
}
