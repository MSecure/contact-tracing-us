package d.a.a.a.h;

import android.widget.Button;
import b.n.q;

/* compiled from: lambda */
public final /* synthetic */ class a implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Button f4707a;

    public /* synthetic */ a(Button button) {
        this.f4707a = button;
    }

    @Override // b.n.q
    public final void a(Object obj) {
        Boolean bool = (Boolean) obj;
        this.f4707a.setEnabled(!bool.booleanValue());
    }
}
