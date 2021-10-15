package c.b.a.b.r;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import b.b.k.p;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class d extends p {
    public boolean waitingForDismissAllowingStateLoss;

    public class b extends BottomSheetBehavior.d {
        public b(a aVar) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void a(View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void b(View view, int i) {
            if (i == 5) {
                d.this.dismissAfterAnimation();
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
        if (getDialog() instanceof c) {
            c cVar = (c) getDialog();
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = cVar.f4505d;
            bottomSheetBehavior2.G.remove(cVar.i);
        }
        b bVar = new b(null);
        if (!bottomSheetBehavior.G.contains(bVar)) {
            bottomSheetBehavior.G.add(bVar);
        }
        bottomSheetBehavior.L(5);
    }

    private boolean tryDismissWithAnimation(boolean z) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof c)) {
            return false;
        }
        c cVar = (c) dialog;
        if (cVar.f4505d == null) {
            cVar.d();
        }
        boolean z2 = cVar.f4505d.u;
        return false;
    }

    @Override // b.l.d.l
    public void dismiss() {
        if (!tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    @Override // b.l.d.l
    public void dismissAllowingStateLoss() {
        if (!tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override // b.b.k.p, b.l.d.l
    public Dialog onCreateDialog(Bundle bundle) {
        return new c(getContext(), getTheme());
    }
}
