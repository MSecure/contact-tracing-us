package b.b.q;

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
import b.b.j;
import b.i.l.m;
import com.google.android.gms.nearby.messages.BleSignal;

public class i0 extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public boolean f859b;

    /* renamed from: c  reason: collision with root package name */
    public int f860c;

    /* renamed from: d  reason: collision with root package name */
    public int f861d;

    /* renamed from: e  reason: collision with root package name */
    public int f862e;

    /* renamed from: f  reason: collision with root package name */
    public int f863f;

    /* renamed from: g  reason: collision with root package name */
    public int f864g;
    public float h;
    public boolean i;
    public int[] j;
    public int[] k;
    public Drawable l;
    public int m;
    public int n;
    public int o;
    public int p;

    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public float f865a;

        /* renamed from: b  reason: collision with root package name */
        public int f866b;

        public a(int i, int i2) {
            super(i, i2);
            this.f866b = -1;
            this.f865a = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f866b = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.LinearLayoutCompat_Layout);
            this.f865a = obtainStyledAttributes.getFloat(j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f866b = obtainStyledAttributes.getInt(j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f866b = -1;
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
        this.f859b = true;
        this.f860c = -1;
        this.f861d = 0;
        this.f863f = 8388659;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.LinearLayoutCompat, i2, 0);
        m.T(this, context, j.LinearLayoutCompat, attributeSet, obtainStyledAttributes, i2, 0);
        int i3 = obtainStyledAttributes.getInt(j.LinearLayoutCompat_android_orientation, -1);
        if (i3 >= 0) {
            setOrientation(i3);
        }
        int i4 = obtainStyledAttributes.getInt(j.LinearLayoutCompat_android_gravity, -1);
        if (i4 >= 0) {
            setGravity(i4);
        }
        boolean z = obtainStyledAttributes.getBoolean(j.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.h = obtainStyledAttributes.getFloat(j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f860c = obtainStyledAttributes.getInt(j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.i = obtainStyledAttributes.getBoolean(j.LinearLayoutCompat_measureWithLargestChild, false);
        int i5 = j.LinearLayoutCompat_divider;
        setDividerDrawable((!obtainStyledAttributes.hasValue(i5) || (resourceId = obtainStyledAttributes.getResourceId(i5, 0)) == 0) ? obtainStyledAttributes.getDrawable(i5) : b.b.l.a.a.b(context, resourceId));
        this.o = obtainStyledAttributes.getInt(j.LinearLayoutCompat_showDividers, 0);
        this.p = obtainStyledAttributes.getDimensionPixelSize(j.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void g(Canvas canvas, int i2) {
        this.l.setBounds(getPaddingLeft() + this.p, i2, (getWidth() - getPaddingRight()) - this.p, this.n + i2);
        this.l.draw(canvas);
    }

    public int getBaseline() {
        int i2;
        if (this.f860c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f860c;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i4 = this.f861d;
                if (this.f862e == 1 && (i2 = this.f863f & 112) != 48) {
                    if (i2 == 16) {
                        i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f864g) / 2;
                    } else if (i2 == 80) {
                        i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f864g;
                    }
                }
                return i4 + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
            } else if (this.f860c == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f860c;
    }

    public Drawable getDividerDrawable() {
        return this.l;
    }

    public int getDividerPadding() {
        return this.p;
    }

    public int getDividerWidth() {
        return this.m;
    }

    public int getGravity() {
        return this.f863f;
    }

    public int getOrientation() {
        return this.f862e;
    }

    public int getShowDividers() {
        return this.o;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.h;
    }

    public void h(Canvas canvas, int i2) {
        this.l.setBounds(i2, getPaddingTop() + this.p, this.m + i2, (getHeight() - getPaddingBottom()) - this.p);
        this.l.draw(canvas);
    }

    /* renamed from: i */
    public a generateDefaultLayoutParams() {
        int i2 = this.f862e;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* renamed from: j */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* renamed from: k */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int l() {
        return 0;
    }

    public int m() {
        return 0;
    }

    public int n() {
        return 0;
    }

    public boolean o(int i2) {
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

    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        if (this.l != null) {
            int i5 = 0;
            if (this.f862e == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i5 < virtualChildCount) {
                    View childAt = getChildAt(i5);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !o(i5))) {
                        g(canvas, (childAt.getTop() - ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin) - this.n);
                    }
                    i5++;
                }
                if (o(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    g(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.n : childAt2.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) childAt2.getLayoutParams())).bottomMargin);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean a2 = e1.a(this);
            while (i5 < virtualChildCount2) {
                View childAt3 = getChildAt(i5);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !o(i5))) {
                    a aVar = (a) childAt3.getLayoutParams();
                    h(canvas, a2 ? childAt3.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin : (childAt3.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.m);
                }
                i5++;
            }
            if (o(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 != null) {
                    a aVar2 = (a) childAt4.getLayoutParams();
                    if (a2) {
                        i4 = childAt4.getLeft();
                        i3 = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    } else {
                        i2 = childAt4.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                        h(canvas, i2);
                    }
                } else if (a2) {
                    i2 = getPaddingLeft();
                    h(canvas, i2);
                } else {
                    i4 = getWidth();
                    i3 = getPaddingRight();
                }
                i2 = (i4 - i3) - this.m;
                h(canvas, i2);
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

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b4  */
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
        if (this.f862e == 1) {
            int paddingLeft = getPaddingLeft();
            int i20 = i4 - i2;
            int paddingRight = i20 - getPaddingRight();
            int paddingRight2 = (i20 - paddingLeft) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i21 = this.f863f;
            int i22 = i21 & 112;
            int i23 = 8388615 & i21;
            int paddingTop = i22 != 16 ? i22 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - this.f864g : getPaddingTop() + (((i5 - i3) - this.f864g) / 2);
            int i24 = 0;
            while (i24 < virtualChildCount) {
                View childAt = getChildAt(i24);
                if (childAt == null) {
                    i15 = q() + paddingTop;
                } else if (childAt.getVisibility() != i18) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    a aVar = (a) childAt.getLayoutParams();
                    int i25 = aVar.f866b;
                    if (i25 < 0) {
                        i25 = i23;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i25, m.p(this)) & 7;
                    if (absoluteGravity == 1) {
                        i17 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                    } else if (absoluteGravity != i19) {
                        i16 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                        if (o(i24)) {
                            paddingTop += this.n;
                        }
                        int i26 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                        int m2 = m() + i26;
                        childAt.layout(i16, m2, measuredWidth + i16, measuredHeight + m2);
                        i15 = n() + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + i26;
                        i24 = l() + i24;
                    } else {
                        i17 = paddingRight - measuredWidth;
                    }
                    i16 = i17 - ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                    if (o(i24)) {
                    }
                    int i262 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                    int m22 = m() + i262;
                    childAt.layout(i16, m22, measuredWidth + i16, measuredHeight + m22);
                    i15 = n() + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + i262;
                    i24 = l() + i24;
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
        int i28 = this.f863f;
        int i29 = 8388615 & i28;
        int i30 = i28 & 112;
        boolean z3 = this.f859b;
        int[] iArr = this.j;
        int[] iArr2 = this.k;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i29, getLayoutDirection());
        int paddingLeft2 = absoluteGravity2 != 1 ? absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i4) - i2) - this.f864g : getPaddingLeft() + (((i4 - i2) - this.f864g) / 2);
        if (a2) {
            i6 = virtualChildCount2 - 1;
            i8 = 0;
            i7 = -1;
        } else {
            i7 = 1;
            i8 = 0;
            i6 = 0;
        }
        while (i8 < virtualChildCount2) {
            int i31 = (i7 * i8) + i6;
            View childAt2 = getChildAt(i31);
            if (childAt2 == null) {
                paddingLeft2 = q() + paddingLeft2;
            } else if (childAt2.getVisibility() != 8) {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                a aVar2 = (a) childAt2.getLayoutParams();
                i9 = virtualChildCount2;
                if (z3) {
                    i10 = i30;
                    if (((ViewGroup.MarginLayoutParams) aVar2).height != -1) {
                        i11 = childAt2.getBaseline();
                        i12 = aVar2.f866b;
                        if (i12 < 0) {
                            i12 = i10;
                        }
                        i13 = i12 & 112;
                        z2 = z3;
                        if (i13 != 16) {
                            i14 = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop2) + ((ViewGroup.MarginLayoutParams) aVar2).topMargin) - ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin;
                        } else if (i13 == 48) {
                            i14 = ((ViewGroup.MarginLayoutParams) aVar2).topMargin + paddingTop2;
                            if (i11 != -1) {
                                i14 = (iArr[1] - i11) + i14;
                            }
                        } else if (i13 != 80) {
                            i14 = paddingTop2;
                        } else {
                            i14 = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin;
                            if (i11 != -1) {
                                i14 -= iArr2[2] - (childAt2.getMeasuredHeight() - i11);
                            }
                        }
                        if (o(i31)) {
                            paddingLeft2 += this.m;
                        }
                        int i32 = paddingLeft2 + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                        int m3 = m() + i32;
                        childAt2.layout(m3, i14, measuredWidth2 + m3, measuredHeight2 + i14);
                        paddingLeft2 = i32 + n() + measuredWidth2 + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                        i8 = l() + i8;
                        i8++;
                        virtualChildCount2 = i9;
                        i30 = i10;
                        z3 = z2;
                    }
                } else {
                    i10 = i30;
                }
                i11 = -1;
                i12 = aVar2.f866b;
                if (i12 < 0) {
                }
                i13 = i12 & 112;
                z2 = z3;
                if (i13 != 16) {
                }
                if (o(i31)) {
                }
                int i322 = paddingLeft2 + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                int m32 = m() + i322;
                childAt2.layout(m32, i14, measuredWidth2 + m32, measuredHeight2 + i14);
                paddingLeft2 = i322 + n() + measuredWidth2 + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                i8 = l() + i8;
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

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02cb, code lost:
        if (r13 < 0) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0764, code lost:
        if (r7 < 0) goto L_0x0766;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04e3  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04e8  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04f2  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0501  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0585  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0590  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x062b  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x06f1  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x070e  */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x08b9  */
    /* JADX WARNING: Removed duplicated region for block: B:421:? A[RETURN, SYNTHETIC] */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        float f2;
        int i10;
        char c2;
        int i11;
        int i12;
        int i13;
        float f3;
        int i14;
        int i15;
        int i16;
        boolean z;
        int baseline;
        int i17;
        int i18;
        char c3;
        boolean z2;
        boolean z3;
        int i19;
        int i20;
        int i21;
        boolean z4;
        a aVar;
        int i22;
        boolean z5;
        int i23;
        int i24;
        int baseline2;
        int i25;
        float f4;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z6;
        int i30;
        int i31;
        int i32;
        boolean z7;
        int i33;
        int i34;
        int i35;
        int i36;
        a aVar2;
        boolean z8;
        boolean z9;
        int i37;
        int i38;
        int i39 = this.f862e;
        int i40 = -2;
        int i41 = BleSignal.UNKNOWN_TX_POWER;
        int i42 = 8;
        float f5 = 0.0f;
        int i43 = 1073741824;
        boolean z10 = true;
        if (i39 == 1) {
            this.f864g = 0;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int i44 = this.f860c;
            boolean z11 = this.i;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            boolean z12 = false;
            boolean z13 = false;
            int i50 = 0;
            boolean z14 = true;
            float f6 = 0.0f;
            while (i45 < virtualChildCount) {
                View childAt = getChildAt(i45);
                if (childAt == null) {
                    this.f864g = q() + this.f864g;
                } else if (childAt.getVisibility() == i42) {
                    i45 += l();
                } else {
                    if (o(i45)) {
                        this.f864g += this.n;
                    }
                    a aVar3 = (a) childAt.getLayoutParams();
                    float f7 = aVar3.f865a;
                    f6 += f7;
                    if (mode2 == i43 && ((ViewGroup.MarginLayoutParams) aVar3).height == 0 && f7 > f5) {
                        int i51 = this.f864g;
                        this.f864g = Math.max(i51, ((ViewGroup.MarginLayoutParams) aVar3).topMargin + i51 + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin);
                        i33 = i44;
                        i32 = mode2;
                        i36 = mode;
                        i31 = virtualChildCount;
                        aVar2 = aVar3;
                        z8 = true;
                        z7 = true;
                    } else {
                        if (((ViewGroup.MarginLayoutParams) aVar3).height != 0 || aVar3.f865a <= f5) {
                            i37 = i41;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar3).height = i40;
                            i37 = 0;
                        }
                        if (f6 == f5) {
                            i38 = this.f864g;
                            i33 = i44;
                        } else {
                            i33 = i44;
                            i38 = 0;
                        }
                        i32 = mode2;
                        i36 = mode;
                        i31 = virtualChildCount;
                        aVar2 = aVar3;
                        z7 = true;
                        p(childAt, i2, 0, i3, i38);
                        if (i37 != i41) {
                            ((ViewGroup.MarginLayoutParams) aVar2).height = i37;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i52 = this.f864g;
                        this.f864g = Math.max(i52, n() + i52 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar2).topMargin + ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin);
                        if (z11) {
                            i47 = Math.max(measuredHeight, i47);
                        }
                        z8 = z12;
                    }
                    if (i33 >= 0 && i33 == i45 + 1) {
                        this.f861d = this.f864g;
                    }
                    if (i45 >= i33 || aVar2.f865a <= 0.0f) {
                        i35 = i36;
                        if (i35 == 1073741824 || ((ViewGroup.MarginLayoutParams) aVar2).width != -1) {
                            z9 = false;
                        } else {
                            z9 = z7;
                            z13 = z9;
                        }
                        int i53 = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                        int measuredWidth = childAt.getMeasuredWidth() + i53;
                        i34 = Math.max(i49, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i50, childAt.getMeasuredState());
                        boolean z15 = (!z14 || ((ViewGroup.MarginLayoutParams) aVar2).width != -1) ? false : z7;
                        if (aVar2.f865a > 0.0f) {
                            if (!z9) {
                                i53 = measuredWidth;
                            }
                            i46 = Math.max(i46, i53);
                        } else {
                            if (!z9) {
                                i53 = measuredWidth;
                            }
                            i48 = Math.max(i48, i53);
                            i46 = i46;
                        }
                        i45 += l();
                        z12 = z8;
                        z14 = z15;
                        i50 = combineMeasuredStates;
                        i45++;
                        mode = i35;
                        i49 = i34;
                        i44 = i33;
                        z10 = z7;
                        mode2 = i32;
                        virtualChildCount = i31;
                        i40 = -2;
                        i41 = BleSignal.UNKNOWN_TX_POWER;
                        i42 = 8;
                        f5 = 0.0f;
                        i43 = 1073741824;
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i33 = i44;
                i32 = mode2;
                i35 = mode;
                i31 = virtualChildCount;
                z7 = z10;
                i34 = i49;
                i45++;
                mode = i35;
                i49 = i34;
                i44 = i33;
                z10 = z7;
                mode2 = i32;
                virtualChildCount = i31;
                i40 = -2;
                i41 = BleSignal.UNKNOWN_TX_POWER;
                i42 = 8;
                f5 = 0.0f;
                i43 = 1073741824;
            }
            int i54 = i48;
            int i55 = i49;
            int i56 = i50;
            if (this.f864g > 0 && o(virtualChildCount)) {
                this.f864g += this.n;
            }
            int i57 = mode2;
            if (z11 && (i57 == Integer.MIN_VALUE || i57 == 0)) {
                this.f864g = 0;
                int i58 = 0;
                while (i58 < virtualChildCount) {
                    View childAt2 = getChildAt(i58);
                    if (childAt2 == null) {
                        this.f864g = q() + this.f864g;
                    } else if (childAt2.getVisibility() == 8) {
                        i58 += l();
                    } else {
                        a aVar4 = (a) childAt2.getLayoutParams();
                        int i59 = this.f864g;
                        this.f864g = Math.max(i59, n() + i59 + i47 + ((ViewGroup.MarginLayoutParams) aVar4).topMargin + ((ViewGroup.MarginLayoutParams) aVar4).bottomMargin);
                    }
                    i58++;
                }
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop() + this.f864g;
            this.f864g = paddingBottom;
            int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, 0);
            int i60 = (16777215 & resolveSizeAndState) - this.f864g;
            if (z12 || (i60 != 0 && f6 > 0.0f)) {
                float f8 = this.h;
                if (f8 > 0.0f) {
                    f6 = f8;
                }
                this.f864g = 0;
                int i61 = 0;
                while (i61 < virtualChildCount) {
                    View childAt3 = getChildAt(i61);
                    if (childAt3.getVisibility() == 8) {
                        i27 = i57;
                    } else {
                        a aVar5 = (a) childAt3.getLayoutParams();
                        float f9 = aVar5.f865a;
                        if (f9 > 0.0f) {
                            int i62 = (int) ((((float) i60) * f9) / f6);
                            f6 -= f9;
                            int i63 = i60 - i62;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) aVar5).leftMargin + ((ViewGroup.MarginLayoutParams) aVar5).rightMargin, ((ViewGroup.MarginLayoutParams) aVar5).width);
                            if (((ViewGroup.MarginLayoutParams) aVar5).height != 0 || i57 != 1073741824) {
                                i30 = childAt3.getMeasuredHeight() + i62;
                            } else if (i62 > 0) {
                                i30 = i62;
                                childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i30, 1073741824));
                                i56 = View.combineMeasuredStates(i56, childAt3.getMeasuredState() & -256);
                                i60 = i63;
                            }
                            i30 = 0;
                            childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i30, 1073741824));
                            i56 = View.combineMeasuredStates(i56, childAt3.getMeasuredState() & -256);
                            i60 = i63;
                        }
                        int i64 = ((ViewGroup.MarginLayoutParams) aVar5).leftMargin + ((ViewGroup.MarginLayoutParams) aVar5).rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i64;
                        i55 = Math.max(i55, measuredWidth2);
                        i27 = i57;
                        if (mode != 1073741824) {
                            i28 = i60;
                            i29 = -1;
                            if (((ViewGroup.MarginLayoutParams) aVar5).width == -1) {
                                z6 = z10;
                                if (!z6) {
                                    i64 = measuredWidth2;
                                }
                                i54 = Math.max(i54, i64);
                                boolean z16 = (z14 || ((ViewGroup.MarginLayoutParams) aVar5).width != i29) ? false : z10;
                                int i65 = this.f864g;
                                this.f864g = Math.max(i65, n() + childAt3.getMeasuredHeight() + i65 + ((ViewGroup.MarginLayoutParams) aVar5).topMargin + ((ViewGroup.MarginLayoutParams) aVar5).bottomMargin);
                                z14 = z16;
                                i60 = i28;
                            }
                        } else {
                            i28 = i60;
                            i29 = -1;
                        }
                        z6 = false;
                        if (!z6) {
                        }
                        i54 = Math.max(i54, i64);
                        if (z14) {
                        }
                        int i652 = this.f864g;
                        this.f864g = Math.max(i652, n() + childAt3.getMeasuredHeight() + i652 + ((ViewGroup.MarginLayoutParams) aVar5).topMargin + ((ViewGroup.MarginLayoutParams) aVar5).bottomMargin);
                        z14 = z16;
                        i60 = i28;
                    }
                    i61++;
                    i57 = i27;
                }
                this.f864g = getPaddingBottom() + getPaddingTop() + this.f864g;
            } else {
                i54 = Math.max(i54, i46);
                if (z11 && i57 != 1073741824) {
                    for (int i66 = 0; i66 < virtualChildCount; i66++) {
                        View childAt4 = getChildAt(i66);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((a) childAt4.getLayoutParams()).f865a <= 0.0f)) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i47, 1073741824));
                        }
                    }
                }
            }
            if (z14 || mode == 1073741824) {
                i54 = i55;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + i54, getSuggestedMinimumWidth()), i2, i56), resolveSizeAndState);
            if (z13) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                for (int i67 = 0; i67 < virtualChildCount; i67++) {
                    View childAt5 = getChildAt(i67);
                    if (childAt5.getVisibility() != 8) {
                        a aVar6 = (a) childAt5.getLayoutParams();
                        if (((ViewGroup.MarginLayoutParams) aVar6).width == -1) {
                            int i68 = ((ViewGroup.MarginLayoutParams) aVar6).height;
                            ((ViewGroup.MarginLayoutParams) aVar6).height = childAt5.getMeasuredHeight();
                            measureChildWithMargins(childAt5, makeMeasureSpec, 0, i3, 0);
                            ((ViewGroup.MarginLayoutParams) aVar6).height = i68;
                        }
                    }
                }
                return;
            }
            return;
        }
        this.f864g = 0;
        int virtualChildCount2 = getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i2);
        int mode4 = View.MeasureSpec.getMode(i3);
        if (this.j == null || this.k == null) {
            this.j = new int[4];
            this.k = new int[4];
        }
        int[] iArr = this.j;
        int[] iArr2 = this.k;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z17 = this.f859b;
        boolean z18 = this.i;
        boolean z19 = mode3 == 1073741824;
        boolean z20 = true;
        int i69 = 0;
        float f10 = 0.0f;
        int i70 = 0;
        int i71 = 0;
        int i72 = 0;
        int i73 = 0;
        int i74 = 0;
        boolean z21 = false;
        boolean z22 = false;
        while (i71 < virtualChildCount2) {
            View childAt6 = getChildAt(i71);
            if (childAt6 == null) {
                this.f864g = q() + this.f864g;
                z3 = z18;
                z2 = z17;
            } else if (childAt6.getVisibility() == 8) {
                i71 += l();
                z2 = z17;
                i69 = i69;
                i70 = i70;
                z3 = z18;
            } else {
                if (o(i71)) {
                    this.f864g += this.m;
                }
                a aVar7 = (a) childAt6.getLayoutParams();
                float f11 = aVar7.f865a;
                float f12 = f10 + f11;
                if (mode3 == 1073741824 && ((ViewGroup.MarginLayoutParams) aVar7).width == 0 && f11 > 0.0f) {
                    if (z19) {
                        i26 = i71;
                        this.f864g = ((ViewGroup.MarginLayoutParams) aVar7).leftMargin + ((ViewGroup.MarginLayoutParams) aVar7).rightMargin + this.f864g;
                    } else {
                        i26 = i71;
                        int i75 = this.f864g;
                        this.f864g = Math.max(i75, ((ViewGroup.MarginLayoutParams) aVar7).leftMargin + i75 + ((ViewGroup.MarginLayoutParams) aVar7).rightMargin);
                    }
                    if (z17) {
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                        childAt6.measure(makeMeasureSpec2, makeMeasureSpec2);
                        aVar = aVar7;
                        i20 = i69;
                        i19 = i70;
                        i21 = i26;
                        z3 = z18;
                        z2 = z17;
                    } else {
                        aVar = aVar7;
                        i20 = i69;
                        i19 = i70;
                        i21 = i26;
                        i22 = 1073741824;
                        z3 = z18;
                        z2 = z17;
                        z4 = true;
                        if (mode4 == i22 && ((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                            z5 = true;
                            z22 = true;
                        } else {
                            z5 = false;
                        }
                        i23 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        int measuredHeight2 = childAt6.getMeasuredHeight() + i23;
                        int combineMeasuredStates2 = View.combineMeasuredStates(i73, childAt6.getMeasuredState());
                        if (z2 || (baseline2 = childAt6.getBaseline()) == -1) {
                            i24 = i23;
                        } else {
                            int i76 = aVar.f866b;
                            if (i76 < 0) {
                                i76 = this.f863f;
                            }
                            int i77 = (((i76 & 112) >> 4) & -2) >> 1;
                            i24 = i23;
                            iArr[i77] = Math.max(iArr[i77], baseline2);
                            iArr2[i77] = Math.max(iArr2[i77], measuredHeight2 - baseline2);
                        }
                        int max = Math.max(i74, measuredHeight2);
                        boolean z23 = !z20 && ((ViewGroup.MarginLayoutParams) aVar).height == -1;
                        if (aVar.f865a <= 0.0f) {
                            if (z5) {
                                measuredHeight2 = i24;
                            }
                            i69 = Math.max(i20, measuredHeight2);
                        } else {
                            if (z5) {
                                measuredHeight2 = i24;
                            }
                            i19 = Math.max(i19, measuredHeight2);
                            i69 = i20;
                        }
                        i71 = l() + i21;
                        i74 = max;
                        i73 = combineMeasuredStates2;
                        z21 = z4;
                        z20 = z23;
                        f10 = f12;
                        i70 = i19;
                    }
                } else {
                    if (((ViewGroup.MarginLayoutParams) aVar7).width == 0) {
                        f4 = 0.0f;
                        if (aVar7.f865a > 0.0f) {
                            ((ViewGroup.MarginLayoutParams) aVar7).width = -2;
                            i25 = 0;
                            i20 = i69;
                            i19 = i70;
                            i21 = i71;
                            z3 = z18;
                            z2 = z17;
                            p(childAt6, i2, f12 != f4 ? this.f864g : 0, i3, 0);
                            if (i25 == Integer.MIN_VALUE) {
                                aVar = aVar7;
                                ((ViewGroup.MarginLayoutParams) aVar).width = i25;
                            } else {
                                aVar = aVar7;
                            }
                            int measuredWidth3 = childAt6.getMeasuredWidth();
                            int i78 = this.f864g;
                            if (!z19) {
                                this.f864g = n() + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + measuredWidth3 + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + i78;
                            } else {
                                this.f864g = Math.max(i78, n() + i78 + measuredWidth3 + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin);
                            }
                            if (z3) {
                                i72 = Math.max(measuredWidth3, i72);
                            }
                        }
                    } else {
                        f4 = 0.0f;
                    }
                    i25 = BleSignal.UNKNOWN_TX_POWER;
                    i20 = i69;
                    i19 = i70;
                    i21 = i71;
                    z3 = z18;
                    z2 = z17;
                    p(childAt6, i2, f12 != f4 ? this.f864g : 0, i3, 0);
                    if (i25 == Integer.MIN_VALUE) {
                    }
                    int measuredWidth32 = childAt6.getMeasuredWidth();
                    int i782 = this.f864g;
                    if (!z19) {
                    }
                    if (z3) {
                    }
                }
                z4 = z21;
                i22 = 1073741824;
                if (mode4 == i22) {
                }
                z5 = false;
                i23 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                int measuredHeight22 = childAt6.getMeasuredHeight() + i23;
                int combineMeasuredStates22 = View.combineMeasuredStates(i73, childAt6.getMeasuredState());
                if (z2) {
                }
                i24 = i23;
                int max2 = Math.max(i74, measuredHeight22);
                if (!z20) {
                }
                if (aVar.f865a <= 0.0f) {
                }
                i71 = l() + i21;
                i74 = max2;
                i73 = combineMeasuredStates22;
                z21 = z4;
                z20 = z23;
                f10 = f12;
                i70 = i19;
            }
            i71++;
            z18 = z3;
            z17 = z2;
        }
        int i79 = i70;
        if (this.f864g > 0 && o(virtualChildCount2)) {
            this.f864g += this.m;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1) {
            c3 = 3;
            if (iArr[3] == -1) {
                i4 = i73;
                if (z18 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
                    this.f864g = 0;
                    i18 = 0;
                    while (i18 < virtualChildCount2) {
                        View childAt7 = getChildAt(i18);
                        if (childAt7 == null) {
                            this.f864g = q() + this.f864g;
                        } else if (childAt7.getVisibility() == 8) {
                            i18 += l();
                        } else {
                            a aVar8 = (a) childAt7.getLayoutParams();
                            int i80 = this.f864g;
                            this.f864g = z19 ? n() + ((ViewGroup.MarginLayoutParams) aVar8).leftMargin + i72 + ((ViewGroup.MarginLayoutParams) aVar8).rightMargin + i80 : Math.max(i80, n() + i80 + i72 + ((ViewGroup.MarginLayoutParams) aVar8).leftMargin + ((ViewGroup.MarginLayoutParams) aVar8).rightMargin);
                        }
                        i18++;
                    }
                }
                int paddingRight = getPaddingRight() + getPaddingLeft() + this.f864g;
                this.f864g = paddingRight;
                int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, 0);
                i5 = (16777215 & resolveSizeAndState2) - this.f864g;
                if (!z21 || (i5 != 0 && f10 > 0.0f)) {
                    f2 = this.h;
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
                    this.f864g = 0;
                    int i81 = i5;
                    i7 = i4;
                    int i82 = -1;
                    i10 = 0;
                    while (i10 < virtualChildCount2) {
                        View childAt8 = getChildAt(i10);
                        if (childAt8 == null || childAt8.getVisibility() == 8) {
                            i12 = i81;
                            i11 = virtualChildCount2;
                        } else {
                            a aVar9 = (a) childAt8.getLayoutParams();
                            float f13 = aVar9.f865a;
                            if (f13 > 0.0f) {
                                i11 = virtualChildCount2;
                                int i83 = (int) ((((float) i81) * f13) / f10);
                                float f14 = f10 - f13;
                                int i84 = i81 - i83;
                                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) aVar9).topMargin + ((ViewGroup.MarginLayoutParams) aVar9).bottomMargin, ((ViewGroup.MarginLayoutParams) aVar9).height);
                                if (((ViewGroup.MarginLayoutParams) aVar9).width != 0 || mode3 != 1073741824) {
                                    i17 = childAt8.getMeasuredWidth() + i83;
                                } else if (i83 > 0) {
                                    i17 = i83;
                                    childAt8.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), childMeasureSpec2);
                                    i7 = View.combineMeasuredStates(i7, childAt8.getMeasuredState() & -16777216);
                                    f10 = f14;
                                    i13 = i84;
                                }
                                i17 = 0;
                                childAt8.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), childMeasureSpec2);
                                i7 = View.combineMeasuredStates(i7, childAt8.getMeasuredState() & -16777216);
                                f10 = f14;
                                i13 = i84;
                            } else {
                                i13 = i81;
                                i11 = virtualChildCount2;
                            }
                            if (z19) {
                                f3 = f10;
                                i15 = n() + childAt8.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) aVar9).leftMargin + ((ViewGroup.MarginLayoutParams) aVar9).rightMargin + this.f864g;
                                i14 = i13;
                            } else {
                                f3 = f10;
                                int i85 = this.f864g;
                                i14 = i13;
                                i15 = Math.max(i85, n() + childAt8.getMeasuredWidth() + i85 + ((ViewGroup.MarginLayoutParams) aVar9).leftMargin + ((ViewGroup.MarginLayoutParams) aVar9).rightMargin);
                            }
                            this.f864g = i15;
                            boolean z24 = mode4 != 1073741824 && ((ViewGroup.MarginLayoutParams) aVar9).height == -1;
                            int i86 = ((ViewGroup.MarginLayoutParams) aVar9).topMargin + ((ViewGroup.MarginLayoutParams) aVar9).bottomMargin;
                            int measuredHeight3 = childAt8.getMeasuredHeight() + i86;
                            i82 = Math.max(i82, measuredHeight3);
                            if (!z24) {
                                i86 = measuredHeight3;
                            }
                            i79 = Math.max(i79, i86);
                            if (z20) {
                                i16 = -1;
                                if (((ViewGroup.MarginLayoutParams) aVar9).height == -1) {
                                    z = true;
                                    if (!z17 && (baseline = childAt8.getBaseline()) != i16) {
                                        int i87 = aVar9.f866b;
                                        if (i87 < 0) {
                                            i87 = this.f863f;
                                        }
                                        int i88 = (((i87 & 112) >> 4) & -2) >> 1;
                                        iArr[i88] = Math.max(iArr[i88], baseline);
                                        iArr2[i88] = Math.max(iArr2[i88], measuredHeight3 - baseline);
                                    }
                                    z20 = z;
                                    i12 = i14;
                                    f10 = f3;
                                }
                            } else {
                                i16 = -1;
                            }
                            z = false;
                            if (!z17) {
                            }
                            z20 = z;
                            i12 = i14;
                            f10 = f3;
                        }
                        i10++;
                        i81 = i12;
                        virtualChildCount2 = i11;
                    }
                    i8 = i3;
                    i6 = virtualChildCount2;
                    this.f864g = getPaddingRight() + getPaddingLeft() + this.f864g;
                    if (iArr[1] != -1 && iArr[0] == -1 && iArr[2] == -1) {
                        c2 = 3;
                        if (iArr[3] == -1) {
                            i74 = i82;
                        }
                    } else {
                        c2 = 3;
                    }
                    i9 = 0;
                    i74 = Math.max(i82, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
                    if (z20 || mode4 == 1073741824) {
                        i79 = i74;
                    }
                    setMeasuredDimension((-16777216 & i7) | resolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i79, getSuggestedMinimumHeight()), i8, i7 << 16));
                    if (z22) {
                        int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                        for (int i89 = i9; i89 < i6; i89++) {
                            View childAt9 = getChildAt(i89);
                            if (childAt9.getVisibility() != 8) {
                                a aVar10 = (a) childAt9.getLayoutParams();
                                if (((ViewGroup.MarginLayoutParams) aVar10).height == -1) {
                                    int i90 = ((ViewGroup.MarginLayoutParams) aVar10).width;
                                    ((ViewGroup.MarginLayoutParams) aVar10).width = childAt9.getMeasuredWidth();
                                    measureChildWithMargins(childAt9, i2, 0, makeMeasureSpec3, 0);
                                    ((ViewGroup.MarginLayoutParams) aVar10).width = i90;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                i79 = Math.max(i79, i69);
                if (z18 && mode3 != 1073741824) {
                    for (int i91 = 0; i91 < virtualChildCount2; i91++) {
                        View childAt10 = getChildAt(i91);
                        if (!(childAt10 == null || childAt10.getVisibility() == 8 || ((a) childAt10.getLayoutParams()).f865a <= 0.0f)) {
                            childAt10.measure(View.MeasureSpec.makeMeasureSpec(i72, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt10.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
                i8 = i3;
                i6 = virtualChildCount2;
                i7 = i4;
                i9 = 0;
                i79 = i74;
                setMeasuredDimension((-16777216 & i7) | resolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i79, getSuggestedMinimumHeight()), i8, i7 << 16));
                if (z22) {
                }
            }
        } else {
            c3 = 3;
        }
        i4 = i73;
        i74 = Math.max(i74, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        this.f864g = 0;
        i18 = 0;
        while (i18 < virtualChildCount2) {
        }
        int paddingRight2 = getPaddingRight() + getPaddingLeft() + this.f864g;
        this.f864g = paddingRight2;
        int resolveSizeAndState22 = View.resolveSizeAndState(Math.max(paddingRight2, getSuggestedMinimumWidth()), i2, 0);
        i5 = (16777215 & resolveSizeAndState22) - this.f864g;
        if (!z21) {
        }
        f2 = this.h;
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
        this.f864g = 0;
        int i812 = i5;
        i7 = i4;
        int i822 = -1;
        i10 = 0;
        while (i10 < virtualChildCount2) {
        }
        i8 = i3;
        i6 = virtualChildCount2;
        this.f864g = getPaddingRight() + getPaddingLeft() + this.f864g;
        if (iArr[1] != -1) {
        }
        c2 = 3;
        i9 = 0;
        i74 = Math.max(i822, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        i79 = i74;
        setMeasuredDimension((-16777216 & i7) | resolveSizeAndState22, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i79, getSuggestedMinimumHeight()), i8, i7 << 16));
        if (z22) {
        }
    }

    public void p(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public int q() {
        return 0;
    }

    public void setBaselineAligned(boolean z) {
        this.f859b = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            StringBuilder h2 = c.a.a.a.a.h("base aligned child index out of range (0, ");
            h2.append(getChildCount());
            h2.append(")");
            throw new IllegalArgumentException(h2.toString());
        }
        this.f860c = i2;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.l) {
            this.l = drawable;
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
        if (this.f863f != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f863f = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f863f;
        if ((8388615 & i4) != i3) {
            this.f863f = i3 | (-8388616 & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.i = z;
    }

    public void setOrientation(int i2) {
        if (this.f862e != i2) {
            this.f862e = i2;
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
        int i4 = this.f863f;
        if ((i4 & 112) != i3) {
            this.f863f = i3 | (i4 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.h = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
