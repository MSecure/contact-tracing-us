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
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
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
import e.b.a.m;
import e.i.i.c0.b;
import e.i.i.v;
import f.b.a.c.b.o.b;
import f.b.a.e.a0.a;
import f.b.a.e.a0.c;
import java.util.Arrays;

public class ClockFaceView extends c implements ClockHandView.c {
    public final RectF A = new RectF();
    public final SparseArray<TextView> B;
    public final e.i.i.c C;
    public final int[] D;
    public final float[] E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public String[] J;
    public float K;
    public final ColorStateList L;
    public final ClockHandView y;
    public final Rect z = new Rect();

    /* JADX WARNING: Illegal instructions before constructor call */
    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i2 = R$attr.materialClockStyle;
        SparseArray<TextView> sparseArray = new SparseArray<>();
        this.B = sparseArray;
        this.E = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i2, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList x0 = b.x0(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        this.L = x0;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.y = clockHandView;
        this.F = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = x0.getColorForState(new int[]{16842913}, x0.getDefaultColor());
        this.D = new int[]{colorForState, colorForState, x0.getDefaultColor()};
        clockHandView.f622g.add(this);
        int defaultColor = m.e.f0(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList x02 = b.x0(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(x02 != null ? x02.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.C = new f.b.a.e.a0.b(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.J = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        for (int i3 = 0; i3 < Math.max(this.J.length, size); i3++) {
            TextView textView = this.B.get(i3);
            if (i3 >= this.J.length) {
                removeView(textView);
                this.B.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.B.put(i3, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.J[i3]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i3));
                v.u(textView, this.C);
                textView.setTextColor(this.L);
            }
        }
        this.G = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_height);
        this.H = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_width);
        this.I = resources.getDimensionPixelSize(R$dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float f2, boolean z2) {
        if (Math.abs(this.K - f2) > 0.001f) {
            this.K = f2;
            t();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0037b.a(1, this.J.length, false, 1).a);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onMeasure(int i2, int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (((float) this.I) / Math.max(Math.max(((float) this.G) / ((float) displayMetrics.heightPixels), ((float) this.H) / ((float) displayMetrics.widthPixels)), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public final void t() {
        RectF rectF = this.y.f626k;
        for (int i2 = 0; i2 < this.B.size(); i2++) {
            TextView textView = this.B.get(i2);
            if (textView != null) {
                textView.getDrawingRect(this.z);
                this.z.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.z);
                this.A.set(this.z);
                textView.getPaint().setShader(!RectF.intersects(rectF, this.A) ? null : new RadialGradient(rectF.centerX() - this.A.left, rectF.centerY() - this.A.top, 0.5f * rectF.width(), this.D, this.E, Shader.TileMode.CLAMP));
                textView.invalidate();
            }
        }
    }
}
