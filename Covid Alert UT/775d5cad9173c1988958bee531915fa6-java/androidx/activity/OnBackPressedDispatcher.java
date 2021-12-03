package androidx.activity;

import e.a.b;
import e.q.h;
import e.q.j;
import e.q.l;
import e.q.m;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {
    public final Runnable a;
    public final ArrayDeque<b> b = new ArrayDeque<>();

    public class LifecycleOnBackPressedCancellable implements j, e.a.a {
        public final h a;
        public final b b;
        public e.a.a c;

        public LifecycleOnBackPressedCancellable(h hVar, b bVar) {
            this.a = hVar;
            this.b = bVar;
            hVar.a(this);
        }

        @Override // e.a.a
        public void cancel() {
            m mVar = (m) this.a;
            mVar.d("removeObserver");
            mVar.a.l(this);
            this.b.b.remove(this);
            e.a.a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
                this.c = null;
            }
        }

        @Override // e.q.j
        public void d(l lVar, h.a aVar) {
            if (aVar == h.a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                b bVar = this.b;
                onBackPressedDispatcher.b.add(bVar);
                a aVar2 = new a(bVar);
                bVar.b.add(aVar2);
                this.c = aVar2;
            } else if (aVar == h.a.ON_STOP) {
                e.a.a aVar3 = this.c;
                if (aVar3 != null) {
                    aVar3.cancel();
                }
            } else if (aVar == h.a.ON_DESTROY) {
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

    public void a(l lVar, b bVar) {
        h a2 = lVar.a();
        if (((m) a2).b != h.b.DESTROYED) {
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
