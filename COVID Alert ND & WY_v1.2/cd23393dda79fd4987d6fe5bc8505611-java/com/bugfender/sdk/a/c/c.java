package com.bugfender.sdk.a.c;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c {
    private final ThreadPoolExecutor a;
    private final int b;
    private final int c;
    private boolean d = true;
    private int e;
    private final AbstractC0018c f;
    private final b g;

    /* access modifiers changed from: private */
    public static class b {
        private float a;
        private final Handler b;
        private final Runnable c;
        private boolean d;

        class a implements Runnable {
            a() {
            }

            public void run() {
                long maxMemory = Runtime.getRuntime().maxMemory();
                b.this.a = (1.0f - (((float) Runtime.getRuntime().totalMemory()) / ((float) maxMemory))) * 100.0f;
                b.this.b.postDelayed(b.this.c, TimeUnit.SECONDS.toMillis(1));
            }
        }

        private b() {
            this.a = 100.0f;
            this.b = new Handler();
            this.c = new a();
            this.d = false;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.d) {
                this.b.removeCallbacksAndMessages(null);
                this.d = false;
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (!this.d) {
                this.d = true;
                this.c.run();
            }
        }

        /* access modifiers changed from: package-private */
        public float a() {
            return this.a;
        }
    }

    /* renamed from: com.bugfender.sdk.a.c.c$c  reason: collision with other inner class name */
    public interface AbstractC0018c {
        void a(ThreadPoolExecutor threadPoolExecutor, boolean z);
    }

    public c(ThreadPoolExecutor threadPoolExecutor, int i, int i2, AbstractC0018c cVar) {
        this.a = threadPoolExecutor;
        this.b = i;
        this.c = i2;
        this.f = cVar;
        this.g = new b();
    }

    private float b() {
        this.g.b();
        return this.g.a();
    }

    private void c() {
        int size = this.a.getQueue().size();
        if (this.d && size >= this.b && b() < ((float) this.c)) {
            this.e = size;
            this.d = false;
            AbstractC0018c cVar = this.f;
            if (cVar != null) {
                cVar.a(this.a, true);
            }
        } else if (!this.d && size < this.e / 2) {
            this.d = true;
            this.g.c();
            AbstractC0018c cVar2 = this.f;
            if (cVar2 != null) {
                cVar2.a(this.a, true ^ this.d);
            }
        }
    }

    public synchronized <T> Future<T> a(Callable<T> callable) {
        c();
        if (!this.d) {
            return null;
        }
        return this.a.submit(callable);
    }

    public void a() {
        ThreadPoolExecutor threadPoolExecutor = this.a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
