package e.d;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import androidx.biometric.R$array;
import e.b.a.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class p {
    public final b a;
    public final BiometricManager b;
    public final e.j.d.a.b c;

    /* loaded from: classes.dex */
    public static class a implements b {
        public final Context a;

        public a(Context context) {
            this.a = context.getApplicationContext();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public p(b bVar) {
        this.a = bVar;
        int i2 = Build.VERSION.SDK_INT;
        e.j.d.a.b bVar2 = null;
        this.b = i2 >= 29 ? (BiometricManager) ((a) bVar).a.getSystemService(BiometricManager.class) : null;
        this.c = i2 <= 29 ? new e.j.d.a.b(((a) bVar).a) : bVar2;
    }

    public int a(int i2) {
        Method method;
        int i3;
        BiometricPrompt.CryptoObject e2;
        Object invoke;
        int i4 = Build.VERSION.SDK_INT;
        int i5 = 1;
        if (i4 >= 30) {
            BiometricManager biometricManager = this.b;
            if (biometricManager == null) {
                return 1;
            }
            return biometricManager.canAuthenticate(i2);
        } else if (!m.e.T0(i2)) {
            return -2;
        } else {
            if (i2 != 0) {
                boolean z = false;
                if (w.b(((a) this.a).a) != null) {
                    if (m.e.N0(i2)) {
                        return w.d(((a) this.a).a) ? 0 : 11;
                    }
                    if (i4 == 29) {
                        if ((i2 & 255) == 255) {
                            BiometricManager biometricManager2 = this.b;
                            if (biometricManager2 != null) {
                                i5 = biometricManager2.canAuthenticate();
                            }
                        } else {
                            try {
                                method = BiometricManager.class.getMethod("canAuthenticate", BiometricPrompt.CryptoObject.class);
                            } catch (NoSuchMethodException unused) {
                                method = null;
                            }
                            if (!(method == null || (e2 = w.e(w.a())) == null)) {
                                try {
                                    invoke = method.invoke(this.b, e2);
                                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                                }
                                if (invoke instanceof Integer) {
                                    i3 = ((Integer) invoke).intValue();
                                    i5 = i3;
                                }
                            }
                            BiometricManager biometricManager3 = this.b;
                            if (biometricManager3 != null) {
                                i5 = biometricManager3.canAuthenticate();
                            }
                            Context context = ((a) this.a).a;
                            String str = Build.MODEL;
                            if (Build.VERSION.SDK_INT < 30) {
                                z = m.e.Q0(context, str, R$array.assume_strong_biometrics_models);
                            }
                            if (!z && i5 == 0) {
                                i3 = c();
                                i5 = i3;
                            }
                        }
                        return i5;
                    } else if (i4 != 28) {
                        return b();
                    } else {
                        if (w.c(((a) this.a).a)) {
                            return c();
                        }
                    }
                }
            }
            return 12;
        }
    }

    public final int b() {
        e.j.d.a.b bVar = this.c;
        if (bVar == null) {
            return 1;
        }
        if (!bVar.d()) {
            return 12;
        }
        return !this.c.c() ? 11 : 0;
    }

    public final int c() {
        if (!w.d(((a) this.a).a)) {
            return b();
        }
        return b() == 0 ? 0 : -1;
    }
}
