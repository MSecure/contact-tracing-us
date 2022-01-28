package io.realm.internal.async;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class RealmThreadPoolExecutor extends ThreadPoolExecutor {
    public static final int CORE_POOL_SIZE;
    public ReentrantLock pauseLock;
    public Condition unpaused;

    static {
        final Pattern compile = Pattern.compile("cpu[0-9]+");
        int i = 0;
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                /* class io.realm.internal.async.RealmThreadPoolExecutor.AnonymousClass1 */

                public boolean accept(File file) {
                    return compile.matcher(file.getName()).matches();
                }
            });
            if (listFiles != null) {
                i = listFiles.length;
            }
        } catch (SecurityException unused) {
        }
        if (i <= 0) {
            i = Runtime.getRuntime().availableProcessors();
        }
        int i2 = 1;
        if (i > 0) {
            i2 = 1 + (i * 2);
        }
        CORE_POOL_SIZE = i2;
    }

    public RealmThreadPoolExecutor(int i, int i2) {
        super(i, i2, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
        ReentrantLock reentrantLock = new ReentrantLock();
        this.pauseLock = reentrantLock;
        this.unpaused = reentrantLock.newCondition();
    }

    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.pauseLock.lock();
        this.pauseLock.unlock();
    }
}
