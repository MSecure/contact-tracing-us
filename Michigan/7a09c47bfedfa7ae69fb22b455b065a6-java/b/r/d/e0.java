package b.r.d;

import androidx.recyclerview.widget.RecyclerView;
import b.r.d.o;

public abstract class e0 extends RecyclerView.j {

    /* renamed from: g  reason: collision with root package name */
    public boolean f2331g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean a(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2, RecyclerView.j.c cVar, RecyclerView.j.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f294a;
        int i4 = cVar.f295b;
        if (a0Var2.shouldIgnore()) {
            int i5 = cVar.f294a;
            i = cVar.f295b;
            i2 = i5;
        } else {
            i2 = cVar2.f294a;
            i = cVar2.f295b;
        }
        o oVar = (o) this;
        if (a0Var == a0Var2) {
            return oVar.j(a0Var, i3, i4, i2, i);
        }
        float translationX = a0Var.itemView.getTranslationX();
        float translationY = a0Var.itemView.getTranslationY();
        float alpha = a0Var.itemView.getAlpha();
        oVar.o(a0Var);
        a0Var.itemView.setTranslationX(translationX);
        a0Var.itemView.setTranslationY(translationY);
        a0Var.itemView.setAlpha(alpha);
        oVar.o(a0Var2);
        a0Var2.itemView.setTranslationX((float) (-((int) (((float) (i2 - i3)) - translationX))));
        a0Var2.itemView.setTranslationY((float) (-((int) (((float) (i - i4)) - translationY))));
        a0Var2.itemView.setAlpha(0.0f);
        oVar.k.add(new o.a(a0Var, a0Var2, i3, i4, i2, i));
        return true;
    }

    public abstract boolean j(RecyclerView.a0 a0Var, int i, int i2, int i3, int i4);
}
