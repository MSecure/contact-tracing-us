package f.b.a.e.v;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class h implements c {
    public final float a;

    public h(float f2) {
        this.a = f2;
    }

    @Override // f.b.a.e.v.c
    public float a(RectF rectF) {
        return rectF.height() * this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.a == ((h) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
