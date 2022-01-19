package io.realm;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.Realm;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmFileException;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.RealmCore;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.modules.CompositeMediator;
import io.realm.internal.modules.FilterableMediator;
import io.realm.rx.RealmObservableFactory;
import io.realm.rx.RxObservableFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public class RealmConfiguration {
    public static final Object DEFAULT_MODULE;
    public static final RealmProxyMediator DEFAULT_MODULE_MEDIATOR;
    public static Boolean rxJavaAvailable;
    public final String assetFilePath = null;
    public final String canonicalPath;
    public final CompactOnLaunchCallback compactOnLaunch;
    public final boolean deleteRealmIfMigrationNeeded;
    public final OsRealmConfig.Durability durability;
    public final Realm.Transaction initialDataTransaction;
    public final boolean isRecoveryConfiguration;
    public final byte[] key;
    public final long maxNumberOfActiveVersions;
    public final RealmMigration migration;
    public final boolean readOnly;
    public final File realmDirectory;
    public final String realmFileName;
    public final RxObservableFactory rxObservableFactory;
    public final RealmProxyMediator schemaMediator;
    public final long schemaVersion;

    public static class Builder {
        public CompactOnLaunchCallback compactOnLaunch;
        public HashSet<Class<? extends RealmModel>> debugSchema = new HashSet<>();
        public boolean deleteRealmIfMigrationNeeded;
        public File directory;
        public OsRealmConfig.Durability durability;
        public String fileName;
        public byte[] key;
        public long maxNumberOfActiveVersions = RecyclerView.FOREVER_NS;
        public RealmMigration migration;
        public HashSet<Object> modules = new HashSet<>();
        public boolean readOnly;
        public RxObservableFactory rxFactory;
        public long schemaVersion;

        public Builder(Context context) {
            if (context != null) {
                RealmCore.loadLibrary(context);
                this.directory = context.getFilesDir();
                this.fileName = "default.realm";
                this.key = null;
                this.schemaVersion = 0;
                this.migration = null;
                this.deleteRealmIfMigrationNeeded = false;
                this.durability = OsRealmConfig.Durability.FULL;
                this.readOnly = false;
                this.compactOnLaunch = null;
                Object obj = RealmConfiguration.DEFAULT_MODULE;
                if (obj != null) {
                    this.modules.add(obj);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Call `Realm.init(Context)` before creating a RealmConfiguration");
        }

        public RealmConfiguration build() {
            RealmProxyMediator compositeMediator;
            if (this.readOnly) {
                throw new IllegalStateException("Only Realms provided using 'assetFile(path)' can be marked read-only. No such Realm was provided.");
            }
            if (this.rxFactory == null && RealmConfiguration.isRxJavaAvailable()) {
                this.rxFactory = new RealmObservableFactory(true);
            }
            File file = this.directory;
            String str = this.fileName;
            File file2 = new File(this.directory, this.fileName);
            try {
                String canonicalPath = file2.getCanonicalPath();
                byte[] bArr = this.key;
                long j = this.schemaVersion;
                RealmMigration realmMigration = this.migration;
                boolean z = this.deleteRealmIfMigrationNeeded;
                OsRealmConfig.Durability durability2 = this.durability;
                HashSet<Object> hashSet = this.modules;
                HashSet<Class<? extends RealmModel>> hashSet2 = this.debugSchema;
                if (hashSet2.size() > 0) {
                    compositeMediator = new FilterableMediator(RealmConfiguration.DEFAULT_MODULE_MEDIATOR, hashSet2);
                } else if (hashSet.size() == 1) {
                    compositeMediator = RealmConfiguration.getModuleMediator(hashSet.iterator().next().getClass().getCanonicalName());
                } else {
                    RealmProxyMediator[] realmProxyMediatorArr = new RealmProxyMediator[hashSet.size()];
                    int i = 0;
                    for (Object obj : hashSet) {
                        realmProxyMediatorArr[i] = RealmConfiguration.getModuleMediator(obj.getClass().getCanonicalName());
                        i++;
                    }
                    compositeMediator = new CompositeMediator(realmProxyMediatorArr);
                }
                return new RealmConfiguration(file, str, canonicalPath, null, bArr, j, realmMigration, z, durability2, compositeMediator, this.rxFactory, null, this.readOnly, this.compactOnLaunch, false, this.maxNumberOfActiveVersions);
            } catch (IOException e) {
                RealmFileException.Kind kind = RealmFileException.Kind.ACCESS_ERROR;
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Could not resolve the canonical path to the Realm file: ");
                outline15.append(file2.getAbsolutePath());
                throw new RealmFileException(kind, outline15.toString(), e);
            }
        }
    }

    static {
        Object defaultModule = Realm.getDefaultModule();
        DEFAULT_MODULE = defaultModule;
        if (defaultModule != null) {
            RealmProxyMediator moduleMediator = getModuleMediator(defaultModule.getClass().getCanonicalName());
            if (moduleMediator.transformerApplied()) {
                DEFAULT_MODULE_MEDIATOR = moduleMediator;
                return;
            }
            throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://realm.io/news/android-installation-change/");
        }
        DEFAULT_MODULE_MEDIATOR = null;
    }

    public RealmConfiguration(File file, String str, String str2, String str3, byte[] bArr, long j, RealmMigration realmMigration, boolean z, OsRealmConfig.Durability durability2, RealmProxyMediator realmProxyMediator, RxObservableFactory rxObservableFactory2, Realm.Transaction transaction, boolean z2, CompactOnLaunchCallback compactOnLaunchCallback, boolean z3, long j2) {
        this.realmDirectory = file;
        this.realmFileName = str;
        this.canonicalPath = str2;
        this.key = bArr;
        this.schemaVersion = j;
        this.migration = realmMigration;
        this.deleteRealmIfMigrationNeeded = z;
        this.durability = durability2;
        this.schemaMediator = realmProxyMediator;
        this.rxObservableFactory = rxObservableFactory2;
        this.initialDataTransaction = null;
        this.readOnly = z2;
        this.compactOnLaunch = compactOnLaunchCallback;
        this.isRecoveryConfiguration = z3;
        this.maxNumberOfActiveVersions = j2;
    }

    public static RealmProxyMediator getModuleMediator(String str) {
        String[] split = str.split("\\.");
        String str2 = split[split.length - 1];
        String format = String.format(Locale.US, "io.realm.%s%s", str2, "Mediator");
        try {
            Constructor<?> constructor = Class.forName(format).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return (RealmProxyMediator) constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new RealmException(GeneratedOutlineSupport.outline8("Could not find ", format), e);
        } catch (InvocationTargetException e2) {
            throw new RealmException(GeneratedOutlineSupport.outline8("Could not create an instance of ", format), e2);
        } catch (InstantiationException e3) {
            throw new RealmException(GeneratedOutlineSupport.outline8("Could not create an instance of ", format), e3);
        } catch (IllegalAccessException e4) {
            throw new RealmException(GeneratedOutlineSupport.outline8("Could not create an instance of ", format), e4);
        }
    }

    public static synchronized boolean isRxJavaAvailable() {
        boolean booleanValue;
        synchronized (RealmConfiguration.class) {
            if (rxJavaAvailable == null) {
                try {
                    Class.forName("io.reactivex.Flowable");
                    rxJavaAvailable = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    rxJavaAvailable = Boolean.FALSE;
                }
            }
            booleanValue = rxJavaAvailable.booleanValue();
        }
        return booleanValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RealmConfiguration.class != obj.getClass()) {
            return false;
        }
        RealmConfiguration realmConfiguration = (RealmConfiguration) obj;
        if (this.schemaVersion != realmConfiguration.schemaVersion || this.deleteRealmIfMigrationNeeded != realmConfiguration.deleteRealmIfMigrationNeeded || this.readOnly != realmConfiguration.readOnly || this.isRecoveryConfiguration != realmConfiguration.isRecoveryConfiguration) {
            return false;
        }
        File file = this.realmDirectory;
        if (file == null ? realmConfiguration.realmDirectory != null : !file.equals(realmConfiguration.realmDirectory)) {
            return false;
        }
        String str = this.realmFileName;
        if (str == null ? realmConfiguration.realmFileName != null : !str.equals(realmConfiguration.realmFileName)) {
            return false;
        }
        if (!this.canonicalPath.equals(realmConfiguration.canonicalPath)) {
            return false;
        }
        String str2 = this.assetFilePath;
        if (str2 == null ? realmConfiguration.assetFilePath != null : !str2.equals(realmConfiguration.assetFilePath)) {
            return false;
        }
        if (!Arrays.equals(this.key, realmConfiguration.key)) {
            return false;
        }
        RealmMigration realmMigration = this.migration;
        if (realmMigration == null ? realmConfiguration.migration != null : !realmMigration.equals(realmConfiguration.migration)) {
            return false;
        }
        if (this.durability != realmConfiguration.durability || !this.schemaMediator.equals(realmConfiguration.schemaMediator)) {
            return false;
        }
        RxObservableFactory rxObservableFactory2 = this.rxObservableFactory;
        if (rxObservableFactory2 == null ? realmConfiguration.rxObservableFactory != null : !rxObservableFactory2.equals(realmConfiguration.rxObservableFactory)) {
            return false;
        }
        Realm.Transaction transaction = this.initialDataTransaction;
        if (transaction == null ? realmConfiguration.initialDataTransaction != null : !transaction.equals(realmConfiguration.initialDataTransaction)) {
            return false;
        }
        CompactOnLaunchCallback compactOnLaunchCallback = this.compactOnLaunch;
        if (compactOnLaunchCallback == null ? realmConfiguration.compactOnLaunch == null : compactOnLaunchCallback.equals(realmConfiguration.compactOnLaunch)) {
            return this.maxNumberOfActiveVersions == realmConfiguration.maxNumberOfActiveVersions;
        }
        return false;
    }

    public byte[] getEncryptionKey() {
        byte[] bArr = this.key;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public int hashCode() {
        File file = this.realmDirectory;
        int i = 0;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        String str = this.realmFileName;
        int hashCode2 = (this.canonicalPath.hashCode() + ((hashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31;
        String str2 = this.assetFilePath;
        int hashCode3 = str2 != null ? str2.hashCode() : 0;
        int hashCode4 = Arrays.hashCode(this.key);
        long j = this.schemaVersion;
        int i2 = (((hashCode4 + ((hashCode2 + hashCode3) * 31)) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        RealmMigration realmMigration = this.migration;
        int hashCode5 = (this.schemaMediator.hashCode() + ((this.durability.hashCode() + ((((i2 + (realmMigration != null ? realmMigration.hashCode() : 0)) * 31) + (this.deleteRealmIfMigrationNeeded ? 1 : 0)) * 31)) * 31)) * 31;
        RxObservableFactory rxObservableFactory2 = this.rxObservableFactory;
        int hashCode6 = (hashCode5 + (rxObservableFactory2 != null ? rxObservableFactory2.hashCode() : 0)) * 31;
        Realm.Transaction transaction = this.initialDataTransaction;
        int hashCode7 = (((hashCode6 + (transaction != null ? transaction.hashCode() : 0)) * 31) + (this.readOnly ? 1 : 0)) * 31;
        CompactOnLaunchCallback compactOnLaunchCallback = this.compactOnLaunch;
        if (compactOnLaunchCallback != null) {
            i = compactOnLaunchCallback.hashCode();
        }
        long j2 = this.maxNumberOfActiveVersions;
        return ((((hashCode7 + i) * 31) + (this.isRecoveryConfiguration ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("realmDirectory: ");
        File file = this.realmDirectory;
        outline15.append(file != null ? file.toString() : "");
        outline15.append("\n");
        outline15.append("realmFileName : ");
        outline15.append(this.realmFileName);
        outline15.append("\n");
        outline15.append("canonicalPath: ");
        outline15.append(this.canonicalPath);
        outline15.append("\n");
        outline15.append("key: ");
        outline15.append("[length: ");
        outline15.append(this.key == null ? 0 : 64);
        outline15.append("]");
        outline15.append("\n");
        outline15.append("schemaVersion: ");
        outline15.append(Long.toString(this.schemaVersion));
        outline15.append("\n");
        outline15.append("migration: ");
        outline15.append(this.migration);
        outline15.append("\n");
        outline15.append("deleteRealmIfMigrationNeeded: ");
        outline15.append(this.deleteRealmIfMigrationNeeded);
        outline15.append("\n");
        outline15.append("durability: ");
        outline15.append(this.durability);
        outline15.append("\n");
        outline15.append("schemaMediator: ");
        outline15.append(this.schemaMediator);
        outline15.append("\n");
        outline15.append("readOnly: ");
        outline15.append(this.readOnly);
        outline15.append("\n");
        outline15.append("compactOnLaunch: ");
        outline15.append(this.compactOnLaunch);
        outline15.append("\n");
        outline15.append("maxNumberOfActiveVersions: ");
        outline15.append(this.maxNumberOfActiveVersions);
        return outline15.toString();
    }
}
