package f.b.a.d.v;

import android.graphics.RectF;
import java.util.Arrays;

public final class a implements c {
    public final float a;

    public a(float f2) {
        this.a = f2;
    }

    @Override // f.b.a.d.v.c
    public float a(RectF rectF) {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.a == ((a) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
