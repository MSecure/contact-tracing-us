package c.b.a.b.h0;

import android.graphics.RectF;
import java.util.Arrays;

public final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final float f4275a;

    public h(float f2) {
        this.f4275a = f2;
    }

    @Override // c.b.a.b.h0.c
    public float a(RectF rectF) {
        return rectF.height() * this.f4275a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f4275a == ((h) obj).f4275a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4275a)});
    }
}
