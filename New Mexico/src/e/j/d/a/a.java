package e.j.d.a;

import android.hardware.fingerprint.FingerprintManager;
import e.d.r;
import e.d.u;
import e.j.d.a.b;
import e.r.s;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public class a extends FingerprintManager.AuthenticationCallback {
    public final /* synthetic */ b.a a;

    public a(b.a aVar) {
        this.a = aVar;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i2, CharSequence charSequence) {
        ((e.d.a) this.a).a.c.a(i2, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        ((e.d.a) this.a).a.c.b();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        u.b bVar = (u.b) ((e.d.a) this.a).a.c;
        if (bVar.a.get() != null) {
            u uVar = bVar.a.get();
            if (uVar.s == null) {
                uVar.s = new s<>();
            }
            u.o(uVar.s, charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        b.C0037b bVar;
        b.a aVar = this.a;
        FingerprintManager.CryptoObject cryptoObject = authenticationResult.getCryptoObject();
        e.d.s sVar = null;
        if (cryptoObject != null) {
            if (cryptoObject.getCipher() != null) {
                bVar = new b.C0037b(cryptoObject.getCipher());
            } else if (cryptoObject.getSignature() != null) {
                bVar = new b.C0037b(cryptoObject.getSignature());
            } else if (cryptoObject.getMac() != null) {
                bVar = new b.C0037b(cryptoObject.getMac());
            }
            e.d.a aVar2 = (e.d.a) aVar;
            if (bVar != null) {
                Cipher cipher = bVar.b;
                if (cipher != null) {
                    sVar = new e.d.s(cipher);
                } else {
                    Signature signature = bVar.a;
                    if (signature != null) {
                        sVar = new e.d.s(signature);
                    } else {
                        Mac mac = bVar.c;
                        if (mac != null) {
                            sVar = new e.d.s(mac);
                        }
                    }
                }
            }
            aVar2.a.c.c(new r(sVar, 2));
        }
        bVar = null;
        e.d.a aVar22 = (e.d.a) aVar;
        if (bVar != null) {
        }
        aVar22.a.c.c(new r(sVar, 2));
    }
}
