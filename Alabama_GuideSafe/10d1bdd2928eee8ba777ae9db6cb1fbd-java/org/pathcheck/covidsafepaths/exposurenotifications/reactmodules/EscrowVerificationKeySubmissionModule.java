package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.common.util.concurrent.Futures$CallbackListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;
import org.pathcheck.covidsafepaths.exposurenotifications.common.AppExecutors;

@ReactModule(name = ExposureKeyModule.MODULE_NAME)
/* compiled from: EscrowVerificationKeySubmissionModule.kt */
public final class EscrowVerificationKeySubmissionModule extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion(null);
    public static final String MODULE_NAME = "EscrowVerificationKeySubmissionModule";
    public static final int NO_KEYS_ERROR_CODE = 999;

    /* compiled from: EscrowVerificationKeySubmissionModule.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public EscrowVerificationKeySubmissionModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public final void submitDiagnosisKeys(String str, double d, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "verificationCode");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        ListenableFuture<List<TemporaryExposureKey>> requestPermissionToGetExposureKeys = ExposureNotificationClientWrapper.get(getReactApplicationContext()).requestPermissionToGetExposureKeys(getReactApplicationContext());
        EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1 escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1 = new EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1(this, d, str, promise);
        ListeningExecutorService lightweightExecutor = AppExecutors.getLightweightExecutor();
        ((CallbackToFutureAdapter$SafeFuture) requestPermissionToGetExposureKeys).addListener(new Futures$CallbackListener(requestPermissionToGetExposureKeys, escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1), lightweightExecutor);
    }

    @ReactMethod
    public final void submitPhoneNumber(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        ListenableFuture<List<TemporaryExposureKey>> requestPermissionToGetExposureKeys = ExposureNotificationClientWrapper.get(getReactApplicationContext()).requestPermissionToGetExposureKeys(getReactApplicationContext());
        EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1 escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1 = new EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1(this, str, promise);
        ListeningExecutorService lightweightExecutor = AppExecutors.getLightweightExecutor();
        ((CallbackToFutureAdapter$SafeFuture) requestPermissionToGetExposureKeys).addListener(new Futures$CallbackListener(requestPermissionToGetExposureKeys, escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1), lightweightExecutor);
    }
}
