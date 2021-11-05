package b.g.b;

import android.content.Context;
import android.util.AttributeSet;

public class a extends b {
    public int h;
    public int i;
    public b.g.a.h.a j;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // b.g.b.b
    public void b(AttributeSet attributeSet) {
        super.b(null);
        b.g.a.h.a aVar = new b.g.a.h.a();
        this.j = aVar;
        this.f944e = aVar;
        f();
    }

    public int getType() {
        return this.h;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.j.n0 = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r5 == 6) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r5 == 6) goto L_0x0029;
     */
    public void setType(int i2) {
        this.h = i2;
        this.i = i2;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
            int i3 = this.h;
            if (i3 != 5) {
            }
        } else {
            int i4 = this.h;
            if (i4 != 5) {
            }
            this.i = 0;
            this.j.l0 = this.i;
        }
        this.i = 1;
        this.j.l0 = this.i;
    }
}
