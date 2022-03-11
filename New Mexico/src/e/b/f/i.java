package e.b.f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import e.b.a.m;
/* loaded from: classes.dex */
public class i {
    public final CheckedTextView a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f963d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f964e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f965f;

    public i(CheckedTextView checkedTextView) {
        this.a = checkedTextView;
    }

    public void a() {
        Drawable checkMarkDrawable = this.a.getCheckMarkDrawable();
        if (checkMarkDrawable == null) {
            return;
        }
        if (this.f963d || this.f964e) {
            Drawable mutate = m.e.X1(checkMarkDrawable).mutate();
            if (this.f963d) {
                mutate.setTintList(this.b);
            }
            if (this.f964e) {
                mutate.setTintMode(this.c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.a.getDrawableState());
            }
            this.a.setCheckMarkDrawable(mutate);
        }
    }
}
