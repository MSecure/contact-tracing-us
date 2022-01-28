package b.i.l;

import android.text.TextUtils;
import android.view.View;
import b.i.l.m;

public class o extends m.b<CharSequence> {
    public o(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // b.i.l.m.b
    public CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // b.i.l.m.b
    public void c(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // b.i.l.m.b
    public boolean e(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
