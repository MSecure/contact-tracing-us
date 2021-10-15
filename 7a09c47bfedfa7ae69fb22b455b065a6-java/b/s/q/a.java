package b.s.q;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, Lock> f2551e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final File f2552a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f2553b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f2554c;

    /* renamed from: d  reason: collision with root package name */
    public FileChannel f2555d;

    public a(String str, File file, boolean z) {
        Lock lock;
        File file2 = new File(file, c.a.a.a.a.q(str, ".lck"));
        this.f2552a = file2;
        String absolutePath = file2.getAbsolutePath();
        synchronized (f2551e) {
            lock = f2551e.get(absolutePath);
            if (lock == null) {
                lock = new ReentrantLock();
                f2551e.put(absolutePath, lock);
            }
        }
        this.f2553b = lock;
        this.f2554c = z;
    }

    public void a() {
        FileChannel fileChannel = this.f2555d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f2553b.unlock();
    }
}
