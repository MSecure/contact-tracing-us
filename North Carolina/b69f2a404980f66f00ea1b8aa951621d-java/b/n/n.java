package b.n;

import androidx.lifecycle.LiveData;
import b.c.a.b.b;
import java.util.Iterator;
import java.util.Map;

public class n<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    public b<LiveData<?>, a<?>> f1401a = new b<>();

    public static class a<V> implements q<V> {

        /* renamed from: a  reason: collision with root package name */
        public final LiveData<V> f1402a;

        /* renamed from: b  reason: collision with root package name */
        public final q<? super V> f1403b;

        /* renamed from: c  reason: collision with root package name */
        public int f1404c = -1;

        public a(LiveData<V> liveData, q<? super V> qVar) {
            this.f1402a = liveData;
            this.f1403b = qVar;
        }

        @Override // b.n.q
        public void a(V v) {
            if (this.f1404c != this.f1402a.getVersion()) {
                this.f1404c = this.f1402a.getVersion();
                this.f1403b.a(v);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f1401a.iterator();
        while (true) {
            b.e eVar = (b.e) it;
            if (eVar.hasNext()) {
                a aVar = (a) ((Map.Entry) eVar.next()).getValue();
                aVar.f1402a.observeForever(aVar);
            } else {
                return;
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f1401a.iterator();
        while (true) {
            b.e eVar = (b.e) it;
            if (eVar.hasNext()) {
                a aVar = (a) ((Map.Entry) eVar.next()).getValue();
                aVar.f1402a.removeObserver(aVar);
            } else {
                return;
            }
        }
    }
}
