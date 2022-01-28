package f.d.b.s;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import f.d.b.m;
import f.d.b.n;
import j.k.b.e;

public final class d<ItemVHFactory extends m<? extends RecyclerView.b0>> implements n<ItemVHFactory> {
    public final SparseArray<ItemVHFactory> a = new SparseArray<>();

    @Override // f.d.b.n
    public boolean a(int i2, ItemVHFactory itemvhfactory) {
        e.c(itemvhfactory, "item");
        if (this.a.indexOfKey(i2) >= 0) {
            return false;
        }
        this.a.put(i2, itemvhfactory);
        return true;
    }

    @Override // f.d.b.n
    public boolean b(int i2) {
        return this.a.indexOfKey(i2) >= 0;
    }

    @Override // f.d.b.n
    public ItemVHFactory get(int i2) {
        ItemVHFactory itemvhfactory = this.a.get(i2);
        e.b(itemvhfactory, "typeInstances.get(type)");
        return itemvhfactory;
    }
}
