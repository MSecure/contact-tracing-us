package f.d.b.r;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import f.d.b.k;
import j.k.b.e;
import java.util.List;

public abstract class b<Item extends k<? extends RecyclerView.b0>> implements c<Item> {
    @Override // f.d.b.r.c
    public View a(RecyclerView.b0 b0Var) {
        e.c(b0Var, "viewHolder");
        f.b.a.c.b.o.b.a1(b0Var);
        return null;
    }

    @Override // f.d.b.r.c
    public List<View> b(RecyclerView.b0 b0Var) {
        e.c(b0Var, "viewHolder");
        f.b.a.c.b.o.b.b1(b0Var);
        return null;
    }

    public abstract void c(View view, RecyclerView.b0 b0Var);
}
