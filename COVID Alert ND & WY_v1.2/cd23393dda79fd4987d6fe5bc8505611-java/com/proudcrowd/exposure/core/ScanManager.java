package com.proudcrowd.exposure.core;

import android.content.Context;
import android.util.Log;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import com.bugfender.sdk.Bugfender;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.proudcrowd.exposure.datasource.ScanPostDataSource;
import com.proudcrowd.exposure.misc.AppExecutors;
import com.proudcrowd.exposure.misc.TaskToFutureAdapter;
import com.proudcrowd.exposure.storage.KeyScanEntity;
import com.proudcrowd.exposure.storage.KeyScanRepository;
import com.proudcrowd.exposure.storage.WatermarkUrlRepository;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.threeten.bp.Duration;

public final class ScanManager extends ListenableWorker {
    private static final Duration EN_ENABLED_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration JOB_FLEX_INTERVAL = Duration.ofHours(6);
    public static final Duration JOB_INTERVAL = Duration.ofHours(8);
    private static final String TAG = "ScanManager";
    private final ExposureApplication applicationContext;
    private boolean isDetectingExposures = false;
    private final KeyScanRepository keyScanRepository;
    private final WatermarkUrlRepository watermarkUrlRepository;

    static /* synthetic */ ExposureDetectionInfo lambda$null$6(ExposureDetectionInfo exposureDetectionInfo, Void r1) {
        return exposureDetectionInfo;
    }

    public ScanManager(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.keyScanRepository = new KeyScanRepository(context);
        this.watermarkUrlRepository = new WatermarkUrlRepository(context);
        this.applicationContext = (ExposureApplication) context;
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        if (this.applicationContext.mDeviceGuid == null || this.applicationContext.mStudy == null || this.applicationContext.mStudy.id == 0) {
            return Futures.immediateFuture(ListenableWorker.Result.success());
        }
        if (this.isDetectingExposures) {
            Bugfender.d("Scan Stop", "IsDetectingExposures");
            return Futures.immediateFuture(ListenableWorker.Result.success());
        }
        this.isDetectingExposures = true;
        if (NetworkCheck.getInstance(this.applicationContext).isOnline()) {
            return doBackgroundWork();
        }
        Bugfender.d("Scan Stop", "No Network");
        return Futures.immediateFuture(ListenableWorker.Result.failure());
    }

    private ListenableFuture<ListenableWorker.Result> doBackgroundWork() {
        return FluentFuture.from(MaintenanceManager.execute(this.applicationContext)).transformAsync(new AsyncFunction() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$8FEnoLmN0tI0PenuxdsIC96NCNY */

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ScanManager.this.lambda$doBackgroundWork$0$ScanManager((Void) obj);
            }
        }, AppExecutors.getScheduledExecutor()).transformAsync(new AsyncFunction() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$ORhkKygSaqYqpISW_2w67i_jimc */

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ScanManager.this.lambda$doBackgroundWork$1$ScanManager((Boolean) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transformAsync(new AsyncFunction() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$743c4whlnzglbofl2bMI7AlljtA */

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ScanManager.this.lambda$doBackgroundWork$3$ScanManager((List) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transformAsync(new AsyncFunction() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$HQxpi2YBj6SAQ4lviBzZoMa63dE */

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ScanManager.this.lambda$doBackgroundWork$7$ScanManager((ExposureDetectionInfo) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transformAsync(new AsyncFunction() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$_6AOgVYxCPwaikWAqU6mqsUm6w */

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ScanManager.this.lambda$doBackgroundWork$8$ScanManager((ExposureDetectionInfo) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).catchingAsync(Exception.class, new AsyncFunction() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$2dH4vECMZWgTWBf2w8D4OXpvY6s */

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ScanManager.this.lambda$doBackgroundWork$9$ScanManager((Exception) obj);
            }
        }, AppExecutors.getBackgroundExecutor());
    }

    public /* synthetic */ ListenableFuture lambda$doBackgroundWork$0$ScanManager(Void r5) throws Exception {
        return TaskToFutureAdapter.getFutureWithTimeout(ExposureClient.get(this.applicationContext).isEnabled(), EN_ENABLED_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
    }

    public /* synthetic */ ListenableFuture lambda$doBackgroundWork$1$ScanManager(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            return this.watermarkUrlRepository.getAllAsync();
        }
        return Futures.immediateFailedFuture(new NotEnabledException());
    }

    public /* synthetic */ ListenableFuture lambda$doBackgroundWork$3$ScanManager(List list) throws Exception {
        return ExposureManager.get(this.applicationContext).detectExposures(Lists.transform(list, $$Lambda$ScanManager$BlmL16y3wyhp0lfWsHkn8QZ7E8.INSTANCE));
    }

    public /* synthetic */ ListenableFuture lambda$doBackgroundWork$7$ScanManager(ExposureDetectionInfo exposureDetectionInfo) throws Exception {
        ImmutableList<String> newWatermarkUrlFragments = exposureDetectionInfo.getNewWatermarkUrlFragments();
        if (!exposureDetectionInfo.getSucceeded() || newWatermarkUrlFragments == null || newWatermarkUrlFragments.isEmpty()) {
            return Futures.immediateFuture(exposureDetectionInfo);
        }
        return FluentFuture.from(this.watermarkUrlRepository.deleteAllAsync()).transformAsync(new AsyncFunction(newWatermarkUrlFragments) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$EBdBQfz53tgrpvC1hW0E4yLDEJA */
            public final /* synthetic */ ImmutableList f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ScanManager.this.lambda$null$5$ScanManager(this.f$1, (Void) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transform(new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$aZLxQqLUtQYcjrrVtzauSoFRP8g */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ScanManager.lambda$null$6(ExposureDetectionInfo.this, (Void) obj);
            }
        }, AppExecutors.getLightweightExecutor());
    }

    public /* synthetic */ ListenableFuture lambda$null$5$ScanManager(ImmutableList immutableList, Void r2) throws Exception {
        return this.watermarkUrlRepository.upsertAsync(Lists.transform(immutableList, $$Lambda$ScanManager$sR3bWts6JLL8p9zroRw2kAYvnUk.INSTANCE));
    }

    public /* synthetic */ ListenableFuture lambda$doBackgroundWork$8$ScanManager(ExposureDetectionInfo exposureDetectionInfo) throws Exception {
        return completeBackgroundWork(exposureDetectionInfo.getError(), exposureDetectionInfo);
    }

    public /* synthetic */ ListenableFuture lambda$doBackgroundWork$9$ScanManager(Exception exc) throws Exception {
        return completeBackgroundWork(exc, null);
    }

    private ListenableFuture<ListenableWorker.Result> completeBackgroundWork(Exception exc, ExposureDetectionInfo exposureDetectionInfo) {
        boolean z = exc != null;
        return FluentFuture.from(Futures.immediateFuture(Boolean.valueOf(z))).transformAsync(new AsyncFunction(z) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$ZdcSgS5n9BAzEDoh7b9DoLH42X4 */
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ScanManager.this.lambda$completeBackgroundWork$10$ScanManager(this.f$1, (Boolean) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transform(new Function(exposureDetectionInfo, z, exc) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$USZh_gZC4UupV0vA1EmDGIuag_Q */
            public final /* synthetic */ ExposureDetectionInfo f$1;
            public final /* synthetic */ boolean f$2;
            public final /* synthetic */ Exception f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ScanManager.this.lambda$completeBackgroundWork$11$ScanManager(this.f$1, this.f$2, this.f$3, (Void) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transform(new Function(exc) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ScanManager$NH2s6yIb0uUJJxc6NeKJBHyeI */
            public final /* synthetic */ Exception f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ScanManager.this.lambda$completeBackgroundWork$12$ScanManager(this.f$1, (Boolean) obj);
            }
        }, AppExecutors.getLightweightExecutor());
    }

    public /* synthetic */ ListenableFuture lambda$completeBackgroundWork$10$ScanManager(boolean z, Boolean bool) throws Exception {
        if (!z) {
            return this.keyScanRepository.upsertAsync(KeyScanEntity.create());
        }
        return Futures.immediateVoidFuture();
    }

    public /* synthetic */ Boolean lambda$completeBackgroundWork$11$ScanManager(ExposureDetectionInfo exposureDetectionInfo, boolean z, Exception exc, Void r6) {
        boolean z2 = true;
        boolean z3 = exposureDetectionInfo != null && exposureDetectionInfo.getSucceeded() && exposureDetectionInfo.getKeyFiles().size() == 0;
        if (!z && !z3) {
            z2 = false;
        }
        if (z2) {
            postScanResult(exc);
        }
        return Boolean.valueOf(z2);
    }

    public /* synthetic */ ListenableWorker.Result lambda$completeBackgroundWork$12$ScanManager(Exception exc, Boolean bool) {
        boolean z = exc == null || (exc instanceof NotEnabledException);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Background work completed. Succeded: ");
        sb.append(z);
        sb.append(". Exception: ");
        sb.append(z ? "null" : exc.getMessage());
        Log.d(str, sb.toString());
        this.isDetectingExposures = false;
        return z ? ListenableWorker.Result.success() : ListenableWorker.Result.failure();
    }

    private void postScanResult(Exception exc) {
        String str;
        boolean z = exc != null;
        int i = 3;
        if (z) {
            boolean z2 = exc instanceof NotEnabledException;
            if (z2) {
                str = "No Authorization";
            } else {
                str = exc.getMessage();
            }
            i = !z2 ? 1 : 0;
        } else {
            str = null;
        }
        ScanPostDataSource.Execute(this.applicationContext, true ^ z, i, str);
    }

    public static void schedule(Context context) {
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(context.getPackageName() + ".exposure-notification", ExistingPeriodicWorkPolicy.REPLACE, (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(ScanManager.class, JOB_INTERVAL.toHours(), TimeUnit.HOURS, JOB_FLEX_INTERVAL.toHours(), TimeUnit.HOURS).setConstraints(new Constraints.Builder().setRequiresBatteryNotLow(true).setRequiredNetworkType(NetworkType.CONNECTED).build())).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS)).build());
    }

    public static void runOnce(Context context) {
        WorkManager.getInstance(context).enqueue((OneTimeWorkRequest) new OneTimeWorkRequest.Builder(ScanManager.class).build());
    }

    /* access modifiers changed from: private */
    public static class NotEnabledException extends Exception {
        private NotEnabledException() {
        }
    }
}
