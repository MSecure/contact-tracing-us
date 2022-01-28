package b.b.k;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import b.b.p.a;
import b.i.l.d;

public class o extends Dialog implements g {

    /* renamed from: b  reason: collision with root package name */
    public h f558b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a f559c;

    public class a implements d.a {
        public a() {
        }

        @Override // b.i.l.d.a
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return o.this.b(keyEvent);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public o(Context context, int i) {
        super(context, r1);
        int i2;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(b.b.a.dialogTheme, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = i;
        }
        this.f559c = new a();
        h a2 = a();
        if (i == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(b.b.a.dialogTheme, typedValue2, true);
            i = typedValue2.resourceId;
        }
        ((i) a2).O = i;
        a2.h(null);
    }

    public h a() {
        if (this.f558b == null) {
            this.f558b = h.e(this, this);
        }
        return this.f558b;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().c(view, layoutParams);
    }

    public boolean b(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean c(int i) {
        return a().k(i);
    }

    public void dismiss() {
        super.dismiss();
        a().i();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d.a(this.f559c, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        i iVar = (i) a();
        iVar.A();
        return (T) iVar.f521f.findViewById(i);
    }

    public void invalidateOptionsMenu() {
        a().g();
    }

    public void onCreate(Bundle bundle) {
        a().f();
        super.onCreate(bundle);
        a().h(bundle);
    }

    public void onStop() {
        super.onStop();
        i iVar = (i) a();
        iVar.L = false;
        iVar.G();
        a aVar = iVar.i;
        if (aVar != null) {
            aVar.m(false);
        }
    }

    @Override // b.b.k.g
    public void onSupportActionModeFinished(b.b.p.a aVar) {
    }

    @Override // b.b.k.g
    public void onSupportActionModeStarted(b.b.p.a aVar) {
    }

    @Override // b.b.k.g
    public b.b.p.a onWindowStartingSupportActionMode(a.AbstractC0012a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().l(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().m(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().n(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().o(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().o(charSequence);
    }
}
