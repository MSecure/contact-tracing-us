package d.a.a.a.d;

import android.widget.Button;
import b.n.q;

/* compiled from: lambda */
public final /* synthetic */ class h implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Button f4614a;

    public /* synthetic */ h(Button button) {
        this.f4614a = button;
    }

    @Override // b.n.q
    public final void a(Object obj) {
        Boolean bool = (Boolean) obj;
        this.f4614a.setEnabled(!bool.booleanValue());
    }
}
