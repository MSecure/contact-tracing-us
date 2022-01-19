package com.bottlerocketstudios.vault.keys.wrapper;

import android.annotation.TargetApi;
import android.content.Context;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

@TargetApi(23)
public class AndroidOaepKeystoreSecretKeyWrapper extends AbstractAndroidKeystoreSecretKeyWrapper {
    public static final String[] BLOCK_MODES = {"ECB"};
    public static final String[] DIGESTS = {"SHA-256"};
    public static final String[] ENCRYPTION_PADDING = {"OAEPPadding"};

    public AndroidOaepKeystoreSecretKeyWrapper(Context context, String str) throws GeneralSecurityException {
        super(context, str);
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.AbstractAndroidKeystoreSecretKeyWrapper
    public AlgorithmParameterSpec buildCipherAlgorithmParameterSpec() {
        return new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.AbstractAndroidKeystoreSecretKeyWrapper
    public String[] getBlockModes() {
        return BLOCK_MODES;
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.AbstractAndroidKeystoreSecretKeyWrapper
    public String[] getDigests() {
        return DIGESTS;
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.AbstractAndroidKeystoreSecretKeyWrapper
    public String[] getEncryptionPadding() {
        return ENCRYPTION_PADDING;
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.AbstractAndroidKeystoreSecretKeyWrapper
    public String getTransformation() {
        return "RSA/ECB/OAEPwithSHA-256andMGF1Padding";
    }
}
