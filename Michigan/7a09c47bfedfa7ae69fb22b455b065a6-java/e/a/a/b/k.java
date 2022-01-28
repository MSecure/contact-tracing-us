package e.a.a.b;

import android.widget.Button;
import b.o.q;

/* compiled from: lambda */
public final /* synthetic */ class k implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Button f6231a;

    public /* synthetic */ k(Button button) {
        this.f6231a = button;
    }

    @Override // b.o.q
    public final void a(Object obj) {
        Boolean bool = (Boolean) obj;
        this.f6231a.setEnabled(!bool.booleanValue());
    }
}
