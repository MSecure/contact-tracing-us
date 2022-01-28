package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArraySet;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zaf;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class GoogleApi<O extends Api.ApiOptions> {
    public final Context zaa;
    public final Api<O> zac;
    public final O zad;
    public final ApiKey<O> zae;
    public final int zag;
    public final ApiExceptionMapper zai;
    public final GoogleApiManager zaj;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static class Settings {
        @RecentlyNonNull
        public static final Settings DEFAULT_SETTINGS = new Settings(new ApiExceptionMapper(), null, Looper.getMainLooper());
        @RecentlyNonNull
        public final ApiExceptionMapper zaa;
        @RecentlyNonNull
        public final Looper zab;

        public Settings(ApiExceptionMapper apiExceptionMapper, Account account, Looper looper) {
            this.zaa = apiExceptionMapper;
            this.zab = looper;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1  */
    public GoogleApi(@RecentlyNonNull Context context, @RecentlyNonNull Api<O> api, @RecentlyNonNull O o, @RecentlyNonNull Settings settings) {
        ReactYogaConfigProvider.checkNotNull(context, "Null context is not permitted.");
        ReactYogaConfigProvider.checkNotNull(api, "Api must not be null.");
        ReactYogaConfigProvider.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zaa = context.getApplicationContext();
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 29) {
            if (Build.VERSION.SDK_INT < 30 || !Build.VERSION.CODENAME.equals("REL")) {
                if (Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'R' && Build.VERSION.CODENAME.charAt(0) <= 'Z') {
                    Boolean bool = ReactYogaConfigProvider.zza;
                    if (bool != null) {
                        z = bool.booleanValue();
                    } else {
                        try {
                            if (!"google".equals(Build.BRAND) || Build.ID.startsWith("RPP1") || Build.ID.startsWith("RPP2") || Integer.parseInt(Build.VERSION.INCREMENTAL) < 6301457) {
                                z = false;
                            }
                            ReactYogaConfigProvider.zza = Boolean.valueOf(z);
                        } catch (NumberFormatException unused) {
                            ReactYogaConfigProvider.zza = Boolean.TRUE;
                        }
                        if (!ReactYogaConfigProvider.zza.booleanValue()) {
                            Log.w("PlatformVersion", "Build version must be at least 6301457 to support R in gmscore");
                        }
                        z = ReactYogaConfigProvider.zza.booleanValue();
                    }
                }
            }
            if (z) {
                try {
                    String str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                }
            }
            this.zac = api;
            this.zad = null;
            this.zae = new ApiKey<>(api, null);
            GoogleApiManager zaa2 = GoogleApiManager.zaa(this.zaa);
            this.zaj = zaa2;
            this.zag = zaa2.zak.getAndIncrement();
            this.zai = settings.zaa;
            Handler handler = this.zaj.zaq;
            handler.sendMessage(handler.obtainMessage(7, this));
        }
        z = false;
        if (z) {
        }
        this.zac = api;
        this.zad = null;
        this.zae = new ApiKey<>(api, null);
        GoogleApiManager zaa22 = GoogleApiManager.zaa(this.zaa);
        this.zaj = zaa22;
        this.zag = zaa22.zak.getAndIncrement();
        this.zai = settings.zaa;
        Handler handler2 = this.zaj.zaq;
        handler2.sendMessage(handler2.obtainMessage(7, this));
    }

    @RecentlyNonNull
    public ClientSettings.Builder createClientSettingsBuilder() {
        Set<Scope> set;
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        O o = this.zad;
        Account account = null;
        if (!(o instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o).getGoogleSignInAccount()) == null) {
            O o2 = this.zad;
            if (o2 instanceof Api.ApiOptions.HasAccountOptions) {
                account = ((Api.ApiOptions.HasAccountOptions) o2).getAccount();
            }
        } else if (googleSignInAccount2.zae != null) {
            account = new Account(googleSignInAccount2.zae, "com.google");
        }
        builder.zaa = account;
        O o3 = this.zad;
        if (!(o3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o3).getGoogleSignInAccount()) == null) {
            set = Collections.emptySet();
        } else {
            set = googleSignInAccount.getRequestedScopes();
        }
        if (builder.zab == null) {
            builder.zab = new ArraySet<>(0);
        }
        builder.zab.addAll(set);
        builder.zae = this.zaa.getClass().getName();
        builder.zad = this.zaa.getPackageName();
        return builder;
    }

    public final <TResult, A> Task<TResult> zaa(int i, TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GoogleApiManager googleApiManager = this.zaj;
        ApiExceptionMapper apiExceptionMapper = this.zai;
        if (googleApiManager != null) {
            zaf zaf = new zaf(i, taskApiCall, taskCompletionSource, apiExceptionMapper);
            Handler handler = googleApiManager.zaq;
            handler.sendMessage(handler.obtainMessage(4, new zabr(zaf, googleApiManager.zal.get(), this)));
            return taskCompletionSource.zza;
        }
        throw null;
    }
}
