package f.b.b.f.a;

import f.b.b.f.a.l;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class c0<V> extends l.a<V> {

    /* renamed from: i  reason: collision with root package name */
    public u<V> f3031i;

    /* renamed from: j  reason: collision with root package name */
    public ScheduledFuture<?> f3032j;

    public static final class b<V> implements Runnable {
        public c0<V> b;

        public b(c0<V> c0Var) {
            this.b = c0Var;
        }

        public void run() {
            u<V> uVar;
            c0<V> c0Var = this.b;
            if (c0Var != null && (uVar = c0Var.f3031i) != null) {
                this.b = null;
                if (uVar.isDone()) {
                    c0Var.v(uVar);
                    return;
                }
                try {
                    ScheduledFuture<?> scheduledFuture = c0Var.f3032j;
                    c0Var.f3032j = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        try {
                            long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                            if (abs > 10) {
                                str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                            }
                        } catch (Throwable th) {
                            c0Var.u(new c(str, null));
                            throw th;
                        }
                    }
                    c0Var.u(new c(str + ": " + uVar, null));
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

    public c0(u<V> uVar) {
        Objects.requireNonNull(uVar);
        this.f3031i = uVar;
    }

    @Override // f.b.b.f.a.b
    public void j() {
        q(this.f3031i);
        ScheduledFuture<?> scheduledFuture = this.f3032j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f3031i = null;
        this.f3032j = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        u<V> uVar = this.f3031i;
        ScheduledFuture<?> scheduledFuture = this.f3032j;
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
