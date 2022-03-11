package e.r;

import androidx.lifecycle.LiveData;
import e.c.a.b.b;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class q<T> extends s<T> {

    /* renamed from: l  reason: collision with root package name */
    public b<LiveData<?>, a<?>> f1899l = new b<>();

    /* loaded from: classes.dex */
    public static class a<V> implements t<V> {
        public final LiveData<V> a;
        public final t<? super V> b;
        public int c = -1;

        public a(LiveData<V> liveData, t<? super V> tVar) {
            this.a = liveData;
            this.b = tVar;
        }

        @Override // e.r.t
        public void a(V v) {
            int i2 = this.c;
            int i3 = this.a.f177g;
            if (i2 != i3) {
                this.c = i3;
                this.b.a(v);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void h() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f1899l.iterator();
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
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f1899l.iterator();
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

    public <S> void m(LiveData<S> liveData, t<? super S> tVar) {
        a<?> aVar = new a<>(liveData, tVar);
        a<?> k2 = this.f1899l.k(liveData, aVar);
        if (k2 != null && k2.b != tVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (k2 == null && e()) {
            aVar.a.g(aVar);
        }
    }
}
