package b.b.k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import b.b.j;
import b.b.p.a;

public abstract class a {

    /* renamed from: b.b.k.a$a  reason: collision with other inner class name */
    public static class C0005a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f359a;

        public C0005a(int i, int i2) {
            super(i, i2);
            this.f359a = 0;
            this.f359a = 8388627;
        }

        public C0005a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f359a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
            this.f359a = obtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0005a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f359a = 0;
        }

        public C0005a(C0005a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f359a = 0;
            this.f359a = aVar.f359a;
        }
    }

    public interface b {
        void a(boolean z);
    }

    @Deprecated
    public static abstract class c {
        public abstract void a();
    }

    public boolean a() {
        return false;
    }

    public abstract boolean b();

    public abstract void c(boolean z);

    public abstract int d();

    public abstract Context e();

    public boolean f() {
        return false;
    }

    public abstract void g(Configuration configuration);

    public void h() {
    }

    public abstract boolean i(int i, KeyEvent keyEvent);

    public boolean j(KeyEvent keyEvent) {
        return false;
    }

    public boolean k() {
        return false;
    }

    public abstract void l(boolean z);

    public abstract void m(boolean z);

    public abstract void n(CharSequence charSequence);

    public b.b.p.a o(a.AbstractC0009a aVar) {
        return null;
    }
}
