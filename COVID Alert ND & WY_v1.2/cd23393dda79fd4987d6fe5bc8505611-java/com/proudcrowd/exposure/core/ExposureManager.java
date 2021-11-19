package com.proudcrowd.exposure.core;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bugfender.sdk.Bugfender;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.proudcrowd.exposure.datamodel.DiagnosisKeyFile;
import com.proudcrowd.exposure.datamodel.ExposureConfigurationDetail;
import com.proudcrowd.exposure.datasource.ExposureConfigurationDataSource;
import com.proudcrowd.exposure.datasource.ExposureManagerDataSource;
import com.proudcrowd.exposure.misc.AppExecutors;
import com.proudcrowd.exposure.misc.TaskToFutureAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.threeten.bp.Duration;

public final class ExposureManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Duration GET_TEKS_TIMEOUT = Duration.ofSeconds(30);
    private static ExposureManager INSTANCE = null;
    private static final Duration PROVIDE_KEYS_TIMEOUT = Duration.ofMinutes(30);
    private static final String TAG = "ExposureManager";
    private static final Splitter WHITESPACE_SPLITTER = Splitter.onPattern("\\s+").trimResults().omitEmptyStrings();
    private final ExposureApplication applicationContext;

    static /* synthetic */ ExposureDetectionInfo lambda$detectExposures$4(ExposureDetectionInfo exposureDetectionInfo, Object obj) {
        return exposureDetectionInfo;
    }

    static /* synthetic */ Exception lambda$getAndPostDiagnosisKeys$10(Exception exc) {
        return exc;
    }

    public static ExposureManager get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ExposureManager(context);
        }
        return INSTANCE;
    }

    private ExposureManager(Context context) {
        this.applicationContext = (ExposureApplication) context.getApplicationContext();
    }

    public ListenableFuture<ExposureDetectionInfo> detectExposures(Collection<String> collection) {
        ExposureDetectionInfo exposureDetectionInfo = new ExposureDetectionInfo(this.applicationContext);
        ExposureManagerDataSource exposureManagerDataSource = new ExposureManagerDataSource(this.applicationContext);
        ExposureConfigurationDataSource exposureConfigurationDataSource = new ExposureConfigurationDataSource(this.applicationContext.mDeviceGuid, this.applicationContext.mStudy.id);
        Bugfender.d("Download Scan", "Starting");
        return FluentFuture.from(exposureConfigurationDataSource.ExecuteFutureRequest()).transform(new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$4R5cHLmHV4D249DwRfluH81CdGs */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureDetectionInfo.this.setConfiguration((ExposureConfigurationDetail) obj);
            }
        }, AppExecutors.getLightweightExecutor()).transformAsync(new AsyncFunction(exposureDetectionInfo) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureManager$bsNRpu8WI9VH86HUby89MT7uOt8 */
            public final /* synthetic */ ExposureDetectionInfo f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                ListenableFuture listenableFuture = (ListenableFuture) obj;
                return ExposureManagerDataSource.this.downloadIndex(this.f$1.getDownloadIndexUri());
            }
        }, AppExecutors.getBackgroundExecutor()).transform(new Function(collection, exposureDetectionInfo) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureManager$JxY7HTF1Q3JfGgGxNe2GW3ire5E */
            public final /* synthetic */ Collection f$1;
            public final /* synthetic */ ExposureDetectionInfo f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureManager.this.lambda$detectExposures$1$ExposureManager(this.f$1, this.f$2, (String) obj);
            }
        }, AppExecutors.getLightweightExecutor()).transformAsync(new AsyncFunction(exposureDetectionInfo) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureManager$JSxCKkUwXr_A6oYvEPKg0YehTws */
            public final /* synthetic */ ExposureDetectionInfo f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ExposureManagerDataSource.this.download(this.f$1.getDownloadBaseUri(), (Collection) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transform(new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$1OrNNGzzHzrkvsPW32Mnl6J3R80 */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureDetectionInfo.this.setKeyFiles((ImmutableList) obj);
            }
        }, AppExecutors.getLightweightExecutor()).transformAsync(new AsyncFunction(exposureDetectionInfo) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureManager$JWe0Ja2C06KOJXI0r0Gjgndpcg */
            public final /* synthetic */ ExposureDetectionInfo f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ExposureManager.this.lambda$detectExposures$3$ExposureManager(this.f$1, (ListenableFuture) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transform(new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureManager$zuVHVH09sE9uAr0IQ2oX6EBJhAE */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureManager.lambda$detectExposures$4(ExposureDetectionInfo.this, obj);
            }
        }, AppExecutors.getLightweightExecutor()).catching(Exception.class, new Function() {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureManager$qMT7MHiLgxBeTulbbGNkoXDOyY */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureDetectionInfo.this.setError((Exception) obj);
            }
        }, AppExecutors.getLightweightExecutor());
    }

    public /* synthetic */ ListenableFuture lambda$detectExposures$3$ExposureManager(ExposureDetectionInfo exposureDetectionInfo, ListenableFuture listenableFuture) throws Exception {
        return detectExposures(exposureDetectionInfo.getKeyFiles(), exposureDetectionInfo.getConfiguration());
    }

    /* access modifiers changed from: private */
    /* renamed from: parseKeyFileIndex */
    public Collection<String> lambda$detectExposures$1$ExposureManager(String str, Collection<String> collection, ExposureDetectionInfo exposureDetectionInfo) {
        List<String> splitToList = WHITESPACE_SPLITTER.splitToList(str);
        String str2 = TAG;
        Log.d(str2, "Inspected key files index. File count: " + splitToList.size());
        HashSet hashSet = new HashSet(collection);
        HashSet hashSet2 = new HashSet(splitToList);
        hashSet2.removeAll(hashSet);
        Log.d(str2, "Determined files need to be downloaded after watermark. File count: " + hashSet2.size());
        exposureDetectionInfo.setNewWatermarkUrlFragments(ImmutableList.builder().addAll((Iterable) splitToList).build());
        return hashSet2;
    }

    private ListenableFuture<?> detectExposures(List<DiagnosisKeyFile> list, ExposureConfiguration exposureConfiguration) {
        if (list.isEmpty()) {
            Bugfender.d("detectExposures", "No files to process");
            return Futures.immediateFuture(null);
        }
        Bugfender.d("Scan Starting Detect", "Files to process");
        ArrayList arrayList = new ArrayList();
        for (DiagnosisKeyFile diagnosisKeyFile : list) {
            arrayList.addAll(diagnosisKeyFile.files());
        }
        String str = TAG;
        Log.d(str, "Calling exposure detection API. Size: " + arrayList.size());
        ListenableFuture<?> futureWithTimeout = TaskToFutureAdapter.getFutureWithTimeout(ExposureClient.get(this.applicationContext).provideDiagnosisKeys(arrayList, exposureConfiguration), PROVIDE_KEYS_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
        futureWithTimeout.addListener(new Runnable(list) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureManager$FqyFKs5vfWtXaZSHwybu_Ma1DFE */
            public final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                ExposureManager.lambda$detectExposures$6(this.f$0);
            }
        }, AppExecutors.getBackgroundExecutor());
        return futureWithTimeout;
    }

    static /* synthetic */ void lambda$detectExposures$6(List list) {
        String str = TAG;
        Log.d(str, "Completed exposure detection. Deleting downloaded key files. Batch count: " + list.size());
        Bugfender.d(str, "Completed exposure detection. Deleting downloaded key files. Batch count: " + list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UnmodifiableIterator<File> it2 = ((DiagnosisKeyFile) it.next()).files().iterator();
            while (it2.hasNext()) {
                it2.next().delete();
            }
        }
        String str2 = TAG;
        Log.d(str2, "Deleted downloaded key files. Batch count: " + list.size());
    }

    public void getAndPostDiagnosisKeys(FutureCallback<Exception> futureCallback) {
        ExposureManagerDataSource exposureManagerDataSource = new ExposureManagerDataSource(this.applicationContext);
        String uploadServerAddress = this.applicationContext.getPreferences().getUploadServerAddress("");
        if (uploadServerAddress.isEmpty()) {
            Log.d(TAG, "Upload URI is not populated, method was called before a scan was performed.");
            Futures.addCallback(Futures.immediateFuture(new UploadUriNotAvailableException()), futureCallback, AppExecutors.getLightweightExecutor());
            return;
        }
        Futures.addCallback(FluentFuture.from(TaskToFutureAdapter.getFutureWithTimeout(ExposureClient.get(this.applicationContext).getTemporaryExposureKeyHistory(), GET_TEKS_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).transform($$Lambda$ExposureManager$BW5w5XDnmKW9rfr5vZsnipiPuQ4.INSTANCE, AppExecutors.getLightweightExecutor()).transformAsync(new AsyncFunction(uploadServerAddress, exposureManagerDataSource) {
            /* class com.proudcrowd.exposure.core.$$Lambda$ExposureManager$Gm2Ei2FhJMD81fyxRUOrP8o0xlI */
            public final /* synthetic */ String f$0;
            public final /* synthetic */ ExposureManagerDataSource f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.f$1.upload(Uri.parse(this.f$0), (ImmutableList) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transform($$Lambda$ExposureManager$Z5aidqLIY0KiWRPUfYBzaW7c5Qk.INSTANCE, AppExecutors.getLightweightExecutor()).catching(Exception.class, $$Lambda$ExposureManager$3valRmwElpCPgyE1BVMFREoz0Q.INSTANCE, AppExecutors.getLightweightExecutor()), futureCallback, AppExecutors.getLightweightExecutor());
    }

    static /* synthetic */ ImmutableList lambda$getAndPostDiagnosisKeys$7(List list) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) it.next();
            builder.add((Object) DiagnosisKey.newBuilder().setTransmissionRisk(2).setReportType(1).setKeyBytes(temporaryExposureKey.getKeyData()).setRollingStartNumber(temporaryExposureKey.getRollingStartIntervalNumber()).setRollingPeriod(temporaryExposureKey.getRollingPeriod()).build());
        }
        return builder.build();
    }

    static /* synthetic */ Exception lambda$getAndPostDiagnosisKeys$9(Object obj) {
        return null;
    }

    /* access modifiers changed from: private */
    public static class UploadUriNotAvailableException extends Exception {
        private UploadUriNotAvailableException() {
        }
    }
}
