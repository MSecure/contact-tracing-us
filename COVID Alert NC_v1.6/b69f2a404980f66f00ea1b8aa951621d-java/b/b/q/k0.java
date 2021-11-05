package b.b.q;

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
import b.b.j;
import b.b.p.i.p;
import b.i.l.m;
import java.lang.reflect.Method;

public class k0 implements p {
    public static Method D;
    public static Method E;
    public static Method F;
    public Rect A;
    public boolean B;
    public PopupWindow C;

    /* renamed from: b  reason: collision with root package name */
    public Context f668b;

    /* renamed from: c  reason: collision with root package name */
    public ListAdapter f669c;

    /* renamed from: d  reason: collision with root package name */
    public f0 f670d;

    /* renamed from: e  reason: collision with root package name */
    public int f671e = -2;
    public int f = -2;
    public int g;
    public int h;
    public int i = 1002;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public int p = Integer.MAX_VALUE;
    public int q = 0;
    public DataSetObserver r;
    public View s;
    public AdapterView.OnItemClickListener t;
    public final e u = new e();
    public final d v = new d();
    public final c w = new c();
    public final a x = new a();
    public final Handler y;
    public final Rect z = new Rect();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            f0 f0Var = k0.this.f670d;
            if (f0Var != null) {
                f0Var.setListSelectionHidden(true);
                f0Var.requestLayout();
            }
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            if (k0.this.c()) {
                k0.this.a();
            }
        }

        public void onInvalidated() {
            k0.this.dismiss();
        }
    }

    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            boolean z = true;
            if (i == 1) {
                if (k0.this.C.getInputMethodMode() != 2) {
                    z = false;
                }
                if (!z && k0.this.C.getContentView() != null) {
                    k0 k0Var = k0.this;
                    k0Var.y.removeCallbacks(k0Var.u);
                    k0.this.u.run();
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
            if (action == 0 && (popupWindow = k0.this.C) != null && popupWindow.isShowing() && x >= 0 && x < k0.this.C.getWidth() && y >= 0 && y < k0.this.C.getHeight()) {
                k0 k0Var = k0.this;
                k0Var.y.postDelayed(k0Var.u, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                k0 k0Var2 = k0.this;
                k0Var2.y.removeCallbacks(k0Var2.u);
                return false;
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            f0 f0Var = k0.this.f670d;
            if (f0Var != null && m.A(f0Var) && k0.this.f670d.getCount() > k0.this.f670d.getChildCount()) {
                int childCount = k0.this.f670d.getChildCount();
                k0 k0Var = k0.this;
                if (childCount <= k0Var.p) {
                    k0Var.C.setInputMethodMode(2);
                    k0.this.a();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                D = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                F = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                E = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public k0(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f668b = context;
        this.y = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i2, i3);
        this.g = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.j = true;
        }
        obtainStyledAttributes.recycle();
        p pVar = new p(context, attributeSet, i2, i3);
        this.C = pVar;
        pVar.setInputMethodMode(1);
    }

    @Override // b.b.p.i.p
    public void a() {
        int i2;
        int i3;
        int i4;
        f0 f0Var;
        int i5;
        boolean z2 = true;
        if (this.f670d == null) {
            f0 q2 = q(this.f668b, !this.B);
            this.f670d = q2;
            q2.setAdapter(this.f669c);
            this.f670d.setOnItemClickListener(this.t);
            this.f670d.setFocusable(true);
            this.f670d.setFocusableInTouchMode(true);
            this.f670d.setOnItemSelectedListener(new j0(this));
            this.f670d.setOnScrollListener(this.w);
            this.C.setContentView(this.f670d);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.C.getContentView();
        }
        Drawable background = this.C.getBackground();
        if (background != null) {
            background.getPadding(this.z);
            Rect rect = this.z;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.j) {
                this.h = -i6;
            }
        } else {
            this.z.setEmpty();
            i2 = 0;
        }
        boolean z3 = this.C.getInputMethodMode() == 2;
        View view = this.s;
        int i7 = this.h;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = E;
            if (method != null) {
                try {
                    i3 = ((Integer) method.invoke(this.C, view, Integer.valueOf(i7), Boolean.valueOf(z3))).intValue();
                } catch (Exception unused) {
                }
            }
            i3 = this.C.getMaxAvailableHeight(view, i7);
        } else {
            i3 = this.C.getMaxAvailableHeight(view, i7, z3);
        }
        if (this.n || this.f671e == -1) {
            i4 = i3 + i2;
        } else {
            int i8 = this.f;
            if (i8 != -2) {
                i5 = 1073741824;
                if (i8 == -1) {
                    int i9 = this.f668b.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.z;
                    i8 = i9 - (rect2.left + rect2.right);
                }
            } else {
                int i10 = this.f668b.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.z;
                i8 = i10 - (rect3.left + rect3.right);
                i5 = Integer.MIN_VALUE;
            }
            int a2 = this.f670d.a(View.MeasureSpec.makeMeasureSpec(i8, i5), i3 - 0, -1);
            i4 = a2 + (a2 > 0 ? this.f670d.getPaddingBottom() + this.f670d.getPaddingTop() + i2 + 0 : 0);
        }
        boolean z4 = this.C.getInputMethodMode() == 2;
        this.C.setWindowLayoutType(this.i);
        if (!this.C.isShowing()) {
            int i11 = this.f;
            if (i11 == -1) {
                i11 = -1;
            } else if (i11 == -2) {
                i11 = this.s.getWidth();
            }
            int i12 = this.f671e;
            if (i12 == -1) {
                i4 = -1;
            } else if (i12 != -2) {
                i4 = i12;
            }
            this.C.setWidth(i11);
            this.C.setHeight(i4);
            if (Build.VERSION.SDK_INT <= 28) {
                Method method2 = D;
                if (method2 != null) {
                    try {
                        method2.invoke(this.C, Boolean.TRUE);
                    } catch (Exception unused2) {
                    }
                }
            } else {
                this.C.setIsClippedToScreen(true);
            }
            this.C.setOutsideTouchable(!this.o && !this.n);
            this.C.setTouchInterceptor(this.v);
            if (this.l) {
                this.C.setOverlapAnchor(this.k);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method3 = F;
                if (method3 != null) {
                    try {
                        method3.invoke(this.C, this.A);
                    } catch (Exception unused3) {
                    }
                }
            } else {
                this.C.setEpicenterBounds(this.A);
            }
            this.C.showAsDropDown(this.s, this.g, this.h, this.m);
            this.f670d.setSelection(-1);
            if ((!this.B || this.f670d.isInTouchMode()) && (f0Var = this.f670d) != null) {
                f0Var.setListSelectionHidden(true);
                f0Var.requestLayout();
            }
            if (!this.B) {
                this.y.post(this.x);
            }
        } else if (m.A(this.s)) {
            int i13 = this.f;
            if (i13 == -1) {
                i13 = -1;
            } else if (i13 == -2) {
                i13 = this.s.getWidth();
            }
            int i14 = this.f671e;
            if (i14 == -1) {
                if (!z4) {
                    i4 = -1;
                }
                if (z4) {
                    this.C.setWidth(this.f == -1 ? -1 : 0);
                    this.C.setHeight(0);
                } else {
                    this.C.setWidth(this.f == -1 ? -1 : 0);
                    this.C.setHeight(-1);
                }
            } else if (i14 != -2) {
                i4 = i14;
            }
            PopupWindow popupWindow = this.C;
            if (this.o || this.n) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.C.update(this.s, this.g, this.h, i13 < 0 ? -1 : i13, i4 < 0 ? -1 : i4);
        }
    }

    public void b(int i2) {
        this.g = i2;
    }

    @Override // b.b.p.i.p
    public boolean c() {
        return this.C.isShowing();
    }

    public int d() {
        return this.g;
    }

    @Override // b.b.p.i.p
    public void dismiss() {
        this.C.dismiss();
        this.C.setContentView(null);
        this.f670d = null;
        this.y.removeCallbacks(this.u);
    }

    public int g() {
        if (!this.j) {
            return 0;
        }
        return this.h;
    }

    public Drawable i() {
        return this.C.getBackground();
    }

    @Override // b.b.p.i.p
    public ListView k() {
        return this.f670d;
    }

    public void m(Drawable drawable) {
        this.C.setBackgroundDrawable(drawable);
    }

    public void n(int i2) {
        this.h = i2;
        this.j = true;
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.r;
        if (dataSetObserver == null) {
            this.r = new b();
        } else {
            ListAdapter listAdapter2 = this.f669c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f669c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.r);
        }
        f0 f0Var = this.f670d;
        if (f0Var != null) {
            f0Var.setAdapter(this.f669c);
        }
    }

    public f0 q(Context context, boolean z2) {
        return new f0(context, z2);
    }

    public void r(int i2) {
        Drawable background = this.C.getBackground();
        if (background != null) {
            background.getPadding(this.z);
            Rect rect = this.z;
            this.f = rect.left + rect.right + i2;
            return;
        }
        this.f = i2;
    }

    public void s(boolean z2) {
        this.B = z2;
        this.C.setFocusable(z2);
    }
}
