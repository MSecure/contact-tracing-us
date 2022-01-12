package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout {
    public static final int DEF_STYLE_RES = R$style.Widget_Design_TextInputLayout;
    public ValueAnimator animator;
    public MaterialShapeDrawable boxBackground;
    public int boxBackgroundColor;
    public int boxBackgroundMode;
    public final int boxCollapsedPaddingTopPx;
    public final int boxLabelCutoutPaddingPx;
    public int boxStrokeColor;
    public final int boxStrokeWidthDefaultPx;
    public final int boxStrokeWidthFocusedPx;
    public int boxStrokeWidthPx;
    public MaterialShapeDrawable boxUnderline;
    public final CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
    public boolean counterEnabled;
    public int counterMaxLength;
    public int counterOverflowTextAppearance;
    public ColorStateList counterOverflowTextColor;
    public boolean counterOverflowed;
    public int counterTextAppearance;
    public ColorStateList counterTextColor;
    public TextView counterView;
    public int defaultFilledBackgroundColor;
    public ColorStateList defaultHintTextColor;
    public final int defaultStrokeColor;
    public final int disabledColor;
    public final int disabledFilledBackgroundColor;
    public EditText editText;
    public final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners = new LinkedHashSet<>();
    public final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners = new LinkedHashSet<>();
    public final SparseArray<EndIconDelegate> endIconDelegates = new SparseArray<>();
    public Drawable endIconDummyDrawable;
    public final FrameLayout endIconFrame;
    public int endIconMode = 0;
    public View.OnLongClickListener endIconOnLongClickListener;
    public ColorStateList endIconTintList;
    public PorterDuff.Mode endIconTintMode;
    public final CheckableImageButton endIconView;
    public final CheckableImageButton errorIconView;
    public int focusedStrokeColor;
    public ColorStateList focusedTextColor;
    public boolean hasEndIconTintList;
    public boolean hasEndIconTintMode;
    public boolean hasStartIconTintList;
    public boolean hasStartIconTintMode;
    public CharSequence hint;
    public boolean hintAnimationEnabled;
    public boolean hintEnabled;
    public boolean hintExpanded;
    public final int hoveredFilledBackgroundColor;
    public final int hoveredStrokeColor;
    public boolean inDrawableStateChanged;
    public final IndicatorViewController indicatorViewController = new IndicatorViewController(this);
    public final FrameLayout inputFrame;
    public boolean isProvidingHint;
    public Drawable originalEditTextEndDrawable;
    public CharSequence originalHint;
    public boolean restoringSavedState;
    public ShapeAppearanceModel shapeAppearanceModel;
    public Drawable startIconDummyDrawable;
    public View.OnLongClickListener startIconOnLongClickListener;
    public ColorStateList startIconTintList;
    public PorterDuff.Mode startIconTintMode;
    public final CheckableImageButton startIconView;
    public final Rect tmpBoundsRect = new Rect();
    public final Rect tmpRect = new Rect();
    public final RectF tmpRectF = new RectF();
    public Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
            EditText editText = this.layout.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                accessibilityNodeInfoCompat.mInfo.setText(text);
            } else if (z2) {
                accessibilityNodeInfoCompat.mInfo.setText(hint);
            }
            if (z2) {
                accessibilityNodeInfoCompat.setHintText(hint);
                if (!z && z2) {
                    z4 = true;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.mInfo.setShowingHintText(z4);
                } else {
                    accessibilityNodeInfoCompat.setBooleanProperty(4, z4);
                }
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.mInfo.setError(error);
                accessibilityNodeInfoCompat.mInfo.setContentInvalid(true);
            }
        }
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout textInputLayout, int i);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class com.google.android.material.textfield.TextInputLayout.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        public CharSequence error;
        public boolean isEndIconChecked;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("TextInputLayout.SavedState{");
            outline17.append(Integer.toHexString(System.identityHashCode(this)));
            outline17.append(" error=");
            outline17.append((Object) this.error);
            outline17.append("}");
            return outline17.toString();
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() != 1 ? false : true;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(ThemeEnforcement.createThemedContext(context, attributeSet, r8, DEF_STYLE_RES), attributeSet, r8);
        int i = R$attr.textInputStyle;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.inputFrame = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.inputFrame);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.endIconFrame = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 8388629));
        this.inputFrame.addView(this.endIconFrame);
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        collapsingTextHelper2.textSizeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        collapsingTextHelper2.recalculate();
        CollapsingTextHelper collapsingTextHelper3 = this.collapsingTextHelper;
        collapsingTextHelper3.positionInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        collapsingTextHelper3.recalculate();
        CollapsingTextHelper collapsingTextHelper4 = this.collapsingTextHelper;
        if (collapsingTextHelper4.collapsedTextGravity != 8388659) {
            collapsingTextHelper4.collapsedTextGravity = 8388659;
            collapsingTextHelper4.recalculate();
        }
        int[] iArr = R$styleable.TextInputLayout;
        int i2 = DEF_STYLE_RES;
        int[] iArr2 = {R$styleable.TextInputLayout_counterTextAppearance, R$styleable.TextInputLayout_counterOverflowTextAppearance, R$styleable.TextInputLayout_errorTextAppearance, R$styleable.TextInputLayout_helperTextTextAppearance, R$styleable.TextInputLayout_hintTextAppearance};
        ThemeEnforcement.checkCompatibleTheme(context2, attributeSet, i, i2);
        ThemeEnforcement.checkTextAppearance(context2, attributeSet, iArr, i, i2, iArr2);
        TintTypedArray tintTypedArray = new TintTypedArray(context2, context2.obtainStyledAttributes(attributeSet, iArr, i, i2));
        this.hintEnabled = tintTypedArray.getBoolean(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(tintTypedArray.getText(R$styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = tintTypedArray.getBoolean(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES).build();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = tintTypedArray.getDimensionPixelOffset(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = tintTypedArray.getDimensionPixelSize(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = tintTypedArray.getDimensionPixelSize(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float dimension = tintTypedArray.getDimension(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = tintTypedArray.getDimension(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = tintTypedArray.getDimension(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = tintTypedArray.getDimension(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ShapeAppearanceModel shapeAppearanceModel2 = this.shapeAppearanceModel;
        if (shapeAppearanceModel2 != null) {
            ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel2);
            if (dimension >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                builder.setTopLeftCornerSize(dimension);
            }
            if (dimension2 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                builder.setTopRightCornerSize(dimension2);
            }
            if (dimension3 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                builder.setBottomRightCornerSize(dimension3);
            }
            if (dimension4 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                builder.setBottomLeftCornerSize(dimension4);
            }
            this.shapeAppearanceModel = builder.build();
            ColorStateList colorStateList = ReactYogaConfigProvider.getColorStateList(context2, tintTypedArray, R$styleable.TextInputLayout_boxBackgroundColor);
            if (colorStateList != null) {
                int defaultColor = colorStateList.getDefaultColor();
                this.defaultFilledBackgroundColor = defaultColor;
                this.boxBackgroundColor = defaultColor;
                if (colorStateList.isStateful()) {
                    this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                    this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623}, -1);
                } else {
                    ColorStateList colorStateList2 = AppCompatResources.getColorStateList(context2, R$color.mtrl_filled_background_color);
                    this.disabledFilledBackgroundColor = colorStateList2.getColorForState(new int[]{-16842910}, -1);
                    this.hoveredFilledBackgroundColor = colorStateList2.getColorForState(new int[]{16843623}, -1);
                }
            } else {
                this.boxBackgroundColor = 0;
                this.defaultFilledBackgroundColor = 0;
                this.disabledFilledBackgroundColor = 0;
                this.hoveredFilledBackgroundColor = 0;
            }
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_android_textColorHint)) {
                ColorStateList colorStateList3 = tintTypedArray.getColorStateList(R$styleable.TextInputLayout_android_textColorHint);
                this.focusedTextColor = colorStateList3;
                this.defaultHintTextColor = colorStateList3;
            }
            ColorStateList colorStateList4 = ReactYogaConfigProvider.getColorStateList(context2, tintTypedArray, R$styleable.TextInputLayout_boxStrokeColor);
            if (colorStateList4 == null || !colorStateList4.isStateful()) {
                this.focusedStrokeColor = tintTypedArray.getColor(R$styleable.TextInputLayout_boxStrokeColor, 0);
                this.defaultStrokeColor = ContextCompat.getColor(context2, R$color.mtrl_textinput_default_box_stroke_color);
                this.disabledColor = context2.getColor(R$color.mtrl_textinput_disabled_color);
                this.hoveredStrokeColor = context2.getColor(R$color.mtrl_textinput_hovered_box_stroke_color);
            } else {
                this.defaultStrokeColor = colorStateList4.getDefaultColor();
                this.disabledColor = colorStateList4.getColorForState(new int[]{-16842910}, -1);
                this.hoveredStrokeColor = colorStateList4.getColorForState(new int[]{16843623}, -1);
                this.focusedStrokeColor = colorStateList4.getColorForState(new int[]{16842908}, -1);
            }
            if (tintTypedArray.getResourceId(R$styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
                setHintTextAppearance(tintTypedArray.getResourceId(R$styleable.TextInputLayout_hintTextAppearance, 0));
            }
            int resourceId = tintTypedArray.getResourceId(R$styleable.TextInputLayout_errorTextAppearance, 0);
            boolean z = tintTypedArray.getBoolean(R$styleable.TextInputLayout_errorEnabled, false);
            CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_end_icon, (ViewGroup) this.inputFrame, false);
            this.errorIconView = checkableImageButton;
            this.inputFrame.addView(checkableImageButton);
            this.errorIconView.setVisibility(8);
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_errorIconDrawable)) {
                setErrorIconDrawable(tintTypedArray.getDrawable(R$styleable.TextInputLayout_errorIconDrawable));
            }
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_errorIconTint)) {
                setErrorIconTintList(ReactYogaConfigProvider.getColorStateList(context2, tintTypedArray, R$styleable.TextInputLayout_errorIconTint));
            }
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_errorIconTintMode)) {
                setErrorIconTintMode(ReactYogaConfigProvider.parseTintMode(tintTypedArray.getInt(R$styleable.TextInputLayout_errorIconTintMode, -1), null));
            }
            this.errorIconView.setContentDescription(getResources().getText(R$string.error_icon_content_description));
            ViewCompat.setImportantForAccessibility(this.errorIconView, 2);
            this.errorIconView.setClickable(false);
            this.errorIconView.setPressable(false);
            this.errorIconView.setFocusable(false);
            int resourceId2 = tintTypedArray.getResourceId(R$styleable.TextInputLayout_helperTextTextAppearance, 0);
            boolean z2 = tintTypedArray.getBoolean(R$styleable.TextInputLayout_helperTextEnabled, false);
            CharSequence text = tintTypedArray.getText(R$styleable.TextInputLayout_helperText);
            boolean z3 = tintTypedArray.getBoolean(R$styleable.TextInputLayout_counterEnabled, false);
            setCounterMaxLength(tintTypedArray.getInt(R$styleable.TextInputLayout_counterMaxLength, -1));
            this.counterTextAppearance = tintTypedArray.getResourceId(R$styleable.TextInputLayout_counterTextAppearance, 0);
            this.counterOverflowTextAppearance = tintTypedArray.getResourceId(R$styleable.TextInputLayout_counterOverflowTextAppearance, 0);
            CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this.inputFrame, false);
            this.startIconView = checkableImageButton2;
            this.inputFrame.addView(checkableImageButton2);
            this.startIconView.setVisibility(8);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_startIconDrawable)) {
                setStartIconDrawable(tintTypedArray.getDrawable(R$styleable.TextInputLayout_startIconDrawable));
                if (tintTypedArray.hasValue(R$styleable.TextInputLayout_startIconContentDescription)) {
                    setStartIconContentDescription(tintTypedArray.getText(R$styleable.TextInputLayout_startIconContentDescription));
                }
                setStartIconCheckable(tintTypedArray.getBoolean(R$styleable.TextInputLayout_startIconCheckable, true));
            }
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_startIconTint)) {
                setStartIconTintList(ReactYogaConfigProvider.getColorStateList(context2, tintTypedArray, R$styleable.TextInputLayout_startIconTint));
            }
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_startIconTintMode)) {
                setStartIconTintMode(ReactYogaConfigProvider.parseTintMode(tintTypedArray.getInt(R$styleable.TextInputLayout_startIconTintMode, -1), null));
            }
            setHelperTextEnabled(z2);
            setHelperText(text);
            setHelperTextTextAppearance(resourceId2);
            setErrorEnabled(z);
            setErrorTextAppearance(resourceId);
            setCounterTextAppearance(this.counterTextAppearance);
            setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_errorTextColor)) {
                setErrorTextColor(tintTypedArray.getColorStateList(R$styleable.TextInputLayout_errorTextColor));
            }
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_helperTextTextColor)) {
                setHelperTextColor(tintTypedArray.getColorStateList(R$styleable.TextInputLayout_helperTextTextColor));
            }
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_hintTextColor)) {
                setHintTextColor(tintTypedArray.getColorStateList(R$styleable.TextInputLayout_hintTextColor));
            }
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_counterTextColor)) {
                setCounterTextColor(tintTypedArray.getColorStateList(R$styleable.TextInputLayout_counterTextColor));
            }
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_counterOverflowTextColor)) {
                setCounterOverflowTextColor(tintTypedArray.getColorStateList(R$styleable.TextInputLayout_counterOverflowTextColor));
            }
            setCounterEnabled(z3);
            setBoxBackgroundMode(tintTypedArray.getInt(R$styleable.TextInputLayout_boxBackgroundMode, 0));
            CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_end_icon, (ViewGroup) this.endIconFrame, false);
            this.endIconView = checkableImageButton3;
            this.endIconFrame.addView(checkableImageButton3);
            this.endIconView.setVisibility(8);
            this.endIconDelegates.append(-1, new CustomEndIconDelegate(this));
            this.endIconDelegates.append(0, new NoEndIconDelegate(this));
            this.endIconDelegates.append(1, new PasswordToggleEndIconDelegate(this));
            this.endIconDelegates.append(2, new ClearTextEndIconDelegate(this));
            this.endIconDelegates.append(3, new DropdownMenuEndIconDelegate(this));
            if (tintTypedArray.hasValue(R$styleable.TextInputLayout_endIconMode)) {
                setEndIconMode(tintTypedArray.getInt(R$styleable.TextInputLayout_endIconMode, 0));
                if (tintTypedArray.hasValue(R$styleable.TextInputLayout_endIconDrawable)) {
                    setEndIconDrawable(tintTypedArray.getDrawable(R$styleable.TextInputLayout_endIconDrawable));
                }
                if (tintTypedArray.hasValue(R$styleable.TextInputLayout_endIconContentDescription)) {
                    setEndIconContentDescription(tintTypedArray.getText(R$styleable.TextInputLayout_endIconContentDescription));
                }
                setEndIconCheckable(tintTypedArray.getBoolean(R$styleable.TextInputLayout_endIconCheckable, true));
            } else if (tintTypedArray.hasValue(R$styleable.TextInputLayout_passwordToggleEnabled)) {
                setEndIconMode(tintTypedArray.getBoolean(R$styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
                setEndIconDrawable(tintTypedArray.getDrawable(R$styleable.TextInputLayout_passwordToggleDrawable));
                setEndIconContentDescription(tintTypedArray.getText(R$styleable.TextInputLayout_passwordToggleContentDescription));
                if (tintTypedArray.hasValue(R$styleable.TextInputLayout_passwordToggleTint)) {
                    setEndIconTintList(ReactYogaConfigProvider.getColorStateList(context2, tintTypedArray, R$styleable.TextInputLayout_passwordToggleTint));
                }
                if (tintTypedArray.hasValue(R$styleable.TextInputLayout_passwordToggleTintMode)) {
                    setEndIconTintMode(ReactYogaConfigProvider.parseTintMode(tintTypedArray.getInt(R$styleable.TextInputLayout_passwordToggleTintMode, -1), null));
                }
            }
            if (!tintTypedArray.hasValue(R$styleable.TextInputLayout_passwordToggleEnabled)) {
                if (tintTypedArray.hasValue(R$styleable.TextInputLayout_endIconTint)) {
                    setEndIconTintList(ReactYogaConfigProvider.getColorStateList(context2, tintTypedArray, R$styleable.TextInputLayout_endIconTint));
                }
                if (tintTypedArray.hasValue(R$styleable.TextInputLayout_endIconTintMode)) {
                    setEndIconTintMode(ReactYogaConfigProvider.parseTintMode(tintTypedArray.getInt(R$styleable.TextInputLayout_endIconTintMode, -1), null));
                }
            }
            tintTypedArray.mWrapped.recycle();
            setImportantForAccessibility(2);
            return;
        }
        throw null;
    }

    private EndIconDelegate getEndIconDelegate() {
        EndIconDelegate endIconDelegate = this.endIconDelegates.get(this.endIconMode);
        return endIconDelegate != null ? endIconDelegate : this.endIconDelegates.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (!hasEndIcon() || !isEndIconVisible()) {
            return null;
        }
        return this.endIconView;
    }

    public static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText2) {
        if (this.editText == null) {
            if (this.endIconMode != 3 && !(editText2 instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText2;
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            float textSize = this.editText.getTextSize();
            if (collapsingTextHelper2.expandedTextSize != textSize) {
                collapsingTextHelper2.expandedTextSize = textSize;
                collapsingTextHelper2.recalculate();
            }
            int gravity = this.editText.getGravity();
            CollapsingTextHelper collapsingTextHelper3 = this.collapsingTextHelper;
            int i = (gravity & -113) | 48;
            if (collapsingTextHelper3.collapsedTextGravity != i) {
                collapsingTextHelper3.collapsedTextGravity = i;
                collapsingTextHelper3.recalculate();
            }
            CollapsingTextHelper collapsingTextHelper4 = this.collapsingTextHelper;
            if (collapsingTextHelper4.expandedTextGravity != gravity) {
                collapsingTextHelper4.expandedTextGravity = gravity;
                collapsingTextHelper4.recalculate();
            }
            this.editText.addTextChangedListener(new TextWatcher() {
                /* class com.google.android.material.textfield.TextInputLayout.AnonymousClass1 */

                public void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState, false);
                    TextInputLayout textInputLayout2 = TextInputLayout.this;
                    if (textInputLayout2.counterEnabled) {
                        textInputLayout2.updateCounter(editable.length());
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    CharSequence hint2 = this.editText.getHint();
                    this.originalHint = hint2;
                    setHint(hint2);
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText().length());
            }
            updateEditTextBackground();
            this.indicatorViewController.adjustIndicatorPadding();
            this.startIconView.bringToFront();
            this.endIconFrame.bringToFront();
            this.errorIconView.bringToFront();
            Iterator<OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
            while (it.hasNext()) {
                it.next().onEditTextAttached(this);
            }
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z) {
        int i = 0;
        this.errorIconView.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = this.endIconFrame;
        if (z) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        if (!hasEndIcon()) {
            updateIconDummyDrawables();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            if (charSequence == null || !TextUtils.equals(collapsingTextHelper2.text, charSequence)) {
                collapsingTextHelper2.text = charSequence;
                collapsingTextHelper2.textToDraw = null;
                Bitmap bitmap = collapsingTextHelper2.expandedTitleTexture;
                if (bitmap != null) {
                    bitmap.recycle();
                    collapsingTextHelper2.expandedTitleTexture = null;
                }
                collapsingTextHelper2.recalculate();
            }
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    public static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z = false;
        int i = 1;
        boolean z2 = onLongClickListener != null;
        if (hasOnClickListeners || z2) {
            z = true;
        }
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        if (!z) {
            i = 2;
        }
        checkableImageButton.setImportantForAccessibility(i);
    }

    public void addOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void animateToExpansionFraction(float f) {
        if (this.collapsingTextHelper.expandedFraction != f) {
            if (this.animator == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.animator = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.animator.setDuration(167L);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.google.android.material.textfield.TextInputLayout.AnonymousClass4 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.animator.setFloatValues(this.collapsingTextHelper.expandedFraction, f);
            this.animator.start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    public final void applyBoxAttributes() {
        boolean z;
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
            boolean z2 = false;
            if (this.boxBackgroundMode == 2) {
                if (this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0) {
                    z = true;
                    if (z) {
                        this.boxBackground.setStroke((float) this.boxStrokeWidthPx, this.boxStrokeColor);
                    }
                    int i = this.boxBackgroundColor;
                    if (this.boxBackgroundMode == 1) {
                        i = ColorUtils.compositeColors(this.boxBackgroundColor, ReactYogaConfigProvider.getColor(getContext(), R$attr.colorSurface, 0));
                    }
                    this.boxBackgroundColor = i;
                    this.boxBackground.setFillColor(ColorStateList.valueOf(i));
                    if (this.endIconMode == 3) {
                        this.editText.getBackground().invalidateSelf();
                    }
                    if (this.boxUnderline != null) {
                        if (this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0) {
                            z2 = true;
                        }
                        if (z2) {
                            this.boxUnderline.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
                        }
                        invalidate();
                    }
                    invalidate();
                }
            }
            z = false;
            if (z) {
            }
            int i2 = this.boxBackgroundColor;
            if (this.boxBackgroundMode == 1) {
            }
            this.boxBackgroundColor = i2;
            this.boxBackground.setFillColor(ColorStateList.valueOf(i2));
            if (this.endIconMode == 3) {
            }
            if (this.boxUnderline != null) {
            }
            invalidate();
        }
    }

    public final void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    public final void applyIconTint(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = drawable.mutate();
            if (z) {
                drawable.setTintList(colorStateList);
            }
            if (z2) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public final void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    public final int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i = this.boxBackgroundMode;
        if (i == 0 || i == 1) {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
        } else if (i != 2) {
            return 0;
        } else {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    public final boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable);
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText2;
        if (this.originalHint == null || (editText2 = this.editText) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence hint2 = editText2.getHint();
        this.editText.setHint(this.originalHint);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.editText.setHint(hint2);
            this.isProvidingHint = z;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public void draw(Canvas canvas) {
        float f;
        super.draw(canvas);
        if (this.hintEnabled) {
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            if (collapsingTextHelper2 != null) {
                int save = canvas.save();
                if (collapsingTextHelper2.textToDraw != null && collapsingTextHelper2.drawTitle) {
                    float f2 = collapsingTextHelper2.currentDrawX;
                    float f3 = collapsingTextHelper2.currentDrawY;
                    boolean z = collapsingTextHelper2.useTexture && collapsingTextHelper2.expandedTitleTexture != null;
                    if (z) {
                        f = collapsingTextHelper2.textureAscent * collapsingTextHelper2.scale;
                    } else {
                        f = collapsingTextHelper2.textPaint.ascent() * collapsingTextHelper2.scale;
                        collapsingTextHelper2.textPaint.descent();
                    }
                    if (z) {
                        f3 += f;
                    }
                    float f4 = collapsingTextHelper2.scale;
                    if (f4 != 1.0f) {
                        canvas.scale(f4, f4, f2, f3);
                    }
                    if (z) {
                        canvas.drawBitmap(collapsingTextHelper2.expandedTitleTexture, f2, f3, collapsingTextHelper2.texturePaint);
                    } else {
                        CharSequence charSequence = collapsingTextHelper2.textToDraw;
                        canvas.drawText(charSequence, 0, charSequence.length(), f2, f3, collapsingTextHelper2.textPaint);
                    }
                }
                canvas.restoreToCount(save);
            } else {
                throw null;
            }
        }
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    public void drawableStateChanged() {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        if (!this.inDrawableStateChanged) {
            boolean z3 = true;
            this.inDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            if (collapsingTextHelper2 != null) {
                collapsingTextHelper2.state = drawableState;
                ColorStateList colorStateList2 = collapsingTextHelper2.collapsedTextColor;
                if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = collapsingTextHelper2.expandedTextColor) != null && colorStateList.isStateful())) {
                    collapsingTextHelper2.recalculate();
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2 | false;
            } else {
                z = false;
            }
            if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                z3 = false;
            }
            updateLabelState(z3, false);
            updateEditTextBackground();
            updateTextInputBoxState();
            if (z) {
                invalidate();
            }
            this.inDrawableStateChanged = false;
        }
    }

    public int getBaseline() {
        EditText editText2 = this.editText;
        if (editText2 == null) {
            return super.getBaseline();
        }
        return calculateLabelMarginTop() + getPaddingTop() + editText2.getBaseline();
    }

    public MaterialShapeDrawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public float getBoxCornerRadiusBottomEnd() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        return materialShapeDrawable.drawableState.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF());
    }

    public float getBoxCornerRadiusBottomStart() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        return materialShapeDrawable.drawableState.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF());
    }

    public float getBoxCornerRadiusTopEnd() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        return materialShapeDrawable.drawableState.shapeAppearanceModel.topRightCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.counterEnabled || !this.counterOverflowed || (textView = this.counterView) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    public CharSequence getError() {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        if (indicatorViewController2.errorEnabled) {
            return indicatorViewController2.errorText;
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public CharSequence getHelperText() {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        if (indicatorViewController2.helperTextEnabled) {
            return indicatorViewController2.helperText;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        TextView textView = this.indicatorViewController.helperTextView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public final boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public final void onApplyBoxBackgroundMode() {
        int i = this.boxBackgroundMode;
        boolean z = true;
        if (i == 0) {
            this.boxBackground = null;
            this.boxUnderline = null;
        } else if (i == 1) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderline = new MaterialShapeDrawable();
        } else if (i == 2) {
            if (!this.hintEnabled || (this.boxBackground instanceof CutoutDrawable)) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
            }
            this.boxUnderline = null;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline13(new StringBuilder(), this.boxBackgroundMode, " is illegal; only @BoxBackgroundMode constants are supported."));
        }
        EditText editText2 = this.editText;
        if (editText2 == null || this.boxBackground == null || editText2.getBackground() != null || this.boxBackgroundMode == 0) {
            z = false;
        }
        if (z) {
            ViewCompat.setBackground(this.editText, this.boxBackground);
        }
        updateTextInputBoxState();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        EditText editText2 = this.editText;
        if (editText2 != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText2, rect);
            MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
            if (materialShapeDrawable != null) {
                int i7 = rect.bottom;
                materialShapeDrawable.setBounds(rect.left, i7 - this.boxStrokeWidthFocusedPx, rect.right, i7);
            }
            if (this.hintEnabled) {
                CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
                EditText editText3 = this.editText;
                if (editText3 != null) {
                    Rect rect2 = this.tmpBoundsRect;
                    rect2.bottom = rect.bottom;
                    int i8 = this.boxBackgroundMode;
                    if (i8 == 1) {
                        rect2.left = editText3.getCompoundPaddingLeft() + rect.left;
                        rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                        rect2.right = rect.right - this.editText.getCompoundPaddingRight();
                    } else if (i8 != 2) {
                        rect2.left = editText3.getCompoundPaddingLeft() + rect.left;
                        rect2.top = getPaddingTop();
                        rect2.right = rect.right - this.editText.getCompoundPaddingRight();
                    } else {
                        rect2.left = editText3.getPaddingLeft() + rect.left;
                        rect2.top = rect.top - calculateLabelMarginTop();
                        rect2.right = rect.right - this.editText.getPaddingRight();
                    }
                    if (collapsingTextHelper2 != null) {
                        int i9 = rect2.left;
                        int i10 = rect2.top;
                        int i11 = rect2.right;
                        int i12 = rect2.bottom;
                        if (!CollapsingTextHelper.rectEquals(collapsingTextHelper2.collapsedBounds, i9, i10, i11, i12)) {
                            collapsingTextHelper2.collapsedBounds.set(i9, i10, i11, i12);
                            collapsingTextHelper2.boundsChanged = true;
                            collapsingTextHelper2.onBoundsChanged();
                        }
                        CollapsingTextHelper collapsingTextHelper3 = this.collapsingTextHelper;
                        if (this.editText != null) {
                            Rect rect3 = this.tmpBoundsRect;
                            TextPaint textPaint = collapsingTextHelper3.tmpPaint;
                            textPaint.setTextSize(collapsingTextHelper3.expandedTextSize);
                            textPaint.setTypeface(collapsingTextHelper3.expandedTypeface);
                            float f = -collapsingTextHelper3.tmpPaint.ascent();
                            rect3.left = this.editText.getCompoundPaddingLeft() + rect.left;
                            if (this.boxBackgroundMode == 1 && this.editText.getMinLines() <= 1) {
                                i5 = (int) (((float) rect.centerY()) - (f / 2.0f));
                            } else {
                                i5 = rect.top + this.editText.getCompoundPaddingTop();
                            }
                            rect3.top = i5;
                            rect3.right = rect.right - this.editText.getCompoundPaddingRight();
                            if (this.boxBackgroundMode == 1) {
                                i6 = (int) (((float) rect3.top) + f);
                            } else {
                                i6 = rect.bottom - this.editText.getCompoundPaddingBottom();
                            }
                            rect3.bottom = i6;
                            if (collapsingTextHelper3 != null) {
                                int i13 = rect3.left;
                                int i14 = rect3.top;
                                int i15 = rect3.right;
                                if (!CollapsingTextHelper.rectEquals(collapsingTextHelper3.expandedBounds, i13, i14, i15, i6)) {
                                    collapsingTextHelper3.expandedBounds.set(i13, i14, i15, i6);
                                    collapsingTextHelper3.boundsChanged = true;
                                    collapsingTextHelper3.onBoundsChanged();
                                }
                                this.collapsingTextHelper.recalculate();
                                if (cutoutEnabled() && !this.hintExpanded) {
                                    openCutout();
                                    return;
                                }
                                return;
                            }
                            throw null;
                        }
                        throw new IllegalStateException();
                    }
                    throw null;
                }
                throw new IllegalStateException();
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int max;
        super.onMeasure(i, i2);
        boolean z = false;
        if (this.editText != null && this.editText.getMeasuredHeight() < (max = Math.max(this.endIconView.getMeasuredHeight(), this.startIconView.getMeasuredHeight()))) {
            this.editText.setMinimumHeight(max);
            z = true;
        }
        boolean updateIconDummyDrawables = updateIconDummyDrawables();
        if (z || updateIconDummyDrawables) {
            this.editText.post(new Runnable() {
                /* class com.google.android.material.textfield.TextInputLayout.AnonymousClass3 */

                public void run() {
                    TextInputLayout.this.editText.requestLayout();
                }
            });
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new Runnable() {
                /* class com.google.android.material.textfield.TextInputLayout.AnonymousClass2 */

                public void run() {
                    TextInputLayout.this.endIconView.performClick();
                    TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
                }
            });
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = hasEndIcon() && this.endIconView.isChecked();
        return savedState;
    }

    public final void openCutout() {
        float f;
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            boolean calculateIsRtl = collapsingTextHelper2.calculateIsRtl(collapsingTextHelper2.text);
            Rect rect = collapsingTextHelper2.collapsedBounds;
            if (!calculateIsRtl) {
                f = (float) rect.left;
            } else {
                f = ((float) rect.right) - collapsingTextHelper2.calculateCollapsedTextWidth();
            }
            rectF.left = f;
            Rect rect2 = collapsingTextHelper2.collapsedBounds;
            rectF.top = (float) rect2.top;
            rectF.right = !calculateIsRtl ? collapsingTextHelper2.calculateCollapsedTextWidth() + f : (float) rect2.right;
            float collapsedTextHeight = collapsingTextHelper2.getCollapsedTextHeight() + ((float) collapsingTextHelper2.collapsedBounds.top);
            rectF.bottom = collapsedTextHeight;
            float f2 = rectF.left;
            float f3 = (float) this.boxLabelCutoutPaddingPx;
            rectF.left = f2 - f3;
            rectF.top -= f3;
            rectF.right += f3;
            rectF.bottom = collapsedTextHeight + f3;
            rectF.offset((float) (-getPaddingLeft()), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            CutoutDrawable cutoutDrawable = (CutoutDrawable) this.boxBackground;
            if (cutoutDrawable != null) {
                cutoutDrawable.setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
                return;
            }
            throw null;
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBoxBackgroundMode(int i) {
        if (i != this.boxBackgroundMode) {
            this.boxBackgroundMode = i;
            if (this.editText != null) {
                onApplyBoxBackgroundMode();
            }
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
                this.counterView = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.counterView.setTypeface(typeface2);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false, false);
        }
    }

    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.endIconView.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.endIconView.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setEndIconMode(int i) {
        int i2 = this.endIconMode;
        this.endIconMode = i;
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            getEndIconDelegate().initialize();
            applyEndIconTint();
            Iterator<OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().onEndIconChanged(this, i2);
            }
            return;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("The current box background mode ");
        outline17.append(this.boxBackgroundMode);
        outline17.append(" is not supported by the end icon mode ");
        outline17.append(i);
        throw new IllegalStateException(outline17.toString());
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.endIconView;
        View.OnLongClickListener onLongClickListener = this.endIconOnLongClickListener;
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = this.endIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (isEndIconVisible() != z) {
            this.endIconView.setVisibility(z ? 0 : 4);
            updateIconDummyDrawables();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.errorEnabled) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            IndicatorViewController indicatorViewController2 = this.indicatorViewController;
            indicatorViewController2.cancelCaptionAnimator();
            indicatorViewController2.errorText = charSequence;
            indicatorViewController2.errorView.setText(charSequence);
            if (indicatorViewController2.captionDisplayed != 1) {
                indicatorViewController2.captionToShow = 1;
            }
            indicatorViewController2.updateCaptionViewsVisibility(indicatorViewController2.captionDisplayed, indicatorViewController2.captionToShow, indicatorViewController2.shouldAnimateCaptionView(indicatorViewController2.errorView, charSequence));
            return;
        }
        this.indicatorViewController.hideError();
    }

    public void setErrorEnabled(boolean z) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        if (indicatorViewController2.errorEnabled != z) {
            indicatorViewController2.cancelCaptionAnimator();
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController2.context, null);
                indicatorViewController2.errorView = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_error);
                Typeface typeface2 = indicatorViewController2.typeface;
                if (typeface2 != null) {
                    indicatorViewController2.errorView.setTypeface(typeface2);
                }
                int i = indicatorViewController2.errorTextAppearance;
                indicatorViewController2.errorTextAppearance = i;
                TextView textView = indicatorViewController2.errorView;
                if (textView != null) {
                    indicatorViewController2.textInputView.setTextAppearanceCompatWithErrorFallback(textView, i);
                }
                ColorStateList colorStateList = indicatorViewController2.errorViewTextColor;
                indicatorViewController2.errorViewTextColor = colorStateList;
                TextView textView2 = indicatorViewController2.errorView;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                indicatorViewController2.errorView.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(indicatorViewController2.errorView, 1);
                indicatorViewController2.addIndicator(indicatorViewController2.errorView, 0);
            } else {
                indicatorViewController2.hideError();
                indicatorViewController2.removeIndicator(indicatorViewController2.errorView, 0);
                indicatorViewController2.errorView = null;
                indicatorViewController2.textInputView.updateEditTextBackground();
                indicatorViewController2.textInputView.updateTextInputBoxState();
            }
            indicatorViewController2.errorEnabled = z;
        }
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            drawable.setTintList(colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            drawable.setTintMode(mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        indicatorViewController2.errorTextAppearance = i;
        TextView textView = indicatorViewController2.errorView;
        if (textView != null) {
            indicatorViewController2.textInputView.setTextAppearanceCompatWithErrorFallback(textView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        indicatorViewController2.errorViewTextColor = colorStateList;
        TextView textView = indicatorViewController2.errorView;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.indicatorViewController.helperTextEnabled) {
                setHelperTextEnabled(true);
            }
            IndicatorViewController indicatorViewController2 = this.indicatorViewController;
            indicatorViewController2.cancelCaptionAnimator();
            indicatorViewController2.helperText = charSequence;
            indicatorViewController2.helperTextView.setText(charSequence);
            if (indicatorViewController2.captionDisplayed != 2) {
                indicatorViewController2.captionToShow = 2;
            }
            indicatorViewController2.updateCaptionViewsVisibility(indicatorViewController2.captionDisplayed, indicatorViewController2.captionToShow, indicatorViewController2.shouldAnimateCaptionView(indicatorViewController2.helperTextView, charSequence));
        } else if (this.indicatorViewController.helperTextEnabled) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        indicatorViewController2.helperTextViewTextColor = colorStateList;
        TextView textView = indicatorViewController2.helperTextView;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        if (indicatorViewController2.helperTextEnabled != z) {
            indicatorViewController2.cancelCaptionAnimator();
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController2.context, null);
                indicatorViewController2.helperTextView = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_helper_text);
                Typeface typeface2 = indicatorViewController2.typeface;
                if (typeface2 != null) {
                    indicatorViewController2.helperTextView.setTypeface(typeface2);
                }
                indicatorViewController2.helperTextView.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(indicatorViewController2.helperTextView, 1);
                int i = indicatorViewController2.helperTextTextAppearance;
                indicatorViewController2.helperTextTextAppearance = i;
                TextView textView = indicatorViewController2.helperTextView;
                if (textView != null) {
                    textView.setTextAppearance(i);
                }
                ColorStateList colorStateList = indicatorViewController2.helperTextViewTextColor;
                indicatorViewController2.helperTextViewTextColor = colorStateList;
                TextView textView2 = indicatorViewController2.helperTextView;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                indicatorViewController2.addIndicator(indicatorViewController2.helperTextView, 1);
            } else {
                indicatorViewController2.cancelCaptionAnimator();
                if (indicatorViewController2.captionDisplayed == 2) {
                    indicatorViewController2.captionToShow = 0;
                }
                indicatorViewController2.updateCaptionViewsVisibility(indicatorViewController2.captionDisplayed, indicatorViewController2.captionToShow, indicatorViewController2.shouldAnimateCaptionView(indicatorViewController2.helperTextView, null));
                indicatorViewController2.removeIndicator(indicatorViewController2.helperTextView, 1);
                indicatorViewController2.helperTextView = null;
                indicatorViewController2.textInputView.updateEditTextBackground();
                indicatorViewController2.textInputView.updateTextInputBoxState();
            }
            indicatorViewController2.helperTextEnabled = z;
        }
    }

    public void setHelperTextTextAppearance(int i) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        indicatorViewController2.helperTextTextAppearance = i;
        TextView textView = indicatorViewController2.helperTextView;
        if (textView != null) {
            textView.setTextAppearance(i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (!z) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            } else {
                CharSequence hint2 = this.editText.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        TextAppearance textAppearance = new TextAppearance(collapsingTextHelper2.view.getContext(), i);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            collapsingTextHelper2.collapsedTextColor = colorStateList;
        }
        float f = textAppearance.textSize;
        if (f != BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            collapsingTextHelper2.collapsedTextSize = f;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            collapsingTextHelper2.collapsedShadowColor = colorStateList2;
        }
        collapsingTextHelper2.collapsedShadowDx = textAppearance.shadowDx;
        collapsingTextHelper2.collapsedShadowDy = textAppearance.shadowDy;
        collapsingTextHelper2.collapsedShadowRadius = textAppearance.shadowRadius;
        CancelableFontCallback cancelableFontCallback = collapsingTextHelper2.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        CollapsingTextHelper.AnonymousClass1 r2 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0039: CONSTRUCTOR  (r2v4 'r2' com.google.android.material.internal.CollapsingTextHelper$1) = (r0v0 'collapsingTextHelper2' com.google.android.material.internal.CollapsingTextHelper) call: com.google.android.material.internal.CollapsingTextHelper.1.<init>(com.google.android.material.internal.CollapsingTextHelper):void type: CONSTRUCTOR in method: com.google.android.material.textfield.TextInputLayout.setHintTextAppearance(int):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.material.internal.CollapsingTextHelper, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.setHintTextAppearance(int):void");
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
                if (collapsingTextHelper2.collapsedTextColor != colorStateList) {
                    collapsingTextHelper2.collapsedTextColor = colorStateList;
                    collapsingTextHelper2.recalculate();
                }
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false, false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.endIconMode != 1) {
            setEndIconMode(1);
        } else if (!z) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setStartIconCheckable(boolean z) {
        this.startIconView.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.startIconView;
        View.OnLongClickListener onLongClickListener = this.startIconOnLongClickListener;
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = this.startIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyStartIconTint();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyStartIconTint();
        }
    }

    public void setStartIconVisible(boolean z) {
        int i = 0;
        if ((this.startIconView.getVisibility() == 0) != z) {
            CheckableImageButton checkableImageButton = this.startIconView;
            if (!z) {
                i = 8;
            }
            checkableImageButton.setVisibility(i);
            updateIconDummyDrawables();
        }
    }

    public void setTextAppearanceCompatWithErrorFallback(TextView textView, int i) {
        boolean z = true;
        try {
            textView.setTextAppearance(i);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z = false;
            }
        } catch (Exception unused) {
        }
        if (z) {
            textView.setTextAppearance(R$style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(ContextCompat.getColor(getContext(), R$color.design_error));
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            ViewCompat.setAccessibilityDelegate(editText2, accessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            this.collapsingTextHelper.setTypefaces(typeface2);
            IndicatorViewController indicatorViewController2 = this.indicatorViewController;
            if (typeface2 != indicatorViewController2.typeface) {
                indicatorViewController2.typeface = typeface2;
                TextView textView = indicatorViewController2.errorView;
                if (textView != null) {
                    textView.setTypeface(typeface2);
                }
                TextView textView2 = indicatorViewController2.helperTextView;
                if (textView2 != null) {
                    textView2.setTypeface(typeface2);
                }
            }
            TextView textView3 = this.counterView;
            if (textView3 != null) {
                textView3.setTypeface(typeface2);
            }
        }
    }

    public final void updateCounter() {
        if (this.counterView != null) {
            EditText editText2 = this.editText;
            updateCounter(editText2 == null ? 0 : editText2.getText().length());
        }
    }

    public final void updateCounterTextAppearanceAndColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.counterView;
        if (textView != null) {
            setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (this.counterOverflowed && (colorStateList = this.counterOverflowTextColor) != null) {
                this.counterView.setTextColor(colorStateList);
            }
        }
    }

    public void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 0 && (background = editText2.getBackground()) != null) {
            if (DrawableUtils.canSafelyMutateDrawable(background)) {
                background = background.mutate();
            }
            if (this.indicatorViewController.errorShouldBeShown()) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                background.clearColorFilter();
                this.editText.refreshDrawableState();
            } else {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    public final boolean updateIconDummyDrawables() {
        boolean z;
        CheckableImageButton endIconToUpdateDummyDrawable;
        if (this.editText == null) {
            return false;
        }
        boolean z2 = true;
        if (getStartIconDrawable() != null) {
            if ((this.startIconView.getVisibility() == 0) && this.startIconView.getMeasuredWidth() > 0) {
                if (this.startIconDummyDrawable == null) {
                    this.startIconDummyDrawable = new ColorDrawable();
                    this.startIconDummyDrawable.setBounds(0, 0, (this.startIconView.getMeasuredWidth() - this.editText.getPaddingLeft()) + ((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams()).getMarginEnd(), 1);
                }
                Drawable[] compoundDrawablesRelative = this.editText.getCompoundDrawablesRelative();
                Drawable drawable = compoundDrawablesRelative[0];
                Drawable drawable2 = this.startIconDummyDrawable;
                if (drawable != drawable2) {
                    this.editText.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                    z = true;
                    endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
                    if (endIconToUpdateDummyDrawable == null && endIconToUpdateDummyDrawable.getMeasuredWidth() > 0) {
                        if (this.endIconDummyDrawable == null) {
                            this.endIconDummyDrawable = new ColorDrawable();
                            this.endIconDummyDrawable.setBounds(0, 0, (endIconToUpdateDummyDrawable.getMeasuredWidth() - this.editText.getPaddingRight()) + ((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()).getMarginStart(), 1);
                        }
                        Drawable[] compoundDrawablesRelative2 = this.editText.getCompoundDrawablesRelative();
                        Drawable drawable3 = compoundDrawablesRelative2[2];
                        Drawable drawable4 = this.endIconDummyDrawable;
                        if (drawable3 != drawable4) {
                            this.originalEditTextEndDrawable = compoundDrawablesRelative2[2];
                            this.editText.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], drawable4, compoundDrawablesRelative2[3]);
                        } else {
                            z2 = z;
                        }
                    } else if (this.endIconDummyDrawable != null) {
                        return z;
                    } else {
                        Drawable[] compoundDrawablesRelative3 = this.editText.getCompoundDrawablesRelative();
                        if (compoundDrawablesRelative3[2] == this.endIconDummyDrawable) {
                            this.editText.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.originalEditTextEndDrawable, compoundDrawablesRelative3[3]);
                        } else {
                            z2 = z;
                        }
                        this.endIconDummyDrawable = null;
                    }
                    return z2;
                }
                z = false;
                endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
                if (endIconToUpdateDummyDrawable == null) {
                }
                if (this.endIconDummyDrawable != null) {
                }
            }
        }
        if (this.startIconDummyDrawable != null) {
            Drawable[] compoundDrawablesRelative4 = this.editText.getCompoundDrawablesRelative();
            this.editText.setCompoundDrawablesRelative(null, compoundDrawablesRelative4[1], compoundDrawablesRelative4[2], compoundDrawablesRelative4[3]);
            this.startIconDummyDrawable = null;
            z = true;
            endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable == null) {
            }
            if (this.endIconDummyDrawable != null) {
            }
        }
        z = false;
        endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
        if (endIconToUpdateDummyDrawable == null) {
        }
        if (this.endIconDummyDrawable != null) {
        }
    }

    public final void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    public final void updateLabelState(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText2 = this.editText;
        boolean z3 = editText2 != null && !TextUtils.isEmpty(editText2.getText());
        EditText editText3 = this.editText;
        boolean z4 = editText3 != null && editText3.hasFocus();
        boolean errorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            if (collapsingTextHelper2.collapsedTextColor != colorStateList2) {
                collapsingTextHelper2.collapsedTextColor = colorStateList2;
                collapsingTextHelper2.recalculate();
            }
            CollapsingTextHelper collapsingTextHelper3 = this.collapsingTextHelper;
            ColorStateList colorStateList3 = this.defaultHintTextColor;
            if (collapsingTextHelper3.expandedTextColor != colorStateList3) {
                collapsingTextHelper3.expandedTextColor = colorStateList3;
                collapsingTextHelper3.recalculate();
            }
        }
        if (!isEnabled) {
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(this.disabledColor));
            CollapsingTextHelper collapsingTextHelper4 = this.collapsingTextHelper;
            ColorStateList valueOf = ColorStateList.valueOf(this.disabledColor);
            if (collapsingTextHelper4.expandedTextColor != valueOf) {
                collapsingTextHelper4.expandedTextColor = valueOf;
                collapsingTextHelper4.recalculate();
            }
        } else if (errorShouldBeShown) {
            CollapsingTextHelper collapsingTextHelper5 = this.collapsingTextHelper;
            TextView textView2 = this.indicatorViewController.errorView;
            collapsingTextHelper5.setCollapsedTextColor(textView2 != null ? textView2.getTextColors() : null);
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(textView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            CollapsingTextHelper collapsingTextHelper6 = this.collapsingTextHelper;
            if (collapsingTextHelper6.collapsedTextColor != colorStateList) {
                collapsingTextHelper6.collapsedTextColor = colorStateList;
                collapsingTextHelper6.recalculate();
            }
        }
        if (z3 || (isEnabled() && (z4 || errorShouldBeShown))) {
            if (z2 || this.hintExpanded) {
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.animator.cancel();
                }
                if (!z || !this.hintAnimationEnabled) {
                    this.collapsingTextHelper.setExpansionFraction(1.0f);
                } else {
                    animateToExpansionFraction(1.0f);
                }
                this.hintExpanded = false;
                if (cutoutEnabled()) {
                    openCutout();
                }
            }
        } else if (z2 || !this.hintExpanded) {
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.animator.cancel();
            }
            if (!z || !this.hintAnimationEnabled) {
                this.collapsingTextHelper.setExpansionFraction(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            } else {
                animateToExpansionFraction(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            }
            if (cutoutEnabled() && (!((CutoutDrawable) this.boxBackground).cutoutBounds.isEmpty()) && cutoutEnabled()) {
                ((CutoutDrawable) this.boxBackground).setCutout(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            }
            this.hintExpanded = true;
        }
    }

    public void updateTextInputBoxState() {
        TextView textView;
        EditText editText2;
        EditText editText3;
        if (this.boxBackground != null && this.boxBackgroundMode != 0) {
            boolean z = false;
            boolean z2 = isFocused() || ((editText3 = this.editText) != null && editText3.hasFocus());
            boolean z3 = isHovered() || ((editText2 = this.editText) != null && editText2.isHovered());
            if (!isEnabled()) {
                this.boxStrokeColor = this.disabledColor;
            } else if (this.indicatorViewController.errorShouldBeShown()) {
                this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
            } else if (this.counterOverflowed && (textView = this.counterView) != null) {
                this.boxStrokeColor = textView.getCurrentTextColor();
            } else if (z2) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z3) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
            if (!(this.indicatorViewController.errorShouldBeShown() && getEndIconDelegate().shouldTintIconOnError()) || getEndIconDrawable() == null) {
                applyEndIconTint();
            } else {
                Drawable mutate = getEndIconDrawable().mutate();
                mutate.setTint(this.indicatorViewController.getErrorViewCurrentTextColor());
                this.endIconView.setImageDrawable(mutate);
            }
            if (getErrorIconDrawable() != null) {
                IndicatorViewController indicatorViewController2 = this.indicatorViewController;
                if (indicatorViewController2.errorEnabled && indicatorViewController2.errorShouldBeShown()) {
                    z = true;
                }
            }
            setErrorIconVisible(z);
            if ((z3 || z2) && isEnabled()) {
                this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
            } else {
                this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
            }
            if (this.boxBackgroundMode == 1) {
                if (!isEnabled()) {
                    this.boxBackgroundColor = this.disabledFilledBackgroundColor;
                } else if (z3) {
                    this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
                } else {
                    this.boxBackgroundColor = this.defaultFilledBackgroundColor;
                }
            }
            applyBoxAttributes();
        }
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.errorEnabled);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            applyStartIconTint();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        if (this.counterMaxLength == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            if (ViewCompat.getAccessibilityLiveRegion(this.counterView) == 1) {
                this.counterView.setAccessibilityLiveRegion(0);
            }
            this.counterOverflowed = i > this.counterMaxLength;
            Context context = getContext();
            this.counterView.setContentDescription(context.getString(this.counterOverflowed ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)));
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
                if (this.counterOverflowed) {
                    this.counterView.setAccessibilityLiveRegion(1);
                }
            }
            this.counterView.setText(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)));
        }
        if (this.editText != null && z != this.counterOverflowed) {
            updateLabelState(false, false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }
}
