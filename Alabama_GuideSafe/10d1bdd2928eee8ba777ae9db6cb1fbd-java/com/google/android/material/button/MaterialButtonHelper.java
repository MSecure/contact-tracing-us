package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$attr;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

public class MaterialButtonHelper {
    public boolean backgroundOverwritten = false;
    public ColorStateList backgroundTint;
    public PorterDuff.Mode backgroundTintMode;
    public boolean checkable;
    public int cornerRadius;
    public boolean cornerRadiusSet = false;
    public int insetBottom;
    public int insetLeft;
    public int insetRight;
    public int insetTop;
    public Drawable maskDrawable;
    public final MaterialButton materialButton;
    public ColorStateList rippleColor;
    public LayerDrawable rippleDrawable;
    public ShapeAppearanceModel shapeAppearanceModel;
    public boolean shouldDrawSurfaceColorStroke = false;
    public ColorStateList strokeColor;
    public int strokeWidth;

    public MaterialButtonHelper(MaterialButton materialButton2, ShapeAppearanceModel shapeAppearanceModel2) {
        this.materialButton = materialButton2;
        this.shapeAppearanceModel = shapeAppearanceModel2;
    }

    public Shapeable getMaskDrawable() {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.rippleDrawable.getNumberOfLayers() > 2) {
            return (Shapeable) this.rippleDrawable.getDrawable(2);
        }
        return (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    public final MaterialShapeDrawable getMaterialShapeDrawable(boolean z) {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        if (getMaterialShapeDrawable() != null) {
            MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
            materialShapeDrawable.drawableState.shapeAppearanceModel = shapeAppearanceModel2;
            materialShapeDrawable.invalidateSelf();
        }
        if (getSurfaceColorStrokeDrawable() != null) {
            MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
            surfaceColorStrokeDrawable.drawableState.shapeAppearanceModel = shapeAppearanceModel2;
            surfaceColorStrokeDrawable.invalidateSelf();
        }
        if (getMaskDrawable() != null) {
            getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel2);
        }
    }

    public final void updateStroke() {
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
            if (surfaceColorStrokeDrawable != null) {
                surfaceColorStrokeDrawable.setStroke((float) this.strokeWidth, this.shouldDrawSurfaceColorStroke ? ReactYogaConfigProvider.getColor(this.materialButton, R$attr.colorSurface) : 0);
            }
        }
    }

    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }
}
