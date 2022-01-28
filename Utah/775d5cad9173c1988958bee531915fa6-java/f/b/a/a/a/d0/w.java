package f.b.a.a.a.d0;

import android.widget.ViewSwitcher;
import e.q.t;

public final /* synthetic */ class w implements t {
    public final /* synthetic */ ViewSwitcher a;

    public /* synthetic */ w(ViewSwitcher viewSwitcher) {
        this.a = viewSwitcher;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        ViewSwitcher viewSwitcher = this.a;
        Integer num = (Integer) obj;
        int i2 = u5.l0;
        if (num.intValue() > -1) {
            viewSwitcher.setDisplayedChild(num.intValue());
        }
    }
}
