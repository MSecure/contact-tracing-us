package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MaterialToolbar extends Toolbar {
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_Toolbar;

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(ThemeEnforcement.createThemedContext(context, attributeSet, r0, DEF_STYLE_RES), attributeSet, r0);
        int i = R$attr.toolbarStyle;
        Context context2 = getContext();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            materialShapeDrawable.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context2);
            materialShapeDrawable.updateZ();
            materialShapeDrawable.setElevation(ViewCompat.getElevation(this));
            setBackground(materialShapeDrawable);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ReactYogaConfigProvider.setParentAbsoluteElevation(this, (MaterialShapeDrawable) background);
        }
    }

    public void setElevation(float f) {
        super.setElevation(f);
        ReactYogaConfigProvider.setElevation(this, f);
    }
}
