package c.b.a.a.d.k.o;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import c.b.a.a.d.a;
import c.b.a.a.g.a.d;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;

public abstract class y0 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f3061c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<a1> f3062d = new AtomicReference<>(null);

    /* renamed from: e  reason: collision with root package name */
    public final Handler f3063e = new d(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public final c.b.a.a.d.d f3064f;

    public y0(j jVar, c.b.a.a.d.d dVar) {
        super(jVar);
        this.f3064f = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void c(int i, int i2, Intent intent) {
        a1 a1Var = this.f3062d.get();
        boolean z = true;
        if (i == 1) {
            if (i2 != -1) {
                if (i2 == 0) {
                    if (a1Var != null) {
                        int i3 = 13;
                        if (intent != null) {
                            i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                        }
                        a1 a1Var2 = new a1(new a(i3, null, a1Var.f2951b.toString()), a1Var.f2950a);
                        this.f3062d.set(a1Var2);
                        a1Var = a1Var2;
                    } else {
                        return;
                    }
                }
            }
            if (z) {
            }
        } else if (i == 2) {
            int c2 = this.f3064f.c(b());
            if (c2 != 0) {
                z = false;
            }
            if (a1Var != null) {
                if (a1Var.f2951b.f2918c == 18 && c2 == 18) {
                    return;
                }
                if (z) {
                    i();
                    return;
                } else if (a1Var != null) {
                    ((f1) this).h.f(a1Var.f2951b, a1Var.f2950a);
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
            this.f3062d.set(bundle.getBoolean("resolving_error", false) ? new a1(new a(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void f(Bundle bundle) {
        a1 a1Var = this.f3062d.get();
        if (a1Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", a1Var.f2950a);
            bundle.putInt("failed_status", a1Var.f2951b.f2918c);
            bundle.putParcelable("failed_resolution", a1Var.f2951b.f2919d);
        }
    }

    public final void i() {
        this.f3062d.set(null);
        Handler handler = ((f1) this).h.m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public void onCancel(DialogInterface dialogInterface) {
        a aVar = new a(13, null);
        a1 a1Var = this.f3062d.get();
        ((f1) this).h.f(aVar, a1Var == null ? -1 : a1Var.f2950a);
        i();
    }
}
