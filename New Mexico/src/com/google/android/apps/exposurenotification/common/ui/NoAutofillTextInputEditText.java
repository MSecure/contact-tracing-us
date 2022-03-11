package com.google.android.apps.exposurenotification.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputEditText;
/* loaded from: classes.dex */
public class NoAutofillTextInputEditText extends TextInputEditText {
    public NoAutofillTextInputEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public int getAutofillType() {
        return 0;
    }
}
