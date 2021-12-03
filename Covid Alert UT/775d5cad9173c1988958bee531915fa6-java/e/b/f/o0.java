package e.b.f;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import e.b.a.m;
import e.b.e.i.p;
import e.i.i.v;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class o0 implements p {
    public static Method B;
    public static Method C;
    public static Method D;
    public PopupWindow A;
    public Context b;
    public ListAdapter c;

    /* renamed from: d  reason: collision with root package name */
    public j0 f940d;

    /* renamed from: e  reason: collision with root package name */
    public int f941e = -2;

    /* renamed from: f  reason: collision with root package name */
    public int f942f = -2;

    /* renamed from: g  reason: collision with root package name */
    public int f943g;

    /* renamed from: h  reason: collision with root package name */
    public int f944h;

    /* renamed from: i  reason: collision with root package name */
    public int f945i = 1002;

    /* renamed from: j  reason: collision with root package name */
    public boolean f946j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f947k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f948l;
    public int m = 0;
    public int n = Integer.MAX_VALUE;
    public int o = 0;
    public DataSetObserver p;
    public View q;
    public AdapterView.OnItemClickListener r;
    public final e s = new e();
    public final d t = new d();
    public final c u = new c();
    public final a v = new a();
    public final Handler w;
    public final Rect x = new Rect();
    public Rect y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            j0 j0Var = o0.this.f940d;
            if (j0Var != null) {
                j0Var.setListSelectionHidden(true);
                j0Var.requestLayout();
            }
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            if (o0.this.c()) {
                o0.this.a();
            }
        }

        public void onInvalidated() {
            o0.this.dismiss();
        }
    }

    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            boolean z = true;
            if (i2 == 1) {
                if (o0.this.A.getInputMethodMode() != 2) {
                    z = false;
                }
                if (!z && o0.this.A.getContentView() != null) {
                    o0 o0Var = o0.this;
                    o0Var.w.removeCallbacks(o0Var.s);
                    o0.this.s.run();
                }
            }
        }
    }

    public class d implements View.OnTouchListener {
        public d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = o0.this.A) != null && popupWindow.isShowing() && x >= 0 && x < o0.this.A.getWidth() && y >= 0 && y < o0.this.A.getHeight()) {
                o0 o0Var = o0.this;
                o0Var.w.postDelayed(o0Var.s, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                o0 o0Var2 = o0.this;
                o0Var2.w.removeCallbacks(o0Var2.s);
                return false;
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            j0 j0Var = o0.this.f940d;
            if (j0Var != null) {
                AtomicInteger atomicInteger = v.a;
                if (v.g.b(j0Var) && o0.this.f940d.getCount() > o0.this.f940d.getChildCount()) {
                    int childCount = o0.this.f940d.getChildCount();
                    o0 o0Var = o0.this;
                    if (childCount <= o0Var.n) {
                        o0Var.A.setInputMethodMode(2);
                        o0.this.a();
                    }
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                B = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                D = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                C = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public o0(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.b = context;
        this.w = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i2, i3);
        this.f943g = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f944h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f946j = true;
        }
        obtainStyledAttributes.recycle();
        s sVar = new s(context, attributeSet, i2, i3);
        this.A = sVar;
        sVar.setInputMethodMode(1);
    }

    @Override // e.b.e.i.p
    public void a() {
        int i2;
        int i3;
        int i4;
        j0 j0Var;
        int i5;
        if (this.f940d == null) {
            j0 q2 = q(this.b, !this.z);
            this.f940d = q2;
            q2.setAdapter(this.c);
            this.f940d.setOnItemClickListener(this.r);
            this.f940d.setFocusable(true);
            this.f940d.setFocusableInTouchMode(true);
            this.f940d.setOnItemSelectedListener(new n0(this));
            this.f940d.setOnScrollListener(this.u);
            this.A.setContentView(this.f940d);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.A.getContentView();
        }
        Drawable background = this.A.getBackground();
        int i6 = 0;
        if (background != null) {
            background.getPadding(this.x);
            Rect rect = this.x;
            int i7 = rect.top;
            i2 = rect.bottom + i7;
            if (!this.f946j) {
                this.f944h = -i7;
            }
        } else {
            this.x.setEmpty();
            i2 = 0;
        }
        boolean z2 = this.A.getInputMethodMode() == 2;
        View view = this.q;
        int i8 = this.f944h;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = C;
            if (method != null) {
                try {
                    i3 = ((Integer) method.invoke(this.A, view, Integer.valueOf(i8), Boolean.valueOf(z2))).intValue();
                } catch (Exception unused) {
                }
            }
            i3 = this.A.getMaxAvailableHeight(view, i8);
        } else {
            i3 = this.A.getMaxAvailableHeight(view, i8, z2);
        }
        if (this.f941e == -1) {
            i4 = i3 + i2;
        } else {
            int i9 = this.f942f;
            if (i9 != -2) {
                i5 = 1073741824;
                if (i9 == -1) {
                    int i10 = this.b.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.x;
                    i9 = i10 - (rect2.left + rect2.right);
                }
            } else {
                int i11 = this.b.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.x;
                i9 = i11 - (rect3.left + rect3.right);
                i5 = Integer.MIN_VALUE;
            }
            int a2 = this.f940d.a(View.MeasureSpec.makeMeasureSpec(i9, i5), i3 - 0, -1);
            i4 = a2 + (a2 > 0 ? this.f940d.getPaddingBottom() + this.f940d.getPaddingTop() + i2 + 0 : 0);
        }
        boolean z3 = this.A.getInputMethodMode() == 2;
        m.e.A1(this.A, this.f945i);
        if (this.A.isShowing()) {
            View view2 = this.q;
            AtomicInteger atomicInteger = v.a;
            if (v.g.b(view2)) {
                int i12 = this.f942f;
                if (i12 == -1) {
                    i12 = -1;
                } else if (i12 == -2) {
                    i12 = this.q.getWidth();
                }
                int i13 = this.f941e;
                if (i13 == -1) {
                    if (!z3) {
                        i4 = -1;
                    }
                    if (z3) {
                        this.A.setWidth(this.f942f == -1 ? -1 : 0);
                        this.A.setHeight(0);
                    } else {
                        PopupWindow popupWindow = this.A;
                        if (this.f942f == -1) {
                            i6 = -1;
                        }
                        popupWindow.setWidth(i6);
                        this.A.setHeight(-1);
                    }
                } else if (i13 != -2) {
                    i4 = i13;
                }
                this.A.setOutsideTouchable(true);
                this.A.update(this.q, this.f943g, this.f944h, i12 < 0 ? -1 : i12, i4 < 0 ? -1 : i4);
                return;
            }
            return;
        }
        int i14 = this.f942f;
        if (i14 == -1) {
            i14 = -1;
        } else if (i14 == -2) {
            i14 = this.q.getWidth();
        }
        int i15 = this.f941e;
        if (i15 == -1) {
            i4 = -1;
        } else if (i15 != -2) {
            i4 = i15;
        }
        this.A.setWidth(i14);
        this.A.setHeight(i4);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = B;
            if (method2 != null) {
                try {
                    method2.invoke(this.A, Boolean.TRUE);
                } catch (Exception unused2) {
                }
            }
        } else {
            this.A.setIsClippedToScreen(true);
        }
        this.A.setOutsideTouchable(true);
        this.A.setTouchInterceptor(this.t);
        if (this.f948l) {
            m.e.t1(this.A, this.f947k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = D;
            if (method3 != null) {
                try {
                    method3.invoke(this.A, this.y);
                } catch (Exception unused3) {
                }
            }
        } else {
            this.A.setEpicenterBounds(this.y);
        }
        e.i.j.d.a(this.A, this.q, this.f943g, this.f944h, this.m);
        this.f940d.setSelection(-1);
        if ((!this.z || this.f940d.isInTouchMode()) && (j0Var = this.f940d) != null) {
            j0Var.setListSelectionHidden(true);
            j0Var.requestLayout();
        }
        if (!this.z) {
            this.w.post(this.v);
        }
    }

    public void b(int i2) {
        this.f943g = i2;
    }

    @Override // e.b.e.i.p
    public boolean c() {
        return this.A.isShowing();
    }

    public int d() {
        return this.f943g;
    }

    @Override // e.b.e.i.p
    public void dismiss() {
        this.A.dismiss();
        this.A.setContentView(null);
        this.f940d = null;
        this.w.removeCallbacks(this.s);
    }

    public int g() {
        if (!this.f946j) {
            return 0;
        }
        return this.f944h;
    }

    public Drawable i() {
        return this.A.getBackground();
    }

    @Override // e.b.e.i.p
    public ListView k() {
        return this.f940d;
    }

    public void m(Drawable drawable) {
        this.A.setBackgroundDrawable(drawable);
    }

    public void n(int i2) {
        this.f944h = i2;
        this.f946j = true;
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.p;
        if (dataSetObserver == null) {
            this.p = new b();
        } else {
            ListAdapter listAdapter2 = this.c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.p);
        }
        j0 j0Var = this.f940d;
        if (j0Var != null) {
            j0Var.setAdapter(this.c);
        }
    }

    public j0 q(Context context, boolean z2) {
        return new j0(context, z2);
    }

    public void r(int i2) {
        Drawable background = this.A.getBackground();
        if (background != null) {
            background.getPadding(this.x);
            Rect rect = this.x;
            this.f942f = rect.left + rect.right + i2;
            return;
        }
        this.f942f = i2;
    }

    public void s(boolean z2) {
        this.z = z2;
        this.A.setFocusable(z2);
    }
}
