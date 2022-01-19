package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    public static final CardViewImpl IMPL = new CardViewApi21Impl();
    public boolean mCompatPadding;
    public boolean mPreventCornerOverlap;

    public ColorStateList getCardBackgroundColor() {
        CardViewApi21Impl cardViewApi21Impl = (CardViewApi21Impl) IMPL;
        throw null;
    }

    public float getCardElevation() {
        throw null;
    }

    public int getContentPaddingBottom() {
        throw null;
    }

    public int getContentPaddingLeft() {
        throw null;
    }

    public int getContentPaddingRight() {
        throw null;
    }

    public int getContentPaddingTop() {
        throw null;
    }

    public float getMaxCardElevation() {
        return ((CardViewApi21Impl) IMPL).getMaxElevation(null);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return ((CardViewApi21Impl) IMPL).getRadius(null);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        ((CardViewApi21Impl) IMPL).setBackgroundColor(null, ColorStateList.valueOf(i));
        throw null;
    }

    public void setCardElevation(float f) {
        throw null;
    }

    public void setMaxCardElevation(float f) {
        ((CardViewApi21Impl) IMPL).setMaxElevation(null, f);
    }

    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            CardViewApi21Impl cardViewApi21Impl = (CardViewApi21Impl) IMPL;
            throw null;
        }
    }

    public void setRadius(float f) {
        CardViewApi21Impl cardViewApi21Impl = (CardViewApi21Impl) IMPL;
        throw null;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            CardViewApi21Impl cardViewApi21Impl = (CardViewApi21Impl) IMPL;
            throw null;
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        ((CardViewApi21Impl) IMPL).setBackgroundColor(null, colorStateList);
        throw null;
    }
}
