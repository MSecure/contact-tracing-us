package com.bottlerocketstudios.vault.keys.storage.hardware;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bottlerocketstudios.vault.keys.storage.AndroidKeystoreTestState;
import com.bottlerocketstudios.vault.keys.wrapper.AbstractAndroidKeystoreSecretKeyWrapper;
import java.security.GeneralSecurityException;

public abstract class AndroidKeystoreTester {
    public final Context mContext;
    public final int mCurrentSdkInt;
    public final String mKeystoreAlias;
    public final String mTestKeystoreAlias;

    public AndroidKeystoreTester(Context context, String str, int i) {
        this.mContext = context;
        this.mKeystoreAlias = str;
        this.mTestKeystoreAlias = GeneratedOutlineSupport.outline10(str, "___TEST___");
        this.mCurrentSdkInt = i;
    }

    public abstract AbstractAndroidKeystoreSecretKeyWrapper createKeystoreSecretKeyWrapper(Context context, String str) throws GeneralSecurityException;

    public abstract String getAndroidKeystoreTestStateSharedPreferenceKey(String str);

    public AndroidKeystoreTestState readAndroidKeystoreTestState(SharedPreferences sharedPreferences) {
        try {
            return AndroidKeystoreTestState.valueOf(sharedPreferences.getString(getAndroidKeystoreTestStateSharedPreferenceKey(this.mKeystoreAlias), "UNTESTED"));
        } catch (IllegalArgumentException unused) {
            Log.e("AndroidKeystoreTester", "Failed to parse previous test state");
            return AndroidKeystoreTestState.UNTESTED;
        }
    }
}
