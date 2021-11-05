package d.a.a.a.i;

import android.widget.Button;
import b.n.q;

/* compiled from: lambda */
public final /* synthetic */ class t implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Button f4779a;

    public /* synthetic */ t(Button button) {
        this.f4779a = button;
    }

    @Override // b.n.q
    public final void a(Object obj) {
        Boolean bool = (Boolean) obj;
        this.f4779a.setEnabled(!bool.booleanValue());
    }
}
