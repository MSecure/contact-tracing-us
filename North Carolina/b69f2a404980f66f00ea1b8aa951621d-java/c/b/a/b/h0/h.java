package c.b.a.b.h0;

import android.graphics.RectF;
import java.util.Arrays;

public final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final float f2992a;

    public h(float f) {
        this.f2992a = f;
    }

    @Override // c.b.a.b.h0.c
    public float a(RectF rectF) {
        return rectF.height() * this.f2992a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f2992a == ((h) obj).f2992a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f2992a)});
    }
}
