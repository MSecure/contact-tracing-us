package com.proudcrowd.exposure.core;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.proudcrowd.exposure.datasource.DeviceExposureDataSource;
import com.proudcrowd.exposure.datasource.ExposureManagerDataSource;
import com.proudcrowd.exposure.misc.AppExecutors;
import com.proudcrowd.exposure.misc.TaskToFutureAdapter;
import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.threeten.bp.Duration;

public final class FakeScanManager extends ListenableWorker {
    private static final Duration API_TIMEOUT = Duration.ofSeconds(5);
    private static final double EXECUTION_PROBABILITY = 0.25d;
    private static final int FAKE_INTERVAL_NUM = 2650847;
    private static final int FAKE_KEY_SIZE = 16;
    private static final int FLEX_INTERVAL = 12;
    private static final TimeUnit FLEX_INTERVAL_UNITS = TimeUnit.HOURS;
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int REPEAT_INTERVAL = 24;
    private static final TimeUnit REPEAT_INTERVAL_UNITS = TimeUnit.HOURS;
    private static final String TAG = "FakeScanManager";
    private final ExposureApplication applicationContext;

    public FakeScanManager(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.applicationContext = (ExposureApplication) context;
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        if (!shouldExecute()) {
            return Futures.immediateFuture(ListenableWorker.Result.success());
        }
        ImmutableList<DiagnosisKey> createFakeDiagnosisKeys = createFakeDiagnosisKeys();
        ExposureManagerDataSource exposureManagerDataSource = new ExposureManagerDataSource(getApplicationContext());
        String uploadServerAddress = this.applicationContext.getPreferences().getUploadServerAddress("");
        if (uploadServerAddress.isEmpty()) {
            Log.d(TAG, "Upload URI is not populated, method was called before a scan was performed.");
            return Futures.immediateFuture(ListenableWorker.Result.success());
        }
        return FluentFuture.from(TaskToFutureAdapter.getFutureWithTimeout(ExposureClient.get(getApplicationContext()).isEnabled(), API_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).transform(new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$FakeScanManager$RhBh6MZ0pRJPCqXEwXVvXtKcCY */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(FakeScanManager.this.postRandomExposure(((Boolean) obj).booleanValue()));
            }
        }, AppExecutors.getBackgroundExecutor()).transformAsync(new AsyncFunction(Uri.parse(uploadServerAddress), createFakeDiagnosisKeys) {
            /* class com.proudcrowd.exposure.core.$$Lambda$FakeScanManager$05TrIOd43WHl3FEE9SCUbUeAaEQ */
            public final /* synthetic */ Uri f$1;
            public final /* synthetic */ ImmutableList f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return FakeScanManager.lambda$startWork$0(ExposureManagerDataSource.this, this.f$1, this.f$2, (Boolean) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transform($$Lambda$FakeScanManager$ybSi5PVBDPzkuEsPBf09_5xnxw.INSTANCE, AppExecutors.getLightweightExecutor()).catching(Throwable.class, $$Lambda$FakeScanManager$eYnGWQjQeZD7bDnEyhW8S1HL4w.INSTANCE, AppExecutors.getLightweightExecutor());
    }

    static /* synthetic */ ListenableFuture lambda$startWork$0(ExposureManagerDataSource exposureManagerDataSource, Uri uri, ImmutableList immutableList, Boolean bool) throws Exception {
        return bool.booleanValue() ? exposureManagerDataSource.uploadFakeKeys(uri, immutableList) : Futures.immediateFuture(null);
    }

    /* access modifiers changed from: private */
    public boolean postRandomExposure(boolean z) {
        if (z) {
            new DeviceExposureDataSource(UUID.randomUUID().toString(), new Date()).ExecuteRequest();
        }
        return z;
    }

    public ImmutableList<DiagnosisKey> createFakeDiagnosisKeys() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < 16; i++) {
            byte[] bArr = new byte[16];
            RANDOM.nextBytes(bArr);
            builder.add((Object) DiagnosisKey.newBuilder().setKeyBytes(bArr).setTransmissionRisk(i % 7).setReportType(1).setRollingStartNumber(FAKE_INTERVAL_NUM).build());
        }
        return builder.build();
    }

    private boolean shouldExecute() {
        return RANDOM.nextDouble() < EXECUTION_PROBABILITY;
    }

    public static void schedule(Context context) {
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(context.getPackageName() + ".fake-exposure-notification", ExistingPeriodicWorkPolicy.REPLACE, (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(FakeScanManager.class, 24, REPEAT_INTERVAL_UNITS, 12, FLEX_INTERVAL_UNITS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).build());
    }

    public static void runOnce(Context context) {
        WorkManager.getInstance(context).enqueue((OneTimeWorkRequest) new OneTimeWorkRequest.Builder(FakeScanManager.class).build());
    }
}
