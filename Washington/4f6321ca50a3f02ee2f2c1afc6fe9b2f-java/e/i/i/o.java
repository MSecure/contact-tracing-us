package e.i.i;

import android.view.View;
import e.i.i.l;

public class o extends l.b<CharSequence> {
    public o(int i2, Class cls, int i3, int i4) {
        super(i2, cls, i3, i4);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.i.i.l.b
    public CharSequence b(View view) {
        return view.getStateDescription();
    }
}
