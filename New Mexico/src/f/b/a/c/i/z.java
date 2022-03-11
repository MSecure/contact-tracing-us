package f.b.a.c.i;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes.dex */
public final class z<TResult> {
    public final Object a = new Object();
    public Queue<a0<TResult>> b;
    public boolean c;

    public final void a(h<TResult> hVar) {
        a0<TResult> poll;
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
                    poll.c(hVar);
                }
            }
        }
    }

    public final void b(a0<TResult> a0Var) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(a0Var);
        }
    }
}
