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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import e.b.e.i.i;
import e.b.e.i.n;
import e.b.f.y0;
import e.i.i.m;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {
    public i b;
    public ImageView c;

    /* renamed from: d  reason: collision with root package name */
    public RadioButton f46d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f47e;

    /* renamed from: f  reason: collision with root package name */
    public CheckBox f48f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f50h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f51i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f52j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f53k;

    /* renamed from: l  reason: collision with root package name */
    public int f54l;
    public Context m;
    public boolean n;
    public Drawable o;
    public boolean p;
    public LayoutInflater q;
    public boolean r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2 = R$attr.listMenuViewStyle;
        y0 q2 = y0.q(getContext(), attributeSet, R$styleable.MenuView, i2, 0);
        this.f53k = q2.g(R$styleable.MenuView_android_itemBackground);
        this.f54l = q2.l(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.n = q2.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.m = context;
        this.o = q2.g(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R$attr.dropDownListViewStyle, 0);
        this.p = obtainStyledAttributes.hasValue(0);
        q2.b.recycle();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f50h;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final void a() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f48f = checkBox;
        LinearLayout linearLayout = this.f52j;
        if (linearLayout != null) {
            linearLayout.addView(checkBox, -1);
        } else {
            addView(checkBox, -1);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f51i;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f51i.getLayoutParams();
            rect.top = this.f51i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    public final void b() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f46d = radioButton;
        LinearLayout linearLayout = this.f52j;
        if (linearLayout != null) {
            linearLayout.addView(radioButton, -1);
        } else {
            addView(radioButton, -1);
        }
    }

    public void c(boolean z) {
        String str;
        int i2;
        int i3 = (!z || !this.b.m()) ? 8 : 0;
        if (i3 == 0) {
            TextView textView = this.f49g;
            i iVar = this.b;
            char e2 = iVar.e();
            if (e2 == 0) {
                str = "";
            } else {
                Resources resources = iVar.n.a.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(iVar.n.a).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R$string.abc_prepend_shortcut_label));
                }
                int i4 = iVar.n.n() ? iVar.f797k : iVar.f795i;
                i.c(sb, i4, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
                i.c(sb, i4, 4096, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
                i.c(sb, i4, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
                i.c(sb, i4, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
                i.c(sb, i4, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
                i.c(sb, i4, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
                if (e2 == '\b') {
                    i2 = R$string.abc_menu_delete_shortcut_label;
                } else if (e2 == '\n') {
                    i2 = R$string.abc_menu_enter_shortcut_label;
                } else if (e2 != ' ') {
                    sb.append(e2);
                    str = sb.toString();
                } else {
                    i2 = R$string.abc_menu_space_shortcut_label;
                }
                sb.append(resources.getString(i2));
                str = sb.toString();
            }
            textView.setText(str);
        }
        if (this.f49g.getVisibility() != i3) {
            this.f49g.setVisibility(i3);
        }
    }

    @Override // e.b.e.i.n.a
    public void d(i iVar, int i2) {
        this.b = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.f791e);
        setCheckable(iVar.isCheckable());
        boolean m2 = iVar.m();
        iVar.e();
        c(m2);
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.q);
    }

    @Override // e.b.e.i.n.a
    public i getItemData() {
        return this.b;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        Drawable drawable = this.f53k;
        AtomicInteger atomicInteger = m.a;
        setBackground(drawable);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f47e = textView;
        int i2 = this.f54l;
        if (i2 != -1) {
            textView.setTextAppearance(this.m, i2);
        }
        this.f49g = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f50h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.o);
        }
        this.f51i = (ImageView) findViewById(R$id.group_divider);
        this.f52j = (LinearLayout) findViewById(R$id.content);
    }

    public void onMeasure(int i2, int i3) {
        if (this.c != null && this.n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
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
        if (z || this.f46d != null || this.f48f != null) {
            if (this.b.h()) {
                if (this.f46d == null) {
                    b();
                }
                compoundButton2 = this.f46d;
                compoundButton = this.f48f;
            } else {
                if (this.f48f == null) {
                    a();
                }
                compoundButton2 = this.f48f;
                compoundButton = this.f46d;
            }
            if (z) {
                compoundButton2.setChecked(this.b.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f48f;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f46d;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.b.h()) {
            if (this.f46d == null) {
                b();
            }
            compoundButton = this.f46d;
        } else {
            if (this.f48f == null) {
                a();
            }
            compoundButton = this.f48f;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f51i;
        if (imageView != null) {
            imageView.setVisibility((this.p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        Objects.requireNonNull(this.b.n);
        boolean z = this.r;
        if (z || this.n) {
            ImageView imageView = this.c;
            if (imageView != null || drawable != null || this.n) {
                if (imageView == null) {
                    ImageView imageView2 = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                    this.c = imageView2;
                    LinearLayout linearLayout = this.f52j;
                    if (linearLayout != null) {
                        linearLayout.addView(imageView2, 0);
                    } else {
                        addView(imageView2, 0);
                    }
                }
                if (drawable != null || this.n) {
                    ImageView imageView3 = this.c;
                    if (!z) {
                        drawable = null;
                    }
                    imageView3.setImageDrawable(drawable);
                    if (this.c.getVisibility() != 0) {
                        this.c.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.c.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i2;
        if (charSequence != null) {
            this.f47e.setText(charSequence);
            if (this.f47e.getVisibility() != 0) {
                textView = this.f47e;
                i2 = 0;
            } else {
                return;
            }
        } else {
            i2 = 8;
            if (this.f47e.getVisibility() != 8) {
                textView = this.f47e;
            } else {
                return;
            }
        }
        textView.setVisibility(i2);
    }
}
