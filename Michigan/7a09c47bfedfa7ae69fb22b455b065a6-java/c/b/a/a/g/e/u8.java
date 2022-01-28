package c.b.a.a.g.e;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class u8 {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f3755a;

    /* renamed from: b  reason: collision with root package name */
    public volatile InputStream f3756b = null;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f3757c = false;

    public u8() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f3755a = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public static void a(OutputStream outputStream, boolean z, long j) {
        try {
            outputStream.write(z ? 1 : 0);
        } catch (IOException unused) {
            String.format("Unable to deliver status for Payload %d", Long.valueOf(j));
            if (outputStream == null) {
                return;
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
        try {
            outputStream.close();
        } catch (IOException unused3) {
        }
    }
}
