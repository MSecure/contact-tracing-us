package com.proudcrowd.exposure.core;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.bugfender.sdk.Bugfender;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import com.google.android.gms.nearby.exposurenotification.ScanInstance;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.proudcrowd.exposure.core.DayBucket;
import com.proudcrowd.exposure.datamodel.ScoringDetailEx;
import com.proudcrowd.exposure.datasource.DeviceExposureDataSource;
import com.proudcrowd.exposure.datasource.ScanPostDataSource;
import com.proudcrowd.exposure.misc.AppExecutors;
import com.proudcrowd.exposure.misc.NotificationHelper;
import com.proudcrowd.exposure.misc.TaskToFutureAdapter;
import com.proudcrowd.exposure.storage.ExposureEntity;
import com.proudcrowd.exposure.storage.ExposureRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.threeten.bp.Duration;

public final class ExposureMatchManager extends ListenableWorker {
    private static final Duration GET_WINDOWS_TIMEOUT = Duration.ofSeconds(120);
    private static final String TAG = "ExposureMatchManager";
    private final ExposureApplication applicationContext;
    private final ExposureRepository exposureRepository;

    public ExposureMatchManager(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.applicationContext = (ExposureApplication) context;
        this.exposureRepository = new ExposureRepository(context);
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        return FluentFuture.from(getExposureWindows()).transform(new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureMatchManager$0iHHm7Gl1zVChtuwE5xKD9jL8w */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureMatchManager.this.toExposureEntities((List) obj);
            }
        }, AppExecutors.getLightweightExecutor()).transform(new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureMatchManager$Wpnlu4UQJSfWBqoCv4CCQd9HiF4 */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureMatchManager.this.lambda$startWork$0$ExposureMatchManager((List) obj);
            }
        }, AppExecutors.getLightweightExecutor()).transform(new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureMatchManager$xgDEpVA_BKZCZpGx2RnPsMt2b40 */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(ExposureMatchManager.this.postExposures((List) obj));
            }
        }, AppExecutors.getBackgroundExecutor()).transform(new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureMatchManager$t0UzlyYSxZ982JGoQB5HulVt_do */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureMatchManager.this.lambda$startWork$1$ExposureMatchManager((Integer) obj);
            }
        }, AppExecutors.getLightweightExecutor()).catching(Exception.class, new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureMatchManager$Rxi_p0hG0rRmrcSU7MmbnU446kI */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureMatchManager.this.completeBackgroundWork((Exception) obj);
            }
        }, AppExecutors.getLightweightExecutor());
    }

    public /* synthetic */ List lambda$startWork$0$ExposureMatchManager(List list) {
        if (saveExposures(list)) {
            NotificationHelper.showPossibleExposureNotification(this.applicationContext);
        }
        return list;
    }

    public /* synthetic */ ListenableWorker.Result lambda$startWork$1$ExposureMatchManager(Integer num) {
        return completeBackgroundWork(null);
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<List<ExposureWindow>> getExposureWindows() {
        return TaskToFutureAdapter.getFutureWithTimeout(ExposureClient.get(this.applicationContext).getExposureWindows(), GET_WINDOWS_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
    }

    /* access modifiers changed from: private */
    public List<ExposureEntity> toExposureEntities(List<ExposureWindow> list) {
        HashMap hashMap = new HashMap();
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        for (Map.Entry<Long, DayBucket> entry : accumulateWindowsToDayBuckets(list).entrySet()) {
            if (entry.getValue().IsExposure()) {
                long longValue = entry.getKey().longValue();
                if (!hashMap.containsKey(Long.valueOf(longValue))) {
                    hashMap.put(Long.valueOf(longValue), ExposureEntity.create(longValue));
                }
            }
        }
        return new ArrayList(hashMap.values());
    }

    private Map<Long, DayBucket> accumulateWindowsToDayBuckets(List<ExposureWindow> list) {
        HashMap hashMap = new HashMap();
        for (ExposureWindow exposureWindow : list) {
            if (exposureWindow.getReportType() == 1) {
                long dateMillisSinceEpoch = exposureWindow.getDateMillisSinceEpoch();
                if (!hashMap.containsKey(Long.valueOf(dateMillisSinceEpoch))) {
                    ScoringDetailEx scoringDetailEx = this.applicationContext.mKeymatchSettings.scoringSettingsEx;
                    hashMap.put(Long.valueOf(dateMillisSinceEpoch), new DayBucket(dateMillisSinceEpoch, scoringDetailEx.thresholdSeconds, scoringDetailEx.attenuationSettings));
                }
                DayBucket dayBucket = (DayBucket) hashMap.get(Long.valueOf(dateMillisSinceEpoch));
                for (ScanInstance scanInstance : exposureWindow.getScanInstances()) {
                    Bugfender.d("Exposure Scan Attenuation: ", String.valueOf(scanInstance.getTypicalAttenuationDb()));
                    Bugfender.d("Exposure Scan Seconds: ", String.valueOf(scanInstance.getSecondsSinceLastScan()));
                    Iterator<DayBucket.AttenuationBucket> it = dayBucket.attenuationBuckets.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        DayBucket.AttenuationBucket next = it.next();
                        if (scanInstance.getTypicalAttenuationDb() < next.maximumAttenuation) {
                            next.accumulatedSeconds += scanInstance.getSecondsSinceLastScan();
                            break;
                        }
                    }
                }
            } else {
                Bugfender.e("ReportType != CONFIRMED", "");
            }
        }
        return hashMap;
    }

    private boolean saveExposures(List<ExposureEntity> list) {
        if (list.isEmpty()) {
            return false;
        }
        return this.exposureRepository.tryInsert(list);
    }

    /* access modifiers changed from: private */
    public int postExposures(List<ExposureEntity> list) {
        for (ExposureEntity exposureEntity : list) {
            new DeviceExposureDataSource(this.applicationContext.mDeviceGuid, new Date(exposureEntity.getDateTimestampMs())).ExecuteRequest();
        }
        return list.size();
    }

    /* access modifiers changed from: private */
    public ListenableWorker.Result completeBackgroundWork(Exception exc) {
        boolean z = exc == null;
        ScanPostDataSource.Execute(this.applicationContext, z, 3, z ? null : exc.getMessage());
        return z ? ListenableWorker.Result.success() : ListenableWorker.Result.failure();
    }

    public static void runOnce(Context context) {
        WorkManager.getInstance(context).enqueue((OneTimeWorkRequest) new OneTimeWorkRequest.Builder(ExposureMatchManager.class).build());
    }
}
