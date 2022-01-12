package androidx.appcompat.widget;

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
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;

public class LinearLayoutCompat extends ViewGroup {
    public boolean mBaselineAligned;
    public int mBaselineAlignedChildIndex;
    public int mBaselineChildTop;
    public Drawable mDivider;
    public int mDividerHeight;
    public int mDividerPadding;
    public int mDividerWidth;
    public int mGravity;
    public int[] mMaxAscent;
    public int[] mMaxDescent;
    public int mOrientation;
    public int mShowDividers;
    public int mTotalLength;
    public boolean mUseLargestChild;
    public float mWeightSum;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i3 = this.mBaselineChildTop;
                if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
                    if (i == 16) {
                        i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    } else if (i == 80) {
                        i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                }
                return i3 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
            } else if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount() {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset() {
        return 0;
    }

    public int getNextLocationOffset() {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    public int measureNullChild() {
        return 0;
    }

    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.mDivider != null) {
            int i6 = 0;
            if (this.mOrientation == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i6 < virtualChildCount) {
                    View childAt = getChildAt(i6);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i6))) {
                        drawHorizontalDivider(canvas, (childAt.getTop() - ((ViewGroup.MarginLayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin) - this.mDividerHeight);
                    }
                    i6++;
                }
                if (hasDividerBeforeChildAt(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        i5 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
                    } else {
                        i5 = childAt2.getBottom() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) childAt2.getLayoutParams())).bottomMargin;
                    }
                    drawHorizontalDivider(canvas, i5);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            while (i6 < virtualChildCount2) {
                View childAt3 = getChildAt(i6);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !hasDividerBeforeChildAt(i6))) {
                    LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (isLayoutRtl) {
                        i4 = childAt3.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else {
                        i4 = (childAt3.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerWidth;
                    }
                    drawVerticalDivider(canvas, i4);
                }
                i6++;
            }
            if (hasDividerBeforeChildAt(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 != null) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                    if (isLayoutRtl) {
                        i3 = childAt4.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                        i2 = this.mDividerWidth;
                    } else {
                        i = childAt4.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        drawVerticalDivider(canvas, i);
                    }
                } else if (isLayoutRtl) {
                    i = getPaddingLeft();
                    drawVerticalDivider(canvas, i);
                } else {
                    i3 = getWidth() - getPaddingRight();
                    i2 = this.mDividerWidth;
                }
                i = i3 - i2;
                drawVerticalDivider(canvas, i);
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
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
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
        int i18;
        int i19;
        int i20 = 8;
        int i21 = 5;
        if (this.mOrientation == 1) {
            int paddingLeft = getPaddingLeft();
            int i22 = i3 - i;
            int paddingRight = i22 - getPaddingRight();
            int paddingRight2 = (i22 - paddingLeft) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i23 = this.mGravity;
            int i24 = i23 & 112;
            int i25 = 8388615 & i23;
            if (i24 == 16) {
                i15 = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
            } else if (i24 != 80) {
                i15 = getPaddingTop();
            } else {
                i15 = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
            }
            int i26 = 0;
            while (i26 < virtualChildCount) {
                View childAt = getChildAt(i26);
                if (childAt == null) {
                    i16 = measureNullChild() + i15;
                } else if (childAt.getVisibility() != i20) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i27 = layoutParams.gravity;
                    if (i27 < 0) {
                        i27 = i25;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i27, ViewCompat.getLayoutDirection(this)) & 7;
                    if (absoluteGravity == 1) {
                        i19 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        i18 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else if (absoluteGravity != i21) {
                        i17 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                        if (hasDividerBeforeChildAt(i26)) {
                            i15 += this.mDividerHeight;
                        }
                        int i28 = i15 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        int locationOffset = getLocationOffset() + i28;
                        childAt.layout(i17, locationOffset, measuredWidth + i17, measuredHeight + locationOffset);
                        i16 = getNextLocationOffset() + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i28;
                        i26 = getChildrenSkipCount() + i26;
                    } else {
                        i19 = paddingRight - measuredWidth;
                        i18 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                    i17 = i19 - i18;
                    if (hasDividerBeforeChildAt(i26)) {
                    }
                    int i282 = i15 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    int locationOffset2 = getLocationOffset() + i282;
                    childAt.layout(i17, locationOffset2, measuredWidth + i17, measuredHeight + locationOffset2);
                    i16 = getNextLocationOffset() + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i282;
                    i26 = getChildrenSkipCount() + i26;
                } else {
                    i26++;
                    i20 = 8;
                    i21 = 5;
                }
                i15 = i16;
                i26++;
                i20 = 8;
                i21 = 5;
            }
            return;
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i29 = i4 - i2;
        int paddingBottom = i29 - getPaddingBottom();
        int paddingBottom2 = (i29 - paddingTop) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i30 = this.mGravity;
        int i31 = 8388615 & i30;
        int i32 = i30 & 112;
        boolean z3 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i31, getLayoutDirection());
        if (absoluteGravity2 == 1) {
            i5 = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (absoluteGravity2 != 5) {
            i5 = getPaddingLeft();
        } else {
            i5 = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        }
        if (isLayoutRtl) {
            i6 = virtualChildCount2 - 1;
            i8 = 0;
            i7 = -1;
        } else {
            i7 = 1;
            i8 = 0;
            i6 = 0;
        }
        while (i8 < virtualChildCount2) {
            int i33 = (i7 * i8) + i6;
            View childAt2 = getChildAt(i33);
            if (childAt2 == null) {
                i5 = measureNullChild() + i5;
            } else if (childAt2.getVisibility() != 8) {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (z3) {
                    i10 = virtualChildCount2;
                    i9 = i32;
                    if (((ViewGroup.MarginLayoutParams) layoutParams2).height != -1) {
                        i11 = childAt2.getBaseline();
                        i12 = layoutParams2.gravity;
                        if (i12 < 0) {
                            i12 = i9;
                        }
                        i13 = i12 & 112;
                        z2 = z3;
                        if (i13 != 16) {
                            i14 = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        } else if (i13 == 48) {
                            i14 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + paddingTop;
                            if (i11 != -1) {
                                i14 = (iArr[1] - i11) + i14;
                            }
                        } else if (i13 != 80) {
                            i14 = paddingTop;
                        } else {
                            i14 = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                            if (i11 != -1) {
                                i14 -= iArr2[2] - (childAt2.getMeasuredHeight() - i11);
                            }
                        }
                        if (hasDividerBeforeChildAt(i33)) {
                            i5 += this.mDividerWidth;
                        }
                        int i34 = i5 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                        int locationOffset3 = getLocationOffset() + i34;
                        childAt2.layout(locationOffset3, i14, measuredWidth2 + locationOffset3, measuredHeight2 + i14);
                        i5 = i34 + getNextLocationOffset() + measuredWidth2 + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        i8 = getChildrenSkipCount() + i8;
                        i8++;
                        virtualChildCount2 = i10;
                        i32 = i9;
                        z3 = z2;
                    }
                } else {
                    i10 = virtualChildCount2;
                    i9 = i32;
                }
                i11 = -1;
                i12 = layoutParams2.gravity;
                if (i12 < 0) {
                }
                i13 = i12 & 112;
                z2 = z3;
                if (i13 != 16) {
                }
                if (hasDividerBeforeChildAt(i33)) {
                }
                int i342 = i5 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                int locationOffset32 = getLocationOffset() + i342;
                childAt2.layout(locationOffset32, i14, measuredWidth2 + locationOffset32, measuredHeight2 + i14);
                i5 = i342 + getNextLocationOffset() + measuredWidth2 + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                i8 = getChildrenSkipCount() + i8;
                i8++;
                virtualChildCount2 = i10;
                i32 = i9;
                z3 = z2;
            }
            i10 = virtualChildCount2;
            i9 = i32;
            z2 = z3;
            i8++;
            virtualChildCount2 = i10;
            i32 = i9;
            z3 = z2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04c7  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x04fc  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x050d  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0593  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x059e  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0639  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0703  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0720  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x08d6  */
    /* JADX WARNING: Removed duplicated region for block: B:428:? A[RETURN, SYNTHETIC] */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f;
        int i9;
        char c;
        int i10;
        int i11;
        int i12;
        float f2;
        int i13;
        int i14;
        boolean z;
        int baseline;
        int i15;
        int i16;
        char c2;
        boolean z2;
        boolean z3;
        int i17;
        int i18;
        int i19;
        boolean z4;
        LayoutParams layoutParams;
        int i20;
        boolean z5;
        int i21;
        int i22;
        int baseline2;
        int i23;
        float f3;
        int i24;
        int i25;
        int i26;
        int i27;
        boolean z6;
        int i28;
        int i29;
        int i30;
        boolean z7;
        int i31;
        int i32;
        int i33;
        int i34;
        LayoutParams layoutParams2;
        boolean z8;
        boolean z9;
        int i35;
        int i36;
        int i37 = this.mOrientation;
        int i38 = -2;
        int i39 = RecyclerView.UNDEFINED_DURATION;
        int i40 = 8;
        float f4 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        int i41 = 1073741824;
        boolean z10 = true;
        if (i37 == 1) {
            this.mTotalLength = 0;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i42 = this.mBaselineAlignedChildIndex;
            boolean z11 = this.mUseLargestChild;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            boolean z12 = false;
            boolean z13 = false;
            int i48 = 0;
            boolean z14 = true;
            float f5 = 0.0f;
            while (i43 < virtualChildCount) {
                View childAt = getChildAt(i43);
                if (childAt == null) {
                    this.mTotalLength = measureNullChild() + this.mTotalLength;
                } else if (childAt.getVisibility() == i40) {
                    i43 += getChildrenSkipCount();
                } else {
                    if (hasDividerBeforeChildAt(i43)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams3 = (LayoutParams) childAt.getLayoutParams();
                    float f6 = layoutParams3.weight;
                    f5 += f6;
                    if (mode2 == i41 && ((ViewGroup.MarginLayoutParams) layoutParams3).height == 0 && f6 > f4) {
                        int i49 = this.mTotalLength;
                        this.mTotalLength = Math.max(i49, ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + i49 + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin);
                        i31 = i42;
                        i30 = mode2;
                        i34 = mode;
                        i29 = virtualChildCount;
                        layoutParams2 = layoutParams3;
                        z8 = true;
                        z7 = true;
                    } else {
                        if (((ViewGroup.MarginLayoutParams) layoutParams3).height != 0 || layoutParams3.weight <= f4) {
                            i35 = i39;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).height = i38;
                            i35 = 0;
                        }
                        if (f5 == f4) {
                            i36 = this.mTotalLength;
                            i31 = i42;
                        } else {
                            i31 = i42;
                            i36 = 0;
                        }
                        i30 = mode2;
                        i34 = mode;
                        i29 = virtualChildCount;
                        layoutParams2 = layoutParams3;
                        z7 = true;
                        measureChildBeforeLayout(childAt, i, 0, i2, i36);
                        if (i35 != i39) {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).height = i35;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i50 = this.mTotalLength;
                        this.mTotalLength = Math.max(i50, getNextLocationOffset() + i50 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                        if (z11) {
                            i45 = Math.max(measuredHeight, i45);
                        }
                        z8 = z12;
                    }
                    if (i31 >= 0 && i31 == i43 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i43 >= i31 || layoutParams2.weight <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        i33 = i34;
                        if (i33 == 1073741824 || ((ViewGroup.MarginLayoutParams) layoutParams2).width != -1) {
                            z9 = false;
                        } else {
                            z9 = z7;
                            z13 = z9;
                        }
                        int i51 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        int measuredWidth = childAt.getMeasuredWidth() + i51;
                        i32 = Math.max(i47, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i48, childAt.getMeasuredState());
                        boolean z15 = (!z14 || ((ViewGroup.MarginLayoutParams) layoutParams2).width != -1) ? false : z7;
                        if (layoutParams2.weight > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            if (!z9) {
                                i51 = measuredWidth;
                            }
                            i44 = Math.max(i44, i51);
                        } else {
                            if (!z9) {
                                i51 = measuredWidth;
                            }
                            i46 = Math.max(i46, i51);
                            i44 = i44;
                        }
                        i43 += getChildrenSkipCount();
                        z12 = z8;
                        z14 = z15;
                        i48 = combineMeasuredStates;
                        i43++;
                        mode = i33;
                        i47 = i32;
                        i42 = i31;
                        z10 = z7;
                        mode2 = i30;
                        virtualChildCount = i29;
                        i38 = -2;
                        i39 = RecyclerView.UNDEFINED_DURATION;
                        i40 = 8;
                        f4 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        i41 = 1073741824;
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i31 = i42;
                i30 = mode2;
                i33 = mode;
                i29 = virtualChildCount;
                z7 = z10;
                i32 = i47;
                i43++;
                mode = i33;
                i47 = i32;
                i42 = i31;
                z10 = z7;
                mode2 = i30;
                virtualChildCount = i29;
                i38 = -2;
                i39 = RecyclerView.UNDEFINED_DURATION;
                i40 = 8;
                f4 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                i41 = 1073741824;
            }
            int i52 = i46;
            int i53 = i47;
            int i54 = i48;
            if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
                this.mTotalLength += this.mDividerHeight;
            }
            int i55 = mode2;
            if (z11 && (i55 == Integer.MIN_VALUE || i55 == 0)) {
                this.mTotalLength = 0;
                int i56 = 0;
                while (i56 < virtualChildCount) {
                    View childAt2 = getChildAt(i56);
                    if (childAt2 == null) {
                        this.mTotalLength = measureNullChild() + this.mTotalLength;
                    } else if (childAt2.getVisibility() == 8) {
                        i56 += getChildrenSkipCount();
                    } else {
                        LayoutParams layoutParams4 = (LayoutParams) childAt2.getLayoutParams();
                        int i57 = this.mTotalLength;
                        this.mTotalLength = Math.max(i57, getNextLocationOffset() + i57 + i45 + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin);
                    }
                    i56++;
                }
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
            this.mTotalLength = paddingBottom;
            int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, 0);
            int i58 = (16777215 & resolveSizeAndState) - this.mTotalLength;
            if (z12 || (i58 != 0 && f5 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                float f7 = this.mWeightSum;
                if (f7 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    f5 = f7;
                }
                this.mTotalLength = 0;
                int i59 = 0;
                while (i59 < virtualChildCount) {
                    View childAt3 = getChildAt(i59);
                    if (childAt3.getVisibility() == 8) {
                        i25 = i55;
                    } else {
                        LayoutParams layoutParams5 = (LayoutParams) childAt3.getLayoutParams();
                        float f8 = layoutParams5.weight;
                        if (f8 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            int i60 = (int) ((((float) i58) * f8) / f5);
                            f5 -= f8;
                            int i61 = i58 - i60;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams5).width);
                            if (((ViewGroup.MarginLayoutParams) layoutParams5).height == 0) {
                                i28 = 1073741824;
                                if (i55 == 1073741824) {
                                    if (i60 <= 0) {
                                        i60 = 0;
                                    }
                                    childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i60, 1073741824));
                                    i54 = View.combineMeasuredStates(i54, childAt3.getMeasuredState() & -256);
                                    i58 = i61;
                                }
                            } else {
                                i28 = 1073741824;
                            }
                            int measuredHeight2 = childAt3.getMeasuredHeight() + i60;
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i28));
                            i54 = View.combineMeasuredStates(i54, childAt3.getMeasuredState() & -256);
                            i58 = i61;
                        }
                        int i62 = ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i62;
                        i53 = Math.max(i53, measuredWidth2);
                        i25 = i55;
                        if (mode != 1073741824) {
                            i26 = i58;
                            i27 = -1;
                            if (((ViewGroup.MarginLayoutParams) layoutParams5).width == -1) {
                                z6 = z10;
                                if (!z6) {
                                    i62 = measuredWidth2;
                                }
                                i52 = Math.max(i52, i62);
                                boolean z16 = (z14 || ((ViewGroup.MarginLayoutParams) layoutParams5).width != i27) ? false : z10;
                                int i63 = this.mTotalLength;
                                this.mTotalLength = Math.max(i63, getNextLocationOffset() + childAt3.getMeasuredHeight() + i63 + ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin);
                                z14 = z16;
                                i58 = i26;
                            }
                        } else {
                            i26 = i58;
                            i27 = -1;
                        }
                        z6 = false;
                        if (!z6) {
                        }
                        i52 = Math.max(i52, i62);
                        if (z14) {
                        }
                        int i632 = this.mTotalLength;
                        this.mTotalLength = Math.max(i632, getNextLocationOffset() + childAt3.getMeasuredHeight() + i632 + ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin);
                        z14 = z16;
                        i58 = i26;
                    }
                    i59++;
                    i55 = i25;
                }
                this.mTotalLength = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
            } else {
                i52 = Math.max(i52, i44);
                if (z11 && i55 != 1073741824) {
                    for (int i64 = 0; i64 < virtualChildCount; i64++) {
                        View childAt4 = getChildAt(i64);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LayoutParams) childAt4.getLayoutParams()).weight <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i45, 1073741824));
                        }
                    }
                }
            }
            if (z14 || mode == 1073741824) {
                i52 = i53;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + i52, getSuggestedMinimumWidth()), i, i54), resolveSizeAndState);
            if (z13) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                for (int i65 = 0; i65 < virtualChildCount; i65++) {
                    View childAt5 = getChildAt(i65);
                    if (childAt5.getVisibility() != 8) {
                        LayoutParams layoutParams6 = (LayoutParams) childAt5.getLayoutParams();
                        if (((ViewGroup.MarginLayoutParams) layoutParams6).width == -1) {
                            int i66 = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
                            ((ViewGroup.MarginLayoutParams) layoutParams6).height = childAt5.getMeasuredHeight();
                            measureChildWithMargins(childAt5, makeMeasureSpec, 0, i2, 0);
                            ((ViewGroup.MarginLayoutParams) layoutParams6).height = i66;
                        }
                    }
                }
                return;
            }
            return;
        }
        this.mTotalLength = 0;
        int virtualChildCount2 = getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i);
        int mode4 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z17 = this.mBaselineAligned;
        boolean z18 = this.mUseLargestChild;
        boolean z19 = mode3 == 1073741824;
        boolean z20 = true;
        int i67 = 0;
        float f9 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        int i68 = 0;
        int i69 = 0;
        int i70 = 0;
        int i71 = 0;
        int i72 = 0;
        boolean z21 = false;
        boolean z22 = false;
        while (i69 < virtualChildCount2) {
            View childAt6 = getChildAt(i69);
            if (childAt6 == null) {
                this.mTotalLength = measureNullChild() + this.mTotalLength;
                z3 = z18;
                z2 = z17;
            } else if (childAt6.getVisibility() == 8) {
                i69 += getChildrenSkipCount();
                z2 = z17;
                i67 = i67;
                i68 = i68;
                z3 = z18;
            } else {
                if (hasDividerBeforeChildAt(i69)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams7 = (LayoutParams) childAt6.getLayoutParams();
                float f10 = layoutParams7.weight;
                float f11 = f9 + f10;
                if (mode3 == 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams7).width == 0 && f10 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    if (z19) {
                        i24 = i69;
                        this.mTotalLength = ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin + this.mTotalLength;
                    } else {
                        i24 = i69;
                        int i73 = this.mTotalLength;
                        this.mTotalLength = Math.max(i73, ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin + i73 + ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin);
                    }
                    if (z17) {
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                        childAt6.measure(makeMeasureSpec2, makeMeasureSpec2);
                        layoutParams = layoutParams7;
                        i18 = i67;
                        i17 = i68;
                        i19 = i24;
                        z3 = z18;
                        z2 = z17;
                    } else {
                        layoutParams = layoutParams7;
                        i18 = i67;
                        i17 = i68;
                        i19 = i24;
                        i20 = 1073741824;
                        z3 = z18;
                        z2 = z17;
                        z4 = true;
                        if (mode4 == i20 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                            z5 = true;
                            z22 = true;
                        } else {
                            z5 = false;
                        }
                        i21 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        int measuredHeight3 = childAt6.getMeasuredHeight() + i21;
                        int combineMeasuredStates2 = View.combineMeasuredStates(i71, childAt6.getMeasuredState());
                        if (z2 || (baseline2 = childAt6.getBaseline()) == -1) {
                            i22 = i21;
                        } else {
                            int i74 = layoutParams.gravity;
                            if (i74 < 0) {
                                i74 = this.mGravity;
                            }
                            int i75 = (((i74 & 112) >> 4) & -2) >> 1;
                            i22 = i21;
                            iArr[i75] = Math.max(iArr[i75], baseline2);
                            iArr2[i75] = Math.max(iArr2[i75], measuredHeight3 - baseline2);
                        }
                        int max = Math.max(i72, measuredHeight3);
                        boolean z23 = !z20 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1;
                        if (layoutParams.weight <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            if (z5) {
                                measuredHeight3 = i22;
                            }
                            i67 = Math.max(i18, measuredHeight3);
                        } else {
                            if (z5) {
                                measuredHeight3 = i22;
                            }
                            i17 = Math.max(i17, measuredHeight3);
                            i67 = i18;
                        }
                        i69 = getChildrenSkipCount() + i19;
                        i72 = max;
                        i71 = combineMeasuredStates2;
                        z21 = z4;
                        z20 = z23;
                        f9 = f11;
                        i68 = i17;
                    }
                } else {
                    if (((ViewGroup.MarginLayoutParams) layoutParams7).width == 0) {
                        float f12 = layoutParams7.weight;
                        f3 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        if (f12 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            ((ViewGroup.MarginLayoutParams) layoutParams7).width = -2;
                            i23 = 0;
                            i18 = i67;
                            i17 = i68;
                            i19 = i69;
                            z3 = z18;
                            z2 = z17;
                            measureChildBeforeLayout(childAt6, i, f11 != f3 ? this.mTotalLength : 0, i2, 0);
                            if (i23 == Integer.MIN_VALUE) {
                                layoutParams = layoutParams7;
                                ((ViewGroup.MarginLayoutParams) layoutParams).width = i23;
                            } else {
                                layoutParams = layoutParams7;
                            }
                            int measuredWidth3 = childAt6.getMeasuredWidth();
                            if (!z19) {
                                this.mTotalLength = getNextLocationOffset() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + measuredWidth3 + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.mTotalLength;
                            } else {
                                int i76 = this.mTotalLength;
                                this.mTotalLength = Math.max(i76, getNextLocationOffset() + i76 + measuredWidth3 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                            }
                            if (z3) {
                                i70 = Math.max(measuredWidth3, i70);
                            }
                        }
                    } else {
                        f3 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                    }
                    i23 = RecyclerView.UNDEFINED_DURATION;
                    i18 = i67;
                    i17 = i68;
                    i19 = i69;
                    z3 = z18;
                    z2 = z17;
                    measureChildBeforeLayout(childAt6, i, f11 != f3 ? this.mTotalLength : 0, i2, 0);
                    if (i23 == Integer.MIN_VALUE) {
                    }
                    int measuredWidth32 = childAt6.getMeasuredWidth();
                    if (!z19) {
                    }
                    if (z3) {
                    }
                }
                z4 = z21;
                i20 = 1073741824;
                if (mode4 == i20) {
                }
                z5 = false;
                i21 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int measuredHeight32 = childAt6.getMeasuredHeight() + i21;
                int combineMeasuredStates22 = View.combineMeasuredStates(i71, childAt6.getMeasuredState());
                if (z2) {
                }
                i22 = i21;
                int max2 = Math.max(i72, measuredHeight32);
                if (!z20) {
                }
                if (layoutParams.weight <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                }
                i69 = getChildrenSkipCount() + i19;
                i72 = max2;
                i71 = combineMeasuredStates22;
                z21 = z4;
                z20 = z23;
                f9 = f11;
                i68 = i17;
            }
            i69++;
            z18 = z3;
            z17 = z2;
        }
        int i77 = i68;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount2)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1) {
            c2 = 3;
            if (iArr[3] == -1) {
                i3 = i71;
                if (z18 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
                    this.mTotalLength = 0;
                    i16 = 0;
                    while (i16 < virtualChildCount2) {
                        View childAt7 = getChildAt(i16);
                        if (childAt7 == null) {
                            this.mTotalLength = measureNullChild() + this.mTotalLength;
                        } else if (childAt7.getVisibility() == 8) {
                            i16 += getChildrenSkipCount();
                        } else {
                            LayoutParams layoutParams8 = (LayoutParams) childAt7.getLayoutParams();
                            if (z19) {
                                this.mTotalLength = getNextLocationOffset() + ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin + i70 + ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin + this.mTotalLength;
                            } else {
                                int i78 = this.mTotalLength;
                                this.mTotalLength = Math.max(i78, getNextLocationOffset() + i78 + i70 + ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin);
                            }
                        }
                        i16++;
                    }
                }
                int paddingRight = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
                this.mTotalLength = paddingRight;
                int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, 0);
                i4 = (16777215 & resolveSizeAndState2) - this.mTotalLength;
                if (!z21 || (i4 != 0 && f9 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                    f = this.mWeightSum;
                    if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        f9 = f;
                    }
                    iArr[3] = -1;
                    iArr[2] = -1;
                    iArr[1] = -1;
                    iArr[0] = -1;
                    iArr2[3] = -1;
                    iArr2[2] = -1;
                    iArr2[1] = -1;
                    iArr2[0] = -1;
                    this.mTotalLength = 0;
                    int i79 = i4;
                    i6 = i3;
                    int i80 = -1;
                    i9 = 0;
                    while (i9 < virtualChildCount2) {
                        View childAt8 = getChildAt(i9);
                        if (childAt8 == null || childAt8.getVisibility() == 8) {
                            i11 = i79;
                            i10 = virtualChildCount2;
                        } else {
                            LayoutParams layoutParams9 = (LayoutParams) childAt8.getLayoutParams();
                            float f13 = layoutParams9.weight;
                            if (f13 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                i10 = virtualChildCount2;
                                int i81 = (int) ((((float) i79) * f13) / f9);
                                float f14 = f9 - f13;
                                int i82 = i79 - i81;
                                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams9).height);
                                if (((ViewGroup.MarginLayoutParams) layoutParams9).width == 0) {
                                    i15 = 1073741824;
                                    if (mode3 == 1073741824) {
                                        if (i81 <= 0) {
                                            i81 = 0;
                                        }
                                        childAt8.measure(View.MeasureSpec.makeMeasureSpec(i81, 1073741824), childMeasureSpec2);
                                        i6 = View.combineMeasuredStates(i6, childAt8.getMeasuredState() & -16777216);
                                        f9 = f14;
                                        i12 = i82;
                                    }
                                } else {
                                    i15 = 1073741824;
                                }
                                int measuredWidth4 = childAt8.getMeasuredWidth() + i81;
                                if (measuredWidth4 < 0) {
                                    measuredWidth4 = 0;
                                }
                                childAt8.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i15), childMeasureSpec2);
                                i6 = View.combineMeasuredStates(i6, childAt8.getMeasuredState() & -16777216);
                                f9 = f14;
                                i12 = i82;
                            } else {
                                i12 = i79;
                                i10 = virtualChildCount2;
                            }
                            if (z19) {
                                f2 = f9;
                                this.mTotalLength = getNextLocationOffset() + childAt8.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams9).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams9).rightMargin + this.mTotalLength;
                                i13 = i12;
                            } else {
                                f2 = f9;
                                int i83 = this.mTotalLength;
                                i13 = i12;
                                this.mTotalLength = Math.max(i83, getNextLocationOffset() + childAt8.getMeasuredWidth() + i83 + ((ViewGroup.MarginLayoutParams) layoutParams9).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams9).rightMargin);
                            }
                            boolean z24 = mode4 != 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams9).height == -1;
                            int i84 = ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin;
                            int measuredHeight4 = childAt8.getMeasuredHeight() + i84;
                            i80 = Math.max(i80, measuredHeight4);
                            if (!z24) {
                                i84 = measuredHeight4;
                            }
                            i77 = Math.max(i77, i84);
                            if (z20) {
                                i14 = -1;
                                if (((ViewGroup.MarginLayoutParams) layoutParams9).height == -1) {
                                    z = true;
                                    if (!z17 && (baseline = childAt8.getBaseline()) != i14) {
                                        int i85 = layoutParams9.gravity;
                                        if (i85 < 0) {
                                            i85 = this.mGravity;
                                        }
                                        int i86 = (((i85 & 112) >> 4) & -2) >> 1;
                                        iArr[i86] = Math.max(iArr[i86], baseline);
                                        iArr2[i86] = Math.max(iArr2[i86], measuredHeight4 - baseline);
                                    }
                                    z20 = z;
                                    i11 = i13;
                                    f9 = f2;
                                }
                            } else {
                                i14 = -1;
                            }
                            z = false;
                            if (!z17) {
                            }
                            z20 = z;
                            i11 = i13;
                            f9 = f2;
                        }
                        i9++;
                        i79 = i11;
                        virtualChildCount2 = i10;
                    }
                    i7 = i2;
                    i5 = virtualChildCount2;
                    this.mTotalLength = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
                    if (iArr[1] != -1 && iArr[0] == -1 && iArr[2] == -1) {
                        c = 3;
                        if (iArr[3] == -1) {
                            i72 = i80;
                        }
                    } else {
                        c = 3;
                    }
                    i8 = 0;
                    i72 = Math.max(i80, Math.max(iArr2[c], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
                    if (z20 || mode4 == 1073741824) {
                        i77 = i72;
                    }
                    setMeasuredDimension((-16777216 & i6) | resolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i77, getSuggestedMinimumHeight()), i7, i6 << 16));
                    if (z22) {
                        int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                        for (int i87 = i8; i87 < i5; i87++) {
                            View childAt9 = getChildAt(i87);
                            if (childAt9.getVisibility() != 8) {
                                LayoutParams layoutParams10 = (LayoutParams) childAt9.getLayoutParams();
                                if (((ViewGroup.MarginLayoutParams) layoutParams10).height == -1) {
                                    int i88 = ((ViewGroup.MarginLayoutParams) layoutParams10).width;
                                    ((ViewGroup.MarginLayoutParams) layoutParams10).width = childAt9.getMeasuredWidth();
                                    measureChildWithMargins(childAt9, i, 0, makeMeasureSpec3, 0);
                                    ((ViewGroup.MarginLayoutParams) layoutParams10).width = i88;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                i77 = Math.max(i77, i67);
                if (z18 && mode3 != 1073741824) {
                    for (int i89 = 0; i89 < virtualChildCount2; i89++) {
                        View childAt10 = getChildAt(i89);
                        if (!(childAt10 == null || childAt10.getVisibility() == 8 || ((LayoutParams) childAt10.getLayoutParams()).weight <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                            childAt10.measure(View.MeasureSpec.makeMeasureSpec(i70, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt10.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
                i7 = i2;
                i5 = virtualChildCount2;
                i6 = i3;
                i8 = 0;
                i77 = i72;
                setMeasuredDimension((-16777216 & i6) | resolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i77, getSuggestedMinimumHeight()), i7, i6 << 16));
                if (z22) {
                }
            }
        } else {
            c2 = 3;
        }
        i3 = i71;
        i72 = Math.max(i72, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        this.mTotalLength = 0;
        i16 = 0;
        while (i16 < virtualChildCount2) {
        }
        int paddingRight2 = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
        this.mTotalLength = paddingRight2;
        int resolveSizeAndState22 = View.resolveSizeAndState(Math.max(paddingRight2, getSuggestedMinimumWidth()), i, 0);
        i4 = (16777215 & resolveSizeAndState22) - this.mTotalLength;
        if (!z21) {
        }
        f = this.mWeightSum;
        if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
        }
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        this.mTotalLength = 0;
        int i792 = i4;
        i6 = i3;
        int i802 = -1;
        i9 = 0;
        while (i9 < virtualChildCount2) {
        }
        i7 = i2;
        i5 = virtualChildCount2;
        this.mTotalLength = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
        if (iArr[1] != -1) {
        }
        c = 3;
        i8 = 0;
        i72 = Math.max(i802, Math.max(iArr2[c], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        i77 = i72;
        setMeasuredDimension((-16777216 & i6) | resolveSizeAndState22, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i77, getSuggestedMinimumHeight()), i7, i6 << 16));
        if (z22) {
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("base aligned child index out of range (0, ");
            outline17.append(getChildCount());
            outline17.append(")");
            throw new IllegalArgumentException(outline17.toString());
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | (-8388616 & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max((float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        int resourceId;
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LinearLayoutCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.LinearLayoutCompat, attributeSet, obtainStyledAttributes, i, 0);
        int i2 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        int i4 = R$styleable.LinearLayoutCompat_divider;
        if (!obtainStyledAttributes.hasValue(i4) || (resourceId = obtainStyledAttributes.getResourceId(i4, 0)) == 0) {
            drawable = obtainStyledAttributes.getDrawable(i4);
        } else {
            drawable = AppCompatResources.getDrawable(context, resourceId);
        }
        setDividerDrawable(drawable);
        this.mShowDividers = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(R$styleable.LinearLayoutCompat_Layout_android_layout_weight, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            this.gravity = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }
    }
}
