package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import e.i.i.e;
import e.i.i.f;
import e.i.i.h;
import e.i.i.i;
import e.i.i.l;
import e.i.i.w.b;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class NestedScrollView extends FrameLayout implements h, e {
    public static final a B = new a();
    public static final int[] C = {16843130};
    public b A;
    public long b;
    public final Rect c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public OverScroller f152d = new OverScroller(getContext());

    /* renamed from: e  reason: collision with root package name */
    public EdgeEffect f153e;

    /* renamed from: f  reason: collision with root package name */
    public EdgeEffect f154f;

    /* renamed from: g  reason: collision with root package name */
    public int f155g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f156h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f157i = false;

    /* renamed from: j  reason: collision with root package name */
    public View f158j = null;

    /* renamed from: k  reason: collision with root package name */
    public boolean f159k = false;

    /* renamed from: l  reason: collision with root package name */
    public VelocityTracker f160l;
    public boolean m;
    public boolean n = true;
    public int o;
    public int p;
    public int q;
    public int r = -1;
    public final int[] s = new int[2];
    public final int[] t = new int[2];
    public int u;
    public int v;
    public c w;
    public final i x;
    public final f y;
    public float z;

    public static class a extends e.i.i.a {
        @Override // e.i.i.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
        }

        @Override // e.i.i.a
        public void d(View view, e.i.i.w.b bVar) {
            int scrollRange;
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.a.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                bVar.a.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    bVar.a(b.a.f1486g);
                    bVar.a(b.a.f1490k);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    bVar.a(b.a.f1485f);
                    bVar.a(b.a.f1491l);
                }
            }
        }

        @Override // e.i.i.a
        public boolean g(View view, int i2, Bundle bundle) {
            int min;
            if (super.g(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i2 != 4096) {
                if (i2 == 8192 || i2 == 16908344) {
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.B(0 - nestedScrollView.getScrollX(), min - nestedScrollView.getScrollY(), 250, true);
                    return true;
                } else if (i2 != 16908346) {
                    return false;
                }
            }
            min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.B(0 - nestedScrollView.getScrollX(), min - nestedScrollView.getScrollY(), 250, true);
            return true;
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public int b;

        public class a implements Parcelable.Creator<c> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public c[] newArray(int i2) {
                return new c[i2];
            }
        }

        public c(Parcel parcel) {
            super(parcel);
            this.b = parcel.readInt();
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("HorizontalScrollView.SavedState{");
            h2.append(Integer.toHexString(System.identityHashCode(this)));
            h2.append(" scrollPosition=");
            h2.append(this.b);
            h2.append("}");
            return h2.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.b);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.o = viewConfiguration.getScaledTouchSlop();
        this.p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C, 0, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.x = new i();
        this.y = new f(this);
        setNestedScrollingEnabled(true);
        l.r(this, B);
    }

    public static int c(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.z;
    }

    public static boolean s(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && s((View) parent, view2);
    }

    public final void A(View view) {
        view.getDrawingRect(this.c);
        offsetDescendantRectToMyCoords(view, this.c);
        int d2 = d(this.c);
        if (d2 != 0) {
            scrollBy(0, d2);
        }
    }

    public final void B(int i2, int i3, int i4, boolean z2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.b > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f152d;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i4);
                y(z2);
            } else {
                if (!this.f152d.isFinished()) {
                    a();
                }
                scrollBy(i2, i3);
            }
            this.b = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public boolean C(int i2, int i3) {
        return this.y.i(i2, i3);
    }

    public void D(int i2) {
        this.y.j(i2);
    }

    public final void a() {
        this.f152d.abortAnimation();
        this.y.j(1);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !t(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            f(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.c);
            offsetDescendantRectToMyCoords(findNextFocus, this.c);
            f(d(this.c));
            findNextFocus.requestFocus(i2);
        }
        if (findFocus != null && findFocus.isFocused() && (!t(findFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (!this.f152d.isFinished()) {
            this.f152d.computeScrollOffset();
            int currY = this.f152d.getCurrY();
            int i2 = currY - this.v;
            this.v = currY;
            int[] iArr = this.t;
            boolean z2 = false;
            iArr[1] = 0;
            e(0, i2, iArr, null, 1);
            int i3 = i2 - this.t[1];
            int scrollRange = getScrollRange();
            if (i3 != 0) {
                int scrollY = getScrollY();
                w(0, i3, getScrollX(), scrollY, 0, scrollRange, 0, 0);
                int scrollY2 = getScrollY() - scrollY;
                int i4 = i3 - scrollY2;
                int[] iArr2 = this.t;
                iArr2[1] = 0;
                this.y.f(0, scrollY2, 0, i4, this.s, 1, iArr2);
                i3 = i4 - this.t[1];
            }
            if (i3 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z2 = true;
                }
                if (z2) {
                    k();
                    if (i3 < 0) {
                        if (this.f153e.isFinished()) {
                            edgeEffect = this.f153e;
                        }
                    } else if (this.f154f.isFinished()) {
                        edgeEffect = this.f154f;
                    }
                    edgeEffect.onAbsorb((int) this.f152d.getCurrVelocity());
                }
                a();
            }
            if (!this.f152d.isFinished()) {
                AtomicInteger atomicInteger = l.a;
                postInvalidateOnAnimation();
                return;
            }
            this.y.j(1);
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public int d(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i3 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        int i4 = rect.bottom;
        if (i4 > i3 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i3) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
        } else if (rect.top >= scrollY || i4 >= i3) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i3 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || l(keyEvent);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.y.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.y.b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return e(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.y.e(i2, i3, i4, i5, iArr);
    }

    public void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        if (this.f153e != null) {
            int scrollY = getScrollY();
            int i3 = 0;
            if (!this.f153e.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (getClipToPadding()) {
                    width -= getPaddingRight() + getPaddingLeft();
                    i2 = getPaddingLeft() + 0;
                } else {
                    i2 = 0;
                }
                if (getClipToPadding()) {
                    height -= getPaddingBottom() + getPaddingTop();
                    min += getPaddingTop();
                }
                canvas.translate((float) i2, (float) min);
                this.f153e.setSize(width, height);
                if (this.f153e.draw(canvas)) {
                    AtomicInteger atomicInteger = l.a;
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(save);
            }
            if (!this.f154f.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (getClipToPadding()) {
                    width2 -= getPaddingRight() + getPaddingLeft();
                    i3 = 0 + getPaddingLeft();
                }
                if (getClipToPadding()) {
                    height2 -= getPaddingBottom() + getPaddingTop();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i3 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.f154f.setSize(width2, height2);
                if (this.f154f.draw(canvas)) {
                    AtomicInteger atomicInteger2 = l.a;
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public boolean e(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.y.c(i2, i3, iArr, iArr2, i4);
    }

    public final void f(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.n) {
            B(0, i2, 250, false);
        } else {
            scrollBy(0, i2);
        }
    }

    public final void g() {
        this.f159k = false;
        x();
        this.y.j(0);
        EdgeEffect edgeEffect = this.f153e;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f154f.onRelease();
        }
    }

    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.x.a();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    @Override // e.i.i.g
    public void h(View view, View view2, int i2, int i3) {
        i iVar = this.x;
        if (i3 == 1) {
            iVar.b = i2;
        } else {
            iVar.a = i2;
        }
        C(2, i3);
    }

    public boolean hasNestedScrollingParent() {
        return r(0);
    }

    @Override // e.i.i.g
    public void i(View view, int i2) {
        i iVar = this.x;
        if (i2 == 1) {
            iVar.b = 0;
        } else {
            iVar.a = 0;
        }
        this.y.j(i2);
    }

    public boolean isNestedScrollingEnabled() {
        return this.y.f1464d;
    }

    @Override // e.i.i.g
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        e(i2, i3, iArr, null, i4);
    }

    public final void k() {
        if (getOverScrollMode() == 2) {
            this.f153e = null;
            this.f154f = null;
        } else if (this.f153e == null) {
            Context context = getContext();
            this.f153e = new EdgeEffect(context);
            this.f154f = new EdgeEffect(context);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0038  */
    public boolean l(KeyEvent keyEvent) {
        boolean z2;
        Rect rect;
        int i2;
        this.c.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                z2 = true;
                if (z2) {
                    if (!isFocused() || keyEvent.getKeyCode() == 4) {
                        return false;
                    }
                    View findFocus = findFocus();
                    if (findFocus == this) {
                        findFocus = null;
                    }
                    View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
                    if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                        return false;
                    }
                    return true;
                } else if (keyEvent.getAction() != 0) {
                    return false;
                } else {
                    int keyCode = keyEvent.getKeyCode();
                    int i3 = 33;
                    if (keyCode == 19) {
                        return !keyEvent.isAltPressed() ? b(33) : q(33);
                    }
                    if (keyCode == 20) {
                        return !keyEvent.isAltPressed() ? b(130) : q(130);
                    }
                    if (keyCode != 62) {
                        return false;
                    }
                    if (!keyEvent.isShiftPressed()) {
                        i3 = 130;
                    }
                    boolean z3 = i3 == 130;
                    int height = getHeight();
                    if (z3) {
                        this.c.top = getScrollY() + height;
                        int childCount = getChildCount();
                        if (childCount > 0) {
                            View childAt2 = getChildAt(childCount - 1);
                            int paddingBottom = getPaddingBottom() + childAt2.getBottom() + ((FrameLayout.LayoutParams) childAt2.getLayoutParams()).bottomMargin;
                            rect = this.c;
                            if (rect.top + height > paddingBottom) {
                                i2 = paddingBottom - height;
                            }
                        }
                        Rect rect2 = this.c;
                        int i4 = rect2.top;
                        int i5 = height + i4;
                        rect2.bottom = i5;
                        z(i3, i4, i5);
                        return false;
                    }
                    this.c.top = getScrollY() - height;
                    rect = this.c;
                    if (rect.top < 0) {
                        i2 = 0;
                    }
                    Rect rect22 = this.c;
                    int i42 = rect22.top;
                    int i52 = height + i42;
                    rect22.bottom = i52;
                    z(i3, i42, i52);
                    return false;
                    rect.top = i2;
                    Rect rect222 = this.c;
                    int i422 = rect222.top;
                    int i522 = height + i422;
                    rect222.bottom = i522;
                    z(i3, i422, i522);
                    return false;
                }
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    @Override // e.i.i.h
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        u(i5, i6, iArr);
    }

    public void measureChild(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // e.i.i.g
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        u(i5, i6, null);
    }

    @Override // e.i.i.g
    public boolean o(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f157i = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f159k) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00eb  */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        int action = motionEvent.getAction();
        if (action == 2 && this.f159k) {
            return true;
        }
        int i2 = action & 255;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = this.r;
                    if (i3 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i3 + " in onInterceptTouchEvent");
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.f155g) > this.o && (2 & getNestedScrollAxes()) == 0) {
                                this.f159k = true;
                                this.f155g = y2;
                                if (this.f160l == null) {
                                    this.f160l = VelocityTracker.obtain();
                                }
                                this.f160l.addMovement(motionEvent);
                                this.u = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 == 6) {
                        v(motionEvent);
                    }
                }
            }
            this.f159k = false;
            this.r = -1;
            x();
            if (this.f152d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                AtomicInteger atomicInteger = l.a;
                postInvalidateOnAnimation();
            }
            this.y.j(0);
        } else {
            int y3 = (int) motionEvent.getY();
            int x2 = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y3 >= childAt.getTop() - scrollY && y3 < childAt.getBottom() - scrollY && x2 >= childAt.getLeft() && x2 < childAt.getRight()) {
                    z2 = true;
                    if (z2) {
                        this.f159k = false;
                        x();
                    } else {
                        this.f155g = y3;
                        this.r = motionEvent.getPointerId(0);
                        VelocityTracker velocityTracker = this.f160l;
                        if (velocityTracker == null) {
                            this.f160l = VelocityTracker.obtain();
                        } else {
                            velocityTracker.clear();
                        }
                        this.f160l.addMovement(motionEvent);
                        this.f152d.computeScrollOffset();
                        this.f159k = !this.f152d.isFinished();
                        C(2, 0);
                    }
                }
            }
            z2 = false;
            if (z2) {
            }
        }
        return this.f159k;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int i6 = 0;
        this.f156h = false;
        View view = this.f158j;
        if (view != null && s(view, this)) {
            A(this.f158j);
        }
        this.f158j = null;
        if (!this.f157i) {
            if (this.w != null) {
                scrollTo(getScrollX(), this.w.b);
                this.w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int c2 = c(scrollY, paddingTop, i6);
            if (c2 != scrollY) {
                scrollTo(getScrollX(), c2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f157i = true;
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.m && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        p((int) f3);
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        e(i2, i3, iArr, null, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        u(i5, 0, null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.x.a = i2;
        C(2, 0);
    }

    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        FocusFinder instance = FocusFinder.getInstance();
        View findNextFocus = rect == null ? instance.findNextFocus(this, null, i2) : instance.findNextFocusFromRect(this, rect, i2);
        if (findNextFocus != null && !(true ^ t(findNextFocus, 0, getHeight()))) {
            return findNextFocus.requestFocus(i2, rect);
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.w = cVar;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.b = getScrollY();
        return cVar;
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        b bVar = this.A;
        if (bVar != null) {
            bVar.a(this, i2, i3, i4, i5);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && t(findFocus, 0, i5)) {
            findFocus.getDrawingRect(this.c);
            offsetDescendantRectToMyCoords(findFocus, this.c);
            f(d(this.c));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.x.a = 0;
        D(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
        if (r22.f152d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0209, code lost:
        if (r22.f152d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x020b;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        EdgeEffect edgeEffect;
        if (this.f160l == null) {
            this.f160l = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.u = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float) this.u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f160l;
                velocityTracker.computeCurrentVelocity(1000, (float) this.q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.r);
                if (Math.abs(yVelocity) >= this.p) {
                    int i2 = -yVelocity;
                    float f2 = (float) i2;
                    if (!dispatchNestedPreFling(0.0f, f2)) {
                        dispatchNestedFling(0.0f, f2, true);
                        p(i2);
                    }
                }
                this.r = -1;
                g();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.r);
                if (findPointerIndex == -1) {
                    StringBuilder h2 = f.a.a.a.a.h("Invalid pointerId=");
                    h2.append(this.r);
                    h2.append(" in onTouchEvent");
                    Log.e("NestedScrollView", h2.toString());
                } else {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    int i3 = this.f155g - y2;
                    if (!this.f159k && Math.abs(i3) > this.o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f159k = true;
                        int i4 = this.o;
                        i3 = i3 > 0 ? i3 - i4 : i3 + i4;
                    }
                    int i5 = i3;
                    if (this.f159k) {
                        if (e(0, i5, this.t, this.s, 0)) {
                            i5 -= this.t[1];
                            this.u += this.s[1];
                        }
                        this.f155g = y2 - this.s[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (w(0, i5, 0, getScrollY(), 0, scrollRange, 0, 0) && !r(0)) {
                            this.f160l.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.t;
                        iArr[1] = 0;
                        this.y.f(0, scrollY2, 0, i5 - scrollY2, this.s, 0, iArr);
                        int i6 = this.f155g;
                        int[] iArr2 = this.s;
                        this.f155g = i6 - iArr2[1];
                        this.u += iArr2[1];
                        if (z2) {
                            int i7 = i5 - this.t[1];
                            k();
                            int i8 = scrollY + i7;
                            if (i8 < 0) {
                                this.f153e.onPull(((float) i7) / ((float) getHeight()), motionEvent.getX(findPointerIndex) / ((float) getWidth()));
                                if (!this.f154f.isFinished()) {
                                    edgeEffect = this.f154f;
                                }
                                EdgeEffect edgeEffect2 = this.f153e;
                                if (edgeEffect2 != null && (!edgeEffect2.isFinished() || !this.f154f.isFinished())) {
                                    AtomicInteger atomicInteger = l.a;
                                    postInvalidateOnAnimation();
                                }
                            } else {
                                if (i8 > scrollRange) {
                                    this.f154f.onPull(((float) i7) / ((float) getHeight()), 1.0f - (motionEvent.getX(findPointerIndex) / ((float) getWidth())));
                                    if (!this.f153e.isFinished()) {
                                        edgeEffect = this.f153e;
                                    }
                                }
                                EdgeEffect edgeEffect22 = this.f153e;
                                AtomicInteger atomicInteger2 = l.a;
                                postInvalidateOnAnimation();
                            }
                            edgeEffect.onRelease();
                            EdgeEffect edgeEffect222 = this.f153e;
                            AtomicInteger atomicInteger22 = l.a;
                            postInvalidateOnAnimation();
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f159k) {
                    if (getChildCount() > 0) {
                    }
                }
                this.r = -1;
                g();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f155g = (int) motionEvent.getY(actionIndex);
                this.r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                v(motionEvent);
                this.f155g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.r));
            }
            AtomicInteger atomicInteger3 = l.a;
            postInvalidateOnAnimation();
            this.r = -1;
            g();
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z3 = !this.f152d.isFinished();
            this.f159k = z3;
            if (z3 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f152d.isFinished()) {
                a();
            }
            this.f155g = (int) motionEvent.getY();
            this.r = motionEvent.getPointerId(0);
            C(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f160l;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void p(int i2) {
        if (getChildCount() > 0) {
            this.f152d.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            y(true);
        }
    }

    public boolean q(int i2) {
        int childCount;
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.c;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.c.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            Rect rect2 = this.c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.c;
        return z(i2, rect3.top, rect3.bottom);
    }

    public boolean r(int i2) {
        return this.y.g(i2) != null;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f156h) {
            A(view2);
        } else {
            this.f158j = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int d2 = d(rect);
        boolean z3 = d2 != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, d2);
            } else {
                B(0, d2, 250, false);
            }
        }
        return z3;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            x();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        this.f156h = true;
        super.requestLayout();
    }

    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int c2 = c(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int c3 = c(i3, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (c2 != getScrollX() || c3 != getScrollY()) {
                super.scrollTo(c2, c3);
            }
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.m) {
            this.m = z2;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        f fVar = this.y;
        if (fVar.f1464d) {
            View view = fVar.c;
            AtomicInteger atomicInteger = l.a;
            view.stopNestedScroll();
        }
        fVar.f1464d = z2;
    }

    public void setOnScrollChangeListener(b bVar) {
        this.A = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.n = z2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i2) {
        return this.y.i(i2, 0);
    }

    public void stopNestedScroll() {
        this.y.j(0);
    }

    public final boolean t(View view, int i2, int i3) {
        view.getDrawingRect(this.c);
        offsetDescendantRectToMyCoords(view, this.c);
        return this.c.bottom + i2 >= getScrollY() && this.c.top - i2 <= getScrollY() + i3;
    }

    public final void u(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.y.d(0, scrollY2, 0, i2 - scrollY2, null, i3, iArr);
    }

    public final void v(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f155g = (int) motionEvent.getY(i2);
            this.r = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f160l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083 A[ADDED_TO_REGION] */
    public boolean w(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i10 = i4 + i2;
        int i11 = !z6 ? 0 : i8;
        int i12 = i5 + i3;
        int i13 = !z7 ? 0 : i9;
        int i14 = -i11;
        int i15 = i11 + i6;
        int i16 = -i13;
        int i17 = i13 + i7;
        if (i10 > i15) {
            i10 = i15;
        } else if (i10 < i14) {
            i10 = i14;
        } else {
            z2 = false;
            if (i12 <= i17) {
                i12 = i17;
            } else if (i12 < i16) {
                i12 = i16;
            } else {
                z3 = false;
                if (z3 && !r(1)) {
                    this.f152d.springBack(i10, i12, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i10, i12, z2, z3);
                return !z2 || z3;
            }
            z3 = true;
            this.f152d.springBack(i10, i12, 0, 0, 0, getScrollRange());
            onOverScrolled(i10, i12, z2, z3);
            if (!z2) {
            }
        }
        z2 = true;
        if (i12 <= i17) {
        }
        z3 = true;
        this.f152d.springBack(i10, i12, 0, 0, 0, getScrollRange());
        onOverScrolled(i10, i12, z2, z3);
        if (!z2) {
        }
    }

    public final void x() {
        VelocityTracker velocityTracker = this.f160l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f160l = null;
        }
    }

    public final void y(boolean z2) {
        if (z2) {
            C(2, 1);
        } else {
            this.y.j(1);
        }
        this.v = getScrollY();
        AtomicInteger atomicInteger = l.a;
        postInvalidateOnAnimation();
    }

    public final boolean z(int i2, int i3, int i4) {
        boolean z2;
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z3 = i2 == 33;
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z4 = false;
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) focusables.get(i6);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i3 < bottom && top < i4) {
                boolean z5 = i3 < top && bottom < i4;
                if (view == null) {
                    view = view2;
                    z4 = z5;
                } else {
                    boolean z6 = (z3 && top < view.getTop()) || (!z3 && bottom > view.getBottom());
                    if (z4) {
                        if (z5) {
                            if (!z6) {
                            }
                        }
                    } else if (z5) {
                        view = view2;
                        z4 = true;
                    } else if (!z6) {
                    }
                    view = view2;
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i3 < scrollY || i4 > i5) {
            f(z3 ? i3 - scrollY : i4 - i5);
            z2 = true;
        } else {
            z2 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i2);
        }
        return z2;
    }
}
