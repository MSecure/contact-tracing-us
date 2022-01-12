package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.google.common.util.concurrent.MoreExecutors;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmResults;
import io.realm.internal.OsResults;
import io.realm.internal.SubscriptionAwareOsResults;
import io.realm.internal.TableQuery;
import io.realm.internal.core.DescriptorOrdering;
import io.realm.internal.sync.SubscriptionAction;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte$deleteLogEntry$$inlined$use$lambda$1;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte$deleteSymptomLogs$1$1;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte$deleteSymptomLogsOlderThan$$inlined$use$lambda$1;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte$upsertLogEntry$$inlined$use$lambda$1;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry;

@ReactModule(name = SymptomLogEntryModule.MODULE_NAME)
public class SymptomLogEntryModule extends ReactContextBaseJavaModule {
    public static final String MODULE_NAME = "SymptomLogEntryModule";

    public SymptomLogEntryModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
        com.google.common.util.concurrent.MoreExecutors.closeFinally(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        throw r0;
     */
    @ReactMethod
    public void addSymptomLogEntry(ReadableMap readableMap, Promise promise) {
        String str;
        if (SymptomLogEntry.Companion != null) {
            Intrinsics.checkNotNullParameter(readableMap, "map");
            ReadableArray array = readableMap.getArray("symptoms");
            RealmList realmList = new RealmList();
            if (array != null) {
                Iterator<Object> it = array.toArrayList().iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    realmList.add(next != null ? next.toString() : null);
                }
            }
            if (readableMap.hasKey("id")) {
                str = readableMap.getString("id");
                if (str == null) {
                    str = UUID.randomUUID().toString();
                }
                Intrinsics.checkNotNullExpressionValue(str, "map.getString(\"id\") ?: U…D.randomUUID().toString()");
            } else {
                str = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str, "UUID.randomUUID().toString()");
            }
            SymptomLogEntry symptomLogEntry = new SymptomLogEntry(str, (long) readableMap.getDouble(DatePickerDialogModule.ARG_DATE), realmList);
            RealmSecureStorageBte realmSecureStorageBte = RealmSecureStorageBte.INSTANCE;
            Intrinsics.checkNotNullParameter(symptomLogEntry, "logEntry");
            Realm realmInstance = realmSecureStorageBte.getRealmInstance();
            realmInstance.executeTransaction(new RealmSecureStorageBte$upsertLogEntry$$inlined$use$lambda$1(symptomLogEntry));
            MoreExecutors.closeFinally(realmInstance, null);
            promise.resolve(null);
            return;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        com.google.common.util.concurrent.MoreExecutors.closeFinally(r0, r3);
     */
    @ReactMethod
    public void deleteSymptomLogEntry(String str, Promise promise) {
        RealmSecureStorageBte realmSecureStorageBte = RealmSecureStorageBte.INSTANCE;
        Intrinsics.checkNotNullParameter(str, "id");
        Realm realmInstance = realmSecureStorageBte.getRealmInstance();
        realmInstance.executeTransaction(new RealmSecureStorageBte$deleteLogEntry$$inlined$use$lambda$1(str));
        MoreExecutors.closeFinally(realmInstance, null);
        promise.resolve(null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        com.google.common.util.concurrent.MoreExecutors.closeFinally(r0, r3);
     */
    @ReactMethod
    public void deleteSymptomLogs(Promise promise) {
        Realm realmInstance = RealmSecureStorageBte.INSTANCE.getRealmInstance();
        realmInstance.executeTransaction(RealmSecureStorageBte$deleteSymptomLogs$1$1.INSTANCE);
        MoreExecutors.closeFinally(realmInstance, null);
        promise.resolve(null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        com.google.common.util.concurrent.MoreExecutors.closeFinally(r4, r5);
     */
    @ReactMethod
    public void deleteSymptomLogsOlderThan(Integer num, Promise promise) {
        RealmSecureStorageBte realmSecureStorageBte = RealmSecureStorageBte.INSTANCE;
        long intValue = (long) num.intValue();
        Realm realmInstance = realmSecureStorageBte.getRealmInstance();
        realmInstance.executeTransaction(new RealmSecureStorageBte$deleteSymptomLogsOlderThan$$inlined$use$lambda$1(intValue));
        MoreExecutors.closeFinally(realmInstance, null);
        promise.resolve(null);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c7, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c8, code lost:
        com.google.common.util.concurrent.MoreExecutors.closeFinally(r0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        throw r1;
     */
    @ReactMethod
    public void getSymptomLogEntries(Promise promise) {
        OsResults osResults;
        Realm realmInstance = RealmSecureStorageBte.INSTANCE.getRealmInstance();
        realmInstance.checkIfValid();
        DescriptorOrdering descriptorOrdering = new DescriptorOrdering();
        boolean z = true;
        TableQuery where = !RealmModel.class.isAssignableFrom(SymptomLogEntry.class) ? null : realmInstance.schema.getSchemaForClass(SymptomLogEntry.class).table.where();
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
        RealmResults realmResults = new RealmResults(realmInstance, osResults, SymptomLogEntry.class);
        realmResults.realm.checkIfValid();
        OsResults osResults2 = realmResults.osResults;
        if (!osResults2.loaded) {
            OsResults.nativeEvaluateQueryIfNeeded(osResults2.nativePtr, false);
            osResults2.notifyChangeListeners(0);
        }
        List<SymptomLogEntry> copyFromRealm = realmInstance.copyFromRealm(realmResults);
        MoreExecutors.closeFinally(realmInstance, null);
        Intrinsics.checkNotNullExpressionValue(copyFromRealm, "getRealmInstance().use {…ava).findAll())\n        }");
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (SymptomLogEntry symptomLogEntry : copyFromRealm) {
            if (symptomLogEntry != null) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("id", symptomLogEntry.realmGet$id());
                writableNativeMap.putDouble(DatePickerDialogModule.ARG_DATE, (double) symptomLogEntry.realmGet$date());
                WritableNativeArray writableNativeArray2 = new WritableNativeArray();
                Iterator it = symptomLogEntry.realmGet$symptoms().iterator();
                while (it.hasNext()) {
                    writableNativeArray2.pushString((String) it.next());
                }
                writableNativeMap.putArray("symptoms", writableNativeArray2);
                writableNativeArray.pushMap(writableNativeMap);
            } else {
                throw null;
            }
        }
        promise.resolve(writableNativeArray);
    }

    @ReactMethod
    public void updateSymptomLogEntry(ReadableMap readableMap, Promise promise) {
        addSymptomLogEntry(readableMap, promise);
    }
}
