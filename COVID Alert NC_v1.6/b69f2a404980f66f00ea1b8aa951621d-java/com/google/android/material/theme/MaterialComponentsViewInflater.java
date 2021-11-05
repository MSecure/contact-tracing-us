package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import b.b.k.q;
import b.b.q.d;
import b.b.q.f;
import b.b.q.g;
import b.b.q.r;
import b.b.q.z;
import c.b.a.b.l0.p;
import c.b.a.b.u.a;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MaterialComponentsViewInflater extends q {
    @Override // b.b.k.q
    public d a(Context context, AttributeSet attributeSet) {
        return new p(context, attributeSet);
    }

    @Override // b.b.k.q
    public f b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // b.b.k.q
    public g c(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // b.b.k.q
    public r d(Context context, AttributeSet attributeSet) {
        return new c.b.a.b.d0.a(context, attributeSet);
    }

    @Override // b.b.k.q
    public z e(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
