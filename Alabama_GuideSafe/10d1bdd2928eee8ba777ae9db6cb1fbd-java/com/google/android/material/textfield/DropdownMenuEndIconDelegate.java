package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;

public class DropdownMenuEndIconDelegate extends EndIconDelegate {
    public final TextInputLayout.AccessibilityDelegate accessibilityDelegate = new TextInputLayout.AccessibilityDelegate(this.textInputLayout) {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass2 */

        @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.mInfo.setClassName(Spinner.class.getName());
            if (Build.VERSION.SDK_INT >= 26) {
                z = accessibilityNodeInfoCompat.mInfo.isShowingHintText();
            } else {
                Bundle extras = accessibilityNodeInfoCompat.getExtras();
                z = extras != null && (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4;
            }
            if (z) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            AutoCompleteTextView access$000 = DropdownMenuEndIconDelegate.access$000(dropdownMenuEndIconDelegate, dropdownMenuEndIconDelegate.textInputLayout.getEditText());
            if (accessibilityEvent.getEventType() == 1 && DropdownMenuEndIconDelegate.this.accessibilityManager.isTouchExplorationEnabled()) {
                DropdownMenuEndIconDelegate.access$400(DropdownMenuEndIconDelegate.this, access$000);
            }
        }
    };
    public AccessibilityManager accessibilityManager;
    public final TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass3 */

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(TextInputLayout textInputLayout) {
            AutoCompleteTextView access$000 = DropdownMenuEndIconDelegate.access$000(DropdownMenuEndIconDelegate.this, textInputLayout.getEditText());
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            int boxBackgroundMode = dropdownMenuEndIconDelegate.textInputLayout.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                access$000.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.outlinedPopupBackground);
            } else if (boxBackgroundMode == 1) {
                access$000.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.filledPopupBackground);
            }
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
            if (dropdownMenuEndIconDelegate2 != null) {
                if (access$000.getKeyListener() == null) {
                    int boxBackgroundMode2 = dropdownMenuEndIconDelegate2.textInputLayout.getBoxBackgroundMode();
                    MaterialShapeDrawable boxBackground = dropdownMenuEndIconDelegate2.textInputLayout.getBoxBackground();
                    int color = ReactYogaConfigProvider.getColor(access$000, R$attr.colorControlHighlight);
                    int[][] iArr = {new int[]{16842919}, new int[0]};
                    if (boxBackgroundMode2 == 2) {
                        int color2 = ReactYogaConfigProvider.getColor(access$000, R$attr.colorSurface);
                        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.drawableState.shapeAppearanceModel);
                        int layer = ReactYogaConfigProvider.layer(color, color2, 0.1f);
                        materialShapeDrawable.setFillColor(new ColorStateList(iArr, new int[]{layer, 0}));
                        materialShapeDrawable.setTint(color2);
                        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{layer, color2});
                        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.drawableState.shapeAppearanceModel);
                        materialShapeDrawable2.setTint(-1);
                        ViewCompat.setBackground(access$000, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground}));
                    } else if (boxBackgroundMode2 == 1) {
                        int boxBackgroundColor = dropdownMenuEndIconDelegate2.textInputLayout.getBoxBackgroundColor();
                        ViewCompat.setBackground(access$000, new RippleDrawable(new ColorStateList(iArr, new int[]{ReactYogaConfigProvider.layer(color, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                    }
                }
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate3 = DropdownMenuEndIconDelegate.this;
                if (dropdownMenuEndIconDelegate3 != null) {
                    access$000.setOnTouchListener(new View.OnTouchListener(access$000) {
                        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass5 */
                        public final /* synthetic */ AutoCompleteTextView val$editText;

                        {
                            this.val$editText = r2;
                        }

                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 1) {
                                if (DropdownMenuEndIconDelegate.this.isDropdownPopupActive()) {
                                    DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
                                }
                                DropdownMenuEndIconDelegate.access$400(DropdownMenuEndIconDelegate.this, this.val$editText);
                                view.performClick();
                            }
                            return false;
                        }
                    });
                    access$000.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass6 */

                        public void onFocusChange(View view, boolean z) {
                            DropdownMenuEndIconDelegate.this.textInputLayout.setEndIconActivated(z);
                            if (!z) {
                                DropdownMenuEndIconDelegate.access$100(DropdownMenuEndIconDelegate.this, false);
                                DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
                            }
                        }
                    });
                    access$000.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() {
                        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass7 */

                        public void onDismiss() {
                            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                            dropdownMenuEndIconDelegate.dropdownPopupDirty = true;
                            dropdownMenuEndIconDelegate.dropdownPopupActivatedAt = System.currentTimeMillis();
                            DropdownMenuEndIconDelegate.access$100(DropdownMenuEndIconDelegate.this, false);
                        }
                    });
                    access$000.setThreshold(0);
                    access$000.removeTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
                    access$000.addTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
                    textInputLayout.setErrorIconDrawable((Drawable) null);
                    textInputLayout.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.this.accessibilityDelegate);
                    textInputLayout.setEndIconVisible(true);
                    return;
                }
                throw null;
            }
            throw null;
        }
    };
    public long dropdownPopupActivatedAt = RecyclerView.FOREVER_NS;
    public boolean dropdownPopupDirty = false;
    public final TextWatcher exposedDropdownEndIconTextWatcher = new TextWatcher() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass1 */

        public void afterTextChanged(Editable editable) {
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            final AutoCompleteTextView access$000 = DropdownMenuEndIconDelegate.access$000(dropdownMenuEndIconDelegate, dropdownMenuEndIconDelegate.textInputLayout.getEditText());
            access$000.post(new Runnable() {
                /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass1.AnonymousClass1 */

                public void run() {
                    boolean isPopupShowing = access$000.isPopupShowing();
                    DropdownMenuEndIconDelegate.access$100(DropdownMenuEndIconDelegate.this, isPopupShowing);
                    DropdownMenuEndIconDelegate.this.dropdownPopupDirty = isPopupShowing;
                }
            });
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public ValueAnimator fadeInAnim;
    public ValueAnimator fadeOutAnim;
    public StateListDrawable filledPopupBackground;
    public boolean isEndIconChecked = false;
    public MaterialShapeDrawable outlinedPopupBackground;

    public DropdownMenuEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static AutoCompleteTextView access$000(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, EditText editText) {
        if (dropdownMenuEndIconDelegate == null) {
            throw null;
        } else if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        } else {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
    }

    public static void access$100(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, boolean z) {
        if (dropdownMenuEndIconDelegate.isEndIconChecked != z) {
            dropdownMenuEndIconDelegate.isEndIconChecked = z;
            dropdownMenuEndIconDelegate.fadeInAnim.cancel();
            dropdownMenuEndIconDelegate.fadeOutAnim.start();
        }
    }

    public static void access$400(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, AutoCompleteTextView autoCompleteTextView) {
        if (dropdownMenuEndIconDelegate == null) {
            throw null;
        } else if (autoCompleteTextView != null) {
            if (dropdownMenuEndIconDelegate.isDropdownPopupActive()) {
                dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
            }
            if (!dropdownMenuEndIconDelegate.dropdownPopupDirty) {
                boolean z = dropdownMenuEndIconDelegate.isEndIconChecked;
                boolean z2 = !z;
                if (z != z2) {
                    dropdownMenuEndIconDelegate.isEndIconChecked = z2;
                    dropdownMenuEndIconDelegate.fadeInAnim.cancel();
                    dropdownMenuEndIconDelegate.fadeOutAnim.start();
                }
                if (dropdownMenuEndIconDelegate.isEndIconChecked) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
        }
    }

    public final MaterialShapeDrawable getPopUpMaterialShapeDrawable(float f, float f2, float f3, int i) {
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        builder.topLeftCornerSize = new AbsoluteCornerSize(f);
        builder.topRightCornerSize = new AbsoluteCornerSize(f);
        builder.bottomLeftCornerSize = new AbsoluteCornerSize(f2);
        builder.bottomRightCornerSize = new AbsoluteCornerSize(f2);
        ShapeAppearanceModel build = builder.build();
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.context, f3);
        createWithElevationOverlay.drawableState.shapeAppearanceModel = build;
        createWithElevationOverlay.invalidateSelf();
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = createWithElevationOverlay.drawableState;
        if (materialShapeDrawableState.padding == null) {
            materialShapeDrawableState.padding = new Rect();
        }
        createWithElevationOverlay.drawableState.padding.set(0, i, 0, i);
        createWithElevationOverlay.padding = createWithElevationOverlay.drawableState.padding;
        createWithElevationOverlay.invalidateSelf();
        return createWithElevationOverlay;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        float dimensionPixelOffset = (float) this.context.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.context.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable popUpMaterialShapeDrawable = getPopUpMaterialShapeDrawable(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable popUpMaterialShapeDrawable2 = getPopUpMaterialShapeDrawable(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.outlinedPopupBackground = popUpMaterialShapeDrawable;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.filledPopupBackground = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, popUpMaterialShapeDrawable);
        this.filledPopupBackground.addState(new int[0], popUpMaterialShapeDrawable2);
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R$drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass4 */

            public void onClick(View view) {
                DropdownMenuEndIconDelegate.access$400(DropdownMenuEndIconDelegate.this, (AutoCompleteTextView) DropdownMenuEndIconDelegate.this.textInputLayout.getEditText());
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration((long) 67);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass9 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.fadeInAnim = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        ofFloat2.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat2.setDuration((long) 50);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass9 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.fadeOutAnim = ofFloat2;
        ofFloat2.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass8 */

            public void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                dropdownMenuEndIconDelegate.endIconView.setChecked(dropdownMenuEndIconDelegate.isEndIconChecked);
                DropdownMenuEndIconDelegate.this.fadeInAnim.start();
            }
        });
        ViewCompat.setImportantForAccessibility(this.endIconView, 2);
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isBoxBackgroundModeSupported(int i) {
        return i != 0;
    }

    public final boolean isDropdownPopupActive() {
        long currentTimeMillis = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean shouldTintIconOnError() {
        return true;
    }
}
