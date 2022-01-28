package e.i.i;

import android.text.TextUtils;
import android.view.View;
import e.i.i.v;

public class t extends v.b<CharSequence> {
    public t(int i2, Class cls, int i3, int i4) {
        super(i2, cls, i3, i4);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.i.i.v.b
    public CharSequence b(View view) {
        return v.n.a(view);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // e.i.i.v.b
    public void c(View view, CharSequence charSequence) {
        v.n.b(view, charSequence);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // e.i.i.v.b
    public boolean f(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
