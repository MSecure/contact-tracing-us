package io.realm;

import android.os.SystemClock;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.exceptions.RealmFileException;
import io.realm.internal.ObjectServerFacade;
import io.realm.internal.OsObjectStore;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Util;
import io.realm.internal.util.Pair;
import io.realm.log.RealmLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class RealmCache {
    public static final List<WeakReference<RealmCache>> cachesList = new ArrayList();
    public static final Collection<RealmCache> leakedCaches = new ConcurrentLinkedQueue();
    public RealmConfiguration configuration;
    public final AtomicBoolean isLeaked = new AtomicBoolean(false);
    public final String realmPath;
    public final Map<Pair<RealmCacheType, OsSharedRealm.VersionID>, ReferenceCounter> refAndCountMap = new HashMap();

    public static class GlobalReferenceCounter extends ReferenceCounter {
        public BaseRealm cachedRealm;

        public GlobalReferenceCounter(AnonymousClass1 r1) {
            super(null);
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public void clearThreadLocalCache() {
            String str = this.cachedRealm.configuration.canonicalPath;
            this.localCount.set(null);
            this.cachedRealm = null;
            if (this.globalCount.decrementAndGet() < 0) {
                throw new IllegalStateException(GeneratedOutlineSupport.outline11("Global reference counter of Realm", str, " not be negative."));
            }
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public BaseRealm getRealmInstance() {
            return this.cachedRealm;
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public int getThreadLocalCount() {
            return this.globalCount.get();
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public boolean hasInstanceAvailableForThread() {
            return this.cachedRealm != null;
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public void onRealmCreated(BaseRealm baseRealm) {
            this.cachedRealm = baseRealm;
            this.localCount.set(0);
            this.globalCount.incrementAndGet();
        }
    }

    public enum RealmCacheType {
        TYPED_REALM,
        DYNAMIC_REALM
    }

    public static class ThreadConfinedReferenceCounter extends ReferenceCounter {
        public final ThreadLocal<BaseRealm> localRealm = new ThreadLocal<>();

        public ThreadConfinedReferenceCounter(AnonymousClass1 r1) {
            super(null);
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public void clearThreadLocalCache() {
            String str = this.localRealm.get().configuration.canonicalPath;
            this.localCount.set(null);
            this.localRealm.set(null);
            if (this.globalCount.decrementAndGet() < 0) {
                throw new IllegalStateException(GeneratedOutlineSupport.outline11("Global reference counter of Realm", str, " can not be negative."));
            }
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public BaseRealm getRealmInstance() {
            return this.localRealm.get();
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public int getThreadLocalCount() {
            Integer num = this.localCount.get();
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public boolean hasInstanceAvailableForThread() {
            return this.localRealm.get() != null;
        }

        @Override // io.realm.RealmCache.ReferenceCounter
        public void onRealmCreated(BaseRealm baseRealm) {
            this.localRealm.set(baseRealm);
            this.localCount.set(0);
            this.globalCount.incrementAndGet();
        }
    }

    public RealmCache(String str) {
        this.realmPath = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0087 A[SYNTHETIC, Splitter:B:44:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008c A[SYNTHETIC, Splitter:B:48:0x008c] */
    public static void access$800(String str, File file) {
        Throwable th;
        FileOutputStream fileOutputStream;
        IOException e;
        if (!file.exists()) {
            InputStream inputStream = null;
            IOException e2 = null;
            inputStream = null;
            try {
                InputStream open = BaseRealm.applicationContext.getAssets().open(str);
                if (open != null) {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = open.read(bArr);
                                if (read > -1) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e3) {
                                        e2 = e3;
                                    }
                                }
                            }
                            open.close();
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                if (e2 == null) {
                                    e2 = e4;
                                }
                            }
                            if (e2 != null) {
                                throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, e2);
                            }
                        } catch (IOException e5) {
                            e = e5;
                            inputStream = open;
                            try {
                                throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, "Could not resolve the path to the asset file: " + str, e);
                            } catch (Throwable th2) {
                                th = th2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = open;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        fileOutputStream = null;
                        inputStream = open;
                        throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, "Could not resolve the path to the asset file: " + str, e);
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        inputStream = open;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } else {
                    throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, "Invalid input stream to the asset file: " + str);
                }
            } catch (IOException e7) {
                e = e7;
                fileOutputStream = null;
                throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, "Could not resolve the path to the asset file: " + str, e);
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        }
    }

    public static <E extends BaseRealm> E createRealmOrGetFromCache(RealmConfiguration realmConfiguration, Class<E> cls) {
        E e;
        int i = 1;
        RealmCache cache = getCache(realmConfiguration.canonicalPath, true);
        OsSharedRealm.VersionID versionID = OsSharedRealm.VersionID.LIVE;
        synchronized (cache) {
            ReferenceCounter refCounter = cache.getRefCounter(cls, versionID);
            boolean z = cache.getTotalGlobalRefCount() == 0;
            boolean z2 = !new File(realmConfiguration.canonicalPath).exists();
            if (z) {
                File file = Util.isEmptyString(realmConfiguration.assetFilePath) ^ true ? new File(realmConfiguration.realmDirectory, realmConfiguration.realmFileName) : null;
                if (ObjectServerFacade.getFacade(false) != null) {
                    boolean z3 = !Util.isEmptyString(null);
                    if (file != null || z3) {
                        OsObjectStore.nativeCallWithLock(realmConfiguration.canonicalPath, new Runnable(file, realmConfiguration, z3, null) {
                            /* class io.realm.RealmCache.AnonymousClass1 */
                            public final /* synthetic */ boolean val$certFileExists;
                            public final /* synthetic */ RealmConfiguration val$configuration;
                            public final /* synthetic */ File val$realmFileFromAsset;
                            public final /* synthetic */ String val$syncServerCertificateAssetName = null;

                            {
                                this.val$realmFileFromAsset = r1;
                                this.val$configuration = r2;
                                this.val$certFileExists = r3;
                            }

                            public void run() {
                                File file = this.val$realmFileFromAsset;
                                if (file != null) {
                                    RealmCache.access$800(this.val$configuration.assetFilePath, file);
                                }
                                if (!this.val$certFileExists) {
                                    return;
                                }
                                if (this.val$configuration == null) {
                                    throw null;
                                } else if (ObjectServerFacade.getFacade(false) != null) {
                                    RealmCache.access$800(this.val$syncServerCertificateAssetName, new File((String) null));
                                } else {
                                    throw null;
                                }
                            }
                        });
                    }
                    cache.configuration = realmConfiguration;
                } else {
                    throw null;
                }
            } else {
                cache.validateConfiguration(realmConfiguration);
            }
            if (!refCounter.hasInstanceAvailableForThread()) {
                cache.createInstance(cls, refCounter, z2, versionID);
            }
            Integer num = refCounter.localCount.get();
            ThreadLocal<Integer> threadLocal = refCounter.localCount;
            if (num != null) {
                i = 1 + num.intValue();
            }
            threadLocal.set(Integer.valueOf(i));
            e = (E) refCounter.getRealmInstance();
        }
        return e;
    }

    public static void deleteRealmFileOnDisk(RealmConfiguration realmConfiguration) {
        int i = 5;
        boolean z = false;
        while (i > 0 && !z) {
            try {
                z = BaseRealm.deleteRealm(realmConfiguration);
            } catch (IllegalStateException unused) {
                i--;
                RealmLog.warn(GeneratedOutlineSupport.outline6("Sync server still holds a reference to the Realm. It cannot be deleted. Retrying ", i, " more times"), new Object[0]);
                if (i > 0) {
                    SystemClock.sleep(15);
                }
            }
        }
        if (!z) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Failed to delete the underlying Realm file: ");
            outline17.append(realmConfiguration.canonicalPath);
            RealmLog.error(outline17.toString(), new Object[0]);
        }
    }

    public static RealmCache getCache(String str, boolean z) {
        RealmCache realmCache;
        synchronized (cachesList) {
            Iterator<WeakReference<RealmCache>> it = cachesList.iterator();
            realmCache = null;
            while (it.hasNext()) {
                RealmCache realmCache2 = it.next().get();
                if (realmCache2 == null) {
                    it.remove();
                } else if (realmCache2.realmPath.equals(str)) {
                    realmCache = realmCache2;
                }
            }
            if (realmCache == null && z) {
                realmCache = new RealmCache(str);
                cachesList.add(new WeakReference<>(realmCache));
            }
        }
        return realmCache;
    }

    public final <E extends BaseRealm> void createInstance(Class<E> cls, ReferenceCounter referenceCounter, boolean z, OsSharedRealm.VersionID versionID) {
        BaseRealm baseRealm;
        if (cls == Realm.class) {
            baseRealm = new Realm(this, versionID);
            if (z) {
                try {
                    if (ObjectServerFacade.getSyncFacadeIfPossible() == null) {
                        throw null;
                    }
                } catch (Throwable unused) {
                    baseRealm.close();
                    deleteRealmFileOnDisk(baseRealm.configuration);
                }
            }
        } else if (cls == DynamicRealm.class) {
            baseRealm = new DynamicRealm(this, versionID);
        } else {
            throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
        }
        referenceCounter.onRealmCreated(baseRealm);
    }

    public final <E extends BaseRealm> ReferenceCounter getRefCounter(Class<E> cls, OsSharedRealm.VersionID versionID) {
        RealmCacheType realmCacheType;
        if (cls == Realm.class) {
            realmCacheType = RealmCacheType.TYPED_REALM;
        } else if (cls == DynamicRealm.class) {
            realmCacheType = RealmCacheType.DYNAMIC_REALM;
        } else {
            throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
        }
        Pair<RealmCacheType, OsSharedRealm.VersionID> pair = new Pair<>(realmCacheType, versionID);
        ReferenceCounter referenceCounter = this.refAndCountMap.get(pair);
        if (referenceCounter == null) {
            if (versionID.equals(OsSharedRealm.VersionID.LIVE)) {
                referenceCounter = new ThreadConfinedReferenceCounter(null);
            } else {
                referenceCounter = new GlobalReferenceCounter(null);
            }
            this.refAndCountMap.put(pair, referenceCounter);
        }
        return referenceCounter;
    }

    public final int getTotalGlobalRefCount() {
        int i = 0;
        for (ReferenceCounter referenceCounter : this.refAndCountMap.values()) {
            i += referenceCounter.globalCount.get();
        }
        return i;
    }

    public final void validateConfiguration(RealmConfiguration realmConfiguration) {
        if (!this.configuration.equals(realmConfiguration)) {
            if (Arrays.equals(this.configuration.getEncryptionKey(), realmConfiguration.getEncryptionKey())) {
                RealmMigration realmMigration = realmConfiguration.migration;
                RealmMigration realmMigration2 = this.configuration.migration;
                if (realmMigration2 == null || realmMigration == null || !realmMigration2.getClass().equals(realmMigration.getClass()) || realmMigration.equals(realmMigration2)) {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Configurations cannot be different if used to open the same file. \nCached configuration: \n");
                    outline17.append(this.configuration);
                    outline17.append("\n\nNew configuration: \n");
                    outline17.append(realmConfiguration);
                    throw new IllegalArgumentException(outline17.toString());
                }
                StringBuilder outline172 = GeneratedOutlineSupport.outline17("Configurations cannot be different if used to open the same file. The most likely cause is that equals() and hashCode() are not overridden in the migration class: ");
                outline172.append(realmConfiguration.migration.getClass().getCanonicalName());
                throw new IllegalArgumentException(outline172.toString());
            }
            throw new IllegalArgumentException("Wrong key used to decrypt Realm.");
        }
    }

    public static abstract class ReferenceCounter {
        public AtomicInteger globalCount = new AtomicInteger(0);
        public final ThreadLocal<Integer> localCount = new ThreadLocal<>();

        public ReferenceCounter() {
        }

        public abstract void clearThreadLocalCache();

        public abstract BaseRealm getRealmInstance();

        public abstract int getThreadLocalCount();

        public abstract boolean hasInstanceAvailableForThread();

        public abstract void onRealmCreated(BaseRealm baseRealm);

        public ReferenceCounter(AnonymousClass1 r2) {
        }
    }
}
