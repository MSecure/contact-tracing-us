package b.w.a.a;

import android.animation.TypeEvaluator;
import b.b.k.i;

public class c implements TypeEvaluator<b.i.f.c[]> {

    /* renamed from: a  reason: collision with root package name */
    public b.i.f.c[] f1852a;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public b.i.f.c[] evaluate(float f, b.i.f.c[] cVarArr, b.i.f.c[] cVarArr2) {
        b.i.f.c[] cVarArr3 = cVarArr;
        b.i.f.c[] cVarArr4 = cVarArr2;
        if (i.j.h(cVarArr3, cVarArr4)) {
            if (!i.j.h(this.f1852a, cVarArr3)) {
                this.f1852a = i.j.U(cVarArr3);
            }
            for (int i = 0; i < cVarArr3.length; i++) {
                b.i.f.c cVar = this.f1852a[i];
                b.i.f.c cVar2 = cVarArr3[i];
                b.i.f.c cVar3 = cVarArr4[i];
                if (cVar != null) {
                    cVar.f1052a = cVar2.f1052a;
                    int i2 = 0;
                    while (true) {
                        float[] fArr = cVar2.f1053b;
                        if (i2 >= fArr.length) {
                            break;
                        }
                        cVar.f1053b[i2] = (cVar3.f1053b[i2] * f) + ((1.0f - f) * fArr[i2]);
                        i2++;
                    }
                } else {
                    throw null;
                }
            }
            return this.f1852a;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}
