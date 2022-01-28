package c.b.a.a.d.k.o;

import c.b.a.a.d.o.d.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f3001a;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("GAC_Transform"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f3001a = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
