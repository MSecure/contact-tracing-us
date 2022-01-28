package com.facebook.cache.disk;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.logging.LoggingDelegate;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class DynamicDefaultDiskStorage implements DiskStorage {
    public static final Class<?> TAG = DynamicDefaultDiskStorage.class;
    public final String mBaseDirectoryName;
    public final Supplier<File> mBaseDirectoryPathSupplier;
    public final CacheErrorLogger mCacheErrorLogger;
    public volatile State mCurrentState = new State(null, null);
    public final int mVersion;

    public static class State {
        public final DiskStorage delegate;
        public final File rootDirectory;

        public State(File file, DiskStorage diskStorage) {
            this.delegate = diskStorage;
            this.rootDirectory = file;
        }
    }

    public DynamicDefaultDiskStorage(int i, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mBaseDirectoryPathSupplier = supplier;
        this.mBaseDirectoryName = str;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() throws IOException {
        get().clearAll();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String str, Object obj) throws IOException {
        return get().contains(str, obj);
    }

    public final void createStorage() throws IOException {
        File file = new File(this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
        try {
            AppCompatDelegateImpl.ConfigurationImplApi17.mkdirs(file);
            Class<?> cls = TAG;
            String absolutePath = file.getAbsolutePath();
            if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(3)) {
                LoggingDelegate loggingDelegate = FLog.sHandler;
                FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = (FLogDefaultLoggingDelegate) loggingDelegate;
                fLogDefaultLoggingDelegate.println(3, cls.getSimpleName(), FLog.formatString("Created cache directory %s", absolutePath));
            }
            this.mCurrentState = new State(file, new DefaultDiskStorage(file, this.mVersion, this.mCacheErrorLogger));
        } catch (FileUtils$CreateDirectoryException e) {
            if (((NoOpCacheErrorLogger) this.mCacheErrorLogger) != null) {
                throw e;
            }
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0017  */
    public synchronized DiskStorage get() throws IOException {
        boolean z;
        DiskStorage diskStorage;
        File file;
        State state = this.mCurrentState;
        if (!(state.delegate == null || (file = state.rootDirectory) == null)) {
            if (file.exists()) {
                z = false;
                if (z) {
                    if (!(this.mCurrentState.delegate == null || this.mCurrentState.rootDirectory == null)) {
                        AppCompatDelegateImpl.ConfigurationImplApi17.deleteRecursively(this.mCurrentState.rootDirectory);
                    }
                    createStorage();
                }
                diskStorage = this.mCurrentState.delegate;
                AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(diskStorage);
            }
        }
        z = true;
        if (z) {
        }
        diskStorage = this.mCurrentState.delegate;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(diskStorage);
        return diskStorage;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Collection<DiskStorage.Entry> getEntries() throws IOException {
        return get().getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public FileBinaryResource getResource(String str, Object obj) throws IOException {
        return get().getResource(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        return get().insert(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        try {
            return get().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        try {
            get().purgeUnexpectedResources();
        } catch (IOException e) {
            FLog.e(TAG, "purgeUnexpectedResources", e);
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) throws IOException {
        return get().remove(entry);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String str) throws IOException {
        return get().remove(str);
    }
}
