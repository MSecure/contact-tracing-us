package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;

public class ClearTextEndIconDelegate extends EndIconDelegate {
    public final TextWatcher clearTextEndIconTextWatcher = new TextWatcher() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass1 */

        public void afterTextChanged(Editable editable) {
            if (!(editable.length() > 0)) {
                ClearTextEndIconDelegate.this.iconInAnim.cancel();
                ClearTextEndIconDelegate.this.iconOutAnim.start();
            } else if (!ClearTextEndIconDelegate.this.textInputLayout.isEndIconVisible()) {
                ClearTextEndIconDelegate.this.iconOutAnim.cancel();
                ClearTextEndIconDelegate.this.iconInAnim.start();
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass2 */

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.getText().length() > 0);
            textInputLayout.setEndIconCheckable(false);
            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            editText.addTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
        }
    };
    public AnimatorSet iconInAnim;
    public ValueAnimator iconOutAnim;

    public ClearTextEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R$drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass3 */

            public void onClick(View view) {
                ClearTextEndIconDelegate.this.textInputLayout.getEditText().setText((CharSequence) null);
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass7 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ClearTextEndIconDelegate.this.endIconView.setScaleX(floatValue);
                ClearTextEndIconDelegate.this.endIconView.setScaleY(floatValue);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f);
        ofFloat2.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass6 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.iconInAnim.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass4 */

            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
            }
        });
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        ofFloat3.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass6 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.iconOutAnim = ofFloat3;
        ofFloat3.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass5 */

            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
            }
        });
    }
}
