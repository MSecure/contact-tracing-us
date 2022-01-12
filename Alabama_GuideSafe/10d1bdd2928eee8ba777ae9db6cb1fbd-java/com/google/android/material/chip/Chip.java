package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.text.BidiFormatter;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable {
    public static final int[] CHECKABLE_STATE_SET = {16842911};
    public static final Rect EMPTY_BOUNDS = new Rect();
    public static final int[] SELECTED_STATE = {16842913};
    public ChipDrawable chipDrawable;
    public boolean closeIconFocused;
    public boolean closeIconHovered;
    public boolean closeIconPressed;
    public boolean deferredCheckedValue;
    public boolean ensureMinTouchTargetSize;
    public final TextAppearanceFontCallback fontCallback = new TextAppearanceFontCallback() {
        /* class com.google.android.material.chip.Chip.AnonymousClass1 */

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrievalFailed(int i) {
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrieved(Typeface typeface, boolean z) {
            CharSequence charSequence;
            Chip chip = Chip.this;
            ChipDrawable chipDrawable = chip.chipDrawable;
            if (chipDrawable.shouldDrawText) {
                charSequence = chipDrawable.text;
            } else {
                charSequence = chip.getText();
            }
            chip.setText(charSequence);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    };
    public InsetDrawable insetBackgroundDrawable;
    public int lastLayoutDirection;
    public int minTouchTargetSize;
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    public View.OnClickListener onCloseIconClickListener;
    public final Rect rect = new Rect();
    public final RectF rectF = new RectF();
    public RippleDrawable ripple;
    public final ChipTouchHelper touchHelper;

    public class ChipTouchHelper extends ExploreByTouchHelper {
        public ChipTouchHelper(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> list) {
            boolean z = false;
            list.add(0);
            if (Chip.this.hasCloseIcon()) {
                ChipDrawable chipDrawable = Chip.this.chipDrawable;
                if (chipDrawable != null && chipDrawable.closeIconVisible) {
                    z = true;
                }
                if (z) {
                    list.add(1);
                }
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i2 == 16) {
                if (i == 0) {
                    return Chip.this.performClick();
                }
                if (i == 1) {
                    Chip chip = Chip.this;
                    chip.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip.onCloseIconClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    chip.touchHelper.sendEventForVirtualView(1, 1);
                }
            }
            return z;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str = "";
            if (i == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfoCompat.mInfo.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = R$string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        str = text;
                    }
                    objArr[0] = str;
                    accessibilityNodeInfoCompat.mInfo.setContentDescription(context.getString(i2, objArr).trim());
                }
                accessibilityNodeInfoCompat.mInfo.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfoCompat.mInfo.setEnabled(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.mInfo.setContentDescription(str);
            accessibilityNodeInfoCompat.mInfo.setBoundsInParent(Chip.EMPTY_BOUNDS);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r6);
        int resourceId;
        int i = R$attr.chipStyle;
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", AppStateModule.APP_STATE_BACKGROUND) != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        int i2 = R$style.Widget_MaterialComponents_Chip_Action;
        ChipDrawable chipDrawable2 = new ChipDrawable(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(chipDrawable2.context, attributeSet, R$styleable.Chip, i, i2, new int[0]);
        chipDrawable2.isShapeThemingEnabled = obtainStyledAttributes.hasValue(R$styleable.Chip_shapeAppearance);
        ColorStateList colorStateList = ReactYogaConfigProvider.getColorStateList(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_chipSurfaceColor);
        if (chipDrawable2.chipSurfaceColor != colorStateList) {
            chipDrawable2.chipSurfaceColor = colorStateList;
            chipDrawable2.onStateChange(chipDrawable2.getState());
        }
        chipDrawable2.setChipBackgroundColor(ReactYogaConfigProvider.getColorStateList(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_chipBackgroundColor));
        chipDrawable2.setChipMinHeight(obtainStyledAttributes.getDimension(R$styleable.Chip_chipMinHeight, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        if (obtainStyledAttributes.hasValue(R$styleable.Chip_chipCornerRadius)) {
            chipDrawable2.setChipCornerRadius(obtainStyledAttributes.getDimension(R$styleable.Chip_chipCornerRadius, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        }
        chipDrawable2.setChipStrokeColor(ReactYogaConfigProvider.getColorStateList(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_chipStrokeColor));
        chipDrawable2.setChipStrokeWidth(obtainStyledAttributes.getDimension(R$styleable.Chip_chipStrokeWidth, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setRippleColor(ReactYogaConfigProvider.getColorStateList(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_rippleColor));
        chipDrawable2.setText(obtainStyledAttributes.getText(R$styleable.Chip_android_text));
        Context context2 = chipDrawable2.context;
        int i3 = R$styleable.Chip_android_textAppearance;
        chipDrawable2.setTextAppearance((!obtainStyledAttributes.hasValue(i3) || (resourceId = obtainStyledAttributes.getResourceId(i3, 0)) == 0) ? null : new TextAppearance(context2, resourceId));
        int i4 = obtainStyledAttributes.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i4 == 1) {
            chipDrawable2.truncateAt = TextUtils.TruncateAt.START;
        } else if (i4 == 2) {
            chipDrawable2.truncateAt = TextUtils.TruncateAt.MIDDLE;
        } else if (i4 == 3) {
            chipDrawable2.truncateAt = TextUtils.TruncateAt.END;
        }
        chipDrawable2.setChipIconVisible(obtainStyledAttributes.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            chipDrawable2.setChipIconVisible(obtainStyledAttributes.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        chipDrawable2.setChipIcon(ReactYogaConfigProvider.getDrawable(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_chipIcon));
        if (obtainStyledAttributes.hasValue(R$styleable.Chip_chipIconTint)) {
            chipDrawable2.setChipIconTint(ReactYogaConfigProvider.getColorStateList(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_chipIconTint));
        }
        chipDrawable2.setChipIconSize(obtainStyledAttributes.getDimension(R$styleable.Chip_chipIconSize, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setCloseIconVisible(obtainStyledAttributes.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            chipDrawable2.setCloseIconVisible(obtainStyledAttributes.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        chipDrawable2.setCloseIcon(ReactYogaConfigProvider.getDrawable(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_closeIcon));
        chipDrawable2.setCloseIconTint(ReactYogaConfigProvider.getColorStateList(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_closeIconTint));
        chipDrawable2.setCloseIconSize(obtainStyledAttributes.getDimension(R$styleable.Chip_closeIconSize, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setCheckable(obtainStyledAttributes.getBoolean(R$styleable.Chip_android_checkable, false));
        chipDrawable2.setCheckedIconVisible(obtainStyledAttributes.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            chipDrawable2.setCheckedIconVisible(obtainStyledAttributes.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        chipDrawable2.setCheckedIcon(ReactYogaConfigProvider.getDrawable(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_checkedIcon));
        chipDrawable2.showMotionSpec = MotionSpec.createFromAttribute(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_showMotionSpec);
        chipDrawable2.hideMotionSpec = MotionSpec.createFromAttribute(chipDrawable2.context, obtainStyledAttributes, R$styleable.Chip_hideMotionSpec);
        chipDrawable2.setChipStartPadding(obtainStyledAttributes.getDimension(R$styleable.Chip_chipStartPadding, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setIconStartPadding(obtainStyledAttributes.getDimension(R$styleable.Chip_iconStartPadding, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setIconEndPadding(obtainStyledAttributes.getDimension(R$styleable.Chip_iconEndPadding, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setTextStartPadding(obtainStyledAttributes.getDimension(R$styleable.Chip_textStartPadding, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setTextEndPadding(obtainStyledAttributes.getDimension(R$styleable.Chip_textEndPadding, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setCloseIconStartPadding(obtainStyledAttributes.getDimension(R$styleable.Chip_closeIconStartPadding, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setCloseIconEndPadding(obtainStyledAttributes.getDimension(R$styleable.Chip_closeIconEndPadding, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.setChipEndPadding(obtainStyledAttributes.getDimension(R$styleable.Chip_chipEndPadding, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        chipDrawable2.maxWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.Chip, i, R$style.Widget_MaterialComponents_Chip_Action, new int[0]);
        this.ensureMinTouchTargetSize = obtainStyledAttributes2.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.minTouchTargetSize = (int) Math.ceil((double) obtainStyledAttributes2.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) TypedValue.applyDimension(1, (float) 48, getContext().getResources().getDisplayMetrics()))));
        obtainStyledAttributes2.recycle();
        setChipDrawable(chipDrawable2);
        chipDrawable2.setElevation(getElevation());
        TypedArray obtainStyledAttributes3 = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.Chip, i, R$style.Widget_MaterialComponents_Chip_Action, new int[0]);
        boolean hasValue = obtainStyledAttributes3.hasValue(R$styleable.Chip_shapeAppearance);
        obtainStyledAttributes3.recycle();
        ChipTouchHelper chipTouchHelper = new ChipTouchHelper(this);
        this.touchHelper = chipTouchHelper;
        if (Build.VERSION.SDK_INT >= 24) {
            ViewCompat.setAccessibilityDelegate(this, chipTouchHelper);
        } else {
            updateAccessibilityDelegate();
        }
        if (!hasValue) {
            setOutlineProvider(new ViewOutlineProvider() {
                /* class com.google.android.material.chip.Chip.AnonymousClass2 */

                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    ChipDrawable chipDrawable = Chip.this.chipDrawable;
                    if (chipDrawable != null) {
                        chipDrawable.getOutline(outline);
                    } else {
                        outline.setAlpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    }
                }
            });
        }
        setChecked(this.deferredCheckedValue);
        setText(chipDrawable2.text);
        setEllipsize(chipDrawable2.truncateAt);
        setIncludeFontPadding(false);
        updateTextPaintDrawState();
        if (!this.chipDrawable.shouldDrawText) {
            setSingleLine();
        }
        setGravity(8388627);
        updatePaddingInternal();
        if (this.ensureMinTouchTargetSize) {
            setMinHeight(this.minTouchTargetSize);
        }
        this.lastLayoutDirection = getLayoutDirection();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon()) {
            ChipDrawable chipDrawable2 = this.chipDrawable;
            chipDrawable2.calculateCloseIconTouchBounds(chipDrawable2.getBounds(), this.rectF);
        }
        return this.rectF;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.rect;
    }

    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.textDrawableHelper.textAppearance;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.closeIconHovered != z) {
            this.closeIconHovered = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.closeIconPressed != z) {
            this.closeIconPressed = z;
            refreshDrawableState();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int i;
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.touchHelper)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.touchHelper, Integer.valueOf((int) RecyclerView.UNDEFINED_DURATION));
                    z = true;
                    if (!z) {
                        return true;
                    }
                    ChipTouchHelper chipTouchHelper = this.touchHelper;
                    if (chipTouchHelper.mManager.isEnabled() && chipTouchHelper.mManager.isTouchExplorationEnabled()) {
                        int action = motionEvent.getAction();
                        if (action == 7 || action == 9) {
                            int i2 = (!Chip.this.hasCloseIcon() || !Chip.this.getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY())) ? 0 : 1;
                            int i3 = chipTouchHelper.mHoveredVirtualViewId;
                            if (i3 != i2) {
                                chipTouchHelper.mHoveredVirtualViewId = i2;
                                chipTouchHelper.sendEventForVirtualView(i2, 128);
                                chipTouchHelper.sendEventForVirtualView(i3, 256);
                            }
                        } else if (action == 10 && (i = chipTouchHelper.mHoveredVirtualViewId) != Integer.MIN_VALUE) {
                            if (i != Integer.MIN_VALUE) {
                                chipTouchHelper.mHoveredVirtualViewId = RecyclerView.UNDEFINED_DURATION;
                                chipTouchHelper.sendEventForVirtualView(RecyclerView.UNDEFINED_DURATION, 128);
                                chipTouchHelper.sendEventForVirtualView(i, 256);
                            }
                        }
                        z2 = true;
                        return z2 || super.dispatchHoverEvent(motionEvent);
                    }
                    z2 = false;
                    if (z2) {
                        return true;
                    }
                }
            } catch (NoSuchMethodException e) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e);
            } catch (IllegalAccessException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (InvocationTargetException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (NoSuchFieldException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            }
        }
        z = false;
        if (!z) {
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ChipTouchHelper chipTouchHelper = this.touchHelper;
        if (chipTouchHelper != null) {
            boolean z = false;
            int i = 0;
            z = false;
            z = false;
            z = false;
            z = false;
            z = false;
            if (keyEvent.getAction() != 1) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 61) {
                    int i2 = 66;
                    if (keyCode != 66) {
                        switch (keyCode) {
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                                if (keyEvent.hasNoModifiers()) {
                                    if (keyCode == 19) {
                                        i2 = 33;
                                    } else if (keyCode == 21) {
                                        i2 = 17;
                                    } else if (keyCode != 22) {
                                        i2 = 130;
                                    }
                                    int repeatCount = keyEvent.getRepeatCount() + 1;
                                    boolean z2 = false;
                                    while (i < repeatCount && chipTouchHelper.moveFocus(i2, null)) {
                                        i++;
                                        z2 = true;
                                    }
                                    z = z2;
                                    break;
                                }
                                break;
                        }
                    }
                    if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                        int i3 = chipTouchHelper.mKeyboardFocusedVirtualViewId;
                        if (i3 != Integer.MIN_VALUE) {
                            chipTouchHelper.onPerformActionForVirtualView(i3, 16, null);
                        }
                        z = true;
                    }
                } else if (keyEvent.hasNoModifiers()) {
                    z = chipTouchHelper.moveFocus(2, null);
                } else if (keyEvent.hasModifiers(1)) {
                    z = chipTouchHelper.moveFocus(1, null);
                }
            }
            if (!z || this.touchHelper.mKeyboardFocusedVirtualViewId == Integer.MIN_VALUE) {
                return super.dispatchKeyEvent(keyEvent);
            }
            return true;
        }
        throw null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [int, boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable chipDrawable2 = this.chipDrawable;
        boolean z = false;
        int i = 0;
        z = false;
        if (chipDrawable2 != null && ChipDrawable.isStateful(chipDrawable2.closeIcon)) {
            ChipDrawable chipDrawable3 = this.chipDrawable;
            ?? isEnabled = isEnabled();
            int i2 = isEnabled;
            if (this.closeIconFocused) {
                i2 = isEnabled + 1;
            }
            int i3 = i2;
            if (this.closeIconHovered) {
                i3 = i2 + 1;
            }
            int i4 = i3;
            if (this.closeIconPressed) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.closeIconFocused) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.closeIconHovered) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.closeIconPressed) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            z = chipDrawable3.setCloseIconState(iArr);
        }
        if (z) {
            invalidate();
        }
    }

    public boolean ensureAccessibleTouchTarget(int i) {
        this.minTouchTargetSize = i;
        int i2 = 0;
        if (!this.ensureMinTouchTargetSize) {
            removeBackgroundInset();
            return false;
        }
        int max = Math.max(0, i - ((int) this.chipDrawable.chipMinHeight));
        int max2 = Math.max(0, i - this.chipDrawable.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i3 = max2 > 0 ? max2 / 2 : 0;
            if (max > 0) {
                i2 = max / 2;
            }
            if (this.insetBackgroundDrawable != null) {
                Rect rect2 = new Rect();
                this.insetBackgroundDrawable.getPadding(rect2);
                if (rect2.top == i2 && rect2.bottom == i2 && rect2.left == i3 && rect2.right == i3) {
                    return true;
                }
            }
            if (getMinHeight() != i) {
                setMinHeight(i);
            }
            if (getMinWidth() != i) {
                setMinWidth(i);
            }
            this.insetBackgroundDrawable = new InsetDrawable((Drawable) this.chipDrawable, i3, i2, i3, i2);
            return true;
        }
        removeBackgroundInset();
        return false;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.insetBackgroundDrawable;
        return insetDrawable == null ? this.chipDrawable : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.checkedIcon;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipBackgroundColor;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.getChipCornerRadius() : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.chipEndPadding : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null || (drawable = chipDrawable2.chipIcon) == null) {
            return null;
        }
        return AppCompatDelegateImpl.ConfigurationImplApi17.unwrap(drawable);
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.chipIconSize : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipIconTint;
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.chipMinHeight : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.chipStartPadding : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipStrokeColor;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.chipStrokeWidth : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCloseIcon();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconContentDescription;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.closeIconEndPadding : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.closeIconSize : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.closeIconStartPadding : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconTint;
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.truncateAt;
        }
        return null;
    }

    public void getFocusedRect(Rect rect2) {
        ChipTouchHelper chipTouchHelper = this.touchHelper;
        if (chipTouchHelper.mKeyboardFocusedVirtualViewId == 1 || chipTouchHelper.mAccessibilityFocusedVirtualViewId == 1) {
            rect2.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect2);
        }
    }

    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.hideMotionSpec;
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.iconEndPadding : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.iconStartPadding : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.rippleColor;
        }
        return null;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.drawableState.shapeAppearanceModel;
    }

    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.showMotionSpec;
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.textEndPadding : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.textStartPadding : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public final boolean hasCloseIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return (chipDrawable2 == null || chipDrawable2.getCloseIcon() == null) ? false : true;
    }

    public boolean isCheckable() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null && chipDrawable2.checkable;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ReactYogaConfigProvider.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
        updateFrameworkRippleBackground();
        updatePaddingInternal();
        requestLayout();
        invalidateOutline();
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, SELECTED_STATE);
        }
        if (isCheckable()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onFocusChanged(boolean z, int i, Rect rect2) {
        super.onFocusChanged(z, i, rect2);
        ChipTouchHelper chipTouchHelper = this.touchHelper;
        int i2 = chipTouchHelper.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            chipTouchHelper.clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            chipTouchHelper.moveFocus(i, rect2);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (isCheckable() || isClickable()) {
            accessibilityNodeInfo.setClassName(isCheckable() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), RNCWebViewManager.COMMAND_CLEAR_HISTORY);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.lastLayoutDirection != i) {
            this.lastLayoutDirection = i;
            updatePaddingInternal();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.closeIconPressed) {
                        if (!contains) {
                            setCloseIconPressed(false);
                        }
                    }
                }
                z = false;
                return !z || super.onTouchEvent(motionEvent);
            } else if (this.closeIconPressed) {
                playSoundEffect(0);
                View.OnClickListener onClickListener = this.onCloseIconClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                this.touchHelper.sendEventForVirtualView(1, 1);
                z = true;
                setCloseIconPressed(false);
                if (!z) {
                }
            }
            z = false;
            setCloseIconPressed(false);
            if (!z) {
            }
        }
        if (contains) {
            setCloseIconPressed(true);
        }
        z = false;
        if (!z) {
        }
        z = true;
        if (!z) {
        }
    }

    public final void removeBackgroundInset() {
        if (this.insetBackgroundDrawable != null) {
            this.insetBackgroundDrawable = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
            updateFrameworkRippleBackground();
        }
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.ripple) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.ripple) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckable(z);
        }
    }

    public void setCheckableResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckable(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null) {
            this.deferredCheckedValue = z;
        } else if (chipDrawable2.checkable) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.onCheckedChangeListenerInternal) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIcon(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIcon(AppCompatResources.getDrawable(chipDrawable2.context, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconVisible(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipBackgroundColor != colorStateList) {
            chipDrawable2.chipBackgroundColor = colorStateList;
            chipDrawable2.onStateChange(chipDrawable2.getState());
        }
    }

    public void setChipBackgroundColorResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipBackgroundColor(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipCornerRadius(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipCornerRadius(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(ChipDrawable chipDrawable2) {
        ChipDrawable chipDrawable3 = this.chipDrawable;
        if (chipDrawable3 != chipDrawable2) {
            if (chipDrawable3 != null) {
                chipDrawable3.delegate = new WeakReference<>(null);
            }
            this.chipDrawable = chipDrawable2;
            chipDrawable2.shouldDrawText = false;
            if (chipDrawable2 != null) {
                chipDrawable2.delegate = new WeakReference<>(this);
                ensureAccessibleTouchTarget(this.minTouchTargetSize);
                boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
                updateFrameworkRippleBackground();
                return;
            }
            throw null;
        }
    }

    public void setChipEndPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipEndPadding != f) {
            chipDrawable2.chipEndPadding = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setChipEndPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipIcon(Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIcon(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIcon(AppCompatResources.getDrawable(chipDrawable2.context, i));
        }
    }

    public void setChipIconSize(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconSize(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconSize(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconTint(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconTint(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setChipIconVisible(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconVisible(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipMinHeight != f) {
            chipDrawable2.chipMinHeight = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setChipMinHeightResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipMinHeight(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipStartPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipStartPadding != f) {
            chipDrawable2.chipStartPadding = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setChipStartPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeColor(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeColor(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeWidth(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeWidth(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIcon(drawable);
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder;
        String str;
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.closeIconContentDescription != charSequence) {
            BidiFormatter instance = BidiFormatter.getInstance();
            TextDirectionHeuristicCompat textDirectionHeuristicCompat = instance.mDefaultTextDirectionHeuristicCompat;
            if (charSequence == null) {
                spannableStringBuilder = null;
            } else {
                boolean isRtl = ((TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl) textDirectionHeuristicCompat).isRtl(charSequence, 0, charSequence.length());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                String str2 = "";
                if ((instance.mFlags & 2) != 0) {
                    boolean isRtl2 = ((TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl) (isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR)).isRtl(charSequence, 0, charSequence.length());
                    if (instance.mIsRtlContext || (!isRtl2 && BidiFormatter.getEntryDir(charSequence) != 1)) {
                        str = (!instance.mIsRtlContext || (isRtl2 && BidiFormatter.getEntryDir(charSequence) != -1)) ? str2 : BidiFormatter.RLM_STRING;
                    } else {
                        str = BidiFormatter.LRM_STRING;
                    }
                    spannableStringBuilder2.append((CharSequence) str);
                }
                if (isRtl != instance.mIsRtlContext) {
                    spannableStringBuilder2.append(isRtl ? (char) 8235 : 8234);
                    spannableStringBuilder2.append(charSequence);
                    spannableStringBuilder2.append((char) 8236);
                } else {
                    spannableStringBuilder2.append(charSequence);
                }
                boolean isRtl3 = ((TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl) (isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR)).isRtl(charSequence, 0, charSequence.length());
                if (!instance.mIsRtlContext && (isRtl3 || BidiFormatter.getExitDir(charSequence) == 1)) {
                    str2 = BidiFormatter.LRM_STRING;
                } else if (instance.mIsRtlContext && (!isRtl3 || BidiFormatter.getExitDir(charSequence) == -1)) {
                    str2 = BidiFormatter.RLM_STRING;
                }
                spannableStringBuilder2.append((CharSequence) str2);
                spannableStringBuilder = spannableStringBuilder2;
            }
            chipDrawable2.closeIconContentDescription = spannableStringBuilder;
            chipDrawable2.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconEndPadding(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIcon(AppCompatResources.getDrawable(chipDrawable2.context, i));
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconSize(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconSize(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconStartPadding(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconTint(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconTint(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setElevation(float f) {
        super.setElevation(f);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = chipDrawable2.drawableState;
            if (materialShapeDrawableState.elevation != f) {
                materialShapeDrawableState.elevation = f;
                chipDrawable2.updateZ();
            }
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.chipDrawable != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                ChipDrawable chipDrawable2 = this.chipDrawable;
                if (chipDrawable2 != null) {
                    chipDrawable2.truncateAt = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.ensureMinTouchTargetSize = z;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.hideMotionSpec = motionSpec;
        }
    }

    public void setHideMotionSpecResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.hideMotionSpec = MotionSpec.createFromResource(chipDrawable2.context, i);
        }
    }

    public void setIconEndPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconEndPadding(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconStartPadding(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setLayoutDirection(int i) {
        if (this.chipDrawable != null) {
            super.setLayoutDirection(i);
        }
    }

    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.maxWidth = i;
        }
    }

    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListenerInternal = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.onCloseIconClickListener = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setRippleColor(colorStateList);
        }
        if (!this.chipDrawable.useCompatRipple) {
            updateFrameworkRippleBackground();
        }
    }

    public void setRippleColorResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setRippleColor(AppCompatResources.getColorStateList(chipDrawable2.context, i));
            if (!this.chipDrawable.useCompatRipple) {
                updateFrameworkRippleBackground();
            }
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        chipDrawable2.drawableState.shapeAppearanceModel = shapeAppearanceModel;
        chipDrawable2.invalidateSelf();
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.showMotionSpec = motionSpec;
        }
    }

    public void setShowMotionSpecResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.showMotionSpec = MotionSpec.createFromResource(chipDrawable2.context, i);
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.chipDrawable != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(this.chipDrawable.shouldDrawText ? null : charSequence, bufferType);
            ChipDrawable chipDrawable2 = this.chipDrawable;
            if (chipDrawable2 != null) {
                chipDrawable2.setText(charSequence);
            }
        }
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearance(textAppearance);
        }
        updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.textEndPadding != f) {
            chipDrawable2.textEndPadding = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setTextEndPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setTextStartPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.textStartPadding != f) {
            chipDrawable2.textStartPadding = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setTextStartPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public final void updateAccessibilityDelegate() {
        if (Build.VERSION.SDK_INT < 24) {
            if (hasCloseIcon()) {
                ChipDrawable chipDrawable2 = this.chipDrawable;
                if (chipDrawable2 != null && chipDrawable2.closeIconVisible) {
                    ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
                    return;
                }
            }
            ViewCompat.setAccessibilityDelegate(this, null);
        }
    }

    public final void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.rippleColor), getBackgroundDrawable(), null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.ripple);
    }

    public final void updatePaddingInternal() {
        ChipDrawable chipDrawable2;
        if (!TextUtils.isEmpty(getText()) && (chipDrawable2 = this.chipDrawable) != null) {
            float calculateCloseIconWidth = chipDrawable2.calculateCloseIconWidth();
            ChipDrawable chipDrawable3 = this.chipDrawable;
            ViewCompat.setPaddingRelative(this, (int) (chipDrawable3.calculateChipIconWidth() + chipDrawable3.chipStartPadding + chipDrawable3.textStartPadding), getPaddingTop(), (int) (calculateCloseIconWidth + chipDrawable2.chipEndPadding + chipDrawable2.textEndPadding), getPaddingBottom());
        }
    }

    public final void updateTextPaintDrawState() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            paint.drawableState = chipDrawable2.getState();
        }
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.updateDrawState(getContext(), paint, this.fontCallback);
        }
    }

    public void setCloseIconVisible(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconVisible(z);
        }
        updateAccessibilityDelegate();
    }

    public void setCheckedIconVisible(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconVisible(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconVisible(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearance(new TextAppearance(chipDrawable2.context, i));
        }
        updateTextPaintDrawState();
    }

    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearance(new TextAppearance(chipDrawable2.context, i));
        }
        updateTextPaintDrawState();
    }
}
