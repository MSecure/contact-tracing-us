package f.d.b.r;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.R$id;
import f.d.b.b;
import f.d.b.k;
import j.k.b.e;
import java.util.List;
/* loaded from: classes.dex */
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
        k p = bVar != null ? bVar.p(i2) : null;
        if (p != null) {
            try {
                p.c(b0Var);
                if (!(b0Var instanceof b.AbstractC0136b)) {
                    b0Var = null;
                }
                if (((b.AbstractC0136b) b0Var) != null) {
                    e.c(p, "item");
                }
            } catch (AbstractMethodError e2) {
                e2.toString();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.d.b.r.e
    public void b(RecyclerView.b0 b0Var, int i2, List<? extends Object> list) {
        k p;
        e.c(b0Var, "viewHolder");
        e.c(list, "payloads");
        View view = b0Var.a;
        RecyclerView.b0 b0Var2 = null;
        Object tag = view != null ? view.getTag(R$id.fastadapter_item_adapter) : null;
        if (!(tag instanceof b)) {
            tag = null;
        }
        b bVar = (b) tag;
        if (bVar != null && (p = bVar.p(i2)) != null) {
            p.g(b0Var, list);
            if (b0Var instanceof b.AbstractC0136b) {
                b0Var2 = b0Var;
            }
            b.AbstractC0136b bVar2 = (b.AbstractC0136b) b0Var2;
            if (bVar2 != 0) {
                bVar2.w(p, list);
            }
            b0Var.a.setTag(R$id.fastadapter_item, p);
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
        if (!(b0Var instanceof b.AbstractC0136b)) {
            return d2;
        }
        if (!d2) {
            b.AbstractC0136b bVar = (b.AbstractC0136b) b0Var;
            e.c(kVar2, "item");
        } else {
            z = true;
        }
        return z;
    }

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
            b.AbstractC0136b bVar = (b.AbstractC0136b) (!(b0Var instanceof b.AbstractC0136b) ? null : b0Var);
            if (bVar != 0) {
                bVar.x(kVar);
            }
            b0Var.a.setTag(R$id.fastadapter_item, null);
            b0Var.a.setTag(R$id.fastadapter_item_adapter, null);
        }
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
            if (!(b0Var instanceof b.AbstractC0136b)) {
                b0Var = null;
            }
            if (((b.AbstractC0136b) b0Var) != null) {
                e.c(kVar, "item");
            }
        }
    }
}
