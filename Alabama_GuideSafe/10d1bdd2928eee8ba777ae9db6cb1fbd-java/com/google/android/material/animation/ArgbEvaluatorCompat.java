package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import com.android.tools.r8.GeneratedOutlineSupport;

public class ArgbEvaluatorCompat implements TypeEvaluator<Integer> {
    public static final ArgbEvaluatorCompat instance = new ArgbEvaluatorCompat();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f2 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
        float outline0 = GeneratedOutlineSupport.outline0(((float) ((intValue2 >> 24) & 255)) / 255.0f, f2, f, f2);
        float outline02 = GeneratedOutlineSupport.outline0(pow4, pow, f, pow);
        float outline03 = GeneratedOutlineSupport.outline0((float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d), pow2, f, pow2);
        float outline04 = GeneratedOutlineSupport.outline0((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d), pow3, f, pow3);
        int round = Math.round(((float) Math.pow((double) outline02, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow((double) outline04, 0.45454545454545453d)) * 255.0f) | round | (Math.round(outline0 * 255.0f) << 24) | (Math.round(((float) Math.pow((double) outline03, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
