package h.a.j1;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class h implements l1 {
    public final AtomicLong a = new AtomicLong();

    @Override // h.a.j1.l1
    public void a(long j2) {
        this.a.getAndAdd(j2);
    }
}
