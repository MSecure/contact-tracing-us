package c.b.a.b.h0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import c.b.a.b.g0.a;
import c.b.a.b.h0.m;
import java.util.List;

public class l extends m.f {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f3009b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Matrix f3010c;

    public l(m mVar, List list, Matrix matrix) {
        this.f3009b = list;
        this.f3010c = matrix;
    }

    @Override // c.b.a.b.h0.m.f
    public void a(Matrix matrix, a aVar, int i, Canvas canvas) {
        for (m.f fVar : this.f3009b) {
            fVar.a(this.f3010c, aVar, i, canvas);
        }
    }
}
