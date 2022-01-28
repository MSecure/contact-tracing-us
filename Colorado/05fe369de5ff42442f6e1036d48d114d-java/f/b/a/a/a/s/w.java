package f.b.a.a.a.s;

import android.widget.ViewSwitcher;
import e.p.t;

public final /* synthetic */ class w implements t {
    public final /* synthetic */ ViewSwitcher a;

    public /* synthetic */ w(ViewSwitcher viewSwitcher) {
        this.a = viewSwitcher;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        ViewSwitcher viewSwitcher = this.a;
        Integer num = (Integer) obj;
        int i2 = v5.k0;
        if (num.intValue() > -1) {
            viewSwitcher.setDisplayedChild(num.intValue());
        }
    }
}
