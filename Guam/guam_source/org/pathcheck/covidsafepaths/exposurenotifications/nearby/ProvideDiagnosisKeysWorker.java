package org.pathcheck.covidsafepaths.exposurenotifications.nearby;

import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat$Builder;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.horcrux.svg.PathParser;
import com.horcrux.svg.R;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;
import org.pathcheck.covidsafepaths.exposurenotifications.common.AppExecutors;
import org.pathcheck.covidsafepaths.exposurenotifications.common.NotificationHelper;
import org.pathcheck.covidsafepaths.exposurenotifications.network.DiagnosisKeys;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

public class ProvideDiagnosisKeysWorker extends ListenableWorker {
    public static final Duration IS_ENABLED_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration JOB_FLEX_INTERVAL = Duration.create(PathParser.safeMultiply(3L, 3600), 0);
    public static final Duration JOB_INTERVAL = Duration.create(PathParser.safeMultiply(12L, 3600), 0);
    public final DiagnosisKeys diagnosisKeys;
    public final ExposureNotificationSharedPreferences prefs;
    public final DiagnosisKeyFileSubmitter submitter;

    public static class NotEnabledException extends Exception {
        public NotEnabledException() {
        }

        public NotEnabledException(AnonymousClass1 r1) {
        }
    }

    public ProvideDiagnosisKeysWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.diagnosisKeys = new DiagnosisKeys(context);
        this.submitter = new DiagnosisKeyFileSubmitter(context);
        this.prefs = new ExposureNotificationSharedPreferences(context);
    }

    public static void cancel(Context context) {
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
        if (instance != null) {
            ((WorkManagerTaskExecutor) instance.mWorkTaskExecutor).mBackgroundExecutor.execute(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
                  (wrap: androidx.work.impl.utils.SerialExecutor : 0x0012: IGET  (r3v5 androidx.work.impl.utils.SerialExecutor) = 
                  (wrap: androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor : 0x0010: CHECK_CAST (r3v4 androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor) = (androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor) (wrap: androidx.work.impl.utils.taskexecutor.TaskExecutor : 0x000e: IGET  (r3v3 androidx.work.impl.utils.taskexecutor.TaskExecutor) = (r3v1 'instance' androidx.work.impl.WorkManagerImpl) androidx.work.impl.WorkManagerImpl.mWorkTaskExecutor androidx.work.impl.utils.taskexecutor.TaskExecutor))
                 androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor.mBackgroundExecutor androidx.work.impl.utils.SerialExecutor)
                  (wrap: androidx.work.impl.utils.CancelWorkRunnable$3 : 0x000b: CONSTRUCTOR  (r0v0 androidx.work.impl.utils.CancelWorkRunnable$3) = (r3v1 'instance' androidx.work.impl.WorkManagerImpl), ("ProvideDiagnosisKeysWorker"), true call: androidx.work.impl.utils.CancelWorkRunnable.3.<init>(androidx.work.impl.WorkManagerImpl, java.lang.String, boolean):void type: CONSTRUCTOR)
                 type: VIRTUAL call: androidx.work.impl.utils.SerialExecutor.execute(java.lang.Runnable):void in method: org.pathcheck.covidsafepaths.exposurenotifications.nearby.ProvideDiagnosisKeysWorker.cancel(android.content.Context):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r0v0 androidx.work.impl.utils.CancelWorkRunnable$3) = (r3v1 'instance' androidx.work.impl.WorkManagerImpl), ("ProvideDiagnosisKeysWorker"), true call: androidx.work.impl.utils.CancelWorkRunnable.3.<init>(androidx.work.impl.WorkManagerImpl, java.lang.String, boolean):void type: CONSTRUCTOR in method: org.pathcheck.covidsafepaths.exposurenotifications.nearby.ProvideDiagnosisKeysWorker.cancel(android.content.Context):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.work.impl.utils.CancelWorkRunnable, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
                androidx.work.impl.WorkManagerImpl r3 = androidx.work.impl.WorkManagerImpl.getInstance(r3)
                if (r3 == 0) goto L_0x0018
                androidx.work.impl.utils.CancelWorkRunnable$3 r0 = new androidx.work.impl.utils.CancelWorkRunnable$3
                r1 = 1
                java.lang.String r2 = "ProvideDiagnosisKeysWorker"
                r0.<init>(r2, r1)
                androidx.work.impl.utils.taskexecutor.TaskExecutor r3 = r3.mWorkTaskExecutor
                androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor r3 = (androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor) r3
                androidx.work.impl.utils.SerialExecutor r3 = r3.mBackgroundExecutor
                r3.execute(r0)
                return
            L_0x0018:
                r3 = 0
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: org.pathcheck.covidsafepaths.exposurenotifications.nearby.ProvideDiagnosisKeysWorker.cancel(android.content.Context):void");
        }

        public static ListenableWorker.Result lambda$startWork$2(NotEnabledException notEnabledException) {
            return new ListenableWorker.Result.Success();
        }

        public static ListenableWorker.Result lambda$startWork$3(Exception exc) {
            Log.e("ProvideDiagnosisKeysWkr", "Failure to provide diagnosis keys", exc);
            return new ListenableWorker.Result.Failure();
        }

        public static void schedule(Context context) {
            WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
            TimeUnit timeUnit = TimeUnit.HOURS;
            PeriodicWorkRequest.Builder builder = new PeriodicWorkRequest.Builder(ProvideDiagnosisKeysWorker.class, JOB_INTERVAL.seconds / 3600, timeUnit, JOB_FLEX_INTERVAL.seconds / 3600, timeUnit);
            Constraints.Builder builder2 = new Constraints.Builder();
            builder2.mRequiresBatteryNotLow = true;
            builder2.mRequiredNetworkType = NetworkType.CONNECTED;
            Constraints constraints = new Constraints(builder2);
            WorkSpec workSpec = builder.mWorkSpec;
            workSpec.constraints = constraints;
            BackoffPolicy backoffPolicy = BackoffPolicy.EXPONENTIAL;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            builder.mBackoffCriteriaSet = true;
            workSpec.backoffPolicy = backoffPolicy;
            long millis = timeUnit2.toMillis(30000);
            if (millis > 18000000) {
                Logger.get().warning(WorkSpec.TAG, "Backoff delay duration exceeds maximum value", new Throwable[0]);
                millis = 18000000;
            }
            if (millis < 10000) {
                Logger.get().warning(WorkSpec.TAG, "Backoff delay duration less than minimum value", new Throwable[0]);
                millis = 10000;
            }
            workSpec.backoffDelayDuration = millis;
            PeriodicWorkRequest periodicWorkRequest = (PeriodicWorkRequest) builder.build();
            if (instance != null) {
                new WorkContinuationImpl(instance, "ProvideDiagnosisKeysWorker", ExistingWorkPolicy.KEEP, Collections.singletonList(periodicWorkRequest), null).enqueue();
                return;
            }
            throw null;
        }

        public final ForegroundInfo createForegroundInfo() {
            Context context = this.mAppContext;
            NotificationHelper.createNotificationChannel(context);
            NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, "EXPOSURE_NOTIFICATION_CHANNEL_ID");
            notificationCompat$Builder.mNotification.icon = R.drawable.ic_notification;
            notificationCompat$Builder.mColor = context.getResources().getColor(R.color.colorPrimary, context.getTheme());
            notificationCompat$Builder.setContentTitle(context.getString(R.string.background_worker_notification_title));
            notificationCompat$Builder.setFlag(2, true);
            return new ForegroundInfo(NotificationHelper.BACKGROUND_WORKER_NOTIFICATION_ID.intValue(), notificationCompat$Builder.build());
        }

        public /* synthetic */ ListenableFuture lambda$startWork$0$ProvideDiagnosisKeysWorker(Boolean bool) throws Exception {
            if (!bool.booleanValue()) {
                return ReactYogaConfigProvider.immediateFailedFuture(new NotEnabledException(null));
            }
            setForegroundAsync(createForegroundInfo());
            return this.diagnosisKeys.download();
        }

        public ListenableWorker.Result lambda$startWork$1$ProvideDiagnosisKeysWorker(Object obj) {
            this.prefs.sharedPreferences.edit().putLong("ExposureNotificationSharedPreferences.LAST_DETECTION_PROCESS_DATE", Long.valueOf(Instant.now().toEpochMilli()).longValue()).commit();
            return new ListenableWorker.Result.Success();
        }

        @Override // androidx.work.ListenableWorker
        public ListenableFuture<ListenableWorker.Result> startWork() {
            FluentFuture transformAsync = FluentFuture.from(PathParser.getFutureWithTimeout(ExposureNotificationClientWrapper.get(this.mAppContext).isEnabled(), IS_ENABLED_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).transformAsync(new AsyncFunction() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.nearby.$$Lambda$ProvideDiagnosisKeysWorker$gOP_kahnjJSkGfsUpaE26p7szU */

                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return ProvideDiagnosisKeysWorker.this.lambda$startWork$0$ProvideDiagnosisKeysWorker((Boolean) obj);
                }
            }, AppExecutors.getBackgroundExecutor());
            DiagnosisKeyFileSubmitter diagnosisKeyFileSubmitter = this.submitter;
            diagnosisKeyFileSubmitter.getClass();
            return transformAsync.transformAsync(new AsyncFunction() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.nearby.$$Lambda$lnmBFt27sqyBBQjpDuOFCyrio8s */

                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return DiagnosisKeyFileSubmitter.this.submitFiles((ImmutableList) obj);
                }
            }, AppExecutors.getBackgroundExecutor()).transform(new Function() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.nearby.$$Lambda$ProvideDiagnosisKeysWorker$xh3T1QMWWoAJFhLyqbCMzNkNEz4 */

                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return ProvideDiagnosisKeysWorker.this.lambda$startWork$1$ProvideDiagnosisKeysWorker(obj);
                }
            }, AppExecutors.getLightweightExecutor()).catching(NotEnabledException.class, $$Lambda$ProvideDiagnosisKeysWorker$oZhW9CaEINesgm7BjA3bjM4Iso.INSTANCE, AppExecutors.getBackgroundExecutor()).catching(Exception.class, $$Lambda$ProvideDiagnosisKeysWorker$fTz5_CwmNQktn2zDlnnDMZ8_zs.INSTANCE, AppExecutors.getBackgroundExecutor());
        }
    }
