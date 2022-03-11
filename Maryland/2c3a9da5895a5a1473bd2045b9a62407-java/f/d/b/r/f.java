package f.d.b.r;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.R$id;
import f.d.b.b;
import f.d.b.k;
import j.j.b.e;
import java.util.List;

public class f<Item extends k<? extends RecyclerView.b0>> implements e {
    @Override // f.d.b.r.e
    public void a(RecyclerView.b0 b0Var, int i2) {
        e.c(b0Var, "viewHolder");
        View view = b0Var.a;
        Object tag = view != null ? view.getTag(R$id.fastadapter_item_adapter) : null;
        if (!(tag instanceof b)) {
            tag = null;
        }
        b bVar = (b) tag;
        k s = bVar != null ? bVar.s(i2) : null;
        if (s != null) {
            try {
                s.c(b0Var);
                if (!(b0Var instanceof b.AbstractC0134b)) {
                    b0Var = null;
                }
                if (((b.AbstractC0134b) b0Var) != null) {
                    e.c(s, "item");
                }
            } catch (AbstractMethodError e2) {
                Log.e("FastAdapter", e2.toString());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: f.d.b.b$b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.d.b.r.e
    public void b(RecyclerView.b0 b0Var, int i2, List<? extends Object> list) {
        k s;
        e.c(b0Var, "viewHolder");
        e.c(list, "payloads");
        View view = b0Var.a;
        RecyclerView.b0 b0Var2 = null;
        Object tag = view != null ? view.getTag(R$id.fastadapter_item_adapter) : null;
        if (!(tag instanceof b)) {
            tag = null;
        }
        b bVar = (b) tag;
        if (bVar != null && (s = bVar.s(i2)) != null) {
            s.g(b0Var, list);
            if (b0Var instanceof b.AbstractC0134b) {
                b0Var2 = b0Var;
            }
            b.AbstractC0134b bVar2 = (b.AbstractC0134b) b0Var2;
            if (bVar2 != 0) {
                bVar2.w(s, list);
            }
            b0Var.a.setTag(R$id.fastadapter_item, s);
        }
    }

    @Override // f.d.b.r.e
    public boolean c(RecyclerView.b0 b0Var, int i2) {
        e.c(b0Var, "viewHolder");
        View view = b0Var.a;
        k kVar = null;
        Object tag = view != null ? view.getTag(R$id.fastadapter_item) : null;
        if (tag instanceof k) {
            kVar = tag;
        }
        k kVar2 = kVar;
        boolean z = false;
        if (kVar2 == null) {
            return false;
        }
        boolean d2 = kVar2.d(b0Var);
        if (!(b0Var instanceof b.AbstractC0134b)) {
            return d2;
        }
        if (!d2) {
            b.AbstractC0134b bVar = (b.AbstractC0134b) b0Var;
            e.c(kVar2, "item");
        } else {
            z = true;
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: f.d.b.b$b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.d.b.r.e
    public void d(RecyclerView.b0 b0Var, int i2) {
        e.c(b0Var, "viewHolder");
        View view = b0Var.a;
        Object tag = view != null ? view.getTag(R$id.fastadapter_item) : null;
        if (!(tag instanceof k)) {
            tag = null;
        }
        k kVar = (k) tag;
        if (kVar != null) {
            kVar.j(b0Var);
            b.AbstractC0134b bVar = (b.AbstractC0134b) (!(b0Var instanceof b.AbstractC0134b) ? null : b0Var);
            if (bVar != 0) {
                bVar.x(kVar);
            }
            b0Var.a.setTag(R$id.fastadapter_item, null);
            b0Var.a.setTag(R$id.fastadapter_item_adapter, null);
            return;
        }
        Log.e("FastAdapter", "The bindView method of this item should set the `Tag` on its itemView (https://github.com/mikepenz/FastAdapter/blob/develop/library-core/src/main/java/com/mikepenz/fastadapter/items/AbstractItem.kt#L22)");
    }

    @Override // f.d.b.r.e
    public void e(RecyclerView.b0 b0Var, int i2) {
        e.c(b0Var, "viewHolder");
        View view = b0Var.a;
        Object tag = view != null ? view.getTag(R$id.fastadapter_item) : null;
        if (!(tag instanceof k)) {
            tag = null;
        }
        k kVar = (k) tag;
        if (kVar != null) {
            kVar.i(b0Var);
            if (!(b0Var instanceof b.AbstractC0134b)) {
                b0Var = null;
            }
            if (((b.AbstractC0134b) b0Var) != null) {
                e.c(kVar, "item");
            }
        }
    }
}
