package f.b.c.k.t;

import f.b.c.k.x.c;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class v {
    public static final long c;

    /* renamed from: d */
    public static final long f3622d;
    public final u a;
    public final a b;

    /* loaded from: classes.dex */
    public static class a {
        public final long a;

        public a(long j2, int i2, int i3) {
            this.a = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public b(boolean z, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static final /* synthetic */ int c;
        public final PriorityQueue<Long> a;
        public final int b;

        public c(int i2) {
            this.b = i2;
            this.a = new PriorityQueue<>(i2, w.a);
        }

        public void a(Long l2) {
            if (this.a.size() >= this.b) {
                if (l2.longValue() < this.a.peek().longValue()) {
                    this.a.poll();
                } else {
                    return;
                }
            }
            this.a.add(l2);
        }
    }

    /* loaded from: classes.dex */
    public class d implements d {
        public final f.b.c.k.x.c a;
        public final r b;
        public boolean c = false;

        public d(f.b.c.k.x.c cVar, r rVar) {
            v.this = r1;
            this.a = cVar;
            this.b = rVar;
        }

        public final void a() {
            long j2;
            if (this.c) {
                j2 = v.f3622d;
            } else {
                j2 = v.c;
            }
            this.a.a(c.d.GARBAGE_COLLECTION, j2, new x(this));
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        c = timeUnit.toMillis(1);
        f3622d = timeUnit.toMillis(5);
    }

    public v(u uVar, a aVar) {
        this.a = uVar;
        this.b = aVar;
    }
}
