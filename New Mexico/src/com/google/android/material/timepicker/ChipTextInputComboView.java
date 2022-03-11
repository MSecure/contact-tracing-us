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
import f.b.a.e.q.j;
import f.b.a.e.q.l;
/* loaded from: classes.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip b;
    public final TextInputLayout c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f631d;

    /* renamed from: e  reason: collision with root package name */
    public TextWatcher f632e;

    /* loaded from: classes.dex */
    public class b extends j {
        public b(a aVar) {
        }

        @Override // f.b.a.e.q.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.b.setText(ChipTextInputComboView.a(chipTextInputComboView, "00"));
                return;
            }
            ChipTextInputComboView chipTextInputComboView2 = ChipTextInputComboView.this;
            chipTextInputComboView2.b.setText(ChipTextInputComboView.a(chipTextInputComboView2, editable));
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
        this.f631d = editText;
        editText.setVisibility(4);
        b bVar = new b(null);
        this.f632e = bVar;
        editText.addTextChangedListener(bVar);
        b();
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(R$id.material_label);
        editText.setSaveEnabled(false);
    }

    public static String a(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        return String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public final void b() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f631d.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.b.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.b.setChecked(z);
        int i2 = 0;
        this.f631d.setVisibility(z ? 0 : 4);
        Chip chip = this.b;
        if (z) {
            i2 = 8;
        }
        chip.setVisibility(i2);
        if (isChecked()) {
            EditText editText = this.f631d;
            editText.requestFocus();
            editText.post(new l(editText));
            if (!TextUtils.isEmpty(this.f631d.getText())) {
                EditText editText2 = this.f631d;
                editText2.setSelection(editText2.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        this.b.setTag(i2, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.b.toggle();
    }
}
