package com.google.android.material.internal;

import android.graphics.Typeface;
import android.text.TextPaint;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

public class TextDrawableHelper {
    public WeakReference<TextDrawableDelegate> delegate = new WeakReference<>(null);
    public final TextAppearanceFontCallback fontCallback = new TextAppearanceFontCallback() {
        /* class com.google.android.material.internal.TextDrawableHelper.AnonymousClass1 */

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrievalFailed(int i) {
            TextDrawableHelper textDrawableHelper = TextDrawableHelper.this;
            textDrawableHelper.textWidthDirty = true;
            TextDrawableDelegate textDrawableDelegate = textDrawableHelper.delegate.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrieved(Typeface typeface, boolean z) {
            if (!z) {
                TextDrawableHelper textDrawableHelper = TextDrawableHelper.this;
                textDrawableHelper.textWidthDirty = true;
                TextDrawableDelegate textDrawableDelegate = textDrawableHelper.delegate.get();
                if (textDrawableDelegate != null) {
                    textDrawableDelegate.onTextSizeChange();
                }
            }
        }
    };
    public TextAppearance textAppearance;
    public final TextPaint textPaint = new TextPaint(1);
    public float textWidth;
    public boolean textWidthDirty = true;

    public interface TextDrawableDelegate {
        int[] getState();

        boolean onStateChange(int[] iArr);

        void onTextSizeChange();
    }

    public TextDrawableHelper(TextDrawableDelegate textDrawableDelegate) {
        this.delegate = new WeakReference<>(textDrawableDelegate);
    }

    public float getTextWidth(String str) {
        float f;
        if (!this.textWidthDirty) {
            return this.textWidth;
        }
        if (str == null) {
            f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        } else {
            f = this.textPaint.measureText((CharSequence) str, 0, str.length());
        }
        this.textWidth = f;
        this.textWidthDirty = false;
        return f;
    }
}
