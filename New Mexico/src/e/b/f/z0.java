package e.b.f;

import android.content.Context;
import android.content.ContextWrapper;
/* loaded from: classes.dex */
public class z0 extends ContextWrapper {
    public static final Object a = new Object();

    public static Context a(Context context) {
        if (!(context instanceof z0) && !(context.getResources() instanceof b1)) {
            context.getResources();
            int i2 = h1.a;
        }
        return context;
    }
}
