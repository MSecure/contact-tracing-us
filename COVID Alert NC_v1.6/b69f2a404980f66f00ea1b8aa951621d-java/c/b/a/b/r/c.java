package c.b.a.b.r;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import b.b.k.p;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class c extends p {
    public boolean waitingForDismissAllowingStateLoss;

    public class b extends BottomSheetBehavior.d {
        public b(a aVar) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void a(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void b(View view, int i) {
            if (i == 5) {
                c.this.dismissAfterAnimation();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void dismissWithAnimation(BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.waitingForDismissAllowingStateLoss = z;
        if (bottomSheetBehavior.x == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof b) {
            b bVar = (b) getDialog();
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = bVar.f3192d;
            bottomSheetBehavior2.G.remove(bVar.i);
        }
        b bVar2 = new b(null);
        if (!bottomSheetBehavior.G.contains(bVar2)) {
            bottomSheetBehavior.G.add(bVar2);
        }
        bottomSheetBehavior.L(5);
    }

    private boolean tryDismissWithAnimation(boolean z) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof b)) {
            return false;
        }
        b bVar = (b) dialog;
        if (bVar.f3192d == null) {
            bVar.d();
        }
        boolean z2 = bVar.f3192d.u;
        return false;
    }

    @Override // b.l.d.c
    public void dismiss() {
        if (!tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    @Override // b.l.d.c
    public void dismissAllowingStateLoss() {
        if (!tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override // b.l.d.c, b.b.k.p
    public Dialog onCreateDialog(Bundle bundle) {
        return new b(getContext(), getTheme());
    }
}
