package b.b.q;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import b.b.j;
import b.b.l.a.a;
import b.i.l.m;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final CompoundButton f853a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f854b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f855c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f856d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f857e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f858f;

    public i(CompoundButton compoundButton) {
        this.f853a = compoundButton;
    }

    public void a() {
        Drawable buttonDrawable = this.f853a.getButtonDrawable();
        if (buttonDrawable == null) {
            return;
        }
        if (this.f856d || this.f857e) {
            Drawable mutate = buttonDrawable.mutate();
            if (this.f856d) {
                mutate.setTintList(this.f854b);
            }
            if (this.f857e) {
                mutate.setTintMode(this.f855c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f853a.getDrawableState());
            }
            this.f853a.setButtonDrawable(mutate);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007e  */
    public void b(AttributeSet attributeSet, int i) {
        boolean z;
        int l;
        int l2;
        y0 q = y0.q(this.f853a.getContext(), attributeSet, j.CompoundButton, i, 0);
        CompoundButton compoundButton = this.f853a;
        m.T(compoundButton, compoundButton.getContext(), j.CompoundButton, attributeSet, q.f986b, i, 0);
        try {
            if (q.o(j.CompoundButton_buttonCompat) && (l2 = q.l(j.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    this.f853a.setButtonDrawable(a.b(this.f853a.getContext(), l2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z && q.o(j.CompoundButton_android_button) && (l = q.l(j.CompoundButton_android_button, 0)) != 0) {
                    this.f853a.setButtonDrawable(a.b(this.f853a.getContext(), l));
                }
                if (q.o(j.CompoundButton_buttonTint)) {
                    this.f853a.setButtonTintList(q.c(j.CompoundButton_buttonTint));
                }
                if (q.o(j.CompoundButton_buttonTintMode)) {
                    this.f853a.setButtonTintMode(e0.d(q.j(j.CompoundButton_buttonTintMode, -1), null));
                }
            }
            z = false;
            this.f853a.setButtonDrawable(a.b(this.f853a.getContext(), l));
            if (q.o(j.CompoundButton_buttonTint)) {
            }
            if (q.o(j.CompoundButton_buttonTintMode)) {
            }
        } finally {
            q.f986b.recycle();
        }
    }
}
