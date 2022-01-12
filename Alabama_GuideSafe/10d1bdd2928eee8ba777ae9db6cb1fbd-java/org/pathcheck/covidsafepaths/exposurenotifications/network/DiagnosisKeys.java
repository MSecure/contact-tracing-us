package org.pathcheck.covidsafepaths.exposurenotifications.network;

import android.content.Context;
import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures$CallbackListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.pathcheck.covidsafepaths.exposurenotifications.common.AppExecutors;

public class DiagnosisKeys {
    public final DiagnosisKeyDownloader diagnosisKeyDownloader;

    public DiagnosisKeys(Context context) {
        this.diagnosisKeyDownloader = new DiagnosisKeyDownloader(context.getApplicationContext());
    }

    public ListenableFuture<ImmutableList<KeyFileBatch>> download() {
        DiagnosisKeyDownloader diagnosisKeyDownloader2 = this.diagnosisKeyDownloader;
        if (diagnosisKeyDownloader2 != null) {
            byte[] bArr = new byte[8];
            DiagnosisKeyDownloader.RAND.nextBytes(bArr);
            String encode = DiagnosisKeyDownloader.BASE32.encode(bArr);
            diagnosisKeyDownloader2.context.registerReceiver(diagnosisKeyDownloader2.downloadStatusReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            Uris uris = diagnosisKeyDownloader2.uris;
            if (uris != null) {
                FluentFuture withTimeout = FluentFuture.from(FluentFuture.from(FluentFuture.from(AppCompatDelegateImpl.ConfigurationImplApi17.getFuture(new CallbackToFutureAdapter$Resolver() {
                    /* class org.pathcheck.covidsafepaths.exposurenotifications.network.$$Lambda$Uris$fdNtoxYhJzXo39CQyyFShYkaj_E */

                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
                        return Uris.this.lambda$getIndexFileContent$3$Uris(callbackToFutureAdapter$Completer);
                    }
                })).transform(new Function() {
                    /* class org.pathcheck.covidsafepaths.exposurenotifications.network.$$Lambda$Uris$Eya_OGs4Bt36rXrBGjIoAhksEo4 */

                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        return Uris.this.lambda$getKeyFileBatches$1$Uris((String) obj);
                    }
                }, AppExecutors.getBackgroundExecutor())).transform($$Lambda$Uris$muaYIUhTXw8rAqdiibgMJ8zBcrs.INSTANCE, AppExecutors.getLightweightExecutor())).transformAsync(new AsyncFunction(encode) {
                    /* class org.pathcheck.covidsafepaths.exposurenotifications.network.$$Lambda$DiagnosisKeyDownloader$7YMfrE61I1XgU94lsPEoIRsWn_0 */
                    public final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    @Override // com.google.common.util.concurrent.AsyncFunction
                    public final ListenableFuture apply(Object obj) {
                        return DiagnosisKeyDownloader.this.lambda$download$0$DiagnosisKeyDownloader(this.f$1, (ImmutableList) obj);
                    }
                }, AppExecutors.getBackgroundExecutor()).transform(new Function() {
                    /* class org.pathcheck.covidsafepaths.exposurenotifications.network.$$Lambda$McJlF_vwIA0fjTbd91pvRAUJojU */

                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        return DiagnosisKeyDownloader.this.groupAsBatches((List) obj);
                    }
                }, AppExecutors.getBackgroundExecutor()).withTimeout(DiagnosisKeyDownloader.TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
                FutureCallback<ImmutableList<KeyFileBatch>> futureCallback = diagnosisKeyDownloader2.logOutcome;
                ListeningExecutorService lightweightExecutor = AppExecutors.getLightweightExecutor();
                if (futureCallback != null) {
                    withTimeout.addListener(new Futures$CallbackListener(withTimeout, futureCallback), lightweightExecutor);
                    withTimeout.addListener(new Runnable() {
                        /* class org.pathcheck.covidsafepaths.exposurenotifications.network.$$Lambda$DiagnosisKeyDownloader$XYbRwsmPyiq4Ync7jmp3OgAc1Y */

                        public final void run() {
                            DiagnosisKeyDownloader.this.lambda$download$1$DiagnosisKeyDownloader();
                        }
                    }, AppExecutors.getLightweightExecutor());
                    return withTimeout;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }
}
