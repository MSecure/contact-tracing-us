package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import e.b0.b.f;
import e.i.i.m;
import e.i.i.x.b;
import e.i.i.x.d;
import e.s.a.t;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class ViewPager2 extends ViewGroup {
    public final Rect b = new Rect();
    public final Rect c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public e.b0.b.c f298d = new e.b0.b.c(3);

    /* renamed from: e  reason: collision with root package name */
    public int f299e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f300f = false;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.g f301g = new a();

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f302h;

    /* renamed from: i  reason: collision with root package name */
    public int f303i = -1;

    /* renamed from: j  reason: collision with root package name */
    public Parcelable f304j;

    /* renamed from: k  reason: collision with root package name */
    public RecyclerView f305k;

    /* renamed from: l  reason: collision with root package name */
    public t f306l;
    public e.b0.b.f m;
    public e.b0.b.c n;
    public e.b0.b.d o;
    public e.b0.b.e p;
    public RecyclerView.j q = null;
    public boolean r = false;
    public boolean s = true;
    public int t = -1;
    public b u = new f();

    public class a extends c {
        public a() {
            super(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f300f = true;
            viewPager2.m.f991l = true;
        }
    }

    public abstract class b {
        public b(ViewPager2 viewPager2, a aVar) {
        }

        public abstract void a(e.b0.b.c cVar, RecyclerView recyclerView);

        public abstract void b();
    }

    public static abstract class c extends RecyclerView.g {
        public c(a aVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void b(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void c(int i2, int i3, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void d(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void e(int i2, int i3) {
            a();
        }
    }

    public class d extends LinearLayoutManager {
        public d(Context context) {
            super(1, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public boolean E0(RecyclerView.t tVar, RecyclerView.y yVar, int i2, Bundle bundle) {
            Objects.requireNonNull(ViewPager2.this.u);
            return super.E0(tVar, yVar, i2, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public boolean L0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void b1(RecyclerView.y yVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.b1(yVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void m0(RecyclerView.t tVar, RecyclerView.y yVar, e.i.i.x.b bVar) {
            super.m0(tVar, yVar, bVar);
            Objects.requireNonNull(ViewPager2.this.u);
        }
    }

    public static abstract class e {
        public void a(int i2) {
        }

        public void b(int i2, float f2, int i3) {
        }

        public void c(int i2) {
        }
    }

    public class f extends b {
        public final e.i.i.x.d a = new a();
        public final e.i.i.x.d b = new b();
        public RecyclerView.g c;

        public class a implements e.i.i.x.d {
            public a() {
            }

            @Override // e.i.i.x.d
            public boolean a(View view, d.a aVar) {
                f.this.c(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        public class b implements e.i.i.x.d {
            public b() {
            }

            @Override // e.i.i.x.d
            public boolean a(View view, d.a aVar) {
                f.this.c(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        public class c extends c {
            public c() {
                super(null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.g
            public void a() {
                f.this.d();
            }
        }

        public f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.b
        public void a(e.b0.b.c cVar, RecyclerView recyclerView) {
            AtomicInteger atomicInteger = m.a;
            recyclerView.setImportantForAccessibility(2);
            this.c = new c();
            if (ViewPager2.this.getImportantForAccessibility() == 0) {
                ViewPager2.this.setImportantForAccessibility(1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.b
        public void b() {
            d();
        }

        public void c(int i2) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.s) {
                viewPager2.c(i2, true);
            }
        }

        public void d() {
            int c2;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i2 = 16908360;
            m.n(viewPager2, 16908360);
            m.n(viewPager2, 16908361);
            m.n(viewPager2, 16908358);
            m.n(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (c2 = ViewPager2.this.getAdapter().c()) != 0) {
                ViewPager2 viewPager22 = ViewPager2.this;
                if (viewPager22.s) {
                    if (viewPager22.getOrientation() == 0) {
                        boolean a2 = ViewPager2.this.a();
                        int i3 = a2 ? 16908360 : 16908361;
                        if (a2) {
                            i2 = 16908361;
                        }
                        if (ViewPager2.this.f299e < c2 - 1) {
                            m.p(viewPager2, new b.a(i3, null), null, this.a);
                        }
                        if (ViewPager2.this.f299e > 0) {
                            m.p(viewPager2, new b.a(i2, null), null, this.b);
                            return;
                        }
                        return;
                    }
                    if (ViewPager2.this.f299e < c2 - 1) {
                        m.p(viewPager2, new b.a(16908359, null), null, this.a);
                    }
                    if (ViewPager2.this.f299e > 0) {
                        m.p(viewPager2, new b.a(16908358, null), null, this.b);
                    }
                }
            }
        }
    }

    public interface g {
    }

    public class h extends t {
        public h() {
        }

        @Override // e.s.a.y, e.s.a.t
        public View c(RecyclerView.m mVar) {
            if (ViewPager2.this.o.a.m) {
                return null;
            }
            return super.c(mVar);
        }
    }

    public class i extends RecyclerView {
        public i(Context context) {
            super(context, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public CharSequence getAccessibilityClassName() {
            Objects.requireNonNull(ViewPager2.this.u);
            return super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f299e);
            accessibilityEvent.setToIndex(ViewPager2.this.f299e);
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.s && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.s && super.onTouchEvent(motionEvent);
        }
    }

    public static class j extends View.BaseSavedState {
        public static final Parcelable.Creator<j> CREATOR = new a();
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public Parcelable f309d;

        public static class a implements Parcelable.ClassLoaderCreator<j> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return Build.VERSION.SDK_INT >= 24 ? new j(parcel, null) : new j(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new j[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public j createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new j(parcel, classLoader) : new j(parcel);
            }
        }

        public j(Parcel parcel) {
            super(parcel);
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.f309d = parcel.readParcelable(null);
        }

        public j(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeParcelable(this.f309d, i2);
        }

        public j(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.f309d = parcel.readParcelable(classLoader);
        }
    }

    public static class k implements Runnable {
        public final int b;
        public final RecyclerView c;

        public k(int i2, RecyclerView recyclerView) {
            this.b = i2;
            this.c = recyclerView;
        }

        public void run() {
            this.c.m0(this.b);
        }
    }

    /* JADX INFO: finally extract failed */
    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i iVar = new i(context);
        this.f305k = iVar;
        AtomicInteger atomicInteger = m.a;
        iVar.setId(View.generateViewId());
        this.f305k.setDescendantFocusability(131072);
        d dVar = new d(context);
        this.f302h = dVar;
        this.f305k.setLayoutManager(dVar);
        this.f305k.setScrollingTouchSlop(1);
        int[] iArr = R$styleable.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R$styleable.ViewPager2_android_orientation, 0));
            obtainStyledAttributes.recycle();
            this.f305k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            RecyclerView recyclerView = this.f305k;
            e.b0.b.i iVar2 = new e.b0.b.i(this);
            if (recyclerView.D == null) {
                recyclerView.D = new ArrayList();
            }
            recyclerView.D.add(iVar2);
            e.b0.b.f fVar = new e.b0.b.f(this);
            this.m = fVar;
            this.o = new e.b0.b.d(this, fVar, this.f305k);
            h hVar = new h();
            this.f306l = hVar;
            hVar.a(this.f305k);
            this.f305k.h(this.m);
            e.b0.b.c cVar = new e.b0.b.c(3);
            this.n = cVar;
            this.m.a = cVar;
            e.b0.b.g gVar = new e.b0.b.g(this);
            e.b0.b.h hVar2 = new e.b0.b.h(this);
            cVar.a.add(gVar);
            this.n.a.add(hVar2);
            this.u.a(this.n, this.f305k);
            e.b0.b.c cVar2 = this.n;
            cVar2.a.add(this.f298d);
            e.b0.b.e eVar = new e.b0.b.e(this.f302h);
            this.p = eVar;
            this.n.a.add(eVar);
            RecyclerView recyclerView2 = this.f305k;
            attachViewToParent(recyclerView2, 0, recyclerView2.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public boolean a() {
        return this.f302h.L() == 1;
    }

    public final void b() {
        RecyclerView.e adapter;
        if (this.f303i != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.f304j;
            if (parcelable != null) {
                if (adapter instanceof e.b0.a.g) {
                    ((e.b0.a.g) adapter).b(parcelable);
                }
                this.f304j = null;
            }
            int max = Math.max(0, Math.min(this.f303i, adapter.c() - 1));
            this.f299e = max;
            this.f303i = -1;
            this.f305k.j0(max);
            ((f) this.u).d();
        }
    }

    public void c(int i2, boolean z) {
        RecyclerView.e adapter = getAdapter();
        boolean z2 = false;
        if (adapter == null) {
            if (this.f303i != -1) {
                this.f303i = Math.max(i2, 0);
            }
        } else if (adapter.c() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.c() - 1);
            int i3 = this.f299e;
            if (min == i3) {
                if (this.m.f985f == 0) {
                    return;
                }
            }
            if (min != i3 || !z) {
                double d2 = (double) i3;
                this.f299e = min;
                ((f) this.u).d();
                e.b0.b.f fVar = this.m;
                if (!(fVar.f985f == 0)) {
                    fVar.f();
                    f.a aVar = fVar.f986g;
                    d2 = ((double) aVar.a) + ((double) aVar.b);
                }
                e.b0.b.f fVar2 = this.m;
                fVar2.f984e = z ? 2 : 3;
                fVar2.m = false;
                if (fVar2.f988i != min) {
                    z2 = true;
                }
                fVar2.f988i = min;
                fVar2.d(2);
                if (z2) {
                    fVar2.c(min);
                }
                if (!z) {
                    this.f305k.j0(min);
                    return;
                }
                double d3 = (double) min;
                if (Math.abs(d3 - d2) > 3.0d) {
                    this.f305k.j0(d3 > d2 ? min - 3 : min + 3);
                    RecyclerView recyclerView = this.f305k;
                    recyclerView.post(new k(min, recyclerView));
                    return;
                }
                this.f305k.m0(min);
            }
        }
    }

    public boolean canScrollHorizontally(int i2) {
        return this.f305k.canScrollHorizontally(i2);
    }

    public boolean canScrollVertically(int i2) {
        return this.f305k.canScrollVertically(i2);
    }

    public void d() {
        t tVar = this.f306l;
        if (tVar != null) {
            View c2 = tVar.c(this.f302h);
            if (c2 != null) {
                int S = this.f302h.S(c2);
                if (S != this.f299e && getScrollState() == 0) {
                    this.n.c(S);
                }
                this.f300f = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof j) {
            int i2 = ((j) parcelable).b;
            sparseArray.put(this.f305k.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        b();
    }

    public CharSequence getAccessibilityClassName() {
        Objects.requireNonNull(this.u);
        Objects.requireNonNull(this.u);
        return "androidx.viewpager.widget.ViewPager";
    }

    public RecyclerView.e getAdapter() {
        return this.f305k.getAdapter();
    }

    public int getCurrentItem() {
        return this.f299e;
    }

    public int getItemDecorationCount() {
        return this.f305k.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.t;
    }

    public int getOrientation() {
        return this.f302h.r;
    }

    public int getPageSize() {
        int i2;
        int i3;
        RecyclerView recyclerView = this.f305k;
        if (getOrientation() == 0) {
            i2 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i3 = recyclerView.getPaddingRight();
        } else {
            i2 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i3 = recyclerView.getPaddingBottom();
        }
        return i2 - i3;
    }

    public int getScrollState() {
        return this.m.f985f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        int i3;
        RecyclerView.e adapter;
        int c2;
        ViewPager2 viewPager2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        f fVar = (f) this.u;
        if (ViewPager2.this.getAdapter() == null) {
            i3 = 0;
        } else if (ViewPager2.this.getOrientation() == 1) {
            i3 = ViewPager2.this.getAdapter().c();
        } else {
            i2 = ViewPager2.this.getAdapter().c();
            i3 = 0;
            accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0039b.a(i3, i2, false, 0).a);
            adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (c2 = adapter.c()) != 0) {
                viewPager2 = ViewPager2.this;
                if (!viewPager2.s) {
                    if (viewPager2.f299e > 0) {
                        accessibilityNodeInfo.addAction(8192);
                    }
                    if (ViewPager2.this.f299e < c2 - 1) {
                        accessibilityNodeInfo.addAction(4096);
                    }
                    accessibilityNodeInfo.setScrollable(true);
                    return;
                }
                return;
            }
            return;
        }
        i2 = 0;
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0039b.a(i3, i2, false, 0).a);
        adapter = ViewPager2.this.getAdapter();
        if (adapter != null) {
            viewPager2 = ViewPager2.this;
            if (!viewPager2.s) {
            }
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f305k.getMeasuredWidth();
        int measuredHeight = this.f305k.getMeasuredHeight();
        this.b.left = getPaddingLeft();
        this.b.right = (i4 - i2) - getPaddingRight();
        this.b.top = getPaddingTop();
        this.b.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.b, this.c);
        RecyclerView recyclerView = this.f305k;
        Rect rect = this.c;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f300f) {
            d();
        }
    }

    public void onMeasure(int i2, int i3) {
        measureChild(this.f305k, i2, i3);
        int measuredWidth = this.f305k.getMeasuredWidth();
        int measuredHeight = this.f305k.getMeasuredHeight();
        int measuredState = this.f305k.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, measuredState), ViewGroup.resolveSizeAndState(Math.max(getPaddingBottom() + paddingTop + measuredHeight, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof j)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.getSuperState());
        this.f303i = jVar.c;
        this.f304j = jVar.f309d;
    }

    public Parcelable onSaveInstanceState() {
        j jVar = new j(super.onSaveInstanceState());
        jVar.b = this.f305k.getId();
        int i2 = this.f303i;
        if (i2 == -1) {
            i2 = this.f299e;
        }
        jVar.c = i2;
        Parcelable parcelable = this.f304j;
        if (parcelable == null) {
            RecyclerView.e adapter = this.f305k.getAdapter();
            if (adapter instanceof e.b0.a.g) {
                parcelable = ((e.b0.a.g) adapter).a();
            }
            return jVar;
        }
        jVar.f309d = parcelable;
        return jVar;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        Objects.requireNonNull((f) this.u);
        boolean z = false;
        if (!(i2 == 8192 || i2 == 4096)) {
            return super.performAccessibilityAction(i2, bundle);
        }
        f fVar = (f) this.u;
        Objects.requireNonNull(fVar);
        if (i2 == 8192 || i2 == 4096) {
            z = true;
        }
        if (z) {
            fVar.c(i2 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }
        throw new IllegalStateException();
    }

    public void setAdapter(RecyclerView.e eVar) {
        RecyclerView.e adapter = this.f305k.getAdapter();
        f fVar = (f) this.u;
        Objects.requireNonNull(fVar);
        if (adapter != null) {
            adapter.a.unregisterObserver(fVar.c);
        }
        if (adapter != null) {
            adapter.a.unregisterObserver(this.f301g);
        }
        this.f305k.setAdapter(eVar);
        this.f299e = 0;
        b();
        f fVar2 = (f) this.u;
        fVar2.d();
        if (eVar != null) {
            eVar.a.registerObserver(fVar2.c);
        }
        if (eVar != null) {
            eVar.a.registerObserver(this.f301g);
        }
    }

    public void setCurrentItem(int i2) {
        if (!this.o.a.m) {
            c(i2, true);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        ((f) this.u).d();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 >= 1 || i2 == -1) {
            this.t = i2;
            this.f305k.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i2) {
        this.f302h.E1(i2);
        ((f) this.u).d();
    }

    public void setPageTransformer(g gVar) {
        boolean z = this.r;
        if (gVar != null) {
            if (!z) {
                this.q = this.f305k.getItemAnimator();
                this.r = true;
            }
            this.f305k.setItemAnimator(null);
        } else if (z) {
            this.f305k.setItemAnimator(this.q);
            this.q = null;
            this.r = false;
        }
        e.b0.b.e eVar = this.p;
        if (gVar != eVar.b) {
            eVar.b = gVar;
            if (gVar != null) {
                e.b0.b.f fVar = this.m;
                fVar.f();
                f.a aVar = fVar.f986g;
                double d2 = ((double) aVar.a) + ((double) aVar.b);
                int i2 = (int) d2;
                float f2 = (float) (d2 - ((double) i2));
                this.p.b(i2, f2, Math.round(((float) getPageSize()) * f2));
            }
        }
    }

    public void setUserInputEnabled(boolean z) {
        this.s = z;
        ((f) this.u).d();
    }
}
