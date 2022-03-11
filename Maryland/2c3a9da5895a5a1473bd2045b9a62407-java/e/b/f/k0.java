package e.b.f;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
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
import e.i.i.m;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class k0 implements p {
    public static Method B;
    public static Method C;
    public static Method D;
    public PopupWindow A;
    public Context b;
    public ListAdapter c;

    /* renamed from: d  reason: collision with root package name */
    public f0 f912d;

    /* renamed from: e  reason: collision with root package name */
    public int f913e = -2;

    /* renamed from: f  reason: collision with root package name */
    public int f914f = -2;

    /* renamed from: g  reason: collision with root package name */
    public int f915g;

    /* renamed from: h  reason: collision with root package name */
    public int f916h;

    /* renamed from: i  reason: collision with root package name */
    public int f917i = 1002;

    /* renamed from: j  reason: collision with root package name */
    public boolean f918j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f919k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f920l;
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
            f0 f0Var = k0.this.f912d;
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

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            boolean z = true;
            if (i2 == 1) {
                if (k0.this.A.getInputMethodMode() != 2) {
                    z = false;
                }
                if (!z && k0.this.A.getContentView() != null) {
                    k0 k0Var = k0.this;
                    k0Var.w.removeCallbacks(k0Var.s);
                    k0.this.s.run();
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
            if (action == 0 && (popupWindow = k0.this.A) != null && popupWindow.isShowing() && x >= 0 && x < k0.this.A.getWidth() && y >= 0 && y < k0.this.A.getHeight()) {
                k0 k0Var = k0.this;
                k0Var.w.postDelayed(k0Var.s, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                k0 k0Var2 = k0.this;
                k0Var2.w.removeCallbacks(k0Var2.s);
                return false;
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            f0 f0Var = k0.this.f912d;
            if (f0Var != null) {
                AtomicInteger atomicInteger = m.a;
                if (f0Var.isAttachedToWindow() && k0.this.f912d.getCount() > k0.this.f912d.getChildCount()) {
                    int childCount = k0.this.f912d.getChildCount();
                    k0 k0Var = k0.this;
                    if (childCount <= k0Var.n) {
                        k0Var.A.setInputMethodMode(2);
                        k0.this.a();
                    }
                }
            }
        }
    }

    static {
        Class cls = Boolean.TYPE;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 28) {
            try {
                B = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", cls);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                D = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (i2 <= 23) {
            try {
                C = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, cls);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public k0(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.b = context;
        this.w = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i2, i3);
        this.f915g = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f916h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f918j = true;
        }
        obtainStyledAttributes.recycle();
        p pVar = new p(context, attributeSet, i2, i3);
        this.A = pVar;
        pVar.setInputMethodMode(1);
    }

    @Override // e.b.e.i.p
    public void a() {
        int i2;
        int i3;
        int i4;
        f0 f0Var;
        int i5;
        int i6 = Build.VERSION.SDK_INT;
        if (this.f912d == null) {
            f0 q2 = q(this.b, !this.z);
            this.f912d = q2;
            q2.setAdapter(this.c);
            this.f912d.setOnItemClickListener(this.r);
            this.f912d.setFocusable(true);
            this.f912d.setFocusableInTouchMode(true);
            this.f912d.setOnItemSelectedListener(new j0(this));
            this.f912d.setOnScrollListener(this.u);
            this.A.setContentView(this.f912d);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.A.getContentView();
        }
        Drawable background = this.A.getBackground();
        int i7 = 0;
        if (background != null) {
            background.getPadding(this.x);
            Rect rect = this.x;
            int i8 = rect.top;
            i2 = rect.bottom + i8;
            if (!this.f918j) {
                this.f916h = -i8;
            }
        } else {
            this.x.setEmpty();
            i2 = 0;
        }
        boolean z2 = this.A.getInputMethodMode() == 2;
        View view = this.q;
        int i9 = this.f916h;
        if (i6 <= 23) {
            Method method = C;
            if (method != null) {
                try {
                    i3 = ((Integer) method.invoke(this.A, view, Integer.valueOf(i9), Boolean.valueOf(z2))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            i3 = this.A.getMaxAvailableHeight(view, i9);
        } else {
            i3 = this.A.getMaxAvailableHeight(view, i9, z2);
        }
        if (this.f913e == -1) {
            i4 = i3 + i2;
        } else {
            int i10 = this.f914f;
            if (i10 != -2) {
                i5 = 1073741824;
                if (i10 == -1) {
                    int i11 = this.b.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.x;
                    i10 = i11 - (rect2.left + rect2.right);
                }
            } else {
                int i12 = this.b.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.x;
                i10 = i12 - (rect3.left + rect3.right);
                i5 = Integer.MIN_VALUE;
            }
            int a2 = this.f912d.a(View.MeasureSpec.makeMeasureSpec(i10, i5), i3 - 0, -1);
            i4 = a2 + (a2 > 0 ? this.f912d.getPaddingBottom() + this.f912d.getPaddingTop() + i2 + 0 : 0);
        }
        boolean z3 = this.A.getInputMethodMode() == 2;
        m.h.i1(this.A, this.f917i);
        if (this.A.isShowing()) {
            View view2 = this.q;
            AtomicInteger atomicInteger = e.i.i.m.a;
            if (view2.isAttachedToWindow()) {
                int i13 = this.f914f;
                if (i13 == -1) {
                    i13 = -1;
                } else if (i13 == -2) {
                    i13 = this.q.getWidth();
                }
                int i14 = this.f913e;
                if (i14 == -1) {
                    if (!z3) {
                        i4 = -1;
                    }
                    if (z3) {
                        this.A.setWidth(this.f914f == -1 ? -1 : 0);
                        this.A.setHeight(0);
                    } else {
                        PopupWindow popupWindow = this.A;
                        if (this.f914f == -1) {
                            i7 = -1;
                        }
                        popupWindow.setWidth(i7);
                        this.A.setHeight(-1);
                    }
                } else if (i14 != -2) {
                    i4 = i14;
                }
                this.A.setOutsideTouchable(true);
                this.A.update(this.q, this.f915g, this.f916h, i13 < 0 ? -1 : i13, i4 < 0 ? -1 : i4);
                return;
            }
            return;
        }
        int i15 = this.f914f;
        if (i15 == -1) {
            i15 = -1;
        } else if (i15 == -2) {
            i15 = this.q.getWidth();
        }
        int i16 = this.f913e;
        if (i16 == -1) {
            i4 = -1;
        } else if (i16 != -2) {
            i4 = i16;
        }
        this.A.setWidth(i15);
        this.A.setHeight(i4);
        if (i6 <= 28) {
            Method method2 = B;
            if (method2 != null) {
                try {
                    method2.invoke(this.A, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.A.setIsClippedToScreen(true);
        }
        this.A.setOutsideTouchable(true);
        this.A.setTouchInterceptor(this.t);
        if (this.f920l) {
            m.h.b1(this.A, this.f919k);
        }
        if (i6 <= 28) {
            Method method3 = D;
            if (method3 != null) {
                try {
                    method3.invoke(this.A, this.y);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.A.setEpicenterBounds(this.y);
        }
        this.A.showAsDropDown(this.q, this.f915g, this.f916h, this.m);
        this.f912d.setSelection(-1);
        if ((!this.z || this.f912d.isInTouchMode()) && (f0Var = this.f912d) != null) {
            f0Var.setListSelectionHidden(true);
            f0Var.requestLayout();
        }
        if (!this.z) {
            this.w.post(this.v);
        }
    }

    public void b(int i2) {
        this.f915g = i2;
    }

    @Override // e.b.e.i.p
    public boolean c() {
        return this.A.isShowing();
    }

    public int d() {
        return this.f915g;
    }

    @Override // e.b.e.i.p
    public void dismiss() {
        this.A.dismiss();
        this.A.setContentView(null);
        this.f912d = null;
        this.w.removeCallbacks(this.s);
    }

    public int g() {
        if (!this.f918j) {
            return 0;
        }
        return this.f916h;
    }

    public Drawable i() {
        return this.A.getBackground();
    }

    @Override // e.b.e.i.p
    public ListView k() {
        return this.f912d;
    }

    public void m(Drawable drawable) {
        this.A.setBackgroundDrawable(drawable);
    }

    public void n(int i2) {
        this.f916h = i2;
        this.f918j = true;
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
        f0 f0Var = this.f912d;
        if (f0Var != null) {
            f0Var.setAdapter(this.c);
        }
    }

    public f0 q(Context context, boolean z2) {
        return new f0(context, z2);
    }

    public void r(int i2) {
        Drawable background = this.A.getBackground();
        if (background != null) {
            background.getPadding(this.x);
            Rect rect = this.x;
            this.f914f = rect.left + rect.right + i2;
            return;
        }
        this.f914f = i2;
    }

    public void s(boolean z2) {
        this.z = z2;
        this.A.setFocusable(z2);
    }
}
