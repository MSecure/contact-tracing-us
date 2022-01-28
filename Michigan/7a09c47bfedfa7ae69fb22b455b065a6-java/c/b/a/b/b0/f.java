package c.b.a.b.b0;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

public class f implements TypeEvaluator<Float> {

    /* renamed from: a  reason: collision with root package name */
    public FloatEvaluator f4185a = new FloatEvaluator();

    public f(e eVar) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f2, Float f3, Float f4) {
        float floatValue = this.f4185a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
        if (floatValue < 0.1f) {
            floatValue = 0.0f;
        }
        return Float.valueOf(floatValue);
    }
}
