package b.b.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import b.b.c;
import b.b.e;
import b.b.q.n0;

public final class j {

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f867b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public static j f868c;

    /* renamed from: a  reason: collision with root package name */
    public n0 f869a;

    public class a implements n0.e {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f870a = {e.abc_textfield_search_default_mtrl_alpha, e.abc_textfield_default_mtrl_alpha, e.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b  reason: collision with root package name */
        public final int[] f871b = {e.abc_ic_commit_search_api_mtrl_alpha, e.abc_seekbar_tick_mark_material, e.abc_ic_menu_share_mtrl_alpha, e.abc_ic_menu_copy_mtrl_am_alpha, e.abc_ic_menu_cut_mtrl_alpha, e.abc_ic_menu_selectall_mtrl_alpha, e.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c  reason: collision with root package name */
        public final int[] f872c = {e.abc_textfield_activated_mtrl_alpha, e.abc_textfield_search_activated_mtrl_alpha, e.abc_cab_background_top_mtrl_alpha, e.abc_text_cursor_material, e.abc_text_select_handle_left_mtrl_dark, e.abc_text_select_handle_middle_mtrl_dark, e.abc_text_select_handle_right_mtrl_dark, e.abc_text_select_handle_left_mtrl_light, e.abc_text_select_handle_middle_mtrl_light, e.abc_text_select_handle_right_mtrl_light};

        /* renamed from: d  reason: collision with root package name */
        public final int[] f873d = {e.abc_popup_background_mtrl_mult, e.abc_cab_background_internal_bg, e.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e  reason: collision with root package name */
        public final int[] f874e = {e.abc_tab_indicator_material, e.abc_textfield_search_material};

        /* renamed from: f  reason: collision with root package name */
        public final int[] f875f = {e.abc_btn_check_material, e.abc_btn_radio_material, e.abc_btn_check_material_anim, e.abc_btn_radio_material_anim};

        public final boolean a(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList b(Context context, int i) {
            int c2 = t0.c(context, b.b.a.colorControlHighlight);
            int b2 = t0.b(context, b.b.a.colorButtonNormal);
            return new ColorStateList(new int[][]{t0.f939b, t0.f941d, t0.f940c, t0.f943f}, new int[]{b2, b.i.f.a.a(c2, i), b.i.f.a.a(c2, i), i});
        }

        public ColorStateList c(Context context, int i) {
            if (i == e.abc_edit_text_material) {
                return b.b.l.a.a.a(context, c.abc_tint_edittext);
            }
            if (i == e.abc_switch_track_mtrl_alpha) {
                return b.b.l.a.a.a(context, c.abc_tint_switch_track);
            }
            if (i == e.abc_switch_thumb_material) {
                int[][] iArr = new int[3][];
                int[] iArr2 = new int[3];
                ColorStateList d2 = t0.d(context, b.b.a.colorSwitchThumbNormal);
                if (d2 == null || !d2.isStateful()) {
                    iArr[0] = t0.f939b;
                    iArr2[0] = t0.b(context, b.b.a.colorSwitchThumbNormal);
                    iArr[1] = t0.f942e;
                    iArr2[1] = t0.c(context, b.b.a.colorControlActivated);
                    iArr[2] = t0.f943f;
                    iArr2[2] = t0.c(context, b.b.a.colorSwitchThumbNormal);
                } else {
                    iArr[0] = t0.f939b;
                    iArr2[0] = d2.getColorForState(iArr[0], 0);
                    iArr[1] = t0.f942e;
                    iArr2[1] = t0.c(context, b.b.a.colorControlActivated);
                    iArr[2] = t0.f943f;
                    iArr2[2] = d2.getDefaultColor();
                }
                return new ColorStateList(iArr, iArr2);
            } else if (i == e.abc_btn_default_mtrl_shape) {
                return b(context, t0.c(context, b.b.a.colorButtonNormal));
            } else {
                if (i == e.abc_btn_borderless_material) {
                    return b(context, 0);
                }
                if (i == e.abc_btn_colored_material) {
                    return b(context, t0.c(context, b.b.a.colorAccent));
                }
                if (i == e.abc_spinner_mtrl_am_alpha || i == e.abc_spinner_textfield_background_material) {
                    return b.b.l.a.a.a(context, c.abc_tint_spinner);
                }
                if (a(this.f871b, i)) {
                    return t0.d(context, b.b.a.colorControlNormal);
                }
                if (a(this.f874e, i)) {
                    return b.b.l.a.a.a(context, c.abc_tint_default);
                }
                if (a(this.f875f, i)) {
                    return b.b.l.a.a.a(context, c.abc_tint_btn_checkable);
                }
                if (i == e.abc_seekbar_thumb_material) {
                    return b.b.l.a.a.a(context, c.abc_tint_seek_thumb);
                }
                return null;
            }
        }

        public final void d(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.f867b;
            }
            drawable.setColorFilter(j.c(i, mode));
        }
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (f868c == null) {
                e();
            }
            jVar = f868c;
        }
        return jVar;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter h;
        synchronized (j.class) {
            h = n0.h(i, mode);
        }
        return h;
    }

    public static synchronized void e() {
        synchronized (j.class) {
            if (f868c == null) {
                j jVar = new j();
                f868c = jVar;
                jVar.f869a = n0.d();
                n0 n0Var = f868c.f869a;
                a aVar = new a();
                synchronized (n0Var) {
                    n0Var.f900g = aVar;
                }
            }
        }
    }

    public static void f(Drawable drawable, w0 w0Var, int[] iArr) {
        n0.l(drawable, w0Var, iArr);
    }

    public synchronized Drawable b(Context context, int i) {
        return this.f869a.f(context, i);
    }

    public synchronized ColorStateList d(Context context, int i) {
        return this.f869a.i(context, i);
    }
}
