package e.b.f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import e.b.a.m;

public class i {
    public final CheckedTextView a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f899d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f900e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f901f;

    public i(CheckedTextView checkedTextView) {
        this.a = checkedTextView;
    }

    public void a() {
        Drawable checkMarkDrawable = this.a.getCheckMarkDrawable();
        if (checkMarkDrawable == null) {
            return;
        }
        if (this.f899d || this.f900e) {
            Drawable mutate = m.e.P1(checkMarkDrawable).mutate();
            if (this.f899d) {
                mutate.setTintList(this.b);
            }
            if (this.f900e) {
                mutate.setTintMode(this.c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.a.getDrawableState());
            }
            this.a.setCheckMarkDrawable(mutate);
        }
    }
}
