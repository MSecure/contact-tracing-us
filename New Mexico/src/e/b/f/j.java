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
import e.j.j.v;
/* loaded from: classes.dex */
public class j {
    public final CompoundButton a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f969d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f970e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f971f;

    public j(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    public void a() {
        Drawable f0 = m.e.f0(this.a);
        if (f0 == null) {
            return;
        }
        if (this.f969d || this.f970e) {
            Drawable mutate = m.e.X1(f0).mutate();
            if (this.f969d) {
                mutate.setTintList(this.b);
            }
            if (this.f970e) {
                mutate.setTintMode(this.c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.a.getDrawableState());
            }
            this.a.setButtonDrawable(mutate);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b A[Catch: all -> 0x0068, TRY_ENTER, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x001b, B:5:0x0023, B:7:0x0029, B:11:0x003b, B:13:0x0043, B:15:0x0049, B:16:0x0056, B:18:0x005e, B:21:0x006a, B:23:0x0072), top: B:31:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[Catch: all -> 0x0068, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x001b, B:5:0x0023, B:7:0x0029, B:11:0x003b, B:13:0x0043, B:15:0x0049, B:16:0x0056, B:18:0x005e, B:21:0x006a, B:23:0x0072), top: B:31:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072 A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x001b, B:5:0x0023, B:7:0x0029, B:11:0x003b, B:13:0x0043, B:15:0x0049, B:16:0x0056, B:18:0x005e, B:21:0x006a, B:23:0x0072), top: B:31:0x001b }] */
    /* Code decompiled incorrectly, please refer to instructions dump */
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
                    compoundButton2.setButtonDrawable(m.e.i0(compoundButton2.getContext(), l3));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z) {
                    int i6 = R$styleable.CompoundButton_android_button;
                    if (q.o(i6) && (l2 = q.l(i6, 0)) != 0) {
                        CompoundButton compoundButton3 = this.a;
                        compoundButton3.setButtonDrawable(m.e.i0(compoundButton3.getContext(), l2));
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
                q.b.recycle();
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
            q.b.recycle();
        } catch (Throwable th) {
            q.b.recycle();
            throw th;
        }
    }
}
