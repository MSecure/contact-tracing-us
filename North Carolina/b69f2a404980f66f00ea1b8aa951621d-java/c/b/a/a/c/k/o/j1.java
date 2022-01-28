package c.b.a.a.c.k.o;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public final class j1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f2372b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2373c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i1 f2374d;

    public j1(i1 i1Var, LifecycleCallback lifecycleCallback, String str) {
        this.f2374d = i1Var;
        this.f2372b = lifecycleCallback;
        this.f2373c = str;
    }

    public final void run() {
        i1 i1Var = this.f2374d;
        if (i1Var.f2369c > 0) {
            LifecycleCallback lifecycleCallback = this.f2372b;
            Bundle bundle = i1Var.f2370d;
            lifecycleCallback.d(bundle != null ? bundle.getBundle(this.f2373c) : null);
        }
        if (this.f2374d.f2369c >= 2) {
            this.f2372b.g();
        }
        if (this.f2374d.f2369c >= 3) {
            this.f2372b.e();
        }
        if (this.f2374d.f2369c >= 4) {
            this.f2372b.h();
        }
        if (this.f2374d.f2369c >= 5 && this.f2372b == null) {
            throw null;
        }
    }
}
