package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import e.b.a.m;
import e.i.i.j;
import e.i.i.k;
import e.i.i.m;
import e.i.i.w;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class CoordinatorLayout extends ViewGroup implements e.i.i.h, e.i.i.i {
    public static final String v;
    public static final Class<?>[] w = {Context.class, AttributeSet.class};
    public static final ThreadLocal<Map<String, Constructor<c>>> x = new ThreadLocal<>();
    public static final Comparator<View> y = new i();
    public static final e.i.h.b<Rect> z = new e.i.h.c(12);
    public final List<View> b = new ArrayList();
    public final e.h.a.a<View> c = new e.h.a.a<>();

    /* renamed from: d  reason: collision with root package name */
    public final List<View> f130d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final List<View> f131e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Paint f132f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f133g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    public final int[] f134h = new int[2];

    /* renamed from: i  reason: collision with root package name */
    public boolean f135i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f136j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f137k;

    /* renamed from: l  reason: collision with root package name */
    public View f138l;
    public View m;
    public g n;
    public boolean o;
    public w p;
    public boolean q;
    public Drawable r;
    public ViewGroup.OnHierarchyChangeListener s;
    public k t;
    public final j u = new j();

    public class a implements k {
        public a() {
        }

        @Override // e.i.i.k
        public w a(View view, w wVar) {
            c cVar;
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (!Objects.equals(coordinatorLayout.p, wVar)) {
                coordinatorLayout.p = wVar;
                boolean z = true;
                boolean z2 = wVar.d() > 0;
                coordinatorLayout.q = z2;
                if (z2 || coordinatorLayout.getBackground() != null) {
                    z = false;
                }
                coordinatorLayout.setWillNotDraw(z);
                if (!wVar.a.i()) {
                    int childCount = coordinatorLayout.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = coordinatorLayout.getChildAt(i2);
                        AtomicInteger atomicInteger = m.a;
                        if (childAt.getFitsSystemWindows() && (cVar = ((f) childAt.getLayoutParams()).a) != null) {
                            wVar = cVar.e(wVar);
                            if (wVar.a.i()) {
                                break;
                            }
                        }
                    }
                }
                coordinatorLayout.requestLayout();
            }
            return wVar;
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;)I */
        public int b() {
            return -16777216;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;)F */
        public float c() {
            return 0.0f;
        }

        public boolean d(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Le/i/i/w;)Le/i/i/w; */
        public w e(w wVar) {
            return wVar;
        }

        public void f(f fVar) {
        }

        public boolean g(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void h(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void i() {
        }

        public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v, int i2) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;FFZ)Z */
        public boolean m() {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;II[I)V */
        @Deprecated
        public void o() {
        }

        public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                o();
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;IIII)V */
        @Deprecated
        public void q() {
        }

        public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
            if (i6 == 0) {
                q();
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;Landroid/view/View;I)V */
        @Deprecated
        public void s() {
        }

        public boolean t(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void u(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable v(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;Landroid/view/View;I)Z */
        @Deprecated
        public boolean w() {
            return false;
        }

        public boolean x(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return w();
            }
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;)V */
        @Deprecated
        public void y() {
        }

        public void z(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
            if (i2 == 0) {
                y();
            }
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        Class<? extends c> value();
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.q(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {
        public c a;
        public boolean b = false;
        public int c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f139d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f140e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f141f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f142g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f143h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f144i;

        /* renamed from: j  reason: collision with root package name */
        public int f145j;

        /* renamed from: k  reason: collision with root package name */
        public View f146k;

        /* renamed from: l  reason: collision with root package name */
        public View f147l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q = new Rect();

        public f(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: java.lang.Class<?> */
        /* JADX WARN: Multi-variable type inference failed */
        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            c cVar;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.c = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f141f = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f139d = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f140e = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f142g = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f143h = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i2 = R$styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean hasValue = obtainStyledAttributes.hasValue(i2);
            this.b = hasValue;
            if (hasValue) {
                String string = obtainStyledAttributes.getString(i2);
                String str = CoordinatorLayout.v;
                if (TextUtils.isEmpty(string)) {
                    cVar = null;
                } else {
                    if (string.startsWith(".")) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.v;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + '.' + string;
                        }
                    }
                    try {
                        ThreadLocal<Map<String, Constructor<c>>> threadLocal = CoordinatorLayout.x;
                        Map<String, Constructor<c>> map = threadLocal.get();
                        if (map == null) {
                            map = new HashMap<>();
                            threadLocal.set(map);
                        }
                        Constructor<c> constructor = map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.w);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        cVar = constructor.newInstance(context, attributeSet);
                    } catch (Exception e2) {
                        throw new RuntimeException(f.a.a.a.a.t("Could not inflate Behavior subclass ", string), e2);
                    }
                }
                this.a = cVar;
            }
            obtainStyledAttributes.recycle();
            c cVar2 = this.a;
            if (cVar2 != null) {
                cVar2.f(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
        }

        public boolean a(int i2) {
            if (i2 == 0) {
                return this.n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.o;
        }

        public void b(c cVar) {
            c cVar2 = this.a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.i();
                }
                this.a = cVar;
                this.b = true;
                if (cVar != null) {
                    cVar.f(this);
                }
            }
        }

        public void c(int i2, boolean z) {
            if (i2 == 0) {
                this.n = z;
            } else if (i2 == 1) {
                this.o = z;
            }
        }
    }

    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.q(0);
            return true;
        }
    }

    public static class h extends e.k.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public SparseArray<Parcelable> f148d;

        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new h[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f148d = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f148d.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            SparseArray<Parcelable> sparseArray = this.f148d;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f148d.keyAt(i3);
                parcelableArr[i3] = this.f148d.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }
    }

    public static class i implements Comparator<View> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            AtomicInteger atomicInteger = m.a;
            float z = view.getZ();
            float z2 = view2.getZ();
            if (z > z2) {
                return -1;
            }
            return z < z2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        v = r0 != null ? r0.getName() : null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r5);
        int i2 = R$attr.coordinatorLayoutStyle;
        int[] iArr = R$styleable.CoordinatorLayout;
        TypedArray obtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, R$style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, R$style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f137k = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.f137k.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr2 = this.f137k;
                iArr2[i3] = (int) (((float) iArr2[i3]) * f2);
            }
        }
        this.r = obtainStyledAttributes.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        y();
        super.setOnHierarchyChangeListener(new e());
        AtomicInteger atomicInteger = m.a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect a() {
        Rect a2 = z.a();
        return a2 == null ? new Rect() : a2;
    }

    public final void b(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    public void c(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            f(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public List<View> d(View view) {
        e.h.a.a<View> aVar = this.c;
        int i2 = aVar.b.f1211d;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList<T> k2 = aVar.b.k(i3);
            if (k2 != null && k2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar.b.h(i3));
            }
        }
        this.f131e.clear();
        if (arrayList != null) {
            this.f131e.addAll(arrayList);
        }
        return this.f131e;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.a;
        if (cVar != null) {
            float c2 = cVar.c();
            if (c2 > 0.0f) {
                if (this.f132f == null) {
                    this.f132f = new Paint();
                }
                this.f132f.setColor(fVar.a.b());
                Paint paint = this.f132f;
                int round = Math.round(c2 * 255.0f);
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                paint.setAlpha(round);
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f132f);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.r;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public List<View> e(View view) {
        ArrayList<T> orDefault = this.c.b.getOrDefault(view, null);
        this.f131e.clear();
        if (orDefault != null) {
            this.f131e.addAll(orDefault);
        }
        return this.f131e;
    }

    public void f(View view, Rect rect) {
        ThreadLocal<Matrix> threadLocal = e.h.a.b.a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal<Matrix> threadLocal2 = e.h.a.b.a;
        Matrix matrix = threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        e.h.a.b.a(this, view, matrix);
        ThreadLocal<RectF> threadLocal3 = e.h.a.b.b;
        RectF rectF = threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final void g(int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int i5 = fVar.c;
        if (i5 == 0) {
            i5 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, i2);
        int i6 = fVar.f139d;
        if ((i6 & 7) == 0) {
            i6 |= 8388611;
        }
        if ((i6 & 112) == 0) {
            i6 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i6, i2);
        int i7 = absoluteGravity & 7;
        int i8 = absoluteGravity & 112;
        int i9 = absoluteGravity2 & 7;
        int i10 = absoluteGravity2 & 112;
        int width = i9 != 1 ? i9 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i10 != 16 ? i10 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i7 == 1) {
            width -= i3 / 2;
        } else if (i7 != 5) {
            width -= i3;
        }
        if (i8 == 16) {
            height -= i4 / 2;
        } else if (i8 != 80) {
            height -= i4;
        }
        rect2.set(width, height, i3 + width, i4 + height);
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        u();
        return Collections.unmodifiableList(this.b);
    }

    public final w getLastWindowInsets() {
        return this.p;
    }

    public int getNestedScrollAxes() {
        return this.u.a();
    }

    public Drawable getStatusBarBackground() {
        return this.r;
    }

    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override // e.i.i.h
    public void h(View view, View view2, int i2, int i3) {
        c cVar;
        j jVar = this.u;
        if (i3 == 1) {
            jVar.b = i2;
        } else {
            jVar.a = i2;
        }
        this.m = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            f fVar = (f) getChildAt(i4).getLayoutParams();
            if (fVar.a(i3) && (cVar = fVar.a) != null && i3 == 0) {
                cVar.s();
            }
        }
    }

    @Override // e.i.i.h
    public void i(View view, int i2) {
        j jVar = this.u;
        if (i2 == 1) {
            jVar.b = 0;
        } else {
            jVar.a = 0;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i2)) {
                c cVar = fVar.a;
                if (cVar != null) {
                    cVar.z(this, childAt, view, i2);
                }
                fVar.c(i2, false);
                fVar.p = false;
            }
        }
        this.m = null;
    }

    @Override // e.i.i.h
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        c cVar;
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i4) && (cVar = fVar.a) != null) {
                    int[] iArr2 = this.f133g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.p(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.f133g;
                    i5 = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                    int[] iArr4 = this.f133g;
                    i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z2) {
            q(1);
        }
    }

    public final int k(int i2) {
        StringBuilder sb;
        int[] iArr = this.f137k;
        if (iArr == null) {
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i2);
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i2);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e("CoordinatorLayout", sb.toString());
        return 0;
    }

    public f l(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.b(behavior);
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.b((c) dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        StringBuilder h2 = f.a.a.a.a.h("Default behavior class ");
                        h2.append(dVar.value().getName());
                        h2.append(" could not be instantiated. Did you forget a default constructor?");
                        Log.e("CoordinatorLayout", h2.toString(), e2);
                    }
                }
            }
            fVar.b = true;
        }
        return fVar;
    }

    @Override // e.i.i.i
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c cVar;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i6) && (cVar = fVar.a) != null) {
                    int[] iArr2 = this.f133g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.r(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.f133g;
                    i7 = i4 > 0 ? Math.max(i7, iArr3[0]) : Math.min(i7, iArr3[0]);
                    i8 = i5 > 0 ? Math.max(i8, this.f133g[1]) : Math.min(i8, this.f133g[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i7;
        iArr[1] = iArr[1] + i8;
        if (z2) {
            q(1);
        }
    }

    @Override // e.i.i.h
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        m(view, i2, i3, i4, i5, 0, this.f134h);
    }

    @Override // e.i.i.h
    public boolean o(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVar = fVar.a;
                if (cVar != null) {
                    boolean x2 = cVar.x(this, childAt, view, view2, i2, i3);
                    z2 |= x2;
                    fVar.c(i3, x2);
                } else {
                    fVar.c(i3, false);
                }
            }
        }
        return z2;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        v(false);
        if (this.o) {
            if (this.n == null) {
                this.n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.n);
        }
        if (this.p == null) {
            AtomicInteger atomicInteger = m.a;
            if (getFitsSystemWindows()) {
                requestApplyInsets();
            }
        }
        this.f136j = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v(false);
        if (this.o && this.n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.n);
        }
        View view = this.m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f136j = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.q && this.r != null) {
            w wVar = this.p;
            int d2 = wVar != null ? wVar.d() : 0;
            if (d2 > 0) {
                this.r.setBounds(0, 0, getWidth(), d2);
                this.r.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            v(true);
        }
        boolean t2 = t(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            v(true);
        }
        return t2;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        c cVar;
        AtomicInteger atomicInteger = m.a;
        int layoutDirection = getLayoutDirection();
        int size = this.b.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.b.get(i6);
            if (view.getVisibility() != 8 && ((cVar = ((f) view.getLayoutParams()).a) == null || !cVar.k(this, view, layoutDirection))) {
                r(view, layoutDirection);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0180, code lost:
        if (r0.l(r30, r20, r8, r21, r23, 0) == false) goto L_0x0190;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0183  */
    public void onMeasure(int i2, int i3) {
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        c cVar;
        int i11;
        f fVar;
        int i12;
        int i13;
        boolean z3;
        u();
        int childCount = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount) {
                z2 = false;
                break;
            }
            View childAt = getChildAt(i14);
            e.h.a.a<View> aVar = this.c;
            int i15 = aVar.b.f1211d;
            int i16 = 0;
            while (true) {
                if (i16 < i15) {
                    ArrayList<T> k2 = aVar.b.k(i16);
                    if (k2 != null && k2.contains(childAt)) {
                        z3 = true;
                        break;
                    }
                    i16++;
                } else {
                    z3 = false;
                    break;
                }
            }
            if (z3) {
                z2 = true;
                break;
            }
            i14++;
        }
        if (z2 != this.o) {
            if (z2) {
                if (this.f136j) {
                    if (this.n == null) {
                        this.n = new g();
                    }
                    getViewTreeObserver().addOnPreDrawListener(this.n);
                }
                this.o = true;
            } else {
                if (this.f136j && this.n != null) {
                    getViewTreeObserver().removeOnPreDrawListener(this.n);
                }
                this.o = false;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        AtomicInteger atomicInteger = m.a;
        int layoutDirection = getLayoutDirection();
        boolean z4 = layoutDirection == 1;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int i17 = paddingLeft + paddingRight;
        int i18 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z5 = this.p != null && getFitsSystemWindows();
        int size3 = this.b.size();
        int i19 = suggestedMinimumWidth;
        int i20 = suggestedMinimumHeight;
        int i21 = 0;
        int i22 = 0;
        while (i22 < size3) {
            View view = this.b.get(i22);
            if (view.getVisibility() == 8) {
                i6 = i22;
                i4 = size3;
                i5 = paddingLeft;
            } else {
                f fVar2 = (f) view.getLayoutParams();
                int i23 = fVar2.f140e;
                if (i23 < 0 || mode == 0) {
                    i7 = i21;
                } else {
                    int k3 = k(i23);
                    int i24 = fVar2.c;
                    if (i24 == 0) {
                        i24 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i24, layoutDirection) & 7;
                    i7 = i21;
                    if ((absoluteGravity == 3 && !z4) || (absoluteGravity == 5 && z4)) {
                        i8 = Math.max(0, (size - paddingRight) - k3);
                        if (z5) {
                        }
                        i10 = i2;
                        i9 = i3;
                        cVar = fVar2.a;
                        if (cVar != null) {
                        }
                        measureChildWithMargins(view, i10, i8, i9, 0);
                        int max = Math.max(i13, view.getMeasuredWidth() + i17 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                        int max2 = Math.max(i11, view.getMeasuredHeight() + i18 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                        i21 = View.combineMeasuredStates(i12, view.getMeasuredState());
                        i19 = max;
                        i20 = max2;
                    } else if ((absoluteGravity == 5 && !z4) || (absoluteGravity == 3 && z4)) {
                        i8 = Math.max(0, k3 - paddingLeft);
                        if (z5 || view.getFitsSystemWindows()) {
                            i10 = i2;
                            i9 = i3;
                        } else {
                            int c2 = this.p.c() + this.p.b();
                            int a2 = this.p.a() + this.p.d();
                            i10 = View.MeasureSpec.makeMeasureSpec(size - c2, mode);
                            i9 = View.MeasureSpec.makeMeasureSpec(size2 - a2, mode2);
                        }
                        cVar = fVar2.a;
                        if (cVar != null) {
                            fVar = fVar2;
                            i12 = i7;
                            i6 = i22;
                            i11 = i20;
                            i5 = paddingLeft;
                            i13 = i19;
                            i4 = size3;
                        } else {
                            fVar = fVar2;
                            i11 = i20;
                            i4 = size3;
                            i5 = paddingLeft;
                            i12 = i7;
                            i6 = i22;
                            i13 = i19;
                        }
                        measureChildWithMargins(view, i10, i8, i9, 0);
                        int max3 = Math.max(i13, view.getMeasuredWidth() + i17 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                        int max22 = Math.max(i11, view.getMeasuredHeight() + i18 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                        i21 = View.combineMeasuredStates(i12, view.getMeasuredState());
                        i19 = max3;
                        i20 = max22;
                    }
                }
                i8 = 0;
                if (z5) {
                }
                i10 = i2;
                i9 = i3;
                cVar = fVar2.a;
                if (cVar != null) {
                }
                measureChildWithMargins(view, i10, i8, i9, 0);
                int max32 = Math.max(i13, view.getMeasuredWidth() + i17 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                int max222 = Math.max(i11, view.getMeasuredHeight() + i18 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                i21 = View.combineMeasuredStates(i12, view.getMeasuredState());
                i19 = max32;
                i20 = max222;
            }
            i22 = i6 + 1;
            paddingLeft = i5;
            size3 = i4;
        }
        setMeasuredDimension(View.resolveSizeAndState(i19, i2, -16777216 & i21), View.resolveSizeAndState(i20, i3, i21 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        c cVar;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.a) != null) {
                    z3 |= cVar.m();
                }
            }
        }
        if (z3) {
            q(1);
        }
        return z3;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        c cVar;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.a) != null) {
                    z2 |= cVar.n(this, childAt, view, f2, f3);
                }
            }
        }
        return z2;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        j(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        m(view, i2, i3, i4, i5, 0, this.f134h);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        h(view, view2, i2, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.b);
        SparseArray<Parcelable> sparseArray = hVar.f148d;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVar = l(childAt).a;
            if (!(id == -1 || cVar == null || (parcelable2 = sparseArray.get(id)) == null)) {
                cVar.u(this, childAt, parcelable2);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable v2;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVar = ((f) childAt.getLayoutParams()).a;
            if (!(id == -1 || cVar == null || (v2 = cVar.v(this, childAt)) == null)) {
                sparseArray.append(id, v2);
            }
        }
        hVar.f148d = sparseArray;
        return hVar;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return o(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.f138l == null) {
            z3 = t(motionEvent, 1);
        } else {
            z3 = false;
        }
        c cVar = ((f) this.f138l.getLayoutParams()).a;
        if (cVar != null) {
            z2 = cVar.A(this, this.f138l, motionEvent);
            motionEvent2 = null;
            if (this.f138l != null) {
                z2 |= super.onTouchEvent(motionEvent);
            } else if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked == 1 || actionMasked == 3) {
                v(false);
            }
            return z2;
        }
        z2 = false;
        motionEvent2 = null;
        if (this.f138l != null) {
        }
        if (motionEvent2 != null) {
        }
        v(false);
        return z2;
    }

    public boolean p(View view, int i2, int i3) {
        Rect a2 = a();
        f(view, a2);
        try {
            return a2.contains(i2, i3);
        } finally {
            a2.setEmpty();
            z.b(a2);
        }
    }

    public final void q(int i2) {
        int i3;
        Rect rect;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        int width;
        int i5;
        int i6;
        int i7;
        int height;
        int i8;
        int i9;
        int i10;
        Rect rect2;
        int i11;
        int i12;
        int i13;
        f fVar;
        c cVar;
        AtomicInteger atomicInteger = m.a;
        int layoutDirection = getLayoutDirection();
        int size = this.b.size();
        Rect a2 = a();
        Rect a3 = a();
        Rect a4 = a();
        int i14 = 0;
        while (i14 < size) {
            View view = this.b.get(i14);
            f fVar2 = (f) view.getLayoutParams();
            if (i2 == 0 && view.getVisibility() == 8) {
                i4 = size;
                rect = a4;
                i3 = i14;
            } else {
                int i15 = 0;
                while (i15 < i14) {
                    if (fVar2.f147l == this.b.get(i15)) {
                        f fVar3 = (f) view.getLayoutParams();
                        if (fVar3.f146k != null) {
                            Rect a5 = a();
                            Rect a6 = a();
                            Rect a7 = a();
                            f(fVar3.f146k, a5);
                            c(view, false, a6);
                            int measuredWidth = view.getMeasuredWidth();
                            i13 = size;
                            int measuredHeight = view.getMeasuredHeight();
                            i12 = i14;
                            i11 = i15;
                            rect2 = a4;
                            fVar = fVar2;
                            g(layoutDirection, a5, a7, fVar3, measuredWidth, measuredHeight);
                            boolean z5 = (a7.left == a6.left && a7.top == a6.top) ? false : true;
                            b(fVar3, a7, measuredWidth, measuredHeight);
                            int i16 = a7.left - a6.left;
                            int i17 = a7.top - a6.top;
                            if (i16 != 0) {
                                m.l(view, i16);
                            }
                            if (i17 != 0) {
                                m.m(view, i17);
                            }
                            if (z5 && (cVar = fVar3.a) != null) {
                                cVar.g(this, view, fVar3.f146k);
                            }
                            a5.setEmpty();
                            e.i.h.b<Rect> bVar = z;
                            bVar.b(a5);
                            a6.setEmpty();
                            bVar.b(a6);
                            a7.setEmpty();
                            bVar.b(a7);
                            i15 = i11 + 1;
                            fVar2 = fVar;
                            size = i13;
                            i14 = i12;
                            a4 = rect2;
                        }
                    }
                    i11 = i15;
                    i13 = size;
                    rect2 = a4;
                    i12 = i14;
                    fVar = fVar2;
                    i15 = i11 + 1;
                    fVar2 = fVar;
                    size = i13;
                    i14 = i12;
                    a4 = rect2;
                }
                i3 = i14;
                c(view, true, a3);
                if (fVar2.f142g != 0 && !a3.isEmpty()) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(fVar2.f142g, layoutDirection);
                    int i18 = absoluteGravity & 112;
                    if (i18 == 48) {
                        a2.top = Math.max(a2.top, a3.bottom);
                    } else if (i18 == 80) {
                        a2.bottom = Math.max(a2.bottom, getHeight() - a3.top);
                    }
                    int i19 = absoluteGravity & 7;
                    if (i19 == 3) {
                        a2.left = Math.max(a2.left, a3.right);
                    } else if (i19 == 5) {
                        a2.right = Math.max(a2.right, getWidth() - a3.left);
                    }
                }
                if (fVar2.f143h != 0 && view.getVisibility() == 0) {
                    AtomicInteger atomicInteger2 = m.a;
                    if (view.isLaidOut() && view.getWidth() > 0 && view.getHeight() > 0) {
                        f fVar4 = (f) view.getLayoutParams();
                        c cVar2 = fVar4.a;
                        Rect a8 = a();
                        Rect a9 = a();
                        a9.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                        if (cVar2 == null || !cVar2.a(this, view, a8)) {
                            a8.set(a9);
                        } else if (!a9.contains(a8)) {
                            StringBuilder h2 = f.a.a.a.a.h("Rect should be within the child's bounds. Rect:");
                            h2.append(a8.toShortString());
                            h2.append(" | Bounds:");
                            h2.append(a9.toShortString());
                            throw new IllegalArgumentException(h2.toString());
                        }
                        a9.setEmpty();
                        e.i.h.b<Rect> bVar2 = z;
                        bVar2.b(a9);
                        if (!a8.isEmpty()) {
                            int absoluteGravity2 = Gravity.getAbsoluteGravity(fVar4.f143h, layoutDirection);
                            if ((absoluteGravity2 & 48) != 48 || (i9 = (a8.top - ((ViewGroup.MarginLayoutParams) fVar4).topMargin) - fVar4.f145j) >= (i10 = a2.top)) {
                                z3 = false;
                            } else {
                                x(view, i10 - i9);
                                z3 = true;
                            }
                            if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - a8.bottom) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin) + fVar4.f145j) < (i8 = a2.bottom)) {
                                x(view, height - i8);
                                z3 = true;
                            }
                            if (!z3) {
                                x(view, 0);
                            }
                            if ((absoluteGravity2 & 3) != 3 || (i6 = (a8.left - ((ViewGroup.MarginLayoutParams) fVar4).leftMargin) - fVar4.f144i) >= (i7 = a2.left)) {
                                z4 = false;
                            } else {
                                w(view, i7 - i6);
                                z4 = true;
                            }
                            if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - a8.right) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin) + fVar4.f144i) < (i5 = a2.right)) {
                                w(view, width - i5);
                                z4 = true;
                            }
                            if (!z4) {
                                w(view, 0);
                            }
                        }
                        a8.setEmpty();
                        bVar2.b(a8);
                    }
                }
                if (i2 != 2) {
                    rect = a4;
                    rect.set(((f) view.getLayoutParams()).q);
                    if (rect.equals(a3)) {
                        i4 = size;
                    } else {
                        ((f) view.getLayoutParams()).q.set(a3);
                    }
                } else {
                    rect = a4;
                }
                i4 = size;
                for (int i20 = i3 + 1; i20 < i4; i20++) {
                    View view2 = this.b.get(i20);
                    f fVar5 = (f) view2.getLayoutParams();
                    c cVar3 = fVar5.a;
                    if (cVar3 != null && cVar3.d(this, view2, view)) {
                        if (i2 != 0 || !fVar5.p) {
                            if (i2 != 2) {
                                z2 = cVar3.g(this, view2, view);
                            } else {
                                cVar3.h(this, view2, view);
                                z2 = true;
                            }
                            if (i2 == 1) {
                                fVar5.p = z2;
                            }
                        } else {
                            fVar5.p = false;
                        }
                    }
                }
            }
            i14 = i3 + 1;
            size = i4;
            a4 = rect;
        }
        a2.setEmpty();
        e.i.h.b<Rect> bVar3 = z;
        bVar3.b(a2);
        a3.setEmpty();
        bVar3.b(a3);
        a4.setEmpty();
        bVar3.b(a4);
    }

    public void r(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        View view2 = fVar.f146k;
        int i3 = 0;
        if (view2 == null && fVar.f141f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (view2 != null) {
            Rect a2 = a();
            Rect a3 = a();
            try {
                f(view2, a2);
                f fVar2 = (f) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                g(i2, a2, a3, fVar2, measuredWidth, measuredHeight);
                b(fVar2, a3, measuredWidth, measuredHeight);
                view.layout(a3.left, a3.top, a3.right, a3.bottom);
            } finally {
                a2.setEmpty();
                e.i.h.b<Rect> bVar = z;
                bVar.b(a2);
                a3.setEmpty();
                bVar.b(a3);
            }
        } else {
            int i4 = fVar.f140e;
            if (i4 >= 0) {
                f fVar3 = (f) view.getLayoutParams();
                int i5 = fVar3.c;
                if (i5 == 0) {
                    i5 = 8388661;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i5, i2);
                int i6 = absoluteGravity & 7;
                int i7 = absoluteGravity & 112;
                int width = getWidth();
                int height = getHeight();
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                if (i2 == 1) {
                    i4 = width - i4;
                }
                int k2 = k(i4) - measuredWidth2;
                if (i6 == 1) {
                    k2 += measuredWidth2 / 2;
                } else if (i6 == 5) {
                    k2 += measuredWidth2;
                }
                if (i7 == 16) {
                    i3 = 0 + (measuredHeight2 / 2);
                } else if (i7 == 80) {
                    i3 = measuredHeight2 + 0;
                }
                int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin, Math.min(k2, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin));
                int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin));
                view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
                return;
            }
            f fVar4 = (f) view.getLayoutParams();
            Rect a4 = a();
            a4.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin);
            if (this.p != null) {
                AtomicInteger atomicInteger = m.a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    a4.left = this.p.b() + a4.left;
                    a4.top = this.p.d() + a4.top;
                    a4.right -= this.p.c();
                    a4.bottom -= this.p.a();
                }
            }
            Rect a5 = a();
            int i8 = fVar4.c;
            if ((i8 & 7) == 0) {
                i8 |= 8388611;
            }
            if ((i8 & 112) == 0) {
                i8 |= 48;
            }
            Gravity.apply(i8, view.getMeasuredWidth(), view.getMeasuredHeight(), a4, a5, i2);
            view.layout(a5.left, a5.top, a5.right, a5.bottom);
            a4.setEmpty();
            e.i.h.b<Rect> bVar2 = z;
            bVar2.b(a4);
            a5.setEmpty();
            bVar2.b(a5);
        }
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        c cVar = ((f) view.getLayoutParams()).a;
        if (cVar == null || !cVar.t(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2 && !this.f135i) {
            v(false);
            this.f135i = true;
        }
    }

    public void s(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        y();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.r = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.r.setState(getDrawableState());
                }
                Drawable drawable4 = this.r;
                AtomicInteger atomicInteger = m.a;
                m.h.Z0(drawable4, getLayoutDirection());
                this.r.setVisible(getVisibility() == 0, false);
                this.r.setCallback(this);
            }
            AtomicInteger atomicInteger2 = e.i.i.m.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        Drawable drawable;
        if (i2 != 0) {
            Context context = getContext();
            Object obj = e.i.b.a.a;
            drawable = context.getDrawable(i2);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.r;
        if (drawable != null && drawable.isVisible() != z2) {
            this.r.setVisible(z2, false);
        }
    }

    public final boolean t(MotionEvent motionEvent, int i2) {
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f130d;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        Comparator<View> comparator = y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z3 = false;
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = list.get(i4);
            f fVar = (f) view.getLayoutParams();
            c cVar = fVar.a;
            boolean z5 = true;
            if (!(z3 || z4) || actionMasked == 0) {
                if (!z3 && cVar != null) {
                    if (i2 == 0) {
                        z3 = cVar.j(this, view, motionEvent);
                    } else if (i2 == 1) {
                        z3 = cVar.A(this, view, motionEvent);
                    }
                    if (z3) {
                        this.f138l = view;
                    }
                }
                c cVar2 = fVar.a;
                if (cVar2 == null) {
                    fVar.m = false;
                }
                boolean z6 = fVar.m;
                if (z6) {
                    z2 = true;
                } else {
                    z2 = (cVar2 != null && cVar2.c() > 0.0f) | z6;
                    fVar.m = z2;
                }
                if (!z2 || z6) {
                    z5 = false;
                }
                if (z2 && !z5) {
                    break;
                }
                z4 = z5;
            } else if (cVar != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    cVar.j(this, view, motionEvent2);
                } else if (i2 == 1) {
                    cVar.A(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r5 != false) goto L_0x00c2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0162 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0108  */
    public final void u() {
        boolean z2;
        c cVar;
        boolean z3;
        this.b.clear();
        e.h.a.a<View> aVar = this.c;
        int i2 = aVar.b.f1211d;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList<T> k2 = aVar.b.k(i3);
            if (k2 != null) {
                k2.clear();
                aVar.a.b(k2);
            }
        }
        aVar.b.clear();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f l2 = l(childAt);
            if (l2.f141f == -1) {
                l2.f147l = null;
                l2.f146k = null;
            } else {
                View view = l2.f146k;
                if (view != null) {
                    if (view.getId() == l2.f141f) {
                        View view2 = l2.f146k;
                        for (ViewParent parent = view2.getParent(); parent != this; parent = parent.getParent()) {
                            if (parent == null || parent == childAt) {
                                l2.f147l = null;
                                l2.f146k = null;
                            } else {
                                if (parent instanceof View) {
                                    view2 = (View) parent;
                                }
                            }
                        }
                        l2.f147l = view2;
                        z3 = true;
                    }
                    z3 = false;
                    break;
                }
                View findViewById = findViewById(l2.f141f);
                l2.f146k = findViewById;
                if (findViewById != null) {
                    if (findViewById != this) {
                        ViewParent parent2 = findViewById.getParent();
                        while (parent2 != this && parent2 != null) {
                            if (parent2 != childAt) {
                                if (parent2 instanceof View) {
                                    findViewById = (View) parent2;
                                }
                                parent2 = parent2.getParent();
                            } else if (!isInEditMode()) {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                        l2.f147l = findViewById;
                    } else if (!isInEditMode()) {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (!isInEditMode()) {
                    StringBuilder h2 = f.a.a.a.a.h("Could not find CoordinatorLayout descendant view with id ");
                    h2.append(getResources().getResourceName(l2.f141f));
                    h2.append(" to anchor view ");
                    h2.append(childAt);
                    throw new IllegalStateException(h2.toString());
                }
                l2.f147l = null;
                l2.f146k = null;
            }
            this.c.a(childAt);
            for (int i5 = 0; i5 < childCount; i5++) {
                if (i5 != i4) {
                    View childAt2 = getChildAt(i5);
                    if (childAt2 != l2.f147l) {
                        AtomicInteger atomicInteger = e.i.i.m.a;
                        int layoutDirection = getLayoutDirection();
                        int absoluteGravity = Gravity.getAbsoluteGravity(((f) childAt2.getLayoutParams()).f142g, layoutDirection);
                        if (!(absoluteGravity != 0 && (Gravity.getAbsoluteGravity(l2.f143h, layoutDirection) & absoluteGravity) == absoluteGravity) && ((cVar = l2.a) == null || !cVar.d(this, childAt, childAt2))) {
                            z2 = false;
                            if (!z2) {
                                continue;
                            } else {
                                if (!(this.c.b.e(childAt2) >= 0)) {
                                    this.c.a(childAt2);
                                }
                                e.h.a.a<View> aVar2 = this.c;
                                if (aVar2.b.e(childAt2) >= 0) {
                                    if (aVar2.b.e(childAt) >= 0) {
                                        ArrayList<T> orDefault = aVar2.b.getOrDefault(childAt2, null);
                                        if (orDefault == null) {
                                            orDefault = aVar2.a.a();
                                            if (orDefault == null) {
                                                orDefault = new ArrayList<>();
                                            }
                                            aVar2.b.put(childAt2, orDefault);
                                        }
                                        orDefault.add(childAt);
                                    }
                                }
                                throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                            }
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                }
            }
        }
        List<View> list = this.b;
        e.h.a.a<View> aVar3 = this.c;
        aVar3.c.clear();
        aVar3.f1396d.clear();
        int i6 = aVar3.b.f1211d;
        for (int i7 = 0; i7 < i6; i7++) {
            aVar3.b(aVar3.b.h(i7), aVar3.c, aVar3.f1396d);
        }
        list.addAll(aVar3.c);
        Collections.reverse(this.b);
    }

    public final void v(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c cVar = ((f) childAt.getLayoutParams()).a;
            if (cVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    cVar.j(this, childAt, obtain);
                } else {
                    cVar.A(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).m = false;
        }
        this.f138l = null;
        this.f135i = false;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    public final void w(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f144i;
        if (i3 != i2) {
            e.i.i.m.l(view, i2 - i3);
            fVar.f144i = i2;
        }
    }

    public final void x(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f145j;
        if (i3 != i2) {
            e.i.i.m.m(view, i2 - i3);
            fVar.f145j = i2;
        }
    }

    public final void y() {
        AtomicInteger atomicInteger = e.i.i.m.a;
        if (getFitsSystemWindows()) {
            if (this.t == null) {
                this.t = new a();
            }
            e.i.i.m.s(this, this.t);
            setSystemUiVisibility(1280);
            return;
        }
        e.i.i.m.s(this, null);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }
}
