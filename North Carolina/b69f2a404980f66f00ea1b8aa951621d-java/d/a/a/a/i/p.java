package d.a.a.a.i;

import android.widget.Button;
import b.n.q;

/* compiled from: lambda */
public final /* synthetic */ class p implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Button f4775a;

    public /* synthetic */ p(Button button) {
        this.f4775a = button;
    }

    @Override // b.n.q
    public final void a(Object obj) {
        Boolean bool = (Boolean) obj;
        this.f4775a.setEnabled(!bool.booleanValue());
    }
}
