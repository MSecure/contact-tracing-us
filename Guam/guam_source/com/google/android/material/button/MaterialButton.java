package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    public static final int[] CHECKABLE_STATE_SET = {16842911};
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_Button;
    public boolean broadcasting = false;
    public boolean checked = false;
    public Drawable icon;
    public int iconGravity;
    public int iconLeft;
    public int iconPadding;
    public int iconSize;
    public ColorStateList iconTint;
    public PorterDuff.Mode iconTintMode;
    public final MaterialButtonHelper materialButtonHelper;
    public final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners = new LinkedHashSet<>();
    public OnPressedChangeListener onPressedChangeListenerInternal;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z);
    }

    public interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton materialButton, boolean z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(ThemeEnforcement.createThemedContext(context, attributeSet, r8, DEF_STYLE_RES), attributeSet, r8);
        int i = R$attr.materialButtonStyle;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialButton, i, DEF_STYLE_RES, new int[0]);
        this.iconPadding = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ReactYogaConfigProvider.parseTintMode(obtainStyledAttributes.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = ReactYogaConfigProvider.getColorStateList(getContext(), obtainStyledAttributes, R$styleable.MaterialButton_iconTint);
        this.icon = ReactYogaConfigProvider.getDrawable(getContext(), obtainStyledAttributes, R$styleable.MaterialButton_icon);
        this.iconGravity = obtainStyledAttributes.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.iconSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        MaterialButtonHelper materialButtonHelper2 = new MaterialButtonHelper(this, ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES).build());
        this.materialButtonHelper = materialButtonHelper2;
        materialButtonHelper2.insetLeft = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        materialButtonHelper2.insetRight = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        materialButtonHelper2.insetTop = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        materialButtonHelper2.insetBottom = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        if (obtainStyledAttributes.hasValue(R$styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, -1);
            materialButtonHelper2.cornerRadius = dimensionPixelSize;
            materialButtonHelper2.setShapeAppearanceModel(materialButtonHelper2.shapeAppearanceModel.withCornerSize((float) dimensionPixelSize));
            materialButtonHelper2.cornerRadiusSet = true;
        }
        materialButtonHelper2.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        materialButtonHelper2.backgroundTintMode = ReactYogaConfigProvider.parseTintMode(obtainStyledAttributes.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        materialButtonHelper2.backgroundTint = ReactYogaConfigProvider.getColorStateList(materialButtonHelper2.materialButton.getContext(), obtainStyledAttributes, R$styleable.MaterialButton_backgroundTint);
        materialButtonHelper2.strokeColor = ReactYogaConfigProvider.getColorStateList(materialButtonHelper2.materialButton.getContext(), obtainStyledAttributes, R$styleable.MaterialButton_strokeColor);
        materialButtonHelper2.rippleColor = ReactYogaConfigProvider.getColorStateList(materialButtonHelper2.materialButton.getContext(), obtainStyledAttributes, R$styleable.MaterialButton_rippleColor);
        materialButtonHelper2.checkable = obtainStyledAttributes.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(materialButtonHelper2.materialButton);
        int paddingTop = materialButtonHelper2.materialButton.getPaddingTop();
        int paddingEnd = materialButtonHelper2.materialButton.getPaddingEnd();
        int paddingBottom = materialButtonHelper2.materialButton.getPaddingBottom();
        MaterialButton materialButton = materialButtonHelper2.materialButton;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialButtonHelper2.shapeAppearanceModel);
        materialShapeDrawable.initializeElevationOverlay(materialButtonHelper2.materialButton.getContext());
        materialShapeDrawable.setTintList(materialButtonHelper2.backgroundTint);
        PorterDuff.Mode mode = materialButtonHelper2.backgroundTintMode;
        if (mode != null) {
            materialShapeDrawable.setTintMode(mode);
        }
        materialShapeDrawable.setStroke((float) materialButtonHelper2.strokeWidth, materialButtonHelper2.strokeColor);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialButtonHelper2.shapeAppearanceModel);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.setStroke((float) materialButtonHelper2.strokeWidth, materialButtonHelper2.shouldDrawSurfaceColorStroke ? ReactYogaConfigProvider.getColor(materialButtonHelper2.materialButton, R$attr.colorSurface) : 0);
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialButtonHelper2.shapeAppearanceModel);
        materialButtonHelper2.maskDrawable = materialShapeDrawable3;
        materialShapeDrawable3.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(materialButtonHelper2.rippleColor), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), materialButtonHelper2.insetLeft, materialButtonHelper2.insetTop, materialButtonHelper2.insetRight, materialButtonHelper2.insetBottom), materialButtonHelper2.maskDrawable);
        materialButtonHelper2.rippleDrawable = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        MaterialShapeDrawable materialShapeDrawable4 = materialButtonHelper2.getMaterialShapeDrawable();
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setElevation((float) dimensionPixelSize2);
        }
        materialButtonHelper2.materialButton.setPaddingRelative(paddingStart + materialButtonHelper2.insetLeft, paddingTop + materialButtonHelper2.insetTop, paddingEnd + materialButtonHelper2.insetRight, paddingBottom + materialButtonHelper2.insetBottom);
        obtainStyledAttributes.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        updateIcon(this.icon != null);
    }

    private String getA11yClassName() {
        return (isCheckable() ? CompoundButton.class : Button.class).getName();
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.cornerRadius;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.rippleColor;
        }
        return null;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.shapeAppearanceModel;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.strokeColor;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.strokeWidth;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTint;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTintMode;
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
        return materialButtonHelper2 != null && materialButtonHelper2.checkable;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public final boolean isUsingOriginalBackground() {
        MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
        return materialButtonHelper2 != null && !materialButtonHelper2.backgroundOverwritten;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ReactYogaConfigProvider.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isCheckable()) {
            Button.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        updateIconPosition();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        updateIconPosition();
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.getMaterialShapeDrawable() != null) {
                materialButtonHelper2.getMaterialShapeDrawable().setTint(i);
                return;
            }
            return;
        }
        super.setBackgroundColor(i);
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setBackgroundDrawable(Drawable drawable) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            materialButtonHelper2.backgroundOverwritten = true;
            materialButtonHelper2.materialButton.setSupportBackgroundTintList(materialButtonHelper2.backgroundTint);
            materialButtonHelper2.materialButton.setSupportBackgroundTintMode(materialButtonHelper2.backgroundTintMode);
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.checkable = z;
        }
    }

    public void setChecked(boolean z) {
        if (isCheckable() && isEnabled() && this.checked != z) {
            this.checked = z;
            refreshDrawableState();
            if (!this.broadcasting) {
                this.broadcasting = true;
                Iterator<OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
                while (it.hasNext()) {
                    it.next().onCheckedChanged(this, this.checked);
                }
                this.broadcasting = false;
            }
        }
    }

    public void setCornerRadius(int i) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (!materialButtonHelper2.cornerRadiusSet || materialButtonHelper2.cornerRadius != i) {
                materialButtonHelper2.cornerRadius = i;
                materialButtonHelper2.cornerRadiusSet = true;
                materialButtonHelper2.setShapeAppearanceModel(materialButtonHelper2.shapeAppearanceModel.withCornerSize((float) i));
            }
        }
    }

    public void setCornerRadiusResource(int i) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setElevation(float f) {
        super.setElevation(f);
        if (isUsingOriginalBackground()) {
            MaterialShapeDrawable materialShapeDrawable = this.materialButtonHelper.getMaterialShapeDrawable();
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
            if (materialShapeDrawableState.elevation != f) {
                materialShapeDrawableState.elevation = f;
                materialShapeDrawable.updateZ();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon(true);
        }
    }

    public void setIconGravity(int i) {
        if (this.iconGravity != i) {
            this.iconGravity = i;
            updateIconPosition();
        }
    }

    public void setIconPadding(int i) {
        if (this.iconPadding != i) {
            this.iconPadding = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.iconSize != i) {
            this.iconSize = i;
            updateIcon(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(OnPressedChangeListener onPressedChangeListener) {
        this.onPressedChangeListenerInternal = onPressedChangeListener;
    }

    public void setPressed(boolean z) {
        OnPressedChangeListener onPressedChangeListener = this.onPressedChangeListenerInternal;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.onPressedChanged(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.rippleColor != colorStateList) {
                materialButtonHelper2.rippleColor = colorStateList;
                if (materialButtonHelper2.materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButtonHelper2.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShapeAppearanceModel(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            materialButtonHelper2.shouldDrawSurfaceColorStroke = z;
            materialButtonHelper2.updateStroke();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.strokeColor != colorStateList) {
                materialButtonHelper2.strokeColor = colorStateList;
                materialButtonHelper2.updateStroke();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.strokeWidth != i) {
                materialButtonHelper2.strokeWidth = i;
                materialButtonHelper2.updateStroke();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.backgroundTint != colorStateList) {
                materialButtonHelper2.backgroundTint = colorStateList;
                if (materialButtonHelper2.getMaterialShapeDrawable() != null) {
                    materialButtonHelper2.getMaterialShapeDrawable().setTintList(materialButtonHelper2.backgroundTint);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.backgroundTintMode != mode) {
                materialButtonHelper2.backgroundTintMode = mode;
                if (materialButtonHelper2.getMaterialShapeDrawable() != null && materialButtonHelper2.backgroundTintMode != null) {
                    materialButtonHelper2.getMaterialShapeDrawable().setTintMode(materialButtonHelper2.backgroundTintMode);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    public void toggle() {
        setChecked(!this.checked);
    }

    public final void updateIcon(boolean z) {
        Drawable drawable = this.icon;
        boolean z2 = false;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.icon = mutate;
            mutate.setTintList(this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                this.icon.setTintMode(mode);
            }
            int i = this.iconSize;
            if (i == 0) {
                i = this.icon.getIntrinsicWidth();
            }
            int i2 = this.iconSize;
            if (i2 == 0) {
                i2 = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i3 = this.iconLeft;
            drawable2.setBounds(i3, 0, i + i3, i2);
        }
        int i4 = this.iconGravity;
        boolean z3 = i4 == 1 || i4 == 2;
        if (!z) {
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            Drawable drawable3 = compoundDrawablesRelative[0];
            Drawable drawable4 = compoundDrawablesRelative[2];
            if ((z3 && drawable3 != this.icon) || (!z3 && drawable4 != this.icon)) {
                z2 = true;
            }
            if (!z2) {
                return;
            }
            if (z3) {
                setCompoundDrawablesRelative(this.icon, null, null, null);
            } else {
                setCompoundDrawablesRelative(null, null, this.icon, null);
            }
        } else if (z3) {
            setCompoundDrawablesRelative(this.icon, null, null, null);
        } else {
            setCompoundDrawablesRelative(null, null, this.icon, null);
        }
    }

    public final void updateIconPosition() {
        if (this.icon != null && getLayout() != null) {
            int i = this.iconGravity;
            boolean z = true;
            if (i == 1 || i == 3) {
                this.iconLeft = 0;
                updateIcon(false);
                return;
            }
            TextPaint paint = getPaint();
            String charSequence = getText().toString();
            if (getTransformationMethod() != null) {
                charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
            }
            int min = Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
            int i2 = this.iconSize;
            if (i2 == 0) {
                i2 = this.icon.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - min) - ViewCompat.getPaddingEnd(this)) - i2) - this.iconPadding) - getPaddingStart()) / 2;
            boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
            if (this.iconGravity != 4) {
                z = false;
            }
            if (z2 != z) {
                measuredWidth = -measuredWidth;
            }
            if (this.iconLeft != measuredWidth) {
                this.iconLeft = measuredWidth;
                updateIcon(false);
            }
        }
    }
}
