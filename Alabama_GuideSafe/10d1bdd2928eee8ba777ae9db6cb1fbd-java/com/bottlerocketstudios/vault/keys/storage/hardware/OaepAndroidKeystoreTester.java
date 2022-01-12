package com.bottlerocketstudios.vault.keys.storage.hardware;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bottlerocketstudios.vault.keys.wrapper.AbstractAndroidKeystoreSecretKeyWrapper;
import com.bottlerocketstudios.vault.keys.wrapper.AndroidOaepKeystoreSecretKeyWrapper;
import java.security.GeneralSecurityException;

public class OaepAndroidKeystoreTester extends AndroidKeystoreTester {
    public OaepAndroidKeystoreTester(Context context, String str, int i) {
        super(context, str, i);
    }

    @Override // com.bottlerocketstudios.vault.keys.storage.hardware.AndroidKeystoreTester
    public AbstractAndroidKeystoreSecretKeyWrapper createKeystoreSecretKeyWrapper(Context context, String str) throws GeneralSecurityException {
        return new AndroidOaepKeystoreSecretKeyWrapper(context, str);
    }

    @Override // com.bottlerocketstudios.vault.keys.storage.hardware.AndroidKeystoreTester
    public String getAndroidKeystoreTestStateSharedPreferenceKey(String str) {
        return GeneratedOutlineSupport.outline11("androidKeystoreTestState.", str, ".oaep.");
    }
}
