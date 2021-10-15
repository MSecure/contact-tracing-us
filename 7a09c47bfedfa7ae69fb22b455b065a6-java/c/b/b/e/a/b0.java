package c.b.b.e.a;

import c.b.b.e.a.l;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class b0<V> extends l.a<V> {
    public u<V> i;
    public ScheduledFuture<?> j;

    public static final class b<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public b0<V> f4745b;

        public b(b0<V> b0Var) {
            this.f4745b = b0Var;
        }

        public void run() {
            u<V> uVar;
            b0<V> b0Var = this.f4745b;
            if (b0Var != null && (uVar = b0Var.i) != null) {
                this.f4745b = null;
                if (uVar.isDone()) {
                    b0Var.o(uVar);
                    return;
                }
                try {
                    ScheduledFuture<?> scheduledFuture = b0Var.j;
                    b0Var.j = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        try {
                            long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                            if (abs > 10) {
                                str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                            }
                        } catch (Throwable th) {
                            b0Var.n(new c(str, null));
                            throw th;
                        }
                    }
                    b0Var.n(new c(str + ": " + uVar, null));
                } finally {
                    uVar.cancel(true);
                }
            }
        }
    }

    public static final class c extends TimeoutException {
        public c(String str, a aVar) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    public b0(u<V> uVar) {
        if (uVar != null) {
            this.i = uVar;
            return;
        }
        throw null;
    }

    @Override // c.b.b.e.a.b
    public void c() {
        j(this.i);
        ScheduledFuture<?> scheduledFuture = this.j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.i = null;
        this.j = null;
    }

    @Override // c.b.b.e.a.b
    public String k() {
        u<V> uVar = this.i;
        ScheduledFuture<?> scheduledFuture = this.j;
        if (uVar == null) {
            return null;
        }
        String str = "inputFuture=[" + uVar + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
