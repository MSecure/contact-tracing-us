package f.b.a.e.y;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

public abstract class m {
    public TextInputLayout a;
    public Context b;
    public CheckableImageButton c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3100d;

    public m(TextInputLayout textInputLayout, int i2) {
        this.a = textInputLayout;
        this.b = textInputLayout.getContext();
        this.c = textInputLayout.getEndIconView();
        this.f3100d = i2;
    }

    public abstract void a();

    public boolean b(int i2) {
        return true;
    }

    public void c(boolean z) {
    }

    public boolean d() {
        return false;
    }
}
