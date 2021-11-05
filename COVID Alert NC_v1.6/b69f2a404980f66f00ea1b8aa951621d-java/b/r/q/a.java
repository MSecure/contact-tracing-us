package b.r.q;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, Lock> f1681e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final File f1682a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f1683b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1684c;

    /* renamed from: d  reason: collision with root package name */
    public FileChannel f1685d;

    public a(String str, File file, boolean z) {
        Lock lock;
        File file2 = new File(file, c.a.a.a.a.o(str, ".lck"));
        this.f1682a = file2;
        String absolutePath = file2.getAbsolutePath();
        synchronized (f1681e) {
            lock = f1681e.get(absolutePath);
            if (lock == null) {
                lock = new ReentrantLock();
                f1681e.put(absolutePath, lock);
            }
        }
        this.f1683b = lock;
        this.f1684c = z;
    }

    public void a() {
        FileChannel fileChannel = this.f1685d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f1683b.unlock();
    }
}
