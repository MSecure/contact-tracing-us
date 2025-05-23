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
import e.b.f.h0;
import e.b.f.z;

public class ActionMenuItemView extends z implements n.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: g  reason: collision with root package name */
    public i f36g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f37h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f38i;

    /* renamed from: j  reason: collision with root package name */
    public g.b f39j;

    /* renamed from: k  reason: collision with root package name */
    public h0 f40k;

    /* renamed from: l  reason: collision with root package name */
    public b f41l;
    public boolean m = e();
    public boolean n;
    public int o;
    public int p;
    public int q;

    public class a extends h0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // e.b.f.h0
        public p b() {
            c.a aVar;
            b bVar = ActionMenuItemView.this.f41l;
            if (bVar == null || (aVar = c.this.v) == null) {
                return null;
            }
            return aVar.a();
        }

        @Override // e.b.f.h0
        public boolean c() {
            p b;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f39j;
            return bVar != null && bVar.a(actionMenuItemView.f36g) && (b = b()) != null && b.c();
        }
    }

    public static abstract class b {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, 0, 0);
        this.o = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.p = -1;
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return c();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return c() && this.f36g.getIcon() == null;
    }

    public boolean c() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // e.b.e.i.n.a
    public void d(i iVar, int i2) {
        this.f36g = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitleCondensed());
        setId(iVar.a);
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f40k == null) {
            this.f40k = new a();
        }
    }

    public final boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void f() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f37h);
        if (this.f38i != null) {
            if (!((this.f36g.y & 4) == 4) || (!this.m && !this.n)) {
                z = false;
            }
        }
        boolean z3 = z2 & z;
        CharSequence charSequence = null;
        setText(z3 ? this.f37h : null);
        CharSequence charSequence2 = this.f36g.q;
        if (TextUtils.isEmpty(charSequence2)) {
            if (z3) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f36g.f801e;
            }
        }
        setContentDescription(charSequence2);
        CharSequence charSequence3 = this.f36g.r;
        if (TextUtils.isEmpty(charSequence3)) {
            if (!z3) {
                charSequence = this.f36g.f801e;
            }
            m.h.h1(this, charSequence);
            return;
        }
        m.h.h1(this, charSequence3);
    }

    @Override // e.b.e.i.n.a
    public i getItemData() {
        return this.f36g;
    }

    public void onClick(View view) {
        g.b bVar = this.f39j;
        if (bVar != null) {
            bVar.a(this.f36g);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.m = e();
        f();
    }

    @Override // e.b.f.z
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean c = c();
        if (c && (i4 = this.p) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.o) : this.o;
        if (mode != 1073741824 && this.o > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i3);
        }
        if (!c && this.f38i != null) {
            super.setPadding((getMeasuredWidth() - this.f38i.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var;
        if (!this.f36g.hasSubMenu() || (h0Var = this.f40k) == null || !h0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.n != z) {
            this.n = z;
            i iVar = this.f36g;
            if (iVar != null) {
                iVar.n.p();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f38i = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.q;
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
        this.f39j = bVar;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.p = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.f41l = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f37h = charSequence;
        f();
    }
}
