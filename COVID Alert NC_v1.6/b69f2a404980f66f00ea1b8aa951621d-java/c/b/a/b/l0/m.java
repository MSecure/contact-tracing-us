package c.b.a.b.l0;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public TextInputLayout f3087a;

    /* renamed from: b  reason: collision with root package name */
    public Context f3088b;

    /* renamed from: c  reason: collision with root package name */
    public CheckableImageButton f3089c;

    public m(TextInputLayout textInputLayout) {
        this.f3087a = textInputLayout;
        this.f3088b = textInputLayout.getContext();
        this.f3089c = textInputLayout.getEndIconView();
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
