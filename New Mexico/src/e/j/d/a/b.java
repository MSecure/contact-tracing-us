package e.j.d.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
@Deprecated
/* loaded from: classes.dex */
public class b {
    public final Context a;

    /* loaded from: classes.dex */
    public static abstract class a {
    }

    /* renamed from: e.j.d.a.b$b */
    /* loaded from: classes.dex */
    public static class C0037b {
        public final Signature a;
        public final Cipher b;
        public final Mac c;

        public C0037b(Signature signature) {
            this.a = signature;
            this.b = null;
            this.c = null;
        }

        public C0037b(Cipher cipher) {
            this.b = cipher;
            this.a = null;
            this.c = null;
        }

        public C0037b(Mac mac) {
            this.c = mac;
            this.b = null;
            this.a = null;
        }
    }

    public b(Context context) {
        this.a = context;
    }

    public static FingerprintManager b(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 != 23 && (i2 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint"))) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    public void a(C0037b bVar, int i2, e.j.f.a aVar, a aVar2, Handler handler) {
        FingerprintManager b;
        CancellationSignal cancellationSignal;
        FingerprintManager.CryptoObject cryptoObject;
        FingerprintManager.CryptoObject cryptoObject2;
        Object obj;
        if (Build.VERSION.SDK_INT >= 23 && (b = b(this.a)) != null) {
            FingerprintManager.CryptoObject cryptoObject3 = null;
            if (aVar != null) {
                synchronized (aVar) {
                    if (aVar.c == null) {
                        CancellationSignal cancellationSignal2 = new CancellationSignal();
                        aVar.c = cancellationSignal2;
                        if (aVar.a) {
                            cancellationSignal2.cancel();
                        }
                    }
                    obj = aVar.c;
                }
                cancellationSignal = (CancellationSignal) obj;
            } else {
                cancellationSignal = null;
            }
            if (bVar != null) {
                if (bVar.b != null) {
                    cryptoObject2 = new FingerprintManager.CryptoObject(bVar.b);
                } else if (bVar.a != null) {
                    cryptoObject2 = new FingerprintManager.CryptoObject(bVar.a);
                } else if (bVar.c != null) {
                    cryptoObject3 = new FingerprintManager.CryptoObject(bVar.c);
                }
                cryptoObject = cryptoObject2;
                b.authenticate(cryptoObject, cancellationSignal, i2, new a(aVar2), null);
            }
            cryptoObject = cryptoObject3;
            b.authenticate(cryptoObject, cancellationSignal, i2, new a(aVar2), null);
        }
    }

    public boolean c() {
        FingerprintManager b;
        return Build.VERSION.SDK_INT >= 23 && (b = b(this.a)) != null && b.hasEnrolledFingerprints();
    }

    public boolean d() {
        FingerprintManager b;
        return Build.VERSION.SDK_INT >= 23 && (b = b(this.a)) != null && b.isHardwareDetected();
    }
}
