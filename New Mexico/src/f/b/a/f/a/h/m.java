package f.b.a.f.a.h;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes.dex */
public final class m<ResultT> {
    public final Object a = new Object();
    public Queue<l<ResultT>> b;
    public boolean c;

    public final void a(l<ResultT> lVar) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(lVar);
        }
    }

    public final void b(r<ResultT> rVar) {
        l<ResultT> poll;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        poll = this.b.poll();
                        if (poll == null) {
                            this.c = false;
                            return;
                        }
                    }
                    poll.a(rVar);
                }
            }
        }
    }
}
