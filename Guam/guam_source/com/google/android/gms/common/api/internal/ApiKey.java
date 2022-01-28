package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class ApiKey<O extends Api.ApiOptions> {
    public final int zab;
    public final Api<O> zac;
    public final O zad;

    public ApiKey(Api<O> api, O o) {
        this.zac = api;
        this.zad = o;
        this.zab = Arrays.hashCode(new Object[]{api, o});
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        return ReactYogaConfigProvider.equal(this.zac, apiKey.zac) && ReactYogaConfigProvider.equal(this.zad, apiKey.zad);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return this.zab;
    }
}
