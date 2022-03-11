package e.a0.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class b extends ViewGroup {
    public static final int[] C = {16842931};
    public static final Comparator<c> D = new a();
    public static final h E = new h();
    public List<e> A;
    public int B;
    public int b;
    public Parcelable c;

    /* renamed from: d  reason: collision with root package name */
    public ClassLoader f643d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f644e;

    /* renamed from: f  reason: collision with root package name */
    public int f645f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f646g;

    /* renamed from: h  reason: collision with root package name */
    public int f647h;

    /* renamed from: i  reason: collision with root package name */
    public int f648i;

    /* renamed from: j  reason: collision with root package name */
    public int f649j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f650k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f651l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;
    public float q;
    public float r;
    public float s;
    public float t;
    public int u;
    public VelocityTracker v;
    public boolean w;
    public int x;
    public List<f> y;
    public f z;

    public static class a implements Comparator<c> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            Objects.requireNonNull(cVar);
            Objects.requireNonNull(cVar2);
            return 0;
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: e.a0.a.b$b  reason: collision with other inner class name */
    public @interface AbstractC0012b {
    }

    public static class c {
    }

    public static class d extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        public boolean c;

        public d() {
            super(-1, -1);
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.C);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public interface e {
        void a(b bVar, a aVar, a aVar2);
    }

    public interface f {
        void a(int i2);
    }

    public static class g extends e.k.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public int f652d;

        /* renamed from: e  reason: collision with root package name */
        public Parcelable f653e;

        /* renamed from: f  reason: collision with root package name */
        public ClassLoader f654f;

        public static class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new g[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? g.class.getClassLoader() : classLoader;
            this.f652d = parcel.readInt();
            this.f653e = parcel.readParcelable(classLoader);
            this.f654f = classLoader;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("FragmentPager.SavedState{");
            h2.append(Integer.toHexString(System.identityHashCode(this)));
            h2.append(" position=");
            h2.append(this.f652d);
            h2.append("}");
            return h2.toString();
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f652d);
            parcel.writeParcelable(this.f653e, i2);
        }
    }

    public static class h implements Comparator<View> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            boolean z = ((d) view.getLayoutParams()).a;
            if (z != ((d) view2.getLayoutParams()).a) {
                return z ? 1 : -1;
            }
            return 0;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.f651l != z2) {
            this.f651l = z2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        if (r1 <= r3) goto L_0x00ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    public boolean a(int i2) {
        View findNextFocus;
        boolean z2;
        boolean z3;
        View findFocus = findFocus();
        boolean z4 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z3 = false;
                        break;
                    } else if (parent == this) {
                        z3 = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    StringBuilder h2 = f.a.a.a.a.h("arrowScroll tried to find focus based on non-child current focused view ");
                    h2.append(sb.toString());
                    Log.e("ViewPager", h2.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i2 == 17) {
                    int i3 = c(null, findNextFocus).left;
                    int i4 = c(null, findFocus).left;
                    if (findFocus != null && i3 >= i4) {
                        z2 = e();
                        z4 = z2;
                    }
                } else if (i2 == 66) {
                    int i5 = c(null, findNextFocus).left;
                    int i6 = c(null, findFocus).left;
                    if (findFocus != null) {
                    }
                }
                z2 = findNextFocus.requestFocus();
                z4 = z2;
            } else if (i2 == 17 || i2 == 1) {
                z4 = e();
            }
            if (z4) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
            }
            return z4;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        if (findNextFocus == null) {
        }
        z4 = e();
        if (z4) {
        }
        return z4;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4).getVisibility() == 0) {
                    throw null;
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addTouchables(ArrayList<View> arrayList) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                throw null;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        d dVar = (d) layoutParams;
        boolean z2 = dVar.a | (view.getClass().getAnnotation(AbstractC0012b.class) != null);
        dVar.a = z2;
        if (!this.f650k) {
            super.addView(view, i2, layoutParams);
        } else if (!z2) {
            dVar.c = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public boolean b(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && b(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && view.canScrollHorizontally(-i2);
    }

    public final Rect c(Rect rect, View view) {
        Rect rect2 = new Rect();
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left = viewGroup.getLeft() + rect2.left;
            rect2.right = viewGroup.getRight() + rect2.right;
            rect2.top = viewGroup.getTop() + rect2.top;
            rect2.bottom = viewGroup.getBottom() + rect2.bottom;
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    public boolean canScrollHorizontally(int i2) {
        return false;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.f644e = true;
        throw null;
    }

    public final void d(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.u) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.q = motionEvent.getX(i2);
            this.u = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.v;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z2;
        int i2;
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 21) {
                    if (keyCode != 22) {
                        if (keyCode == 61) {
                            if (keyEvent.hasNoModifiers()) {
                                z2 = a(2);
                            } else if (keyEvent.hasModifiers(1)) {
                                z2 = a(1);
                            }
                            return !z2;
                        }
                    } else if (!keyEvent.hasModifiers(2)) {
                        i2 = 66;
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    z2 = e();
                    if (!z2) {
                    }
                } else {
                    i2 = 17;
                }
                z2 = a(i2);
                if (!z2) {
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                throw null;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getOverScrollMode() != 0) {
            throw null;
        }
        throw null;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f646g;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public boolean e() {
        return false;
    }

    public void f() {
    }

    public final void g(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return null;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        throw null;
    }

    public int getCurrentItem() {
        return 0;
    }

    public int getOffscreenPageLimit() {
        return this.m;
    }

    public int getPageMargin() {
        return this.f645f;
    }

    public final boolean h() {
        this.u = -1;
        this.n = false;
        this.o = false;
        VelocityTracker velocityTracker = this.v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.v = null;
        }
        throw null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.w = true;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(null);
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f645f > 0 && this.f646g != null) {
            throw null;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            h();
            throw null;
        }
        if (action != 0) {
            if (this.n) {
                return true;
            }
            if (this.o) {
                return false;
            }
        }
        if (action != 0) {
            if (action == 2) {
                int i2 = this.u;
                if (i2 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.q;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.t);
                    int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i3 != 0) {
                        float f3 = this.q;
                        if (!((f3 < ((float) this.p) && i3 > 0) || (f3 > ((float) (getWidth() - this.p)) && f2 < 0.0f)) && b(this, false, (int) f2, (int) x2, (int) y2)) {
                            this.q = x2;
                            this.r = y2;
                            this.o = true;
                            return false;
                        }
                    }
                    float f4 = (float) 0;
                    if (abs > f4 && abs * 0.5f > abs2) {
                        this.n = true;
                        g(true);
                        setScrollState(1);
                        float f5 = this.s;
                        this.q = i3 > 0 ? f5 + f4 : f5 - f4;
                        this.r = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > f4) {
                        this.o = true;
                    }
                    if (this.n) {
                        this.q = x2;
                        getScrollX();
                        getClientWidth();
                        throw null;
                    }
                }
            } else if (action == 6) {
                d(motionEvent);
            }
            if (this.v == null) {
                this.v = VelocityTracker.obtain();
            }
            this.v.addMovement(motionEvent);
            return this.n;
        }
        float x3 = motionEvent.getX();
        this.s = x3;
        this.q = x3;
        float y3 = motionEvent.getY();
        this.t = y3;
        this.r = y3;
        this.u = motionEvent.getPointerId(0);
        this.o = false;
        this.f644e = true;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int childCount = getChildCount();
        int i10 = i4 - i2;
        int i11 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a) {
                    int i14 = dVar.b;
                    int i15 = i14 & 7;
                    int i16 = i14 & 112;
                    if (i15 != 1) {
                        if (i15 == 3) {
                            i6 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i15 != 5) {
                            i6 = paddingLeft;
                        } else {
                            i9 = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i16 == 16) {
                            if (i16 == 48) {
                                i7 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i16 != 80) {
                                i7 = paddingTop;
                            } else {
                                i8 = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i17 = paddingLeft + scrollX;
                            childAt.layout(i17, paddingTop, childAt.getMeasuredWidth() + i17, childAt.getMeasuredHeight() + paddingTop);
                            i12++;
                            paddingTop = i7;
                            paddingLeft = i6;
                        } else {
                            i8 = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        i7 = paddingTop;
                        paddingTop = i8;
                        int i172 = paddingLeft + scrollX;
                        childAt.layout(i172, paddingTop, childAt.getMeasuredWidth() + i172, childAt.getMeasuredHeight() + paddingTop);
                        i12++;
                        paddingTop = i7;
                        paddingLeft = i6;
                    } else {
                        i9 = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    i6 = paddingLeft;
                    paddingLeft = i9;
                    if (i16 == 16) {
                    }
                    i7 = paddingTop;
                    paddingTop = i8;
                    int i1722 = paddingLeft + scrollX;
                    childAt.layout(i1722, paddingTop, childAt.getMeasuredWidth() + i1722, childAt.getMeasuredHeight() + paddingTop);
                    i12++;
                    paddingTop = i7;
                    paddingLeft = i6;
                }
            }
        }
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8 && !((d) childAt2.getLayoutParams()).a) {
                throw null;
            }
        }
        this.f647h = paddingTop;
        this.f648i = i11 - paddingBottom;
        this.x = i12;
        if (!this.w) {
            this.w = false;
            return;
        }
        throw null;
    }

    public void onMeasure(int i2, int i3) {
        d dVar;
        d dVar2;
        int i4;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.p = Math.min(measuredWidth / 10, 0);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            int i6 = 1073741824;
            boolean z2 = true;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (!(childAt.getVisibility() == 8 || (dVar2 = (d) childAt.getLayoutParams()) == null || !dVar2.a)) {
                int i7 = dVar2.b;
                int i8 = i7 & 7;
                int i9 = i7 & 112;
                boolean z3 = i9 == 48 || i9 == 80;
                if (!(i8 == 3 || i8 == 5)) {
                    z2 = false;
                }
                int i10 = Integer.MIN_VALUE;
                if (z3) {
                    i4 = 1073741824;
                } else {
                    if (z2) {
                        i10 = 1073741824;
                    }
                    i4 = Integer.MIN_VALUE;
                }
                int i11 = ((ViewGroup.LayoutParams) dVar2).width;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = paddingLeft;
                    }
                    i4 = 1073741824;
                } else {
                    i11 = paddingLeft;
                }
                int i12 = ((ViewGroup.LayoutParams) dVar2).height;
                if (i12 == -2) {
                    i12 = measuredHeight;
                    i6 = i10;
                } else if (i12 == -1) {
                    i12 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i4), View.MeasureSpec.makeMeasureSpec(i12, i6));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i5++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f649j = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f650k = true;
        f();
        this.f650k = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((dVar = (d) childAt2.getLayoutParams()) == null || !dVar.a)) {
                Objects.requireNonNull(dVar);
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * 0.0f), 1073741824), this.f649j);
            }
        }
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 1;
            i3 = 0;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            if (getChildAt(i3).getVisibility() != 0) {
                i3 += i4;
            } else {
                throw null;
            }
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.b);
        this.b = gVar.f652d;
        this.c = gVar.f653e;
        this.f643d = gVar.f654f;
    }

    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        gVar.f652d = 0;
        return gVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4) {
            return;
        }
        if (i4 > 0) {
            throw null;
        }
        throw null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        motionEvent.getEdgeFlags();
        return false;
    }

    public void removeView(View view) {
        if (this.f650k) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(a aVar) {
        List<e> list = this.A;
        if (!(list == null || list.isEmpty())) {
            int size = this.A.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.A.get(i2).a(this, null, aVar);
            }
        }
    }

    public void setCurrentItem(int i2) {
        setScrollingCacheEnabled(false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to " + 1);
            i2 = 1;
        }
        if (i2 != this.m) {
            this.m = i2;
            f();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.z = fVar;
    }

    public void setPageMargin(int i2) {
        this.f645f = i2;
        if (getWidth() > 0) {
            throw null;
        }
        throw null;
    }

    public void setPageMarginDrawable(int i2) {
        Context context = getContext();
        Object obj = e.i.b.a.a;
        setPageMarginDrawable(context.getDrawable(i2));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f646g = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.B != i2) {
            this.B = i2;
            f fVar = this.z;
            if (fVar != null) {
                fVar.a(i2);
            }
            List<f> list = this.y;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    f fVar2 = this.y.get(i3);
                    if (fVar2 != null) {
                        fVar2.a(i2);
                    }
                }
            }
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f646g;
    }
}
