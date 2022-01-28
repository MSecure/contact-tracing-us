package com.google.android.material.timepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.b.a.b.c0.j;
import c.b.a.b.f;
import c.b.a.b.h;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;

public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: b  reason: collision with root package name */
    public final Chip f6176b;

    /* renamed from: c  reason: collision with root package name */
    public final TextInputLayout f6177c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f6178d;

    /* renamed from: e  reason: collision with root package name */
    public TextWatcher f6179e;

    public class b extends j {
        public b(a aVar) {
        }

        @Override // c.b.a.b.c0.j
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.f6176b.setText("00");
                EditText editText = chipTextInputComboView.f6177c.getEditText();
                if (!TextUtils.isEmpty(editText.getText())) {
                    editText.removeTextChangedListener(chipTextInputComboView.f6179e);
                    editText.setText((CharSequence) null);
                    editText.setHint("00");
                    editText.addTextChangedListener(chipTextInputComboView.f6179e);
                }
                editText.setHint("00");
                return;
            }
            ChipTextInputComboView.this.f6177c.getEditText().setHint((CharSequence) null);
            ChipTextInputComboView.this.f6176b.setText(editable.toString());
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater from = LayoutInflater.from(context);
        this.f6176b = (Chip) from.inflate(h.material_time_chip, (ViewGroup) this, false);
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(h.material_time_input, (ViewGroup) this, false);
        this.f6177c = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f6178d = editText;
        editText.setVisibility(4);
        b bVar = new b(null);
        this.f6179e = bVar;
        this.f6178d.addTextChangedListener(bVar);
        addView(this.f6176b);
        addView(this.f6177c);
        TextView textView = (TextView) findViewById(f.material_label);
    }

    public boolean isChecked() {
        return this.f6176b.isChecked();
    }

    public void setChecked(boolean z) {
        this.f6176b.setChecked(z);
        int i = 0;
        this.f6178d.setVisibility(z ? 0 : 4);
        Chip chip = this.f6176b;
        if (z) {
            i = 8;
        }
        chip.setVisibility(i);
        if (isChecked()) {
            this.f6178d.requestFocus();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f6176b.setOnClickListener(onClickListener);
    }

    public void setTag(int i, Object obj) {
        this.f6176b.setTag(i, obj);
    }

    public void toggle() {
        this.f6176b.toggle();
    }
}
