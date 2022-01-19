package com.bottlerocketstudios.vault.keys.wrapper;

import android.content.Context;
import java.security.GeneralSecurityException;

public class AndroidKeystoreSecretKeyWrapper extends AbstractAndroidKeystoreSecretKeyWrapper {
    public static final String[] BLOCK_MODES = {"ECB"};
    public static final String[] DIGESTS = new String[0];
    public static final String[] ENCRYPTION_PADDING = {"PKCS1Padding"};

    public AndroidKeystoreSecretKeyWrapper(Context context, String str) throws GeneralSecurityException {
        super(context, str);
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
        return "RSA/ECB/PKCS1Padding";
    }
}
