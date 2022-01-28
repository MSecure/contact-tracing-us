package org.pathcheck.covidsafepaths.exposurenotifications.nearby;

import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.android.volley.toolbox.JsonObjectRequest;
import com.horcrux.svg.PathParser;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExposureConfigurations.kt */
public final class ExposureConfigurations$refresh$1<T> implements CallbackToFutureAdapter$Resolver<Unit> {
    public final /* synthetic */ ExposureConfigurations this$0;

    public ExposureConfigurations$refresh$1(ExposureConfigurations exposureConfigurations) {
        this.this$0 = exposureConfigurations;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
    public final Object attachCompleter(CallbackToFutureAdapter$Completer<Unit> callbackToFutureAdapter$Completer) {
        Intrinsics.checkNotNullParameter(callbackToFutureAdapter$Completer, "completer");
        ExposureConfigurations$refresh$1$responseListener$1 exposureConfigurations$refresh$1$responseListener$1 = new ExposureConfigurations$refresh$1$responseListener$1(this, callbackToFutureAdapter$Completer);
        ExposureConfigurations$refresh$1$errorListener$1 exposureConfigurations$refresh$1$errorListener$1 = new ExposureConfigurations$refresh$1$errorListener$1(callbackToFutureAdapter$Completer);
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Fetching configuration file from ");
        outline15.append(ExposureConfigurations.configurationUri);
        outline15.toString();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(ExposureConfigurations.configurationUri.toString(), null, exposureConfigurations$refresh$1$responseListener$1, exposureConfigurations$refresh$1$errorListener$1);
        jsonObjectRequest.mShouldCache = false;
        PathParser.get().add(jsonObjectRequest);
        return jsonObjectRequest;
    }
}
