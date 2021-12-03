package e.t.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public final class q extends r {
    public q(RecyclerView.m mVar) {
        super(mVar, null);
    }

    @Override // e.t.a.r
    public int b(View view) {
        return this.a.C(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).bottomMargin;
    }

    @Override // e.t.a.r
    public int c(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.a.F(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
    }

    @Override // e.t.a.r
    public int d(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.a.G(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
    }

    @Override // e.t.a.r
    public int e(View view) {
        return this.a.I(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).topMargin;
    }

    @Override // e.t.a.r
    public int f() {
        return this.a.q;
    }

    @Override // e.t.a.r
    public int g() {
        RecyclerView.m mVar = this.a;
        return mVar.q - mVar.O();
    }

    @Override // e.t.a.r
    public int h() {
        return this.a.O();
    }

    @Override // e.t.a.r
    public int i() {
        return this.a.o;
    }

    @Override // e.t.a.r
    public int j() {
        return this.a.n;
    }

    @Override // e.t.a.r
    public int k() {
        return this.a.R();
    }

    @Override // e.t.a.r
    public int l() {
        RecyclerView.m mVar = this.a;
        return (mVar.q - mVar.R()) - this.a.O();
    }

    @Override // e.t.a.r
    public int n(View view) {
        this.a.W(view, true, this.c);
        return this.c.bottom;
    }

    @Override // e.t.a.r
    public int o(View view) {
        this.a.W(view, true, this.c);
        return this.c.top;
    }

    @Override // e.t.a.r
    public void p(int i2) {
        this.a.d0(i2);
    }
}
