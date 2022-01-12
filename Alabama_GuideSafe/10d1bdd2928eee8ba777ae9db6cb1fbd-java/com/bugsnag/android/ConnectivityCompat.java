package com.bugsnag.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import com.google.common.util.concurrent.MoreExecutors;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectivityCompat.kt */
public final class ConnectivityCompat implements Connectivity {
    public final ConnectivityManager cm;
    public final Connectivity connectivity;

    public ConnectivityCompat(Context context, Function2<? super Boolean, ? super String, Unit> function2) {
        Connectivity connectivity2;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            this.cm = connectivityManager;
            if (Build.VERSION.SDK_INT >= 24) {
                connectivity2 = new ConnectivityApi24(connectivityManager, function2);
            } else {
                connectivity2 = new ConnectivityLegacy(context, connectivityManager, function2);
            }
            this.connectivity = connectivity2;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    @Override // com.bugsnag.android.Connectivity
    public boolean hasNetworkConnection() {
        Object obj;
        try {
            obj = Boolean.valueOf(this.connectivity.hasNetworkConnection());
        } catch (Throwable th) {
            obj = MoreExecutors.createFailure(th);
        }
        if (Result.m10exceptionOrNullimpl(obj) != null) {
            obj = Boolean.TRUE;
        }
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.bugsnag.android.Connectivity
    public void registerForNetworkChanges() {
        try {
            this.connectivity.registerForNetworkChanges();
        } catch (Throwable th) {
            MoreExecutors.createFailure(th);
        }
    }

    @Override // com.bugsnag.android.Connectivity
    public String retrieveNetworkAccessState() {
        Object obj;
        try {
            obj = this.connectivity.retrieveNetworkAccessState();
        } catch (Throwable th) {
            obj = MoreExecutors.createFailure(th);
        }
        if (Result.m10exceptionOrNullimpl(obj) != null) {
            obj = "unknown";
        }
        return (String) obj;
    }
}
