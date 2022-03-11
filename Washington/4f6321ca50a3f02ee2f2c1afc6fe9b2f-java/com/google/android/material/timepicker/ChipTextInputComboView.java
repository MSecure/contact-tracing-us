package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
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
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import f.b.a.d.q.j;

public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f619f = 0;
    public final Chip b;
    public final TextInputLayout c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f620d;

    /* renamed from: e  reason: collision with root package name */
    public TextWatcher f621e;

    public class b extends j {
        public b(a aVar) {
        }

        @Override // f.b.a.d.q.j
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                int i2 = ChipTextInputComboView.f619f;
                String a = chipTextInputComboView.a("00");
                chipTextInputComboView.b.setText(chipTextInputComboView.a(a));
                EditText editText = chipTextInputComboView.c.getEditText();
                if (!TextUtils.isEmpty(editText.getText())) {
                    editText.removeTextChangedListener(chipTextInputComboView.f621e);
                    editText.setText((CharSequence) null);
                    editText.setHint(chipTextInputComboView.a("00"));
                    editText.addTextChangedListener(chipTextInputComboView.f621e);
                }
                editText.setHint(chipTextInputComboView.a(a));
                return;
            }
            ChipTextInputComboView.this.c.getEditText().setHint((CharSequence) null);
            ChipTextInputComboView chipTextInputComboView2 = ChipTextInputComboView.this;
            chipTextInputComboView2.b.setText(chipTextInputComboView2.a(editable));
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R$layout.material_time_chip, (ViewGroup) this, false);
        this.b = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R$layout.material_time_input, (ViewGroup) this, false);
        this.c = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f620d = editText;
        editText.setVisibility(4);
        b bVar = new b(null);
        this.f621e = bVar;
        editText.addTextChangedListener(bVar);
        b();
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(R$id.material_label);
    }

    public final String a(CharSequence charSequence) {
        return String.format(getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public final void b() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f620d.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public boolean isChecked() {
        return this.b.isChecked();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void setChecked(boolean z) {
        this.b.setChecked(z);
        int i2 = 0;
        this.f620d.setVisibility(z ? 0 : 4);
        Chip chip = this.b;
        if (z) {
            i2 = 8;
        }
        chip.setVisibility(i2);
        if (isChecked()) {
            this.f620d.requestFocus();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void setTag(int i2, Object obj) {
        this.b.setTag(i2, obj);
    }

    public void toggle() {
        this.b.toggle();
    }
}
