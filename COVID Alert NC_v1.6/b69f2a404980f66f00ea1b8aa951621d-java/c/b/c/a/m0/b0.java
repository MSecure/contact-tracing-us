package c.b.c.a.m0;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public interface b0<T> {

    public static class a implements b0<Cipher> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.b.c.a.m0.b0
        public Cipher a(String str, Provider provider) {
            return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
        }
    }

    public static class b implements b0<KeyFactory> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.b.c.a.m0.b0
        public KeyFactory a(String str, Provider provider) {
            return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
        }
    }

    public static class c implements b0<KeyPairGenerator> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.b.c.a.m0.b0
        public KeyPairGenerator a(String str, Provider provider) {
            return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
        }
    }

    public static class d implements b0<Mac> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.b.c.a.m0.b0
        public Mac a(String str, Provider provider) {
            return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
        }
    }

    public static class e implements b0<MessageDigest> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.b.c.a.m0.b0
        public MessageDigest a(String str, Provider provider) {
            return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
        }
    }

    public static class f implements b0<Signature> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.b.c.a.m0.b0
        public Signature a(String str, Provider provider) {
            return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    T a(String str, Provider provider);
}
