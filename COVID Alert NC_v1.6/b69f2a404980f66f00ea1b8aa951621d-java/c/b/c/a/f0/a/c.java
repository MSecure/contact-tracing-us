package c.b.c.a.f0.a;

import android.security.keystore.KeyGenParameterSpec;
import androidx.recyclerview.widget.RecyclerView;
import c.b.c.a.m;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

public final class c implements m {

    /* renamed from: a  reason: collision with root package name */
    public final String f3460a;

    /* renamed from: b  reason: collision with root package name */
    public final KeyStore f3461b;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f3462a = null;

        /* renamed from: b  reason: collision with root package name */
        public KeyStore f3463b = null;

        public b() {
            c.c();
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                this.f3463b = instance;
                instance.load(null);
            } catch (IOException | GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public c() {
        b bVar = new b();
        this.f3460a = bVar.f3462a;
        this.f3461b = bVar.f3463b;
    }

    public static boolean c() {
        return true;
    }

    public static void d(String str) {
        if (!new b().f3463b.containsAlias(n0.b("android-keystore://", str))) {
            String b2 = n0.b("android-keystore://", str);
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init(new KeyGenParameterSpec.Builder(b2, 3).setKeySize(RecyclerView.d0.FLAG_TMP_DETACHED).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
            instance.generateKey();
            return;
        }
        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str));
    }

    @Override // c.b.c.a.m
    public c.b.c.a.a a(String str) {
        String str2 = this.f3460a;
        if (str2 == null || str2.equals(str)) {
            b bVar = new b(n0.b("android-keystore://", str), this.f3461b);
            byte[] a2 = i0.a(10);
            byte[] bArr = new byte[0];
            if (Arrays.equals(a2, bVar.b(bVar.a(a2, bArr), bArr))) {
                return bVar;
            }
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.f3460a, str));
    }

    @Override // c.b.c.a.m
    public boolean b(String str) {
        String str2 = this.f3460a;
        if (str2 == null || !str2.equals(str)) {
            return this.f3460a == null && str.toLowerCase(Locale.US).startsWith("android-keystore://");
        }
        return true;
    }

    public c(b bVar, a aVar) {
        this.f3460a = bVar.f3462a;
        this.f3461b = bVar.f3463b;
    }
}
