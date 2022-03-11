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
import e.b.f.g0;
import java.util.Objects;
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    public TypedValue b;
    public TypedValue c;

    /* renamed from: d */
    public TypedValue f79d;

    /* renamed from: e */
    public TypedValue f80e;

    /* renamed from: f */
    public TypedValue f81f;

    /* renamed from: g */
    public TypedValue f82g;

    /* renamed from: h */
    public final Rect f83h = new Rect();

    /* renamed from: i */
    public a f84i;

    /* loaded from: classes.dex */
    public interface a {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f81f == null) {
            this.f81f = new TypedValue();
        }
        return this.f81f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f82g == null) {
            this.f82g = new TypedValue();
        }
        return this.f82g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f79d == null) {
            this.f79d = new TypedValue();
        }
        return this.f79d;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f80e == null) {
            this.f80e = new TypedValue();
        }
        return this.f80e;
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

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f84i;
        if (aVar != null) {
            Objects.requireNonNull((o) aVar);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f84i;
        if (aVar != null) {
            m mVar = ((o) aVar).a;
            g0 g0Var = mVar.f723l;
            if (g0Var != null) {
                g0Var.l();
            }
            if (mVar.q != null) {
                mVar.f717f.getDecorView().removeCallbacks(mVar.r);
                if (mVar.q.isShowing()) {
                    try {
                        mVar.q.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                mVar.q = null;
            }
            mVar.J();
            g gVar = mVar.O(0).f741h;
            if (gVar != null) {
                gVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int measuredWidth;
        TypedValue typedValue;
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
            TypedValue typedValue2 = z3 ? this.f80e : this.f79d;
            if (!(typedValue2 == null || (i8 = typedValue2.type) == 0)) {
                if (i8 == 5) {
                    fraction3 = typedValue2.getDimension(displayMetrics);
                } else if (i8 == 6) {
                    int i10 = displayMetrics.widthPixels;
                    fraction3 = typedValue2.getFraction((float) i10, (float) i10);
                } else {
                    i9 = 0;
                    if (i9 > 0) {
                        Rect rect = this.f83h;
                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i9 - (rect.left + rect.right), View.MeasureSpec.getSize(i2)), 1073741824);
                        z = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue3 = z3 ? this.f81f : this.f82g;
                            if (!(typedValue3 == null || (i6 = typedValue3.type) == 0)) {
                                if (i6 == 5) {
                                    fraction2 = typedValue3.getDimension(displayMetrics);
                                } else if (i6 == 6) {
                                    int i11 = displayMetrics.heightPixels;
                                    fraction2 = typedValue3.getFraction((float) i11, (float) i11);
                                } else {
                                    i7 = 0;
                                    if (i7 > 0) {
                                        Rect rect2 = this.f83h;
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
                            typedValue = !z3 ? this.c : this.b;
                            if (!(typedValue == null || (i4 = typedValue.type) == 0)) {
                                if (i4 != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (i4 == 6) {
                                    int i12 = displayMetrics.widthPixels;
                                    fraction = typedValue.getFraction((float) i12, (float) i12);
                                } else {
                                    i5 = 0;
                                    if (i5 > 0) {
                                        Rect rect3 = this.f83h;
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
        if (!z) {
            if (!z3) {
            }
            if (typedValue == null) {
                if (i4 != 5) {
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

    public void setAttachListener(a aVar) {
        this.f84i = aVar;
    }
}
