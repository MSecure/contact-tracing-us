package b.r.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public final class y extends a0 {
    public y(RecyclerView.m mVar) {
        super(mVar, null);
    }

    @Override // b.r.d.a0
    public int b(View view) {
        return this.f2293a.F(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).rightMargin;
    }

    @Override // b.r.d.a0
    public int c(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.f2293a.E(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
    }

    @Override // b.r.d.a0
    public int d(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.f2293a.D(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
    }

    @Override // b.r.d.a0
    public int e(View view) {
        return this.f2293a.C(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).leftMargin;
    }

    @Override // b.r.d.a0
    public int f() {
        return this.f2293a.q;
    }

    @Override // b.r.d.a0
    public int g() {
        RecyclerView.m mVar = this.f2293a;
        return mVar.q - mVar.N();
    }

    @Override // b.r.d.a0
    public int h() {
        return this.f2293a.N();
    }

    @Override // b.r.d.a0
    public int i() {
        return this.f2293a.o;
    }

    @Override // b.r.d.a0
    public int j() {
        return this.f2293a.p;
    }

    @Override // b.r.d.a0
    public int k() {
        return this.f2293a.M();
    }

    @Override // b.r.d.a0
    public int l() {
        RecyclerView.m mVar = this.f2293a;
        return (mVar.q - mVar.M()) - this.f2293a.N();
    }

    @Override // b.r.d.a0
    public int n(View view) {
        this.f2293a.T(view, true, this.f2295c);
        return this.f2295c.right;
    }

    @Override // b.r.d.a0
    public int o(View view) {
        this.f2293a.T(view, true, this.f2295c);
        return this.f2295c.left;
    }

    @Override // b.r.d.a0
    public void p(int i) {
        this.f2293a.Z(i);
    }
}
