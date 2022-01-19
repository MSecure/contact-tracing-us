package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures$CallbackListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.horcrux.svg.PathParser;
import io.realm.Realm;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;
import org.pathcheck.covidsafepaths.exposurenotifications.common.AppExecutors;
import org.pathcheck.covidsafepaths.exposurenotifications.common.NotificationHelper;
import org.pathcheck.covidsafepaths.exposurenotifications.dto.RNDiagnosisKey;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte$insertExposure$$inlined$use$lambda$1;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte$resetExposures$1$1;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity;
import org.threeten.bp.Instant;

@ReactModule(name = DebugMenuModule.MODULE_NAME)
public class DebugMenuModule extends ReactContextBaseJavaModule {
    public static final String MODULE_NAME = "DebugMenuModule";

    public DebugMenuModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private Long getRandomExposureDate() {
        return Long.valueOf(Instant.now().toEpochMilli() - ((long) ((((new SecureRandom().nextInt(13) * 24) * 60) * 60) * 1000)));
    }

    @ReactMethod
    public void fetchDiagnosisKeys(final Promise promise) {
        ExposureNotificationClientWrapper exposureNotificationClientWrapper = ExposureNotificationClientWrapper.get(getReactApplicationContext());
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        AnonymousClass1 r2 = new FutureCallback<List<TemporaryExposureKey>>(this) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.DebugMenuModule.AnonymousClass1 */

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                promise.reject(th);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(List<TemporaryExposureKey> list) {
                ArrayList arrayList = new ArrayList();
                for (TemporaryExposureKey temporaryExposureKey : list) {
                    arrayList.add(new RNDiagnosisKey((long) temporaryExposureKey.zzb));
                }
                promise.resolve(PathParser.convertListToWritableArray(arrayList));
            }
        };
        ListenableFuture<List<TemporaryExposureKey>> requestPermissionToGetExposureKeys = exposureNotificationClientWrapper.requestPermissionToGetExposureKeys(reactApplicationContext);
        ListeningExecutorService lightweightExecutor = AppExecutors.getLightweightExecutor();
        ((CallbackToFutureAdapter$SafeFuture) requestPermissionToGetExposureKeys).addListener(new Futures$CallbackListener(requestPermissionToGetExposureKeys, r2), lightweightExecutor);
    }

    @ReactMethod
    public void forceAppCrash(Promise promise) throws Exception {
        throw new Exception("Force crash");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    public void lambda$toggleExposureNotifications$0$DebugMenuModule(ExposureNotificationClientWrapper exposureNotificationClientWrapper, ReactContext reactContext, final Promise promise, Boolean bool) {
        if (bool.booleanValue()) {
            Task<Void> stopTracing = exposureNotificationClientWrapper.stopTracing(reactContext);
            promise.getClass();
            stopTracing.addOnSuccessListener(new OnSuccessListener() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$owfeFXC4QiqgWJqnrp9II8tK0js */

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    Promise.this.resolve((Void) obj);
                }
            });
            promise.getClass();
            stopTracing.addOnFailureListener(new OnFailureListener() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$4FnuZITwpTidBCa7qe8kzCWQ6s */

                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Promise.this.reject(exc);
                }
            });
            return;
        }
        AnonymousClass2 r4 = new FutureCallback<Void>(this) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.DebugMenuModule.AnonymousClass2 */

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                promise.reject(th);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r2) {
                promise.resolve(r2);
            }
        };
        ListenableFuture<Void> requestPermissionToStartTracing = exposureNotificationClientWrapper.requestPermissionToStartTracing(reactContext);
        ListeningExecutorService lightweightExecutor = AppExecutors.getLightweightExecutor();
        ((CallbackToFutureAdapter$SafeFuture) requestPermissionToStartTracing).addListener(new Futures$CallbackListener(requestPermissionToStartTracing, r4), lightweightExecutor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        com.horcrux.svg.PathParser.closeFinally(r0, r3);
     */
    @ReactMethod
    public void resetExposures(Promise promise) {
        Realm realmInstance = RealmSecureStorageBte.INSTANCE.getRealmInstance();
        realmInstance.executeTransaction(RealmSecureStorageBte$resetExposures$1$1.INSTANCE);
        PathParser.closeFinally(realmInstance, null);
        promise.resolve(null);
    }

    @ReactMethod
    public void showLastProcessedFilePath(Promise promise) {
        promise.resolve(RealmSecureStorageBte.INSTANCE.getLastProcessedKeyZipFileName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        com.horcrux.svg.PathParser.closeFinally(r0, r7);
     */
    @ReactMethod
    public void simulateExposure(Promise promise) {
        RealmSecureStorageBte realmSecureStorageBte = RealmSecureStorageBte.INSTANCE;
        ExposureEntity exposureEntity = new ExposureEntity(getRandomExposureDate().longValue(), Instant.now().toEpochMilli());
        Intrinsics.checkNotNullParameter(exposureEntity, "exposure");
        Realm realmInstance = realmSecureStorageBte.getRealmInstance();
        realmInstance.executeTransaction(new RealmSecureStorageBte$insertExposure$$inlined$use$lambda$1(exposureEntity));
        PathParser.closeFinally(realmInstance, null);
        NotificationHelper.showPossibleExposureNotification(getReactApplicationContext());
        promise.resolve(null);
    }

    @ReactMethod
    public void simulateExposureDetectionError(Promise promise) {
        promise.reject(new Exception("Not implemented"));
    }

    @ReactMethod
    public void toggleExposureNotifications(Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        ExposureNotificationClientWrapper exposureNotificationClientWrapper = ExposureNotificationClientWrapper.get(reactApplicationContext);
        Task<Boolean> isEnabled = exposureNotificationClientWrapper.isEnabled();
        isEnabled.addOnSuccessListener(new OnSuccessListener(exposureNotificationClientWrapper, reactApplicationContext, promise) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$DebugMenuModule$n2sqNb6NZLZJtV6jq0iMuPrBOQA */
            public final /* synthetic */ ExposureNotificationClientWrapper f$1;
            public final /* synthetic */ ReactContext f$2;
            public final /* synthetic */ Promise f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                DebugMenuModule.this.lambda$toggleExposureNotifications$0$DebugMenuModule(this.f$1, this.f$2, this.f$3, (Boolean) obj);
            }
        });
        promise.getClass();
        isEnabled.addOnFailureListener(new OnFailureListener() {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$4FnuZITwpTidBCa7qe8kzCWQ6s */

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Promise.this.reject(exc);
            }
        });
    }
}
