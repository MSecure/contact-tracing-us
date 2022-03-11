package e.b.f;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.R$dimen;
import e.j.j.v;
import e.j.j.w;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class f1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k  reason: collision with root package name */
    public static f1 f946k;

    /* renamed from: l  reason: collision with root package name */
    public static f1 f947l;
    public final View b;
    public final CharSequence c;

    /* renamed from: d  reason: collision with root package name */
    public final int f948d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f949e = new a();

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f950f = new b();

    /* renamed from: g  reason: collision with root package name */
    public int f951g;

    /* renamed from: h  reason: collision with root package name */
    public int f952h;

    /* renamed from: i  reason: collision with root package name */
    public g1 f953i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f954j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f1.this.d(false);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f1.this.b();
        }
    }

    public f1(View view, CharSequence charSequence) {
        this.b = view;
        this.c = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = w.a;
        this.f948d = Build.VERSION.SDK_INT >= 28 ? viewConfiguration.getScaledHoverSlop() : viewConfiguration.getScaledTouchSlop() / 2;
        a();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void c(f1 f1Var) {
        f1 f1Var2 = f946k;
        if (f1Var2 != null) {
            f1Var2.b.removeCallbacks(f1Var2.f949e);
        }
        f946k = f1Var;
        if (f1Var != null) {
            f1Var.b.postDelayed(f1Var.f949e, (long) ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        this.f951g = Integer.MAX_VALUE;
        this.f952h = Integer.MAX_VALUE;
    }

    public void b() {
        if (f947l == this) {
            f947l = null;
            g1 g1Var = this.f953i;
            if (g1Var != null) {
                g1Var.a();
                this.f953i = null;
                a();
                this.b.removeOnAttachStateChangeListener(this);
            }
        }
        if (f946k == this) {
            c(null);
        }
        this.b.removeCallbacks(this.f950f);
    }

    public void d(boolean z) {
        int i2;
        int i3;
        long j2;
        View view = this.b;
        AtomicInteger atomicInteger = v.a;
        if (v.g.b(view)) {
            c(null);
            f1 f1Var = f947l;
            if (f1Var != null) {
                f1Var.b();
            }
            f947l = this;
            this.f954j = z;
            g1 g1Var = new g1(this.b.getContext());
            this.f953i = g1Var;
            View view2 = this.b;
            int i4 = this.f951g;
            int i5 = this.f952h;
            boolean z2 = this.f954j;
            CharSequence charSequence = this.c;
            if (g1Var.b.getParent() != null) {
                g1Var.a();
            }
            g1Var.c.setText(charSequence);
            WindowManager.LayoutParams layoutParams = g1Var.f957d;
            layoutParams.token = view2.getApplicationWindowToken();
            int dimensionPixelOffset = g1Var.a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
            if (view2.getWidth() < dimensionPixelOffset) {
                i4 = view2.getWidth() / 2;
            }
            if (view2.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = g1Var.a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
                i2 = i5 + dimensionPixelOffset2;
                i3 = i5 - dimensionPixelOffset2;
            } else {
                i2 = view2.getHeight();
                i3 = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = g1Var.a.getResources().getDimensionPixelOffset(z2 ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch);
            View rootView = view2.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context = view2.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else if (context instanceof Activity) {
                        rootView = ((Activity) context).getWindow().getDecorView();
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
            }
            if (rootView != null) {
                rootView.getWindowVisibleDisplayFrame(g1Var.f958e);
                Rect rect = g1Var.f958e;
                if (rect.left < 0 && rect.top < 0) {
                    Resources resources = g1Var.a.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    g1Var.f958e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(g1Var.f960g);
                view2.getLocationOnScreen(g1Var.f959f);
                int[] iArr = g1Var.f959f;
                int i6 = iArr[0];
                int[] iArr2 = g1Var.f960g;
                iArr[0] = i6 - iArr2[0];
                iArr[1] = iArr[1] - iArr2[1];
                layoutParams.x = (iArr[0] + i4) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                g1Var.b.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = g1Var.b.getMeasuredHeight();
                int[] iArr3 = g1Var.f959f;
                int i7 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
                int i8 = iArr3[1] + i2 + dimensionPixelOffset3;
                if (!z2 ? measuredHeight + i8 > g1Var.f958e.height() : i7 >= 0) {
                    layoutParams.y = i7;
                } else {
                    layoutParams.y = i8;
                }
            }
            ((WindowManager) g1Var.a.getSystemService("window")).addView(g1Var.b, g1Var.f957d);
            this.b.addOnAttachStateChangeListener(this);
            if (this.f954j) {
                j2 = 2500;
            } else {
                j2 = ((v.d.g(this.b) & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.b.removeCallbacks(this.f950f);
            this.b.postDelayed(this.f950f, j2);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.f953i != null && this.f954j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                a();
                b();
            }
        } else if (this.b.isEnabled() && this.f953i == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.f951g) > this.f948d || Math.abs(y - this.f952h) > this.f948d) {
                this.f951g = x;
                this.f952h = y;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                c(this);
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f951g = view.getWidth() / 2;
        this.f952h = view.getHeight() / 2;
        d(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
