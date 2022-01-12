package kotlinx.coroutines;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonPool.kt */
public final class CommonPool extends ExecutorCoroutineDispatcher {
    public static final CommonPool INSTANCE = new CommonPool();
    public static volatile Executor pool;
    public static final int requestedParallelism;

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0076 A[SYNTHETIC] */
    static {
        String str;
        int i;
        int i2;
        int digit;
        int i3;
        Integer num = null;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        int i4 = -1;
        if (str != null) {
            Intrinsics.checkNotNullParameter(str, "$this$toIntOrNull");
            Intrinsics.checkNotNullParameter(str, "$this$toIntOrNull");
            MoreExecutors.checkRadix(10);
            int length = str.length();
            if (length != 0) {
                int i5 = 0;
                char charAt = str.charAt(0);
                if (charAt >= '0') {
                    i4 = charAt == '0' ? 0 : 1;
                }
                int i6 = -2147483647;
                if (i4 >= 0) {
                    i2 = 0;
                } else if (length != 1) {
                    if (charAt == '-') {
                        i6 = RecyclerView.UNDEFINED_DURATION;
                        i2 = 1;
                    } else if (charAt == '+') {
                        i2 = 1;
                        i = 0;
                        int i7 = -59652323;
                        while (true) {
                            if (i2 >= length) {
                                digit = Character.digit((int) str.charAt(i2), 10);
                                if (digit < 0 || ((i5 < i7 && (i7 != -59652323 || i5 < (i7 = i6 / 10))) || (i3 = i5 * 10) < i6 + digit)) {
                                    break;
                                }
                                i5 = i3 - digit;
                                i2++;
                            } else {
                                if (i == 0) {
                                    i5 = -i5;
                                }
                                num = Integer.valueOf(i5);
                            }
                        }
                    }
                }
                i = i2;
                int i72 = -59652323;
                while (true) {
                    if (i2 >= length) {
                    }
                    i5 = i3 - digit;
                    i2++;
                }
            }
            if (num == null || num.intValue() < 1) {
                throw new IllegalStateException(GeneratedOutlineSupport.outline10("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
            i4 = num.intValue();
        }
        requestedParallelism = i4;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    public final ExecutorService createPlainPool() {
        return Executors.newFixedThreadPool(getParallelism(), new CommonPool$createPlainPool$1(new AtomicInteger()));
    }

    public final ExecutorService createPool() {
        Class<?> cls;
        ExecutorService executorService;
        Integer num;
        if (System.getSecurityManager() != null) {
            return createPlainPool();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return createPlainPool();
        }
        if (requestedParallelism < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(invoke instanceof ExecutorService)) {
                    invoke = null;
                }
                executorService = (ExecutorService) invoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                if (INSTANCE != null) {
                    executorService.submit(CommonPool$isGoodCommonPool$1.INSTANCE);
                    try {
                        Object invoke2 = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
                        if (!(invoke2 instanceof Integer)) {
                            invoke2 = null;
                        }
                        num = (Integer) invoke2;
                    } catch (Throwable unused3) {
                        num = null;
                    }
                    if (!(num != null && num.intValue() >= 1)) {
                        executorService = null;
                    }
                    if (executorService != null) {
                        return executorService;
                    }
                } else {
                    throw null;
                }
            }
        }
        try {
            Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(INSTANCE.getParallelism()));
            if (!(newInstance instanceof ExecutorService)) {
                newInstance = null;
            }
            executorService2 = (ExecutorService) newInstance;
        } catch (Throwable unused4) {
        }
        if (executorService2 != null) {
            return executorService2;
        }
        return createPlainPool();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor executor = pool;
            if (executor == null) {
                synchronized (this) {
                    executor = pool;
                    if (executor == null) {
                        executor = createPool();
                        pool = executor;
                    }
                }
            }
            executor.execute(runnable);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    public final int getParallelism() {
        Integer valueOf = Integer.valueOf(requestedParallelism);
        int i = 1;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors() - 1;
        if (availableProcessors >= 1) {
            i = availableProcessors;
        }
        return i;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "CommonPool";
    }
}
