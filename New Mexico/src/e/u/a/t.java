package e.u.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class t extends y {
    public r c;

    /* renamed from: d */
    public r f2032d;

    @Override // e.u.a.y
    public int[] a(RecyclerView.m mVar, View view) {
        int[] iArr = new int[2];
        if (mVar.f()) {
            iArr[0] = c(view, e(mVar));
        } else {
            iArr[0] = 0;
        }
        if (mVar.g()) {
            iArr[1] = c(view, f(mVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final int c(View view, r rVar) {
        return ((rVar.c(view) / 2) + rVar.e(view)) - ((rVar.l() / 2) + rVar.k());
    }

    public final View d(RecyclerView.m mVar, r rVar) {
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

    public final r e(RecyclerView.m mVar) {
        r rVar = this.f2032d;
        if (rVar == null || rVar.a != mVar) {
            this.f2032d = new p(mVar);
        }
        return this.f2032d;
    }

    public final r f(RecyclerView.m mVar) {
        r rVar = this.c;
        if (rVar == null || rVar.a != mVar) {
            this.c = new q(mVar);
        }
        return this.c;
    }
}
