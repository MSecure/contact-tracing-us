package e.b.f;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import e.i.i.m;
import java.util.concurrent.atomic.AtomicInteger;

public class i0 extends ViewGroup {
    public boolean b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f889d;

    /* renamed from: e  reason: collision with root package name */
    public int f890e;

    /* renamed from: f  reason: collision with root package name */
    public int f891f;

    /* renamed from: g  reason: collision with root package name */
    public int f892g;

    /* renamed from: h  reason: collision with root package name */
    public float f893h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f894i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f895j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f896k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f897l;
    public int m;
    public int n;
    public int o;
    public int p;

    public static class a extends LinearLayout.LayoutParams {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public i0(Context context) {
        this(context, null);
    }

    public i0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int resourceId;
        this.b = true;
        this.c = -1;
        this.f889d = 0;
        this.f891f = 8388659;
        int[] iArr = R$styleable.LinearLayoutCompat;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        m.p(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        int i3 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (i3 >= 0) {
            setOrientation(i3);
        }
        int i4 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (i4 >= 0) {
            setGravity(i4);
        }
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f893h = obtainStyledAttributes.getFloat(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.c = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f894i = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        int i5 = R$styleable.LinearLayoutCompat_divider;
        setDividerDrawable((!obtainStyledAttributes.hasValue(i5) || (resourceId = obtainStyledAttributes.getResourceId(i5, 0)) == 0) ? obtainStyledAttributes.getDrawable(i5) : e.b.b.a.a.b(context, resourceId));
        this.o = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void f(Canvas canvas, int i2) {
        this.f897l.setBounds(getPaddingLeft() + this.p, i2, (getWidth() - getPaddingRight()) - this.p, this.n + i2);
        this.f897l.draw(canvas);
    }

    public void g(Canvas canvas, int i2) {
        this.f897l.setBounds(i2, getPaddingTop() + this.p, this.m + i2, (getHeight() - getPaddingBottom()) - this.p);
        this.f897l.draw(canvas);
    }

    public int getBaseline() {
        int i2;
        if (this.c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.c;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i4 = this.f889d;
                if (this.f890e == 1 && (i2 = this.f891f & 112) != 48) {
                    if (i2 == 16) {
                        i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f892g) / 2;
                    } else if (i2 == 80) {
                        i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f892g;
                    }
                }
                return i4 + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
            } else if (this.c == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.c;
    }

    public Drawable getDividerDrawable() {
        return this.f897l;
    }

    public int getDividerPadding() {
        return this.p;
    }

    public int getDividerWidth() {
        return this.m;
    }

    public int getGravity() {
        return this.f891f;
    }

    public int getOrientation() {
        return this.f890e;
    }

    public int getShowDividers() {
        return this.o;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f893h;
    }

    /* renamed from: h */
    public a generateDefaultLayoutParams() {
        int i2 = this.f890e;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* renamed from: i */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* renamed from: j */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int k() {
        return 0;
    }

    public int l() {
        return 0;
    }

    public int m() {
        return 0;
    }

    public boolean n(int i2) {
        if (i2 == 0) {
            return (this.o & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.o & 4) != 0;
        }
        if ((this.o & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public void o(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        if (this.f897l != null) {
            int i5 = 0;
            if (this.f890e == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i5 < virtualChildCount) {
                    View childAt = getChildAt(i5);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !n(i5))) {
                        f(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin) - this.n);
                    }
                    i5++;
                }
                if (n(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    f(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.n : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((a) childAt2.getLayoutParams())).bottomMargin);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean a2 = e1.a(this);
            while (i5 < virtualChildCount2) {
                View childAt3 = getChildAt(i5);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !n(i5))) {
                    a aVar = (a) childAt3.getLayoutParams();
                    g(canvas, a2 ? childAt3.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.m);
                }
                i5++;
            }
            if (n(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 != null) {
                    a aVar2 = (a) childAt4.getLayoutParams();
                    if (a2) {
                        i4 = childAt4.getLeft();
                        i3 = ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    } else {
                        i2 = childAt4.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                        g(canvas, i2);
                    }
                } else if (a2) {
                    i2 = getPaddingLeft();
                    g(canvas, i2);
                } else {
                    i4 = getWidth();
                    i3 = getPaddingRight();
                }
                i2 = (i4 - i3) - this.m;
                g(canvas, i2);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b8  */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = 8;
        int i19 = 5;
        if (this.f890e == 1) {
            int paddingLeft = getPaddingLeft();
            int i20 = i4 - i2;
            int paddingRight = i20 - getPaddingRight();
            int paddingRight2 = (i20 - paddingLeft) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i21 = this.f891f;
            int i22 = i21 & 112;
            int i23 = 8388615 & i21;
            int paddingTop = i22 != 16 ? i22 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - this.f892g : getPaddingTop() + (((i5 - i3) - this.f892g) / 2);
            int i24 = 0;
            while (i24 < virtualChildCount) {
                View childAt = getChildAt(i24);
                if (childAt == null) {
                    i15 = p() + paddingTop;
                } else if (childAt.getVisibility() != i18) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    a aVar = (a) childAt.getLayoutParams();
                    int i25 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i25 < 0) {
                        i25 = i23;
                    }
                    AtomicInteger atomicInteger = m.a;
                    int absoluteGravity = Gravity.getAbsoluteGravity(i25, getLayoutDirection()) & 7;
                    if (absoluteGravity == 1) {
                        i17 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    } else if (absoluteGravity != i19) {
                        i16 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        if (n(i24)) {
                            paddingTop += this.n;
                        }
                        int i26 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                        int l2 = l() + i26;
                        childAt.layout(i16, l2, measuredWidth + i16, measuredHeight + l2);
                        i15 = m() + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + i26;
                        i24 = k() + i24;
                    } else {
                        i17 = paddingRight - measuredWidth;
                    }
                    i16 = i17 - ((LinearLayout.LayoutParams) aVar).rightMargin;
                    if (n(i24)) {
                    }
                    int i262 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    int l22 = l() + i262;
                    childAt.layout(i16, l22, measuredWidth + i16, measuredHeight + l22);
                    i15 = m() + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + i262;
                    i24 = k() + i24;
                } else {
                    i24++;
                    i18 = 8;
                    i19 = 5;
                }
                paddingTop = i15;
                i24++;
                i18 = 8;
                i19 = 5;
            }
            return;
        }
        boolean a2 = e1.a(this);
        int paddingTop2 = getPaddingTop();
        int i27 = i5 - i3;
        int paddingBottom = i27 - getPaddingBottom();
        int paddingBottom2 = (i27 - paddingTop2) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i28 = this.f891f;
        int i29 = 8388615 & i28;
        int i30 = i28 & 112;
        boolean z3 = this.b;
        int[] iArr = this.f895j;
        int[] iArr2 = this.f896k;
        AtomicInteger atomicInteger2 = m.a;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i29, getLayoutDirection());
        int paddingLeft2 = absoluteGravity2 != 1 ? absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i4) - i2) - this.f892g : getPaddingLeft() + (((i4 - i2) - this.f892g) / 2);
        if (a2) {
            i6 = virtualChildCount2 - 1;
            i8 = 0;
            i7 = -1;
        } else {
            i8 = 0;
            i7 = 1;
            i6 = 0;
        }
        while (i8 < virtualChildCount2) {
            int i31 = (i7 * i8) + i6;
            View childAt2 = getChildAt(i31);
            if (childAt2 == null) {
                paddingLeft2 = p() + paddingLeft2;
            } else if (childAt2.getVisibility() != 8) {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                a aVar2 = (a) childAt2.getLayoutParams();
                i9 = virtualChildCount2;
                if (z3) {
                    i10 = i30;
                    if (((LinearLayout.LayoutParams) aVar2).height != -1) {
                        i11 = childAt2.getBaseline();
                        i12 = ((LinearLayout.LayoutParams) aVar2).gravity;
                        if (i12 < 0) {
                            i12 = i10;
                        }
                        i13 = i12 & 112;
                        z2 = z3;
                        if (i13 != 16) {
                            i14 = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop2) + ((LinearLayout.LayoutParams) aVar2).topMargin) - ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                        } else if (i13 == 48) {
                            i14 = ((LinearLayout.LayoutParams) aVar2).topMargin + paddingTop2;
                            if (i11 != -1) {
                                i14 = (iArr[1] - i11) + i14;
                            }
                        } else if (i13 != 80) {
                            i14 = paddingTop2;
                        } else {
                            i14 = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                            if (i11 != -1) {
                                i14 -= iArr2[2] - (childAt2.getMeasuredHeight() - i11);
                            }
                        }
                        if (n(i31)) {
                            paddingLeft2 += this.m;
                        }
                        int i32 = paddingLeft2 + ((LinearLayout.LayoutParams) aVar2).leftMargin;
                        int l3 = l() + i32;
                        childAt2.layout(l3, i14, measuredWidth2 + l3, measuredHeight2 + i14);
                        paddingLeft2 = i32 + m() + measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                        i8 = k() + i8;
                        i8++;
                        virtualChildCount2 = i9;
                        i30 = i10;
                        z3 = z2;
                    }
                } else {
                    i10 = i30;
                }
                i11 = -1;
                i12 = ((LinearLayout.LayoutParams) aVar2).gravity;
                if (i12 < 0) {
                }
                i13 = i12 & 112;
                z2 = z3;
                if (i13 != 16) {
                }
                if (n(i31)) {
                }
                int i322 = paddingLeft2 + ((LinearLayout.LayoutParams) aVar2).leftMargin;
                int l32 = l() + i322;
                childAt2.layout(l32, i14, measuredWidth2 + l32, measuredHeight2 + i14);
                paddingLeft2 = i322 + m() + measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                i8 = k() + i8;
                i8++;
                virtualChildCount2 = i9;
                i30 = i10;
                z3 = z2;
            }
            i9 = virtualChildCount2;
            i10 = i30;
            z2 = z3;
            i8++;
            virtualChildCount2 = i9;
            i30 = i10;
            z3 = z2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02c8, code lost:
        if (r13 < 0) goto L_0x02ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x075a, code lost:
        if (r7 < 0) goto L_0x075c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04da  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04df  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04e9  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04f8  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x050d  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x057a  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0585  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0620  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x06e6  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0703  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x08ad  */
    /* JADX WARNING: Removed duplicated region for block: B:421:? A[RETURN, SYNTHETIC] */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f2;
        int i9;
        char c2;
        int i10;
        int i11;
        int i12;
        float f3;
        int i13;
        int i14;
        int i15;
        boolean z;
        int baseline;
        int i16;
        int i17;
        char c3;
        boolean z2;
        boolean z3;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z4;
        a aVar;
        int i23;
        boolean z5;
        int i24;
        int i25;
        int baseline2;
        int i26;
        float f4;
        int i27;
        int i28;
        int i29;
        int i30;
        boolean z6;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        a aVar2;
        boolean z7;
        boolean z8;
        int i38;
        int i39;
        int i40 = -2;
        int i41 = Integer.MIN_VALUE;
        int i42 = 8;
        float f5 = 0.0f;
        int i43 = 1073741824;
        if (this.f890e == 1) {
            this.f892g = 0;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int i44 = this.c;
            boolean z9 = this.f894i;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            float f6 = 0.0f;
            boolean z10 = false;
            int i50 = 0;
            boolean z11 = true;
            boolean z12 = false;
            while (i45 < virtualChildCount) {
                View childAt = getChildAt(i45);
                if (childAt == null) {
                    this.f892g = p() + this.f892g;
                } else if (childAt.getVisibility() == i42) {
                    i45 += k();
                } else {
                    if (n(i45)) {
                        this.f892g += this.n;
                    }
                    a aVar3 = (a) childAt.getLayoutParams();
                    float f7 = ((LinearLayout.LayoutParams) aVar3).weight;
                    f6 += f7;
                    if (mode2 == i43 && ((LinearLayout.LayoutParams) aVar3).height == 0 && f7 > f5) {
                        int i51 = this.f892g;
                        this.f892g = Math.max(i51, ((LinearLayout.LayoutParams) aVar3).topMargin + i51 + ((LinearLayout.LayoutParams) aVar3).bottomMargin);
                        i34 = i44;
                        i33 = mode2;
                        i37 = mode;
                        i32 = virtualChildCount;
                        aVar2 = aVar3;
                        z7 = true;
                    } else {
                        if (((LinearLayout.LayoutParams) aVar3).height != 0 || f7 <= f5) {
                            i38 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) aVar3).height = i40;
                            i38 = 0;
                        }
                        if (f6 == f5) {
                            i39 = this.f892g;
                            i34 = i44;
                        } else {
                            i34 = i44;
                            i39 = 0;
                        }
                        i33 = mode2;
                        i37 = mode;
                        i32 = virtualChildCount;
                        aVar2 = aVar3;
                        o(childAt, i2, 0, i3, i39);
                        if (i38 != i41) {
                            ((LinearLayout.LayoutParams) aVar2).height = i38;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i52 = this.f892g;
                        this.f892g = Math.max(i52, m() + i52 + measuredHeight + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin);
                        if (z9) {
                            i47 = Math.max(measuredHeight, i47);
                        }
                        z7 = z10;
                    }
                    if (i34 >= 0 && i34 == i45 + 1) {
                        this.f889d = this.f892g;
                    }
                    if (i45 >= i34 || ((LinearLayout.LayoutParams) aVar2).weight <= 0.0f) {
                        i36 = i37;
                        if (i36 == 1073741824 || ((LinearLayout.LayoutParams) aVar2).width != -1) {
                            z8 = false;
                        } else {
                            z8 = true;
                            z12 = true;
                        }
                        int i53 = ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                        int measuredWidth = childAt.getMeasuredWidth() + i53;
                        i35 = Math.max(i49, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i50, childAt.getMeasuredState());
                        boolean z13 = z11 && ((LinearLayout.LayoutParams) aVar2).width == -1;
                        if (((LinearLayout.LayoutParams) aVar2).weight > 0.0f) {
                            if (!z8) {
                                i53 = measuredWidth;
                            }
                            i46 = Math.max(i46, i53);
                        } else {
                            if (!z8) {
                                i53 = measuredWidth;
                            }
                            i48 = Math.max(i48, i53);
                            i46 = i46;
                        }
                        i45 += k();
                        z10 = z7;
                        z11 = z13;
                        i50 = combineMeasuredStates;
                        i45++;
                        mode = i36;
                        i49 = i35;
                        i44 = i34;
                        mode2 = i33;
                        virtualChildCount = i32;
                        i40 = -2;
                        i41 = Integer.MIN_VALUE;
                        i42 = 8;
                        f5 = 0.0f;
                        i43 = 1073741824;
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i34 = i44;
                i33 = mode2;
                i36 = mode;
                i32 = virtualChildCount;
                i35 = i49;
                i45++;
                mode = i36;
                i49 = i35;
                i44 = i34;
                mode2 = i33;
                virtualChildCount = i32;
                i40 = -2;
                i41 = Integer.MIN_VALUE;
                i42 = 8;
                f5 = 0.0f;
                i43 = 1073741824;
            }
            int i54 = i48;
            int i55 = i49;
            int i56 = i50;
            if (this.f892g > 0 && n(virtualChildCount)) {
                this.f892g += this.n;
            }
            int i57 = mode2;
            if (z9 && (i57 == Integer.MIN_VALUE || i57 == 0)) {
                this.f892g = 0;
                int i58 = 0;
                while (i58 < virtualChildCount) {
                    View childAt2 = getChildAt(i58);
                    if (childAt2 == null) {
                        this.f892g = p() + this.f892g;
                    } else if (childAt2.getVisibility() == 8) {
                        i58 += k();
                    } else {
                        a aVar4 = (a) childAt2.getLayoutParams();
                        int i59 = this.f892g;
                        this.f892g = Math.max(i59, m() + i59 + i47 + ((LinearLayout.LayoutParams) aVar4).topMargin + ((LinearLayout.LayoutParams) aVar4).bottomMargin);
                    }
                    i58++;
                }
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop() + this.f892g;
            this.f892g = paddingBottom;
            int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, 0);
            int i60 = (16777215 & resolveSizeAndState) - this.f892g;
            if (z10 || (i60 != 0 && f6 > 0.0f)) {
                float f8 = this.f893h;
                if (f8 > 0.0f) {
                    f6 = f8;
                }
                this.f892g = 0;
                int i61 = 0;
                while (i61 < virtualChildCount) {
                    View childAt3 = getChildAt(i61);
                    if (childAt3.getVisibility() == 8) {
                        i28 = i57;
                    } else {
                        a aVar5 = (a) childAt3.getLayoutParams();
                        float f9 = ((LinearLayout.LayoutParams) aVar5).weight;
                        if (f9 > 0.0f) {
                            int i62 = (int) ((((float) i60) * f9) / f6);
                            f6 -= f9;
                            int i63 = i60 - i62;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) aVar5).leftMargin + ((LinearLayout.LayoutParams) aVar5).rightMargin, ((LinearLayout.LayoutParams) aVar5).width);
                            if (((LinearLayout.LayoutParams) aVar5).height != 0 || i57 != 1073741824) {
                                i31 = childAt3.getMeasuredHeight() + i62;
                            } else if (i62 > 0) {
                                i31 = i62;
                                childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i31, 1073741824));
                                i56 = View.combineMeasuredStates(i56, childAt3.getMeasuredState() & -256);
                                i60 = i63;
                            }
                            i31 = 0;
                            childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i31, 1073741824));
                            i56 = View.combineMeasuredStates(i56, childAt3.getMeasuredState() & -256);
                            i60 = i63;
                        }
                        int i64 = ((LinearLayout.LayoutParams) aVar5).leftMargin + ((LinearLayout.LayoutParams) aVar5).rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i64;
                        i55 = Math.max(i55, measuredWidth2);
                        i28 = i57;
                        if (mode != 1073741824) {
                            i29 = i60;
                            i30 = -1;
                            if (((LinearLayout.LayoutParams) aVar5).width == -1) {
                                z6 = true;
                                if (!z6) {
                                    i64 = measuredWidth2;
                                }
                                i54 = Math.max(i54, i64);
                                boolean z14 = !z11 && ((LinearLayout.LayoutParams) aVar5).width == i30;
                                int i65 = this.f892g;
                                this.f892g = Math.max(i65, m() + childAt3.getMeasuredHeight() + i65 + ((LinearLayout.LayoutParams) aVar5).topMargin + ((LinearLayout.LayoutParams) aVar5).bottomMargin);
                                z11 = z14;
                                i60 = i29;
                            }
                        } else {
                            i29 = i60;
                            i30 = -1;
                        }
                        z6 = false;
                        if (!z6) {
                        }
                        i54 = Math.max(i54, i64);
                        if (!z11) {
                        }
                        int i652 = this.f892g;
                        this.f892g = Math.max(i652, m() + childAt3.getMeasuredHeight() + i652 + ((LinearLayout.LayoutParams) aVar5).topMargin + ((LinearLayout.LayoutParams) aVar5).bottomMargin);
                        z11 = z14;
                        i60 = i29;
                    }
                    i61++;
                    i57 = i28;
                }
                this.f892g = getPaddingBottom() + getPaddingTop() + this.f892g;
            } else {
                i54 = Math.max(i54, i46);
                if (z9 && i57 != 1073741824) {
                    for (int i66 = 0; i66 < virtualChildCount; i66++) {
                        View childAt4 = getChildAt(i66);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LinearLayout.LayoutParams) ((a) childAt4.getLayoutParams())).weight <= 0.0f)) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i47, 1073741824));
                        }
                    }
                }
            }
            if (z11 || mode == 1073741824) {
                i54 = i55;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + i54, getSuggestedMinimumWidth()), i2, i56), resolveSizeAndState);
            if (z12) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                for (int i67 = 0; i67 < virtualChildCount; i67++) {
                    View childAt5 = getChildAt(i67);
                    if (childAt5.getVisibility() != 8) {
                        a aVar6 = (a) childAt5.getLayoutParams();
                        if (((LinearLayout.LayoutParams) aVar6).width == -1) {
                            int i68 = ((LinearLayout.LayoutParams) aVar6).height;
                            ((LinearLayout.LayoutParams) aVar6).height = childAt5.getMeasuredHeight();
                            measureChildWithMargins(childAt5, makeMeasureSpec, 0, i3, 0);
                            ((LinearLayout.LayoutParams) aVar6).height = i68;
                        }
                    }
                }
                return;
            }
            return;
        }
        this.f892g = 0;
        int virtualChildCount2 = getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i2);
        int mode4 = View.MeasureSpec.getMode(i3);
        if (this.f895j == null || this.f896k == null) {
            this.f895j = new int[4];
            this.f896k = new int[4];
        }
        int[] iArr = this.f895j;
        int[] iArr2 = this.f896k;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z15 = this.b;
        boolean z16 = this.f894i;
        boolean z17 = mode3 == 1073741824;
        int i69 = 0;
        float f10 = 0.0f;
        int i70 = 0;
        int i71 = 0;
        int i72 = 0;
        int i73 = 0;
        int i74 = 0;
        boolean z18 = false;
        boolean z19 = true;
        boolean z20 = false;
        while (i71 < virtualChildCount2) {
            View childAt6 = getChildAt(i71);
            if (childAt6 == null) {
                this.f892g = p() + this.f892g;
                i19 = i69;
                i18 = i70;
            } else {
                i19 = i69;
                i18 = i70;
                if (childAt6.getVisibility() == 8) {
                    i71 += k();
                } else {
                    if (n(i71)) {
                        this.f892g += this.m;
                    }
                    a aVar7 = (a) childAt6.getLayoutParams();
                    float f11 = ((LinearLayout.LayoutParams) aVar7).weight;
                    float f12 = f10 + f11;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) aVar7).width == 0 && f11 > 0.0f) {
                        if (z17) {
                            i27 = i71;
                            this.f892g = ((LinearLayout.LayoutParams) aVar7).leftMargin + ((LinearLayout.LayoutParams) aVar7).rightMargin + this.f892g;
                        } else {
                            i27 = i71;
                            int i75 = this.f892g;
                            this.f892g = Math.max(i75, ((LinearLayout.LayoutParams) aVar7).leftMargin + i75 + ((LinearLayout.LayoutParams) aVar7).rightMargin);
                        }
                        if (z15) {
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt6.measure(makeMeasureSpec2, makeMeasureSpec2);
                            aVar = aVar7;
                            i21 = i19;
                            i20 = i18;
                            i22 = i27;
                            z3 = z16;
                            z2 = z15;
                        } else {
                            aVar = aVar7;
                            i21 = i19;
                            i20 = i18;
                            i22 = i27;
                            i23 = 1073741824;
                            z3 = z16;
                            z2 = z15;
                            z4 = true;
                            if (mode4 == i23 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                                z5 = true;
                                z20 = true;
                            } else {
                                z5 = false;
                            }
                            i24 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                            int measuredHeight2 = childAt6.getMeasuredHeight() + i24;
                            int combineMeasuredStates2 = View.combineMeasuredStates(i73, childAt6.getMeasuredState());
                            if (z2 || (baseline2 = childAt6.getBaseline()) == -1) {
                                i25 = i24;
                            } else {
                                int i76 = ((LinearLayout.LayoutParams) aVar).gravity;
                                if (i76 < 0) {
                                    i76 = this.f891f;
                                }
                                int i77 = (((i76 & 112) >> 4) & -2) >> 1;
                                i25 = i24;
                                iArr[i77] = Math.max(iArr[i77], baseline2);
                                iArr2[i77] = Math.max(iArr2[i77], measuredHeight2 - baseline2);
                            }
                            int max = Math.max(i74, measuredHeight2);
                            boolean z21 = !z19 && ((LinearLayout.LayoutParams) aVar).height == -1;
                            if (((LinearLayout.LayoutParams) aVar).weight <= 0.0f) {
                                if (z5) {
                                    measuredHeight2 = i25;
                                }
                                i69 = Math.max(i21, measuredHeight2);
                            } else {
                                if (z5) {
                                    measuredHeight2 = i25;
                                }
                                i20 = Math.max(i20, measuredHeight2);
                                i69 = i21;
                            }
                            i71 = k() + i22;
                            i74 = max;
                            i73 = combineMeasuredStates2;
                            z18 = z4;
                            z19 = z21;
                            f10 = f12;
                            i70 = i20;
                            i71++;
                            z16 = z3;
                            z15 = z2;
                        }
                    } else {
                        if (((LinearLayout.LayoutParams) aVar7).width == 0) {
                            f4 = 0.0f;
                            if (f11 > 0.0f) {
                                ((LinearLayout.LayoutParams) aVar7).width = -2;
                                i26 = 0;
                                i21 = i19;
                                i20 = i18;
                                i22 = i71;
                                z3 = z16;
                                z2 = z15;
                                o(childAt6, i2, f12 != f4 ? this.f892g : 0, i3, 0);
                                if (i26 == Integer.MIN_VALUE) {
                                    aVar = aVar7;
                                    ((LinearLayout.LayoutParams) aVar).width = i26;
                                } else {
                                    aVar = aVar7;
                                }
                                int measuredWidth3 = childAt6.getMeasuredWidth();
                                int i78 = this.f892g;
                                if (!z17) {
                                    this.f892g = m() + ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth3 + ((LinearLayout.LayoutParams) aVar).rightMargin + i78;
                                } else {
                                    this.f892g = Math.max(i78, m() + i78 + measuredWidth3 + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin);
                                }
                                if (z3) {
                                    i72 = Math.max(measuredWidth3, i72);
                                }
                            }
                        } else {
                            f4 = 0.0f;
                        }
                        i26 = Integer.MIN_VALUE;
                        i21 = i19;
                        i20 = i18;
                        i22 = i71;
                        z3 = z16;
                        z2 = z15;
                        o(childAt6, i2, f12 != f4 ? this.f892g : 0, i3, 0);
                        if (i26 == Integer.MIN_VALUE) {
                        }
                        int measuredWidth32 = childAt6.getMeasuredWidth();
                        int i782 = this.f892g;
                        if (!z17) {
                        }
                        if (z3) {
                        }
                    }
                    z4 = z18;
                    i23 = 1073741824;
                    if (mode4 == i23) {
                    }
                    z5 = false;
                    i24 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    int measuredHeight22 = childAt6.getMeasuredHeight() + i24;
                    int combineMeasuredStates22 = View.combineMeasuredStates(i73, childAt6.getMeasuredState());
                    if (z2) {
                    }
                    i25 = i24;
                    int max2 = Math.max(i74, measuredHeight22);
                    if (!z19) {
                    }
                    if (((LinearLayout.LayoutParams) aVar).weight <= 0.0f) {
                    }
                    i71 = k() + i22;
                    i74 = max2;
                    i73 = combineMeasuredStates22;
                    z18 = z4;
                    z19 = z21;
                    f10 = f12;
                    i70 = i20;
                    i71++;
                    z16 = z3;
                    z15 = z2;
                }
            }
            z2 = z15;
            i69 = i19;
            i70 = i18;
            z3 = z16;
            i71++;
            z16 = z3;
            z15 = z2;
        }
        int i79 = i70;
        if (this.f892g > 0 && n(virtualChildCount2)) {
            this.f892g += this.m;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1) {
            c3 = 3;
            if (iArr[3] == -1) {
                i4 = i73;
                if (z16 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
                    this.f892g = 0;
                    i17 = 0;
                    while (i17 < virtualChildCount2) {
                        View childAt7 = getChildAt(i17);
                        if (childAt7 == null) {
                            this.f892g = p() + this.f892g;
                        } else if (childAt7.getVisibility() == 8) {
                            i17 += k();
                        } else {
                            a aVar8 = (a) childAt7.getLayoutParams();
                            int i80 = this.f892g;
                            this.f892g = z17 ? m() + ((LinearLayout.LayoutParams) aVar8).leftMargin + i72 + ((LinearLayout.LayoutParams) aVar8).rightMargin + i80 : Math.max(i80, m() + i80 + i72 + ((LinearLayout.LayoutParams) aVar8).leftMargin + ((LinearLayout.LayoutParams) aVar8).rightMargin);
                        }
                        i17++;
                    }
                }
                int paddingRight = getPaddingRight() + getPaddingLeft() + this.f892g;
                this.f892g = paddingRight;
                int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, 0);
                i5 = (16777215 & resolveSizeAndState2) - this.f892g;
                if (!z18 || (i5 != 0 && f10 > 0.0f)) {
                    f2 = this.f893h;
                    if (f2 > 0.0f) {
                        f10 = f2;
                    }
                    iArr[3] = -1;
                    iArr[2] = -1;
                    iArr[1] = -1;
                    iArr[0] = -1;
                    iArr2[3] = -1;
                    iArr2[2] = -1;
                    iArr2[1] = -1;
                    iArr2[0] = -1;
                    this.f892g = 0;
                    int i81 = i5;
                    i7 = i4;
                    int i82 = -1;
                    i9 = 0;
                    while (i9 < virtualChildCount2) {
                        View childAt8 = getChildAt(i9);
                        if (childAt8 == null || childAt8.getVisibility() == 8) {
                            i11 = i81;
                            i10 = virtualChildCount2;
                        } else {
                            a aVar9 = (a) childAt8.getLayoutParams();
                            float f13 = ((LinearLayout.LayoutParams) aVar9).weight;
                            if (f13 > 0.0f) {
                                i10 = virtualChildCount2;
                                int i83 = (int) ((((float) i81) * f13) / f10);
                                float f14 = f10 - f13;
                                int i84 = i81 - i83;
                                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) aVar9).topMargin + ((LinearLayout.LayoutParams) aVar9).bottomMargin, ((LinearLayout.LayoutParams) aVar9).height);
                                if (((LinearLayout.LayoutParams) aVar9).width != 0 || mode3 != 1073741824) {
                                    i16 = childAt8.getMeasuredWidth() + i83;
                                } else if (i83 > 0) {
                                    i16 = i83;
                                    childAt8.measure(View.MeasureSpec.makeMeasureSpec(i16, 1073741824), childMeasureSpec2);
                                    i7 = View.combineMeasuredStates(i7, childAt8.getMeasuredState() & -16777216);
                                    f10 = f14;
                                    i12 = i84;
                                }
                                i16 = 0;
                                childAt8.measure(View.MeasureSpec.makeMeasureSpec(i16, 1073741824), childMeasureSpec2);
                                i7 = View.combineMeasuredStates(i7, childAt8.getMeasuredState() & -16777216);
                                f10 = f14;
                                i12 = i84;
                            } else {
                                i12 = i81;
                                i10 = virtualChildCount2;
                            }
                            if (z17) {
                                f3 = f10;
                                i14 = m() + childAt8.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar9).leftMargin + ((LinearLayout.LayoutParams) aVar9).rightMargin + this.f892g;
                                i13 = i12;
                            } else {
                                f3 = f10;
                                int i85 = this.f892g;
                                i13 = i12;
                                i14 = Math.max(i85, m() + childAt8.getMeasuredWidth() + i85 + ((LinearLayout.LayoutParams) aVar9).leftMargin + ((LinearLayout.LayoutParams) aVar9).rightMargin);
                            }
                            this.f892g = i14;
                            boolean z22 = mode4 != 1073741824 && ((LinearLayout.LayoutParams) aVar9).height == -1;
                            int i86 = ((LinearLayout.LayoutParams) aVar9).topMargin + ((LinearLayout.LayoutParams) aVar9).bottomMargin;
                            int measuredHeight3 = childAt8.getMeasuredHeight() + i86;
                            i82 = Math.max(i82, measuredHeight3);
                            if (!z22) {
                                i86 = measuredHeight3;
                            }
                            i79 = Math.max(i79, i86);
                            if (z19) {
                                i15 = -1;
                                if (((LinearLayout.LayoutParams) aVar9).height == -1) {
                                    z = true;
                                    if (!z15 && (baseline = childAt8.getBaseline()) != i15) {
                                        int i87 = ((LinearLayout.LayoutParams) aVar9).gravity;
                                        if (i87 < 0) {
                                            i87 = this.f891f;
                                        }
                                        int i88 = (((i87 & 112) >> 4) & -2) >> 1;
                                        iArr[i88] = Math.max(iArr[i88], baseline);
                                        iArr2[i88] = Math.max(iArr2[i88], measuredHeight3 - baseline);
                                    }
                                    z19 = z;
                                    i11 = i13;
                                    f10 = f3;
                                }
                            } else {
                                i15 = -1;
                            }
                            z = false;
                            if (!z15) {
                            }
                            z19 = z;
                            i11 = i13;
                            f10 = f3;
                        }
                        i9++;
                        i81 = i11;
                        virtualChildCount2 = i10;
                    }
                    i8 = i3;
                    i6 = virtualChildCount2;
                    this.f892g = getPaddingRight() + getPaddingLeft() + this.f892g;
                    if (iArr[1] != -1 && iArr[0] == -1 && iArr[2] == -1) {
                        c2 = 3;
                        if (iArr[3] == -1) {
                            i74 = i82;
                        }
                    } else {
                        c2 = 3;
                    }
                    i74 = Math.max(i82, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
                    if (z19 || mode4 == 1073741824) {
                        i79 = i74;
                    }
                    setMeasuredDimension((-16777216 & i7) | resolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i79, getSuggestedMinimumHeight()), i8, i7 << 16));
                    if (z20) {
                        int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                        for (int i89 = 0; i89 < i6; i89++) {
                            View childAt9 = getChildAt(i89);
                            if (childAt9.getVisibility() != 8) {
                                a aVar10 = (a) childAt9.getLayoutParams();
                                if (((LinearLayout.LayoutParams) aVar10).height == -1) {
                                    int i90 = ((LinearLayout.LayoutParams) aVar10).width;
                                    ((LinearLayout.LayoutParams) aVar10).width = childAt9.getMeasuredWidth();
                                    measureChildWithMargins(childAt9, i2, 0, makeMeasureSpec3, 0);
                                    ((LinearLayout.LayoutParams) aVar10).width = i90;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                i79 = Math.max(i79, i69);
                if (z16 && mode3 != 1073741824) {
                    for (int i91 = 0; i91 < virtualChildCount2; i91++) {
                        View childAt10 = getChildAt(i91);
                        if (!(childAt10 == null || childAt10.getVisibility() == 8 || ((LinearLayout.LayoutParams) ((a) childAt10.getLayoutParams())).weight <= 0.0f)) {
                            childAt10.measure(View.MeasureSpec.makeMeasureSpec(i72, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt10.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
                i8 = i3;
                i6 = virtualChildCount2;
                i7 = i4;
                i79 = i74;
                setMeasuredDimension((-16777216 & i7) | resolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i79, getSuggestedMinimumHeight()), i8, i7 << 16));
                if (z20) {
                }
            }
        } else {
            c3 = 3;
        }
        i4 = i73;
        i74 = Math.max(i74, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        this.f892g = 0;
        i17 = 0;
        while (i17 < virtualChildCount2) {
        }
        int paddingRight2 = getPaddingRight() + getPaddingLeft() + this.f892g;
        this.f892g = paddingRight2;
        int resolveSizeAndState22 = View.resolveSizeAndState(Math.max(paddingRight2, getSuggestedMinimumWidth()), i2, 0);
        i5 = (16777215 & resolveSizeAndState22) - this.f892g;
        if (!z18) {
        }
        f2 = this.f893h;
        if (f2 > 0.0f) {
        }
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        this.f892g = 0;
        int i812 = i5;
        i7 = i4;
        int i822 = -1;
        i9 = 0;
        while (i9 < virtualChildCount2) {
        }
        i8 = i3;
        i6 = virtualChildCount2;
        this.f892g = getPaddingRight() + getPaddingLeft() + this.f892g;
        if (iArr[1] != -1) {
        }
        c2 = 3;
        i74 = Math.max(i822, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        i79 = i74;
        setMeasuredDimension((-16777216 & i7) | resolveSizeAndState22, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i79, getSuggestedMinimumHeight()), i8, i7 << 16));
        if (z20) {
        }
    }

    public int p() {
        return 0;
    }

    public void setBaselineAligned(boolean z) {
        this.b = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            StringBuilder i3 = f.a.a.a.a.i("base aligned child index out of range (0, ");
            i3.append(getChildCount());
            i3.append(")");
            throw new IllegalArgumentException(i3.toString());
        }
        this.c = i2;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f897l) {
            this.f897l = drawable;
            boolean z = false;
            if (drawable != null) {
                this.m = drawable.getIntrinsicWidth();
                this.n = drawable.getIntrinsicHeight();
            } else {
                this.m = 0;
                this.n = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i2) {
        this.p = i2;
    }

    public void setGravity(int i2) {
        if (this.f891f != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f891f = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f891f;
        if ((8388615 & i4) != i3) {
            this.f891f = i3 | (-8388616 & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f894i = z;
    }

    public void setOrientation(int i2) {
        if (this.f890e != i2) {
            this.f890e = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.o) {
            requestLayout();
        }
        this.o = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f891f;
        if ((i4 & 112) != i3) {
            this.f891f = i3 | (i4 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f893h = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
