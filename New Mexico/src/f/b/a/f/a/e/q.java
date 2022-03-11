package f.b.a.f.a.e;

import java.io.InputStream;
/* loaded from: classes.dex */
public final class q extends p {
    public final p b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3367d;

    public q(p pVar, long j2, long j3) {
        this.b = pVar;
        long t = t(j2);
        this.c = t;
        this.f3367d = t(t + j3);
    }

    @Override // f.b.a.f.a.e.p
    public final long c() {
        return this.f3367d - this.c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // f.b.a.f.a.e.p
    public final InputStream d(long j2, long j3) {
        long t = t(this.c);
        return this.b.d(t, t(j3 + t) - t);
    }

    public final long t(long j2) {
        if (j2 < 0) {
            return 0;
        }
        return j2 > this.b.c() ? this.b.c() : j2;
    }
}
