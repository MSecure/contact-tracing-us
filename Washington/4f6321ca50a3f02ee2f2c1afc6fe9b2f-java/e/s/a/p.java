package e.s.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public final class p extends q {
    public p(RecyclerView.m mVar) {
        super(mVar, null);
    }

    @Override // e.s.a.q
    public int b(View view) {
        return this.a.B(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).bottomMargin;
    }

    @Override // e.s.a.q
    public int c(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.a.E(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
    }

    @Override // e.s.a.q
    public int d(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.a.F(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
    }

    @Override // e.s.a.q
    public int e(View view) {
        return this.a.H(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).topMargin;
    }

    @Override // e.s.a.q
    public int f() {
        return this.a.q;
    }

    @Override // e.s.a.q
    public int g() {
        RecyclerView.m mVar = this.a;
        return mVar.q - mVar.N();
    }

    @Override // e.s.a.q
    public int h() {
        return this.a.N();
    }

    @Override // e.s.a.q
    public int i() {
        return this.a.o;
    }

    @Override // e.s.a.q
    public int j() {
        return this.a.n;
    }

    @Override // e.s.a.q
    public int k() {
        return this.a.Q();
    }

    @Override // e.s.a.q
    public int l() {
        RecyclerView.m mVar = this.a;
        return (mVar.q - mVar.Q()) - this.a.N();
    }

    @Override // e.s.a.q
    public int n(View view) {
        this.a.V(view, true, this.c);
        return this.c.bottom;
    }

    @Override // e.s.a.q
    public int o(View view) {
        this.a.V(view, true, this.c);
        return this.c.top;
    }

    @Override // e.s.a.q
    public void p(int i2) {
        this.a.c0(i2);
    }
}
