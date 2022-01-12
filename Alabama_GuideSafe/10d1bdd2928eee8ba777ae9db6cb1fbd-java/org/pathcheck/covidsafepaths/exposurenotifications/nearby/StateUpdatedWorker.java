package org.pathcheck.covidsafepaths.exposurenotifications.nearby;

import android.content.Context;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.nearby.zzt;
import com.google.android.gms.internal.nearby.zzx;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.zza;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;
import org.pathcheck.covidsafepaths.exposurenotifications.common.AppExecutors;
import org.pathcheck.covidsafepaths.exposurenotifications.common.NotificationHelper;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte;

public class StateUpdatedWorker extends ListenableWorker {
    public final Context context;

    public StateUpdatedWorker(Context context2, WorkerParameters workerParameters) {
        super(context2, workerParameters);
        this.context = context2;
    }

    public static ListenableWorker.Result lambda$startWork$1(Exception exc) {
        Log.e("StateUpdatedWorker", "Failure to update app state (tokens, etc) from exposure summary.", exc);
        return new ListenableWorker.Result.Failure();
    }

    public ListenableWorker.Result lambda$startWork$0$StateUpdatedWorker(Boolean bool) {
        if (bool.booleanValue()) {
            NotificationHelper.showPossibleExposureNotification(this.context);
        }
        return new ListenableWorker.Result.Success();
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        ExposureNotificationClientWrapper exposureNotificationClientWrapper = ExposureNotificationClientWrapper.get(this.context);
        ExposureNotificationClient exposureNotificationClient = exposureNotificationClientWrapper.exposureNotificationClient;
        ExposureConfigurations exposureConfigurations = exposureNotificationClientWrapper.config;
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = exposureConfigurations.prefs;
        List<Double> list = ExposureConfigurations.DEFAULT_REPORT_TYPE_WEIGHTS;
        String string = exposureNotificationSharedPreferences.sharedPreferences.getString("ExposureNotificationSharedPreferences.REPORT_TYPE_WEIGHTS", null);
        if (string != null) {
            list = (List) new Gson().fromJson(string, new TypeToken<List<Double>>(exposureNotificationSharedPreferences) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences.AnonymousClass3 */
            }.type);
        }
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences2 = exposureConfigurations.prefs;
        List<Double> list2 = ExposureConfigurations.DEFAULT_INFECTIOUSNESS_WEIGHT;
        String string2 = exposureNotificationSharedPreferences2.sharedPreferences.getString("ExposureNotificationSharedPreferences.INFECTIOUSNESS_WEIGHTS", null);
        if (string2 != null) {
            list2 = (List) new Gson().fromJson(string2, new TypeToken<List<Double>>(exposureNotificationSharedPreferences2) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences.AnonymousClass4 */
            }.type);
        }
        DailySummariesConfig.DailySummariesConfigBuilder dailySummariesConfigBuilder = new DailySummariesConfig.DailySummariesConfigBuilder();
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences3 = exposureConfigurations.prefs;
        List<Integer> list3 = ExposureConfigurations.DEFAULT_ATTENUATION_DURATION_THRESHOLDS;
        String string3 = exposureNotificationSharedPreferences3.sharedPreferences.getString("ExposureNotificationSharedPreferences.ATTENUATION_DURATION_THRESHOLDS", null);
        if (string3 != null) {
            list3 = (List) new Gson().fromJson(string3, new TypeToken<List<Integer>>(exposureNotificationSharedPreferences3) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences.AnonymousClass1 */
            }.type);
        }
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences4 = exposureConfigurations.prefs;
        List<Double> list4 = ExposureConfigurations.DEFAULT_ATTENUATION_BUCKET_WEIGHTS;
        String string4 = exposureNotificationSharedPreferences4.sharedPreferences.getString("ExposureNotificationSharedPreferences.ATTENUATION_BUCKET_WEIGHTS", null);
        if (string4 != null) {
            list4 = (List) new Gson().fromJson(string4, new TypeToken<List<Double>>(exposureNotificationSharedPreferences4) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences.AnonymousClass2 */
            }.type);
        }
        DailySummariesConfig.DailySummariesConfigBuilder.zza(list3, ((int[]) DailySummariesConfig.zza.zze.clone()).length - 1, "attenuationBucketThresholdDb");
        for (int i = 0; i < list3.size(); i++) {
            ReactYogaConfigProvider.checkArgument(list3.get(i).intValue() >= 0 && list3.get(i).intValue() <= 255, "Element of attenuationBucketThreshold must between 0 ~ 255");
            if (i != 0) {
                int i2 = i - 1;
                ReactYogaConfigProvider.checkArgument(list3.get(i2).intValue() < list3.get(i).intValue(), String.format(Locale.ENGLISH, "attenuationBucketThresholdDb of index %d must be larger than index %d", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }
        dailySummariesConfigBuilder.zzc = new ArrayList(list3);
        DailySummariesConfig.DailySummariesConfigBuilder.zza(list4, ((int[]) DailySummariesConfig.zza.zze.clone()).length, "attenuationBucketWeights");
        for (Double d : list4) {
            DailySummariesConfig.DailySummariesConfigBuilder.zza(d.doubleValue(), "attenuationBucketWeights");
        }
        dailySummariesConfigBuilder.zzd = new ArrayList(list4);
        Double d2 = list.get(0);
        Intrinsics.checkNotNullExpressionValue(d2, "reportTypeWeights[0]");
        dailySummariesConfigBuilder.setReportTypeWeight(1, d2.doubleValue());
        Double d3 = list.get(1);
        Intrinsics.checkNotNullExpressionValue(d3, "reportTypeWeights[1]");
        dailySummariesConfigBuilder.setReportTypeWeight(2, d3.doubleValue());
        Double d4 = list.get(2);
        Intrinsics.checkNotNullExpressionValue(d4, "reportTypeWeights[2]");
        dailySummariesConfigBuilder.setReportTypeWeight(3, d4.doubleValue());
        Double d5 = list.get(3);
        Intrinsics.checkNotNullExpressionValue(d5, "reportTypeWeights[3]");
        dailySummariesConfigBuilder.setReportTypeWeight(4, d5.doubleValue());
        Double d6 = list2.get(0);
        Intrinsics.checkNotNullExpressionValue(d6, "infectiousnessWeights[0]");
        dailySummariesConfigBuilder.setInfectiousnessWeight(1, d6.doubleValue());
        Double d7 = list2.get(1);
        Intrinsics.checkNotNullExpressionValue(d7, "infectiousnessWeights[1]");
        dailySummariesConfigBuilder.setInfectiousnessWeight(2, d7.doubleValue());
        ReactYogaConfigProvider.checkArgument(dailySummariesConfigBuilder.zzc != null, "Must set attenuationBucketThresholdDb");
        ReactYogaConfigProvider.checkArgument(dailySummariesConfigBuilder.zzd != null, "Must set attenuationBucketWeights");
        DailySummariesConfig dailySummariesConfig = new DailySummariesConfig(Arrays.asList(dailySummariesConfigBuilder.zza), Arrays.asList(dailySummariesConfigBuilder.zzb), dailySummariesConfigBuilder.zzc, dailySummariesConfigBuilder.zzd, dailySummariesConfigBuilder.zze, dailySummariesConfigBuilder.zzf);
        Intrinsics.checkNotNullExpressionValue(dailySummariesConfig, "DailySummariesConfig.Dai…[1])\n            .build()");
        zzt zzt = (zzt) exposureNotificationClient;
        if (zzt != null) {
            TaskApiCall.Builder builder = TaskApiCall.builder();
            builder.zaa = new zzx(zzt, dailySummariesConfig);
            builder.zac = new Feature[]{zza.zzf};
            FluentFuture from = FluentFuture.from(FluentFuture.from(MoreExecutors.getFutureWithTimeout(zzt.zaa(0, builder.build()), ExposureNotificationClientWrapper.GET_DAILY_SUMMARIES_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).transform(new Function() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$q3Raqa5jV4OWsm0eZXRM0UH2HaY */

                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return ExposureNotificationClientWrapper.this.lambda$getDailySummaries$13$ExposureNotificationClientWrapper((List) obj);
                }
            }, AppExecutors.getLightweightExecutor()));
            RealmSecureStorageBte realmSecureStorageBte = RealmSecureStorageBte.INSTANCE;
            realmSecureStorageBte.getClass();
            return from.transform(new Function() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.nearby.$$Lambda$sih1tM4oA_sNgaa4OtN00mp5djg */

                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(RealmSecureStorageBte.this.refreshWithDailySummaries((List) obj));
                }
            }, AppExecutors.getBackgroundExecutor()).transform(new Function() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.nearby.$$Lambda$StateUpdatedWorker$sm9Wdai1wDd_Ux9BanctpwmSYg */

                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return StateUpdatedWorker.this.lambda$startWork$0$StateUpdatedWorker((Boolean) obj);
                }
            }, AppExecutors.getLightweightExecutor()).catching(Exception.class, $$Lambda$StateUpdatedWorker$rzWds3u584aFUtLpqB8nRPFA8LU.INSTANCE, AppExecutors.getLightweightExecutor());
        }
        throw null;
    }
}
