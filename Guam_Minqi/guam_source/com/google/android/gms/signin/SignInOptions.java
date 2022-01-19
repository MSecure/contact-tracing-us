package com.google.android.gms.signin;

import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class SignInOptions implements Api.ApiOptions {
    @RecentlyNonNull
    public static final SignInOptions zaa = new SignInOptions();

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        SignInOptions signInOptions = (SignInOptions) obj;
        return ReactYogaConfigProvider.equal(null, null) && ReactYogaConfigProvider.equal(null, null) && ReactYogaConfigProvider.equal(null, null) && ReactYogaConfigProvider.equal(null, null) && ReactYogaConfigProvider.equal(null, null);
    }

    @RecentlyNonNull
    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
