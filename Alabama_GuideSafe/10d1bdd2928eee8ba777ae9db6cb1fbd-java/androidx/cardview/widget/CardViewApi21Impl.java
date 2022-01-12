package androidx.cardview.widget;

import android.content.res.ColorStateList;

public class CardViewApi21Impl implements CardViewImpl {
    public final RoundRectDrawable getCardBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.getCardBackground();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        throw null;
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        throw null;
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        throw null;
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawable cardBackground = getCardBackground(cardViewDelegate);
        boolean useCompatPadding = cardViewDelegate.getUseCompatPadding();
        boolean preventCornerOverlap = cardViewDelegate.getPreventCornerOverlap();
        if (f != cardBackground.mPadding || cardBackground.mInsetForPadding != useCompatPadding || cardBackground.mInsetForRadius != preventCornerOverlap) {
            cardBackground.mPadding = f;
            cardBackground.mInsetForPadding = useCompatPadding;
            cardBackground.mInsetForRadius = preventCornerOverlap;
            cardBackground.updateBounds(null);
            throw null;
        } else if (!cardViewDelegate.getUseCompatPadding()) {
            cardViewDelegate.setShadowPadding(0, 0, 0, 0);
        } else {
            float f2 = getCardBackground(cardViewDelegate).mPadding;
            float f3 = getCardBackground(cardViewDelegate).mRadius;
            int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.calculateHorizontalPadding(f2, f3, cardViewDelegate.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.calculateVerticalPadding(f2, f3, cardViewDelegate.getPreventCornerOverlap()));
            cardViewDelegate.setShadowPadding(ceil, ceil2, ceil, ceil2);
        }
    }
}
