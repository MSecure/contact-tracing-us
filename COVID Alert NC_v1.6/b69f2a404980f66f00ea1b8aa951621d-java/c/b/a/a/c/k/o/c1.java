package c.b.a.a.c.k.o;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import c.b.a.a.c.a;
import c.b.a.a.e.a.d;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c1 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f2324c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<b1> f2325d = new AtomicReference<>(null);

    /* renamed from: e  reason: collision with root package name */
    public final Handler f2326e = new d(Looper.getMainLooper());
    public final c.b.a.a.c.d f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c1(j jVar) {
        super(jVar);
        c.b.a.a.c.d dVar = c.b.a.a.c.d.f2290d;
        this.f = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void c(int i, int i2, Intent intent) {
        b1 b1Var = this.f2325d.get();
        boolean z = true;
        if (i == 1) {
            if (i2 != -1) {
                if (i2 == 0) {
                    if (b1Var != null) {
                        int i3 = 13;
                        if (intent != null) {
                            i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                        }
                        b1 b1Var2 = new b1(new a(i3, null, b1Var.f2318b.toString()), b1Var.f2317a);
                        this.f2325d.set(b1Var2);
                        b1Var = b1Var2;
                    } else {
                        return;
                    }
                }
            }
            if (z) {
            }
        } else if (i == 2) {
            int c2 = this.f.c(b());
            if (c2 != 0) {
                z = false;
            }
            if (b1Var != null) {
                if (b1Var.f2318b.f2281c == 18 && c2 == 18) {
                    return;
                }
                if (z) {
                    j();
                    return;
                } else if (b1Var != null) {
                    i(b1Var.f2318b, b1Var.f2317a);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void d(Bundle bundle) {
        if (bundle != null) {
            this.f2325d.set(bundle.getBoolean("resolving_error", false) ? new b1(new a(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void f(Bundle bundle) {
        b1 b1Var = this.f2325d.get();
        if (b1Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", b1Var.f2317a);
            bundle.putInt("failed_status", b1Var.f2318b.f2281c);
            bundle.putParcelable("failed_resolution", b1Var.f2318b.f2282d);
        }
    }

    public abstract void i(a aVar, int i);

    public final void j() {
        this.f2325d.set(null);
        Handler handler = ((u) this).h.m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public void onCancel(DialogInterface dialogInterface) {
        a aVar = new a(13, null);
        b1 b1Var = this.f2325d.get();
        i(aVar, b1Var == null ? -1 : b1Var.f2317a);
        j();
    }
}
