package e.n.b;

import android.text.Editable;
import e.n.a.l;
/* loaded from: classes.dex */
public final class b extends Editable.Factory {
    public static final Object a = new Object();
    public static volatile Editable.Factory b;
    public static Class<?> c;

    public b() {
        try {
            c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, getClass().getClassLoader());
        } catch (Throwable unused) {
        }
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = c;
        if (cls != null) {
            return new l(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
