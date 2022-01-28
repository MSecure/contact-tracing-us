package c.b.a.a.g.h;

import java.util.Iterator;
import java.util.Map;

public final class x3 implements Iterator<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    public int f4065b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4066c;

    /* renamed from: d  reason: collision with root package name */
    public Iterator<Map.Entry<K, V>> f4067d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ r3 f4068e;

    public x3(r3 r3Var, t3 t3Var) {
        this.f4068e = r3Var;
    }

    public final Iterator<Map.Entry<K, V>> a() {
        if (this.f4067d == null) {
            this.f4067d = this.f4068e.f4020d.entrySet().iterator();
        }
        return this.f4067d;
    }

    public final boolean hasNext() {
        if (this.f4065b + 1 < this.f4068e.f4019c.size() || (!this.f4068e.f4020d.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f4066c = true;
        int i = this.f4065b + 1;
        this.f4065b = i;
        return (Map.Entry) (i < this.f4068e.f4019c.size() ? this.f4068e.f4019c.get(this.f4065b) : a().next());
    }

    public final void remove() {
        if (this.f4066c) {
            this.f4066c = false;
            this.f4068e.j();
            if (this.f4065b < this.f4068e.f4019c.size()) {
                r3 r3Var = this.f4068e;
                int i = this.f4065b;
                this.f4065b = i - 1;
                r3Var.f(i);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
