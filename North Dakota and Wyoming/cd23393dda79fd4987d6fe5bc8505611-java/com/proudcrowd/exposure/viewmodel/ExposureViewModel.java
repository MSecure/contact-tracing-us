package com.proudcrowd.exposure.viewmodel;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.os.StatFs;
import android.util.Log;
import androidx.core.location.LocationManagerCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bugfender.sdk.Bugfender;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.core.ExposureClient;
import com.proudcrowd.exposure.core.FakeScanManager;
import com.proudcrowd.exposure.core.ScanManager;
import com.proudcrowd.exposure.misc.AppExecutors;
import com.proudcrowd.exposure.misc.SingleLiveEvent;
import com.proudcrowd.exposure.storage.ExposureNotificationSharedPreferences;
import java.util.concurrent.Callable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ExposureViewModel extends AndroidViewModel {
    private static final long MINIMUM_FREE_STORAGE_REQUIRED_BYTES = 104857600;
    private static final String TAG = "ExposureVM";
    private final SingleLiveEvent<Void> apiErrorLiveEvent = new SingleLiveEvent<>();
    private boolean avoidRecursion_IsEnabled = false;
    private final ExposureNotificationSharedPreferences exposureNotificationSharedPreferences;
    private final MutableLiveData<Boolean> inFlightLiveData = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> inFlightResolutionLiveData = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isEnabledLiveData;
    private final MutableLiveData<ExposureNotificationState> mStateLiveData;
    private final SingleLiveEvent<ApiException> resolutionRequiredLiveEvent = new SingleLiveEvent<>();

    public enum ExposureNotificationState {
        DISABLED,
        ENABLED,
        PAUSED_BLE_OFF,
        PAUSED_LOCATION_OFF,
        STORAGE_LOW
    }

    public ExposureViewModel(Application application) {
        super(application);
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences2 = new ExposureNotificationSharedPreferences(application);
        this.exposureNotificationSharedPreferences = exposureNotificationSharedPreferences2;
        this.isEnabledLiveData = new MutableLiveData<>(Boolean.valueOf(exposureNotificationSharedPreferences2.getIsEnabledCache()));
        this.mStateLiveData = new MutableLiveData<>(getStateForIsEnabled(exposureNotificationSharedPreferences2.getIsEnabledCache()));
    }

    public LiveData<Boolean> getIsEnabledLiveData() {
        return this.isEnabledLiveData;
    }

    public LiveData<ExposureNotificationState> getStateLiveData() {
        return this.mStateLiveData;
    }

    public LiveData<Boolean> getInFlightLiveData() {
        return this.inFlightLiveData;
    }

    public SingleLiveEvent<ApiException> getResolutionRequiredLiveEvent() {
        return this.resolutionRequiredLiveEvent;
    }

    public SingleLiveEvent<Void> getApiErrorLiveEvent() {
        return this.apiErrorLiveEvent;
    }

    public synchronized void refreshIsEnabledState() {
        if (!this.avoidRecursion_IsEnabled) {
            this.avoidRecursion_IsEnabled = true;
            ExposureClient.get(getApplication()).isEnabled().addOnSuccessListener(new OnSuccessListener() {
                /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$IxCMbAgYfC8zy7Lat8nQlLL7ups */

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    ExposureViewModel.this.lambda$refreshIsEnabledState$0$ExposureViewModel((Boolean) obj);
                }
            }).addOnCanceledListener(new OnCanceledListener() {
                /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$WPBcP2Qgt3MKIWnEOad7Arh86oc */

                @Override // com.google.android.gms.tasks.OnCanceledListener
                public final void onCanceled() {
                    ExposureViewModel.this.lambda$refreshIsEnabledState$1$ExposureViewModel();
                }
            }).addOnFailureListener(new OnFailureListener() {
                /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$J00thbeqILMxOSz6h0VlPiKAs */

                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    ExposureViewModel.this.lambda$refreshIsEnabledState$2$ExposureViewModel(exc);
                }
            });
        }
    }

    public /* synthetic */ void lambda$refreshIsEnabledState$0$ExposureViewModel(Boolean bool) {
        this.isEnabledLiveData.setValue(bool);
        this.exposureNotificationSharedPreferences.setIsEnabledCache(bool.booleanValue());
        this.mStateLiveData.setValue(getStateForIsEnabled(bool.booleanValue()));
        this.avoidRecursion_IsEnabled = false;
    }

    public /* synthetic */ void lambda$refreshIsEnabledState$1$ExposureViewModel() {
        this.avoidRecursion_IsEnabled = false;
    }

    public /* synthetic */ void lambda$refreshIsEnabledState$2$ExposureViewModel(Exception exc) {
        Log.e(TAG, "Failed to call isEnabled", exc);
        Bugfender.e("Failed to call isEnabled", exc.getLocalizedMessage());
        Bugfender.forceSendOnce();
        this.isEnabledLiveData.setValue(false);
        this.mStateLiveData.setValue(getStateForIsEnabled(false));
        this.exposureNotificationSharedPreferences.setIsEnabledCache(false);
        this.avoidRecursion_IsEnabled = false;
    }

    private ExposureNotificationState getStateForIsEnabled(boolean z) {
        if (!z) {
            return ExposureNotificationState.DISABLED;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && !defaultAdapter.isEnabled()) {
            return ExposureNotificationState.PAUSED_BLE_OFF;
        }
        LocationManager locationManager = (LocationManager) getApplication().getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (locationManager != null && !LocationManagerCompat.isLocationEnabled(locationManager)) {
            return ExposureNotificationState.PAUSED_LOCATION_OFF;
        }
        if (new StatFs(getApplication().getFilesDir().toString()).getAvailableBytes() <= MINIMUM_FREE_STORAGE_REQUIRED_BYTES) {
            return ExposureNotificationState.STORAGE_LOW;
        }
        return ExposureNotificationState.ENABLED;
    }

    public void startExposureNotifications() {
        schedulePeriodicJobs(getApplication());
        this.inFlightLiveData.setValue(true);
        ExposureClient.get(getApplication()).start().addOnSuccessListener(new OnSuccessListener() {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$z3QwBFTW8CGT6lAgoNJ9aPUNuI */

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ExposureViewModel.this.lambda$startExposureNotifications$3$ExposureViewModel((Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$ZDvKeNVxQiwcZkyVmnvIvgyNC04 */

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                ExposureViewModel.this.lambda$startExposureNotifications$4$ExposureViewModel(exc);
            }
        }).addOnCanceledListener(new OnCanceledListener() {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$YOeM3LXT794JMir5Fmgx_R0Gvg */

            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                ExposureViewModel.this.lambda$startExposureNotifications$5$ExposureViewModel();
            }
        });
    }

    public /* synthetic */ void lambda$startExposureNotifications$3$ExposureViewModel(Void r2) {
        this.mStateLiveData.setValue(getStateForIsEnabled(true));
        this.inFlightLiveData.setValue(false);
        refreshIsEnabledState();
    }

    public /* synthetic */ void lambda$startExposureNotifications$4$ExposureViewModel(Exception exc) {
        if (!(exc instanceof ApiException)) {
            Log.e(TAG, "Unknown error when attempting to start API", exc);
            this.inFlightLiveData.setValue(false);
            this.apiErrorLiveEvent.call();
            return;
        }
        ApiException apiException = (ApiException) exc;
        if (apiException.getStatusCode() != 6) {
            Log.w(TAG, "No RESOLUTION_REQUIRED in result", apiException);
            this.apiErrorLiveEvent.call();
            this.inFlightLiveData.setValue(false);
        } else if (this.inFlightResolutionLiveData.getValue().booleanValue()) {
            Log.e(TAG, "Error, has in flight resolution", exc);
        } else {
            this.inFlightResolutionLiveData.setValue(true);
            this.resolutionRequiredLiveEvent.postValue(apiException);
        }
    }

    public /* synthetic */ void lambda$startExposureNotifications$5$ExposureViewModel() {
        this.inFlightLiveData.setValue(false);
    }

    public void startResolutionResultOk() {
        this.inFlightResolutionLiveData.setValue(false);
        ExposureClient.get(getApplication()).start().addOnSuccessListener(new OnSuccessListener() {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$2313LQARlActdIUhyuh0G6HMkWw */

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ExposureViewModel.this.lambda$startResolutionResultOk$6$ExposureViewModel((Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$i5H3ASfuCoPEQxJoTOSpVpFOmR0 */

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                ExposureViewModel.this.lambda$startResolutionResultOk$7$ExposureViewModel(exc);
            }
        }).addOnCanceledListener(new OnCanceledListener() {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$eGKWSH8QeOESmSkJVM2b1QeCZ4 */

            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                ExposureViewModel.this.lambda$startResolutionResultOk$8$ExposureViewModel();
            }
        });
    }

    public /* synthetic */ void lambda$startResolutionResultOk$6$ExposureViewModel(Void r2) {
        refreshIsEnabledState();
        this.mStateLiveData.setValue(getStateForIsEnabled(true));
        this.inFlightLiveData.setValue(false);
    }

    public /* synthetic */ void lambda$startResolutionResultOk$7$ExposureViewModel(Exception exc) {
        Log.e(TAG, "Error handling resolution ok", exc);
        this.apiErrorLiveEvent.call();
        this.inFlightLiveData.setValue(false);
    }

    public /* synthetic */ void lambda$startResolutionResultOk$8$ExposureViewModel() {
        this.inFlightLiveData.setValue(false);
    }

    public void startResolutionResultNotOk() {
        this.inFlightResolutionLiveData.setValue(false);
        this.inFlightLiveData.setValue(false);
    }

    public void stopExposureNotifications() {
        this.inFlightLiveData.setValue(true);
        ExposureClient.get(getApplication()).stop().addOnSuccessListener(new OnSuccessListener() {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$RFUjnMzXpESp0jnrrtZqFkF7fXQ */

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ExposureViewModel.this.lambda$stopExposureNotifications$9$ExposureViewModel((Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$DEpPRKUtBeOiWvdMXvkpeTdFLis */

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                ExposureViewModel.this.lambda$stopExposureNotifications$10$ExposureViewModel(exc);
            }
        }).addOnCanceledListener(new OnCanceledListener() {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$c_PTAtQlE1_TLGHMiv7lClNKrI */

            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                ExposureViewModel.this.lambda$stopExposureNotifications$11$ExposureViewModel();
            }
        });
    }

    public /* synthetic */ void lambda$stopExposureNotifications$9$ExposureViewModel(Void r2) {
        refreshIsEnabledState();
        this.inFlightLiveData.setValue(false);
    }

    public /* synthetic */ void lambda$stopExposureNotifications$10$ExposureViewModel(Exception exc) {
        Log.w(TAG, "Failed to stop", exc);
        this.inFlightLiveData.setValue(false);
    }

    public /* synthetic */ void lambda$stopExposureNotifications$11$ExposureViewModel() {
        this.inFlightLiveData.setValue(false);
    }

    public static void schedulePeriodicJobs(Context context) {
        Futures.addCallback(AppExecutors.getBackgroundExecutor().submit((Callable) new Callable(context) {
            /* class com.proudcrowd.exposure.viewmodel.$$Lambda$ExposureViewModel$0AEpWLEayWrBCJQSD5rxyv1aOE */
            public final /* synthetic */ Context f$0;

            {
                this.f$0 = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ExposureViewModel.lambda$schedulePeriodicJobs$12(this.f$0);
            }
        }), new FutureCallback<Void>() {
            /* class com.proudcrowd.exposure.viewmodel.ExposureViewModel.AnonymousClass1 */

            public void onSuccess(@NullableDecl Void r2) {
                Bugfender.d("Background", "Scheduled periodic WorkManager jobs.");
                Log.i(ExposureViewModel.TAG, "Scheduled periodic WorkManager jobs.");
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                Bugfender.e("Failed to schedule periodic WorkManager jobs.", th.getLocalizedMessage());
                Log.e(ExposureViewModel.TAG, "Failed to schedule periodic WorkManager jobs.", th);
            }
        }, AppExecutors.getLightweightExecutor());
    }

    static /* synthetic */ Void lambda$schedulePeriodicJobs$12(Context context) throws Exception {
        Bugfender.d("Background", "Scheduling post-enable periodic WorkManager jobs...");
        Log.i(TAG, "Scheduling post-enable periodic WorkManager jobs...");
        FakeScanManager.schedule(context);
        ScanManager.schedule(context);
        return null;
    }

    public void noteOnboardingCompleted() {
        ((ExposureApplication) getApplication()).setHaveConsent();
    }
}
