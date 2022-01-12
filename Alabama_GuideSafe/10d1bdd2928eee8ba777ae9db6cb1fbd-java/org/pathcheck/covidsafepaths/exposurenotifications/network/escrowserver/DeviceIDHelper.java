package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.common.io.BaseEncoding;
import com.google.common.util.concurrent.MoreExecutors;
import java.security.SecureRandom;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DeviceIDHelper.kt */
public final class DeviceIDHelper {
    public static final BaseEncoding BASE64_LOWER = BaseEncoding.BASE64;
    public static final DeviceIDHelper INSTANCE = new DeviceIDHelper();
    public static final SecureRandom secureRandom = new SecureRandom();

    public final Object getDeviceID(String str, Context context, Continuation<? super String> continuation) {
        if (GoogleApiAvailability.zab.isGooglePlayServicesAvailable(context, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0) {
            Log.w("DeviceIDHelper", "SUCCESS");
        } else {
            Log.w("DeviceIDHelper", "FAILURE, DOWNLOAD GOOGLE PLAY SERVICES");
        }
        return MoreExecutors.withContext(Dispatchers.IO, new DeviceIDHelper$getDeviceID$2(context, str, null), continuation);
    }
}
