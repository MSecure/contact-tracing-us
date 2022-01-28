package c.b.a.b.h0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import c.b.a.b.g0.a;
import c.b.a.b.h0.m;
import java.util.List;

public class l extends m.f {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f4298b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Matrix f4299c;

    public l(m mVar, List list, Matrix matrix) {
        this.f4298b = list;
        this.f4299c = matrix;
    }

    @Override // c.b.a.b.h0.m.f
    public void a(Matrix matrix, a aVar, int i, Canvas canvas) {
        for (m.f fVar : this.f4298b) {
            fVar.a(this.f4299c, aVar, i, canvas);
        }
    }
}
