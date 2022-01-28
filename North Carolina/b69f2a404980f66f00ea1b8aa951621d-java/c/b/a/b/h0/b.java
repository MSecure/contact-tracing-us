package c.b.a.b.h0;

import android.graphics.RectF;
import java.util.Arrays;

public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c f2979a;

    /* renamed from: b  reason: collision with root package name */
    public final float f2980b;

    public b(float f, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f2979a;
            f += ((b) cVar).f2980b;
        }
        this.f2979a = cVar;
        this.f2980b = f;
    }

    @Override // c.b.a.b.h0.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f2979a.a(rectF) + this.f2980b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2979a.equals(bVar.f2979a) && this.f2980b == bVar.f2980b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2979a, Float.valueOf(this.f2980b)});
    }
}
