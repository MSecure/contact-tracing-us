package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int tempLeftRightOffset = 0;
    public int tempTopBottomOffset = 0;
    public ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.offsetTop;
        }
        return 0;
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        layoutChild(coordinatorLayout, v, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new ViewOffsetHelper(v);
        }
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        viewOffsetHelper2.layoutTop = viewOffsetHelper2.view.getTop();
        viewOffsetHelper2.layoutLeft = viewOffsetHelper2.view.getLeft();
        this.viewOffsetHelper.applyOffsets();
        int i2 = this.tempTopBottomOffset;
        if (i2 != 0) {
            ViewOffsetHelper viewOffsetHelper3 = this.viewOffsetHelper;
            if (viewOffsetHelper3.verticalOffsetEnabled && viewOffsetHelper3.offsetTop != i2) {
                viewOffsetHelper3.offsetTop = i2;
                viewOffsetHelper3.applyOffsets();
            }
            this.tempTopBottomOffset = 0;
        }
        int i3 = this.tempLeftRightOffset;
        if (i3 == 0) {
            return true;
        }
        ViewOffsetHelper viewOffsetHelper4 = this.viewOffsetHelper;
        if (viewOffsetHelper4.horizontalOffsetEnabled && viewOffsetHelper4.offsetLeft != i3) {
            viewOffsetHelper4.offsetLeft = i3;
            viewOffsetHelper4.applyOffsets();
        }
        this.tempLeftRightOffset = 0;
        return true;
    }

    public boolean setTopAndBottomOffset(int i) {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 == null) {
            this.tempTopBottomOffset = i;
            return false;
        } else if (!viewOffsetHelper2.verticalOffsetEnabled || viewOffsetHelper2.offsetTop == i) {
            return false;
        } else {
            viewOffsetHelper2.offsetTop = i;
            viewOffsetHelper2.applyOffsets();
            return true;
        }
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
