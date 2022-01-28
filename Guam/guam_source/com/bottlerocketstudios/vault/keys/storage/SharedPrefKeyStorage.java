package com.bottlerocketstudios.vault.keys.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bottlerocketstudios.vault.keys.wrapper.SecretKeyWrapper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;

public class SharedPrefKeyStorage implements KeyStorage {
    public SecretKey mCachedSecretKey;
    public final String mCipherAlgorithm;
    public final String mKeystoreAlias;
    public final String mPrefFileName;
    public final SecretKeyWrapper mSecretKeyWrapper;

    public SharedPrefKeyStorage(SecretKeyWrapper secretKeyWrapper, String str, String str2, String str3) {
        this.mSecretKeyWrapper = secretKeyWrapper;
        this.mPrefFileName = str;
        this.mKeystoreAlias = str2;
        this.mCipherAlgorithm = str3;
    }

    public void clearKey(Context context) {
        this.mCachedSecretKey = null;
        storeSecretKey(context, this.mKeystoreAlias, null);
        try {
            this.mSecretKeyWrapper.clearKey(context);
        } catch (IOException | GeneralSecurityException e) {
            Log.e("SharedPrefKeyStorage", "Failed to clearKey in wrapper", e);
        }
    }

    public String getSharedPreferenceKey(String str) {
        return GeneratedOutlineSupport.outline8("vaultedBlobV2.", str);
    }

    public SecretKey loadKey(Context context) {
        if (this.mCachedSecretKey == null) {
            synchronized ("keyLock") {
                if (this.mCachedSecretKey == null) {
                    String str = this.mKeystoreAlias;
                    String str2 = this.mCipherAlgorithm;
                    SecretKey secretKey = null;
                    String string = context.getSharedPreferences(this.mPrefFileName, 0).getString(getSharedPreferenceKey(str), null);
                    if (string != null) {
                        try {
                            secretKey = this.mSecretKeyWrapper.unwrap(Base64.decode(string, 0), str2);
                        } catch (IOException | RuntimeException | GeneralSecurityException e) {
                            Log.e("SharedPrefKeyStorage", "load failed", e);
                        }
                    }
                    this.mCachedSecretKey = secretKey;
                }
            }
        }
        return this.mCachedSecretKey;
    }

    public boolean saveKey(Context context, SecretKey secretKey) {
        boolean storeSecretKey;
        synchronized ("keyLock") {
            storeSecretKey = storeSecretKey(context, this.mKeystoreAlias, secretKey);
            if (!storeSecretKey) {
                secretKey = null;
            }
            this.mCachedSecretKey = secretKey;
        }
        return storeSecretKey;
    }

    public boolean storeSecretKey(Context context, String str, SecretKey secretKey) {
        SharedPreferences.Editor edit = context.getSharedPreferences(this.mPrefFileName, 0).edit();
        if (secretKey == null) {
            edit.remove(getSharedPreferenceKey(str));
            edit.apply();
            return true;
        }
        try {
            edit.putString(getSharedPreferenceKey(str), Base64.encodeToString(this.mSecretKeyWrapper.wrap(secretKey), 0));
            edit.apply();
            return true;
        } catch (IOException | RuntimeException | GeneralSecurityException e) {
            Log.e("SharedPrefKeyStorage", "save failed", e);
            return false;
        }
    }
}
