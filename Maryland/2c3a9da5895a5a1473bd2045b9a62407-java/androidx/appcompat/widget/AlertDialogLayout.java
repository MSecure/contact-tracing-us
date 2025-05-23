package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$id;
import e.b.f.i0;
import e.i.i.m;
import java.util.concurrent.atomic.AtomicInteger;

public class AlertDialogLayout extends i0 {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static int q(View view) {
        AtomicInteger atomicInteger = m.a;
        int minimumHeight = view.getMinimumHeight();
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return q(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    @Override // e.b.f.i0
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i4 - i2;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i9 = gravity & 112;
        int i10 = gravity & 8388615;
        int paddingTop = i9 != 16 ? i9 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - measuredHeight : (((i5 - i3) - measuredHeight) / 2) + getPaddingTop();
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                i0.a aVar = (i0.a) childAt.getLayoutParams();
                int i12 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i12 < 0) {
                    i12 = i10;
                }
                AtomicInteger atomicInteger = m.a;
                int absoluteGravity = Gravity.getAbsoluteGravity(i12, getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    i7 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                } else if (absoluteGravity != 5) {
                    i6 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    if (n(i11)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i13 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    childAt.layout(i6, i13, measuredWidth + i6, measuredHeight2 + i13);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + i13;
                } else {
                    i7 = paddingRight - measuredWidth;
                }
                i6 = i7 - ((LinearLayout.LayoutParams) aVar).rightMargin;
                if (n(i11)) {
                }
                int i132 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                childAt.layout(i6, i132, measuredWidth + i6, measuredHeight2 + i132);
                paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + i132;
            }
        }
    }

    @Override // e.b.f.i0
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int childCount = getChildCount();
        View view = null;
        boolean z = false;
        View view2 = null;
        View view3 = null;
        int i8 = 0;
        while (true) {
            if (i8 < childCount) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    int id = childAt.getId();
                    if (id == R$id.topPanel) {
                        view = childAt;
                    } else if (id == R$id.buttonPanel) {
                        view2 = childAt;
                    } else if ((id == R$id.contentPanel || id == R$id.customPanel) && view3 == null) {
                        view3 = childAt;
                    }
                }
                i8++;
            } else {
                int mode = View.MeasureSpec.getMode(i3);
                int size = View.MeasureSpec.getSize(i3);
                int mode2 = View.MeasureSpec.getMode(i2);
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                if (view != null) {
                    view.measure(i2, 0);
                    paddingBottom += view.getMeasuredHeight();
                    i4 = View.combineMeasuredStates(0, view.getMeasuredState());
                } else {
                    i4 = 0;
                }
                if (view2 != null) {
                    view2.measure(i2, 0);
                    i6 = q(view2);
                    i5 = view2.getMeasuredHeight() - i6;
                    paddingBottom += i6;
                    i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
                } else {
                    i6 = 0;
                    i5 = 0;
                }
                if (view3 != null) {
                    view3.measure(i2, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode));
                    i7 = view3.getMeasuredHeight();
                    paddingBottom += i7;
                    i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
                } else {
                    i7 = 0;
                }
                int i9 = size - paddingBottom;
                if (view2 != null) {
                    int i10 = paddingBottom - i6;
                    int min = Math.min(i9, i5);
                    if (min > 0) {
                        i9 -= min;
                        i6 += min;
                    }
                    view2.measure(i2, View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
                    paddingBottom = i10 + view2.getMeasuredHeight();
                    i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
                }
                if (view3 != null && i9 > 0) {
                    view3.measure(i2, View.MeasureSpec.makeMeasureSpec(i7 + i9, mode));
                    paddingBottom = (paddingBottom - i7) + view3.getMeasuredHeight();
                    i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
                }
                int i11 = 0;
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt2 = getChildAt(i12);
                    if (childAt2.getVisibility() != 8) {
                        i11 = Math.max(i11, childAt2.getMeasuredWidth());
                    }
                }
                setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i11, i2, i4), View.resolveSizeAndState(paddingBottom, i3, 0));
                if (mode2 != 1073741824) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    for (int i13 = 0; i13 < childCount; i13++) {
                        View childAt3 = getChildAt(i13);
                        if (childAt3.getVisibility() != 8) {
                            i0.a aVar = (i0.a) childAt3.getLayoutParams();
                            if (((LinearLayout.LayoutParams) aVar).width == -1) {
                                int i14 = ((LinearLayout.LayoutParams) aVar).height;
                                ((LinearLayout.LayoutParams) aVar).height = childAt3.getMeasuredHeight();
                                measureChildWithMargins(childAt3, makeMeasureSpec, 0, i3, 0);
                                ((LinearLayout.LayoutParams) aVar).height = i14;
                            }
                        }
                    }
                }
                z = true;
            }
        }
        if (!z) {
            super.onMeasure(i2, i3);
        }
    }
}
