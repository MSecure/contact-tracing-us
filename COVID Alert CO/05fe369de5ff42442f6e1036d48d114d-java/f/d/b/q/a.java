package f.d.b.q;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import f.d.b.m;
import j.k.b.e;

public abstract class a<VH extends RecyclerView.b0> extends b<VH> implements m<VH> {
    @Override // f.d.b.m
    public VH e(ViewGroup viewGroup) {
        e.c(viewGroup, "parent");
        Context context = viewGroup.getContext();
        e.b(context, "parent.context");
        e.c(context, "ctx");
        View inflate = LayoutInflater.from(context).inflate(k(), viewGroup, false);
        e.b(inflate, "LayoutInflater.from(ctx)…layoutRes, parent, false)");
        return l(inflate);
    }

    public abstract int k();

    public abstract VH l(View view);
}
