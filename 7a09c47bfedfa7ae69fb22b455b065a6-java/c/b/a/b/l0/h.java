package c.b.a.b.l0;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import b.i.l.m;
import b.x.t;
import c.b.a.b.c0.j;
import c.b.a.b.h0.g;
import c.b.a.b.h0.j;
import com.google.android.material.textfield.TextInputLayout;

public class h extends m {

    /* renamed from: d  reason: collision with root package name */
    public final TextWatcher f4367d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final View.OnFocusChangeListener f4368e = new b();

    /* renamed from: f  reason: collision with root package name */
    public final TextInputLayout.e f4369f = new c(this.f4384a);

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout.f f4370g = new d();
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.g h = new e();
    public boolean i = false;
    public boolean j = false;
    public long k = Long.MAX_VALUE;
    public StateListDrawable l;
    public g m;
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    public class a extends j {

        /* renamed from: c.b.a.b.l0.h$a$a  reason: collision with other inner class name */
        public class RunnableC0076a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AutoCompleteTextView f4372b;

            public RunnableC0076a(AutoCompleteTextView autoCompleteTextView) {
                this.f4372b = autoCompleteTextView;
            }

            public void run() {
                boolean isPopupShowing = this.f4372b.isPopupShowing();
                h.f(h.this, isPopupShowing);
                h.this.i = isPopupShowing;
            }
        }

        public a() {
        }

        @Override // c.b.a.b.c0.j
        public void afterTextChanged(Editable editable) {
            h hVar = h.this;
            AutoCompleteTextView e2 = h.e(hVar, hVar.f4384a.getEditText());
            e2.post(new RunnableC0076a(e2));
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z) {
            h.this.f4384a.setEndIconActivated(z);
            if (!z) {
                h.f(h.this, false);
                h.this.i = false;
            }
        }
    }

    public class c extends TextInputLayout.e {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // b.i.l.a, com.google.android.material.textfield.TextInputLayout.e
        public void d(View view, b.i.l.w.b bVar) {
            boolean z;
            super.d(view, bVar);
            if (h.this.f4384a.getEditText().getKeyListener() == null) {
                bVar.f1906a.setClassName(Spinner.class.getName());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                z = bVar.f1906a.isShowingHintText();
            } else {
                Bundle f2 = bVar.f();
                z = f2 != null && (f2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4;
            }
            if (z) {
                bVar.k(null);
            }
        }

        @Override // b.i.l.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            this.f1847a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            h hVar = h.this;
            AutoCompleteTextView e2 = h.e(hVar, hVar.f4384a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && h.this.n.isTouchExplorationEnabled()) {
                h.g(h.this, e2);
            }
        }
    }

    public class d implements TextInputLayout.f {
        public d() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            h hVar;
            Drawable drawable;
            AutoCompleteTextView e2 = h.e(h.this, textInputLayout.getEditText());
            h hVar2 = h.this;
            int boxBackgroundMode = hVar2.f4384a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = hVar2.m;
            } else {
                if (boxBackgroundMode == 1) {
                    drawable = hVar2.l;
                }
                hVar = h.this;
                if (hVar == null) {
                    if (e2.getKeyListener() == null) {
                        int boxBackgroundMode2 = hVar.f4384a.getBoxBackgroundMode();
                        g boxBackground = hVar.f4384a.getBoxBackground();
                        int A1 = t.A1(e2, c.b.a.b.b.colorControlHighlight);
                        int[][] iArr = {new int[]{16842919}, new int[0]};
                        if (boxBackgroundMode2 == 2) {
                            int A12 = t.A1(e2, c.b.a.b.b.colorSurface);
                            g gVar = new g(boxBackground.f4261b.f4268a);
                            int a2 = t.a2(A1, A12, 0.1f);
                            gVar.r(new ColorStateList(iArr, new int[]{a2, 0}));
                            gVar.setTint(A12);
                            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{a2, A12});
                            g gVar2 = new g(boxBackground.f4261b.f4268a);
                            gVar2.setTint(-1);
                            m.X(e2, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar, gVar2), boxBackground}));
                        } else if (boxBackgroundMode2 == 1) {
                            int boxBackgroundColor = hVar.f4384a.getBoxBackgroundColor();
                            m.X(e2, new RippleDrawable(new ColorStateList(iArr, new int[]{t.a2(A1, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                        }
                    }
                    h hVar3 = h.this;
                    if (hVar3 != null) {
                        e2.setOnTouchListener(new j(hVar3, e2));
                        e2.setOnFocusChangeListener(hVar3.f4368e);
                        e2.setOnDismissListener(new k(hVar3));
                        e2.setThreshold(0);
                        e2.removeTextChangedListener(h.this.f4367d);
                        e2.addTextChangedListener(h.this.f4367d);
                        textInputLayout.setEndIconCheckable(true);
                        textInputLayout.setErrorIconDrawable((Drawable) null);
                        textInputLayout.setTextInputAccessibilityDelegate(h.this.f4369f);
                        textInputLayout.setEndIconVisible(true);
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            e2.setDropDownBackgroundDrawable(drawable);
            hVar = h.this;
            if (hVar == null) {
            }
        }
    }

    public class e implements TextInputLayout.g {
        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i == 3) {
                autoCompleteTextView.removeTextChangedListener(h.this.f4367d);
                if (autoCompleteTextView.getOnFocusChangeListener() == h.this.f4368e) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            h.g(h.this, (AutoCompleteTextView) h.this.f4384a.getEditText());
        }
    }

    public h(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static AutoCompleteTextView e(h hVar, EditText editText) {
        if (hVar == null) {
            throw null;
        } else if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        } else {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
    }

    public static void f(h hVar, boolean z) {
        if (hVar.j != z) {
            hVar.j = z;
            hVar.p.cancel();
            hVar.o.start();
        }
    }

    public static void g(h hVar, AutoCompleteTextView autoCompleteTextView) {
        if (hVar == null) {
            throw null;
        } else if (autoCompleteTextView != null) {
            if (hVar.i()) {
                hVar.i = false;
            }
            if (!hVar.i) {
                boolean z = hVar.j;
                boolean z2 = !z;
                if (z != z2) {
                    hVar.j = z2;
                    hVar.p.cancel();
                    hVar.o.start();
                }
                if (hVar.j) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            hVar.i = false;
        }
    }

    @Override // c.b.a.b.l0.m
    public void a() {
        float dimensionPixelOffset = (float) this.f4385b.getResources().getDimensionPixelOffset(c.b.a.b.d.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.f4385b.getResources().getDimensionPixelOffset(c.b.a.b.d.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f4385b.getResources().getDimensionPixelOffset(c.b.a.b.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        g h2 = h(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        g h3 = h(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = h2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, h2);
        this.l.addState(new int[0], h3);
        this.f4384a.setEndIconDrawable(b.b.l.a.a.b(this.f4385b, c.b.a.b.e.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.f4384a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(c.b.a.b.j.exposed_dropdown_menu_content_description));
        this.f4384a.setEndIconOnClickListener(new f());
        this.f4384a.a(this.f4370g);
        TextInputLayout textInputLayout2 = this.f4384a;
        textInputLayout2.g0.add(this.h);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(c.b.a.b.m.a.f4410a);
        ofFloat.setDuration((long) 67);
        ofFloat.addUpdateListener(new i(this));
        this.p = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(c.b.a.b.m.a.f4410a);
        ofFloat2.setDuration((long) 50);
        ofFloat2.addUpdateListener(new i(this));
        this.o = ofFloat2;
        ofFloat2.addListener(new l(this));
        m.b0(this.f4386c, 2);
        this.n = (AccessibilityManager) this.f4385b.getSystemService("accessibility");
    }

    @Override // c.b.a.b.l0.m
    public boolean b(int i2) {
        return i2 != 0;
    }

    @Override // c.b.a.b.l0.m
    public boolean d() {
        return true;
    }

    public final g h(float f2, float f3, float f4, int i2) {
        j.b bVar = new j.b();
        bVar.f4288e = new c.b.a.b.h0.a(f2);
        bVar.f4289f = new c.b.a.b.h0.a(f2);
        bVar.h = new c.b.a.b.h0.a(f3);
        bVar.f4290g = new c.b.a.b.h0.a(f3);
        c.b.a.b.h0.j a2 = bVar.a();
        g f5 = g.f(this.f4385b, f4);
        f5.f4261b.f4268a = a2;
        f5.invalidateSelf();
        g.b bVar2 = f5.f4261b;
        if (bVar2.i == null) {
            bVar2.i = new Rect();
        }
        f5.f4261b.i.set(0, i2, 0, i2);
        f5.invalidateSelf();
        return f5;
    }

    public final boolean i() {
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }
}
