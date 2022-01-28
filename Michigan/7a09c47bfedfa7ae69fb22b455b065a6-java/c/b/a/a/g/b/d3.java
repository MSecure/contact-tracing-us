package c.b.a.a.g.b;

import java.util.Iterator;
import java.util.Map;

public final class d3 implements Iterator<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    public int f3243b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3244c;

    /* renamed from: d  reason: collision with root package name */
    public Iterator<Map.Entry<K, V>> f3245d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ x2 f3246e;

    public d3(x2 x2Var, y2 y2Var) {
        this.f3246e = x2Var;
    }

    public final Iterator<Map.Entry<K, V>> a() {
        if (this.f3245d == null) {
            this.f3245d = this.f3246e.f3467d.entrySet().iterator();
        }
        return this.f3245d;
    }

    public final boolean hasNext() {
        if (this.f3243b + 1 < this.f3246e.f3466c.size() || (!this.f3246e.f3467d.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f3244c = true;
        int i = this.f3243b + 1;
        this.f3243b = i;
        return (Map.Entry) (i < this.f3246e.f3466c.size() ? this.f3246e.f3466c.get(this.f3243b) : a().next());
    }

    public final void remove() {
        if (this.f3244c) {
            this.f3244c = false;
            this.f3246e.h();
            if (this.f3243b < this.f3246e.f3466c.size()) {
                x2 x2Var = this.f3246e;
                int i = this.f3243b;
                this.f3243b = i - 1;
                x2Var.e(i);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
