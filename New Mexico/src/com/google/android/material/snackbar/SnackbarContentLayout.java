package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import e.j.j.v;
import f.b.a.e.w.n;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements n {
    public TextView b;
    public Button c;

    /* renamed from: d */
    public int f612d;

    /* renamed from: e */
    public int f613e;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
        AtomicInteger atomicInteger = v.a;
        if (v.e.g(textView)) {
            v.e.k(textView, v.e.f(textView), i3, v.e.e(textView), i4);
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

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.b = (TextView) findViewById(R$id.snackbar_text);
        this.c = (Button) findViewById(R$id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (a(1, r0, r0 - r1) != false) goto L_0x0060;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        if (a(0, r0, r0) != false) goto L_0x0060;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        if (this.f612d > 0 && getMeasuredWidth() > (i4 = this.f612d)) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            super.onMeasure(i2, i3);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical);
        boolean z = false;
        boolean z2 = this.b.getLayout().getLineCount() > 1;
        if (!z2 || this.f613e <= 0 || this.c.getMeasuredWidth() <= this.f613e) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
        if (z) {
            super.onMeasure(i2, i3);
        }
    }

    public void setMaxInlineActionWidth(int i2) {
        this.f613e = i2;
    }

    public void setMaxWidth(int i2) {
        this.f612d = i2;
    }
}
