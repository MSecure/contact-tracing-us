package e.i.i;

import android.view.View;
import e.i.i.m;

public class n extends m.b<Boolean> {
    public n(int i2, Class cls, int i3) {
        super(i2, cls, i3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.i.i.m.b
    public Boolean b(View view) {
        return Boolean.valueOf(view.isScreenReaderFocusable());
    }
}
