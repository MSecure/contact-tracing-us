package org.pathcheck.covidsafepaths.helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.MainActivity;

/* compiled from: LocationHelper.kt */
public final class LocationHelper$receiver$1 extends BroadcastReceiver {
    public boolean isGpsEnabled;
    public boolean isNetworkEnabled;
    public final /* synthetic */ LocationHelper this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public LocationHelper$receiver$1(LocationHelper locationHelper) {
        this.this$0 = locationHelper;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            Intrinsics.checkNotNullExpressionValue(action, "action");
            Intrinsics.checkNotNullParameter("android.location.PROVIDERS_CHANGED", "pattern");
            Pattern compile = Pattern.compile("android.location.PROVIDERS_CHANGED");
            Intrinsics.checkNotNullExpressionValue(compile, "Pattern.compile(pattern)");
            Intrinsics.checkNotNullParameter(compile, "nativePattern");
            Intrinsics.checkNotNullParameter(action, "input");
            if (compile.matcher(action).matches()) {
                Object systemService = context.getSystemService("location");
                if (systemService != null) {
                    LocationManager locationManager = (LocationManager) systemService;
                    this.isGpsEnabled = locationManager.isProviderEnabled("gps");
                    boolean isProviderEnabled = locationManager.isProviderEnabled("network");
                    this.isNetworkEnabled = isProviderEnabled;
                    if (this.isGpsEnabled || isProviderEnabled) {
                        ((MainActivity.AnonymousClass2) this.this$0.callback).onLocationAvailable();
                    } else {
                        ((MainActivity.AnonymousClass2) this.this$0.callback).onLocationUnavailable();
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
                }
            }
        }
    }
}
