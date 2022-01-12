package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzu;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.gson.Gson;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;
import io.realm.internal.OsResults;
import io.realm.internal.SubscriptionAwareOsResults;
import io.realm.internal.TableQuery;
import io.realm.internal.core.DescriptorOrdering;
import io.realm.internal.sync.SubscriptionAction;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;
import org.pathcheck.covidsafepaths.exposurenotifications.dto.RNExposureInformation;
import org.pathcheck.covidsafepaths.exposurenotifications.nearby.ProvideDiagnosisKeysWorker;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity;

@ReactModule(name = "ExposureHistoryModule")
public class ExposureHistoryModule extends ReactContextBaseJavaModule {
    public static final String MODULE_NAME = "ExposureHistoryModule";
    public static final String TAG = "ExposureHistoryModule";
    public ExposureNotificationSharedPreferences prefs;

    public ExposureHistoryModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.prefs = new ExposureNotificationSharedPreferences(reactApplicationContext);
    }

    @ReactMethod
    public void detectExposures(Promise promise) {
        Task<Boolean> isEnabled = ExposureNotificationClientWrapper.get(getReactApplicationContext()).isEnabled();
        $$Lambda$ExposureHistoryModule$nnFxxOARIMLXpm5t1DAqPKVcm54 r1 = new OnSuccessListener(promise) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$ExposureHistoryModule$nnFxxOARIMLXpm5t1DAqPKVcm54 */
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ExposureHistoryModule.this.lambda$detectExposures$0$ExposureHistoryModule(this.f$1, (Boolean) obj);
            }
        };
        zzu zzu = (zzu) isEnabled;
        if (zzu != null) {
            zzu.addOnSuccessListener(TaskExecutors.MAIN_THREAD, r1);
            promise.getClass();
            zzu.addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.$$Lambda$4FnuZITwpTidBCa7qe8kzCWQ6s */

                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Promise.this.reject(exc);
                }
            });
            return;
        }
        throw null;
    }

    @ReactMethod
    public void fetchLastDetectionDate(Promise promise) {
        long j = this.prefs.sharedPreferences.getLong("ExposureNotificationSharedPreferences.LAST_DETECTION_PROCESS_DATE", -1);
        Double d = null;
        Long valueOf = j != -1 ? Long.valueOf(j) : null;
        if (valueOf != null) {
            d = Double.valueOf(valueOf.doubleValue());
        }
        promise.resolve(d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009d, code lost:
        com.google.common.util.concurrent.MoreExecutors.closeFinally(r0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a0, code lost:
        throw r1;
     */
    @ReactMethod
    public void getCurrentExposures(Promise promise) {
        OsResults osResults;
        Realm realmInstance = RealmSecureStorageBte.INSTANCE.getRealmInstance();
        realmInstance.checkIfValid();
        DescriptorOrdering descriptorOrdering = new DescriptorOrdering();
        boolean z = true;
        TableQuery where = !RealmModel.class.isAssignableFrom(ExposureEntity.class) ? null : realmInstance.schema.getSchemaForClass(ExposureEntity.class).table.where();
        realmInstance.checkIfValid();
        SubscriptionAction subscriptionAction = SubscriptionAction.NO_SUBSCRIPTION;
        if (subscriptionAction.subscriptionName == null) {
            z = false;
        }
        if (z) {
            osResults = SubscriptionAwareOsResults.createFromQuery(realmInstance.sharedRealm, where, descriptorOrdering, subscriptionAction);
        } else {
            osResults = OsResults.createFromQuery(realmInstance.sharedRealm, where, descriptorOrdering);
        }
        RealmResults realmResults = new RealmResults(realmInstance, osResults, ExposureEntity.class);
        realmResults.realm.checkIfValid();
        OsResults osResults2 = realmResults.osResults;
        if (!osResults2.loaded) {
            OsResults.nativeEvaluateQueryIfNeeded(osResults2.nativePtr, false);
            osResults2.notifyChangeListeners(0);
        }
        List<ExposureEntity> copyFromRealm = realmInstance.copyFromRealm(realmResults);
        MoreExecutors.closeFinally(realmInstance, null);
        Intrinsics.checkNotNullExpressionValue(copyFromRealm, "getRealmInstance().use {…ava).findAll())\n        }");
        ArrayList arrayList = new ArrayList();
        for (ExposureEntity exposureEntity : copyFromRealm) {
            arrayList.add(new RNExposureInformation(exposureEntity.realmGet$dateMillisSinceEpoch()));
        }
        promise.resolve(new Gson().toJson(arrayList));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ExposureHistoryModule";
    }

    public /* synthetic */ void lambda$detectExposures$0$ExposureHistoryModule(Promise promise, Boolean bool) {
        if (bool.booleanValue()) {
            WorkManager.getInstance(getReactApplicationContext()).enqueue(new OneTimeWorkRequest.Builder(ProvideDiagnosisKeysWorker.class).build());
            promise.resolve("Detecting exposures now.");
            return;
        }
        promise.reject(new Exception("Exposure notifications must be enabled to detect exposures."));
    }
}
