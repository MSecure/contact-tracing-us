package com.bugfender.sdk.a.a.m;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class a {
    public static final long b = TimeUnit.SECONDS.toMillis(12);
    private Timer a;

    /* renamed from: com.bugfender.sdk.a.a.m.a$a  reason: collision with other inner class name */
    public static class C0013a extends c {
        private final c a;

        public C0013a(c cVar) {
            this.a = cVar;
        }

        @Override // com.bugfender.sdk.a.a.m.a.c
        public void a() {
            this.a.a();
        }

        @Override // com.bugfender.sdk.a.a.m.a.c
        public void a(Exception exc) {
            this.a.a(exc);
        }
    }

    public static abstract class c extends TimerTask {
        public abstract void a();

        public abstract void a(Exception exc);

        public void run() {
            try {
                a();
            } catch (Exception e) {
                a(e);
            }
        }
    }

    public void a(long j, c cVar) {
        Timer timer = new Timer();
        this.a = timer;
        timer.schedule(cVar, j, j);
    }

    public void a() {
        Timer timer = this.a;
        if (timer != null) {
            timer.cancel();
            this.a = null;
        }
    }

    public static abstract class b extends c {
        private final Random a = new Random();
        final long b = a.b;
        int c = 0;

        private void d() {
            int i = this.c + 1;
            this.c = i;
            a(a(i, this.b));
        }

        @Override // com.bugfender.sdk.a.a.m.a.c
        public void a() {
            b();
            if (this.c > 0) {
                c();
                a(a.b);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void a(long j);

        public abstract void b();

        public void c() {
            this.c = 0;
        }

        @Override // com.bugfender.sdk.a.a.m.a.c
        public void a(Exception exc) {
            if (exc instanceof com.bugfender.sdk.a.a.i.c.a.a) {
                d();
            } else {
                exc.printStackTrace();
            }
        }

        public long a(int i, long j) {
            long pow = (long) (((double) (j / 1000)) * Math.pow(2.0d, (double) Math.min(i, 15)));
            double nextDouble = this.a.nextDouble() * ((double) Math.min(pow, 18000L));
            return ((long) Math.min(((double) pow) + nextDouble, nextDouble + 43200.0d)) * 1000;
        }
    }
}
