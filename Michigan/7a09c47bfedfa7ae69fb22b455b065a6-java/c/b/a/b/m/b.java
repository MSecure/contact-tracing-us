package c.b.a.b.m;

import android.animation.TypeEvaluator;
import gov.michigan.MiCovidExposure.BuildConfig;

public class b implements TypeEvaluator<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final b f4415a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public Integer evaluate(float f2, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f3 = ((float) ((intValue >> 24) & BuildConfig.VERSION_CODE)) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & BuildConfig.VERSION_CODE)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & BuildConfig.VERSION_CODE)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & BuildConfig.VERSION_CODE)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & BuildConfig.VERSION_CODE)) / 255.0f), 2.2d);
        float pow5 = ((((float) Math.pow((double) (((float) (intValue2 & BuildConfig.VERSION_CODE)) / 255.0f), 2.2d)) - pow3) * f2) + pow3;
        return Integer.valueOf((Math.round(((float) Math.pow((double) (((pow4 - pow) * f2) + pow), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(((((((float) ((intValue2 >> 24) & BuildConfig.VERSION_CODE)) / 255.0f) - f3) * f2) + f3) * 255.0f) << 24) | (Math.round(((float) Math.pow((double) (((((float) Math.pow((double) (((float) ((intValue2 >> 8) & BuildConfig.VERSION_CODE)) / 255.0f), 2.2d)) - pow2) * f2) + pow2), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow((double) pow5, 0.45454545454545453d)) * 255.0f));
    }
}
