package c.b.a.b.x;

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
import b.i.l.m;
import b.l.d.l;
import b.l.d.z;
import b.x.t;
import c.b.a.b.d;
import c.b.a.b.e;
import c.b.a.b.f;
import c.b.a.b.h;
import c.b.a.b.h0.g;
import c.b.a.b.j;
import c.b.a.b.k;
import c.b.a.b.x.a;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class o<S> extends l {
    public static final Object s = "CONFIRM_BUTTON_TAG";
    public static final Object t = "CANCEL_BUTTON_TAG";
    public static final Object u = "TOGGLE_BUTTON_TAG";

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashSet<q<? super S>> f4597b = new LinkedHashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f4598c = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f4599d = new LinkedHashSet<>();

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnDismissListener> f4600e = new LinkedHashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public int f4601f;

    /* renamed from: g  reason: collision with root package name */
    public d<S> f4602g;
    public x<S> h;
    public a i;
    public g<S> j;
    public int k;
    public CharSequence l;
    public boolean m;
    public int n;
    public TextView o;
    public CheckableImageButton p;
    public g q;
    public Button r;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Iterator<q<? super S>> it = o.this.f4597b.iterator();
            while (it.hasNext()) {
                it.next().a(o.this.f4602g.b());
            }
            o.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Iterator<View.OnClickListener> it = o.this.f4598c.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            o.this.dismiss();
        }
    }

    public class c extends w<S> {
        public c() {
        }

        @Override // c.b.a.b.x.w
        public void a(S s) {
            o.this.i();
            o oVar = o.this;
            oVar.r.setEnabled(oVar.f4602g.m());
        }
    }

    public static int e(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(d.mtrl_calendar_content_padding);
        int i2 = s.y().f4614f;
        int dimensionPixelSize = resources.getDimensionPixelSize(d.mtrl_calendar_day_width) * i2;
        return ((i2 - 1) * resources.getDimensionPixelOffset(d.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean f(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(t.B2(context, c.b.a.b.b.materialCalendarStyle, g.class.getCanonicalName()), new int[]{16843277});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public static long h() {
        return s.y().h;
    }

    public final void g() {
        x<S> xVar;
        d<S> dVar = this.f4602g;
        Context requireContext = requireContext();
        int i2 = this.f4601f;
        if (i2 == 0) {
            i2 = this.f4602g.f(requireContext);
        }
        a aVar = this.i;
        g<S> gVar = new g<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.f4541d);
        gVar.setArguments(bundle);
        this.j = gVar;
        if (this.p.isChecked()) {
            d<S> dVar2 = this.f4602g;
            a aVar2 = this.i;
            xVar = new r<>();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("DATE_SELECTOR_KEY", dVar2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar2);
            xVar.setArguments(bundle2);
        } else {
            xVar = this.j;
        }
        this.h = xVar;
        i();
        z childFragmentManager = getChildFragmentManager();
        if (childFragmentManager != null) {
            b.l.d.a aVar3 = new b.l.d.a(childFragmentManager);
            aVar3.h(f.mtrl_calendar_frame, this.h, null);
            aVar3.e();
            x<S> xVar2 = this.h;
            xVar2.f4629b.add(new c());
            return;
        }
        throw null;
    }

    public final void i() {
        String d2 = this.f4602g.d(getContext());
        this.o.setContentDescription(String.format(getString(j.mtrl_picker_announce_current_selection), d2));
        this.o.setText(d2);
    }

    public final void j(CheckableImageButton checkableImageButton) {
        this.p.setContentDescription(checkableImageButton.getContext().getString(this.p.isChecked() ? j.mtrl_picker_toggle_to_calendar_input_mode : j.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // b.l.d.l
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f4599d.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment, b.l.d.l
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f4601f = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f4602g = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.i = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.n = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // b.l.d.l
    public final Dialog onCreateDialog(Bundle bundle) {
        Context requireContext = requireContext();
        Context requireContext2 = requireContext();
        int i2 = this.f4601f;
        if (i2 == 0) {
            i2 = this.f4602g.f(requireContext2);
        }
        Dialog dialog = new Dialog(requireContext, i2);
        Context context = dialog.getContext();
        this.m = f(context);
        int B2 = t.B2(context, c.b.a.b.b.colorSurface, o.class.getCanonicalName());
        g gVar = new g(context, null, c.b.a.b.b.materialCalendarStyle, k.Widget_MaterialComponents_MaterialCalendar);
        this.q = gVar;
        gVar.o(context);
        this.q.r(ColorStateList.valueOf(B2));
        this.q.q(m.l(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.m ? h.mtrl_picker_fullscreen : h.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.m) {
            inflate.findViewById(f.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(e(context), -2));
        } else {
            View findViewById = inflate.findViewById(f.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(f.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(e(context), -1));
            Resources resources = requireContext().getResources();
            findViewById2.setMinimumHeight(resources.getDimensionPixelOffset(d.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(d.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(d.mtrl_calendar_navigation_height) + resources.getDimensionPixelSize(d.mtrl_calendar_days_of_week_height) + (resources.getDimensionPixelOffset(d.mtrl_calendar_month_vertical_padding) * (t.f4616f - 1)) + (resources.getDimensionPixelSize(d.mtrl_calendar_day_height) * t.f4616f) + resources.getDimensionPixelOffset(d.mtrl_calendar_bottom_padding));
        }
        TextView textView = (TextView) inflate.findViewById(f.mtrl_picker_header_selection_text);
        this.o = textView;
        m.W(textView, 1);
        this.p = (CheckableImageButton) inflate.findViewById(f.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(f.mtrl_picker_title_text);
        CharSequence charSequence = this.l;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.k);
        }
        this.p.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.p;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, b.b.l.a.a.b(context, e.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], b.b.l.a.a.b(context, e.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.p.setChecked(this.n != 0);
        m.U(this.p, null);
        j(this.p);
        this.p.setOnClickListener(new p(this));
        this.r = (Button) inflate.findViewById(f.confirm_button);
        if (this.f4602g.m()) {
            this.r.setEnabled(true);
        } else {
            this.r.setEnabled(false);
        }
        this.r.setTag("CONFIRM_BUTTON_TAG");
        this.r.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(f.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // b.l.d.l
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f4600e.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment, b.l.d.l
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f4601f);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f4602g);
        a.b bVar = new a.b(this.i);
        s sVar = this.j.f4577f;
        if (sVar != null) {
            bVar.f4549c = Long.valueOf(sVar.h);
        }
        if (bVar.f4549c == null) {
            long h2 = h();
            if (bVar.f4547a > h2 || h2 > bVar.f4548b) {
                h2 = bVar.f4547a;
            }
            bVar.f4549c = Long.valueOf(h2);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", bVar.f4550d);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new a(s.x(bVar.f4547a), s.x(bVar.f4548b), s.x(bVar.f4549c.longValue()), (a.c) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY"), null));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.l);
    }

    @Override // androidx.fragment.app.Fragment, b.l.d.l
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.q);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.q, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new c.b.a.b.y.a(requireDialog(), rect));
        }
        g();
    }

    @Override // androidx.fragment.app.Fragment, b.l.d.l
    public void onStop() {
        this.h.f4629b.clear();
        super.onStop();
    }
}
