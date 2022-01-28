package org.matomo.sdk.dispatcher;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import okhttp3.internal.cache.DiskLruCache;
import org.matomo.sdk.Matomo;
import org.matomo.sdk.Tracker;
import timber.log.Timber;

public class EventDiskCache {
    public static final String TAG = Matomo.tag(EventDiskCache.class);
    public final File mCacheDir;
    public long mCurrentSize = 0;
    public boolean mDelayedClear;
    public final LinkedBlockingQueue<File> mEventContainer = new LinkedBlockingQueue<>();
    public final long mMaxAge;
    public final long mMaxSize;

    public EventDiskCache(Tracker tracker) {
        this.mDelayedClear = false;
        this.mMaxAge = tracker.getPreferences().getLong("tracker.cache.age", 86400000);
        this.mMaxSize = tracker.getPreferences().getLong("tracker.cache.size", 4194304);
        try {
            File file = new File(new File(tracker.mMatomo.mContext.getCacheDir(), "piwik_cache"), new URL(tracker.mApiUrl).getHost());
            this.mCacheDir = file;
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles);
                for (File file2 : listFiles) {
                    this.mCurrentSize = file2.length() + this.mCurrentSize;
                    this.mEventContainer.add(file2);
                }
            } else if (!this.mCacheDir.mkdirs()) {
                Timber.tag(TAG).e("Failed to make disk-cache dir %s", this.mCacheDir);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public final void checkCacheLimits() {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.mMaxAge;
        long j3 = 0;
        if (j2 < 0) {
            Timber.tag(TAG).d("Caching is disabled.", new Object[0]);
            while (!this.mEventContainer.isEmpty()) {
                File poll = this.mEventContainer.poll();
                if (poll.delete()) {
                    Timber.tag(TAG).e("Deleted cache container %s", poll.getPath());
                }
            }
        } else if (j2 > 0) {
            Iterator<File> it = this.mEventContainer.iterator();
            while (it.hasNext()) {
                File next = it.next();
                try {
                    j = Long.valueOf(next.getName().split("_")[1]).longValue();
                } catch (Exception e) {
                    Timber.tag(TAG).e(e);
                    j = j3;
                }
                if (j >= System.currentTimeMillis() - this.mMaxAge) {
                    break;
                }
                if (next.delete()) {
                    Timber.tag(TAG).e("Deleted cache container %s", next.getPath());
                } else {
                    Timber.tag(TAG).e("Failed to delete cache container %s", next.getPath());
                }
                it.remove();
                j3 = 0;
            }
        }
        if (this.mMaxSize != 0) {
            Iterator<File> it2 = this.mEventContainer.iterator();
            while (it2.hasNext() && this.mCurrentSize > this.mMaxSize) {
                File next2 = it2.next();
                this.mCurrentSize -= next2.length();
                it2.remove();
                if (next2.delete()) {
                    Timber.tag(TAG).e("Deleted cache container %s", next2.getPath());
                } else {
                    Timber.tag(TAG).e("Failed to delete cache container %s", next2.getPath());
                }
            }
        }
        Timber.tag(TAG).d("Cache check took %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0079, code lost:
        timber.log.Timber.tag(org.matomo.sdk.dispatcher.EventDiskCache.TAG).e(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0088, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        timber.log.Timber.tag(org.matomo.sdk.dispatcher.EventDiskCache.TAG).e(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087 A[ExcHandler: all (r0v11 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:9:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d1 A[SYNTHETIC, Splitter:B:51:0x00d1] */
    public final List<Event> readEventFile(File file) {
        IOException e;
        ArrayList arrayList = new ArrayList();
        if (!file.exists()) {
            return arrayList;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                    if (!DiskLruCache.VERSION_1.equals(bufferedReader.readLine())) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            Timber.tag(TAG).e(e2);
                        }
                        return arrayList;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - this.mMaxAge;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            int indexOf = readLine.indexOf(" ");
                            if (indexOf != -1) {
                                long parseLong = Long.parseLong(readLine.substring(0, indexOf));
                                if (this.mMaxAge <= 0 || parseLong >= currentTimeMillis) {
                                    arrayList.add(new Event(parseLong, readLine.substring(indexOf + 1)));
                                }
                            }
                        } else {
                            try {
                                break;
                            } catch (IOException e3) {
                                Timber.tag(TAG).e(e3);
                            }
                        }
                    }
                    fileInputStream2.close();
                    Timber.tag(TAG).d("Restored %d events from %s", Integer.valueOf(arrayList.size()), file.getPath());
                    return arrayList;
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream = fileInputStream2;
                    try {
                        Timber.tag(TAG).e(e);
                        if (fileInputStream != null) {
                        }
                        Timber.tag(TAG).d("Restored %d events from %s", Integer.valueOf(arrayList.size()), file.getPath());
                        return arrayList;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                }
            } catch (IOException e5) {
                e = e5;
                Timber.tag(TAG).e(e);
                if (fileInputStream != null) {
                }
                Timber.tag(TAG).d("Restored %d events from %s", Integer.valueOf(arrayList.size()), file.getPath());
                return arrayList;
            }
        } catch (IOException e6) {
            e = e6;
            Timber.tag(TAG).e(e);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            Timber.tag(TAG).d("Restored %d events from %s", Integer.valueOf(arrayList.size()), file.getPath());
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cd A[SYNTHETIC, Splitter:B:37:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00df A[SYNTHETIC, Splitter:B:43:0x00df] */
    public final File writeEventFile(List<Event> list) {
        FileWriter fileWriter;
        IOException e;
        FileWriter fileWriter2 = null;
        if (list.isEmpty()) {
            return null;
        }
        File file = this.mCacheDir;
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("events_");
        outline15.append(list.get(list.size() - 1).mTimestamp);
        File file2 = new File(file, outline15.toString());
        try {
            fileWriter = new FileWriter(file2);
            try {
                fileWriter.append((CharSequence) DiskLruCache.VERSION_1).append((CharSequence) "\n");
                long currentTimeMillis = System.currentTimeMillis() - this.mMaxAge;
                boolean z = false;
                for (Event event : list) {
                    if (this.mMaxAge <= 0 || event.mTimestamp >= currentTimeMillis) {
                        fileWriter.append((CharSequence) String.valueOf(event.mTimestamp)).append((CharSequence) " ").append((CharSequence) event.mQuery).append((CharSequence) "\n");
                        z = true;
                    }
                }
                try {
                    fileWriter.close();
                } catch (IOException e2) {
                    Timber.tag(TAG).e(e2);
                }
                Timber.tag(TAG).d("Saved %d events to %s", Integer.valueOf(list.size()), file2.getPath());
                if (z) {
                    return file2;
                }
                file2.delete();
                return null;
            } catch (IOException e3) {
                e = e3;
                try {
                    Timber.tag(TAG).e(e);
                    file2.deleteOnExit();
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                            Timber.tag(TAG).e(e4);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileWriter2 = fileWriter;
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (IOException e5) {
                            Timber.tag(TAG).e(e5);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileWriter = null;
            Timber.tag(TAG).e(e);
            file2.deleteOnExit();
            if (fileWriter != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (fileWriter2 != null) {
            }
            throw th;
        }
    }
}
