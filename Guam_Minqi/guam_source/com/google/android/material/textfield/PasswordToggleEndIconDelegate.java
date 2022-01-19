package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;

public class PasswordToggleEndIconDelegate extends EndIconDelegate {
    public final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() {
        /* class com.google.android.material.textfield.PasswordToggleEndIconDelegate.AnonymousClass2 */

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
            passwordToggleEndIconDelegate.endIconView.setChecked(!PasswordToggleEndIconDelegate.access$000(passwordToggleEndIconDelegate));
            editText.removeTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
            editText.addTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
        }
    };
    public final TextInputLayout.OnEndIconChangedListener onEndIconChangedListener = new TextInputLayout.OnEndIconChangedListener(this) {
        /* class com.google.android.material.textfield.PasswordToggleEndIconDelegate.AnonymousClass3 */

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    };
    public final TextWatcher textWatcher = new TextWatcher() {
        /* class com.google.android.material.textfield.PasswordToggleEndIconDelegate.AnonymousClass1 */

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
            passwordToggleEndIconDelegate.endIconView.setChecked(!PasswordToggleEndIconDelegate.access$000(passwordToggleEndIconDelegate));
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    public PasswordToggleEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static boolean access$000(PasswordToggleEndIconDelegate passwordToggleEndIconDelegate) {
        EditText editText = passwordToggleEndIconDelegate.textInputLayout.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R$drawable.design_password_eye));
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.password_toggle_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.textfield.PasswordToggleEndIconDelegate.AnonymousClass4 */

            public void onClick(View view) {
                EditText editText = PasswordToggleEndIconDelegate.this.textInputLayout.getEditText();
                if (editText != null) {
                    int selectionEnd = editText.getSelectionEnd();
                    if (PasswordToggleEndIconDelegate.access$000(PasswordToggleEndIconDelegate.this)) {
                        editText.setTransformationMethod(null);
                    } else {
                        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    if (selectionEnd >= 0) {
                        editText.setSelection(selectionEnd);
                    }
                }
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
        TextInputLayout textInputLayout2 = this.textInputLayout;
        textInputLayout2.endIconChangedListeners.add(this.onEndIconChangedListener);
    }
}
