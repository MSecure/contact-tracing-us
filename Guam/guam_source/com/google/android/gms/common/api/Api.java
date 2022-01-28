package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class Api<O extends ApiOptions> {
    public final AbstractClientBuilder<?, O> zaa;
    public final String zac;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @RecentlyNonNull
        @Deprecated
        public T buildClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull ClientSettings clientSettings, @RecentlyNonNull O o, @RecentlyNonNull GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, @RecentlyNonNull GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
            return buildClient(context, looper, clientSettings, (Object) o, (ConnectionCallbacks) googleApiClient$ConnectionCallbacks, (OnConnectionFailedListener) googleApiClient$OnConnectionFailedListener);
        }

        @RecentlyNonNull
        public T buildClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull ClientSettings clientSettings, @RecentlyNonNull O o, @RecentlyNonNull ConnectionCallbacks connectionCallbacks, @RecentlyNonNull OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static class AnyClientKey<C> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public interface ApiOptions {

        /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
        public interface HasAccountOptions extends ApiOptions {
            @RecentlyNonNull
            Account getAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
        public interface HasGoogleSignInAccountOptions extends ApiOptions {
            @RecentlyNonNull
            GoogleSignInAccount getGoogleSignInAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
        public static final class NoOptions implements ApiOptions {
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static abstract class BaseClientBuilder<T, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public interface Client {
        void connect(@RecentlyNonNull BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        void disconnect();

        void disconnect(@RecentlyNonNull String str);

        @RecentlyNonNull
        Feature[] getAvailableFeatures();

        @RecentlyNonNull
        String getEndpointPackageName();

        @RecentlyNullable
        String getLastDisconnectMessage();

        @RecentlyNonNull
        int getMinApkVersion();

        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        Set<Scope> getScopesForConnectionlessNonSignIn();

        @RecentlyNonNull
        boolean isConnected();

        @RecentlyNonNull
        boolean isConnecting();

        void onUserSignOut(@RecentlyNonNull BaseGmsClient.SignOutCallbacks signOutCallbacks);

        @RecentlyNonNull
        boolean requiresGooglePlayServices();

        @RecentlyNonNull
        boolean requiresSignIn();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.android.gms.common.api.Api$AbstractClientBuilder<C extends com.google.android.gms.common.api.Api$Client, O extends com.google.android.gms.common.api.Api$ApiOptions> */
    /* JADX WARN: Multi-variable type inference failed */
    public <C extends Client> Api(@RecentlyNonNull String str, @RecentlyNonNull AbstractClientBuilder<C, O> abstractClientBuilder, @RecentlyNonNull ClientKey<C> clientKey) {
        ReactYogaConfigProvider.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        ReactYogaConfigProvider.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
        this.zac = str;
        this.zaa = abstractClientBuilder;
    }
}
