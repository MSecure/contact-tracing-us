package b.r.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public final class z extends a0 {
    public z(RecyclerView.m mVar) {
        super(mVar, null);
    }

    @Override // b.r.d.a0
    public int b(View view) {
        return this.f2293a.B(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).bottomMargin;
    }

    @Override // b.r.d.a0
    public int c(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.f2293a.D(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
    }

    @Override // b.r.d.a0
    public int d(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.f2293a.E(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
    }

    @Override // b.r.d.a0
    public int e(View view) {
        return this.f2293a.G(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).topMargin;
    }

    @Override // b.r.d.a0
    public int f() {
        return this.f2293a.r;
    }

    @Override // b.r.d.a0
    public int g() {
        RecyclerView.m mVar = this.f2293a;
        return mVar.r - mVar.L();
    }

    @Override // b.r.d.a0
    public int h() {
        return this.f2293a.L();
    }

    @Override // b.r.d.a0
    public int i() {
        return this.f2293a.p;
    }

    @Override // b.r.d.a0
    public int j() {
        return this.f2293a.o;
    }

    @Override // b.r.d.a0
    public int k() {
        return this.f2293a.O();
    }

    @Override // b.r.d.a0
    public int l() {
        RecyclerView.m mVar = this.f2293a;
        return (mVar.r - mVar.O()) - this.f2293a.L();
    }

    @Override // b.r.d.a0
    public int n(View view) {
        this.f2293a.T(view, true, this.f2295c);
        return this.f2295c.bottom;
    }

    @Override // b.r.d.a0
    public int o(View view) {
        this.f2293a.T(view, true, this.f2295c);
        return this.f2295c.top;
    }

    @Override // b.r.d.a0
    public void p(int i) {
        this.f2293a.a0(i);
    }
}
