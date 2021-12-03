package e.i.i;

import android.view.View;
import e.i.i.v;

public class r extends v.b<Boolean> {
    public r(int i2, Class cls, int i3) {
        super(i2, cls, i3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.i.i.v.b
    public Boolean b(View view) {
        return Boolean.valueOf(v.l.d(view));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // e.i.i.v.b
    public void c(View view, Boolean bool) {
        v.l.i(view, bool.booleanValue());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // e.i.i.v.b
    public boolean f(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }
}
