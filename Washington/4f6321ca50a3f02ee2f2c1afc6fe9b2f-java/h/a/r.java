package h.a;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class r implements Comparable<r> {

    /* renamed from: e  reason: collision with root package name */
    public static final b f3981e = new b(null);

    /* renamed from: f  reason: collision with root package name */
    public static final long f3982f;

    /* renamed from: g  reason: collision with root package name */
    public static final long f3983g;

    /* renamed from: h  reason: collision with root package name */
    public static final long f3984h = TimeUnit.SECONDS.toNanos(1);
    public final c b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f3985d;

    public static class b extends c {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public static abstract class c {
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500);
        f3982f = nanos;
        f3983g = -nanos;
    }

    public r(c cVar, long j2, boolean z) {
        Objects.requireNonNull((b) cVar);
        long nanoTime = System.nanoTime();
        this.b = cVar;
        long min = Math.min(f3982f, Math.max(f3983g, j2));
        this.c = nanoTime + min;
        this.f3985d = z && min <= 0;
    }

    public final void a(r rVar) {
        if (this.b != rVar.b) {
            StringBuilder h2 = f.a.a.a.a.h("Tickers (");
            h2.append(this.b);
            h2.append(" and ");
            h2.append(rVar.b);
            h2.append(") don't match. Custom Ticker should only be used in tests!");
            throw new AssertionError(h2.toString());
        }
    }

    /* renamed from: b */
    public int compareTo(r rVar) {
        a(rVar);
        int i2 = ((this.c - rVar.c) > 0 ? 1 : ((this.c - rVar.c) == 0 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public boolean c() {
        if (!this.f3985d) {
            long j2 = this.c;
            Objects.requireNonNull((b) this.b);
            if (j2 - System.nanoTime() > 0) {
                return false;
            }
            this.f3985d = true;
        }
        return true;
    }

    public long e(TimeUnit timeUnit) {
        Objects.requireNonNull((b) this.b);
        long nanoTime = System.nanoTime();
        if (!this.f3985d && this.c - nanoTime <= 0) {
            this.f3985d = true;
        }
        return timeUnit.convert(this.c - nanoTime, TimeUnit.NANOSECONDS);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        c cVar = this.b;
        if (cVar != null ? cVar == rVar.b : rVar.b == null) {
            return this.c == rVar.c;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.asList(this.b, Long.valueOf(this.c)).hashCode();
    }

    public String toString() {
        long e2 = e(TimeUnit.NANOSECONDS);
        long abs = Math.abs(e2);
        long j2 = f3984h;
        long j3 = abs / j2;
        long abs2 = Math.abs(e2) % j2;
        StringBuilder sb = new StringBuilder();
        if (e2 < 0) {
            sb.append('-');
        }
        sb.append(j3);
        if (abs2 > 0) {
            sb.append(String.format(".%09d", Long.valueOf(abs2)));
        }
        sb.append("s from now");
        if (this.b != f3981e) {
            StringBuilder h2 = f.a.a.a.a.h(" (ticker=");
            h2.append(this.b);
            h2.append(")");
            sb.append(h2.toString());
        }
        return sb.toString();
    }
}
