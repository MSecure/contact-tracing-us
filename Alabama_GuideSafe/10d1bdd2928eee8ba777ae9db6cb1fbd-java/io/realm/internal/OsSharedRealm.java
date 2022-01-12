package io.realm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import io.realm.RealmConfiguration;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.OsResults;
import io.realm.internal.android.AndroidCapabilities;
import io.realm.internal.android.AndroidRealmNotifier;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
public final class OsSharedRealm implements Closeable, NativeObject {
    public static final byte FILE_EXCEPTION_INCOMPATIBLE_SYNC_FILE = 7;
    public static final byte FILE_EXCEPTION_KIND_ACCESS_ERROR = 0;
    public static final byte FILE_EXCEPTION_KIND_BAD_HISTORY = 1;
    public static final byte FILE_EXCEPTION_KIND_EXISTS = 3;
    public static final byte FILE_EXCEPTION_KIND_FORMAT_UPGRADE_REQUIRED = 6;
    public static final byte FILE_EXCEPTION_KIND_INCOMPATIBLE_LOCK_FILE = 5;
    public static final byte FILE_EXCEPTION_KIND_NOT_FOUND = 4;
    public static final byte FILE_EXCEPTION_KIND_PERMISSION_DENIED = 2;
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public static final List<OsSharedRealm> sharedRealmsUnderConstruction = new CopyOnWriteArrayList();
    public static volatile File temporaryDirectory;
    public final Capabilities capabilities;
    public final NativeContext context;
    public final List<WeakReference<OsResults.Iterator>> iterators = new ArrayList();
    public final long nativePtr;
    public final OsRealmConfig osRealmConfig;
    public final List<WeakReference<PendingRow>> pendingRows = new CopyOnWriteArrayList();
    public final RealmNotifier realmNotifier;
    public final OsSchemaInfo schemaInfo;
    public final List<OsSharedRealm> tempSharedRealmsForCallback = new ArrayList();

    @Keep
    public interface InitializationCallback {
        void onInit(OsSharedRealm osSharedRealm);
    }

    @Keep
    public interface MigrationCallback {
        void onMigrationNeeded(OsSharedRealm osSharedRealm, long j, long j2);
    }

    @Keep
    public interface SchemaChangedCallback {
        void onSchemaChanged();
    }

    public static class VersionID implements Comparable<VersionID> {
        public static final VersionID LIVE = new VersionID(-1, -1);
        public final long index;
        public final long version;

        public VersionID(long j, long j2) {
            this.version = j;
            this.index = j2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(VersionID versionID) {
            VersionID versionID2 = versionID;
            if (versionID2 != null) {
                int i = (this.version > versionID2.version ? 1 : (this.version == versionID2.version ? 0 : -1));
                if (i > 0) {
                    return 1;
                }
                return i < 0 ? -1 : 0;
            }
            throw new IllegalArgumentException("Version cannot be compared to a null value.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VersionID.class != obj.getClass()) {
                return false;
            }
            VersionID versionID = (VersionID) obj;
            return this.version == versionID.version && this.index == versionID.index;
        }

        public int hashCode() {
            long j = this.version;
            long j2 = this.index;
            return (((int) (j ^ (j >>> 32))) * 31) + ((int) ((j2 >>> 32) ^ j2));
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("VersionID{version=");
            outline17.append(this.version);
            outline17.append(", index=");
            outline17.append(this.index);
            outline17.append('}');
            return outline17.toString();
        }
    }

    public OsSharedRealm(OsRealmConfig osRealmConfig2, VersionID versionID) {
        AndroidCapabilities androidCapabilities = new AndroidCapabilities();
        AndroidRealmNotifier androidRealmNotifier = new AndroidRealmNotifier(this, androidCapabilities);
        this.context = osRealmConfig2.context;
        sharedRealmsUnderConstruction.add(this);
        try {
            this.nativePtr = nativeGetSharedRealm(osRealmConfig2.nativePtr, versionID.version, versionID.index, androidRealmNotifier);
            this.tempSharedRealmsForCallback.clear();
            sharedRealmsUnderConstruction.remove(this);
            this.osRealmConfig = osRealmConfig2;
            this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(this.nativePtr), this);
            this.context.addReference(this);
            this.capabilities = androidCapabilities;
            this.realmNotifier = androidRealmNotifier;
            if (versionID.equals(VersionID.LIVE)) {
                nativeSetAutoRefresh(this.nativePtr, androidCapabilities.canDeliverNotification());
            }
        } catch (Throwable th) {
            this.tempSharedRealmsForCallback.clear();
            sharedRealmsUnderConstruction.remove(this);
            throw th;
        }
    }

    private void detachIterators() {
        for (WeakReference<OsResults.Iterator> weakReference : this.iterators) {
            OsResults.Iterator iterator = weakReference.get();
            if (iterator != null) {
                iterator.iteratorOsResults = iterator.iteratorOsResults.createSnapshot();
            }
        }
        this.iterators.clear();
    }

    private void executePendingRowQueries() {
        for (WeakReference<PendingRow> weakReference : this.pendingRows) {
            PendingRow pendingRow = weakReference.get();
            if (pendingRow != null) {
                if (pendingRow.pendingOsResults == null) {
                    throw new IllegalStateException("The query has been executed. This 'PendingRow' is not valid anymore.");
                }
                throw new IllegalStateException("The 'frontEnd' has not been set.");
            }
        }
        this.pendingRows.clear();
    }

    public static OsSharedRealm getInstance(RealmConfiguration realmConfiguration, VersionID versionID) {
        return getInstance(new OsRealmConfig.Builder(realmConfiguration), versionID);
    }

    public static File getTemporaryDirectory() {
        return temporaryDirectory;
    }

    public static void initialize(File file) {
        if (temporaryDirectory == null) {
            String absolutePath = file.getAbsolutePath();
            if (file.isDirectory() || file.mkdirs() || file.isDirectory()) {
                if (!absolutePath.endsWith(ColorPropConverter.PATH_DELIMITER)) {
                    absolutePath = GeneratedOutlineSupport.outline10(absolutePath, ColorPropConverter.PATH_DELIMITER);
                }
                nativeInit(absolutePath);
                temporaryDirectory = file;
                return;
            }
            throw new IOException(GeneratedOutlineSupport.outline10("failed to create temporary directory: ", absolutePath));
        }
    }

    public static native void nativeBeginTransaction(long j);

    public static native void nativeCancelTransaction(long j);

    public static native void nativeCloseSharedRealm(long j);

    public static native void nativeCommitTransaction(long j);

    public static native boolean nativeCompact(long j);

    public static native long nativeCreateTable(long j, String str);

    public static native long nativeCreateTableWithPrimaryKeyField(long j, String str, String str2, boolean z, boolean z2);

    public static native long nativeFreeze(long j);

    public static native int nativeGetClassPrivileges(long j, String str);

    public static native long nativeGetFinalizerPtr();

    public static native int nativeGetObjectPrivileges(long j, long j2);

    public static native int nativeGetRealmPrivileges(long j);

    public static native long nativeGetSchemaInfo(long j);

    public static native long nativeGetSharedRealm(long j, long j2, long j3, RealmNotifier realmNotifier2);

    public static native long nativeGetTableRef(long j, String str);

    public static native String[] nativeGetTablesName(long j);

    public static native long[] nativeGetVersionID(long j);

    public static native boolean nativeHasTable(long j, String str);

    public static native void nativeInit(String str);

    public static native boolean nativeIsAutoRefresh(long j);

    public static native boolean nativeIsClosed(long j);

    public static native boolean nativeIsEmpty(long j);

    public static native boolean nativeIsFrozen(long j);

    public static native boolean nativeIsInTransaction(long j);

    public static native boolean nativeIsPartial(long j);

    public static native long nativeNumberOfVersions(long j);

    public static native void nativeRefresh(long j);

    public static native void nativeRegisterSchemaChangedCallback(long j, SchemaChangedCallback schemaChangedCallback);

    public static native void nativeRenameTable(long j, String str, String str2);

    public static native void nativeSetAutoRefresh(long j, boolean z);

    public static native long nativeSize(long j);

    public static native void nativeStopWaitForChange(long j);

    public static native boolean nativeWaitForChange(long j);

    public static native void nativeWriteCopy(long j, String str, byte[] bArr);

    public static void runInitializationCallback(long j, OsRealmConfig osRealmConfig2, InitializationCallback initializationCallback) {
        initializationCallback.onInit(new OsSharedRealm(j, osRealmConfig2));
    }

    public static void runMigrationCallback(long j, OsRealmConfig osRealmConfig2, MigrationCallback migrationCallback, long j2) {
        migrationCallback.onMigrationNeeded(new OsSharedRealm(j, osRealmConfig2), j2, osRealmConfig2.realmConfiguration.schemaVersion);
    }

    public void addIterator(OsResults.Iterator iterator) {
        this.iterators.add(new WeakReference<>(iterator));
    }

    public void addPendingRow(PendingRow pendingRow) {
        this.pendingRows.add(new WeakReference<>(pendingRow));
    }

    public void beginTransaction() {
        detachIterators();
        executePendingRowQueries();
        nativeBeginTransaction(this.nativePtr);
    }

    public void cancelTransaction() {
        nativeCancelTransaction(this.nativePtr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        RealmNotifier realmNotifier2 = this.realmNotifier;
        if (realmNotifier2 != null) {
            realmNotifier2.close();
        }
        synchronized (this.context) {
            nativeCloseSharedRealm(this.nativePtr);
        }
    }

    public void commitTransaction() {
        nativeCommitTransaction(this.nativePtr);
    }

    public boolean compact() {
        return nativeCompact(this.nativePtr);
    }

    public Table createTable(String str) {
        return new Table(this, nativeCreateTable(this.nativePtr, str));
    }

    public Table createTableWithPrimaryKey(String str, String str2, boolean z, boolean z2) {
        return new Table(this, nativeCreateTableWithPrimaryKeyField(this.nativePtr, str, str2, z, z2));
    }

    public OsSharedRealm freeze() {
        return new OsSharedRealm(this.osRealmConfig, getVersionID());
    }

    public RealmConfiguration getConfiguration() {
        return this.osRealmConfig.realmConfiguration;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNumberOfVersions() {
        return nativeNumberOfVersions(this.nativePtr);
    }

    public String getPath() {
        return this.osRealmConfig.realmConfiguration.canonicalPath;
    }

    public OsSchemaInfo getSchemaInfo() {
        return this.schemaInfo;
    }

    public Table getTable(String str) {
        return new Table(this, nativeGetTableRef(this.nativePtr, str));
    }

    public String[] getTablesNames() {
        String[] nativeGetTablesName = nativeGetTablesName(this.nativePtr);
        return nativeGetTablesName != null ? nativeGetTablesName : new String[0];
    }

    public VersionID getVersionID() {
        long[] nativeGetVersionID = nativeGetVersionID(this.nativePtr);
        if (nativeGetVersionID != null) {
            return new VersionID(nativeGetVersionID[0], nativeGetVersionID[1]);
        }
        throw new IllegalStateException("Cannot get versionId, this could be related to a non existing read/write transaction");
    }

    public boolean hasTable(String str) {
        return nativeHasTable(this.nativePtr, str);
    }

    public void invalidateIterators() {
        for (WeakReference<OsResults.Iterator> weakReference : this.iterators) {
            OsResults.Iterator iterator = weakReference.get();
            if (iterator != null) {
                iterator.iteratorOsResults = null;
            }
        }
        this.iterators.clear();
    }

    public boolean isAutoRefresh() {
        return nativeIsAutoRefresh(this.nativePtr);
    }

    public boolean isClosed() {
        return nativeIsClosed(this.nativePtr);
    }

    public boolean isEmpty() {
        return nativeIsEmpty(this.nativePtr);
    }

    public boolean isFrozen() {
        return nativeIsFrozen(this.nativePtr);
    }

    public boolean isInTransaction() {
        return nativeIsInTransaction(this.nativePtr);
    }

    public boolean isPartial() {
        return nativeIsPartial(this.nativePtr);
    }

    public boolean isSyncRealm() {
        return this.osRealmConfig.resolvedRealmURI != null;
    }

    public void refresh() {
        if (!isFrozen()) {
            nativeRefresh(this.nativePtr);
            return;
        }
        throw new IllegalStateException("It is not possible to refresh frozen Realms.");
    }

    public void registerSchemaChangedCallback(SchemaChangedCallback schemaChangedCallback) {
        nativeRegisterSchemaChangedCallback(this.nativePtr, schemaChangedCallback);
    }

    public void removePendingRow(PendingRow pendingRow) {
        for (WeakReference<PendingRow> weakReference : this.pendingRows) {
            PendingRow pendingRow2 = weakReference.get();
            if (pendingRow2 == null || pendingRow2 == pendingRow) {
                this.pendingRows.remove(weakReference);
            }
        }
    }

    public void renameTable(String str, String str2) {
        nativeRenameTable(this.nativePtr, str, str2);
    }

    public void setAutoRefresh(boolean z) {
        AndroidCapabilities androidCapabilities = (AndroidCapabilities) this.capabilities;
        if (!(androidCapabilities.looper != null)) {
            throw new IllegalStateException("");
        } else if (androidCapabilities.isIntentServiceThread) {
            throw new IllegalStateException("");
        } else {
            nativeSetAutoRefresh(this.nativePtr, z);
        }
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public void stopWaitForChange() {
        nativeStopWaitForChange(this.nativePtr);
    }

    public boolean waitForChange() {
        return nativeWaitForChange(this.nativePtr);
    }

    public void writeCopy(File file, byte[] bArr) {
        if (!file.isFile() || !file.exists()) {
            nativeWriteCopy(this.nativePtr, file.getAbsolutePath(), bArr);
            return;
        }
        throw new IllegalArgumentException("The destination file must not exist");
    }

    public static OsSharedRealm getInstance(OsRealmConfig.Builder builder, VersionID versionID) {
        OsRealmConfig build = builder.build();
        if (ObjectServerFacade.getSyncFacadeIfPossible() != null) {
            return new OsSharedRealm(build, versionID);
        }
        throw null;
    }

    public OsSharedRealm(long j, OsRealmConfig osRealmConfig2) {
        this.nativePtr = j;
        this.osRealmConfig = osRealmConfig2;
        this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(this.nativePtr), this);
        NativeContext nativeContext = osRealmConfig2.context;
        this.context = nativeContext;
        nativeContext.addReference(this);
        this.capabilities = new AndroidCapabilities();
        this.realmNotifier = null;
        boolean z = false;
        nativeSetAutoRefresh(this.nativePtr, false);
        Iterator<OsSharedRealm> it = sharedRealmsUnderConstruction.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            OsSharedRealm next = it.next();
            if (next.context == osRealmConfig2.context) {
                z = true;
                next.tempSharedRealmsForCallback.add(this);
                break;
            }
        }
        if (!z) {
            throw new IllegalStateException("Cannot find the parent 'OsSharedRealm' which is under construction.");
        }
    }
}
