package com.bottlerocketstudios.vault.keys.wrapper;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.spec.AlgorithmParameterSpec;
import java.util.GregorianCalendar;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.security.auth.x500.X500Principal;

public abstract class AbstractAndroidKeystoreSecretKeyWrapper implements SecretKeyWrapper {
    public final String mAlias;
    public final Cipher mCipher = Cipher.getInstance(getTransformation());
    public final Context mContext;
    public KeyPair mKeyPair;

    @SuppressLint({"GetInstance"})
    public AbstractAndroidKeystoreSecretKeyWrapper(Context context, String str) throws GeneralSecurityException {
        this.mAlias = str;
        this.mContext = context.getApplicationContext();
    }

    public AlgorithmParameterSpec buildCipherAlgorithmParameterSpec() {
        return null;
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.SecretKeyWrapper
    public synchronized void clearKey(Context context) throws GeneralSecurityException, IOException {
        this.mKeyPair = null;
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load(null);
        instance.deleteEntry(this.mAlias);
    }

    @TargetApi(18)
    public final void generateKeyPair(Context context, String str) throws GeneralSecurityException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(12, -5);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.add(1, 100);
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(str, 7).setCertificateSubject(new X500Principal(GeneratedOutlineSupport.outline8("CN=", str))).setCertificateSerialNumber(BigInteger.ONE).setKeyValidityStart(gregorianCalendar.getTime()).setCertificateNotBefore(gregorianCalendar.getTime()).setKeyValidityEnd(gregorianCalendar2.getTime()).setCertificateNotAfter(gregorianCalendar2.getTime()).setEncryptionPaddings(getEncryptionPadding()).setBlockModes(getBlockModes()).setDigests(getDigests()).build();
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        instance.initialize(build);
        instance.generateKeyPair();
    }

    public abstract String[] getBlockModes();

    public abstract String[] getDigests();

    public abstract String[] getEncryptionPadding();

    public final KeyPair getKeyPair() throws GeneralSecurityException, IOException {
        synchronized (this.mAlias) {
            if (this.mKeyPair == null) {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                instance.load(null);
                if (!instance.containsAlias(this.mAlias)) {
                    generateKeyPair(this.mContext, this.mAlias);
                }
                KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) instance.getEntry(this.mAlias, null);
                this.mKeyPair = new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
            }
        }
        return this.mKeyPair;
    }

    public abstract String getTransformation();

    @Override // com.bottlerocketstudios.vault.keys.wrapper.SecretKeyWrapper
    public synchronized SecretKey unwrap(byte[] bArr, String str) throws GeneralSecurityException, IOException {
        AlgorithmParameterSpec buildCipherAlgorithmParameterSpec = buildCipherAlgorithmParameterSpec();
        if (buildCipherAlgorithmParameterSpec == null) {
            this.mCipher.init(4, getKeyPair().getPrivate());
        } else {
            this.mCipher.init(4, getKeyPair().getPrivate(), buildCipherAlgorithmParameterSpec);
        }
        return (SecretKey) this.mCipher.unwrap(bArr, str, 3);
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.SecretKeyWrapper
    public synchronized byte[] wrap(SecretKey secretKey) throws GeneralSecurityException, IOException {
        AlgorithmParameterSpec buildCipherAlgorithmParameterSpec = buildCipherAlgorithmParameterSpec();
        if (buildCipherAlgorithmParameterSpec == null) {
            this.mCipher.init(3, getKeyPair().getPublic());
        } else {
            this.mCipher.init(3, getKeyPair().getPublic(), buildCipherAlgorithmParameterSpec);
        }
        return this.mCipher.wrap(secretKey);
    }
}
