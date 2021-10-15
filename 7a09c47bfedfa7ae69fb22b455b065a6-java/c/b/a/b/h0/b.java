package c.b.a.b.h0;

import android.graphics.RectF;
import java.util.Arrays;

public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c f4258a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4259b;

    public b(float f2, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f4258a;
            f2 += ((b) cVar).f4259b;
        }
        this.f4258a = cVar;
        this.f4259b = f2;
    }

    @Override // c.b.a.b.h0.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f4258a.a(rectF) + this.f4259b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4258a.equals(bVar.f4258a) && this.f4259b == bVar.f4259b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4258a, Float.valueOf(this.f4259b)});
    }
}
