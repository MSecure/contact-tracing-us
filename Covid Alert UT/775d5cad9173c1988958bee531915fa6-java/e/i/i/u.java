package e.i.i;

import android.view.View;
import e.i.i.v;

public class u extends v.b<Boolean> {
    public u(int i2, Class cls, int i3) {
        super(i2, cls, i3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.i.i.v.b
    public Boolean b(View view) {
        return Boolean.valueOf(v.l.c(view));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // e.i.i.v.b
    public void c(View view, Boolean bool) {
        v.l.g(view, bool.booleanValue());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // e.i.i.v.b
    public boolean f(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }
}
