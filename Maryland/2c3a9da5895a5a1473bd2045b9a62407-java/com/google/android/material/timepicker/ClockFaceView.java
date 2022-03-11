package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
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
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.timepicker.ClockHandView;
import e.i.i.a;
import e.i.i.m;
import e.i.i.x.b;
import f.b.a.c.b.o.b;
import f.b.a.d.b0.c;
import java.util.Arrays;

public class ClockFaceView extends c implements ClockHandView.c {
    public final SparseArray<TextView> A;
    public final a B;
    public final int[] C;
    public final float[] D;
    public final int E;
    public String[] F;
    public float G;
    public final ColorStateList H;
    public final ClockHandView x;
    public final Rect y = new Rect();
    public final RectF z = new RectF();

    /* JADX WARNING: Illegal instructions before constructor call */
    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i2 = R$attr.materialClockStyle;
        SparseArray<TextView> sparseArray = new SparseArray<>();
        this.A = sparseArray;
        this.D = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i2, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList L0 = b.L0(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        this.H = L0;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.x = clockHandView;
        this.E = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = L0.getColorForState(new int[]{16842913}, L0.getDefaultColor());
        this.C = new int[]{colorForState, colorForState, L0.getDefaultColor()};
        clockHandView.f626g.add(this);
        int defaultColor = e.b.b.a.a.a(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList L02 = b.L0(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(L02 != null ? L02.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new f.b.a.d.b0.a(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.B = new f.b.a.d.b0.b(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.F = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        for (int i3 = 0; i3 < Math.max(this.F.length, size); i3++) {
            TextView textView = this.A.get(i3);
            if (i3 >= this.F.length) {
                removeView(textView);
                this.A.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.A.put(i3, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.F[i3]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i3));
                m.r(textView, this.B);
                textView.setTextColor(this.H);
            }
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float f2, boolean z2) {
        if (Math.abs(this.G - f2) > 0.001f) {
            this.G = f2;
            l();
        }
    }

    public final void l() {
        RectF rectF = this.x.f630k;
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            TextView textView = this.A.get(i2);
            if (textView != null) {
                textView.getDrawingRect(this.y);
                this.y.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.y);
                this.z.set(this.y);
                textView.getPaint().setShader(!RectF.intersects(rectF, this.z) ? null : new RadialGradient(rectF.centerX() - this.z.left, rectF.centerY() - this.z.top, 0.5f * rectF.width(), this.C, this.D, Shader.TileMode.CLAMP));
                textView.invalidate();
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0039b.a(1, this.F.length, false, 1).a);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        l();
    }
}
