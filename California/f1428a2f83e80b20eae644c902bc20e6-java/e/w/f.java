package e.w;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

public class f implements TypeEvaluator<Rect> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        Rect rect3 = rect;
        Rect rect4 = rect2;
        int i2 = rect3.left;
        int i3 = i2 + ((int) (((float) (rect4.left - i2)) * f2));
        int i4 = rect3.top;
        int i5 = i4 + ((int) (((float) (rect4.top - i4)) * f2));
        int i6 = rect3.right;
        int i7 = rect3.bottom;
        return new Rect(i3, i5, i6 + ((int) (((float) (rect4.right - i6)) * f2)), i7 + ((int) (((float) (rect4.bottom - i7)) * f2)));
    }
}
