package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        Dialog dialog = this.mDialog;
        if (dialog instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
            if (bottomSheetDialog.behavior == null) {
                bottomSheetDialog.ensureContainerAndBehavior();
            }
            boolean z = bottomSheetDialog.behavior.hideable;
        }
        dismissInternal(false, false);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(getContext(), this.mTheme);
    }
}
