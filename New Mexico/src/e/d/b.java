package e.d;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.security.identity.IdentityCredential;
import e.d.c;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public class b extends BiometricPrompt.AuthenticationCallback {
    public final /* synthetic */ c.a a;

    public b(c.a aVar) {
        this.a = aVar;
    }

    @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
    public void onAuthenticationError(int i2, CharSequence charSequence) {
        this.a.a(i2, charSequence);
    }

    @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
    public void onAuthenticationFailed() {
        this.a.b();
    }

    @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
    }

    @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
        BiometricPrompt.CryptoObject cryptoObject;
        IdentityCredential identityCredential;
        s sVar = null;
        if (!(authenticationResult == null || (cryptoObject = authenticationResult.getCryptoObject()) == null)) {
            Cipher cipher = cryptoObject.getCipher();
            if (cipher != null) {
                sVar = new s(cipher);
            } else {
                Signature signature = cryptoObject.getSignature();
                if (signature != null) {
                    sVar = new s(signature);
                } else {
                    Mac mac = cryptoObject.getMac();
                    if (mac != null) {
                        sVar = new s(mac);
                    } else if (Build.VERSION.SDK_INT >= 30 && (identityCredential = cryptoObject.getIdentityCredential()) != null) {
                        sVar = new s(identityCredential);
                    }
                }
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        int i3 = -1;
        if (i2 >= 30) {
            if (authenticationResult != null) {
                i3 = authenticationResult.getAuthenticationType();
            }
        } else if (i2 != 29) {
            i3 = 2;
        }
        this.a.c(new r(sVar, i3));
    }
}
