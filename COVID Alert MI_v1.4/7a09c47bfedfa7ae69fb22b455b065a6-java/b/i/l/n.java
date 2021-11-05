package b.i.l;

import android.view.View;
import b.i.l.m;

public class n extends m.b<Boolean> {
    public n(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // b.i.l.m.b
    public Boolean b(View view) {
        return Boolean.valueOf(view.isScreenReaderFocusable());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // b.i.l.m.b
    public void c(View view, Boolean bool) {
        view.setScreenReaderFocusable(bool.booleanValue());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // b.i.l.m.b
    public boolean e(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }
}
