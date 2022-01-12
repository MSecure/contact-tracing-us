package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

public class ViewOffsetHelper {
    public boolean horizontalOffsetEnabled = true;
    public int layoutLeft;
    public int layoutTop;
    public int offsetLeft;
    public int offsetTop;
    public boolean verticalOffsetEnabled = true;
    public final View view;

    public ViewOffsetHelper(View view2) {
        this.view = view2;
    }

    public void applyOffsets() {
        View view2 = this.view;
        ViewCompat.offsetTopAndBottom(view2, this.offsetTop - (view2.getTop() - this.layoutTop));
        View view3 = this.view;
        view3.offsetLeftAndRight(this.offsetLeft - (view3.getLeft() - this.layoutLeft));
    }
}
