package f.b.a.e.y;

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
import e.j.j.v;
import f.b.a.e.q.j;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class h extends m {

    /* renamed from: e */
    public final TextWatcher f3133e = new a();

    /* renamed from: f */
    public final View.OnFocusChangeListener f3134f = new b();

    /* renamed from: g */
    public final TextInputLayout.e f3135g = new c(this.a);

    /* renamed from: h */
    public final TextInputLayout.f f3136h = new d();

    /* renamed from: i */
    public final TextInputLayout.g f3137i = new e();

    /* renamed from: j */
    public boolean f3138j = false;

    /* renamed from: k */
    public boolean f3139k = false;

    /* renamed from: l */
    public long f3140l = Long.MAX_VALUE;
    public StateListDrawable m;
    public g n;
    public AccessibilityManager o;
    public ValueAnimator p;
    public ValueAnimator q;

    /* loaded from: classes.dex */
    public class a extends j {

        /* renamed from: f.b.a.e.y.h$a$a */
        /* loaded from: classes.dex */
        public class RunnableC0103a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView b;

            public RunnableC0103a(AutoCompleteTextView autoCompleteTextView) {
                a.this = r1;
                this.b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.b.isPopupShowing();
                h.g(h.this, isPopupShowing);
                h.this.f3138j = isPopupShowing;
            }
        }

        public a() {
            h.this = r1;
        }

        @Override // f.b.a.e.q.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView e2 = h.e(h.this.a.getEditText());
            if (h.this.o.isTouchExplorationEnabled() && h.f(e2) && !h.this.c.hasFocus()) {
                e2.dismissDropDown();
            }
            e2.post(new RunnableC0103a(e2));
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
            h.this = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            h.this.a.setEndIconActivated(z);
            if (!z) {
                h.g(h.this, false);
                h.this.f3138j = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends TextInputLayout.e {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
            h.this = r1;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, e.j.j.c
        public void d(View view, e.j.j.c0.b bVar) {
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

        @Override // e.j.j.c
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView e2 = h.e(h.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && h.this.o.isTouchExplorationEnabled() && !h.f(h.this.a.getEditText())) {
                h.h(h.this, e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements TextInputLayout.f {
        public d() {
            h.this = r1;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0105  */
        @Override // com.google.android.material.textfield.TextInputLayout.f
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void a(TextInputLayout textInputLayout) {
            boolean z;
            Drawable drawable;
            AutoCompleteTextView e2 = h.e(textInputLayout.getEditText());
            h hVar = h.this;
            int boxBackgroundMode = hVar.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = hVar.n;
            } else {
                if (boxBackgroundMode == 1) {
                    drawable = hVar.m;
                }
                h hVar2 = h.this;
                Objects.requireNonNull(hVar2);
                z = false;
                if (!(e2.getKeyListener() == null)) {
                    int boxBackgroundMode2 = hVar2.a.getBoxBackgroundMode();
                    g boxBackground = hVar2.a.getBoxBackground();
                    int x0 = f.b.a.c.b.o.b.x0(e2, R$attr.colorControlHighlight);
                    int[][] iArr = {new int[]{16842919}, new int[0]};
                    if (boxBackgroundMode2 == 2) {
                        int x02 = f.b.a.c.b.o.b.x0(e2, R$attr.colorSurface);
                        g gVar = new g(boxBackground.b.a);
                        int b1 = f.b.a.c.b.o.b.b1(x0, x02, 0.1f);
                        gVar.r(new ColorStateList(iArr, new int[]{b1, 0}));
                        gVar.setTint(x02);
                        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{b1, x02});
                        g gVar2 = new g(boxBackground.b.a);
                        gVar2.setTint(-1);
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar, gVar2), boxBackground});
                        AtomicInteger atomicInteger = v.a;
                        v.d.q(e2, layerDrawable);
                    } else if (boxBackgroundMode2 == 1) {
                        int boxBackgroundColor = hVar2.a.getBoxBackgroundColor();
                        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, new int[]{f.b.a.c.b.o.b.b1(x0, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground);
                        AtomicInteger atomicInteger2 = v.a;
                        v.d.q(e2, rippleDrawable);
                    }
                }
                h hVar3 = h.this;
                Objects.requireNonNull(hVar3);
                e2.setOnTouchListener(new j(hVar3, e2));
                e2.setOnFocusChangeListener(hVar3.f3134f);
                e2.setOnDismissListener(new k(hVar3));
                e2.setThreshold(0);
                e2.removeTextChangedListener(h.this.f3133e);
                e2.addTextChangedListener(h.this.f3133e);
                textInputLayout.setEndIconCheckable(true);
                textInputLayout.setErrorIconDrawable((Drawable) null);
                if (e2.getKeyListener() != null) {
                    z = true;
                }
                if (!z) {
                    CheckableImageButton checkableImageButton = h.this.c;
                    AtomicInteger atomicInteger3 = v.a;
                    v.d.s(checkableImageButton, 2);
                }
                textInputLayout.setTextInputAccessibilityDelegate(h.this.f3135g);
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
            e2.setOnFocusChangeListener(hVar32.f3134f);
            e2.setOnDismissListener(new k(hVar32));
            e2.setThreshold(0);
            e2.removeTextChangedListener(h.this.f3133e);
            e2.addTextChangedListener(h.this.f3133e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (e2.getKeyListener() != null) {
            }
            if (!z) {
            }
            textInputLayout.setTextInputAccessibilityDelegate(h.this.f3135g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* loaded from: classes.dex */
    public class e implements TextInputLayout.g {

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView b;

            public a(AutoCompleteTextView autoCompleteTextView) {
                e.this = r1;
                this.b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.b.removeTextChangedListener(h.this.f3133e);
            }
        }

        public e() {
            h.this = r1;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i2 == 3) {
                autoCompleteTextView.post(new a(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == h.this.f3134f) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public f() {
            h.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.h(h.this, (AutoCompleteTextView) h.this.a.getEditText());
        }
    }

    public h(TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
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
        if (hVar.f3139k != z) {
            hVar.f3139k = z;
            hVar.q.cancel();
            hVar.p.start();
        }
    }

    public static void h(h hVar, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(hVar);
        if (autoCompleteTextView != null) {
            if (hVar.j()) {
                hVar.f3138j = false;
            }
            if (!hVar.f3138j) {
                boolean z = hVar.f3139k;
                boolean z2 = !z;
                if (z != z2) {
                    hVar.f3139k = z2;
                    hVar.q.cancel();
                    hVar.p.start();
                }
                if (hVar.f3139k) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            hVar.f3138j = false;
        }
    }

    @Override // f.b.a.e.y.m
    public void a() {
        float dimensionPixelOffset = (float) this.b.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        g i2 = i(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        g i3 = i(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.n = i2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.m = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, i2);
        this.m.addState(new int[0], i3);
        int i4 = this.f3142d;
        if (i4 == 0) {
            i4 = R$drawable.mtrl_dropdown_arrow;
        }
        this.a.setEndIconDrawable(i4);
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new f());
        this.a.a(this.f3136h);
        this.a.k0.add(this.f3137i);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.a;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration((long) 67);
        ofFloat.addUpdateListener(new i(this));
        this.q = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration((long) 50);
        ofFloat2.addUpdateListener(new i(this));
        this.p = ofFloat2;
        ofFloat2.addListener(new l(this));
        this.o = (AccessibilityManager) this.b.getSystemService("accessibility");
    }

    @Override // f.b.a.e.y.m
    public boolean b(int i2) {
        return i2 != 0;
    }

    @Override // f.b.a.e.y.m
    public boolean d() {
        return true;
    }

    public final g i(float f2, float f3, float f4, int i2) {
        j.b bVar = new j.b();
        bVar.f3096e = new f.b.a.e.v.a(f2);
        bVar.f3097f = new f.b.a.e.v.a(f2);
        bVar.f3099h = new f.b.a.e.v.a(f3);
        bVar.f3098g = new f.b.a.e.v.a(f3);
        f.b.a.e.v.j a2 = bVar.a();
        Context context = this.b;
        String str = g.y;
        int n1 = f.b.a.c.b.o.b.n1(context, R$attr.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.b.b = new f.b.a.e.n.a(context);
        gVar.z();
        gVar.r(ColorStateList.valueOf(n1));
        g.b bVar2 = gVar.b;
        if (bVar2.o != f4) {
            bVar2.o = f4;
            gVar.z();
        }
        gVar.b.a = a2;
        gVar.invalidateSelf();
        g.b bVar3 = gVar.b;
        if (bVar3.f3082i == null) {
            bVar3.f3082i = new Rect();
        }
        gVar.b.f3082i.set(0, i2, 0, i2);
        gVar.invalidateSelf();
        return gVar;
    }

    public final boolean j() {
        long currentTimeMillis = System.currentTimeMillis() - this.f3140l;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }
}
