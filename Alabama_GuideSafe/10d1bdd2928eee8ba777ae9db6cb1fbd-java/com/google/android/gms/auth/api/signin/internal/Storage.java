package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class Storage {
    public static final Lock zaa = new ReentrantLock();
    public static Storage zab;
    public final Lock zac = new ReentrantLock();
    public final SharedPreferences zad;

    public Storage(Context context) {
        this.zad = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @RecentlyNonNull
    public static Storage getInstance(@RecentlyNonNull Context context) {
        ReactYogaConfigProvider.checkNotNull(context);
        zaa.lock();
        try {
            if (zab == null) {
                zab = new Storage(context.getApplicationContext());
            }
            return zab;
        } finally {
            zaa.unlock();
        }
    }

    @RecentlyNullable
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String zac2 = zac("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zac2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(zac2).length() + 20);
        sb.append("googleSignInAccount");
        sb.append(ColorPropConverter.PACKAGE_DELIMITER);
        sb.append(zac2);
        String zac3 = zac(sb.toString());
        if (zac3 == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zaa(zac3);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String zac(String str) {
        this.zac.lock();
        try {
            return this.zad.getString(str, null);
        } finally {
            this.zac.unlock();
        }
    }
}
