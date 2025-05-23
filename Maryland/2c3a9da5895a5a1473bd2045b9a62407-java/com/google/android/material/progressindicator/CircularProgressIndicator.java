package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import f.b.a.d.r.b;
import f.b.a.d.r.d;
import f.b.a.d.r.g;
import f.b.a.d.r.h;
import f.b.a.d.r.i;
import f.b.a.d.r.o;

public final class CircularProgressIndicator extends b<h> {
    public static final int q = R$style.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R$attr.circularProgressIndicatorStyle, q);
        Context context2 = getContext();
        h hVar = (h) this.b;
        setIndeterminateDrawable(new o(context2, hVar, new d(hVar), new g(hVar)));
        Context context3 = getContext();
        h hVar2 = (h) this.b;
        setProgressDrawable(new i(context3, hVar2, new d(hVar2)));
    }

    public int getIndicatorDirection() {
        return ((h) this.b).f2829i;
    }

    public int getIndicatorInset() {
        return ((h) this.b).f2828h;
    }

    public int getIndicatorSize() {
        return ((h) this.b).f2827g;
    }

    public void setIndicatorDirection(int i2) {
        ((h) this.b).f2829i = i2;
        invalidate();
    }

    public void setIndicatorInset(int i2) {
        S s = this.b;
        if (((h) s).f2828h != i2) {
            ((h) s).f2828h = i2;
            invalidate();
        }
    }

    public void setIndicatorSize(int i2) {
        S s = this.b;
        if (((h) s).f2827g != i2) {
            ((h) s).f2827g = i2;
            ((h) s).a();
            invalidate();
        }
    }

    @Override // f.b.a.d.r.b
    public void setTrackThickness(int i2) {
        super.setTrackThickness(i2);
        ((h) this.b).a();
    }
}
