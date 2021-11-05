package c.b.a.a.d.k.o;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public final class i1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f3009b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3010c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ j1 f3011d;

    public i1(j1 j1Var, LifecycleCallback lifecycleCallback, String str) {
        this.f3011d = j1Var;
        this.f3009b = lifecycleCallback;
        this.f3010c = str;
    }

    public final void run() {
        j1 j1Var = this.f3011d;
        if (j1Var.f3016c > 0) {
            LifecycleCallback lifecycleCallback = this.f3009b;
            Bundle bundle = j1Var.f3017d;
            lifecycleCallback.d(bundle != null ? bundle.getBundle(this.f3010c) : null);
        }
        if (this.f3011d.f3016c >= 2) {
            this.f3009b.g();
        }
        if (this.f3011d.f3016c >= 3) {
            this.f3009b.e();
        }
        if (this.f3011d.f3016c >= 4) {
            this.f3009b.h();
        }
        if (this.f3011d.f3016c >= 5 && this.f3009b == null) {
            throw null;
        }
    }
}
