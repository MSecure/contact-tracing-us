package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures$CallbackListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import io.realm.Realm;
import io.realm.RealmQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;
import org.pathcheck.covidsafepaths.exposurenotifications.common.AppExecutors;
import org.pathcheck.covidsafepaths.exposurenotifications.dto.RNExposureKey;
import org.pathcheck.covidsafepaths.exposurenotifications.network.AutoValue_DiagnosisKey;
import org.pathcheck.covidsafepaths.exposurenotifications.network.DiagnosisKey;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte$upsertRevisionToken$$inlined$use$lambda$1;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues;

@ReactModule(name = ExposureKeyModule.MODULE_NAME)
public class ExposureKeyModule extends ReactContextBaseJavaModule {
    public static final BaseEncoding BASE64 = BaseEncoding.BASE64;
    public static final String MODULE_NAME = "ExposureKeyModule";

    public ExposureKeyModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<DiagnosisKey> toDiagnosisKeysWithTransmissionRisk(List<TemporaryExposureKey> list) {
        int i;
        int i2;
        ReactYogaConfigProvider.checkNonnegative(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i3 = 0;
        boolean z = false;
        for (TemporaryExposureKey temporaryExposureKey : list) {
            DiagnosisKey.Builder newBuilder = DiagnosisKey.newBuilder();
            ((AutoValue_DiagnosisKey.Builder) newBuilder).key = new DiagnosisKey.ByteArrayValue(temporaryExposureKey.getKeyData());
            AutoValue_DiagnosisKey.Builder builder = (AutoValue_DiagnosisKey.Builder) newBuilder;
            builder.intervalNumber = Integer.valueOf(temporaryExposureKey.zzb);
            builder.setRollingPeriod(temporaryExposureKey.zzd);
            Integer num = builder.transmissionRisk;
            if (num != null) {
                if (num.intValue() > 0) {
                    Integer num2 = builder.transmissionRisk;
                    if (num2 != null) {
                        i = num2.intValue();
                    } else {
                        throw new IllegalStateException("Property \"transmissionRisk\" has not been set");
                    }
                } else {
                    i = 1;
                }
                builder.transmissionRisk = Integer.valueOf(i);
                Integer num3 = builder.rollingPeriod;
                if (num3 != null) {
                    if (num3.intValue() > 0) {
                        Integer num4 = builder.rollingPeriod;
                        if (num4 != null) {
                            i2 = num4.intValue();
                        } else {
                            throw new IllegalStateException("Property \"rollingPeriod\" has not been set");
                        }
                    } else {
                        i2 = 144;
                    }
                    builder.setRollingPeriod(i2);
                    String str = builder.key == null ? " key" : "";
                    if (builder.intervalNumber == null) {
                        str = GeneratedOutlineSupport.outline10(str, " intervalNumber");
                    }
                    if (builder.rollingPeriod == null) {
                        str = GeneratedOutlineSupport.outline10(str, " rollingPeriod");
                    }
                    if (builder.transmissionRisk == null) {
                        str = GeneratedOutlineSupport.outline10(str, " transmissionRisk");
                    }
                    if (str.isEmpty()) {
                        AutoValue_DiagnosisKey autoValue_DiagnosisKey = new AutoValue_DiagnosisKey(builder.key, builder.intervalNumber.intValue(), builder.rollingPeriod.intValue(), builder.transmissionRisk.intValue(), null);
                        int i4 = i3 + 1;
                        if (objArr.length < i4) {
                            int length = objArr.length;
                            if (i4 >= 0) {
                                int i5 = length + (length >> 1) + 1;
                                if (i5 < i4) {
                                    i5 = Integer.highestOneBit(i4 - 1) << 1;
                                }
                                if (i5 < 0) {
                                    i5 = Integer.MAX_VALUE;
                                }
                                objArr = Arrays.copyOf(objArr, i5);
                            } else {
                                throw new AssertionError("cannot store more than MAX_VALUE elements");
                            }
                        } else if (z) {
                            objArr = (Object[]) objArr.clone();
                        } else {
                            objArr[i3] = autoValue_DiagnosisKey;
                            i3++;
                        }
                        z = false;
                        objArr[i3] = autoValue_DiagnosisKey;
                        i3++;
                    } else {
                        throw new IllegalStateException(GeneratedOutlineSupport.outline10("Missing required properties:", str));
                    }
                } else {
                    throw new IllegalStateException("Property \"rollingPeriod\" has not been set");
                }
            } else {
                throw new IllegalStateException("Property \"transmissionRisk\" has not been set");
            }
        }
        return ImmutableList.asImmutableList(objArr, i3);
    }

    @ReactMethod
    public void fetchExposureKeys(final Promise promise) {
        ListenableFuture<List<TemporaryExposureKey>> requestPermissionToGetExposureKeys = ExposureNotificationClientWrapper.get(getReactApplicationContext()).requestPermissionToGetExposureKeys(getReactApplicationContext());
        AnonymousClass1 r1 = new FutureCallback<List<TemporaryExposureKey>>() {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.ExposureKeyModule.AnonymousClass1 */

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                promise.reject(th);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(List<TemporaryExposureKey> list) {
                ArrayList arrayList = new ArrayList();
                for (DiagnosisKey diagnosisKey : ExposureKeyModule.this.toDiagnosisKeysWithTransmissionRisk(list)) {
                    AutoValue_DiagnosisKey autoValue_DiagnosisKey = (AutoValue_DiagnosisKey) diagnosisKey;
                    arrayList.add(new RNExposureKey(ExposureKeyModule.BASE64.encode(diagnosisKey.getKeyBytes()), autoValue_DiagnosisKey.rollingPeriod, autoValue_DiagnosisKey.intervalNumber, autoValue_DiagnosisKey.transmissionRisk));
                }
                promise.resolve(MoreExecutors.convertListToWritableArray(arrayList));
            }
        };
        ListeningExecutorService lightweightExecutor = AppExecutors.getLightweightExecutor();
        ((CallbackToFutureAdapter$SafeFuture) requestPermissionToGetExposureKeys).addListener(new Futures$CallbackListener(requestPermissionToGetExposureKeys, r1), lightweightExecutor);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        com.google.common.util.concurrent.MoreExecutors.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        throw r1;
     */
    @ReactMethod
    public void getRevisionToken(Promise promise) {
        Realm realmInstance = RealmSecureStorageBte.INSTANCE.getRealmInstance();
        realmInstance.checkIfValid();
        RealmQuery realmQuery = new RealmQuery(realmInstance, KeyValues.class);
        realmQuery.equalTo("id", KeyValues.REVISION_TOKEN_KEY);
        KeyValues keyValues = (KeyValues) realmQuery.findFirst();
        String realmGet$value = keyValues != null ? keyValues.realmGet$value() : null;
        MoreExecutors.closeFinally(realmInstance, null);
        promise.resolve(realmGet$value);
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
    public void storeRevisionToken(String str, Promise promise) {
        RealmSecureStorageBte realmSecureStorageBte = RealmSecureStorageBte.INSTANCE;
        Intrinsics.checkNotNullParameter(str, "revisionToken");
        Realm realmInstance = realmSecureStorageBte.getRealmInstance();
        realmInstance.executeTransaction(new RealmSecureStorageBte$upsertRevisionToken$$inlined$use$lambda$1(str));
        MoreExecutors.closeFinally(realmInstance, null);
        promise.resolve(null);
    }
}
