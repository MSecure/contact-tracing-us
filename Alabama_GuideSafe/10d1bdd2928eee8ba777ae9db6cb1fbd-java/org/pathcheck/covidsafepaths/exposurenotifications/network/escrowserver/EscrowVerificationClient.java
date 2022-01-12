package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import android.content.Context;
import com.google.common.util.concurrent.MoreExecutors;
import kotlin.Lazy;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences;
import org.pathcheck.covidsafepaths.exposurenotifications.utils.Result;

/* compiled from: EscrowVerificationClient.kt */
public final class EscrowVerificationClient {
    public static final EscrowVerificationClient INSTANCE = new EscrowVerificationClient();
    public static ExposureNotificationSharedPreferences prefs;
    public static final Lazy retrofit$delegate;
    public static final Lazy service$delegate;

    static {
        EscrowVerificationClient$retrofit$2 escrowVerificationClient$retrofit$2 = EscrowVerificationClient$retrofit$2.INSTANCE;
        Intrinsics.checkNotNullParameter(escrowVerificationClient$retrofit$2, "initializer");
        retrofit$delegate = new SynchronizedLazyImpl(escrowVerificationClient$retrofit$2, null, 2);
        EscrowVerificationClient$service$2 escrowVerificationClient$service$2 = EscrowVerificationClient$service$2.INSTANCE;
        Intrinsics.checkNotNullParameter(escrowVerificationClient$service$2, "initializer");
        service$delegate = new SynchronizedLazyImpl(escrowVerificationClient$service$2, null, 2);
    }

    public static final IBackendService access$getService$p(EscrowVerificationClient escrowVerificationClient) {
        return (IBackendService) service$delegate.getValue();
    }

    public static final ExposureNotificationSharedPreferences access$getSharedPrefs(EscrowVerificationClient escrowVerificationClient, Context context) {
        if (prefs == null) {
            prefs = new ExposureNotificationSharedPreferences(context);
        }
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = prefs;
        Intrinsics.checkNotNull(exposureNotificationSharedPreferences);
        return exposureNotificationSharedPreferences;
    }

    public final Object postPositiveSubmission(Context context, PositiveSubmission positiveSubmission, int i, Continuation<? super Result<Unit>> continuation) {
        return MoreExecutors.coroutineScope(new EscrowVerificationClient$postPositiveSubmission$2(positiveSubmission, context, i, null), continuation);
    }
}
