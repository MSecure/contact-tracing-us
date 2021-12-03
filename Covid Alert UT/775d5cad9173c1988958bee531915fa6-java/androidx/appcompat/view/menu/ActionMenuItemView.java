package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView;
import e.b.a.m;
import e.b.e.i.g;
import e.b.e.i.i;
import e.b.e.i.n;
import e.b.e.i.p;
import e.b.f.c;
import e.b.f.d0;
import e.b.f.l0;

public class ActionMenuItemView extends d0 implements n.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: h  reason: collision with root package name */
    public i f40h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f41i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f42j;

    /* renamed from: k  reason: collision with root package name */
    public g.b f43k;

    /* renamed from: l  reason: collision with root package name */
    public l0 f44l;
    public b m;
    public boolean n = e();
    public boolean o;
    public int p;
    public int q;
    public int r;

    public class a extends l0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // e.b.f.l0
        public p b() {
            c.a aVar;
            b bVar = ActionMenuItemView.this.m;
            if (bVar == null || (aVar = c.this.v) == null) {
                return null;
            }
            return aVar.a();
        }

        @Override // e.b.f.l0
        public boolean c() {
            p b;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f43k;
            return bVar != null && bVar.a(actionMenuItemView.f40h) && (b = b()) != null && b.c();
        }
    }

    public static abstract class b {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, 0, 0);
        this.p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.q = -1;
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return c();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return c() && this.f40h.getIcon() == null;
    }

    public boolean c() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // e.b.e.i.n.a
    public void d(i iVar, int i2) {
        this.f40h = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitleCondensed());
        setId(iVar.a);
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f44l == null) {
            this.f44l = new a();
        }
    }

    public final boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void f() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f41i);
        if (this.f42j != null) {
            if (!((this.f40h.y & 4) == 4) || (!this.n && !this.o)) {
                z = false;
            }
        }
        boolean z3 = z2 & z;
        CharSequence charSequence = null;
        setText(z3 ? this.f41i : null);
        CharSequence charSequence2 = this.f40h.q;
        if (TextUtils.isEmpty(charSequence2)) {
            if (z3) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f40h.f799e;
            }
        }
        setContentDescription(charSequence2);
        CharSequence charSequence3 = this.f40h.r;
        if (TextUtils.isEmpty(charSequence3)) {
            if (!z3) {
                charSequence = this.f40h.f799e;
            }
            m.e.z1(this, charSequence);
            return;
        }
        m.e.z1(this, charSequence3);
    }

    @Override // e.b.e.i.n.a
    public i getItemData() {
        return this.f40h;
    }

    public void onClick(View view) {
        g.b bVar = this.f43k;
        if (bVar != null) {
            bVar.a(this.f40h);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.n = e();
        f();
    }

    @Override // e.b.f.d0
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean c = c();
        if (c && (i4 = this.q) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.p) : this.p;
        if (mode != 1073741824 && this.p > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i3);
        }
        if (!c && this.f42j != null) {
            super.setPadding((getMeasuredWidth() - this.f42j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        l0 l0Var;
        if (!this.f40h.hasSubMenu() || (l0Var = this.f44l) == null || !l0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.o != z) {
            this.o = z;
            i iVar = this.f40h;
            if (iVar != null) {
                iVar.n.p();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f42j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.r;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i2) / ((float) intrinsicHeight)));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        f();
    }

    public void setItemInvoker(g.b bVar) {
        this.f43k = bVar;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.q = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.m = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f41i = charSequence;
        f();
    }
}
