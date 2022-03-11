package e.v.p;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, Lock> f2095e = new HashMap();
    public final File a;
    public final Lock b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public FileChannel f2096d;

    public a(String str, File file, boolean z) {
        Lock lock;
        File file2 = new File(file, f.a.a.a.a.x(str, ".lck"));
        this.a = file2;
        String absolutePath = file2.getAbsolutePath();
        Map<String, Lock> map = f2095e;
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
        FileChannel fileChannel = this.f2096d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.b.unlock();
    }
}
