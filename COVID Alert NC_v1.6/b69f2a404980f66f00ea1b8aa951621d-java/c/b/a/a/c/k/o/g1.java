package c.b.a.a.c.k.o;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public final class g1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f2354b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2355c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h1 f2356d;

    public g1(h1 h1Var, LifecycleCallback lifecycleCallback, String str) {
        this.f2356d = h1Var;
        this.f2354b = lifecycleCallback;
        this.f2355c = str;
    }

    public final void run() {
        h1 h1Var = this.f2356d;
        if (h1Var.f2362c > 0) {
            LifecycleCallback lifecycleCallback = this.f2354b;
            Bundle bundle = h1Var.f2363d;
            lifecycleCallback.d(bundle != null ? bundle.getBundle(this.f2355c) : null);
        }
        if (this.f2356d.f2362c >= 2) {
            this.f2354b.g();
        }
        if (this.f2356d.f2362c >= 3) {
            this.f2354b.e();
        }
        if (this.f2356d.f2362c >= 4) {
            this.f2354b.h();
        }
        if (this.f2356d.f2362c >= 5 && this.f2354b == null) {
            throw null;
        }
    }
}
