package f.b.a.d.l;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.internal.CheckableImageButton;
import e.i.i.m;
import e.m.a.k;
import f.b.a.d.l.a;
import f.b.a.d.v.g;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

public final class q<S> extends k {
    public static final /* synthetic */ int E0 = 0;
    public TextView A0;
    public CheckableImageButton B0;
    public g C0;
    public Button D0;
    public final LinkedHashSet<s<? super S>> n0 = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> o0 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> p0 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> q0 = new LinkedHashSet<>();
    public int r0;
    public f<S> s0;
    public z<S> t0;
    public a u0;
    public i<S> v0;
    public int w0;
    public CharSequence x0;
    public boolean y0;
    public int z0;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Iterator<s<? super S>> it = q.this.n0.iterator();
            while (it.hasNext()) {
                it.next().a(q.this.s0.a());
            }
            q.this.y0(false, false);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Iterator<View.OnClickListener> it = q.this.o0.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            q.this.y0(false, false);
        }
    }

    public class c extends y<S> {
        public c() {
        }

        @Override // f.b.a.d.l.y
        public void a() {
            q.this.D0.setEnabled(false);
        }

        @Override // f.b.a.d.l.y
        public void b(S s) {
            q qVar = q.this;
            int i2 = q.E0;
            qVar.G0();
            q qVar2 = q.this;
            qVar2.D0.setEnabled(qVar2.s0.h());
        }
    }

    public static int C0(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i2 = u.r().f2744e;
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i2;
        return ((i2 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean D0(Context context) {
        return E0(context, 16843277);
    }

    public static boolean E0(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f.b.a.c.b.o.b.D1(context, R$attr.materialCalendarStyle, i.class.getCanonicalName()), new int[]{i2});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final void F0() {
        z<S> zVar;
        Context n02 = n0();
        int i2 = this.r0;
        if (i2 == 0) {
            i2 = this.s0.c(n02);
        }
        f<S> fVar = this.s0;
        a aVar = this.u0;
        i<S> iVar = new i<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", fVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.f2719e);
        iVar.s0(bundle);
        this.v0 = iVar;
        if (this.B0.isChecked()) {
            f<S> fVar2 = this.s0;
            a aVar2 = this.u0;
            zVar = new t<>();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i2);
            bundle2.putParcelable("DATE_SELECTOR_KEY", fVar2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar2);
            zVar.s0(bundle2);
        } else {
            zVar = this.v0;
        }
        this.t0 = zVar;
        G0();
        e.m.a.a aVar3 = new e.m.a.a(j());
        aVar3.f(R$id.mtrl_calendar_frame, this.t0, null);
        aVar3.d();
        this.t0.y0(new c());
    }

    public final void G0() {
        String b2 = this.s0.b(k());
        this.A0.setContentDescription(String.format(z(R$string.mtrl_picker_announce_current_selection), b2));
        this.A0.setText(b2);
    }

    public final void H0(CheckableImageButton checkableImageButton) {
        this.B0.setContentDescription(checkableImageButton.getContext().getString(this.B0.isChecked() ? R$string.mtrl_picker_toggle_to_calendar_input_mode : R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // e.m.a.k, e.m.a.l
    public final void N(Bundle bundle) {
        super.N(bundle);
        if (bundle == null) {
            bundle = this.f1632g;
        }
        this.r0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.s0 = (f) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.u0 = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.w0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.x0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.z0 = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // e.m.a.l
    public final View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.y0 ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.y0) {
            inflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(C0(context), -2));
        } else {
            View findViewById = inflate.findViewById(R$id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R$id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(C0(context), -1));
            Resources resources = n0().getResources();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height);
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
            int i2 = v.f2748g;
            findViewById2.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding) * (i2 - 1)) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i2) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding));
        }
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.A0 = textView;
        AtomicInteger atomicInteger = m.a;
        textView.setAccessibilityLiveRegion(1);
        this.B0 = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.x0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.w0);
        }
        this.B0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.B0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, e.b.b.a.a.b(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], e.b.b.a.a.b(context, R$drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.B0.setChecked(this.z0 != 0);
        m.r(this.B0, null);
        H0(this.B0);
        this.B0.setOnClickListener(new r(this));
        this.D0 = (Button) inflate.findViewById(R$id.confirm_button);
        if (this.s0.h()) {
            this.D0.setEnabled(true);
        } else {
            this.D0.setEnabled(false);
        }
        this.D0.setTag("CONFIRM_BUTTON_TAG");
        this.D0.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // e.m.a.k, e.m.a.l
    public final void d0(Bundle bundle) {
        super.d0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.r0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.s0);
        a.b bVar = new a.b(this.u0);
        u uVar = this.v0.b0;
        if (uVar != null) {
            bVar.c = Long.valueOf(uVar.f2746g);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.w0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.x0);
    }

    @Override // e.m.a.k, e.m.a.l
    public void e0() {
        this.D = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.j0 = false;
            dialog.show();
        }
        Window window = A0().getWindow();
        if (this.y0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.C0);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = v().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.C0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new f.b.a.d.m.a(A0(), rect));
        }
        F0();
    }

    @Override // e.m.a.k, e.m.a.l
    public void f0() {
        this.t0.X.clear();
        this.D = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // e.m.a.k
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.p0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
    }

    @Override // e.m.a.k
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.q0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.F;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // e.m.a.k
    public final Dialog z0(Bundle bundle) {
        Context n02 = n0();
        Context n03 = n0();
        int i2 = this.r0;
        if (i2 == 0) {
            i2 = this.s0.c(n03);
        }
        Dialog dialog = new Dialog(n02, i2);
        Context context = dialog.getContext();
        this.y0 = D0(context);
        int D1 = f.b.a.c.b.o.b.D1(context, R$attr.colorSurface, q.class.getCanonicalName());
        g gVar = new g(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        this.C0 = gVar;
        gVar.n(context);
        this.C0.q(ColorStateList.valueOf(D1));
        g gVar2 = this.C0;
        View decorView = dialog.getWindow().getDecorView();
        AtomicInteger atomicInteger = m.a;
        gVar2.p(decorView.getElevation());
        return dialog;
    }
}
