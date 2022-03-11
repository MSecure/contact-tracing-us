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
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.timepicker.ClockHandView;
import e.b.b.a.a;
import f.b.a.c.b.o.b;
import f.b.a.d.b0.c;

public class ClockFaceView extends c implements ClockHandView.c {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, 0, 0);
        Resources resources = getResources();
        obtainStyledAttributes.getColor(R$styleable.ClockFaceView_valueTextColor, -16777216);
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.x = clockHandView;
        this.D = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int K0 = b.K0(this, R$attr.colorOnSurface);
        int K02 = b.K0(this, R$attr.colorOnPrimary);
        this.B = new int[]{K02, K02, K0};
        clockHandView.f625g.add(this);
        setBackgroundColor(a.a(context, R$color.material_timepicker_clockface).getDefaultColor());
        getViewTreeObserver().addOnPreDrawListener(new f.b.a.d.b0.a(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        new f.b.a.d.b0.b(this);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float f2, boolean z2) {
        if (Math.abs(this.E - f2) > 0.001f) {
            this.E = f2;
            l();
        }
    }

    public final void l() {
        RectF rectF = this.x.f629k;
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            TextView textView = this.A.get(i2);
            textView.getDrawingRect(this.y);
            this.y.offset(textView.getPaddingLeft(), textView.getPaddingTop());
            offsetDescendantRectToMyCoords(textView, this.y);
            this.z.set(this.y);
            textView.getPaint().setShader(!RectF.intersects(rectF, this.z) ? null : new RadialGradient(rectF.centerX() - this.z.left, rectF.centerY() - this.z.top, 0.5f * rectF.width(), this.B, this.C, Shader.TileMode.CLAMP));
            textView.invalidate();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        throw null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        l();
    }
}
