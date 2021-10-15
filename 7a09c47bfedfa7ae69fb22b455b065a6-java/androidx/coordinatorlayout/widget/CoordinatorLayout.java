package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import b.i.l.j;
import b.i.l.m;
import b.i.l.v;
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

public class CoordinatorLayout extends ViewGroup implements b.i.l.g, b.i.l.h {
    public static final String v;
    public static final Class<?>[] w = {Context.class, AttributeSet.class};
    public static final ThreadLocal<Map<String, Constructor<c>>> x = new ThreadLocal<>();
    public static final Comparator<View> y = new i();
    public static final b.i.k.b<Rect> z = new b.i.k.c(12);

    /* renamed from: b  reason: collision with root package name */
    public final List<View> f178b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final b.h.d.a<View> f179c = new b.h.d.a<>();

    /* renamed from: d  reason: collision with root package name */
    public final List<View> f180d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final List<View> f181e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Paint f182f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f183g = new int[2];
    public final int[] h = new int[2];
    public boolean i;
    public boolean j;
    public int[] k;
    public View l;
    public View m;
    public g n;
    public boolean o;
    public v p;
    public boolean q;
    public Drawable r;
    public ViewGroup.OnHierarchyChangeListener s;
    public j t;
    public final b.i.l.i u = new b.i.l.i();

    public class a implements j {
        public a() {
        }

        @Override // b.i.l.j
        public v a(View view, v vVar) {
            c cVar;
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (!Objects.equals(coordinatorLayout.p, vVar)) {
                coordinatorLayout.p = vVar;
                boolean z = true;
                boolean z2 = vVar.d() > 0;
                coordinatorLayout.q = z2;
                if (z2 || coordinatorLayout.getBackground() != null) {
                    z = false;
                }
                coordinatorLayout.setWillNotDraw(z);
                if (!vVar.g()) {
                    int childCount = coordinatorLayout.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = coordinatorLayout.getChildAt(i);
                        if (m.m(childAt) && (cVar = ((f) childAt.getLayoutParams()).f186a) != null) {
                            vVar = cVar.e(vVar);
                            if (vVar.g()) {
                                break;
                            }
                        }
                    }
                }
                coordinatorLayout.requestLayout();
            }
            return vVar;
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

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Lb/i/l/v;)Lb/i/l/v; */
        public v e(v vVar) {
            return vVar;
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

        public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
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

        public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                o();
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;IIII)V */
        @Deprecated
        public void q() {
        }

        public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            if (i5 == 0) {
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

        public boolean x(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return w();
            }
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;)V */
        @Deprecated
        public void y() {
        }

        public void z(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
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
            CoordinatorLayout.this.p(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public c f186a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f187b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f188c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f189d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f190e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f191f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f192g = 0;
        public int h = 0;
        public int i;
        public int j;
        public View k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q = new Rect();

        public f(int i2, int i3) {
            super(i2, i3);
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.h.c.CoordinatorLayout_Layout);
            this.f188c = obtainStyledAttributes.getInteger(b.h.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f191f = obtainStyledAttributes.getResourceId(b.h.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f189d = obtainStyledAttributes.getInteger(b.h.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f190e = obtainStyledAttributes.getInteger(b.h.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f192g = obtainStyledAttributes.getInt(b.h.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = obtainStyledAttributes.getInt(b.h.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(b.h.c.CoordinatorLayout_Layout_layout_behavior);
            this.f187b = hasValue;
            if (hasValue) {
                this.f186a = CoordinatorLayout.s(context, attributeSet, obtainStyledAttributes.getString(b.h.c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.f186a;
            if (cVar != null) {
                cVar.f(this);
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
            c cVar2 = this.f186a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.i();
                }
                this.f186a = cVar;
                this.f187b = true;
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
            CoordinatorLayout.this.p(0);
            return true;
        }
    }

    public static class h extends b.k.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public SparseArray<Parcelable> f194d;

        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new h[i];
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
            this.f194d = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f194d.append(iArr[i], readParcelableArray[i]);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1952b, i);
            SparseArray<Parcelable> sparseArray = this.f194d;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f194d.keyAt(i2);
                parcelableArr[i2] = this.f194d.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    public static class i implements Comparator<View> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            float x = m.x(view);
            float z = view2.getZ();
            if (x > z) {
                return -1;
            }
            return x < z ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        v = r0 != null ? r0.getName() : null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r5);
        int i2 = b.h.a.coordinatorLayoutStyle;
        int[] iArr = b.h.c.CoordinatorLayout;
        TypedArray obtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, b.h.b.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            int[] iArr2 = b.h.c.CoordinatorLayout;
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, 0, b.h.b.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(b.h.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.k = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.k.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr3 = this.k;
                iArr3[i3] = (int) (((float) iArr3[i3]) * f2);
            }
        }
        this.r = obtainStyledAttributes.getDrawable(b.h.c.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        y();
        super.setOnHierarchyChangeListener(new e());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect a() {
        Rect a2 = z.a();
        return a2 == null ? new Rect() : a2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public static c s(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(v)) {
            str = v + '.' + str;
        }
        try {
            Map<String, Constructor<c>> map = x.get();
            if (map == null) {
                map = new HashMap<>();
                x.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(w);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException(c.a.a.a.a.q("Could not inflate Behavior subclass ", str), e2);
        }
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
            b.h.d.b.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public List<View> d(View view) {
        b.h.d.a<View> aVar = this.f179c;
        int i2 = aVar.f1642b.f1413d;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList<T> k2 = aVar.f1642b.k(i3);
            if (k2 != null && k2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar.f1642b.h(i3));
            }
        }
        this.f181e.clear();
        if (arrayList != null) {
            this.f181e.addAll(arrayList);
        }
        return this.f181e;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f186a;
        if (cVar != null) {
            float c2 = cVar.c();
            if (c2 > 0.0f) {
                if (this.f182f == null) {
                    this.f182f = new Paint();
                }
                this.f182f.setColor(fVar.f186a.b());
                Paint paint = this.f182f;
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
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f182f);
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
        ArrayList<T> orDefault = this.f179c.f1642b.getOrDefault(view, null);
        this.f181e.clear();
        if (orDefault != null) {
            this.f181e.addAll(orDefault);
        }
        return this.f181e;
    }

    public final void f(int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int i5 = fVar.f188c;
        if (i5 == 0) {
            i5 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, i2);
        int i6 = fVar.f189d;
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

    public final int g(int i2) {
        StringBuilder sb;
        int[] iArr = this.k;
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
        sb.toString();
        return 0;
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
        return Collections.unmodifiableList(this.f178b);
    }

    public final v getLastWindowInsets() {
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

    @Override // b.i.l.g
    public void h(View view, View view2, int i2, int i3) {
        c cVar;
        b.i.l.i iVar = this.u;
        if (i3 == 1) {
            iVar.f1862b = i2;
        } else {
            iVar.f1861a = i2;
        }
        this.m = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            f fVar = (f) getChildAt(i4).getLayoutParams();
            if (fVar.a(i3) && (cVar = fVar.f186a) != null && i3 == 0) {
                cVar.s();
            }
        }
    }

    @Override // b.i.l.g
    public void i(View view, int i2) {
        b.i.l.i iVar = this.u;
        if (i2 == 1) {
            iVar.f1862b = 0;
        } else {
            iVar.f1861a = 0;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i2)) {
                c cVar = fVar.f186a;
                if (cVar != null) {
                    cVar.z(this, childAt, view, i2);
                }
                fVar.c(i2, false);
                fVar.p = false;
            }
        }
        this.m = null;
    }

    @Override // b.i.l.g
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
                if (fVar.a(i4) && (cVar = fVar.f186a) != null) {
                    int[] iArr2 = this.f183g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.p(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.f183g;
                    i5 = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                    int[] iArr4 = this.f183g;
                    i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z2) {
            p(1);
        }
    }

    public f k(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f187b) {
            if (view instanceof b) {
                fVar.b(((b) view).getBehavior());
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
                    } catch (Exception unused) {
                        dVar.value().getName();
                    }
                }
            }
            fVar.f187b = true;
        }
        return fVar;
    }

    public boolean l(View view, int i2, int i3) {
        Rect a2 = a();
        b.h.d.b.a(this, view, a2);
        try {
            return a2.contains(i2, i3);
        } finally {
            a2.setEmpty();
            z.b(a2);
        }
    }

    @Override // b.i.l.h
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c cVar;
        boolean z2;
        int i7;
        int childCount = getChildCount();
        boolean z3 = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i6) && (cVar = fVar.f186a) != null) {
                    int[] iArr2 = this.f183g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.r(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.f183g;
                    i8 = i4 > 0 ? Math.max(i8, iArr3[0]) : Math.min(i8, iArr3[0]);
                    if (i5 > 0) {
                        z2 = true;
                        i7 = Math.max(i9, this.f183g[1]);
                    } else {
                        z2 = true;
                        i7 = Math.min(i9, this.f183g[1]);
                    }
                    i9 = i7;
                    z3 = z2;
                }
            }
        }
        iArr[0] = iArr[0] + i8;
        iArr[1] = iArr[1] + i9;
        if (z3) {
            p(1);
        }
    }

    @Override // b.i.l.g
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        m(view, i2, i3, i4, i5, 0, this.h);
    }

    @Override // b.i.l.g
    public boolean o(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVar = fVar.f186a;
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
        if (this.p == null && m.m(this)) {
            requestApplyInsets();
        }
        this.j = true;
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
        this.j = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.q && this.r != null) {
            v vVar = this.p;
            int d2 = vVar != null ? vVar.d() : 0;
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
        int p2 = m.p(this);
        int size = this.f178b.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f178b.get(i6);
            if (view.getVisibility() != 8 && ((cVar = ((f) view.getLayoutParams()).f186a) == null || !cVar.k(this, view, p2))) {
                q(view, p2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x017e, code lost:
        if (r0.l(r30, r20, r8, r21, r23, 0) == false) goto L_0x018e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0181  */
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
        int i15 = 0;
        while (true) {
            if (i15 >= childCount) {
                z2 = false;
                break;
            }
            View childAt = getChildAt(i15);
            b.h.d.a<View> aVar = this.f179c;
            int i16 = aVar.f1642b.f1413d;
            int i17 = 0;
            while (true) {
                if (i17 < i16) {
                    ArrayList<T> k2 = aVar.f1642b.k(i17);
                    if (k2 != null && k2.contains(childAt)) {
                        z3 = true;
                        break;
                    }
                    i17++;
                } else {
                    z3 = false;
                    break;
                }
            }
            if (z3) {
                z2 = true;
                break;
            }
            i15++;
        }
        if (z2 != this.o) {
            if (z2) {
                if (this.j) {
                    if (this.n == null) {
                        this.n = new g();
                    }
                    getViewTreeObserver().addOnPreDrawListener(this.n);
                }
                this.o = true;
            } else {
                if (this.j && this.n != null) {
                    getViewTreeObserver().removeOnPreDrawListener(this.n);
                }
                this.o = false;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int p2 = m.p(this);
        boolean z4 = p2 == 1;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int i18 = paddingLeft + paddingRight;
        int i19 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z5 = this.p != null && getFitsSystemWindows();
        int size3 = this.f178b.size();
        int i20 = suggestedMinimumWidth;
        int i21 = suggestedMinimumHeight;
        int i22 = 0;
        int i23 = 0;
        while (i23 < size3) {
            View view = this.f178b.get(i23);
            if (view.getVisibility() == 8) {
                i6 = i23;
                i4 = size3;
                i5 = paddingLeft;
            } else {
                f fVar2 = (f) view.getLayoutParams();
                int i24 = fVar2.f190e;
                if (i24 < 0 || mode == 0) {
                    i7 = i22;
                } else {
                    int g2 = g(i24);
                    int i25 = fVar2.f188c;
                    if (i25 == 0) {
                        i25 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i25, p2) & 7;
                    i7 = i22;
                    if ((absoluteGravity == 3 && !z4) || (absoluteGravity == 5 && z4)) {
                        i8 = Math.max(0, (size - paddingRight) - g2);
                        if (z5) {
                        }
                        i10 = i2;
                        i9 = i3;
                        cVar = fVar2.f186a;
                        if (cVar != null) {
                        }
                        measureChildWithMargins(view, i10, i8, i9, 0);
                        int max = Math.max(i13, view.getMeasuredWidth() + i18 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                        int max2 = Math.max(i11, view.getMeasuredHeight() + i19 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                        i22 = View.combineMeasuredStates(i12, view.getMeasuredState());
                        i20 = max;
                        i21 = max2;
                    } else if ((absoluteGravity != 5 || z4) && (absoluteGravity != 3 || !z4)) {
                        i14 = 0;
                    } else {
                        i8 = Math.max(0, g2 - paddingLeft);
                        if (z5 || view.getFitsSystemWindows()) {
                            i10 = i2;
                            i9 = i3;
                        } else {
                            int c2 = this.p.c() + this.p.b();
                            int a2 = this.p.a() + this.p.d();
                            i10 = View.MeasureSpec.makeMeasureSpec(size - c2, mode);
                            i9 = View.MeasureSpec.makeMeasureSpec(size2 - a2, mode2);
                        }
                        cVar = fVar2.f186a;
                        if (cVar != null) {
                            fVar = fVar2;
                            i12 = i7;
                            i6 = i23;
                            i11 = i21;
                            i5 = paddingLeft;
                            i13 = i20;
                            i4 = size3;
                        } else {
                            fVar = fVar2;
                            i11 = i21;
                            i4 = size3;
                            i5 = paddingLeft;
                            i12 = i7;
                            i6 = i23;
                            i13 = i20;
                        }
                        measureChildWithMargins(view, i10, i8, i9, 0);
                        int max3 = Math.max(i13, view.getMeasuredWidth() + i18 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                        int max22 = Math.max(i11, view.getMeasuredHeight() + i19 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                        i22 = View.combineMeasuredStates(i12, view.getMeasuredState());
                        i20 = max3;
                        i21 = max22;
                    }
                }
                i8 = i14;
                if (z5) {
                }
                i10 = i2;
                i9 = i3;
                cVar = fVar2.f186a;
                if (cVar != null) {
                }
                measureChildWithMargins(view, i10, i8, i9, 0);
                int max32 = Math.max(i13, view.getMeasuredWidth() + i18 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                int max222 = Math.max(i11, view.getMeasuredHeight() + i19 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                i22 = View.combineMeasuredStates(i12, view.getMeasuredState());
                i20 = max32;
                i21 = max222;
            }
            i23 = i6 + 1;
            paddingLeft = i5;
            size3 = i4;
            i14 = 0;
        }
        setMeasuredDimension(View.resolveSizeAndState(i20, i2, -16777216 & i22), View.resolveSizeAndState(i21, i3, i22 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        c cVar;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.f186a) != null) {
                    z3 |= cVar.m();
                }
            }
        }
        if (z3) {
            p(1);
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
                if (fVar.a(0) && (cVar = fVar.f186a) != null) {
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
        m(view, i2, i3, i4, i5, 0, this.h);
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
        super.onRestoreInstanceState(hVar.f1952b);
        SparseArray<Parcelable> sparseArray = hVar.f194d;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVar = k(childAt).f186a;
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
            c cVar = ((f) childAt.getLayoutParams()).f186a;
            if (!(id == -1 || cVar == null || (v2 = cVar.v(this, childAt)) == null)) {
                sparseArray.append(id, v2);
            }
        }
        hVar.f194d = sparseArray;
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
        if (this.l == null) {
            z3 = t(motionEvent, 1);
        } else {
            z3 = false;
        }
        c cVar = ((f) this.l.getLayoutParams()).f186a;
        if (cVar != null) {
            z2 = cVar.A(this, this.l, motionEvent);
            motionEvent2 = null;
            if (this.l != null) {
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
        if (this.l != null) {
        }
        if (motionEvent2 != null) {
        }
        v(false);
        return z2;
    }

    public final void p(int i2) {
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
        int p2 = m.p(this);
        int size = this.f178b.size();
        Rect a2 = a();
        Rect a3 = a();
        Rect a4 = a();
        int i14 = 0;
        while (i14 < size) {
            View view = this.f178b.get(i14);
            f fVar2 = (f) view.getLayoutParams();
            if (i2 == 0 && view.getVisibility() == 8) {
                i4 = size;
                rect = a4;
                i3 = i14;
            } else {
                int i15 = 0;
                while (i15 < i14) {
                    if (fVar2.l == this.f178b.get(i15)) {
                        f fVar3 = (f) view.getLayoutParams();
                        if (fVar3.k != null) {
                            Rect a5 = a();
                            Rect a6 = a();
                            Rect a7 = a();
                            b.h.d.b.a(this, fVar3.k, a5);
                            c(view, false, a6);
                            int measuredWidth = view.getMeasuredWidth();
                            i13 = size;
                            int measuredHeight = view.getMeasuredHeight();
                            i12 = i14;
                            i11 = i15;
                            rect2 = a4;
                            fVar = fVar2;
                            f(p2, a5, a7, fVar3, measuredWidth, measuredHeight);
                            boolean z5 = (a7.left == a6.left && a7.top == a6.top) ? false : true;
                            b(fVar3, a7, measuredWidth, measuredHeight);
                            int i16 = a7.left - a6.left;
                            int i17 = a7.top - a6.top;
                            if (i16 != 0) {
                                view.offsetLeftAndRight(i16);
                            }
                            if (i17 != 0) {
                                view.offsetTopAndBottom(i17);
                            }
                            if (z5 && (cVar = fVar3.f186a) != null) {
                                cVar.g(this, view, fVar3.k);
                            }
                            a5.setEmpty();
                            z.b(a5);
                            a6.setEmpty();
                            z.b(a6);
                            a7.setEmpty();
                            z.b(a7);
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
                if (fVar2.f192g != 0 && !a3.isEmpty()) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(fVar2.f192g, p2);
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
                if (fVar2.h != 0 && view.getVisibility() == 0 && view.isLaidOut() && view.getWidth() > 0 && view.getHeight() > 0) {
                    f fVar4 = (f) view.getLayoutParams();
                    c cVar2 = fVar4.f186a;
                    Rect a8 = a();
                    Rect a9 = a();
                    a9.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    if (cVar2 == null || !cVar2.a(this, view, a8)) {
                        a8.set(a9);
                    } else if (!a9.contains(a8)) {
                        StringBuilder h2 = c.a.a.a.a.h("Rect should be within the child's bounds. Rect:");
                        h2.append(a8.toShortString());
                        h2.append(" | Bounds:");
                        h2.append(a9.toShortString());
                        throw new IllegalArgumentException(h2.toString());
                    }
                    a9.setEmpty();
                    z.b(a9);
                    if (!a8.isEmpty()) {
                        int absoluteGravity2 = Gravity.getAbsoluteGravity(fVar4.h, p2);
                        if ((absoluteGravity2 & 48) != 48 || (i9 = (a8.top - ((ViewGroup.MarginLayoutParams) fVar4).topMargin) - fVar4.j) >= (i10 = a2.top)) {
                            z3 = false;
                        } else {
                            x(view, i10 - i9);
                            z3 = true;
                        }
                        if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - a8.bottom) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin) + fVar4.j) < (i8 = a2.bottom)) {
                            x(view, height - i8);
                            z3 = true;
                        }
                        if (!z3) {
                            x(view, 0);
                        }
                        if ((absoluteGravity2 & 3) != 3 || (i6 = (a8.left - ((ViewGroup.MarginLayoutParams) fVar4).leftMargin) - fVar4.i) >= (i7 = a2.left)) {
                            z4 = false;
                        } else {
                            w(view, i7 - i6);
                            z4 = true;
                        }
                        if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - a8.right) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin) + fVar4.i) < (i5 = a2.right)) {
                            w(view, width - i5);
                            z4 = true;
                        }
                        if (!z4) {
                            w(view, 0);
                        }
                    }
                    a8.setEmpty();
                    z.b(a8);
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
                    View view2 = this.f178b.get(i20);
                    f fVar5 = (f) view2.getLayoutParams();
                    c cVar3 = fVar5.f186a;
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
        z.b(a2);
        a3.setEmpty();
        z.b(a3);
        a4.setEmpty();
        z.b(a4);
    }

    public void q(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = 0;
        if (!(fVar.k == null && fVar.f191f != -1)) {
            View view2 = fVar.k;
            if (view2 != null) {
                Rect a2 = a();
                Rect a3 = a();
                try {
                    b.h.d.b.a(this, view2, a2);
                    f fVar2 = (f) view.getLayoutParams();
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    f(i2, a2, a3, fVar2, measuredWidth, measuredHeight);
                    b(fVar2, a3, measuredWidth, measuredHeight);
                    view.layout(a3.left, a3.top, a3.right, a3.bottom);
                } finally {
                    a2.setEmpty();
                    z.b(a2);
                    a3.setEmpty();
                    z.b(a3);
                }
            } else {
                int i4 = fVar.f190e;
                if (i4 >= 0) {
                    f fVar3 = (f) view.getLayoutParams();
                    int i5 = fVar3.f188c;
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
                    int g2 = g(i4) - measuredWidth2;
                    if (i6 == 1) {
                        g2 += measuredWidth2 / 2;
                    } else if (i6 == 5) {
                        g2 += measuredWidth2;
                    }
                    if (i7 == 16) {
                        i3 = 0 + (measuredHeight2 / 2);
                    } else if (i7 == 80) {
                        i3 = measuredHeight2 + 0;
                    }
                    int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin, Math.min(g2, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin));
                    int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin));
                    view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
                    return;
                }
                f fVar4 = (f) view.getLayoutParams();
                Rect a4 = a();
                a4.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin);
                if (this.p != null && m.m(this) && !view.getFitsSystemWindows()) {
                    a4.left = this.p.b() + a4.left;
                    a4.top = this.p.d() + a4.top;
                    a4.right -= this.p.c();
                    a4.bottom -= this.p.a();
                }
                Rect a5 = a();
                int i8 = fVar4.f188c;
                if ((i8 & 7) == 0) {
                    i8 |= 8388611;
                }
                if ((i8 & 112) == 0) {
                    i8 |= 48;
                }
                Gravity.apply(i8, view.getMeasuredWidth(), view.getMeasuredHeight(), a4, a5, i2);
                view.layout(a5.left, a5.top, a5.right, a5.bottom);
                a4.setEmpty();
                z.b(a4);
                a5.setEmpty();
                z.b(a5);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    public void r(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        c cVar = ((f) view.getLayoutParams()).f186a;
        if (cVar == null || !cVar.t(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2 && !this.i) {
            v(false);
            this.i = true;
        }
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
                this.r.setLayoutDirection(m.p(this));
                this.r.setVisible(getVisibility() == 0, false);
                this.r.setCallback(this);
            }
            m.M(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? b.i.e.a.c(getContext(), i2) : null);
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
        List<View> list = this.f180d;
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
            c cVar = fVar.f186a;
            if (!(z3 || z4) || actionMasked == 0) {
                if (!z3 && cVar != null) {
                    if (i2 == 0) {
                        z3 = cVar.j(this, view, motionEvent);
                    } else if (i2 == 1) {
                        z3 = cVar.A(this, view, motionEvent);
                    }
                    if (z3) {
                        this.l = view;
                    }
                }
                if (fVar.f186a == null) {
                    fVar.m = false;
                }
                boolean z5 = fVar.m;
                if (z5) {
                    z2 = true;
                } else {
                    c cVar2 = fVar.f186a;
                    z2 = (cVar2 != null && cVar2.c() > 0.0f) | z5;
                    fVar.m = z2;
                }
                z4 = z2 && !z5;
                if (z2 && !z4) {
                    break;
                }
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

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        if (r5 != false) goto L_0x00c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0161 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0107  */
    public final void u() {
        boolean z2;
        c cVar;
        boolean z3;
        this.f178b.clear();
        b.h.d.a<View> aVar = this.f179c;
        int i2 = aVar.f1642b.f1413d;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList<T> k2 = aVar.f1642b.k(i3);
            if (k2 != null) {
                k2.clear();
                aVar.f1641a.b(k2);
            }
        }
        aVar.f1642b.clear();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f k3 = k(childAt);
            if (k3.f191f == -1) {
                k3.l = null;
                k3.k = null;
            } else {
                View view = k3.k;
                if (view != null) {
                    if (view.getId() == k3.f191f) {
                        View view2 = k3.k;
                        for (ViewParent parent = view2.getParent(); parent != this; parent = parent.getParent()) {
                            if (parent == null || parent == childAt) {
                                k3.l = null;
                                k3.k = null;
                            } else {
                                if (parent instanceof View) {
                                    view2 = (View) parent;
                                }
                            }
                        }
                        k3.l = view2;
                        z3 = true;
                    }
                    z3 = false;
                    break;
                }
                View findViewById = findViewById(k3.f191f);
                k3.k = findViewById;
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
                        k3.l = findViewById;
                    } else if (!isInEditMode()) {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (!isInEditMode()) {
                    StringBuilder h2 = c.a.a.a.a.h("Could not find CoordinatorLayout descendant view with id ");
                    h2.append(getResources().getResourceName(k3.f191f));
                    h2.append(" to anchor view ");
                    h2.append(childAt);
                    throw new IllegalStateException(h2.toString());
                }
                k3.l = null;
                k3.k = null;
            }
            this.f179c.a(childAt);
            for (int i5 = 0; i5 < childCount; i5++) {
                if (i5 != i4) {
                    View childAt2 = getChildAt(i5);
                    if (childAt2 != k3.l) {
                        int p2 = m.p(this);
                        int absoluteGravity = Gravity.getAbsoluteGravity(((f) childAt2.getLayoutParams()).f192g, p2);
                        if (!(absoluteGravity != 0 && (Gravity.getAbsoluteGravity(k3.h, p2) & absoluteGravity) == absoluteGravity) && ((cVar = k3.f186a) == null || !cVar.d(this, childAt, childAt2))) {
                            z2 = false;
                            if (!z2) {
                                continue;
                            } else {
                                if (!(this.f179c.f1642b.e(childAt2) >= 0)) {
                                    this.f179c.a(childAt2);
                                }
                                b.h.d.a<View> aVar2 = this.f179c;
                                if (aVar2.f1642b.e(childAt2) >= 0) {
                                    if (aVar2.f1642b.e(childAt) >= 0) {
                                        ArrayList<T> orDefault = aVar2.f1642b.getOrDefault(childAt2, null);
                                        if (orDefault == null) {
                                            orDefault = aVar2.f1641a.a();
                                            if (orDefault == null) {
                                                orDefault = new ArrayList<>();
                                            }
                                            aVar2.f1642b.put(childAt2, orDefault);
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
        List<View> list = this.f178b;
        b.h.d.a<View> aVar3 = this.f179c;
        aVar3.f1643c.clear();
        aVar3.f1644d.clear();
        int i6 = aVar3.f1642b.f1413d;
        for (int i7 = 0; i7 < i6; i7++) {
            aVar3.b(aVar3.f1642b.h(i7), aVar3.f1643c, aVar3.f1644d);
        }
        list.addAll(aVar3.f1643c);
        Collections.reverse(this.f178b);
    }

    public final void v(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c cVar = ((f) childAt.getLayoutParams()).f186a;
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
        this.l = null;
        this.i = false;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    public final void w(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.i;
        if (i3 != i2) {
            m.H(view, i2 - i3);
            fVar.i = i2;
        }
    }

    public final void x(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.j;
        if (i3 != i2) {
            m.I(view, i2 - i3);
            fVar.j = i2;
        }
    }

    public final void y() {
        if (m.m(this)) {
            if (this.t == null) {
                this.t = new a();
            }
            m.c0(this, this.t);
            setSystemUiVisibility(1280);
            return;
        }
        m.c0(this, null);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }
}
