package c.b.a.b.h0;

import android.graphics.RectF;
import java.util.Arrays;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final float f4257a;

    public a(float f2) {
        this.f4257a = f2;
    }

    @Override // c.b.a.b.h0.c
    public float a(RectF rectF) {
        return this.f4257a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f4257a == ((a) obj).f4257a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4257a)});
    }
}
