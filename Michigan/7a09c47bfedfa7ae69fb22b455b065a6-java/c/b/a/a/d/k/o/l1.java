package c.b.a.a.d.k.o;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public final class l1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f3029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3030c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k1 f3031d;

    public l1(k1 k1Var, LifecycleCallback lifecycleCallback, String str) {
        this.f3031d = k1Var;
        this.f3029b = lifecycleCallback;
        this.f3030c = str;
    }

    public final void run() {
        k1 k1Var = this.f3031d;
        if (k1Var.f3027c > 0) {
            LifecycleCallback lifecycleCallback = this.f3029b;
            Bundle bundle = k1Var.f3028d;
            lifecycleCallback.d(bundle != null ? bundle.getBundle(this.f3030c) : null);
        }
        if (this.f3031d.f3027c >= 2) {
            this.f3029b.g();
        }
        if (this.f3031d.f3027c >= 3) {
            this.f3029b.e();
        }
        if (this.f3031d.f3027c >= 4) {
            this.f3029b.h();
        }
        if (this.f3031d.f3027c >= 5 && this.f3029b == null) {
            throw null;
        }
    }
}
