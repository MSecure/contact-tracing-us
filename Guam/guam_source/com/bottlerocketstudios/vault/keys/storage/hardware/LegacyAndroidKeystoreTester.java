package com.bottlerocketstudios.vault.keys.storage.hardware;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bottlerocketstudios.vault.keys.wrapper.AbstractAndroidKeystoreSecretKeyWrapper;
import java.security.GeneralSecurityException;

public class LegacyAndroidKeystoreTester extends AndroidKeystoreTester {
    public LegacyAndroidKeystoreTester(Context context, String str, int i) {
        super(context, str, i);
    }

    @Override // com.bottlerocketstudios.vault.keys.storage.hardware.AndroidKeystoreTester
    public AbstractAndroidKeystoreSecretKeyWrapper createKeystoreSecretKeyWrapper(Context context, String str) throws GeneralSecurityException {
        throw new UnsupportedOperationException("Tests should not be performed. This class is provided to read legacy test status.");
    }

    @Override // com.bottlerocketstudios.vault.keys.storage.hardware.AndroidKeystoreTester
    public String getAndroidKeystoreTestStateSharedPreferenceKey(String str) {
        return GeneratedOutlineSupport.outline8("androidKeystoreTestState.", str);
    }
}
