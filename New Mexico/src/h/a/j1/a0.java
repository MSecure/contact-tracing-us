package h.a.j1;

import f.b.a.c.b.o.b;
import h.a.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class a0 {
    public ArrayList<a> a = new ArrayList<>();
    public volatile n b = n.IDLE;

    /* loaded from: classes.dex */
    public static final class a {
        public final Runnable a;
        public final Executor b;

        public a(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    public void a(n nVar) {
        b.A(nVar, "newState");
        if (this.b != nVar && this.b != n.SHUTDOWN) {
            this.b = nVar;
            if (!this.a.isEmpty()) {
                ArrayList<a> arrayList = this.a;
                this.a = new ArrayList<>();
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    next.b.execute(next.a);
                }
            }
        }
    }
}
