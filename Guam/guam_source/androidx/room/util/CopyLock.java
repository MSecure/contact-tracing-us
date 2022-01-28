package androidx.room.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CopyLock {
    public static final Map<String, Lock> sThreadLocks = new HashMap();
    public final File mCopyLockFile;
    public final boolean mFileLevelLock;
    public FileChannel mLockChannel;
    public final Lock mThreadLock;

    public CopyLock(String str, File file, boolean z) {
        Lock lock;
        File file2 = new File(file, GeneratedOutlineSupport.outline8(str, ".lck"));
        this.mCopyLockFile = file2;
        String absolutePath = file2.getAbsolutePath();
        synchronized (sThreadLocks) {
            lock = sThreadLocks.get(absolutePath);
            if (lock == null) {
                lock = new ReentrantLock();
                sThreadLocks.put(absolutePath, lock);
            }
        }
        this.mThreadLock = lock;
        this.mFileLevelLock = z;
    }

    public void unlock() {
        FileChannel fileChannel = this.mLockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.mThreadLock.unlock();
    }
}
