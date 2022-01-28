package c.b.a.a.g;

import java.util.ArrayDeque;
import java.util.Queue;

public final class y<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2894a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Queue<x<TResult>> f2895b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2896c;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r1 = r2.f2894a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = r2.f2895b.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        r2.f2896c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        r0.a(r3);
     */
    public final void a(h<TResult> hVar) {
        synchronized (this.f2894a) {
            if (this.f2895b != null) {
                if (!this.f2896c) {
                    this.f2896c = true;
                }
            }
        }
    }

    public final void b(x<TResult> xVar) {
        synchronized (this.f2894a) {
            if (this.f2895b == null) {
                this.f2895b = new ArrayDeque();
            }
            this.f2895b.add(xVar);
        }
    }
}
