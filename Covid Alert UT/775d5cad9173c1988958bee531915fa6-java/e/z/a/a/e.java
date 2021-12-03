package e.z.a.a;

import android.animation.TypeEvaluator;
import f.a.a.a.a;

public class e implements TypeEvaluator {
    public static final e a = new e();

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f2, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f3 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
        float a2 = a.a(((float) ((intValue2 >> 24) & 255)) / 255.0f, f3, f2, f3);
        float a3 = a.a(pow4, pow, f2, pow);
        float a4 = a.a((float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d), pow2, f2, pow2);
        float a5 = a.a((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d), pow3, f2, pow3);
        int round = Math.round(((float) Math.pow((double) a3, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow((double) a5, 0.45454545454545453d)) * 255.0f) | round | (Math.round(a2 * 255.0f) << 24) | (Math.round(((float) Math.pow((double) a4, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
