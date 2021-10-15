package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import b.b.l.a.a;
import b.x.t;
import c.b.a.b.b;
import c.b.a.b.d;
import c.b.a.b.f;
import c.b.a.b.h;
import c.b.a.b.l;
import c.b.a.b.n0.c;
import com.google.android.material.timepicker.ClockHandView;

public class ClockFaceView extends c implements ClockHandView.d {
    public final SparseArray<TextView> A = new SparseArray<>();
    public final int[] B;
    public final float[] C = {0.0f, 0.9f, 1.0f};
    public final int D;
    public float E;
    public final ClockHandView x;
    public final Rect y = new Rect();
    public final RectF z = new RectF();

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ClockFaceView, 0, 0);
        Resources resources = getResources();
        obtainStyledAttributes.getColor(l.ClockFaceView_valueTextColor, -16777216);
        LayoutInflater.from(context).inflate(h.material_clockface_view, (ViewGroup) this, true);
        this.x = (ClockHandView) findViewById(f.material_clock_hand);
        this.D = resources.getDimensionPixelSize(d.material_clock_hand_padding);
        int A1 = t.A1(this, b.colorOnSurface);
        int A12 = t.A1(this, b.colorOnPrimary);
        this.B = new int[]{A12, A12, A1};
        this.x.h.add(this);
        setBackgroundColor(a.a(context, c.b.a.b.c.material_timepicker_clockface).getDefaultColor());
        getViewTreeObserver().addOnPreDrawListener(new c.b.a.b.n0.a(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        new c.b.a.b.n0.b(this);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void a(float f2, boolean z2) {
        if (Math.abs(this.E - f2) > 0.001f) {
            this.E = f2;
            m();
        }
    }

    public final void m() {
        RectF currentSelectorBox = this.x.getCurrentSelectorBox();
        for (int i = 0; i < this.A.size(); i++) {
            TextView textView = this.A.get(i);
            textView.getDrawingRect(this.y);
            this.y.offset(textView.getPaddingLeft(), getPaddingTop());
            offsetDescendantRectToMyCoords(textView, this.y);
            this.z.set(this.y);
            textView.getPaint().setShader(!RectF.intersects(currentSelectorBox, this.z) ? null : new RadialGradient(currentSelectorBox.centerX() - this.z.left, currentSelectorBox.centerY() - this.z.top, 0.5f * currentSelectorBox.width(), this.B, this.C, Shader.TileMode.CLAMP));
            textView.invalidate();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        throw null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        m();
    }

    public void setHandRotation(float f2) {
        this.x.setHandRotation(f2);
        m();
    }

    @Override // c.b.a.b.n0.c
    public void setRadius(int i) {
        if (i != getRadius()) {
            super.setRadius(i);
            this.x.setCircleRadius(getRadius());
        }
    }
}
