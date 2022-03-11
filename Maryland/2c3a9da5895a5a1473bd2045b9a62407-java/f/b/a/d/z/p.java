package f.b.a.d.z;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.textfield.TextInputLayout;
import e.b.f.d;
import e.b.f.k0;
import f.b.a.d.a0.a.a;
import f.b.a.d.q.k;
import java.util.Locale;

public class p extends d {

    /* renamed from: e  reason: collision with root package name */
    public final k0 f2955e;

    /* renamed from: f  reason: collision with root package name */
    public final AccessibilityManager f2956f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f2957g = new Rect();

    /* JADX WARNING: Illegal instructions before constructor call */
    public p(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, r3, 0), attributeSet, r3);
        int i2 = R$attr.autoCompleteTextViewStyle;
        Context context2 = getContext();
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, i2, R$style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i3 = R$styleable.MaterialAutoCompleteTextView_android_inputType;
        if (d2.hasValue(i3) && d2.getInt(i3, 0) == 0) {
            setKeyListener(null);
        }
        this.f2956f = (AccessibilityManager) context2.getSystemService("accessibility");
        k0 k0Var = new k0(context2, null, androidx.appcompat.R$attr.listPopupWindowStyle, 0);
        this.f2955e = k0Var;
        k0Var.s(true);
        k0Var.q = this;
        k0Var.A.setInputMethodMode(2);
        k0Var.o(getAdapter());
        k0Var.r = new o(this);
        d2.recycle();
    }

    public static void a(p pVar, Object obj) {
        pVar.setText(pVar.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public CharSequence getHint() {
        TextInputLayout b = b();
        return (b == null || !b.B) ? super.getHint() : b.getHint();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b = b();
        if (b != null && b.B && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b = b();
            int i4 = 0;
            if (!(adapter == null || b == null)) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                k0 k0Var = this.f2955e;
                int min = Math.min(adapter.getCount(), Math.max(0, !k0Var.c() ? -1 : k0Var.f912d.getSelectedItemPosition()) + 15);
                View view = null;
                int i5 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i4) {
                        view = null;
                        i4 = itemViewType;
                    }
                    view = adapter.getView(max, view, b);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i5 = Math.max(i5, view.getMeasuredWidth());
                }
                Drawable i6 = this.f2955e.i();
                if (i6 != null) {
                    i6.getPadding(this.f2957g);
                    Rect rect = this.f2957g;
                    i5 += rect.left + rect.right;
                }
                i4 = b.getEndIconView().getMeasuredWidth() + i5;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i4), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f2955e.o(getAdapter());
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f2956f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f2955e.a();
        }
    }
}
