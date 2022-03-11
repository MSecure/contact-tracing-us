package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;
import e.i.i.m;
import f.b.a.d.w.n;
import java.util.concurrent.atomic.AtomicInteger;

public class SnackbarContentLayout extends LinearLayout implements n {
    public TextView b;
    public Button c;

    /* renamed from: d  reason: collision with root package name */
    public int f576d;

    /* renamed from: e  reason: collision with root package name */
    public int f577e;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        this.f576d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
        this.f577e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    public final boolean a(int i2, int i3, int i4) {
        boolean z;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z = true;
        } else {
            z = false;
        }
        if (this.b.getPaddingTop() == i3 && this.b.getPaddingBottom() == i4) {
            return z;
        }
        TextView textView = this.b;
        AtomicInteger atomicInteger = m.a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i3, textView.getPaddingEnd(), i4);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i3, textView.getPaddingRight(), i4);
        return true;
    }

    public Button getActionView() {
        return this.c;
    }

    public TextView getMessageView() {
        return this.b;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.b = (TextView) findViewById(R$id.snackbar_text);
        this.c = (Button) findViewById(R$id.snackbar_action);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (a(1, r0, r0 - r1) != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (a(0, r0, r0) != false) goto L_0x0060;
     */
    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        if (this.f576d > 0 && getMeasuredWidth() > (i4 = this.f576d)) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            super.onMeasure(i2, i3);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical);
        boolean z = false;
        boolean z2 = this.b.getLayout().getLineCount() > 1;
        if (!z2 || this.f577e <= 0 || this.c.getMeasuredWidth() <= this.f577e) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
        z = true;
        if (z) {
            super.onMeasure(i2, i3);
        }
    }

    public void setMaxInlineActionWidth(int i2) {
        this.f577e = i2;
    }
}
