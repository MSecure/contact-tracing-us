package b.q.d;

import androidx.recyclerview.widget.RecyclerView;
import b.q.d.o;

public abstract class c0 extends RecyclerView.l {
    public boolean g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f215a;
        int i4 = cVar.f216b;
        if (d0Var2.shouldIgnore()) {
            int i5 = cVar.f215a;
            i = cVar.f216b;
            i2 = i5;
        } else {
            i2 = cVar2.f215a;
            i = cVar2.f216b;
        }
        o oVar = (o) this;
        if (d0Var == d0Var2) {
            return oVar.j(d0Var, i3, i4, i2, i);
        }
        float translationX = d0Var.itemView.getTranslationX();
        float translationY = d0Var.itemView.getTranslationY();
        float alpha = d0Var.itemView.getAlpha();
        oVar.o(d0Var);
        d0Var.itemView.setTranslationX(translationX);
        d0Var.itemView.setTranslationY(translationY);
        d0Var.itemView.setAlpha(alpha);
        oVar.o(d0Var2);
        d0Var2.itemView.setTranslationX((float) (-((int) (((float) (i2 - i3)) - translationX))));
        d0Var2.itemView.setTranslationY((float) (-((int) (((float) (i - i4)) - translationY))));
        d0Var2.itemView.setAlpha(0.0f);
        oVar.k.add(new o.a(d0Var, d0Var2, i3, i4, i2, i));
        return true;
    }

    public abstract boolean j(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4);
}
