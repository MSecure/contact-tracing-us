package b.b.q;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import b.b.j;
import b.b.l.a.a;

public class p extends PopupWindow {
    public p(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.PopupWindow, i, i2);
        if (obtainStyledAttributes.hasValue(j.PopupWindow_overlapAnchor)) {
            setOverlapAnchor(obtainStyledAttributes.getBoolean(j.PopupWindow_overlapAnchor, false));
        }
        int i3 = j.PopupWindow_android_popupBackground;
        setBackgroundDrawable((!obtainStyledAttributes.hasValue(i3) || (resourceId = obtainStyledAttributes.getResourceId(i3, 0)) == 0) ? obtainStyledAttributes.getDrawable(i3) : a.b(context, resourceId));
        obtainStyledAttributes.recycle();
    }

    public void showAsDropDown(View view, int i, int i2) {
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, i2, i3, i4);
    }
}
