package b.b.q;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import b.b.d;
import b.i.l.m;
import b.i.l.q;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeyUploader;

public class b1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static b1 k;
    public static b1 l;

    /* renamed from: b  reason: collision with root package name */
    public final View f600b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f601c;

    /* renamed from: d  reason: collision with root package name */
    public final int f602d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f603e = new a();
    public final Runnable f = new b();
    public int g;
    public int h;
    public c1 i;
    public boolean j;

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
        this.f600b = view;
        this.f601c = charSequence;
        this.f602d = q.c(ViewConfiguration.get(view.getContext()));
        a();
        this.f600b.setOnLongClickListener(this);
        this.f600b.setOnHoverListener(this);
    }

    public static void c(b1 b1Var) {
        b1 b1Var2 = k;
        if (b1Var2 != null) {
            b1Var2.f600b.removeCallbacks(b1Var2.f603e);
        }
        k = b1Var;
        if (b1Var != null) {
            b1Var.f600b.postDelayed(b1Var.f603e, (long) ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
    }

    public void b() {
        if (l == this) {
            l = null;
            c1 c1Var = this.i;
            if (c1Var != null) {
                c1Var.a();
                this.i = null;
                a();
                this.f600b.removeOnAttachStateChangeListener(this);
            }
        }
        if (k == this) {
            c(null);
        }
        this.f600b.removeCallbacks(this.f);
    }

    public void d(boolean z) {
        int i2;
        int i3;
        long j2;
        if (m.A(this.f600b)) {
            c(null);
            b1 b1Var = l;
            if (b1Var != null) {
                b1Var.b();
            }
            l = this;
            this.j = z;
            c1 c1Var = new c1(this.f600b.getContext());
            this.i = c1Var;
            View view = this.f600b;
            int i4 = this.g;
            int i5 = this.h;
            boolean z2 = this.j;
            CharSequence charSequence = this.f601c;
            if (c1Var.f612b.getParent() != null) {
                c1Var.a();
            }
            c1Var.f613c.setText(charSequence);
            WindowManager.LayoutParams layoutParams = c1Var.f614d;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = c1Var.f611a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                i4 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = c1Var.f611a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_extra_offset);
                i2 = i5 + dimensionPixelOffset2;
                i3 = i5 - dimensionPixelOffset2;
            } else {
                i2 = view.getHeight();
                i3 = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = c1Var.f611a.getResources().getDimensionPixelOffset(z2 ? d.tooltip_y_offset_touch : d.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context = view.getContext();
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
                rootView.getWindowVisibleDisplayFrame(c1Var.f615e);
                Rect rect = c1Var.f615e;
                if (rect.left < 0 && rect.top < 0) {
                    Resources resources = c1Var.f611a.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", DiagnosisKeyUploader.PLATFORM);
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    c1Var.f615e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(c1Var.g);
                view.getLocationOnScreen(c1Var.f);
                int[] iArr = c1Var.f;
                int i6 = iArr[0];
                int[] iArr2 = c1Var.g;
                iArr[0] = i6 - iArr2[0];
                iArr[1] = iArr[1] - iArr2[1];
                layoutParams.x = (iArr[0] + i4) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                c1Var.f612b.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = c1Var.f612b.getMeasuredHeight();
                int[] iArr3 = c1Var.f;
                int i7 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
                int i8 = iArr3[1] + i2 + dimensionPixelOffset3;
                if (!z2 ? measuredHeight + i8 > c1Var.f615e.height() : i7 >= 0) {
                    layoutParams.y = i7;
                } else {
                    layoutParams.y = i8;
                }
            }
            ((WindowManager) c1Var.f611a.getSystemService("window")).addView(c1Var.f612b, c1Var.f614d);
            this.f600b.addOnAttachStateChangeListener(this);
            if (this.j) {
                j2 = 2500;
            } else {
                j2 = ((this.f600b.getWindowSystemUiVisibility() & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f600b.removeCallbacks(this.f);
            this.f600b.postDelayed(this.f, j2);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.i != null && this.j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f600b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                a();
                b();
            }
        } else if (this.f600b.isEnabled() && this.i == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.g) > this.f602d || Math.abs(y - this.h) > this.f602d) {
                this.g = x;
                this.h = y;
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
        this.g = view.getWidth() / 2;
        this.h = view.getHeight() / 2;
        d(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
