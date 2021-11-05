package b.u.a;

import android.security.keystore.KeyGenParameterSpec;
import c.a.a.a.a;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f2607a;

    public b(String str, Object obj) {
        this.f2607a = str;
        KeyGenParameterSpec keyGenParameterSpec = (KeyGenParameterSpec) obj;
    }

    public String toString() {
        boolean z;
        StringBuilder h = a.h("MasterKey{keyAlias=");
        h.append(this.f2607a);
        h.append(", isKeyStoreBacked=");
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            z = instance.containsAlias(this.f2607a);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            z = false;
        }
        h.append(z);
        h.append("}");
        return h.toString();
    }
}
