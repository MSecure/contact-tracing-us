package b.u.a;

import android.security.keystore.KeyGenParameterSpec;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.ProviderException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

@Deprecated
public final class c {
    static {
        new KeyGenParameterSpec.Builder("_androidx_security_master_key_", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(RecyclerView.a0.FLAG_TMP_DETACHED).build();
    }

    public static String a(KeyGenParameterSpec keyGenParameterSpec) {
        if (keyGenParameterSpec.getKeySize() != 256) {
            StringBuilder h = a.h("invalid key size, want 256 bits got ");
            h.append(keyGenParameterSpec.getKeySize());
            h.append(" bits");
            throw new IllegalArgumentException(h.toString());
        } else if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{"GCM"})) {
            StringBuilder h2 = a.h("invalid block mode, want GCM got ");
            h2.append(Arrays.toString(keyGenParameterSpec.getBlockModes()));
            throw new IllegalArgumentException(h2.toString());
        } else if (keyGenParameterSpec.getPurposes() != 3) {
            StringBuilder h3 = a.h("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got ");
            h3.append(keyGenParameterSpec.getPurposes());
            throw new IllegalArgumentException(h3.toString());
        } else if (!Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
            StringBuilder h4 = a.h("invalid padding mode, want NoPadding got ");
            h4.append(Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
            throw new IllegalArgumentException(h4.toString());
        } else if (!keyGenParameterSpec.isUserAuthenticationRequired() || keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() >= 1) {
            String keystoreAlias = keyGenParameterSpec.getKeystoreAlias();
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (!instance.containsAlias(keystoreAlias)) {
                try {
                    KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    instance2.init(keyGenParameterSpec);
                    instance2.generateKey();
                } catch (ProviderException e2) {
                    throw new GeneralSecurityException(e2.getMessage(), e2);
                }
            }
            return keyGenParameterSpec.getKeystoreAlias();
        } else {
            throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
        }
    }
}
