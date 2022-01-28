package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.i.l.m;
import c.b.a.b.d;
import c.b.a.b.f;
import c.b.a.b.i0.n;
import c.b.a.b.l;

public class SnackbarContentLayout extends LinearLayout implements n {

    /* renamed from: b  reason: collision with root package name */
    public TextView f4528b;

    /* renamed from: c  reason: collision with root package name */
    public Button f4529c;

    /* renamed from: d  reason: collision with root package name */
    public int f4530d;

    /* renamed from: e  reason: collision with root package name */
    public int f4531e;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.SnackbarLayout);
        this.f4530d = obtainStyledAttributes.getDimensionPixelSize(l.SnackbarLayout_android_maxWidth, -1);
        this.f4531e = obtainStyledAttributes.getDimensionPixelSize(l.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    public final boolean a(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f4528b.getPaddingTop() == i2 && this.f4528b.getPaddingBottom() == i3) {
            return z;
        }
        TextView textView = this.f4528b;
        if (m.D(textView)) {
            textView.setPaddingRelative(textView.getPaddingStart(), i2, textView.getPaddingEnd(), i3);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i2, textView.getPaddingRight(), i3);
        return true;
    }

    public Button getActionView() {
        return this.f4529c;
    }

    public TextView getMessageView() {
        return this.f4528b;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f4528b = (TextView) findViewById(f.snackbar_text);
        this.f4529c = (Button) findViewById(f.snackbar_action);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (a(1, r0, r0 - r1) != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (a(0, r0, r0) != false) goto L_0x0060;
     */
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        if (this.f4530d > 0 && getMeasuredWidth() > (i3 = this.f4530d)) {
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical);
        boolean z = false;
        boolean z2 = this.f4528b.getLayout().getLineCount() > 1;
        if (!z2 || this.f4531e <= 0 || this.f4529c.getMeasuredWidth() <= this.f4531e) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
        z = true;
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    public void setMaxInlineActionWidth(int i) {
        this.f4531e = i;
    }
}
