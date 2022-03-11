package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textview.MaterialTextView;
import e.b.a.s;
import e.b.f.d;
import e.b.f.d0;
import e.b.f.f;
import e.b.f.g;
import e.b.f.u;
import f.b.a.e.h.a;
import f.b.a.e.y.p;
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends s {
    @Override // e.b.a.s
    public d a(Context context, AttributeSet attributeSet) {
        return new p(context, attributeSet);
    }

    @Override // e.b.a.s
    public f b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // e.b.a.s
    public g c(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // e.b.a.s
    public u d(Context context, AttributeSet attributeSet) {
        return new MaterialRadioButton(context, attributeSet);
    }

    @Override // e.b.a.s
    public d0 e(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
