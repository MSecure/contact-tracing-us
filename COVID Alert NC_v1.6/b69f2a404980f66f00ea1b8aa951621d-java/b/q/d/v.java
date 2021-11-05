package b.q.d;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.d0;
import b.q.d.c;
import b.q.d.d;
import b.q.d.p;
import java.util.List;
import java.util.concurrent.Executors;

public abstract class v<T, VH extends RecyclerView.d0> extends RecyclerView.g<VH> {
    public final d<T> mDiffer;
    public final d.b<T> mListener = new a();

    public class a implements d.b<T> {
        public a() {
        }

        @Override // b.q.d.d.b
        public void a(List<T> list, List<T> list2) {
            v.this.onCurrentListChanged(list, list2);
        }
    }

    public v(c<T> cVar) {
        d<T> dVar = new d<>(new b(this), cVar);
        this.mDiffer = dVar;
        dVar.f1471d.add(this.mListener);
    }

    public List<T> getCurrentList() {
        return this.mDiffer.f;
    }

    public T getItem(int i) {
        return this.mDiffer.f.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.mDiffer.f.size();
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
        if (aVar.f1466a == null) {
            synchronized (c.a.f1464c) {
                if (c.a.f1465d == null) {
                    c.a.f1465d = Executors.newFixedThreadPool(2);
                }
            }
            aVar.f1466a = c.a.f1465d;
        }
        d<T> dVar2 = new d<>(bVar, new c(null, aVar.f1466a, aVar.f1467b));
        this.mDiffer = dVar2;
        dVar2.f1471d.add(this.mListener);
    }
}
