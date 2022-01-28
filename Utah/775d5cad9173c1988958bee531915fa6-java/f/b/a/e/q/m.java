package f.b.a.e.q;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.i.i.b0;
import e.i.i.n;
import f.b.a.e.e.b;

public final class m implements n {
    public final /* synthetic */ o a;
    public final /* synthetic */ p b;

    public m(o oVar, p pVar) {
        this.a = oVar;
        this.b = pVar;
    }

    @Override // e.i.i.n
    public b0 a(View view, b0 b0Var) {
        o oVar = this.a;
        p pVar = this.b;
        int i2 = pVar.a;
        int i3 = pVar.c;
        int i4 = pVar.f2971d;
        b bVar = (b) oVar;
        bVar.b.s = b0Var.d();
        boolean V0 = f.b.a.c.b.o.b.V0(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        BottomSheetBehavior bottomSheetBehavior = bVar.b;
        if (bottomSheetBehavior.n) {
            bottomSheetBehavior.r = b0Var.a();
            paddingBottom = bVar.b.r + i4;
        }
        if (bVar.b.o) {
            paddingLeft = b0Var.b() + (V0 ? i3 : i2);
        }
        if (bVar.b.p) {
            if (!V0) {
                i2 = i3;
            }
            paddingRight = b0Var.c() + i2;
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        if (bVar.a) {
            bVar.b.f516l = b0Var.a.f().f1487d;
        }
        BottomSheetBehavior bottomSheetBehavior2 = bVar.b;
        if (bottomSheetBehavior2.n || bVar.a) {
            bottomSheetBehavior2.T(false);
        }
        return b0Var;
    }
}
