package androidx.activity;

import b.a.b;
import b.l.d.q;
import b.n.f;
import b.n.g;
import b.n.i;
import b.n.j;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f11a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque<b> f12b = new ArrayDeque<>();

    public class LifecycleOnBackPressedCancellable implements g, b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final f f13a;

        /* renamed from: b  reason: collision with root package name */
        public final b f14b;

        /* renamed from: c  reason: collision with root package name */
        public b.a.a f15c;

        public LifecycleOnBackPressedCancellable(f fVar, b bVar) {
            this.f13a = fVar;
            this.f14b = bVar;
            fVar.a(this);
        }

        @Override // b.a.a
        public void cancel() {
            ((j) this.f13a).f1391a.j(this);
            this.f14b.f358b.remove(this);
            b.a.a aVar = this.f15c;
            if (aVar != null) {
                aVar.cancel();
                this.f15c = null;
            }
        }

        @Override // b.n.g
        public void d(i iVar, f.a aVar) {
            if (aVar == f.a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                b bVar = this.f14b;
                onBackPressedDispatcher.f12b.add(bVar);
                a aVar2 = new a(bVar);
                bVar.f358b.add(aVar2);
                this.f15c = aVar2;
            } else if (aVar == f.a.ON_STOP) {
                b.a.a aVar3 = this.f15c;
                if (aVar3 != null) {
                    aVar3.cancel();
                }
            } else if (aVar == f.a.ON_DESTROY) {
                cancel();
            }
        }
    }

    public class a implements b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final b f17a;

        public a(b bVar) {
            this.f17a = bVar;
        }

        @Override // b.a.a
        public void cancel() {
            OnBackPressedDispatcher.this.f12b.remove(this.f17a);
            this.f17a.f358b.remove(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f11a = runnable;
    }

    public void a() {
        Iterator<b> descendingIterator = this.f12b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.f357a) {
                q qVar = q.this;
                qVar.D(true);
                if (qVar.h.f357a) {
                    qVar.b0();
                    return;
                } else {
                    qVar.g.a();
                    return;
                }
            }
        }
        Runnable runnable = this.f11a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
