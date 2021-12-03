package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import e.b.f.k0;

public class FitWindowsLinearLayout extends LinearLayout {
    public k0 b;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean fitSystemWindows(Rect rect) {
        k0 k0Var = this.b;
        if (k0Var != null) {
            k0Var.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(k0 k0Var) {
        this.b = k0Var;
    }
}
