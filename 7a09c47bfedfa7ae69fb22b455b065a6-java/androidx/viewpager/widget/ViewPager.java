package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import b.i.l.m;
import com.google.android.gms.nearby.messages.BleSignal;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    public static final int[] b0 = {16842931};
    public static final Comparator<e> c0 = new a();
    public static final Interpolator d0 = new b();
    public static final l e0 = new l();
    public int A;
    public int B;
    public int C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H = -1;
    public VelocityTracker I;
    public int J;
    public int K;
    public int L;
    public int M;
    public EdgeEffect N;
    public EdgeEffect O;
    public boolean P = true;
    public boolean Q;
    public int R;
    public List<i> S;
    public i T;
    public List<h> U;
    public ArrayList<View> V;
    public final Runnable W = new c();
    public int a0 = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f414b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<e> f415c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final e f416d = new e();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f417e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public b.a0.a.a f418f;

    /* renamed from: g  reason: collision with root package name */
    public int f419g;
    public int h = -1;
    public Parcelable i = null;
    public ClassLoader j = null;
    public Scroller k;
    public boolean l;
    public j m;
    public int n;
    public Drawable o;
    public int p;
    public int q;
    public float r = -3.4028235E38f;
    public float s = Float.MAX_VALUE;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x = 1;
    public boolean y;
    public boolean z;

    public static class a implements Comparator<e> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(e eVar, e eVar2) {
            return eVar.f422b - eVar2.f422b;
        }
    }

    public static class b implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager viewPager = ViewPager.this;
            viewPager.q(viewPager.f419g);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public Object f421a;

        /* renamed from: b  reason: collision with root package name */
        public int f422b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f423c;

        /* renamed from: d  reason: collision with root package name */
        public float f424d;

        /* renamed from: e  reason: collision with root package name */
        public float f425e;
    }

    public static class f extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f426a;

        /* renamed from: b  reason: collision with root package name */
        public int f427b;

        /* renamed from: c  reason: collision with root package name */
        public float f428c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public boolean f429d;

        /* renamed from: e  reason: collision with root package name */
        public int f430e;

        /* renamed from: f  reason: collision with root package name */
        public int f431f;

        public f() {
            super(-1, -1);
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.b0);
            this.f427b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public class g extends b.i.l.a {
        public g() {
        }

        @Override // b.i.l.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            b.a0.a.a aVar;
            this.f1847a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            b.a0.a.a aVar2 = ViewPager.this.f418f;
            boolean z = true;
            if (aVar2 == null || aVar2.getCount() <= 1) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (accessibilityEvent.getEventType() == 4096 && (aVar = ViewPager.this.f418f) != null) {
                accessibilityEvent.setItemCount(aVar.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.f419g);
                accessibilityEvent.setToIndex(ViewPager.this.f419g);
            }
        }

        @Override // b.i.l.a
        public void d(View view, b.i.l.w.b bVar) {
            this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
            bVar.f1906a.setClassName(ViewPager.class.getName());
            b.a0.a.a aVar = ViewPager.this.f418f;
            bVar.f1906a.setScrollable(aVar != null && aVar.getCount() > 1);
            if (ViewPager.this.canScrollHorizontally(1)) {
                bVar.f1906a.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                bVar.f1906a.addAction(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            }
        }

        @Override // b.i.l.a
        public boolean g(View view, int i, Bundle bundle) {
            ViewPager viewPager;
            int i2;
            if (super.g(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i2 = viewPager.f419g - 1;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                viewPager = ViewPager.this;
                i2 = viewPager.f419g + 1;
            }
            viewPager.setCurrentItem(i2);
            return true;
        }
    }

    public interface h {
        void a(ViewPager viewPager, b.a0.a.a aVar, b.a0.a.a aVar2);
    }

    public interface i {
        void a(int i, float f2, int i2);

        void b(int i);

        void c(int i);
    }

    public class j extends DataSetObserver {
        public j() {
        }

        public void onChanged() {
            ViewPager.this.e();
        }

        public void onInvalidated() {
            ViewPager.this.e();
        }
    }

    public static class k extends b.k.a.a {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public int f434d;

        /* renamed from: e  reason: collision with root package name */
        public Parcelable f435e;

        /* renamed from: f  reason: collision with root package name */
        public ClassLoader f436f;

        public static class a implements Parcelable.ClassLoaderCreator<k> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new k(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new k[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public k createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new k(parcel, classLoader);
            }
        }

        public k(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? k.class.getClassLoader() : classLoader;
            this.f434d = parcel.readInt();
            this.f435e = parcel.readParcelable(classLoader);
            this.f436f = classLoader;
        }

        public k(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder h = c.a.a.a.a.h("FragmentPager.SavedState{");
            h.append(Integer.toHexString(System.identityHashCode(this)));
            h.append(" position=");
            h.append(this.f434d);
            h.append("}");
            return h.toString();
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1952b, i);
            parcel.writeInt(this.f434d);
            parcel.writeParcelable(this.f435e, i);
        }
    }

    public static class l implements Comparator<View> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            f fVar = (f) view.getLayoutParams();
            f fVar2 = (f) view2.getLayoutParams();
            boolean z = fVar.f426a;
            if (z != fVar2.f426a) {
                return z ? 1 : -1;
            }
            return fVar.f430e - fVar2.f430e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.k = new Scroller(context2, d0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f2 = context2.getResources().getDisplayMetrics().density;
        this.C = viewConfiguration.getScaledPagingTouchSlop();
        this.J = (int) (400.0f * f2);
        this.K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.N = new EdgeEffect(context2);
        this.O = new EdgeEffect(context2);
        this.L = (int) (25.0f * f2);
        this.M = (int) (2.0f * f2);
        this.A = (int) (f2 * 16.0f);
        m.U(this, new g());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        m.c0(this, new b.a0.a.b(this));
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.v != z2) {
            this.v = z2;
        }
    }

    public e a(int i2, int i3) {
        e eVar = new e();
        eVar.f422b = i2;
        eVar.f421a = this.f418f.instantiateItem((ViewGroup) this, i2);
        eVar.f424d = this.f418f.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.f415c.size()) {
            this.f415c.add(eVar);
        } else {
            this.f415c.add(i3, eVar);
        }
        return eVar;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        e h2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.f422b == this.f419g) {
                    childAt.addFocusables(arrayList, i2, i3);
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
        e h2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.f422b == this.f419g) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        f fVar = (f) layoutParams;
        boolean z2 = fVar.f426a | (view.getClass().getAnnotation(d.class) != null);
        fVar.f426a = z2;
        if (!this.u) {
            super.addView(view, i2, layoutParams);
        } else if (!z2) {
            fVar.f429d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3  */
    public boolean b(int i2) {
        View findNextFocus;
        boolean n2;
        boolean z2;
        View findFocus = findFocus();
        boolean z3 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z2 = false;
                        break;
                    } else if (parent == this) {
                        z2 = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    sb.toString();
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i2 == 17) {
                    int i3 = g(this.f417e, findNextFocus).left;
                    int i4 = g(this.f417e, findFocus).left;
                    if (findFocus != null && i3 >= i4) {
                        n2 = m();
                        z3 = n2;
                    }
                } else if (i2 == 66) {
                    int i5 = g(this.f417e, findNextFocus).left;
                    int i6 = g(this.f417e, findFocus).left;
                    if (findFocus != null && i5 <= i6) {
                        n2 = n();
                        z3 = n2;
                    }
                }
                n2 = findNextFocus.requestFocus();
                z3 = n2;
            } else if (i2 != 17 || i2 == 1) {
                z3 = m();
            } else if (i2 == 66 || i2 == 2) {
                z3 = n();
            }
            if (z3) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
            }
            return z3;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        if (findNextFocus == null) {
        }
        if (i2 != 17) {
        }
        z3 = m();
        if (z3) {
        }
        return z3;
    }

    public boolean c(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && c(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && view.canScrollHorizontally(-i2);
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.f418f == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.r)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.s));
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.l = true;
        if (this.k.isFinished() || !this.k.computeScrollOffset()) {
            d(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.k.getCurrX();
        int currY = this.k.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!o(currX)) {
                this.k.abortAnimation();
                scrollTo(0, currY);
            }
        }
        m.M(this);
    }

    public final void d(boolean z2) {
        boolean z3 = this.a0 == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.k.isFinished()) {
                this.k.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.k.getCurrX();
                int currY = this.k.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        o(currX);
                    }
                }
            }
        }
        this.w = false;
        for (int i2 = 0; i2 < this.f415c.size(); i2++) {
            e eVar = this.f415c.get(i2);
            if (eVar.f423c) {
                eVar.f423c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z2) {
            m.N(this, this.W);
        } else {
            this.W.run();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
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
                                z2 = b(2);
                            } else if (keyEvent.hasModifiers(1)) {
                                z2 = b(1);
                            }
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        z2 = n();
                    } else {
                        i2 = 66;
                    }
                    if (!z2) {
                        return false;
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    z2 = m();
                    if (!z2) {
                    }
                } else {
                    i2 = 17;
                }
                z2 = b(i2);
                if (!z2) {
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        e h2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.f422b == this.f419g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        b.a0.a.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z2 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f418f) != null && aVar.getCount() > 1)) {
            if (!this.N.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) (getPaddingTop() + (-height)), this.r * ((float) width));
                this.N.setSize(height, width);
                z2 = false | this.N.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.O.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.s + 1.0f)) * ((float) width2));
                this.O.setSize(height2, width2);
                z2 |= this.O.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.N.finish();
            this.O.finish();
        }
        if (z2) {
            m.M(this);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.o;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void e() {
        int count = this.f418f.getCount();
        this.f414b = count;
        boolean z2 = this.f415c.size() < (this.x * 2) + 1 && this.f415c.size() < count;
        int i2 = this.f419g;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.f415c.size()) {
            e eVar = this.f415c.get(i3);
            int itemPosition = this.f418f.getItemPosition(eVar.f421a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f415c.remove(i3);
                    i3--;
                    if (!z3) {
                        this.f418f.startUpdate((ViewGroup) this);
                        z3 = true;
                    }
                    this.f418f.destroyItem((ViewGroup) this, eVar.f422b, eVar.f421a);
                    int i4 = this.f419g;
                    if (i4 == eVar.f422b) {
                        i2 = Math.max(0, Math.min(i4, count - 1));
                    }
                } else {
                    int i5 = eVar.f422b;
                    if (i5 != itemPosition) {
                        if (i5 == this.f419g) {
                            i2 = itemPosition;
                        }
                        eVar.f422b = itemPosition;
                    }
                }
                z2 = true;
            }
            i3++;
        }
        if (z3) {
            this.f418f.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f415c, c0);
        if (z2) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                f fVar = (f) getChildAt(i6).getLayoutParams();
                if (!fVar.f426a) {
                    fVar.f428c = 0.0f;
                }
            }
            v(i2, false, true, 0);
            requestLayout();
        }
    }

    public final void f(int i2) {
        i iVar = this.T;
        if (iVar != null) {
            iVar.c(i2);
        }
        List<i> list = this.S;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar2 = this.S.get(i3);
                if (iVar2 != null) {
                    iVar2.c(i2);
                }
            }
        }
    }

    public final Rect g(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public b.a0.a.a getAdapter() {
        return this.f418f;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        return ((f) this.V.get(i3).getLayoutParams()).f431f;
    }

    public int getCurrentItem() {
        return this.f419g;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.n;
    }

    public e h(View view) {
        for (int i2 = 0; i2 < this.f415c.size(); i2++) {
            e eVar = this.f415c.get(i2);
            if (this.f418f.isViewFromObject(view, eVar.f421a)) {
                return eVar;
            }
        }
        return null;
    }

    public final e i() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f3 = clientWidth > 0 ? ((float) this.n) / ((float) clientWidth) : 0.0f;
        e eVar = null;
        int i3 = 0;
        int i4 = -1;
        boolean z2 = true;
        float f4 = 0.0f;
        while (i3 < this.f415c.size()) {
            e eVar2 = this.f415c.get(i3);
            if (!z2 && eVar2.f422b != (i2 = i4 + 1)) {
                eVar2 = this.f416d;
                eVar2.f425e = f2 + f4 + f3;
                eVar2.f422b = i2;
                eVar2.f424d = this.f418f.getPageWidth(i2);
                i3--;
            }
            f2 = eVar2.f425e;
            float f5 = eVar2.f424d + f2 + f3;
            if (!z2 && scrollX < f2) {
                return eVar;
            }
            if (scrollX < f5 || i3 == this.f415c.size() - 1) {
                return eVar2;
            }
            i4 = eVar2.f422b;
            f4 = eVar2.f424d;
            i3++;
            z2 = false;
            eVar = eVar2;
        }
        return eVar;
    }

    public e j(int i2) {
        for (int i3 = 0; i3 < this.f415c.size(); i3++) {
            e eVar = this.f415c.get(i3);
            if (eVar.f422b == i2) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    public void k(int i2, float f2, int i3) {
        int i4;
        int left;
        int i5;
        if (this.R > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.f426a) {
                    int i7 = fVar.f427b & 7;
                    if (i7 != 1) {
                        if (i7 == 3) {
                            i4 = childAt.getWidth() + paddingLeft;
                        } else if (i7 != 5) {
                            i4 = paddingLeft;
                        } else {
                            i5 = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i4;
                    } else {
                        i5 = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    i4 = paddingLeft;
                    paddingLeft = i5;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i4;
                }
            }
        }
        i iVar = this.T;
        if (iVar != null) {
            iVar.a(i2, f2, i3);
        }
        List<i> list = this.S;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                i iVar2 = this.S.get(i8);
                if (iVar2 != null) {
                    iVar2.a(i2, f2, i3);
                }
            }
        }
        this.Q = true;
    }

    public final void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.H) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.D = motionEvent.getX(i2);
            this.H = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean m() {
        int i2 = this.f419g;
        if (i2 <= 0) {
            return false;
        }
        this.w = false;
        v(i2 - 1, true, false, 0);
        return true;
    }

    public boolean n() {
        b.a0.a.a aVar = this.f418f;
        if (aVar == null || this.f419g >= aVar.getCount() - 1) {
            return false;
        }
        this.w = false;
        v(this.f419g + 1, true, false, 0);
        return true;
    }

    public final boolean o(int i2) {
        if (this.f415c.size() != 0) {
            e i3 = i();
            int clientWidth = getClientWidth();
            int i4 = this.n;
            int i5 = clientWidth + i4;
            float f2 = (float) clientWidth;
            int i6 = i3.f422b;
            float f3 = ((((float) i2) / f2) - i3.f425e) / (i3.f424d + (((float) i4) / f2));
            this.Q = false;
            k(i6, f3, (int) (((float) i5) * f3));
            if (this.Q) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.P) {
            return false;
        } else {
            this.Q = false;
            k(0, 0.0f, 0);
            if (this.Q) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.P = true;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.W);
        Scroller scroller = this.k;
        if (scroller != null && !scroller.isFinished()) {
            this.k.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.n > 0 && this.o != null && this.f415c.size() > 0 && this.f418f != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f4 = (float) width;
            float f5 = ((float) this.n) / f4;
            int i2 = 0;
            e eVar = this.f415c.get(0);
            float f6 = eVar.f425e;
            int size = this.f415c.size();
            int i3 = eVar.f422b;
            int i4 = this.f415c.get(size - 1).f422b;
            while (i3 < i4) {
                while (i3 > eVar.f422b && i2 < size) {
                    i2++;
                    eVar = this.f415c.get(i2);
                }
                if (i3 == eVar.f422b) {
                    float f7 = eVar.f425e;
                    float f8 = eVar.f424d;
                    f2 = (f7 + f8) * f4;
                    f6 = f7 + f8 + f5;
                } else {
                    float pageWidth = this.f418f.getPageWidth(i3);
                    f2 = (f6 + pageWidth) * f4;
                    f6 = pageWidth + f5 + f6;
                }
                if (((float) this.n) + f2 > ((float) scrollX)) {
                    f3 = f5;
                    this.o.setBounds(Math.round(f2), this.p, Math.round(((float) this.n) + f2), this.q);
                    this.o.draw(canvas);
                } else {
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollX + width))) {
                    i3++;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & BuildConfig.VERSION_CODE;
        if (action == 3 || action == 1) {
            t();
            return false;
        }
        if (action != 0) {
            if (this.y) {
                return true;
            }
            if (this.z) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.F = x2;
            this.D = x2;
            float y2 = motionEvent.getY();
            this.G = y2;
            this.E = y2;
            this.H = motionEvent.getPointerId(0);
            this.z = false;
            this.l = true;
            this.k.computeScrollOffset();
            if (this.a0 != 2 || Math.abs(this.k.getFinalX() - this.k.getCurrX()) <= this.M) {
                d(false);
                this.y = false;
            } else {
                this.k.abortAnimation();
                this.w = false;
                q(this.f419g);
                this.y = true;
                s(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.H;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x3 = motionEvent.getX(findPointerIndex);
                float f2 = x3 - this.D;
                float abs = Math.abs(f2);
                float y3 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y3 - this.G);
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 != 0) {
                    float f3 = this.D;
                    if (!((f3 < ((float) this.B) && i3 > 0) || (f3 > ((float) (getWidth() - this.B)) && f2 < 0.0f)) && c(this, false, (int) f2, (int) x3, (int) y3)) {
                        this.D = x3;
                        this.E = y3;
                        this.z = true;
                        return false;
                    }
                }
                if (abs > ((float) this.C) && abs * 0.5f > abs2) {
                    this.y = true;
                    s(true);
                    setScrollState(1);
                    float f4 = this.F;
                    float f5 = (float) this.C;
                    this.D = i3 > 0 ? f4 + f5 : f4 - f5;
                    this.E = y3;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.C)) {
                    this.z = true;
                }
                if (this.y && p(x3)) {
                    m.M(this);
                }
            }
        } else if (action == 6) {
            l(motionEvent);
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        return this.y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3;
        e h2;
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
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.f426a) {
                    int i14 = fVar.f427b;
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
        int i18 = (i10 - paddingLeft) - paddingRight;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                f fVar2 = (f) childAt2.getLayoutParams();
                if (!fVar2.f426a && (h2 = h(childAt2)) != null) {
                    float f2 = (float) i18;
                    int i20 = ((int) (h2.f425e * f2)) + paddingLeft;
                    if (fVar2.f429d) {
                        fVar2.f429d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * fVar2.f428c), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i20, paddingTop, childAt2.getMeasuredWidth() + i20, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.p = paddingTop;
        this.q = i11 - paddingBottom;
        this.R = i12;
        if (this.P) {
            z3 = false;
            u(this.f419g, false, 0, false);
        } else {
            z3 = false;
        }
        this.P = z3;
    }

    public void onMeasure(int i2, int i3) {
        f fVar;
        f fVar2;
        int i4;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.B = Math.min(measuredWidth / 10, this.A);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z2 = true;
            int i6 = 1073741824;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (!(childAt.getVisibility() == 8 || (fVar2 = (f) childAt.getLayoutParams()) == null || !fVar2.f426a)) {
                int i7 = fVar2.f427b;
                int i8 = i7 & 7;
                int i9 = i7 & 112;
                boolean z3 = i9 == 48 || i9 == 80;
                if (!(i8 == 3 || i8 == 5)) {
                    z2 = false;
                }
                int i10 = BleSignal.UNKNOWN_TX_POWER;
                if (z3) {
                    i4 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i4 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i11 = ((ViewGroup.LayoutParams) fVar2).width;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = paddingLeft;
                    }
                    i10 = 1073741824;
                } else {
                    i11 = paddingLeft;
                }
                int i12 = ((ViewGroup.LayoutParams) fVar2).height;
                if (i12 == -2) {
                    i12 = measuredHeight;
                    i6 = i4;
                } else if (i12 == -1) {
                    i12 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i10), View.MeasureSpec.makeMeasureSpec(i12, i6));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i5++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.t = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.u = true;
        q(this.f419g);
        this.u = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((fVar = (f) childAt2.getLayoutParams()) == null || !fVar.f426a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * fVar.f428c), 1073741824), this.t);
            }
        }
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        e h2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.f422b == this.f419g && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof k)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.f1952b);
        b.a0.a.a aVar = this.f418f;
        if (aVar != null) {
            aVar.restoreState(kVar.f435e, kVar.f436f);
            v(kVar.f434d, false, true, 0);
            return;
        }
        this.h = kVar.f434d;
        this.i = kVar.f435e;
        this.j = kVar.f436f;
    }

    public Parcelable onSaveInstanceState() {
        k kVar = new k(super.onSaveInstanceState());
        kVar.f434d = this.f419g;
        b.a0.a.a aVar = this.f418f;
        if (aVar != null) {
            kVar.f435e = aVar.saveState();
        }
        return kVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.n;
            r(i2, i4, i6, i6);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0198  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b.a0.a.a aVar;
        int i2;
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.f418f) == null || aVar.getCount() == 0) {
            return false;
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        int action = motionEvent.getAction() & BuildConfig.VERSION_CODE;
        if (action != 0) {
            if (action == 1) {
                if (this.y) {
                    VelocityTracker velocityTracker = this.I;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.K);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.H);
                    this.w = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    e i3 = i();
                    float f2 = (float) clientWidth;
                    float f3 = ((float) this.n) / f2;
                    int i4 = i3.f422b;
                    float f4 = ((((float) scrollX) / f2) - i3.f425e) / (i3.f424d + f3);
                    if (Math.abs((int) (motionEvent.getX(motionEvent.findPointerIndex(this.H)) - this.F)) <= this.L || Math.abs(xVelocity) <= this.J) {
                        i4 += (int) (f4 + (i4 >= this.f419g ? 0.4f : 0.6f));
                    } else if (xVelocity <= 0) {
                        i4++;
                    }
                    if (this.f415c.size() > 0) {
                        ArrayList<e> arrayList = this.f415c;
                        i4 = Math.max(this.f415c.get(0).f422b, Math.min(i4, arrayList.get(arrayList.size() - 1).f422b));
                    }
                    v(i4, true, true, xVelocity);
                }
                if (z2) {
                }
                return true;
            } else if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.D = motionEvent.getX(actionIndex);
                        i2 = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        l(motionEvent);
                        this.D = motionEvent.getX(motionEvent.findPointerIndex(this.H));
                    }
                } else if (this.y) {
                    u(this.f419g, true, 0, false);
                }
                if (z2) {
                    m.M(this);
                }
                return true;
            } else {
                if (!this.y) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.H);
                    if (findPointerIndex != -1) {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.D);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.E);
                        if (abs > ((float) this.C) && abs > abs2) {
                            this.y = true;
                            s(true);
                            float f5 = this.F;
                            this.D = x2 - f5 > 0.0f ? f5 + ((float) this.C) : f5 - ((float) this.C);
                            this.E = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.y) {
                    z2 = false | p(motionEvent.getX(motionEvent.findPointerIndex(this.H)));
                }
                if (z2) {
                }
                return true;
            }
            z2 = t();
            if (z2) {
            }
            return true;
        }
        this.k.abortAnimation();
        this.w = false;
        q(this.f419g);
        float x3 = motionEvent.getX();
        this.F = x3;
        this.D = x3;
        float y3 = motionEvent.getY();
        this.G = y3;
        this.E = y3;
        i2 = motionEvent.getPointerId(0);
        this.H = i2;
        if (z2) {
        }
        return true;
    }

    public final boolean p(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.D - f2;
        this.D = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.r * clientWidth;
        float f5 = this.s * clientWidth;
        boolean z4 = false;
        e eVar = this.f415c.get(0);
        ArrayList<e> arrayList = this.f415c;
        e eVar2 = arrayList.get(arrayList.size() - 1);
        if (eVar.f422b != 0) {
            f4 = eVar.f425e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (eVar2.f422b != this.f418f.getCount() - 1) {
            f5 = eVar2.f425e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.N.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.O.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.D = (scrollX - ((float) i2)) + this.D;
        scrollTo(i2, getScrollY());
        o(i2);
        return z4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r5 == r6) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b5, code lost:
        if (r6 >= 0) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c3, code lost:
        if (r6 >= 0) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d1, code lost:
        if (r6 >= 0) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00dc, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0130, code lost:
        if (r9 < r14.f415c.size()) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0144, code lost:
        if (r9 < r14.f415c.size()) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0156, code lost:
        if (r9 < r14.f415c.size()) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0161, code lost:
        r7 = null;
     */
    public void q(int i2) {
        e eVar;
        String str;
        e eVar2;
        e eVar3;
        e h2;
        int i3;
        int i4;
        e eVar4;
        e eVar5;
        int i5 = this.f419g;
        if (i5 != i2) {
            eVar = j(i5);
            this.f419g = i2;
        } else {
            eVar = null;
        }
        if (!(this.f418f == null || this.w || getWindowToken() == null)) {
            this.f418f.startUpdate((ViewGroup) this);
            int i6 = this.x;
            int i7 = 0;
            int max = Math.max(0, this.f419g - i6);
            int count = this.f418f.getCount();
            int min = Math.min(count - 1, this.f419g + i6);
            if (count == this.f414b) {
                while (true) {
                    if (i7 >= this.f415c.size()) {
                        break;
                    }
                    eVar2 = this.f415c.get(i7);
                    int i8 = eVar2.f422b;
                    int i9 = this.f419g;
                    if (i8 < i9) {
                        i7++;
                    }
                }
                eVar2 = null;
                if (eVar2 == null && count > 0) {
                    eVar2 = a(this.f419g, i7);
                }
                if (eVar2 != null) {
                    int i10 = i7 - 1;
                    e eVar6 = i10 >= 0 ? this.f415c.get(i10) : null;
                    int clientWidth = getClientWidth();
                    float paddingLeft = clientWidth <= 0 ? 0.0f : (((float) getPaddingLeft()) / ((float) clientWidth)) + (2.0f - eVar2.f424d);
                    float f2 = 0.0f;
                    for (int i11 = this.f419g - 1; i11 >= 0; i11--) {
                        if (f2 < paddingLeft || i11 >= max) {
                            if (eVar6 == null || i11 != eVar6.f422b) {
                                f2 += a(i11, i10 + 1).f424d;
                                i7++;
                            } else {
                                f2 += eVar6.f424d;
                                i10--;
                            }
                        } else if (eVar6 == null) {
                            break;
                        } else {
                            if (i11 == eVar6.f422b && !eVar6.f423c) {
                                this.f415c.remove(i10);
                                this.f418f.destroyItem((ViewGroup) this, i11, eVar6.f421a);
                                i10--;
                                i7--;
                            }
                        }
                        eVar6 = this.f415c.get(i10);
                    }
                    float f3 = eVar2.f424d;
                    int i12 = i7 + 1;
                    if (f3 < 2.0f) {
                        e eVar7 = i12 < this.f415c.size() ? this.f415c.get(i12) : null;
                        float paddingRight = clientWidth <= 0 ? 0.0f : (((float) getPaddingRight()) / ((float) clientWidth)) + 2.0f;
                        int i13 = i12;
                        for (int i14 = this.f419g + 1; i14 < count; i14++) {
                            if (f3 < paddingRight || i14 <= min) {
                                if (eVar7 == null || i14 != eVar7.f422b) {
                                    e a2 = a(i14, i13);
                                    i13++;
                                    f3 += a2.f424d;
                                } else {
                                    f3 += eVar7.f424d;
                                    i13++;
                                }
                            } else if (eVar7 == null) {
                                break;
                            } else {
                                if (i14 == eVar7.f422b && !eVar7.f423c) {
                                    this.f415c.remove(i13);
                                    this.f418f.destroyItem((ViewGroup) this, i14, eVar7.f421a);
                                }
                            }
                            eVar7 = this.f415c.get(i13);
                        }
                    }
                    int count2 = this.f418f.getCount();
                    int clientWidth2 = getClientWidth();
                    float f4 = clientWidth2 > 0 ? ((float) this.n) / ((float) clientWidth2) : 0.0f;
                    if (eVar != null) {
                        int i15 = eVar.f422b;
                        int i16 = eVar2.f422b;
                        if (i15 < i16) {
                            float f5 = eVar.f425e + eVar.f424d + f4;
                            int i17 = 0;
                            while (true) {
                                i15++;
                                if (i15 > eVar2.f422b || i17 >= this.f415c.size()) {
                                    break;
                                }
                                while (true) {
                                    eVar5 = this.f415c.get(i17);
                                    if (i15 > eVar5.f422b && i17 < this.f415c.size() - 1) {
                                        i17++;
                                    }
                                }
                                while (i15 < eVar5.f422b) {
                                    f5 += this.f418f.getPageWidth(i15) + f4;
                                    i15++;
                                }
                                eVar5.f425e = f5;
                                f5 += eVar5.f424d + f4;
                            }
                        } else if (i15 > i16) {
                            int size = this.f415c.size() - 1;
                            float f6 = eVar.f425e;
                            while (true) {
                                i15--;
                                if (i15 < eVar2.f422b || size < 0) {
                                    break;
                                }
                                while (true) {
                                    eVar4 = this.f415c.get(size);
                                    if (i15 < eVar4.f422b && size > 0) {
                                        size--;
                                    }
                                }
                                while (i15 > eVar4.f422b) {
                                    f6 -= this.f418f.getPageWidth(i15) + f4;
                                    i15--;
                                }
                                f6 -= eVar4.f424d + f4;
                                eVar4.f425e = f6;
                            }
                        }
                    }
                    int size2 = this.f415c.size();
                    float f7 = eVar2.f425e;
                    int i18 = eVar2.f422b;
                    int i19 = i18 - 1;
                    this.r = i18 == 0 ? f7 : -3.4028235E38f;
                    int i20 = count2 - 1;
                    this.s = eVar2.f422b == i20 ? (eVar2.f425e + eVar2.f424d) - 1.0f : Float.MAX_VALUE;
                    int i21 = i7 - 1;
                    while (i21 >= 0) {
                        e eVar8 = this.f415c.get(i21);
                        while (true) {
                            i4 = eVar8.f422b;
                            if (i19 <= i4) {
                                break;
                            }
                            f7 -= this.f418f.getPageWidth(i19) + f4;
                            i19--;
                        }
                        f7 -= eVar8.f424d + f4;
                        eVar8.f425e = f7;
                        if (i4 == 0) {
                            this.r = f7;
                        }
                        i21--;
                        i19--;
                    }
                    float f8 = eVar2.f425e + eVar2.f424d + f4;
                    int i22 = eVar2.f422b;
                    while (true) {
                        i22++;
                        if (i12 >= size2) {
                            break;
                        }
                        e eVar9 = this.f415c.get(i12);
                        while (true) {
                            i3 = eVar9.f422b;
                            if (i22 >= i3) {
                                break;
                            }
                            f8 += this.f418f.getPageWidth(i22) + f4;
                            i22++;
                        }
                        if (i3 == i20) {
                            this.s = (eVar9.f424d + f8) - 1.0f;
                        }
                        eVar9.f425e = f8;
                        f8 += eVar9.f424d + f4;
                        i12++;
                    }
                    this.f418f.setPrimaryItem((ViewGroup) this, this.f419g, eVar2.f421a);
                }
                this.f418f.finishUpdate((ViewGroup) this);
                int childCount = getChildCount();
                for (int i23 = 0; i23 < childCount; i23++) {
                    View childAt = getChildAt(i23);
                    f fVar = (f) childAt.getLayoutParams();
                    fVar.f431f = i23;
                    if (!fVar.f426a && fVar.f428c == 0.0f && (h2 = h(childAt)) != null) {
                        fVar.f428c = h2.f424d;
                        fVar.f430e = h2.f422b;
                    }
                }
                if (hasFocus()) {
                    View findFocus = findFocus();
                    if (findFocus != null) {
                        while (true) {
                            ViewParent parent = findFocus.getParent();
                            if (parent == this) {
                                eVar3 = h(findFocus);
                                break;
                            }
                            if (parent == null || !(parent instanceof View)) {
                                break;
                            }
                            findFocus = (View) parent;
                        }
                    }
                    eVar3 = null;
                    if (eVar3 == null || eVar3.f422b != this.f419g) {
                        for (int i24 = 0; i24 < getChildCount(); i24++) {
                            View childAt2 = getChildAt(i24);
                            e h3 = h(childAt2);
                            if (h3 != null && h3.f422b == this.f419g && childAt2.requestFocus(2)) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                str = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                str = Integer.toHexString(getId());
            }
            StringBuilder h4 = c.a.a.a.a.h("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
            h4.append(this.f414b);
            h4.append(", found: ");
            h4.append(count);
            h4.append(" Pager id: ");
            h4.append(str);
            h4.append(" Pager class: ");
            h4.append(ViewPager.class);
            h4.append(" Problematic adapter: ");
            h4.append(this.f418f.getClass());
            throw new IllegalStateException(h4.toString());
        }
    }

    public final void r(int i2, int i3, int i4, int i5) {
        int min;
        if (i3 <= 0 || this.f415c.isEmpty()) {
            e j2 = j(this.f419g);
            min = (int) ((j2 != null ? Math.min(j2.f425e, this.s) : 0.0f) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                d(false);
            } else {
                return;
            }
        } else if (!this.k.isFinished()) {
            this.k.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            min = (int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)));
        }
        scrollTo(min, getScrollY());
    }

    public void removeView(View view) {
        if (this.u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final void s(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public void setAdapter(b.a0.a.a aVar) {
        b.a0.a.a aVar2 = this.f418f;
        if (aVar2 != null) {
            aVar2.setViewPagerObserver(null);
            this.f418f.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.f415c.size(); i2++) {
                e eVar = this.f415c.get(i2);
                this.f418f.destroyItem((ViewGroup) this, eVar.f422b, eVar.f421a);
            }
            this.f418f.finishUpdate((ViewGroup) this);
            this.f415c.clear();
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (!((f) getChildAt(i3).getLayoutParams()).f426a) {
                    removeViewAt(i3);
                    i3--;
                }
                i3++;
            }
            this.f419g = 0;
            scrollTo(0, 0);
        }
        b.a0.a.a aVar3 = this.f418f;
        this.f418f = aVar;
        this.f414b = 0;
        if (aVar != null) {
            if (this.m == null) {
                this.m = new j();
            }
            this.f418f.setViewPagerObserver(this.m);
            this.w = false;
            boolean z2 = this.P;
            this.P = true;
            this.f414b = this.f418f.getCount();
            if (this.h >= 0) {
                this.f418f.restoreState(this.i, this.j);
                v(this.h, false, true, 0);
                this.h = -1;
                this.i = null;
                this.j = null;
            } else if (!z2) {
                q(this.f419g);
            } else {
                requestLayout();
            }
        }
        List<h> list = this.U;
        if (!(list == null || list.isEmpty())) {
            int size = this.U.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.U.get(i4).a(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.w = false;
        v(i2, !this.P, false, 0);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            i2 = 1;
        }
        if (i2 != this.x) {
            this.x = i2;
            q(this.f419g);
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        this.T = iVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.n;
        this.n = i2;
        int width = getWidth();
        r(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(b.i.e.a.c(getContext(), i2));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.a0 != i2) {
            this.a0 = i2;
            i iVar = this.T;
            if (iVar != null) {
                iVar.b(i2);
            }
            List<i> list = this.S;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    i iVar2 = this.S.get(i3);
                    if (iVar2 != null) {
                        iVar2.b(i2);
                    }
                }
            }
        }
    }

    public final boolean t() {
        this.H = -1;
        this.y = false;
        this.z = false;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.I = null;
        }
        this.N.onRelease();
        this.O.onRelease();
        if (this.N.isFinished() || this.O.isFinished()) {
            return true;
        }
        return false;
    }

    public final void u(int i2, boolean z2, int i3, boolean z3) {
        int i4;
        e j2 = j(i2);
        int max = j2 != null ? (int) (Math.max(this.r, Math.min(j2.f425e, this.s)) * ((float) getClientWidth())) : 0;
        if (z2) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                Scroller scroller = this.k;
                if (scroller != null && !scroller.isFinished()) {
                    i4 = this.l ? this.k.getCurrX() : this.k.getStartX();
                    this.k.abortAnimation();
                    setScrollingCacheEnabled(false);
                } else {
                    i4 = getScrollX();
                }
                int scrollY = getScrollY();
                int i5 = max - i4;
                int i6 = 0 - scrollY;
                if (i5 == 0 && i6 == 0) {
                    d(false);
                    q(this.f419g);
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    int clientWidth = getClientWidth();
                    int i7 = clientWidth / 2;
                    float f2 = (float) clientWidth;
                    float f3 = (float) i7;
                    float sin = (((float) Math.sin((double) ((Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / f2) - 0.5f) * 0.47123894f))) * f3) + f3;
                    int abs = Math.abs(i3);
                    int min = Math.min(abs > 0 ? Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i5)) / ((this.f418f.getPageWidth(this.f419g) * f2) + ((float) this.n))) + 1.0f) * 100.0f), 600);
                    this.l = false;
                    this.k.startScroll(i4, scrollY, i5, i6, min);
                    m.M(this);
                }
            }
            if (z3) {
                f(i2);
                return;
            }
            return;
        }
        if (z3) {
            f(i2);
        }
        d(false);
        scrollTo(max, 0);
        o(max);
    }

    public void v(int i2, boolean z2, boolean z3, int i3) {
        b.a0.a.a aVar = this.f418f;
        boolean z4 = false;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.f419g != i2 || this.f415c.size() == 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.f418f.getCount()) {
                i2 = this.f418f.getCount() - 1;
            }
            int i4 = this.x;
            int i5 = this.f419g;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.f415c.size(); i6++) {
                    this.f415c.get(i6).f423c = true;
                }
            }
            if (this.f419g != i2) {
                z4 = true;
            }
            if (this.P) {
                this.f419g = i2;
                if (z4) {
                    f(i2);
                }
                requestLayout();
                return;
            }
            q(i2);
            u(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }
}
