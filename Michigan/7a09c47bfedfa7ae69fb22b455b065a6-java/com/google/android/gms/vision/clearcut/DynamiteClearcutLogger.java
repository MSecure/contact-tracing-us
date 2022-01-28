package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import c.b.a.a.g.h.v;
import c.b.a.a.k.a.a;
import c.b.a.a.k.a.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
public class DynamiteClearcutLogger {
    public static final ExecutorService zzbv;
    public b zzbw = new b();
    public VisionClearcutLogger zzbx;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        zzbv = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public DynamiteClearcutLogger(Context context) {
        this.zzbx = new VisionClearcutLogger(context);
    }

    public final void zza(int i, v vVar) {
        boolean z;
        if (i == 3) {
            b bVar = this.zzbw;
            synchronized (bVar.f4156b) {
                long currentTimeMillis = System.currentTimeMillis();
                if (bVar.f4157c + bVar.f4155a > currentTimeMillis) {
                    z = false;
                } else {
                    bVar.f4157c = currentTimeMillis;
                    z = true;
                }
            }
            if (!z) {
                Object[] objArr = new Object[0];
                if (Log.isLoggable("Vision", 2)) {
                    String.format("Skipping image analysis log due to rate limiting", objArr);
                    return;
                }
                return;
            }
        }
        zzbv.execute(new a(this, i, vVar));
    }
}
