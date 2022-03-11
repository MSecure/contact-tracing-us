package g.a.a.c.c;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import e.m.a.l;
import java.util.Objects;

public final class f extends ContextWrapper {
    public LayoutInflater a;
    public LayoutInflater b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context, l lVar) {
        super(context);
        Objects.requireNonNull(context);
        this.a = null;
        Objects.requireNonNull(lVar);
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
    public f(LayoutInflater layoutInflater, l lVar) {
        super(r0);
        Objects.requireNonNull(layoutInflater);
        Context context = layoutInflater.getContext();
        Objects.requireNonNull(context);
        this.a = layoutInflater;
        Objects.requireNonNull(lVar);
    }
}
