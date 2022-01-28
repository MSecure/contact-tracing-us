package com.google.android.material.resources;

import android.graphics.Typeface;
import com.google.android.material.internal.CollapsingTextHelper;

public final class CancelableFontCallback extends TextAppearanceFontCallback {
    public final ApplyFont applyFont;
    public boolean cancelled;
    public final Typeface fallbackFont;

    public interface ApplyFont {
    }

    public CancelableFontCallback(ApplyFont applyFont2, Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = applyFont2;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i) {
        updateIfNotCancelled(this.fallbackFont);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(Typeface typeface, boolean z) {
        updateIfNotCancelled(typeface);
    }

    public final void updateIfNotCancelled(Typeface typeface) {
        if (!this.cancelled) {
            CollapsingTextHelper collapsingTextHelper = CollapsingTextHelper.this;
            CancelableFontCallback cancelableFontCallback = collapsingTextHelper.collapsedFontCallback;
            boolean z = true;
            if (cancelableFontCallback != null) {
                cancelableFontCallback.cancelled = true;
            }
            if (collapsingTextHelper.collapsedTypeface != typeface) {
                collapsingTextHelper.collapsedTypeface = typeface;
            } else {
                z = false;
            }
            if (z) {
                collapsingTextHelper.recalculate();
            }
        }
    }
}
