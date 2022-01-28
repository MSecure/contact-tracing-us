package c.b.a.b.l0;

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
import b.b.q.d;
import b.b.q.k0;
import c.b.a.b.b;
import c.b.a.b.c0.k;
import c.b.a.b.l;
import c.b.a.b.m0.a.a;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;

public class p extends d {

    /* renamed from: e  reason: collision with root package name */
    public final k0 f4400e;

    /* renamed from: f  reason: collision with root package name */
    public final AccessibilityManager f4401f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f4402g = new Rect();

    /* JADX WARNING: Illegal instructions before constructor call */
    public p(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, r3, 0), attributeSet, r3);
        int i = b.autoCompleteTextViewStyle;
        Context context2 = getContext();
        TypedArray d2 = k.d(context2, attributeSet, l.MaterialAutoCompleteTextView, i, c.b.a.b.k.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (d2.hasValue(l.MaterialAutoCompleteTextView_android_inputType) && d2.getInt(l.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.f4401f = (AccessibilityManager) context2.getSystemService("accessibility");
        k0 k0Var = new k0(context2, null, b.b.a.listPopupWindowStyle, 0);
        this.f4400e = k0Var;
        k0Var.s(true);
        k0 k0Var2 = this.f4400e;
        k0Var2.s = this;
        k0Var2.C.setInputMethodMode(2);
        this.f4400e.o(getAdapter());
        this.f4400e.t = new o(this);
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
        TextInputLayout b2 = b();
        return (b2 == null || !b2.B) ? super.getHint() : b2.getHint();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b2 = b();
        if (b2 != null && b2.B && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b2 = b();
            int i3 = 0;
            if (!(adapter == null || b2 == null)) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                k0 k0Var = this.f4400e;
                int min = Math.min(adapter.getCount(), Math.max(0, !k0Var.c() ? -1 : k0Var.f879d.getSelectedItemPosition()) + 15);
                View view = null;
                int i4 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i3) {
                        view = null;
                        i3 = itemViewType;
                    }
                    view = adapter.getView(max, view, b2);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i4 = Math.max(i4, view.getMeasuredWidth());
                }
                Drawable i5 = this.f4400e.i();
                if (i5 != null) {
                    i5.getPadding(this.f4402g);
                    Rect rect = this.f4402g;
                    i4 += rect.left + rect.right;
                }
                i3 = b2.getEndIconView().getMeasuredWidth() + i4;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i3), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f4400e.o(getAdapter());
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager;
        if (getInputType() != 0 || (accessibilityManager = this.f4401f) == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f4400e.a();
        }
    }
}
