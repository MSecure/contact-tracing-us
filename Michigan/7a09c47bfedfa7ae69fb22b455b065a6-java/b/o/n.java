package b.o;

import androidx.lifecycle.LiveData;
import b.c.a.b.b;
import java.util.Iterator;
import java.util.Map;

public class n<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    public b<LiveData<?>, a<?>> f2232a = new b<>();

    public static class a<V> implements q<V> {

        /* renamed from: a  reason: collision with root package name */
        public final LiveData<V> f2233a;

        /* renamed from: b  reason: collision with root package name */
        public final q<? super V> f2234b;

        /* renamed from: c  reason: collision with root package name */
        public int f2235c = -1;

        public a(LiveData<V> liveData, q<? super V> qVar) {
            this.f2233a = liveData;
            this.f2234b = qVar;
        }

        @Override // b.o.q
        public void a(V v) {
            if (this.f2235c != this.f2233a.getVersion()) {
                this.f2235c = this.f2233a.getVersion();
                this.f2234b.a(v);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f2232a.iterator();
        while (true) {
            b.e eVar = (b.e) it;
            if (eVar.hasNext()) {
                a aVar = (a) ((Map.Entry) eVar.next()).getValue();
                aVar.f2233a.observeForever(aVar);
            } else {
                return;
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f2232a.iterator();
        while (true) {
            b.e eVar = (b.e) it;
            if (eVar.hasNext()) {
                a aVar = (a) ((Map.Entry) eVar.next()).getValue();
                aVar.f2233a.removeObserver(aVar);
            } else {
                return;
            }
        }
    }
}
