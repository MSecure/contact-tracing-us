package c.b.a.b.l0;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public TextInputLayout f4384a;

    /* renamed from: b  reason: collision with root package name */
    public Context f4385b;

    /* renamed from: c  reason: collision with root package name */
    public CheckableImageButton f4386c;

    public m(TextInputLayout textInputLayout) {
        this.f4384a = textInputLayout;
        this.f4385b = textInputLayout.getContext();
        this.f4386c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int i) {
        return true;
    }

    public void c(boolean z) {
    }

    public boolean d() {
        return false;
    }
}
