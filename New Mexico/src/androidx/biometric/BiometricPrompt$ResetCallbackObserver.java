package androidx.biometric;

import e.d.u;
import e.r.h;
import e.r.k;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class BiometricPrompt$ResetCallbackObserver implements k {
    public final WeakReference<u> a;

    public BiometricPrompt$ResetCallbackObserver(u uVar) {
        this.a = new WeakReference<>(uVar);
    }

    @e.r.u(h.a.ON_DESTROY)
    public void resetCallback() {
        if (this.a.get() != null) {
            this.a.get().f1265d = null;
        }
    }
}
