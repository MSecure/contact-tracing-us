package e.d;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.biometric.R$array;
import androidx.biometric.R$string;
import e.b.a.m;
import e.d.u;
import e.d.v;
import e.j.d.a.b;
import e.o.a.e0;
import e.o.a.m;
import e.o.a.r;
import e.r.f0;
import e.r.s;
import java.lang.ref.WeakReference;
import java.security.Signature;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public class e extends m {
    public Handler W = new Handler(Looper.getMainLooper());
    public u X;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ int b;
        public final /* synthetic */ CharSequence c;

        public a(int i2, CharSequence charSequence) {
            e.this = r1;
            this.b = i2;
            this.c = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.X.e().a(this.b, this.c);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Executor {
        public final Handler b = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.b.post(runnable);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public final WeakReference<e> b;

        public c(e eVar) {
            this.b = new WeakReference<>(eVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.get() != null) {
                this.b.get().Q0();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public final WeakReference<u> b;

        public d(u uVar) {
            this.b = new WeakReference<>(uVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.get() != null) {
                this.b.get().o = false;
            }
        }
    }

    /* renamed from: e.d.e$e */
    /* loaded from: classes.dex */
    public static class RunnableC0026e implements Runnable {
        public final WeakReference<u> b;

        public RunnableC0026e(u uVar) {
            this.b = new WeakReference<>(uVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.get() != null) {
                this.b.get().p = false;
            }
        }
    }

    public void H0(int i2) {
        if (i2 == 3 || !this.X.p) {
            if (L0()) {
                this.X.f1272k = i2;
                if (i2 == 1) {
                    N0(10, m.e.m0(k(), 10));
                }
            }
            v d2 = this.X.d();
            CancellationSignal cancellationSignal = d2.b;
            if (cancellationSignal != null) {
                try {
                    cancellationSignal.cancel();
                } catch (NullPointerException unused) {
                }
                d2.b = null;
            }
            e.j.f.a aVar = d2.c;
            if (aVar != null) {
                try {
                    aVar.a();
                } catch (NullPointerException unused2) {
                }
                d2.c = null;
            }
        }
    }

    public void I0() {
        boolean z = false;
        this.X.f1273l = false;
        J0();
        if (!this.X.n && I()) {
            e.o.a.a aVar = new e.o.a.a(w());
            aVar.o(this);
            aVar.e();
        }
        Context k2 = k();
        if (k2 != null) {
            String str = Build.MODEL;
            if (Build.VERSION.SDK_INT == 29) {
                z = m.e.Q0(k2, str, R$array.delay_showing_prompt_models);
            }
            if (z) {
                u uVar = this.X;
                uVar.o = true;
                this.W.postDelayed(new d(uVar), 600);
            }
        }
    }

    public final void J0() {
        this.X.f1273l = false;
        if (I()) {
            e0 w = w();
            x xVar = (x) w.I("androidx.biometric.FingerprintDialogFragment");
            if (xVar == null) {
                return;
            }
            if (xVar.I()) {
                xVar.H0(true, false);
                return;
            }
            e.o.a.a aVar = new e.o.a.a(w);
            aVar.o(xVar);
            aVar.e();
        }
    }

    public boolean K0() {
        return Build.VERSION.SDK_INT <= 28 && m.e.N0(this.X.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final boolean L0() {
        boolean z;
        boolean z2;
        boolean z3;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            r g2 = g();
            if (!(g2 == null || this.X.f1267f == null)) {
                String str = Build.MANUFACTURER;
                String str2 = Build.MODEL;
                if (i2 == 28) {
                    int i3 = R$array.crypto_fingerprint_fallback_vendors;
                    if (str != null) {
                        for (String str3 : g2.getResources().getStringArray(i3)) {
                            if (str.equalsIgnoreCase(str3)) {
                                z3 = true;
                                break;
                            }
                        }
                    }
                    z3 = false;
                    if (z3 || m.e.R0(g2, str2, R$array.crypto_fingerprint_fallback_prefixes)) {
                        z2 = true;
                        if (z2) {
                            z = true;
                            if (!z) {
                                if (!(Build.VERSION.SDK_INT == 28 && !w.c(k()))) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            z = false;
            if (!z) {
            }
        }
        return true;
    }

    public final void M0() {
        r g2 = g();
        if (g2 != null) {
            KeyguardManager b2 = w.b(g2);
            if (b2 == null) {
                N0(12, F(R$string.generic_error_no_keyguard));
                I0();
                return;
            }
            CharSequence j2 = this.X.j();
            this.X.i();
            this.X.g();
            Intent createConfirmDeviceCredentialIntent = b2.createConfirmDeviceCredentialIntent(j2, null);
            if (createConfirmDeviceCredentialIntent == null) {
                N0(14, F(R$string.generic_error_no_device_credential));
                I0();
                return;
            }
            this.X.n = true;
            if (L0()) {
                J0();
            }
            createConfirmDeviceCredentialIntent.setFlags(134742016);
            if (this.t != null) {
                e0 w = w();
                if (w.w != null) {
                    w.z.addLast(new e0.k(this.f1811f, 1));
                    w.w.a(createConfirmDeviceCredentialIntent, null);
                    return;
                }
                Objects.requireNonNull(w.q);
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    @Override // e.o.a.m
    public void N(int i2, int i3, Intent intent) {
        super.N(i2, i3, intent);
        if (i2 == 1) {
            this.X.n = false;
            if (i3 == -1) {
                O0(new r(null, 1));
                return;
            }
            N0(10, F(R$string.generic_error_user_canceled));
            I0();
        }
    }

    public final void N0(int i2, CharSequence charSequence) {
        u uVar = this.X;
        if (!uVar.n && uVar.m) {
            uVar.m = false;
            uVar.f().execute(new a(i2, charSequence));
        }
    }

    public final void O0(r rVar) {
        u uVar = this.X;
        if (uVar.m) {
            uVar.m = false;
            uVar.f().execute(new o(this, rVar));
        }
        I0();
    }

    public final void P0(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = F(R$string.default_error_msg);
        }
        this.X.m(2);
        this.X.l(charSequence);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void Q0() {
        b.C0037b bVar;
        v d2;
        u uVar;
        c cVar;
        if (!this.X.f1273l && k() != null) {
            u uVar2 = this.X;
            uVar2.f1273l = true;
            uVar2.m = true;
            if (L0()) {
                Context applicationContext = v0().getApplicationContext();
                e.j.d.a.b bVar2 = new e.j.d.a.b(applicationContext);
                int i2 = !bVar2.d() ? 12 : !bVar2.c() ? 11 : 0;
                if (i2 != 0) {
                    N0(i2, m.e.m0(applicationContext, i2));
                    I0();
                } else if (I()) {
                    this.X.v = true;
                    if (!(Build.VERSION.SDK_INT != 28 ? false : m.e.R0(applicationContext, Build.MODEL, R$array.hide_fingerprint_instantly_prefixes))) {
                        this.W.postDelayed(new m(this), 500);
                        new x().K0(w(), "androidx.biometric.FingerprintDialogFragment");
                    }
                    u uVar3 = this.X;
                    uVar3.f1272k = 0;
                    s sVar = uVar3.f1267f;
                    b.C0037b bVar3 = null;
                    try {
                        if (sVar != null) {
                            Cipher cipher = sVar.b;
                            if (cipher != null) {
                                bVar = new b.C0037b(cipher);
                            } else {
                                Signature signature = sVar.a;
                                if (signature != null) {
                                    bVar = new b.C0037b(signature);
                                } else {
                                    Mac mac = sVar.c;
                                    if (mac != null) {
                                        bVar3 = new b.C0037b(mac);
                                    }
                                }
                            }
                            d2 = uVar3.d();
                            if (d2.c == null) {
                                Objects.requireNonNull((v.a) d2.a);
                                d2.c = new e.j.f.a();
                            }
                            e.j.f.a aVar = d2.c;
                            uVar = this.X;
                            if (uVar.f1268g == null) {
                                uVar.f1268g = new c(new u.b(uVar));
                            }
                            cVar = uVar.f1268g;
                            if (cVar.b == null) {
                                cVar.b = new a(cVar);
                            }
                            bVar2.a(bVar, 0, aVar, cVar.b, null);
                            return;
                        }
                        bVar2.a(bVar, 0, aVar, cVar.b, null);
                        return;
                    } catch (NullPointerException unused) {
                        N0(1, m.e.m0(applicationContext, 1));
                        I0();
                        return;
                    }
                    bVar = bVar3;
                    d2 = uVar3.d();
                    if (d2.c == null) {
                    }
                    e.j.f.a aVar2 = d2.c;
                    uVar = this.X;
                    if (uVar.f1268g == null) {
                    }
                    cVar = uVar.f1268g;
                    if (cVar.b == null) {
                    }
                }
            } else {
                BiometricPrompt.Builder builder = new BiometricPrompt.Builder(v0().getApplicationContext());
                CharSequence j2 = this.X.j();
                this.X.i();
                this.X.g();
                if (j2 != null) {
                    builder.setTitle(j2);
                }
                CharSequence h2 = this.X.h();
                if (!TextUtils.isEmpty(h2)) {
                    Executor f2 = this.X.f();
                    u uVar4 = this.X;
                    if (uVar4.f1270i == null) {
                        uVar4.f1270i = new u.d(uVar4);
                    }
                    builder.setNegativeButton(h2, f2, uVar4.f1270i);
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 29) {
                    t tVar = this.X.f1266e;
                    builder.setConfirmationRequired(true);
                }
                int c2 = this.X.c();
                if (i3 >= 30) {
                    builder.setAllowedAuthenticators(c2);
                } else if (i3 >= 29) {
                    builder.setDeviceCredentialAllowed(m.e.N0(c2));
                }
                BiometricPrompt build = builder.build();
                Context k2 = k();
                BiometricPrompt.CryptoObject e2 = w.e(this.X.f1267f);
                v d3 = this.X.d();
                if (d3.b == null) {
                    Objects.requireNonNull((v.a) d3.a);
                    d3.b = new CancellationSignal();
                }
                CancellationSignal cancellationSignal = d3.b;
                b bVar4 = new b();
                u uVar5 = this.X;
                if (uVar5.f1268g == null) {
                    uVar5.f1268g = new c(new u.b(uVar5));
                }
                c cVar2 = uVar5.f1268g;
                if (cVar2.a == null) {
                    cVar2.a = new b(cVar2.c);
                }
                BiometricPrompt.AuthenticationCallback authenticationCallback = cVar2.a;
                try {
                    if (e2 == null) {
                        build.authenticate(cancellationSignal, bVar4, authenticationCallback);
                    } else {
                        build.authenticate(e2, cancellationSignal, bVar4, authenticationCallback);
                    }
                } catch (NullPointerException unused2) {
                    while (true) {
                        N0(1, k2 != null ? k2.getString(R$string.default_error_msg) : "");
                        I0();
                        return;
                    }
                }
            }
        }
    }

    @Override // e.o.a.m
    public void S(Bundle bundle) {
        super.S(bundle);
        if (g() != null) {
            u uVar = (u) new f0(g()).a(u.class);
            this.X = uVar;
            if (uVar.q == null) {
                uVar.q = new s<>();
            }
            uVar.q.f(this, new g(this));
            u uVar2 = this.X;
            if (uVar2.r == null) {
                uVar2.r = new s<>();
            }
            uVar2.r.f(this, new h(this));
            u uVar3 = this.X;
            if (uVar3.s == null) {
                uVar3.s = new s<>();
            }
            uVar3.s.f(this, new i(this));
            u uVar4 = this.X;
            if (uVar4.t == null) {
                uVar4.t = new s<>();
            }
            uVar4.t.f(this, new j(this));
            u uVar5 = this.X;
            if (uVar5.u == null) {
                uVar5.u = new s<>();
            }
            uVar5.u.f(this, new k(this));
            u uVar6 = this.X;
            if (uVar6.w == null) {
                uVar6.w = new s<>();
            }
            uVar6.w.f(this, new l(this));
        }
    }

    @Override // e.o.a.m
    public void k0() {
        this.D = true;
        if (Build.VERSION.SDK_INT == 29 && m.e.N0(this.X.c())) {
            u uVar = this.X;
            uVar.p = true;
            this.W.postDelayed(new RunnableC0026e(uVar), 250);
        }
    }

    @Override // e.o.a.m
    public void l0() {
        boolean z = true;
        this.D = true;
        if (Build.VERSION.SDK_INT < 29 && !this.X.n) {
            r g2 = g();
            if (g2 == null || !g2.isChangingConfigurations()) {
                z = false;
            }
            if (!z) {
                H0(0);
            }
        }
    }
}
