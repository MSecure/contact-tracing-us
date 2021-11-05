package b.t.a;

import android.security.keystore.KeyGenParameterSpec;
import c.a.a.a.a;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1733a;

    public b(String str, Object obj) {
        this.f1733a = str;
        KeyGenParameterSpec keyGenParameterSpec = (KeyGenParameterSpec) obj;
    }

    public String toString() {
        boolean z;
        StringBuilder g = a.g("MasterKey{keyAlias=");
        g.append(this.f1733a);
        g.append(", isKeyStoreBacked=");
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            z = instance.containsAlias(this.f1733a);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            z = false;
        }
        g.append(z);
        g.append("}");
        return g.toString();
    }
}
