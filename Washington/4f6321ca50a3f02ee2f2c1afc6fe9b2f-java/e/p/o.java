package e.p;

import androidx.lifecycle.LiveData;
import e.c.a.b.b;
import java.util.Iterator;
import java.util.Map;

public class o<T> extends q<T> {

    /* renamed from: l  reason: collision with root package name */
    public b<LiveData<?>, a<?>> f1715l = new b<>();

    public static class a<V> implements r<V> {
        public final LiveData<V> a;
        public final r<? super V> b;
        public int c = -1;

        public a(LiveData<V> liveData, r<? super V> rVar) {
            this.a = liveData;
            this.b = rVar;
        }

        @Override // e.p.r
        public void a(V v) {
            int i2 = this.c;
            int i3 = this.a.f165g;
            if (i2 != i3) {
                this.c = i3;
                this.b.a(v);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void h() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f1715l.iterator();
        while (true) {
            b.e eVar = (b.e) it;
            if (eVar.hasNext()) {
                a aVar = (a) ((Map.Entry) eVar.next()).getValue();
                aVar.a.g(aVar);
            } else {
                return;
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void i() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f1715l.iterator();
        while (true) {
            b.e eVar = (b.e) it;
            if (eVar.hasNext()) {
                a aVar = (a) ((Map.Entry) eVar.next()).getValue();
                aVar.a.k(aVar);
            } else {
                return;
            }
        }
    }

    public <S> void m(LiveData<S> liveData, r<? super S> rVar) {
        a<?> aVar = new a<>(liveData, rVar);
        a<?> k2 = this.f1715l.k(liveData, aVar);
        if (k2 != null && k2.b != rVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (k2 == null && e()) {
            aVar.a.g(aVar);
        }
    }
}
