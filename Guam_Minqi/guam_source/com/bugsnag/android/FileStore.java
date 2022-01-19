package com.bugsnag.android;

import android.content.Context;
import com.bugsnag.android.JsonStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FileStore {
    public final Comparator<File> comparator;
    public final Delegate delegate;
    public final Lock lock = new ReentrantLock();
    public final Logger logger;
    public final int maxStoreCount;
    public final Collection<File> queuedFiles = new ConcurrentSkipListSet();
    public final String storeDirectory;

    public interface Delegate {
    }

    public FileStore(Context context, String str, int i, Comparator<File> comparator2, Logger logger2, Delegate delegate2) {
        String str2;
        this.maxStoreCount = i;
        this.comparator = comparator2;
        this.logger = logger2;
        this.delegate = delegate2;
        try {
            str2 = context.getCacheDir().getAbsolutePath() + str;
            File file = new File(str2);
            file.mkdirs();
            if (!file.exists()) {
                this.logger.w("Could not prepare file storage directory");
                str2 = null;
            }
        } catch (Exception e) {
            this.logger.w("Could not prepare file storage directory", e);
        }
        this.storeDirectory = str2;
    }

    public void cancelQueuedFiles(Collection<File> collection) {
        this.lock.lock();
        if (collection != null) {
            try {
                this.queuedFiles.removeAll(collection);
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
    }

    public void deleteStoredFiles(Collection<File> collection) {
        this.lock.lock();
        if (collection != null) {
            try {
                this.queuedFiles.removeAll(collection);
                for (File file : collection) {
                    if (!file.delete()) {
                        file.deleteOnExit();
                    }
                }
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
    }

    public void discardOldestFileIfNeeded() {
        File[] listFiles;
        File file = new File(this.storeDirectory);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length >= this.maxStoreCount) {
            Arrays.sort(listFiles, this.comparator);
            for (int i = 0; i < listFiles.length && listFiles.length >= this.maxStoreCount; i++) {
                File file2 = listFiles[i];
                if (!this.queuedFiles.contains(file2)) {
                    this.logger.w(String.format("Discarding oldest error as stored error limit reached (%s)", file2.getPath()));
                    deleteStoredFiles(Collections.singleton(file2));
                }
            }
        }
    }

    public List<File> findStoredFiles() {
        File[] listFiles;
        this.lock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            if (this.storeDirectory != null) {
                File file = new File(this.storeDirectory);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.length() == 0) {
                            if (!file2.delete()) {
                                file2.deleteOnExit();
                            }
                        } else if (file2.isFile() && !this.queuedFiles.contains(file2)) {
                            arrayList.add(file2);
                        }
                    }
                }
            }
            this.queuedFiles.addAll(arrayList);
            return arrayList;
        } finally {
            this.lock.unlock();
        }
    }

    public abstract String getFilename(Object obj);

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0071, code lost:
        if (r2 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
        if (r2 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056 A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008c A[SYNTHETIC, Splitter:B:43:0x008c] */
    public String write(JsonStream.Streamable streamable) {
        Throwable th;
        JsonStream jsonStream;
        FileNotFoundException e;
        Exception e2;
        File file;
        JsonStream jsonStream2 = null;
        if (this.storeDirectory == null) {
            return null;
        }
        discardOldestFileIfNeeded();
        String filename = getFilename(streamable);
        this.lock.lock();
        try {
            jsonStream = new JsonStream(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8")));
            try {
                jsonStream.value(streamable);
                this.logger.i(String.format("Saved unsent payload to disk (%s) ", filename));
                try {
                    jsonStream.close();
                } catch (Exception unused) {
                }
                this.lock.unlock();
                return filename;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.logger.w("Ignoring FileNotFoundException - unable to create file", e);
            } catch (Exception e4) {
                e2 = e4;
                try {
                    file = new File(filename);
                    if (this.delegate != null) {
                        ((InternalReportDelegate) this.delegate).onErrorIOFailure(e2, file, "Crash report serialization");
                    }
                    Logger logger2 = this.logger;
                    try {
                        if (!file.delete()) {
                            file.deleteOnExit();
                        }
                    } catch (Exception e5) {
                        logger2.w("Failed to delete file", e5);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jsonStream2 = jsonStream;
                    if (jsonStream2 != null) {
                        try {
                            jsonStream2.close();
                        } catch (Exception unused2) {
                        }
                    }
                    this.lock.unlock();
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            jsonStream = null;
            this.logger.w("Ignoring FileNotFoundException - unable to create file", e);
        } catch (Exception e7) {
            e2 = e7;
            jsonStream = null;
            file = new File(filename);
            if (this.delegate != null) {
            }
            Logger logger22 = this.logger;
            if (!file.delete()) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (jsonStream2 != null) {
            }
            this.lock.unlock();
            throw th;
        }
        this.lock.unlock();
        return null;
    }
}
