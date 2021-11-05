package b.b.q;

import android.content.Context;
import android.content.ContextWrapper;

public class v0 extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f949a = new Object();

    public static Context a(Context context) {
        if (!(context instanceof v0) && !(context.getResources() instanceof x0) && !(context.getResources() instanceof d1)) {
            d1.a();
        }
        return context;
    }
}
