package com.bottlerocketstudios.vault.keys.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bottlerocketstudios.vault.keys.storage.hardware.AndroidKeystoreTester;
import com.bottlerocketstudios.vault.keys.wrapper.AbstractAndroidKeystoreSecretKeyWrapper;
import com.bottlerocketstudios.vault.keys.wrapper.AndroidKeystoreSecretKeyWrapper;
import com.bottlerocketstudios.vault.keys.wrapper.AndroidOaepKeystoreSecretKeyWrapper;
import com.bottlerocketstudios.vault.keys.wrapper.ObfuscatingSecretKeyWrapper;
import com.bottlerocketstudios.vault.keys.wrapper.SecretKeyWrapper;
import com.bottlerocketstudios.vault.salt.PrngSaltGenerator;
import com.pedrouid.crypto.RNSCAes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CompatSharedPrefKeyStorageFactory {
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0085  */
    public static boolean canUseAndroidKeystore(AndroidKeystoreTester androidKeystoreTester, SharedPreferences sharedPreferences) {
        AndroidKeystoreTestState androidKeystoreTestState = AndroidKeystoreTestState.PASS;
        AndroidKeystoreTestState readAndroidKeystoreTestState = androidKeystoreTester.readAndroidKeystoreTestState(sharedPreferences);
        if (AndroidKeystoreTestState.UNTESTED.equals(readAndroidKeystoreTestState)) {
            AndroidKeystoreTestState androidKeystoreTestState2 = AndroidKeystoreTestState.FAIL;
            if (androidKeystoreTester.mCurrentSdkInt >= 18) {
                AbstractAndroidKeystoreSecretKeyWrapper abstractAndroidKeystoreSecretKeyWrapper = null;
                try {
                    AbstractAndroidKeystoreSecretKeyWrapper createKeystoreSecretKeyWrapper = androidKeystoreTester.createKeystoreSecretKeyWrapper(androidKeystoreTester.mContext, androidKeystoreTester.mTestKeystoreAlias);
                    boolean z = false;
                    if (createKeystoreSecretKeyWrapper.getKeyPair() != null) {
                        SecretKey createKey = AppCompatDelegateImpl.ConfigurationImplApi17.createKey();
                        SecretKey unwrap = createKeystoreSecretKeyWrapper.unwrap(createKeystoreSecretKeyWrapper.wrap(createKey), RNSCAes.KEY_ALGORITHM);
                        if (unwrap != null && Arrays.equals(unwrap.getEncoded(), ((SecretKeySpec) createKey).getEncoded())) {
                            z = true;
                        }
                    }
                    AndroidKeystoreTestState androidKeystoreTestState3 = z ? androidKeystoreTestState : androidKeystoreTestState2;
                    try {
                        createKeystoreSecretKeyWrapper.clearKey(androidKeystoreTester.mContext);
                    } catch (Throwable th) {
                        Log.e("AndroidKeystoreTester", "Caught an exception while cleaning up the AndroidKeystoreSecretKeyWrapper", th);
                    }
                    readAndroidKeystoreTestState = androidKeystoreTestState3;
                } catch (Throwable th2) {
                    Log.e("AndroidKeystoreTester", "Caught an exception while cleaning up the AndroidKeystoreSecretKeyWrapper", th2);
                }
                if (androidKeystoreTestState2.equals(readAndroidKeystoreTestState)) {
                    Log.w("AndroidKeystoreTester", "This device failed the AndroidKeystoreSecretKeyWrapper test.");
                }
                sharedPreferences.edit().putString(androidKeystoreTester.getAndroidKeystoreTestStateSharedPreferenceKey(androidKeystoreTester.mKeystoreAlias), readAndroidKeystoreTestState.toString()).apply();
            }
            readAndroidKeystoreTestState = androidKeystoreTestState2;
            if (androidKeystoreTestState2.equals(readAndroidKeystoreTestState)) {
            }
            sharedPreferences.edit().putString(androidKeystoreTester.getAndroidKeystoreTestStateSharedPreferenceKey(androidKeystoreTester.mKeystoreAlias), readAndroidKeystoreTestState.toString()).apply();
        }
        return androidKeystoreTestState.equals(readAndroidKeystoreTestState);
    }

    public static KeyStorage createKeyStorageForWrapperType(Context context, int i, String str, String str2, int i2, String str3, String str4, PrngSaltGenerator prngSaltGenerator) throws GeneralSecurityException {
        SecretKeyWrapper secretKeyWrapper;
        if (i == 1) {
            secretKeyWrapper = new ObfuscatingSecretKeyWrapper(context, i2, prngSaltGenerator, str4);
        } else if (i == 2) {
            secretKeyWrapper = new AndroidKeystoreSecretKeyWrapper(context, str2);
        } else if (i == 3) {
            secretKeyWrapper = new AndroidOaepKeystoreSecretKeyWrapper(context, str2);
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline6("Wrapper type ", i, " is invalid."));
        }
        return new SharedPrefKeyStorage(secretKeyWrapper, str, str2, str3);
    }
}
