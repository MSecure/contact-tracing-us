package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import b.b.k.i;
import b.b.k.l;
import b.b.p.i.g;
import b.b.q.c0;

public class ContentFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TypedValue f59b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f60c;

    /* renamed from: d  reason: collision with root package name */
    public TypedValue f61d;

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f62e;
    public TypedValue f;
    public TypedValue g;
    public final Rect h = new Rect();
    public a i;

    public interface a {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.g == null) {
            this.g = new TypedValue();
        }
        return this.g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f61d == null) {
            this.f61d = new TypedValue();
        }
        return this.f61d;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f62e == null) {
            this.f62e = new TypedValue();
        }
        return this.f62e;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f59b == null) {
            this.f59b = new TypedValue();
        }
        return this.f59b;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f60c == null) {
            this.f60c = new TypedValue();
        }
        return this.f60c;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.i;
        if (aVar != null && ((l) aVar) == null) {
            throw null;
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.i;
        if (aVar != null) {
            i iVar = ((l) aVar).f398a;
            c0 c0Var = iVar.l;
            if (c0Var != null) {
                c0Var.l();
            }
            if (iVar.q != null) {
                iVar.f.getDecorView().removeCallbacks(iVar.r);
                if (iVar.q.isShowing()) {
                    try {
                        iVar.q.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                iVar.q = null;
            }
            iVar.z();
            g gVar = iVar.E(0).h;
            if (gVar != null) {
                gVar.c(true);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int measuredWidth;
        int i4;
        int i5;
        float fraction;
        int i6;
        int i7;
        float fraction2;
        int i8;
        int i9;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue = z3 ? this.f62e : this.f61d;
            if (!(typedValue == null || (i8 = typedValue.type) == 0)) {
                if (i8 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else if (i8 == 6) {
                    int i10 = displayMetrics.widthPixels;
                    fraction3 = typedValue.getFraction((float) i10, (float) i10);
                } else {
                    i9 = 0;
                    if (i9 > 0) {
                        Rect rect = this.h;
                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i9 - (rect.left + rect.right), View.MeasureSpec.getSize(i2)), 1073741824);
                        z = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue2 = z3 ? this.f : this.g;
                            if (!(typedValue2 == null || (i6 = typedValue2.type) == 0)) {
                                if (i6 == 5) {
                                    fraction2 = typedValue2.getDimension(displayMetrics);
                                } else if (i6 == 6) {
                                    int i11 = displayMetrics.heightPixels;
                                    fraction2 = typedValue2.getFraction((float) i11, (float) i11);
                                } else {
                                    i7 = 0;
                                    if (i7 > 0) {
                                        Rect rect2 = this.h;
                                        i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i7 - (rect2.top + rect2.bottom), View.MeasureSpec.getSize(i3)), 1073741824);
                                    }
                                }
                                i7 = (int) fraction2;
                                if (i7 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i2, i3);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z && mode == Integer.MIN_VALUE) {
                            TypedValue typedValue3 = !z3 ? this.f60c : this.f59b;
                            if (!(typedValue3 == null || (i4 = typedValue3.type) == 0)) {
                                if (i4 != 5) {
                                    fraction = typedValue3.getDimension(displayMetrics);
                                } else if (i4 == 6) {
                                    int i12 = displayMetrics.widthPixels;
                                    fraction = typedValue3.getFraction((float) i12, (float) i12);
                                } else {
                                    i5 = 0;
                                    if (i5 > 0) {
                                        Rect rect3 = this.h;
                                        i5 -= rect3.left + rect3.right;
                                    }
                                    if (measuredWidth < i5) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                                        if (z2) {
                                            super.onMeasure(makeMeasureSpec, i3);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i5 = (int) fraction;
                                if (i5 > 0) {
                                }
                                if (measuredWidth < i5) {
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                i9 = (int) fraction3;
                if (i9 > 0) {
                }
            }
        }
        z = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i2, i3);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z3) {
        }
        if (i4 != 5) {
        }
        i5 = (int) fraction;
        if (i5 > 0) {
        }
        if (measuredWidth < i5) {
        }
        z2 = false;
        if (z2) {
        }
    }

    public void setAttachListener(a aVar) {
        this.i = aVar;
    }
}
