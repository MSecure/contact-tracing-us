package com.facebook.cache.disk;

import android.os.Environment;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DefaultDiskStorage implements DiskStorage {
    public static final Class<?> TAG = DefaultDiskStorage.class;
    public static final long TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30);
    public final CacheErrorLogger mCacheErrorLogger;
    public final Clock mClock;
    public final boolean mIsExternal;
    public final File mRootDirectory;
    public final File mVersionDirectory;

    public class EntriesCollector implements FileTreeVisitor {
        public final List<DiskStorage.Entry> result = new ArrayList();

        public EntriesCollector(AnonymousClass1 r2) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            FileInfo access$000 = DefaultDiskStorage.access$000(DefaultDiskStorage.this, file);
            if (access$000 != null && access$000.type == ".cnt") {
                this.result.add(new EntryImpl(access$000.resourceId, file, null));
            }
        }
    }

    public static class EntryImpl implements DiskStorage.Entry {
        public final String id;
        public final FileBinaryResource resource;
        public long size;
        public long timestamp;

        public EntryImpl(String str, File file, AnonymousClass1 r3) {
            if (str != null) {
                this.id = str;
                this.resource = FileBinaryResource.createOrNull(file);
                this.size = -1;
                this.timestamp = -1;
                return;
            }
            throw null;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public String getId() {
            return this.id;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getSize() {
            if (this.size < 0) {
                this.size = this.resource.size();
            }
            return this.size;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            if (this.timestamp < 0) {
                this.timestamp = this.resource.mFile.lastModified();
            }
            return this.timestamp;
        }
    }

    public static class FileInfo {
        public final String resourceId;
        public final String type;

        public FileInfo(String str, String str2) {
            this.type = str;
            this.resourceId = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.type);
            sb.append("(");
            return GeneratedOutlineSupport.outline14(sb, this.resourceId, ")");
        }
    }

    public static class IncompleteFileException extends IOException {
        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
        }
    }

    public class InserterImpl implements DiskStorage.Inserter {
        public final String mResourceId;
        public final File mTemporaryFile;

        public InserterImpl(String str, File file) {
            this.mResourceId = str;
            this.mTemporaryFile = file;
        }

        public boolean cleanUp() {
            return !this.mTemporaryFile.exists() || this.mTemporaryFile.delete();
        }

        public FileBinaryResource commit(Object obj) throws IOException {
            File contentFileFor = DefaultDiskStorage.this.getContentFileFor(this.mResourceId);
            try {
                AppCompatDelegateImpl.ConfigurationImplApi17.rename(this.mTemporaryFile, contentFileFor);
                if (contentFileFor.exists()) {
                    if (((SystemClock) DefaultDiskStorage.this.mClock) != null) {
                        contentFileFor.setLastModified(System.currentTimeMillis());
                    } else {
                        throw null;
                    }
                }
                return FileBinaryResource.createOrNull(contentFileFor);
            } catch (FileUtils$RenameException e) {
                Throwable cause = e.getCause();
                if (cause != null && !(cause instanceof FileUtils$ParentDirNotFoundException)) {
                    boolean z = cause instanceof FileNotFoundException;
                }
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.mCacheErrorLogger;
                Class<?> cls = DefaultDiskStorage.TAG;
                if (((NoOpCacheErrorLogger) cacheErrorLogger) != null) {
                    throw e;
                }
                throw null;
            }
        }

        /* JADX INFO: finally extract failed */
        public void writeData(WriterCallback writerCallback, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mTemporaryFile);
                try {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                    BufferedDiskCache.AnonymousClass6 r5 = (BufferedDiskCache.AnonymousClass6) writerCallback;
                    BufferedDiskCache.this.mPooledByteStreams.copy(r5.getInputStream(), countingOutputStream);
                    countingOutputStream.flush();
                    long j = countingOutputStream.mCount;
                    fileOutputStream.close();
                    if (this.mTemporaryFile.length() != j) {
                        throw new IncompleteFileException(j, this.mTemporaryFile.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.mCacheErrorLogger;
                Class<?> cls = DefaultDiskStorage.TAG;
                if (((NoOpCacheErrorLogger) cacheErrorLogger) != null) {
                    throw e;
                }
                throw null;
            }
        }
    }

    public class PurgingVisitor implements FileTreeVisitor {
        public boolean insideBaseDirectory;

        public PurgingVisitor(AnonymousClass1 r2) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
            if (!DefaultDiskStorage.this.mRootDirectory.equals(file) && !this.insideBaseDirectory) {
                file.delete();
            }
            if (this.insideBaseDirectory && file.equals(DefaultDiskStorage.this.mVersionDirectory)) {
                this.insideBaseDirectory = false;
            }
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
            if (!this.insideBaseDirectory && file.equals(DefaultDiskStorage.this.mVersionDirectory)) {
                this.insideBaseDirectory = true;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
            if (r3 > (java.lang.System.currentTimeMillis() - com.facebook.cache.disk.DefaultDiskStorage.TEMP_FILE_LIFETIME_MS)) goto L_0x0037;
         */
        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            if (this.insideBaseDirectory) {
                FileInfo access$000 = DefaultDiskStorage.access$000(DefaultDiskStorage.this, file);
                boolean z = false;
                if (access$000 != null) {
                    String str = access$000.type;
                    if (str == ".tmp") {
                        long lastModified = file.lastModified();
                        if (((SystemClock) DefaultDiskStorage.this.mClock) == null) {
                            throw null;
                        }
                    } else {
                        if (str == ".cnt") {
                            z = true;
                        }
                        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(z);
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            file.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a A[SYNTHETIC, Splitter:B:22:0x006a] */
    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        boolean z;
        this.mRootDirectory = file;
        boolean z2 = false;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                try {
                    z = file.getCanonicalPath().contains(externalStorageDirectory.toString());
                } catch (IOException unused) {
                    if (((NoOpCacheErrorLogger) cacheErrorLogger) == null) {
                        throw null;
                    }
                }
                this.mIsExternal = z;
                this.mVersionDirectory = new File(this.mRootDirectory, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
                this.mCacheErrorLogger = cacheErrorLogger;
                if (this.mRootDirectory.exists()) {
                    if (!this.mVersionDirectory.exists()) {
                        AppCompatDelegateImpl.ConfigurationImplApi17.deleteRecursively(this.mRootDirectory);
                    }
                    if (z2) {
                        try {
                            AppCompatDelegateImpl.ConfigurationImplApi17.mkdirs(this.mVersionDirectory);
                        } catch (FileUtils$CreateDirectoryException unused2) {
                            CacheErrorLogger cacheErrorLogger2 = this.mCacheErrorLogger;
                            StringBuilder outline17 = GeneratedOutlineSupport.outline17("version directory could not be created: ");
                            outline17.append(this.mVersionDirectory);
                            outline17.toString();
                            if (((NoOpCacheErrorLogger) cacheErrorLogger2) == null) {
                                throw null;
                            }
                        }
                    }
                    this.mClock = SystemClock.INSTANCE;
                }
                z2 = true;
                if (z2) {
                }
                this.mClock = SystemClock.INSTANCE;
            }
        } catch (Exception unused3) {
            if (((NoOpCacheErrorLogger) cacheErrorLogger) == null) {
                throw null;
            }
        }
        z = false;
        this.mIsExternal = z;
        this.mVersionDirectory = new File(this.mRootDirectory, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
        this.mCacheErrorLogger = cacheErrorLogger;
        if (this.mRootDirectory.exists()) {
        }
        z2 = true;
        if (z2) {
        }
        this.mClock = SystemClock.INSTANCE;
    }

    public static FileInfo access$000(DefaultDiskStorage defaultDiskStorage, File file) {
        FileInfo fileInfo;
        String access$800;
        if (defaultDiskStorage != null) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (access$800 = access$800(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (access$800.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 > 0) {
                        substring = substring.substring(0, lastIndexOf2);
                    }
                }
                fileInfo = new FileInfo(access$800, substring);
                if (fileInfo == null && new File(defaultDiskStorage.getSubdirectoryPath(fileInfo.resourceId)).equals(file.getParentFile())) {
                    return fileInfo;
                }
                return null;
            }
            fileInfo = null;
            if (fileInfo == null) {
                return null;
            }
            return fileInfo;
        }
        throw null;
    }

    public static String access$800(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        AppCompatDelegateImpl.ConfigurationImplApi17.deleteContents(this.mRootDirectory);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String str, Object obj) {
        return getContentFileFor(str).exists();
    }

    public final long doRemove(File file) {
        if (!file.exists()) {
            return 0;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1;
    }

    public File getContentFileFor(String str) {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17(getSubdirectoryPath(str));
        outline17.append(File.separator);
        outline17.append(str);
        outline17.append(".cnt");
        return new File(outline17.toString());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Collection getEntries() throws IOException {
        EntriesCollector entriesCollector = new EntriesCollector(null);
        AppCompatDelegateImpl.ConfigurationImplApi17.walkFileTree(this.mVersionDirectory, entriesCollector);
        return Collections.unmodifiableList(entriesCollector.result);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public FileBinaryResource getResource(String str, Object obj) {
        File contentFileFor = getContentFileFor(str);
        if (!contentFileFor.exists()) {
            return null;
        }
        if (((SystemClock) this.mClock) != null) {
            contentFileFor.setLastModified(System.currentTimeMillis());
            return FileBinaryResource.createOrNull(contentFileFor);
        }
        throw null;
    }

    public final String getSubdirectoryPath(String str) {
        String valueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder sb = new StringBuilder();
        sb.append(this.mVersionDirectory);
        return GeneratedOutlineSupport.outline14(sb, File.separator, valueOf);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        File file = new File(getSubdirectoryPath(str));
        if (!file.exists()) {
            try {
                AppCompatDelegateImpl.ConfigurationImplApi17.mkdirs(file);
            } catch (FileUtils$CreateDirectoryException e) {
                if (((NoOpCacheErrorLogger) this.mCacheErrorLogger) != null) {
                    throw e;
                }
                throw null;
            }
        }
        try {
            return new InserterImpl(str, File.createTempFile(str + ".", ".tmp", file));
        } catch (IOException e2) {
            if (((NoOpCacheErrorLogger) this.mCacheErrorLogger) != null) {
                throw e2;
            }
            throw null;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        return this.mIsExternal;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        AppCompatDelegateImpl.ConfigurationImplApi17.walkFileTree(this.mRootDirectory, new PurgingVisitor(null));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) {
        return doRemove(((EntryImpl) entry).resource.mFile);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String str) {
        return doRemove(getContentFileFor(str));
    }
}
