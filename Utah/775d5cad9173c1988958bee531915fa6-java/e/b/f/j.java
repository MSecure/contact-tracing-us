package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import e.b.a.m;
import e.i.i.v;

public class j {
    public final CompoundButton a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f905d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f906e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f907f;

    public j(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    public void a() {
        Drawable e0 = m.e.e0(this.a);
        if (e0 == null) {
            return;
        }
        if (this.f905d || this.f906e) {
            Drawable mutate = m.e.P1(e0).mutate();
            if (this.f905d) {
                mutate.setTintList(this.b);
            }
            if (this.f906e) {
                mutate.setTintMode(this.c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.a.getDrawableState());
            }
            this.a.setButtonDrawable(mutate);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    public void b(AttributeSet attributeSet, int i2) {
        boolean z;
        int i3;
        int i4;
        int l2;
        int l3;
        Context context = this.a.getContext();
        int[] iArr = R$styleable.CompoundButton;
        c1 q = c1.q(context, attributeSet, iArr, i2, 0);
        CompoundButton compoundButton = this.a;
        v.t(compoundButton, compoundButton.getContext(), iArr, attributeSet, q.b, i2, 0);
        try {
            int i5 = R$styleable.CompoundButton_buttonCompat;
            if (q.o(i5) && (l3 = q.l(i5, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.a;
                    compoundButton2.setButtonDrawable(m.e.h0(compoundButton2.getContext(), l3));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z) {
                    int i6 = R$styleable.CompoundButton_android_button;
                    if (q.o(i6) && (l2 = q.l(i6, 0)) != 0) {
                        CompoundButton compoundButton3 = this.a;
                        compoundButton3.setButtonDrawable(m.e.h0(compoundButton3.getContext(), l2));
                    }
                }
                i3 = R$styleable.CompoundButton_buttonTint;
                if (q.o(i3)) {
                    this.a.setButtonTintList(q.c(i3));
                }
                i4 = R$styleable.CompoundButton_buttonTintMode;
                if (q.o(i4)) {
                    this.a.setButtonTintMode(i0.e(q.j(i4, -1), null));
                }
            }
            z = false;
            if (!z) {
            }
            i3 = R$styleable.CompoundButton_buttonTint;
            if (q.o(i3)) {
            }
            i4 = R$styleable.CompoundButton_buttonTintMode;
            if (q.o(i4)) {
            }
        } finally {
            q.b.recycle();
        }
    }
}
