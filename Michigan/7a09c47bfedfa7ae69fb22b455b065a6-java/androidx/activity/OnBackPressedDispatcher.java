package androidx.activity;

import b.a.b;
import b.l.d.z;
import b.o.f;
import b.o.g;
import b.o.i;
import b.o.j;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f18a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque<b> f19b = new ArrayDeque<>();

    public class LifecycleOnBackPressedCancellable implements g, b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final f f20a;

        /* renamed from: b  reason: collision with root package name */
        public final b f21b;

        /* renamed from: c  reason: collision with root package name */
        public b.a.a f22c;

        public LifecycleOnBackPressedCancellable(f fVar, b bVar) {
            this.f20a = fVar;
            this.f21b = bVar;
            fVar.a(this);
        }

        @Override // b.a.a
        public void cancel() {
            j jVar = (j) this.f20a;
            jVar.d("removeObserver");
            jVar.f2220a.h(this);
            this.f21b.f497b.remove(this);
            b.a.a aVar = this.f22c;
            if (aVar != null) {
                aVar.cancel();
                this.f22c = null;
            }
        }

        @Override // b.o.g
        public void d(i iVar, f.a aVar) {
            if (aVar == f.a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                b bVar = this.f21b;
                onBackPressedDispatcher.f19b.add(bVar);
                a aVar2 = new a(bVar);
                bVar.f497b.add(aVar2);
                this.f22c = aVar2;
            } else if (aVar == f.a.ON_STOP) {
                b.a.a aVar3 = this.f22c;
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
        public final b f24a;

        public a(b bVar) {
            this.f24a = bVar;
        }

        @Override // b.a.a
        public void cancel() {
            OnBackPressedDispatcher.this.f19b.remove(this.f24a);
            this.f24a.f497b.remove(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f18a = runnable;
    }

    public void a() {
        Iterator<b> descendingIterator = this.f19b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.f496a) {
                z zVar = z.this;
                zVar.D(true);
                if (zVar.h.f496a) {
                    zVar.a0();
                    return;
                } else {
                    zVar.f2184g.a();
                    return;
                }
            }
        }
        Runnable runnable = this.f18a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
