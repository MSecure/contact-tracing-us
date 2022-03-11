package f.b.a.e.l;

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
import e.b.a.m;
import e.j.j.v;
import e.o.a.l;
import f.b.a.e.l.a;
import f.b.a.e.v.g;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class q<S> extends l {
    public static final /* synthetic */ int D0;
    public CheckableImageButton A0;
    public g B0;
    public Button C0;
    public final LinkedHashSet<s<? super S>> m0 = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> n0 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> o0 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> p0 = new LinkedHashSet<>();
    public int q0;
    public f<S> r0;
    public z<S> s0;
    public a t0;
    public i<S> u0;
    public int v0;
    public CharSequence w0;
    public boolean x0;
    public int y0;
    public TextView z0;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
            q.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<s<? super S>> it = q.this.m0.iterator();
            while (it.hasNext()) {
                it.next().a((S) q.this.L0().a());
            }
            q.this.H0(false, false);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
            q.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<View.OnClickListener> it = q.this.n0.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            q.this.H0(false, false);
        }
    }

    /* loaded from: classes.dex */
    public class c extends y<S> {
        public c() {
            q.this = r1;
        }

        @Override // f.b.a.e.l.y
        public void a() {
            q.this.C0.setEnabled(false);
        }

        @Override // f.b.a.e.l.y
        public void b(S s) {
            q qVar = q.this;
            int i2 = q.D0;
            qVar.Q0();
            q qVar2 = q.this;
            qVar2.C0.setEnabled(qVar2.L0().h());
        }
    }

    /* loaded from: classes.dex */
    public static final class d<S> {
        public static boolean a(u uVar, a aVar) {
            return uVar.compareTo(aVar.b) >= 0 && uVar.compareTo(aVar.c) <= 0;
        }
    }

    public static int M0(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i2 = u.r().f2947e;
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i2;
        return ((i2 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean N0(Context context) {
        return O0(context, 16843277);
    }

    public static boolean O0(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f.b.a.c.b.o.b.n1(context, R$attr.materialCalendarStyle, i.class.getCanonicalName()), new int[]{i2});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    @Override // e.o.a.l
    public final Dialog I0(Bundle bundle) {
        Context v0 = v0();
        Context v02 = v0();
        int i2 = this.q0;
        if (i2 == 0) {
            i2 = L0().c(v02);
        }
        Dialog dialog = new Dialog(v0, i2);
        Context context = dialog.getContext();
        this.x0 = N0(context);
        int n1 = f.b.a.c.b.o.b.n1(context, R$attr.colorSurface, q.class.getCanonicalName());
        g gVar = new g(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        this.B0 = gVar;
        gVar.o(context);
        this.B0.r(ColorStateList.valueOf(n1));
        g gVar2 = this.B0;
        View decorView = dialog.getWindow().getDecorView();
        AtomicInteger atomicInteger = v.a;
        gVar2.q(v.i.i(decorView));
        return dialog;
    }

    public final f<S> L0() {
        if (this.r0 == null) {
            this.r0 = (f) this.f1812g.getParcelable("DATE_SELECTOR_KEY");
        }
        return this.r0;
    }

    public final void P0() {
        z<S> zVar;
        Context v0 = v0();
        int i2 = this.q0;
        if (i2 == 0) {
            i2 = L0().c(v0);
        }
        f<S> L0 = L0();
        a aVar = this.t0;
        i<S> iVar = new i<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", L0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.f2922e);
        iVar.A0(bundle);
        this.u0 = iVar;
        if (this.A0.isChecked()) {
            f<S> L02 = L0();
            a aVar2 = this.t0;
            zVar = new t<>();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i2);
            bundle2.putParcelable("DATE_SELECTOR_KEY", L02);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar2);
            zVar.A0(bundle2);
        } else {
            zVar = this.u0;
        }
        this.s0 = zVar;
        Q0();
        e.o.a.a aVar3 = new e.o.a.a(j());
        aVar3.g(R$id.mtrl_calendar_frame, this.s0, null);
        if (!aVar3.f1830g) {
            aVar3.f1831h = false;
            aVar3.q.D(aVar3, false);
            this.s0.H0(new c());
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public final void Q0() {
        String b2 = L0().b(k());
        this.z0.setContentDescription(String.format(F(R$string.mtrl_picker_announce_current_selection), b2));
        this.z0.setText(b2);
    }

    public final void R0(CheckableImageButton checkableImageButton) {
        this.A0.setContentDescription(checkableImageButton.getContext().getString(this.A0.isChecked() ? R$string.mtrl_picker_toggle_to_calendar_input_mode : R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // e.o.a.l, e.o.a.m
    public final void S(Bundle bundle) {
        super.S(bundle);
        if (bundle == null) {
            bundle = this.f1812g;
        }
        this.q0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.r0 = (f) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.t0 = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.v0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.w0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.y0 = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // e.o.a.m
    public final View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        LinearLayout.LayoutParams layoutParams;
        View inflate = layoutInflater.inflate(this.x0 ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.x0) {
            view = inflate.findViewById(R$id.mtrl_calendar_frame);
            layoutParams = new LinearLayout.LayoutParams(M0(context), -2);
        } else {
            view = inflate.findViewById(R$id.mtrl_calendar_main_pane);
            layoutParams = new LinearLayout.LayoutParams(M0(context), -1);
        }
        view.setLayoutParams(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.z0 = textView;
        AtomicInteger atomicInteger = v.a;
        v.g.f(textView, 1);
        this.A0 = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.w0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.v0);
        }
        this.A0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.A0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, m.e.i0(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], m.e.i0(context, R$drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.A0.setChecked(this.y0 != 0);
        v.u(this.A0, null);
        R0(this.A0);
        this.A0.setOnClickListener(new r(this));
        this.C0 = (Button) inflate.findViewById(R$id.confirm_button);
        if (L0().h()) {
            this.C0.setEnabled(true);
        } else {
            this.C0.setEnabled(false);
        }
        this.C0.setTag("CONFIRM_BUTTON_TAG");
        this.C0.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // e.o.a.l, e.o.a.m
    public final void j0(Bundle bundle) {
        super.j0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.q0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.r0);
        a.b bVar = new a.b(this.t0);
        u uVar = this.u0.a0;
        if (uVar != null) {
            bVar.c = Long.valueOf(uVar.f2949g);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.v0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.w0);
    }

    @Override // e.o.a.l, e.o.a.m
    public void k0() {
        super.k0();
        Window window = J0().getWindow();
        if (this.x0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.B0);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = B().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.B0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new f.b.a.e.m.a(J0(), rect));
        }
        P0();
    }

    @Override // e.o.a.l, e.o.a.m
    public void l0() {
        this.s0.W.clear();
        this.D = true;
        Dialog dialog = this.h0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // e.o.a.l, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.o0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
    }

    @Override // e.o.a.l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.p0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.F;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }
}
