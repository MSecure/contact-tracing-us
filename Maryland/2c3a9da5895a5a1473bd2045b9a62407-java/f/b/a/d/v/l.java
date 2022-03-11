package f.b.a.d.v;

import android.graphics.Canvas;
import android.graphics.Matrix;
import f.b.a.d.u.a;
import f.b.a.d.v.m;
import java.util.List;

public class l extends m.f {
    public final /* synthetic */ List b;
    public final /* synthetic */ Matrix c;

    public l(m mVar, List list, Matrix matrix) {
        this.b = list;
        this.c = matrix;
    }

    @Override // f.b.a.d.v.m.f
    public void a(Matrix matrix, a aVar, int i2, Canvas canvas) {
        for (m.f fVar : this.b) {
            fVar.a(this.c, aVar, i2, canvas);
        }
    }
}
