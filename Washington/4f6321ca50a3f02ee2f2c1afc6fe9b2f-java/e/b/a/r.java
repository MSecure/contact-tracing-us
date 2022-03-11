package e.b.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import e.b.e.a;
import e.e.c;
import e.i.i.d;
import java.lang.ref.WeakReference;

public class r extends Dialog implements k {
    public l b;
    public final d.a c;

    public class a implements d.a {
        public a() {
        }

        @Override // e.i.i.d.a
        public boolean f(KeyEvent keyEvent) {
            return r.this.b(keyEvent);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public r(Context context, int i2) {
        super(context, r1);
        int i3;
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
            i3 = typedValue.resourceId;
        } else {
            i3 = i2;
        }
        this.c = new a();
        l a2 = a();
        if (i2 == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue2, true);
            i2 = typedValue2.resourceId;
        }
        a2.y(i2);
        a2.l(null);
    }

    public l a() {
        if (this.b == null) {
            c<WeakReference<l>> cVar = l.b;
            this.b = new m(getContext(), getWindow(), this, this);
        }
        return this.b;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().c(view, layoutParams);
    }

    public boolean b(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void dismiss() {
        super.dismiss();
        a().m();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d.b(this.c, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        return (T) a().e(i2);
    }

    @Override // e.b.a.k
    public void g(e.b.e.a aVar) {
    }

    @Override // e.b.a.k
    public void i(e.b.e.a aVar) {
    }

    public void invalidateOptionsMenu() {
        a().j();
    }

    @Override // e.b.a.k
    public e.b.e.a j(a.AbstractC0014a aVar) {
        return null;
    }

    public void onCreate(Bundle bundle) {
        a().i();
        super.onCreate(bundle);
        a().l(bundle);
    }

    public void onStop() {
        super.onStop();
        a().r();
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        a().u(i2);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().v(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().w(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        a().z(getContext().getString(i2));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().z(charSequence);
    }
}
