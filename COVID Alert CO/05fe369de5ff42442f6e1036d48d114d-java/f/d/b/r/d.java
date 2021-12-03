package f.d.b.r;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import f.b.a.c.b.o.b;
import f.d.b.k;
import j.k.b.e;
import java.util.List;

public abstract class d<Item extends k<? extends RecyclerView.b0>> implements c<Item> {
    @Override // f.d.b.r.c
    public View a(RecyclerView.b0 b0Var) {
        e.c(b0Var, "viewHolder");
        b.a1(b0Var);
        return null;
    }

    @Override // f.d.b.r.c
    public List<View> b(RecyclerView.b0 b0Var) {
        e.c(b0Var, "viewHolder");
        b.b1(b0Var);
        return null;
    }

    public abstract boolean c(View view, int i2, f.d.b.b<Item> bVar, Item item);
}
