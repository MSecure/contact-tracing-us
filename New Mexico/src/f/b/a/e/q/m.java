package f.b.a.e.q;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.j.j.b0;
import e.j.j.n;
import f.b.a.e.e.b;
/* loaded from: classes.dex */
public final class m implements n {
    public final /* synthetic */ o a;
    public final /* synthetic */ p b;

    public m(o oVar, p pVar) {
        this.a = oVar;
        this.b = pVar;
    }

    @Override // e.j.j.n
    public b0 a(View view, b0 b0Var) {
        o oVar = this.a;
        p pVar = this.b;
        int i2 = pVar.a;
        int i3 = pVar.c;
        int i4 = pVar.f3013d;
        b bVar = (b) oVar;
        bVar.b.s = b0Var.d();
        boolean W0 = f.b.a.c.b.o.b.W0(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        BottomSheetBehavior bottomSheetBehavior = bVar.b;
        if (bottomSheetBehavior.n) {
            bottomSheetBehavior.r = b0Var.a();
            paddingBottom = bVar.b.r + i4;
        }
        if (bVar.b.o) {
            paddingLeft = b0Var.b() + (W0 ? i3 : i2);
        }
        if (bVar.b.p) {
            if (!W0) {
                i2 = i3;
            }
            paddingRight = b0Var.c() + i2;
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        if (bVar.a) {
            bVar.b.f528l = b0Var.a.f().f1571d;
        }
        BottomSheetBehavior bottomSheetBehavior2 = bVar.b;
        if (bottomSheetBehavior2.n || bVar.a) {
            bottomSheetBehavior2.T(false);
        }
        return b0Var;
    }
}
