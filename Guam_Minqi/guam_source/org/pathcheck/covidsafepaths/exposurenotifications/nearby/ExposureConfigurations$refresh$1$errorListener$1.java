package org.pathcheck.covidsafepaths.exposurenotifications.nearby;

import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import com.android.volley.Response;
import com.android.volley.VolleyError;

/* compiled from: ExposureConfigurations.kt */
public final class ExposureConfigurations$refresh$1$errorListener$1 implements Response.ErrorListener {
    public final /* synthetic */ CallbackToFutureAdapter$Completer $completer;

    public ExposureConfigurations$refresh$1$errorListener$1(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.$completer = callbackToFutureAdapter$Completer;
    }

    @Override // com.android.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        Log.e("ExposureConfigurations", "Failed to fetch configuration: " + volleyError);
        this.$completer.setCancelled();
    }
}
