package e.s.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class t extends y {
    public r c;

    /* renamed from: d  reason: collision with root package name */
    public r f1856d;

    @Override // e.s.a.y
    public int[] b(RecyclerView.m mVar, View view) {
        int[] iArr = new int[2];
        if (mVar.f()) {
            iArr[0] = e(view, g(mVar));
        } else {
            iArr[0] = 0;
        }
        if (mVar.g()) {
            iArr[1] = e(view, h(mVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // e.s.a.y
    public View c(RecyclerView.m mVar) {
        r g2;
        if (mVar.g()) {
            g2 = h(mVar);
        } else if (!mVar.f()) {
            return null;
        } else {
            g2 = g(mVar);
        }
        return f(mVar, g2);
    }

    public final int e(View view, r rVar) {
        return ((rVar.c(view) / 2) + rVar.e(view)) - ((rVar.l() / 2) + rVar.k());
    }

    public final View f(RecyclerView.m mVar, r rVar) {
        int z = mVar.z();
        View view = null;
        if (z == 0) {
            return null;
        }
        int l2 = (rVar.l() / 2) + rVar.k();
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < z; i3++) {
            View y = mVar.y(i3);
            int abs = Math.abs(((rVar.c(y) / 2) + rVar.e(y)) - l2);
            if (abs < i2) {
                view = y;
                i2 = abs;
            }
        }
        return view;
    }

    public final r g(RecyclerView.m mVar) {
        r rVar = this.f1856d;
        if (rVar == null || rVar.a != mVar) {
            this.f1856d = new p(mVar);
        }
        return this.f1856d;
    }

    public final r h(RecyclerView.m mVar) {
        r rVar = this.c;
        if (rVar == null || rVar.a != mVar) {
            this.c = new q(mVar);
        }
        return this.c;
    }
}
