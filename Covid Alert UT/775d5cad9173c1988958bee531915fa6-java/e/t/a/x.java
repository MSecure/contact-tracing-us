package e.t.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import e.t.a.c;

public abstract class x extends RecyclerView.j {

    /* renamed from: g  reason: collision with root package name */
    public boolean f1952g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean a(RecyclerView.b0 b0Var, RecyclerView.j.c cVar, RecyclerView.j.c cVar2) {
        int i2;
        int i3;
        if (cVar != null && ((i2 = cVar.a) != (i3 = cVar2.a) || cVar.b != cVar2.b)) {
            return n(b0Var, i2, cVar.b, i3, cVar2.b);
        }
        c cVar3 = (c) this;
        cVar3.t(b0Var);
        b0Var.a.setAlpha(0.0f);
        cVar3.f1884i.add(b0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean b(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, RecyclerView.j.c cVar, RecyclerView.j.c cVar2) {
        int i2;
        int i3;
        int i4 = cVar.a;
        int i5 = cVar.b;
        if (b0Var2.u()) {
            int i6 = cVar.a;
            i2 = cVar.b;
            i3 = i6;
        } else {
            i3 = cVar2.a;
            i2 = cVar2.b;
        }
        c cVar3 = (c) this;
        if (b0Var == b0Var2) {
            return cVar3.n(b0Var, i4, i5, i3, i2);
        }
        float translationX = b0Var.a.getTranslationX();
        float translationY = b0Var.a.getTranslationY();
        float alpha = b0Var.a.getAlpha();
        cVar3.t(b0Var);
        b0Var.a.setTranslationX(translationX);
        b0Var.a.setTranslationY(translationY);
        b0Var.a.setAlpha(alpha);
        cVar3.t(b0Var2);
        b0Var2.a.setTranslationX((float) (-((int) (((float) (i3 - i4)) - translationX))));
        b0Var2.a.setTranslationY((float) (-((int) (((float) (i2 - i5)) - translationY))));
        b0Var2.a.setAlpha(0.0f);
        cVar3.f1886k.add(new c.d(b0Var, b0Var2, i4, i5, i3, i2));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean c(RecyclerView.b0 b0Var, RecyclerView.j.c cVar, RecyclerView.j.c cVar2) {
        int i2 = cVar.a;
        int i3 = cVar.b;
        View view = b0Var.a;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (b0Var.m() || (i2 == left && i3 == top)) {
            c cVar3 = (c) this;
            cVar3.t(b0Var);
            cVar3.f1883h.add(b0Var);
            return true;
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return n(b0Var, i2, i3, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean d(RecyclerView.b0 b0Var, RecyclerView.j.c cVar, RecyclerView.j.c cVar2) {
        int i2 = cVar.a;
        int i3 = cVar2.a;
        if (i2 != i3 || cVar.b != cVar2.b) {
            return n(b0Var, i2, cVar.b, i3, cVar2.b);
        }
        g(b0Var);
        return false;
    }

    public abstract boolean n(RecyclerView.b0 b0Var, int i2, int i3, int i4, int i5);

    public boolean o(RecyclerView.b0 b0Var) {
        return !this.f1952g || b0Var.k();
    }
}
