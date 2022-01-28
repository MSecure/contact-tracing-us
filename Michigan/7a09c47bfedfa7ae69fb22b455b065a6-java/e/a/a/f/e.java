package e.a.a.f;

import android.widget.Button;
import b.o.q;

/* compiled from: lambda */
public final /* synthetic */ class e implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Button f6329a;

    public /* synthetic */ e(Button button) {
        this.f6329a = button;
    }

    @Override // b.o.q
    public final void a(Object obj) {
        Boolean bool = (Boolean) obj;
        this.f6329a.setEnabled(!bool.booleanValue());
    }
}
