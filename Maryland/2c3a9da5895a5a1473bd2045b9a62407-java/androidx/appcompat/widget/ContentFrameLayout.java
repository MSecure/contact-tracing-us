package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import e.b.a.m;
import e.b.a.o;
import e.b.e.i.g;
import e.b.f.c0;
import java.util.Objects;

public class ContentFrameLayout extends FrameLayout {
    public TypedValue b;
    public TypedValue c;

    /* renamed from: d  reason: collision with root package name */
    public TypedValue f75d;

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f76e;

    /* renamed from: f  reason: collision with root package name */
    public TypedValue f77f;

    /* renamed from: g  reason: collision with root package name */
    public TypedValue f78g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f79h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    public a f80i;

    public interface a {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f77f == null) {
            this.f77f = new TypedValue();
        }
        return this.f77f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f78g == null) {
            this.f78g = new TypedValue();
        }
        return this.f78g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f75d == null) {
            this.f75d = new TypedValue();
        }
        return this.f75d;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f76e == null) {
            this.f76e = new TypedValue();
        }
        return this.f76e;
    }

    public TypedValue getMinWidthMajor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    public TypedValue getMinWidthMinor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f80i;
        if (aVar != null) {
            Objects.requireNonNull((o) aVar);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f80i;
        if (aVar != null) {
            m mVar = ((o) aVar).a;
            c0 c0Var = mVar.f666l;
            if (c0Var != null) {
                c0Var.l();
            }
            if (mVar.q != null) {
                mVar.f660f.getDecorView().removeCallbacks(mVar.r);
                if (mVar.q.isShowing()) {
                    try {
                        mVar.q.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                mVar.q = null;
            }
            mVar.J();
            g gVar = mVar.O(0).f683h;
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
            TypedValue typedValue = z3 ? this.f76e : this.f75d;
            if (!(typedValue == null || (i8 = typedValue.type) == 0)) {
                if (i8 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else if (i8 == 6) {
                    int i10 = displayMetrics.widthPixels;
                    fraction3 = typedValue.getFraction((float) i10, (float) i10);
                } else {
                    i9 = 0;
                    if (i9 > 0) {
                        Rect rect = this.f79h;
                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i9 - (rect.left + rect.right), View.MeasureSpec.getSize(i2)), 1073741824);
                        z = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue2 = z3 ? this.f77f : this.f78g;
                            if (!(typedValue2 == null || (i6 = typedValue2.type) == 0)) {
                                if (i6 == 5) {
                                    fraction2 = typedValue2.getDimension(displayMetrics);
                                } else if (i6 == 6) {
                                    int i11 = displayMetrics.heightPixels;
                                    fraction2 = typedValue2.getFraction((float) i11, (float) i11);
                                } else {
                                    i7 = 0;
                                    if (i7 > 0) {
                                        Rect rect2 = this.f79h;
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
                            TypedValue typedValue3 = !z3 ? this.c : this.b;
                            if (!(typedValue3 == null || (i4 = typedValue3.type) == 0)) {
                                if (i4 != 5) {
                                    fraction = typedValue3.getDimension(displayMetrics);
                                } else if (i4 == 6) {
                                    int i12 = displayMetrics.widthPixels;
                                    fraction = typedValue3.getFraction((float) i12, (float) i12);
                                } else {
                                    i5 = 0;
                                    if (i5 > 0) {
                                        Rect rect3 = this.f79h;
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
        this.f80i = aVar;
    }
}
