package b.r.d;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import b.r.d.c;
import b.r.d.d;
import b.r.d.p;
import java.util.List;
import java.util.concurrent.Executors;

public abstract class v<T, VH extends RecyclerView.a0> extends RecyclerView.e<VH> {
    public final d<T> mDiffer;
    public final d.b<T> mListener = new a();

    public class a implements d.b<T> {
        public a() {
        }

        @Override // b.r.d.d.b
        public void a(List<T> list, List<T> list2) {
            v.this.onCurrentListChanged(list, list2);
        }
    }

    public v(c<T> cVar) {
        d<T> dVar = new d<>(new b(this), cVar);
        this.mDiffer = dVar;
        dVar.f2309d.add(this.mListener);
    }

    public List<T> getCurrentList() {
        return this.mDiffer.f2311f;
    }

    public T getItem(int i) {
        return this.mDiffer.f2311f.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.mDiffer.f2311f.size();
    }

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    public void submitList(List<T> list) {
        this.mDiffer.b(list, null);
    }

    public void submitList(List<T> list, Runnable runnable) {
        this.mDiffer.b(list, runnable);
    }

    public v(p.d<T> dVar) {
        b bVar = new b(this);
        c.a aVar = new c.a(dVar);
        if (aVar.f2303a == null) {
            synchronized (c.a.f2301c) {
                if (c.a.f2302d == null) {
                    c.a.f2302d = Executors.newFixedThreadPool(2);
                }
            }
            aVar.f2303a = c.a.f2302d;
        }
        d<T> dVar2 = new d<>(bVar, new c(null, aVar.f2303a, aVar.f2304b));
        this.mDiffer = dVar2;
        dVar2.f2309d.add(this.mListener);
    }
}
