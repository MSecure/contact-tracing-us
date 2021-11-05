package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import b.b.a;
import b.b.f;
import b.b.g;
import b.b.h;
import b.b.j;
import b.b.p.i.i;
import b.b.p.i.n;
import b.b.q.y0;
import b.i.l.m;

public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: b  reason: collision with root package name */
    public i f35b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36c;

    /* renamed from: d  reason: collision with root package name */
    public RadioButton f37d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38e;
    public CheckBox f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public LinearLayout j;
    public Drawable k;
    public int l;
    public Context m;
    public boolean n;
    public Drawable o;
    public boolean p;
    public LayoutInflater q;
    public boolean r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2 = a.listMenuViewStyle;
        y0 q2 = y0.q(getContext(), attributeSet, j.MenuView, i2, 0);
        this.k = q2.g(j.MenuView_android_itemBackground);
        this.l = q2.l(j.MenuView_android_itemTextAppearance, -1);
        this.n = q2.a(j.MenuView_preserveIconSpacing, false);
        this.m = context;
        this.o = q2.g(j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, a.dropDownListViewStyle, 0);
        this.p = obtainStyledAttributes.hasValue(0);
        q2.f759b.recycle();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final void a() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f = checkBox;
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.addView(checkBox, -1);
        } else {
            addView(checkBox, -1);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.i;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            rect.top = this.i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    public final void b() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f37d = radioButton;
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.addView(radioButton, -1);
        } else {
            addView(radioButton, -1);
        }
    }

    public void c(boolean z) {
        String str;
        int i2;
        int i3 = (!z || !this.f35b.m()) ? 8 : 0;
        if (i3 == 0) {
            TextView textView = this.g;
            i iVar = this.f35b;
            char e2 = iVar.e();
            if (e2 == 0) {
                str = "";
            } else {
                Resources resources = iVar.n.f540a.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(iVar.n.f540a).hasPermanentMenuKey()) {
                    sb.append(resources.getString(h.abc_prepend_shortcut_label));
                }
                int i4 = iVar.n.n() ? iVar.k : iVar.i;
                i.c(sb, i4, 65536, resources.getString(h.abc_menu_meta_shortcut_label));
                i.c(sb, i4, 4096, resources.getString(h.abc_menu_ctrl_shortcut_label));
                i.c(sb, i4, 2, resources.getString(h.abc_menu_alt_shortcut_label));
                i.c(sb, i4, 1, resources.getString(h.abc_menu_shift_shortcut_label));
                i.c(sb, i4, 4, resources.getString(h.abc_menu_sym_shortcut_label));
                i.c(sb, i4, 8, resources.getString(h.abc_menu_function_shortcut_label));
                if (e2 == '\b') {
                    i2 = h.abc_menu_delete_shortcut_label;
                } else if (e2 == '\n') {
                    i2 = h.abc_menu_enter_shortcut_label;
                } else if (e2 != ' ') {
                    sb.append(e2);
                    str = sb.toString();
                } else {
                    i2 = h.abc_menu_space_shortcut_label;
                }
                sb.append(resources.getString(i2));
                str = sb.toString();
            }
            textView.setText(str);
        }
        if (this.g.getVisibility() != i3) {
            this.g.setVisibility(i3);
        }
    }

    @Override // b.b.p.i.n.a
    public boolean d() {
        return false;
    }

    @Override // b.b.p.i.n.a
    public void e(i iVar, int i2) {
        CharSequence charSequence;
        this.f35b = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (d()) {
            charSequence = iVar.getTitleCondensed();
        } else {
            charSequence = iVar.f552e;
        }
        setTitle(charSequence);
        setCheckable(iVar.isCheckable());
        boolean m2 = iVar.m();
        iVar.e();
        c(m2);
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.q);
    }

    @Override // b.b.p.i.n.a
    public i getItemData() {
        return this.f35b;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        m.W(this, this.k);
        TextView textView = (TextView) findViewById(f.title);
        this.f38e = textView;
        int i2 = this.l;
        if (i2 != -1) {
            textView.setTextAppearance(this.m, i2);
        }
        this.g = (TextView) findViewById(f.shortcut);
        ImageView imageView = (ImageView) findViewById(f.submenuarrow);
        this.h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.o);
        }
        this.i = (ImageView) findViewById(f.group_divider);
        this.j = (LinearLayout) findViewById(f.content);
    }

    public void onMeasure(int i2, int i3) {
        if (this.f36c != null && this.n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f36c.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f37d != null || this.f != null) {
            if (this.f35b.h()) {
                if (this.f37d == null) {
                    b();
                }
                compoundButton2 = this.f37d;
                compoundButton = this.f;
            } else {
                if (this.f == null) {
                    a();
                }
                compoundButton2 = this.f;
                compoundButton = this.f37d;
            }
            if (z) {
                compoundButton2.setChecked(this.f35b.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f37d;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f35b.h()) {
            if (this.f37d == null) {
                b();
            }
            compoundButton = this.f37d;
        } else {
            if (this.f == null) {
                a();
            }
            compoundButton = this.f;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility((this.p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f35b.n.s || this.r;
        if (!z && !this.n) {
            return;
        }
        if (this.f36c != null || drawable != null || this.n) {
            if (this.f36c == null) {
                ImageView imageView = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f36c = imageView;
                LinearLayout linearLayout = this.j;
                if (linearLayout != null) {
                    linearLayout.addView(imageView, 0);
                } else {
                    addView(imageView, 0);
                }
            }
            if (drawable != null || this.n) {
                ImageView imageView2 = this.f36c;
                if (!z) {
                    drawable = null;
                }
                imageView2.setImageDrawable(drawable);
                if (this.f36c.getVisibility() != 0) {
                    this.f36c.setVisibility(0);
                    return;
                }
                return;
            }
            this.f36c.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i2;
        if (charSequence != null) {
            this.f38e.setText(charSequence);
            if (this.f38e.getVisibility() != 0) {
                textView = this.f38e;
                i2 = 0;
            } else {
                return;
            }
        } else {
            i2 = 8;
            if (this.f38e.getVisibility() != 8) {
                textView = this.f38e;
            } else {
                return;
            }
        }
        textView.setVisibility(i2);
    }
}
