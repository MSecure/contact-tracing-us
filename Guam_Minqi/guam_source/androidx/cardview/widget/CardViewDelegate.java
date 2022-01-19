package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

public interface CardViewDelegate {
    Drawable getCardBackground();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setShadowPadding(int i, int i2, int i3, int i4);
}
