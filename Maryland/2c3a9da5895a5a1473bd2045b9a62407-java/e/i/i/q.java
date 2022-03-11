package e.i.i;

import android.view.View;
import e.i.i.m;

public class q extends m.b<Boolean> {
    public q(int i2, Class cls, int i3) {
        super(i2, cls, i3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.i.i.m.b
    public Boolean b(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }

    public void d(View view, Object obj) {
        view.setAccessibilityHeading(((Boolean) obj).booleanValue());
    }

    public boolean e(Object obj, Object obj2) {
        return !a((Boolean) obj, (Boolean) obj2);
    }
}
