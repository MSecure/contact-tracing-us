package e.d;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.security.identity.IdentityCredential;
import android.security.keystore.KeyGenParameterSpec;
import e.b.a.m;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class w {
    public static s a() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            KeyGenParameterSpec.Builder J = m.e.J("androidxBiometric", 3);
            m.e.v1(J);
            m.e.w1(J);
            KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance2.init(J.build());
            instance2.generateKey();
            Cipher instance3 = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance3.init(1, (SecretKey) instance.getKey("androidxBiometric", null));
            return new s(instance3);
        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableKeyException | CertificateException | NoSuchPaddingException unused) {
            return null;
        }
    }

    public static KeyguardManager b(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return (KeyguardManager) context.getSystemService(KeyguardManager.class);
        }
        Object systemService = context.getSystemService("keyguard");
        if (systemService instanceof KeyguardManager) {
            return (KeyguardManager) systemService;
        }
        return null;
    }

    public static boolean c(Context context) {
        return Build.VERSION.SDK_INT >= 23 && context != null && context.getPackageManager() != null && context.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
    }

    public static boolean d(Context context) {
        KeyguardManager b = b(context);
        if (b == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return b.isDeviceSecure();
        }
        return b.isKeyguardSecure();
    }

    public static BiometricPrompt.CryptoObject e(s sVar) {
        IdentityCredential identityCredential;
        if (sVar == null) {
            return null;
        }
        Cipher cipher = sVar.b;
        if (cipher != null) {
            return new BiometricPrompt.CryptoObject(cipher);
        }
        Signature signature = sVar.a;
        if (signature != null) {
            return new BiometricPrompt.CryptoObject(signature);
        }
        Mac mac = sVar.c;
        if (mac != null) {
            return new BiometricPrompt.CryptoObject(mac);
        }
        if (Build.VERSION.SDK_INT < 30 || (identityCredential = sVar.f1264d) == null) {
            return null;
        }
        return new BiometricPrompt.CryptoObject(identityCredential);
    }
}
