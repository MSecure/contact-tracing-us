package org.pathcheck.covidsafepaths.exposurenotifications;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.IntentSender;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.nearby.zzae;
import com.google.android.gms.internal.nearby.zzah;
import com.google.android.gms.internal.nearby.zzt;
import com.google.android.gms.internal.nearby.zzz;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.nearby.zza;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzd;
import com.google.android.gms.tasks.zzq;
import com.google.android.gms.tasks.zzu;
import com.google.android.gms.tasks.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.common.AppExecutors;
import org.pathcheck.covidsafepaths.exposurenotifications.nearby.ExposureConfigurations;
import org.pathcheck.covidsafepaths.exposurenotifications.nearby.ProvideDiagnosisKeysWorker;
import org.threeten.bp.Duration;

public class ExposureNotificationClientWrapper {
    public static final Duration GET_DAILY_SUMMARIES_TIMEOUT = Duration.ofSeconds(120);
    public static ExposureNotificationClientWrapper INSTANCE;
    public static final Duration PROVIDE_KEYS_TIMEOUT = Duration.create(MoreExecutors.safeMultiply(30L, 60), 0);
    public static final Duration SET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT = Duration.ofSeconds(30);
    public final ExposureConfigurations config;
    public final ExposureNotificationClient exposureNotificationClient;
    public CallbackToFutureAdapter$Completer<List<TemporaryExposureKey>> getKeysCompleter;
    public CallbackToFutureAdapter$Completer<Void> startTracingCompleter;

    public ExposureNotificationClientWrapper(Context context) {
        ReactYogaConfigProvider.checkNotNull(context, "Context must not be null");
        this.exposureNotificationClient = new zzt(context);
        this.config = new ExposureConfigurations(context);
    }

    public static ExposureNotificationClientWrapper get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ExposureNotificationClientWrapper(context);
        }
        return INSTANCE;
    }

    public static /* synthetic */ Void lambda$provideDiagnosisKeys$11(Exception exc) {
        String str = "setDiagnosisKeysDataMapping failed: " + exc;
        return null;
    }

    public static /* synthetic */ Unit lambda$provideDiagnosisKeys$9(Exception exc) {
        String str = "Config refresh failed: " + exc;
        return null;
    }

    public boolean deviceSupportsLocationlessScanning() {
        if (Settings.Global.getInt(((zzt) this.exposureNotificationClient).zaa.getContentResolver(), "bluetooth_sanitized_exposure_notification_supported", 0) == 1) {
            return true;
        }
        return false;
    }

    public Task<Boolean> isEnabled() {
        return ((zzt) this.exposureNotificationClient).isEnabled();
    }

    public List lambda$getDailySummaries$13$ExposureNotificationClientWrapper(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DailySummary dailySummary = (DailySummary) it.next();
            Integer num = 15;
            Integer valueOf = Integer.valueOf(this.config.prefs.sharedPreferences.getInt("ExposureNotificationSharedPreferences.TRIGGER_THRESHOLD_WEIGHTED_DURATION", num.intValue()));
            Intrinsics.checkNotNullExpressionValue(valueOf, "prefs.getTriggerThreshol…ESHOLD_WEIGHTED_DURATION)");
            if (Duration.ofSeconds((long) ((int) dailySummary.zzc.zzc)).seconds / 60 >= ((long) valueOf.intValue())) {
                arrayList.add(dailySummary);
            }
        }
        arrayList.size();
        list.size();
        return arrayList;
    }

    public /* synthetic */ void lambda$null$0$ExposureNotificationClientWrapper(ReactContext reactContext, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, Void r4) {
        CallbackToFutureAdapter$Completer<Void> callbackToFutureAdapter$Completer2 = this.startTracingCompleter;
        if (callbackToFutureAdapter$Completer2 != null) {
            callbackToFutureAdapter$Completer2.set(r4);
            this.startTracingCompleter = null;
        }
        onExposureNotificationStateChanged(reactContext, true);
        callbackToFutureAdapter$Completer.set(r4);
    }

    public void lambda$null$1$ExposureNotificationClientWrapper(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ReactContext reactContext, Exception exc) {
        if (exc instanceof ApiException) {
            ApiException apiException = (ApiException) exc;
            if (apiException.mStatus.zzc == 6) {
                this.startTracingCompleter = callbackToFutureAdapter$Completer;
                showPermissionDialog(reactContext, apiException, 1111);
                return;
            }
        }
        CallbackToFutureAdapter$Completer<Void> callbackToFutureAdapter$Completer2 = this.startTracingCompleter;
        if (callbackToFutureAdapter$Completer2 != null) {
            callbackToFutureAdapter$Completer2.setException(exc);
            this.startTracingCompleter = null;
        }
        onExposureNotificationStateChanged(reactContext, false);
        callbackToFutureAdapter$Completer.setException(exc);
    }

    public /* synthetic */ void lambda$null$3$ExposureNotificationClientWrapper(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, List list) {
        CallbackToFutureAdapter$Completer<List<TemporaryExposureKey>> callbackToFutureAdapter$Completer2 = this.getKeysCompleter;
        if (callbackToFutureAdapter$Completer2 != null) {
            callbackToFutureAdapter$Completer2.set(list);
            this.getKeysCompleter = null;
        }
        callbackToFutureAdapter$Completer.set(list);
    }

    public void lambda$null$4$ExposureNotificationClientWrapper(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ReactContext reactContext, Exception exc) {
        if (exc instanceof ApiException) {
            ApiException apiException = (ApiException) exc;
            if (apiException.mStatus.zzc == 6) {
                this.getKeysCompleter = callbackToFutureAdapter$Completer;
                showPermissionDialog(reactContext, apiException, 2222);
                return;
            }
        }
        CallbackToFutureAdapter$Completer<List<TemporaryExposureKey>> callbackToFutureAdapter$Completer2 = this.getKeysCompleter;
        if (callbackToFutureAdapter$Completer2 != null) {
            callbackToFutureAdapter$Completer2.setException(exc);
            this.getKeysCompleter = null;
        }
        callbackToFutureAdapter$Completer.setException(exc);
    }

    public /* synthetic */ ListenableFuture lambda$provideDiagnosisKeys$10$ExposureNotificationClientWrapper(Unit unit) throws Exception {
        return setDiagnosisKeysDataMapping();
    }

    public /* synthetic */ ListenableFuture lambda$provideDiagnosisKeys$12$ExposureNotificationClientWrapper(List list, Void r2) throws Exception {
        return provideDiagnosisKeysFuture(list);
    }

    public Object lambda$requestPermissionToGetExposureKeys$5$ExposureNotificationClientWrapper(ReactContext reactContext, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) throws Exception {
        zzt zzt = (zzt) this.exposureNotificationClient;
        if (zzt != null) {
            TaskApiCall.Builder builder = TaskApiCall.builder();
            builder.zaa = new zzae(zzt);
            builder.zac = new Feature[]{zza.zzb};
            Task zaa = zzt.zaa(0, builder.build());
            $$Lambda$ExposureNotificationClientWrapper$FDSlk7aafJLl8khHsBGbbe3dVFo r2 = new OnSuccessListener(callbackToFutureAdapter$Completer) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$FDSlk7aafJLl8khHsBGbbe3dVFo */
                public final /* synthetic */ CallbackToFutureAdapter$Completer f$1;

                {
                    this.f$1 = r2;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    ExposureNotificationClientWrapper.this.lambda$null$3$ExposureNotificationClientWrapper(this.f$1, (List) obj);
                }
            };
            zzu zzu = (zzu) zaa;
            if (zzu != null) {
                zzu.addOnSuccessListener(TaskExecutors.MAIN_THREAD, r2);
                zzu.addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener(callbackToFutureAdapter$Completer, reactContext) {
                    /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$nA64YJOZFB5MNten_gpmOYoYYBY */
                    public final /* synthetic */ CallbackToFutureAdapter$Completer f$1;
                    public final /* synthetic */ ReactContext f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        ExposureNotificationClientWrapper.this.lambda$null$4$ExposureNotificationClientWrapper(this.f$1, this.f$2, exc);
                    }
                });
                return zzu;
            }
            throw null;
        }
        throw null;
    }

    public Object lambda$requestPermissionToStartTracing$2$ExposureNotificationClientWrapper(ReactContext reactContext, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) throws Exception {
        Task<Void> start = ((zzt) this.exposureNotificationClient).start();
        $$Lambda$ExposureNotificationClientWrapper$lkrnggp4lkAc3el1rj52Hin9pAU r1 = new OnSuccessListener(reactContext, callbackToFutureAdapter$Completer) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$lkrnggp4lkAc3el1rj52Hin9pAU */
            public final /* synthetic */ ReactContext f$1;
            public final /* synthetic */ CallbackToFutureAdapter$Completer f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ExposureNotificationClientWrapper.this.lambda$null$0$ExposureNotificationClientWrapper(this.f$1, this.f$2, (Void) obj);
            }
        };
        zzu zzu = (zzu) start;
        if (zzu != null) {
            zzu.addOnSuccessListener(TaskExecutors.MAIN_THREAD, r1);
            zzu.addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener(callbackToFutureAdapter$Completer, reactContext) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$22rUZ0nVep4L83rqdgwtMwSS87o */
                public final /* synthetic */ CallbackToFutureAdapter$Completer f$1;
                public final /* synthetic */ ReactContext f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    ExposureNotificationClientWrapper.this.lambda$null$1$ExposureNotificationClientWrapper(this.f$1, this.f$2, exc);
                }
            });
            return zzu;
        }
        throw null;
    }

    public /* synthetic */ void lambda$stopTracing$6$ExposureNotificationClientWrapper(ReactContext reactContext, Void r2) {
        onExposureNotificationStateChanged(reactContext, false);
    }

    public /* synthetic */ void lambda$stopTracing$7$ExposureNotificationClientWrapper(ReactContext reactContext, Exception exc) {
        onExposureNotificationStateChanged(reactContext, true);
    }

    public /* synthetic */ void lambda$stopTracing$8$ExposureNotificationClientWrapper(ReactContext reactContext) {
        onExposureNotificationStateChanged(reactContext, true);
    }

    public void onExposureNotificationStateChanged(ReactContext reactContext, boolean z) {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        if (z) {
            ProvideDiagnosisKeysWorker.schedule(reactContext);
        } else {
            ProvideDiagnosisKeysWorker.cancel(reactContext);
        }
        String str = !z ? "Disabled" : "Active";
        if (reactContext != null && (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) != null) {
            rCTDeviceEventEmitter.emit("onEnabledStatusUpdated", str);
        }
    }

    public final ListenableFuture<Void> provideDiagnosisKeysFuture(List<File> list) {
        list.size();
        zzt zzt = (zzt) this.exposureNotificationClient;
        if (zzt != null) {
            ExposureConfiguration.ExposureConfigurationBuilder exposureConfigurationBuilder = new ExposureConfiguration.ExposureConfigurationBuilder();
            ExposureConfiguration exposureConfiguration = new ExposureConfiguration(exposureConfigurationBuilder.zza, exposureConfigurationBuilder.zzb, exposureConfigurationBuilder.zzc, exposureConfigurationBuilder.zzd, exposureConfigurationBuilder.zze, exposureConfigurationBuilder.zzf, exposureConfigurationBuilder.zzg, exposureConfigurationBuilder.zzh, exposureConfigurationBuilder.zzi, exposureConfigurationBuilder.zzj);
            TaskApiCall.Builder builder = TaskApiCall.builder();
            builder.zaa = new com.google.android.gms.internal.nearby.zzu(zzt);
            builder.zac = new Feature[]{zza.zzd};
            Task zaa = zzt.zaa(0, builder.build());
            zzah zzah = new zzah(zzt, list, exposureConfiguration, "TYZWQ32170AXEUVCDW7A");
            zzu zzu = (zzu) zaa;
            if (zzu != null) {
                Executor executor = TaskExecutors.MAIN_THREAD;
                zzu zzu2 = new zzu();
                zzq<TResult> zzq = zzu.zzb;
                zzv.zza(executor);
                zzq.zza(new zzd(executor, zzah, zzu2));
                zzu.zze();
                return MoreExecutors.getFutureWithTimeout(zzu2, PROVIDE_KEYS_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
            }
            throw null;
        }
        throw null;
    }

    public ListenableFuture<List<TemporaryExposureKey>> requestPermissionToGetExposureKeys(ReactContext reactContext) {
        return AppCompatDelegateImpl.ConfigurationImplApi17.getFuture(new CallbackToFutureAdapter$Resolver(reactContext) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$t1QVhRoyyLKd4nZdfVLaYuzuBDc */
            public final /* synthetic */ ReactContext f$1;

            {
                this.f$1 = r2;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
            public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
                return ExposureNotificationClientWrapper.this.lambda$requestPermissionToGetExposureKeys$5$ExposureNotificationClientWrapper(this.f$1, callbackToFutureAdapter$Completer);
            }
        });
    }

    public ListenableFuture<Void> requestPermissionToStartTracing(ReactContext reactContext) {
        return AppCompatDelegateImpl.ConfigurationImplApi17.getFuture(new CallbackToFutureAdapter$Resolver(reactContext) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$sd1ogSXwFvbP2H07Zrgu9F68ge4 */
            public final /* synthetic */ ReactContext f$1;

            {
                this.f$1 = r2;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
            public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
                return ExposureNotificationClientWrapper.this.lambda$requestPermissionToStartTracing$2$ExposureNotificationClientWrapper(this.f$1, callbackToFutureAdapter$Completer);
            }
        });
    }

    public final ListenableFuture<Void> setDiagnosisKeysDataMapping() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("setDiagnosisKeysDataMapping called with config ");
        outline17.append(this.config.getDiagnosisKeysDataMapping());
        outline17.toString();
        ExposureNotificationClient exposureNotificationClient2 = this.exposureNotificationClient;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = this.config.getDiagnosisKeysDataMapping();
        zzt zzt = (zzt) exposureNotificationClient2;
        if (zzt != null) {
            TaskApiCall.Builder builder = TaskApiCall.builder();
            builder.zaa = new zzz(diagnosisKeysDataMapping);
            builder.zac = new Feature[]{zza.zzh};
            return MoreExecutors.getFutureWithTimeout(zzt.zaa(1, builder.build()), SET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
        }
        throw null;
    }

    public void showPermissionDialog(ReactContext reactContext, ApiException apiException, int i) {
        try {
            Activity currentActivity = reactContext.getCurrentActivity();
            if (currentActivity != null) {
                Status status = apiException.mStatus;
                if (status.zze != null) {
                    PendingIntent pendingIntent = status.zze;
                    ReactYogaConfigProvider.checkNotNull(pendingIntent);
                    currentActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
                }
            }
        } catch (IntentSender.SendIntentException e) {
            Log.e("Permissions Dialog", e.toString());
        }
    }

    public Task<Void> stopTracing(ReactContext reactContext) {
        Task<Void> stop = ((zzt) this.exposureNotificationClient).stop();
        $$Lambda$ExposureNotificationClientWrapper$uv0taYX_6r0kRkrbTt5BEr83hoE r1 = new OnSuccessListener(reactContext) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$uv0taYX_6r0kRkrbTt5BEr83hoE */
            public final /* synthetic */ ReactContext f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ExposureNotificationClientWrapper.this.lambda$stopTracing$6$ExposureNotificationClientWrapper(this.f$1, (Void) obj);
            }
        };
        zzu zzu = (zzu) stop;
        if (zzu != null) {
            zzu.addOnSuccessListener(TaskExecutors.MAIN_THREAD, r1);
            zzu.addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener(reactContext) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$_WWGBjJQSSx8Pv42UnWW2luP2DI */
                public final /* synthetic */ ReactContext f$1;

                {
                    this.f$1 = r2;
                }

                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    ExposureNotificationClientWrapper.this.lambda$stopTracing$7$ExposureNotificationClientWrapper(this.f$1, exc);
                }
            });
            zzu.addOnCanceledListener(TaskExecutors.MAIN_THREAD, new OnCanceledListener(reactContext) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$nyZhDXA0QEdWUE1NQSuOCiPPqDM */
                public final /* synthetic */ ReactContext f$1;

                {
                    this.f$1 = r2;
                }

                @Override // com.google.android.gms.tasks.OnCanceledListener
                public final void onCanceled() {
                    ExposureNotificationClientWrapper.this.lambda$stopTracing$8$ExposureNotificationClientWrapper(this.f$1);
                }
            });
            return zzu;
        }
        throw null;
    }
}
