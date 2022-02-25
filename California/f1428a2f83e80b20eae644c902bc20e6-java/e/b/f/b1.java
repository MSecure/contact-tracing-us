package e.b.f;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.R$dimen;
import e.i.i.l;
import e.i.i.q;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class b1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k  reason: collision with root package name */
    public static b1 f853k;

    /* renamed from: l  reason: collision with root package name */
    public static b1 f854l;
    public final View b;
    public final CharSequence c;

    /* renamed from: d  reason: collision with root package name */
    public final int f855d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f856e = new a();

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f857f = new b();

    /* renamed from: g  reason: collision with root package name */
    public int f858g;

    /* renamed from: h  reason: collision with root package name */
    public int f859h;

    /* renamed from: i  reason: collision with root package name */
    public c1 f860i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f861j;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            b1.this.d(false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            b1.this.b();
        }
    }

    public b1(View view, CharSequence charSequence) {
        this.b = view;
        this.c = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = q.a;
        this.f855d = Build.VERSION.SDK_INT >= 28 ? viewConfiguration.getScaledHoverSlop() : viewConfiguration.getScaledTouchSlop() / 2;
        a();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void c(b1 b1Var) {
        b1 b1Var2 = f853k;
        if (b1Var2 != null) {
            b1Var2.b.removeCallbacks(b1Var2.f856e);
        }
        f853k = b1Var;
        if (b1Var != null) {
            b1Var.b.postDelayed(b1Var.f856e, (long) ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        this.f858g = Integer.MAX_VALUE;
        this.f859h = Integer.MAX_VALUE;
    }

    public void b() {
        if (f854l == this) {
            f854l = null;
            c1 c1Var = this.f860i;
            if (c1Var != null) {
                c1Var.a();
                this.f860i = null;
                a();
                this.b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f853k == this) {
            c(null);
        }
        this.b.removeCallbacks(this.f857f);
    }

    public void d(boolean z) {
        int i2;
        int i3;
        long j2;
        View view = this.b;
        AtomicInteger atomicInteger = l.a;
        if (view.isAttachedToWindow()) {
            c(null);
            b1 b1Var = f854l;
            if (b1Var != null) {
                b1Var.b();
            }
            f854l = this;
            this.f861j = z;
            c1 c1Var = new c1(this.b.getContext());
            this.f860i = c1Var;
            View view2 = this.b;
            int i4 = this.f858g;
            int i5 = this.f859h;
            boolean z2 = this.f861j;
            CharSequence charSequence = this.c;
            if (c1Var.b.getParent() != null) {
                c1Var.a();
            }
            c1Var.c.setText(charSequence);
            WindowManager.LayoutParams layoutParams = c1Var.f867d;
            layoutParams.token = view2.getApplicationWindowToken();
            int dimensionPixelOffset = c1Var.a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
            if (view2.getWidth() < dimensionPixelOffset) {
                i4 = view2.getWidth() / 2;
            }
            if (view2.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = c1Var.a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
                i2 = i5 + dimensionPixelOffset2;
                i3 = i5 - dimensionPixelOffset2;
            } else {
                i2 = view2.getHeight();
                i3 = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = c1Var.a.getResources().getDimensionPixelOffset(z2 ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch);
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
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                rootView.getWindowVisibleDisplayFrame(c1Var.f868e);
                Rect rect = c1Var.f868e;
                if (rect.left < 0 && rect.top < 0) {
                    Resources resources = c1Var.a.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    c1Var.f868e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(c1Var.f870g);
                view2.getLocationOnScreen(c1Var.f869f);
                int[] iArr = c1Var.f869f;
                int i6 = iArr[0];
                int[] iArr2 = c1Var.f870g;
                iArr[0] = i6 - iArr2[0];
                iArr[1] = iArr[1] - iArr2[1];
                layoutParams.x = (iArr[0] + i4) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                c1Var.b.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = c1Var.b.getMeasuredHeight();
                int[] iArr3 = c1Var.f869f;
                int i7 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
                int i8 = iArr3[1] + i2 + dimensionPixelOffset3;
                if (!z2 ? measuredHeight + i8 > c1Var.f868e.height() : i7 >= 0) {
                    layoutParams.y = i7;
                } else {
                    layoutParams.y = i8;
                }
            }
            ((WindowManager) c1Var.a.getSystemService("window")).addView(c1Var.b, c1Var.f867d);
            this.b.addOnAttachStateChangeListener(this);
            if (this.f861j) {
                j2 = 2500;
            } else {
                j2 = ((this.b.getWindowSystemUiVisibility() & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.b.removeCallbacks(this.f857f);
            this.b.postDelayed(this.f857f, j2);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.f860i != null && this.f861j) {
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
        } else if (this.b.isEnabled() && this.f860i == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.f858g) > this.f855d || Math.abs(y - this.f859h) > this.f855d) {
                this.f858g = x;
                this.f859h = y;
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

    public boolean onLongClick(View view) {
        this.f858g = view.getWidth() / 2;
        this.f859h = view.getHeight() / 2;
        d(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
