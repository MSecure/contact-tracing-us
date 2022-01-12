package io.realm;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.Realm;
import io.realm.RealmCache;
import io.realm.internal.CheckedRow;
import io.realm.internal.ColumnIndices;
import io.realm.internal.ColumnInfo;
import io.realm.internal.ObjectServerFacade;
import io.realm.internal.OsObjectStore;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.UncheckedRow;
import io.realm.internal.async.RealmThreadPoolExecutor;
import io.realm.log.RealmLog;
import java.io.Closeable;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseRealm implements Closeable {
    public static volatile Context applicationContext;
    public static final ThreadLocalRealmObjectContext objectContext = new ThreadLocalRealmObjectContext();
    public final RealmConfiguration configuration;
    public final boolean frozen;
    public RealmCache realmCache;
    public OsSharedRealm.SchemaChangedCallback schemaChangedCallback = new OsSharedRealm.SchemaChangedCallback() {
        /* class io.realm.BaseRealm.AnonymousClass1 */

        @Override // io.realm.internal.OsSharedRealm.SchemaChangedCallback
        public void onSchemaChanged() {
            RealmSchema schema = BaseRealm.this.getSchema();
            if (schema != null) {
                ColumnIndices columnIndices = schema.columnIndices;
                if (columnIndices != null) {
                    for (Map.Entry<Class<? extends RealmModel>, ColumnInfo> entry : columnIndices.classToColumnInfoMap.entrySet()) {
                        entry.getValue().copyFrom(columnIndices.mediator.createColumnInfo(entry.getKey(), columnIndices.osSchemaInfo));
                    }
                }
                schema.dynamicClassToTable.clear();
                schema.classToTable.clear();
                schema.classToSchema.clear();
                schema.dynamicClassToSchema.clear();
            }
        }
    };
    public OsSharedRealm sharedRealm;
    public boolean shouldCloseSharedRealm;
    public final long threadId = Thread.currentThread().getId();

    public static final class RealmObjectContext {
        public boolean acceptDefaultValue;
        public ColumnInfo columnInfo;
        public List<String> excludeFields;
        public BaseRealm realm;
        public Row row;

        public void clear() {
            this.realm = null;
            this.row = null;
            this.columnInfo = null;
            this.acceptDefaultValue = false;
            this.excludeFields = null;
        }

        public void set(BaseRealm baseRealm, Row row2, ColumnInfo columnInfo2, boolean z, List<String> list) {
            this.realm = baseRealm;
            this.row = row2;
            this.columnInfo = columnInfo2;
            this.acceptDefaultValue = z;
            this.excludeFields = list;
        }
    }

    public static final class ThreadLocalRealmObjectContext extends ThreadLocal<RealmObjectContext> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public RealmObjectContext initialValue() {
            return new RealmObjectContext();
        }
    }

    static {
        int i = RealmThreadPoolExecutor.CORE_POOL_SIZE;
        new RealmThreadPoolExecutor(i, i);
    }

    public BaseRealm(OsSharedRealm osSharedRealm) {
        this.configuration = osSharedRealm.getConfiguration();
        this.realmCache = null;
        this.sharedRealm = osSharedRealm;
        this.frozen = osSharedRealm.isFrozen();
        this.shouldCloseSharedRealm = false;
    }

    public static boolean deleteRealm(final RealmConfiguration realmConfiguration) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        if (OsObjectStore.nativeCallWithLock(realmConfiguration.canonicalPath, new Runnable() {
            /* class io.realm.BaseRealm.AnonymousClass4 */

            public void run() {
                boolean z;
                RealmConfiguration realmConfiguration = RealmConfiguration.this;
                String str = realmConfiguration.canonicalPath;
                File file = realmConfiguration.realmDirectory;
                String str2 = realmConfiguration.realmFileName;
                AtomicBoolean atomicBoolean = atomicBoolean;
                File file2 = new File(file, GeneratedOutlineSupport.outline10(str2, ".management"));
                File file3 = new File(str);
                File file4 = new File(GeneratedOutlineSupport.outline10(str, ".note"));
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (File file5 : listFiles) {
                        if (!file5.delete()) {
                            RealmLog.warn(String.format(Locale.ENGLISH, "Realm temporary file at %s cannot be deleted", file5.getAbsolutePath()), new Object[0]);
                        }
                    }
                }
                if (file2.exists() && !file2.delete()) {
                    RealmLog.warn(String.format(Locale.ENGLISH, "Realm temporary folder at %s cannot be deleted", file2.getAbsolutePath()), new Object[0]);
                }
                if (file3.exists()) {
                    z = file3.delete();
                    if (!z) {
                        RealmLog.warn(String.format(Locale.ENGLISH, "Realm file at %s cannot be deleted", file3.getAbsolutePath()), new Object[0]);
                    }
                } else {
                    z = true;
                }
                if (file4.exists() && !file4.delete()) {
                    RealmLog.warn(String.format(Locale.ENGLISH, ".note file at %s cannot be deleted", file4.getAbsolutePath()), new Object[0]);
                }
                atomicBoolean.set(z);
            }
        })) {
            return atomicBoolean.get();
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file: ");
        outline17.append(realmConfiguration.canonicalPath);
        throw new IllegalStateException(outline17.toString());
    }

    public void checkIfValid() {
        OsSharedRealm osSharedRealm = this.sharedRealm;
        if (osSharedRealm == null || osSharedRealm.isClosed()) {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        } else if (!this.frozen && this.threadId != Thread.currentThread().getId()) {
            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
        }
    }

    public void checkNotInSync() {
        if (this.configuration == null) {
            throw null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        BaseRealm realmInstance;
        if (this.frozen || this.threadId == Thread.currentThread().getId()) {
            RealmCache realmCache2 = this.realmCache;
            if (realmCache2 != null) {
                synchronized (realmCache2) {
                    String str = this.configuration.canonicalPath;
                    RealmCache.ReferenceCounter refCounter = realmCache2.getRefCounter(getClass(), isFrozen() ? this.sharedRealm.getVersionID() : OsSharedRealm.VersionID.LIVE);
                    int threadLocalCount = refCounter.getThreadLocalCount();
                    if (threadLocalCount <= 0) {
                        RealmLog.warn("%s has been closed already. refCount is %s", str, Integer.valueOf(threadLocalCount));
                        return;
                    }
                    int i = threadLocalCount - 1;
                    if (i == 0) {
                        refCounter.clearThreadLocalCache();
                        this.realmCache = null;
                        OsSharedRealm osSharedRealm = this.sharedRealm;
                        if (osSharedRealm != null && this.shouldCloseSharedRealm) {
                            osSharedRealm.close();
                            this.sharedRealm = null;
                        }
                        int i2 = 0;
                        for (RealmCache.ReferenceCounter referenceCounter : realmCache2.refAndCountMap.values()) {
                            if (referenceCounter instanceof RealmCache.ThreadConfinedReferenceCounter) {
                                i2 += referenceCounter.globalCount.get();
                            }
                        }
                        if (i2 == 0) {
                            realmCache2.configuration = null;
                            for (RealmCache.ReferenceCounter referenceCounter2 : realmCache2.refAndCountMap.values()) {
                                if ((referenceCounter2 instanceof RealmCache.GlobalReferenceCounter) && (realmInstance = referenceCounter2.getRealmInstance()) != null) {
                                    while (true) {
                                        if (realmInstance.frozen || realmInstance.threadId == Thread.currentThread().getId()) {
                                            OsSharedRealm osSharedRealm2 = realmInstance.sharedRealm;
                                            if (osSharedRealm2 == null || osSharedRealm2.isClosed()) {
                                                break;
                                            }
                                            realmInstance.close();
                                        } else {
                                            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
                                        }
                                    }
                                }
                            }
                            if (this.configuration == null) {
                                throw null;
                            } else if (ObjectServerFacade.getFacade(false) == null) {
                                throw null;
                            }
                        }
                    } else {
                        refCounter.localCount.set(Integer.valueOf(i));
                    }
                    return;
                }
            }
            this.realmCache = null;
            OsSharedRealm osSharedRealm3 = this.sharedRealm;
            if (osSharedRealm3 != null && this.shouldCloseSharedRealm) {
                osSharedRealm3.close();
                this.sharedRealm = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.");
    }

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        OsSharedRealm osSharedRealm;
        if (this.shouldCloseSharedRealm && (osSharedRealm = this.sharedRealm) != null && !osSharedRealm.isClosed()) {
            RealmLog.warn("Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", this.configuration.canonicalPath);
            RealmCache realmCache2 = this.realmCache;
            if (realmCache2 != null && !realmCache2.isLeaked.getAndSet(true)) {
                RealmCache.leakedCaches.add(realmCache2);
            }
        }
        super.finalize();
    }

    public <E extends RealmModel> E get(Class<E> cls, String str, UncheckedRow uncheckedRow) {
        if (str != null) {
            return new DynamicRealmObject(this, new CheckedRow(uncheckedRow));
        }
        RealmProxyMediator realmProxyMediator = this.configuration.schemaMediator;
        RealmSchema schema = getSchema();
        schema.checkColumnKeys();
        return (E) realmProxyMediator.newInstance(cls, this, uncheckedRow, schema.columnIndices.getColumnInfo(cls), false, Collections.emptyList());
    }

    public abstract RealmSchema getSchema();

    public boolean isFrozen() {
        OsSharedRealm osSharedRealm = this.sharedRealm;
        if (osSharedRealm != null && !osSharedRealm.isClosed()) {
            return this.frozen;
        }
        throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
    }

    public boolean isInTransaction() {
        checkIfValid();
        return this.sharedRealm.isInTransaction();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001d, code lost:
        r2 = r0.migration;
     */
    public BaseRealm(RealmCache realmCache2, OsSchemaInfo osSchemaInfo, OsSharedRealm.VersionID versionID) {
        final RealmMigration realmMigration;
        RealmConfiguration realmConfiguration = realmCache2.configuration;
        this.configuration = realmConfiguration;
        AnonymousClass2 r1 = null;
        this.realmCache = null;
        AnonymousClass6 r3 = (osSchemaInfo == null || realmMigration == null) ? null : new OsSharedRealm.MigrationCallback() {
            /* class io.realm.BaseRealm.AnonymousClass6 */

            @Override // io.realm.internal.OsSharedRealm.MigrationCallback
            public void onMigrationNeeded(OsSharedRealm osSharedRealm, long j, long j2) {
                RealmMigration.this.migrate(new DynamicRealm(osSharedRealm), j, j2);
            }
        };
        final Realm.Transaction transaction = realmConfiguration.initialDataTransaction;
        r1 = transaction != null ? new OsSharedRealm.InitializationCallback() {
            /* class io.realm.BaseRealm.AnonymousClass2 */

            @Override // io.realm.internal.OsSharedRealm.InitializationCallback
            public void onInit(OsSharedRealm osSharedRealm) {
                transaction.execute(new Realm(osSharedRealm));
            }
        } : r1;
        OsRealmConfig.Builder builder = new OsRealmConfig.Builder(realmConfiguration);
        builder.fifoFallbackDir = new File(applicationContext.getFilesDir(), ".realm.temp").getAbsolutePath();
        builder.autoUpdateNotification = true;
        builder.migrationCallback = r3;
        builder.schemaInfo = osSchemaInfo;
        builder.initializationCallback = r1;
        OsSharedRealm instance = OsSharedRealm.getInstance(builder, versionID);
        this.sharedRealm = instance;
        this.frozen = instance.isFrozen();
        this.shouldCloseSharedRealm = true;
        this.sharedRealm.registerSchemaChangedCallback(this.schemaChangedCallback);
        this.realmCache = realmCache2;
    }
}
