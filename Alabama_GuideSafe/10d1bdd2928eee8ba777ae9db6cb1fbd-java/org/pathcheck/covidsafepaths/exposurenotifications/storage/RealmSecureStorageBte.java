package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.bottlerocketstudios.vault.StandardSharedPreferenceVault;
import com.bottlerocketstudios.vault.StronglyTypedBundle;
import com.bottlerocketstudios.vault.keys.storage.AndroidKeystoreTestState;
import com.bottlerocketstudios.vault.keys.storage.CompatSharedPrefKeyStorageFactory;
import com.bottlerocketstudios.vault.keys.storage.KeyStorage;
import com.bottlerocketstudios.vault.keys.storage.SharedPrefKeyStorage;
import com.bottlerocketstudios.vault.keys.storage.hardware.BadHardware;
import com.bottlerocketstudios.vault.keys.storage.hardware.LegacyAndroidKeystoreTester;
import com.bottlerocketstudios.vault.keys.storage.hardware.OaepAndroidKeystoreTester;
import com.bottlerocketstudios.vault.salt.PrngSaltGenerator;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.common.util.concurrent.MoreExecutors;
import com.pedrouid.crypto.RNSCAes;
import io.realm.BaseRealm;
import io.realm.Realm;
import io.realm.RealmCache;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.annotations.RealmModule;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import javax.crypto.SecretKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.pathcheck.covidsafepaths.MainApplication;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte {
    public static final RealmSecureStorageBte INSTANCE = new RealmSecureStorageBte();
    public static final RealmConfiguration realmConfig;

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: android.content.Context */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.bottlerocketstudios.vault.StandardSharedPreferenceVault */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c7, code lost:
        if (((com.bottlerocketstudios.vault.keys.storage.SharedPrefKeyStorage) r4).saveKey(r10, r9) != false) goto L_0x00e2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01f6  */
    /* JADX WARNING: Unknown variable types count: 1 */
    static {
        int i;
        String str;
        String str2;
        Class cls;
        KeyStorage keyStorage;
        ?? r1;
        int i2;
        StandardSharedPreferenceVault standardSharedPreferenceVault;
        boolean z;
        String string;
        byte[] bArr;
        int i3;
        boolean z2;
        boolean z3;
        Context context = MainApplication.context;
        if (!TextUtils.equals("safepathsbte_enc_prefs", "safepathsbte_enc_key")) {
            int i4 = Build.VERSION.SDK_INT;
            PrngSaltGenerator prngSaltGenerator = new PrngSaltGenerator();
            int i5 = context.getSharedPreferences("safepathsbte_enc_key", 0).getInt("compatFactoryWrapperType.safepathsbte", 0);
            if (i5 == 0) {
                int i6 = context.getSharedPreferences("safepathsbte_enc_key", 0).getInt("compatFactorySdkInt.safepathsbte", 0);
                if (i6 == 0) {
                    i = 0;
                } else {
                    if (i6 <= 0 || i6 >= 18) {
                        if (AndroidKeystoreTestState.PASS.equals(new LegacyAndroidKeystoreTester(context, "safepathsbte", i6).readAndroidKeystoreTestState(context.getSharedPreferences("safepathsbte_enc_key", 0)))) {
                            i = 2;
                        }
                    }
                    i = 1;
                }
            } else {
                i = i5;
            }
            int i7 = (BadHardware.BAD_HARDWARE_MODELS.contains(Build.MODEL) || !CompatSharedPrefKeyStorageFactory.canUseAndroidKeystore(new OaepAndroidKeystoreTester(context, "safepathsbte", i4), context.getSharedPreferences("safepathsbte_enc_key", 0))) ? 1 : 3;
            if (i != 0 && i < i7) {
                i3 = i7;
                str2 = "compatFactorySdkInt.safepathsbte";
                str = "compatFactoryWrapperType.safepathsbte";
                cls = SafePathsBteRealmModule.class;
                try {
                    SharedPrefKeyStorage sharedPrefKeyStorage = (SharedPrefKeyStorage) CompatSharedPrefKeyStorageFactory.createKeyStorageForWrapperType(context, i, "safepathsbte_enc_key", "safepathsbte", 2, RNSCAes.KEY_ALGORITHM, "", prngSaltGenerator);
                    SecretKey loadKey = sharedPrefKeyStorage.loadKey(context);
                    z3 = false;
                    if (loadKey != null) {
                        sharedPrefKeyStorage.clearKey(context);
                        keyStorage = CompatSharedPrefKeyStorageFactory.createKeyStorageForWrapperType(context, i3, "safepathsbte_enc_key", "safepathsbte", 2, RNSCAes.KEY_ALGORITHM, "", prngSaltGenerator);
                        z3 = false;
                        z2 = false;
                    }
                } catch (GeneralSecurityException e) {
                    Log.e("CompatSharedPrefKeyStorageFactory", "Upgrade resulted in an exception", e);
                    z3 = false;
                }
            } else {
                cls = SafePathsBteRealmModule.class;
                i3 = i7;
                str2 = "compatFactorySdkInt.safepathsbte";
                str = "compatFactoryWrapperType.safepathsbte";
                z3 = false;
                if (i != 0) {
                    i2 = i;
                    keyStorage = null;
                    r1 = false;
                    if (keyStorage == null) {
                        keyStorage = CompatSharedPrefKeyStorageFactory.createKeyStorageForWrapperType(context, i2, "safepathsbte_enc_key", "safepathsbte", 2, RNSCAes.KEY_ALGORITHM, "", prngSaltGenerator);
                    }
                    int i8 = r1 == true ? 1 : 0;
                    int i9 = r1 == true ? 1 : 0;
                    int i10 = r1 == true ? 1 : 0;
                    int i11 = r1 == true ? 1 : 0;
                    int i12 = r1 == true ? 1 : 0;
                    SharedPreferences.Editor edit = context.getSharedPreferences("safepathsbte_enc_key", i8).edit();
                    edit.putInt(str, i2);
                    edit.apply();
                    SharedPreferences.Editor edit2 = context.getSharedPreferences("safepathsbte_enc_key", r1).edit();
                    edit2.putInt(str2, i4);
                    edit2.apply();
                    standardSharedPreferenceVault = new StandardSharedPreferenceVault(context, keyStorage, "safepathsbte_enc_prefs", "AES/CBC/PKCS5Padding", false);
                    if (((SharedPrefKeyStorage) standardSharedPreferenceVault.mKeyStorage).loadKey(standardSharedPreferenceVault.mContext) == null) {
                        z = true;
                    } else {
                        boolean z4 = r1 == true ? 1 : 0;
                        boolean z5 = r1 == true ? 1 : 0;
                        boolean z6 = r1 == true ? 1 : 0;
                        boolean z7 = r1 == true ? 1 : 0;
                        boolean z8 = r1 == true ? 1 : 0;
                        z = z4;
                    }
                    if (!z) {
                        SecretKey createKey = AppCompatDelegateImpl.ConfigurationImplApi17.createKey();
                        standardSharedPreferenceVault.getSharedPreferences().edit().clear().apply();
                        ((SharedPrefKeyStorage) standardSharedPreferenceVault.mKeyStorage).clearKey(standardSharedPreferenceVault.mContext);
                        ((SharedPrefKeyStorage) standardSharedPreferenceVault.mKeyStorage).saveKey(standardSharedPreferenceVault.mContext, createKey);
                    }
                    Intrinsics.checkNotNullExpressionValue(standardSharedPreferenceVault, "SharedPreferenceVaultFac…ARED_SECRET\n            )");
                    string = standardSharedPreferenceVault.getString("KEY_REALM_ENCRYPTION_KEY", null);
                    if (string == null) {
                        bArr = Base64.decode(string, (int) r1);
                        Intrinsics.checkNotNullExpressionValue(bArr, "Base64.decode(existingKeyString, Base64.DEFAULT)");
                    } else {
                        byte[] bArr2 = new byte[64];
                        new SecureRandom().nextBytes(bArr2);
                        String encodeToString = Base64.encodeToString(bArr2, r1);
                        StronglyTypedBundle stronglyTypedBundle = new StronglyTypedBundle();
                        HashSet hashSet = new HashSet();
                        stronglyTypedBundle.mValueMap.put("KEY_REALM_ENCRYPTION_KEY", encodeToString);
                        stronglyTypedBundle.mClassMap.put("KEY_REALM_ENCRYPTION_KEY", encodeToString.getClass());
                        standardSharedPreferenceVault.writeValues(r1, r1, hashSet, stronglyTypedBundle);
                        bArr = bArr2;
                    }
                    RealmConfiguration.Builder builder = new RealmConfiguration.Builder(BaseRealm.applicationContext);
                    if (bArr.length != 64) {
                        builder.key = Arrays.copyOf(bArr, bArr.length);
                        SafePathsBteRealmModule safePathsBteRealmModule = new SafePathsBteRealmModule();
                        if (cls.isAnnotationPresent(RealmModule.class)) {
                            builder.modules.add(safePathsBteRealmModule);
                            builder.schemaVersion = 7;
                            builder.migration = new Migration();
                            builder.fileName = "safepathsbte.realm";
                            RealmConfiguration build = builder.build();
                            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
                            realmConfig = build;
                            return;
                        }
                        throw new IllegalArgumentException(cls.getCanonicalName() + " is not a RealmModule. Add @RealmModule to the class definition.");
                    }
                    Locale locale = Locale.US;
                    Object[] objArr = new Object[2];
                    char c = r1 == true ? 1 : 0;
                    char c2 = r1 == true ? 1 : 0;
                    char c3 = r1 == true ? 1 : 0;
                    char c4 = r1 == true ? 1 : 0;
                    char c5 = r1 == true ? 1 : 0;
                    objArr[c] = 64;
                    objArr[1] = Integer.valueOf(bArr.length);
                    throw new IllegalArgumentException(String.format(locale, "The provided key must be %s bytes. Yours was: %s", objArr));
                }
            }
            keyStorage = null;
            z2 = z3;
            i2 = i3;
            r1 = z2;
            if (keyStorage == null) {
            }
            int i82 = r1 == true ? 1 : 0;
            int i92 = r1 == true ? 1 : 0;
            int i102 = r1 == true ? 1 : 0;
            int i112 = r1 == true ? 1 : 0;
            int i122 = r1 == true ? 1 : 0;
            SharedPreferences.Editor edit3 = context.getSharedPreferences("safepathsbte_enc_key", i82).edit();
            edit3.putInt(str, i2);
            edit3.apply();
            SharedPreferences.Editor edit22 = context.getSharedPreferences("safepathsbte_enc_key", r1).edit();
            edit22.putInt(str2, i4);
            edit22.apply();
            standardSharedPreferenceVault = new StandardSharedPreferenceVault(context, keyStorage, "safepathsbte_enc_prefs", "AES/CBC/PKCS5Padding", false);
            if (((SharedPrefKeyStorage) standardSharedPreferenceVault.mKeyStorage).loadKey(standardSharedPreferenceVault.mContext) == null) {
            }
            if (!z) {
            }
            Intrinsics.checkNotNullExpressionValue(standardSharedPreferenceVault, "SharedPreferenceVaultFac…ARED_SECRET\n            )");
            string = standardSharedPreferenceVault.getString("KEY_REALM_ENCRYPTION_KEY", null);
            if (string == null) {
            }
            RealmConfiguration.Builder builder2 = new RealmConfiguration.Builder(BaseRealm.applicationContext);
            if (bArr.length != 64) {
            }
        } else {
            throw new IllegalArgumentException("Pref file and key file cannot be the same file.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        com.google.common.util.concurrent.MoreExecutors.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        throw r2;
     */
    public final String getLastProcessedKeyZipFileName() {
        Realm realmInstance = getRealmInstance();
        realmInstance.checkIfValid();
        RealmQuery realmQuery = new RealmQuery(realmInstance, KeyValues.class);
        realmQuery.equalTo("id", KeyValues.LAST_PROCESSED_FILE_NAME_KEY);
        KeyValues keyValues = (KeyValues) realmQuery.findFirst();
        String realmGet$value = keyValues != null ? keyValues.realmGet$value() : null;
        MoreExecutors.closeFinally(realmInstance, null);
        return realmGet$value;
    }

    public final Realm getRealmInstance() {
        RealmConfiguration realmConfiguration = realmConfig;
        if (realmConfiguration != null) {
            Realm realm = (Realm) RealmCache.createRealmOrGetFromCache(realmConfiguration, Realm.class);
            Intrinsics.checkNotNullExpressionValue(realm, "Realm.getInstance(realmConfig)");
            return realm;
        }
        throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        com.google.common.util.concurrent.MoreExecutors.closeFinally(r1, r4);
     */
    public final boolean refreshWithDailySummaries(List<? extends DailySummary> list) {
        Intrinsics.checkNotNullParameter(list, "dailySummaries");
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        Realm realmInstance = getRealmInstance();
        realmInstance.executeTransaction(new RealmSecureStorageBte$refreshWithDailySummaries$$inlined$use$lambda$1(list, ref$BooleanRef));
        MoreExecutors.closeFinally(realmInstance, null);
        return ref$BooleanRef.element;
    }
}
