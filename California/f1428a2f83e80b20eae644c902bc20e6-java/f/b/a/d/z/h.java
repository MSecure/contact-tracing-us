package f.b.a.d.z;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
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
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import e.i.i.l;
import f.b.a.d.q.j;
import f.b.a.d.v.g;
import f.b.a.d.v.j;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class h extends m {

    /* renamed from: d  reason: collision with root package name */
    public final TextWatcher f2830d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final View.OnFocusChangeListener f2831e = new b();

    /* renamed from: f  reason: collision with root package name */
    public final TextInputLayout.e f2832f = new c(this.a);

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout.f f2833g = new d();

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout.g f2834h = new e();

    /* renamed from: i  reason: collision with root package name */
    public boolean f2835i = false;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2836j = false;

    /* renamed from: k  reason: collision with root package name */
    public long f2837k = Long.MAX_VALUE;

    /* renamed from: l  reason: collision with root package name */
    public StateListDrawable f2838l;
    public g m;
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    public class a extends j {

        /* renamed from: f.b.a.d.z.h$a$a  reason: collision with other inner class name */
        public class RunnableC0098a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView b;

            public RunnableC0098a(AutoCompleteTextView autoCompleteTextView) {
                this.b = autoCompleteTextView;
            }

            public void run() {
                boolean isPopupShowing = this.b.isPopupShowing();
                h.g(h.this, isPopupShowing);
                h.this.f2835i = isPopupShowing;
            }
        }

        public a() {
        }

        @Override // f.b.a.d.q.j
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView e2 = h.e(h.this.a.getEditText());
            if (h.this.n.isTouchExplorationEnabled() && h.f(e2) && !h.this.c.hasFocus()) {
                e2.dismissDropDown();
            }
            e2.post(new RunnableC0098a(e2));
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z) {
            h.this.a.setEndIconActivated(z);
            if (!z) {
                h.g(h.this, false);
                h.this.f2835i = false;
            }
        }
    }

    public class c extends TextInputLayout.e {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, e.i.i.a
        public void d(View view, e.i.i.w.b bVar) {
            boolean z;
            super.d(view, bVar);
            if (!h.f(h.this.a.getEditText())) {
                bVar.a.setClassName(Spinner.class.getName());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                z = bVar.a.isShowingHintText();
            } else {
                Bundle f2 = bVar.f();
                z = f2 != null && (f2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4;
            }
            if (z) {
                bVar.k(null);
            }
        }

        @Override // e.i.i.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView e2 = h.e(h.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && h.this.n.isTouchExplorationEnabled() && !h.f(h.this.a.getEditText())) {
                h.h(h.this, e2);
            }
        }
    }

    public class d implements TextInputLayout.f {
        public d() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0105  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            boolean z;
            Drawable drawable;
            AutoCompleteTextView e2 = h.e(textInputLayout.getEditText());
            h hVar = h.this;
            int boxBackgroundMode = hVar.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = hVar.m;
            } else {
                if (boxBackgroundMode == 1) {
                    drawable = hVar.f2838l;
                }
                h hVar2 = h.this;
                Objects.requireNonNull(hVar2);
                z = false;
                if (!(e2.getKeyListener() == null)) {
                    int boxBackgroundMode2 = hVar2.a.getBoxBackgroundMode();
                    g boxBackground = hVar2.a.getBoxBackground();
                    int K0 = f.b.a.c.b.o.b.K0(e2, R$attr.colorControlHighlight);
                    int[][] iArr = {new int[]{16842919}, new int[0]};
                    if (boxBackgroundMode2 == 2) {
                        int K02 = f.b.a.c.b.o.b.K0(e2, R$attr.colorSurface);
                        g gVar = new g(boxBackground.b.a);
                        int m1 = f.b.a.c.b.o.b.m1(K0, K02, 0.1f);
                        gVar.q(new ColorStateList(iArr, new int[]{m1, 0}));
                        gVar.setTint(K02);
                        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{m1, K02});
                        g gVar2 = new g(boxBackground.b.a);
                        gVar2.setTint(-1);
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar, gVar2), boxBackground});
                        AtomicInteger atomicInteger = l.a;
                        e2.setBackground(layerDrawable);
                    } else if (boxBackgroundMode2 == 1) {
                        int boxBackgroundColor = hVar2.a.getBoxBackgroundColor();
                        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, new int[]{f.b.a.c.b.o.b.m1(K0, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground);
                        AtomicInteger atomicInteger2 = l.a;
                        e2.setBackground(rippleDrawable);
                    }
                }
                h hVar3 = h.this;
                Objects.requireNonNull(hVar3);
                e2.setOnTouchListener(new j(hVar3, e2));
                e2.setOnFocusChangeListener(hVar3.f2831e);
                e2.setOnDismissListener(new k(hVar3));
                e2.setThreshold(0);
                e2.removeTextChangedListener(h.this.f2830d);
                e2.addTextChangedListener(h.this.f2830d);
                textInputLayout.setEndIconCheckable(true);
                textInputLayout.setErrorIconDrawable((Drawable) null);
                if (e2.getKeyListener() != null) {
                    z = true;
                }
                if (!z) {
                    CheckableImageButton checkableImageButton = h.this.c;
                    AtomicInteger atomicInteger3 = l.a;
                    checkableImageButton.setImportantForAccessibility(2);
                }
                textInputLayout.setTextInputAccessibilityDelegate(h.this.f2832f);
                textInputLayout.setEndIconVisible(true);
            }
            e2.setDropDownBackgroundDrawable(drawable);
            h hVar22 = h.this;
            Objects.requireNonNull(hVar22);
            z = false;
            if (!(e2.getKeyListener() == null)) {
            }
            h hVar32 = h.this;
            Objects.requireNonNull(hVar32);
            e2.setOnTouchListener(new j(hVar32, e2));
            e2.setOnFocusChangeListener(hVar32.f2831e);
            e2.setOnDismissListener(new k(hVar32));
            e2.setThreshold(0);
            e2.removeTextChangedListener(h.this.f2830d);
            e2.addTextChangedListener(h.this.f2830d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (e2.getKeyListener() != null) {
            }
            if (!z) {
            }
            textInputLayout.setTextInputAccessibilityDelegate(h.this.f2832f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    public class e implements TextInputLayout.g {
        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i2 == 3) {
                autoCompleteTextView.removeTextChangedListener(h.this.f2830d);
                if (autoCompleteTextView.getOnFocusChangeListener() == h.this.f2831e) {
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
            h.h(h.this, (AutoCompleteTextView) h.this.a.getEditText());
        }
    }

    public h(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static AutoCompleteTextView e(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static boolean f(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static void g(h hVar, boolean z) {
        if (hVar.f2836j != z) {
            hVar.f2836j = z;
            hVar.p.cancel();
            hVar.o.start();
        }
    }

    public static void h(h hVar, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(hVar);
        if (autoCompleteTextView != null) {
            if (hVar.j()) {
                hVar.f2835i = false;
            }
            if (!hVar.f2835i) {
                boolean z = hVar.f2836j;
                boolean z2 = !z;
                if (z != z2) {
                    hVar.f2836j = z2;
                    hVar.p.cancel();
                    hVar.o.start();
                }
                if (hVar.f2836j) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            hVar.f2835i = false;
        }
    }

    @Override // f.b.a.d.z.m
    public void a() {
        float dimensionPixelOffset = (float) this.b.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        g i2 = i(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        g i3 = i(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = i2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f2838l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, i2);
        this.f2838l.addState(new int[0], i3);
        this.a.setEndIconDrawable(e.b.b.a.a.b(this.b, R$drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new f());
        this.a.a(this.f2833g);
        TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.g0.add(this.f2834h);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = f.b.a.d.a.a.a;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration((long) 67);
        ofFloat.addUpdateListener(new i(this));
        this.p = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration((long) 50);
        ofFloat2.addUpdateListener(new i(this));
        this.o = ofFloat2;
        ofFloat2.addListener(new l(this));
        this.n = (AccessibilityManager) this.b.getSystemService("accessibility");
    }

    @Override // f.b.a.d.z.m
    public boolean b(int i2) {
        return i2 != 0;
    }

    @Override // f.b.a.d.z.m
    public boolean d() {
        return true;
    }

    public final g i(float f2, float f3, float f4, int i2) {
        j.b bVar = new j.b();
        bVar.f2789e = new f.b.a.d.v.a(f2);
        bVar.f2790f = new f.b.a.d.v.a(f2);
        bVar.f2792h = new f.b.a.d.v.a(f3);
        bVar.f2791g = new f.b.a.d.v.a(f3);
        f.b.a.d.v.j a2 = bVar.a();
        Context context = this.b;
        String str = g.x;
        int E1 = f.b.a.c.b.o.b.E1(context, R$attr.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.b.b = new f.b.a.d.n.a(context);
        gVar.y();
        gVar.q(ColorStateList.valueOf(E1));
        g.b bVar2 = gVar.b;
        if (bVar2.o != f4) {
            bVar2.o = f4;
            gVar.y();
        }
        gVar.b.a = a2;
        gVar.invalidateSelf();
        g.b bVar3 = gVar.b;
        if (bVar3.f2775i == null) {
            bVar3.f2775i = new Rect();
        }
        gVar.b.f2775i.set(0, i2, 0, i2);
        gVar.invalidateSelf();
        return gVar;
    }

    public final boolean j() {
        long currentTimeMillis = System.currentTimeMillis() - this.f2837k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }
}
