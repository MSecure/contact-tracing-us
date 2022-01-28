package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.internal.nearby.zzt;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures$CallbackListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.horcrux.svg.PathParser;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;
import org.pathcheck.covidsafepaths.exposurenotifications.common.AppExecutors;
import org.pathcheck.covidsafepaths.exposurenotifications.nearby.ProvideDiagnosisKeysWorker;

@ReactModule(name = ExposureNotificationsModule.MODULE_NAME)
public class ExposureNotificationsModule extends ReactContextBaseJavaModule {
    public static final String MODULE_NAME = "ENPermissionsModule";
    public static final String TAG = "ENModule";
    public final ExposureNotificationClient exposureNotificationClient;

    public ExposureNotificationsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        ReactYogaConfigProvider.checkNotNull(reactApplicationContext, "Context must not be null");
        this.exposureNotificationClient = new zzt(reactApplicationContext);
    }

    private void cancelDailyProvideDiagnosisKeys() {
        ProvideDiagnosisKeysWorker.cancel(getReactApplicationContext());
    }

    public static /* synthetic */ void lambda$getCurrentENPermissionsStatus$1(Promise promise, Exception exc) {
        if (!(exc instanceof ApiException)) {
            promise.reject(new Exception("error unknown"));
        } else {
            promise.reject(exc);
        }
    }

    public static /* synthetic */ void lambda$startExposureNotifications$3(Promise promise, Exception exc) {
        Log.e(TAG, "Failed to start EN", exc);
        promise.reject(exc);
    }

    private void scheduleDailyProvideDiagnosisKeys() {
        ProvideDiagnosisKeysWorker.schedule(getReactApplicationContext());
    }

    @ReactMethod
    public void getCurrentENPermissionsStatus(Promise promise) {
        Task<Boolean> isEnabled = ExposureNotificationClientWrapper.get(getReactApplicationContext()).isEnabled();
        isEnabled.addOnSuccessListener(new OnSuccessListener() {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureNotificationsModule$YjIpPH1loXGpUwj8YjlezD5I7IE */

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Promise.this.resolve(PathParser.getEnStatusWritableArray(((Boolean) obj).booleanValue()));
            }
        });
        isEnabled.addOnFailureListener(new OnFailureListener() {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureNotificationsModule$I1KFSnwkprHPzX0saRQXDcSOVeQ */

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                ExposureNotificationsModule.lambda$getCurrentENPermissionsStatus$1(Promise.this, exc);
            }
        });
    }

    @ReactMethod
    public void getExposureNotificationStatus(Promise promise) {
        Task<Boolean> isEnabled = ((zzt) this.exposureNotificationClient).isEnabled();
        promise.getClass();
        isEnabled.addOnSuccessListener(new OnSuccessListener() {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$SSlnbFTQSJhH8ZSoeqhzdHtOA1k */

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Promise.this.resolve((Boolean) obj);
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    public /* synthetic */ void lambda$startExposureNotifications$2$ExposureNotificationsModule(Promise promise, Void r2) {
        promise.resolve(null);
        scheduleDailyProvideDiagnosisKeys();
    }

    public /* synthetic */ void lambda$stopExposureNotifications$5$ExposureNotificationsModule(Promise promise, Void r2) {
        promise.resolve(null);
        cancelDailyProvideDiagnosisKeys();
    }

    @ReactMethod
    public void requestExposureNotificationAuthorization(final Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        ExposureNotificationClientWrapper exposureNotificationClientWrapper = ExposureNotificationClientWrapper.get(reactApplicationContext);
        AnonymousClass1 r2 = new FutureCallback<Void>(this) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.ExposureNotificationsModule.AnonymousClass1 */

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                promise.reject(th);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r2) {
                promise.resolve("success");
            }
        };
        ListenableFuture<Void> requestPermissionToStartTracing = exposureNotificationClientWrapper.requestPermissionToStartTracing(reactApplicationContext);
        ListeningExecutorService lightweightExecutor = AppExecutors.getLightweightExecutor();
        ((CallbackToFutureAdapter$SafeFuture) requestPermissionToStartTracing).addListener(new Futures$CallbackListener(requestPermissionToStartTracing, r2), lightweightExecutor);
    }

    @ReactMethod
    public void startExposureNotifications(Promise promise) {
        Task<Void> start = ((zzt) this.exposureNotificationClient).start();
        start.addOnSuccessListener(new OnSuccessListener(promise) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureNotificationsModule$Y_Z29HmbeAB51p8VTq5GHPvzHUE */
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ExposureNotificationsModule.this.lambda$startExposureNotifications$2$ExposureNotificationsModule(this.f$1, (Void) obj);
            }
        });
        start.addOnFailureListener(new OnFailureListener() {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureNotificationsModule$TpAu1lAOMDBYr2e1mOubRpBc564 */

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                ExposureNotificationsModule.lambda$startExposureNotifications$3(Promise.this, exc);
            }
        });
        start.addOnCanceledListener(new OnCanceledListener() {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureNotificationsModule$XG9HPDLnP6oCrKw3BtZww5suoRc */

            /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
                java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:267)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
                */
            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                /*
                    r1 = this;
                    com.facebook.react.bridge.Promise r0 = com.facebook.react.bridge.Promise.this
                    org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.ExposureNotificationsModule.lambda$startExposureNotifications$4(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureNotificationsModule$XG9HPDLnP6oCrKw3BtZww5suoRc.onCanceled():void");
            }
        });
    }

    @ReactMethod
    public void stopExposureNotifications(Promise promise) {
        Task<Void> stop = ((zzt) this.exposureNotificationClient).stop();
        stop.addOnSuccessListener(new OnSuccessListener(promise) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureNotificationsModule$szdbtLDCyZcnjPPsoAEvhBNcwKE */
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ExposureNotificationsModule.this.lambda$stopExposureNotifications$5$ExposureNotificationsModule(this.f$1, (Void) obj);
            }
        });
        stop.addOnFailureListener($$Lambda$ExposureNotificationsModule$fq6jUIhTgXtqXKNpq33_h3vKswk.INSTANCE);
        stop.addOnCanceledListener(new OnCanceledListener() {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureNotificationsModule$c2d42oLxljrY4ZBdNmyhOZqX0jw */

            /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
                java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:267)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
                */
            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                /*
                    r1 = this;
                    com.facebook.react.bridge.Promise r0 = com.facebook.react.bridge.Promise.this
                    org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.ExposureNotificationsModule.lambda$stopExposureNotifications$7(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureNotificationsModule$c2d42oLxljrY4ZBdNmyhOZqX0jw.onCanceled():void");
            }
        });
    }
}
