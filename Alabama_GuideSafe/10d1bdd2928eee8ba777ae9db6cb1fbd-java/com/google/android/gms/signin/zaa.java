package com.google.android.gms.signin;

import android.text.TextUtils;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaa {
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zaa = new zac();
    public static final Api.ClientKey<SignInClientImpl> zac = new Api.ClientKey<>();
    public static final Api.ClientKey<SignInClientImpl> zad = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<SignInClientImpl, zae> zae = new zab();

    static {
        if (TextUtils.isEmpty("profile")) {
            throw new IllegalArgumentException("scopeUri must not be null or empty");
        } else if (!TextUtils.isEmpty("email")) {
            Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> abstractClientBuilder = zaa;
            Api.ClientKey<SignInClientImpl> clientKey = zac;
            ReactYogaConfigProvider.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
            ReactYogaConfigProvider.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
            Api.AbstractClientBuilder<SignInClientImpl, zae> abstractClientBuilder2 = zae;
            Api.ClientKey<SignInClientImpl> clientKey2 = zad;
            ReactYogaConfigProvider.checkNotNull(abstractClientBuilder2, "Cannot construct an Api with a null ClientBuilder");
            ReactYogaConfigProvider.checkNotNull(clientKey2, "Cannot construct an Api with a null ClientKey");
        } else {
            throw new IllegalArgumentException("scopeUri must not be null or empty");
        }
    }
}
