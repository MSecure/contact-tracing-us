package com.bugfender.sdk.a.a.f;

import android.os.Process;
import android.text.TextUtils;
import com.bugfender.sdk.a.a.f.a;
import com.bugfender.sdk.a.a.h.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class c implements b {
    private final com.bugfender.sdk.a.a.b a;
    private final String b;
    private final int c;
    private final ExecutorService d;
    private Future<?> e = null;

    class a implements a.AbstractC0004a {
        a() {
        }

        @Override // com.bugfender.sdk.a.a.f.a.AbstractC0004a
        public void a(String str) {
            try {
                com.bugfender.sdk.a.a.f.e.a a2 = com.bugfender.sdk.a.a.f.e.a.a(str, c.this.c);
                if (!TextUtils.isEmpty(a2.b())) {
                    c.this.a((c) a2);
                }
            } catch (com.bugfender.sdk.a.a.f.d.a unused) {
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ a a;

        b(a aVar) {
            this.a = aVar;
        }

        public void run() {
            if (c.this.e.isDone() || c.this.e.isCancelled()) {
                c.this.a.a(0, "logcat", "logcat", g.c.c, com.bugfender.sdk.a.a.b.E, "Logcat process has exited prematurely, restarting it in 5 minutes to continue delivering the logs. During this time logs will not be collected.");
                c cVar = c.this;
                cVar.e = cVar.d.submit(this.a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.bugfender.sdk.a.a.f.c$c  reason: collision with other inner class name */
    public static /* synthetic */ class C0005c {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[com.bugfender.sdk.a.a.f.e.b.values().length];
            a = iArr;
            iArr[com.bugfender.sdk.a.a.f.e.b.VERBOSE.ordinal()] = 1;
            a[com.bugfender.sdk.a.a.f.e.b.DEBUG.ordinal()] = 2;
            a[com.bugfender.sdk.a.a.f.e.b.INFO.ordinal()] = 3;
            a[com.bugfender.sdk.a.a.f.e.b.WARNING.ordinal()] = 4;
            a[com.bugfender.sdk.a.a.f.e.b.ERROR.ordinal()] = 5;
            a[com.bugfender.sdk.a.a.f.e.b.ASSERT.ordinal()] = 6;
            try {
                a[com.bugfender.sdk.a.a.f.e.b.WTF.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public c(String str, com.bugfender.sdk.a.a.b bVar, ExecutorService executorService) {
        this.b = str;
        this.a = bVar;
        this.c = Process.myPid();
        this.d = executorService;
    }

    @Override // com.bugfender.sdk.a.a.f.b
    public void a() {
        a aVar = new a();
        a aVar2 = new a(this.b);
        aVar2.a(aVar);
        this.e = this.d.submit(aVar2);
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new b(aVar2), 1, 5, TimeUnit.MINUTES);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(com.bugfender.sdk.a.a.f.e.a aVar) {
        if (!aVar.c().startsWith("BF/")) {
            switch (C0005c.a[aVar.a().ordinal()]) {
                case 1:
                    this.a.a(0, "logcat", "Logcat", g.c.e, aVar.c(), aVar.b());
                    return;
                case 2:
                    this.a.a(0, "logcat", "Logcat", g.c.D, aVar.c(), aVar.b());
                    return;
                case 3:
                    this.a.a(0, "logcat", "Logcat", g.c.I, aVar.c(), aVar.b());
                    return;
                case 4:
                    this.a.a(0, "logcat", "Logcat", g.c.c, aVar.c(), aVar.b());
                    return;
                case 5:
                    this.a.a(0, "logcat", "Logcat", g.c.d, aVar.c(), aVar.b());
                    return;
                case 6:
                    this.a.a(0, "logcat", "Logcat", g.c.D, aVar.c(), aVar.b());
                    return;
                case 7:
                    this.a.a(0, "logcat", "Logcat", g.c.F, aVar.c(), aVar.b());
                    return;
                default:
                    return;
            }
        }
    }
}
