package androidx.activity;

import e.a.b;
import e.p.g;
import e.p.h;
import e.p.j;
import e.p.k;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {
    public final Runnable a;
    public final ArrayDeque<b> b = new ArrayDeque<>();

    public class LifecycleOnBackPressedCancellable implements h, e.a.a {
        public final g a;
        public final b b;
        public e.a.a c;

        public LifecycleOnBackPressedCancellable(g gVar, b bVar) {
            this.a = gVar;
            this.b = bVar;
            gVar.a(this);
        }

        @Override // e.a.a
        public void cancel() {
            k kVar = (k) this.a;
            kVar.d("removeObserver");
            kVar.a.l(this);
            this.b.b.remove(this);
            e.a.a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
                this.c = null;
            }
        }

        @Override // e.p.h
        public void d(j jVar, g.a aVar) {
            if (aVar == g.a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                b bVar = this.b;
                onBackPressedDispatcher.b.add(bVar);
                a aVar2 = new a(bVar);
                bVar.b.add(aVar2);
                this.c = aVar2;
            } else if (aVar == g.a.ON_STOP) {
                e.a.a aVar3 = this.c;
                if (aVar3 != null) {
                    aVar3.cancel();
                }
            } else if (aVar == g.a.ON_DESTROY) {
                cancel();
            }
        }
    }

    public class a implements e.a.a {
        public final b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // e.a.a
        public void cancel() {
            OnBackPressedDispatcher.this.b.remove(this.a);
            this.a.b.remove(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.a = runnable;
    }

    public void a(j jVar, b bVar) {
        g a2 = jVar.a();
        if (((k) a2).b != g.b.DESTROYED) {
            bVar.b.add(new LifecycleOnBackPressedCancellable(a2, bVar));
        }
    }

    public void b() {
        Iterator<b> descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.a) {
                next.a();
                return;
            }
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
