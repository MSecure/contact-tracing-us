package g.b.a.c.c;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import e.m.a.m;
import java.util.Objects;

public final class g extends ContextWrapper {
    public LayoutInflater a;
    public LayoutInflater b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, m mVar) {
        super(context);
        Objects.requireNonNull(context);
        this.a = null;
        Objects.requireNonNull(mVar);
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.b == null) {
            if (this.a == null) {
                this.a = (LayoutInflater) getBaseContext().getSystemService("layout_inflater");
            }
            this.b = this.a.cloneInContext(this);
        }
        return this.b;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public g(LayoutInflater layoutInflater, m mVar) {
        super(r0);
        Objects.requireNonNull(layoutInflater);
        Context context = layoutInflater.getContext();
        Objects.requireNonNull(context);
        this.a = layoutInflater;
        Objects.requireNonNull(mVar);
    }
}
