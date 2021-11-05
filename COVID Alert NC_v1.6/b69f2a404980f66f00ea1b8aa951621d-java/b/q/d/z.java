package b.q.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public final class z extends a0 {
    public z(RecyclerView.o oVar) {
        super(oVar, null);
    }

    @Override // b.q.d.a0
    public int b(View view) {
        return this.f1453a.B(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
    }

    @Override // b.q.d.a0
    public int c(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return this.f1453a.D(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
    }

    @Override // b.q.d.a0
    public int d(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return this.f1453a.E(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
    }

    @Override // b.q.d.a0
    public int e(View view) {
        return this.f1453a.G(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
    }

    @Override // b.q.d.a0
    public int f() {
        return this.f1453a.r;
    }

    @Override // b.q.d.a0
    public int g() {
        RecyclerView.o oVar = this.f1453a;
        return oVar.r - oVar.L();
    }

    @Override // b.q.d.a0
    public int h() {
        return this.f1453a.L();
    }

    @Override // b.q.d.a0
    public int i() {
        return this.f1453a.p;
    }

    @Override // b.q.d.a0
    public int j() {
        return this.f1453a.o;
    }

    @Override // b.q.d.a0
    public int k() {
        return this.f1453a.O();
    }

    @Override // b.q.d.a0
    public int l() {
        RecyclerView.o oVar = this.f1453a;
        return (oVar.r - oVar.O()) - this.f1453a.L();
    }

    @Override // b.q.d.a0
    public int n(View view) {
        this.f1453a.T(view, true, this.f1455c);
        return this.f1455c.bottom;
    }

    @Override // b.q.d.a0
    public int o(View view) {
        this.f1453a.T(view, true, this.f1455c);
        return this.f1455c.top;
    }

    @Override // b.q.d.a0
    public void p(int i) {
        this.f1453a.a0(i);
    }
}
