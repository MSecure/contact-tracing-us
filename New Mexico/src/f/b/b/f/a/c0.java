package f.b.b.f.a;

import f.b.b.f.a.l;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class c0<V> extends l.a<V> {

    /* renamed from: i  reason: collision with root package name */
    public u<V> f3443i;

    /* renamed from: j  reason: collision with root package name */
    public ScheduledFuture<?> f3444j;

    /* loaded from: classes.dex */
    public static final class b<V> implements Runnable {
        public c0<V> b;

        public b(c0<V> c0Var) {
            this.b = c0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            u<V> uVar;
            c0<V> c0Var = this.b;
            if (c0Var != null && (uVar = c0Var.f3443i) != null) {
                this.b = null;
                if (uVar.isDone()) {
                    c0Var.v(uVar);
                    return;
                }
                try {
                    ScheduledFuture<?> scheduledFuture = c0Var.f3444j;
                    c0Var.f3444j = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                        }
                    }
                    c0Var.u(new c(str + ": " + uVar, null));
                } finally {
                    uVar.cancel(true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends TimeoutException {
        public c(String str, a aVar) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    public c0(u<V> uVar) {
        Objects.requireNonNull(uVar);
        this.f3443i = uVar;
    }

    @Override // f.b.b.f.a.b
    public void j() {
        q(this.f3443i);
        ScheduledFuture<?> scheduledFuture = this.f3444j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f3443i = null;
        this.f3444j = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        u<V> uVar = this.f3443i;
        ScheduledFuture<?> scheduledFuture = this.f3444j;
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
