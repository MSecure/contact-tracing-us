package f.b.b.f.a;

import f.b.b.f.a.l;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class b0<V> extends l.a<V> {

    /* renamed from: i  reason: collision with root package name */
    public u<V> f2934i;

    /* renamed from: j  reason: collision with root package name */
    public ScheduledFuture<?> f2935j;

    public static final class b<V> implements Runnable {
        public b0<V> b;

        public b(b0<V> b0Var) {
            this.b = b0Var;
        }

        public void run() {
            u<V> uVar;
            b0<V> b0Var = this.b;
            if (b0Var != null && (uVar = b0Var.f2934i) != null) {
                this.b = null;
                if (uVar.isDone()) {
                    b0Var.v(uVar);
                    return;
                }
                try {
                    ScheduledFuture<?> scheduledFuture = b0Var.f2935j;
                    b0Var.f2935j = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        try {
                            long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                            if (abs > 10) {
                                str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                            }
                        } catch (Throwable th) {
                            b0Var.u(new c(str, null));
                            throw th;
                        }
                    }
                    b0Var.u(new c(str + ": " + uVar, null));
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
        Objects.requireNonNull(uVar);
        this.f2934i = uVar;
    }

    @Override // f.b.b.f.a.b
    public void j() {
        q(this.f2934i);
        ScheduledFuture<?> scheduledFuture = this.f2935j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f2934i = null;
        this.f2935j = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        u<V> uVar = this.f2934i;
        ScheduledFuture<?> scheduledFuture = this.f2935j;
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
