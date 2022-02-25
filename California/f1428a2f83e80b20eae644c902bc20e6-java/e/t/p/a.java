package e.t.p;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, Lock> f1887e = new HashMap();
    public final File a;
    public final Lock b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public FileChannel f1888d;

    public a(String str, File file, boolean z) {
        Lock lock;
        File file2 = new File(file, f.a.a.a.a.t(str, ".lck"));
        this.a = file2;
        String absolutePath = file2.getAbsolutePath();
        Map<String, Lock> map = f1887e;
        synchronized (map) {
            lock = map.get(absolutePath);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(absolutePath, lock);
            }
        }
        this.b = lock;
        this.c = z;
    }

    public void a() {
        FileChannel fileChannel = this.f1888d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.b.unlock();
    }
}
